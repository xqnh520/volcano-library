// ---------------------------------------------------------------------------
// imcn_helper.h - helper layer between Volcano (Chinese IDE) and Dear ImGui
//       in the ANSI/ASCII character set. Keep this file ASCII-only.
// ---------------------------------------------------------------------------
#ifndef IMCN_HELPER_H
#define IMCN_HELPER_H

#include <stdio.h>
#include <string>
#include <cstring>
#include <vector>
#include <cstdio>

#ifndef WIN32_LEAN_AND_MEAN
#define WIN32_LEAN_AND_MEAN
#endif
#include <windows.h>

#include "imgui.h"
// imgui_internal.h is required for ImGui::TableSetColumnWidth() (column width by
// index lives in the internal API and has no public equivalent).
#include "imgui_internal.h"
#include "misc/cpp/imgui_stdlib.h"

namespace imcn
{
    // Wide (UTF-16, Volcano native string) -> UTF-8 (ImGui native string).
    inline std::string ToU8(const wchar_t* s)
    {
        if (s == NULL || s[0] == 0)
            return std::string();
        int n = ::WideCharToMultiByte(CP_UTF8, 0, s, -1, NULL, 0, NULL, NULL);
        if (n <= 1)
            return std::string();
        std::string out;
        out.resize((size_t)n - 1);
        ::WideCharToMultiByte(CP_UTF8, 0, s, -1, &out[0], n, NULL, NULL);
        return out;
    }

    // Narrow string passthrough (already UTF-8 or plain ASCII).
    inline std::string ToU8(const char* s)
    {
        return (s == NULL) ? std::string() : std::string(s);
    }

    // UTF-8 -> UTF-16, used when ImGui reports text back to Volcano code.
    inline std::wstring ToW(const char* s)
    {
        if (s == NULL || s[0] == 0)
            return std::wstring();
        int n = ::MultiByteToWideChar(CP_UTF8, 0, s, -1, NULL, 0);
        if (n <= 1)
            return std::wstring();
        std::wstring out;
        out.resize((size_t)n - 1);
        ::MultiByteToWideChar(CP_UTF8, 0, s, -1, &out[0], n);
        return out;
    }

    // Volcano keeps UTF-16 text in CVolString objects; forward declaration keeps
    // this header independent from the Volcano runtime headers.
    class CVolString;
}

// IMCN_U8(volcano_text) yields a temporary std::string whose storage lives until
// the end of the full expression, so several text arguments may appear inside a
// single ImGui call without clobbering each other.
#define IMCN_U8(x) (::imcn::ToU8(x).c_str())


namespace imcn
{
    // Text input: Volcano string (UTF-16) <-> ImGui (UTF-8) bridge.
    template <typename TStr>
    inline bool InputTextW(const char* label, TStr* var, ImGuiInputTextFlags flags)
    {
        std::string buf = ToU8(var->GetText());
        buf.reserve(512);
        bool changed = ImGui::InputText(label, &buf, flags);
        if (changed)
            *var = ToW(buf.c_str()).c_str();
        return changed;
    }

    template <typename TStr>
    inline bool InputTextMultilineW(const char* label, TStr* var, const ImVec2& size, ImGuiInputTextFlags flags)
    {
        std::string buf = ToU8(var->GetText());
        buf.reserve(4096);
        bool changed = ImGui::InputTextMultiline(label, &buf, size, flags);
        if (changed)
            *var = ToW(buf.c_str()).c_str();
        return changed;
    }

    template <typename TStr>
    inline bool InputTextWithHintW(const char* label, const char* hint, TStr* var, ImGuiInputTextFlags flags)
    {
        std::string buf = ToU8(var->GetText());
        buf.reserve(512);
        bool changed = ImGui::InputTextWithHint(label, hint, &buf, flags);
        if (changed)
            *var = ToW(buf.c_str()).c_str();
        return changed;
    }

    inline bool SetDragDropTextW(const char* type, const wchar_t* text)
    {
        std::string data = ToU8(text);
        return ImGui::SetDragDropPayload(type, data.c_str(), data.size() + 1);
    }

    // ---- Table / draw-list guards -------------------------------------------
    // These wrap internal-only ImGui entry points and pre-check the assertions
    // they rely on, so that a misuse degrades into a no-op instead of an
    // assert/crash. All table helpers require a live table context, i.e. they
    // must be called between BeginTable() and EndTable().

    // TableSetColumnWidth() asserts (table != NULL && IsLayoutLocked == false),
    // asserts 0 <= column_n < ColumnsCount and asserts MinColumnWidth > 0.
    // MinColumnWidth is only computed by TableUpdateLayout(), i.e. from the
    // second frame on, and IsLayoutLocked becomes true at the first row cell.
    inline void TableSetColumnWidthSafe(int column_n, float width)
    {
        ImGuiTable* table = ImGui::GetCurrentTable();
        if (table == NULL || column_n < 0 || column_n >= table->ColumnsCount || table->MinColumnWidth <= 0.0f)
            return;
        if (table->IsLayoutLocked)
            return;
        ImGui::TableSetColumnWidth(column_n, width);
    }

    // Read back the effective width of one column. WidthGiven is filled by
    // TableUpdateLayout(), i.e. from the second frame on; it reports 0 earlier.
    inline float TableGetColumnWidthSafe(int column_n)
    {
        ImGuiTable* table = ImGui::GetCurrentTable();
        if (table == NULL || column_n < 0 || column_n >= table->ColumnsCount)
            return 0.0f;
        return table->Columns[column_n].WidthGiven;
    }

    // TableSetColumnEnabled() asserts the table-level ImGuiTableFlags_Hideable.
    inline void TableSetColumnEnabledSafe(int column_n, bool enabled)
    {
        ImGuiTable* table = ImGui::GetCurrentTable();
        if (table == NULL || (table->Flags & ImGuiTableFlags_Hideable) == 0)
            return;
        if (column_n < 0 || column_n >= table->ColumnsCount)
            return;
        ImGui::TableSetColumnEnabled(column_n, enabled);
    }

    // Filled rect grown by 'spread' pixels on all four sides: overlay a
    // semi-transparent color to get a drop shadow / glow. Kept here so that the
    // Volcano embedded line never needs to reference a parameter twice.
    inline void AddShadowRect(ImDrawList* list, const ImVec2& a, const ImVec2& b, ImU32 col, float rounding, float spread)
    {
        if (list == NULL)
            return;
        list->AddRectFilled(ImVec2(a.x - spread, a.y - spread), ImVec2(b.x + spread, b.y + spread), col, rounding);
    }

    template <typename TStr>
    inline bool AcceptDragDropTextW(const char* type, TStr* var)
    {
        const ImGuiPayload* payload = ImGui::AcceptDragDropPayload(type);
        if (payload == NULL || payload->Data == NULL)
            return false;
        *var = ToW((const char*)payload->Data).c_str();
        return true;
    }

    // ---- Plot data buffer ---------------------------------------------------
    // ImGui Plot*() expect a raw float array; Volcano has no cheap way to hand
    // one over, so values are pushed one by one into a process-wide buffer.
    // Single-threaded use only (same assumption as ImGui itself).
    inline std::vector<float>& PlotBuffer()
    {
        static std::vector<float> buffer;
        return buffer;
    }

    inline void PlotClear()
    {
        PlotBuffer().clear();
    }

    inline void PlotPush(float value)
    {
        if (PlotBuffer().size() < 8192)
            PlotBuffer().push_back(value);
    }

    inline int PlotCount()
    {
        return (int)PlotBuffer().size();
    }

    inline bool PlotLinesW(const char* label, const char* overlay, float scale_min, float scale_max, const ImVec2& size)
    {
        std::vector<float>& buffer = PlotBuffer();
        if (buffer.empty())
            return false;
        ImGui::PlotLines(label, buffer.data(), (int)buffer.size(), 0, overlay, scale_min, scale_max, size);
        return true;
    }

    inline bool PlotHistogramW(const char* label, const char* overlay, float scale_min, float scale_max, const ImVec2& size)
    {
        std::vector<float>& buffer = PlotBuffer();
        if (buffer.empty())
            return false;
        ImGui::PlotHistogram(label, buffer.data(), (int)buffer.size(), 0, overlay, scale_min, scale_max, size);
        return true;
    }

    // ---- Path point buffer --------------------------------------------------
    // Same idea for ImDrawList::AddPolyline()/AddConvexPolyFilled()/_AddConcave,
    // which need an ImVec2 array.
    inline std::vector<ImVec2>& PathBuffer()
    {
        static std::vector<ImVec2> buffer;
        return buffer;
    }

    inline void PathClear()
    {
        PathBuffer().clear();
    }

    inline void PathPush(float x, float y)
    {
        if (PathBuffer().size() < 8192)
            PathBuffer().push_back(ImVec2(x, y));
    }

    inline int PathCount()
    {
        return (int)PathBuffer().size();
    }

    inline void PathPolyline(ImDrawList* list, ImU32 col, ImDrawFlags flags, float thickness)
    {
        std::vector<ImVec2>& buffer = PathBuffer();
        if (list == NULL || buffer.size() < 2)
            return;
        list->AddPolyline(buffer.data(), (int)buffer.size(), col, flags, thickness);
    }

    inline void PathConvexFill(ImDrawList* list, ImU32 col)
    {
        std::vector<ImVec2>& buffer = PathBuffer();
        if (list == NULL || buffer.size() < 3)
            return;
        list->AddConvexPolyFilled(buffer.data(), (int)buffer.size(), col);
    }

    inline void PathConcaveFill(ImDrawList* list, ImU32 col)
    {
        std::vector<ImVec2>& buffer = PathBuffer();
        if (list == NULL || buffer.size() < 3)
            return;
        list->AddConcavePolyFilled(buffer.data(), (int)buffer.size(), col);
    }

    // ---- Window storage (ImGuiStorage of the current window) ----------------
    // GetStateStorage() asserts on a missing current window, so the pointer is
    // taken from the context directly and every entry point degrades to a no-op.
    inline ImGuiStorage* StorageOrNull()
    {
        ImGuiContext* ctx = ImGui::GetCurrentContext();
        if (ctx == NULL || ctx->CurrentWindow == NULL)
            return NULL;
        return &ctx->CurrentWindow->StateStorage;
    }

    inline void StorageSetInt(const char* key, int value)
    {
        ImGuiStorage* storage = StorageOrNull();
        if (storage != NULL)
            storage->SetInt(ImGui::GetID(key), value);
    }

    inline int StorageGetInt(const char* key, int default_value)
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->GetInt(ImGui::GetID(key), default_value) : default_value;
    }

    inline void StorageSetFloat(const char* key, float value)
    {
        ImGuiStorage* storage = StorageOrNull();
        if (storage != NULL)
            storage->SetFloat(ImGui::GetID(key), value);
    }

    inline float StorageGetFloat(const char* key, float default_value)
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->GetFloat(ImGui::GetID(key), default_value) : default_value;
    }

    inline void StorageSetBool(const char* key, bool value)
    {
        ImGuiStorage* storage = StorageOrNull();
        if (storage != NULL)
            storage->SetBool(ImGui::GetID(key), value);
    }

    inline bool StorageGetBool(const char* key, bool default_value)
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->GetBool(ImGui::GetID(key), default_value) : default_value;
    }

    inline int StorageCount()
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->Data.Size : 0;
    }

    inline void StorageClear()
    {
        ImGuiStorage* storage = StorageOrNull();
        if (storage != NULL)
            storage->Clear();
    }

    // ---- Font measurement ---------------------------------------------------
    // CalcWordWrapPositionA() returns a pointer into the UTF-8 copy, so the
    // copy must outlive the call; the byte offset is what Volcano can use.
    inline int WordWrapByteOffset(float size, const wchar_t* text, float wrap_width)
    {
        ImFont* font = ImGui::GetFont();
        if (font == NULL)
            return 0;
        std::string utf8 = ToU8(text);
        const char* begin = utf8.c_str();
        const char* pos = font->CalcWordWrapPositionA(size, begin, begin + utf8.size(), wrap_width);
        return (int)(pos - begin);
    }

    inline bool HasGlyph(unsigned int codepoint)
    {
        ImFont* font = ImGui::GetFont();
        return (font != NULL) && (font->FindGlyph((ImWchar)codepoint) != NULL);
    }

    inline float GlyphAdvance(unsigned int codepoint)
    {
        ImFont* font = ImGui::GetFont();
        if (font == NULL)
            return 0.0f;
        const ImFontGlyph* glyph = font->FindGlyph((ImWchar)codepoint);
        return (glyph != NULL) ? glyph->AdvanceX : 0.0f;
    }

    // Reads a TTF into heap memory and hands ownership to ImGui (adds the
    // "memory" path on top of AddFontFromFileTTF). Narrow fopen(): keep paths
    // ASCII on the Volcano side.
    inline bool AddFontFromFileMemory(const char* path, float size_pixels, bool chinese_ranges)
    {
        if (path == NULL || path[0] == 0)
            return false;
        FILE* fp = fopen(path, "rb");
        if (fp == NULL)
            return false;
        fseek(fp, 0, SEEK_END);
        long size = ftell(fp);
        fseek(fp, 0, SEEK_SET);
        if (size <= 0)
        {
            fclose(fp);
            return false;
        }
        unsigned char* data = (unsigned char*)IM_ALLOC((size_t)size);
        size_t read = fread(data, 1, (size_t)size, fp);
        fclose(fp);
        if (read != (size_t)size)
        {
            IM_FREE(data);
            return false;
        }
        ImGuiIO& io = ImGui::GetIO();
        const ImWchar* ranges = chinese_ranges ? io.Fonts->GetGlyphRangesChineseFull() : NULL;
        ImFont* font = io.Fonts->AddFontFromMemoryTTF(data, (int)size, size_pixels, NULL, ranges);
        if (font != NULL)
            io.FontDefault = font;
        return true;
    }

    // Fonts added after a backend already built the atlas are not used for
    // rendering unless they become the default font, so every add helper below
    // also sets io.FontDefault. This makes "add a CJK font and Chinese works"
    // true for every backend, including Direct3D 9 which builds an atlas eagerly.
    inline ImFont* AddFontFileW(const char* path, float size_pixels, const ImWchar* ranges)
    {
        ImGuiIO& io = ImGui::GetIO();
        ImFont* font = io.Fonts->AddFontFromFileTTF(path, size_pixels, NULL, ranges);
        if (font != NULL)
            io.FontDefault = font;
        return font;
    }

    inline ImFont* AddFontDefaultW()
    {
        ImGuiIO& io = ImGui::GetIO();
        ImFont* font = io.Fonts->AddFontDefault();
        io.FontDefault = font;
        return font;
    }

    // ---- List clipper -------------------------------------------------------
    // The clipper is heap-allocated on Begin() and destroyed on End(), so a
    // missing End() (or a double End()) can never leave stale state behind.
    inline ImGuiListClipper*& ClipperSlot()
    {
        static ImGuiListClipper* clipper = NULL;
        return clipper;
    }

    inline void ClipperBegin(int items_count, float items_height)
    {
        if (ClipperSlot() == NULL)
            ClipperSlot() = IM_NEW(ImGuiListClipper)();
        ClipperSlot()->Begin(items_count, items_height);
    }

    inline bool ClipperStep()
    {
        if (ClipperSlot() == NULL)
            return false;
        return ClipperSlot()->Step();
    }

    inline int ClipperDisplayStart()
    {
        return (ClipperSlot() != NULL) ? ClipperSlot()->DisplayStart : 0;
    }

    inline int ClipperDisplayEnd()
    {
        return (ClipperSlot() != NULL) ? ClipperSlot()->DisplayEnd : 0;
    }

    inline void ClipperEnd()
    {
        if (ClipperSlot() == NULL)
            return;
        ClipperSlot()->End();
        IM_DELETE(ClipperSlot());
        ClipperSlot() = NULL;
    }

    // ---- Text filter --------------------------------------------------------
    inline ImGuiTextFilter& Filter()
    {
        static ImGuiTextFilter filter;
        return filter;
    }

    inline bool FilterDraw(const char* label, float width)
    {
        return Filter().Draw(label, width);
    }

    inline bool FilterPass(const char* text)
    {
        return Filter().PassFilter(text);
    }

    inline bool FilterActive()
    {
        return Filter().IsActive();
    }

    inline void FilterClear()
    {
        Filter().Clear();
    }

    inline void FilterSetText(const char* text)
    {
        Filter().Clear();
        if (text != NULL)
            strncpy_s(Filter().InputBuf, sizeof(Filter().InputBuf), text, _TRUNCATE);
        Filter().Build();
    }

    // ---- Multi-select -------------------------------------------------------
    // One process-wide ImGuiSelectionBasicStorage; requests coming from
    // BeginMultiSelect()/EndMultiSelect() are applied immediately so Volcano
    // code only has to read/test selection state.
    inline ImGuiSelectionBasicStorage& Selection()
    {
        static ImGuiSelectionBasicStorage selection;
        return selection;
    }

    inline bool& MultiSelectActive()
    {
        static bool active = false;
        return active;
    }

    inline void MultiSelectBegin(int flags, int items_count)
    {
        if (MultiSelectActive())
        {
            ImGui::EndMultiSelect();
            MultiSelectActive() = false;
        }
        ImGuiMultiSelectIO* io = ImGui::BeginMultiSelect((ImGuiMultiSelectFlags)flags, (int)Selection().Size, items_count);
        Selection().ApplyRequests(io);
        MultiSelectActive() = true;
    }

    inline void MultiSelectEnd()
    {
        if (!MultiSelectActive())
            return;
        ImGuiMultiSelectIO* io = ImGui::EndMultiSelect();
        Selection().ApplyRequests(io);
        MultiSelectActive() = false;
    }

    inline void MultiSelectSetIndex(int index)
    {
        ImGui::SetNextItemSelectionUserData((ImGuiSelectionUserData)index);
    }

    inline bool MultiSelectContains(int index)
    {
        return Selection().Contains((ImGuiID)index);
    }

    inline int MultiSelectCount()
    {
        return (int)Selection().Size;
    }

    inline void MultiSelectClear()
    {
        Selection().Clear();
    }

    inline void MultiSelectSetSelected(int index, bool selected)
    {
        Selection().SetItemSelected((ImGuiID)index, selected);
    }

    // ---- Color + storage pointers -------------------------------------------
    inline ImVec4 HSVtoRGB(float h, float s, float v)
    {
        float r = 0.0f, g = 0.0f, b = 0.0f;
        ImGui::ColorConvertHSVtoRGB(h, s, v, r, g, b);
        return ImVec4(r, g, b, 1.0f);
    }

    inline ImVec4 RGBtoHSV(float r, float g, float b)
    {
        float h = 0.0f, s = 0.0f, v = 0.0f;
        ImGui::ColorConvertRGBtoHSV(r, g, b, h, s, v);
        return ImVec4(h, s, v, 1.0f);
    }

    inline void StorageSetPtr(const char* key, void* value)
    {
        ImGuiStorage* storage = StorageOrNull();
        if (storage != NULL)
            storage->SetVoidPtr(ImGui::GetID(key), value);
    }

    inline void* StorageGetPtr(const char* key)
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->GetVoidPtr(ImGui::GetID(key)) : NULL;
    }

    // ---- DockBuilder (internal API, used to build a fixed IDE-like layout) --
    inline void DockReset(unsigned int node_id)
    {
        ImGui::DockBuilderRemoveNode((ImGuiID)node_id);
    }

    inline unsigned int DockAddNode(unsigned int node_id, int flags)
    {
        return (unsigned int)ImGui::DockBuilderAddNode((ImGuiID)node_id, (ImGuiDockNodeFlags)flags);
    }

    inline void DockSetNodeSize(unsigned int node_id, float width, float height)
    {
        ImGui::DockBuilderSetNodeSize((ImGuiID)node_id, ImVec2(width, height));
    }

    inline unsigned int DockSplit(unsigned int node_id, int dir, float ratio)
    {
        ImGuiID at_dir = 0;
        ImGuiID at_opposite = 0;
        ImGui::DockBuilderSplitNode((ImGuiID)node_id, (ImGuiDir)dir, ratio, &at_dir, &at_opposite);
        return (unsigned int)at_dir;
    }

    inline void DockWindow(const char* window_name, unsigned int node_id)
    {
        ImGui::DockBuilderDockWindow(window_name, (ImGuiID)node_id);
    }

    inline void DockFinish(unsigned int node_id)
    {
        ImGui::DockBuilderFinish((ImGuiID)node_id);
    }


    // ---- Dock layout --------------------------------------------------------
    // A dock node only gets displayed when it has a HostWindow, and a HostWindow
    // is only assigned by DockSpace() while it is submitted *inside* a window.
    // Building the layout from the top-level scope therefore produces an
    // invisible tree (node->HostWindow == NULL), which is the most common
    // reason a DockBuilder layout "does nothing".
    // DockBuildQuadFullViewport() below creates the host window, builds the
    // layout inside it and then submits the dockspace, all in the right order.
    inline unsigned int DockBuildQuadFullViewport(const char* name,
                                                  float left_ratio, float right_ratio, float bottom_ratio,
                                                  bool rebuild, int* out_left, int* out_right, int* out_bottom, int* out_center)
    {
        ImGuiViewport* viewport = ImGui::GetMainViewport();
        ImGui::SetNextWindowPos(viewport->WorkPos);
        ImGui::SetNextWindowSize(viewport->WorkSize);
        ImGui::SetNextWindowViewport(viewport->ID);

        ImGuiWindowFlags flags = 0;
        flags |= ImGuiWindowFlags_NoTitleBar | ImGuiWindowFlags_NoCollapse | ImGuiWindowFlags_NoResize;
        flags |= ImGuiWindowFlags_NoMove | ImGuiWindowFlags_NoDocking | ImGuiWindowFlags_NoBringToFrontOnFocus;
        flags |= ImGuiWindowFlags_NoNavFocus;

        ImGui::PushStyleVar(ImGuiStyleVar_WindowRounding, 0.0f);
        ImGui::PushStyleVar(ImGuiStyleVar_WindowBorderSize, 0.0f);
        ImGui::PushStyleVar(ImGuiStyleVar_WindowPadding, ImVec2(0.0f, 0.0f));
        ImGui::Begin("##imcn_dock_host", NULL, flags);
        ImGui::PopStyleVar(3);

        ImGuiID dock_id = ImGui::GetID(name);
        if (rebuild)
        {
            ImGui::DockBuilderRemoveNode(dock_id);
            ImGui::DockBuilderAddNode(dock_id, ImGuiDockNodeFlags_DockSpace);
            ImGui::DockBuilderSetNodeSize(dock_id, viewport->WorkSize);

            ImGuiID center = dock_id;
            ImGuiID left_id = ImGui::DockBuilderSplitNode(center, ImGuiDir_Left, left_ratio, NULL, &center);
            ImGuiID right_id = ImGui::DockBuilderSplitNode(center, ImGuiDir_Right, right_ratio, NULL, &center);
            ImGuiID bottom_id = ImGui::DockBuilderSplitNode(center, ImGuiDir_Down, bottom_ratio, NULL, &center);
            ImGui::DockBuilderFinish(dock_id);

            if (out_left != NULL) *out_left = (int)left_id;
            if (out_right != NULL) *out_right = (int)right_id;
            if (out_bottom != NULL) *out_bottom = (int)bottom_id;
            if (out_center != NULL) *out_center = (int)center;
            if (out_center != NULL) *out_center = (int)center;
        }

        ImGui::DockSpace(dock_id, ImVec2(0.0f, 0.0f), 0, NULL);
        ImGui::End();
        return (unsigned int)dock_id;
    }

    // Diagnostic text: where the four named windows actually ended up.
    // "found" means the window exists this frame, x/y/w/h are screen-space,
    // node is its dock node id (0 = floating).
    inline const char* DockProbeText(const char* n1, const char* n2, const char* n3, const char* n4)
    {
        static std::string out;
        out.clear();
        const char* names[4] = { n1, n2, n3, n4 };
        char line[256];
        for (int i = 0; i < 4; i++)
        {
            if (names[i] == NULL || names[i][0] == 0)
                continue;
            ImGuiWindow* w = ImGui::FindWindowByName(names[i]);
            if (w == NULL)
            {
                snprintf(line, sizeof(line), "[%d] missing\n", i);
            }
            else
            {
                snprintf(line, sizeof(line), "[%d] pos=%.0f,%.0f size=%.0f,%.0f dock=0x%08X\n",
                         i, w->Pos.x, w->Pos.y, w->Size.x, w->Size.y, (unsigned int)w->DockId);
            }
            out += line;
        }
        return out.c_str();
    }

    // Docking windows by id *after* DockBuilderFinish() only lands them in the
    // root node, which is why the right/bottom split nodes used to stay empty.
    // DockBuilderDockWindow() writes the target node into the window settings and
    // therefore has to run *before* Finish, so the four names are passed in here.
    inline unsigned int DockBuildQuadWindows(const char* name,
                                             float left_ratio, float right_ratio, float bottom_ratio,
                                             const char* win_left, const char* win_right,
                                             const char* win_bottom, const char* win_center,
                                             int rebuild, int* out_left, int* out_right, int* out_bottom, int* out_center)
    {
        ImGuiViewport* viewport = ImGui::GetMainViewport();
        ImGui::SetNextWindowPos(viewport->WorkPos);
        ImGui::SetNextWindowSize(viewport->WorkSize);
        ImGui::SetNextWindowViewport(viewport->ID);

        ImGuiWindowFlags flags = 0;
        flags |= ImGuiWindowFlags_NoTitleBar | ImGuiWindowFlags_NoCollapse | ImGuiWindowFlags_NoResize;
        flags |= ImGuiWindowFlags_NoMove | ImGuiWindowFlags_NoDocking | ImGuiWindowFlags_NoBringToFrontOnFocus;
        flags |= ImGuiWindowFlags_NoNavFocus;

        ImGui::PushStyleVar(ImGuiStyleVar_WindowRounding, 0.0f);
        ImGui::PushStyleVar(ImGuiStyleVar_WindowBorderSize, 0.0f);
        ImGui::PushStyleVar(ImGuiStyleVar_WindowPadding, ImVec2(0.0f, 0.0f));
        ImGui::Begin("##imcn_dock_host", NULL, flags);
        ImGui::PopStyleVar(3);

        ImGuiID dock_id = ImGui::GetID(name);
        if (rebuild)
        {
            ImGui::DockBuilderRemoveNode(dock_id);
            ImGui::DockBuilderAddNode(dock_id, ImGuiDockNodeFlags_DockSpace);
            ImGui::DockBuilderSetNodeSize(dock_id, viewport->WorkSize);

            ImGuiID center = dock_id;
            ImGuiID left_id = ImGui::DockBuilderSplitNode(center, ImGuiDir_Left, left_ratio, NULL, &center);
            ImGuiID right_id = ImGui::DockBuilderSplitNode(center, ImGuiDir_Right, right_ratio, NULL, &center);
            ImGuiID bottom_id = ImGui::DockBuilderSplitNode(center, ImGuiDir_Down, bottom_ratio, NULL, &center);

            if (win_left != NULL && win_left[0] != 0)     ImGui::DockBuilderDockWindow(win_left, left_id);
            if (win_right != NULL && win_right[0] != 0)   ImGui::DockBuilderDockWindow(win_right, right_id);
            if (win_bottom != NULL && win_bottom[0] != 0) ImGui::DockBuilderDockWindow(win_bottom, bottom_id);
            if (win_center != NULL && win_center[0] != 0) ImGui::DockBuilderDockWindow(win_center, center);

            ImGui::DockBuilderFinish(dock_id);

            if (out_left != NULL) *out_left = (int)left_id;
            if (out_right != NULL) *out_right = (int)right_id;
            if (out_bottom != NULL) *out_bottom = (int)bottom_id;
            if (out_center != NULL) *out_center = (int)center;
        }

        ImGui::DockSpace(dock_id, ImVec2(0.0f, 0.0f), 0, NULL);
        ImGui::End();
        return (unsigned int)dock_id;
    }

    inline int WindowDockId(const char* window_name)
    {
        ImGuiWindow* w = ImGui::FindWindowByName(window_name);
        return (w != NULL) ? (int)w->DockId : -1;
    }


    inline int DockNodeExists(unsigned int node_id)
    {
        return (ImGui::DockBuilderGetNode((ImGuiID)node_id) != NULL) ? 1 : 0;
    }

    // No public IsItemDisabled() in this ImGui version: read the item flag.
    inline bool ItemDisabled()
    {
        ImGuiContext* ctx = ImGui::GetCurrentContext();
        if (ctx == NULL)
            return false;
        return (ctx->LastItemData.ItemFlags & ImGuiItemFlags_Disabled) != 0;
    }

    // TableNeedSort() was removed; the public path is the sort specs flag.
    inline bool TableSortDirty()
    {
        ImGuiTableSortSpecs* specs = ImGui::TableGetSortSpecs();
        return (specs != NULL) && specs->SpecsDirty;
    }

    inline ImVec2 AddVec2(const ImVec2& a, const ImVec2& b) { return ImVec2(a.x + b.x, a.y + b.y); }
    inline ImVec2 SubVec2(const ImVec2& a, const ImVec2& b) { return ImVec2(a.x - b.x, a.y - b.y); }
    inline ImVec2 MulVec2(const ImVec2& a, float s) { return ImVec2(a.x * s, a.y * s); }

    // Volcano can only reference an embedded-method parameter once, so a
    // two-field write has to happen in C++.
    inline void SetVec2(ImVec2* v, float x, float y)
    {
        if (v == NULL)
            return;
        v->x = x;
        v->y = y;
    }

    inline const char* SpinnerText()
    {
        static const char* frames[4] = { "|", "/", "-", "\\" };
        int index = ((int)(ImGui::GetTime() * 12.0)) & 3;
        return frames[index];
    }

    // ------------------------------------------------------------------
    // Volcano has no integer-vector type, so multi-component integer widgets
    // pack separate scalar variables into a temporary array and write them back.
    // ------------------------------------------------------------------
    inline bool InputInt2V(const char* label, int* a, int* b, ImGuiInputTextFlags flags)
    {
        int v[2] = { *a, *b };
        bool ch = ImGui::InputInt2(label, v, flags);
        if (ch) { *a = v[0]; *b = v[1]; }
        return ch;
    }

    inline bool InputInt3V(const char* label, int* a, int* b, int* c, ImGuiInputTextFlags flags)
    {
        int v[3] = { *a, *b, *c };
        bool ch = ImGui::InputInt3(label, v, flags);
        if (ch) { *a = v[0]; *b = v[1]; *c = v[2]; }
        return ch;
    }

    inline bool InputInt4V(const char* label, int* a, int* b, int* c, int* d, ImGuiInputTextFlags flags)
    {
        int v[4] = { *a, *b, *c, *d };
        bool ch = ImGui::InputInt4(label, v, flags);
        if (ch) { *a = v[0]; *b = v[1]; *c = v[2]; *d = v[3]; }
        return ch;
    }

    inline bool SliderInt2V(const char* label, int* a, int* b, int mn, int mx, const char* fmt, ImGuiSliderFlags flags)
    {
        int v[2] = { *a, *b };
        bool ch = ImGui::SliderInt2(label, v, mn, mx, fmt, flags);
        if (ch) { *a = v[0]; *b = v[1]; }
        return ch;
    }

    inline bool SliderInt3V(const char* label, int* a, int* b, int* c, int mn, int mx, const char* fmt, ImGuiSliderFlags flags)
    {
        int v[3] = { *a, *b, *c };
        bool ch = ImGui::SliderInt3(label, v, mn, mx, fmt, flags);
        if (ch) { *a = v[0]; *b = v[1]; *c = v[2]; }
        return ch;
    }

    inline bool SliderInt4V(const char* label, int* a, int* b, int* c, int* d, int mn, int mx, const char* fmt, ImGuiSliderFlags flags)
    {
        int v[4] = { *a, *b, *c, *d };
        bool ch = ImGui::SliderInt4(label, v, mn, mx, fmt, flags);
        if (ch) { *a = v[0]; *b = v[1]; *c = v[2]; *d = v[3]; }
        return ch;
    }

    inline bool DragInt2V(const char* label, int* a, int* b, float speed, int mn, int mx, const char* fmt, ImGuiSliderFlags flags)
    {
        int v[2] = { *a, *b };
        bool ch = ImGui::DragInt2(label, v, speed, mn, mx, fmt, flags);
        if (ch) { *a = v[0]; *b = v[1]; }
        return ch;
    }

    inline bool DragInt3V(const char* label, int* a, int* b, int* c, float speed, int mn, int mx, const char* fmt, ImGuiSliderFlags flags)
    {
        int v[3] = { *a, *b, *c };
        bool ch = ImGui::DragInt3(label, v, speed, mn, mx, fmt, flags);
        if (ch) { *a = v[0]; *b = v[1]; *c = v[2]; }
        return ch;
    }

    inline bool DragInt4V(const char* label, int* a, int* b, int* c, int* d, float speed, int mn, int mx, const char* fmt, ImGuiSliderFlags flags)
    {
        int v[4] = { *a, *b, *c, *d };
        bool ch = ImGui::DragInt4(label, v, speed, mn, mx, fmt, flags);
        if (ch) { *a = v[0]; *b = v[1]; *c = v[2]; *d = v[3]; }
        return ch;
    }

    // Pack an ImVec4 color into an ImU32 with style alpha and an extra multiplier.
    // ImGui::GetColorU32() has no (ImVec4, float) overload, hence this wrapper.
    inline unsigned int ColorU32FromVec4(const ImVec4& col, float alpha_mul)
    {
        ImVec4 c = col;
        c.w *= ImGui::GetStyle().Alpha * alpha_mul;
        return ImGui::ColorConvertFloat4ToU32(c);
    }

    // Double input: relay through the variable's real width (float or double).
    template <typename T>
    inline bool InputDoubleT(const char* label, T* var, double step, double step_fast, const char* fmt, ImGuiInputTextFlags flags)
    {
        double tmp = (double)*var;
        bool ch = ImGui::InputDouble(label, &tmp, step, step_fast, fmt, flags);
        if (ch)
            *var = (T)tmp;
        return ch;
    }

    // ---- Window storage: raw value references -------------------------------
    // Advanced use only: these hand out the pointer ImGuiStorage keeps internally,
    // so a value can be shown by a widget (or read from a self-drawn control)
    // without a hash lookup every frame. The pointer stays valid while the owning
    // window lives, but ImGuiStorage::Data is a growing array: obtaining another
    // reference may reallocate it and invalidate pointers fetched earlier, so
    // re-fetch after inserting new keys. NULL means "no current window".
    inline int* StorageGetIntRef(const char* key, int default_value)
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->GetIntRef(ImGui::GetID(key), default_value) : NULL;
    }

    inline float* StorageGetFloatRef(const char* key, float default_value)
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->GetFloatRef(ImGui::GetID(key), default_value) : NULL;
    }

    inline bool* StorageGetBoolRef(const char* key, bool default_value)
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->GetBoolRef(ImGui::GetID(key), default_value) : NULL;
    }

    inline void** StorageGetPtrRef(const char* key, void* default_value)
    {
        ImGuiStorage* storage = StorageOrNull();
        return (storage != NULL) ? storage->GetVoidPtrRef(ImGui::GetID(key), default_value) : NULL;
    }

    inline void StorageSetAllInt(int value)
    {
        ImGuiStorage* storage = StorageOrNull();
        if (storage != NULL)
            storage->SetAllInt(value);
    }

    // ---- List clipper: forced ranges ----------------------------------------
    // ImGuiListClipper::IncludeItemsByIndex() asserts (DisplayStart < 0), i.e. it
    // is only legal right after Begin() and before the first Step(). The guard
    // below mirrors that condition so a late call degrades to a no-op.
    inline void ClipperIncludeItems(int item_begin, int item_end)
    {
        ImGuiListClipper* clipper = ClipperSlot();
        if (clipper == NULL || clipper->TempData == NULL)
            return;
        if (clipper->DisplayStart >= 0 || clipper->ItemsCount < 0)
            return;
        if (item_begin < 0 || item_begin > item_end)
            return;
        if (item_end > clipper->ItemsCount)
            item_end = clipper->ItemsCount;
        clipper->IncludeItemsByIndex(item_begin, item_end);
    }

    // ImGuiListClipper::SeekCursorForItem() only needs the members filled by
    // Begin()/Step(), so it also works after the clipper has already ended.
    inline void ClipperSeekCursorForItem(int item_index)
    {
        ImGuiListClipper* clipper = ClipperSlot();
        if (clipper == NULL || item_index < 0)
            return;
        clipper->SeekCursorForItem(item_index);
    }

    // ---- Generic scalar widgets ---------------------------------------------
    // InputScalar()/SliderScalar()/DragScalar() take their steps and limits as
    // void* pointing at a value whose type matches p_data. Volcano can only pass
    // plain numbers, so these helpers build a correctly typed temporary from the
    // double and hand its address over. ScalarBox keeps the storage 16 bytes wide
    // and 8-byte aligned, which covers every numeric ImGuiDataType.
    struct ScalarBox
    {
        double align_dummy;
        unsigned char raw[16];

        ScalarBox()
        {
            align_dummy = 0.0;
            memset(raw, 0, sizeof(raw));
        }

        void Set(int data_type, double value)
        {
            memset(raw, 0, sizeof(raw));
            switch (data_type)
            {
            case ImGuiDataType_S8:     { ImS8   v = (ImS8)value;            memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_U8:     { ImU8   v = (ImU8)value;            memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_S16:    { ImS16  v = (ImS16)value;           memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_U16:    { ImU16  v = (ImU16)value;           memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_S32:    { ImS32  v = (ImS32)value;           memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_U32:    { ImU32  v = (ImU32)value;           memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_S64:    { ImS64  v = (ImS64)value;           memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_U64:    { ImU64  v = (ImU64)value;           memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_Float:  { float  v = (float)value;           memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_Double: { double v = (double)value;          memcpy(raw, &v, sizeof(v)); break; }
            case ImGuiDataType_Bool:   { bool   v = (value != 0.0) ? true : false; memcpy(raw, &v, sizeof(v)); break; }
            default: break;
            }
        }

        const void* Data() const { return (const void*)raw; }
    };

    // An empty format string means "let ImGui pick the default per data type".
    inline const char* ScalarFmt(const char* fmt)
    {
        return (fmt != NULL && fmt[0] == 0) ? NULL : fmt;
    }

    // 64-bit exact limits: Volcano passes long long, so skip the double box.
    inline bool SliderScalarI64(const char* label, void* data, long long v_min, long long v_max,
                                const char* fmt, ImGuiSliderFlags flags)
    {
        if (data == NULL || v_min > v_max)
            return false;
        ImS64 mn = (ImS64)v_min;
        ImS64 mx = (ImS64)v_max;
        return ImGui::SliderScalar(label, ImGuiDataType_S64, data, &mn, &mx, ScalarFmt(fmt), flags);
    }

    inline bool DragScalarI64(const char* label, void* data, float v_speed, long long v_min, long long v_max,
                              const char* fmt, ImGuiSliderFlags flags)
    {
        if (data == NULL)
            return false;
        ImS64 mn = (ImS64)v_min;
        ImS64 mx = (ImS64)v_max;
        const void* p_min = (v_min == 0 && v_max == 0) ? NULL : &mn;
        const void* p_max = (v_min == 0 && v_max == 0) ? NULL : &mx;
        return ImGui::DragScalar(label, ImGuiDataType_S64, data, v_speed, p_min, p_max, ScalarFmt(fmt), flags);
    }

    inline bool VSliderScalarD(const char* label, const ImVec2& size, int data_type, void* data,
                               double v_min, double v_max, const char* fmt, ImGuiSliderFlags flags)
    {
        if (data == NULL || v_min > v_max)
            return false;
        ScalarBox min_box;
        ScalarBox max_box;
        min_box.Set(data_type, v_min);
        max_box.Set(data_type, v_max);
        return ImGui::VSliderScalar(label, size, (ImGuiDataType)data_type, data, min_box.Data(), max_box.Data(), ScalarFmt(fmt), flags);
    }

    // LogToFile() asserts when the file cannot be opened; probe first so that a
    // read-only location degrades to "return false" instead of aborting the app.
    inline bool FileWritable(const char* utf8_path)
    {
        if (utf8_path == NULL || utf8_path[0] == 0)
            return false;
        wchar_t wide[MAX_PATH];
        int n = ::MultiByteToWideChar(CP_UTF8, 0, utf8_path, -1, wide, MAX_PATH);
        if (n <= 0)
            return false;
        FILE* f = _wfopen(wide, L"ab");
        if (f == NULL)
            return false;
        fclose(f);
        return true;
    }

    inline bool LogToFileW(const char* path)
    {
        if (path == NULL || path[0] == 0)
            return false;
        // ImGui::LogToFile() aborts when the file cannot be opened, so probe first.
        // Probe through the wide-character API so that Chinese paths work.
        if (!FileWritable(path))
            return false;
        ImGui::LogToFile(-1, path);
        return true;
    }

    inline bool InputScalarD(const char* label, int data_type, void* data,
                             double step, double step_fast, const char* fmt, ImGuiInputTextFlags flags)
    {
        if (data == NULL)
            return false;
        ScalarBox step_box;
        ScalarBox fast_box;
        step_box.Set(data_type, step);
        fast_box.Set(data_type, step_fast);
        const void* p_step = (step == 0.0) ? NULL : step_box.Data();
        const void* p_fast = (step_fast == 0.0) ? NULL : fast_box.Data();
        return ImGui::InputScalar(label, (ImGuiDataType)data_type, data, p_step, p_fast, ScalarFmt(fmt), flags);
    }

    inline bool InputScalarND(const char* label, int data_type, void* data, int components,
                              double step, double step_fast, const char* fmt, ImGuiInputTextFlags flags)
    {
        if (data == NULL || components < 1 || components > 4)
            return false;
        ScalarBox step_box;
        ScalarBox fast_box;
        step_box.Set(data_type, step);
        fast_box.Set(data_type, step_fast);
        const void* p_step = (step == 0.0) ? NULL : step_box.Data();
        const void* p_fast = (step_fast == 0.0) ? NULL : fast_box.Data();
        return ImGui::InputScalarN(label, (ImGuiDataType)data_type, data, components, p_step, p_fast, ScalarFmt(fmt), flags);
    }

    inline bool SliderScalarD(const char* label, int data_type, void* data,
                              double v_min, double v_max, const char* fmt, ImGuiSliderFlags flags)
    {
        if (data == NULL || v_min > v_max)
            return false;
        ScalarBox min_box;
        ScalarBox max_box;
        min_box.Set(data_type, v_min);
        max_box.Set(data_type, v_max);
        return ImGui::SliderScalar(label, (ImGuiDataType)data_type, data, min_box.Data(), max_box.Data(), ScalarFmt(fmt), flags);
    }

    inline bool SliderScalarND(const char* label, int data_type, void* data, int components,
                               double v_min, double v_max, const char* fmt, ImGuiSliderFlags flags)
    {
        if (data == NULL || components < 1 || components > 4 || v_min > v_max)
            return false;
        ScalarBox min_box;
        ScalarBox max_box;
        min_box.Set(data_type, v_min);
        max_box.Set(data_type, v_max);
        return ImGui::SliderScalarN(label, (ImGuiDataType)data_type, data, components, min_box.Data(), max_box.Data(), ScalarFmt(fmt), flags);
    }

    inline bool DragScalarD(const char* label, int data_type, void* data, float v_speed,
                            double v_min, double v_max, const char* fmt, ImGuiSliderFlags flags)
    {
        if (data == NULL)
            return false;
        ScalarBox min_box;
        ScalarBox max_box;
        min_box.Set(data_type, v_min);
        max_box.Set(data_type, v_max);
        // Matches the DragFloat() convention: min == max == 0 means "no bounds".
        const void* p_min = (v_min == 0.0 && v_max == 0.0) ? NULL : min_box.Data();
        const void* p_max = (v_min == 0.0 && v_max == 0.0) ? NULL : max_box.Data();
        return ImGui::DragScalar(label, (ImGuiDataType)data_type, data, v_speed, p_min, p_max, ScalarFmt(fmt), flags);
    }

    inline bool DragScalarND(const char* label, int data_type, void* data, int components, float v_speed,
                             double v_min, double v_max, const char* fmt, ImGuiSliderFlags flags)
    {
        if (data == NULL || components < 1 || components > 4)
            return false;
        ScalarBox min_box;
        ScalarBox max_box;
        min_box.Set(data_type, v_min);
        max_box.Set(data_type, v_max);
        const void* p_min = (v_min == 0.0 && v_max == 0.0) ? NULL : min_box.Data();
        const void* p_max = (v_min == 0.0 && v_max == 0.0) ? NULL : max_box.Data();
        return ImGui::DragScalarN(label, (ImGuiDataType)data_type, data, components, v_speed, p_min, p_max, ScalarFmt(fmt), flags);
    }
}

#endif // IMCN_HELPER_H
