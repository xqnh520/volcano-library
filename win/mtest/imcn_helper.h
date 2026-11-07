// ---------------------------------------------------------------------------
// imcn_helper.h - helper layer between Volcano (Chinese IDE) and Dear ImGui
//       in the ANSI/ASCII character set. Keep this file ASCII-only.
// ---------------------------------------------------------------------------
#ifndef IMCN_HELPER_H
#define IMCN_HELPER_H

#include <string>
#include <cstring>

#ifndef WIN32_LEAN_AND_MEAN
#define WIN32_LEAN_AND_MEAN
#endif
#include <windows.h>

#include "imgui.h"

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

#endif // IMCN_HELPER_H
