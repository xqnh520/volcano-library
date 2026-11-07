/* ------------------------------------------------------------------------
 * ac_core.h  -  shared bridge infrastructure for AnyCADBridge.dll
 *
 * THIS FILE IS PURE ASCII ON PURPOSE.  MSVC reads sources with code page 936
 * and any non ASCII byte would emit C4819 and could corrupt literals.  All
 * comments are English, all identifiers are ASCII.
 *
 * Why this file exists
 * --------------------
 * The v1 bridge (anycad_bridge.cpp, 94 exports) and the generated bridge
 * (ac_gen_*.cpp, ~17,000 exports) MUST live in one and the same DLL, because
 * they have to share ONE handle table.  If they were two DLLs, each mixed mode
 * DLL would get its own gcroot static, the tables would diverge, and a handle
 * produced by the old ac_make_box() would fail with AC_ERR_HANDLE when passed
 * to a new af_* function.  That is the single most dangerous integration risk
 * of the whole project (architecture doc section 3.6).
 *
 * Therefore the infrastructure is defined exactly ONCE here:
 *   - thread local text buffer + error code      (TextBuf / ErrorBuf / ErrorCode)
 *   - error helpers                              (SetErrorRaw / SetError / ToStd / ToManaged)
 *   - the handle table and its id generator      (AcHandleEntry / HandleTable / ...)
 *   - the type id registry used for derived-type compatibility checks
 *   - diagnostics (live handle count / report / object type name)
 *
 * anycad_bridge.cpp keeps its 94 function BODIES unchanged and now simply does
 *   #include "ac_core.h"
 * instead of carrying a local copy.  The export table is therefore byte for
 * byte identical (verified with dumpbin, see the POC report, item P1).
 *
 * Conventions that must never change (frozen ABI / frozen behaviour)
 * ------------------------------------------------------------------
 *   - A handle is a small monotonically increasing UInt64 id.  0 is invalid.
 *     Ids are NEVER reused: a released handle can never alias a new object.
 *   - Freeing is idempotent.  Freeing a handle of the wrong kind is ignored.
 *   - The table is not synchronised.  Geometry calls must be single threaded
 *     (OpenCascade is not thread safe either) - the caller serialises.
 *   - Failure sentinels: void* -> 0, double -> NaN, int count -> -1,
 *     int boolean -> 0 with the error code set, text -> "" (thread local
 *     buffer, valid only until the next bridge call on the same thread).
 *   - No managed exception may ever cross the C boundary.
 * ------------------------------------------------------------------------ */

#ifndef AC_CORE_H_INCLUDED
#define AC_CORE_H_INCLUDED

#include <vcclr.h>
#include <msclr\gcroot.h>
#include <limits>
#include <string>
#include <wchar.h>
#include <wctype.h>
#include <stdlib.h>
#include <stdint.h>      /* int64_t: the C ABI of the Long / Int64 mapping */

#include "anycad_bridge.h"     /* AC_API and the AC_ERR_* code set */

using namespace System;

/* The three historical type codes.  They used to be called AC_MAGIC_* when
 * they were written into the handle block; nothing is dereferenced any more so
 * they are plain type tags.  The numeric values are frozen: the shipped DLL and
 * the volcano module already rely on them, and the generated type id space
 * starts far above them so the two can never collide. */
#define AC_TYPE_SHAPE   0x41435348u   /* 'ACSH' */
#define AC_TYPE_LIST    0x4143534Cu   /* 'ACSL' */
#define AC_TYPE_PTLIST  0x41435054u   /* 'ACPT' */

/* ======================================================================= */
/* 1. thread local text / error buffers                                    */
/* ======================================================================= */

/* The three buffers are deliberately allocated with new and never released:
 * they must stay valid for the whole process lifetime (their c_str() is handed
 * to the caller) and a TLS destructor running after CLR shutdown would be a
 * hazard.  One small std::wstring per thread is the intended cost. */
std::wstring& TextBuf(void);
std::wstring& ErrorBuf(void);
int& ErrorCode(void);

/* "[code] text", truncated at 2000 characters.  Never throws. */
void SetErrorRaw(int code, const wchar_t* text);

/* Same, but the text is an ASCII string (used by generated code, whose
 * identifiers are always ASCII). */
void SetErrorA(int code, const char* text);

/* Same, from a managed string ("unknown managed error" when null). */
void SetErrorManaged(int code, String^ msg);

/* Same, from a caught exception: sets "[code] <ExceptionType>: <Message>". */
void SetErrorException(int code, System::Exception^ ex);

/* v1 spellings kept so that anycad_bridge.cpp stays line for line identical. */
void SetError(int code, const wchar_t* text);
void SetError(int code, String^ msg);

/* managed string -> std::wstring (null safe) */
void ToStd(String^ s, std::wstring& out);
std::wstring ToStd(String^ s);

/* native wide string -> managed string (null safe, never throws on null) */
String^ ToManaged(const wchar_t* s);

/* Replace TextBuf() with the given text and hand back its c_str().  The pointer
 * stays valid until the next bridge call on the same thread. */
const wchar_t* AcDeliverText(const std::wstring& text);

/* Empty text sentinel = "" in the thread local buffer.  Never NULL, so the
 * volcano side can assign it to a text type variable without a null check. */
const wchar_t* AcEmptyText(void);

/* Wrap a std::wstring into the thread local buffer and hand back its c_str(). */
const wchar_t* AcTextW(const std::wstring& text);

/* ======================================================================= */
/* 2. handle table                                                         */
/* ======================================================================= */

/* A handle is NOT a pointer any more: it is a small monotonically increasing
 * id that is NEVER reused.  Releasing a handle only removes its table entry,
 * so a stale handle can never be mistaken for a freshly created object.
 *
 * Why this matters: the original scheme stored a magic number inside the
 * allocated block.  Once the block was deleted and the allocator handed the
 * same block to the next NewHandle() call, the stale pointer's magic number
 * looked valid again and the type matched, so a released handle silently
 * resolved to the NEW object (~5% of free+realloc cycles, measured by QA).
 * No amount of magic number checking can fix that; only never reusing the
 * identity can. */
ref class AcHandleEntry
{
public:
    unsigned int TypeCode;   /* AC_TYPE_* (v1) or AC_T_* (generated)  */
    Object^      Obj;        /* keeps the managed object alive        */

    AcHandleEntry(unsigned int typeCode, Object^ obj)
    {
        TypeCode = typeCode;
        Obj = obj;
    }
};

typedef System::Collections::Generic::Dictionary<System::UInt64, AcHandleEntry^> AcHandleDict;

/* The single lazily created instance - THE reason this file exists.  A file
 * scope managed handle is illegal (C3145), so the dictionary is held through a
 * gcroot that lives in ac_core.cpp only. */
AcHandleDict^ HandleTable(void);

/* Take the next id.  Never returns 0. */
System::UInt64 NextHandleId(void);

/* ---------------------------------------------------------------------
 * Raw (non template) primitives.  Everything else is built on these, which
 * keeps the managed types confined to ac_core.cpp and lets the header be
 * included by translation units that only know a subset of AnyCAD.
 * ------------------------------------------------------------------- */

/* Insert obj under a fresh id.  Returns nullptr when obj is nullptr. */
void* NewHandleRaw(Object^ o, unsigned int typeCode);

/* Look up h and require entry->TypeCode == expectCode.  On any failure the
 * error code is already set and nullptr is returned.  Never dereferences h. */
Object^ LookupHandleRaw(void* h, unsigned int expectCode, const wchar_t* what);

/* Look up h and require the System::Type registered for typeId to be
 * assignable from the actual runtime type (derived class compatible).  On
 * failure the error code is AC_ERR_HANDLE (1001) or AC_ERR_HANDLE_TYPE (1002)
 * and nullptr is returned.  `what` is ASCII and ends up in the error text. */
Object^ LookupTypedRaw(void* h, unsigned int typeId, const char* what);

/* Idempotent.  A second release finds no entry and returns silently.  A handle
 * of the wrong kind is ignored as well, so ac_shape_free(list) cannot drop a
 * list entry. */
void FreeHandleRaw(void* h, unsigned int typeCode);

/* Idempotent release that ignores the type code entirely (generated code).
 * Returns 1 always, so the volcano side can ignore the result safely. */
int AcFreeAny(void* h);

/* Replace the stored object of an existing handle (struct write back).  The
 * handle value does not change.  Returns 1 on success, 0 on failure. */
int AcReplaceRaw(void* h, Object^ o, unsigned int typeId, const char* what);

/* ======================================================================= */
/* 3. type id registry (derived class compatibility)                       */
/* ======================================================================= */

/* The generated ac_types_gen.cpp publishes one System::Type per type id:
 *     AcTypeRegister(AF_T_GPnt, GPnt::typeid);
 * A native static constructor in that TU calls AcSetTypePopulate(), so the
 * whole table is filled on first use without any call from the generated
 * function bodies (one call per function would cost ~17,000 calls). */
void AcTypeRegister(unsigned int id, System::Type^ t);
System::Type^ AcTypeById(unsigned int id);

typedef void (__cdecl *AcTypePopulateFn)(void);
void AcSetTypePopulate(AcTypePopulateFn fn);

/* Number of registered type ids (diagnostics). */
int AcRegisteredTypeCount(void);

/* ======================================================================= */
/* 4. diagnostics                                                          */
/* ======================================================================= */

int AcLiveHandleCount(void);                  /* number of live entries      */
void AcLiveHandleReport(std::wstring& out);   /* "GPnt=12\nTopoShape=3\n"    */
String^ AcObjectTypeName(void* h);            /* real .NET type full name    */

/* 1 = the handle exists and still holds an object.  Never sets an error, so the
 * volcano side can call it in a condition without clearing the error state. */
int AcIsValidRaw(void* h);

/* 1 when both handles resolve to the very same managed object.  Never sets an
 * error. */
int AcSameRaw(void* a, void* b);

/* Real .NET type full name as a wide string; "" when the handle is unknown. */
const wchar_t* AcObjectTypeNameText(void* h);

/* ======================================================================= */
/* 5. templates on top of the raw primitives                               */
/* ======================================================================= */

/* v1 spelling: semantics unchanged by the refactor. */
template <typename T>
void* NewHandle(T^ o, unsigned int typeCode)
{
    return NewHandleRaw(o, typeCode);
}

/* The body below is character for character the original anycad_bridge.cpp
 * implementation, so the v1 error TEXT (observable through ac_last_error) is
 * also unchanged by the refactor, not just the export table. */
template <typename T>
T^ ValidateHandle(void* h, unsigned int expectCode, const wchar_t* what)
{
    Object^ o = LookupHandleRaw(h, expectCode, what);
    if (o == nullptr) { return nullptr; }
    T^ typed = dynamic_cast<T^>(o);        /* never throws; nullptr on mismatch */
    if (typed == nullptr)
    {
        wchar_t buf[192];
        swprintf_s(buf, L"handle %p has a different type (expecting %s)", h, what);
        SetErrorRaw(AC_ERR_HANDLE_TYPE, buf);
    }
    return typed;
}

/* v1 spelling: the type parameter is unused by the implementation (the entry
 * is checked by its stored type code), it only documents intent at the call
 * site, e.g. FreeHandle<TopoShape>(h, AC_TYPE_SHAPE). */
template <typename T>
void FreeHandle(void* h, unsigned int typeCode)
{
    FreeHandleRaw(h, typeCode);
}

/* Generated code spelling: derived class compatible, ASCII error text. */
template <typename T>
T^ AcGet(void* h, unsigned int typeId, const char* what)
{
    Object^ o = LookupTypedRaw(h, typeId, what);
    if (o == nullptr) { return nullptr; }
    T^ typed = dynamic_cast<T^>(o);
    if (typed == nullptr)
    {
        SetErrorA(AC_ERR_HANDLE_TYPE, what);
    }
    return typed;
}

/* Reference type spelling: dynamic_cast, which also accepts a derived class.
 * Only valid for ref classes / interfaces (a boxed value type has no vtable, so
 * the C++/CLI compiler rejects dynamic_cast on it). */
template <typename T>
T^ AcGetObject(void* h, unsigned int typeId, const char* what)
{
    Object^ o = LookupTypedRaw(h, typeId, what);
    if (o == nullptr) { return nullptr; }
    T^ typed = dynamic_cast<T^>(o);
    if (typed == nullptr)
    {
        SetErrorA(AC_ERR_HANDLE_TYPE, what);
    }
    return typed;
}

/* Boxed value type spelling: a boxed struct can never be a derived class, so an
 * exact type comparison is both correct and cheap.  The unboxing cast is
 * wrapped because it throws InvalidCastException on a mismatch; that exception
 * would otherwise be reported as AC_ERR_MANAGED instead of 1002. */
template <typename T>
T^ AcGetBoxed(void* h, unsigned int typeId, const char* what)
{
    Object^ o = LookupTypedRaw(h, typeId, what);
    if (o == nullptr) { return nullptr; }
    if (!T::typeid->Equals(o->GetType()))
    {
        SetErrorA(AC_ERR_HANDLE_TYPE, what);
        return nullptr;
    }
    try
    {
        return safe_cast<T^>(o);
    }
    catch (System::Exception^)
    {
        SetErrorA(AC_ERR_HANDLE_TYPE, what);
        return nullptr;
    }
}

/* Struct write back: box the value again under the same handle id.  This does
 * not rely on the mutability of a boxed value type at all (architecture P4). */
template <typename T>
int AcReplace(void* h, unsigned int typeId, const char* what, T value)
{
    return AcReplaceRaw(h, value, typeId, what);
}

/* ======================================================================= */
/* 6. frozen failure sentinels                                              */
/* ======================================================================= */

/* `double` failure sentinel: NaN, tested with  v != v  (0.0 is a legal
 * result and must never be treated as failure). */
inline double AcNaN(void)
{
    return std::numeric_limits<double>::quiet_NaN();
}

#endif /* AC_CORE_H_INCLUDED */
