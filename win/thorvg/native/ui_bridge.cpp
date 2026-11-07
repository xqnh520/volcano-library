/* ThorVG UI Toolkit 实现。
 *
 * 结构: UiWidget 控件树 + 递归布局 + 最内层命中测试 + 状态机 + 绘制 + 事件队列。
 * 所有绘制统一走 thorvg_bridge 的 C 接口(thorgw_*), 不直接使用 tvg:: C++ API:
 * 静态库由 14.29 工具集构建, 而本文件由 14.44 编译, 跨边界传 C++ 对象不安全。
 */

#include "ui_bridge.hpp"
#include "thorvg_bridge.hpp"

#ifndef NOMINMAX
#define NOMINMAX
#endif
#include <windows.h>

#include <algorithm>
#include <cmath>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>

namespace
{

/* ==================== 基础工具 ==================== */

float 夹取(float v, float lo, float hi)
{
    return (v < lo) ? lo : ((v > hi) ? hi : v);
}

void 拷名(char* dst, size_t cap, const std::string& s)
{
    if (!dst || cap == 0) return;
    const size_t n = (s.size() < cap - 1) ? s.size() : cap - 1;
    ::memcpy(dst, s.data(), n);
    dst[n] = '\0';
}

void 拆色(unsigned c, int& r, int& g, int& b, int& a)
{
    a = (int)((c >> 24) & 0xFF);
    r = (int)((c >> 16) & 0xFF);
    g = (int)((c >> 8) & 0xFF);
    b = (int)(c & 0xFF);
}

unsigned 混色(unsigned c1, unsigned c2, float t)
{
    int r1, g1, b1, a1, r2, g2, b2, a2;
    拆色(c1, r1, g1, b1, a1);
    拆色(c2, r2, g2, b2, a2);
    t = 夹取(t, 0.0f, 1.0f);
    const int r = (int)(r1 + (r2 - r1) * t);
    const int g = (int)(g1 + (g2 - g1) * t);
    const int b = (int)(b1 + (b2 - b1) * t);
    const int a = (int)(a1 + (a2 - a1) * t);
    return ((unsigned)a << 24) | ((unsigned)r << 16) | ((unsigned)g << 8) | (unsigned)b;
}

unsigned 设透明度(unsigned c, float alpha)
{
    const int a = (int)夹取(alpha * 255.0f, 0.0f, 255.0f);
    return (c & 0x00FFFFFFu) | ((unsigned)a << 24);
}

/* ==================== 主题 ==================== */

struct UiTheme
{
    unsigned bg, surface, surfaceHi, surfaceLo, border, fg, fgDim;
    unsigned accent, accentFg, disabled, shadow, select;
    unsigned success, warn, danger;
    float    radius, fontSize, rowHeight, borderWidth;
};

UiTheme 深色主题()
{
    UiTheme t;
    t.bg = 0xFF171B22; t.surface = 0xFF232A36; t.surfaceHi = 0xFF2F3949;
    t.surfaceLo = 0xFF1B212B; t.border = 0xFF37414F;
    t.fg = 0xFFE6EAF0; t.fgDim = 0xFF98A2B3;
    t.accent = 0xFF4C8DFF; t.accentFg = 0xFFFFFFFF;
    t.disabled = 0xFF4A5464; t.shadow = 0x66000000; t.select = 0x333B82F6;
    t.success = 0xFF3DD68C; t.warn = 0xFFF5B841; t.danger = 0xFFF2637B;
    t.radius = 6.0f; t.fontSize = 14.0f; t.rowHeight = 30.0f; t.borderWidth = 1.0f;
    return t;
}

UiTheme 浅色主题()
{
    UiTheme t;
    t.bg = 0xFFF3F5F9; t.surface = 0xFFFFFFFF; t.surfaceHi = 0xFFEAF0F8;
    t.surfaceLo = 0xFFE5EAF2; t.border = 0xFFD2D9E3;
    t.fg = 0xFF1E2733; t.fgDim = 0xFF68738A;
    t.accent = 0xFF2F6FEB; t.accentFg = 0xFFFFFFFF;
    t.disabled = 0xFFB4BECC; t.shadow = 0x28000000; t.select = 0x222F6FEB;
    t.success = 0xFF1BA97B; t.warn = 0xFFC9820E; t.danger = 0xFFD93B54;
    t.radius = 6.0f; t.fontSize = 14.0f; t.rowHeight = 30.0f; t.borderWidth = 1.0f;
    return t;
}

UiTheme 蓝色主题()
{
    UiTheme t = 深色主题();
    t.bg = 0xFF0C1524; t.surface = 0xFF152238; t.surfaceHi = 0xFF1E3050;
    t.surfaceLo = 0xFF101B2C; t.border = 0xFF27405F;
    t.accent = 0xFF38BDF8; t.accentFg = 0xFF06121F;
    t.select = 0x3340B4F4; t.shadow = 0x77000000;
    return t;
}

UiTheme 高对比主题()
{
    UiTheme t;
    t.bg = 0xFF000000; t.surface = 0xFF141414; t.surfaceHi = 0xFF262626;
    t.surfaceLo = 0xFF0A0A0A; t.border = 0xFF7A7A7A;
    t.fg = 0xFFFFFFFF; t.fgDim = 0xFFC8C8C8;
    t.accent = 0xFFFFD400; t.accentFg = 0xFF000000;
    t.disabled = 0xFF6E6E6E; t.shadow = 0xAA000000; t.select = 0x55FFD400;
    t.success = 0xFF00FF87; t.warn = 0xFFFFD400; t.danger = 0xFFFF5A5A;
    t.radius = 3.0f; t.fontSize = 14.0f; t.rowHeight = 30.0f; t.borderWidth = 2.0f;
    return t;
}

/* ==================== 控件模型 ==================== */

struct UiItem
{
    std::string text;
    bool checked = false;
};

struct UiColumn
{
    std::string title;
    float width = 0.0f;   /* <=0 表示按剩余宽度均分 */
};

#define UI_ITEM_MIN_H 18.0f

struct UiWidget
{
    int   id = 0;
    int   kind = UIW_PANEL;
    int   layout = UIL_ABSOLUTE;
    int   align = UIA_LEFT;
    int   valign = UIV_MIDDLE;
    int   group = 0;
    int   tag = 0;
    int   icon = 0;
    int   gridCols = 2;
    int   wrapMode = 0;        /* 0 不换行 1 字符 2 单词 3 智能 */
    int   visibleRows = 0;     /* 多行文本框可见行数, 0 = 自动 */

    bool  visible = true;
    bool  enabled = true;
    bool  checked = false;
    bool  expanded = false;    /* 下拉框/菜单是否展开 */

    /* 计算后矩形(父容器内的绝对坐标, 顶层即视口坐标) */
    float x = 0, y = 0, w = 0, h = 0;

    /* 声明矩形(相对父容器内容区左上角) */
    float dx = 0, dy = 0, dw = 0, dh = 0;

    float padL = 8, padT = 4, padR = 8, padB = 4;
    float marginL = 0, marginT = 0, marginR = 0, marginB = 0;
    float spacing = 6;
    float weight = 0;          /* >0 在流水布局中按权重分配剩余空间 */

    float scroll = 0, scrollMax = 0;

    float value = 0, vmin = 0, vmax = 1, step = 0;

    float fontSize = 0;        /* 0 = 用主题字号 */
    float radius = -1;         /* <0 = 用主题圆角 */
    float borderWidth = 0;     /* 0 = 用主题边框宽 */
    float rowHeight = 0;       /* 0 = 用主题行高 */

    unsigned bg = 0, fg = 0, borderColor = 0, iconColor = 0;

    std::string name;
    std::string text;
    std::string tooltip;

    /* 图片控件: 保存原始编码数据, 每帧重建图片对象 */
    std::string imageData;
    std::string imageMime;

    std::vector<UiItem> items;
    std::vector<UiColumn> cols;
    std::vector<std::vector<std::string>> rows;

    int  selected = -1;        /* 列表/表格/下拉/标签页的选中索引 */
    int  hotIndex = -1;        /* 鼠标悬停项 */
    int  caret = 0;            /* 输入框光标(字节偏移) */

    bool hovered = false, pressed = false, focused = false;

    UiWidget* parent = nullptr;
    std::vector<UiWidget*> children;
};

/* ==================== 上下文 ==================== */

struct UiContext
{
    std::vector<UiWidget*> all;
    std::vector<UiWidget*> roots;

    std::vector<UiEvent> events;
    UiEvent current{};
    bool    hasCurrent = false;

    UiWidget* hovered = nullptr;
    UiWidget* pressed = nullptr;
    UiWidget* focused = nullptr;
    UiWidget* dragSlider = nullptr;
    UiWidget* dragScroll = nullptr;
    UiWidget* popup = nullptr;          /* 当前展开的下拉/菜单 */

    float dragStartY = 0, dragStartVal = 0, dragStartScroll = 0;
    float pressX = 0, pressY = 0;

    float mx = -1, my = -1;
    DWORD hoverSince = 0;
    int   cursorKind = 0;

    float viewW = 800, viewH = 600, scale = 1.0f;

    UiTheme theme = 深色主题();
    std::string fontName = "simhei";

    std::vector<void*> framePaints;
    void* canvas = nullptr;

    int nextId = 1;
    bool dirty = true;             /* 状态变化后置位, 由 uiw_take_dirty 消费 */

    ~UiContext()
    {
        for (auto* w : all) delete w;
    }
};

/* ==================== 查找与事件记录 ==================== */

UiWidget* 找控件(UiContext* c, int id)
{
    if (!c || id <= 0) return nullptr;
    for (auto* w : c->all) {
        if (w->id == id) return w;
    }
    return nullptr;
}

void 记录事件(UiContext* c, int kind, UiWidget* w, float value, int flag)
{
    UiEvent e;
    ::memset(&e, 0, sizeof(e));
    e.kind = kind;
    e.id = w ? w->id : 0;
    e.value = value;
    e.flag = flag;
    if (w) {
        拷名(e.name, UIW_NAME_MAX, w->name);
        拷名(e.text, UIW_TEXT_MAX, w->text);
    }
    c->events.push_back(e);
    c->dirty = true;
}

void 记录事件文本(UiContext* c, int kind, UiWidget* w, float value, int flag,
                   const std::string& 内容)
{
    UiEvent e;
    ::memset(&e, 0, sizeof(e));
    e.kind = kind;
    e.id = w ? w->id : 0;
    e.value = value;
    e.flag = flag;
    if (w) {
        拷名(e.name, UIW_NAME_MAX, w->name);
        拷名(e.text, UIW_TEXT_MAX, 内容);
    }
    c->events.push_back(e);
    c->dirty = true;
}

/* ==================== 文本测量 ==================== */

float 文字宽(UiContext* c, const std::string& s, float size)
{
    if (s.empty()) return 0.0f;
    void* t = thorgw_text_new();
    if (!t) return 0.0f;
    thorgw_text_font(t, c->fontName.c_str());
    thorgw_text_set(t, s.c_str());
    thorgw_text_size(t, size);
    float m[4] = {0, 0, 0, 0};
    float 宽 = 0.0f;
    if (thorgw_text_metrics(t, m) == 0) 宽 = m[3];
    thorgw_paint_free(t);
    return 宽;
}

/* 单字符宽度估算: ASCII 半角, 其余按全角 */
float 估算字宽(unsigned char 首字节, float 字号)
{
    return (首字节 < 0x80) ? (字号 * 0.62f) : (字号 * 1.16f);
}

/* 估算整段文本宽度: 与折行使用同一套估算, 保证截断/居中一致 */
float 估算文本宽(const std::string& s, float 字号)
{
    float 宽 = 0.0f;
    for (size_t i = 0; i < s.size(); ) {
        const unsigned char ch = (unsigned char)s[i];
        size_t 字节数 = 1;
        if ((ch & 0x80) == 0)                字节数 = 1;
        else if ((ch & 0xE0) == 0xC0)        字节数 = 2;
        else if ((ch & 0xF0) == 0xE0)        字节数 = 3;
        else                                 字节数 = 4;
        if (i + 字节数 > s.size()) 字节数 = 1;
        宽 += 估算字宽(ch, 字号);
        i += 字节数;
    }
    return 宽;
}

/* 按宽度折行: 先按换行符拆行, 再把超宽的行按字符拆开 */
void 排版文本(const std::string& 文本, float 字号, float 最大宽,
              std::vector<std::string>& 结果)
{
    结果.clear();
    std::string 当前;
    float 累计 = 0.0f;

    for (size_t i = 0; i < 文本.size(); ) {
        const unsigned char ch = (unsigned char)文本[i];
        if (ch == '\r') { ++i; continue; }
        if (ch == '\n') {
            结果.push_back(当前);
            当前.clear();
            累计 = 0.0f;
            ++i;
            continue;
        }
        size_t 字节数 = 1;
        if ((ch & 0x80) == 0)                字节数 = 1;
        else if ((ch & 0xE0) == 0xC0)        字节数 = 2;
        else if ((ch & 0xF0) == 0xE0)        字节数 = 3;
        else                                 字节数 = 4;
        if (i + 字节数 > 文本.size()) 字节数 = 1;

        const float 宽 = 估算字宽(ch, 字号);
        if (最大宽 > 0.0f && 累计 + 宽 > 最大宽 && !当前.empty()) {
            结果.push_back(当前);
            当前.clear();
            累计 = 0.0f;
        }
        当前.append(文本, i, 字节数);
        累计 += 宽;
        i += 字节数;
    }
    结果.push_back(当前);
}

/* 按字符截断, 超出部分用省略号 */
std::string 截断文字(UiContext* c, const std::string& s, float size, float maxW)
{
    (void)c;
    if (s.empty() || maxW <= 0) return std::string();
    if (估算文本宽(s, size) <= maxW) return s;

    const std::string 省略 = "..";
    const float 省略宽 = 估算文本宽(省略, size);
    const float 预算 = maxW - 省略宽;
    if (预算 <= 0) return 省略;

    std::string 结果;
    float 累计 = 0.0f;
    for (size_t i = 0; i < s.size(); ) {
        const unsigned char ch = (unsigned char)s[i];
        size_t 字节数 = 1;
        if ((ch & 0x80) == 0)                字节数 = 1;
        else if ((ch & 0xE0) == 0xC0)        字节数 = 2;
        else if ((ch & 0xF0) == 0xE0)        字节数 = 3;
        else                                 字节数 = 4;
        if (i + 字节数 > s.size()) 字节数 = 1;

        const float 片段宽 = 估算字宽(ch, size);
        if (累计 + 片段宽 > 预算) break;
        累计 += 片段宽;
        结果.append(s, i, 字节数);
        i += 字节数;
    }
    return 结果 + 省略;
}

/* 把多行文本按换行符拆成行, 并去掉回车 */
void 拆文本行(const std::string& 文本, std::vector<std::string>& 行)
{
    行.clear();
    std::string 当前;
    for (size_t i = 0; i < 文本.size(); ++i) {
        const char c = 文本[i];
        if (c == '\r') continue;
        if (c == '\n') {
            行.push_back(当前);
            当前.clear();
        } else {
            当前 += c;
        }
    }
    行.push_back(当前);
}

/* 按字节偏移量估算前缀宽度(用于输入框光标定位) */
float 前缀宽(UiContext* c, const std::string& s, size_t bytes, float size)
{
    if (bytes == 0) return 0.0f;
    if (bytes > s.size()) bytes = s.size();
    return 文字宽(c, s.substr(0, bytes), size);
}

/* 根据点击横坐标求最近的字符偏移 */
int 横坐标转光标(UiContext* c, const std::string& s, float size, float dx)
{
    if (dx <= 0) return 0;
    float 累计 = 0.0f;
    size_t i = 0;
    while (i < s.size()) {
        const unsigned char ch = (unsigned char)s[i];
        size_t 字节数 = 1;
        if ((ch & 0x80) == 0)                字节数 = 1;
        else if ((ch & 0xE0) == 0xC0)        字节数 = 2;
        else if ((ch & 0xF0) == 0xE0)        字节数 = 3;
        else                                 字节数 = 4;
        if (i + 字节数 > s.size()) 字节数 = 1;

        const float 片段宽 = 文字宽(c, s.substr(i, 字节数), size);
        if (dx < 累计 + 片段宽 * 0.5f) return (int)i;
        累计 += 片段宽;
        i += 字节数;
    }
    return (int)s.size();
}

void 退一字符(std::string& s, int& caret)
{
    if (caret <= 0 || s.empty()) { caret = 0; return; }
    int i = caret - 1;
    while (i > 0 && ((unsigned char)s[i] & 0xC0) == 0x80) --i;
    s.erase((size_t)i, (size_t)(caret - i));
    caret = i;
}

void 进一字符(const std::string& s, int& caret)
{
    if (caret >= (int)s.size()) { caret = (int)s.size(); return; }
    int i = caret + 1;
    while (i < (int)s.size() && ((unsigned char)s[i] & 0xC0) == 0x80) ++i;
    caret = i;
}

void 追加UTF8(std::string& s, int& caret, unsigned cp)
{
    std::string 片段;
    if (cp < 0x80) {
        片段 += (char)cp;
    } else if (cp < 0x800) {
        片段 += (char)(0xC0 | (cp >> 6));
        片段 += (char)(0x80 | (cp & 0x3F));
    } else if (cp < 0x10000) {
        片段 += (char)(0xE0 | (cp >> 12));
        片段 += (char)(0x80 | ((cp >> 6) & 0x3F));
        片段 += (char)(0x80 | (cp & 0x3F));
    } else {
        片段 += (char)(0xF0 | (cp >> 18));
        片段 += (char)(0x80 | ((cp >> 12) & 0x3F));
        片段 += (char)(0x80 | ((cp >> 6) & 0x3F));
        片段 += (char)(0x80 | (cp & 0x3F));
    }
    if (caret < 0 || caret > (int)s.size()) caret = (int)s.size();
    s.insert((size_t)caret, 片段);
    caret += (int)片段.size();
}

/* ==================== 自动尺寸 ==================== */

void 自动尺寸(UiContext* c, UiWidget* w)
{
    for (auto* ch : w->children) 自动尺寸(c, ch);

    const float 字 = (w->fontSize > 0) ? w->fontSize : c->theme.fontSize;
    const float 行高 = c->theme.rowHeight;

    if (w->dw > 0 && w->dh > 0) return;

    switch (w->kind) {
        case UIW_LABEL:
        case UIW_LINK: {
            if (w->dw <= 0) w->dw = 估算文本宽(w->text, 字) + w->padL + w->padR;
            if (w->dh <= 0) w->dh = 字 * 1.7f + w->padT + w->padB;
            break;
        }
        case UIW_BADGE: {
            if (w->dw <= 0) w->dw = 估算文本宽(w->text, 字 * 0.82f) + w->padL + w->padR + 4.0f;
            if (w->dh <= 0) w->dh = 字 * 1.35f + w->padT + w->padB;
            break;
        }
        case UIW_BUTTON: {
            if (w->dw <= 0) {
                w->dw = 估算文本宽(w->text, 字) + w->padL + w->padR + 20.0f;
                if (w->icon) w->dw += 字 + 6.0f;
            }
            if (w->dh <= 0) w->dh = 行高;
            break;
        }
        case UIW_CHECKBOX:
        case UIW_RADIO: {
            if (w->dw <= 0) w->dw = 估算文本宽(w->text, 字) + w->padL + w->padR + 24.0f;
            if (w->dh <= 0) w->dh = std::max(行高 * 0.85f, 字 * 1.9f);
            break;
        }
        case UIW_TOGGLE: {
            if (w->dw <= 0) w->dw = 44.0f;
            if (w->dh <= 0) w->dh = 24.0f;
            break;
        }
        case UIW_SEPARATOR: {
            if (w->dw <= 0) w->dw = 100.0f;
            if (w->dh <= 0) w->dh = 1.0f;
            break;
        }
        case UIW_SLIDER: {
            if (w->dw <= 0) w->dw = 200.0f;
            if (w->dh <= 0) w->dh = 26.0f;
            break;
        }
        case UIW_PROGRESS: {
            if (w->dw <= 0) w->dw = 200.0f;
            if (w->dh <= 0) w->dh = 10.0f;
            break;
        }
        case UIW_SPIN: {
            if (w->dw <= 0) w->dw = 96.0f;
            if (w->dh <= 0) w->dh = 行高;
            break;
        }
        case UIW_EDIT:
        case UIW_COMBO:
        case UIW_MENU: {
            if (w->dw <= 0) w->dw = 180.0f;
            if (w->dh <= 0) w->dh = 行高;
            break;
        }
        case UIW_MULTIEDIT: {
            if (w->dw <= 0) w->dw = 260.0f;
            if (w->dh <= 0) w->dh = 行高 * (float)std::max(1, w->visibleRows > 0 ? w->visibleRows : 4);
            break;
        }
        case UIW_LIST: {
            if (w->dw <= 0) w->dw = 200.0f;
            if (w->dh <= 0) w->dh = std::max(80.0f, 行高 * (float)std::min((int)w->items.size(), 6));
            break;
        }
        case UIW_TABLE: {
            if (w->dw <= 0) w->dw = 360.0f;
            if (w->dh <= 0) w->dh = 行高 * 6.0f;
            break;
        }
        case UIW_IMAGE: {
            if (w->dw <= 0) w->dw = 120.0f;
            if (w->dh <= 0) w->dh = 90.0f;
            break;
        }
        case UIW_SCROLLBAR: {
            if (w->dw <= 0) w->dw = 8.0f;
            if (w->dh <= 0) w->dh = 100.0f;
            break;
        }
        default: {
            if (w->dw <= 0) w->dw = 200.0f;
            if (w->dh <= 0) w->dh = 行高 * 3.0f;
            break;
        }
    }
}

/* ==================== 布局 ==================== */

bool 可滚动(UiWidget* w)
{
    return w->scrollMax > 0.5f;
}

void 排布局(UiContext* c, UiWidget* w)
{
    if (!w->visible) return;

    for (auto* ch : w->children) 自动尺寸(c, ch);

    float 内x = w->x + w->padL;
    float 内y = w->y + w->padT;
    const float 内w = std::max(0.0f, w->w - w->padL - w->padR);
    float 内h = std::max(0.0f, w->h - w->padT - w->padB);

    /* 标签页: 顶部留出标签条 */
    if (w->kind == UIW_TABS) {
        const float 条高 = c->theme.rowHeight;
        内y += 条高;
        内h = std::max(0.0f, 内h - 条高);
    }

    int 可见数 = 0;
    for (auto* ch : w->children) if (ch->visible) ++可见数;

    switch (w->layout) {
        case UIL_ABSOLUTE: {
            for (auto* ch : w->children) {
                if (!ch->visible) continue;
                ch->x = 内x + ch->dx + ch->marginL;
                ch->y = 内y + ch->dy + ch->marginT;
                if (ch->dw > 0) ch->w = ch->dw;
                if (ch->dh > 0) ch->h = ch->dh;
                ch->w = std::max(0.0f, ch->w - ch->marginL - ch->marginR);
                ch->h = std::max(0.0f, ch->h - ch->marginT - ch->marginB);
            }
            w->scrollMax = 0;
            break;
        }
        case UIL_STACK: {
            for (auto* ch : w->children) {
                if (!ch->visible) continue;
                ch->x = 内x + ch->marginL;
                ch->y = 内y + ch->marginT;
                ch->w = std::max(0.0f, 内w - ch->marginL - ch->marginR);
                ch->h = std::max(0.0f, 内h - ch->marginT - ch->marginB);
            }
            w->scrollMax = 0;
            break;
        }
        case UIL_HORIZONTAL: {
            float 固定 = 0, 权重和 = 0;
            for (auto* ch : w->children) {
                if (!ch->visible) continue;
                if (ch->weight > 0) 权重和 += ch->weight;
                else 固定 += ch->dw + ch->marginL + ch->marginR;
            }
            const float 间隔总 = w->spacing * (float)std::max(0, 可见数 - 1);
            const float 剩余 = std::max(0.0f, 内w - 固定 - 间隔总);

            float cx = 内x - w->scroll;
            for (auto* ch : w->children) {
                if (!ch->visible) continue;
                float 宽 = (ch->weight > 0)
                         ? (权重和 > 0 ? 剩余 * ch->weight / 权重和 : 0.0f)
                         : ch->dw;
                ch->x = cx + ch->marginL;
                ch->y = 内y + ch->marginT;
                ch->w = std::max(0.0f, 宽 - ch->marginL - ch->marginR);
                ch->h = std::max(0.0f, (ch->dh > 0 ? ch->dh : 内h) - ch->marginT - ch->marginB);
                cx += 宽 + w->spacing;
            }
            const float 内容 = cx + w->scroll - 内x - w->spacing;
            w->scrollMax = std::max(0.0f, 内容 - 内w);
            w->scroll = 夹取(w->scroll, 0.0f, w->scrollMax);
            break;
        }
        case UIL_VERTICAL: {
            float 固定 = 0, 权重和 = 0;
            for (auto* ch : w->children) {
                if (!ch->visible) continue;
                if (ch->weight > 0) 权重和 += ch->weight;
                else 固定 += ch->dh + ch->marginT + ch->marginB;
            }
            const float 间隔总 = w->spacing * (float)std::max(0, 可见数 - 1);
            const float 剩余 = std::max(0.0f, 内h - 固定 - 间隔总);

            float cy = 内y - w->scroll;
            for (auto* ch : w->children) {
                if (!ch->visible) continue;
                float 高 = (ch->weight > 0)
                         ? (权重和 > 0 ? 剩余 * ch->weight / 权重和 : 0.0f)
                         : ch->dh;
                ch->x = 内x + ch->marginL;
                ch->y = cy + ch->marginT;
                ch->w = std::max(0.0f, (ch->dw > 0 ? ch->dw : 内w) - ch->marginL - ch->marginR);
                ch->h = std::max(0.0f, 高 - ch->marginT - ch->marginB);
                cy += 高 + w->spacing;
            }
            const float 内容 = cy + w->scroll - 内y - w->spacing;
            w->scrollMax = std::max(0.0f, 内容 - 内h);
            w->scroll = 夹取(w->scroll, 0.0f, w->scrollMax);
            break;
        }
        case UIL_GRID: {
            const int 列 = std::max(1, w->gridCols);
            const float 格宽 = (内w - w->spacing * (float)(列 - 1)) / (float)列;
            float 行高值 = 0;
            for (auto* ch : w->children) {
                if (!ch->visible) continue;
                行高值 = std::max(行高值, ch->dh + ch->marginT + ch->marginB);
            }
            if (行高值 <= 0) 行高值 = c->theme.rowHeight;

            int i = 0;
            for (auto* ch : w->children) {
                if (!ch->visible) continue;
                const int r = i / 列, cc = i % 列;
                ch->x = 内x + (float)cc * (格宽 + w->spacing) + ch->marginL;
                ch->y = 内y + (float)r * (行高值 + w->spacing) - w->scroll + ch->marginT;
                ch->w = std::max(0.0f, 格宽 - ch->marginL - ch->marginR);
                ch->h = std::max(0.0f, 行高值 - ch->marginT - ch->marginB);
                ++i;
            }
            const int 行数 = (i + 列 - 1) / 列;
            const float 内容 = (float)行数 * (行高值 + w->spacing) - w->spacing;
            w->scrollMax = std::max(0.0f, 内容 - 内h);
            w->scroll = 夹取(w->scroll, 0.0f, w->scrollMax);
            break;
        }
        default:
            break;
    }

    /* 内容型控件: 计算自身滚动范围 */
    if (w->kind == UIW_LIST) {
        const float 行高 = (w->rowHeight > 0.0f) ? w->rowHeight : c->theme.rowHeight;
        const float 内容 = (float)w->items.size() * 行高 + 4.0f;
        w->scrollMax = std::max(0.0f, 内容 - (w->h - 4.0f));
        w->scroll = 夹取(w->scroll, 0.0f, w->scrollMax);
    } else if (w->kind == UIW_TABLE) {
        const float 行高 = (w->rowHeight > 0.0f) ? w->rowHeight : c->theme.rowHeight;
        const float 内容 = (float)w->rows.size() * 行高;
        const float 可视 = std::max(0.0f, w->h - 行高 - 2.0f);
        w->scrollMax = std::max(0.0f, 内容 - 可视);
        w->scroll = 夹取(w->scroll, 0.0f, w->scrollMax);
    } else if (w->kind == UIW_MULTIEDIT) {
        const float 字 = (w->fontSize > 0.0f) ? w->fontSize : c->theme.fontSize;
        std::vector<std::string> 行;
        排版文本(w->text, 字, std::max(20.0f, w->w - 18.0f), 行);
        const float 内容 = (float)行.size() * 字 * 1.45f + 10.0f;
        w->scrollMax = std::max(0.0f, 内容 - (w->h - 10.0f));
        w->scroll = 夹取(w->scroll, 0.0f, w->scrollMax);
    }

    for (auto* ch : w->children) 排布局(c, ch);
}

/* 标签页只显示选中的那一页 */
void 同步标签页(UiWidget* w)
{
    if (w->kind != UIW_TABS) return;
    for (size_t i = 0; i < w->children.size(); ++i) {
        w->children[i]->visible = ((int)i == w->selected);
    }
}

/* ==================== 命中测试 ==================== */

bool 在矩形内(UiWidget* w, float x, float y)
{
    return x >= w->x && y >= w->y && x <= w->x + w->w && y <= w->y + w->h;
}

UiWidget* 命中(UiWidget* w, float x, float y)
{
    if (!w->visible) return nullptr;
    if (!在矩形内(w, x, y)) return nullptr;

    for (int i = (int)w->children.size() - 1; i >= 0; --i) {
        if (auto* r = 命中(w->children[i], x, y)) return r;
    }
    return w;
}

UiWidget* 顶层命中(UiContext* c, float x, float y)
{
    for (int i = (int)c->roots.size() - 1; i >= 0; --i) {
        if (auto* r = 命中(c->roots[i], x, y)) return r;
    }
    return nullptr;
}

UiWidget* 可滚动祖先(UiWidget* w)
{
    for (UiWidget* p = w; p; p = p->parent) {
        if (可滚动(p)) return p;
    }
    return nullptr;
}

bool 可聚焦(UiWidget* w)
{
    if (!w || !w->enabled || !w->visible) return false;
    switch (w->kind) {
        case UIW_BUTTON: case UIW_CHECKBOX: case UIW_RADIO: case UIW_SLIDER:
        case UIW_EDIT: case UIW_MULTIEDIT: case UIW_COMBO: case UIW_TOGGLE:
        case UIW_SPIN: case UIW_LIST: case UIW_TABLE: case UIW_TABS:
        case UIW_LINK: case UIW_MENU: return true;
        default: return false;
    }
}

/* 弹出浮层矩形(下拉框/菜单) */
bool 浮层矩形(UiContext* c, UiWidget* w, float& ox, float& oy, float& ow, float& oh)
{
    if (!w || !w->expanded) return false;
    if (w->kind != UIW_COMBO && w->kind != UIW_MENU) return false;

    const int 条数 = (int)w->items.size();
    if (条数 <= 0) return false;

    const float 行高 = (w->rowHeight > 0) ? w->rowHeight : c->theme.rowHeight;
    ox = w->x;
    ow = w->w;

    /* 空间不足时向上展开 */
    const float 需要 = 行高 * (float)条数 + 6.0f;
    if (w->y + w->h + 需要 > c->viewH && w->y > 需要) {
        oy = w->y - 需要;
    } else {
        oy = w->y + w->h;
    }
    oh = 需要;
    return true;
}

} /* namespace */
/* ==================== 绘制 ==================== */

namespace
{

void 加对象(UiContext* c, void* p)
{
    if (!p) return;
    if (!c->canvas) { thorgw_paint_free(p); return; }
    thorgw_canvas_add(c->canvas, p);
    c->framePaints.push_back(p);
}

void 圆角矩形(UiContext* c, float x, float y, float w, float h, float r, unsigned color)
{
    if (w <= 0.0f || h <= 0.0f) return;
    int cr, cg, cb, ca;
    拆色(color, cr, cg, cb, ca);
    if (ca == 0) return;
    void* s = thorgw_shape_new();
    if (!s) return;
    const float 半径 = std::min(r, std::min(w, h) * 0.5f);
    thorgw_shape_append_rect(s, x, y, w, h, 半径, 半径);
    thorgw_shape_fill(s, cr, cg, cb, ca);
    加对象(c, s);
}

void 描边矩形(UiContext* c, float x, float y, float w, float h, float r,
              unsigned color, float width)
{
    if (w <= 0.0f || h <= 0.0f || width <= 0.0f) return;
    int cr, cg, cb, ca;
    拆色(color, cr, cg, cb, ca);
    if (ca == 0) return;
    void* s = thorgw_shape_new();
    if (!s) return;
    const float 半径 = std::min(r, std::min(w, h) * 0.5f);
    thorgw_shape_append_rect(s, x + width * 0.5f, y + width * 0.5f,
                             w - width, h - width, 半径, 半径);
    thorgw_shape_stroke_fill(s, cr, cg, cb, ca);
    thorgw_shape_stroke_width(s, width);
    加对象(c, s);
}

void 画线(UiContext* c, float x1, float y1, float x2, float y2,
          unsigned color, float width)
{
    int cr, cg, cb, ca;
    拆色(color, cr, cg, cb, ca);
    if (ca == 0) return;
    void* s = thorgw_shape_new();
    if (!s) return;
    thorgw_shape_move_to(s, x1, y1);
    thorgw_shape_line_to(s, x2, y2);
    thorgw_shape_stroke_fill(s, cr, cg, cb, ca);
    thorgw_shape_stroke_width(s, width);
    thorgw_shape_stroke_cap(s, 1);
    加对象(c, s);
}

void 画圆(UiContext* c, float cx, float cy, float r, unsigned color, bool 填充)
{
    if (r <= 0.0f) return;
    int cr, cg, cb, ca;
    拆色(color, cr, cg, cb, ca);
    if (ca == 0) return;
    void* s = thorgw_shape_new();
    if (!s) return;
    thorgw_shape_append_circle(s, cx, cy, r, r);
    if (填充) {
        thorgw_shape_fill(s, cr, cg, cb, ca);
    } else {
        thorgw_shape_stroke_fill(s, cr, cg, cb, ca);
        thorgw_shape_stroke_width(s, 1.5f);
    }
    加对象(c, s);
}

void 画三角(UiContext* c, float cx, float cy, float size, int 方向, unsigned color)
{
    int cr, cg, cb, ca;
    拆色(color, cr, cg, cb, ca);
    if (ca == 0) return;
    const float h = size * 0.5f;
    float xy[6];
    switch (方向) {
        case 0: /* 下 */ xy[0] = cx - h; xy[1] = cy - h * 0.5f;
                xy[2] = cx + h; xy[3] = cy - h * 0.5f;
                xy[4] = cx;     xy[5] = cy + h * 0.7f; break;
        case 1: /* 上 */ xy[0] = cx - h; xy[1] = cy + h * 0.5f;
                xy[2] = cx + h; xy[3] = cy + h * 0.5f;
                xy[4] = cx;     xy[5] = cy - h * 0.7f; break;
        case 2: /* 右 */ xy[0] = cx - h * 0.5f; xy[1] = cy - h;
                xy[2] = cx - h * 0.5f; xy[3] = cy + h;
                xy[4] = cx + h * 0.7f; xy[5] = cy; break;
        default: /* 左 */ xy[0] = cx + h * 0.5f; xy[1] = cy - h;
                xy[2] = cx + h * 0.5f; xy[3] = cy + h;
                xy[4] = cx - h * 0.7f; xy[5] = cy; break;
    }
    void* s = thorgw_shape_new();
    if (!s) return;
    thorgw_shape_append_polygon(s, xy, 3, 1);
    thorgw_shape_fill(s, cr, cg, cb, ca);
    加对象(c, s);
}

void 渐变矩形(UiContext* c, float x, float y, float w, float h, float r,
              unsigned 起, unsigned 止, bool 垂直)
{
    if (w <= 0.0f || h <= 0.0f) return;
    void* g = thorgw_linear_new();
    if (!g) return;
    if (垂直) thorgw_linear_set(g, x, y, x, y + h);
    else      thorgw_linear_set(g, x, y, x + w, y);

    int r1, g1, b1, a1, r2, g2, b2, a2;
    拆色(起, r1, g1, b1, a1);
    拆色(止, r2, g2, b2, a2);
    const float stops[10] = {
        0.0f, (float)r1, (float)g1, (float)b1, (float)a1,
        1.0f, (float)r2, (float)g2, (float)b2, (float)a2
    };
    thorgw_gradient_stops(g, stops, 2);

    void* s = thorgw_shape_new();
    if (!s) { thorgw_gradient_free(g); return; }
    const float 半径 = std::min(r, std::min(w, h) * 0.5f);
    thorgw_shape_append_rect(s, x, y, w, h, 半径, 半径);
    if (thorgw_shape_fill_gradient(s, g) != 0) {
        thorgw_gradient_free(g);
        thorgw_paint_free(s);
        return;
    }
    加对象(c, s);
}

void 画文字(UiContext* c, const std::string& s, float x, float y, float w, float h,
            float size, unsigned color, int ha, int va, int wrap)
{
    if (s.empty()) return;
    int cr, cg, cb, ca;
    拆色(color, cr, cg, cb, ca);
    if (ca == 0) return;

    void* t = thorgw_text_new();
    if (!t) return;
    thorgw_text_font(t, c->fontName.c_str());
    thorgw_text_set(t, s.c_str());
    thorgw_text_size(t, size);
    thorgw_text_fill(t, cr, cg, cb);
    if (ca < 255) thorgw_paint_opacity(t, ca);
    if (w > 0.0f && h > 0.0f) {
        if (wrap > 0) thorgw_text_wrap(t, wrap);
        thorgw_text_layout(t, w, h);
        const float hx = (ha == UIA_CENTER) ? 0.5f : ((ha == UIA_RIGHT) ? 1.0f : 0.0f);
        const float vy = (va == UIV_MIDDLE) ? 0.5f : ((va == UIV_BOTTOM) ? 1.0f : 0.0f);
        thorgw_text_align(t, hx, vy);
    }
    thorgw_paint_translate(t, x, y);
    加对象(c, t);
}

/* 按矩形区域居中绘制一行文字, 自动截断 */
void 画单行(UiContext* c, const std::string& s, float x, float y, float w, float h,
            float size, unsigned color, int ha)
{
    if (s.empty() || w <= 0.0f) return;
    const std::string 显示 = 截断文字(c, s, size, w);
    const float 宽 = std::min(w, 估算文本宽(显示, size));
    float 起 = x;
    if (ha == UIA_CENTER)     起 = x + (w - 宽) * 0.5f;
    else if (ha == UIA_RIGHT) 起 = x + (w - 宽);
    画文字(c, 显示, 起, y + (h - size * 1.32f) * 0.5f, 0, 0, size,
           color, UIA_LEFT, UIV_TOP, 0);
}

void 画文字框(UiContext* c, const std::string& s, float x, float y, float w, float h,
              float size, unsigned color, int ha, int va, int wrap)
{
    if (s.empty() || w <= 0.0f || h <= 0.0f) return;
    画文字(c, s, x, y, w, h, size, color, ha, va, wrap);
}

/* ==================== 内置图标 ==================== */

void 画图标(UiContext* c, int icon, float cx, float cy, float size, unsigned color)
{
    if (icon <= UII_NONE || size <= 0.0f) return;
    const float h = size * 0.5f;
    const float 线宽 = std::max(1.5f, size * 0.12f);

    switch (icon) {
        case UII_CHECK:
            画线(c, cx - h * 0.75f, cy, cx - h * 0.15f, cy + h * 0.6f, color, 线宽);
            画线(c, cx - h * 0.15f, cy + h * 0.6f, cx + h * 0.8f, cy - h * 0.6f, color, 线宽);
            break;
        case UII_CROSS:
        case UII_CLOSE:
            画线(c, cx - h * 0.6f, cy - h * 0.6f, cx + h * 0.6f, cy + h * 0.6f, color, 线宽);
            画线(c, cx + h * 0.6f, cy - h * 0.6f, cx - h * 0.6f, cy + h * 0.6f, color, 线宽);
            break;
        case UII_DOWN: 画三角(c, cx, cy, size * 0.62f, 0, color); break;
        case UII_UP:   画三角(c, cx, cy, size * 0.62f, 1, color); break;
        case UII_RIGHT:画三角(c, cx, cy, size * 0.62f, 2, color); break;
        case UII_LEFT: 画三角(c, cx, cy, size * 0.62f, 3, color); break;
        case UII_PLUS:
            画线(c, cx - h * 0.7f, cy, cx + h * 0.7f, cy, color, 线宽);
            画线(c, cx, cy - h * 0.7f, cx, cy + h * 0.7f, color, 线宽);
            break;
        case UII_MINUS:
            画线(c, cx - h * 0.7f, cy, cx + h * 0.7f, cy, color, 线宽);
            break;
        case UII_DOT:
            画圆(c, cx, cy, size * 0.22f, color, true);
            break;
        case UII_STAR: {
            int cr, cg, cb, ca;
            拆色(color, cr, cg, cb, ca);
            void* s = thorgw_shape_new();
            if (s) {
                thorgw_shape_append_star(s, cx, cy, h, h * 0.44f, 5);
                thorgw_shape_fill(s, cr, cg, cb, ca);
                加对象(c, s);
            }
            break;
        }
        case UII_MENU:
            画线(c, cx - h * 0.8f, cy - h * 0.55f, cx + h * 0.8f, cy - h * 0.55f, color, 线宽);
            画线(c, cx - h * 0.8f, cy, cx + h * 0.8f, cy, color, 线宽);
            画线(c, cx - h * 0.8f, cy + h * 0.55f, cx + h * 0.8f, cy + h * 0.55f, color, 线宽);
            break;
        case UII_SEARCH:
            画圆(c, cx - h * 0.15f, cy - h * 0.15f, h * 0.55f, color, false);
            画线(c, cx + h * 0.26f, cy + h * 0.26f, cx + h * 0.78f, cy + h * 0.78f, color, 线宽);
            break;
        case UII_GEAR:
            画圆(c, cx, cy, h * 0.62f, color, false);
            画圆(c, cx, cy, h * 0.24f, color, true);
            break;
        case UII_HOME: {
            float xy[8] = { cx - h * 0.8f, cy + h * 0.1f,
                            cx, cy - h * 0.75f,
                            cx + h * 0.8f, cy + h * 0.1f,
                            cx - h * 0.8f, cy + h * 0.1f };
            int cr, cg, cb, ca;
            拆色(color, cr, cg, cb, ca);
            void* s = thorgw_shape_new();
            if (s) {
                thorgw_shape_append_polygon(s, xy, 4, 1);
                thorgw_shape_fill(s, cr, cg, cb, ca);
                加对象(c, s);
            }
            画圆(c, cx, cy + h * 0.3f, h * 0.35f, color, true);
            break;
        }
        case UII_INFO:
            画圆(c, cx, cy, h * 0.85f, color, false);
            画圆(c, cx, cy - h * 0.42f, h * 0.12f, color, true);
            画线(c, cx, cy - h * 0.1f, cx, cy + h * 0.45f, color, 线宽);
            break;
        case UII_WARN: {
            float xy[6] = { cx, cy - h * 0.85f, cx + h * 0.9f, cy + h * 0.7f,
                            cx - h * 0.9f, cy + h * 0.7f };
            int cr, cg, cb, ca;
            拆色(color, cr, cg, cb, ca);
            void* s = thorgw_shape_new();
            if (s) {
                thorgw_shape_append_polygon(s, xy, 3, 1);
                thorgw_shape_stroke_fill(s, cr, cg, cb, ca);
                thorgw_shape_stroke_width(s, 线宽);
                thorgw_shape_stroke_join(s, 1);
                加对象(c, s);
            }
            画线(c, cx, cy - h * 0.2f, cx, cy + h * 0.2f, color, 线宽);
            画圆(c, cx, cy + h * 0.45f, h * 0.1f, color, true);
            break;
        }
        default:
            break;
    }
}

/* ==================== 滚动条 ==================== */

void 画滚动条(UiContext* c, UiWidget* w)
{
    if (!可滚动(w)) return;
    if (w->w < 24.0f || w->h < 24.0f) return;

    const float 条宽 = 6.0f;
    const float 轨x = w->x + w->w - 条宽 - 3.0f;
    const float 轨y = w->y + w->padT + 2.0f;
    const float 轨高 = w->h - w->padT - w->padB - 4.0f;
    if (轨高 <= 10.0f) return;

    圆角矩形(c, 轨x, 轨y, 条宽, 轨高, 条宽 * 0.5f, c->theme.surfaceLo);

    const float 可见 = std::max(1.0f, 轨高 * (轨高 / (轨高 + w->scrollMax)));
    const float 柄高 = std::max(18.0f, 可见);
    const float 行程 = 轨高 - 柄高;
    float 比例 = (w->scrollMax > 0) ? (w->scroll / w->scrollMax) : 0.0f;
    比例 = 夹取(比例, 0.0f, 1.0f);

    const unsigned 柄色 = w->focused ? c->theme.accent : c->theme.fgDim;
    圆角矩形(c, 轨x, 轨y + 行程 * 比例, 条宽, 柄高, 条宽 * 0.5f, 柄色);
}

/* ==================== 各控件绘制 ==================== */

void 绘制控件(UiContext* c, UiWidget* w);

void 绘制子控件(UiContext* c, UiWidget* w)
{
    for (auto* ch : w->children) 绘制控件(c, ch);
}

void 画列表内容(UiContext* c, UiWidget* w, float 区x, float 区y, float 区w, float 区h,
                float 行高, bool 带勾选)
{
    const int 总数 = (int)w->items.size();
    if (总数 <= 0) return;

    const int 首行 = std::max(0, (int)std::floor(w->scroll / 行高));
    const int 可见 = (int)std::ceil(区h / 行高) + 1;

    for (int i = 首行; i < 总数 && i < 首行 + 可见; ++i) {
        const float iy = 区y + (float)i * 行高 - w->scroll;
        if (iy + 行高 < 区y - 1.0f) continue;
        if (iy > 区y + 区h + 1.0f) break;

        const bool 选中 = (i == w->selected);
        const bool 悬停 = (i == w->hotIndex) && w->enabled;

        if (选中) {
            圆角矩形(c, 区x + 1.0f, iy, 区w - 8.0f, 行高, 3.0f, c->theme.select);
            圆角矩形(c, 区x + 1.0f, iy + 1.0f, 3.0f, 行高 - 2.0f, 1.5f, c->theme.accent);
        } else if (悬停) {
            圆角矩形(c, 区x + 1.0f, iy, 区w - 8.0f, 行高, 3.0f, c->theme.surfaceHi);
        }

        float 文字x = 区x + 8.0f;
        const float 文字w = 区w - 18.0f;

        if (带勾选) {
            const float 盒 = std::min(13.0f, 行高 - 6.0f);
            const float 盒x = 区x + 5.0f;
            const float 盒y = iy + (行高 - 盒) * 0.5f;
            圆角矩形(c, 盒x, 盒y, 盒, 盒, 2.0f,
                     w->items[(size_t)i].checked ? c->theme.accent : c->theme.surface);
            描边矩形(c, 盒x, 盒y, 盒, 盒, 2.0f,
                     w->items[(size_t)i].checked ? c->theme.accent : c->theme.border, 1.0f);
            if (w->items[(size_t)i].checked)
                画图标(c, UII_CHECK, 盒x + 盒 * 0.5f, 盒y + 盒 * 0.5f, 盒 * 0.8f, c->theme.accentFg);
            文字x = 盒x + 盒 + 7.0f;
        }

        const unsigned 色 = !w->enabled ? c->theme.disabled : c->theme.fg;
        const float 字号 = (w->fontSize > 0) ? w->fontSize : c->theme.fontSize;
        画单行(c, w->items[(size_t)i].text, 文字x, iy, 文字w, 行高, 字号, 色, UIA_LEFT);
    }
}

void 绘制控件(UiContext* c, UiWidget* w)
{
    if (!w->visible) return;
    if (w->w <= 0.0f || w->h <= 0.0f) return;


    const UiTheme& th = c->theme;
    const float r = (w->radius >= 0.0f) ? w->radius : th.radius;
    const float 字 = (w->fontSize > 0.0f) ? w->fontSize : th.fontSize;
    const float 行高 = (w->rowHeight > 0.0f) ? w->rowHeight : th.rowHeight;
    const float 边宽 = (w->borderWidth > 0.0f) ? w->borderWidth : th.borderWidth;
    const unsigned fg = w->fg ? w->fg : th.fg;
    const unsigned 边色 = w->borderColor ? w->borderColor : th.border;
    const float x = w->x, y = w->y, ww = w->w, hh = w->h;

    switch (w->kind) {
        case UIW_PANEL: {
            const unsigned bg = w->bg ? w->bg : th.bg;
            if (r > 0.0f) 圆角矩形(c, x, y, ww, hh, r, bg);
            else          圆角矩形(c, x, y, ww, hh, 0.0f, bg);
            if (w->borderColor) 描边矩形(c, x, y, ww, hh, r, 边色, 边宽);
            绘制子控件(c, w);
            画滚动条(c, w);
            return;
        }
        case UIW_CARD: {
            /* 投影: 两层半透明偏移矩形模拟 */
            圆角矩形(c, x + 1.0f, y + 2.0f, ww, hh, r + 1.0f, 设透明度(th.shadow, 0.10f));
            圆角矩形(c, x, y + 1.0f, ww, hh, r + 1.0f, 设透明度(th.shadow, 0.16f));
            圆角矩形(c, x, y, ww, hh, r, w->bg ? w->bg : th.surface);
            描边矩形(c, x, y, ww, hh, r, 边色, 边宽);
            绘制子控件(c, w);
            画滚动条(c, w);
            return;
        }
        case UIW_GROUP: {
            const float 标题高 = std::max(16.0f, 字 * 1.5f);
            const float 标题宽 = w->text.empty() ? 0.0f : 估算文本宽(w->text, 字) + 16.0f;
            圆角矩形(c, x, y + 标题高 * 0.5f, ww, hh - 标题高 * 0.5f, r,
                     w->bg ? w->bg : th.surface);
            描边矩形(c, x, y + 标题高 * 0.5f, ww, hh - 标题高 * 0.5f, r, 边色, 边宽);
            if (!w->text.empty()) {
                /* 标题背景挖空, 让框线在标题处断开 */
                圆角矩形(c, x + 10.0f, y + 1.0f, 标题宽, 标题高 - 2.0f, 2.0f,
                         w->bg ? w->bg : th.surface);
                画文字框(c, w->text, x + 14.0f, y + 1.0f, 标题宽, 标题高 - 2.0f,
                         字, w->enabled ? fg : th.disabled, UIA_LEFT, UIV_MIDDLE, 0);
            }
            绘制子控件(c, w);
            画滚动条(c, w);
            return;
        }
        case UIW_LABEL: {
            const unsigned col = w->enabled ? fg : th.disabled;
            画文字框(c, w->text, x + w->padL, y + w->padT,
                     ww - w->padL - w->padR, hh - w->padT - w->padB,
                     字, col, w->align, w->valign, w->wrapMode);
            return;
        }
        case UIW_LINK: {
            const unsigned col = !w->enabled ? th.disabled
                               : (w->hovered ? th.accent : 混色(th.accent, th.fg, 0.25f));
            画文字框(c, w->text, x + w->padL, y + w->padT,
                     ww - w->padL - w->padR, hh - w->padT - w->padB,
                     字, col, w->align, w->valign, w->wrapMode);
            if (w->hovered && w->enabled) {
                const float 宽 = std::min(ww - w->padL - w->padR,
                                          文字宽(c, w->text, 字));
                const float 下划x = (w->align == UIA_CENTER) ? x + (ww - 宽) * 0.5f
                                  : ((w->align == UIA_RIGHT) ? x + ww - 宽 - w->padR
                                                            : x + w->padL);
                画线(c, 下划x, y + hh * 0.5f + 字 * 0.62f, 下划x + 宽,
                     y + hh * 0.5f + 字 * 0.62f, col, 1.0f);
            }
            return;
        }
        case UIW_BADGE: {
            const unsigned bg = w->bg ? w->bg : th.accent;
            const unsigned col = w->fg ? w->fg : th.accentFg;
            const float 圆 = hh * 0.5f;
            圆角矩形(c, x, y, ww, hh, 圆, bg);
            if (!w->icon) {
                画文字框(c, w->text, x + 4.0f, y, ww - 8.0f, hh,
                         字 * 0.82f, col, UIA_CENTER, UIV_MIDDLE, 0);
            } else {
                画图标(c, w->icon, x + hh * 0.5f, y + hh * 0.5f, hh * 0.66f, col);
                if (!w->text.empty())
                    画文字框(c, w->text, x + hh, y, ww - hh - 4.0f, hh,
                             字 * 0.82f, col, UIA_LEFT, UIV_MIDDLE, 0);
            }
            return;
        }
        case UIW_SEPARATOR: {
            圆角矩形(c, x, y + hh * 0.5f - 0.5f, ww, std::max(1.0f, hh), 0.0f, 边色);
            return;
        }
        case UIW_BUTTON: {
            unsigned bg = th.surface;
            if (!w->enabled)      bg = th.surfaceLo;
            else if (w->pressed)  bg = 混色(th.accent, th.surface, 0.25f);
            else if (w->hovered)  bg = th.surfaceHi;
            if (w->bg)            bg = w->bg;

            const bool 主按钮 = (w->tag == 1);
            if (主按钮 && w->enabled && !w->pressed) bg = th.accent;

            圆角矩形(c, x, y, ww, hh, r, bg);
            描边矩形(c, x, y, ww, hh, r,
                     w->borderColor ? 边色 : (主按钮 ? th.accent : th.border), 边宽);

            const unsigned col = !w->enabled ? th.disabled
                               : (主按钮 ? th.accentFg : (w->fg ? fg : fg));
            float 文x = x + w->padL;
            float 文w = ww - w->padL - w->padR;
            if (w->icon) {
                const float 图s = 字 * 1.05f;
                float 内容 = 图s + (w->text.empty() ? 0.0f : 6.0f + 估算文本宽(w->text, 字));
                内容 = std::min(内容, 文w);
                float 起 = x + (ww - 内容) * 0.5f;
                画图标(c, w->icon, 起 + 图s * 0.5f,
                       y + hh * 0.5f + (w->pressed ? 1.0f : 0.0f), 图s, col);
                文x = 起 + 图s + 6.0f;
                文w = 内容 - 图s - 6.0f;
            }
            画单行(c, w->text, 文x, y + (w->pressed ? 1.0f : 0.0f), 文w, hh, 字, col, UIA_CENTER);
            return;
        }
        case UIW_CHECKBOX: {
            const float 盒 = std::min(16.0f, hh - 4.0f);
            const float 盒x = x + 2.0f;
            const float 盒y = y + (hh - 盒) * 0.5f;

            圆角矩形(c, 盒x, 盒y, 盒, 盒, 3.0f,
                     w->checked ? th.accent : (w->hovered && w->enabled ? th.surface : th.surfaceLo));
            描边矩形(c, 盒x, 盒y, 盒, 盒, 3.0f,
                     w->checked ? th.accent : (w->hovered ? th.fgDim : th.border), 1.0f);
            if (w->checked)
                画图标(c, UII_CHECK, 盒x + 盒 * 0.5f, 盒y + 盒 * 0.5f, 盒 * 0.85f,
                       w->enabled ? th.accentFg : th.disabled);

            const unsigned col = w->enabled ? fg : th.disabled;
            画单行(c, w->text, 盒x + 盒 + 8.0f, y, ww - 盒 - 12.0f, hh, 字, col, UIA_LEFT);
            return;
        }
        case UIW_RADIO: {
            const float 半径 = std::min(8.0f, (hh - 4.0f) * 0.5f);
            const float ccx = x + 2.0f + 半径;
            const float ccy = y + hh * 0.5f;

            画圆(c, ccx, ccy, 半径,
                 w->checked ? th.accent : (w->hovered && w->enabled ? th.fgDim : th.border), false);
            if (w->checked) {
                if (w->hovered && w->enabled)
                    画圆(c, ccx, ccy, 半径 + 2.5f, 设透明度(th.accent, 0.22f), false);
                画圆(c, ccx, ccy, 半径 * 0.48f, th.accent, true);
            }

            const unsigned col = w->enabled ? fg : th.disabled;
            画单行(c, w->text, ccx + 半径 + 8.0f, y, ww - (ccx - x) - 半径 - 12.0f, hh,
                  字, col, UIA_LEFT);
            return;
        }
        case UIW_TOGGLE: {
            const float 轨道高 = std::min(hh, 24.0f);
            const float 轨道宽 = ww;
            const float 轨道y = y + (hh - 轨道高) * 0.5f;
            const float 圆 = 轨道高 * 0.5f;

            圆角矩形(c, x, 轨道y, 轨道宽, 轨道高, 圆,
                     w->checked ? (w->enabled ? th.accent : 混色(th.accent, th.bg, 0.55f))
                                : th.surfaceLo);
            if (!w->checked) 描边矩形(c, x, 轨道y, 轨道宽, 轨道高, 圆, th.border, 1.0f);

            const float 柄r = 圆 - 3.0f;
            const float 柄x = w->checked ? (x + 轨道宽 - 圆) : (x + 圆);
            画圆(c, 柄x, 轨道y + 圆, 柄r, th.accentFg, true);
            return;
        }
        case UIW_SLIDER: {
            const float 轨道高 = 6.0f;
            const float ty = y + hh * 0.5f - 轨道高 * 0.5f;
            const float 域 = (w->vmax - w->vmin);
            float 比例 = (域 > 0.0f) ? (w->value - w->vmin) / 域 : 0.0f;
            比例 = 夹取(比例, 0.0f, 1.0f);

            const float 柄r = std::min(9.0f, hh * 0.4f);
            const float 可用 = std::max(1.0f, ww - 柄r * 2.0f);
            const float 柄心 = x + 柄r + 可用 * 比例;

            圆角矩形(c, x + 柄r, ty, 可用, 轨道高, 轨道高 * 0.5f,
                     w->enabled ? th.surfaceLo : 混色(th.surfaceLo, th.bg, 0.4f));
            圆角矩形(c, x + 柄r, ty, 可用 * 比例, 轨道高, 轨道高 * 0.5f,
                     w->enabled ? th.accent : th.disabled);
            画圆(c, 柄心, y + hh * 0.5f, 柄r,
                 !w->enabled ? th.disabled
                             : ((w->hovered || w->pressed) ? th.accent : th.accentFg), true);
            画圆(c, 柄心, y + hh * 0.5f, 柄r,
                 w->enabled ? th.accent : th.disabled, false);
            return;
        }
        case UIW_PROGRESS: {
            const float 域 = (w->vmax - w->vmin);
            float 比例 = (域 > 0.0f) ? (w->value - w->vmin) / 域 : 0.0f;
            比例 = 夹取(比例, 0.0f, 1.0f);
            const float 圆 = std::min(hh * 0.5f, r);

            圆角矩形(c, x, y, ww, hh, 圆, th.surfaceLo);
            if (比例 > 0.0f) {
                const unsigned 色 = w->bg ? w->bg : th.accent;
                圆角矩形(c, x, y, std::max(hh, ww * 比例), hh, 圆, 色);
            }
            if (!w->text.empty()) {
                const std::string 显示 = w->text;
                画单行(c, 显示, x, y - 字 * 1.5f, ww, 字 * 1.4f, 字 * 0.86f, th.fgDim, UIA_RIGHT);
            }
            return;
        }
        case UIW_SPIN: {
            const float 按钮宽 = std::min(20.0f, ww * 0.32f);
            const float 框w = ww - 按钮宽;

            圆角矩形(c, x, y, 框w, hh, r, th.surfaceLo);
            描边矩形(c, x, y, 框w, hh, r, w->focused ? th.accent : 边色,
                     w->focused ? 1.5f : 边宽);

            char 缓冲[64];
            if (w->step >= 1.0f)
                ::sprintf_s(缓冲, sizeof(缓冲), "%d", (int)std::lround(w->value));
            else
                ::sprintf_s(缓冲, sizeof(缓冲), "%.2f", w->value);
            const unsigned col = w->enabled ? fg : th.disabled;
            画单行(c, 缓冲, x + 8.0f, y, 框w - 12.0f, hh, 字, col, UIA_RIGHT);

            const float 上高 = hh * 0.5f;
            圆角矩形(c, x + 框w, y, 按钮宽, 上高, 3.0f, th.surface);
            圆角矩形(c, x + 框w, y + 上高, 按钮宽, hh - 上高, 3.0f, th.surface);
            画三角(c, x + 框w + 按钮宽 * 0.5f, y + 上高 * 0.5f, 8.0f, 1,
                   w->enabled ? fg : th.disabled);
            画三角(c, x + 框w + 按钮宽 * 0.5f, y + 上高 + (hh - 上高) * 0.5f, 8.0f, 0,
                   w->enabled ? fg : th.disabled);
            return;
        }
        case UIW_EDIT: {
            圆角矩形(c, x, y, ww, hh, r, w->enabled ? th.surfaceLo : 混色(th.surfaceLo, th.bg, 0.5f));
            描边矩形(c, x, y, ww, hh, r, w->focused ? th.accent : 边色,
                     w->focused ? 1.5f : 边宽);

            const float 内左 = x + 8.0f;
            const float 内宽 = std::max(0.0f, ww - 16.0f);

            if (w->text.empty() && !w->focused) {
                画单行(c, w->tooltip.empty() ? "请输入..." : w->tooltip,
                      内左, y, 内宽, hh, 字, th.fgDim, UIA_LEFT);
            } else {
                const std::string 显示 = 截断文字(c, w->text, 字, 内宽 - 2.0f);
                画单行(c, 显示, 内左, y, 内宽, hh, 字, w->enabled ? fg : th.disabled, UIA_LEFT);

                if (w->focused) {
                    const float 光宽 = 前缀宽(c, w->text, (size_t)w->caret, 字);
                    const float 光x = 内左 + 光宽 + 1.0f;
                    if (光x < x + ww - 6.0f)
                        圆角矩形(c, 光x, y + 4.0f, 1.5f, hh - 8.0f, 0.0f, th.accent);
                }
            }
            return;
        }
        case UIW_MULTIEDIT: {
            圆角矩形(c, x, y, ww, hh, r, w->enabled ? th.surfaceLo : 混色(th.surfaceLo, th.bg, 0.5f));
            描边矩形(c, x, y, ww, hh, r, w->focused ? th.accent : 边色,
                     w->focused ? 1.5f : 边宽);

            const float 内x = x + 8.0f;
            const float 内y = y + 5.0f;
            const float 内w = std::max(0.0f, ww - 16.0f);
            const float 内h = std::max(0.0f, hh - 10.0f);
            const float 行高值 = 字 * 1.45f;

            std::vector<std::string> 行;
            排版文本(w->text, 字, 内w, 行);
            const int 总行数 = (int)行.size();
            const int 首行 = std::max(0, (int)std::floor(w->scroll / 行高值));

            for (int i = 首行; i < 总行数; ++i) {
                const float ly = 内y + (float)(i - 首行) * 行高值
                               - (w->scroll - (float)首行 * 行高值);
                if (ly > 内y + 内h) break;
                if (ly + 行高值 < 内y) continue;
                画单行(c, 行[(size_t)i], 内x, ly, 内w, 行高值, 字,
                      w->enabled ? fg : th.disabled, UIA_LEFT);
            }
            画滚动条(c, w);
            return;
        }
        case UIW_COMBO: {
            圆角矩形(c, x, y, ww, hh, r, w->enabled ? th.surfaceLo : 混色(th.surfaceLo, th.bg, 0.5f));
            描边矩形(c, x, y, ww, hh, r,
                     w->expanded ? th.accent : (w->focused ? th.accent : 边色), 边宽);

            std::string 显示 = w->text;
            if (显示.empty() && w->selected >= 0 && w->selected < (int)w->items.size())
                显示 = w->items[(size_t)w->selected].text;
            if (显示.empty()) {
                画单行(c, w->tooltip.empty() ? "请选择..." : w->tooltip,
                      x + 8.0f, y, ww - 32.0f, hh, 字, th.fgDim, UIA_LEFT);
            } else {
                画单行(c, 显示, x + 8.0f, y, ww - 32.0f, hh, 字,
                      w->enabled ? fg : th.disabled, UIA_LEFT);
            }
            画三角(c, x + ww - 14.0f, y + hh * 0.5f, 9.0f,
                   w->expanded ? 1 : 0, w->enabled ? th.fgDim : th.disabled);
            return;
        }
        case UIW_MENU: {
            unsigned bg = w->bg ? w->bg : (w->expanded ? th.surfaceHi
                                   : (w->hovered ? th.surfaceHi : th.surface));
            if (w->pressed) bg = th.surfaceHi;
            圆角矩形(c, x, y, ww, hh, r, bg);
            if (w->hovered || w->expanded) 描边矩形(c, x, y, ww, hh, r, th.border, 边宽);

            float 文x = x + w->padL;
            if (w->icon) {
                画图标(c, w->icon, x + w->padL + 字 * 0.5f, y + hh * 0.5f, 字 * 1.1f,
                       w->enabled ? fg : th.disabled);
                文x += 字 + 4.0f;
            }
            画单行(c, w->text, 文x, y, ww - (文x - x) - 18.0f, hh, 字,
                  w->enabled ? fg : th.disabled, UIA_LEFT);
            画三角(c, x + ww - 12.0f, y + hh * 0.5f, 8.0f, 0, th.fgDim);
            return;
        }
        case UIW_LIST: {
            圆角矩形(c, x, y, ww, hh, r, w->enabled ? th.surfaceLo : 混色(th.surfaceLo, th.bg, 0.5f));
            描边矩形(c, x, y, ww, hh, r, 边色, 边宽);
            画列表内容(c, w, x + 1.0f, y + 2.0f, ww - 2.0f, hh - 4.0f, 行高, false);
            画滚动条(c, w);
            return;
        }
        case UIW_TABLE: {
            const float 头高 = 行高;
            const int 列数 = (int)w->cols.size();
            if (列数 <= 0) {
                圆角矩形(c, x, y, ww, hh, r, th.surfaceLo);
                描边矩形(c, x, y, ww, hh, r, 边色, 边宽);
                return;
            }

            /* 列宽: 固定宽优先, 其余均分剩余 */
            std::vector<float> 列宽((size_t)列数, 0.0f);
            float 固定总 = 0.0f;
            int 弹性数 = 0;
            for (int i = 0; i < 列数; ++i) {
                if (w->cols[(size_t)i].width > 0.0f) {
                    列宽[(size_t)i] = w->cols[(size_t)i].width;
                    固定总 += w->cols[(size_t)i].width;
                } else {
                    ++弹性数;
                }
            }
            const float 弹性宽 = (弹性数 > 0)
                               ? std::max(20.0f, (ww - 固定总) / (float)弹性数) : 0.0f;
            for (int i = 0; i < 列数; ++i) {
                if (列宽[(size_t)i] <= 0.0f) 列宽[(size_t)i] = 弹性宽;
            }

            圆角矩形(c, x, y, ww, hh, r, w->enabled ? th.surface : th.surfaceLo);
            描边矩形(c, x, y, ww, hh, r, 边色, 边宽);

            /* 表头 */
            圆角矩形(c, x + 1.0f, y + 1.0f, ww - 2.0f, 头高 - 1.0f, r, th.surfaceLo);
            float cx = x;
            for (int i = 0; i < 列数; ++i) {
                画单行(c, w->cols[(size_t)i].title, cx + 8.0f, y, 列宽[(size_t)i] - 12.0f,
                      头高, 字 * 0.94f, th.fgDim, UIA_LEFT);
                cx += 列宽[(size_t)i];
                if (i + 1 < 列数) 画线(c, cx, y + 6.0f, cx, y + hh - 6.0f, th.border, 1.0f);
            }
            画线(c, x + 2.0f, y + 头高, x + ww - 2.0f, y + 头高, th.border, 1.0f);

            /* 行 */
            const float 区y = y + 头高 + 1.0f;
            const float 区h = std::max(0.0f, hh - 头高 - 2.0f);
            const int 总数 = (int)w->rows.size();
            const int 首行 = std::max(0, (int)std::floor(w->scroll / 行高));
            const int 可见 = (int)std::ceil(区h / 行高) + 1;

            for (int ri = 首行; ri < 总数 && ri < 首行 + 可见; ++ri) {
                const float ry = 区y + (float)(ri - 首行) * 行高
                               - (w->scroll - (float)首行 * 行高);
                if (ry + 行高 < 区y - 1.0f) continue;
                if (ry > 区y + 区h + 1.0f) break;

                const bool 选中 = (ri == w->selected);
                if (选中) {
                    圆角矩形(c, x + 2.0f, ry, ww - 12.0f, 行高, 2.0f, th.select);
                } else if (ri == w->hotIndex && w->enabled) {
                    圆角矩形(c, x + 2.0f, ry, ww - 12.0f, 行高, 2.0f, th.surfaceHi);
                } else if (ri % 2 == 1) {
                    圆角矩形(c, x + 2.0f, ry, ww - 12.0f, 行高, 2.0f,
                             设透明度(th.surfaceLo, 0.55f));
                }

                const auto& 行 = w->rows[(size_t)ri];
                float 单元格x = x;
                for (int ci = 0; ci < 列数; ++ci) {
                    const std::string 内容 = (ci < (int)行.size()) ? 行[(size_t)ci] : std::string();
                    const unsigned col = !w->enabled ? th.disabled
                                       : (选中 ? 混色(th.accent, th.fg, 0.1f) : fg);
                    画单行(c, 内容, 单元格x + 8.0f, ry, 列宽[(size_t)ci] - 12.0f, 行高,
                          字, col, UIA_LEFT);
                    单元格x += 列宽[(size_t)ci];
                }
            }
            画滚动条(c, w);
            return;
        }
        case UIW_TABS: {
            const float 条高 = 行高;
            const int 页数 = (int)w->items.size();

            /* 标签条背景 */
            圆角矩形(c, x, y, ww, 条高 + 2.0f, r, th.bg);
            画线(c, x, y + 条高 + 1.0f, x + ww, y + 条高 + 1.0f, th.border, 1.0f);

            float tx = x;
            for (int i = 0; i < 页数; ++i) {
                const std::string& 标题 = w->items[(size_t)i].text;
                const float 宽 = std::max(84.0f, 估算文本宽(标题, 字) + 34.0f);
                const bool 选中 = (i == w->selected);
                const bool 悬停 = (i == w->hotIndex);

                if (选中) {
                    圆角矩形(c, tx, y + 3.0f, 宽, 条高 - 3.0f, r, th.surface);
                    圆角矩形(c, tx + 8.0f, y + 3.0f, 宽 - 16.0f, 2.5f, 1.25f, th.accent);
                } else if (悬停) {
                    圆角矩形(c, tx, y + 4.0f, 宽, 条高 - 5.0f, r, th.surfaceHi);
                }
                画单行(c, 标题, tx + 10.0f, y + 3.0f, 宽 - 20.0f, 条高 - 3.0f, 字,
                      选中 ? fg : th.fgDim, UIA_CENTER);
                tx += 宽 + 2.0f;
            }

            /* 内容区高亮 (子控件由递归绘制) */
            绘制子控件(c, w);
            return;
        }
        case UIW_SCROLLBAR: {
            const float 圆 = ww * 0.5f;
            圆角矩形(c, x, y, ww, hh, 圆, th.surfaceLo);
            const float 域 = (w->vmax - w->vmin);
            float 比例 = (域 > 0.0f) ? (w->value - w->vmin) / 域 : 0.0f;
            比例 = 夹取(比例, 0.0f, 1.0f);
            const float 柄高 = std::max(ww, hh * ((域 > 0.0f) ? (1.0f / (1.0f + 域)) : 0.5f));
            const float 行程 = std::max(0.0f, hh - 柄高);
            圆角矩形(c, x, y + 行程 * 比例, ww, 柄高, 圆,
                     (w->hovered || w->pressed) ? th.fgDim : th.border);
            return;
        }
        case UIW_IMAGE: {
            圆角矩形(c, x, y, ww, hh, r, w->bg ? w->bg : th.surfaceLo);
            if (!w->imageData.empty()) {
                /* 图片对象每次绘制重建: 加入画布后归画布所有, 下一帧会被销毁 */
                void* pic = thorgw_picture_new();
                if (pic && thorgw_picture_load_data(pic, w->imageData.data(),
                        (int)w->imageData.size(),
                        w->imageMime.empty() ? "png" : w->imageMime.c_str()) == 0) {
                    thorgw_picture_set_size(pic, ww, hh);
                    thorgw_paint_translate(pic, x, y);
                    加对象(c, pic);
                } else if (pic) {
                    thorgw_paint_free(pic);
                }
            } else {
                画图标(c, UII_STAR, x + ww * 0.5f, y + hh * 0.5f,
                      std::min(ww, hh) * 0.4f, th.disabled);
            }
            if (w->borderColor) 描边矩形(c, x, y, ww, hh, r, 边色, 边宽);
            return;
        }
        default:
            return;
    }
}

/* ==================== 弹出浮层 ==================== */

void 绘制浮层(UiContext* c)
{
    UiWidget* w = c->popup;
    if (!w || !w->expanded) return;

    float ox, oy, ow, oh;
    if (!浮层矩形(c, w, ox, oy, ow, oh)) return;

    /* 投影 */
    圆角矩形(c, ox + 1.0f, oy + 3.0f, ow, oh, c->theme.radius, 设透明度(c->theme.shadow, 0.35f));
    圆角矩形(c, ox, oy, ow, oh, c->theme.radius, c->theme.surface);
    描边矩形(c, ox, oy, ow, oh, c->theme.radius, c->theme.border, 1.0f);

    const float 行高 = (w->rowHeight > 0) ? w->rowHeight : c->theme.rowHeight;
    const float 字号 = (w->fontSize > 0) ? w->fontSize : c->theme.fontSize;
    const int 总数 = (int)w->items.size();

    for (int i = 0; i < 总数; ++i) {
        const float iy = oy + 3.0f + (float)i * 行高;
        if (iy + 行高 > oy + oh - 2.0f) break;

        const bool 选中 = (i == w->selected);
        if (i == w->hotIndex) {
            圆角矩形(c, ox + 3.0f, iy, ow - 6.0f, 行高, 3.0f, c->theme.surfaceHi);
        } else if (选中) {
            圆角矩形(c, ox + 3.0f, iy, ow - 6.0f, 行高, 3.0f, c->theme.select);
        }

        if (选中) {
            /* 左侧强调条 */
            圆角矩形(c, ox + 3.0f, iy + 2.0f, 3.0f, 行高 - 4.0f, 1.5f, c->theme.accent);
        }

        画单行(c, w->items[(size_t)i].text, ox + 12.0f, iy, ow - 24.0f, 行高, 字号,
              选中 ? c->theme.accent : c->theme.fg, UIA_LEFT);
    }
}

} /* namespace */
/* ==================== 交互 ==================== */

namespace
{

void 设焦点(UiContext* c, UiWidget* w)
{
    if (!c) return;
    if (c->focused == w) return;
    if (c->focused) {
        c->focused->focused = false;
        记录事件(c, UIE_FOCUS_LOST, c->focused, 0, 0);
    }
    c->focused = w;
    if (w) {
        w->focused = true;
        记录事件(c, UIE_FOCUS_GAINED, w, 0, 0);
    }
}

void 关闭浮层(UiContext* c)
{
    if (!c || !c->popup) return;
    UiWidget* p = c->popup;
    p->expanded = false;
    p->hotIndex = -1;
    c->popup = nullptr;
    记录事件(c, UIE_POPUP_CLOSED, p, 0, 0);
}

float 行高取(UiContext* c, UiWidget* w, float 行高)
{
    return (w->rowHeight > 0.0f) ? w->rowHeight : 行高;
}

int 列表行索引(UiContext* c, UiWidget* w, float x, float y)
{
    if (!在矩形内(w, x, y)) return -1;
    const float 行高 = (w->rowHeight > 0.0f) ? w->rowHeight : c->theme.rowHeight;

    if (w->kind == UIW_TABLE) {
        const float 区y = w->y + 行高 + 1.0f;
        if (y < 区y) return -1;
        const int 索引 = (int)std::floor((y - 区y + w->scroll) / 行高);
        return (索引 >= 0 && 索引 < (int)w->rows.size()) ? 索引 : -1;
    }
    const int 索引 = (int)std::floor((y - w->y - 2.0f + w->scroll) / 行高);
    return (索引 >= 0 && 索引 < (int)w->items.size()) ? 索引 : -1;
}

int 标签索引(UiContext* c, UiWidget* w, float x)
{
    const float 字 = (w->fontSize > 0.0f) ? w->fontSize : c->theme.fontSize;
    float tx = w->x;
    for (size_t i = 0; i < w->items.size(); ++i) {
        const float 宽 = std::max(84.0f, 估算文本宽(w->items[i].text, 字) + 34.0f);
        if (x >= tx && x <= tx + 宽) return (int)i;
        tx += 宽 + 2.0f;
    }
    return -1;
}

void 更新滑块(UiContext* c, UiWidget* w, float x)
{
    const float 柄r = std::min(9.0f, w->h * 0.4f);
    const float 可用 = std::max(1.0f, w->w - 柄r * 2.0f);
    float 比例 = (x - w->x - 柄r) / 可用;
    比例 = 夹取(比例, 0.0f, 1.0f);
    float 新值 = w->vmin + 比例 * (w->vmax - w->vmin);
    if (w->step > 0.0f) {
        新值 = w->vmin + std::round((新值 - w->vmin) / w->step) * w->step;
        新值 = 夹取(新值, w->vmin, w->vmax);
    }
    if (新值 != w->value) {
        w->value = 新值;
        记录事件(c, UIE_VALUE_CHANGED, w, 新值, 0);
    }
}

void 滚到可见(UiContext* c, UiWidget* w, int 索引)
{
    const float 行高 = (w->rowHeight > 0.0f) ? w->rowHeight : c->theme.rowHeight;
    const float 头高 = (w->kind == UIW_TABLE) ? 行高 + 1.0f : 2.0f;
    const float top = (float)索引 * 行高;
    const float bottom = top + 行高;
    const float 可视 = w->h - 头高;

    if (top < w->scroll) w->scroll = top;
    else if (bottom > w->scroll + 可视) w->scroll = bottom - 可视;
    w->scroll = 夹取(w->scroll, 0.0f, w->scrollMax);
}

/* 判断点是否落在容器的滚动条热区 */
bool 在滚动条上(UiWidget* w, float x, float y)
{
    return 可滚动(w) && x >= w->x + w->w - 12.0f && 在矩形内(w, x, y);
}

/* 表格行按 '|' 拆分单元格 */
std::vector<std::string> 拆单元格(const char* cells)
{
    std::vector<std::string> 结果;
    if (!cells) return 结果;
    std::string 当前;
    for (const char* p = cells; *p; ++p) {
        if (*p == '|') {
            结果.push_back(当前);
            当前.clear();
        } else {
            当前 += *p;
        }
    }
    结果.push_back(当前);
    return 结果;
}

} /* namespace */

/* ==================== 对外接口 ==================== */

extern "C" {

void* uiw_new(void)
{
    return new UiContext();
}

void uiw_free(void* ctx)
{
    delete (UiContext*)ctx;
}

const char* uiw_version(void)
{
    return "ThorVG UI Toolkit 2.0";
}

int uiw_set_viewport(void* ctx, float w, float h, float scale)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    c->viewW = (w > 0.0f) ? w : 800.0f;
    c->viewH = (h > 0.0f) ? h : 600.0f;
    c->scale = (scale > 0.0f) ? scale : 1.0f;
    return 0;
}

float uiw_get_viewport_width(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return c ? c->viewW : 0.0f;
}

float uiw_get_viewport_height(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return c ? c->viewH : 0.0f;
}

int uiw_set_theme(void* ctx, int theme)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    switch (theme) {
        case 0: c->theme = 深色主题(); break;
        case 1: c->theme = 浅色主题(); break;
        case 2: c->theme = 蓝色主题(); break;
        case 3: c->theme = 高对比主题(); break;
        default: return -1;
    }
    return 0;
}

int uiw_set_font(void* ctx, const char* utf8_font_name)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !utf8_font_name) return -1;
    c->fontName = utf8_font_name;
    return 0;
}

int uiw_set_theme_color(void* ctx, int slot, unsigned color)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    UiTheme& t = c->theme;
    switch (slot) {
        case UC_BG: t.bg = color; break;
        case UC_SURFACE: t.surface = color; break;
        case UC_SURFACE_HI: t.surfaceHi = color; break;
        case UC_SURFACE_LO: t.surfaceLo = color; break;
        case UC_BORDER: t.border = color; break;
        case UC_FG: t.fg = color; break;
        case UC_FG_DIM: t.fgDim = color; break;
        case UC_ACCENT: t.accent = color; break;
        case UC_ACCENT_FG: t.accentFg = color; break;
        case UC_DISABLED: t.disabled = color; break;
        case UC_SHADOW: t.shadow = color; break;
        case UC_SELECT: t.select = color; break;
        case UC_SUCCESS: t.success = color; break;
        case UC_WARN: t.warn = color; break;
        case UC_DANGER: t.danger = color; break;
        default: return -1;
    }
    return 0;
}

int uiw_set_theme_metric(void* ctx, int slot, float v)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    switch (slot) {
        case UM_RADIUS: c->theme.radius = v; break;
        case UM_FONT_SIZE: c->theme.fontSize = v; break;
        case UM_ROW_HEIGHT: c->theme.rowHeight = v; break;
        case UM_BORDER: c->theme.borderWidth = v; break;
        default: return -1;
    }
    return 0;
}

int uiw_add(void* ctx, int kind, const char* name, const char* text,
            float x, float y, float w, float h)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    if (kind < UIW_PANEL || kind > UIW_CARD) return -1;

    UiWidget* wd = new UiWidget();
    wd->id = c->nextId++;
    wd->kind = kind;
    wd->dx = x; wd->dy = y; wd->dw = w; wd->dh = h;
    wd->x = x; wd->y = y; wd->w = w; wd->h = h;
    if (name) wd->name = name;
    if (text) wd->text = text;

    /* 容器默认流式布局 */
    if (kind == UIW_PANEL || kind == UIW_CARD || kind == UIW_GROUP) {
        wd->layout = UIL_ABSOLUTE;
        wd->padL = wd->padT = wd->padR = wd->padB = 0.0f;
    }
    if (kind == UIW_TABS) {
        wd->layout = UIL_STACK;
        wd->padL = wd->padT = wd->padR = wd->padB = 8.0f;
    }
    if (kind == UIW_LIST || kind == UIW_TABLE) {
        wd->rowHeight = 0.0f;
    }

    c->all.push_back(wd);
    c->roots.push_back(wd);
    return wd->id;
}

int uiw_remove(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    UiWidget* w = 找控件(c, id);
    if (!w) return -1;

    /* 收集自身与所有后代 */
    std::vector<UiWidget*> 待删;
    std::vector<UiWidget*> 栈{ w };
    while (!栈.empty()) {
        UiWidget* cur = 栈.back();
        栈.pop_back();
        待删.push_back(cur);
        for (auto* ch : cur->children) 栈.push_back(ch);
    }

    for (auto* d : 待删) {
        if (c->hovered == d) c->hovered = nullptr;
        if (c->pressed == d) c->pressed = nullptr;
        if (c->focused == d) c->focused = nullptr;
        if (c->dragSlider == d) c->dragSlider = nullptr;
        if (c->dragScroll == d) c->dragScroll = nullptr;
        if (c->popup == d) c->popup = nullptr;

        c->all.erase(std::remove(c->all.begin(), c->all.end(), d), c->all.end());
        c->roots.erase(std::remove(c->roots.begin(), c->roots.end(), d), c->roots.end());
        if (d->parent) {
            auto& p = d->parent->children;
            p.erase(std::remove(p.begin(), p.end(), d), p.end());
        }
        delete d;
    }
    return 0;
}

int uiw_clear(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    for (auto* w : c->all) delete w;
    c->all.clear();
    c->roots.clear();
    c->hovered = c->pressed = c->focused = nullptr;
    c->dragSlider = c->dragScroll = c->popup = nullptr;
    c->events.clear();
    c->hasCurrent = false;
    return 0;
}

/* ---------- 通用属性 ---------- */

#define FIND_W(检查)                                     \
    UiContext* c = (UiContext*)ctx;                      \
    if (!c) return 检查;                                  \
    UiWidget* w = 找控件(c, id);                          \
    if (!w) return 检查;                                  \
    c->dirty = true

int uiw_set_rect(void* ctx, int id, float fx, float fy, float fw, float fh)
{
    FIND_W(-1);
    w->dx = fx; w->dy = fy;
    if (fw > 0.0f) w->dw = fw;
    if (fh > 0.0f) w->dh = fh;
    return 0;
}

int uiw_get_rect(void* ctx, int id, float* out4)
{
    FIND_W(-1);
    if (!out4) return -1;
    out4[0] = w->x; out4[1] = w->y; out4[2] = w->w; out4[3] = w->h;
    return 0;
}

int uiw_set_pos(void* ctx, int id, float x, float y)
{
    FIND_W(-1);
    w->dx = x; w->dy = y;
    return 0;
}

int uiw_set_size(void* ctx, int id, float w_, float h_)
{
    FIND_W(-1);
    if (w_ > 0.0f) w->dw = w_;
    if (h_ > 0.0f) w->dh = h_;
    return 0;
}

int uiw_set_text(void* ctx, int id, const char* utf8_text)
{
    FIND_W(-1);
    w->text = utf8_text ? utf8_text : "";
    /* 统一换行, 避免 \r 被当成字符渲染成方框 */
    {
        std::string 规范;
        规范.reserve(w->text.size());
        for (size_t i = 0; i < w->text.size(); ++i) {
            if (w->text[i] == '\r') continue;
            规范 += w->text[i];
        }
        w->text.swap(规范);
    }
    if (w->kind == UIW_EDIT || w->kind == UIW_MULTIEDIT) {
        if (w->caret > (int)w->text.size()) w->caret = (int)w->text.size();
    }
    return 0;
}

int uiw_get_text(void* ctx, int id, char* out, int cap)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !out) return -1;
    UiWidget* w = 找控件(c, id);
    if (!w) return -1;
    拷名(out, (size_t)cap, w->text);
    return (int)::strlen(out);
}

int uiw_set_value(void* ctx, int id, float v)
{
    FIND_W(-1);
    w->value = 夹取(v, w->vmin, w->vmax);
    return 0;
}

float uiw_get_value(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0.0f;
    UiWidget* w = 找控件(c, id);
    return w ? w->value : 0.0f;
}

int uiw_set_range(void* ctx, int id, float vmin, float vmax, float step)
{
    FIND_W(-1);
    if (vmax < vmin) std::swap(vmin, vmax);
    w->vmin = vmin;
    w->vmax = vmax;
    w->step = (step > 0.0f) ? step : 0.0f;
    w->value = 夹取(w->value, vmin, vmax);
    return 0;
}

int uiw_get_range(void* ctx, int id, float* out3)
{
    FIND_W(-1);
    if (!out3) return -1;
    out3[0] = w->vmin; out3[1] = w->vmax; out3[2] = w->step;
    return 0;
}

int uiw_set_checked(void* ctx, int id, int on)
{
    FIND_W(-1);
    w->checked = (on != 0);
    return 0;
}

int uiw_get_checked(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    return (w && w->checked) ? 1 : 0;
}

int uiw_set_enabled(void* ctx, int id, int on)
{
    FIND_W(-1);
    w->enabled = (on != 0);
    return 0;
}

int uiw_get_enabled(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    return (w && w->enabled) ? 1 : 0;
}

int uiw_set_visible(void* ctx, int id, int on)
{
    FIND_W(-1);
    w->visible = (on != 0);
    return 0;
}

int uiw_get_visible(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    return (w && w->visible) ? 1 : 0;
}

int uiw_set_font_size(void* ctx, int id, float size)
{
    FIND_W(-1);
    w->fontSize = (size > 0.0f) ? size : 0.0f;
    return 0;
}

int uiw_set_align(void* ctx, int id, int h_align)
{
    FIND_W(-1);
    w->align = h_align;
    return 0;
}

int uiw_set_valign(void* ctx, int id, int v_align)
{
    FIND_W(-1);
    w->valign = v_align;
    return 0;
}

int uiw_set_wrap(void* ctx, int id, int on)
{
    FIND_W(-1);
    w->wrapMode = on;
    return 0;
}

int uiw_set_colors(void* ctx, int id, unsigned bg, unsigned fg)
{
    FIND_W(-1);
    w->bg = bg;
    w->fg = fg;
    return 0;
}

int uiw_set_bg(void* ctx, int id, unsigned bg)
{
    FIND_W(-1);
    w->bg = bg;
    return 0;
}

int uiw_set_fg(void* ctx, int id, unsigned fg)
{
    FIND_W(-1);
    w->fg = fg;
    return 0;
}

int uiw_set_border(void* ctx, int id, unsigned color, float width)
{
    FIND_W(-1);
    w->borderColor = color;
    w->borderWidth = (width > 0.0f) ? width : 0.0f;
    return 0;
}

int uiw_set_radius(void* ctx, int id, float radius)
{
    FIND_W(-1);
    w->radius = radius;
    return 0;
}

int uiw_set_layout(void* ctx, int id, int mode, float padding, float spacing)
{
    FIND_W(-1);
    w->layout = mode;
    if (padding >= 0.0f) {
        w->padL = w->padT = w->padR = w->padB = padding;
    }
    if (spacing >= 0.0f) w->spacing = spacing;
    return 0;
}

int uiw_set_padding(void* ctx, int id, float l, float t, float r, float b)
{
    FIND_W(-1);
    w->padL = l; w->padT = t; w->padR = r; w->padB = b;
    return 0;
}

int uiw_set_margin(void* ctx, int id, float l, float t, float r, float b)
{
    FIND_W(-1);
    w->marginL = l; w->marginT = t; w->marginR = r; w->marginB = b;
    return 0;
}

int uiw_set_weight(void* ctx, int id, float weight)
{
    FIND_W(-1);
    w->weight = (weight > 0.0f) ? weight : 0.0f;
    return 0;
}

int uiw_set_parent(void* ctx, int child, int parent)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    UiWidget* ch = 找控件(c, child);
    if (!ch) return -1;

    /* 先从原父/根移除 */
    if (ch->parent) {
        auto& p = ch->parent->children;
        p.erase(std::remove(p.begin(), p.end(), ch), p.end());
    }
    c->roots.erase(std::remove(c->roots.begin(), c->roots.end(), ch), c->roots.end());

    if (parent <= 0) {
        ch->parent = nullptr;
        c->roots.push_back(ch);
        return 0;
    }

    UiWidget* p = 找控件(c, parent);
    if (!p) return -1;
    /* 防止成环 */
    for (UiWidget* q = p; q; q = q->parent) {
        if (q == ch) return -1;
    }
    ch->parent = p;
    p->children.push_back(ch);
    return 0;
}

int uiw_get_parent(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    return (w && w->parent) ? w->parent->id : 0;
}

int uiw_set_scroll(void* ctx, int id, float offset)
{
    FIND_W(-1);
    w->scroll = 夹取(offset, 0.0f, w->scrollMax);
    return 0;
}

float uiw_get_scroll(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0.0f;
    UiWidget* w = 找控件(c, id);
    return w ? w->scroll : 0.0f;
}

int uiw_scroll_by(void* ctx, int id, float delta)
{
    FIND_W(-1);
    w->scroll = 夹取(w->scroll + delta, 0.0f, w->scrollMax);
    记录事件(c, UIE_SCROLL, w, w->scroll, 0);
    return 0;
}

float uiw_get_scroll_max(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0.0f;
    UiWidget* w = 找控件(c, id);
    return w ? w->scrollMax : 0.0f;
}

int uiw_set_group(void* ctx, int id, int group)
{
    FIND_W(-1);
    w->group = group;
    return 0;
}

int uiw_set_tag(void* ctx, int id, int tag)
{
    FIND_W(-1);
    w->tag = tag;
    return 0;
}

int uiw_get_tag(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    return w ? w->tag : 0;
}

int uiw_set_tooltip(void* ctx, int id, const char* utf8_text)
{
    FIND_W(-1);
    w->tooltip = utf8_text ? utf8_text : "";
    return 0;
}

int uiw_set_icon(void* ctx, int id, int icon, unsigned color)
{
    FIND_W(-1);
    w->icon = icon;
    w->iconColor = color;
    return 0;
}

int uiw_set_grid_cols(void* ctx, int id, int cols)
{
    FIND_W(-1);
    w->gridCols = (cols > 0) ? cols : 1;
    return 0;
}

int uiw_set_row_height(void* ctx, int id, float h)
{
    FIND_W(-1);
    w->rowHeight = (h > 0.0f) ? h : 0.0f;
    return 0;
}

int uiw_set_columns(void* ctx, int id, int cols)
{
    FIND_W(-1);
    w->visibleRows = (cols > 0) ? cols : 0;
    return 0;
}

int uiw_set_image_data(void* ctx, int id, const void* data, int size, const char* mime)
{
    FIND_W(-1);
    if (!data || size <= 0) {
        w->imageData.clear();
        return 0;
    }
    w->imageData.assign((const char*)data, (size_t)size);
    w->imageMime = mime ? mime : "png";
    return 0;
}

/* ---------- 列表 / 表格 / 标签页 ---------- */

int uiw_item_count(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    return w ? (int)w->items.size() : 0;
}

int uiw_item_add(void* ctx, int id, const char* utf8_text)
{
    FIND_W(-1);
    UiItem it;
    it.text = utf8_text ? utf8_text : "";
    w->items.push_back(it);
    return (int)w->items.size() - 1;
}

int uiw_item_insert(void* ctx, int id, int index, const char* utf8_text)
{
    FIND_W(-1);
    const int 总数 = (int)w->items.size();
    int 位置 = (index < 0) ? 0 : ((index > 总数) ? 总数 : index);
    UiItem it;
    it.text = utf8_text ? utf8_text : "";
    w->items.insert(w->items.begin() + 位置, it);
    return 位置;
}

int uiw_item_set(void* ctx, int id, int index, const char* utf8_text)
{
    FIND_W(-1);
    if (index < 0 || index >= (int)w->items.size()) return -1;
    w->items[(size_t)index].text = utf8_text ? utf8_text : "";
    return 0;
}

int uiw_item_get(void* ctx, int id, int index, char* out, int cap)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !out) return -1;
    UiWidget* w = 找控件(c, id);
    if (!w || index < 0 || index >= (int)w->items.size()) return -1;
    拷名(out, (size_t)cap, w->items[(size_t)index].text);
    return (int)::strlen(out);
}

int uiw_item_remove(void* ctx, int id, int index)
{
    FIND_W(-1);
    if (index < 0 || index >= (int)w->items.size()) return -1;
    w->items.erase(w->items.begin() + index);
    if (w->selected >= (int)w->items.size()) w->selected = (int)w->items.size() - 1;
    return 0;
}

int uiw_item_clear(void* ctx, int id)
{
    FIND_W(-1);
    w->items.clear();
    w->selected = -1;
    w->hotIndex = -1;
    w->scroll = 0.0f;
    return 0;
}

int uiw_item_check(void* ctx, int id, int index, int on)
{
    FIND_W(-1);
    if (index < 0 || index >= (int)w->items.size()) return -1;
    w->items[(size_t)index].checked = (on != 0);
    return 0;
}

int uiw_item_checked(void* ctx, int id, int index)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    if (!w || index < 0 || index >= (int)w->items.size()) return 0;
    return w->items[(size_t)index].checked ? 1 : 0;
}

int uiw_col_add(void* ctx, int id, const char* utf8_title, float width)
{
    FIND_W(-1);
    UiColumn col;
    col.title = utf8_title ? utf8_title : "";
    col.width = width;
    w->cols.push_back(col);
    return (int)w->cols.size() - 1;
}

int uiw_col_count(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    return w ? (int)w->cols.size() : 0;
}

int uiw_col_set_width(void* ctx, int id, int col, float width)
{
    FIND_W(-1);
    if (col < 0 || col >= (int)w->cols.size()) return -1;
    w->cols[(size_t)col].width = width;
    return 0;
}

int uiw_col_clear(void* ctx, int id)
{
    FIND_W(-1);
    w->cols.clear();
    return 0;
}

int uiw_row_add(void* ctx, int id, const char* utf8_cells)
{
    FIND_W(-1);
    w->rows.push_back(拆单元格(utf8_cells));
    return (int)w->rows.size() - 1;
}

int uiw_row_set(void* ctx, int id, int row, const char* utf8_cells)
{
    FIND_W(-1);
    if (row < 0 || row >= (int)w->rows.size()) return -1;
    w->rows[(size_t)row] = 拆单元格(utf8_cells);
    return 0;
}

int uiw_row_remove(void* ctx, int id, int row)
{
    FIND_W(-1);
    if (row < 0 || row >= (int)w->rows.size()) return -1;
    w->rows.erase(w->rows.begin() + row);
    if (w->selected >= (int)w->rows.size()) w->selected = (int)w->rows.size() - 1;
    return 0;
}

int uiw_row_clear(void* ctx, int id)
{
    FIND_W(-1);
    w->rows.clear();
    w->selected = -1;
    w->scroll = 0.0f;
    return 0;
}

int uiw_row_count(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    return w ? (int)w->rows.size() : 0;
}

int uiw_tab_add(void* ctx, int id, const char* utf8_title)
{
    FIND_W(-1);
    UiItem it;
    it.text = utf8_title ? utf8_title : "";
    w->items.push_back(it);
    if (w->selected < 0) w->selected = 0;
    return (int)w->items.size() - 1;
}

int uiw_select(void* ctx, int id, int index)
{
    FIND_W(-1);
    const int 总数 = (w->kind == UIW_TABLE) ? (int)w->rows.size() : (int)w->items.size();
    if (index < -1 || index >= 总数) return -1;
    const bool 变化 = (w->selected != index);
    w->selected = index;
    if (w->kind == UIW_TABS) 同步标签页(w);
    if (w->kind == UIW_COMBO && index >= 0 && index < (int)w->items.size()) {
        w->text = w->items[(size_t)index].text;
    }
    if (变化) 记录事件(c, UIE_SELECT_CHANGED, w, (float)index, 0);
    return 0;
}

int uiw_selected(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    UiWidget* w = 找控件(c, id);
    return w ? w->selected : -1;
}

/* ---------- 查找与遍历 ---------- */

int uiw_find(void* ctx, const char* name)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !name) return -1;
    for (auto* w : c->all) {
        if (w->name == name) return w->id;
    }
    return -1;
}

int uiw_count(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return c ? (int)c->all.size() : 0;
}

int uiw_at(void* ctx, int index)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || index < 0 || index >= (int)c->all.size()) return -1;
    return c->all[(size_t)index]->id;
}

int uiw_get_state(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    UiWidget* w = 找控件(c, id);
    if (!w) return 0;
    int 位 = 0;
    if (w->hovered) 位 |= 1;
    if (w->pressed) 位 |= 2;
    if (w->focused) 位 |= 4;
    if (w->checked) 位 |= 8;
    if (w->expanded) 位 |= 16;
    if (!w->enabled) 位 |= 32;
    return 位;
}

/* ---------- 布局与绘制 ---------- */

int uiw_take_dirty(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return 0;
    if (!c->dirty) return 0;
    c->dirty = false;
    return 1;
}

int uiw_layout(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;

    for (auto* w : c->all) 同步标签页(w);

    for (auto* r : c->roots) {
        自动尺寸(c, r);
        r->x = r->dx;
        r->y = r->dy;
        if (r->dw > 0.0f) r->w = r->dw;
        if (r->dh > 0.0f) r->h = r->dh;
        排布局(c, r);
    }
    return 0;
}

int uiw_draw(void* ctx, void* thorvg_canvas)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !thorvg_canvas) return -1;

    for (auto* p : c->framePaints) thorgw_canvas_remove(thorvg_canvas, p);
    c->framePaints.clear();
    c->canvas = thorvg_canvas;

    for (auto* w : c->roots) {
        绘制控件(c, w);
    }
    绘制浮层(c);

    thorgw_canvas_update(thorvg_canvas);
    return 0;
}

int uiw_popup_close(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    关闭浮层(c);
    return 0;
}

int uiw_popup_open(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !c->focused) return -1;
    UiWidget* w = c->focused;
    if (w->kind != UIW_COMBO && w->kind != UIW_MENU) return -1;
    if (c->popup && c->popup != w) 关闭浮层(c);
    w->expanded = true;
    w->hotIndex = -1;
    c->popup = w;
    return 0;
}

/* ---------- 输入 ---------- */

int uiw_mouse_move(void* ctx, float x, float y)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    c->mx = x;
    c->my = y;
    c->cursorKind = 0;

    /* 浮层内悬停 */
    if (c->popup && c->popup->expanded) {
        float ox, oy, ow, oh;
        if (浮层矩形(c, c->popup, ox, oy, ow, oh) &&
            x >= ox && x <= ox + ow && y >= oy && y <= oy + oh) {
            const float 行高 = (c->popup->rowHeight > 0.0f)
                             ? c->popup->rowHeight : c->theme.rowHeight;
            const int 索引 = (int)std::floor((y - oy - 3.0f) / 行高);
            c->popup->hotIndex = (索引 >= 0 && 索引 < (int)c->popup->items.size())
                               ? 索引 : -1;
            c->cursorKind = 1;
            return 0;
        }
        c->popup->hotIndex = -1;
    }

    UiWidget* w = 顶层命中(c, x, y);

    if (c->hovered != w) {
        if (c->hovered) {
            c->hovered->hovered = false;
            c->hovered->hotIndex = -1;
            记录事件(c, UIE_HOVER_LEAVE, c->hovered, 0, 0);
        }
        c->hovered = w;
        c->hoverSince = ::GetTickCount();
        if (w) {
            w->hovered = true;
            记录事件(c, UIE_HOVER_ENTER, w, 0, 0);
        }
    }

    /* 列表/表格的悬停行 */
    if (w && (w->kind == UIW_LIST || w->kind == UIW_TABLE)) {
        const int 新行 = 列表行索引(c, w, x, y);
        if (新行 != w->hotIndex) {
            w->hotIndex = 新行;
            c->dirty = true;
        }
    }

    /* 拖拽滑块 */
    if (c->dragSlider) {
        更新滑块(c, c->dragSlider, x);
    }

    /* 拖拽容器滚动条 */
    if (c->dragScroll) {
        UiWidget* s = c->dragScroll;
        const float 轨高 = std::max(20.0f, s->h - s->padT - s->padB - 4.0f);
        const float 可见 = 轨高 * (轨高 / (轨高 + s->scrollMax));
        const float 柄高 = std::max(18.0f, 可见);
        const float 行程 = std::max(1.0f, 轨高 - 柄高);
        const float 位移 = y - c->dragStartY;
        s->scroll = 夹取(c->dragStartScroll + 位移 * s->scrollMax / 行程,
                        0.0f, s->scrollMax);
    }

    /* 光标形状 */
    if (w) {
        switch (w->kind) {
            case UIW_BUTTON: case UIW_CHECKBOX: case UIW_RADIO: case UIW_TOGGLE:
            case UIW_LINK: case UIW_COMBO: case UIW_MENU: case UIW_TABS:
            case UIW_LIST: case UIW_TABLE:
                c->cursorKind = 1;
                break;
            case UIW_EDIT: case UIW_MULTIEDIT:
                c->cursorKind = 2;
                break;
            case UIW_SLIDER: case UIW_SPIN:
                c->cursorKind = 3;
                break;
            default:
                if (在滚动条上(w, x, y)) c->cursorKind = 1;
                break;
        }
    }
    return 0;
}

int uiw_mouse_down(void* ctx, float x, float y, int button)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    (void)button;
    c->pressX = x;
    c->pressY = y;
    c->mx = x;
    c->my = y;

    /* 浮层优先处理 */
    if (c->popup && c->popup->expanded) {
        UiWidget* p = c->popup;
        float ox, oy, ow, oh;
        if (浮层矩形(c, p, ox, oy, ow, oh) &&
            x >= ox && x <= ox + ow && y >= oy && y <= oy + oh) {
            const float 行高 = (p->rowHeight > 0.0f) ? p->rowHeight : c->theme.rowHeight;
            const int 索引 = (int)std::floor((y - oy - 3.0f) / 行高);
            if (索引 >= 0 && 索引 < (int)p->items.size()) {
                p->selected = 索引;
                if (p->kind == UIW_COMBO) p->text = p->items[(size_t)索引].text;
                记录事件(c, UIE_ITEM_CLICK, p, (float)索引, 0);
                记录事件(c, UIE_SELECT_CHANGED, p, (float)索引, 0);
            }
            关闭浮层(c);
            return 0;
        }
        关闭浮层(c);
        return 0;
    }

    UiWidget* w = 顶层命中(c, x, y);
    if (!w) {
        设焦点(c, nullptr);
        return 0;
    }

    /* 容器滚动条 */
    if (在滚动条上(w, x, y)) {
        c->dragScroll = w;
        c->dragStartY = y;
        c->dragStartScroll = w->scroll;
        return 0;
    }

    if (可聚焦(w)) 设焦点(c, w);

    switch (w->kind) {
        case UIW_BUTTON: case UIW_CHECKBOX: case UIW_RADIO: case UIW_TOGGLE:
        case UIW_LINK:
            w->pressed = true;
            c->pressed = w;
            break;
        case UIW_SLIDER:
            w->pressed = true;
            c->pressed = w;
            c->dragSlider = w;
            更新滑块(c, w, x);
            break;
        case UIW_SPIN: {
            const float 按钮宽 = std::min(20.0f, w->w * 0.32f);
            if (x > w->x + w->w - 按钮宽) {
                const float 上高 = w->h * 0.5f;
                const int 方向 = (y < w->y + 上高) ? 1 : -1;
                const float 步 = (w->step > 0.0f) ? w->step : 1.0f;
                const float 新值 = 夹取(w->value + (float)方向 * 步, w->vmin, w->vmax);
                if (新值 != w->value) {
                    w->value = 新值;
                    记录事件(c, UIE_VALUE_CHANGED, w, 新值, 0);
                }
            }
            w->pressed = true;
            c->pressed = w;
            break;
        }
        case UIW_EDIT: case UIW_MULTIEDIT: {
            const float 字 = (w->fontSize > 0.0f) ? w->fontSize : c->theme.fontSize;
            w->caret = 横坐标转光标(c, w->text, 字, x - (w->x + 8.0f));
            c->pressed = w;
            break;
        }
        case UIW_LIST: case UIW_TABLE: {
            const int 索引 = 列表行索引(c, w, x, y);
            if (索引 >= 0 && 索引 != w->selected) {
                w->selected = 索引;
                记录事件(c, UIE_SELECT_CHANGED, w, (float)索引, 0);
            }
            w->pressed = true;
            c->pressed = w;
            break;
        }
        case UIW_COMBO: case UIW_MENU: {
            if (c->popup && c->popup != w) 关闭浮层(c);
            w->expanded = !w->expanded;
            w->hotIndex = -1;
            c->popup = w->expanded ? w : nullptr;
            break;
        }
        case UIW_TABS: {
            const int 索引 = 标签索引(c, w, x);
            if (索引 >= 0 && 索引 != w->selected) {
                w->selected = 索引;
                同步标签页(w);
                记录事件(c, UIE_TAB_CHANGED, w, (float)索引, 0);
                记录事件(c, UIE_SELECT_CHANGED, w, (float)索引, 0);
            }
            break;
        }
        default:
            break;
    }
    return 0;
}

int uiw_mouse_up(void* ctx, float x, float y, int button)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    (void)button;

    UiWidget* 按下 = c->pressed;
    UiWidget* 抬起于 = 顶层命中(c, x, y);

    c->pressed = nullptr;
    c->dragSlider = nullptr;
    c->dragScroll = nullptr;

    if (!按下) return 0;
    按下->pressed = false;

    /* 移出控件后松开不算点击 */
    if (按下 != 抬起于) return 0;

    switch (按下->kind) {
        case UIW_BUTTON:
        case UIW_LINK:
        case UIW_MENU:
            记录事件(c, UIE_CLICK, 按下, 0, 0);
            break;
        case UIW_CHECKBOX:
            按下->checked = !按下->checked;
            记录事件(c, UIE_CHECK_CHANGED, 按下, 0, 按下->checked ? 1 : 0);
            记录事件(c, UIE_CLICK, 按下, 0, 0);
            break;
        case UIW_TOGGLE:
            按下->checked = !按下->checked;
            记录事件(c, UIE_CHECK_CHANGED, 按下, 0, 按下->checked ? 1 : 0);
            记录事件(c, UIE_CLICK, 按下, 0, 0);
            break;
        case UIW_RADIO: {
            const bool 变化 = !按下->checked;
            按下->checked = true;
            if (按下->group != 0) {
                for (auto* o : c->all) {
                    if (o != 按下 && o->kind == UIW_RADIO && o->group == 按下->group) {
                        o->checked = false;
                    }
                }
            }
            if (变化) 记录事件(c, UIE_CHECK_CHANGED, 按下, 0, 1);
            记录事件(c, UIE_CLICK, 按下, 0, 0);
            break;
        }
        case UIW_LIST:
        case UIW_TABLE: {
            const int 索引 = 列表行索引(c, 按下, x, y);
            if (索引 >= 0) 记录事件(c, UIE_ITEM_CLICK, 按下, (float)索引, 0);
            else            记录事件(c, UIE_CLICK, 按下, 0, 0);
            break;
        }
        default:
            记录事件(c, UIE_CLICK, 按下, 0, 0);
            break;
    }
    return 0;
}

int uiw_mouse_double_click(void* ctx, float x, float y)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    UiWidget* w = 顶层命中(c, x, y);
    if (!w) return 0;
    if (w->kind == UIW_LIST || w->kind == UIW_TABLE) {
        const int 索引 = 列表行索引(c, w, x, y);
        if (索引 >= 0) 记录事件(c, UIE_ITEM_DBLCLICK, w, (float)索引, 0);
    } else if (w->kind == UIW_EDIT || w->kind == UIW_MULTIEDIT) {
        w->caret = (int)w->text.size();
    }
    return 0;
}

int uiw_mouse_wheel(void* ctx, float delta)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;

    UiWidget* w = 顶层命中(c, c->mx, c->my);
    UiWidget* 目标 = nullptr;
    for (UiWidget* p = w; p; p = p->parent) {
        if (可滚动(p)) { 目标 = p; break; }
    }
    if (!目标) return 0;

    const float 步长 = (目标->kind == UIW_MULTIEDIT) ? 20.0f : 40.0f;
    目标->scroll = 夹取(目标->scroll - delta * 步长, 0.0f, 目标->scrollMax);
    记录事件(c, UIE_SCROLL, 目标, 目标->scroll, 0);
    return 0;
}

int uiw_key_input(void* ctx, unsigned codepoint)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    UiWidget* w = c->focused;
    if (!w) return 0;
    if (w->kind != UIW_EDIT && w->kind != UIW_MULTIEDIT) return 0;
    if (!w->enabled) return 0;
    if (codepoint < 32) return 0;

    追加UTF8(w->text, w->caret, codepoint);
    记录事件文本(c, UIE_TEXT_CHANGED, w, 0.0f, 0, w->text);
    return 0;
}

int uiw_key_special(void* ctx, int key)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    UiWidget* w = c->focused;

    if (key == 9) {          /* Tab: 焦点链 */
        const int 目标 = uiw_focus_next(ctx, (::GetKeyState(VK_SHIFT) & 0x8000) ? 1 : 0);
        (void)目标;
        return 0;
    }
    if (key == 27) {         /* Esc */
        if (c->popup) { 关闭浮层(c); return 0; }
        设焦点(c, nullptr);
        return 0;
    }
    if (!w) return 0;

    if (w->kind == UIW_EDIT || w->kind == UIW_MULTIEDIT) {
        switch (key) {
            case 8:   /* 退格 */
                if (w->caret > 0) {
                    退一字符(w->text, w->caret);
                    记录事件文本(c, UIE_TEXT_CHANGED, w, 0.0f, 0, w->text);
                }
                break;
            case 46: { /* Delete */
                if (w->caret < (int)w->text.size()) {
                    int 临时 = w->caret;
                    进一字符(w->text, 临时);
                    w->text.erase((size_t)w->caret, (size_t)(临时 - w->caret));
                    记录事件文本(c, UIE_TEXT_CHANGED, w, 0.0f, 0, w->text);
                }
                break;
            }
            case 37: { /* 左 */
                if (w->caret > 0) {
                    int i = w->caret - 1;
                    while (i > 0 && ((unsigned char)w->text[(size_t)i] & 0xC0) == 0x80) --i;
                    w->caret = i;
                }
                break;
            }
            case 39:  /* 右 */
                进一字符(w->text, w->caret);
                break;
            case 36:  /* Home */
                w->caret = 0;
                break;
            case 35:  /* End */
                w->caret = (int)w->text.size();
                break;
            case 13:  /* 回车 */
                if (w->kind == UIW_MULTIEDIT) {
                    追加UTF8(w->text, w->caret, (unsigned)'\n');
                    记录事件文本(c, UIE_TEXT_CHANGED, w, 0.0f, 0, w->text);
                }
                break;
            default:
                break;
        }
        return 0;
    }

    if (w->kind == UIW_LIST || w->kind == UIW_TABLE) {
        const int 总数 = (w->kind == UIW_TABLE) ? (int)w->rows.size() : (int)w->items.size();
        if (总数 <= 0) return 0;
        int 索引 = w->selected;
        if (key == 38) --索引;
        else if (key == 40) ++索引;
        else if (key == 36) 索引 = 0;
        else if (key == 35) 索引 = 总数 - 1;
        else return 0;
        索引 = (int)夹取((float)索引, 0.0f, (float)(总数 - 1));
        if (索引 != w->selected) {
            w->selected = 索引;
            滚到可见(c, w, 索引);
            记录事件(c, UIE_SELECT_CHANGED, w, (float)索引, 0);
        }
        return 0;
    }

    /* 空格: 触发可点击控件的点击 */
    if (key == 32) {
        switch (w->kind) {
            case UIW_CHECKBOX:
            case UIW_TOGGLE:
                w->checked = !w->checked;
                记录事件(c, UIE_CHECK_CHANGED, w, 0.0f, w->checked ? 1 : 0);
                记录事件(c, UIE_CLICK, w, 0.0f, 0);
                break;
            case UIW_RADIO:
                w->checked = true;
                if (w->group != 0) {
                    for (auto* o : c->all) {
                        if (o != w && o->kind == UIW_RADIO && o->group == w->group)
                            o->checked = false;
                    }
                }
                记录事件(c, UIE_CLICK, w, 0.0f, 0);
                break;
            case UIW_BUTTON:
            case UIW_LINK:
            case UIW_MENU:
                记录事件(c, UIE_CLICK, w, 0.0f, 0);
                break;
            case UIW_COMBO:
                if (c->popup == w) 关闭浮层(c);
                else { w->expanded = true; c->popup = w; }
                break;
            default:
                break;
        }
    }
    return 0;
}

int uiw_set_focus(void* ctx, int id)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    if (id <= 0) { 设焦点(c, nullptr); return 0; }
    UiWidget* w = 找控件(c, id);
    if (!w) return -1;
    设焦点(c, w);
    return 0;
}

int uiw_get_focus(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return (c && c->focused) ? c->focused->id : 0;
}

int uiw_focus_next(void* ctx, int back)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;

    std::vector<UiWidget*> 列表;
    for (auto* w : c->all) {
        if (可聚焦(w) && w->visible) 列表.push_back(w);
    }
    if (列表.empty()) return -1;

    int 当前 = -1;
    for (size_t i = 0; i < 列表.size(); ++i) {
        if (列表[i] == c->focused) { 当前 = (int)i; break; }
    }

    int 目标 = 0;
    if (当前 < 0) 目标 = back ? (int)列表.size() - 1 : 0;
    else if (back) 目标 = (当前 == 0) ? (int)列表.size() - 1 : 当前 - 1;
    else 目标 = (当前 + 1) % (int)列表.size();

    设焦点(c, 列表[(size_t)目标]);
    return 列表[(size_t)目标]->id;
}

int uiw_get_cursor_kind(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return c ? c->cursorKind : 0;
}

/* ---------- 事件队列 ---------- */

int uiw_ev_next(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || c->events.empty()) return 0;
    c->current = c->events.front();
    c->events.erase(c->events.begin());
    c->hasCurrent = true;
    return 1;
}

int uiw_ev_kind(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return (c && c->hasCurrent) ? c->current.kind : -1;
}

int uiw_ev_id(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return (c && c->hasCurrent) ? c->current.id : -1;
}

float uiw_ev_value(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return (c && c->hasCurrent) ? c->current.value : 0.0f;
}

int uiw_ev_flag(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return (c && c->hasCurrent) ? c->current.flag : 0;
}

int uiw_ev_name(void* ctx, char* out, int cap)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !c->hasCurrent || !out || cap <= 0) return -1;
    拷名(out, (size_t)cap, c->current.name);
    return (int)::strlen(out);
}

int uiw_ev_text(void* ctx, char* out, int cap)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !c->hasCurrent || !out || cap <= 0) return -1;
    拷名(out, (size_t)cap, c->current.text);
    return (int)::strlen(out);
}

void uiw_clear_events(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    if (c) {
        c->events.clear();
        c->hasCurrent = false;
    }
}

int uiw_pending(void* ctx)
{
    UiContext* c = (UiContext*)ctx;
    return c ? (int)c->events.size() : 0;
}

/* ---------- 便利查询 ---------- */

int uiw_hit_test(void* ctx, float x, float y)
{
    UiContext* c = (UiContext*)ctx;
    if (!c) return -1;
    /* 浮层优先 */
    if (c->popup && c->popup->expanded) {
        float ox, oy, ow, oh;
        if (浮层矩形(c, c->popup, ox, oy, ow, oh) &&
            x >= ox && x <= ox + ow && y >= oy && y <= oy + oh) {
            return c->popup->id;
        }
    }
    UiWidget* w = 顶层命中(c, x, y);
    return w ? w->id : -1;
}

int uiw_measure_text(void* ctx, const char* utf8_text, float size, float* out2)
{
    UiContext* c = (UiContext*)ctx;
    if (!c || !out2) return -1;
    const std::string s = utf8_text ? utf8_text : "";
    out2[0] = 文字宽(c, s, size);
    out2[1] = size * 1.32f;
    return 0;
}

} /* extern "C" */
