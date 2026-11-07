#include "d2d_components.hpp"

#include "lunasvg_bridge.hpp"

#include <algorithm>
#include <cmath>
#include <cwchar>
#include <cwctype>
#include <fstream>
#include <sstream>

namespace volcano_d2d {

namespace {
std::wstring Trim(const std::wstring& text) {
    size_t first = 0;
    while (first < text.size() && iswspace(text[first])) ++first;
    size_t last = text.size();
    while (last > first && iswspace(text[last - 1])) --last;
    return text.substr(first, last - first);
}

int ToIntOrDefault(const std::wstring& text, int fallback) {
    try {
        return std::stoi(Trim(text));
    } catch (...) {
        return fallback;
    }
}

float ToFloatOrDefault(const std::wstring& text, float fallback) {
    try {
        return std::stof(Trim(text));
    } catch (...) {
        return fallback;
    }
}

Rect InsetD2DRect(Rect rect, float inset) {
    rect.left += inset;
    rect.top += inset;
    rect.right -= inset;
    rect.bottom -= inset;
    return rect;
}

bool IsUsableRect(Rect rect) {
    return rect.right > rect.left && rect.bottom > rect.top;
}

void FillRoundedBorder(Engine& engine, Rect outerRect, float outerRadius, float borderWidth, Color color) {
    if (borderWidth <= 0.0f || color.a <= 0.0f || !IsUsableRect(outerRect) || !engine.Factory()) return;

    Rect innerRect = InsetD2DRect(outerRect, borderWidth);
    if (!IsUsableRect(innerRect)) {
        engine.FillRoundedRectangle(outerRect, outerRadius, outerRadius, color);
        return;
    }

    ComPtr<ID2D1RoundedRectangleGeometry> outerGeometry;
    ComPtr<ID2D1RoundedRectangleGeometry> innerGeometry;
    ComPtr<ID2D1PathGeometry> borderGeometry;
    ComPtr<ID2D1GeometrySink> sink;
    ComPtr<ID2D1SolidColorBrush> brush;
    const float innerRadius = std::max(0.0f, outerRadius - borderWidth);

    if (FAILED(engine.CreateRoundedRectangleGeometry(outerRect, outerRadius, outerRadius, outerGeometry.GetAddressOf())) ||
        FAILED(engine.CreateRoundedRectangleGeometry(innerRect, innerRadius, innerRadius, innerGeometry.GetAddressOf())) ||
        FAILED(engine.Factory()->CreatePathGeometry(borderGeometry.GetAddressOf())) ||
        FAILED(borderGeometry->Open(sink.GetAddressOf())) ||
        FAILED(outerGeometry->CombineWithGeometry(innerGeometry.Get(), D2D1_COMBINE_MODE_EXCLUDE, nullptr,
            D2D1_DEFAULT_FLATTENING_TOLERANCE, sink.Get()))) {
        return;
    }
    if (FAILED(sink->Close()) || FAILED(engine.CreateSolidBrush(color, 1.0f, brush.GetAddressOf()))) return;

    engine.FillGeometry(borderGeometry.Get(), brush.Get());
}

bool EndsWithInsensitive(const std::wstring& text, const std::wstring& suffix) {
    if (text.size() < suffix.size()) return false;
    for (size_t i = 0; i < suffix.size(); ++i) {
        if (towlower(text[text.size() - suffix.size() + i]) != towlower(suffix[i])) return false;
    }
    return true;
}

float Clamp01(float value) {
    if (value < 0.0f) return 0.0f;
    if (value > 1.0f) return 1.0f;
    return value;
}

Color MixColor(Color from, Color to, float amount) {
    amount = Clamp01(amount);
    const float inv = 1.0f - amount;
    return MakeColor(
        from.r * inv + to.r * amount,
        from.g * inv + to.g * amount,
        from.b * inv + to.b * amount,
        from.a * inv + to.a * amount);
}

float PointsToDips(float points) {
    return points > 0.0f ? points * (96.0f / 72.0f) : points;
}

std::vector<unsigned char> ReadBinaryFile(const std::wstring& fileName) {
    std::ifstream file(fileName.c_str(), std::ios::binary);
    if (!file) return {};
    file.seekg(0, std::ios::end);
    const std::streamoff size = file.tellg();
    if (size <= 0) return {};
    file.seekg(0, std::ios::beg);
    std::vector<unsigned char> data(static_cast<size_t>(size));
    file.read(reinterpret_cast<char*>(data.data()), size);
    return data;
}

bool LooksLikeSvg(const void* data, int dataSize) {
    if (!data || dataSize <= 0) return false;
    const char* bytes = static_cast<const char*>(data);
    const int scan = std::min(dataSize, 512);
    for (int i = 0; i + 3 < scan; ++i) {
        if ((bytes[i] == '<') &&
            (bytes[i + 1] == 's' || bytes[i + 1] == 'S') &&
            (bytes[i + 2] == 'v' || bytes[i + 2] == 'V') &&
            (bytes[i + 3] == 'g' || bytes[i + 3] == 'G')) {
            return true;
        }
    }
    return false;
}

void ApplySvgTint(std::vector<unsigned char>& bgraPixels, Color tint) {
    const unsigned char r = static_cast<unsigned char>(Clamp01(tint.r) * 255.0f + 0.5f);
    const unsigned char g = static_cast<unsigned char>(Clamp01(tint.g) * 255.0f + 0.5f);
    const unsigned char b = static_cast<unsigned char>(Clamp01(tint.b) * 255.0f + 0.5f);
    const float alphaScale = Clamp01(tint.a);
    for (size_t i = 0; i + 3 < bgraPixels.size(); i += 4) {
        const unsigned char alpha = bgraPixels[i + 3];
        if (alpha == 0) continue;
        bgraPixels[i + 0] = b;
        bgraPixels[i + 1] = g;
        bgraPixels[i + 2] = r;
        bgraPixels[i + 3] = static_cast<unsigned char>(static_cast<float>(alpha) * alphaScale + 0.5f);
    }
}

float ParseFloatAt(const std::wstring& text, size_t& pos, float fallback = 0.0f) {
    while (pos < text.size() && (iswspace(text[pos]) || text[pos] == L',')) ++pos;
    const wchar_t* start = text.c_str() + pos;
    wchar_t* end = nullptr;
    const float value = std::wcstof(start, &end);
    if (end == start) return fallback;
    pos = static_cast<size_t>(end - text.c_str());
    return value;
}

Point MeasureTextSize(Engine& engine, const std::wstring& text, const std::wstring& fontFamily, float fontSize, int fontWeight, int fontStyle) {
    if (text.empty()) return MakePoint(0.0f, 0.0f);

    ComPtr<IDWriteTextFormat> format;
    if (FAILED(engine.CreateTextFormat(fontFamily.empty() ? L"Microsoft YaHei" : fontFamily.c_str(),
        fontSize, fontWeight, fontStyle, DWRITE_FONT_STRETCH_NORMAL, L"zh-cn", format.GetAddressOf()))) {
        return MakePoint(0.0f, fontSize * 1.35f);
    }
    format->SetWordWrapping(DWRITE_WORD_WRAPPING_NO_WRAP);

    ComPtr<IDWriteTextLayout> layout;
    if (FAILED(engine.CreateTextLayout(text.c_str(), format.Get(), 4096.0f, std::max(1.0f, fontSize * 2.0f), layout.GetAddressOf()))) {
        return MakePoint(0.0f, fontSize * 1.35f);
    }

    DWRITE_TEXT_METRICS metrics{};
    if (FAILED(layout->GetMetrics(&metrics))) {
        return MakePoint(0.0f, fontSize * 1.35f);
    }
    const float width = std::max(metrics.width, metrics.widthIncludingTrailingWhitespace);
    const float height = metrics.height > 0.0f ? metrics.height : fontSize * 1.35f;
    return MakePoint(width, height);
}
}  // namespace

UiComponent::UiComponent(Type type) : type_(type) {
    buttonNormalColor_ = MakeColor(0.09f, 0.32f, 0.46f, 1.0f);
    buttonHoverColor_ = MakeColor(0.08f, 0.38f, 0.53f, 1.0f);
    buttonPressedColor_ = MakeColor(0.04f, 0.24f, 0.34f, 1.0f);
    buttonDisabledColor_ = MakeColor(0.72f, 0.75f, 0.74f, 1.0f);
    buttonTextColor_ = MakeColor(1.0f, 1.0f, 1.0f, 1.0f);
    buttonDisabledTextColor_ = MakeColor(1.0f, 1.0f, 1.0f, 0.72f);
    buttonBorderColor_ = MakeColor(1.0f, 1.0f, 1.0f, 0.22f);
    buttonFocusColor_ = MakeColor(0.12f, 0.58f, 0.84f, 1.0f);
}

void UiComponent::SetValue(float value) {
    value_ = value;
    if (value_ < minimum_) value_ = minimum_;
    if (value_ > maximum_) value_ = maximum_;
}

void UiComponent::SetRange(float minimum, float maximum) {
    minimum_ = minimum;
    maximum_ = maximum > minimum ? maximum : minimum + 1.0f;
    SetValue(value_);
}

void UiComponent::SetButtonMetrics(float radius, float borderWidth) {
    buttonRadius_ = radius < 0.0f ? 0.0f : radius;
    buttonBorderWidth_ = borderWidth < 0.0f ? 0.0f : borderWidth;
}

void UiComponent::SetButtonFont(const std::wstring& family, float size, int weight) {
    buttonFontFamily_ = family.empty() ? L"Microsoft YaHei" : family;
    buttonFontSize_ = size > 0.0f ? PointsToDips(size) : 14.0f;
    buttonFontWeight_ = weight;
    buttonFontStyle_ = DWRITE_FONT_STYLE_NORMAL;
    buttonFontUnderline_ = false;
    buttonFontStrikeout_ = false;
    buttonFontRotationDegrees_ = 0.0f;
}

void UiComponent::SetButtonFontDescriptor(const std::wstring& descriptor) {
    std::vector<std::wstring> parts;
    std::wstringstream stream(descriptor);
    std::wstring part;
    while (std::getline(stream, part, L',')) {
        parts.push_back(Trim(part));
    }

    if (!parts.empty() && !parts[0].empty()) {
        buttonFontFamily_ = parts[0];
    }
    if (parts.size() > 1) {
        buttonFontSize_ = PointsToDips(ToFloatOrDefault(parts[1], buttonFontSize_ * (72.0f / 96.0f)));
        if (buttonFontSize_ <= 0.0f) buttonFontSize_ = 14.0f;
    }
    if (parts.size() > 2) {
        buttonFontWeight_ = ToIntOrDefault(parts[2], 0) != 0 ? DWRITE_FONT_WEIGHT_BOLD : DWRITE_FONT_WEIGHT_NORMAL;
    }
    if (parts.size() > 3) {
        buttonFontStyle_ = ToIntOrDefault(parts[3], 0) != 0 ? DWRITE_FONT_STYLE_ITALIC : DWRITE_FONT_STYLE_NORMAL;
    }
    if (parts.size() > 4) {
        buttonFontUnderline_ = ToIntOrDefault(parts[4], 0) != 0;
    }
    if (parts.size() > 5) {
        buttonFontStrikeout_ = ToIntOrDefault(parts[5], 0) != 0;
    }
    if (parts.size() > 6) {
        buttonFontRotationDegrees_ = static_cast<float>(ToFloatOrDefault(parts[6], 0.0f) / 10.0f);
    }
}

void UiComponent::SetButtonColors(Color normal, Color hover, Color pressed, Color disabled, Color text, Color disabledText, Color border) {
    buttonNormalColor_ = normal;
    buttonHoverColor_ = hover;
    buttonPressedColor_ = pressed;
    buttonDisabledColor_ = disabled;
    buttonTextColor_ = text;
    buttonDisabledTextColor_ = disabledText;
    buttonBorderColor_ = border;
    SetButtonStateColors(0, normal, true, text, true, border, true);
    SetButtonStateColors(1, hover, true, text, false, border, false);
    SetButtonStateColors(2, pressed, true, text, false, border, false);
    SetButtonStateColors(3, disabled, true, disabledText, true, border, false);
}

void UiComponent::SetButtonStateColors(int state, Color background, bool hasBackground, Color text, bool hasText, Color border, bool hasBorder) {
    if (state < 0 || state > 3) return;
    buttonStateBackground_[state] = background;
    buttonStateText_[state] = text;
    buttonStateBorder_[state] = border;
    buttonHasStateBackground_[state] = hasBackground;
    buttonHasStateText_[state] = hasText;
    buttonHasStateBorder_[state] = hasBorder;
}

void UiComponent::SetButtonLayout(float paddingX, float paddingY, float iconGap, int iconPosition, int contentAlign, bool autoWrap) {
    buttonPaddingX_ = paddingX < 0.0f ? 0.0f : paddingX;
    buttonPaddingY_ = paddingY < 0.0f ? 0.0f : paddingY;
    buttonIconGap_ = iconGap < 0.0f ? 0.0f : iconGap;
    buttonIconPosition_ = iconPosition < 0 ? 0 : (iconPosition > 3 ? 3 : iconPosition);
    buttonContentAlign_ = contentAlign < 0 ? 0 : (contentAlign > 2 ? 2 : contentAlign);
    buttonAutoWrap_ = autoWrap;
}

void UiComponent::SetButtonOptions(int style, bool toggle, bool focused, bool defaultButton, Color focusColor, float focusWidth) {
    buttonStyle_ = style < 0 ? 0 : (style > 4 ? 4 : style);
    buttonToggle_ = toggle;
    buttonFocused_ = focused;
    buttonDefault_ = defaultButton;
    buttonFocusColor_ = focusColor;
    buttonFocusWidth_ = focusWidth < 0.0f ? 0.0f : focusWidth;
}

void UiComponent::SetButtonEffects(float pressedOffset, float shadowOffsetX, float shadowOffsetY, float shadowOpacity, bool gradientHighlight, int verticalAlign) {
    buttonPressedOffset_ = pressedOffset < 0.0f ? 0.0f : pressedOffset;
    buttonShadowOffsetX_ = shadowOffsetX;
    buttonShadowOffsetY_ = shadowOffsetY;
    buttonShadowOpacity_ = Clamp01(shadowOpacity);
    buttonGradientHighlight_ = gradientHighlight;
    buttonVerticalAlign_ = verticalAlign < 0 ? 0 : (verticalAlign > 2 ? 2 : verticalAlign);
}

void UiComponent::ClearButtonIconCache() {
    for (int state = 0; state < 4; ++state) ClearButtonIconCache(state);
}

void UiComponent::ClearButtonIconCache(int state) {
    if (state < 0 || state > 3) return;
    buttonLoadedIconFileStates_[state].clear();
    buttonIconBitmapStates_[state].Reset();
    buttonIconIsSvgStates_[state] = false;
    buttonIconLoadAttemptedStates_[state] = false;
}

void UiComponent::SetButtonIcon(const std::wstring& fileName, float size, Color tint, bool useTint) {
    if (buttonIconFile_ != fileName) {
        buttonIconFile_ = fileName;
        buttonIconFileStates_[0] = fileName;
        buttonIconData_.clear();
        buttonIconDataStates_[0].clear();
        ClearButtonIconCache();
    }
    buttonIconSize_ = size < 0.0f ? 0.0f : size;
    buttonIconTint_ = tint;
    buttonUseIconTint_ = useTint;
}

void UiComponent::SetButtonIconData(const void* data, int dataSize, float size, Color tint, bool useTint) {
    buttonIconFile_.clear();
    const unsigned char* bytes = static_cast<const unsigned char*>(data);
    std::vector<unsigned char> next;
    if (bytes && dataSize > 0) next.assign(bytes, bytes + dataSize);
    if (buttonIconData_ != next) {
        buttonIconData_.swap(next);
        buttonIconDataStates_[0] = buttonIconData_;
        buttonIconFileStates_[0].clear();
        ClearButtonIconCache(0);
    }
    buttonIconSize_ = size < 0.0f ? 0.0f : size;
    buttonIconTint_ = tint;
    buttonUseIconTint_ = useTint;
}

void UiComponent::SetButtonStateIconData(int state, const void* data, int dataSize, float size, Color tint, bool useTint) {
    if (state < 0 || state > 3) return;
    const unsigned char* bytes = static_cast<const unsigned char*>(data);
    std::vector<unsigned char> next;
    if (bytes && dataSize > 0) next.assign(bytes, bytes + dataSize);
    if (buttonIconDataStates_[state] != next) {
        buttonIconDataStates_[state].swap(next);
        buttonIconFileStates_[state].clear();
        ClearButtonIconCache(state);
    }
    if (state == 0) {
        buttonIconData_ = buttonIconDataStates_[0];
        buttonIconFile_.clear();
    }
    buttonIconSize_ = size < 0.0f ? 0.0f : size;
    buttonIconTint_ = tint;
    buttonUseIconTint_ = useTint;
}

int UiComponent::ButtonVisualState() const {
    if (!enabled_) return 3;
    if (pressed_) return 2;
    if (hovered_) return 1;
    if (buttonToggle_ && checked_) return 2;
    return 0;
}

int UiComponent::ResolveIconState(int state) const {
    auto hasIcon = [this](int s) { return s >= 0 && s < 4 && (!buttonIconDataStates_[s].empty() || !buttonIconFileStates_[s].empty()); };
    if (hasIcon(state)) return state;
    if (state == 2 && hasIcon(1)) return 1;
    return hasIcon(0) ? 0 : -1;
}

Color UiComponent::ResolveBackgroundColor(int state) const {
    if (state >= 0 && state < 4 && buttonHasStateBackground_[state]) return buttonStateBackground_[state];
    if (state == 2 && buttonHasStateBackground_[1]) return buttonStateBackground_[1];
    if (buttonHasStateBackground_[0]) return buttonStateBackground_[0];
    if (state == 3) return buttonDisabledColor_;
    if (state == 2) return buttonPressedColor_;
    if (state == 1) return buttonHoverColor_;
    return buttonNormalColor_;
}

Color UiComponent::ResolveTextColor(int state) const {
    if (state >= 0 && state < 4 && buttonHasStateText_[state]) return buttonStateText_[state];
    if (state == 2 && buttonHasStateText_[1]) return buttonStateText_[1];
    if (buttonHasStateText_[0]) return buttonStateText_[0];
    return state == 3 ? buttonDisabledTextColor_ : buttonTextColor_;
}

Color UiComponent::ResolveBorderColor(int state) const {
    if (state >= 0 && state < 4 && buttonHasStateBorder_[state]) return buttonStateBorder_[state];
    if (state == 2 && buttonHasStateBorder_[1]) return buttonStateBorder_[1];
    if (buttonHasStateBorder_[0]) return buttonStateBorder_[0];
    return buttonBorderColor_;
}

bool UiComponent::EnsureButtonIcon(Engine& engine, int state) {
    const int iconState = ResolveIconState(state);
    if (iconState < 0) return false;
    auto& iconData = buttonIconDataStates_[iconState];
    auto& iconFile = buttonIconFileStates_[iconState];
    auto& loadedIconFile = buttonLoadedIconFileStates_[iconState];
    auto& iconBitmap = buttonIconBitmapStates_[iconState];
    auto& iconIsSvg = buttonIconIsSvgStates_[iconState];
    auto& iconLoadAttempted = buttonIconLoadAttemptedStates_[iconState];
    if (iconFile.empty() && iconData.empty()) return false;
    if (!iconData.empty()) {
        if (iconLoadAttempted && loadedIconFile == L":memory:") return iconBitmap;
        ClearButtonIconCache(iconState);
        loadedIconFile = L":memory:";
        iconLoadAttempted = true;
        if (LooksLikeSvg(iconData.data(), static_cast<int>(iconData.size()))) {
            std::vector<unsigned char> pixels;
            int width = 0;
            int height = 0;
            int stride = 0;
            const int desiredSize = std::max(32, static_cast<int>(std::ceil((buttonIconSize_ > 0.0f ? buttonIconSize_ : buttonFontSize_ * 1.35f) * 2.0f)));
            ID2D1Bitmap* bitmap = nullptr;
            if (RenderSvgToBgraBitmap(iconData.data(), static_cast<int>(iconData.size()), desiredSize, desiredSize, pixels, width, height, stride)) {
                if (buttonUseIconTint_) ApplySvgTint(pixels, buttonIconTint_);
            }
            if (!pixels.empty()
                && SUCCEEDED(engine.CreateBitmapFromBgra(width, height, pixels.data(), static_cast<UINT32>(stride), &bitmap)) && bitmap) {
                iconBitmap.Attach(bitmap);
                iconIsSvg = true;
                return true;
            }
            return false;
        }
        ID2D1Bitmap* bitmap = nullptr;
        if (SUCCEEDED(engine.LoadBitmapFromMemory(iconData.data(), static_cast<int>(iconData.size()), &bitmap)) && bitmap) {
            iconBitmap.Attach(bitmap);
            return true;
        }
        return false;
    }
    if (loadedIconFile == iconFile && iconBitmap) return true;
    if (iconLoadAttempted && loadedIconFile == iconFile) return false;

    ClearButtonIconCache(iconState);
    loadedIconFile = iconFile;
    iconLoadAttempted = true;
    iconIsSvg = EndsWithInsensitive(iconFile, L".svg");
    if (iconIsSvg) {
        std::vector<unsigned char> data = ReadBinaryFile(iconFile);
        std::vector<unsigned char> pixels;
        int width = 0;
        int height = 0;
        int stride = 0;
        const int desiredSize = std::max(32, static_cast<int>(std::ceil((buttonIconSize_ > 0.0f ? buttonIconSize_ : buttonFontSize_ * 1.35f) * 2.0f)));
        ID2D1Bitmap* bitmap = nullptr;
        if (!data.empty() && RenderSvgToBgraBitmap(data.data(), static_cast<int>(data.size()), desiredSize, desiredSize, pixels, width, height, stride)) {
            if (buttonUseIconTint_) ApplySvgTint(pixels, buttonIconTint_);
        }
        if (!pixels.empty()
            && SUCCEEDED(engine.CreateBitmapFromBgra(width, height, pixels.data(), static_cast<UINT32>(stride), &bitmap)) && bitmap) {
            iconBitmap.Attach(bitmap);
            return true;
        }
        return false;
    }
    ID2D1Bitmap* bitmap = nullptr;
    if (SUCCEEDED(engine.LoadBitmapFromFile(iconFile.c_str(), &bitmap)) && bitmap) {
        iconBitmap.Attach(bitmap);
        return true;
    }
    return false;
}

bool UiComponent::Hit(Point point) const {
    return visible_
        && point.x >= bounds_.left && point.x <= bounds_.right
        && point.y >= bounds_.top && point.y <= bounds_.bottom;
}

float UiComponent::NormalizedValue() const {
    const float span = maximum_ - minimum_;
    if (span <= 0.0f) return 0.0f;
    float ratio = (value_ - minimum_) / span;
    if (ratio < 0.0f) ratio = 0.0f;
    if (ratio > 1.0f) ratio = 1.0f;
    return ratio;
}

void UiComponent::DrawFrame(Engine& engine, Color fill, Color stroke, float radius) {
    engine.FillRoundedRectangle(bounds_, radius, radius, fill);
    engine.DrawRoundedRectangle(bounds_, radius, radius, stroke, 1.0f);
}

void UiComponent::Draw(Engine& engine) {
    if (!visible_) return;

    switch (type_) {
    case Panel:
        DrawFrame(engine, MakeColor(1.0f, 1.0f, 1.0f, 0.76f), MakeColor(0.64f, 0.68f, 0.66f, 1.0f), 8.0f);
        if (!text_.empty()) {
            engine.DrawTextSimple(text_.c_str(), MakeRect(bounds_.left + 14.0f, bounds_.top + 10.0f, bounds_.right - 14.0f, bounds_.top + 36.0f),
                MakeColor(0.10f, 0.14f, 0.16f, 1.0f), L"Microsoft YaHei", 15.0f, DWRITE_FONT_WEIGHT_SEMI_BOLD, DWRITE_FONT_STYLE_NORMAL,
                DWRITE_TEXT_ALIGNMENT_LEADING, DWRITE_PARAGRAPH_ALIGNMENT_CENTER);
        }
        break;
    case Button: {
        const int visualState = ButtonVisualState();
        Color fill = ResolveBackgroundColor(visualState);
        Color textColor = ResolveTextColor(visualState);
        Color borderColor = ResolveBorderColor(visualState);
        if (buttonStyle_ == 1) {
            fill.a *= visualState == 0 ? 0.16f : 0.24f;
            textColor = ResolveBackgroundColor(visualState);
            borderColor = ResolveBackgroundColor(visualState);
        } else if (buttonStyle_ == 2) {
            fill.a = visualState == 0 ? 0.0f : 0.10f;
            textColor = ResolveBackgroundColor(visualState);
            borderColor = ResolveBackgroundColor(visualState);
        } else if (buttonStyle_ == 3) {
            fill.a = visualState == 0 ? 0.0f : 0.10f;
            textColor = ResolveBackgroundColor(visualState);
            borderColor.a = 0.0f;
        } else if (buttonStyle_ == 4 && !buttonHasStateBackground_[0]) {
            fill = visualState == 2 ? MakeColor(0.50f, 0.08f, 0.08f, 1.0f)
                 : visualState == 1 ? MakeColor(0.86f, 0.21f, 0.21f, 1.0f)
                 : visualState == 3 ? buttonDisabledColor_
                 : MakeColor(0.72f, 0.16f, 0.16f, 1.0f);
            textColor = visualState == 3 ? buttonDisabledTextColor_ : MakeColor(1.0f, 1.0f, 1.0f, 1.0f);
            borderColor = MakeColor(1.0f, 1.0f, 1.0f, 0.20f);
        }
        if (buttonShadowOpacity_ > 0.0f && (buttonShadowOffsetX_ != 0.0f || buttonShadowOffsetY_ != 0.0f) && fill.a > 0.0f) {
            Rect shadowRect = MakeRect(bounds_.left + buttonShadowOffsetX_, bounds_.top + buttonShadowOffsetY_,
                                       bounds_.right + buttonShadowOffsetX_, bounds_.bottom + buttonShadowOffsetY_);
            engine.FillRoundedRectangle(shadowRect, buttonRadius_, buttonRadius_,
                MakeColor(0.0f, 0.0f, 0.0f, buttonShadowOpacity_ * (enabled_ ? 1.0f : 0.45f)));
        }
        const float effectiveBorderWidth = std::max(buttonBorderWidth_, (buttonStyle_ == 2 || buttonDefault_) ? 1.0f : 0.0f);
        const float paintedBorderWidth = borderColor.a > 0.0f ? effectiveBorderWidth : 0.0f;
        if (IsUsableRect(bounds_) && buttonGradientHighlight_ && fill.a > 0.0f) {
            GradientStop stops[2];
            stops[0].position = 0.0f;
            stops[0].color = MixColor(fill, MakeColor(1.0f, 1.0f, 1.0f, fill.a), 0.22f);
            stops[1].position = 1.0f;
            stops[1].color = MixColor(fill, MakeColor(0.0f, 0.0f, 0.0f, fill.a), visualState == 2 ? 0.10f : 0.03f);
            ComPtr<ID2D1LinearGradientBrush> gradient;
            if (SUCCEEDED(engine.CreateLinearGradientBrush(MakePoint(bounds_.left, bounds_.top), MakePoint(bounds_.left, bounds_.bottom), stops, 2, gradient.GetAddressOf())) && gradient) {
                engine.FillRoundedRectByBrush(bounds_, buttonRadius_, buttonRadius_, gradient.Get());
            } else {
                engine.FillRoundedRectangle(bounds_, buttonRadius_, buttonRadius_, fill);
            }
        } else if (IsUsableRect(bounds_) && fill.a > 0.0f) {
            engine.FillRoundedRectangle(bounds_, buttonRadius_, buttonRadius_, fill);
        }
        if (paintedBorderWidth > 0.0f) {
            FillRoundedBorder(engine, bounds_, buttonRadius_, paintedBorderWidth, borderColor);
        }
        if ((buttonFocused_ || buttonDefault_) && buttonFocusWidth_ > 0.0f) {
            const float inset = buttonFocusWidth_ * 0.5f + 2.0f;
            Rect focusRect = MakeRect(bounds_.left + inset, bounds_.top + inset, bounds_.right - inset, bounds_.bottom - inset);
            if (focusRect.right > focusRect.left && focusRect.bottom > focusRect.top) {
                const float focusRadius = std::max(0.0f, buttonRadius_ - inset);
                engine.DrawRoundedRectangle(focusRect, focusRadius, focusRadius, buttonFocusColor_, buttonFocusWidth_);
            }
        }
        Rect contentRect = MakeRect(bounds_.left + buttonPaddingX_ + effectiveBorderWidth,
                                    bounds_.top + buttonPaddingY_ + effectiveBorderWidth,
                                    bounds_.right - buttonPaddingX_ - effectiveBorderWidth,
                                    bounds_.bottom - buttonPaddingY_ - effectiveBorderWidth);
        if (pressed_ && buttonPressedOffset_ > 0.0f) {
            contentRect.left += buttonPressedOffset_;
            contentRect.top += buttonPressedOffset_;
            contentRect.right += buttonPressedOffset_;
            contentRect.bottom += buttonPressedOffset_;
        }
        const bool hasIcon = EnsureButtonIcon(engine, visualState);
        const int iconState = ResolveIconState(visualState);
        ID2D1Bitmap* iconBitmap = iconState >= 0 ? buttonIconBitmapStates_[iconState].Get() : nullptr;
        const bool hasText = !text_.empty();
        const float contentWidth = std::max(0.0f, contentRect.right - contentRect.left);
        const float contentHeight = std::max(0.0f, contentRect.bottom - contentRect.top);
        const float autoIconSize = std::max(1.0f, std::min(contentHeight, buttonFontSize_ * 1.35f));
        const float iconSize = hasIcon ? (buttonIconSize_ > 0.0f ? buttonIconSize_ : autoIconSize) : 0.0f;
        const Point measuredText = MeasureTextSize(engine, text_, buttonFontFamily_, buttonFontSize_, buttonFontWeight_, buttonFontStyle_);
        const float textHeight = hasText ? std::min(contentHeight, std::max(1.0f, measuredText.y)) : 0.0f;
        int textAlignment = DWRITE_TEXT_ALIGNMENT_CENTER;
        Rect iconRect{};
        Rect textRect = contentRect;
        if (hasIcon) {
            if (buttonIconPosition_ == 0 || buttonIconPosition_ == 1) {
                const float gap = hasText ? buttonIconGap_ : 0.0f;
                const float layoutIconSize = std::min(iconSize, contentWidth);
                const float maxTextWidth = std::max(0.0f, contentWidth - layoutIconSize - gap);
                const float measuredTextWidth = hasText ? std::max(1.0f, std::ceil(measuredText.x) + 2.0f) : 0.0f;
                const float desiredTextWidth = hasText ? std::min(maxTextWidth, measuredTextWidth) : 0.0f;
                const bool drawText = desiredTextWidth > 0.5f;
                const float textWidth = drawText ? desiredTextWidth : 0.0f;
                const float usedGap = drawText ? gap : 0.0f;
                const float totalWidth = std::min(contentWidth, layoutIconSize + usedGap + textWidth);
                float groupLeft = contentRect.left;
                if (buttonContentAlign_ == 0) groupLeft = contentRect.left + std::max(0.0f, contentWidth - totalWidth) * 0.5f;
                if (buttonContentAlign_ == 2) groupLeft = contentRect.right - totalWidth;
                float top = contentRect.top + (contentHeight - layoutIconSize) * 0.5f;
                if (buttonVerticalAlign_ == 1) top = contentRect.top;
                if (buttonVerticalAlign_ == 2) top = contentRect.bottom - layoutIconSize;
                if (buttonIconPosition_ == 0) {
                    iconRect = MakeRect(groupLeft, top, groupLeft + layoutIconSize, top + layoutIconSize);
                    textRect = MakeRect(iconRect.right + usedGap, contentRect.top, iconRect.right + usedGap + textWidth, contentRect.bottom);
                    textAlignment = buttonAutoWrap_ ? (buttonContentAlign_ == 2 ? DWRITE_TEXT_ALIGNMENT_TRAILING : buttonContentAlign_ == 1 ? DWRITE_TEXT_ALIGNMENT_LEADING : DWRITE_TEXT_ALIGNMENT_CENTER) : DWRITE_TEXT_ALIGNMENT_LEADING;
                } else {
                    textRect = MakeRect(groupLeft, contentRect.top, groupLeft + textWidth, contentRect.bottom);
                    iconRect = MakeRect(textRect.right + usedGap, top, textRect.right + usedGap + layoutIconSize, top + layoutIconSize);
                    textAlignment = buttonAutoWrap_ ? (buttonContentAlign_ == 2 ? DWRITE_TEXT_ALIGNMENT_TRAILING : buttonContentAlign_ == 1 ? DWRITE_TEXT_ALIGNMENT_LEADING : DWRITE_TEXT_ALIGNMENT_CENTER) : DWRITE_TEXT_ALIGNMENT_TRAILING;
                }
            } else {
                const float gap = hasText ? buttonIconGap_ : 0.0f;
                const float layoutIconSize = std::min(iconSize, std::min(contentWidth, contentHeight));
                const float maxTextHeight = std::max(0.0f, contentHeight - layoutIconSize - gap);
                const float layoutTextHeight = hasText ? std::min(textHeight, maxTextHeight) : 0.0f;
                const bool drawText = layoutTextHeight > 0.5f;
                const float usedGap = drawText ? gap : 0.0f;
                const float totalHeight = std::min(contentHeight, layoutIconSize + usedGap + (drawText ? layoutTextHeight : 0.0f));
                const float groupWidth = std::min(contentWidth, std::max(iconSize, hasText ? std::ceil(measuredText.x) + 2.0f : 0.0f));
                float groupLeft = contentRect.left;
                if (buttonContentAlign_ == 0) groupLeft = contentRect.left + std::max(0.0f, contentWidth - groupWidth) * 0.5f;
                if (buttonContentAlign_ == 2) groupLeft = contentRect.right - groupWidth;
                float top = contentRect.top + std::max(0.0f, contentHeight - totalHeight) * 0.5f;
                if (buttonVerticalAlign_ == 1) top = contentRect.top;
                if (buttonVerticalAlign_ == 2) top = contentRect.bottom - totalHeight;
                const float iconLeft = groupLeft + std::max(0.0f, groupWidth - layoutIconSize) * 0.5f;
                const float textWidth = drawText ? groupWidth : 0.0f;
                const float textLeft = groupLeft + std::max(0.0f, groupWidth - textWidth) * 0.5f;
                if (buttonIconPosition_ == 2) {
                    iconRect = MakeRect(iconLeft, top, iconLeft + layoutIconSize, top + layoutIconSize);
                    textRect = MakeRect(textLeft, iconRect.bottom + usedGap, textLeft + textWidth, iconRect.bottom + usedGap + (drawText ? layoutTextHeight : 0.0f));
                } else {
                    textRect = MakeRect(textLeft, top, textLeft + textWidth, top + (drawText ? layoutTextHeight : 0.0f));
                    iconRect = MakeRect(iconLeft, textRect.bottom + usedGap, iconLeft + layoutIconSize, textRect.bottom + usedGap + layoutIconSize);
                }
            }
            if (iconBitmap) {
                engine.DrawBitmap(iconBitmap, iconRect, enabled_ ? 1.0f : 0.55f, D2D1_BITMAP_INTERPOLATION_MODE_LINEAR, MakeRect(0, 0, 0, 0));
            }
        } else if (hasText) {
            const float textWidth = std::min(contentWidth, std::max(1.0f, std::ceil(measuredText.x) + 2.0f));
            float textLeft = contentRect.left;
            if (buttonContentAlign_ == 0) textLeft = contentRect.left + std::max(0.0f, contentWidth - textWidth) * 0.5f;
            if (buttonContentAlign_ == 2) textLeft = contentRect.right - textWidth;
            float textTop = contentRect.top;
            float textBottom = contentRect.bottom;
            if (!buttonAutoWrap_) {
                const float clampedTextHeight = std::min(contentHeight, std::max(1.0f, measuredText.y));
                textTop = contentRect.top + std::max(0.0f, contentHeight - clampedTextHeight) * 0.5f;
                if (buttonVerticalAlign_ == 1) textTop = contentRect.top;
                if (buttonVerticalAlign_ == 2) textTop = contentRect.bottom - clampedTextHeight;
                textBottom = textTop + clampedTextHeight;
            }
            textRect = MakeRect(textLeft, textTop, textLeft + textWidth, textBottom);
            textAlignment = buttonContentAlign_ == 2 ? DWRITE_TEXT_ALIGNMENT_TRAILING : buttonContentAlign_ == 1 ? DWRITE_TEXT_ALIGNMENT_LEADING : DWRITE_TEXT_ALIGNMENT_CENTER;
        }
        if (hasText && textRect.right - textRect.left > 0.5f && textRect.bottom - textRect.top > 0.5f) {
            engine.DrawTextDecorated(text_.c_str(), textRect, textColor, buttonFontFamily_.c_str(), buttonFontSize_, buttonFontWeight_,
                buttonFontStyle_, buttonFontUnderline_, buttonFontStrikeout_, buttonFontRotationDegrees_, textAlignment, DWRITE_PARAGRAPH_ALIGNMENT_CENTER, buttonAutoWrap_);
        }
        break;
    }
    case TextBlock:
        engine.DrawTextSimple(text_.c_str(), bounds_, MakeColor(0.10f, 0.14f, 0.16f, enabled_ ? 1.0f : 0.55f),
            L"Microsoft YaHei", 14.0f, DWRITE_FONT_WEIGHT_NORMAL, DWRITE_FONT_STYLE_NORMAL,
            DWRITE_TEXT_ALIGNMENT_LEADING, DWRITE_PARAGRAPH_ALIGNMENT_NEAR);
        break;
    case ProgressBar: {
        DrawFrame(engine, MakeColor(0.89f, 0.92f, 0.91f, 1.0f), MakeColor(0.62f, 0.67f, 0.65f, 1.0f), 7.0f);
        Rect fill = bounds_;
        fill.right = fill.left + (bounds_.right - bounds_.left) * NormalizedValue();
        if (fill.right > fill.left) {
            engine.FillRoundedRectangle(fill, 7.0f, 7.0f, MakeColor(0.20f, 0.58f, 0.38f, 1.0f));
        }
        break;
    }
    case CheckBox: {
        Rect box = MakeRect(bounds_.left, bounds_.top + 3.0f, bounds_.left + 20.0f, bounds_.top + 23.0f);
        engine.FillRoundedRectangle(box, 4.0f, 4.0f, MakeColor(1.0f, 1.0f, 1.0f, 1.0f));
        engine.DrawRoundedRectangle(box, 4.0f, 4.0f, MakeColor(0.30f, 0.42f, 0.45f, 1.0f), 1.4f);
        if (checked_) {
            engine.DrawLine(MakePoint(box.left + 4.0f, box.top + 10.0f), MakePoint(box.left + 9.0f, box.bottom - 5.0f), MakeColor(0.07f, 0.42f, 0.30f, 1.0f), 2.6f);
            engine.DrawLine(MakePoint(box.left + 9.0f, box.bottom - 5.0f), MakePoint(box.right - 4.0f, box.top + 5.0f), MakeColor(0.07f, 0.42f, 0.30f, 1.0f), 2.6f);
        }
        engine.DrawTextSimple(text_.c_str(), MakeRect(bounds_.left + 28.0f, bounds_.top, bounds_.right, bounds_.bottom),
            MakeColor(0.10f, 0.14f, 0.16f, 1.0f), L"Microsoft YaHei", 14.0f, DWRITE_FONT_WEIGHT_NORMAL,
            DWRITE_FONT_STYLE_NORMAL, DWRITE_TEXT_ALIGNMENT_LEADING, DWRITE_PARAGRAPH_ALIGNMENT_CENTER);
        break;
    }
    case Slider: {
        const float cy = (bounds_.top + bounds_.bottom) * 0.5f;
        engine.DrawLine(MakePoint(bounds_.left, cy), MakePoint(bounds_.right, cy), MakeColor(0.72f, 0.76f, 0.74f, 1.0f), 5.0f);
        const float x = bounds_.left + (bounds_.right - bounds_.left) * NormalizedValue();
        engine.DrawLine(MakePoint(bounds_.left, cy), MakePoint(x, cy), MakeColor(0.15f, 0.52f, 0.70f, 1.0f), 5.0f);
        engine.FillEllipse(MakePoint(x, cy), pressed_ ? 8.5f : 7.0f, pressed_ ? 8.5f : 7.0f, MakeColor(1.0f, 1.0f, 1.0f, 1.0f));
        engine.DrawEllipse(MakePoint(x, cy), pressed_ ? 8.5f : 7.0f, pressed_ ? 8.5f : 7.0f, MakeColor(0.10f, 0.34f, 0.48f, 1.0f), 1.6f);
        break;
    }
    case TabBar: {
        const int tabCount = 4;
        const float width = (bounds_.right - bounds_.left) / tabCount;
        const int selectedIndex = selectedIndex_ < 0 ? 0 : (selectedIndex_ >= tabCount ? tabCount - 1 : selectedIndex_);
        for (int i = 0; i < tabCount; ++i) {
            Rect tab = MakeRect(bounds_.left + width * i + 2.0f, bounds_.top, bounds_.left + width * (i + 1) - 2.0f, bounds_.bottom);
            const bool selected = i == selectedIndex;
            engine.FillRoundedRectangle(tab, 7.0f, 7.0f, selected ? MakeColor(0.08f, 0.34f, 0.50f, 1.0f) : MakeColor(1.0f, 1.0f, 1.0f, 0.72f));
            engine.DrawRoundedRectangle(tab, 7.0f, 7.0f, MakeColor(0.58f, 0.64f, 0.62f, 1.0f), 1.0f);
            std::wstring label = L"Tab ";
            label += std::to_wstring(i + 1);
            engine.DrawTextSimple(label.c_str(), MakeRect(tab.left + 6.0f, tab.top, tab.right - 6.0f, tab.bottom),
                selected ? MakeColor(1.0f, 1.0f, 1.0f, 1.0f) : MakeColor(0.10f, 0.14f, 0.16f, 1.0f),
                L"Microsoft YaHei", 13.0f, selected ? DWRITE_FONT_WEIGHT_SEMI_BOLD : DWRITE_FONT_WEIGHT_NORMAL,
                DWRITE_FONT_STYLE_NORMAL, DWRITE_TEXT_ALIGNMENT_CENTER, DWRITE_PARAGRAPH_ALIGNMENT_CENTER);
        }
        break;
    }
    default:
        break;
    }
}

bool UiComponent::OnMouse(Engine& engine, int x, int y, int eventType) {
    if (!visible_ || !enabled_) return false;
    Point point = MakePoint(static_cast<float>(x), static_cast<float>(y));
    const bool hit = Hit(point);
    if (eventType == MOUSE_MOVE) {
        bool changed = hovered_ != hit;
        hovered_ = hit;
        if (pressed_ && type_ == Slider) {
            SetValue(minimum_ + ((point.x - bounds_.left) / (bounds_.right - bounds_.left)) * (maximum_ - minimum_));
            changed = true;
        }
        if (changed) engine.Invalidate(false);
        return hit || pressed_;
    }
    if (eventType == MOUSE_DOWN && hit) {
        pressed_ = true;
        if (type_ == CheckBox) checked_ = !checked_;
        if (type_ == Slider) SetValue(minimum_ + ((point.x - bounds_.left) / (bounds_.right - bounds_.left)) * (maximum_ - minimum_));
        if (type_ == TabBar) {
            const int tabCount = 4;
            const float width = (bounds_.right - bounds_.left) / tabCount;
            int index = static_cast<int>((point.x - bounds_.left) / width);
            if (index < 0) index = 0;
            if (index >= tabCount) index = tabCount - 1;
            selectedIndex_ = index;
        }
        engine.Invalidate(false);
        return true;
    }
    if (eventType == MOUSE_UP) {
        const bool handled = pressed_;
        const bool clicked = pressed_ && hit;
        pressed_ = false;
        if (clicked && type_ == Button && buttonToggle_) checked_ = !checked_;
        if (handled) engine.Invalidate(false);
        if (type_ == Button || type_ == CheckBox) return clicked;
        return handled;
    }
    if (eventType == MOUSE_LEAVE) {
        const bool changed = hovered_ || pressed_;
        hovered_ = false;
        pressed_ = false;
        if (changed) engine.Invalidate(false);
        return changed;
    }
    return hit;
}

bool UiComponent::OnKey(Engine& engine, int eventType, int keyCode) {
    if (!visible_ || !enabled_) return false;
    if (eventType == KEY_FOCUS) {
        buttonFocused_ = true;
        engine.Invalidate(false);
        return true;
    }
    if (eventType == KEY_BLUR) {
        const bool changed = buttonFocused_ || pressed_;
        buttonFocused_ = false;
        pressed_ = false;
        if (changed) engine.Invalidate(false);
        return changed;
    }
    if (type_ != Button) return false;
    const bool activateKey = keyCode == VK_SPACE || keyCode == VK_RETURN;
    if (!activateKey) return false;
    if (eventType == KEY_DOWN) {
        if (!pressed_) {
            pressed_ = true;
            engine.Invalidate(false);
        }
        return false;
    }
    if (eventType == KEY_UP) {
        const bool clicked = pressed_ || keyCode == VK_RETURN;
        pressed_ = false;
        if (clicked && buttonToggle_) checked_ = !checked_;
        engine.Invalidate(false);
        return clicked;
    }
    return false;
}

UiContainer::UiContainer() : UiComponent(Panel) {}

UiContainer::~UiContainer() {
    Clear();
}

void UiContainer::Add(UiComponent* child) {
    if (child) children_.push_back(child);
}

void UiContainer::Clear() {
    for (UiComponent* child : children_) delete child;
    children_.clear();
}

void UiContainer::Draw(Engine& engine) {
    for (UiComponent* child : children_) {
        if (child) child->Draw(engine);
    }
}

bool UiContainer::OnMouse(Engine& engine, int x, int y, int eventType) {
    for (auto it = children_.rbegin(); it != children_.rend(); ++it) {
        if (*it && (*it)->OnMouse(engine, x, y, eventType)) return true;
    }
    return false;
}

UiComponent* CreateUiComponent(int type) {
    switch (type) {
    case UiComponent::Panel:
    case UiComponent::Button:
    case UiComponent::TextBlock:
    case UiComponent::ProgressBar:
    case UiComponent::CheckBox:
    case UiComponent::Slider:
    case UiComponent::TabBar:
        return new UiComponent(static_cast<UiComponent::Type>(type));
    default:
        return nullptr;
    }
}

UiContainer* CreateUiContainer() {
    return new UiContainer();
}

void DestroyUiComponent(UiComponent* component) {
    delete component;
}

void UiAddChild(UiContainer* container, UiComponent* child) {
    if (container) container->Add(child);
}

void UiClearChildren(UiContainer* container) {
    if (container) container->Clear();
}

void UiSetBounds(UiComponent* component, Rect bounds) {
    if (component) component->SetBounds(bounds);
}

void UiSetPixelBounds(Engine& engine, UiComponent* component, Rect bounds) {
    if (!component) return;
    float dpiX = 96.0f;
    float dpiY = 96.0f;
    if (engine.Target()) engine.Target()->GetDpi(&dpiX, &dpiY);
    if (dpiX <= 0.0f) dpiX = 96.0f;
    if (dpiY <= 0.0f) dpiY = 96.0f;
    component->SetBounds(MakeRect(
        bounds.left * 96.0f / dpiX,
        bounds.top * 96.0f / dpiY,
        bounds.right * 96.0f / dpiX,
        bounds.bottom * 96.0f / dpiY));
}

void UiSetText(UiComponent* component, const wchar_t* text) {
    if (component) component->SetText(text ? text : L"");
}

void UiSetValue(UiComponent* component, float value) {
    if (component) component->SetValue(value);
}

void UiSetRange(UiComponent* component, float minimum, float maximum) {
    if (component) component->SetRange(minimum, maximum);
}

void UiSetEnabled(UiComponent* component, bool enabled) {
    if (component) component->SetEnabled(enabled);
}

void UiSetVisible(UiComponent* component, bool visible) {
    if (component) component->SetVisible(visible);
}

void UiSetChecked(UiComponent* component, bool checked) {
    if (component) component->SetChecked(checked);
}

void UiSetSelectedIndex(UiComponent* component, int index) {
    if (component) component->SetSelectedIndex(index);
}

void UiSetButtonMetrics(UiComponent* component, float radius, float borderWidth) {
    if (component) component->SetButtonMetrics(radius, borderWidth);
}

void UiSetButtonFont(UiComponent* component, const wchar_t* family, float size, int weight) {
    if (component) component->SetButtonFont(family ? family : L"", size, weight);
}

void UiSetButtonFontDescriptor(UiComponent* component, const wchar_t* descriptor) {
    if (component) component->SetButtonFontDescriptor(descriptor ? descriptor : L"");
}

void UiSetButtonColors(UiComponent* component, Color normal, Color hover, Color pressed, Color disabled, Color text, Color disabledText, Color border) {
    if (component) component->SetButtonColors(normal, hover, pressed, disabled, text, disabledText, border);
}

void UiSetButtonStateColors(UiComponent* component, int state, Color background, bool hasBackground, Color text, bool hasText, Color border, bool hasBorder) {
    if (component) component->SetButtonStateColors(state, background, hasBackground, text, hasText, border, hasBorder);
}

void UiSetButtonLayout(UiComponent* component, float paddingX, float paddingY, float iconGap, int iconPosition, int contentAlign, bool autoWrap) {
    if (component) component->SetButtonLayout(paddingX, paddingY, iconGap, iconPosition, contentAlign, autoWrap);
}

void UiSetButtonOptions(UiComponent* component, int style, bool toggle, bool focused, bool defaultButton, Color focusColor, float focusWidth) {
    if (component) component->SetButtonOptions(style, toggle, focused, defaultButton, focusColor, focusWidth);
}

void UiSetButtonEffects(UiComponent* component, float pressedOffset, float shadowOffsetX, float shadowOffsetY, float shadowOpacity, bool gradientHighlight, int verticalAlign) {
    if (component) component->SetButtonEffects(pressedOffset, shadowOffsetX, shadowOffsetY, shadowOpacity, gradientHighlight, verticalAlign);
}

void UiSetButtonIcon(UiComponent* component, const wchar_t* fileName, float size, Color tint, bool useTint) {
    if (component) component->SetButtonIcon(fileName ? fileName : L"", size, tint, useTint);
}

void UiSetButtonIconData(UiComponent* component, const void* data, int dataSize, float size, Color tint, bool useTint) {
    if (component) component->SetButtonIconData(data, dataSize, size, tint, useTint);
}

void UiSetButtonStateIconData(UiComponent* component, int state, const void* data, int dataSize, float size, Color tint, bool useTint) {
    if (component) component->SetButtonStateIconData(state, data, dataSize, size, tint, useTint);
}

int UiSelectedIndex(UiComponent* component) {
    return component ? component->selectedIndex() : -1;
}

bool UiChecked(UiComponent* component) {
    return component ? component->checked() : false;
}

float UiValue(UiComponent* component) {
    return component ? component->value() : 0.0f;
}

void UiDraw(Engine& engine, UiComponent* component) {
    if (component) component->Draw(engine);
}

bool UiMouseEvent(Engine& engine, UiComponent* component, int x, int y, int eventType) {
    return component ? component->OnMouse(engine, x, y, eventType) : false;
}

bool UiKeyEvent(Engine& engine, UiComponent* component, int eventType, int keyCode) {
    return component ? component->OnKey(engine, eventType, keyCode) : false;
}

}  // namespace volcano_d2d
