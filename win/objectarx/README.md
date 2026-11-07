# ObjectARX 几何 / 数据库 用户模块

把 ObjectARX 2026 (R25) 的 AcGe 几何库和 AcDb 实体读写封成火山视窗用户模块，供任意视窗工程从「模块」列表直接取用。

- 权威源在 `E:\火山视窗\cadARX\lib\`（`.wsv`）与 `E:\火山视窗\cadARX\native\`、`arx\`（C 桥）。
- 本目录里的两份 `.wsv` 由 `E:\火山视窗\cadARX\install_arx_module.py` 从权威源复制生成，**只改写包头的构建属性路径**（绝对路径 → 模块内相对路径），正文逐行一致。
- 类库有更新时重跑那个脚本即可覆盖本副本；不要手改本目录里的 `.wsv`，下次重跑会被抹掉。

## 目录

```
objectarx\
  ObjectARX几何.vgrp              模块清单: 一个 .wsv, 依赖 视窗基本类
  ObjectARX数据库.vgrp            模块清单: 一个 .wsv, 声明依赖 ObjectARX几何
  w_ObjectARX_几何.wsv            AcGe 封装: 点/向量/矩阵/直线/线段/平面/有界平面/圆弧/椭圆弧/射线/点实体/容差/区间
  w_ObjectARX_数据库.wsv          AcDb 封装: 块记录/直线/圆/多段线/曲线量测/实体生命周期/图层表
  native\arx_ge_bridge.cpp|.h     AcGe 侧 C 桥, 由 外部源文件 属性直接参与编译
  sdk\inc\                        ObjectARX 2026 SDK 头 (677 个文件 / 18.9 MB)
  sdk\lib-x64\                    ObjectARX 2026 SDK 导入库 (34 个 / 23.7 MB), 含 acge25.lib
  arx\arx_db_bridge.h             AcDb 侧桥接口声明 (调用方只需要这一个头)
  arx\out\cadarx_test.lib         AcDb 侧导入库, 供链接
  arx\out\cadarx_test.arx         AcDb 侧实现, 要在 acad.exe 里 arxload
  examples\最小调用\               只用几何模块的 exe, 能直接跑
  examples\数据库最小调用\         同时挂两个模块的 exe, 只证到编译级
```

## 装到新机器

整个 `objectarx` 目录复制到目标机的

```
<火山安装目录>\plugins\vprj_win\classlib\user\objectarx\
```

即完成安装，没有注册表或中央清单要改。重启 IDE 后新建工程，在「模块」里就能看到 **ObjectARX几何** 与 **ObjectARX数据库**。

## 用法

**只算几何**（点、向量、矩阵、圆弧、投影、分割等）：工程挂 `ObjectARX几何` 一个模块即可，产物是普通 exe。

```
变量 甲 <类型 = ARX点3D>
变量 乙 <类型 = ARX点3D>
甲.创建 (0.0, 0.0, 0.0)
乙.创建 (3.0, 4.0, 0.0)
甲.到点距离 (乙)      // 5.0
甲.释放 ()
```

**读写 DWG 实体**：工程要同时挂 `ObjectARX数据库` 和 `ObjectARX几何`。

实测过：`ObjectARX数据库.vgrp` 的 `dependence` 字段只是登记，IDE **不会**把几何模块的类型带进工程——只挂数据库模块时 `ARX点3D` 报「没有找到所指定名称的类」。数据库模块的出参口径就是几何侧的 `ARX点3D` / `ARX向量3D`，所以两个模块都得挂。

## 运行前置

- **几何侧**：链接的是 `acge25.lib`，运行时要 `acge25.dll` 及其同级运行库。这些 DLL 只在 AutoCAD 2026 安装目录下有，SDK 不带。独立进程启动前要把该目录加进 `PATH`，例如：

  ```
  set PATH=D:\Program Files\CAD2026\AutoCAD 2026;%PATH%
  ```

  否则进程一启动就 0xC0000135（找不到 DLL）。

- **数据库侧**：桥的实现体 `cadarx_test.arx` 是 AutoCAD 插件，进程必须是 acad.exe 且已经 `arxload` 这个 arx。在 acad 之外运行连加载都过不去（`cadarx_test.arx` 自身还依赖 accore 等 CAD 运行库），实测 `examples\数据库最小调用.exe` 在 CAD 外直接 0xC0000135 退出。在 CAD 里取不到数据库时的原始口径是 `ARX数据库底层.取最后错误 () = 124` (eNoDatabase)。

## 验证口径（本机新鲜证据）

`examples\最小调用` 用 `voldev_awp.exe @compile 最小调用.vsln /r` 编译：**成功 1 个 / 0 个警告**；跑起来的日志框文本：

```
=== ObjectARX几何 用户模块最小示例 ===
甲.是否有效 = 1
乙.横坐标 = 3
乙.纵坐标 = 4
甲.到点距离(乙) = 5
默认点容差 大于 0 = 1
(到文本 会把小数截断, 所以不直接打印 默认容差)
释放后 甲.是否有效 = 0
=== 示例结束 ===
```

`examples\数据库最小调用` 同样编译 **0 个警告**（证明 `arx\arx_db_bridge.h` + `arx\out\cadarx_test.lib` 两条相对路径在模块内解析成立）；运行侧只能证到「CAD 外起不来」这一步，真正的 AcDb 用例要在 acad 内跑。

模块本身的功能深度不在这里重复证明：权威源侧的回归是 **几何 3606 项断言 / 数据库 1677 项断言，失败 0 项**，见 `E:\火山视窗\cadARX`。

## 已知显示口径

`到文本` 会把小数截断（`ARX容差.取默认点容差 ()` 打印成 `0`，逻辑型打印成 `1`/`0`）。示例里凡是要看数值的地方都用比较式或断言，不直接打印小数。
