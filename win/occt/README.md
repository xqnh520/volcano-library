# OCCT 8.0 二维 CAD 火山视窗封装

本模块面向火山视窗 C++17/VS2022 生成工具，封装 Open CASCADE Technology 8.0 的二维 CAD 查看与编辑基础能力。完整可用源码在 `src/occt_2d.wsv`，原生桥接在 `native/occt_2d_bridge.hpp` 和 `native/occt_2d_bridge.cpp`。包属性已设置 `@视窗.附加编译参数 = "cpp: /std:c++17"`，否则 OCCT 8.0 头文件中的 `std::optional`、`std::variant` 和 inline variable 会编译失败。链接库采用 `@视窗.库文件搜寻目录.x64` 加逗号分隔 `@视窗.外部库.x64` 库文件名的方式。

## 模块范围

| 范围 | 火山类 | OCCT 类/模块 | 头文件 |
|---|---|---|---|
| 基础数据 | `OCCT二维点` | `gp_Pnt2d` | `gp_Pnt2d.hxx` |
| 基础数据 | `OCCT二维向量` | `gp_Vec2d` | `gp_Vec2d.hxx` |
| 基础数据 | `OCCT二维方向` | `gp_Dir2d` | `gp_Dir2d.hxx` |
| 基础数据 | `OCCT二维坐标轴` | `gp_Ax2d` | `gp_Ax2d.hxx` |
| 基础数据 | `OCCT二维变换` | `gp_Trsf2d` | `gp_Trsf2d.hxx` |
| 2D 几何 | `OCCT二维曲线` | `Handle(Geom2d_Curve)` | `Geom2d_Curve.hxx` |
| 2D 几何 | `OCCT二维直线` | `Geom2d_Line` | `Geom2d_Line.hxx` |
| 2D 几何 | `OCCT二维圆` | `Geom2d_Circle` | `Geom2d_Circle.hxx` |
| 2D 几何 | `OCCT二维贝塞尔曲线` | `Geom2d_BezierCurve` | `Geom2d_BezierCurve.hxx`, `NCollection_Array1.hxx` |
| 2D 算法 | `OCCT二维投影器` | `Geom2dAPI_ProjectPointOnCurve` | `Geom2dAPI_ProjectPointOnCurve.hxx` |
| 2D 算法 | `OCCT二维交点计算` | `Geom2dAPI_InterCurveCurve` | `Geom2dAPI_InterCurveCurve.hxx` |
| 拓扑构建 | `OCCT二维边` | `BRepBuilderAPI_MakeEdge2d` | `BRepBuilderAPI_MakeEdge2d.hxx` |
| 拓扑构建 | `OCCT二维线框` | `BRepBuilderAPI_MakeWire` | `BRepBuilderAPI_MakeWire.hxx` |
| 可视化交互 | `OCCT二维视图器` | `V3d_View`, `V3d_Viewer`, `AIS_InteractiveContext`, `AIS_Shape`, `WNT_Window`, `OpenGl_GraphicDriver` | `V3d_View.hxx`, `V3d_Viewer.hxx`, `AIS_InteractiveContext.hxx`, `AIS_Shape.hxx`, `WNT_Window.hxx`, `OpenGl_GraphicDriver.hxx` |
| 低层渲染模块 | `OCCT显示连接`, `OCCTOpenGL图形驱动`, `OCCTV3d查看器`, `OCCTWNT窗口`, `OCCTV3d视图` | `Aspect_DisplayConnection`, `OpenGl_GraphicDriver`, `V3d_Viewer`, `WNT_Window`, `V3d_View` | `Aspect_DisplayConnection.hxx`, `OpenGl_GraphicDriver.hxx`, `V3d_Viewer.hxx`, `WNT_Window.hxx`, `V3d_View.hxx` |
| 文件读写 | `OCCT二维形状` | `TopoDS_Shape`, `BRepTools` | `TopoDS_Shape.hxx`, `BRepTools.hxx` |

## 火山方法列表

### `OCCT二维点`

| 方法 | 参数映射 | 返回映射 | 说明 |
|---|---|---|---|
| `创建` | `小数 横坐标/纵坐标 -> double` | `OCCT二维点 -> gp_Pnt2d*` | 创建点 |
| `横坐标`, `纵坐标` | 无 | `小数 -> double` | 读取坐标 |
| `置坐标` | `小数 -> double` | 无 | 修改坐标 |
| `距离` | `OCCT二维点 -> gp_Pnt2d*` | `小数 -> double` | 两点距离 |
| `平移` | `小数 DX/DY -> gp_Vec2d` | `OCCT二维点` | 返回新点 |
| `变换` | `OCCT二维变换 -> gp_Trsf2d*` | `OCCT二维点` | 返回变换后的新点 |

### `OCCT二维向量`, `OCCT二维方向`, `OCCT二维坐标轴`, `OCCT二维变换`

| 类 | 方法 | 参数映射 | 返回映射 | 说明 |
|---|---|---|---|---|
| `OCCT二维向量` | `创建`, `从两点创建`, `横分量`, `纵分量`, `长度`, `点积`, `叉积`, `单位化` | `小数/OCCT二维点/OCCT二维向量` | `OCCT二维向量/小数` | 向量创建与运算 |
| `OCCT二维方向` | `创建`, `横分量`, `纵分量`, `夹角` | `小数/OCCT二维方向` | `OCCT二维方向/小数` | 单位方向 |
| `OCCT二维坐标轴` | `创建`, `位置`, `方向`, `夹角` | `小数/OCCT二维坐标轴` | `OCCT二维点/OCCT二维方向/小数` | 二维轴 |
| `OCCT二维变换` | `创建`, `置平移`, `置旋转`, `置缩放`, `矩阵值` | `小数/整数` | `OCCT二维变换/小数` | 平移、旋转、缩放 |

### `Geom2d` 曲线

| 类 | 方法 | 参数映射 | 返回映射 | 说明 |
|---|---|---|---|---|
| `OCCT二维曲线` | `类型`, `起始参数`, `结束参数`, `是否闭合`, `取点` | `小数 参数值 -> double` | `整数/小数/逻辑型/OCCT二维点` | 曲线公共能力 |
| `OCCT二维直线` | `创建` | `位置点和方向 -> gp_Pnt2d/gp_Dir2d` | `Handle(Geom2d_Line)` | 创建直线 |
| `OCCT二维圆` | `创建` | `圆心、X轴方向、半径` | `Handle(Geom2d_Circle)` | 创建圆 |
| `OCCT二维贝塞尔曲线` | `创建四点` | `4 个控制点坐标 -> NCollection_Array1<gp_Pnt2d>` | `Handle(Geom2d_BezierCurve)` | 创建三次 Bezier |

### 算法与拓扑

| 类 | 方法 | 参数映射 | 返回映射 | 说明 |
|---|---|---|---|---|
| `OCCT二维投影器` | `创建`, `数量`, `点`, `参数值`, `距离`, `最近点`, `最小距离` | `OCCT二维点/OCCT二维曲线/整数` | `整数/小数/OCCT二维点` | 点到曲线投影 |
| `OCCT二维交点计算` | `创建`, `数量`, `点` | `OCCT二维曲线/小数 容差/整数` | `整数/OCCT二维点` | 曲线交点 |
| `OCCT二维边` | `从两点创建`, `从曲线创建`, `是否完成`, `错误码` | `OCCT二维点/OCCT二维曲线/小数` | `OCCT二维边/逻辑型/整数` | 二维拓扑边 |
| `OCCT二维线框` | `创建`, `加边`, `是否完成`, `错误码`, `边数` | `OCCT二维边` | `OCCT二维线框/逻辑型/整数` | 线框构建 |

### 可视化与交互

| 类 | 方法 | 参数映射 | 返回映射 | 说明 |
|---|---|---|---|---|
| `OCCT二维视图器` | `绑定窗口`, `关闭` | `变整数 HWND -> Aspect_Handle` | `逻辑型` | 创建/释放 V3d/AIS/OpenGL 视图 |
| `OCCT二维视图器` | `显示边`, `显示线框`, `显示曲线`, `显示测试网格`, `显示填充线框`, `显示填充形状` | `OCCT二维边/线框/曲线/形状`, `整数 RGB`, `小数 线宽` | `逻辑型` | 显示二维对象和闭合填充图形 |
| `OCCT二维视图器` | `调整尺寸`, `重绘`, `适配全部`, `清空显示` | 无 | `逻辑型` | 常用视图操作 |
| `OCCT二维视图器` | `置背景颜色` | `整数 红/绿/蓝 -> Quantity_Color` | `逻辑型` | 设置视图背景颜色 |
| `OCCT二维视图器` | `平移`, `缩放框`, `开始旋转`, `旋转到` | `整数 屏幕坐标/偏移` | `逻辑型` | 交互操作 |
| `OCCT二维视图器` | `移动检测`, `选择检测项` | `整数 屏幕坐标` | `整数 状态码` | AIS 动态检测与选择 |
| `OCCT二维视图器` | `按比例缩放`, `屏幕点到模型点`, `显示形状` | `小数 缩放比例/整数 屏幕坐标/OCCT二维形状` | `逻辑型/OCCT二维点` | 鼠标绘制和文件回显 |
| `OCCT二维边/线框/形状` | `保存BREP`, `保存DXF`, `从BREP读取`, `从DXF读取` | `文本型 文件名` | `逻辑型/OCCT二维形状` | OCCT BREP 与基础 AutoCAD DXF 文件读写 |
| `OCCTV3d视图` | `绑定窗口`, `置二维投影`, `置背景颜色`, `调整尺寸`, `重绘`, `适配全部`, `平移`, `缩放框`, `按比例缩放`, `屏幕点到模型点` | `OCCTWNT窗口/整数/小数` | `逻辑型/OCCT二维点` | 低层 V3d_View 操作 |

## 测试窗口

打开 `examples/simple_window/OCCT二维测试.vsln`。示例窗口会：

- 使用顶部工具按钮切换不同图形：矩形、圆、贝塞尔曲线、组合图形和清空。
- 将 `OCCT二维视图器` 绑定到下方 `图片框` 承载区。原生层会在图片框内部创建专用 OpenGL 子渲染窗口，图片框只作为宿主，避免控件背景重绘和 OCCT 交换缓冲互相抢画面。
- 默认显示组合图形：XY 网格、矩形线框、圆、贝塞尔曲线和两条辅助斜线。
- 初始化阶段仍会计算直线与圆的交点，用于验证 `Geom2dAPI_InterCurveCurve` 封装可用。
- 顶部按钮支持放大、缩小、适配全部、填充显示、背景色切换、DXF 保存/打开、BREP 保存/打开。
- 视图区支持鼠标交互：左键拖动绘制直线，右键拖动平移，滚轮缩放；窗口底部标签实时显示鼠标所在模型坐标。
- 右侧预览区专门测试低层 `V3d_View + WNT_Window + OpenGl_GraphicDriver` 封装链路：`低层` 按钮重新初始化并显式调用 `WNT_Window.Map/IsMapped/取渲染窗口句柄`，随后通过低层 `V3d_Viewer` 懒创建 `AIS_InteractiveContext` 显示测试网格；`低背` 切换背景，`低缩` 调用 `V3d_View.Zoom` 缩放框和比例缩放；右侧区域也支持左键拖动缩放框、滚轮缩放、右键平移和坐标转换。
- 示例窗口采用两行工具栏和紧凑左右绘图区布局，避免在高 DPI 缩放环境下右侧低层绘图区被挤出窗口可视范围。
- `存DXF` 会把鼠标绘制草图保存为基础 AutoCAD DXF 文件；如果尚未绘制草图，则保存示例矩形线框。`开DXF` 支持读取 `LINE`、`CIRCLE`、`ARC`、`LWPOLYLINE` 和基础 `POLYLINE/VERTEX`。
- `存BREP` / `开BREP` 保留 OCCT 原生 BREP 文件读写，用于本封装内部或 OCCT 生态数据交换。

运行时依赖采用目录附属文件方式，编译后由火山把目录内文件复制到结果目录。当前附属目录包括 OCCT 的 `win64\vc14\bin`，以及 `tbb`、`jemalloc`、`openvr`、`freeimage`、`ffmpeg`、`freetype`、`msvc-vc14-64` 这些 3rdparty 运行时目录。这样比逐个 DLL 声明更不容易遗漏间接依赖。当前示例输出目录已做递归 PE 导入检查，除 Windows 系统 DLL 外没有未解析的 OCCT/三方 DLL。

## 内存规则

所有火山封装对象都保存原生指针。`创建`、`取点`、`平移`、`变换`、算法结果等会产生新原生对象，正式程序应在对象不再使用时调用 `释放()` 或视图器的 `关闭()`。OCCT `Handle(...)` 对象保存在原生桥接结构里，释放外层指针时由 C++ 析构自动释放，避免手动释放句柄导致悬空引用。

## 渲染窗口说明

`OCCT二维视图器.绑定窗口()` 需要传入一个火山窗口组件的 HWND，例如示例中的 `图片框.取窗口句柄()`。绑定后原生桥接会自动创建一个填满该组件的子窗口，并把 `WNT_Window` 绑定到这个子窗口。这样比直接让图片框承载 OpenGL 更稳定，拖动画线、缩放和平移时不容易因为宿主控件擦背景而闪烁。

## 低层 V3d 模块

如果不想使用一体化的 `OCCT二维视图器`，可以自行组合低层渲染管线：

```text
显示连接 = OCCT显示连接.创建()
图形驱动 = OCCTOpenGL图形驱动.创建(显示连接)
查看器 = OCCTV3d查看器.创建(图形驱动)
查看器.打开默认灯光()
窗口 = OCCTWNT窗口.创建子渲染窗口(绘图区.取窗口句柄())
视图 = 查看器.创建视图()
视图.绑定窗口(窗口)
视图.置二维投影()
视图.置背景颜色(250, 252, 255)
视图.调整尺寸()
视图.重绘()
```

推荐释放顺序：先释放 `OCCTV3d视图`，再释放 `OCCTWNT窗口`、`OCCTV3d查看器`、`OCCTOpenGL图形驱动`、`OCCT显示连接`。`OCCTWNT窗口` 内部仍会创建专用 OpenGL 子窗口，避免直接渲染到火山控件导致闪烁。

## OpenGL / OpenGl_* 模块

除低层 V3d 管线外，本封装还提供完整的 OpenGL 中文接口：底层 `gl*` 接口（`OCCTOpenGL常量`、`OCCTOpenGL`、`OCCTOpenGL上下文`），以及 OCCT 对象封装（`OCCTOpenGL设备上下文`、`OCCTOpenGL视图`、`OCCTOpenGL窗口`、`OCCTOpenGL图形驱动`、`OCCTOpenGL着色器管理器`、`OCCTOpenGL着色器程序`、`OCCTOpenGL纹理`、`OCCTOpenGL帧缓冲`），并打通 `OCCT结构管理器` → `OCCT图形结构` → `OCCT图形组` → `OCCT图形外观` → `OCCTOpenGL结构` / `OCCTOpenGL组` / `OCCTOpenGL外观` 的渲染对象链路。完整类与方法说明见 `docs/OpenGL中文API.md`。

## 安装位置说明（已安装类库副本）

本目录是安装到火山视窗类库目录后的副本，位置为 `D:\Voldev\plugins\vprj_win\classlib\user\occt`。

- 源码位于 `src/occt_2d.wsv`，与工作区 `occt_2d_volcano/src/occt_2d.wsv` **字节一致**，同步方式就是直接覆盖这两个文件（`occt_2d.wsv` 与 `occt_2d.vgrp`），不需要改任何相对路径。
- 类库定义文件为 `occt_2d.vgrp`（版本 8，过滤器 `OCCT二维`）。旧文件名 `occt2d.vgrp` 已废弃。
- 工程内的 `examples/`、`tests/`、`以封装模块记录.txt` 不随类库安装，示例请回工作区 `occt_2d_volcano/examples/` 打开。
- `lib/opencascade-8.0.0-vc14-64/src/` 下的 Shaders、StdResource、XSTEPResource、UnitsAPI、XmlOcafResource、Textures 等运行时资源已补齐；要真正生效需在程序里把 `CSF_OCCTResourcePath` 指向该资源目录，或把这些目录加进 `@视窗.附属文件`。

### 本次安装状态（2026-11-02 19:52）

- 规模：**589 个类 / 4402 个方法条目**（手写封装 + 生成包）。
- 生成包（6 批）：PrsDim 23 类/94 条、Font 5 类/28 条、TDocStd 9 类/76 条、TDataStd 34 类/232 条、BRepOffsetAPI 12 类/81 条、BRepFeat 13 类/88 条。由 `tools/gen_package.py` 生成，命名与注释全中文。
- 同步文件共 4 个：`src/occt_2d.wsv`、`native/occt_2d_bridge.cpp`、`native/occt_2d_bridge.hpp`、`occt_2d.vgrp`，均与工作区 md5 一致。
- 同步方式：新建工程引用本目录的 `occt_2d.vgrp` 即可，`@视窗.外部源文件` 与库路径都写成相对于 `src\` 的 `..\native`、`..\lib\...`，布局与工作区一致，**改代码不需要再改任何相对路径**。
- 装机验证：`examples/cad_command_window` 用本安装副本编译通过，`0 个警告 / 成功 1 / 失败 0`。

重新同步命令（工作区根目录）：

```bash
cp occt_2d_volcano/src/occt_2d.wsv      "D:/Voldev/plugins/vprj_win/classlib/user/occt/src/"
cp occt_2d_volcano/occt_2d.vgrp         "D:/Voldev/plugins/vprj_win/classlib/user/occt/"
cp occt_2d_volcano/native/occt_2d_bridge.* "D:/Voldev/plugins/vprj_win/classlib/user/occt/native/"
python tools/deploy.py --compile cad_command_window   # 一条命令：备份+复制+校验+装机编译
```
