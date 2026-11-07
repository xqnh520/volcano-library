#pragma once

#include "d2d_engine.hpp"

namespace volcano_d2d {

class UiComponent {
public:
    enum Type {
        Panel = 1,
        Button = 2,
        TextBlock = 3,
        ProgressBar = 4,
        CheckBox = 5,
        Slider = 6,
        TabBar = 7
    };

    explicit UiComponent(Type type);
    virtual ~UiComponent() = default;

    Type type() const { return type_; }
    Rect bounds() const { return bounds_; }
    void SetBounds(Rect bounds) { bounds_ = bounds; }
    void SetText(const std::wstring& text) { text_ = text; }
    void SetValue(float value);
    void SetRange(float minimum, float maximum);
    void SetEnabled(bool enabled) { enabled_ = enabled; }
    void SetVisible(bool visible) { visible_ = visible; }
    void SetChecked(bool checked) { checked_ = checked; }
    void SetSelectedIndex(int index) { selectedIndex_ = index; }
    void SetButtonMetrics(float radius, float borderWidth);
    void SetButtonFont(const std::wstring& family, float size, int weight);
    void SetButtonFontDescriptor(const std::wstring& descriptor);
    void SetButtonColors(Color normal, Color hover, Color pressed, Color disabled, Color text, Color disabledText, Color border);
    void SetButtonStateColors(int state, Color background, bool hasBackground, Color text, bool hasText, Color border, bool hasBorder);
    void SetButtonLayout(float paddingX, float paddingY, float iconGap, int iconPosition, int contentAlign, bool autoWrap);
    void SetButtonOptions(int style, bool toggle, bool focused, bool defaultButton, Color focusColor, float focusWidth);
    void SetButtonEffects(float pressedOffset, float shadowOffsetX, float shadowOffsetY, float shadowOpacity, bool gradientHighlight, int verticalAlign);
    void SetButtonIcon(const std::wstring& fileName, float size, Color tint, bool useTint);
    void SetButtonIconData(const void* data, int dataSize, float size, Color tint, bool useTint);
    void SetButtonStateIconData(int state, const void* data, int dataSize, float size, Color tint, bool useTint);
    int selectedIndex() const { return selectedIndex_; }
    bool checked() const { return checked_; }
    float value() const { return value_; }
    bool Hit(Point point) const;

    virtual void Draw(Engine& engine);
    virtual bool OnMouse(Engine& engine, int x, int y, int eventType);
    virtual bool OnKey(Engine& engine, int eventType, int keyCode);

protected:
    void DrawFrame(Engine& engine, Color fill, Color stroke, float radius);
    bool EnsureButtonIcon(Engine& engine, int state);
    void ClearButtonIconCache();
    void ClearButtonIconCache(int state);
    int ButtonVisualState() const;
    int ResolveIconState(int state) const;
    Color ResolveBackgroundColor(int state) const;
    Color ResolveTextColor(int state) const;
    Color ResolveBorderColor(int state) const;
    float NormalizedValue() const;
    Type type_;
    Rect bounds_;
    std::wstring text_;
    float value_ = 0.0f;
    float minimum_ = 0.0f;
    float maximum_ = 100.0f;
    bool enabled_ = true;
    bool visible_ = true;
    bool hovered_ = false;
    bool pressed_ = false;
    bool checked_ = false;
    int selectedIndex_ = 0;
    float buttonRadius_ = 8.0f;
    float buttonBorderWidth_ = 0.0f;
    std::wstring buttonFontFamily_ = L"Microsoft YaHei";
    float buttonFontSize_ = 14.0f;
    int buttonFontWeight_ = DWRITE_FONT_WEIGHT_SEMI_BOLD;
    int buttonFontStyle_ = DWRITE_FONT_STYLE_NORMAL;
    bool buttonFontUnderline_ = false;
    bool buttonFontStrikeout_ = false;
    float buttonFontRotationDegrees_ = 0.0f;
    Color buttonNormalColor_;
    Color buttonHoverColor_;
    Color buttonPressedColor_;
    Color buttonDisabledColor_;
    Color buttonTextColor_;
    Color buttonDisabledTextColor_;
    Color buttonBorderColor_;
    Color buttonStateBackground_[4]{};
    Color buttonStateText_[4]{};
    Color buttonStateBorder_[4]{};
    bool buttonHasStateBackground_[4]{};
    bool buttonHasStateText_[4]{};
    bool buttonHasStateBorder_[4]{};
    float buttonPaddingX_ = 12.0f;
    float buttonPaddingY_ = 6.0f;
    float buttonIconGap_ = 6.0f;
    float buttonIconSize_ = 0.0f;
    int buttonIconPosition_ = 0;
    int buttonContentAlign_ = 0;
    bool buttonAutoWrap_ = false;
    int buttonStyle_ = 0;
    bool buttonToggle_ = false;
    bool buttonFocused_ = false;
    bool buttonDefault_ = false;
    Color buttonFocusColor_;
    float buttonFocusWidth_ = 2.0f;
    float buttonPressedOffset_ = 1.0f;
    float buttonShadowOffsetX_ = 0.0f;
    float buttonShadowOffsetY_ = 0.0f;
    float buttonShadowOpacity_ = 0.0f;
    bool buttonGradientHighlight_ = false;
    int buttonVerticalAlign_ = 0;
    std::wstring buttonIconFile_;
    std::vector<unsigned char> buttonIconData_;
    Color buttonIconTint_;
    bool buttonUseIconTint_ = false;
    std::wstring buttonIconFileStates_[4];
    std::vector<unsigned char> buttonIconDataStates_[4];
    std::wstring buttonLoadedIconFileStates_[4];
    Microsoft::WRL::ComPtr<ID2D1Bitmap> buttonIconBitmapStates_[4];
    bool buttonIconIsSvgStates_[4]{};
    bool buttonIconLoadAttemptedStates_[4]{};
};

class UiContainer : public UiComponent {
public:
    UiContainer();
    ~UiContainer() override;
    void Add(UiComponent* child);
    void Clear();
    void Draw(Engine& engine) override;
    bool OnMouse(Engine& engine, int x, int y, int eventType) override;

private:
    std::vector<UiComponent*> children_;
};

UiComponent* CreateUiComponent(int type);
UiContainer* CreateUiContainer();
void DestroyUiComponent(UiComponent* component);
void UiAddChild(UiContainer* container, UiComponent* child);
void UiClearChildren(UiContainer* container);
void UiSetBounds(UiComponent* component, Rect bounds);
void UiSetPixelBounds(Engine& engine, UiComponent* component, Rect bounds);
void UiSetText(UiComponent* component, const wchar_t* text);
void UiSetValue(UiComponent* component, float value);
void UiSetRange(UiComponent* component, float minimum, float maximum);
void UiSetEnabled(UiComponent* component, bool enabled);
void UiSetVisible(UiComponent* component, bool visible);
void UiSetChecked(UiComponent* component, bool checked);
void UiSetSelectedIndex(UiComponent* component, int index);
void UiSetButtonMetrics(UiComponent* component, float radius, float borderWidth);
void UiSetButtonFont(UiComponent* component, const wchar_t* family, float size, int weight);
void UiSetButtonFontDescriptor(UiComponent* component, const wchar_t* descriptor);
void UiSetButtonColors(UiComponent* component, Color normal, Color hover, Color pressed, Color disabled, Color text, Color disabledText, Color border);
void UiSetButtonStateColors(UiComponent* component, int state, Color background, bool hasBackground, Color text, bool hasText, Color border, bool hasBorder);
void UiSetButtonLayout(UiComponent* component, float paddingX, float paddingY, float iconGap, int iconPosition, int contentAlign, bool autoWrap);
void UiSetButtonOptions(UiComponent* component, int style, bool toggle, bool focused, bool defaultButton, Color focusColor, float focusWidth);
void UiSetButtonEffects(UiComponent* component, float pressedOffset, float shadowOffsetX, float shadowOffsetY, float shadowOpacity, bool gradientHighlight, int verticalAlign);
void UiSetButtonIcon(UiComponent* component, const wchar_t* fileName, float size, Color tint, bool useTint);
void UiSetButtonIconData(UiComponent* component, const void* data, int dataSize, float size, Color tint, bool useTint);
void UiSetButtonStateIconData(UiComponent* component, int state, const void* data, int dataSize, float size, Color tint, bool useTint);
int UiSelectedIndex(UiComponent* component);
bool UiChecked(UiComponent* component);
float UiValue(UiComponent* component);
void UiDraw(Engine& engine, UiComponent* component);
bool UiMouseEvent(Engine& engine, UiComponent* component, int x, int y, int eventType);
bool UiKeyEvent(Engine& engine, UiComponent* component, int eventType, int keyCode);

}  // namespace volcano_d2d
