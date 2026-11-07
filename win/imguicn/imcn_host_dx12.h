// ---------------------------------------------------------------------------
// imcn_host_dx12.h - Win32 + Direct3D 12 host for the ImGui wrapper.
// ASCII only (Volcano requires ANSI/ASCII for external headers).
// ---------------------------------------------------------------------------
#ifndef IMCN_HOST_DX12_H
#define IMCN_HOST_DX12_H

#include <windows.h>
#include <d3d12.h>
#include <dxgi1_4.h>

#pragma comment(lib, "d3d12.lib")
#pragma comment(lib, "dxgi.lib")
#pragma comment(lib, "d3dcompiler.lib")

#include "imgui.h"
#include "imcn_helper.h"
#include "backends/imgui_impl_win32.h"
#include "backends/imgui_impl_dx12.h"

extern IMGUI_IMPL_API LRESULT ImGui_ImplWin32_WndProcHandler(HWND hWnd, UINT msg, WPARAM wParam, LPARAM lParam);

namespace imcn
{
    class HostW12
    {
    public:
        static const int kBuffers = 2;
        static const int kSrvCount = 64;

        HWND                        Handle;
        ID3D12Device*               Device;
        ID3D12CommandQueue*         Queue;
        IDXGISwapChain3*            SwapChain;
        ID3D12DescriptorHeap*       RtvHeap;
        ID3D12DescriptorHeap*       SrvHeap;
        ID3D12Resource*             RenderTargets[kBuffers];
        ID3D12CommandAllocator*     Allocators[kBuffers];
        ID3D12GraphicsCommandList*  CommandList;
        ID3D12Fence*                Fence;
        HANDLE                      FenceEvent;
        UINT64                      FenceValues[kBuffers];
        UINT64                      FenceCounter;
        UINT                        RtvSize;
        UINT                        SrvSize;
        UINT                        SrvNext;
        bool                        Running;

        HostW12()
        {
            Handle = NULL;
            Device = NULL;
            Queue = NULL;
            SwapChain = NULL;
            RtvHeap = NULL;
            SrvHeap = NULL;
            CommandList = NULL;
            Fence = NULL;
            FenceEvent = NULL;
            FenceCounter = 0;
            RtvSize = 0;
            SrvSize = 0;
            SrvNext = 0;
            Running = true;
            for (int i = 0; i < kBuffers; ++i)
            {
                RenderTargets[i] = NULL;
                Allocators[i] = NULL;
                FenceValues[i] = 0;
            }
        }

        D3D12_CPU_DESCRIPTOR_HANDLE RtvHandle(UINT index)
        {
            D3D12_CPU_DESCRIPTOR_HANDLE h = RtvHeap->GetCPUDescriptorHandleForHeapStart();
            h.ptr += (SIZE_T)RtvSize * index;
            return h;
        }

        // Bump allocator over the shader visible SRV heap; ImGui only needs one at a time.
        static void SrvAlloc(ImGui_ImplDX12_InitInfo* info,
            D3D12_CPU_DESCRIPTOR_HANDLE* out_cpu, D3D12_GPU_DESCRIPTOR_HANDLE* out_gpu)
        {
            HostW12* host = (HostW12*)info->UserData;
            if (host->SrvNext >= (UINT)kSrvCount)
                host->SrvNext = 0;
            D3D12_CPU_DESCRIPTOR_HANDLE cpu = host->SrvHeap->GetCPUDescriptorHandleForHeapStart();
            D3D12_GPU_DESCRIPTOR_HANDLE gpu = host->SrvHeap->GetGPUDescriptorHandleForHeapStart();
            cpu.ptr += (SIZE_T)host->SrvSize * host->SrvNext;
            gpu.ptr += (UINT64)host->SrvSize * host->SrvNext;
            host->SrvNext++;
            *out_cpu = cpu;
            *out_gpu = gpu;
        }

        static void SrvFree(ImGui_ImplDX12_InitInfo*, D3D12_CPU_DESCRIPTOR_HANDLE, D3D12_GPU_DESCRIPTOR_HANDLE)
        {
        }

        bool WaitForGpu()
        {
            if (Queue == NULL || Fence == NULL)
                return false;
            const UINT64 value = ++FenceCounter;
            if (FAILED(Queue->Signal(Fence, value)))
                return false;
            if (Fence->GetCompletedValue() < value)
            {
                Fence->SetEventOnCompletion(value, FenceEvent);
                ::WaitForSingleObject(FenceEvent, INFINITE);
            }
            return true;
        }

        bool CreateDeviceD3D(HWND hwnd, int width, int height)
        {
            UINT factory_flags = 0;
            IDXGIFactory4* factory = NULL;
            if (FAILED(::CreateDXGIFactory2(factory_flags, IID_PPV_ARGS(&factory))))
                return false;

            IDXGIAdapter1* adapter = NULL;
            for (UINT i = 0; factory->EnumAdapters1(i, &adapter) != DXGI_ERROR_NOT_FOUND; ++i)
            {
                DXGI_ADAPTER_DESC1 desc;
                ZeroMemory(&desc, sizeof(desc));
                adapter->GetDesc1(&desc);
                if (desc.Flags & DXGI_ADAPTER_FLAG_SOFTWARE)
                {
                    adapter->Release();
                    adapter = NULL;
                    continue;
                }
                if (SUCCEEDED(D3D12CreateDevice(adapter, D3D_FEATURE_LEVEL_11_0, IID_PPV_ARGS(&Device))))
                    break;
                adapter->Release();
                adapter = NULL;
            }
            if (Device == NULL)
            {
                if (FAILED(D3D12CreateDevice(NULL, D3D_FEATURE_LEVEL_11_0, IID_PPV_ARGS(&Device))))
                {
                    factory->Release();
                    return false;
                }
            }
            if (adapter != NULL)
                adapter->Release();

            D3D12_COMMAND_QUEUE_DESC qd;
            ZeroMemory(&qd, sizeof(qd));
            qd.Type = D3D12_COMMAND_LIST_TYPE_DIRECT;
            if (FAILED(Device->CreateCommandQueue(&qd, IID_PPV_ARGS(&Queue))))
            {
                factory->Release();
                return false;
            }

            DXGI_SWAP_CHAIN_DESC1 sd;
            ZeroMemory(&sd, sizeof(sd));
            sd.Width = (UINT)width;
            sd.Height = (UINT)height;
            sd.Format = DXGI_FORMAT_R8G8B8A8_UNORM;
            sd.SampleDesc.Count = 1;
            sd.BufferUsage = DXGI_USAGE_RENDER_TARGET_OUTPUT;
            sd.BufferCount = kBuffers;
            sd.SwapEffect = DXGI_SWAP_EFFECT_FLIP_DISCARD;

            IDXGISwapChain1* swap1 = NULL;
            HRESULT hr = factory->CreateSwapChainForHwnd(Queue, hwnd, &sd, NULL, NULL, &swap1);
            factory->Release();
            if (FAILED(hr))
                return false;
            swap1->QueryInterface(IID_PPV_ARGS(&SwapChain));
            swap1->Release();

            D3D12_DESCRIPTOR_HEAP_DESC rh;
            ZeroMemory(&rh, sizeof(rh));
            rh.Type = D3D12_DESCRIPTOR_HEAP_TYPE_RTV;
            rh.NumDescriptors = kBuffers;
            if (FAILED(Device->CreateDescriptorHeap(&rh, IID_PPV_ARGS(&RtvHeap))))
                return false;
            RtvSize = Device->GetDescriptorHandleIncrementSize(D3D12_DESCRIPTOR_HEAP_TYPE_RTV);

            D3D12_DESCRIPTOR_HEAP_DESC sh;
            ZeroMemory(&sh, sizeof(sh));
            sh.Type = D3D12_DESCRIPTOR_HEAP_TYPE_CBV_SRV_UAV;
            sh.NumDescriptors = kSrvCount;
            sh.Flags = D3D12_DESCRIPTOR_HEAP_FLAG_SHADER_VISIBLE;
            if (FAILED(Device->CreateDescriptorHeap(&sh, IID_PPV_ARGS(&SrvHeap))))
                return false;
            SrvSize = Device->GetDescriptorHandleIncrementSize(D3D12_DESCRIPTOR_HEAP_TYPE_CBV_SRV_UAV);

            for (int i = 0; i < kBuffers; ++i)
            {
                if (FAILED(Device->CreateCommandAllocator(D3D12_COMMAND_LIST_TYPE_DIRECT, IID_PPV_ARGS(&Allocators[i]))))
                    return false;
            }
            if (FAILED(Device->CreateCommandList(0, D3D12_COMMAND_LIST_TYPE_DIRECT,
                Allocators[0], NULL, IID_PPV_ARGS(&CommandList))))
                return false;
            CommandList->Close();

            if (FAILED(Device->CreateFence(0, D3D12_FENCE_FLAG_NONE, IID_PPV_ARGS(&Fence))))
                return false;
            FenceEvent = ::CreateEvent(NULL, FALSE, FALSE, NULL);
            if (FenceEvent == NULL)
                return false;

            CreateRenderTargets();
            return true;
        }

        void CreateRenderTargets()
        {
            for (int i = 0; i < kBuffers; ++i)
            {
                if (RenderTargets[i] != NULL)
                    continue;
                if (FAILED(SwapChain->GetBuffer((UINT)i, IID_PPV_ARGS(&RenderTargets[i]))))
                    continue;
                Device->CreateRenderTargetView(RenderTargets[i], NULL, RtvHandle((UINT)i));
            }
        }

        void ReleaseRenderTargets()
        {
            for (int i = 0; i < kBuffers; ++i)
            {
                if (RenderTargets[i] != NULL)
                {
                    RenderTargets[i]->Release();
                    RenderTargets[i] = NULL;
                }
            }
        }

        bool Shutdown()
        {
            if (Device != NULL)
            {
                WaitForGpu();
                ImGui_ImplDX12_Shutdown();
            }
            if (FenceEvent != NULL) { ::CloseHandle(FenceEvent); FenceEvent = NULL; }
            ReleaseRenderTargets();
            if (CommandList != NULL) { CommandList->Release(); CommandList = NULL; }
            for (int i = 0; i < kBuffers; ++i)
            {
                if (Allocators[i] != NULL) { Allocators[i]->Release(); Allocators[i] = NULL; }
            }
            if (Fence != NULL) { Fence->Release(); Fence = NULL; }
            if (SrvHeap != NULL) { SrvHeap->Release(); SrvHeap = NULL; }
            if (RtvHeap != NULL) { RtvHeap->Release(); RtvHeap = NULL; }
            if (SwapChain != NULL) { SwapChain->Release(); SwapChain = NULL; }
            if (Queue != NULL) { Queue->Release(); Queue = NULL; }
            if (Device != NULL) { Device->Release(); Device = NULL; }
            return true;
        }

        bool Resize(int width, int height)
        {
            if (SwapChain == NULL || width <= 0 || height <= 0)
                return false;
            WaitForGpu();
            ImGui_ImplDX12_InvalidateDeviceObjects();
            ReleaseRenderTargets();
            if (FAILED(SwapChain->ResizeBuffers(kBuffers, (UINT)width, (UINT)height,
                DXGI_FORMAT_R8G8B8A8_UNORM, 0)))
                return false;
            CreateRenderTargets();
            ImGui_ImplDX12_CreateDeviceObjects();
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
                ImGui_ImplDX12_InvalidateDeviceObjects();
                ImGui_ImplDX12_CreateDeviceObjects();
            }
            ImGui_ImplDX12_NewFrame();
            ImGui_ImplWin32_NewFrame();
        }

        void EndFrame()
        {
            if (SwapChain == NULL || CommandList == NULL)
                return;
            const UINT index = SwapChain->GetCurrentBackBufferIndex();

            // Wait until the GPU finished the frame that used this slot.
            if (Fence->GetCompletedValue() < FenceValues[index])
            {
                Fence->SetEventOnCompletion(FenceValues[index], FenceEvent);
                ::WaitForSingleObject(FenceEvent, INFINITE);
            }

            Allocators[index]->Reset();
            CommandList->Reset(Allocators[index], NULL);

            D3D12_RESOURCE_BARRIER barrier;
            ZeroMemory(&barrier, sizeof(barrier));
            barrier.Type = D3D12_RESOURCE_BARRIER_TYPE_TRANSITION;
            barrier.Transition.pResource = RenderTargets[index];
            barrier.Transition.Subresource = D3D12_RESOURCE_BARRIER_ALL_SUBRESOURCES;
            barrier.Transition.StateBefore = D3D12_RESOURCE_STATE_PRESENT;
            barrier.Transition.StateAfter = D3D12_RESOURCE_STATE_RENDER_TARGET;
            CommandList->ResourceBarrier(1, &barrier);

            D3D12_CPU_DESCRIPTOR_HANDLE rtv = RtvHandle(index);
            CommandList->OMSetRenderTargets(1, &rtv, FALSE, NULL);
            ID3D12DescriptorHeap* heaps[1] = { SrvHeap };
            CommandList->SetDescriptorHeaps(1, heaps);

            const float clear_color[4] = { 0.10f, 0.11f, 0.13f, 1.00f };
            CommandList->ClearRenderTargetView(rtv, clear_color, 0, NULL);
            ImGui_ImplDX12_RenderDrawData(ImGui::GetDrawData(), CommandList);

            barrier.Transition.StateBefore = D3D12_RESOURCE_STATE_RENDER_TARGET;
            barrier.Transition.StateAfter = D3D12_RESOURCE_STATE_PRESENT;
            CommandList->ResourceBarrier(1, &barrier);
            CommandList->Close();

            ID3D12CommandList* lists[1] = { CommandList };
            Queue->ExecuteCommandLists(1, lists);
            SwapChain->Present(1, 0);

            const UINT64 value = ++FenceCounter;
            Queue->Signal(Fence, value);
            FenceValues[index] = value;
        }
    };

    inline HostW12*& HostSlot12()
    {
        static HostW12* slot = NULL;
        return slot;
    }

    inline LRESULT CALLBACK HostWndProc12(HWND hwnd, UINT msg, WPARAM wparam, LPARAM lparam)
    {
        if (ImGui_ImplWin32_WndProcHandler(hwnd, msg, wparam, lparam))
            return true;
        switch (msg)
        {
        case WM_SIZE:
            if (wparam != SIZE_MINIMIZED && HostSlot12() != NULL)
                HostSlot12()->Resize((int)LOWORD(lparam), (int)HIWORD(lparam));
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

    inline HostW12* CreateHostW12(const wchar_t* title, int width, int height)
    {
        WNDCLASSEXW wc;
        ZeroMemory(&wc, sizeof(wc));
        wc.cbSize = sizeof(wc);
        wc.style = CS_OWNDC;
        wc.lpfnWndProc = HostWndProc12;
        wc.hInstance = ::GetModuleHandle(NULL);
        wc.hCursor = ::LoadCursor(NULL, IDC_ARROW);
        wc.lpszClassName = L"IMCN_HOST_W12";
        ::RegisterClassExW(&wc);

        HWND hwnd = ::CreateWindowExW(0, wc.lpszClassName, title, WS_OVERLAPPEDWINDOW,
            CW_USEDEFAULT, CW_USEDEFAULT, width, height, NULL, NULL, wc.hInstance, NULL);
        if (hwnd == NULL)
            return NULL;

        HostW12* host = new HostW12();
        host->Handle = hwnd;
        if (!host->CreateDeviceD3D(hwnd, width, height))
        {
            host->Shutdown();
            delete host;
            return NULL;
        }

        IMGUI_CHECKVERSION();
        ImGui::CreateContext();
        ImGui::StyleColorsDark();
        ImGui_ImplWin32_Init(hwnd);

        ImGui_ImplDX12_InitInfo info;
        ZeroMemory(&info, sizeof(info));
        info.Device = host->Device;
        info.CommandQueue = host->Queue;
        info.NumFramesInFlight = HostW12::kBuffers;
        info.RTVFormat = DXGI_FORMAT_R8G8B8A8_UNORM;
        info.DSVFormat = DXGI_FORMAT_UNKNOWN;
        info.UserData = host;
        info.SrvDescriptorHeap = host->SrvHeap;
        info.SrvDescriptorAllocFn = &HostW12::SrvAlloc;
        info.SrvDescriptorFreeFn = &HostW12::SrvFree;
        ImGui_ImplDX12_Init(&info);

        HostSlot12() = host;
        ::ShowWindow(hwnd, SW_SHOWDEFAULT);
        ::UpdateWindow(hwnd);
        return host;
    }

    inline bool PumpHostW12(HostW12* host)
    {
        if (host == NULL)
            return false;
        return host->Pump();
    }

    inline void DestroyHostW12(HostW12* host)
    {
        if (host == NULL)
            return;
        host->Shutdown();
        ImGui::DestroyContext();
        if (host->Handle != NULL)
            ::DestroyWindow(host->Handle);
        if (HostSlot12() == host)
            HostSlot12() = NULL;
        delete host;
    }
}

#endif // IMCN_HOST_DX12_H
