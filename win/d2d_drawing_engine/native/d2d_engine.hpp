#pragma once

#ifndef NOMINMAX
#define NOMINMAX
#endif

#ifndef WINVER
#define WINVER 0x0601
#endif

#ifndef _WIN32_WINNT
#define _WIN32_WINNT 0x0601
#endif

#ifndef NTDDI_VERSION
#define NTDDI_VERSION 0x06010000
#endif

#include <windows.h>
#include <windowsx.h>
#include <d2d1_1.h>
#include <dwrite.h>
#include <wincodec.h>
#include <wrl/client.h>
#include <string>
#include <vector>

#pragma comment(lib, "d2d1.lib")
#pragma comment(lib, "dwrite.lib")
#pragma comment(lib, "windowscodecs.lib")

namespace volcano_d2d {

using Microsoft::WRL::ComPtr;

using PaintCallback = void (*)(void*);
using ResizeCallback = void (*)(void*, int, int);
using MouseCallback = void (*)(void*, int, int, int);
using KeyCallback = void (*)(void*, int, int);

enum MouseEventType {
    MOUSE_MOVE = 0,
    MOUSE_DOWN = 1,
    MOUSE_UP = 2,
    MOUSE_LEAVE = 3,
    MOUSE_WHEEL = 4
};

enum KeyEventType {
    KEY_DOWN = 0,
    KEY_UP = 1,
    KEY_FOCUS = 2,
    KEY_BLUR = 3
};

struct Color {
    float r = 0.0f;
    float g = 0.0f;
    float b = 0.0f;
    float a = 1.0f;
};

inline bool operator==(const Color& lhs, const Color& rhs) {
    return lhs.r == rhs.r && lhs.g == rhs.g && lhs.b == rhs.b && lhs.a == rhs.a;
}

inline bool operator!=(const Color& lhs, const Color& rhs) {
    return !(lhs == rhs);
}

struct Point {
    float x = 0.0f;
    float y = 0.0f;
};

struct Rect {
    float left = 0.0f;
    float top = 0.0f;
    float right = 0.0f;
    float bottom = 0.0f;
};

struct Matrix {
    float m11 = 1.0f;
    float m12 = 0.0f;
    float m21 = 0.0f;
    float m22 = 1.0f;
    float dx = 0.0f;
    float dy = 0.0f;
};

struct TextMetrics {
    float left = 0.0f;
    float top = 0.0f;
    float width = 0.0f;
    float widthIncludingTrailingWhitespace = 0.0f;
    float height = 0.0f;
    float layoutWidth = 0.0f;
    float layoutHeight = 0.0f;
    int maxBidiReorderingDepth = 0;
    int lineCount = 0;
};

struct RenderOptions {
    int factoryType = D2D1_FACTORY_TYPE_SINGLE_THREADED;
    int debugLevel = D2D1_DEBUG_LEVEL_NONE;
    int renderTargetType = D2D1_RENDER_TARGET_TYPE_DEFAULT;
    int featureLevel = D2D1_FEATURE_LEVEL_DEFAULT;
    int presentOptions = D2D1_PRESENT_OPTIONS_NONE;
    int alphaMode = D2D1_ALPHA_MODE_UNKNOWN;
    int pixelFormat = DXGI_FORMAT_UNKNOWN;
    float dpiX = 0.0f;
    float dpiY = 0.0f;
    bool gdiCompatible = false;
};

struct GradientStop {
    float position = 0.0f;
    Color color;
};

class Engine {
public:
    Engine();
    ~Engine();

    HRESULT CreateForHwnd(HWND hwnd, int width, int height, const RenderOptions& options);
    void Destroy();
    bool IsReady() const;
    HRESULT Resize(int width, int height);
    void Invalidate(bool eraseBackground);
    void UpdateNow();
    bool InstallAutoRepaint(void* owner, PaintCallback paintCallback, ResizeCallback resizeCallback = nullptr, MouseCallback mouseCallback = nullptr, KeyCallback keyCallback = nullptr);
    void UninstallAutoRepaint();

    void BeginDraw();
    HRESULT EndDraw();
    void Flush();
    void Clear(Color color);

    void SetDpi(float dpiX, float dpiY);
    void SetTransform(Matrix matrix);
    void ResetTransform();
    void SetAntialiasMode(int mode);
    void SetTextAntialiasMode(int mode);
    void SetTags(UINT64 tag1, UINT64 tag2);

    void DrawLine(Point p1, Point p2, Color color, float strokeWidth);
    void DrawRectangle(Rect rect, Color color, float strokeWidth);
    void FillRectangle(Rect rect, Color color);
    void DrawRoundedRectangle(Rect rect, float radiusX, float radiusY, Color color, float strokeWidth);
    void FillRoundedRectangle(Rect rect, float radiusX, float radiusY, Color color);
    void DrawEllipse(Point center, float radiusX, float radiusY, Color color, float strokeWidth);
    void FillEllipse(Point center, float radiusX, float radiusY, Color color);

    HRESULT CreateSolidBrush(Color color, float opacity, ID2D1SolidColorBrush** brush);
    HRESULT CreateLinearGradientBrush(Point start, Point end, const GradientStop* stops, UINT32 count, ID2D1LinearGradientBrush** brush);
    HRESULT CreateRadialGradientBrush(Point center, Point originOffset, float radiusX, float radiusY, const GradientStop* stops, UINT32 count, ID2D1RadialGradientBrush** brush);
    void ReleaseUnknown(IUnknown* value);
    void SetBrushOpacity(ID2D1Brush* brush, float opacity);
    void SetBrushTransform(ID2D1Brush* brush, Matrix matrix);

    void DrawLineByBrush(Point p1, Point p2, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle);
    void DrawRectByBrush(Rect rect, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle);
    void FillRectByBrush(Rect rect, ID2D1Brush* brush);
    void DrawRoundedRectByBrush(Rect rect, float radiusX, float radiusY, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle);
    void FillRoundedRectByBrush(Rect rect, float radiusX, float radiusY, ID2D1Brush* brush);
    void DrawEllipseByBrush(Point center, float radiusX, float radiusY, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle);
    void FillEllipseByBrush(Point center, float radiusX, float radiusY, ID2D1Brush* brush);

    HRESULT CreateStrokeStyle(int startCap, int endCap, int dashCap, int lineJoin, float miterLimit, int dashStyle, float dashOffset, ID2D1StrokeStyle** style);
    HRESULT CreateCustomStrokeStyle(int startCap, int endCap, int dashCap, int lineJoin, float miterLimit, float dashOffset, const float* dashes, UINT32 dashCount, ID2D1StrokeStyle** style);

    HRESULT CreateRectangleGeometry(Rect rect, ID2D1RectangleGeometry** geometry);
    HRESULT CreateRoundedRectangleGeometry(Rect rect, float radiusX, float radiusY, ID2D1RoundedRectangleGeometry** geometry);
    HRESULT CreateEllipseGeometry(Point center, float radiusX, float radiusY, ID2D1EllipseGeometry** geometry);
    HRESULT CreateTransformedGeometry(ID2D1Geometry* source, Matrix matrix, ID2D1TransformedGeometry** geometry);
    HRESULT CreateCombinedGeometry(ID2D1Geometry* first, ID2D1Geometry* second, int combineMode, ID2D1PathGeometry** geometry);
    HRESULT CreateSimplifiedGeometry(ID2D1Geometry* source, int simplifyOption, ID2D1PathGeometry** geometry);
    HRESULT CreateWidenedGeometry(ID2D1Geometry* source, float strokeWidth, ID2D1StrokeStyle* strokeStyle, ID2D1PathGeometry** geometry);
    HRESULT CreateOutlinedGeometry(ID2D1Geometry* source, ID2D1PathGeometry** geometry);
    HRESULT CreateGeometryGroup2(ID2D1Geometry* first, ID2D1Geometry* second, int fillMode, ID2D1GeometryGroup** geometry);
    HRESULT CreatePathGeometry(ID2D1PathGeometry** geometry);
    HRESULT OpenGeometry(ID2D1PathGeometry* geometry, ID2D1GeometrySink** sink);
    void GeometryBeginFigure(ID2D1GeometrySink* sink, Point start, bool filled);
    void GeometryAddLine(ID2D1GeometrySink* sink, Point point);
    void GeometryAddBezier(ID2D1GeometrySink* sink, Point p1, Point p2, Point p3);
    void GeometryAddQuadraticBezier(ID2D1GeometrySink* sink, Point p1, Point p2);
    void GeometryAddArc(ID2D1GeometrySink* sink, Point end, float radiusX, float radiusY, float rotation, int sweepDirection, int arcSize);
    void GeometryEndFigure(ID2D1GeometrySink* sink, bool closed);
    HRESULT GeometryClose(ID2D1GeometrySink* sink);
    void DrawGeometry(ID2D1Geometry* geometry, ID2D1Brush* brush, float strokeWidth, ID2D1StrokeStyle* strokeStyle);
    void FillGeometry(ID2D1Geometry* geometry, ID2D1Brush* brush);
    HRESULT GeometryGetBounds(ID2D1Geometry* geometry, Rect* bounds);
    HRESULT GeometryComputeArea(ID2D1Geometry* geometry, float* area);
    HRESULT GeometryComputeLength(ID2D1Geometry* geometry, float* length);
    bool GeometryFillContainsPoint(ID2D1Geometry* geometry, Point point);
    bool GeometryStrokeContainsPoint(ID2D1Geometry* geometry, Point point, float strokeWidth, ID2D1StrokeStyle* strokeStyle);

    HRESULT LoadBitmapFromFile(const wchar_t* fileName, ID2D1Bitmap** bitmap);
    HRESULT LoadBitmapFromMemory(const void* data, int dataSize, ID2D1Bitmap** bitmap);
    HRESULT CreateBitmapFromBgra(int width, int height, const void* pixels, UINT32 stride, ID2D1Bitmap** bitmap);
    void DrawBitmap(ID2D1Bitmap* bitmap, Rect dest, float opacity, int interpolationMode, Rect source);
    HRESULT CreateBitmapBrush(ID2D1Bitmap* bitmap, int extendModeX, int extendModeY, int interpolationMode, float opacity, ID2D1BitmapBrush** brush);
    int BitmapWidth(ID2D1Bitmap* bitmap) const;
    int BitmapHeight(ID2D1Bitmap* bitmap) const;

    HRESULT CreateTextFormat(const wchar_t* fontFamily, float size, int weight, int style, int stretch, const wchar_t* locale, IDWriteTextFormat** format);
    HRESULT CreateTextLayout(const wchar_t* text, IDWriteTextFormat* format, float maxWidth, float maxHeight, IDWriteTextLayout** layout);
    HRESULT TextLayoutMetrics(IDWriteTextLayout* layout, TextMetrics* metrics);
    bool TextLayoutHitTestPoint(IDWriteTextLayout* layout, float x, float y, int* textPosition, bool* trailingHit, bool* inside);
    void SetTextAlignment(IDWriteTextFormat* format, int alignment);
    void SetParagraphAlignment(IDWriteTextFormat* format, int alignment);
    void SetWordWrapping(IDWriteTextFormat* format, int wrapping);
    void DrawTextSimple(const wchar_t* text, Rect rect, Color color, const wchar_t* fontFamily, float size, int weight, int style, int horizontalAlign, int verticalAlign);
    void DrawTextDecorated(const wchar_t* text, Rect rect, Color color, const wchar_t* fontFamily, float size, int weight, int style, bool underline, bool strikeout, float rotationDegrees, int horizontalAlign, int verticalAlign, bool wordWrap = true);
    void DrawTextLayout(Point origin, IDWriteTextLayout* layout, ID2D1Brush* brush, int options);

    HRESULT CreateLayer(ID2D1Layer** layer);
    void PushLayer(Rect contentBounds, ID2D1Layer* layer, float opacity);
    void PopLayer();
    void PushAxisAlignedClip(Rect rect, int antialiasMode);
    void PopAxisAlignedClip();
    HRESULT CreateDrawingStateBlock(ID2D1DrawingStateBlock** stateBlock);
    void SaveDrawingState(ID2D1DrawingStateBlock* stateBlock);
    void RestoreDrawingState(ID2D1DrawingStateBlock* stateBlock);

    ID2D1Factory1* Factory() const { return factory_.Get(); }
    IDWriteFactory* WriteFactory() const { return writeFactory_.Get(); }
    IWICImagingFactory* WicFactory() const { return wicFactory_.Get(); }
    ID2D1HwndRenderTarget* Target() const { return target_.Get(); }
    HRESULT LastResult() const { return lastResult_; }
    std::wstring LastErrorText() const;


private:
    D2D1_COLOR_F ToD2D(Color color) const;
    D2D1_POINT_2F ToD2D(Point point) const;
    D2D1_RECT_F ToD2D(Rect rect) const;
    D2D1_MATRIX_3X2_F ToD2D(Matrix matrix) const;
    ID2D1SolidColorBrush* TempBrush(Color color);
    HRESULT EnsureFactories(const RenderOptions& options);
    static LRESULT CALLBACK AutoRepaintWndProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam);
    LRESULT HandleAutoRepaintMessage(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam);

    HWND hwnd_ = nullptr;
    WNDPROC oldWndProc_ = nullptr;
    void* callbackOwner_ = nullptr;
    PaintCallback paintCallback_ = nullptr;
    ResizeCallback resizeCallback_ = nullptr;
    MouseCallback mouseCallback_ = nullptr;
    KeyCallback keyCallback_ = nullptr;
    bool inAutoPaint_ = false;
    bool trackingMouseLeave_ = false;
    bool comInitialized_ = false;
    HRESULT lastResult_ = S_OK;
    RenderOptions options_;
    ComPtr<ID2D1Factory1> factory_;
    ComPtr<IDWriteFactory> writeFactory_;
    ComPtr<IWICImagingFactory> wicFactory_;
    ComPtr<ID2D1HwndRenderTarget> target_;
    ComPtr<ID2D1SolidColorBrush> tempBrush_;
};

inline Color MakeColor(float r, float g, float b, float a = 1.0f) {
    Color value;
    value.r = r;
    value.g = g;
    value.b = b;
    value.a = a;
    return value;
}

inline Color MakeColorFromColorRef(int color) {
    return MakeColor(
        static_cast<float>(color & 0xFF) / 255.0f,
        static_cast<float>((color >> 8) & 0xFF) / 255.0f,
        static_cast<float>((color >> 16) & 0xFF) / 255.0f,
        1.0f);
}

inline Point MakePoint(float x, float y) {
    Point value;
    value.x = x;
    value.y = y;
    return value;
}

inline Rect MakeRect(float left, float top, float right, float bottom) {
    Rect value;
    value.left = left;
    value.top = top;
    value.right = right;
    value.bottom = bottom;
    return value;
}

inline Matrix MakeIdentityMatrix() {
    return Matrix{};
}

inline Matrix MakeTranslationMatrix(float x, float y) {
    Matrix value;
    D2D1_MATRIX_3X2_F m = D2D1::Matrix3x2F::Translation(x, y);
    value.m11 = m._11; value.m12 = m._12; value.m21 = m._21; value.m22 = m._22; value.dx = m._31; value.dy = m._32;
    return value;
}

inline Matrix MakeScaleMatrix(float scaleX, float scaleY, float centerX, float centerY) {
    Matrix value;
    D2D1_MATRIX_3X2_F m = D2D1::Matrix3x2F::Scale(scaleX, scaleY, D2D1::Point2F(centerX, centerY));
    value.m11 = m._11; value.m12 = m._12; value.m21 = m._21; value.m22 = m._22; value.dx = m._31; value.dy = m._32;
    return value;
}

inline Matrix MakeRotationMatrix(float angleDegrees, float centerX, float centerY) {
    Matrix value;
    D2D1_MATRIX_3X2_F m = D2D1::Matrix3x2F::Rotation(angleDegrees, D2D1::Point2F(centerX, centerY));
    value.m11 = m._11; value.m12 = m._12; value.m21 = m._21; value.m22 = m._22; value.dx = m._31; value.dy = m._32;
    return value;
}

inline Matrix MakeSkewMatrix(float angleX, float angleY, float centerX, float centerY) {
    Matrix value;
    D2D1_MATRIX_3X2_F m = D2D1::Matrix3x2F::Skew(angleX, angleY, D2D1::Point2F(centerX, centerY));
    value.m11 = m._11; value.m12 = m._12; value.m21 = m._21; value.m22 = m._22; value.dx = m._31; value.dy = m._32;
    return value;
}

inline Matrix MultiplyMatrix(Matrix first, Matrix second) {
    D2D1_MATRIX_3X2_F a = D2D1::Matrix3x2F(first.m11, first.m12, first.m21, first.m22, first.dx, first.dy);
    D2D1_MATRIX_3X2_F b = D2D1::Matrix3x2F(second.m11, second.m12, second.m21, second.m22, second.dx, second.dy);
    D2D1_MATRIX_3X2_F m = a * b;
    Matrix value;
    value.m11 = m._11; value.m12 = m._12; value.m21 = m._21; value.m22 = m._22; value.dx = m._31; value.dy = m._32;
    return value;
}

inline ID2D1SolidColorBrush* CreateSolidBrushPtr(Engine& engine, Color color, float opacity) {
    ID2D1SolidColorBrush* brush = nullptr;
    engine.CreateSolidBrush(color, opacity, &brush);
    return brush;
}

inline ID2D1StrokeStyle* CreateStrokeStylePtr(Engine& engine, int startCap, int endCap, int dashCap, int lineJoin, float miterLimit, int dashStyle, float dashOffset) {
    ID2D1StrokeStyle* style = nullptr;
    engine.CreateStrokeStyle(startCap, endCap, dashCap, lineJoin, miterLimit, dashStyle, dashOffset, &style);
    return style;
}

inline ID2D1StrokeStyle* CreateCustomStrokeStyle2Ptr(Engine& engine, float dash1, float dash2, int startCap, int endCap, int dashCap, int lineJoin, float miterLimit, float dashOffset) {
    float dashes[2] = { dash1, dash2 };
    ID2D1StrokeStyle* style = nullptr;
    engine.CreateCustomStrokeStyle(startCap, endCap, dashCap, lineJoin, miterLimit, dashOffset, dashes, 2, &style);
    return style;
}

inline ID2D1StrokeStyle* CreateCustomStrokeStyle4Ptr(Engine& engine, float dash1, float dash2, float dash3, float dash4, int startCap, int endCap, int dashCap, int lineJoin, float miterLimit, float dashOffset) {
    float dashes[4] = { dash1, dash2, dash3, dash4 };
    ID2D1StrokeStyle* style = nullptr;
    engine.CreateCustomStrokeStyle(startCap, endCap, dashCap, lineJoin, miterLimit, dashOffset, dashes, 4, &style);
    return style;
}

inline ID2D1LinearGradientBrush* CreateLinearGradientBrush2Ptr(Engine& engine, Point start, Point end, Color color1, Color color2) {
    GradientStop stops[2];
    stops[0].position = 0.0f;
    stops[0].color = color1;
    stops[1].position = 1.0f;
    stops[1].color = color2;
    ID2D1LinearGradientBrush* brush = nullptr;
    engine.CreateLinearGradientBrush(start, end, stops, 2, &brush);
    return brush;
}

inline ID2D1LinearGradientBrush* CreateLinearGradientBrush3Ptr(Engine& engine, Point start, Point end, Color color1, float middlePosition, Color color2, Color color3) {
    GradientStop stops[3];
    stops[0].position = 0.0f;
    stops[0].color = color1;
    stops[1].position = middlePosition;
    stops[1].color = color2;
    stops[2].position = 1.0f;
    stops[2].color = color3;
    ID2D1LinearGradientBrush* brush = nullptr;
    engine.CreateLinearGradientBrush(start, end, stops, 3, &brush);
    return brush;
}

inline ID2D1RadialGradientBrush* CreateRadialGradientBrush2Ptr(Engine& engine, Point center, Point originOffset, float radiusX, float radiusY, Color color1, Color color2) {
    GradientStop stops[2];
    stops[0].position = 0.0f;
    stops[0].color = color1;
    stops[1].position = 1.0f;
    stops[1].color = color2;
    ID2D1RadialGradientBrush* brush = nullptr;
    engine.CreateRadialGradientBrush(center, originOffset, radiusX, radiusY, stops, 2, &brush);
    return brush;
}

inline ID2D1RadialGradientBrush* CreateRadialGradientBrush3Ptr(Engine& engine, Point center, Point originOffset, float radiusX, float radiusY, Color color1, float middlePosition, Color color2, Color color3) {
    GradientStop stops[3];
    stops[0].position = 0.0f;
    stops[0].color = color1;
    stops[1].position = middlePosition;
    stops[1].color = color2;
    stops[2].position = 1.0f;
    stops[2].color = color3;
    ID2D1RadialGradientBrush* brush = nullptr;
    engine.CreateRadialGradientBrush(center, originOffset, radiusX, radiusY, stops, 3, &brush);
    return brush;
}

inline ID2D1PathGeometry* CreatePathGeometryPtr(Engine& engine) {
    ID2D1PathGeometry* geometry = nullptr;
    engine.CreatePathGeometry(&geometry);
    return geometry;
}

inline ID2D1RectangleGeometry* CreateRectangleGeometryPtr(Engine& engine, Rect rect) {
    ID2D1RectangleGeometry* geometry = nullptr;
    engine.CreateRectangleGeometry(rect, &geometry);
    return geometry;
}

inline ID2D1RoundedRectangleGeometry* CreateRoundedRectangleGeometryPtr(Engine& engine, Rect rect, float radiusX, float radiusY) {
    ID2D1RoundedRectangleGeometry* geometry = nullptr;
    engine.CreateRoundedRectangleGeometry(rect, radiusX, radiusY, &geometry);
    return geometry;
}

inline ID2D1EllipseGeometry* CreateEllipseGeometryPtr(Engine& engine, Point center, float radiusX, float radiusY) {
    ID2D1EllipseGeometry* geometry = nullptr;
    engine.CreateEllipseGeometry(center, radiusX, radiusY, &geometry);
    return geometry;
}

inline ID2D1TransformedGeometry* CreateTransformedGeometryPtr(Engine& engine, ID2D1Geometry* source, Matrix matrix) {
    ID2D1TransformedGeometry* geometry = nullptr;
    engine.CreateTransformedGeometry(source, matrix, &geometry);
    return geometry;
}

inline ID2D1PathGeometry* CreateCombinedGeometryPtr(Engine& engine, ID2D1Geometry* first, ID2D1Geometry* second, int combineMode) {
    ID2D1PathGeometry* geometry = nullptr;
    engine.CreateCombinedGeometry(first, second, combineMode, &geometry);
    return geometry;
}

inline ID2D1PathGeometry* CreateSimplifiedGeometryPtr(Engine& engine, ID2D1Geometry* source, int simplifyOption) {
    ID2D1PathGeometry* geometry = nullptr;
    engine.CreateSimplifiedGeometry(source, simplifyOption, &geometry);
    return geometry;
}

inline ID2D1PathGeometry* CreateWidenedGeometryPtr(Engine& engine, ID2D1Geometry* source, float strokeWidth, ID2D1StrokeStyle* strokeStyle) {
    ID2D1PathGeometry* geometry = nullptr;
    engine.CreateWidenedGeometry(source, strokeWidth, strokeStyle, &geometry);
    return geometry;
}

inline ID2D1PathGeometry* CreateOutlinedGeometryPtr(Engine& engine, ID2D1Geometry* source) {
    ID2D1PathGeometry* geometry = nullptr;
    engine.CreateOutlinedGeometry(source, &geometry);
    return geometry;
}

inline ID2D1GeometryGroup* CreateGeometryGroup2Ptr(Engine& engine, ID2D1Geometry* first, ID2D1Geometry* second, int fillMode) {
    ID2D1GeometryGroup* geometry = nullptr;
    engine.CreateGeometryGroup2(first, second, fillMode, &geometry);
    return geometry;
}

inline ID2D1GeometrySink* OpenGeometryPtr(Engine& engine, ID2D1PathGeometry* geometry) {
    ID2D1GeometrySink* sink = nullptr;
    engine.OpenGeometry(geometry, &sink);
    return sink;
}

inline Rect GeometryBoundsValue(Engine& engine, ID2D1Geometry* geometry) {
    Rect bounds;
    engine.GeometryGetBounds(geometry, &bounds);
    return bounds;
}

inline float GeometryAreaValue(Engine& engine, ID2D1Geometry* geometry) {
    float area = 0.0f;
    engine.GeometryComputeArea(geometry, &area);
    return area;
}

inline float GeometryLengthValue(Engine& engine, ID2D1Geometry* geometry) {
    float length = 0.0f;
    engine.GeometryComputeLength(geometry, &length);
    return length;
}

inline ID2D1Bitmap* LoadBitmapFromFilePtr(Engine& engine, const wchar_t* fileName) {
    ID2D1Bitmap* bitmap = nullptr;
    engine.LoadBitmapFromFile(fileName, &bitmap);
    return bitmap;
}

inline ID2D1Bitmap* CreateBitmapFromBgraPtr(Engine& engine, int width, int height, const void* pixels, UINT32 stride) {
    ID2D1Bitmap* bitmap = nullptr;
    engine.CreateBitmapFromBgra(width, height, pixels, stride, &bitmap);
    return bitmap;
}

inline ID2D1BitmapBrush* CreateBitmapBrushPtr(Engine& engine, ID2D1Bitmap* bitmap, int extendModeX, int extendModeY, int interpolationMode, float opacity) {
    ID2D1BitmapBrush* brush = nullptr;
    engine.CreateBitmapBrush(bitmap, extendModeX, extendModeY, interpolationMode, opacity, &brush);
    return brush;
}

inline IDWriteTextFormat* CreateTextFormatPtr(Engine& engine, const wchar_t* fontFamily, float size, int weight, int style, int stretch, const wchar_t* locale) {
    IDWriteTextFormat* format = nullptr;
    engine.CreateTextFormat(fontFamily, size, weight, style, stretch, locale, &format);
    return format;
}

inline IDWriteTextLayout* CreateTextLayoutPtr(Engine& engine, const wchar_t* text, IDWriteTextFormat* format, float maxWidth, float maxHeight) {
    IDWriteTextLayout* layout = nullptr;
    engine.CreateTextLayout(text, format, maxWidth, maxHeight, &layout);
    return layout;
}

inline TextMetrics TextLayoutMetricsValue(Engine& engine, IDWriteTextLayout* layout) {
    TextMetrics metrics;
    engine.TextLayoutMetrics(layout, &metrics);
    return metrics;
}

inline int TextLayoutHitTextPosition(Engine& engine, IDWriteTextLayout* layout, float x, float y) {
    int position = -1;
    bool trailing = false;
    bool inside = false;
    engine.TextLayoutHitTestPoint(layout, x, y, &position, &trailing, &inside);
    return position;
}

inline ID2D1Layer* CreateLayerPtr(Engine& engine) {
    ID2D1Layer* layer = nullptr;
    engine.CreateLayer(&layer);
    return layer;
}

inline ID2D1DrawingStateBlock* CreateDrawingStateBlockPtr(Engine& engine) {
    ID2D1DrawingStateBlock* state = nullptr;
    engine.CreateDrawingStateBlock(&state);
    return state;
}

inline const void* CheckerPixels32() {
    static unsigned int pixels[32 * 32];
    static bool initialized = false;
    if (!initialized) {
        for (int y = 0; y < 32; ++y) {
            for (int x = 0; x < 32; ++x) {
                const bool light = ((x / 8) + (y / 8)) % 2 == 0;
                pixels[y * 32 + x] = light ? 0xFFFFF4D8u : 0xFF2F6F89u;
            }
        }
        initialized = true;
    }
    return pixels;
}

inline int HitTestDemoTab(int x, int y) {
    if (y < 24 || y > 62) return -1;
    if (x >= 24 && x < 88) return 0;
    if (x >= 88 && x < 152) return 1;
    if (x >= 152 && x < 216) return 2;
    if (x >= 216 && x < 280) return 3;
    if (x >= 280 && x < 344) return 4;
    if (x >= 344 && x < 408) return 5;
    if (x >= 408 && x < 472) return 6;
    if (x >= 472 && x < 536) return 7;
    if (x >= 536 && x < 600) return 8;
    if (x >= 600 && x < 664) return 9;
    if (x >= 664 && x < 728) return 10;
    return -1;
}

}  // namespace volcano_d2d

