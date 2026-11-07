
#pragma once
#include <string>
#include <vector>
#ifdef  _WIN64
//@lib "x64\FTBrowser.lib"
//@复制文件 @当前模块路径 "x64\FTBrowser.dll"
#else
//@lib "x86\FTBrowser.lib"
//@复制文件 @当前模块路径 "x86\FTBrowser.dll"
#endif

//@模块名称  炫彩浏览器  
//@版本  1.0  
//@日期  2022-11-3
//@作者  易团雪  
//@模块备注 CEF浏览器

#define  FT_API extern "C"
//#define WINAPIV __cdecl
//@跳过 FT_API
/////////////////////句柄类型定义//////////////////////////////////////
#ifndef DECLARE_HANDLEX
#define DECLARE_HANDLEX(name) struct name##__ { int unused; }; typedef struct name##__ *name
#endif
typedef void* HWEBVIEW;  //浏览器句柄
DECLARE_HANDLEX(HCOMMAND); //命令行句柄
DECLARE_HANDLEX(HV8VALUE); //V8值句柄
DECLARE_HANDLEX(HV8CONTEXE);//V8环境句柄
DECLARE_HANDLEX(HFRAME);//框架句柄
DECLARE_HANDLEX(HBROWSER);//指针
DECLARE_HANDLEX(HCOOKIE);
DECLARE_HANDLEX(HMENUMODEL);//菜单句柄
DECLARE_HANDLEX(HREQUEST);
DECLARE_HANDLEX(HREQUESTCONTEXE);
DECLARE_HANDLEX(HRESPONSE);
DECLARE_HANDLEX(HPOSTDATA);
//@别名 CEF初始化配置
struct FTSettings {
	LPCWSTR cache_path;//@别名 缓存目录
	LPCWSTR user_data_path;//@别名 用户数据目录
	LPCWSTR user_agent;//@别名 浏览器标识
	int remote_debugging_port;//@别名 远程端口
	LPCWSTR browser_subprocess_path;//@别名 执行子进程
	bool persist_user_preferences;//@别名 保留用户首选项
	bool multi_threaded_message_loop;//@别名 启用系统消息循环
	int log_severity;//@别名 日志模式
	LPCWSTR locale;//@别名 本地化语言
	LPCWSTR accept_language_list;//@别名 接收语言清单
	bool windowless_rendering_enabled;//@别名 启用离屏渲染
	bool persist_session_cookies;//@别名 保留Cookies
	int external_message_pump;//@别名 启用进程间消息
    bool no_sandbox;//@别名 无沙箱
};
struct FTWindowInfo {
    int x;
    int y;
    int w;
    int h;
    int ex_style;
    LPCWSTR window_name;
    int style;
    HWND parent_window;
    HMENU menu;
    bool windowless_rendering_enabled;
    bool shared_texture_enabled;
    bool external_begin_frame_enabled ;
    HWND window ;
 };
struct FTTime {
  int year;          // Four or five digit year "2007" (1601 to 30827 on
                     //   Windows, 1970 to 2038 on 32-bit POSIX)
  int month;         // 1-based month (values 1 = January, etc.)
  int day_of_week;   // 0-based day of week (0 = Sunday, etc.)
  int day_of_month;  // 1-based day of month (1-31)
  int hour;          // Hour within the current day (0-23)
  int minute;        // Minute within the current hour (0-59)
  int second;        // Second within the current minute (0-59 plus leap
                     //   seconds which may take it up to 60).
  int millisecond;   // Milliseconds within the current second (0-999)
};
struct FTCookie {
    const wchar_t* name;//名称
    const wchar_t* value;//值
    const wchar_t* domain;//域名
    const wchar_t* path;//路径
    int secure;//仅安全链接使用
	int httponly;//仅普通链接使用
	FTTime creation;//创建时间
	FTTime last_access;//访问时间
	int has_expires;//是否会过期
	FTTime expires;//过期时间
	int same_site;//同站值
	int priority;//优先级值
};

enum FTMSG_Browser {
	type_BCreated = 1, //<浏览器创建完成
	type_browserdraw = 2, //<浏览器绘制
	type_Setcursor = 3, //<设置光标样式
	type_KeyboardRequested = 4,//虚拟键盘请求,文本输入类型
	type_MenuCreated = 5,//菜单即将被创建
	type_MenuCommand = 6,//菜单项被点击
	type_TitleChange = 7,//标题被改变
	type_AddressChange = 8,//地址被改变
	type_LoadEnd = 9,//加载完成
	type_LoadStart = 10,//加载开始
	type_LoadingStateChange = 11,//加载状态被改变
	type_StatusMessage = 12,//接收到状态信息
	type_LoadError = 13,//加载错误
	type_FaviconURLChange = 14,//网页图标被改变
	type_BeforePopup = 15,//即将打开新窗口
	type_DoClose = 16,//关闭浏览器
	type_ = 17,
};
//@别名 浏览器_初始化消息
enum FTMSG_Init {
	type_CommandLine = 1, //<即将处理命令行
	type_ContextCreated = 2,//渲染_即将创建V8环境
	type_ContextReleased = 3,//即将释放V8环境
	type_WebKitInitialized = 4,//即将初始化WebKit
};
//typedef bool(WINAPI* FTCallbaFT)(int uMsg, LONG_PTR hWeBView, LONG_PTR hObj, LONG_PTR attach1, LONG_PTR attach2, LONG_PTR attach3, LONG_PTR attach4, bool* pbHWEBVIEWd,void* lParam);
//typedef void(WINAPI* FTCallCookie)(FTCookie& Cooks,bool blpIsLastCookie,int &attach1,void* lParam);

FT_API char* WINAPI FT_WCharToChar(const wchar_t* pwszUnicode);
FT_API wchar_t* WINAPI FT_CharToWChar(char *lpSrcBuffer) ;

//typedef bool CALLBAFT OnBeforeInit(int uMsg, LONG_PTR hWeBView, LONG_PTR hObj, LONG_PTR attach1, LONG_PTR attach2, LONG_PTR attach3, LONG_PTR attach4, bool* pbHWEBVIEWd,void* lParam)
//FT_API int WINAPI FT_Browser_Init(HMODULE hModule, LPCWSTR subprocess_path, LPCWSTR cache_path, LPCWSTR user_agent, int debugging_port, void* pfun, void* lParam);
//@别名 CEF浏览器_初始化()
FT_API bool WINAPI FT_CefInit(HMODULE hModule,FTSettings& basicinfo,void* pfun,void* hParam);
//@别名 CEF浏览器_运行消息循环()
FT_API void WINAPI FT_RunMessageLoop();
//@别名 CEF浏览器_退出()
FT_API void WINAPI FT_Shutdown();
//@别名 CEF浏览器_退出消息循环()
FT_API void WINAPI FT_QuitMessageLoop();
//浏览器集
FT_API HBROWSER WINAPI FTBrowser_Create(FTWindowInfo &Parent,LONG_PTR hObj, int bcolor, LPCWSTR Url,HREQUESTCONTEXE rContext,void* pfun,void* lParam);
FT_API void WINAPI FTBrowser_Close(HWEBVIEW hWeBView);
FT_API void WINAPI FTBrowser_SendMouse(HWEBVIEW hWeBView, int uMsg, int wParam, int lParam);
FT_API void WINAPI FTBrowser_SendKey(HWEBVIEW hWeBView, int uMsg, int wParam, int lParam);
FT_API void WINAPI FTBrowser_Focus(HWEBVIEW hWeBView, bool IsFocus);
FT_API void WINAPI FTBrowser_Move(HWEBVIEW hWeBView);
FT_API void WINAPI FTBrowser_HandlerSetRect(int left, int top, int nWidth, int nHeight);
FT_API BOOL WINAPI FTBrowser_GoBack(HWEBVIEW hWeBView);
FT_API BOOL WINAPI FTBrowser_GoForward(HWEBVIEW hWeBView);
FT_API BOOL WINAPI FTBrowser_IsBack(HWEBVIEW hWeBView);
FT_API BOOL WINAPI FTBrowser_IsForward(HWEBVIEW hWeBView);
FT_API BOOL WINAPI FTBrowser_IsLoading(HWEBVIEW hWeBView);
FT_API void WINAPI FTBrowser_ReloadIgnoreCache(HWEBVIEW hWeBView);
FT_API void WINAPI FTBrowser_StopLoad(HWEBVIEW hWeBView);
FT_API void WINAPI FTBrowser_Release(HWEBVIEW hWeBView);
FT_API void WINAPI FTBrowser_AddRef(HWEBVIEW hBrowser);
FT_API void WINAPI FTBrowser_Refresh(HWEBVIEW hWeBView);
FT_API int WINAPI FTBrowser_GetFrameCount(HWEBVIEW hWeBView);
FT_API HFRAME WINAPI FTBrowser_GetMframe(HWEBVIEW hWeBView);
FT_API HFRAME WINAPI FTBrowser_GetFframe(HWEBVIEW hWeBView);
FT_API int WINAPI FTBrowser_GetIdentifier(HWEBVIEW hWeBView);
FT_API HFRAME WINAPI FTBrowser_GetFrame(HWEBVIEW hWeBView,wchar_t* pFrame);
FT_API void WINAPI FTBrowser_StartDownload(HWEBVIEW hWeBView,LPCWSTR pURL);
FT_API BOOL WINAPI FTBrowser_IsSame(HWEBVIEW hWeBView,HWEBVIEW hWeBView1);
//框架集
FT_API void WINAPI FTFrame_LoadUrl(HFRAME frame, const wchar_t* url);
FT_API const wchar_t* WINAPI FTFrame_GetUrl(HFRAME frame);
FT_API BOOL WINAPI FTFrame_ExecJs(HFRAME frame, LPCWSTR wszScript, LPCWSTR kurl,int cor);
FT_API LPCWSTR WINAPI FTFrame_GetName(HFRAME frame);
FT_API LPCWSTR WINAPI FTFrame_GetWebcode(HFRAME frame);
FT_API LPCWSTR WINAPI FTFrame_GetWebText(HFRAME frame);
FT_API HFRAME WINAPI FTFrame_GetParent(HFRAME frame);
FT_API BOOL WINAPI FTFrame_IsFocused(HFRAME frame);
FT_API BOOL WINAPI FTFrame_IsMain(HFRAME frame);
FT_API void WINAPI FTFrame_ViewSource(HFRAME frame);

//Cookies集
FT_API HCOOKIE WINAPI FTCookies_GetGlobalManager();
//回调类型
//typedef void CALLBAFT OnEnumAllCookies(FTCookie& Cooks,bool blpIsLastCookie,int &attach1,void* lParam)
FT_API BOOL WINAPI FTCookies_EnumAll (HCOOKIE manager,const TCHAR* szMatchURL, BOOL blpOnlyHttp, void* pfun, void* hParam);
FT_API BOOL WINAPI FTCookies_Set (HCOOKIE manager,const TCHAR* szMatchURL, FTCookie& pcookie);
FT_API BOOL WINAPI FTCookies_Delete (HCOOKIE manager,const TCHAR* szMatchURL, const TCHAR* name);
FT_API BOOL WINAPI FTCookies_FlushStore (HCOOKIE manager);
FT_API void WINAPI FTCookies_SetSupportedSchemes (HCOOKIE manager,wchar_t** schemes,bool include_defaults);
//V8值对象
FT_API HV8VALUE WINAPI FTV8_CreateString(LPCWSTR pValue);
FT_API HV8VALUE WINAPI FTV8_CreateInt(int pValue);
FT_API HV8VALUE WINAPI FTV8_CreateFunction(LPCWSTR Funname,void* pfun, void* hParam);
FT_API HV8VALUE WINAPI FTV8_CreateObject(void* pfun, void* hParam) ;
FT_API const wchar_t* WINAPI FTV8_GetStringValue(HV8VALUE V8Value);
FT_API bool WINAPI FTV8_SetValue(HV8VALUE V8Value, LPCWSTR key, HV8VALUE pValue, int attribute);
FT_API bool WINAPI FTV8_IsFunction(HV8VALUE V8Value);
FT_API bool WINAPI FTV8_IsString(HV8VALUE V8Value);
FT_API bool WINAPI FTV8_IsInt(HV8VALUE V8Value);
FT_API int WINAPI FTV8_GetIntValue(HV8VALUE V8Value);
FT_API HV8VALUE WINAPI FTV8_ExecuteFunctionInt(HV8VALUE V8Value, int* pargs,int hCount);
FT_API HV8VALUE WINAPI FTV8_ExecuteFunctionString(HV8VALUE V8Value, wchar_t** pargs,int hCount);
FT_API bool WINAPI FTV8_SetValueEx(HV8VALUE V8Value, LPCWSTR key, int settings, int attribute);
FT_API bool WINAPI FTV8_SetValueindex(HV8VALUE V8Value,int index,HV8VALUE pValue);
FT_API bool WINAPI FTV8_IsObject(HV8VALUE V8Value);
FT_API bool WINAPI FTV8_IsNull(HV8VALUE V8Value);
//V8环境对象
FT_API HV8VALUE WINAPI FTV8Context_GetGlobal(HV8CONTEXE context);
FT_API bool WINAPI FTV8Context_Enter(HV8CONTEXE context) ;
FT_API bool WINAPI FTV8Context_Exit(HV8CONTEXE context);
FT_API bool WINAPI FTV8Context_Eval(HV8CONTEXE context,LPCWSTR code,LPCWSTR script_url,int start_line,uintptr_t* retval) ;
FT_API bool WINAPI FTV8Context_IsSame(HV8CONTEXE context, HV8CONTEXE hcontext);
FT_API bool WINAPI FTV8Context_IsValid(HV8CONTEXE context);
FT_API bool WINAPI FTV8Context_InContext(HV8CONTEXE context);
FT_API void* WINAPI FTV8Context_GetTaskRunner(HV8CONTEXE context);

FT_API void WINAPI FT_RegisterExtension(const wchar_t* key, LPCWSTR extensionCode);
//typedef void CALLBAFT OnRegisterExtensionEx(LPCWSTR name, HV8VALUE object, LONG_PTR arguments, HV8VALUE retval, LPCWSTR exception,bool* pbHWEBVIEWd, void* lParam)
FT_API void WINAPI FT_RegisterExtensionEx(const wchar_t* key, LPCWSTR extensionCode, void* pfun, void* hParam);
//命令行集
FT_API void WINAPI FTCommandLine_AppendSwitch(HCOMMAND Command, const wchar_t* name);
FT_API void WINAPI FTCommandLine_AppendSwitchWithValue(HCOMMAND Command, const wchar_t* name, const wchar_t* value);
FT_API const wchar_t* WINAPI FTCommandLine_GetSwitchValue(HCOMMAND Command,const wchar_t * name) ;
FT_API const wchar_t* WINAPI FTCommandLine_GetProgram(HCOMMAND Command);
FT_API bool WINAPI FTCommandLine_HasSwitch(HCOMMAND Command, const wchar_t * name);
FT_API bool WINAPI FTCommandLine_HasSwitches(HCOMMAND Command);
//菜单
FT_API bool WINAPI FTMenu_Clear(HMENUMODEL menu);
FT_API int WINAPI FTMenu_GetCount(HMENUMODEL menu);
FT_API bool WINAPI FTMenu_AddSeparator(HMENUMODEL menu);
FT_API bool WINAPI FTMenu_AddItem(HMENUMODEL menu,int command_id,const wchar_t* item);
FT_API bool WINAPI FTMenu_AddCheckItem(HMENUMODEL menu,int command_id,const wchar_t* item);
FT_API bool WINAPI FTMenu_AddRadioItem(HMENUMODEL menu, int command_id,const wchar_t* item, int groupid);
FT_API HMENUMODEL WINAPI FTMenu_AddSubMenu(HMENUMODEL menu, int command_id,const wchar_t* item);
FT_API bool WINAPI FTMenu_Remove(HMENUMODEL menu, int command_id);
//请求
FT_API HREQUEST WINAPI FTRequest_Create();
FT_API const wchar_t* WINAPI FTRequest_GetMethod(HREQUEST request);
FT_API bool WINAPI FTRequest_SetMethod(HREQUEST request, const wchar_t* Method);
FT_API const wchar_t* WINAPI FTRequest_GetURL(HREQUEST request);
FT_API bool WINAPI FTRequest_SetURL(HREQUEST request, const wchar_t* URL);
FT_API bool WINAPI FTRequest_IsReadOnly(HREQUEST request);
FT_API bool WINAPI FTRequest_SetReferrer(HREQUEST request,const wchar_t* URL,int policy);
FT_API const wchar_t* WINAPI FTRequest_GetReferrerURL(HREQUEST request);
FT_API int WINAPI FTRequest_GetReferrerPolicy(HREQUEST request);
FT_API HPOSTDATA WINAPI FTRequest_GetPostData(HREQUEST request);
FT_API bool WINAPI FTRequest_SetPostData(HREQUEST request, HPOSTDATA PostData);
//FT_API void WINAPI FTRequest_GetHeaderMap(HREQUEST request, std::multimap<std::wstring, std::wstring> HeaderMap);
//FT_API void WINAPI FTRequest_SetHeaderMap(HREQUEST request, std::multimap<std::wstring, std::wstring> HeaderMap);
FT_API const wchar_t* WINAPI FTRequest_GetHeaderByName(HREQUEST request, wchar_t* Name);
//请求环境
FT_API HREQUESTCONTEXE WINAPI FTRequestContext_GetGlobalContext();
FT_API bool WINAPI FTRequestContext_IsGlobal(HREQUESTCONTEXE Context);

//响应
FT_API HRESPONSE WINAPI FTResponse_Create();
FT_API bool WINAPI FTResponse_IsReadOnly(HRESPONSE response);
FT_API int WINAPI FTResponse_GetError(HRESPONSE response);
FT_API bool WINAPI FTResponse_SetError(HRESPONSE response,int error);
FT_API int WINAPI FTResponse_GetStatus(HRESPONSE response) ;
FT_API bool WINAPI FTResponse_SetStatus(HRESPONSE response, int status);
FT_API const wchar_t* WINAPI FTResponse_GetStatusText(HRESPONSE response);
FT_API void WINAPI FTResponse_SetStatusText(HRESPONSE response, wchar_t* Name);

