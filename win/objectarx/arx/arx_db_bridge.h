// ASCII only. ObjectARX 2026 (R25) AcDb entity bridge, compiled into cadarx_test.arx.
//
// Conventions (identical to the AcGe bridge in native/arx_ge_bridge.h):
//   * AcDbObjectId travels as intptr_t; 0 means null. No AcDb pointer ever crosses the border.
//   * int returning functions answer 1 = ok, 0 = failed. arx_db_last_error() gives the raw
//     Acad::ErrorStatus code (or ARX_DB_ERR_* when the guard rejected the call itself).
//   * double returning functions answer NaN on failure.
//   * Strings are UTF-8. Buffers are owned by the caller.
//   * Geometry out-params take an already created AcGePoint3d / AcGePoint2d handle from the
//     AcGe bridge, so nothing is allocated on either side of the border.
//
// Everything here must run inside acad.exe with a current document.

#ifndef ARX_DB_BRIDGE_H
#define ARX_DB_BRIDGE_H

#include <cstdint>

#ifdef __cplusplus
extern "C" {
#endif

/* cadarx_test.arx defines the functions; every other module imports them from cadarx_test.lib. */
#ifdef ARX_DB_BUILDING
#define ARX_DB_EXPORT __declspec(dllexport)
#else
#define ARX_DB_EXPORT __declspec(dllimport)
#endif

/* Error markers used when the bridge itself refuses a call (no AcDb call happened). */
#define ARX_DB_ERR_NULL_ID      (-1)
#define ARX_DB_ERR_NULL_POINTER (-2)
#define ARX_DB_ERR_CAST         (-3)
#define ARX_DB_ERR_BUFFER       (-4)

/* Value marker returned by arx_db_entity_line_weight when the call failed. No AcDb::LineWeight is
   ever -1000 (the enum reaches -4 at its most negative), and the ARX_DB_ERR_* markers above are
   reserved for the last-error slot, so this needs its own number. */
#define ARX_DB_NO_WEIGHT        (-1000)

/* ---------- environment ---------- */

ARX_DB_EXPORT int      arx_db_has_database (void);
ARX_DB_EXPORT intptr_t arx_db_model_space (void);
ARX_DB_EXPORT intptr_t arx_db_paper_space (void);
ARX_DB_EXPORT int      arx_db_last_error (void);

/* ---------- block table record: append + walk ---------- */

ARX_DB_EXPORT int      arx_db_btr_count (intptr_t btr);                 /* skipDeleted = true  */
ARX_DB_EXPORT int      arx_db_btr_count_all (intptr_t btr);             /* skipDeleted = false */
ARX_DB_EXPORT intptr_t arx_db_btr_entity_at (intptr_t btr, int index);  /* 0-based, skipping erased */
ARX_DB_EXPORT int      arx_db_btr_name_into (intptr_t btr, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_btr_is_layout (intptr_t btr);

/* ---------- entity lifecycle ---------- */

ARX_DB_EXPORT int      arx_db_id_is_valid (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_is_line (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_is_circle (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_is_polyline (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_erase (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_is_erased (intptr_t id);
ARX_DB_EXPORT intptr_t arx_db_entity_owner (intptr_t id);
ARX_DB_EXPORT intptr_t arx_db_entity_layer_id (intptr_t id);
ARX_DB_EXPORT intptr_t arx_db_entity_handle64 (intptr_t id);
ARX_DB_EXPORT intptr_t arx_db_handle_to_id (intptr_t handle64);

/* utf8 helpers: 1 = text written, 0 = failed (buffer too small counts as failure). */
ARX_DB_EXPORT int      arx_db_entity_handle_text (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_entity_type_name (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_entity_get_layer (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_entity_set_layer (intptr_t id, const char* layerUtf8);
ARX_DB_EXPORT int      arx_db_entity_set_layer_id (intptr_t id, intptr_t layerId);
ARX_DB_EXPORT int      arx_db_entity_set_visible (intptr_t id, int visible);
ARX_DB_EXPORT int      arx_db_entity_is_visible (intptr_t id);

/* ---------- entity graphical properties (AcDbEntity common attribute surface) ---------- */

/* No read in this block takes an out-parameter: the Volcano embedded-method syntax has no way to
   hand the bridge the address of a plain integer, so every reader here returns its value directly
   and reserves a sentinel that no legal value can reach. arx_db_last_error() still carries the raw
   Acad::ErrorStatus (or the ARX_DB_ERR_* marker) after any call, so a sentinel is never the only
   evidence of a failure.
     color_index    ACI number: 0 = byBlock, 256 = byLayer, 1..255 indexed; -1 means failure.
     color_method   AcCmEntityColor::ColorMethod (0xC0 byLayer 0xC1 byBlock 0xC2 byColor 0xC3 byACI
                    0xC4 byPen 0xC5 foreground 0xC6 layerOff 0xC7 layerFrozen 0xC8 none); -1 failed.
     color_rgb      0x00RRGGBB resolved from AcCmEntityColor, so an indexed color comes back as its
                    palette RGB; -1 means failure.
     line_weight    AcDb::LineWeight in hundredths of a millimetre, plus the negative sentinels
                    (-1 byLayer, -2 byBlock, -3 byLwDefault, -4 byDIPs); -1000 means failure, which
                    is why that marker is not one of the ARX_DB_ERR_* codes.
     transparency   method 0 = byLayer 1 = byBlock 2 = byAlpha (kErrorValue is never returned) and
                    alpha 0..255 (255 = fully transparent); -1 means failure.
   Writes answer 1 = ok / 0 = failed and refuse an argument the underlying type cannot represent
   (colorIndex outside 0..65535, an rgb channel outside 0..255, a transparency method outside
   0..2 or alpha outside 0..255) with ARX_DB_ERR_CAST, while anything Acad itself rejects answers
   the raw Acad::ErrorStatus, so a rejected call is always distinguishable from an Acad failure.
   The linetype name crosses as UTF-8 like every other text entry point; linetype scale is a
   double and answers ARX_DB_NAN when the call failed. */
ARX_DB_EXPORT int      arx_db_entity_color_index (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_set_color_index (intptr_t id, int colorIndex);
ARX_DB_EXPORT int      arx_db_entity_color_method (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_color_rgb (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_set_color_rgb (intptr_t id, int red, int green, int blue);
ARX_DB_EXPORT int      arx_db_entity_linetype_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT intptr_t arx_db_entity_linetype_id (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_set_linetype (intptr_t id, const char* nameUtf8);
ARX_DB_EXPORT int      arx_db_entity_set_linetype_id (intptr_t id, intptr_t linetypeId);
ARX_DB_EXPORT double   arx_db_entity_linetype_scale (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_set_linetype_scale (intptr_t id, double scale);
ARX_DB_EXPORT int      arx_db_entity_line_weight (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_set_line_weight (intptr_t id, int weight);
ARX_DB_EXPORT int      arx_db_entity_transparency_method (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_transparency_alpha (intptr_t id);
ARX_DB_EXPORT int      arx_db_entity_set_transparency (intptr_t id, int method, int alpha);

/* ---------- AcDbLine ---------- */

ARX_DB_EXPORT intptr_t arx_db_add_line (intptr_t btr, double x1, double y1, double z1,
                                         double x2, double y2, double z2);
ARX_DB_EXPORT int      arx_db_line_start (intptr_t id, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_db_line_end (intptr_t id, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_db_line_set (intptr_t id, double x1, double y1, double z1,
                                        double x2, double y2, double z2);

/* ---------- AcDbCircle ---------- */

ARX_DB_EXPORT intptr_t arx_db_add_circle (intptr_t btr, double cx, double cy, double cz,
                                          double radius);
ARX_DB_EXPORT int      arx_db_circle_center (intptr_t id, intptr_t outPoint3d);
ARX_DB_EXPORT double   arx_db_circle_radius (intptr_t id);
ARX_DB_EXPORT int      arx_db_circle_set_radius (intptr_t id, double radius);
ARX_DB_EXPORT double   arx_db_circle_circumference (intptr_t id);

/* ---------- AcDbPolyline (lightweight 2D polyline) ---------- */

ARX_DB_EXPORT intptr_t arx_db_add_polyline (intptr_t btr);
ARX_DB_EXPORT int      arx_db_polyline_add_vertex (intptr_t id, double x, double y);
ARX_DB_EXPORT int      arx_db_polyline_vertex_count (intptr_t id);
ARX_DB_EXPORT int      arx_db_polyline_vertex2d (intptr_t id, int index, intptr_t outPoint2d);
ARX_DB_EXPORT int      arx_db_polyline_vertex3d (intptr_t id, int index, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_db_polyline_set_closed (intptr_t id, int closed);
ARX_DB_EXPORT int      arx_db_polyline_is_closed (intptr_t id);
ARX_DB_EXPORT double   arx_db_polyline_elevation (intptr_t id);
ARX_DB_EXPORT int      arx_db_polyline_set_constant_width (intptr_t id, double width);
ARX_DB_EXPORT double   arx_db_polyline_constant_width (intptr_t id);

/* ---------- AcDbCurve surface shared by line / circle / polyline ---------- */

ARX_DB_EXPORT double   arx_db_curve_length (intptr_t id);
ARX_DB_EXPORT double   arx_db_curve_area (intptr_t id);
ARX_DB_EXPORT double   arx_db_curve_start_param (intptr_t id);
ARX_DB_EXPORT double   arx_db_curve_end_param (intptr_t id);
ARX_DB_EXPORT int      arx_db_curve_point_at_param (intptr_t id, double param, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_db_curve_is_closed (intptr_t id);

/* ---------- layer table ---------- */

/* Text crosses the border as UTF-8 byte arrays since ruling 2 of package A: the Volcano
   wrappers hand these entry points a caller-owned buffer and read names back with the
   NUL-terminated contract measured in-process. arx_db_test_layer keeps the fixed CADARX_TEST
   layer so the kernel can still reach a known layer without any text at all. */
ARX_DB_EXPORT intptr_t arx_db_test_layer (void);            /* ensures L"CADARX_TEST" exists */
ARX_DB_EXPORT intptr_t arx_db_layer_at (int index);         /* 0-based, skipping erased      */
ARX_DB_EXPORT intptr_t arx_db_add_layer (const char* nameUtf8);
ARX_DB_EXPORT int      arx_db_layer_exists (const char* nameUtf8);
ARX_DB_EXPORT int      arx_db_layer_count (void);
ARX_DB_EXPORT int      arx_db_layer_name (intptr_t layerId, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_layer_set_frozen (intptr_t layerId, int frozen);
ARX_DB_EXPORT int      arx_db_layer_is_frozen (intptr_t layerId);

/* ---------- command registration (AcEd command stack) ---------- */

/* A command handler address always comes from the calling module: ObjectARX keeps the
   AcRxFunctionPtr it is handed (accmd.h typedefs it as void (*)(), no parameters, since the
   2013 API), so the Volcano side passes the address of a static method that takes nothing
   and returns nothing, taken with the global pointer helper that returns a method address.
   Command names cross the border as UTF-8 exactly like every other text entry point here;
   the wide conversion happens inside this module.
   register / remove / clear_group answer the raw Acad::ErrorStatus (0 = eOk) and keep the
   ARX_DB_ERR_* markers for arguments the bridge refused itself, so a negative answer never
   collides with an Acad code. lookup and function_addr answer 0 when the name is absent,
   flags_of answers -1, because ACRX_CMD_MODAL is legitimately zero; every read of an absent
   name also leaves the last-error slot at the ARX_DB_ERR_NULL_ID marker, like an unknown id. */
ARX_DB_EXPORT int      arx_cmd_register (const char* groupUtf8, const char* globalUtf8,
                                         const char* localUtf8, int cmdFlags, intptr_t fnAddr);
ARX_DB_EXPORT int      arx_cmd_remove (const char* groupUtf8, const char* globalUtf8);
ARX_DB_EXPORT int      arx_cmd_clear_group (const char* groupUtf8);
ARX_DB_EXPORT intptr_t arx_cmd_lookup (const char* nameUtf8, int globalFlag);
ARX_DB_EXPORT intptr_t arx_cmd_function_addr (const char* globalUtf8);
ARX_DB_EXPORT int      arx_cmd_flags_of (const char* globalUtf8);
ARX_DB_EXPORT int      arx_cmd_name_into (const char* globalUtf8, int localFlag,
                                          char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_cmd_count_in_group (const char* groupUtf8);
/* Enumeration over one group: answers how many distinct commands the group holds and writes
   the global name of the requested one into utf8Buf; an index past the end leaves the buffer
   empty and still answers the total. Both this and count_in_group share one walk, which drops
   the repeated visit a fresh AcEdCommandIterator makes on the most recently added command
   (measured: a group with the single command ZPROBE1 reported that name twice). */
ARX_DB_EXPORT int      arx_cmd_visit_group (const char* groupUtf8, int index,
                                            char* utf8Buf, int bufSize);

/* ---------- reactors (package A ruling 3: implemented here, read out as counters) ---------- */

/* The reactor objects live in this module and are never handed across the border. The calling
   side installs a family, drives AutoCAD, then reads accumulated counters plus the last payload
   name of one event, which is all the ABI shape can carry (ruling 3 asked for exactly this:
   reactors inside the .arx, read-out values outside).

   Family ids are 1..4 (the argument of is_installed); the install mask uses bit positions
   instead, so a caller can ask for several families in one call:
       bit0 (1)  editor     AcEditorReactor      registered through acedEditor->addReactor
       bit1 (2)  document   AcApDocManagerReactor registered through acDocManager->addReactor
       bit2 (4)  database   AcDbDatabaseReactor   registered on one AcDbDatabase
       bit3 (8)  object     reserved: this bit installs nothing, object reactors only exist
                            through attach_object, and such a link already counts as one
                            installed family.
   The document family has no addReactor symbol in any import library because AcEditor::addReactor
   and AcApDocManagerReactor-side registration are pure virtual (aced.h:703, acdocman.h:296);
   the calls go through the vtable, which is exactly how the SDK samples do it.
   The database family binds to the working database found at install time and AutoCAD does not
   move it: after a document switch it still notifies about the old database.

   Event ids are flat integers; this module does not build a constant class for them.
       11 commandWillStart  12 commandEnded  13 commandCancelled  14 commandFailed
       15 unknownCommand    16 lispWillStart 17 sysVarChanged
       21 createStarted  22 created  23 toBeDestroyed  24 destroyed  25 toBeActivated
       26 activated  27 toBeDeactivated  28 becameCurrent  29 lockModeWillChange
       30 lockModeChanged  31 lockModeChangeVetoed
       41 objectAppended  42 objectUnAppended  43 objectReAppended  44 objectOpenedForModify
       45 objectModified  46 objectErased  47 headerSysVarWillChange  48 headerSysVarChanged
       49 databaseGoodbye
       61 openedForModify  62 modified  63 subObjModified  64 modifyUndone  65 erased
       66 unappended  67 reappended  68 objectClosed  69 cancelled  70 copied
       71 modifiedXData  72 objectGoodbye
   An id outside that table answers the ARX_DB_ERR_NULL_ID marker instead of zero, so "no such
   event" can never be read as "fired zero times". */
ARX_DB_EXPORT int      arx_rx_install (int mask);           /* families installed after the call */
ARX_DB_EXPORT int      arx_rx_uninstall (void);             /* families detached by this call    */
ARX_DB_EXPORT int      arx_rx_is_installed (int family);    /* 1 / 0, -1 for an unknown family   */
ARX_DB_EXPORT int      arx_rx_reset (void);                 /* slots cleared, answers the count  */
ARX_DB_EXPORT int      arx_rx_event_count (int eventId);
ARX_DB_EXPORT int      arx_rx_event_name_into (int eventId, char* utf8Buf, int bufSize);
/* Object-level attach. addReactor/removeReactor are const on AcDbObject (dbObject.h:358/370), so
   both open the entity for read only. The answers are raw Acad::ErrorStatus codes (0 = eOk,
   22 = eKeyNotFound, 23 = eDuplicateKey); the bridge keeps a small registry so detaching an id
   that was never attached answers 22 without touching AutoCAD, and attaching the same id twice
   answers 23 for the same reason a repeated pointer would.
   The id must be one this bridge handed back earlier. A made-up integer is opened straight
   through acdbOpenObject, and the probe measured (2026-10-15, attach of the literal 12345) that
   AutoCAD stops the whole process with its fatal-error abort dialog on such a stub, so no integer
   that did not come out of arx_db_* may be fed in here. */
ARX_DB_EXPORT int      arx_rx_attach_object (intptr_t id);
ARX_DB_EXPORT int      arx_rx_detach_object (intptr_t id);

/* ---------- struct sizes, for the layout assertions ---------- */

ARX_DB_EXPORT int      arx_db_sizeof_object_id (void);
ARX_DB_EXPORT int      arx_db_sizeof_handle (void);
ARX_DB_EXPORT int      arx_db_sizeof_line (void);
ARX_DB_EXPORT int      arx_db_sizeof_circle (void);
ARX_DB_EXPORT int      arx_db_sizeof_polyline (void);
/* The transparency reads take the method out of the high byte of AcCmTransparency, so the four
   byte layout is load bearing; these two sizes are the only way the Volcano side can check it. */
ARX_DB_EXPORT int      arx_db_sizeof_transparency (void);
ARX_DB_EXPORT int      arx_db_sizeof_entity_color (void);

/* ---------- runtime module lifecycle (unload safety) ----------
   acrxLoadModule / acrxUnloadModule / acrxUnloadApp are the public runtime entries declared in
   rxregsvc.h, and all three take a plain const ACHAR* (wchar_t*), which is exactly what the
   Volcano text type's GetText() hands over, so no code conversion happens in this bridge. They
   answer a plain bool (verified in rxregsvc.h) and carry no Acad::ErrorStatus, so these exports
   report success only through 1/0 and leave the last-error slot at 0 unless the pointer itself
   was NULL (-2). arx_image_mapped is pure Win32 GetModuleHandleW and touches no AutoCAD state, so
   it stays readable after the module is gone. */

ARX_DB_EXPORT int      arx_module_load (const wchar_t* name, int printit);
ARX_DB_EXPORT int      arx_module_unload (const wchar_t* name, int asCmd);
ARX_DB_EXPORT int      arx_app_unload (const wchar_t* name);
ARX_DB_EXPORT int      arx_image_mapped (const wchar_t* path);
ARX_DB_EXPORT int      arx_kernel_mapped (void);
ARX_DB_EXPORT int      arx_kernel_free_code (void);

/* ---------- AcDbText (single line text) ----------
   Package A, required item 2. Text that crosses into AcDb arrives as a plain const wchar_t*
   (the Volcano public method hands over its text type's GetText()), exactly like the module
   lifecycle entries above, so no code page conversion happens here. Text read out of AcDb
   arrives as UTF-8 into a caller owned buffer because the border has no string type.
   Out geometry parameters take handles created by the AcGe bridge (AcGePoint3d / AcGeVector3d /
   AcGeMatrix3d / AcGePlane), so nothing is allocated on either side.
   Enum parameters (AcDb::TextHorzMode, AcDb::TextVertMode, AcDbText::AcTextAlignment) travel as
   plain ints; the bridge casts and the Volcano comment carries the value table. */

ARX_DB_EXPORT int      arx_db_is_text (intptr_t id);
ARX_DB_EXPORT intptr_t arx_db_add_text (intptr_t btr, double x, double y, double z,
                                        double height, double rotation, const wchar_t* text,
                                        intptr_t styleId);
ARX_DB_EXPORT int      arx_db_text_string_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_text_string_const_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_text_set_string (intptr_t id, const wchar_t* text);
ARX_DB_EXPORT int      arx_db_text_position (intptr_t id, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_db_text_set_position (intptr_t id, double x, double y, double z);
ARX_DB_EXPORT int      arx_db_text_alignment_point (intptr_t id, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_db_text_set_alignment_point (intptr_t id, double x, double y, double z);
ARX_DB_EXPORT int      arx_db_text_is_default_alignment (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_normal (intptr_t id, intptr_t outVector3d);
ARX_DB_EXPORT int      arx_db_text_set_normal (intptr_t id, double x, double y, double z);
ARX_DB_EXPORT int      arx_db_text_plane (intptr_t id, intptr_t outPlane);
ARX_DB_EXPORT double   arx_db_text_thickness (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_thickness (intptr_t id, double value);
ARX_DB_EXPORT double   arx_db_text_oblique (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_oblique (intptr_t id, double value);
ARX_DB_EXPORT double   arx_db_text_rotation (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_rotation (intptr_t id, double value);
ARX_DB_EXPORT double   arx_db_text_height (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_height (intptr_t id, double value);
ARX_DB_EXPORT double   arx_db_text_width_factor (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_width_factor (intptr_t id, double value);
ARX_DB_EXPORT intptr_t arx_db_text_style (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_style (intptr_t id, intptr_t styleId);
ARX_DB_EXPORT int      arx_db_text_is_mirrored_x (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_mirror_x (intptr_t id, int on);
ARX_DB_EXPORT int      arx_db_text_is_mirrored_y (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_mirror_y (intptr_t id, int on);
ARX_DB_EXPORT int      arx_db_text_horz_mode (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_horz_mode (intptr_t id, int mode);
ARX_DB_EXPORT int      arx_db_text_vert_mode (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_vert_mode (intptr_t id, int mode);
ARX_DB_EXPORT int      arx_db_text_justification (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_set_justification (intptr_t id, int value);
ARX_DB_EXPORT int      arx_db_text_correct_spelling (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_adjust_alignment (intptr_t id, int useCurrentDb);
ARX_DB_EXPORT int      arx_db_text_hit_test (intptr_t id, double x, double y, double z);
ARX_DB_EXPORT int      arx_db_text_bounding_count (intptr_t id);
ARX_DB_EXPORT int      arx_db_text_bounding_at (intptr_t id, int index, intptr_t outPoint3d);

/* ---------- AcDbMText (multiline text) ---------- */

ARX_DB_EXPORT int      arx_db_is_mtext (intptr_t id);
ARX_DB_EXPORT intptr_t arx_db_add_mtext (intptr_t btr, double x, double y, double z,
                                        const wchar_t* contents, double height, double width,
                                        intptr_t styleId);
ARX_DB_EXPORT int      arx_db_mtext_contents_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_mtext_plain_text_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_mtext_rtf_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_mtext_set_contents (intptr_t id, const wchar_t* contents);
ARX_DB_EXPORT int      arx_db_mtext_set_contents_rtf (intptr_t id, const wchar_t* rtf);
ARX_DB_EXPORT int      arx_db_mtext_code_into (int index, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_mtext_location (intptr_t id, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_db_mtext_set_location (intptr_t id, double x, double y, double z);
ARX_DB_EXPORT int      arx_db_mtext_normal (intptr_t id, intptr_t outVector3d);
ARX_DB_EXPORT int      arx_db_mtext_set_normal (intptr_t id, double x, double y, double z);
ARX_DB_EXPORT int      arx_db_mtext_direction (intptr_t id, intptr_t outVector3d);
ARX_DB_EXPORT int      arx_db_mtext_set_direction (intptr_t id, double x, double y, double z);
ARX_DB_EXPORT double   arx_db_mtext_rotation (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_rotation (intptr_t id, double value);
ARX_DB_EXPORT double   arx_db_mtext_width (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_width (intptr_t id, double value);
ARX_DB_EXPORT double   arx_db_mtext_text_height (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_text_height (intptr_t id, double value);
ARX_DB_EXPORT double   arx_db_mtext_ascent (intptr_t id);
ARX_DB_EXPORT double   arx_db_mtext_descent (intptr_t id);
ARX_DB_EXPORT double   arx_db_mtext_actual_width (intptr_t id);
ARX_DB_EXPORT double   arx_db_mtext_actual_height (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_attachment (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_attachment (intptr_t id, int point);
ARX_DB_EXPORT int      arx_db_mtext_set_attachment_moving_location (intptr_t id, int point);
ARX_DB_EXPORT int      arx_db_mtext_flow_direction (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_flow_direction (intptr_t id, int value);
ARX_DB_EXPORT int      arx_db_mtext_line_spacing_style (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_line_spacing_style (intptr_t id, int value);
ARX_DB_EXPORT double   arx_db_mtext_line_spacing_factor (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_line_spacing_factor (intptr_t id, double value);
ARX_DB_EXPORT int      arx_db_mtext_show_borders (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_show_borders (intptr_t id, int enable);
ARX_DB_EXPORT int      arx_db_mtext_background_fill_on (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_background_fill (intptr_t id, int enable);
ARX_DB_EXPORT int      arx_db_mtext_use_background_color_on (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_use_background_color (intptr_t id, int enable);
ARX_DB_EXPORT int      arx_db_mtext_background_rgb (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_background_rgb (intptr_t id, int red, int green, int blue);
ARX_DB_EXPORT double   arx_db_mtext_background_scale (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_background_scale (intptr_t id, double scale);
ARX_DB_EXPORT int      arx_db_mtext_background_transparency_method (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_background_transparency_alpha (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_background_transparency (intptr_t id, int method, int alpha);
ARX_DB_EXPORT int      arx_db_mtext_ecs (intptr_t id, intptr_t outMatrix3d);
ARX_DB_EXPORT int      arx_db_mtext_plane (intptr_t id, intptr_t outPlane);
ARX_DB_EXPORT intptr_t arx_db_mtext_style (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_set_style (intptr_t id, intptr_t styleId);
ARX_DB_EXPORT int      arx_db_mtext_correct_spelling (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_hit_test (intptr_t id, double x, double y, double z);
ARX_DB_EXPORT int      arx_db_mtext_bounding_count (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_bounding_at (intptr_t id, int index, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_db_mtext_bounding_line_count (intptr_t id);
ARX_DB_EXPORT int      arx_db_mtext_bounding_line_point_count (intptr_t id, int line);
ARX_DB_EXPORT int      arx_db_mtext_bounding_line_point_at (intptr_t id, int line, int index,
                                                            intptr_t outPoint3d);

/* ---------- AcDbTextStyleTable ---------- */

ARX_DB_EXPORT int      arx_db_style_count (void);
ARX_DB_EXPORT intptr_t arx_db_style_at (int index);
ARX_DB_EXPORT intptr_t arx_db_style_get_at (const wchar_t* name);
ARX_DB_EXPORT int      arx_db_style_exists (const wchar_t* name);
ARX_DB_EXPORT intptr_t arx_db_style_ensure (const wchar_t* name);
ARX_DB_EXPORT int      arx_db_style_name_into (intptr_t styleId, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_style_file_name_into (intptr_t styleId, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_style_set_file_name (intptr_t styleId, const wchar_t* fileName);
ARX_DB_EXPORT int      arx_db_style_big_file_name_into (intptr_t styleId, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_db_style_set_big_file_name (intptr_t styleId, const wchar_t* fileName);
ARX_DB_EXPORT double   arx_db_style_text_size (intptr_t styleId);
ARX_DB_EXPORT int      arx_db_style_set_text_size (intptr_t styleId, double value);
ARX_DB_EXPORT double   arx_db_style_x_scale (intptr_t styleId);
ARX_DB_EXPORT int      arx_db_style_set_x_scale (intptr_t styleId, double value);
ARX_DB_EXPORT double   arx_db_style_obliquing_angle (intptr_t styleId);
ARX_DB_EXPORT int      arx_db_style_set_obliquing_angle (intptr_t styleId, double value);
ARX_DB_EXPORT double   arx_db_style_prior_size (intptr_t styleId);
ARX_DB_EXPORT int      arx_db_style_set_prior_size (intptr_t styleId, double value);
ARX_DB_EXPORT int      arx_db_style_flag_bits (intptr_t styleId);
ARX_DB_EXPORT int      arx_db_style_set_flag_bits (intptr_t styleId, int bits);
ARX_DB_EXPORT int      arx_db_style_is_shape_file (intptr_t styleId);
ARX_DB_EXPORT int      arx_db_style_set_is_shape_file (intptr_t styleId, int shape);
ARX_DB_EXPORT int      arx_db_style_is_vertical (intptr_t styleId);
ARX_DB_EXPORT int      arx_db_style_set_is_vertical (intptr_t styleId, int vertical);

/* ---------- Package A, required item 3a: block table, block definitions, block references.

   Block records and block references are both AcDbObjects, so every entry point takes and
   returns the same flat intptr_t handle convention used above. Out geometry parameters take
   handles created by the AcGe bridge (AcGePoint3d); the scalar-only reads (scale factors,
   rotation, normal) answer a double and return ARX_DB_NAN when the call failed, because the
   Volcano embedded-method syntax cannot take the address of a plain local. Text out of AcDb
   arrives as UTF-8 into a caller owned buffer; text in arrives as const wchar_t*.
   Enum parameters (AcDbBlockTableRecord::BlockScaling, AcDb::UnitsValue) travel as plain ints;
   the bridge casts, refuses values outside the documented range with ARX_DB_ERR_CAST, and the
   Volcano comment carries the value table. ---------- */

/* block table: enumerate, look up, create, remove */
ARX_DB_EXPORT int      arx_blk_count (void);
ARX_DB_EXPORT intptr_t arx_blk_at (int index);                        /* 0-based, skipping erased */
ARX_DB_EXPORT intptr_t arx_blk_id_by_name (const wchar_t* name);
ARX_DB_EXPORT int      arx_blk_exists (const wchar_t* name);
ARX_DB_EXPORT intptr_t arx_blk_add (const wchar_t* name);
ARX_DB_EXPORT int      arx_blk_erase (intptr_t btr);

/* block record: flags and base point */
ARX_DB_EXPORT int      arx_blk_is_anonymous (intptr_t btr);
ARX_DB_EXPORT int      arx_blk_has_attrib_definitions (intptr_t btr);
ARX_DB_EXPORT int      arx_blk_is_from_xref (intptr_t btr);
ARX_DB_EXPORT int      arx_blk_is_from_overlay (intptr_t btr);
ARX_DB_EXPORT int      arx_blk_xref_status (intptr_t btr);            /* AcDb::XrefStatus, -1 fails */
ARX_DB_EXPORT int      arx_blk_origin_into (intptr_t btr, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_blk_set_origin (intptr_t btr, double x, double y, double z);

/* block record: which references point at it */
ARX_DB_EXPORT int      arx_blk_ref_count (intptr_t btr);
ARX_DB_EXPORT intptr_t arx_blk_ref_at (intptr_t btr, int index);      /* 0-based */

/* block record: text and insertion behaviour */
ARX_DB_EXPORT int      arx_blk_comments_into (intptr_t btr, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_blk_set_comments (intptr_t btr, const wchar_t* comments);
ARX_DB_EXPORT int      arx_blk_scaling (intptr_t btr);                /* 0 kAny 1 kUniform, -1 fails */
ARX_DB_EXPORT int      arx_blk_set_scaling (intptr_t btr, int value); /* 0..1, else ARX_DB_ERR_CAST */
ARX_DB_EXPORT int      arx_blk_is_explodable (intptr_t btr);
ARX_DB_EXPORT int      arx_blk_set_explodable (intptr_t btr, int value);
ARX_DB_EXPORT int      arx_blk_insert_units (intptr_t btr);           /* AcDb::UnitsValue, -1 fails */
ARX_DB_EXPORT int      arx_blk_set_insert_units (intptr_t btr, int value); /* 0..24, else CAST */

/* block reference: create and point at a definition */
ARX_DB_EXPORT intptr_t arx_bref_add (intptr_t btr, intptr_t blockId,
                                     double x, double y, double z);
ARX_DB_EXPORT intptr_t arx_bref_block_id (intptr_t bref);
ARX_DB_EXPORT int      arx_bref_set_block_id (intptr_t bref, intptr_t blockId);

/* block reference: placement */
ARX_DB_EXPORT int      arx_bref_position_into (intptr_t bref, intptr_t outPoint3d);
ARX_DB_EXPORT int      arx_bref_set_position (intptr_t bref, double x, double y, double z);
ARX_DB_EXPORT double   arx_bref_scale_x (intptr_t bref);
ARX_DB_EXPORT double   arx_bref_scale_y (intptr_t bref);
ARX_DB_EXPORT double   arx_bref_scale_z (intptr_t bref);
ARX_DB_EXPORT int      arx_bref_set_scale (intptr_t bref, double sx, double sy, double sz);
ARX_DB_EXPORT double   arx_bref_rotation (intptr_t bref);
ARX_DB_EXPORT int      arx_bref_set_rotation (intptr_t bref, double value);
ARX_DB_EXPORT double   arx_bref_normal_x (intptr_t bref);
ARX_DB_EXPORT double   arx_bref_normal_y (intptr_t bref);
ARX_DB_EXPORT double   arx_bref_normal_z (intptr_t bref);
ARX_DB_EXPORT int      arx_bref_set_normal (intptr_t bref, double x, double y, double z);

/* block reference: attributes attached to this insertion (count + indexed id) */
ARX_DB_EXPORT int      arx_bref_attrib_count (intptr_t bref);
ARX_DB_EXPORT intptr_t arx_bref_attrib_at (intptr_t bref, int index); /* 0-based */

/* attribute definitions living inside a block record (AcDbAttributeDefinition).
   tag/prompt/text cross the border as UTF-8 buffers; the four flags are separate
   read/write arms because the SDK has no flag mask on these classes. */
ARX_DB_EXPORT int      arx_db_is_attribute_definition (intptr_t id);
ARX_DB_EXPORT int      arx_blk_attdef_count (intptr_t btr);
ARX_DB_EXPORT intptr_t arx_blk_attdef_at (intptr_t btr, int index);   /* 0-based */
ARX_DB_EXPORT intptr_t arx_attdef_add (intptr_t btr, double x, double y, double z,
                                       const wchar_t* text, const wchar_t* tag,
                                       const wchar_t* prompt, intptr_t styleId);
ARX_DB_EXPORT int      arx_attdef_tag_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_attdef_set_tag (intptr_t id, const wchar_t* tag);
ARX_DB_EXPORT int      arx_attdef_prompt_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_attdef_set_prompt (intptr_t id, const wchar_t* prompt);
ARX_DB_EXPORT int      arx_attdef_is_invisible (intptr_t id);        /* 1/0, -1 fails */
ARX_DB_EXPORT int      arx_attdef_set_invisible (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attdef_is_constant (intptr_t id);
ARX_DB_EXPORT int      arx_attdef_set_constant (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attdef_is_verifiable (intptr_t id);
ARX_DB_EXPORT int      arx_attdef_set_verifiable (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attdef_is_preset (intptr_t id);
ARX_DB_EXPORT int      arx_attdef_set_preset (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attdef_field_length (intptr_t id);        /* 0..65535, -1 fails */
ARX_DB_EXPORT int      arx_attdef_set_field_length (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attdef_lock_position (intptr_t id);
ARX_DB_EXPORT int      arx_attdef_set_lock_position (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attdef_is_mtext (intptr_t id);

/* attributes hanging off one insertion (AcDbAttribute) */
ARX_DB_EXPORT int      arx_db_is_attribute (intptr_t id);
ARX_DB_EXPORT intptr_t arx_attrib_add (intptr_t bref, double x, double y, double z,
                                       const wchar_t* text, const wchar_t* tag,
                                       intptr_t styleId);
ARX_DB_EXPORT int      arx_bref_append_attrib (intptr_t bref, intptr_t attribId);
ARX_DB_EXPORT int      arx_bref_open_attrib (intptr_t bref, intptr_t attribId);
ARX_DB_EXPORT int      arx_attrib_tag_into (intptr_t id, char* utf8Buf, int bufSize);
ARX_DB_EXPORT int      arx_attrib_set_tag (intptr_t id, const wchar_t* tag);
ARX_DB_EXPORT int      arx_attrib_is_invisible (intptr_t id);
ARX_DB_EXPORT int      arx_attrib_set_invisible (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attrib_is_constant (intptr_t id);
ARX_DB_EXPORT int      arx_attrib_is_verifiable (intptr_t id);
ARX_DB_EXPORT int      arx_attrib_is_preset (intptr_t id);
ARX_DB_EXPORT int      arx_attrib_field_length (intptr_t id);
ARX_DB_EXPORT int      arx_attrib_set_field_length (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attrib_lock_position (intptr_t id);
ARX_DB_EXPORT int      arx_attrib_set_lock_position (intptr_t id, int value);
ARX_DB_EXPORT int      arx_attrib_is_mtext (intptr_t id);


/* Pack A must-do #4: the transaction tier. Markers used only when no AcDb call produced a code
   (acTransactionManagerPtr() is an inline that answers NULL without one, and
   startTransaction()/topTransaction() answer NULL without one either). Acad::ErrorStatus values
   are all positive, so these cannot collide with a real code. */
#define ARX_DB_ERR_NO_DOC       (-5)    /* acTransactionManagerPtr() answered NULL: no current document */
#define ARX_DB_ERR_NO_TRANS     (-6)    /* end/abort/hold asked while no transaction was active */
#define ARX_DB_ERR_TRANS_START  (-7)    /* startTransaction() answered NULL with a manager present */

/* transaction lifecycle, counters and diagnostics (AcDbTransactionManager / AcTransaction) */
ARX_DB_EXPORT int      arx_tr_start (void);
ARX_DB_EXPORT int      arx_tr_end (void);
ARX_DB_EXPORT int      arx_tr_abort (void);
ARX_DB_EXPORT int      arx_tr_active_count (void);
ARX_DB_EXPORT int      arx_tr_opened_count (void);
ARX_DB_EXPORT int      arx_tr_has_top (void);
ARX_DB_EXPORT int      arx_tr_top_opened_count (void);
ARX_DB_EXPORT intptr_t arx_tr_opened_id_at (int index);
ARX_DB_EXPORT int      arx_tr_enable_flush (int on);
ARX_DB_EXPORT int      arx_tr_flush (void);
ARX_DB_EXPORT int      arx_tr_hold (intptr_t id, int mode);
ARX_DB_EXPORT int      arx_tr_hold_twice (intptr_t id, int firstMode, int secondMode);

#ifdef __cplusplus
} // extern "C"
#endif

#endif // ARX_DB_BRIDGE_H
