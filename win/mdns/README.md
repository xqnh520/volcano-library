# mDNS Toolkit for Volcano Windows

This package wraps Apple Bonjour DNS-SD (`dns_sd.h` / `dnssd.dll`) behind a small C ABI bridge and a Volcano Windows `.wsv` library.

## Files

- `native/mdns_bridge.h`, `native/mdns_bridge.cpp`: native bridge DLL source.
- `native/build_msvc_x64.bat`: build `bin/x64/mdns_bridge.dll` and copy `dnssd.dll`.
- `native/build_msvc_win32.bat`: build `bin/Win32/mdns_bridge.dll` and copy `dnssd.dll`.
- `mdns_toolkit.wsv`: Volcano wrapper library.
- `mdns_toolkit.vgrp`: Volcano module definition.
- `examples/mdns_example.vprj`: test project.
- `examples/mdns_example.wsv`: test window.

## Build

Run from a VS x64 Native Tools command prompt:

```bat
mdns_toolkit\native\build_msvc_x64.bat
```

For Win32, run from a VS x86 Native Tools command prompt:

```bat
mdns_toolkit\native\build_msvc_win32.bat
```

The build output is copied to `mdns_toolkit/bin/<arch>/`. The Volcano wrapper references `mdns_bridge.lib`, `mdns_bridge.dll`, and `dnssd.dll` from that directory.

The checked-in `.wsv` is configured for x64 by default because the verified Volcano package attributes in the local references use the `.x64` suffix. If your project targets Win32, build the Win32 bridge and add the matching Volcano platform attribute supported by your IDE version.

## Use In Volcano

For local testing, open `mdns_toolkit/examples/mdns_example.vprj` in Volcano Windows. The example uses `examples/mdns_toolkit_example_ref.wsv`, which points to `examples/bin/x64` because Volcano resolves native library paths from the example project directory.

For installation as a reusable class library, copy the whole `mdns_toolkit` folder to:

```text
plugins\vprj_win\classlib\user\mdns_toolkit
```

Then reference `mdns_toolkit.vgrp` as a module.

## API Summary

- `mDNS工具.创建()`
- `mDNS工具.注册服务(名称, 服务类型, 端口, 文本记录, 域名, 主机名)`
- `mDNS工具.浏览服务(服务类型, 域名)`
- `mDNS工具.解析服务(网卡索引, 名称, 服务类型, 域名)`
- `mDNS工具.轮询(超时毫秒)`
- `mDNS工具.取事件()`
- `mDNS工具.当前事件文本()`
- `mDNS工具.当前事件名称()` / `当前事件服务类型()` / `当前事件域名()`
- `mDNS工具.当前事件网卡索引()` / `当前事件端口()`
- `mDNS工具.关闭()`
- `mDNS工具.销毁()`

Use a Volcano `时钟` to call `轮询(0)` every 100-300 ms, then repeatedly call `取事件()`. After each non-zero event type, read details with the `当前事件...` methods.

Service type examples: `_http._tcp`, `_ipp._tcp`, `_workstation._tcp`.

TXT record format: `key=value;key2=value2`.

## Runtime Note

This wrapper uses Bonjour DNS-SD. On Windows, Bonjour Service must be installed and running. If it is missing or stopped, DNS-SD often returns `-65563` (`ServiceNotRunning`).
