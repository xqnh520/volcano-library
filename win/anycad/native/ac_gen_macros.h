/* ------------------------------------------------------------------------
 * ac_gen_macros.h  -  wrapper macros for the generated C++ bridge
 *
 * PURE ASCII.
 *
 * Purpose
 * -------
 * Every exported bridge function must satisfy the same hard rules
 * (architecture section 8, "native layer" 1-8):
 *
 *   1. no managed exception may ever cross the C boundary;
 *   2. a failure returns the frozen sentinel (0 / NaN / -1 / 0 / "");
 *   3. the error code is set before returning the sentinel;
 *   4. the exported symbol is  extern "C" __declspec(dllexport) __cdecl .
 *
 * Writing rules 1-4 by hand for ~17,000 functions is how subtle leaks happen.
 * These macros reduce one exported function to about eight readable lines:
 *
 *     AF_FN_D(double, af_gpnt_getx, (void* h))
 *         GPnt^ s = AcGet<GPnt>(h, AF_T_GPnt, "GPnt::get_X");
 *         if (s == nullptr) { return AcNaN(); }
 *         return s->GetX();
 *     AF_END_D
 *
 * The generator emits exactly this shape; this header is hand written once
 * and never regenerated.
 * ------------------------------------------------------------------------ */

#ifndef AC_GEN_MACROS_H_INCLUDED
#define AC_GEN_MACROS_H_INCLUDED

/* Everything below is built on the shared infrastructure: the handle table, the
 * error state and the type registry all live in ac_core.h / ac_core.cpp. */
#include "ac_core.h"

/* ---------------------------------------------------------------------
 * Function shell
 *
 * AF_FN_* opens the exported function and a try block.  The return type and
 * the parameter list are passed straight through, so the generator stays free
 * to emit any C signature it needs (void*, double, int, int64_t, bool,
 * const wchar_t*).
 * ------------------------------------------------------------------- */
#define AF_FN(retType, name, paramList) \
    extern "C" __declspec(dllexport) retType __cdecl name paramList \
    { \
        try {

#define AF_FN_D(retType, name, paramList)  AF_FN(retType, name, paramList)
#define AF_FN_I(retType, name, paramList)  AF_FN(retType, name, paramList)
#define AF_FN_P(retType, name, paramList)  AF_FN(retType, name, paramList)
#define AF_FN_T(retType, name, paramList)  AF_FN(retType, name, paramList)

/* ---------------------------------------------------------------------
 * Closing half.  AF_CATCH_* always sets AC_ERR_MANAGED and always returns the
 * frozen sentinel, so an escaped exception can never be mistaken for a valid
 * result.  AF_END_V is the void variant.
 * ------------------------------------------------------------------- */
#define AF_CATCH \
        } \
        catch (System::Exception^ afEx_) { SetErrorException(AC_ERR_MANAGED, afEx_); } \
        catch (...) { SetErrorA(AC_ERR_MANAGED, "unknown native error"); }

#define AF_END_D    AF_CATCH return AcNaN(); }
#define AF_END_I    AF_CATCH return -1; }
#define AF_END_B    AF_CATCH return 0; }
#define AF_END_I64  AF_CATCH return (long long)0; }
#define AF_END_P    AF_CATCH return nullptr; }
#define AF_END_T    AF_CATCH return AcEmptyText(); }
#define AF_END_V    AF_CATCH }

/* ---------------------------------------------------------------------
 * Helpers used by the generated bodies
 * ------------------------------------------------------------------- */

/* Frozen sentinels, spelled once so the generator cannot drift. */
#define AF_NAN   (AcNaN())
#define AF_NULL  ((void*)0)

/* Build a new handle carrying typeId.  Returns 0 when the object is null, and
 * sets AC_ERR_MANAGED so the caller sees a reason instead of a silent zero. */
#define AF_NEW(obj, typeId) \
    ((obj) == nullptr ? (SetErrorA(AC_ERR_MANAGED, #obj " is null"), AF_NULL) \
                      : NewHandleRaw((obj), (typeId)))

/* Deliver a managed string through the thread local buffer (frozen lifetime:
 * valid only until the next bridge call on the same thread). */
#define AF_TEXT(managedString)  AcDeliverText(ToStd(managedString))

/* Widen a C wide string argument into a managed string (null -> nullptr). */
#define AF_WSTR(nativeWide)  ToManaged(nativeWide)

#endif /* AC_GEN_MACROS_H_INCLUDED */
