#pragma once

#ifndef NOMINMAX
#define NOMINMAX
#endif

#include "d2d_engine.hpp"

#include <windows.h>
#include <d2d1_1.h>
#include <dwrite.h>
#include <wincodec.h>
#include <wrl/client.h>
#include <cstring>
#include <string>
#include <vector>

#pragma comment(lib, "ole32.lib")
#pragma comment(lib, "oleaut32.lib")

namespace volcano_d2d {

enum ImageEncodeFormat {
    IMAGE_ENCODE_PNG = 0,
    IMAGE_ENCODE_BMP = 1,
    IMAGE_ENCODE_JPEG = 2,
    IMAGE_ENCODE_GIF = 3,
    IMAGE_ENCODE_TIFF = 4
};

enum CanvasBrushType {
    CANVAS_BRUSH_SOLID = 0,
    CANVAS_BRUSH_NULL = 1
};

enum CanvasPenType {
    CANVAS_PEN_SOLID = 0,
    CANVAS_PEN_NULL = 1
};

class MemoryCanvas {
public:
    MemoryCanvas();
    ~MemoryCanvas();

    bool Create(int width, int height, float dpiScale, Color background);
    void Destroy();
    bool Resize(int width, int height, float dpiScale, Color background);
    bool IsReady() const;

    int Width() const { return logicalWidth_ > 0 ? logicalWidth_ : width_; }
    int Height() const { return logicalHeight_ > 0 ? logicalHeight_ : height_; }
    HRESULT LastResult() const { return lastResult_; }
    std::wstring LastErrorText() const;

    void BeginDraw();
    HRESULT EndDraw();
    void Flush();

    void Clear(Color color);
    void ClearRect(int x, int y, int width, int height, Color color);
    int GetPixel(int x, int y) const;
    void DrawPoint(int x, int y, Color color);
    void DrawLine(int x1, int y1, int x2, int y2);
    void DrawRectangle(int left, int top, int right, int bottom);
    void FillRectangle(int left, int top, int right, int bottom);
    void DrawEllipse(int left, int top, int right, int bottom);
    void FillEllipse(int left, int top, int right, int bottom);
    void DrawRoundRect(int left, int top, int right, int bottom, int radiusX, int radiusY);
    void FillRoundRect(int left, int top, int right, int bottom, int radiusX, int radiusY);
    void DrawPolygon(const int* points, int pointCount);
    void FillPolygon(const int* points, int pointCount);

    void SetPen(Color color, float width, int type);
    void SetBrush(Color color, int type);
    void SetTextColor(Color color);
    void SetTextBackgroundColor(Color color);
    void SetFont(const wchar_t* family, float size, int weight, int style);
    void SetWritePos(int x, int y);
    void DrawTextAt(int x, int y, const wchar_t* text, int lineSpacing);
    void DrawTextInRect(int left, int top, int right, int bottom, const wchar_t* text, int horizontalAlign, int verticalAlign, bool wordWrap);
    int TextWidth(const wchar_t* text);
    int TextHeight(const wchar_t* text);

    bool DrawImageFile(const wchar_t* fileName, int x, int y, int width, int height, float opacity, int interpolationMode);
    bool DrawImageData(const void* data, int dataSize, int x, int y, int width, int height, float opacity, int interpolationMode);
    bool DrawSvgFile(const wchar_t* fileName, int x, int y, int width, int height, float opacity, int interpolationMode);
    bool DrawSvgData(const void* data, int dataSize, int x, int y, int width, int height, float opacity, int interpolationMode);
    bool DrawHBitmap(HBITMAP bitmap, int x, int y, int width, int height, float opacity, int interpolationMode);
    bool CopyTo(MemoryCanvas& dest, int srcX, int srcY, int srcWidth, int srcHeight, int dstX, int dstY, int dstWidth, int dstHeight);

    HBITMAP CloneHBitmap(int outputWidth = 0, int outputHeight = 0) const;
    bool EncodeToMemory(int format, int quality, std::vector<unsigned char>& bytes) const;
    bool SaveToFile(const wchar_t* fileName, int format, int quality) const;

    ID2D1RenderTarget* Target() const { return target_.Get(); }
    IWICImagingFactory* WicFactory() const { return wicFactory_.Get(); }

private:
    struct AutoDraw;

    HRESULT EnsureFactories();
    bool CreateDib(int width, int height);
    bool BindTarget();
    void ReleaseSurface();
    ID2D1SolidColorBrush* TempBrush(Color color);
    ID2D1SolidColorBrush* PenBrush();
    ID2D1SolidColorBrush* FillBrush();
    D2D1_COLOR_F ToD2D(Color color) const;
    D2D1_RECT_F RectF(float left, float top, float right, float bottom) const;
    HRESULT CreateBitmapFromWic(IWICBitmapSource* source, ID2D1Bitmap** bitmap);
    HRESULT LoadWicBitmapFromFile(const wchar_t* fileName, ID2D1Bitmap** bitmap, int* width, int* height);
    HRESULT LoadWicBitmapFromMemory(const void* data, int dataSize, ID2D1Bitmap** bitmap, int* width, int* height);
    HRESULT CreateBitmapFromSvgData(const void* data, int dataSize, int requestedWidth, int requestedHeight, ID2D1Bitmap** bitmap, int* width, int* height);
    bool DrawBitmap(ID2D1Bitmap* bitmap, int bitmapWidth, int bitmapHeight, int x, int y, int width, int height, float opacity, int interpolationMode);
    HRESULT CreateTextFormat(IDWriteTextFormat** format);
    SIZE MeasureText(const wchar_t* text);
    GUID EncodeFormatGuid(int format) const;
    int ToPixelX(int value) const;
    int ToPixelY(int value) const;
    int ToLogicalWidth(int pixelWidth) const;
    int ToLogicalHeight(int pixelHeight) const;

    int width_ = 0;
    int height_ = 0;
    int logicalWidth_ = 0;
    int logicalHeight_ = 0;
    int stride_ = 0;
    HDC memoryDc_ = nullptr;
    HBITMAP bitmap_ = nullptr;
    void* pixels_ = nullptr;
    HGDIOBJ oldBitmap_ = nullptr;
    bool comInitialized_ = false;
    bool inDraw_ = false;
    HRESULT lastResult_ = S_OK;
    float dpiX_ = 96.0f;
    float dpiY_ = 96.0f;

    Color penColor_ = MakeColor(0, 0, 0, 1);
    Color brushColor_ = MakeColor(1, 1, 1, 1);
    Color textColor_ = MakeColor(0, 0, 0, 1);
    Color textBackgroundColor_ = MakeColor(0, 0, 0, 0);
    float penWidth_ = 1.0f;
    int penType_ = CANVAS_PEN_SOLID;
    int brushType_ = CANVAS_BRUSH_SOLID;
    std::wstring fontFamily_ = L"Microsoft YaHei";
    float fontSize_ = 16.0f;
    int fontWeight_ = DWRITE_FONT_WEIGHT_NORMAL;
    int fontStyle_ = DWRITE_FONT_STYLE_NORMAL;
    int writeX_ = 0;
    int writeY_ = 0;

    Microsoft::WRL::ComPtr<ID2D1Factory1> factory_;
    Microsoft::WRL::ComPtr<IDWriteFactory> writeFactory_;
    Microsoft::WRL::ComPtr<IWICImagingFactory> wicFactory_;
    Microsoft::WRL::ComPtr<ID2D1DCRenderTarget> target_;
    Microsoft::WRL::ComPtr<ID2D1SolidColorBrush> tempBrush_;
    Microsoft::WRL::ComPtr<ID2D1SolidColorBrush> penBrush_;
    Microsoft::WRL::ComPtr<ID2D1SolidColorBrush> fillBrush_;
};

inline bool MemoryCanvasEncodeToBytes(MemoryCanvas& canvas, int format, int quality, std::vector<unsigned char>& bytes) {
    return canvas.EncodeToMemory(format, quality, bytes);
}

}  // namespace volcano_d2d
