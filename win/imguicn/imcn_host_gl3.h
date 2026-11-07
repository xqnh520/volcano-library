// ---------------------------------------------------------------------------
// imcn_host_gl3.h - Win32 + OpenGL 3.x host for the ImGui wrapper.
// ASCII only (Volcano requires ANSI/ASCII for external headers).
// ---------------------------------------------------------------------------
#ifndef IMCN_HOST_GL3_H
#define IMCN_HOST_GL3_H

#include <windows.h>
#include <GL/gl.h>

#pragma comment(lib, "opengl32.lib")
#pragma comment(lib, "gdi32.lib")

#include "imgui.h"
#include "imcn_helper.h"
#include "backends/imgui_impl_win32.h"
#include "backends/imgui_impl_opengl3.h"

extern IMGUI_IMPL_API LRESULT ImGui_ImplWin32_WndProcHandler(HWND hWnd, UINT msg, WPARAM wParam, LPARAM lParam);

// WGL extension entry points (loaded at runtime, no glext.h needed).
#define IMCN_WGL_CONTEXT_MAJOR_VERSION_ARB 0x2091
#define IMCN_WGL_CONTEXT_MINOR_VERSION_ARB 0x2092
#define IMCN_WGL_CONTEXT_FLAGS_ARB         0x2094
#define IMCN_WGL_CONTEXT_PROFILE_MASK_ARB  0x9126
#define IMCN_WGL_CONTEXT_COMPATIBILITY_PROFILE_BIT_ARB 0x00000002

typedef HGLRC(WINAPI* PFN_imcn_wglCreateContextAttribsARB)(HDC, HGLRC, const int*);

namespace imcn
{
    class HostGL3
    {
    public:
        HWND   Handle;
        HDC    DeviceContext;
        HGLRC  RenderContext;
        bool   Running;

        HostGL3()
        {
            Handle = NULL;
            DeviceContext = NULL;
            RenderContext = NULL;
            Running = true;
        }

        // A legacy 1.1 context is required only to resolve wglCreateContextAttribsARB.
        static PFN_imcn_wglCreateContextAttribsARB LoadCreateContextAttribs()
        {
            HWND dummy = ::CreateWindowExA(0, "STATIC", "imcn_dummy", WS_OVERLAPPEDWINDOW,
                0, 0, 16, 16, NULL, NULL, ::GetModuleHandle(NULL), NULL);
            if (dummy == NULL)
                return NULL;
            HDC dc = ::GetDC(dummy);
            PIXELFORMATDESCRIPTOR pfd;
            ZeroMemory(&pfd, sizeof(pfd));
            pfd.nSize = sizeof(pfd);
            pfd.nVersion = 1;
            pfd.dwFlags = PFD_DRAW_TO_WINDOW | PFD_SUPPORT_OPENGL | PFD_DOUBLEBUFFER;
            pfd.iPixelType = PFD_TYPE_RGBA;
            pfd.cColorBits = 32;
            pfd.cDepthBits = 24;
            pfd.cStencilBits = 8;
            int fmt = ::ChoosePixelFormat(dc, &pfd);
            ::SetPixelFormat(dc, fmt, &pfd);
            HGLRC rc = ::wglCreateContext(dc);
            ::wglMakeCurrent(dc, rc);
            PFN_imcn_wglCreateContextAttribsARB fn =
                (PFN_imcn_wglCreateContextAttribsARB)::wglGetProcAddress("wglCreateContextAttribsARB");
            ::wglMakeCurrent(NULL, NULL);
            ::wglDeleteContext(rc);
            ::ReleaseDC(dummy, dc);
            ::DestroyWindow(dummy);
            return fn;
        }

        bool CreateContextGL(HWND hwnd)
        {
            DeviceContext = ::GetDC(hwnd);
            if (DeviceContext == NULL)
                return false;

            PIXELFORMATDESCRIPTOR pfd;
            ZeroMemory(&pfd, sizeof(pfd));
            pfd.nSize = sizeof(pfd);
            pfd.nVersion = 1;
            pfd.dwFlags = PFD_DRAW_TO_WINDOW | PFD_SUPPORT_OPENGL | PFD_DOUBLEBUFFER;
            pfd.iPixelType = PFD_TYPE_RGBA;
            pfd.cColorBits = 32;
            pfd.cDepthBits = 24;
            pfd.cStencilBits = 8;
            int fmt = ::ChoosePixelFormat(DeviceContext, &pfd);
            if (fmt == 0)
                return false;
            if (!::SetPixelFormat(DeviceContext, fmt, &pfd))
                return false;

            PFN_imcn_wglCreateContextAttribsARB create_attribs = LoadCreateContextAttribs();
            if (create_attribs != NULL)
            {
                const int attribs[] = {
                    IMCN_WGL_CONTEXT_MAJOR_VERSION_ARB, 3,
                    IMCN_WGL_CONTEXT_MINOR_VERSION_ARB, 3,
                    IMCN_WGL_CONTEXT_PROFILE_MASK_ARB, IMCN_WGL_CONTEXT_COMPATIBILITY_PROFILE_BIT_ARB,
                    0
                };
                RenderContext = create_attribs(DeviceContext, NULL, attribs);
            }
            if (RenderContext == NULL)
                RenderContext = ::wglCreateContext(DeviceContext);
            if (RenderContext == NULL)
                return false;
            if (!::wglMakeCurrent(DeviceContext, RenderContext))
                return false;
            return true;
        }

        bool Shutdown()
        {
            ImGui_ImplOpenGL3_Shutdown();
            if (RenderContext != NULL)
            {
                ::wglMakeCurrent(NULL, NULL);
                ::wglDeleteContext(RenderContext);
                RenderContext = NULL;
            }
            if (DeviceContext != NULL && Handle != NULL)
            {
                ::ReleaseDC(Handle, DeviceContext);
                DeviceContext = NULL;
            }
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
                ImGui_ImplOpenGL3_DestroyDeviceObjects();
                ImGui_ImplOpenGL3_CreateDeviceObjects();
            }
            ImGui_ImplOpenGL3_NewFrame();
            ImGui_ImplWin32_NewFrame();
        }

        void EndFrame()
        {
            RECT rect;
            ::GetClientRect(Handle, &rect);
            int width = (int)(rect.right - rect.left);
            int height = (int)(rect.bottom - rect.top);
            if (width <= 0 || height <= 0)
                return;
            ::glViewport(0, 0, width, height);
            ::glClearColor(0.10f, 0.11f, 0.13f, 1.00f);
            ::glClear(GL_COLOR_BUFFER_BIT);
            ImGui_ImplOpenGL3_RenderDrawData(ImGui::GetDrawData());
            ::SwapBuffers(DeviceContext);
        }
    };

    inline HostGL3*& HostSlotGL3()
    {
        static HostGL3* slot = NULL;
        return slot;
    }

    inline LRESULT CALLBACK HostWndProcGL3(HWND hwnd, UINT msg, WPARAM wparam, LPARAM lparam)
    {
        if (ImGui_ImplWin32_WndProcHandler(hwnd, msg, wparam, lparam))
            return true;
        switch (msg)
        {
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

    inline HostGL3* CreateHostGL3(const wchar_t* title, int width, int height)
    {
        WNDCLASSEXW wc;
        ZeroMemory(&wc, sizeof(wc));
        wc.cbSize = sizeof(wc);
        wc.style = CS_OWNDC;
        wc.lpfnWndProc = HostWndProcGL3;
        wc.hInstance = ::GetModuleHandle(NULL);
        wc.hCursor = ::LoadCursor(NULL, IDC_ARROW);
        wc.lpszClassName = L"IMCN_HOST_GL3";
        ::RegisterClassExW(&wc);

        HWND hwnd = ::CreateWindowExW(0, wc.lpszClassName, title, WS_OVERLAPPEDWINDOW,
            CW_USEDEFAULT, CW_USEDEFAULT, width, height, NULL, NULL, wc.hInstance, NULL);
        if (hwnd == NULL)
            return NULL;

        HostGL3* host = new HostGL3();
        host->Handle = hwnd;
        if (!host->CreateContextGL(hwnd))
        {
            delete host;
            return NULL;
        }

        IMGUI_CHECKVERSION();
        ImGui::CreateContext();
        ImGui::StyleColorsDark();
        ImGui_ImplWin32_Init(hwnd);
        ImGui_ImplOpenGL3_Init("#version 130");

        HostSlotGL3() = host;
        ::ShowWindow(hwnd, SW_SHOWDEFAULT);
        ::UpdateWindow(hwnd);
        return host;
    }

    inline bool PumpHostGL3(HostGL3* host)
    {
        if (host == NULL)
            return false;
        return host->Pump();
    }

    inline void DestroyHostGL3(HostGL3* host)
    {
        if (host == NULL)
            return;
        host->Shutdown();
        ImGui::DestroyContext();
        if (host->Handle != NULL)
            ::DestroyWindow(host->Handle);
        if (HostSlotGL3() == host)
            HostSlotGL3() = NULL;
        delete host;
    }
}

#endif // IMCN_HOST_GL3_H
