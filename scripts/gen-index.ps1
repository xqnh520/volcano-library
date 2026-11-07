param(
    [string]$RepoRoot = (Split-Path -Parent $PSScriptRoot),
    [string]$OutFile = 'index.json',
    [string]$StorageBase = ''
)

$ErrorActionPreference = 'Stop'
$platforms = @('win', 'android', 'server')
$modules = New-Object System.Collections.ArrayList

foreach ($platform in $platforms) {
    $platformDir = Join-Path $RepoRoot $platform
    if (-not (Test-Path $platformDir)) { continue }

    foreach ($moduleDir in Get-ChildItem -Path $platformDir -Directory) {
        $name = $moduleDir.Name
        $version = '1.0.0'
        $desc = ''
        $author = ''
        $entry = ''
        $moduleBase = ''

        $metaPath = Join-Path $moduleDir.FullName 'module.json'
        if (Test-Path $metaPath) {
            $meta = Get-Content -Path $metaPath -Raw -Encoding UTF8 | ConvertFrom-Json
            if ($meta.name) { $name = $meta.name }
            if ($meta.version) { $version = $meta.version }
            if ($meta.desc) { $desc = $meta.desc }
            if ($meta.author) { $author = $meta.author }
            if ($meta.entry) { $entry = $meta.entry }
            if ($meta.base) { $moduleBase = $meta.base }
        }

        $files = New-Object System.Collections.ArrayList
        $allFiles = Get-ChildItem -Path $moduleDir.FullName -Recurse -File |
            Where-Object { $_.Name -ne 'module.json' } |
            Sort-Object FullName

        foreach ($file in $allFiles) {
            $relative = $file.FullName.Substring($moduleDir.FullName.Length + 1).Replace('\', '/')
            $hash = (Get-FileHash -Path $file.FullName -Algorithm SHA256).Hash.ToLower()
            [void]$files.Add([pscustomobject]@{
                file   = $relative
                sha256 = $hash
                size   = $file.Length
            })
        }

        $moduleObj = [pscustomobject]@{
            name     = $name
            platform = $platform
            version  = $version
            desc     = $desc
            author   = $author
            path     = "$platform/$($moduleDir.Name)"
            entry    = $entry
            files    = $files
        }
        if ($moduleBase) { $moduleObj | Add-Member -NotePropertyName base -NotePropertyValue $moduleBase -Force }
        [void]$modules.Add($moduleObj)

        Write-Host ("[{0}] {1} {2} - {3} 个文件" -f $platform, $name, $version, $files.Count)
    }
}

$result = [pscustomobject]@{
    repo_version = 1
    repo_name    = (Split-Path -Leaf $RepoRoot)
    updated_at   = (Get-Date).ToString('yyyy-MM-ddTHH:mm:ss')
    modules      = $modules
}

$target = Join-Path $RepoRoot $OutFile
$json = $result | ConvertTo-Json -Depth 8
[System.IO.File]::WriteAllText($target, $json, [System.Text.UTF8Encoding]::new($false))
Write-Host ""
Write-Host ("已写出 {0}，共 {1} 个模块" -f $target, $modules.Count)
