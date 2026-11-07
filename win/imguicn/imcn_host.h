// ---------------------------------------------------------------------------
// imcn_host.h - minimal Win32 + Direct3D 11 host for the ImGui wrapper.
// ASCII only (Volcano requires ANSI/ASCII for external headers).
// ---------------------------------------------------------------------------
#ifndef IMCN_HOST_H
#define IMCN_HOST_H

#include <windows.h>
#include <d3d11.h>
#include <dxgi.h>

#pragma comment(lib, "d3d11.lib")
#pragma comment(lib, "dxgi.lib")

#include "imgui.h"
#include "imcn_helper.h"
#include "backends/imgui_impl_win32.h"
#include "backends/imgui_impl_dx11.h"

extern IMGUI_IMPL_API LRESULT ImGui_ImplWin32_WndProcHandler(HWND hWnd, UINT msg, WPARAM wParam, LPARAM lParam);

namespace imcn
{
    class HostW11
    {
    public:
        HWND                     Handle;
        ID3D11Device*            Device;
        ID3D11DeviceContext*     Context;
        IDXGISwapChain*          SwapChain;
        ID3D11RenderTargetView*  RenderTarget;
        bool                     Running;

        HostW11()
        {
            Handle = NULL;
            Device = NULL;
            Context = NULL;
            SwapChain = NULL;
            RenderTarget = NULL;
            Running = true;
        }

        bool CreateDeviceD3D(HWND hwnd)
        {
            DXGI_SWAP_CHAIN_DESC sd;
            ZeroMemory(&sd, sizeof(sd));
            sd.BufferCount = 2;
            sd.BufferDesc.Width = 0;
            sd.BufferDesc.Height = 0;
            sd.BufferDesc.Format = DXGI_FORMAT_R8G8B8A8_UNORM;
            sd.BufferDesc.RefreshRate.Numerator = 60;
            sd.BufferDesc.RefreshRate.Denominator = 1;
            sd.Flags = DXGI_SWAP_CHAIN_FLAG_ALLOW_MODE_SWITCH;
            sd.BufferUsage = DXGI_USAGE_RENDER_TARGET_OUTPUT;
            sd.OutputWindow = hwnd;
            sd.SampleDesc.Count = 1;
            sd.SampleDesc.Quality = 0;
            sd.Windowed = TRUE;
            sd.SwapEffect = DXGI_SWAP_EFFECT_DISCARD;

            UINT create_flags = 0;
            D3D_FEATURE_LEVEL feature_level = D3D_FEATURE_LEVEL_11_0;
            D3D_FEATURE_LEVEL feature_levels[2] = { D3D_FEATURE_LEVEL_11_0, D3D_FEATURE_LEVEL_10_0 };
            HRESULT hr = D3D11CreateDeviceAndSwapChain(NULL, D3D_DRIVER_TYPE_HARDWARE, NULL, create_flags,
                feature_levels, 2, D3D11_SDK_VERSION, &sd, &SwapChain, &Device, &feature_level, &Context);
            if (hr == DXGI_ERROR_UNSUPPORTED)
                hr = D3D11CreateDeviceAndSwapChain(NULL, D3D_DRIVER_TYPE_WARP, NULL, create_flags,
                    feature_levels, 2, D3D11_SDK_VERSION, &sd, &SwapChain, &Device, &feature_level, &Context);
            if (FAILED(hr))
                return false;
            CreateRenderTarget();
            return true;
        }

        void CreateRenderTarget()
        {
            ID3D11Texture2D* back_buffer = NULL;
            SwapChain->GetBuffer(0, IID_PPV_ARGS(&back_buffer));
            if (back_buffer != NULL)
            {
                Device->CreateRenderTargetView(back_buffer, NULL, &RenderTarget);
                back_buffer->Release();
            }
        }

        void CleanupRenderTarget()
        {
            if (RenderTarget != NULL)
            {
                RenderTarget->Release();
                RenderTarget = NULL;
            }
        }

        bool Shutdown()
        {
            if (SwapChain != NULL)
                ImGui_ImplDX11_Shutdown();
            if (Context != NULL)
                ImGui_ImplWin32_Shutdown();
            CleanupRenderTarget();
            if (SwapChain != NULL) { SwapChain->Release(); SwapChain = NULL; }
            if (Context != NULL) { Context->Release(); Context = NULL; }
            if (Device != NULL) { Device->Release(); Device = NULL; }
            return true;
        }

        bool Resize(int width, int height)
        {
            if (Device == NULL || width <= 0 || height <= 0)
                return false;
            CleanupRenderTarget();
            SwapChain->ResizeBuffers(0, (UINT)width, (UINT)height, DXGI_FORMAT_UNKNOWN, 0);
            CreateRenderTarget();
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
                ImGui_ImplDX11_InvalidateDeviceObjects();
                ImGui_ImplDX11_CreateDeviceObjects();
            }
            ImGui_ImplDX11_NewFrame();
            ImGui_ImplWin32_NewFrame();
        }

        void EndFrame()
        {
            const float clear_color[4] = { 0.10f, 0.11f, 0.13f, 1.00f };
            Context->OMSetRenderTargets(1, &RenderTarget, NULL);
            Context->ClearRenderTargetView(RenderTarget, clear_color);
            ImGui_ImplDX11_RenderDrawData(ImGui::GetDrawData());
            SwapChain->Present(1, 0);
        }
    };

    inline HostW11*& HostSlot()
    {
        static HostW11* slot = NULL;
        return slot;
    }

    inline LRESULT CALLBACK HostWndProc(HWND hwnd, UINT msg, WPARAM wparam, LPARAM lparam)
    {
        if (ImGui_ImplWin32_WndProcHandler(hwnd, msg, wparam, lparam))
            return true;
        switch (msg)
        {
        case WM_SIZE:
            if (wparam != SIZE_MINIMIZED && HostSlot() != NULL)
                HostSlot()->Resize((int)LOWORD(lparam), (int)HIWORD(lparam));
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

    inline HostW11* CreateHostW11(const wchar_t* title, int width, int height)
    {
        WNDCLASSEXW wc;
        ZeroMemory(&wc, sizeof(wc));
        wc.cbSize = sizeof(wc);
        wc.style = CS_OWNDC;
        wc.lpfnWndProc = HostWndProc;
        wc.hInstance = ::GetModuleHandle(NULL);
        wc.hCursor = ::LoadCursor(NULL, IDC_ARROW);
        wc.lpszClassName = L"IMCN_HOST_W11";
        ::RegisterClassExW(&wc);

        HWND hwnd = ::CreateWindowExW(0, wc.lpszClassName, title, WS_OVERLAPPEDWINDOW,
            CW_USEDEFAULT, CW_USEDEFAULT, width, height, NULL, NULL, wc.hInstance, NULL);
        if (hwnd == NULL)
            return NULL;

        HostW11* host = new HostW11();
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
        ImGui_ImplDX11_Init(host->Device, host->Context);

        HostSlot() = host;
        ::ShowWindow(hwnd, SW_SHOWDEFAULT);
        ::UpdateWindow(hwnd);
        return host;
    }

    inline bool PumpHostW11(HostW11* host)
    {
        if (host == NULL)
            return false;
        return host->Pump();
    }

    inline void DestroyHostW11(HostW11* host)
    {
        if (host == NULL)
            return;
        host->Shutdown();
        ImGui::DestroyContext();
        if (host->Handle != NULL)
            ::DestroyWindow(host->Handle);
        if (HostSlot() == host)
            HostSlot() = NULL;
        delete host;
    }
}

#endif // IMCN_HOST_H
