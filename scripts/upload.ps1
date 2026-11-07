param(
    [string]$Remote = 'r2:volcano-library',
    [string]$RepoRoot = (Split-Path -Parent $PSScriptRoot),
    [switch]$DryRun
)

# 把类库文件同步到 S3 兼容存储（Cloudflare R2 / 腾讯云 COS / 阿里云 OSS / MinIO / 七牛）
# 依赖 rclone（https://rclone.org/downloads/），先按 scripts/rclone.conf.sample 配好 remote。
# 只上传类库文件，不上传 .git；index.json 也一起传（便于直接用 CDN 兜底读清单）。

$ErrorActionPreference = 'Stop'

if (-not (Get-Command rclone -ErrorAction SilentlyContinue)) {
    throw ' 未找到 rclone，请先安装：https://rclone.org/downloads/'
}

$rcloneArgs = @(
    'sync', $RepoRoot, $Remote,
    '--exclude', '.git/**',
    '--exclude', '*.rar',
    '--checksum',
    '--transfers', '8',
    '--checkers', '16',
    '--progress',
    '--stats-one-line'
)
if ($DryRun) { $rcloneArgs += '--dry-run' }

Write-Host ("rclone " + ($rcloneArgs -join ' ')) -ForegroundColor DarkGray
& rclone @rcloneArgs

if ($LASTEXITCODE -ne 0) {
    throw "rclone 同步失败，退出码 $LASTEXITCODE"
}

Write-Host ''
Write-Host '同步完成。若使用公共读桶，请确认：' -ForegroundColor Green
Write-Host '  1. 桶或目录已设置为公共读（或绑定自定义域名 + CDN）'
Write-Host '  2. 用浏览器直接打开一个文件 URL，例如 <base>/win/Box2D/Box2D.vgrp，能下载才算配好'
Write-Host '  3. 重新生成清单并带上地址：'
Write-Host '     powershell -ExecutionPolicy Bypass -File .\scripts\gen-index.ps1 -StorageBase https://cdn.example.com/volcano-library'
