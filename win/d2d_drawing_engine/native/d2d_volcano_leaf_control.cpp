#include "stdafx.h"
#include "vol_user_app.h"

namespace rg_volcano_D2DHuiZhiYinQing {

class CVolD2DLeafWnd : public CWnd {
public:
    explicit CVolD2DLeafWnd(rg_volcano_MFCJieMian_base::CVolWinControl* owner)
        : owner_(owner) {
    }

protected:
    LRESULT WindowProc(UINT message, WPARAM wParam, LPARAM lParam) override {
        const bool canStayFocused = (GetStyle() & WS_TABSTOP) != 0;
        if (message == WM_MOUSEACTIVATE && !canStayFocused) {
            return MA_NOACTIVATE;
        }
        if (message == WM_SETFOCUS && !canStayFocused) {
            HWND previousFocus = reinterpret_cast<HWND>(wParam);
            if (::IsWindow(previousFocus) && previousFocus != m_hWnd) {
                ::SetFocus(previousFocus);
            } else if (::IsWindow(::GetParent(m_hWnd))) {
                ::SetFocus(::GetParent(m_hWnd));
            }
            return 0;
        }
        if (message == WM_KILLFOCUS && !canStayFocused) {
            return 0;
        }
        if (owner_ != NULL) {
            MSG msg{};
            msg.hwnd = m_hWnd;
            msg.message = message;
            msg.wParam = wParam;
            msg.lParam = lParam;
            if (owner_->OnProcessNativeWndMsg(&msg)) {
                return message == WM_SETCURSOR ? TRUE : 0;
            }
            message = msg.message;
            wParam = msg.wParam;
            lParam = msg.lParam;
        }
        if (!canStayFocused && (message == WM_LBUTTONDOWN || message == WM_RBUTTONDOWN || message == WM_MBUTTONDOWN)) {
            return 0;
        }
        return CWnd::WindowProc(message, wParam, lParam);
    }

private:
    rg_volcano_MFCJieMian_base::CVolWinControl* owner_;
};

static BOOL CreateD2DLeafWindow(rg_volcano_MFCJieMian_base::CVolWinControl* control,
                                CVolNativeWndCreateParam* createParam) {
    ASSERT(control != NULL && createParam != NULL);
    CWnd* wnd = control->GetMfcWndPtr();
    ASSERT(wnd != NULL);
    if (wnd->m_hWnd != NULL) {
        return TRUE;
    }

    control->OnBeforeNativeWndCreate(createParam);
    control->OnCalcNativeWndPos(createParam);
    createParam->m_dwStyle |= WS_CHILD | WS_VISIBLE | WS_CLIPSIBLINGS | WS_CLIPCHILDREN;
    if (wnd->CreateEx(createParam->m_dwExStyle, VolRegisterWndClass(_T("VolD2DLeafControl")),
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
    CMfcWndObject* mfcWndObject = new CMfcWndObject(new CVolD2DLeafWnd(this), FALSE);
    mfcWndObject->m_dwAttrInitialStyle = WS_CHILD | WS_VISIBLE | WS_TABSTOP | WS_CLIPSIBLINGS | WS_CLIPCHILDREN;
    mfcWndObject->m_dwAttrInitialExStyle = 0;
    TakeOverNewRefObject(mfcWndObject);
    _OnInitControl();
}

BOOL rg_D2DChuangKouZuJianJiLei::CreateMfcControl(CVolNativeWndCreateParam* createParam) {
    return CreateD2DLeafWindow(this, createParam);
}

}  // namespace rg_volcano_D2DHuiZhiYinQing
