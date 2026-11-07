# Konva WebView2 火山视窗封装说明

本项目使用火山视窗 `Edge浏览框` 承载本地 `assets/konva.js`。火山侧通过 `Konva画布框` 发送 JSON 命令，页面侧由 `assets/konva_bridge.js` 调用 Konva API。

## 文件

- `src/KonvaWebView2.wsv`: 测试程序启动类和测试窗口。
- `src/KonvaApiWrappers.wsv`: 独立工具模块文件，包含 `Konva绘图工具`、`Konva画布框` 和从本地 `assets/konva.js` 反射生成的 30 个 Konva API 显式类封装。
- `assets/AppStartPage.html`: WebView2 加载的测试页面。
- `assets/konva.js`: 本地 Konva 源文件。
- `assets/konva_bridge.js`: Konva 命令桥接层。
- `assets/styles.css`: 测试页面样式。
- `docs/konva_api_map.json`: 从本地 `konva.js` 生成的 API 清单。
- `docs/konva_local_wrapper_map.json`: 本次显式封装使用的本地类/方法清单。
- `tools/generate_konva_wrappers.js`: 重新从本地 `konva.js` 生成显式封装类的脚本。
- `tools/konva_core_prelude.wsvinc`: 生成 `KonvaApiWrappers.wsv` 时写入文件顶部的核心类模板。

## 加载方式

- `加载调试目录页面`: 调试时直接映射 `C:\Users\bmy\Documents\Konvajs封装\assets`，避免运行目录没有复制资源导致 WebView2 提示未找到文件。
- `加载运行目录页面`: 发布时映射 `取运行目录() + "assets"`，配合 `Konva画布框` 上的 `@视窗.附属文件 = "..\\assets > assets"` 自动复制资源。
- `加载本地页面`: 底层方法，可传任意映射目录。

## 常用封装方法

- `初始化画布`: 初始化 Konva Stage。
- `调整画布尺寸`: 修改 Stage 尺寸。
- `置绘图工具`: 切换选择、矩形、圆形、椭圆、直线、自由画笔。
- `添加矩形`: 添加可拖放矩形。
- `添加圆形`: 添加可拖放圆形。
- `添加椭圆`: 添加可拖放椭圆。
- `添加文本`: 添加可拖放文本。
- `修改图形尺寸`: 修改选中或指定图形大小。
- `修改图形属性`: 设置指定图形 attrs。
- `删除图形`: 删除选中或指定图形。
- `清空画布`: 清空所有图形。
- `取画布JSON`: 返回 `stage.toJSON()`。
- `导出PNG数据URL`: 返回 PNG Data URL。

## ECharts 风格方法

参考 `ECcharts` 知识库里的 ECharts 模块风格，`Konva画布框` 额外提供一组更贴近火山模块习惯的高层方法：

- `取文本`: 返回当前 Stage JSON，等同于 `取画布JSON`。
- `清空参数`: 清空画布，等同于 `清空画布`。
- `画图`: 立即调用默认图层 `draw()`。
- `更新重画`: 调用默认图层 `batchDraw()`，适合连续修改后合并刷新。
- `执行JS脚本`: 直接执行一段 JS 文本。
- `执行JS脚本2`: 把 JS 文本包成函数体执行，需要结果时写 `return ...`。
- `截图`: 返回 PNG Data URL，等同于 `导出PNG数据URL`。
- `取版本`: 返回当前加载的 `Konva.version`。
- `取参数(参数名)`: 读取 Konva 全局配置或公开值，参数名使用 `version`、`pixelRatio` 这类点路径。
- `置参数(参数名, 参数值JSON)`: 写入 Konva 全局配置值，参数值必须是 JSON 值文本。
- `取图形参数(ID, 参数名)`: 读取指定图形或当前选中图形的属性/无参方法值。
- `置图形参数(ID, 参数名, 参数值JSON)`: 设置指定图形或当前选中图形的单个 attrs 参数。
- `重置`: 清空画布并恢复选择工具。

## 全量 Konva 网关

Konva 的类、原型方法、getter/setter 和工具函数很多，且版本升级会变化。本封装从本地 `assets/konva.js` 反射生成 30 个中文类及其公开原型方法；同时保留以下通用网关，用来覆盖未单独生成中文类的静态函数、全局配置和动态对象调用。

- `取Konva接口清单`: 返回当前 `konva.js` 的类、静态成员、原型方法 JSON。
- `调用Konva静态函数(路径, 参数JSON, 超时)`: 调用 `Konva` 下任意静态函数，例如 `Util.getRandomColor`。
- `读Konva值(路径)`: 读取 `Konva.version`、`Konva.pixelRatio` 等公开值。
- `写Konva值(路径, 值JSON)`: 写入 `Konva` 全局配置值。
- `创建Konva对象(类名, 构造参数JSON, 加入目标)`: 创建任意 Konva 类实例，例如 `Star`、`RegularPolygon`、`Tween`。
- `调用图形方法(ID, 方法名, 参数JSON, 超时)`: 调用任意节点方法。特殊 ID: `$stage`、`$layer`、`$transformer`。
- `读图形值(ID, 名称)`: 读取任意节点的属性或无参方法返回值。
- `调用Konva对象方法(对象ID, 方法名, 参数JSON, 超时)`: 调用非节点对象方法。
- `释放Konva对象(对象ID)`: 释放桥接层保存的非节点对象引用。

## 显式类封装

`src/KonvaApiWrappers.wsv` 按本地 `assets/konva.js` 反射生成，不依赖线上文档。该文件已经包含运行所需的 `Konva绘图工具`、`Konva画布框`，可作为独立工具模块引用。当前本地 Konva 版本为 `10.3.0`，另生成以下 30 个 Konva API 类：

`Konva变换`、`Konva绘图上下文`、`Konva画布`、`Konva节点`、`Konva容器`、`Konva舞台`、`Konva图形`、`Konva图层`、`Konva快速图层`、`Konva分组`、`Konva动画`、`Konva补间动画`、`Konva弧形`、`Konva线条`、`Konva路径`、`Konva箭头`、`Konva圆形`、`Konva椭圆`、`Konva图像`、`Konva标签组`、`Konva标签背景`、`Konva矩形`、`Konva正多边形`、`Konva圆环`、`Konva精灵`、`Konva星形`、`Konva文本`、`Konva路径文本`、`Konva变换器`、`Konva扇形`。

中文类名和中文方法名用于火山侧调用；原始 JS 类名和方法名保留在注释里，并作为内部 WebView2 转发目标。

每个类都有：

- `绑定画布`: 绑定 `Konva画布框`。
- 节点类提供 `绑定节点`、`创建`、`取节点ID`。
- 非节点类提供 `绑定对象ID`、`创建`、`取对象ID`、`释放`。
- 本地 `konva.js` 原型链上的每个公开方法都会生成一个同名火山方法。

所有 JS 方法统一使用 `参数JSON` 传参。例如 `rect.width(100)` 对应：

```volcano
矩形.宽度 ("[100]", 2000)
```

`rect.position({x:10,y:20})` 对应：

```volcano
矩形.位置 ("[{\"x\":10,\"y\":20}]", 2000)
```

参数 JSON 支持引用桥接层对象：

- `{"$node":"rect1"}`: 引用指定节点。
- `{"$selectedNode":true}`: 引用当前选中节点。
- `{"$object":"konva_1"}`: 引用网关返回的非节点对象。

## 示例

### 中文类封装示例

下面是当前测试窗口使用的写法。页面 ready 后先绑定画布，再通过中文类创建可拖放图形；输入框宽高可以继续调用中文方法修改尺寸。

```volcano
变量 画布 <类型 = Konva画布框>
变量 矩形 <类型 = Konva矩形>
变量 圆形 <类型 = Konva圆形>
变量 星形 <类型 = Konva星形>
变量 文本 <类型 = Konva文本>

画布.绑定浏览框 (Edge浏览框1)
矩形.绑定画布 (画布)
圆形.绑定画布 (画布)
星形.绑定画布 (画布)
文本.绑定画布 (画布)

矩形.创建 ("demo_rect", "[{\"x\":80,\"y\":90,\"width\":180,\"height\":100,\"fill\":\"#f59e0b\",\"stroke\":\"#7c2d12\",\"strokeWidth\":2,\"cornerRadius\":8,\"draggable\":true}]", "layer")
圆形.创建 ("demo_circle", "[{\"x\":360,\"y\":140,\"radius\":52,\"fill\":\"#22c55e\",\"stroke\":\"#14532d\",\"strokeWidth\":2,\"draggable\":true}]", "layer")
星形.创建 ("demo_star", "[{\"x\":560,\"y\":145,\"numPoints\":5,\"innerRadius\":28,\"outerRadius\":64,\"fill\":\"#38bdf8\",\"stroke\":\"#075985\",\"strokeWidth\":2,\"draggable\":true}]", "layer")
文本.创建 ("demo_text", "[{\"x\":80,\"y\":240,\"text\":\"中文 Konva 封装测试\",\"fontSize\":22,\"fill\":\"#111827\",\"width\":720,\"draggable\":true}]", "layer")

矩形.宽度 ("[220]", 2000)
矩形.高度 ("[120]", 2000)
圆形.半径 ("[70]", 2000)
星形.外半径 ("[80]", 2000)
文本.文本 ("[\"当前尺寸已经通过中文封装方法修改\"]", 2000)

// ECharts 风格参数入口
调试输出 (画布.取参数 ("version"))
画布.置图形参数 ("demo_rect", "fill", "\"#22c55e\"")
调试输出 (画布.取图形参数 ("demo_rect", "fill"))
画布.更新重画 ()
```

鼠标交互绘图仍然走 `Konva画布框.置绘图工具`：

```volcano
画布.置绘图工具 (Konva绘图工具.矩形, "#2f80ed", "#1f2937")
画布.置绘图工具 (Konva绘图工具.圆形, "#22c55e", "#14532d")
画布.置绘图工具 (Konva绘图工具.自由画笔, "#2f80ed", "#1f2937")
```

### 通用网关示例

```volcano
// 读取本地 Konva 版本
调试输出 (画布.读Konva值 ("version"))

// 创建一个 Star 节点并加入默认 layer
调试输出 (画布.创建Konva对象 ("Star", "[{\"id\":\"star1\",\"x\":300,\"y\":180,\"numPoints\":5,\"innerRadius\":25,\"outerRadius\":60,\"fill\":\"#f97316\",\"stroke\":\"#7c2d12\",\"draggable\":true}]", "layer"))

// 调用节点方法旋转图形
画布.调用图形方法 ("star1", "rotation", "[25]", 2000)

// 读取节点旋转角度
调试输出 (画布.读图形值 ("star1", "rotation"))

// 创建 Tween 时把已有节点作为 node 参数传入
调试输出 (画布.创建Konva对象 ("Tween", "[{\"node\":{\"$node\":\"star1\"},\"duration\":0.5,\"rotation\":90}]", "none"))
```

## 测试方式

用火山视窗 IDE 打开 `KonvaWebView2.vsln` 或 `KonvaWebView2.vprj`。运行后可拖放默认图形、鼠标绘制图形、输入宽高修改选中图形，并通过 `输出JSON` 查看序列化结果。
