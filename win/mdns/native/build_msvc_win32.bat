@echo off
setlocal
set ROOT=%~dp0..\..
set OUT=%~dp0..\bin\Win32
if not exist "%OUT%" mkdir "%OUT%"

cl /nologo /EHsc /LD /MD /std:c++17 /I"%~dp0" /I"%ROOT%\mDNS\Include" "%~dp0mdns_bridge.cpp" /Fe:"%OUT%\mdns_bridge.dll" /link /IMPLIB:"%OUT%\mdns_bridge.lib" /LIBPATH:"%ROOT%\mDNS\Lib\Win32" dnssd.lib Ws2_32.lib

if errorlevel 1 exit /b 1
copy /Y "%ROOT%\mDNS\dll\dnssd.dll" "%OUT%\dnssd.dll" >nul
echo Built "%OUT%\mdns_bridge.dll"
