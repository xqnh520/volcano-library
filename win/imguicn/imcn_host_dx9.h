// ---------------------------------------------------------------------------
// imcn_host_dx9.h - Win32 + Direct3D 9 host for the ImGui wrapper.
// ASCII only (Volcano requires ANSI/ASCII for external headers).
// ---------------------------------------------------------------------------
#ifndef IMCN_HOST_DX9_H
#define IMCN_HOST_DX9_H

#include <windows.h>
#include <d3d9.h>

#pragma comment(lib, "d3d9.lib")

#include "imgui.h"
#include "imcn_helper.h"
#include "backends/imgui_impl_win32.h"
#include "backends/imgui_impl_dx9.h"

extern IMGUI_IMPL_API LRESULT ImGui_ImplWin32_WndProcHandler(HWND hWnd, UINT msg, WPARAM wParam, LPARAM lParam);

namespace imcn
{
    class HostW9
    {
    public:
        HWND                  Handle;
        LPDIRECT3D9           D3D;
        LPDIRECT3DDEVICE9     Device;
        D3DPRESENT_PARAMETERS Params;
        bool                  Running;

        HostW9()
        {
            Handle = NULL;
            D3D = NULL;
            Device = NULL;
            ZeroMemory(&Params, sizeof(Params));
            Running = true;
        }

        bool CreateDeviceD3D(HWND hwnd)
        {
            D3D = ::Direct3DCreate9(D3D_SDK_VERSION);
            if (D3D == NULL)
                return false;

            ZeroMemory(&Params, sizeof(Params));
            Params.Windowed = TRUE;
            Params.SwapEffect = D3DSWAPEFFECT_DISCARD;
            Params.BackBufferFormat = D3DFMT_UNKNOWN;
            Params.BackBufferCount = 1;
            Params.EnableAutoDepthStencil = FALSE;
            Params.hDeviceWindow = hwnd;
            Params.PresentationInterval = D3DPRESENT_INTERVAL_ONE;

            HRESULT hr = D3D->CreateDevice(D3DADAPTER_DEFAULT, D3DDEVTYPE_HAL, hwnd,
                D3DCREATE_HARDWARE_VERTEXPROCESSING, &Params, &Device);
            if (FAILED(hr))
            {
                hr = D3D->CreateDevice(D3DADAPTER_DEFAULT, D3DDEVTYPE_HAL, hwnd,
                    D3DCREATE_SOFTWARE_VERTEXPROCESSING, &Params, &Device);
            }
            if (FAILED(hr))
                return false;
            return true;
        }

        bool Shutdown()
        {
            if (Device != NULL)
                ImGui_ImplDX9_Shutdown();
            if (Device != NULL) { Device->Release(); Device = NULL; }
            if (D3D != NULL) { D3D->Release(); D3D = NULL; }
            return true;
        }

        bool Resize(int width, int height)
        {
            if (Device == NULL || width <= 0 || height <= 0)
                return false;
            Params.BackBufferWidth = (UINT)width;
            Params.BackBufferHeight = (UINT)height;
            ImGui_ImplDX9_InvalidateDeviceObjects();
            HRESULT hr = Device->Reset(&Params);
            if (FAILED(hr))
                return false;
            ImGui_ImplDX9_CreateDeviceObjects();
            return true;
        }

        bool Pump()
        {
            MSG msg;
            while (::PeekMessage(&msg, NULL, 0U, 0U, PM_REMOVE))
            {
                ::TranslateMessage(&msg);
                ::DispatchMessage(&msg);
                if (msg.message == WM_QUIT)
                    Running = false;
            }
            return Running;
        }

        void BeginFrame()
        {
            // Fonts added after the backend initialized the atlas invalidate it;
            // rebuild device objects here so any backend keeps working.
            if (!ImGui::GetIO().Fonts->IsBuilt())
            {
                ImGui_ImplDX9_InvalidateDeviceObjects();
                ImGui_ImplDX9_CreateDeviceObjects();
            }
            ImGui_ImplDX9_NewFrame();
            ImGui_ImplWin32_NewFrame();
        }

        void EndFrame()
        {
            const D3DCOLOR clear_color = D3DCOLOR_ARGB(255, 26, 28, 33);
            Device->SetRenderState(D3DRS_ZENABLE, FALSE);
            Device->SetRenderState(D3DRS_ALPHABLENDENABLE, FALSE);
            Device->SetRenderState(D3DRS_SCISSORTESTENABLE, FALSE);

            D3DVIEWPORT9 viewport;
            viewport.X = 0;
            viewport.Y = 0;
            viewport.Width = (DWORD)Params.BackBufferWidth;
            viewport.Height = (DWORD)Params.BackBufferHeight;
            viewport.MinZ = 0.0f;
            viewport.MaxZ = 1.0f;
            Device->SetViewport(&viewport);

            Device->Clear(0, NULL, D3DCLEAR_TARGET, clear_color, 1.0f, 0);
            if (SUCCEEDED(Device->BeginScene()))
            {
                ImGui_ImplDX9_RenderDrawData(ImGui::GetDrawData());
                Device->EndScene();
            }
            Device->Present(NULL, NULL, NULL, NULL);
        }
    };

    inline HostW9*& HostSlot9()
    {
        static HostW9* slot = NULL;
        return slot;
    }

    inline LRESULT CALLBACK HostWndProc9(HWND hwnd, UINT msg, WPARAM wparam, LPARAM lparam)
    {
        if (ImGui_ImplWin32_WndProcHandler(hwnd, msg, wparam, lparam))
            return true;
        switch (msg)
        {
        case WM_SIZE:
            if (wparam != SIZE_MINIMIZED && HostSlot9() != NULL)
                HostSlot9()->Resize((int)LOWORD(lparam), (int)HIWORD(lparam));
            return 0;
        case WM_SYSCOMMAND:
            if ((wparam & 0xfff0) == SC_KEYMENU)
                return 0;
            break;
        case WM_DESTROY:
            ::PostQuitMessage(0);
            return 0;
        }
        return ::DefWindowProc(hwnd, msg, wparam, lparam);
    }

    inline HostW9* CreateHostW9(const wchar_t* title, int width, int height)
    {
        WNDCLASSEXW wc;
        ZeroMemory(&wc, sizeof(wc));
        wc.cbSize = sizeof(wc);
        wc.style = CS_OWNDC;
        wc.lpfnWndProc = HostWndProc9;
        wc.hInstance = ::GetModuleHandle(NULL);
        wc.hCursor = ::LoadCursor(NULL, IDC_ARROW);
        wc.lpszClassName = L"IMCN_HOST_W9";
        ::RegisterClassExW(&wc);

        HWND hwnd = ::CreateWindowExW(0, wc.lpszClassName, title, WS_OVERLAPPEDWINDOW,
            CW_USEDEFAULT, CW_USEDEFAULT, width, height, NULL, NULL, wc.hInstance, NULL);
        if (hwnd == NULL)
            return NULL;

        HostW9* host = new HostW9();
        host->Handle = hwnd;
        if (!host->CreateDeviceD3D(hwnd))
        {
            delete host;
            return NULL;
        }

        IMGUI_CHECKVERSION();
        ImGui::CreateContext();
        ImGui::StyleColorsDark();
        ImGui_ImplWin32_Init(hwnd);
        ImGui_ImplDX9_Init(host->Device);

        HostSlot9() = host;
        ::ShowWindow(hwnd, SW_SHOWDEFAULT);
        ::UpdateWindow(hwnd);
        return host;
    }

    inline bool PumpHostW9(HostW9* host)
    {
        if (host == NULL)
            return false;
        return host->Pump();
    }

    inline void DestroyHostW9(HostW9* host)
    {
        if (host == NULL)
            return;
        host->Shutdown();
        ImGui::DestroyContext();
        if (host->Handle != NULL)
            ::DestroyWindow(host->Handle);
        if (HostSlot9() == host)
            HostSlot9() = NULL;
        delete host;
    }
}

#endif // IMCN_HOST_DX9_H
