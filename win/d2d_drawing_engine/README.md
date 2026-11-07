# D2D Drawing Engine

这是面向火山视窗封装的 Direct2D 绘制类库，目标是在火山代码里更方便地使用 Direct2D、DirectWrite、WIC 和 SVG 绘制能力。类库按层拆分：绘制引擎层保持独立，不依赖 MFC 组件；组件层在绘制层之上封装可放到窗口里的 D2D 控件。

## 包含内容

- `D2D绘制引擎.wsv`：核心 D2D 绘制封装，支持窗口句柄绑定、自动重画、图元、文本、画刷、位图、路径几何、裁剪、状态保存等能力。
- 高级绘制能力：支持矩阵平移/缩放/旋转/斜切/相乘，几何布尔合并、简化、扩宽、轮廓、几何组，文本布局度量和坐标命中测试。
- `D2D内存画板.wsv`：离屏内存画板，支持在内存中绘制图形、文字、传统图片、SVG 图片，并导出 PNG/BMP/JPG/GIF/TIFF 字节集或 `位图对象类`。创建画板时会自动按 `取屏幕DPI()` 适配高清缩放。
- `D2D绘制组件.wsv`：D2D 组件层，目前包含 `D2D按钮`，可用于测试和扩展标准火山视窗组件式控件。
- `SVG绘制库.wsv` 与 `native/third_party`：随类库携带的 SVG 渲染依赖，示例中可直接绘制 SVG 文件。
- `examples`：示例工程与示例源码，演示窗口绘制、组件绘制、内存画板和兼容火山画板接口的内存画板。

## 安装方式

安装时可以直接复制整个 `d2d_drawing_engine` 目录到火山用户模块目录：

```text
你的火山安装目录\plugins\vprj_win\classlib\user
```

复制后，在具体火山视窗项目中添加本目录内的 `.vgrp` 模块定义文件即可引用类库：

- `D2D绘制引擎.vgrp`：独立 D2D/DirectWrite/WIC 绘制层。
- `D2D绘制组件.vgrp`：D2D 组件层，依赖绘制层。

`D2D绘制引擎.vgrp` 同时包含 `D2D内存画板.wsv`，提供离屏内存画板、兼容火山画板接口的内存画板、PNG/BMP/JPG/GIF/TIFF 字节集导出，以及 `位图对象类` 输出。

本目录附带 `examples` 示例目录。示例工程为了方便打开和调试，直接引用本目录内的 `.wsv` 源文件；这不影响用户项目通过 `.vgrp` 方式引用类库。

当前核心窗口绘制层基于 `ID2D1HwndRenderTarget`，已覆盖 D2D1 HWND 管线内的常用和高级绘制功能。D2D 1.1 `ID2D1DeviceContext` 的 Effect、CommandList、DirectComposition 等属于另一条设备上下文渲染管线，后续如需要可单独升级，不与当前稳定接口混写。

当前活动 `.wsv/.vprj/.vsln/.vgrp` 文件保持 UTF-8。编辑时请保留原编码，避免火山 IDE 无法解析。
