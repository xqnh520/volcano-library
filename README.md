# 火山类库 volcano-library

火山软件开发平台个人类库的集中分发仓库。客户端工具「火山类库管家 VolLibHub」从本仓库拉取清单，
把类库按平台安装到本地 `<VolDev>\plugins\vprj_*\classlib\user\` 目录，装完直接生效。

## 目录约定

```
volcano-library/
├── index.json              ← 清单（客户端唯一入口，由脚本生成，勿手改）
├── win/<模块名>/           ← 火山视窗类库（.vgrp/.wsv/native/lib 整目录）
├── android/<模块名>/       ← 火山安卓类库
├── server/<模块名>/        ← 火山服务器类库
└── scripts/gen-index.ps1   ← 扫描目录自动生成 index.json
```

## 当前收录（win）

occt、piv、anycad、objectarx、thorvg、XCGUI、Skia图形库、Box2D、konvaJS、mtest、imguicn、
d2d_drawing_engine、boost工具库、windows_api、mdns、acenum、acp13、acprobe

## 当前收录（android）

火山OCCT几何、火山安卓opencv、XUI用户界面库、AndroidUtils、MPAndroidChart图表类库、洛蒂动画类库

## 日常更新流程

```powershell
# 1. 把类库目录放进 win\ / android\ / server\，改了内容记得升该模块 module.json 里的 version
# 2. 重新生成清单
powershell -ExecutionPolicy Bypass -File .\scripts\gen-index.ps1

# 3. 提交推送
git add -A
git commit -m "更新 <模块名> <版本>"
git push
```

客户端按模块 `version` 判断「已最新 / 可更新」，**改了文件必须升版本号**，否则不会提示更新。

## module.json

每个模块目录里放一个 `module.json`（不会安装到本地，只用于生成清单）：

```json
{
  "name": "Skia图形库",
  "version": "1.0.0",
  "desc": "Skia 图形库封装",
  "author": "xqnh520",
  "entry": "skia.vgrp"
}
```

## .gitattributes（别删）

`* -text`：禁止 git 转换换行符，保证文件逐字节一致，客户端 SHA256 校验才可靠。

## 可选：类库文件走对象存储 / CDN（加速下载）

默认客户端从 git 仓库整包拉取（1.2GB，国内较慢）。把类库文件同步到 S3 兼容存储后，
清单仍走 git（只有 6MB），文件按需逐个下载，速度取决于 CDN，且二次安装只补缺失文件。

1. 装 [rclone](https://rclone.org/downloads/)，按 `scripts/rclone.conf.sample` 配好 remote（R2 / COS / OSS / MinIO）
2. 同步文件并确保桶是公共读：

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\upload.ps1 -Remote r2:volcano-library
```

3. 带上托管地址重新生成清单，提交推送：

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\gen-index.ps1 -StorageBase https://cdn.example.com/volcano-library
git add -A; git commit -m "清单切换到 CDN 托管"; git push
```

清单里会多出：

```json
"storage": { "type": "http", "base": "https://cdn.example.com/volcano-library" }
```

单个模块想用不同地址（比如 occt 单独放另一个桶），在该模块 `module.json` 里加 `"base": "https://..."` 即可覆盖全局。

客户端行为：`storage.base` 存在 → 按文件列表逐个下载并校验 SHA256，缓存到
`%LOCALAPPDATA%\VolLibHub\cache\files\仓库\平台\模块\版本`；没有该字段 → 回落 git 整包模式。

## 客户端读取方式

优先 `git clone --depth 1` / `git pull` 到本地缓存；git 不可用时降级为 GitHub zip 归档下载。
私有仓库在客户端设置里填访问令牌即可。本仓库为公开仓库，无需令牌。
