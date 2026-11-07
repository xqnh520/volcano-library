#include "d2d_memory_canvas.hpp"

#include "lunasvg_bridge.hpp"

#include <algorithm>
#include <cmath>
#include <cstring>
#include <objidl.h>

namespace volcano_d2d {

using Microsoft::WRL::ComPtr;

namespace {
constexpr float kMemoryCanvasDpi = 96.0f;
}

struct MemoryCanvas::AutoDraw {
    explicit AutoDraw(MemoryCanvas& canvas) : canvas_(canvas), started_(!canvas.inDraw_) {
        if (started_) canvas_.BeginDraw();
    }
    ~AutoDraw() {
        if (started_) canvas_.EndDraw();
    }
    MemoryCanvas& canvas_;
    bool started_;
};

MemoryCanvas::MemoryCanvas() = default;

MemoryCanvas::~MemoryCanvas() {
    Destroy();
}

int MemoryCanvas::ToPixelX(int value) const {
    return (int)std::lround((double)value * (double)dpiX_ / 96.0);
}

int MemoryCanvas::ToPixelY(int value) const {
    return (int)std::lround((double)value * (double)dpiY_ / 96.0);
}

int MemoryCanvas::ToLogicalWidth(int pixelWidth) const {
    return (int)std::lround((double)pixelWidth * 96.0 / (double)dpiX_);
}

int MemoryCanvas::ToLogicalHeight(int pixelHeight) const {
    return (int)std::lround((double)pixelHeight * 96.0 / (double)dpiY_);
}

HRESULT MemoryCanvas::EnsureFactories() {
    if (!comInitialized_) {
        HRESULT hr = CoInitializeEx(nullptr, COINIT_APARTMENTTHREADED);
        if (SUCCEEDED(hr) || hr == RPC_E_CHANGED_MODE) {
            comInitialized_ = SUCCEEDED(hr);
        }
    }
    if (!factory_) {
        D2D1_FACTORY_OPTIONS options = {};
        lastResult_ = D2D1CreateFactory(D2D1_FACTORY_TYPE_SINGLE_THREADED, __uuidof(ID2D1Factory1), &options, reinterpret_cast<void**>(factory_.ReleaseAndGetAddressOf()));
        if (FAILED(lastResult_)) return lastResult_;
    }
    if (!writeFactory_) {
        lastResult_ = DWriteCreateFactory(DWRITE_FACTORY_TYPE_SHARED, __uuidof(IDWriteFactory), reinterpret_cast<IUnknown**>(writeFactory_.ReleaseAndGetAddressOf()));
        if (FAILED(lastResult_)) return lastResult_;
    }
    if (!wicFactory_) {
        lastResult_ = CoCreateInstance(CLSID_WICImagingFactory, nullptr, CLSCTX_INPROC_SERVER, IID_PPV_ARGS(wicFactory_.ReleaseAndGetAddressOf()));
        if (FAILED(lastResult_)) return lastResult_;
    }
    return lastResult_ = S_OK;
}

bool MemoryCanvas::CreateDib(int width, int height) {
    if (width <= 0 || height <= 0 || width > 32767 || height > 32767) {
        lastResult_ = E_INVALIDARG;
        return false;
    }
    ReleaseSurface();

    memoryDc_ = CreateCompatibleDC(nullptr);
    if (!memoryDc_) {
        lastResult_ = HRESULT_FROM_WIN32(GetLastError());
        return false;
    }

    BITMAPINFO info = {};
    info.bmiHeader.biSize = sizeof(BITMAPINFOHEADER);
    info.bmiHeader.biWidth = width;
    info.bmiHeader.biHeight = -height;
    info.bmiHeader.biPlanes = 1;
    info.bmiHeader.biBitCount = 32;
    info.bmiHeader.biCompression = BI_RGB;
    bitmap_ = CreateDIBSection(memoryDc_, &info, DIB_RGB_COLORS, &pixels_, nullptr, 0);
    if (!bitmap_ || !pixels_) {
        lastResult_ = HRESULT_FROM_WIN32(GetLastError());
        ReleaseSurface();
        return false;
    }
    oldBitmap_ = SelectObject(memoryDc_, bitmap_);
    width_ = width;
    height_ = height;
    stride_ = width * 4;
    return true;
}

bool MemoryCanvas::BindTarget() {
    if (!factory_ || !memoryDc_) return false;
    if (!target_) {
        D2D1_RENDER_TARGET_PROPERTIES props = D2D1::RenderTargetProperties(
            D2D1_RENDER_TARGET_TYPE_DEFAULT,
            D2D1::PixelFormat(DXGI_FORMAT_B8G8R8A8_UNORM, D2D1_ALPHA_MODE_PREMULTIPLIED),
            dpiX_,
            dpiY_,
            D2D1_RENDER_TARGET_USAGE_GDI_COMPATIBLE);
        lastResult_ = factory_->CreateDCRenderTarget(&props, target_.ReleaseAndGetAddressOf());
        if (FAILED(lastResult_)) return false;
    }
    target_->SetDpi(dpiX_, dpiY_);
    target_->SetAntialiasMode(D2D1_ANTIALIAS_MODE_PER_PRIMITIVE);
    target_->SetTextAntialiasMode(D2D1_TEXT_ANTIALIAS_MODE_GRAYSCALE);
    RECT rc = { 0, 0, width_, height_ };
    lastResult_ = target_->BindDC(memoryDc_, &rc);
    return SUCCEEDED(lastResult_);
}

bool MemoryCanvas::Create(int width, int height, float dpiScale, Color background) {
    if (FAILED(EnsureFactories())) return false;
    if (width <= 0 || height <= 0) {
        lastResult_ = E_INVALIDARG;
        return false;
    }
    dpiScale = dpiScale > 0.0f ? dpiScale : 1.0f;
    dpiX_ = kMemoryCanvasDpi * dpiScale;
    dpiY_ = kMemoryCanvasDpi * dpiScale;
    const int pixelWidth = std::max(1, ToPixelX(width));
    const int pixelHeight = std::max(1, ToPixelY(height));
    if (!CreateDib(pixelWidth, pixelHeight)) return false;
    logicalWidth_ = width;
    logicalHeight_ = height;
    if (!BindTarget()) return false;
    Clear(background);
    return true;
}

void MemoryCanvas::Destroy() {
    target_.Reset();
    tempBrush_.Reset();
    penBrush_.Reset();
    fillBrush_.Reset();
    ReleaseSurface();
    factory_.Reset();
    writeFactory_.Reset();
    wicFactory_.Reset();
    if (comInitialized_) {
        CoUninitialize();
        comInitialized_ = false;
    }
}

bool MemoryCanvas::Resize(int width, int height, float dpiScale, Color background) {
    target_.Reset();
    if (width <= 0 || height <= 0) {
        lastResult_ = E_INVALIDARG;
        return false;
    }
    dpiScale = dpiScale > 0.0f ? dpiScale : 1.0f;
    dpiX_ = kMemoryCanvasDpi * dpiScale;
    dpiY_ = kMemoryCanvasDpi * dpiScale;
    const int pixelWidth = std::max(1, ToPixelX(width));
    const int pixelHeight = std::max(1, ToPixelY(height));
    if (!CreateDib(pixelWidth, pixelHeight)) return false;
    logicalWidth_ = width;
    logicalHeight_ = height;
    if (!BindTarget()) return false;
    Clear(background);
    return true;
}

bool MemoryCanvas::IsReady() const {
    return target_ && bitmap_ && pixels_ && width_ > 0 && height_ > 0;
}

void MemoryCanvas::ReleaseSurface() {
    if (memoryDc_) {
        if (oldBitmap_) {
            SelectObject(memoryDc_, oldBitmap_);
            oldBitmap_ = nullptr;
        }
        DeleteDC(memoryDc_);
        memoryDc_ = nullptr;
    }
    if (bitmap_) {
        DeleteObject(bitmap_);
        bitmap_ = nullptr;
    }
    pixels_ = nullptr;
    width_ = 0;
    height_ = 0;
    logicalWidth_ = 0;
    logicalHeight_ = 0;
    stride_ = 0;
}

D2D1_COLOR_F MemoryCanvas::ToD2D(Color color) const {
    return D2D1::ColorF(color.r, color.g, color.b, color.a);
}

D2D1_RECT_F MemoryCanvas::RectF(float left, float top, float right, float bottom) const {
    return D2D1::RectF(left, top, right, bottom);
}

ID2D1SolidColorBrush* MemoryCanvas::TempBrush(Color color) {
    if (!target_) return nullptr;
    if (!tempBrush_) {
        target_->CreateSolidColorBrush(ToD2D(color), tempBrush_.GetAddressOf());
    } else {
        tempBrush_->SetColor(ToD2D(color));
        tempBrush_->SetOpacity(color.a);
    }
    return tempBrush_.Get();
}

ID2D1SolidColorBrush* MemoryCanvas::PenBrush() {
    if (!target_ || penType_ == CANVAS_PEN_NULL) return nullptr;
    if (!penBrush_) {
        target_->CreateSolidColorBrush(ToD2D(penColor_), penBrush_.GetAddressOf());
    } else {
        penBrush_->SetColor(ToD2D(penColor_));
        penBrush_->SetOpacity(penColor_.a);
    }
    return penBrush_.Get();
}

ID2D1SolidColorBrush* MemoryCanvas::FillBrush() {
    if (!target_ || brushType_ == CANVAS_BRUSH_NULL) return nullptr;
    if (!fillBrush_) {
        target_->CreateSolidColorBrush(ToD2D(brushColor_), fillBrush_.GetAddressOf());
    } else {
        fillBrush_->SetColor(ToD2D(brushColor_));
        fillBrush_->SetOpacity(brushColor_.a);
    }
    return fillBrush_.Get();
}

void MemoryCanvas::BeginDraw() {
    if (!target_ || inDraw_) return;
    BindTarget();
    target_->BeginDraw();
    inDraw_ = true;
}

HRESULT MemoryCanvas::EndDraw() {
    if (!target_ || !inDraw_) return lastResult_;
    lastResult_ = target_->EndDraw();
    inDraw_ = false;
    return lastResult_;
}

void MemoryCanvas::Flush() {
    if (target_) target_->Flush();
}

void MemoryCanvas::Clear(Color color) {
    if (!target_) return;
    AutoDraw draw(*this);
    target_->Clear(ToD2D(color));
}

void MemoryCanvas::ClearRect(int x, int y, int width, int height, Color color) {
    if (!target_) return;
    if (width < 0) width = (logicalWidth_ > 0 ? logicalWidth_ : width_) - x;
    if (height < 0) height = (logicalHeight_ > 0 ? logicalHeight_ : height_) - y;
    AutoDraw draw(*this);
    if (auto brush = TempBrush(color)) target_->FillRectangle(RectF((float)x, (float)y, (float)(x + width), (float)(y + height)), brush);
    writeX_ = x;
    writeY_ = y;
}

int MemoryCanvas::GetPixel(int x, int y) const {
    if (!pixels_ || x < 0 || y < 0 || x >= width_ || y >= height_) return -1;
    const unsigned char* p = static_cast<const unsigned char*>(pixels_) + static_cast<size_t>(y) * stride_ + static_cast<size_t>(x) * 4;
    return (int)p[2] | ((int)p[1] << 8) | ((int)p[0] << 16);
}

void MemoryCanvas::DrawPoint(int x, int y, Color color) {
    if (!target_) return;
    AutoDraw draw(*this);
    if (auto brush = TempBrush(color)) target_->FillRectangle(RectF((float)x, (float)y, (float)x + 1.0f, (float)y + 1.0f), brush);
}

void MemoryCanvas::DrawLine(int x1, int y1, int x2, int y2) {
    if (!target_) return;
    AutoDraw draw(*this);
    if (auto brush = PenBrush()) target_->DrawLine(D2D1::Point2F((float)x1, (float)y1), D2D1::Point2F((float)x2, (float)y2), brush, penWidth_);
}

void MemoryCanvas::DrawRectangle(int left, int top, int right, int bottom) {
    if (!target_) return;
    AutoDraw draw(*this);
    if (auto fill = FillBrush()) target_->FillRectangle(RectF((float)left, (float)top, (float)right, (float)bottom), fill);
    if (auto pen = PenBrush()) target_->DrawRectangle(RectF((float)left, (float)top, (float)right, (float)bottom), pen, penWidth_);
}

void MemoryCanvas::FillRectangle(int left, int top, int right, int bottom) {
    if (!target_) return;
    AutoDraw draw(*this);
    if (auto fill = FillBrush()) target_->FillRectangle(RectF((float)left, (float)top, (float)right, (float)bottom), fill);
}

void MemoryCanvas::DrawEllipse(int left, int top, int right, int bottom) {
    if (!target_) return;
    const float cx = (left + right) * 0.5f;
    const float cy = (top + bottom) * 0.5f;
    const float rx = std::abs(right - left) * 0.5f;
    const float ry = std::abs(bottom - top) * 0.5f;
    AutoDraw draw(*this);
    D2D1_ELLIPSE ellipse = D2D1::Ellipse(D2D1::Point2F(cx, cy), rx, ry);
    if (auto fill = FillBrush()) target_->FillEllipse(ellipse, fill);
    if (auto pen = PenBrush()) target_->DrawEllipse(ellipse, pen, penWidth_);
}

void MemoryCanvas::FillEllipse(int left, int top, int right, int bottom) {
    if (!target_) return;
    const float cx = (left + right) * 0.5f;
    const float cy = (top + bottom) * 0.5f;
    const float rx = std::abs(right - left) * 0.5f;
    const float ry = std::abs(bottom - top) * 0.5f;
    AutoDraw draw(*this);
    if (auto fill = FillBrush()) target_->FillEllipse(D2D1::Ellipse(D2D1::Point2F(cx, cy), rx, ry), fill);
}

void MemoryCanvas::DrawRoundRect(int left, int top, int right, int bottom, int radiusX, int radiusY) {
    if (!target_) return;
    if (radiusY < 0) radiusY = radiusX;
    AutoDraw draw(*this);
    D2D1_ROUNDED_RECT rr = D2D1::RoundedRect(RectF((float)left, (float)top, (float)right, (float)bottom), (float)radiusX, (float)radiusY);
    if (auto fill = FillBrush()) target_->FillRoundedRectangle(rr, fill);
    if (auto pen = PenBrush()) target_->DrawRoundedRectangle(rr, pen, penWidth_);
}

void MemoryCanvas::FillRoundRect(int left, int top, int right, int bottom, int radiusX, int radiusY) {
    if (!target_) return;
    if (radiusY < 0) radiusY = radiusX;
    AutoDraw draw(*this);
    if (auto fill = FillBrush()) target_->FillRoundedRectangle(D2D1::RoundedRect(RectF((float)left, (float)top, (float)right, (float)bottom), (float)radiusX, (float)radiusY), fill);
}

void MemoryCanvas::DrawPolygon(const int* points, int pointCount) {
    if (!target_ || !factory_ || !points || pointCount < 2) return;
    AutoDraw draw(*this);
    ComPtr<ID2D1PathGeometry> geometry;
    ComPtr<ID2D1GeometrySink> sink;
    if (FAILED(factory_->CreatePathGeometry(geometry.GetAddressOf())) || FAILED(geometry->Open(sink.GetAddressOf()))) return;
    sink->BeginFigure(D2D1::Point2F((float)points[0], (float)points[1]), D2D1_FIGURE_BEGIN_FILLED);
    for (int i = 1; i < pointCount; ++i) sink->AddLine(D2D1::Point2F((float)points[i * 2], (float)points[i * 2 + 1]));
    sink->EndFigure(D2D1_FIGURE_END_CLOSED);
    if (FAILED(sink->Close())) return;
    if (auto fill = FillBrush()) target_->FillGeometry(geometry.Get(), fill);
    if (auto pen = PenBrush()) target_->DrawGeometry(geometry.Get(), pen, penWidth_);
}

void MemoryCanvas::FillPolygon(const int* points, int pointCount) {
    const int oldPen = penType_;
    penType_ = CANVAS_PEN_NULL;
    DrawPolygon(points, pointCount);
    penType_ = oldPen;
}

void MemoryCanvas::SetPen(Color color, float width, int type) {
    penColor_ = color;
    penWidth_ = width <= 0.0f ? 1.0f : width;
    penType_ = type;
}

void MemoryCanvas::SetBrush(Color color, int type) {
    brushColor_ = color;
    brushType_ = type;
}

void MemoryCanvas::SetTextColor(Color color) {
    textColor_ = color;
}

void MemoryCanvas::SetTextBackgroundColor(Color color) {
    textBackgroundColor_ = color;
}

void MemoryCanvas::SetFont(const wchar_t* family, float size, int weight, int style) {
    fontFamily_ = family && family[0] ? family : L"Microsoft YaHei";
    fontSize_ = size > 0 ? size : 16.0f;
    fontWeight_ = weight;
    fontStyle_ = style;
}

void MemoryCanvas::SetWritePos(int x, int y) {
    if (x != INT_MAX) writeX_ = x;
    if (y != INT_MAX) writeY_ = y;
}

HRESULT MemoryCanvas::CreateTextFormat(IDWriteTextFormat** format) {
    if (!writeFactory_ || !format) return lastResult_ = E_POINTER;
    lastResult_ = writeFactory_->CreateTextFormat(fontFamily_.c_str(), nullptr, static_cast<DWRITE_FONT_WEIGHT>(fontWeight_), static_cast<DWRITE_FONT_STYLE>(fontStyle_), DWRITE_FONT_STRETCH_NORMAL, fontSize_, L"zh-cn", format);
    return lastResult_;
}

SIZE MemoryCanvas::MeasureText(const wchar_t* text) {
    SIZE size = { 0, 0 };
    if (!writeFactory_ || !text) return size;
    ComPtr<IDWriteTextFormat> format;
    ComPtr<IDWriteTextLayout> layout;
    if (FAILED(CreateTextFormat(format.GetAddressOf()))) return size;
    if (FAILED(writeFactory_->CreateTextLayout(text, (UINT32)wcslen(text), format.Get(), 4096.0f, 4096.0f, layout.GetAddressOf()))) return size;
    DWRITE_TEXT_METRICS metrics = {};
    if (SUCCEEDED(layout->GetMetrics(&metrics))) {
        size.cx = (int)std::ceil(metrics.widthIncludingTrailingWhitespace);
        size.cy = (int)std::ceil(metrics.height);
    }
    return size;
}

void MemoryCanvas::DrawTextAt(int x, int y, const wchar_t* text, int lineSpacing) {
    if (!target_ || !text) return;
    if (x == INT_MAX) x = writeX_;
    if (y == INT_MAX) y = writeY_;
    SIZE size = MeasureText(text);
    AutoDraw draw(*this);
    const int textWidth = size.cx + 4 > 1 ? (int)(size.cx + 4) : 1;
    const int textHeight = size.cy + 4 > 1 ? (int)(size.cy + 4) : 1;
    D2D1_RECT_F rect = RectF((float)x, (float)y, (float)(x + textWidth), (float)(y + textHeight));
    if (textBackgroundColor_.a > 0.0f) {
        if (auto bg = TempBrush(textBackgroundColor_)) target_->FillRectangle(rect, bg);
    }
    ComPtr<IDWriteTextFormat> format;
    if (FAILED(CreateTextFormat(format.GetAddressOf()))) return;
    if (auto brush = TempBrush(textColor_)) {
        target_->DrawText(text, (UINT32)wcslen(text), format.Get(), rect, brush);
    }
    writeX_ = x + size.cx;
    writeY_ = y;
    if (lineSpacing >= 0) {
        writeY_ = y + size.cy + lineSpacing;
        writeX_ = 0;
    }
}

void MemoryCanvas::DrawTextInRect(int left, int top, int right, int bottom, const wchar_t* text, int horizontalAlign, int verticalAlign, bool wordWrap) {
    if (!target_ || !text) return;
    AutoDraw draw(*this);
    D2D1_RECT_F rect = RectF((float)left, (float)top, (float)right, (float)bottom);
    if (textBackgroundColor_.a > 0.0f) {
        if (auto bg = TempBrush(textBackgroundColor_)) target_->FillRectangle(rect, bg);
    }
    ComPtr<IDWriteTextFormat> format;
    if (FAILED(CreateTextFormat(format.GetAddressOf()))) return;
    format->SetTextAlignment(horizontalAlign == 1 ? DWRITE_TEXT_ALIGNMENT_LEADING : (horizontalAlign == 2 ? DWRITE_TEXT_ALIGNMENT_TRAILING : DWRITE_TEXT_ALIGNMENT_CENTER));
    format->SetParagraphAlignment(verticalAlign == 1 ? DWRITE_PARAGRAPH_ALIGNMENT_NEAR : (verticalAlign == 2 ? DWRITE_PARAGRAPH_ALIGNMENT_FAR : DWRITE_PARAGRAPH_ALIGNMENT_CENTER));
    format->SetWordWrapping(wordWrap ? DWRITE_WORD_WRAPPING_WRAP : DWRITE_WORD_WRAPPING_NO_WRAP);
    if (auto brush = TempBrush(textColor_)) target_->DrawText(text, (UINT32)wcslen(text), format.Get(), rect, brush);
}

int MemoryCanvas::TextWidth(const wchar_t* text) {
    return MeasureText(text).cx;
}

int MemoryCanvas::TextHeight(const wchar_t* text) {
    return MeasureText(text).cy;
}

HRESULT MemoryCanvas::CreateBitmapFromWic(IWICBitmapSource* source, ID2D1Bitmap** bitmap) {
    if (!target_ || !wicFactory_ || !source || !bitmap) return lastResult_ = E_POINTER;
    ComPtr<IWICFormatConverter> converter;
    lastResult_ = wicFactory_->CreateFormatConverter(converter.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = converter->Initialize(source, GUID_WICPixelFormat32bppPBGRA, WICBitmapDitherTypeNone, nullptr, 0.0f, WICBitmapPaletteTypeMedianCut);
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = target_->CreateBitmapFromWicBitmap(converter.Get(), nullptr, bitmap);
    return lastResult_;
}

HRESULT MemoryCanvas::LoadWicBitmapFromFile(const wchar_t* fileName, ID2D1Bitmap** bitmap, int* width, int* height) {
    if (!wicFactory_ || !fileName || !bitmap) return lastResult_ = E_POINTER;
    ComPtr<IWICBitmapDecoder> decoder;
    ComPtr<IWICBitmapFrameDecode> frame;
    lastResult_ = wicFactory_->CreateDecoderFromFilename(fileName, nullptr, GENERIC_READ, WICDecodeMetadataCacheOnLoad, decoder.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = decoder->GetFrame(0, frame.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    UINT w = 0, h = 0;
    frame->GetSize(&w, &h);
    if (width) *width = (int)w;
    if (height) *height = (int)h;
    return CreateBitmapFromWic(frame.Get(), bitmap);
}

HRESULT MemoryCanvas::LoadWicBitmapFromMemory(const void* data, int dataSize, ID2D1Bitmap** bitmap, int* width, int* height) {
    if (!wicFactory_ || !data || dataSize <= 0 || !bitmap) return lastResult_ = E_INVALIDARG;
    ComPtr<IWICStream> stream;
    ComPtr<IWICBitmapDecoder> decoder;
    ComPtr<IWICBitmapFrameDecode> frame;
    lastResult_ = wicFactory_->CreateStream(stream.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = stream->InitializeFromMemory(static_cast<BYTE*>(const_cast<void*>(data)), (DWORD)dataSize);
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = wicFactory_->CreateDecoderFromStream(stream.Get(), nullptr, WICDecodeMetadataCacheOnLoad, decoder.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    lastResult_ = decoder->GetFrame(0, frame.GetAddressOf());
    if (FAILED(lastResult_)) return lastResult_;
    UINT w = 0, h = 0;
    frame->GetSize(&w, &h);
    if (width) *width = (int)w;
    if (height) *height = (int)h;
    return CreateBitmapFromWic(frame.Get(), bitmap);
}

HRESULT MemoryCanvas::CreateBitmapFromSvgData(const void* data, int dataSize, int requestedWidth, int requestedHeight, ID2D1Bitmap** bitmap, int* width, int* height) {
    if (!target_ || !data || dataSize <= 0 || !bitmap) return lastResult_ = E_INVALIDARG;
    std::vector<unsigned char> pixels;
    int w = 0, h = 0, stride = 0;
    if (!RenderSvgToBgraBitmap(data, dataSize, requestedWidth, requestedHeight, pixels, w, h, stride)) return lastResult_ = E_FAIL;
    D2D1_BITMAP_PROPERTIES props = D2D1::BitmapProperties(D2D1::PixelFormat(DXGI_FORMAT_B8G8R8A8_UNORM, D2D1_ALPHA_MODE_PREMULTIPLIED));
    lastResult_ = target_->CreateBitmap(D2D1::SizeU((UINT32)w, (UINT32)h), pixels.data(), (UINT32)stride, props, bitmap);
    if (width) *width = w;
    if (height) *height = h;
    return lastResult_;
}

bool MemoryCanvas::DrawBitmap(ID2D1Bitmap* bitmap, int bitmapWidth, int bitmapHeight, int x, int y, int width, int height, float opacity, int interpolationMode) {
    if (!target_ || !bitmap) return false;
    if (width < 0) width = bitmapWidth;
    if (height < 0) height = bitmapHeight;
    if (width <= 0 || height <= 0) return false;
    AutoDraw draw(*this);
    target_->DrawBitmap(bitmap, RectF((float)x, (float)y, (float)(x + width), (float)(y + height)), opacity, static_cast<D2D1_BITMAP_INTERPOLATION_MODE>(interpolationMode));
    return true;
}

static bool LooksLikeSvg(const void* data, int size) {
    if (!data || size <= 0) return false;
    const char* s = static_cast<const char*>(data);
    const int limit = size < 256 ? size : 256;
    for (int i = 0; i < limit; ++i) {
        if (s[i] == '<') {
            return i + 4 < limit && (s[i + 1] == 's' || s[i + 1] == 'S') && (s[i + 2] == 'v' || s[i + 2] == 'V') && (s[i + 3] == 'g' || s[i + 3] == 'G');
        }
    }
    return false;
}

static bool PathEndsWithSvg(const wchar_t* fileName) {
    if (!fileName) return false;
    std::wstring path(fileName);
    if (path.size() < 4) return false;
    std::transform(path.begin(), path.end(), path.begin(), towlower);
    return path.size() >= 4 && path.substr(path.size() - 4) == L".svg";
}

bool MemoryCanvas::DrawImageFile(const wchar_t* fileName, int x, int y, int width, int height, float opacity, int interpolationMode) {
    if (!fileName) return false;
    if (PathEndsWithSvg(fileName)) return DrawSvgFile(fileName, x, y, width, height, opacity, interpolationMode);
    ComPtr<ID2D1Bitmap> bitmap;
    int w = 0, h = 0;
    if (FAILED(LoadWicBitmapFromFile(fileName, bitmap.GetAddressOf(), &w, &h))) return false;
    return DrawBitmap(bitmap.Get(), w, h, x, y, width, height, opacity, interpolationMode);
}

bool MemoryCanvas::DrawImageData(const void* data, int dataSize, int x, int y, int width, int height, float opacity, int interpolationMode) {
    if (LooksLikeSvg(data, dataSize)) return DrawSvgData(data, dataSize, x, y, width, height, opacity, interpolationMode);
    ComPtr<ID2D1Bitmap> bitmap;
    int w = 0, h = 0;
    if (FAILED(LoadWicBitmapFromMemory(data, dataSize, bitmap.GetAddressOf(), &w, &h))) return false;
    return DrawBitmap(bitmap.Get(), w, h, x, y, width, height, opacity, interpolationMode);
}

bool MemoryCanvas::DrawSvgFile(const wchar_t* fileName, int x, int y, int width, int height, float opacity, int interpolationMode) {
    if (!fileName) return false;
    HANDLE file = CreateFileW(fileName, GENERIC_READ, FILE_SHARE_READ, nullptr, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, nullptr);
    if (file == INVALID_HANDLE_VALUE) {
        lastResult_ = HRESULT_FROM_WIN32(GetLastError());
        return false;
    }
    LARGE_INTEGER size = {};
    if (!GetFileSizeEx(file, &size) || size.QuadPart <= 0 || size.QuadPart > 64 * 1024 * 1024) {
        CloseHandle(file);
        lastResult_ = E_INVALIDARG;
        return false;
    }
    std::vector<unsigned char> bytes((size_t)size.QuadPart);
    DWORD read = 0;
    BOOL ok = ReadFile(file, bytes.data(), (DWORD)bytes.size(), &read, nullptr);
    CloseHandle(file);
    if (!ok || read != bytes.size()) {
        lastResult_ = HRESULT_FROM_WIN32(GetLastError());
        return false;
    }
    return DrawSvgData(bytes.data(), (int)bytes.size(), x, y, width, height, opacity, interpolationMode);
}

bool MemoryCanvas::DrawSvgData(const void* data, int dataSize, int x, int y, int width, int height, float opacity, int interpolationMode) {
    ComPtr<ID2D1Bitmap> bitmap;
    int w = 0, h = 0;
    if (FAILED(CreateBitmapFromSvgData(data, dataSize, width, height, bitmap.GetAddressOf(), &w, &h))) return false;
    return DrawBitmap(bitmap.Get(), w, h, x, y, width, height, opacity, interpolationMode);
}

bool MemoryCanvas::DrawHBitmap(HBITMAP bitmap, int x, int y, int width, int height, float opacity, int interpolationMode) {
    if (!wicFactory_ || !bitmap) return false;
    ComPtr<IWICBitmap> wicBitmap;
    lastResult_ = wicFactory_->CreateBitmapFromHBITMAP(bitmap, nullptr, WICBitmapUsePremultipliedAlpha, wicBitmap.GetAddressOf());
    if (FAILED(lastResult_)) return false;
    UINT w = 0, h = 0;
    wicBitmap->GetSize(&w, &h);
    ComPtr<ID2D1Bitmap> d2dBitmap;
    if (FAILED(CreateBitmapFromWic(wicBitmap.Get(), d2dBitmap.GetAddressOf()))) return false;
    return DrawBitmap(d2dBitmap.Get(), (int)w, (int)h, x, y, width, height, opacity, interpolationMode);
}

bool MemoryCanvas::CopyTo(MemoryCanvas& dest, int srcX, int srcY, int srcWidth, int srcHeight, int dstX, int dstY, int dstWidth, int dstHeight) {
    if (!IsReady() || !dest.IsReady()) return false;
    const int sourceLogicalWidth = logicalWidth_ > 0 ? logicalWidth_ : width_;
    const int sourceLogicalHeight = logicalHeight_ > 0 ? logicalHeight_ : height_;
    if (srcWidth < 0) srcWidth = sourceLogicalWidth - srcX;
    if (srcHeight < 0) srcHeight = sourceLogicalHeight - srcY;
    if (dstWidth < 0) dstWidth = srcWidth;
    if (dstHeight < 0) dstHeight = srcHeight;
    if (srcWidth <= 0 || srcHeight <= 0 || dstWidth <= 0 || dstHeight <= 0) return false;
    const int srcPixelX = ToPixelX(srcX);
    const int srcPixelY = ToPixelY(srcY);
    const int srcPixelWidth = ToPixelX(srcWidth);
    const int srcPixelHeight = ToPixelY(srcHeight);
    if (srcPixelWidth <= 0 || srcPixelHeight <= 0) return false;

    HDC dc = CreateCompatibleDC(nullptr);
    if (!dc) return false;
    BITMAPINFO info = {};
    info.bmiHeader.biSize = sizeof(BITMAPINFOHEADER);
    info.bmiHeader.biWidth = srcPixelWidth;
    info.bmiHeader.biHeight = -srcPixelHeight;
    info.bmiHeader.biPlanes = 1;
    info.bmiHeader.biBitCount = 32;
    info.bmiHeader.biCompression = BI_RGB;
    void* cropPixels = nullptr;
    HBITMAP crop = CreateDIBSection(dc, &info, DIB_RGB_COLORS, &cropPixels, nullptr, 0);
    if (!crop) {
        DeleteDC(dc);
        return false;
    }
    HGDIOBJ old = SelectObject(dc, crop);
    BitBlt(dc, 0, 0, srcPixelWidth, srcPixelHeight, memoryDc_, srcPixelX, srcPixelY, SRCCOPY);
    SelectObject(dc, old);
    DeleteDC(dc);

    bool ok = dest.DrawHBitmap(crop, dstX, dstY, dstWidth, dstHeight, 1.0f, D2D1_BITMAP_INTERPOLATION_MODE_LINEAR);
    DeleteObject(crop);
    return ok;
}

HBITMAP MemoryCanvas::CloneHBitmap(int outputWidth, int outputHeight) const {
    if (!bitmap_ || !pixels_) return nullptr;
    if (outputWidth <= 0) outputWidth = width_;
    if (outputHeight <= 0) outputHeight = height_;
    HDC dc = CreateCompatibleDC(nullptr);
    if (!dc) return nullptr;
    BITMAPINFO info = {};
    info.bmiHeader.biSize = sizeof(BITMAPINFOHEADER);
    info.bmiHeader.biWidth = outputWidth;
    info.bmiHeader.biHeight = -outputHeight;
    info.bmiHeader.biPlanes = 1;
    info.bmiHeader.biBitCount = 32;
    info.bmiHeader.biCompression = BI_RGB;
    void* dstPixels = nullptr;
    HBITMAP copy = CreateDIBSection(dc, &info, DIB_RGB_COLORS, &dstPixels, nullptr, 0);
    if (copy && dstPixels) {
        HGDIOBJ old = SelectObject(dc, copy);
        SetStretchBltMode(dc, HALFTONE);
        StretchBlt(dc, 0, 0, outputWidth, outputHeight, memoryDc_, 0, 0, width_, height_, SRCCOPY);
        SelectObject(dc, old);
    }
    DeleteDC(dc);
    return copy;
}

GUID MemoryCanvas::EncodeFormatGuid(int format) const {
    switch (format) {
    case IMAGE_ENCODE_BMP: return GUID_ContainerFormatBmp;
    case IMAGE_ENCODE_JPEG: return GUID_ContainerFormatJpeg;
    case IMAGE_ENCODE_GIF: return GUID_ContainerFormatGif;
    case IMAGE_ENCODE_TIFF: return GUID_ContainerFormatTiff;
    case IMAGE_ENCODE_PNG:
    default: return GUID_ContainerFormatPng;
    }
}

bool MemoryCanvas::EncodeToMemory(int format, int quality, std::vector<unsigned char>& bytes) const {
    bytes.clear();
    if (!wicFactory_ || !pixels_ || width_ <= 0 || height_ <= 0) return false;
    HGLOBAL global = GlobalAlloc(GMEM_MOVEABLE, 0);
    if (!global) return false;
    ComPtr<IStream> stream;
    HRESULT hr = CreateStreamOnHGlobal(global, TRUE, stream.GetAddressOf());
    if (FAILED(hr)) {
        GlobalFree(global);
        return false;
    }
    ComPtr<IWICBitmapEncoder> encoder;
    GUID container = EncodeFormatGuid(format);
    hr = wicFactory_->CreateEncoder(container, nullptr, encoder.GetAddressOf());
    if (FAILED(hr)) return false;
    hr = encoder->Initialize(stream.Get(), WICBitmapEncoderNoCache);
    if (FAILED(hr)) return false;
    ComPtr<IWICBitmapFrameEncode> frame;
    ComPtr<IPropertyBag2> props;
    hr = encoder->CreateNewFrame(frame.GetAddressOf(), props.GetAddressOf());
    if (FAILED(hr)) return false;
    if (props && format == IMAGE_ENCODE_JPEG && quality > 0) {
        PROPBAG2 option = {};
        option.pstrName = const_cast<LPOLESTR>(L"ImageQuality");
        VARIANT value;
        VariantInit(&value);
        value.vt = VT_R4;
        value.fltVal = std::max(1, std::min(100, quality)) / 100.0f;
        props->Write(1, &option, &value);
        VariantClear(&value);
    }
    hr = frame->Initialize(props.Get());
    if (FAILED(hr)) return false;
    hr = frame->SetSize((UINT)width_, (UINT)height_);
    if (FAILED(hr)) return false;
    WICPixelFormatGUID pixelFormat = GUID_WICPixelFormat32bppPBGRA;
    hr = frame->SetPixelFormat(&pixelFormat);
    if (FAILED(hr)) return false;
    hr = frame->WritePixels((UINT)height_, (UINT)stride_, (UINT)(stride_ * height_), static_cast<BYTE*>(pixels_));
    if (FAILED(hr)) return false;
    hr = frame->Commit();
    if (FAILED(hr)) return false;
    hr = encoder->Commit();
    if (FAILED(hr)) return false;

    HGLOBAL written = nullptr;
    if (FAILED(GetHGlobalFromStream(stream.Get(), &written)) || !written) return false;
    SIZE_T size = GlobalSize(written);
    void* ptr = GlobalLock(written);
    if (!ptr || size == 0) {
        if (ptr) GlobalUnlock(written);
        return false;
    }
    bytes.resize((size_t)size);
    std::memcpy(bytes.data(), ptr, (size_t)size);
    GlobalUnlock(written);
    return true;
}

bool MemoryCanvas::SaveToFile(const wchar_t* fileName, int format, int quality) const {
    if (!fileName) return false;
    std::vector<unsigned char> bytes;
    if (!EncodeToMemory(format, quality, bytes)) return false;
    HANDLE file = CreateFileW(fileName, GENERIC_WRITE, 0, nullptr, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, nullptr);
    if (file == INVALID_HANDLE_VALUE) return false;
    DWORD written = 0;
    BOOL ok = WriteFile(file, bytes.data(), (DWORD)bytes.size(), &written, nullptr);
    CloseHandle(file);
    return ok && written == bytes.size();
}

std::wstring MemoryCanvas::LastErrorText() const {
    wchar_t buffer[128];
    swprintf_s(buffer, L"HRESULT=0x%08X", static_cast<unsigned int>(lastResult_));
    return buffer;
}

}  // namespace volcano_d2d
