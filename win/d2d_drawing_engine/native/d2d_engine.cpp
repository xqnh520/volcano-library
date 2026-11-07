#include "d2d_engine.hpp"

#include "lunasvg_bridge.hpp"

#include <algorithm>
#include <cmath>
#include <cwchar>
#include <cwctype>
#include <fstream>
#include <sstream>

namespace volcano_d2d {

static const wchar_t* kEngineWindowProp = L"VolcanoD2DEnginePtr";

namespace {

struct ScopedBoolReset {
    explicit ScopedBoolReset(bool& value) : value_(value) {
        value_ = true;
    }

    ~ScopedBoolReset() {
        value_ = false;
    }

    bool& value_;
};

struct ScopedPaint {
    ScopedPaint(HWND hwnd, PAINTSTRUCT& paintStruct) : hwnd_(hwnd), paintStruct_(paintStruct) {
        BeginPaint(hwnd_, &paintStruct_);
    }

    ~ScopedPaint() {
        EndPaint(hwnd_, &paintStruct_);
    }

    HWND hwnd_;
    PAINTSTRUCT& paintStruct_;
};

int ClampRenderSize(int value) {
    return value > 0 ? value : 1;
}

}  // namespace

Engine::Engine() = default;
Engine::~Engine() {
    Destroy();
}

HRESULT Engine::EnsureFactories(const RenderOptions& options) {
    if (!comInitialized_) {
        HRESULT comResult = CoInitializeEx(nullptr, COINIT_APARTMENTTHREADED);
        if (SUCCEEDED(comResult)) {
            comInitialized_ = true;
        } else if (comResult != RPC_E_CHANGED_MODE) {
            lastResult_ = comResult;
            return lastResult_;
        }
    }

    if (!factory_) {
        D2D1_FACTORY_OPTIONS factoryOptions{};
        factoryOptions.debugLevel = static_cast<D2D1_DEBUG_LEVEL>(options.debugLevel);
        lastResult_ = D2D1CreateFactory(
            static_cast<D2D1_FACTORY_TYPE>(options.factoryType),
            __uuidof(ID2D1Factory1),
            &factoryOptions,
            reinterpret_cast<void**>(factory_.ReleaseAndGetAddressOf()));
        if (FAILED(lastResult_)) return lastResult_;
    }

    if (!writeFactory_) {
        lastResult_ = DWriteCreateFactory(
            DWRITE_FACTORY_TYPE_SHARED,
            __uuidof(IDWriteFactory),
            reinterpret_cast<IUnknown**>(writeFactory_.ReleaseAndGetAddressOf()));
        if (FAILED(lastResult_)) return lastResult_;
    }

    if (!wicFactory_) {
        lastResult_ = CoCreateInstance(
            CLSID_WICImagingFactory,
            nullptr,
            CLSCTX_INPROC_SERVER,
            IID_PPV_ARGS(wicFactory_.ReleaseAndGetAddressOf()));
        if (FAILED(lastResult_)) return lastResult_;
    }

    return S_OK;
}

HRESULT Engine::CreateForHwnd(HWND hwnd, int width, int height, const RenderOptions& options) {
    if (!hwnd || !IsWindow(hwnd)) return lastResult_ = E_INVALIDARG;
    if (hwnd_ && hwnd_ != hwnd) {
        UninstallAutoRepaint();
        tempBrush_.Reset();
        target_.Reset();
    }
    hwnd_ = hwnd;
    options_ = options;
    lastResult_ = EnsureFactories(options);
    if (FAILED(lastResult_)) return lastResult_;

    RECT client{};
    if (width <= 0 || height <= 0) {
        GetClientRect(hwnd, &client);
        width = client.right - client.left;
        height = client.bottom - client.top;
    }
    width = ClampRenderSize(width);
    height = ClampRenderSize(height);

    D2D1_RENDER_TARGET_PROPERTIES rtProps = D2D1::RenderTargetProperties(
        static_cast<D2D1_RENDER_TARGET_TYPE>(options.renderTargetType),
        D2D1::PixelFormat(static_cast<DXGI_FORMAT>(options.pixelFormat), static_cast<D2D1_ALPHA_MODE>(options.alphaMode)),
        options.dpiX,
        options.dpiY,
        static_cast<D2D1_RENDER_TARGET_USAGE>(options.gdiCompatible ? D2D1_RENDER_TARGET_USAGE_GDI_COMPATIBLE : D2D1_RENDER_TARGET_USAGE_NONE),
        static_cast<D2D1_FEATURE_LEVEL>(options.featureLevel));

    D2D1_HWND_RENDER_TARGET_PROPERTIES hwndProps = D2D1::HwndRenderTargetProperties(
        hwnd,
        D2D1::SizeU(static_cast<UINT32>(width), static_cast<UINT32>(height)),
        static_cast<D2D1_PRESENT_OPTIONS>(options.presentOptions));

    lastResult_ = factory_->CreateHwndRenderTarget(rtProps, hwndProps, target_.ReleaseAndGetAddressOf());
    tempBrush_.Reset();
    return lastResult_;
}

void Engine::Destroy() {
    UninstallAutoRepaint();
    tempBrush_.Reset();
    target_.Reset();
    wicFactory_.Reset();
    writeFactory_.Reset();
    factory_.Reset();
    if (comInitialized_) {
        CoUninitialize();
        comInitialized_ = false;
    }
    hwnd_ = nullptr;
    lastResult_ = S_OK;
}

bool Engine::IsReady() const {
    return target_ != nullptr;
}

HRESULT Engine::Resize(int width, int height) {
    if (!target_) return lastResult_ = E_POINTER;
    if (width <= 0 || height <= 0) {
        RECT client{};
        GetClientRect(hwnd_, &client);
        width = client.right - client.left;
        height = client.bottom - client.top;
    }
    width = ClampRenderSize(width);
    height = ClampRenderSize(height);
    lastResult_ = target_->Resize(D2D1::SizeU(static_cast<UINT32>(width), static_cast<UINT32>(height)));
    return lastResult_;
}

void Engine::Invalidate(bool eraseBackground) {
    if (hwnd_) InvalidateRect(hwnd_, nullptr, eraseBackground ? TRUE : FALSE);
}

void Engine::UpdateNow() {
    if (hwnd_) UpdateWindow(hwnd_);
}

bool Engine::InstallAutoRepaint(void* owner, PaintCallback paintCallback, ResizeCallback resizeCallback, MouseCallback mouseCallback, KeyCallback keyCallback) {
    if (!hwnd_ || !paintCallback) return false;
    auto* existing = reinterpret_cast<Engine*>(GetPropW(hwnd_, kEngineWindowProp));
    if (existing && existing != this) {
        lastResult_ = HRESULT_FROM_WIN32(ERROR_ALREADY_EXISTS);
        return false;
    }

    callbackOwner_ = owner;
    paintCallback_ = paintCallback;
    resizeCallback_ = resizeCallback;
    mouseCallback_ = mouseCallback;
    keyCallback_ = keyCallback;

    if (!oldWndProc_) {
        SetLastError(0);
        oldWndProc_ = reinterpret_cast<WNDPROC>(
            SetWindowLongPtrW(hwnd_, GWLP_WNDPROC, reinterpret_cast<LONG_PTR>(&Engine::AutoRepaintWndProc)));
        if (!oldWndProc_ && GetLastError() != 0) {
            lastResult_ = HRESULT_FROM_WIN32(GetLastError());
            callbackOwner_ = nullptr;
            paintCallback_ = nullptr;
            resizeCallback_ = nullptr;
            mouseCallback_ = nullptr;
            keyCallback_ = nullptr;
            return false;
        }
    }

    if (!SetPropW(hwnd_, kEngineWindowProp, this)) {
        lastResult_ = HRESULT_FROM_WIN32(GetLastError());
        if (oldWndProc_) {
            SetWindowLongPtrW(hwnd_, GWLP_WNDPROC, reinterpret_cast<LONG_PTR>(oldWndProc_));
            oldWndProc_ = nullptr;
        }
        callbackOwner_ = nullptr;
        paintCallback_ = nullptr;
        resizeCallback_ = nullptr;
        mouseCallback_ = nullptr;
        keyCallback_ = nullptr;
        return false;
    }
    Invalidate(false);
    return true;
}

void Engine::UninstallAutoRepaint() {
    if (hwnd_ && oldWndProc_) {
        SetWindowLongPtrW(hwnd_, GWLP_WNDPROC, reinterpret_cast<LONG_PTR>(oldWndProc_));
        RemovePropW(hwnd_, kEngineWindowProp);
    }
    oldWndProc_ = nullptr;
    callbackOwner_ = nullptr;
    paintCallback_ = nullptr;
    resizeCallback_ = nullptr;
    mouseCallback_ = nullptr;
    keyCallback_ = nullptr;
    inAutoPaint_ = false;
    trackingMouseLeave_ = false;
}

LRESULT CALLBACK Engine::AutoRepaintWndProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam) {
    auto* engine = reinterpret_cast<Engine*>(GetPropW(hwnd, kEngineWindowProp));
    if (engine) return engine->HandleAutoRepaintMessage(hwnd, message, wParam, lParam);
    return DefWindowProcW(hwnd, message, wParam, lParam);
}

LRESULT Engine::HandleAutoRepaintMessage(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam) {
    switch (message) {
    case WM_ERASEBKGND:
        return 1;
    case WM_SIZE: {
        const int width = LOWORD(lParam);
        const int height = HIWORD(lParam);
        Resize(width, height);
        if (resizeCallback_) resizeCallback_(callbackOwner_, width, height);
        Invalidate(false);
        break;
    }
    case WM_PAINT: {
        PAINTSTRUCT ps{};
        ScopedPaint paint(hwnd, ps);
        if (paintCallback_ && !inAutoPaint_) {
            ScopedBoolReset reset(inAutoPaint_);
            paintCallback_(callbackOwner_);
        }
        return 0;
    }
    case WM_MOUSEMOVE:
    case WM_LBUTTONDOWN:
    case WM_LBUTTONUP: {
        if (mouseCallback_) {
            int x = GET_X_LPARAM(lParam);
            int y = GET_Y_LPARAM(lParam);
            if (target_) {
                float dpiX = 96.0f;
                float dpiY = 96.0f;
                target_->GetDpi(&dpiX, &dpiY);
                if (dpiX > 0.0f) x = static_cast<int>((x * 96.0f) / dpiX);
                if (dpiY > 0.0f) y = static_cast<int>((y * 96.0f) / dpiY);
            }
            if (message == WM_MOUSEMOVE && !trackingMouseLeave_) {
                TRACKMOUSEEVENT track{};
                track.cbSize = sizeof(track);
                track.dwFlags = TME_LEAVE;
                track.hwndTrack = hwnd;
                trackingMouseLeave_ = TrackMouseEvent(&track) != FALSE;
            }
            const int type = message == WM_LBUTTONDOWN ? MOUSE_DOWN
                           : message == WM_LBUTTONUP ? MOUSE_UP
                           : MOUSE_MOVE;
            mouseCallback_(callbackOwner_, x, y, type);
        }
        break;
    }
    case WM_MOUSELEAVE:
        trackingMouseLeave_ = false;
        if (mouseCallback_) {
            mouseCallback_(callbackOwner_, 0, 0, MOUSE_LEAVE);
        }
        break;
    case WM_MOUSEWHEEL:
        if (mouseCallback_) {
            POINT pt{ GET_X_LPARAM(lParam), GET_Y_LPARAM(lParam) };
            ScreenToClient(hwnd, &pt);
            int x = pt.x;
            int y = pt.y;
            if (target_) {
                float dpiX = 96.0f;
                float dpiY = 96.0f;
                target_->GetDpi(&dpiX, &dpiY);
                if (dpiX > 0.0f) x = static_cast<int>((x * 96.0f) / dpiX);
                if (dpiY > 0.0f) y = static_cast<int>((y * 96.0f) / dpiY);
            }
            mouseCallback_(callbackOwner_, x, y, MOUSE_WHEEL);
        }
        break;
    case WM_SETFOCUS:
        if (keyCallback_) keyCallback_(callbackOwner_, KEY_FOCUS, 0);
        break;
    case WM_KILLFOCUS:
        if (keyCallback_) keyCallback_(callbackOwner_, KEY_BLUR, 0);
        break;
    case WM_KEYDOWN:
    case WM_SYSKEYDOWN:
        if (keyCallback_) {
            keyCallback_(callbackOwner_, KEY_DOWN, static_cast<int>(wParam));
            if (wParam == VK_SPACE || wParam == VK_RETURN) return 0;
        }
        break;
    case WM_KEYUP:
    case WM_SYSKEYUP:
        if (keyCallback_) {
            keyCallback_(callbackOwner_, KEY_UP, static_cast<int>(wParam));
            if (wParam == VK_SPACE || wParam == VK_RETURN) return 0;
        }
        break;
    case WM_NCDESTROY: {
        WNDPROC previous = oldWndProc_;
        UninstallAutoRepaint();
        return previous ? CallWindowProcW(previous, hwnd, message, wParam, lParam)
                        : DefWindowProcW(hwnd, message, wParam, lParam);
    }
    default:
        break;
    }
    return oldWndProc_ ? CallWindowProcW(oldWndProc_, hwnd, message, wParam, lParam)
                       : DefWindowProcW(hwnd, message, wParam, lParam);
}

void Engine::BeginDraw() {
    if (target_) target_->BeginDraw();
}

HRESULT Engine::EndDraw() {
    if (!target_) return lastResult_ = E_POINTER;
    lastResult_ = target_->EndDraw();
    if (lastResult_ == D2DERR_RECREATE_TARGET) {
        tempBrush_.Reset();
        target_.Reset();
    }
    return lastResult_;
}

void Engine::Flush() {
    if (target_) lastResult_ = target_->Flush();
}

void Engine::Clear(Color color) {
    if (target_) target_->Clear(ToD2D(color));
}

void Engine::SetDpi(float dpiX, float dpiY) {
    if (target_) target_->SetDpi(dpiX, dpiY);
}

void Engine::SetTransform(Matrix matrix) {
    if (target_) target_->SetTransform(ToD2D(matrix));
}

void Engine::ResetTransform() {
    if (target_) target_->SetTransform(D2D1::Matrix3x2F::Identity());
}

void Engine::SetAntialiasMode(int mode) {
    if (target_) target_->SetAntialiasMode(static_cast<D2D1_ANTIALIAS_MODE>(mode));
}

void Engine::SetTextAntialiasMode(int mode) {
    if (target_) target_->SetTextAntialiasMode(static_cast<D2D1_TEXT_ANTIALIAS_MODE>(mode));
}

void Engine::SetTags(UINT64 tag1, UINT64 tag2) {
    if (target_) target_->SetTags(tag1, tag2);
}

void Engine::DrawLine(Point p1, Point p2, Color color, float strokeWidth) {
    if (auto brush = TempBrush(color)) target_->DrawLine(ToD2D(p1), ToD2D(p2), brush, strokeWidth);
}

void Engine::DrawRectangle(Rect rect, Color color, float strokeWidth) {
    if (auto brush = TempBrush(color)) target_->DrawRectangle(ToD2D(rect), brush, strokeWidth);
}

void Engine::FillRectangle(Rect rect, Color color) {
    if (auto brush = TempBrush(color)) target_->FillRectangle(ToD2D(rect), brush);
}

void Engine::DrawRoundedRectangle(Rect rect, float radiusX, float radiusY, Color color, float strokeWidth) {
    if (auto brush = TempBrush(color)) {
        target_->DrawRoundedRectangle(D2D1::RoundedRect(ToD2D(rect), radiusX, radiusY), brush, strokeWidth);
    }
}

void Engine::FillRoundedRectangle(Rect rect, float radiusX, float radiusY, Color color) {
    if (auto brush = TempBrush(color)) {
        target_->FillRoundedRectangle(D2D1::RoundedRect(ToD2D(rect), radiusX, radiusY), brush);
    }
}

void Engine::DrawEllipse(Point center, float radiusX, float radiusY, Color color, float strokeWidth) {
    if (auto brush = TempBrush(color)) target_->DrawEllipse(D2D1::Ellipse(ToD2D(center), radiusX, radiusY), brush, strokeWidth);
}

void Engine::FillEllipse(Point center, float radiusX, float radiusY, Color color) {
    if (auto brush = TempBrush(color)) target_->FillEllipse(D2D1::Ellipse(ToD2D(center), radiusX, radiusY), brush);
}

HRESULT Engine::CreateSolidBrush(Color color, float opacity, ID2D1SolidColorBrush** brush) {
    if (!target_ || !brush) return lastResult_ = E_POINTER;
    D2D1_BRUSH_PROPERTIES props = D2D1::BrushProperties(opacity);
    lastResult_ = target_->CreateSolidColorBrush(ToD2D(color), props, brush);
    return lastResult_;
}

HRESULT Engine::CreateLinearGradientBrush(Point start, Point end, const GradientStop* stops, UINT32 count, ID2D1LinearGradientBrush** brush) {
    if (!target_ || !stops || count == 0 || !brush) return lastResult_ = E_INVALIDARG;
    std::vector<D2D1_GRADIENT_STOP> nativeStops(count);
    for (UINT32 i = 0; i < count; ++i) {
        nativeStops[i].position = stops[i].position;
        nativeStops[i].color = ToD2D(stops[i].color);
    }
    ComPtr<ID2D1GradientStopCollection> collection;
    lastResult_ = target_->CreateGradientStopCollection(nativeStops.data(), count, collection.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = target_->CreateLinearGradientBrush(D2D1::LinearGradientBrushProperties(ToD2D(start), ToD2D(end)), collection.Get(), brush);
    return lastResult_;
}

HRESULT Engine::CreateRadialGradientBrush(Point center, Point originOffset, float radiusX, float radiusY, const GradientStop* stops, UINT32 count, ID2D1RadialGradientBrush** brush) {
    if (!target_ || !stops || count == 0 || !brush) return lastResult_ = E_INVALIDARG;
    std::vector<D2D1_GRADIENT_STOP> nativeStops(count);
    for (UINT32 i = 0; i < count; ++i) {
        nativeStops[i].position = stops[i].position;
        nativeStops[i].color = ToD2D(stops[i].color);
    }
    ComPtr<ID2D1GradientStopCollection> collection;
    lastResult_ = target_->CreateGradientStopCollection(nativeStops.data(), count, collection.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = target_->CreateRadialGradientBrush(
        D2D1::RadialGradientBrushProperties(ToD2D(center), ToD2D(originOffset), radiusX, radiusY),
        collection.Get(),
        brush);
    return lastResult_;
}

void Engine::ReleaseUnknown(IUnknown* value) {
    if (value) value->Release();
}

void Engine::SetBrushOpacity(ID2D1Brush* brush, float opacity) {
    if (brush) brush->SetOpacity(opacity);
}

void Engine::SetBrushTransform(ID2D1Brush* brush, Matrix matrix) {
    if (brush) brush->SetTransform(ToD2D(matrix));
}

void Engine::DrawLineByBrush(Point p1, Point p2, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle) {
    if (target_ && brush) target_->DrawLine(ToD2D(p1), ToD2D(p2), brush, strokeWidth, strokeStyle);
}

void Engine::DrawRectByBrush(Rect rect, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle) {
    if (target_ && brush) target_->DrawRectangle(ToD2D(rect), brush, strokeWidth, strokeStyle);
}

void Engine::FillRectByBrush(Rect rect, ID2D1Brush* brush) {
    if (target_ && brush) target_->FillRectangle(ToD2D(rect), brush);
}

void Engine::DrawRoundedRectByBrush(Rect rect, float radiusX, float radiusY, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle) {
    if (target_ && brush) target_->DrawRoundedRectangle(D2D1::RoundedRect(ToD2D(rect), radiusX, radiusY), brush, strokeWidth, strokeStyle);
}

void Engine::FillRoundedRectByBrush(Rect rect, float radiusX, float radiusY, ID2D1Brush* brush) {
    if (target_ && brush) target_->FillRoundedRectangle(D2D1::RoundedRect(ToD2D(rect), radiusX, radiusY), brush);
}

void Engine::DrawEllipseByBrush(Point center, float radiusX, float radiusY, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle) {
    if (target_ && brush) target_->DrawEllipse(D2D1::Ellipse(ToD2D(center), radiusX, radiusY), brush, strokeWidth, strokeStyle);
}

void Engine::FillEllipseByBrush(Point center, float radiusX, float radiusY, ID2D1Brush* brush) {
    if (target_ && brush) target_->FillEllipse(D2D1::Ellipse(ToD2D(center), radiusX, radiusY), brush);
}

HRESULT Engine::CreateStrokeStyle(int startCap, int endCap, int dashCap, int lineJoin, float miterLimit, int dashStyle, float dashOffset, ID2D1StrokeStyle** style) {
    if (!factory_ || !style) return lastResult_ = E_POINTER;
    D2D1_STROKE_STYLE_PROPERTIES props = D2D1::StrokeStyleProperties(
        static_cast<D2D1_CAP_STYLE>(startCap),
        static_cast<D2D1_CAP_STYLE>(endCap),
        static_cast<D2D1_CAP_STYLE>(dashCap),
        static_cast<D2D1_LINE_JOIN>(lineJoin),
        miterLimit,
        static_cast<D2D1_DASH_STYLE>(dashStyle),
        dashOffset);
    lastResult_ = factory_->CreateStrokeStyle(props, nullptr, 0, style);
    return lastResult_;
}

HRESULT Engine::CreateCustomStrokeStyle(int startCap, int endCap, int dashCap, int lineJoin, float miterLimit, float dashOffset, const float* dashes, UINT32 dashCount, ID2D1StrokeStyle** style) {
    if (!factory_ || !style || !dashes || dashCount == 0) return lastResult_ = E_INVALIDARG;
    D2D1_STROKE_STYLE_PROPERTIES props = D2D1::StrokeStyleProperties(
        static_cast<D2D1_CAP_STYLE>(startCap),
        static_cast<D2D1_CAP_STYLE>(endCap),
        static_cast<D2D1_CAP_STYLE>(dashCap),
        static_cast<D2D1_LINE_JOIN>(lineJoin),
        miterLimit,
        D2D1_DASH_STYLE_CUSTOM,
        dashOffset);
    lastResult_ = factory_->CreateStrokeStyle(props, dashes, dashCount, style);
    return lastResult_;
}

HRESULT Engine::CreateRectangleGeometry(Rect rect, ID2D1RectangleGeometry** geometry) {
    if (!factory_ || !geometry) return lastResult_ = E_POINTER;
    lastResult_ = factory_->CreateRectangleGeometry(ToD2D(rect), geometry);
    return lastResult_;
}

HRESULT Engine::CreateRoundedRectangleGeometry(Rect rect, float radiusX, float radiusY, ID2D1RoundedRectangleGeometry** geometry) {
    if (!factory_ || !geometry) return lastResult_ = E_POINTER;
    lastResult_ = factory_->CreateRoundedRectangleGeometry(D2D1::RoundedRect(ToD2D(rect), radiusX, radiusY), geometry);
    return lastResult_;
}

HRESULT Engine::CreateEllipseGeometry(Point center, float radiusX, float radiusY, ID2D1EllipseGeometry** geometry) {
    if (!factory_ || !geometry) return lastResult_ = E_POINTER;
    lastResult_ = factory_->CreateEllipseGeometry(D2D1::Ellipse(ToD2D(center), radiusX, radiusY), geometry);
    return lastResult_;
}

HRESULT Engine::CreateTransformedGeometry(ID2D1Geometry* source, Matrix matrix, ID2D1TransformedGeometry** geometry) {
    if (!factory_ || !source || !geometry) return lastResult_ = E_POINTER;
    lastResult_ = factory_->CreateTransformedGeometry(source, ToD2D(matrix), geometry);
    return lastResult_;
}

HRESULT Engine::CreateCombinedGeometry(ID2D1Geometry* first, ID2D1Geometry* second, int combineMode, ID2D1PathGeometry** geometry) {
    if (!factory_ || !first || !second || !geometry) return lastResult_ = E_POINTER;
    ComPtr<ID2D1PathGeometry> path;
    ComPtr<ID2D1GeometrySink> sink;
    lastResult_ = factory_->CreatePathGeometry(path.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = path->Open(sink.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = first->CombineWithGeometry(second, static_cast<D2D1_COMBINE_MODE>(combineMode), nullptr, D2D1_DEFAULT_FLATTENING_TOLERANCE, sink.Get());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = sink->Close();
    if (FAILED(lastResult_)) return lastResult_;
    *geometry = path.Detach();
    return lastResult_;
}

HRESULT Engine::CreateSimplifiedGeometry(ID2D1Geometry* source, int simplifyOption, ID2D1PathGeometry** geometry) {
    if (!factory_ || !source || !geometry) return lastResult_ = E_POINTER;
    ComPtr<ID2D1PathGeometry> path;
    ComPtr<ID2D1GeometrySink> sink;
    lastResult_ = factory_->CreatePathGeometry(path.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = path->Open(sink.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = source->Simplify(static_cast<D2D1_GEOMETRY_SIMPLIFICATION_OPTION>(simplifyOption), nullptr, D2D1_DEFAULT_FLATTENING_TOLERANCE, sink.Get());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = sink->Close();
    if (FAILED(lastResult_)) return lastResult_;
    *geometry = path.Detach();
    return lastResult_;
}

HRESULT Engine::CreateWidenedGeometry(ID2D1Geometry* source, float strokeWidth, ID2D1StrokeStyle* strokeStyle, ID2D1PathGeometry** geometry) {
    if (!factory_ || !source || !geometry) return lastResult_ = E_POINTER;
    ComPtr<ID2D1PathGeometry> path;
    ComPtr<ID2D1GeometrySink> sink;
    lastResult_ = factory_->CreatePathGeometry(path.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = path->Open(sink.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = source->Widen(strokeWidth, strokeStyle, nullptr, D2D1_DEFAULT_FLATTENING_TOLERANCE, sink.Get());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = sink->Close();
    if (FAILED(lastResult_)) return lastResult_;
    *geometry = path.Detach();
    return lastResult_;
}

HRESULT Engine::CreateOutlinedGeometry(ID2D1Geometry* source, ID2D1PathGeometry** geometry) {
    if (!factory_ || !source || !geometry) return lastResult_ = E_POINTER;
    ComPtr<ID2D1PathGeometry> path;
    ComPtr<ID2D1GeometrySink> sink;
    lastResult_ = factory_->CreatePathGeometry(path.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = path->Open(sink.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = source->Outline(nullptr, D2D1_DEFAULT_FLATTENING_TOLERANCE, sink.Get());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = sink->Close();
    if (FAILED(lastResult_)) return lastResult_;
    *geometry = path.Detach();
    return lastResult_;
}

HRESULT Engine::CreateGeometryGroup2(ID2D1Geometry* first, ID2D1Geometry* second, int fillMode, ID2D1GeometryGroup** geometry) {
    if (!factory_ || !first || !second || !geometry) return lastResult_ = E_POINTER;
    ID2D1Geometry* geometries[2] = { first, second };
    lastResult_ = factory_->CreateGeometryGroup(static_cast<D2D1_FILL_MODE>(fillMode), geometries, 2, geometry);
    return lastResult_;
}

HRESULT Engine::CreatePathGeometry(ID2D1PathGeometry** geometry) {
    if (!factory_ || !geometry) return lastResult_ = E_POINTER;
    lastResult_ = factory_->CreatePathGeometry(geometry);
    return lastResult_;
}

HRESULT Engine::OpenGeometry(ID2D1PathGeometry* geometry, ID2D1GeometrySink** sink) {
    if (!geometry || !sink) return lastResult_ = E_POINTER;
    lastResult_ = geometry->Open(sink);
    return lastResult_;
}

void Engine::GeometryBeginFigure(ID2D1GeometrySink* sink, Point start, bool filled) {
    if (sink) sink->BeginFigure(ToD2D(start), filled ? D2D1_FIGURE_BEGIN_FILLED : D2D1_FIGURE_BEGIN_HOLLOW);
}

void Engine::GeometryAddLine(ID2D1GeometrySink* sink, Point point) {
    if (sink) sink->AddLine(ToD2D(point));
}

void Engine::GeometryAddBezier(ID2D1GeometrySink* sink, Point p1, Point p2, Point p3) {
    if (sink) sink->AddBezier(D2D1::BezierSegment(ToD2D(p1), ToD2D(p2), ToD2D(p3)));
}

void Engine::GeometryAddQuadraticBezier(ID2D1GeometrySink* sink, Point p1, Point p2) {
    if (sink) sink->AddQuadraticBezier(D2D1::QuadraticBezierSegment(ToD2D(p1), ToD2D(p2)));
}

void Engine::GeometryAddArc(ID2D1GeometrySink* sink, Point end, float radiusX, float radiusY, float rotation, int sweepDirection, int arcSize) {
    if (sink) {
        sink->AddArc(D2D1::ArcSegment(
            ToD2D(end),
            D2D1::SizeF(radiusX, radiusY),
            rotation,
            static_cast<D2D1_SWEEP_DIRECTION>(sweepDirection),
            static_cast<D2D1_ARC_SIZE>(arcSize)));
    }
}

void Engine::GeometryEndFigure(ID2D1GeometrySink* sink, bool closed) {
    if (sink) sink->EndFigure(closed ? D2D1_FIGURE_END_CLOSED : D2D1_FIGURE_END_OPEN);
}

HRESULT Engine::GeometryClose(ID2D1GeometrySink* sink) {
    if (!sink) return lastResult_ = E_POINTER;
    lastResult_ = sink->Close();
    sink->Release();
    return lastResult_;
}

void Engine::DrawGeometry(ID2D1Geometry* geometry, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle) {
    if (target_ && geometry && brush) target_->DrawGeometry(geometry, brush, strokeWidth, strokeStyle);
}

void Engine::FillGeometry(ID2D1Geometry* geometry, ID2D1Brush* brush) {
    if (target_ && geometry && brush) target_->FillGeometry(geometry, brush);
}

HRESULT Engine::GeometryGetBounds(ID2D1Geometry* geometry, Rect* bounds) {
    if (!geometry || !bounds) return lastResult_ = E_POINTER;
    D2D1_RECT_F nativeBounds{};
    lastResult_ = geometry->GetBounds(nullptr, &nativeBounds);
    if (SUCCEEDED(lastResult_)) {
        bounds->left = nativeBounds.left;
        bounds->top = nativeBounds.top;
        bounds->right = nativeBounds.right;
        bounds->bottom = nativeBounds.bottom;
    }
    return lastResult_;
}

HRESULT Engine::GeometryComputeArea(ID2D1Geometry* geometry, float* area) {
    if (!geometry || !area) return lastResult_ = E_POINTER;
    lastResult_ = geometry->ComputeArea(nullptr, D2D1_DEFAULT_FLATTENING_TOLERANCE, area);
    return lastResult_;
}

HRESULT Engine::GeometryComputeLength(ID2D1Geometry* geometry, float* length) {
    if (!geometry || !length) return lastResult_ = E_POINTER;
    lastResult_ = geometry->ComputeLength(nullptr, D2D1_DEFAULT_FLATTENING_TOLERANCE, length);
    return lastResult_;
}

bool Engine::GeometryFillContainsPoint(ID2D1Geometry* geometry, Point point) {
    if (!geometry) {
        lastResult_ = E_POINTER;
        return false;
    }
    BOOL contains = FALSE;
    lastResult_ = geometry->FillContainsPoint(ToD2D(point), nullptr, D2D1_DEFAULT_FLATTENING_TOLERANCE, &contains);
    return SUCCEEDED(lastResult_) && contains;
}

bool Engine::GeometryStrokeContainsPoint(ID2D1Geometry* geometry, Point point, float strokeWidth, ID2D1StrokeStyle* strokeStyle) {
    if (!geometry) {
        lastResult_ = E_POINTER;
        return false;
    }
    BOOL contains = FALSE;
    lastResult_ = geometry->StrokeContainsPoint(ToD2D(point), strokeWidth, strokeStyle, nullptr, D2D1_DEFAULT_FLATTENING_TOLERANCE, &contains);
    return SUCCEEDED(lastResult_) && contains;
}

HRESULT Engine::LoadBitmapFromFile(const wchar_t* fileName, ID2D1Bitmap** bitmap) {
    if (!target_ || !wicFactory_ || !fileName || !bitmap) return lastResult_ = E_POINTER;
    ComPtr<IWICBitmapDecoder> decoder;
    ComPtr<IWICBitmapFrameDecode> frame;
    ComPtr<IWICFormatConverter> converter;
    lastResult_ = wicFactory_->CreateDecoderFromFilename(fileName, nullptr, GENERIC_READ, WICDecodeMetadataCacheOnLoad, decoder.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = decoder->GetFrame(0, frame.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = wicFactory_->CreateFormatConverter(converter.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = converter->Initialize(frame.Get(), GUID_WICPixelFormat32bppPBGRA, WICBitmapDitherTypeNone, nullptr, 0.0f, WICBitmapPaletteTypeMedianCut);
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = target_->CreateBitmapFromWicBitmap(converter.Get(), nullptr, bitmap);
    return lastResult_;
}

HRESULT Engine::LoadBitmapFromMemory(const void* data, int dataSize, ID2D1Bitmap** bitmap) {
    if (!target_ || !wicFactory_ || !data || dataSize <= 0 || !bitmap) return lastResult_ = E_INVALIDARG;
    ComPtr<IWICStream> stream;
    ComPtr<IWICBitmapDecoder> decoder;
    ComPtr<IWICBitmapFrameDecode> frame;
    ComPtr<IWICFormatConverter> converter;
    lastResult_ = wicFactory_->CreateStream(stream.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = stream->InitializeFromMemory(static_cast<BYTE*>(const_cast<void*>(data)), static_cast<DWORD>(dataSize));
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = wicFactory_->CreateDecoderFromStream(stream.Get(), nullptr, WICDecodeMetadataCacheOnLoad, decoder.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = decoder->GetFrame(0, frame.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = wicFactory_->CreateFormatConverter(converter.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = converter->Initialize(frame.Get(), GUID_WICPixelFormat32bppPBGRA, WICBitmapDitherTypeNone, nullptr, 0.0f, WICBitmapPaletteTypeMedianCut);
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = target_->CreateBitmapFromWicBitmap(converter.Get(), nullptr, bitmap);
    return lastResult_;
}

HRESULT Engine::CreateBitmapFromBgra(int width, int height, const void* pixels, UINT32 stride, ID2D1Bitmap** bitmap) {
    if (!target_ || !pixels || !bitmap || width <= 0 || height <= 0) return lastResult_ = E_INVALIDARG;
    D2D1_BITMAP_PROPERTIES props = D2D1::BitmapProperties(
        D2D1::PixelFormat(DXGI_FORMAT_B8G8R8A8_UNORM, D2D1_ALPHA_MODE_PREMULTIPLIED));
    lastResult_ = target_->CreateBitmap(D2D1::SizeU(static_cast<UINT32>(width), static_cast<UINT32>(height)), pixels, stride, props, bitmap);
    return lastResult_;
}

void Engine::DrawBitmap(ID2D1Bitmap* bitmap, Rect dest, float opacity, int interpolationMode, Rect source) {
    if (!target_ || !bitmap) return;
    D2D1_RECT_F src = ToD2D(source);
    const bool hasSource = source.right > source.left && source.bottom > source.top;
    target_->DrawBitmap(bitmap, ToD2D(dest), opacity, static_cast<D2D1_BITMAP_INTERPOLATION_MODE>(interpolationMode), hasSource ? &src : nullptr);
}

HRESULT Engine::CreateBitmapBrush(ID2D1Bitmap* bitmap, int extendModeX, int extendModeY, int interpolationMode, float opacity, ID2D1BitmapBrush** brush) {
    if (!target_ || !bitmap || !brush) return lastResult_ = E_POINTER;
    const D2D1_BITMAP_BRUSH_PROPERTIES bitmapProps = D2D1::BitmapBrushProperties(
        static_cast<D2D1_EXTEND_MODE>(extendModeX),
        static_cast<D2D1_EXTEND_MODE>(extendModeY),
        static_cast<D2D1_BITMAP_INTERPOLATION_MODE>(interpolationMode));
    const D2D1_BRUSH_PROPERTIES brushProps = D2D1::BrushProperties(opacity);
    lastResult_ = target_->CreateBitmapBrush(bitmap, bitmapProps, brushProps, brush);
    return lastResult_;
}

int Engine::BitmapWidth(ID2D1Bitmap* bitmap) const {
    return bitmap ? static_cast<int>(bitmap->GetPixelSize().width) : 0;
}

int Engine::BitmapHeight(ID2D1Bitmap* bitmap) const {
    return bitmap ? static_cast<int>(bitmap->GetPixelSize().height) : 0;
}

HRESULT Engine::CreateTextFormat(const wchar_t* fontFamily, float size, int weight, int style, int stretch, const wchar_t* locale, IDWriteTextFormat** format) {
    if (!writeFactory_ || !fontFamily || !format) return lastResult_ = E_POINTER;
    lastResult_ = writeFactory_->CreateTextFormat(
        fontFamily,
        nullptr,
        static_cast<DWRITE_FONT_WEIGHT>(weight),
        static_cast<DWRITE_FONT_STYLE>(style),
        static_cast<DWRITE_FONT_STRETCH>(stretch),
        size,
        locale && locale[0] ? locale : L"zh-cn",
        format);
    return lastResult_;
}

HRESULT Engine::CreateTextLayout(const wchar_t* text, IDWriteTextFormat* format, float maxWidth, float maxHeight, IDWriteTextLayout** layout) {
    if (!writeFactory_ || !text || !format || !layout) return lastResult_ = E_POINTER;
    lastResult_ = writeFactory_->CreateTextLayout(text, static_cast<UINT32>(wcslen(text)), format, maxWidth, maxHeight, layout);
    return lastResult_;
}

HRESULT Engine::TextLayoutMetrics(IDWriteTextLayout* layout, TextMetrics* metrics) {
    if (!layout || !metrics) return lastResult_ = E_POINTER;
    DWRITE_TEXT_METRICS nativeMetrics = {};
    lastResult_ = layout->GetMetrics(&nativeMetrics);
    if (FAILED(lastResult_)) return lastResult_;
    metrics->left = nativeMetrics.left;
    metrics->top = nativeMetrics.top;
    metrics->width = nativeMetrics.width;
    metrics->widthIncludingTrailingWhitespace = nativeMetrics.widthIncludingTrailingWhitespace;
    metrics->height = nativeMetrics.height;
    metrics->layoutWidth = nativeMetrics.layoutWidth;
    metrics->layoutHeight = nativeMetrics.layoutHeight;
    metrics->maxBidiReorderingDepth = static_cast<int>(nativeMetrics.maxBidiReorderingDepth);
    metrics->lineCount = static_cast<int>(nativeMetrics.lineCount);
    return lastResult_;
}

bool Engine::TextLayoutHitTestPoint(IDWriteTextLayout* layout, float x, float y, int* textPosition, bool* trailingHit, bool* inside) {
    if (!layout || !textPosition || !trailingHit || !inside) {
        lastResult_ = E_POINTER;
        return false;
    }
    BOOL nativeTrailing = FALSE;
    BOOL nativeInside = FALSE;
    DWRITE_HIT_TEST_METRICS metrics = {};
    lastResult_ = layout->HitTestPoint(x, y, &nativeTrailing, &nativeInside, &metrics);
    if (FAILED(lastResult_)) return false;
    *textPosition = static_cast<int>(metrics.textPosition);
    *trailingHit = nativeTrailing != FALSE;
    *inside = nativeInside != FALSE;
    return true;
}

void Engine::SetTextAlignment(IDWriteTextFormat* format, int alignment) {
    if (format) format->SetTextAlignment(static_cast<DWRITE_TEXT_ALIGNMENT>(alignment));
}

void Engine::SetParagraphAlignment(IDWriteTextFormat* format, int alignment) {
    if (format) format->SetParagraphAlignment(static_cast<DWRITE_PARAGRAPH_ALIGNMENT>(alignment));
}

void Engine::SetWordWrapping(IDWriteTextFormat* format, int wrapping) {
    if (format) format->SetWordWrapping(static_cast<DWRITE_WORD_WRAPPING>(wrapping));
}

void Engine::DrawTextSimple(const wchar_t* text, Rect rect, Color color, const wchar_t* fontFamily, float size, int weight, int style, int horizontalAlign, int verticalAlign) {
    if (!target_ || !text) return;
    ComPtr<IDWriteTextFormat> format;
    if (FAILED(CreateTextFormat(fontFamily && fontFamily[0] ? fontFamily : L"Microsoft YaHei", size, weight, style, DWRITE_FONT_STRETCH_NORMAL, L"zh-cn", format.GetAddressOf()))) return;
    format->SetTextAlignment(static_cast<DWRITE_TEXT_ALIGNMENT>(horizontalAlign));
    format->SetParagraphAlignment(static_cast<DWRITE_PARAGRAPH_ALIGNMENT>(verticalAlign));
    if (auto brush = TempBrush(color)) {
        target_->DrawText(text, static_cast<UINT32>(wcslen(text)), format.Get(), ToD2D(rect), brush);
    }
}

void Engine::DrawTextDecorated(const wchar_t* text, Rect rect, Color color, const wchar_t* fontFamily, float size, int weight, int style, bool underline, bool strikeout, float rotationDegrees, int horizontalAlign, int verticalAlign, bool wordWrap) {
    if (!target_ || !text) return;

    ComPtr<IDWriteTextFormat> format;
    if (FAILED(CreateTextFormat(fontFamily && fontFamily[0] ? fontFamily : L"Microsoft YaHei", size, weight, style, DWRITE_FONT_STRETCH_NORMAL, L"zh-cn", format.GetAddressOf()))) return;
    format->SetTextAlignment(static_cast<DWRITE_TEXT_ALIGNMENT>(horizontalAlign));
    format->SetParagraphAlignment(static_cast<DWRITE_PARAGRAPH_ALIGNMENT>(verticalAlign));
    format->SetWordWrapping(wordWrap ? DWRITE_WORD_WRAPPING_WRAP : DWRITE_WORD_WRAPPING_NO_WRAP);

    ComPtr<IDWriteTextLayout> layout;
    const UINT32 length = static_cast<UINT32>(wcslen(text));
    if (FAILED(CreateTextLayout(text, format.Get(), rect.right - rect.left, rect.bottom - rect.top, layout.GetAddressOf()))) return;
    DWRITE_TEXT_RANGE range{0, length};
    if (underline) layout->SetUnderline(TRUE, range);
    if (strikeout) layout->SetStrikethrough(TRUE, range);
    if (auto brush = TempBrush(color)) {
        D2D1_MATRIX_3X2_F oldTransform{};
        if (rotationDegrees != 0.0f) {
            target_->GetTransform(&oldTransform);
            const auto center = D2D1::Point2F((rect.left + rect.right) * 0.5f, (rect.top + rect.bottom) * 0.5f);
            target_->SetTransform(D2D1::Matrix3x2F::Rotation(rotationDegrees, center) * oldTransform);
        }
        target_->DrawTextLayout(D2D1::Point2F(rect.left, rect.top), layout.Get(), brush, D2D1_DRAW_TEXT_OPTIONS_CLIP);
        if (rotationDegrees != 0.0f) {
            target_->SetTransform(oldTransform);
        }
    }
}

void Engine::DrawTextLayout(Point origin, IDWriteTextLayout* layout, ID2D1Brush* brush, int options) {
    if (target_ && layout && brush) target_->DrawTextLayout(ToD2D(origin), layout, brush, static_cast<D2D1_DRAW_TEXT_OPTIONS>(options));
}

HRESULT Engine::CreateLayer(ID2D1Layer** layer) {
    if (!target_ || !layer) return lastResult_ = E_POINTER;
    lastResult_ = target_->CreateLayer(nullptr, layer);
    return lastResult_;
}

void Engine::PushLayer(Rect contentBounds, ID2D1Layer* layer, float opacity) {
    if (target_ && layer) {
        target_->PushLayer(D2D1::LayerParameters(ToD2D(contentBounds), nullptr, D2D1_ANTIALIAS_MODE_PER_PRIMITIVE, D2D1::IdentityMatrix(), opacity), layer);
    }
}

void Engine::PopLayer() {
    if (target_) target_->PopLayer();
}

void Engine::PushAxisAlignedClip(Rect rect, int antialiasMode) {
    if (target_) target_->PushAxisAlignedClip(ToD2D(rect), static_cast<D2D1_ANTIALIAS_MODE>(antialiasMode));
}

void Engine::PopAxisAlignedClip() {
    if (target_) target_->PopAxisAlignedClip();
}

HRESULT Engine::CreateDrawingStateBlock(ID2D1DrawingStateBlock** stateBlock) {
    if (!factory_ || !stateBlock) return lastResult_ = E_POINTER;
    lastResult_ = factory_->CreateDrawingStateBlock(stateBlock);
    return lastResult_;
}

void Engine::SaveDrawingState(ID2D1DrawingStateBlock* stateBlock) {
    if (target_ && stateBlock) target_->SaveDrawingState(stateBlock);
}

void Engine::RestoreDrawingState(ID2D1DrawingStateBlock* stateBlock) {
    if (target_ && stateBlock) target_->RestoreDrawingState(stateBlock);
}

std::wstring Engine::LastErrorText() const {
    std::wstringstream ss;
    ss << L"HRESULT=0x" << std::hex << static_cast<unsigned long>(lastResult_);
    if (lastResult_ == D2DERR_RECREATE_TARGET) ss << L" D2DERR_RECREATE_TARGET";
    return ss.str();
}

D2D1_COLOR_F Engine::ToD2D(Color color) const {
    return D2D1::ColorF(color.r, color.g, color.b, color.a);
}

D2D1_POINT_2F Engine::ToD2D(Point point) const {
    return D2D1::Point2F(point.x, point.y);
}

D2D1_RECT_F Engine::ToD2D(Rect rect) const {
    return D2D1::RectF(rect.left, rect.top, rect.right, rect.bottom);
}

D2D1_MATRIX_3X2_F Engine::ToD2D(Matrix matrix) const {
    return D2D1::Matrix3x2F(matrix.m11, matrix.m12, matrix.m21, matrix.m22, matrix.dx, matrix.dy);
}

ID2D1SolidColorBrush* Engine::TempBrush(Color color) {
    if (!target_) {
        lastResult_ = E_POINTER;
        return nullptr;
    }
    if (!tempBrush_) {
        lastResult_ = target_->CreateSolidColorBrush(ToD2D(color), tempBrush_.GetAddressOf());
        if (FAILED(lastResult_)) return nullptr;
    } else {
        tempBrush_->SetColor(ToD2D(color));
    }
    return tempBrush_.Get();
}

}  // namespace volcano_d2d

