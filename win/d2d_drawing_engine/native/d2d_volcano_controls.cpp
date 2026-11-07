#include "stdafx.h"
#include "vol_user_app.h"

namespace rg_volcano_D2DHuiZhiYinQing {

static BOOL CreateD2DVolcanoWindow(rg_volcano_MFCJieMian_base::CVolWinControl* control,
                                   CVolNativeWndCreateParam* createParam,
                                   const TCHAR* className) {
    ASSERT(control != NULL && createParam != NULL);
    CWnd* wnd = control->GetMfcWndPtr();
    ASSERT(wnd != NULL);
    if (wnd->m_hWnd != NULL) {
        return TRUE;
    }

    control->OnBeforeNativeWndCreate(createParam);
    control->OnCalcNativeWndPos(createParam);
    createParam->m_dwStyle |= WS_CHILD | WS_VISIBLE | WS_CLIPSIBLINGS | WS_CLIPCHILDREN;
    if (wnd->CreateEx(createParam->m_dwExStyle, VolRegisterWndClass(className),
                      createParam->m_szCaption, createParam->m_dwStyle,
                      createParam->m_nLeft, createParam->m_nTop,
                      createParam->m_nWidth, createParam->m_nHeight,
                      createParam->m_pParentWnd->GetSafeHwnd(),
                      reinterpret_cast<HMENU>(createParam->m_nID))) {
        control->OnAfterNativeWndCreate(wnd, createParam);
        return TRUE;
    }
    return FALSE;
}

void rg_D2DChuangKouZuJianJiLei::_OnInitExtra() {
    CMfcWndObject* mfcWndObject = new CMfcWndObject(new CWnd(), FALSE);
    mfcWndObject->m_dwAttrInitialStyle = WS_CHILD | WS_VISIBLE | WS_CLIPSIBLINGS | WS_CLIPCHILDREN;
    mfcWndObject->m_dwAttrInitialExStyle = 0;
    TakeOverNewRefObject(mfcWndObject);
    _OnInitControl();
}

BOOL rg_D2DChuangKouZuJianJiLei::CreateMfcControl(CVolNativeWndCreateParam* createParam) {
    return CreateD2DVolcanoWindow(this, createParam, _T("VolD2DControl"));
}

void rg_D2DChuangKouRongQiZuJianJiLei::_OnInitExtra() {
    CMfcWndObject* mfcWndObject = new CMfcWndObject(new CWnd(), FALSE);
    mfcWndObject->m_dwAttrInitialStyle = WS_CHILD | WS_VISIBLE | WS_CLIPSIBLINGS | WS_CLIPCHILDREN;
    mfcWndObject->m_dwAttrInitialExStyle = 0;
    TakeOverNewRefObject(mfcWndObject);
    _OnInitControl();
}

BOOL rg_D2DChuangKouRongQiZuJianJiLei::CreateMfcControl(CVolNativeWndCreateParam* createParam) {
    return CreateD2DVolcanoWindow(this, createParam, _T("VolD2DContainer"));
}

}  // namespace rg_volcano_D2DHuiZhiYinQing
