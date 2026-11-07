#ifndef  _VOL_XCGUI_H
#define  _VOL_XCGUI_H
//#include <wke.h>
template <class T> class TempXcgui //定义一个模板类
{
	protected:
		T m_xcgui;// 定义一个私有的成员变量
	public:
		inline_ TempXcgui() { m_xcgui = NULL; } //构造函数 初始化句柄
		inline_ T GetPtr(){ return m_xcgui; } //取句柄
		//置句柄
		inline_ BOOL SetPtr(T pInfo){  
		if (pInfo){
			m_xcgui = pInfo;
			return TRUE;
			}
		return FALSE;
		}
		~TempXcgui() { m_xcgui = NULL; } 
};
class CXImage : public TempXcgui<HIMAGE> //继承模板类并指定T数据类型为HIMAGE 图片句柄
{
};
class CXHTEMP : public TempXcgui<HTEMP> //继承模板类并指定T数据类型为HTEMP 模板句柄
{
};
class CXHBKM : public TempXcgui<HBKM> //继承模板类并指定T数据类型为HBKM 背景管理器
{
};
class CXHDRAW : public TempXcgui<HDRAW> //继承模板类并指定T数据类型为HDRAW 绘图句柄
{
};
class CXHFONTX : public TempXcgui<HFONTX> //继承模板类并指定T数据类型为HFONTX 字体句柄
{
};
class CXHSVG : public TempXcgui<HSVG> //继承模板类并指定T数据类型为HSVG 句柄
{
};
class CXHXCGUI : public TempXcgui<HXCGUI> //继承模板类并指定T数据类型为HXCGUI 句柄
{
};

class XCGUIDATA
{
	public:
		vint m_HXCGUI = NULL ;
	public:
	vint SetP(vint x){
		m_HXCGUI = x;
		return m_HXCGUI;
	}
	vint GetP(){ return m_HXCGUI; }
};
class XCmbWebWiewWrapper
{
	protected:
		wkeWebView m_webView;
	
	public:
		inline_ XCmbWebWiewWrapper() { m_webView = NULL; }
		
		inline_ wkeWebView GetwebView() { return m_webView; }
		
		inline_ void SetwebView(wkeWebView webView) { m_webView = webView; }
};
#endif