/* ------------------------------------------------------------------------
 * anycad_bridge.h  -  C ABI for AnyCADBridge.dll
 *
 * AnyCAD Rapid .NET  ->  plain C bridge  (C++/CLI mixed mode DLL)
 *
 * Conventions
 *   - All functions are extern "C" __cdecl.  Symbol names are pure ASCII.
 *   - Handles are opaque void* values but they are NOT pointers: they are
 *     small monotonically increasing ids looked up in an internal table.
 *     An id is NEVER reused, therefore a handle that has been released always
 *     fails from then on with AC_ERR_HANDLE (1001) - it can never silently
 *     resolve to another object.  A handle returned by a "creator" function is
 *     owned by the caller and MUST be released with the matching *_free().
 *     Handles passed IN as arguments are never released by the bridge.
 *     The handle table is not synchronised: calls that use handles from
 *     several threads must be serialised by the caller.
 *   - double results: failure is reported as NaN (test with  value != value).
 *     0.0 is a legal result and must not be treated as failure.
 *   - int results: >= 0 / 1,0 for counts and booleans; -1 for failure.
 *     Boolean style functions return 0 on failure and also set the error code.
 *   - const wchar_t* results: never NULL (empty string on failure, error set).
 *     The pointer refers to a thread local buffer that stays valid only until
 *     the next bridge call on the same thread.  Copy the string immediately.
 *   - const wchar_t* arguments: NULL is allowed and treated as "".
 *   - Every function catches all managed exceptions; nothing escapes the C
 *     boundary.  On failure inspect ac_last_error() / ac_last_error_code().
 *   - Geometry calls must all be issued from one single thread (OpenCascade is
 *     not thread safe).  The bridge contains no UI / rendering code at all.
 *
 * This header is pure ASCII on purpose: it is compiled by the Volcano
 * toolchain with code page 936 and any non ASCII byte would break it.
 * ------------------------------------------------------------------------ */

#ifndef ANYCAD_BRIDGE_H_INCLUDED
#define ANYCAD_BRIDGE_H_INCLUDED

#if defined(_MSC_VER)
#  if defined(AC_BRIDGE_BUILD)
#    define AC_API __declspec(dllexport)
#  else
#    define AC_API __declspec(dllimport)
#  endif
#else
#  define AC_API
#endif

#ifdef __cplusplus
extern "C" {
#endif

/* ------------------------------ error codes ------------------------------ */
#define AC_OK               0
#define AC_ERR_HANDLE       1001   /* null / invalid / already released handle  */
#define AC_ERR_HANDLE_TYPE  1002   /* handle type mismatch (shape vs list)     */
#define AC_ERR_ARG          1003   /* illegal argument (range / radius / text) */
#define AC_ERR_GEOMETRY     1004   /* geometry operation produced nothing      */
#define AC_ERR_MANAGED      1005   /* managed exception caught inside bridge   */
#define AC_ERR_FILE         1006   /* file not found / unsupported / no access */
#define AC_ERR_VIEW         1007   /* reserved (v1 does not raise it)          */
#define AC_ERR_INIT         1008   /* initialization failed (missing runtime)  */
#define AC_ERR_UNSUPPORTED  1009   /* operation not supported                  */
#define AC_ERR_THREAD       1010   /* reserved: concurrent geometry misuse     */

/* ============================ 1. kernel (6) ============================= */

/* Bridge / AnyCAD / .NET version, single line, for bug reports. */
AC_API const wchar_t* ac_version(void);

/* Must be called once before any other call.  1 = ok, 0 = failed. */
AC_API int ac_init(void);

/* Full text of the last error, prefixed with "[code] ".  "" when none. */
AC_API const wchar_t* ac_last_error(void);

/* Numeric code of the last error, 0 when none. */
AC_API int ac_last_error_code(void);

/* Reset the thread local error state. */
AC_API void ac_clear_error(void);

/* Multi line dump of every enum used by the bridge ("NAME=value"), followed by
 * a short "[render]" block with the renderer state.  Diagnostic use only. */
AC_API const wchar_t* ac_dump_enums(void);

/* ============================ 2. shape (20) ============================= */

/* 1 = usable shape, 0 = null / invalid / already released handle or empty
 * shape.  Never sets an error. */
AC_API int ac_shape_is_valid(void* h);

/* "COMPOUND"/"COMPSOLID"/"SOLID"/"SHELL"/"FACE"/"WIRE"/"EDGE"/"VERTEX"/
 * "SHAPE".  "" on failure. */
AC_API const wchar_t* ac_shape_type_name(void* h);

/* Total surface area.  FACE -> area of that face.  SOLID/SHELL/COMPOUND ->
 * sum of the areas of all FACE children.  NaN on failure. */
AC_API double ac_shape_area(void* h);

/* Volume.  Only SOLID / COMPSOLID / COMPOUND are meaningful.
 * FACE / WIRE / EDGE / VERTEX -> NaN and AC_ERR_GEOMETRY (1004).
 * Useful reverse assertion: ac_shape_volume(face) must be NaN. */
AC_API double ac_shape_volume(void* h);

/* Total edge length.  Sum of EdgeLength() over all EDGE children. */
AC_API double ac_shape_edge_length(void* h);

/* Center of mass components. */
AC_API double ac_shape_com_x(void* h);
AC_API double ac_shape_com_y(void* h);
AC_API double ac_shape_com_z(void* h);

/* Axis aligned bounding box.  Size = max - min. */
AC_API double ac_shape_bbox_min_x(void* h);
AC_API double ac_shape_bbox_min_y(void* h);
AC_API double ac_shape_bbox_min_z(void* h);
AC_API double ac_shape_bbox_max_x(void* h);
AC_API double ac_shape_bbox_max_y(void* h);
AC_API double ac_shape_bbox_max_z(void* h);

/* Number of sub shapes of the given type name.  -1 on failure. */
AC_API int ac_shape_child_count(void* h, const wchar_t* typeName);

/* New list handle holding the sub shapes (caller frees).  Note the difference:
 * an empty result still returns a valid EMPTY list handle, only a handle or
 * memory failure returns NULL.  Use ac_list_count() to test for emptiness. */
AC_API void* ac_shape_children(void* h, const wchar_t* typeName);

/* New shape handle for sub shape #index (0 based, caller frees). */
AC_API void* ac_shape_child(void* h, const wchar_t* typeName, int index);

/* Independent deep copy (caller frees). */
AC_API void* ac_shape_clone(void* h);

/* BREP text of the shape (may be several hundred KB).  "" on failure. */
AC_API const wchar_t* ac_shape_to_brep(void* h);

/* Release a shape handle.  NULL, repeated calls and handles of the wrong kind
 * are safe (silently ignored).  After this the handle is permanently invalid:
 * every later call using it returns AC_ERR_HANDLE (1001).  Set your variable
 * to 0 as well so the mistake cannot be made by accident. */
AC_API void ac_shape_free(void* h);

/* ======================== 3. shape list (7) ============================= */

AC_API void* ac_list_new(void);
AC_API void ac_list_free(void* l);
/* Returns the new element count, -1 on failure.  The list keeps a strong
 * reference, so the shape handle may be freed right after this call. */
AC_API int ac_list_add(void* l, void* shape);
AC_API int ac_list_count(void* l);
/* New shape handle (caller frees), NULL on failure / out of range. */
AC_API void* ac_list_get(void* l, int index);
AC_API int ac_list_clear(void* l);
/* Returns the element count after removal, -1 on failure. */
AC_API int ac_list_remove(void* l, int index);

/* ======================== 4. point list (5) ============================= */

AC_API void* ac_ptl_new(void);
AC_API void ac_ptl_free(void* p);
/* Returns the new point count, -1 on failure. */
AC_API int ac_ptl_add(void* p, double x, double y, double z);
AC_API int ac_ptl_count(void* p);
AC_API int ac_ptl_clear(void* p);

/* ========================= 5. primitives (7) ============================ */
/* Plane of a primitive = point (px,py,pz) + normal (nx,ny,nz).
 * The normal is normalized internally; a zero normal is AC_ERR_ARG. */

AC_API void* ac_make_box(double px, double py, double pz,
                         double nx, double ny, double nz,
                         double dx, double dy, double dz);

AC_API void* ac_make_sphere(double cx, double cy, double cz, double radius);

AC_API void* ac_make_cylinder(double px, double py, double pz,
                              double nx, double ny, double nz,
                              double radius, double height, double angle);

AC_API void* ac_make_cone(double px, double py, double pz,
                          double nx, double ny, double nz,
                          double radius, double radiusTop,
                          double height, double angle);

AC_API void* ac_make_torus(double majorR, double minorR,
                           double px, double py, double pz,
                           double nx, double ny, double nz);

AC_API void* ac_make_pyramid(double px, double py, double pz,
                             double nx, double ny, double nz,
                             int sides, double radius, double height);

AC_API void* ac_make_tube(double lx, double ly, double lz,
                          double dirx, double diry, double dirz,
                          double innerR, double thickness, double len);

/* ============================ 6. sketch (11) ============================ */
/* CurveBuilder results are EDGE / WIRE, not faces.  Use ac_make_face
 * (or let ac_feat_extrude do it) before extruding / revolving. */

AC_API void* ac_make_vertex(double x, double y, double z);

AC_API void* ac_make_line(double x1, double y1, double z1,
                          double x2, double y2, double z2);

AC_API void* ac_make_circle(double px, double py, double pz,
                            double nx, double ny, double nz, double radius);

/* Order is start -> end -> middle, exactly like AnyCAD. */
AC_API void* ac_make_arc3p(double sx, double sy, double sz,
                           double ex, double ey, double ez,
                           double mx, double my, double mz);

AC_API void* ac_make_rectangle(double px, double py, double pz,
                               double nx, double ny, double nz,
                               double len, double width, double cornerR,
                               int filled);

AC_API void* ac_make_polygon_n(double px, double py, double pz,
                               double nx, double ny, double nz,
                               int sides, double radius);

AC_API void* ac_make_polygon_pts(void* ptList, int closed);
AC_API void* ac_make_polyline(void* ptList);
AC_API void* ac_make_bspline(void* ptList);
AC_API void* ac_make_bezier(void* ptList);

/* ac_make_face: convert a closed WIRE / EDGE into a planar FACE.  An input
 * that already is a FACE is returned as an independent copy.  Not closed or
 * not planar -> NULL and AC_ERR_GEOMETRY (1004). */
AC_API void* ac_make_face(void* wire);

/* ============================ 7. boolean (10) =========================== */

AC_API void* ac_bool_common(void* a, void* b);
AC_API void* ac_bool_cut(void* a, void* b);
AC_API void* ac_bool_cut_list(void* a, void* list);
AC_API void* ac_bool_fuse2(void* a, void* b);
AC_API void* ac_bool_fuse_list(void* list);
AC_API void* ac_bool_unify(void* a, int unifyEdges, int unifyFaces,
                           int concatBSplines);
AC_API void* ac_bool_split(void* shape, void* tool);
AC_API void* ac_bool_sewing_list(void* list);
AC_API void* ac_bool_sewing2(void* a, void* b);
AC_API void* ac_bool_simplify(void* a);

/* ============================ 8. feature (11) =========================== */
/* Angles are radians.  Edge / face indexes in the CSV arguments are 0 based,
 * separated by a comma, e.g. "0,2,5". */

AC_API void* ac_feat_extrude(void* base, double height,
                             double dx, double dy, double dz);

AC_API void* ac_feat_revolve(void* base,
                             double px, double py, double pz,
                             double ax, double ay, double az, double angle);

AC_API void* ac_feat_loft2(void* wireA, void* wireB, int solid);
AC_API void* ac_feat_loft_list(void* list, int solid, int checkCompat);
AC_API void* ac_feat_sweep(void* section, void* path,
                           const wchar_t* transitionName, int solid);
AC_API void* ac_feat_fillet_all(void* shape, double radius);
AC_API void* ac_feat_fillet_edges(void* shape, const wchar_t* edgeCsv,
                                  double radius);
AC_API void* ac_feat_chamfer(void* shape, double dis1, double dis2);
/* faceCsv must contain at least one 0 based face index ("0" or "0,3").
 * AnyCAD returns null for an empty face list, so an empty CSV is AC_ERR_ARG. */
AC_API void* ac_feat_thickness(void* solid, double offset,
                               const wchar_t* faceCsv);
AC_API void* ac_feat_offset(void* shape, double offset);
AC_API void* ac_feat_thicken(void* face, double offset);

/* ============================ 9. transform (5) ========================== */
/* All of them return a NEW shape, the input handle stays untouched. */

AC_API void* ac_tr_translate(void* s, double x, double y, double z);
AC_API void* ac_tr_rotate(void* s,
                          double px, double py, double pz,
                          double ax, double ay, double az, double angleRad);
AC_API void* ac_tr_scale(void* s, double cx, double cy, double cz,
                         double scale);
AC_API void* ac_tr_mirror(void* s,
                          double px, double py, double pz,
                          double ax, double ay, double az);
AC_API void* ac_tr_copy(void* s);

/* ======================== 10. import / export (2) ====================== */
/* Neither AnyCAD nor OpenCascade can handle non ASCII paths, therefore the
 * bridge relays every file through an ASCII temporary directory.  Chinese
 * (and any other non ASCII) directories and file names are fully supported. */

AC_API void* ac_io_open(const wchar_t* path);
/* 1 = saved, 0 = failed (AC_ERR_FILE).  The format follows the extension:
 * .step .stp .iges .igs .stl .brep */
AC_API int ac_io_save(void* shape, const wchar_t* path);

/* ---------------- analysis (v1.1 increment) ---------------- */

/* Minimum distance between two shapes.  Returns NaN on failure. */
AC_API double ac_ana_shape_distance(void* shapeA, void* shapeB, double tolerance);

/* Closest point pair between two shapes.
 * Returns an AcPtList with exactly 2 points: [0] on shapeA, [1] on shapeB.
 * The caller owns the handle and must release it with ac_ptl_free. */
AC_API void* ac_ana_shape_closest(void* shapeA, void* shapeB, double tolerance);

/* Distance from a 3D point to a FACE.  Returns NaN on failure. */
AC_API double ac_ana_point_face_distance(double x, double y, double z, void* face, double tolerance);

/* Closest point on a FACE to a 3D point.
 * Returns an AcPtList with exactly 1 point.  Caller owns the handle. */
AC_API void* ac_ana_point_face_closest(double x, double y, double z, void* face, double tolerance);

/* Parameter range of an EDGE / WIRE.
 * Returns an AcPtList with 1 point whose x = first parameter, y = last parameter. */
AC_API void* ac_curve_param_range(void* edge);

/* Point on an EDGE / WIRE at parameter u.
 * Returns an AcPtList with 1 point.  u must be inside ac_curve_param_range. */
AC_API void* ac_curve_value(void* edge, double u);

/* Unit tangent of an EDGE / WIRE at parameter u.
 * Returns an AcPtList with 1 point whose (x,y,z) is the unit tangent vector. */
AC_API void* ac_curve_tangent(void* edge, double u);

/* Read the coordinates of a point stored in an AcPtList (0 based index).
 * Returns NaN when the handle is invalid or the index is out of range. */
AC_API double ac_ptl_x(void* ptList, int index);
AC_API double ac_ptl_y(void* ptList, int index);
AC_API double ac_ptl_z(void* ptList, int index);

#ifdef __cplusplus
}
#endif

#endif /* ANYCAD_BRIDGE_H_INCLUDED */
