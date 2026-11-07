/* ThorVG UI Toolkit。纯 C 接口, 供火山视窗模块调用。
 *
 * 设计: 控件树、布局、命中测试、状态机、绘制与事件队列全部在原生层实现,
 *       火山侧只做薄封装并暴露可覆盖的虚拟方法钩子。
 *
 * 坐标单位为逻辑像素, 原点在左上角。颜色为 0xAARRGGBB。
 * 所有返回 int 的函数以 0 表示成功, 非 0 表示失败(除特别注明)。
 */

#ifndef THORG_UI_BRIDGE_HPP
#define THORG_UI_BRIDGE_HPP

#ifdef __cplusplus
extern "C" {
#endif

/* ---------- 控件类型 ---------- */
enum
{
    UIW_PANEL     = 0,   /* 面板/容器 */
    UIW_LABEL     = 1,   /* 文本标签 */
    UIW_BUTTON    = 2,   /* 按钮 */
    UIW_CHECKBOX  = 3,   /* 复选框 */
    UIW_RADIO     = 4,   /* 单选框 */
    UIW_SLIDER    = 5,   /* 滑块 */
    UIW_PROGRESS  = 6,   /* 进度条 */
    UIW_EDIT      = 7,   /* 单行输入框 */
    UIW_SEPARATOR = 8,   /* 分隔线 */
    UIW_COMBO     = 9,   /* 下拉框 */
    UIW_LIST      = 10,  /* 列表框 */
    UIW_TABLE     = 11,  /* 表格 */
    UIW_TABS      = 12,  /* 标签页容器 */
    UIW_TOGGLE    = 13,  /* 开关 */
    UIW_SCROLLBAR = 14,  /* 滚动条(通常由容器自动绘制, 也可单独使用) */
    UIW_GROUP     = 15,  /* 分组框(带标题边框的容器) */
    UIW_SPIN      = 16,  /* 数值框(带加减按钮) */
    UIW_MULTIEDIT = 17,  /* 多行文本框 */
    UIW_IMAGE     = 18,  /* 图片框 */
    UIW_LINK      = 19,  /* 超链接文本 */
    UIW_BADGE     = 20,  /* 徽标 */
    UIW_MENU      = 21,  /* 下拉菜单(点击展开) */
    UIW_CARD      = 22   /* 卡片容器(带投影) */
};

/* ---------- 布局方式 ---------- */
enum
{
    UIL_ABSOLUTE   = 0,  /* 绝对定位(用 x/y) */
    UIL_HORIZONTAL = 1,  /* 子控件从左往右排 */
    UIL_VERTICAL   = 2,  /* 子控件从上往下排 */
    UIL_GRID       = 3,  /* 网格(按列数自动换行) */
    UIL_STACK      = 4   /* 叠层(子控件全部填满父容器, 用于标签页内容) */
};

/* ---------- 水平对齐 ---------- */
enum { UIA_LEFT = 0, UIA_CENTER = 1, UIA_RIGHT = 2 };

/* ---------- 垂直对齐 ---------- */
enum { UIV_TOP = 0, UIV_MIDDLE = 1, UIV_BOTTOM = 2 };

/* ---------- 事件类型 ---------- */
enum
{
    UIE_CLICK          = 0,   /* 单击: id */
    UIE_VALUE_CHANGED  = 1,   /* 值改变: id + value */
    UIE_TEXT_CHANGED   = 2,   /* 文本改变: id + text */
    UIE_HOVER_ENTER    = 3,   /* 鼠标进入: id */
    UIE_HOVER_LEAVE    = 4,   /* 鼠标离开: id */
    UIE_FOCUS_GAINED   = 5,   /* 获得焦点: id */
    UIE_FOCUS_LOST     = 6,   /* 失去焦点: id */
    UIE_CHECK_CHANGED  = 7,   /* 勾选改变: id + flag(1/0) */
    UIE_SCROLL         = 8,   /* 容器滚动: id + value(新偏移) */
    UIE_SELECT_CHANGED = 9,   /* 选中项改变: id + value(索引) */
    UIE_ITEM_CLICK     = 10,  /* 列表/菜单项点击: id + value(索引) + flag(列) */
    UIE_TAB_CHANGED    = 11,  /* 标签页切换: id + value(索引) */
    UIE_POPUP_CLOSED   = 12,  /* 弹出层关闭: id */
    UIE_ITEM_DBLCLICK  = 13   /* 列表/表格项双击: id + value(索引) */
};

/* ---------- 主题色槽位 ---------- */
enum
{
    UC_BG = 0, UC_SURFACE = 1, UC_SURFACE_HI = 2, UC_SURFACE_LO = 3,
    UC_BORDER = 4, UC_FG = 5, UC_FG_DIM = 6, UC_ACCENT = 7,
    UC_ACCENT_FG = 8, UC_DISABLED = 9, UC_SHADOW = 10, UC_SELECT = 11,
    UC_SUCCESS = 12, UC_WARN = 13, UC_DANGER = 14
};

/* ---------- 主题度量槽位 ---------- */
enum { UM_RADIUS = 0, UM_FONT_SIZE = 1, UM_ROW_HEIGHT = 2, UM_BORDER = 3 };

/* ---------- 内置图标 ---------- */
enum
{
    UII_NONE = 0, UII_CHECK = 1, UII_CROSS = 2, UII_DOWN = 3, UII_UP = 4,
    UII_LEFT = 5, UII_RIGHT = 6, UII_PLUS = 7, UII_MINUS = 8, UII_DOT = 9,
    UII_STAR = 10, UII_MENU = 11, UII_SEARCH = 12, UII_GEAR = 13,
    UII_HOME = 14, UII_INFO = 15, UII_WARN = 16, UII_CLOSE = 17
};

#define UIW_NAME_MAX 64
#define UIW_TEXT_MAX 512

typedef struct UiEvent
{
    int   kind;
    int   id;
    float value;
    int   flag;
    char  name[UIW_NAME_MAX];
    char  text[UIW_TEXT_MAX];
} UiEvent;

/* ================= 上下文生命周期 ================= */
void* uiw_new(void);
void  uiw_free(void* ctx);
const char* uiw_version(void);

int   uiw_set_viewport(void* ctx, float w, float h, float scale);
float uiw_get_viewport_width(void* ctx);
float uiw_get_viewport_height(void* ctx);

/* 主题: 0 深色, 1 浅色, 2 蓝色, 3 高对比 */
int   uiw_set_theme(void* ctx, int theme);
int   uiw_set_font(void* ctx, const char* utf8_font_name);
int   uiw_set_theme_color(void* ctx, int slot, unsigned color);
int   uiw_set_theme_metric(void* ctx, int slot, float v);

/* ================= 控件创建与销毁 ================= */
int uiw_add(void* ctx, int kind, const char* name, const char* text,
            float x, float y, float w, float h);
int uiw_remove(void* ctx, int id);
int uiw_clear(void* ctx);

/* ================= 通用属性 ================= */
int   uiw_set_rect(void* ctx, int id, float x, float y, float w, float h);
int   uiw_get_rect(void* ctx, int id, float* out4);      /* x y w h */
int   uiw_set_pos(void* ctx, int id, float x, float y);
int   uiw_set_size(void* ctx, int id, float w, float h);
int   uiw_set_text(void* ctx, int id, const char* utf8_text);
int   uiw_get_text(void* ctx, int id, char* out, int cap);   /* 返回字节长度 */
int   uiw_set_value(void* ctx, int id, float v);
float uiw_get_value(void* ctx, int id);
int   uiw_set_range(void* ctx, int id, float vmin, float vmax, float step);
int   uiw_get_range(void* ctx, int id, float* out3);          /* min max step */
int   uiw_set_checked(void* ctx, int id, int on);
int   uiw_get_checked(void* ctx, int id);
int   uiw_set_enabled(void* ctx, int id, int on);
int   uiw_get_enabled(void* ctx, int id);
int   uiw_set_visible(void* ctx, int id, int on);
int   uiw_get_visible(void* ctx, int id);
int   uiw_set_font_size(void* ctx, int id, float size);
int   uiw_set_align(void* ctx, int id, int h_align);
int   uiw_set_valign(void* ctx, int id, int v_align);
int   uiw_set_wrap(void* ctx, int id, int on);              /* <=0 自动, 1 字符, 2 单词 */
int   uiw_set_colors(void* ctx, int id, unsigned bg, unsigned fg);
int   uiw_set_bg(void* ctx, int id, unsigned bg);
int   uiw_set_fg(void* ctx, int id, unsigned fg);
int   uiw_set_border(void* ctx, int id, unsigned color, float width);
int   uiw_set_radius(void* ctx, int id, float radius);
int   uiw_set_layout(void* ctx, int id, int mode, float padding, float spacing);
int   uiw_set_padding(void* ctx, int id, float l, float t, float r, float b);
int   uiw_set_margin(void* ctx, int id, float l, float t, float r, float b);
int   uiw_set_weight(void* ctx, int id, float weight);
int   uiw_set_parent(void* ctx, int child, int parent);
int   uiw_get_parent(void* ctx, int id);
int   uiw_set_scroll(void* ctx, int id, float offset);
float uiw_get_scroll(void* ctx, int id);
int   uiw_scroll_by(void* ctx, int id, float delta);
float uiw_get_scroll_max(void* ctx, int id);
int   uiw_set_group(void* ctx, int id, int group);
int   uiw_set_tag(void* ctx, int id, int tag);
int   uiw_get_tag(void* ctx, int id);
int   uiw_set_tooltip(void* ctx, int id, const char* utf8_text);
int   uiw_set_icon(void* ctx, int id, int icon, unsigned color);
int   uiw_set_grid_cols(void* ctx, int id, int cols);
int   uiw_set_row_height(void* ctx, int id, float h);
int   uiw_set_columns(void* ctx, int id, int cols);         /* 多行文本可见行数等 */
/* 图片控件: 直接给编码后的图片数据(SVG/PNG/JPG), 每次绘制重建图片对象 */
int   uiw_set_image_data(void* ctx, int id, const void* data, int size, const char* mime);

/* ================= 列表 / 表格 / 标签页 / 下拉项 ================= */
int   uiw_item_count(void* ctx, int id);
int   uiw_item_add(void* ctx, int id, const char* utf8_text);     /* 返回新索引 */
int   uiw_item_insert(void* ctx, int id, int index, const char* utf8_text);
int   uiw_item_set(void* ctx, int id, int index, const char* utf8_text);
int   uiw_item_get(void* ctx, int id, int index, char* out, int cap);
int   uiw_item_remove(void* ctx, int id, int index);
int   uiw_item_clear(void* ctx, int id);
int   uiw_item_check(void* ctx, int id, int index, int on);       /* 列表项多选标记 */
int   uiw_item_checked(void* ctx, int id, int index);

int   uiw_col_add(void* ctx, int id, const char* utf8_title, float width);
int   uiw_col_count(void* ctx, int id);
int   uiw_col_set_width(void* ctx, int id, int col, float width);
int   uiw_col_clear(void* ctx, int id);
int   uiw_row_add(void* ctx, int id, const char* utf8_cells);      /* 用 '|' 分隔单元格 */
int   uiw_row_set(void* ctx, int id, int row, const char* utf8_cells);
int   uiw_row_remove(void* ctx, int id, int row);
int   uiw_row_clear(void* ctx, int id);
int   uiw_row_count(void* ctx, int id);

int   uiw_tab_add(void* ctx, int id, const char* utf8_title);     /* 标签页: 新建页 */
int   uiw_select(void* ctx, int id, int index);
int   uiw_selected(void* ctx, int id);

/* ================= 查找与遍历 ================= */
int uiw_find(void* ctx, const char* name);
int uiw_count(void* ctx);
int uiw_at(void* ctx, int index);                  /* 按索引取控件 id */
int uiw_get_state(void* ctx, int id);              /* 位0 悬停 1 按下 2 焦点 3 勾选 4 展开 */

/* ================= 布局与绘制 ================= */
/* 脏标记: 界面状态(悬停/焦点/取值/选中/展开)发生变化后返回 1 并清除标记。
 * 宿主据此决定是否需要重绘, 避免鼠标划过时每帧全量重绘。 */
int uiw_take_dirty(void* ctx);
int uiw_layout(void* ctx);
int uiw_draw(void* ctx, void* thorvg_canvas);
int uiw_popup_close(void* ctx);
int uiw_popup_open(void* ctx);

/* ================= 输入 ================= */
int uiw_mouse_move(void* ctx, float x, float y);
int uiw_mouse_down(void* ctx, float x, float y, int button);
int uiw_mouse_up(void* ctx, float x, float y, int button);
int uiw_mouse_double_click(void* ctx, float x, float y);
int uiw_mouse_wheel(void* ctx, float delta);
int uiw_key_input(void* ctx, unsigned codepoint);
int uiw_key_special(void* ctx, int key);   /* 8 退格 9 Tab 13 回车 27 Esc 37-40 方向 45 46 Del 36 35 Home End */

int uiw_set_focus(void* ctx, int id);
int uiw_get_focus(void* ctx);
int uiw_focus_next(void* ctx, int back);
int uiw_get_cursor_kind(void* ctx);        /* 0 箭头 1 手形 2 文本 3 拖动 */

/* ================= 事件队列 ================= */
int   uiw_ev_next(void* ctx);
int   uiw_ev_kind(void* ctx);
int   uiw_ev_id(void* ctx);
float uiw_ev_value(void* ctx);
int   uiw_ev_flag(void* ctx);
int   uiw_ev_name(void* ctx, char* out, int cap);
int   uiw_ev_text(void* ctx, char* out, int cap);
void  uiw_clear_events(void* ctx);
int   uiw_pending(void* ctx);

/* ================= 便利查询 ================= */
int uiw_hit_test(void* ctx, float x, float y);
int uiw_measure_text(void* ctx, const char* utf8_text, float size, float* out2); /* 宽 高 */

#ifdef __cplusplus
}
#endif

#endif /* THORG_UI_BRIDGE_HPP */
