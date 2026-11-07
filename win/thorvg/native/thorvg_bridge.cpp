/* thorvg_bridge.cpp —— 火山.ThorVG 原生桥接实现。
 *
 * 编译方式: 由火山工程经 @视窗.外部源文件 编译(不单独出 DLL),
 *   需要头文件搜寻目录 deps\thorvg\include 与 native,
 *   需要链接 deps\thorvg\lib\libthorvg-1.a(ThorVG 1.1.0 静态库, 含 CPU 光栅引擎、
 *   SVG/Lottie/PNG/JPG/WebP/TTF/OTF 加载器与 GIF 保存器)。
 */

#include "thorvg_bridge.hpp"

#include <thorvg.h>

#include <cmath>
#include <cstring>
#include <string>
#include <vector>

namespace {

/* 把 ThorVG 的 Result 转成 int, 0 表示成功。 */
inline int 转码(tvg::Result r)
{
    return (int)r;
}

/* 句柄统一转换: 火山侧只认 void*。 */
inline tvg::Paint* 取绘制(void* p) { return reinterpret_cast<tvg::Paint*>(p); }
inline tvg::Shape* 取形状(void* p) { return reinterpret_cast<tvg::Shape*>(p); }
inline tvg::Scene* 取场景(void* p) { return reinterpret_cast<tvg::Scene*>(p); }
inline tvg::Picture* 取图片(void* p) { return reinterpret_cast<tvg::Picture*>(p); }
inline tvg::Text* 取文本(void* p) { return reinterpret_cast<tvg::Text*>(p); }
inline tvg::Fill* 取填充(void* p) { return reinterpret_cast<tvg::Fill*>(p); }
inline tvg::Animation* 取动画(void* p) { return reinterpret_cast<tvg::Animation*>(p); }

/* 画布句柄: 把渲染目标(像素缓冲)与 ThorVG 画布绑在一起管理。 */
struct CanvasHandle
{
    tvg::SwCanvas* 画布 = nullptr;
    uint32_t* 缓冲 = nullptr;
    int 宽 = 0;
    int 高 = 0;
    int 色彩空间 = 1;
    size_t 字节数 = 0;
};

inline CanvasHandle* 取画布(void* p) { return reinterpret_cast<CanvasHandle*>(p); }

/* 色彩空间整数码 -> ThorVG 枚举。 */
inline tvg::ColorSpace 色彩空间(int code)
{
    switch (code) {
        case 0: return tvg::ColorSpace::ABGR8888;
        case 2: return tvg::ColorSpace::ABGR8888S;
        case 3: return tvg::ColorSpace::ARGB8888S;
        case 4: return tvg::ColorSpace::Grayscale8;
        default: return tvg::ColorSpace::ARGB8888;
    }
}

/* 计算像素缓冲字节数(灰度 1 字节/像素, 其余 4 字节/像素)。 */
inline size_t 缓冲字节数(int w, int h, int cs)
{
    if (w <= 0 || h <= 0) return 0;
    const size_t 像素数 = (size_t)w * (size_t)h;
    return (cs == 4) ? 像素数 : 像素数 * 4u;
}

/* 为画布分配像素缓冲并绑定渲染目标; 可重复调用(尺寸变化时重建)。 */
bool 绑定缓冲(CanvasHandle* c, int w, int h)
{
    if (!c || w <= 0 || h <= 0) return false;

    const size_t 新字节数 = 缓冲字节数(w, h, c->色彩空间);
    uint32_t* 新缓冲 = (uint32_t*)::malloc(新字节数);
    if (!新缓冲) return false;
    ::memset(新缓冲, 0, 新字节数);

    if (c->画布) {
        /* 尺寸或色彩空间变化时必须重新绑定 target。 */
        c->画布->target(新缓冲, (uint32_t)w, (uint32_t)w, (uint32_t)h, 色彩空间(c->色彩空间));
    }

    ::free(c->缓冲);
    c->缓冲 = 新缓冲;
    c->宽 = w;
    c->高 = h;
    c->字节数 = 新字节数;
    return true;
}

/* 全局引擎状态: 记录初始化次数, 便于重复初始化与顺序终止。 */
int 引擎引用计数 = 0;

/* 版本文本静态缓冲。 */
wchar_t 版本缓冲[256] = {0};

/* 错误码说明静态缓冲。 */
wchar_t 错误缓冲[256] = {0};

/* 角度转弧度。 */
inline float 弧度(float 度) { return 度 * 3.14159265358979323846f / 180.0f; }

/* 三次贝塞尔逼近一段圆弧(单段 <= 90 度)。 */
void 追加圆弧段(tvg::Shape* s, float cx, float cy, float r, float 起角, float 终角)
{
    const float 弧长 = 终角 - 起角;
    const float k = (4.0f / 3.0f) * std::tan(弧长 / 4.0f) * r;

    const float x0 = cx + r * std::cos(起角);
    const float y0 = cy + r * std::sin(起角);
    const float x1 = cx + r * std::cos(终角);
    const float y1 = cy + r * std::sin(终角);

    s->cubicTo(x0 - k * std::sin(起角), y0 + k * std::cos(起角),
               x1 + k * std::sin(终角), y1 - k * std::cos(终角),
               x1, y1);
}

} // namespace

extern "C" {

/* ==================== 引擎 ==================== */

const wchar_t* thorgw_version(void)
{
    uint32_t 主 = 0, 次 = 0, 修订 = 0;
    tvg::Initializer::version(&主, &次, &修订);
    ::swprintf(版本缓冲, 256, L"火山.ThorVG 1.0.0 (ThorVG %u.%u.%u)", 主, 次, 修订);
    return 版本缓冲;
}

int thorgw_init(int threads)
{
    if (引擎引用计数 > 0) {
        引擎引用计数++;
        return 0;
    }
    const int 结果 = 转码(tvg::Initializer::init(threads > 0 ? (uint32_t)threads : 0));
    if (结果 == 0) 引擎引用计数 = 1;
    return 结果;
}

void thorgw_term(void)
{
    if (引擎引用计数 <= 0) return;
    引擎引用计数--;
    if (引擎引用计数 == 0) tvg::Initializer::term();
}

const wchar_t* thorgw_result_text(int code)
{
    const wchar_t* 说明 = L"未知错误";
    switch (code) {
        case 0:   说明 = L"成功"; break;
        case 1:   说明 = L"参数无效(空路径或空指针)"; break;
        case 2:   说明 = L"条件不足(对象不存在或状态不允许)"; break;
        case 3:   说明 = L"内存分配失败"; break;
        case 4:   说明 = L"内存损坏(指针释放或类型转换失败)"; break;
        case 5:   说明 = L"引擎不支持该特性"; break;
        case -1:  说明 = L"句柄无效"; break;
        default:  说明 = L"未知错误"; break;
    }
    ::wcsncpy(错误缓冲, 说明, 255);
    错误缓冲[255] = 0;
    return 错误缓冲;
}

/* ==================== 画布 ==================== */

void* thorgw_canvas_new(int w, int h, int colorspace)
{
    if (w <= 0 || h <= 0) return nullptr;

    CanvasHandle* c = new (std::nothrow) CanvasHandle();
    if (!c) return nullptr;

    c->色彩空间 = colorspace;
    c->画布 = tvg::SwCanvas::gen(tvg::EngineOption::Default);
    if (!c->画布) {
        delete c;
        return nullptr;
    }
    if (!绑定缓冲(c, w, h)) {
        delete c->画布;
        delete c;
        return nullptr;
    }
    return c;
}

void thorgw_canvas_free(void* canvas)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c) return;
    if (c->画布) c->画布->sync();
    delete c->画布;
    ::free(c->缓冲);
    delete c;
}

void* thorgw_canvas_pixels(void* canvas)
{
    CanvasHandle* c = 取画布(canvas);
    return c ? (void*)c->缓冲 : nullptr;
}

int thorgw_canvas_pixel_bytes(void* canvas)
{
    CanvasHandle* c = 取画布(canvas);
    return c ? (int)c->字节数 : 0;
}

int thorgw_canvas_copy_pixels(void* canvas, void* out, int capacity)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->缓冲) return -1;
    const int 需要 = (int)c->字节数;
    if (!out || capacity < 需要) return -需要;
    ::memcpy(out, c->缓冲, c->字节数);
    return 需要;
}

int thorgw_canvas_make_bmp(void* canvas, void* out, int capacity)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->缓冲 || c->色彩空间 == 4) return -1;

    const int 行字节 = c->宽 * 4;
    const int 像素字节 = 行字节 * c->高;
    const int 需要 = 54 + 像素字节;
    if (!out || capacity < 需要) return -需要;

    unsigned char* p = (unsigned char*)out;
    ::memset(p, 0, 54);

    p[0] = 'B';
    p[1] = 'M';
    ::memcpy(p + 2, &需要, 4);            /* 文件总长度 */
    const int 像素偏移 = 54;
    ::memcpy(p + 10, &像素偏移, 4);        /* 像素数据偏移 */
    const int 信息头长 = 40;
    ::memcpy(p + 14, &信息头长, 4);        /* 信息头长度 */
    ::memcpy(p + 18, &c->宽, 4);
    ::memcpy(p + 22, &c->高, 4);
    const short 平面数 = 1;
    ::memcpy(p + 26, &平面数, 2);
    const short 位深 = 32;
    ::memcpy(p + 28, &位深, 2);
    ::memcpy(p + 34, &像素字节, 4);        /* 图像数据长度 */

    /* BMP 像素自下而上; ThorVG 缓冲自上而下, 逐行倒序复制。 */
    const unsigned char* 源 = (const unsigned char*)c->缓冲;
    for (int y = 0; y < c->高; ++y) {
        ::memcpy(p + 54 + (size_t)y * 行字节,
                 源 + (size_t)(c->高 - 1 - y) * 行字节, (size_t)行字节);
    }
    return 需要;
}

int thorgw_canvas_clear(void* canvas)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->缓冲) return -1;
    ::memset(c->缓冲, 0, c->字节数);
    return 0;
}

int thorgw_canvas_fill(void* canvas, int r, int g, int b, int a)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->缓冲) return -1;

    if (c->色彩空间 == 4) {
        ::memset(c->缓冲, 0xFF, c->字节数);
        return 0;
    }
    const uint32_t 色 = ((uint32_t)(a & 0xFF) << 24) | ((uint32_t)(r & 0xFF) << 16)
                      | ((uint32_t)(g & 0xFF) << 8) | (uint32_t)(b & 0xFF);
    const size_t 像素数 = (size_t)c->宽 * (size_t)c->高;
    for (size_t i = 0; i < 像素数; ++i) c->缓冲[i] = 色;
    return 0;
}

int thorgw_canvas_add(void* canvas, void* paint)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->画布 || !paint) return -1;
    return 转码(c->画布->add(取绘制(paint)));
}

int thorgw_canvas_remove(void* canvas, void* paint)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->画布) return -1;
    if (paint) return 转码(c->画布->remove(取绘制(paint)));

    /* ThorVG 的 remove(nullptr) 会解引用空指针, 因此"全部移除"必须逐个处理;
     * 先复制子对象列表, 避免边遍历边修改容器。 */
    std::vector<tvg::Paint*> 列表(c->画布->paints().begin(), c->画布->paints().end());
    for (size_t i = 0; i < 列表.size(); ++i) c->画布->remove(列表[i]);
    return 0;
}

int thorgw_canvas_update(void* canvas)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->画布) return -1;
    return 转码(c->画布->update());
}

int thorgw_canvas_draw(void* canvas, int clear)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->画布) return -1;
    const int 结果 = 转码(c->画布->draw(clear != 0));
    if (结果 == 0) c->画布->sync();
    return 结果;
}

int thorgw_canvas_sync(void* canvas)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->画布) return -1;
    return 转码(c->画布->sync());
}

int thorgw_canvas_viewport(void* canvas, int x, int y, int w, int h)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->画布) return -1;
    return 转码(c->画布->viewport(x, y, w, h));
}

int thorgw_canvas_resize(void* canvas, int w, int h)
{
    CanvasHandle* c = 取画布(canvas);
    if (!c || !c->画布 || w <= 0 || h <= 0) return -1;
    return 绑定缓冲(c, w, h) ? 0 : 3;
}

int thorgw_canvas_width(void* canvas)
{
    CanvasHandle* c = 取画布(canvas);
    return c ? c->宽 : -1;
}

int thorgw_canvas_height(void* canvas)
{
    CanvasHandle* c = 取画布(canvas);
    return c ? c->高 : -1;
}

/* ==================== 绘制对象通用 ==================== */

void thorgw_paint_free(void* paint)
{
    if (!paint) return;
    /* 仅用于 Shape/Scene/Picture/Text 等 Paint 家族对象。
     * 渐变属于 Fill 家族, 必须用 thorgw_gradient_free 释放。 */
    tvg::Paint::rel(取绘制(paint));
}

void thorgw_gradient_free(void* gradient)
{
    if (!gradient) return;
    delete 取填充(gradient);
}

int thorgw_paint_type(void* paint)
{
    tvg::Paint* p = 取绘制(paint);
    return p ? (int)p->type() : 0;
}

int thorgw_paint_visible(void* paint, int on)
{
    tvg::Paint* p = 取绘制(paint);
    return p ? 转码(p->visible(on != 0)) : -1;
}

int thorgw_paint_translate(void* paint, float x, float y)
{
    tvg::Paint* p = 取绘制(paint);
    return p ? 转码(p->translate(x, y)) : -1;
}

int thorgw_paint_rotate(void* paint, float degree)
{
    tvg::Paint* p = 取绘制(paint);
    return p ? 转码(p->rotate(degree)) : -1;
}

int thorgw_paint_scale(void* paint, float factor)
{
    tvg::Paint* p = 取绘制(paint);
    return p ? 转码(p->scale(factor)) : -1;
}

int thorgw_paint_transform(void* paint, const float* m9)
{
    tvg::Paint* p = 取绘制(paint);
    if (!p || !m9) return -1;
    tvg::Matrix m;
    m.e11 = m9[0]; m.e12 = m9[1]; m.e13 = m9[2];
    m.e21 = m9[3]; m.e22 = m9[4]; m.e23 = m9[5];
    m.e31 = m9[6]; m.e32 = m9[7]; m.e33 = m9[8];
    return 转码(p->transform(m));
}

int thorgw_paint_opacity(void* paint, int opacity)
{
    tvg::Paint* p = 取绘制(paint);
    if (!p) return -1;
    if (opacity < 0) opacity = 0;
    if (opacity > 255) opacity = 255;
    return 转码(p->opacity((uint8_t)opacity));
}

int thorgw_paint_mask(void* paint, void* target, int method)
{
    tvg::Paint* p = 取绘制(paint);
    if (!p) return -1;
    tvg::MaskMethod m = tvg::MaskMethod::None;
    switch (method) {
        case 1:  m = tvg::MaskMethod::Alpha; break;
        case 2:  m = tvg::MaskMethod::InvAlpha; break;
        case 3:  m = tvg::MaskMethod::Luma; break;
        case 4:  m = tvg::MaskMethod::InvLuma; break;
        case 5:  m = tvg::MaskMethod::Add; break;
        case 6:  m = tvg::MaskMethod::Subtract; break;
        case 7:  m = tvg::MaskMethod::Intersect; break;
        case 8:  m = tvg::MaskMethod::Difference; break;
        case 9:  m = tvg::MaskMethod::Lighten; break;
        case 10: m = tvg::MaskMethod::Darken; break;
        default: m = tvg::MaskMethod::None; break;
    }
    return 转码(p->mask(target ? 取绘制(target) : nullptr, m));
}

int thorgw_paint_clip(void* paint, void* clipper)
{
    tvg::Paint* p = 取绘制(paint);
    if (!p) return -1;
    return 转码(p->clip(clipper ? 取形状(clipper) : nullptr));
}

int thorgw_paint_blend(void* paint, int method)
{
    tvg::Paint* p = 取绘制(paint);
    if (!p) return -1;
    tvg::BlendMethod m = tvg::BlendMethod::Normal;
    switch (method) {
        case 1:  m = tvg::BlendMethod::Multiply; break;
        case 2:  m = tvg::BlendMethod::Screen; break;
        case 3:  m = tvg::BlendMethod::Overlay; break;
        case 4:  m = tvg::BlendMethod::Darken; break;
        case 5:  m = tvg::BlendMethod::Lighten; break;
        case 6:  m = tvg::BlendMethod::ColorDodge; break;
        case 7:  m = tvg::BlendMethod::ColorBurn; break;
        case 8:  m = tvg::BlendMethod::HardLight; break;
        case 9:  m = tvg::BlendMethod::SoftLight; break;
        case 10: m = tvg::BlendMethod::Difference; break;
        case 11: m = tvg::BlendMethod::Exclusion; break;
        case 12: m = tvg::BlendMethod::Hue; break;
        case 13: m = tvg::BlendMethod::Saturation; break;
        case 14: m = tvg::BlendMethod::Color; break;
        case 15: m = tvg::BlendMethod::Luminosity; break;
        case 16: m = tvg::BlendMethod::Add; break;
        case 255: m = tvg::BlendMethod::Composition; break;
        default: m = tvg::BlendMethod::Normal; break;
    }
    return 转码(p->blend(m));
}

int thorgw_paint_bounds(void* paint, float* out4)
{
    tvg::Paint* p = 取绘制(paint);
    if (!p || !out4) return -1;
    /* 火山字节集不保证 4 字节对齐, 先写临时数组再复制。 */
    float 临时[4] = {0, 0, 0, 0};
    const int 结果 = 转码(p->bounds(&临时[0], &临时[1], &临时[2], &临时[3]));
    if (结果 != 0) return 结果;
    ::memcpy(out4, 临时, sizeof(临时));
    return 0;
}

void* thorgw_paint_parent(void* paint)
{
    tvg::Paint* p = 取绘制(paint);
    if (!p) return nullptr;
    return (void*)p->parent();
}

/* ==================== 形状 ==================== */

void* thorgw_shape_new(void)
{
    return (void*)tvg::Shape::gen();
}

int thorgw_shape_reset(void* shape)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->reset()) : -1;
}

int thorgw_shape_move_to(void* shape, float x, float y)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->moveTo(x, y)) : -1;
}

int thorgw_shape_line_to(void* shape, float x, float y)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->lineTo(x, y)) : -1;
}

int thorgw_shape_cubic_to(void* shape, float cx1, float cy1, float cx2, float cy2, float x, float y)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->cubicTo(cx1, cy1, cx2, cy2, x, y)) : -1;
}

int thorgw_shape_close(void* shape)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->close()) : -1;
}

int thorgw_shape_append_rect(void* shape, float x, float y, float w, float h, float rx, float ry)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->appendRect(x, y, w, h, rx, ry)) : -1;
}

int thorgw_shape_append_circle(void* shape, float cx, float cy, float rx, float ry)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->appendCircle(cx, cy, rx, ry)) : -1;
}

int thorgw_shape_append_polygon(void* shape, const float* xy, int count, int close)
{
    tvg::Shape* s = 取形状(shape);
    if (!s || !xy || count < 2) return -1;

    s->moveTo(xy[0], xy[1]);
    for (int i = 1; i < count; ++i) s->lineTo(xy[i * 2], xy[i * 2 + 1]);
    if (close != 0) s->close();
    return 0;
}

int thorgw_shape_append_star(void* shape, float cx, float cy, float r, float ir, int points)
{
    tvg::Shape* s = 取形状(shape);
    if (!s || points < 3 || r <= 0.0f) return -1;

    const float 步长 = 3.14159265358979323846f / (float)points;
    const float 起始 = -3.14159265358979323846f / 2.0f;

    s->moveTo(cx + r * std::cos(起始), cy + r * std::sin(起始));
    for (int i = 1; i < points * 2; ++i) {
        const float 半径 = (i % 2 == 0) ? r : ir;
        const float 角 = 起始 + 步长 * (float)i;
        s->lineTo(cx + 半径 * std::cos(角), cy + 半径 * std::sin(角));
    }
    s->close();
    return 0;
}

int thorgw_shape_append_arc(void* shape, float cx, float cy, float r, float start, float sweep)
{
    tvg::Shape* s = 取形状(shape);
    if (!s || r <= 0.0f) return -1;

    const float 起角 = 弧度(start);
    const float 扫过 = 弧度(sweep);
    if (std::fabs(扫过) < 1e-6f) return -1;

    s->moveTo(cx + r * std::cos(起角), cy + r * std::sin(起角));

    /* 每段不超过 90 度, 用三次贝塞尔逼近。 */
    const int 段数 = (int)std::ceil(std::fabs(扫过) / 1.5707963f);
    const float 每段 = 扫过 / (float)段数;
    float 当前 = 起角;
    for (int i = 0; i < 段数; ++i) {
        追加圆弧段(s, cx, cy, r, 当前, 当前 + 每段);
        当前 += 每段;
    }
    return 0;
}

int thorgw_shape_fill(void* shape, int r, int g, int b, int a)
{
    tvg::Shape* s = 取形状(shape);
    if (!s) return -1;
    return 转码(s->fill((uint8_t)r, (uint8_t)g, (uint8_t)b, (uint8_t)a));
}

int thorgw_shape_fill_gradient(void* shape, void* gradient)
{
    tvg::Shape* s = 取形状(shape);
    if (!s || !gradient) return -1;
    return 转码(s->fill(取填充(gradient)));
}

int thorgw_shape_stroke_fill(void* shape, int r, int g, int b, int a)
{
    tvg::Shape* s = 取形状(shape);
    if (!s) return -1;
    return 转码(s->strokeFill((uint8_t)r, (uint8_t)g, (uint8_t)b, (uint8_t)a));
}

int thorgw_shape_stroke_gradient(void* shape, void* gradient)
{
    tvg::Shape* s = 取形状(shape);
    if (!s || !gradient) return -1;
    return 转码(s->strokeFill(取填充(gradient)));
}

int thorgw_shape_stroke_width(void* shape, float width)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->strokeWidth(width)) : -1;
}

int thorgw_shape_stroke_dash(void* shape, const float* pattern, int count, float offset)
{
    tvg::Shape* s = 取形状(shape);
    if (!s) return -1;
    return 转码(s->strokeDash(pattern, (uint32_t)count, offset));
}

int thorgw_shape_stroke_cap(void* shape, int cap)
{
    tvg::Shape* s = 取形状(shape);
    if (!s) return -1;
    tvg::StrokeCap c = (cap == 1) ? tvg::StrokeCap::Round
                     : (cap == 2) ? tvg::StrokeCap::Square : tvg::StrokeCap::Butt;
    return 转码(s->strokeCap(c));
}

int thorgw_shape_stroke_join(void* shape, int join)
{
    tvg::Shape* s = 取形状(shape);
    if (!s) return -1;
    tvg::StrokeJoin j = (join == 1) ? tvg::StrokeJoin::Round
                       : (join == 2) ? tvg::StrokeJoin::Bevel : tvg::StrokeJoin::Miter;
    return 转码(s->strokeJoin(j));
}

int thorgw_shape_stroke_miterlimit(void* shape, float miterlimit)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->strokeMiterlimit(miterlimit)) : -1;
}

int thorgw_shape_fill_rule(void* shape, int rule)
{
    tvg::Shape* s = 取形状(shape);
    if (!s) return -1;
    return 转码(s->fillRule(rule == 1 ? tvg::FillRule::EvenOdd : tvg::FillRule::NonZero));
}

int thorgw_shape_order(void* shape, int stroke_first)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->order(stroke_first != 0)) : -1;
}

int thorgw_shape_trim(void* shape, float begin, float end)
{
    tvg::Shape* s = 取形状(shape);
    return s ? 转码(s->trimpath(begin, end)) : -1;
}

int thorgw_shape_path_size(void* shape, int* out2)
{
    tvg::Shape* s = 取形状(shape);
    if (!s || !out2) return -1;

    const tvg::PathCommand* 命令 = nullptr;
    const tvg::Point* 点 = nullptr;
    uint32_t 命令数 = 0, 点数 = 0;
    if (转码(s->path(&命令, &命令数, &点, &点数)) != 0) return -1;
    const int 临时[2] = {(int)命令数, (int)点数};
    ::memcpy(out2, 临时, sizeof(临时));
    return 0;
}

int thorgw_shape_path_cmd_count(void* shape)
{
    tvg::Shape* s = 取形状(shape);
    if (!s) return -1;

    const tvg::PathCommand* 命令 = nullptr;
    const tvg::Point* 点 = nullptr;
    uint32_t 命令数 = 0, 点数 = 0;
    if (转码(s->path(&命令, &命令数, &点, &点数)) != 0) return -1;
    return (int)命令数;
}

int thorgw_shape_path_point_count(void* shape)
{
    tvg::Shape* s = 取形状(shape);
    if (!s) return -1;

    const tvg::PathCommand* 命令 = nullptr;
    const tvg::Point* 点 = nullptr;
    uint32_t 命令数 = 0, 点数 = 0;
    if (转码(s->path(&命令, &命令数, &点, &点数)) != 0) return -1;
    return (int)点数;
}

/* ==================== 渐变 ==================== */

void* thorgw_linear_new(void) { return (void*)tvg::LinearGradient::gen(); }
void* thorgw_radial_new(void) { return (void*)tvg::RadialGradient::gen(); }

int thorgw_linear_set(void* gradient, float x1, float y1, float x2, float y2)
{
    tvg::LinearGradient* g = (tvg::LinearGradient*)gradient;
    return g ? 转码(g->linear(x1, y1, x2, y2)) : -1;
}

int thorgw_radial_set(void* gradient, float cx, float cy, float r, float fx, float fy, float fr)
{
    tvg::RadialGradient* g = (tvg::RadialGradient*)gradient;
    return g ? 转码(g->radial(cx, cy, r, fx, fy, fr)) : -1;
}

int thorgw_gradient_stops(void* gradient, const float* stops, int count)
{
    tvg::Fill* g = 取填充(gradient);
    if (!g || !stops || count <= 0) return -1;

    std::vector<tvg::Fill::ColorStop> 列表((size_t)count);
    for (int i = 0; i < count; ++i) {
        const float* p = stops + i * 5;
        列表[(size_t)i].offset = p[0];
        列表[(size_t)i].r = (uint8_t)p[1];
        列表[(size_t)i].g = (uint8_t)p[2];
        列表[(size_t)i].b = (uint8_t)p[3];
        列表[(size_t)i].a = (uint8_t)p[4];
    }
    return 转码(g->colorStops(列表.data(), (uint32_t)count));
}

int thorgw_gradient_spread(void* gradient, int spread)
{
    tvg::Fill* g = 取填充(gradient);
    if (!g) return -1;
    tvg::FillSpread s = (spread == 1) ? tvg::FillSpread::Reflect
                      : (spread == 2) ? tvg::FillSpread::Repeat : tvg::FillSpread::Pad;
    return 转码(g->spread(s));
}

int thorgw_gradient_transform(void* gradient, const float* m9)
{
    tvg::Fill* g = 取填充(gradient);
    if (!g || !m9) return -1;
    tvg::Matrix m;
    m.e11 = m9[0]; m.e12 = m9[1]; m.e13 = m9[2];
    m.e21 = m9[3]; m.e22 = m9[4]; m.e23 = m9[5];
    m.e31 = m9[6]; m.e32 = m9[7]; m.e33 = m9[8];
    return 转码(g->transform(m));
}

/* ==================== 场景 ==================== */

void* thorgw_scene_new(void) { return (void*)tvg::Scene::gen(); }

int thorgw_scene_add(void* scene, void* paint)
{
    tvg::Scene* s = 取场景(scene);
    if (!s || !paint) return -1;
    return 转码(s->add(取绘制(paint)));
}

int thorgw_scene_remove(void* scene, void* paint)
{
    tvg::Scene* s = 取场景(scene);
    if (!s) return -1;
    if (paint) return 转码(s->remove(取绘制(paint)));

    /* 同画布: remove(nullptr) 不安全, 逐个移出。 */
    std::vector<tvg::Paint*> 列表(s->paints().begin(), s->paints().end());
    for (size_t i = 0; i < 列表.size(); ++i) s->remove(列表[i]);
    return 0;
}

int thorgw_scene_blur(void* scene, float sigma, int direction, int border, int quality)
{
    tvg::Scene* s = 取场景(scene);
    if (!s) return -1;
    return 转码(s->add(tvg::SceneEffect::GaussianBlur, (double)sigma, direction, border, quality));
}

int thorgw_scene_clear_effects(void* scene)
{
    tvg::Scene* s = 取场景(scene);
    if (!s) return -1;
    return 转码(s->add(tvg::SceneEffect::Clear));
}

/* ==================== 图片 ==================== */

void* thorgw_picture_new(void) { return (void*)tvg::Picture::gen(); }

int thorgw_picture_load(void* picture, const char* utf8_path)
{
    tvg::Picture* p = 取图片(picture);
    if (!p || !utf8_path) return -1;
    return 转码(p->load(utf8_path));
}

int thorgw_picture_load_data(void* picture, const void* data, int size, const char* mime)
{
    tvg::Picture* p = 取图片(picture);
    if (!p || !data || size <= 0 || !mime) return -1;
    /* copy = true 必须为真: ThorVG 默认只保存调用方数据指针并在渲染时惰性解析,
     * 而火山字节集是临时对象, 方法返回后即释放, 会导致画面空白。 */
    return 转码(p->load((const char*)data, (uint32_t)size, mime, nullptr, true));
}

int thorgw_picture_load_pixels(void* picture, const void* pixels, int w, int h, int colorspace, int copy)
{
    tvg::Picture* p = 取图片(picture);
    if (!p || !pixels || w <= 0 || h <= 0) return -1;
    return 转码(p->load((const uint32_t*)pixels, (uint32_t)w, (uint32_t)h,
                        色彩空间(colorspace), copy != 0));
}

int thorgw_picture_set_size(void* picture, float w, float h)
{
    tvg::Picture* p = 取图片(picture);
    return p ? 转码(p->size(w, h)) : -1;
}

int thorgw_picture_get_size(void* picture, float* out2)
{
    tvg::Picture* p = 取图片(picture);
    if (!p || !out2) return -1;
    float 临时[2] = {0, 0};
    const int 结果 = 转码(p->size(&临时[0], &临时[1]));
    if (结果 != 0) return 结果;
    ::memcpy(out2, 临时, sizeof(临时));
    return 0;
}

int thorgw_picture_origin(void* picture, float x, float y)
{
    tvg::Picture* p = 取图片(picture);
    return p ? 转码(p->origin(x, y)) : -1;
}

int thorgw_picture_filter(void* picture, int method)
{
    tvg::Picture* p = 取图片(picture);
    if (!p) return -1;
    return 转码(p->filter(method == 1 ? tvg::FilterMethod::Nearest : tvg::FilterMethod::Bilinear));
}

/* ==================== 动画 ==================== */

void* thorgw_animation_new(void) { return (void*)tvg::Animation::gen(); }

void* thorgw_animation_picture(void* animation)
{
    tvg::Animation* a = 取动画(animation);
    return a ? (void*)a->picture() : nullptr;
}

int thorgw_animation_load(void* animation, const char* utf8_path)
{
    tvg::Animation* a = 取动画(animation);
    if (!a || !utf8_path) return -1;
    tvg::Picture* p = a->picture();
    if (!p) return -1;
    return 转码(p->load(utf8_path));
}

int thorgw_animation_load_data(void* animation, const void* data, int size, const char* mime)
{
    tvg::Animation* a = 取动画(animation);
    if (!a || !data || size <= 0 || !mime) return -1;
    tvg::Picture* p = a->picture();
    if (!p) return -1;
    /* copy = true: 原因同图片, 火山字节集是临时对象。 */
    return 转码(p->load((const char*)data, (uint32_t)size, mime, nullptr, true));
}

void thorgw_animation_free(void* animation)
{
    if (!animation) return;
    delete 取动画(animation);
}

float thorgw_animation_total_frame(void* animation)
{
    tvg::Animation* a = 取动画(animation);
    return a ? a->totalFrame() : -1.0f;
}

float thorgw_animation_duration(void* animation)
{
    tvg::Animation* a = 取动画(animation);
    return a ? a->duration() : -1.0f;
}

float thorgw_animation_cur_frame(void* animation)
{
    tvg::Animation* a = 取动画(animation);
    return a ? a->curFrame() : -1.0f;
}

int thorgw_animation_set_frame(void* animation, float frame)
{
    tvg::Animation* a = 取动画(animation);
    return a ? 转码(a->frame(frame)) : -1;
}

int thorgw_animation_segment(void* animation, float begin, float end)
{
    tvg::Animation* a = 取动画(animation);
    return a ? 转码(a->segment(begin, end)) : -1;
}

/* ==================== 文本 ==================== */

void* thorgw_text_new(void) { return (void*)tvg::Text::gen(); }

int thorgw_text_font(void* text, const char* utf8_name)
{
    tvg::Text* t = 取文本(text);
    if (!t || !utf8_name) return -1;
    return 转码(t->font(utf8_name));
}

int thorgw_text_set(void* text, const char* utf8_text)
{
    tvg::Text* t = 取文本(text);
    if (!t || !utf8_text) return -1;
    return 转码(t->text(utf8_text));
}

int thorgw_text_size(void* text, float size)
{
    tvg::Text* t = 取文本(text);
    return t ? 转码(t->size(size)) : -1;
}

int thorgw_text_align(void* text, float x, float y)
{
    tvg::Text* t = 取文本(text);
    return t ? 转码(t->align(x, y)) : -1;
}

int thorgw_text_layout(void* text, float w, float h)
{
    tvg::Text* t = 取文本(text);
    return t ? 转码(t->layout(w, h)) : -1;
}

int thorgw_text_wrap(void* text, int mode)
{
    tvg::Text* t = 取文本(text);
    if (!t) return -1;
    tvg::TextWrap m = tvg::TextWrap::None;
    switch (mode) {
        case 1: m = tvg::TextWrap::Character; break;
        case 2: m = tvg::TextWrap::Word; break;
        case 3: m = tvg::TextWrap::Smart; break;
        case 4: m = tvg::TextWrap::Ellipsis; break;
        default: m = tvg::TextWrap::None; break;
    }
    return 转码(t->wrap(m));
}

int thorgw_text_italic(void* text, float shear)
{
    tvg::Text* t = 取文本(text);
    return t ? 转码(t->italic(shear)) : -1;
}

int thorgw_text_outline(void* text, float width, int r, int g, int b)
{
    tvg::Text* t = 取文本(text);
    if (!t) return -1;
    return 转码(t->outline(width, (uint8_t)r, (uint8_t)g, (uint8_t)b));
}

int thorgw_text_fill(void* text, int r, int g, int b)
{
    tvg::Text* t = 取文本(text);
    if (!t) return -1;
    return 转码(t->fill((uint8_t)r, (uint8_t)g, (uint8_t)b));
}

int thorgw_text_spacing(void* text, float letter, float line)
{
    tvg::Text* t = 取文本(text);
    return t ? 转码(t->spacing(letter, line)) : -1;
}

int thorgw_text_metrics(void* text, float* out4)
{
    tvg::Text* t = 取文本(text);
    if (!t || !out4) return -1;
    tvg::TextMetrics m;
    const int 结果 = 转码(t->metrics(m));
    if (结果 != 0) return 结果;
    const float 临时[4] = {m.ascent, m.descent, m.linegap, m.advance};
    ::memcpy(out4, 临时, sizeof(临时));
    return 0;
}

int thorgw_font_load(const char* utf8_name, const void* data, int size, const char* mime)
{
    if (!utf8_name || !data || size <= 0) return -1;
    /* 同图片: 字体数据也必须由 ThorVG 复制, 否则火山字节集释放后字形数据失效。 */
    return 转码(tvg::Text::load(utf8_name, (const char*)data, (uint32_t)size,
                               mime ? mime : "ttf", true));
}

int thorgw_font_load_file(const char* utf8_path)
{
    if (!utf8_path) return -1;

    /* 读入字体文件, 以「文件名去扩展名」作为注册名, 便于后续 置字体("simhei") 引用。 */
    ::FILE* f = nullptr;
#ifdef _MSC_VER
    if (::fopen_s(&f, utf8_path, "rb") != 0) f = nullptr;
#else
    f = ::fopen(utf8_path, "rb");
#endif
    if (!f) return 1;

    ::fseek(f, 0, SEEK_END);
    const long 长度 = ::ftell(f);
    ::fseek(f, 0, SEEK_SET);
    if (长度 <= 0) { ::fclose(f); return 1; }

    std::vector<char> 数据((size_t)长度);
    const size_t 读到 = ::fread(数据.data(), 1, 数据.size(), f);
    ::fclose(f);
    if (读到 != 数据.size()) return 1;

    /* 取文件名部分并去掉扩展名。 */
    std::string 路径(utf8_path);
    const size_t 斜杠1 = 路径.find_last_of("\\/");
    std::string 名称 = (斜杠1 == std::string::npos) ? 路径 : 路径.substr(斜杠1 + 1);
    const size_t 点 = 名称.find_last_of('.');
    if (点 != std::string::npos) 名称 = 名称.substr(0, 点);
    if (名称.empty()) return 1;

    return 转码(tvg::Text::load(名称.c_str(), 数据.data(), (uint32_t)数据.size(), "ttf", true));
}

int thorgw_font_unload(const char* utf8_name)
{
    if (!utf8_name) return -1;
    return 转码(tvg::Text::unload(utf8_name));
}

/* ==================== 矩阵工具 ==================== */

void thorgw_matrix_identity(float* m9)
{
    if (!m9) return;
    m9[0] = 1; m9[1] = 0; m9[2] = 0;
    m9[3] = 0; m9[4] = 1; m9[5] = 0;
    m9[6] = 0; m9[7] = 0; m9[8] = 1;
}

void thorgw_matrix_translate(float* m9, float x, float y)
{
    thorgw_matrix_identity(m9);
    if (!m9) return;
    /* ThorVG 采用列向量约定(p' = M x p), 平移分量位于第三列 e13/e23。 */
    m9[2] = x;
    m9[5] = y;
}

void thorgw_matrix_scale(float* m9, float sx, float sy)
{
    thorgw_matrix_identity(m9);
    if (!m9) return;
    m9[0] = sx;
    m9[4] = sy;
}

void thorgw_matrix_rotate(float* m9, float degree)
{
    thorgw_matrix_identity(m9);
    if (!m9) return;
    const float 角 = 弧度(degree);
    const float 余 = std::cos(角);
    const float 正 = std::sin(角);
    m9[0] = 余;  m9[1] = 正;  m9[2] = 0;
    m9[3] = -正; m9[4] = 余;  m9[5] = 0;
    m9[6] = 0;   m9[7] = 0;   m9[8] = 1;
}

int thorgw_matrix_build(float* out9, int kind, double a, double b)
{
    if (!out9) return -1;

    /* 先算到临时数组, 再按未对齐安全方式写入火山字节集。 */
    float 临时[9] = {1, 0, 0, 0, 1, 0, 0, 0, 1};
    switch (kind) {
        case 1: thorgw_matrix_translate(临时, (float)a, (float)b); break;
        case 2: thorgw_matrix_scale(临时, (float)a, (float)b); break;
        case 3: thorgw_matrix_rotate(临时, (float)a); break;
        default: thorgw_matrix_identity(临时); break;
    }
    ::memcpy(out9, 临时, sizeof(临时));
    return 0;
}

int thorgw_matrix_multiply(float* out9, const float* a9, const float* b9)
{
    if (!out9 || !a9 || !b9) return -1;

    float 结果[9];
    for (int 行 = 0; 行 < 3; ++行) {
        for (int 列 = 0; 列 < 3; ++列) {
            结果[行 * 3 + 列] = a9[行 * 3 + 0] * b9[0 * 3 + 列]
                              + a9[行 * 3 + 1] * b9[1 * 3 + 列]
                              + a9[行 * 3 + 2] * b9[2 * 3 + 列];
        }
    }
    ::memcpy(out9, 结果, sizeof(结果));
    return 0;
}

} /* extern "C" */
