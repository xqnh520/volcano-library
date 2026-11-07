#pragma once

/* ThorVG 1.1.0 火山视窗封装 —— 原生桥接层接口(纯 extern "C")。
 *
 * 设计约定(与火山外层类一一对应):
 *   1. 所有句柄为 void*, 空指针表示无效句柄; 语义层负责判空。
 *   2. 返回 int 的接口: 0 = 成功; 其余为 ThorVG Result 枚举值(1 参数无效,
 *      2 条件不足, 3 分配失败, 4 内存损坏, 5 不支持, 255 未知); -1 表示句柄无效。
 *   3. 文本返回 const wchar_t*(UTF-16), 由库内静态缓冲持有, 下次调用覆盖。
 *   4. 文本参数一律 UTF-8 (const char*), 由火山侧 文本到UTF8 转换后传入。
 *   5. 浮点数组参数按紧密打包传递(两份实现: 指针版与字节集版)。
 *   6. 画布句柄内含像素缓冲, 由本层分配与释放, 火山侧只读。
 */

#ifndef NOMINMAX
#define NOMINMAX
#endif

#include <stdint.h>

extern "C" {

/* ==================== 引擎 ==================== */

/* 版本文本, 形如 "火山.ThorVG 1.0.0 (ThorVG 1.1.0)"。 */
const wchar_t* thorgw_version(void);

/* 初始化 ThorVG 引擎(进程内只需一次)。线程数 <= 0 表示自动。0 = 成功。 */
int thorgw_init(int threads);

/* 终止引擎, 释放内部线程池。 */
void thorgw_term(void);

/* 把 Result 错误码翻译成中文说明(静态缓冲)。 */
const wchar_t* thorgw_result_text(int code);

/* ==================== 画布 ==================== */

/* 创建软件画布(内含 w*h 像素缓冲)。颜色空间: 0=ABGR8888, 1=ARGB8888,
 * 2=ABGR8888S, 3=ARGB8888S, 4=灰度8。失败返回空。 */
void* thorgw_canvas_new(int w, int h, int colorspace);

/* 释放画布与像素缓冲。 */
void  thorgw_canvas_free(void* canvas);

/* 画布像素缓冲首地址(只读, uint32_t 数组, 长度 = 宽*高)。 */
void* thorgw_canvas_pixels(void* canvas);

/* 画布像素字节数, 用于火山字节集分配。 */
int   thorgw_canvas_pixel_bytes(void* canvas);

/* 把像素缓冲复制到调用方缓冲(容量不足时返回 -(所需字节数), 且不写入)。 */
int   thorgw_canvas_copy_pixels(void* canvas, void* out, int capacity);

/* 生成 32 位 BMP 文件数据(含文件头, 自下而上, BGRA), 便于火山用
 * 位图对象类.载入位图数据 直接显示。返回写入字节数;
 * 容量不足返回 -(所需字节数), 且不写入; 句柄无效返回 -1。 */
int   thorgw_canvas_make_bmp(void* canvas, void* out, int capacity);

/* 清空像素缓冲为全透明黑。 */
int   thorgw_canvas_clear(void* canvas);

/* 用指定颜色(不透明)填满整块像素缓冲, 常用于铺背景。 */
int   thorgw_canvas_fill(void* canvas, int r, int g, int b, int a);

/* 把绘制对象放入画布。 */
int   thorgw_canvas_add(void* canvas, void* paint);

/* 从画布移除绘制对象; paint 传空表示全部移除。 */
int   thorgw_canvas_remove(void* canvas, void* paint);

/* 通知画布场景已变化。 */
int   thorgw_canvas_update(void* canvas);

/* 执行渲染(clear 非 0 时先清屏)。 */
int   thorgw_canvas_draw(void* canvas, int clear);

/* 等待渲染完成。 */
int   thorgw_canvas_sync(void* canvas);

/* 设置视口。 */
int   thorgw_canvas_viewport(void* canvas, int x, int y, int w, int h);

/* 改变画布尺寸(重建像素缓冲, 场景保留)。 */
int   thorgw_canvas_resize(void* canvas, int w, int h);

/* 读取画布宽/高。 */
int   thorgw_canvas_width(void* canvas);
int   thorgw_canvas_height(void* canvas);

/* ==================== 绘制对象通用 ==================== */

/* 释放任意绘制对象(Shape/Scene/Picture/Text), 空指针安全。
 * 注意: 渐变对象属于填充家族, 必须用 thorgw_gradient_free。 */
void  thorgw_paint_free(void* paint);

/* 释放渐变对象(线性/径向), 空指针安全。 */
void  thorgw_gradient_free(void* gradient);

/* 对象类型: 0 未知, 1 形状, 2 场景, 3 图片, 4 文本, 10 线性渐变, 11 径向渐变。 */
int   thorgw_paint_type(void* paint);

int   thorgw_paint_visible(void* paint, int on);
int   thorgw_paint_translate(void* paint, float x, float y);
int   thorgw_paint_rotate(void* paint, float degree);
int   thorgw_paint_scale(void* paint, float factor);
int   thorgw_paint_transform(void* paint, const float* m9);
int   thorgw_paint_opacity(void* paint, int opacity);
int   thorgw_paint_mask(void* paint, void* target, int method);
int   thorgw_paint_clip(void* paint, void* clipper);
int   thorgw_paint_blend(void* paint, int method);

/* 取包围盒: out 为 4 个 float (x, y, w, h)。 */
int   thorgw_paint_bounds(void* paint, float* out4);

/* 读取对象父节点(根对象返回空)。 */
void* thorgw_paint_parent(void* paint);

/* ==================== 形状 ==================== */

void* thorgw_shape_new(void);

/* 清空已构建的路径(保留样式)。 */
int   thorgw_shape_reset(void* shape);

int   thorgw_shape_move_to(void* shape, float x, float y);
int   thorgw_shape_line_to(void* shape, float x, float y);
int   thorgw_shape_cubic_to(void* shape, float cx1, float cy1, float cx2, float cy2, float x, float y);
int   thorgw_shape_close(void* shape);

/* 追加矩形(rx/ry 为圆角半径)。 */
int   thorgw_shape_append_rect(void* shape, float x, float y, float w, float h, float rx, float ry);

/* 追加圆/椭圆(rx == ry 即为圆)。 */
int   thorgw_shape_append_circle(void* shape, float cx, float cy, float rx, float ry);

/* 追加折线/多边形: xy 为 2*count 个 float, close 非 0 时闭合。 */
int   thorgw_shape_append_polygon(void* shape, const float* xy, int count, int close);

/* 追加星形: cx/cy 中心, r 外半径, ir 内半径, 顶点数 points。 */
int   thorgw_shape_append_star(void* shape, float cx, float cy, float r, float ir, int points);

/* 追加圆弧(不含圆心连线)。 */
int   thorgw_shape_append_arc(void* shape, float cx, float cy, float r, float start, float sweep);

/* 纯色填充(a = 255 为不透明)。 */
int   thorgw_shape_fill(void* shape, int r, int g, int b, int a);

/* 用渐变对象填充(渐变对象所有权仍归调用方)。 */
int   thorgw_shape_fill_gradient(void* shape, void* gradient);

int   thorgw_shape_stroke_fill(void* shape, int r, int g, int b, int a);
int   thorgw_shape_stroke_gradient(void* shape, void* gradient);
int   thorgw_shape_stroke_width(void* shape, float width);

/* 虚线样式: pattern 为 count 个 float(长度与间隔交替), offset 为起始偏移。 */
int   thorgw_shape_stroke_dash(void* shape, const float* pattern, int count, float offset);

/* 端点样式: 0 平头, 1 圆头, 2 方头。 */
int   thorgw_shape_stroke_cap(void* shape, int cap);

/* 拐角样式: 0 尖角, 1 圆角, 2 斜切。 */
int   thorgw_shape_stroke_join(void* shape, int join);

int   thorgw_shape_stroke_miterlimit(void* shape, float miterlimit);

/* 填充规则: 0 非零环绕, 1 奇偶。 */
int   thorgw_shape_fill_rule(void* shape, int rule);

/* 描边是否绘制在填充之上。 */
int   thorgw_shape_order(void* shape, int stroke_first);

/* 路径裁剪(按比例截取路径的一段)。 */
int   thorgw_shape_trim(void* shape, float begin, float end);

/* 读取路径规模: out2 返回 {命令数, 点数}。 */
int   thorgw_shape_path_size(void* shape, int* out2);

/* 路径命令数与点数(单独返回, 便于火山侧直接用整数)。 */
int   thorgw_shape_path_cmd_count(void* shape);
int   thorgw_shape_path_point_count(void* shape);

/* ==================== 渐变 ==================== */

void* thorgw_linear_new(void);
void* thorgw_radial_new(void);

int   thorgw_linear_set(void* gradient, float x1, float y1, float x2, float y2);
int   thorgw_radial_set(void* gradient, float cx, float cy, float r, float fx, float fy, float fr);

/* 色标: stops 每 5 个 float 为一组 (偏移, 红, 绿, 蓝, 透明度), count 为色标个数。 */
int   thorgw_gradient_stops(void* gradient, const float* stops, int count);

/* 平铺方式: 0 夹取, 1 反射, 2 重复。 */
int   thorgw_gradient_spread(void* gradient, int spread);
int   thorgw_gradient_transform(void* gradient, const float* m9);

/* ==================== 场景 ==================== */

void* thorgw_scene_new(void);

/* 把对象加入场景。 */
int   thorgw_scene_add(void* scene, void* paint);

/* 从场景移除对象; paint 传空表示全部移除。 */
int   thorgw_scene_remove(void* scene, void* paint);

/* 高斯模糊: sigma 为模糊半径, direction 0 双向 / 1 水平 / 2 垂直, border 边框扩展, quality 质量。 */
int   thorgw_scene_blur(void* scene, float sigma, int direction, int border, int quality);

/* 清除场景上的所有特效。 */
int   thorgw_scene_clear_effects(void* scene);

/* ==================== 图片 ==================== */

void* thorgw_picture_new(void);

/* 由 UTF-8 文件路径加载 SVG/PNG/JPG/WebP/TVG 等。 */
int   thorgw_picture_load(void* picture, const char* utf8_path);

/* 由内存数据加载, mime 形如 "svg"/"png"/"jpg"/"webp"/"tvg"。 */
int   thorgw_picture_load_data(void* picture, const void* data, int size, const char* mime);

/* 由原始像素数据加载(数据所有权: copy 非 0 时内部复制)。 */
int   thorgw_picture_load_pixels(void* picture, const void* pixels, int w, int h, int colorspace, int copy);

/* 设置目标显示尺寸。 */
int   thorgw_picture_set_size(void* picture, float w, float h);

/* 读取原始尺寸: out2 = {w, h}。 */
int   thorgw_picture_get_size(void* picture, float* out2);

/* 设置绘制原点偏移。 */
int   thorgw_picture_origin(void* picture, float x, float y);

/* 缩放过滤: 0 双线性, 1 最近邻。 */
int   thorgw_picture_filter(void* picture, int method);

/* ==================== 动画 ==================== */

/* 说明: ThorVG 1.1 起动画改为「动画 -> 图片」模型。
 * 创建动画后先用 thorgw_animation_picture 取出它自带的图片对象,
 * 用图片的加载接口载入 Lottie/动画文件, 把该图片加入画布,
 * 再用 thorgw_animation_set_frame 推进帧。 */
void* thorgw_animation_new(void);

/* 取动画自带的图片对象(由动画持有, 不要单独释放)。 */
void* thorgw_animation_picture(void* animation);

/* 由 UTF-8 文件路径加载动画(Lottie json / .lot / .tvg)。 */
int   thorgw_animation_load(void* animation, const char* utf8_path);

int   thorgw_animation_load_data(void* animation, const void* data, int size, const char* mime);

/* 释放独立动画(由 thorgw_animation_new 创建)。 */
void  thorgw_animation_free(void* animation);

float thorgw_animation_total_frame(void* animation);
float thorgw_animation_duration(void* animation);
float thorgw_animation_cur_frame(void* animation);

/* 跳转到指定帧(小数帧号)。 */
int   thorgw_animation_set_frame(void* animation, float frame);

/* 设置播放片段 [begin, end]。 */
int   thorgw_animation_segment(void* animation, float begin, float end);

/* ==================== 文本 ==================== */

void* thorgw_text_new(void);

/* 字体名(UTF-8), 需先通过 thorgw_font_load 载入或使用系统已注册字体。 */
int   thorgw_text_font(void* text, const char* utf8_name);

/* 文本内容(UTF-8)。 */
int   thorgw_text_set(void* text, const char* utf8_text);

int   thorgw_text_size(void* text, float size);
int   thorgw_text_align(void* text, float x, float y);
int   thorgw_text_layout(void* text, float w, float h);

/* 换行方式: 0 不换行, 1 按字符, 2 按单词, 3 智能, 4 省略号。 */
int   thorgw_text_wrap(void* text, int mode);

int   thorgw_text_italic(void* text, float shear);
int   thorgw_text_outline(void* text, float width, int r, int g, int b);
int   thorgw_text_fill(void* text, int r, int g, int b);
int   thorgw_text_spacing(void* text, float letter, float line);

/* 文本度量: out4 = {ascent, descent, linegap, advance}。 */
int   thorgw_text_metrics(void* text, float* out4);

/* 载入字体文件, name 为后续引用的字体名(UTF-8); data 为字体文件内容。 */
int   thorgw_font_load(const char* utf8_name, const void* data, int size, const char* mime);
int   thorgw_font_load_file(const char* utf8_path);

/* 卸载字体。 */
int   thorgw_font_unload(const char* utf8_name);

/* ==================== 矩阵工具 ==================== */

/* 生成单位矩阵。 */
void  thorgw_matrix_identity(float* m9);

/* 生成平移矩阵。 */
void  thorgw_matrix_translate(float* m9, float x, float y);

/* 生成缩放矩阵。 */
void  thorgw_matrix_scale(float* m9, float sx, float sy);

/* 生成旋转矩阵(角度)。 */
void  thorgw_matrix_rotate(float* m9, float degree);

/* 火山层统一入口: 按种类生成矩阵写入 out9(9 个单精度小数)。
 * 种类: 0 单位, 1 平移(甲=横, 乙=纵), 2 缩放(甲=横向比例, 乙=纵向比例), 3 旋转(甲=角度)。 */
int   thorgw_matrix_build(float* out9, int kind, double a, double b);

/* 矩阵组合: out = 甲 x 乙(先施加乙, 再施加甲), out 可与甲/乙为同一缓冲。 */
int   thorgw_matrix_multiply(float* out9, const float* a9, const float* b9);

} /* extern "C" */
