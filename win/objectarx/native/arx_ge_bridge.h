// ASCII only. Volcano requires external native sources/headers to be ANSI charset.
// ObjectARX 2026 (R25) AcGe layer bridge for the Volcano Windows class library.
// Handles are exchanged as intptr_t so that Volcano's variable-width integer maps without casts.

#ifndef ARX_GE_BRIDGE_H
#define ARX_GE_BRIDGE_H

#include <cstdint>

#ifdef __cplusplus
extern "C" {
#endif

#define ARX_GE_EXPORT __declspec(dllexport)

/* ---------- AcGePoint3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_point_new (double x, double y, double z);
ARX_GE_EXPORT void     arx_ge_point_free (intptr_t self);
ARX_GE_EXPORT double   arx_ge_point_x (intptr_t self);
ARX_GE_EXPORT double   arx_ge_point_y (intptr_t self);
ARX_GE_EXPORT double   arx_ge_point_z (intptr_t self);
ARX_GE_EXPORT int      arx_ge_point_set (intptr_t self, double x, double y, double z);
ARX_GE_EXPORT double   arx_ge_point_distance_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_point_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_point_add_vector (intptr_t self, intptr_t vec);
ARX_GE_EXPORT int      arx_ge_point_sub_vector (intptr_t self, intptr_t vec);
ARX_GE_EXPORT int      arx_ge_point_sub_point (intptr_t self, intptr_t other, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_point_as_vector (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_point_scale_by (intptr_t self, double scale, double cx, double cy, double cz);
ARX_GE_EXPORT int      arx_ge_point_rotate_by (intptr_t self, double angle,
                                               double axisX, double axisY, double axisZ,
                                               double cx, double cy, double cz);

/* ---------- AcGeVector3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_vector_new (double x, double y, double z);
ARX_GE_EXPORT void     arx_ge_vector_free (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector_x (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector_y (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector_z (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector_set (intptr_t self, double x, double y, double z);
ARX_GE_EXPORT double   arx_ge_vector_length (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector_length_sqrd (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector_normalize (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector_dot_product (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector_cross_product (intptr_t self, intptr_t other, intptr_t outVec);
ARX_GE_EXPORT double   arx_ge_vector_angle_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector_is_parallel_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector_is_perpendicular_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector_negate (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector_add (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector_scale (intptr_t self, double scale);
ARX_GE_EXPORT int      arx_ge_vector_perp_vector (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_vector_rotate_by (intptr_t self, double angle,
                                                double axisX, double axisY, double axisZ);
ARX_GE_EXPORT int      arx_ge_vector_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector_is_unit_length (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector_is_zero_length (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector_is_codirectional_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector_largest_element (intptr_t self);

/* ---------- AcGeVector3d mapping onto a plane (angleOnPlane / convert2d / rotateTo) -- */

ARX_GE_EXPORT double   arx_ge_vector_angle_on_plane (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int      arx_ge_vector_convert2d (intptr_t self, intptr_t plane, intptr_t outVec2);
ARX_GE_EXPORT int      arx_ge_vector_rotate_to (intptr_t self, intptr_t vec, intptr_t outMat);
ARX_GE_EXPORT int      arx_ge_vector_rotate_to_axis (intptr_t self, intptr_t vec,
                                                     double axisX, double axisY, double axisZ,
                                                     intptr_t outMat);

/* ---------- AcGeTol (AcGeContext::gTol) and explicit-tolerance comparisons ---- */

ARX_GE_EXPORT double arx_ge_tol_equal_point (void);
ARX_GE_EXPORT double arx_ge_tol_equal_vector (void);
ARX_GE_EXPORT int    arx_ge_point_is_equal_to_tol (intptr_t self, intptr_t other, double equalPoint);
ARX_GE_EXPORT int    arx_ge_vector_is_equal_to_tol (intptr_t self, intptr_t other, double equalVector);
ARX_GE_EXPORT int    arx_ge_vector_is_parallel_to_tol (intptr_t self, intptr_t other, double equalVector);
ARX_GE_EXPORT int    arx_ge_vector_is_perpendicular_to_tol (intptr_t self, intptr_t other, double equalVector);

/* ---------- AcGeMatrix3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_matrix_new (void);
ARX_GE_EXPORT void     arx_ge_matrix_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT double   arx_ge_matrix_get_elem (intptr_t self, int row, int col);
ARX_GE_EXPORT int      arx_ge_matrix_set_elem (intptr_t self, int row, int col, double value);
ARX_GE_EXPORT int      arx_ge_matrix_set_identity (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix_set_to_translation (intptr_t self, double dx, double dy, double dz);
ARX_GE_EXPORT int      arx_ge_matrix_get_translation (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_matrix_set_to_rotation (intptr_t self, double angle,
                                                      double axisX, double axisY, double axisZ,
                                                      double cx, double cy, double cz);
ARX_GE_EXPORT int      arx_ge_matrix_set_to_scaling (intptr_t self, double scaleAll,
                                                     double cx, double cy, double cz);
ARX_GE_EXPORT int      arx_ge_matrix_post_mult_by (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_matrix_pre_mult_by (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_matrix_set_to_product (intptr_t self, intptr_t mat1, intptr_t mat2);
ARX_GE_EXPORT int      arx_ge_matrix_invert (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix_get_inverse (intptr_t self, intptr_t outMat);
ARX_GE_EXPORT int      arx_ge_matrix_is_singular (intptr_t self);
ARX_GE_EXPORT double   arx_ge_matrix_det (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix_transpose_it (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix_get_transpose (intptr_t self, intptr_t outMat);
ARX_GE_EXPORT int      arx_ge_matrix_is_equal_to_tol (intptr_t self, intptr_t other, double equalVector);
ARX_GE_EXPORT int      arx_ge_matrix_is_scaled_ortho (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix_is_uni_scaled_ortho (intptr_t self);
ARX_GE_EXPORT double   arx_ge_matrix_scale (intptr_t self);
ARX_GE_EXPORT double   arx_ge_matrix_norm (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix_set_coord_system (intptr_t self,
                                                       double ox, double oy, double oz,
                                                       double xx, double xy, double xz,
                                                       double yx, double yy, double yz,
                                                       double zx, double zy, double zz);
ARX_GE_EXPORT int      arx_ge_matrix_get_coord_system (intptr_t self, intptr_t outOrigin,
                                                       intptr_t outX, intptr_t outY, intptr_t outZ);
ARX_GE_EXPORT int      arx_ge_matrix_set_to_align_coord_sys (intptr_t self,
                                                             double fromOx, double fromOy, double fromOz,
                                                             double fromXx, double fromXy, double fromXz,
                                                             double fromYx, double fromYy, double fromYz,
                                                             double fromZx, double fromZy, double fromZz,
                                                             double toOx, double toOy, double toOz,
                                                             double toXx, double toXy, double toXz,
                                                             double toYx, double toYy, double toYz,
                                                             double toZx, double toZy, double toZz);
ARX_GE_EXPORT int      arx_ge_matrix_set_to_mirroring (intptr_t self, double px, double py, double pz);

/* ---------- matrix driven transform (AcGePoint3d / AcGeVector3d::transformBy) ------ */

ARX_GE_EXPORT int arx_ge_point_transform_by (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int arx_ge_vector_transform_by (intptr_t self, intptr_t mat);

/* ---------- AcGePoint2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_point2d_new (double x, double y);
ARX_GE_EXPORT void     arx_ge_point2d_free (intptr_t self);
ARX_GE_EXPORT double   arx_ge_point2d_x (intptr_t self);
ARX_GE_EXPORT double   arx_ge_point2d_y (intptr_t self);
ARX_GE_EXPORT int      arx_ge_point2d_set (intptr_t self, double x, double y);
ARX_GE_EXPORT double   arx_ge_point2d_distance_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_point2d_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_point2d_is_equal_to_tol (intptr_t self, intptr_t other, double equalPoint);
ARX_GE_EXPORT int      arx_ge_point2d_add_vector (intptr_t self, intptr_t vec);
ARX_GE_EXPORT int      arx_ge_point2d_sub_vector (intptr_t self, intptr_t vec);
ARX_GE_EXPORT int      arx_ge_point2d_sub_point (intptr_t self, intptr_t other, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_point2d_as_vector (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_point2d_set_to_sum (intptr_t self, intptr_t pnt, intptr_t vec);
ARX_GE_EXPORT int      arx_ge_point2d_scale_by (intptr_t self, double scale, double cx, double cy);
ARX_GE_EXPORT int      arx_ge_point2d_rotate_by (intptr_t self, double angle, double cx, double cy);

/* ---------- AcGeVector2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_vector2d_new (double x, double y);
ARX_GE_EXPORT void     arx_ge_vector2d_free (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector2d_x (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector2d_y (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector2d_set (intptr_t self, double x, double y);
ARX_GE_EXPORT double   arx_ge_vector2d_length (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector2d_length_sqrd (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector2d_normalize (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector2d_get_normal (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT double   arx_ge_vector2d_dot_product (intptr_t self, intptr_t other);
ARX_GE_EXPORT double   arx_ge_vector2d_angle (intptr_t self);
ARX_GE_EXPORT double   arx_ge_vector2d_angle_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector2d_negate (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector2d_add (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector2d_sub (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector2d_scale (intptr_t self, double scale);
ARX_GE_EXPORT int      arx_ge_vector2d_perp_vector (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_vector2d_rotate_by (intptr_t self, double angle);
ARX_GE_EXPORT int      arx_ge_vector2d_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector2d_is_equal_to_tol (intptr_t self, intptr_t other, double equalVector);
ARX_GE_EXPORT int      arx_ge_vector2d_is_unit_length (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector2d_is_zero_length (intptr_t self);
ARX_GE_EXPORT int      arx_ge_vector2d_is_codirectional_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector2d_is_parallel_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector2d_is_perpendicular_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_vector2d_is_parallel_to_tol (intptr_t self, intptr_t other, double equalVector);
ARX_GE_EXPORT int      arx_ge_vector2d_is_perpendicular_to_tol (intptr_t self, intptr_t other, double equalVector);

/* ---------- AcGeMatrix2d (entry[3][3], homogeneous 2D transform) ---------- */

ARX_GE_EXPORT intptr_t arx_ge_matrix2d_new (void);
ARX_GE_EXPORT void     arx_ge_matrix2d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT double   arx_ge_matrix2d_get_elem (intptr_t self, int row, int col);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_elem (intptr_t self, int row, int col, double value);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_identity (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_to_translation (intptr_t self, double dx, double dy);
ARX_GE_EXPORT int      arx_ge_matrix2d_get_translation (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_to_rotation (intptr_t self, double angle, double cx, double cy);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_to_scaling (intptr_t self, double scaleAll, double cx, double cy);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_to_mirroring (intptr_t self, double px, double py);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_to_mirroring_line (intptr_t self, intptr_t axisLine);
ARX_GE_EXPORT int      arx_ge_matrix2d_post_mult_by (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_matrix2d_pre_mult_by (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_to_product (intptr_t self, intptr_t mat1, intptr_t mat2);
ARX_GE_EXPORT int      arx_ge_matrix2d_invert (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_get_inverse (intptr_t self, intptr_t outMat);
ARX_GE_EXPORT int      arx_ge_matrix2d_is_singular (intptr_t self);
ARX_GE_EXPORT double   arx_ge_matrix2d_det (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_transpose_it (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_get_transpose (intptr_t self, intptr_t outMat);
ARX_GE_EXPORT int      arx_ge_matrix2d_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_matrix2d_is_equal_to_tol (intptr_t self, intptr_t other, double equalVector);
ARX_GE_EXPORT int      arx_ge_matrix2d_is_scaled_ortho (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_is_uni_scaled_ortho (intptr_t self);
ARX_GE_EXPORT double   arx_ge_matrix2d_scale (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_coord_system (intptr_t self,
                                                         double ox, double oy,
                                                         double ex0x, double ex0y,
                                                         double ex1x, double ex1y);
ARX_GE_EXPORT int      arx_ge_matrix2d_get_coord_system (intptr_t self, intptr_t outOrigin,
                                                         intptr_t outE0, intptr_t outE1);
ARX_GE_EXPORT int      arx_ge_matrix2d_set_to_align_coord_sys (intptr_t self,
                                                               double fromOx, double fromOy,
                                                               double fromE0x, double fromE0y,
                                                               double fromE1x, double fromE1y,
                                                               double toOx, double toOy,
                                                               double toE0x, double toE0y,
                                                               double toE1x, double toE1y);

/* ---------- AcGeMatrix2d::isConformal, one call spread over five readers ---------- */

ARX_GE_EXPORT int      arx_ge_matrix2d_is_conformal (intptr_t self);
ARX_GE_EXPORT double   arx_ge_matrix2d_conformal_scale (intptr_t self);
ARX_GE_EXPORT double   arx_ge_matrix2d_conformal_angle (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_conformal_is_mirror (intptr_t self);
ARX_GE_EXPORT int      arx_ge_matrix2d_conformal_reflex (intptr_t self, intptr_t outVec2);

/* ---------- AcGeLine2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_line2d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_line2d_new_through_points (double x1, double y1, double x2, double y2);
ARX_GE_EXPORT intptr_t arx_ge_line2d_new_direction (double px, double py, double vx, double vy);
ARX_GE_EXPORT void     arx_ge_line2d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_line2d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_line2d_set (intptr_t self, double px, double py, double vx, double vy);
ARX_GE_EXPORT int      arx_ge_line2d_set_through_points (intptr_t self, double x1, double y1, double x2, double y2);

/* ---------- AcGeRay2d (third leaf of the linear family, own new/free pair) -- */

ARX_GE_EXPORT intptr_t arx_ge_ray2d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_ray2d_new_through_points (double x1, double y1, double x2, double y2);
ARX_GE_EXPORT intptr_t arx_ge_ray2d_new_direction (double px, double py, double vx, double vy);
ARX_GE_EXPORT void     arx_ge_ray2d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ray2d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_ray2d_set (intptr_t self, double px, double py, double vx, double vy);
ARX_GE_EXPORT int      arx_ge_ray2d_set_through_points (intptr_t self, double x1, double y1, double x2, double y2);

/* ---------- AcGeLineSeg2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_lineseg2d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_lineseg2d_new_through_points (double x1, double y1, double x2, double y2);
ARX_GE_EXPORT intptr_t arx_ge_lineseg2d_new_direction (double px, double py, double vx, double vy);
ARX_GE_EXPORT void     arx_ge_lineseg2d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_lineseg2d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_lineseg2d_set (intptr_t self, double px, double py, double vx, double vy);
ARX_GE_EXPORT int      arx_ge_lineseg2d_set_through_points (intptr_t self, double x1, double y1, double x2, double y2);
ARX_GE_EXPORT int      arx_ge_lineseg2d_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_lineseg2d_mid_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_lineseg2d_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT double   arx_ge_lineseg2d_length (intptr_t self);
ARX_GE_EXPORT double   arx_ge_lineseg2d_length_range (intptr_t self, double fromParam, double toParam);
ARX_GE_EXPORT int      arx_ge_lineseg2d_bary_comb (intptr_t self, double blend, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_lineseg2d_get_bisector (intptr_t self, intptr_t outLine);

/* ---------- AcGeLinearEnt2d / AcGeCurve2d / AcGeEntity2d shared surface ----------
** Both handles may point to an AcGeLine2d or an AcGeLineSeg2d; the static type used
** for the call is the base class, exactly like the ObjectARX signatures do.
*/

ARX_GE_EXPORT int    arx_ge_lent2d_intersect_with (intptr_t self, intptr_t other, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent2d_is_parallel_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent2d_is_perpendicular_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent2d_is_colinear_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent2d_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent2d_get_perp_line (intptr_t self, double px, double py, intptr_t outLine);
ARX_GE_EXPORT int    arx_ge_lent2d_point_on_line (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent2d_direction (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int    arx_ge_lent2d_is_on_pnt (intptr_t self, double px, double py);
ARX_GE_EXPORT double arx_ge_lent2d_param_of (intptr_t self, double px, double py);
ARX_GE_EXPORT double arx_ge_lent2d_distance_to_pnt (intptr_t self, double px, double py);
ARX_GE_EXPORT int    arx_ge_lent2d_closest_point_to (intptr_t self, double px, double py, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent2d_eval_point (intptr_t self, double param, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent2d_transform_by (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int    arx_ge_lent2d_translate_by (intptr_t self, double vx, double vy);
ARX_GE_EXPORT int    arx_ge_lent2d_rotate_by (intptr_t self, double angle, double cx, double cy);
ARX_GE_EXPORT int    arx_ge_lent2d_mirror_by (intptr_t self, intptr_t axisLine);
ARX_GE_EXPORT int    arx_ge_lent2d_scale_by (intptr_t self, double factor, double cx, double cy);
ARX_GE_EXPORT int    arx_ge_lent2d_type_id (intptr_t self);
ARX_GE_EXPORT double arx_ge_lent2d_interval_lower (intptr_t self);
ARX_GE_EXPORT double arx_ge_lent2d_interval_upper (intptr_t self);
ARX_GE_EXPORT int    arx_ge_lent2d_has_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent2d_has_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent2d_is_closed (intptr_t self);
ARX_GE_EXPORT int    arx_ge_lent2d_is_linear (intptr_t self, intptr_t outLine);
ARX_GE_EXPORT int    arx_ge_lent2d_reverse_param (intptr_t self);

/* ---------- 2D matrix driven transform ---------- */

ARX_GE_EXPORT int arx_ge_point2d_transform_by (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int arx_ge_vector2d_transform_by (intptr_t self, intptr_t mat);

/* ---------- AcGeLine3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_line3d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_line3d_new_through_points (double x1, double y1, double z1,
                                                          double x2, double y2, double z2);
ARX_GE_EXPORT intptr_t arx_ge_line3d_new_direction (double px, double py, double pz,
                                                     double vx, double vy, double vz);
ARX_GE_EXPORT void     arx_ge_line3d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_line3d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_line3d_set (intptr_t self, double px, double py, double pz,
                                           double vx, double vy, double vz);
ARX_GE_EXPORT int      arx_ge_line3d_set_through_points (intptr_t self, double x1, double y1, double z1,
                                                          double x2, double y2, double z2);

/* ---------- AcGeRay3d (3D twin of the ray block above) ---------- */

ARX_GE_EXPORT intptr_t arx_ge_ray3d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_ray3d_new_through_points (double x1, double y1, double z1,
                                                          double x2, double y2, double z2);
ARX_GE_EXPORT intptr_t arx_ge_ray3d_new_direction (double px, double py, double pz,
                                                    double vx, double vy, double vz);
ARX_GE_EXPORT void     arx_ge_ray3d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ray3d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_ray3d_set (intptr_t self, double px, double py, double pz,
                                          double vx, double vy, double vz);
ARX_GE_EXPORT int      arx_ge_ray3d_set_through_points (intptr_t self, double x1, double y1, double z1,
                                                          double x2, double y2, double z2);

/* ---------- AcGeLineSeg3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_lineseg3d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_lineseg3d_new_through_points (double x1, double y1, double z1,
                                                              double x2, double y2, double z2);
ARX_GE_EXPORT intptr_t arx_ge_lineseg3d_new_direction (double px, double py, double pz,
                                                        double vx, double vy, double vz);
ARX_GE_EXPORT void     arx_ge_lineseg3d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_lineseg3d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_lineseg3d_set (intptr_t self, double px, double py, double pz,
                                              double vx, double vy, double vz);
ARX_GE_EXPORT int      arx_ge_lineseg3d_set_through_points (intptr_t self, double x1, double y1, double z1,
                                                             double x2, double y2, double z2);
ARX_GE_EXPORT int      arx_ge_lineseg3d_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_lineseg3d_mid_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_lineseg3d_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT double   arx_ge_lineseg3d_length (intptr_t self);
ARX_GE_EXPORT int      arx_ge_lineseg3d_bary_comb (intptr_t self, double blend, intptr_t outPnt);

/* ---------- AcGeLinearEnt3d / AcGeCurve3d / AcGeEntity3d shared surface ----------
** Both handles may point to an AcGeLine3d or an AcGeLineSeg3d; the static type used
** for the call is the base class, exactly like the ObjectARX signatures do.
** The overloads whose signature mentions AcGePlane / AcGePlanarEnt live in the
** "AcGePlane" section at the end of this file, together with the plane entity.
*/

ARX_GE_EXPORT int    arx_ge_lent3d_intersect_with (intptr_t self, intptr_t other, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent3d_proj_intersect_with (intptr_t self, intptr_t other,
                                                         double dx, double dy, double dz,
                                                         intptr_t outThis, intptr_t outOther);
ARX_GE_EXPORT int    arx_ge_lent3d_is_parallel_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent3d_is_perpendicular_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent3d_is_colinear_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent3d_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent3d_point_on_line (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent3d_direction (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int    arx_ge_lent3d_is_on_pnt (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT double arx_ge_lent3d_param_of (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT double arx_ge_lent3d_distance_to_pnt (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT double arx_ge_lent3d_distance_to_curve (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_lent3d_closest_point_to (intptr_t self, double px, double py, double pz,
                                                      intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent3d_closest_point_to_curve (intptr_t self, intptr_t other,
                                                            intptr_t outThis, intptr_t outOther);
ARX_GE_EXPORT int    arx_ge_lent3d_proj_closest_point_to (intptr_t self, double px, double py, double pz,
                                                           double dx, double dy, double dz,
                                                           intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent3d_eval_point (intptr_t self, double param, intptr_t outPnt);
ARX_GE_EXPORT double arx_ge_lent3d_length_range (intptr_t self, double fromParam, double toParam);
ARX_GE_EXPORT double arx_ge_lent3d_param_at_length (intptr_t self, double datumParam, double length);
ARX_GE_EXPORT int    arx_ge_lent3d_transform_by (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int    arx_ge_lent3d_translate_by (intptr_t self, double vx, double vy, double vz);
ARX_GE_EXPORT int    arx_ge_lent3d_rotate_by (intptr_t self, double angle,
                                               double ax, double ay, double az,
                                               double cx, double cy, double cz);
ARX_GE_EXPORT int    arx_ge_lent3d_scale_by (intptr_t self, double factor, double cx, double cy, double cz);
ARX_GE_EXPORT int    arx_ge_lent3d_type_id (intptr_t self);
ARX_GE_EXPORT double arx_ge_lent3d_interval_lower (intptr_t self);
ARX_GE_EXPORT double arx_ge_lent3d_interval_upper (intptr_t self);
ARX_GE_EXPORT int    arx_ge_lent3d_has_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent3d_has_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_lent3d_is_closed (intptr_t self);
ARX_GE_EXPORT int    arx_ge_lent3d_is_linear (intptr_t self, intptr_t outLine);
ARX_GE_EXPORT int    arx_ge_lent3d_reverse_param (intptr_t self);

/* ---------- AcGePlane (incl. the AcGePlanarEnt / AcGeSurface surface) ----------
** Handles point to an AcGePlane. ObjectARX declares the plane parameters as
** AcGePlanarEnt& or AcGePlane&; passing *arx_plane(h) performs the same upcast
** the C++ call sites do, so line / segment / matrix handles and plane handles
** interoperate exactly like the native classes.
*/

ARX_GE_EXPORT intptr_t arx_ge_plane_new (void);
ARX_GE_EXPORT intptr_t arx_ge_plane_new_normal (double px, double py, double pz,
                                                double nx, double ny, double nz);
ARX_GE_EXPORT intptr_t arx_ge_plane_new_three (double ux, double uy, double uz,
                                               double ox, double oy, double oz,
                                               double vx, double vy, double vz);
ARX_GE_EXPORT intptr_t arx_ge_plane_new_axes (double ox, double oy, double oz,
                                              double ux, double uy, double uz,
                                              double vx, double vy, double vz);
ARX_GE_EXPORT intptr_t arx_ge_plane_new_coeff (double a, double b, double c, double d);
ARX_GE_EXPORT void     arx_ge_plane_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_plane_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_plane_set_normal (intptr_t self, double px, double py, double pz,
                                                double nx, double ny, double nz);
ARX_GE_EXPORT int      arx_ge_plane_set_three (intptr_t self,
                                               double ux, double uy, double uz,
                                               double ox, double oy, double oz,
                                               double vx, double vy, double vz);
ARX_GE_EXPORT int      arx_ge_plane_set_axes (intptr_t self,
                                              double ox, double oy, double oz,
                                              double ux, double uy, double uz,
                                              double vx, double vy, double vz);
ARX_GE_EXPORT int      arx_ge_plane_set_coeff (intptr_t self, double a, double b, double c, double d);
ARX_GE_EXPORT int      arx_ge_plane_normal (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_plane_point_on_plane (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT double   arx_ge_plane_coeff_a (intptr_t self);
ARX_GE_EXPORT double   arx_ge_plane_coeff_b (intptr_t self);
ARX_GE_EXPORT double   arx_ge_plane_coeff_c (intptr_t self);
ARX_GE_EXPORT double   arx_ge_plane_coeff_d (intptr_t self);
ARX_GE_EXPORT int      arx_ge_plane_coord_system (intptr_t self, intptr_t outOrigin,
                                                  intptr_t outU, intptr_t outV);
ARX_GE_EXPORT double   arx_ge_plane_signed_distance_to (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT double   arx_ge_plane_distance_to (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT int      arx_ge_plane_intersect_with_line (intptr_t self, intptr_t lineEnt, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_plane_intersect_with_plane (intptr_t self, intptr_t other, intptr_t outLine);
ARX_GE_EXPORT int      arx_ge_plane_is_parallel_to_line (intptr_t self, intptr_t lineEnt);
ARX_GE_EXPORT int      arx_ge_plane_is_perpendicular_to_line (intptr_t self, intptr_t lineEnt);
ARX_GE_EXPORT int      arx_ge_plane_is_parallel_to_plane (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_plane_is_perpendicular_to_plane (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_plane_is_coplanar_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_plane_closest_point_to_linear_ent (intptr_t self, intptr_t lineEnt,
                                                                 intptr_t outPnt, intptr_t outOnLine);
ARX_GE_EXPORT int      arx_ge_plane_closest_point_to_planar_ent (intptr_t self, intptr_t other,
                                                                 intptr_t outPnt, intptr_t outOnOther);
ARX_GE_EXPORT int      arx_ge_plane_is_on_pnt (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT int      arx_ge_plane_closest_point_to (intptr_t self, double px, double py, double pz,
                                                      intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_plane_param_of (intptr_t self, double px, double py, double pz,
                                              intptr_t outPnt2);
ARX_GE_EXPORT int      arx_ge_plane_eval_point (intptr_t self, double u, double v, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_plane_reverse_normal (intptr_t self);
ARX_GE_EXPORT int      arx_ge_plane_is_normal_reversed (intptr_t self);
ARX_GE_EXPORT int      arx_ge_plane_transform_by (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int      arx_ge_plane_type_id (intptr_t self);

/* ---------- AcGeBoundedPlane (a sibling of AcGePlane under AcGePlanarEnt) ----------
** Handles point to an AcGeBoundedPlane. Only the members that AcGeBoundedPlane
** re-declares (the intersectWith trio -- they hide, not override, the base ones)
** need their own exports below. Everything else the new class exposes
** (normal / pointOnPlane / getCoefficients / getCoordSystem / the direction and
** coplanarity tests / closestPointTo* / isOn / distanceTo / paramOf / evalPoint /
** reverseNormal / transformBy / type) is declared exactly once, on
** AcGePlanarEnt, AcGeSurface or AcGeEntity3d, and those are non-virtual there, so
** the arx_ge_plane_* exports above resolve to the very same DLL function for a
** bounded plane and are reused as-is. Do NOT route a bounded plane handle to the
** AcGePlane-only exports (arx_ge_plane_signed_distance_to, arx_ge_plane_set_*,
** arx_ge_plane_intersect_with_plane, ...): those do pick AcGePlane's own
** overloads and would call into a class the object is not.
*/

ARX_GE_EXPORT intptr_t arx_ge_bplane_new (void);
ARX_GE_EXPORT intptr_t arx_ge_bplane_new_axes (double ox, double oy, double oz,
                                               double ux, double uy, double uz,
                                               double vx, double vy, double vz);
ARX_GE_EXPORT intptr_t arx_ge_bplane_new_three (double ux, double uy, double uz,
                                                double ox, double oy, double oz,
                                                double vx, double vy, double vz);
ARX_GE_EXPORT void     arx_ge_bplane_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_bplane_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_bplane_set_axes (intptr_t self, double ox, double oy, double oz,
                                               double ux, double uy, double uz,
                                               double vx, double vy, double vz);
ARX_GE_EXPORT int      arx_ge_bplane_set_three (intptr_t self,
                                                double ux, double uy, double uz,
                                                double ox, double oy, double oz,
                                                double vx, double vy, double vz);
ARX_GE_EXPORT int      arx_ge_bplane_intersect_with_line (intptr_t self, intptr_t lineEnt,
                                                          intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_bplane_intersect_with_plane (intptr_t self, intptr_t plane,
                                                           intptr_t outSeg);
ARX_GE_EXPORT int      arx_ge_bplane_intersect_with_bplane (intptr_t self, intptr_t other,
                                                            intptr_t outSeg);
ARX_GE_EXPORT int      arx_ge_plane_intersect_with_bplane (intptr_t self, intptr_t bplane,
                                                           intptr_t outSeg);
ARX_GE_EXPORT int      arx_ge_bplane_struct_size (void);

/* ---------- AcGePlanarEnt::get, the two overloads that duplicate getCoordSystem -------
** The handle may be an AcGePlane or an AcGeBoundedPlane; both call the single
** AcGePlanarEnt implementation.
*/

ARX_GE_EXPORT int arx_ge_planar_get_axes (intptr_t self, intptr_t outPnt,
                                          intptr_t outUVec, intptr_t outVVec);
ARX_GE_EXPORT int arx_ge_planar_get_points (intptr_t self, intptr_t outPnt,
                                            intptr_t outOrigin, intptr_t outPnt2);

/* ---------- AcGeSurface::getEnvelope ----------
** void getEnvelope (AcGeInterval&, AcGeInterval&) is the only SDK overload.
** AcGeInterval carries no AcGe entity id, so the two intervals are flattened
** into bounds plus an isBounded flag instead of mirrored as a handle class.
** The handle may be an AcGePlane or an AcGeBoundedPlane.
*/

ARX_GE_EXPORT double arx_ge_planar_envelope_u_lower (intptr_t self);
ARX_GE_EXPORT double arx_ge_planar_envelope_u_upper (intptr_t self);
ARX_GE_EXPORT double arx_ge_planar_envelope_v_lower (intptr_t self);
ARX_GE_EXPORT double arx_ge_planar_envelope_v_upper (intptr_t self);
ARX_GE_EXPORT int    arx_ge_planar_envelope_u_bounded (intptr_t self);
ARX_GE_EXPORT int    arx_ge_planar_envelope_v_bounded (intptr_t self);

/* ---------- AcGeSurface::isClosedInU / isClosedInV ----------
** Both are non-virtual members of AcGeSurface and neither AcGePlanarEnt,
** AcGePlane nor AcGeBoundedPlane redeclares them, so exactly like getEnvelope
** one cast channel serves both wrapped surface types. Only the defaulted
** overload is mirrored: an explicit AcGeTol would need a writable tolerance
** handle and ARX容差 is deliberately read-only.
** Measured on AcGe25: open for every surface the class library can reach --
** infinite planes in all three constructions, bounded planes with and without
** a boundary, after copy/setAxes/reverseNormal/transformBy. The headers do
** declare further surfaces (AcGeSphere, AcGeTorus, AcGeCone), but none of them
** exports a single symbol from any import library under lib-x64, so there is
** no closed surface to cross-check the call against.
** 1 closed, 0 open, -1 invalid handle.
*/

ARX_GE_EXPORT int arx_ge_planar_is_closed_in_u (intptr_t self);
ARX_GE_EXPORT int arx_ge_planar_is_closed_in_v (intptr_t self);

/* ---------- plane overloads on AcGeLinearEnt3d / AcGeLineSeg3d ---------- */

ARX_GE_EXPORT int arx_ge_lent3d_intersect_with_plane (intptr_t self, intptr_t plane, intptr_t outPnt);
ARX_GE_EXPORT int arx_ge_lent3d_is_on_plane (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int arx_ge_lent3d_is_parallel_to_plane (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int arx_ge_lent3d_is_perpendicular_to_plane (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int arx_ge_lent3d_get_perp_plane (intptr_t self, double px, double py, double pz,
                                                intptr_t outPlane);
ARX_GE_EXPORT int arx_ge_lent3d_mirror_by_plane (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int arx_ge_lent3d_is_planar (intptr_t self, intptr_t outPlane);
ARX_GE_EXPORT int arx_ge_lineseg3d_get_bisector (intptr_t self, intptr_t outPlane);

/* ---------- plane overloads on AcGeMatrix3d ---------- */

ARX_GE_EXPORT int arx_ge_matrix_set_to_mirroring_plane (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int arx_ge_matrix_set_to_projection (intptr_t self, intptr_t plane,
                                                   double dx, double dy, double dz);
ARX_GE_EXPORT int arx_ge_matrix_set_to_world_to_plane (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int arx_ge_matrix_set_to_plane_to_world (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int arx_ge_matrix_convert_to_local (intptr_t self, double normalX, double normalY,
                                                  double normalZ, double elevIn,
                                                  intptr_t outMat2d, intptr_t outNormal);
ARX_GE_EXPORT double arx_ge_matrix_local_elevation (intptr_t self, double normalX,
                                                    double normalY, double normalZ,
                                                    double elevIn);

/* ---------- AcGeCurve2d base surface (valid on any 2D curve handle) ---------- */

ARX_GE_EXPORT double arx_ge_curve2d_param_of (intptr_t self, double px, double py);
ARX_GE_EXPORT int    arx_ge_curve2d_eval_point (intptr_t self, double param, intptr_t outPnt);
ARX_GE_EXPORT double arx_ge_curve2d_distance_to_pnt (intptr_t self, double px, double py);
ARX_GE_EXPORT double arx_ge_curve2d_distance_to_curve (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_curve2d_closest_point_to (intptr_t self, double px, double py,
                                                      intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_curve2d_closest_point_to_curve (intptr_t self, intptr_t other,
                                                            intptr_t outThis, intptr_t outOther);
ARX_GE_EXPORT int    arx_ge_curve2d_is_on_pnt (intptr_t self, double px, double py);
ARX_GE_EXPORT int    arx_ge_curve2d_is_on_param (intptr_t self, double param);
ARX_GE_EXPORT int    arx_ge_curve2d_is_closed (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve2d_period (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve2d_length (intptr_t self, double fromParam, double toParam);
ARX_GE_EXPORT double arx_ge_curve2d_param_at_length (intptr_t self, double datumParam,
                                                     double length, int positiveDir);
ARX_GE_EXPORT double arx_ge_curve2d_area (intptr_t self, double startParam, double endParam);
ARX_GE_EXPORT int    arx_ge_curve2d_has_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_curve2d_has_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT double arx_ge_curve2d_interval_lower (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve2d_interval_upper (intptr_t self);
/* pkg 16: setInterval family. The interval is flattened to (lower, upper) so no
** AcGeInterval mirror is needed; 1 = SDK accepted, 0 = bad handle, refused or threw.
** read_interval leaves both out points untouched on an unbounded line, so the caller's
** current point values are seeded in rather than a sentinel. */
ARX_GE_EXPORT double arx_ge_curve2d_set_interval (intptr_t self, double lower, double upper);
ARX_GE_EXPORT double arx_ge_curve2d_restore_interval (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve2d_read_interval (intptr_t self, intptr_t outStart, intptr_t outEnd);
ARX_GE_EXPORT int    arx_ge_curve2d_is_linear (intptr_t self, intptr_t outLine);
ARX_GE_EXPORT int    arx_ge_curve2d_reverse_param (intptr_t self);
ARX_GE_EXPORT int    arx_ge_curve2d_degenerate_type (intptr_t self);
ARX_GE_EXPORT int    arx_ge_curve2d_transform_by (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int    arx_ge_curve2d_translate_by (intptr_t self, double vx, double vy);
ARX_GE_EXPORT int    arx_ge_curve2d_rotate_by (intptr_t self, double angle, double cx, double cy);
ARX_GE_EXPORT int    arx_ge_curve2d_mirror_by (intptr_t self, intptr_t axisLine);
ARX_GE_EXPORT int    arx_ge_curve2d_scale_by (intptr_t self, double factor, double cx, double cy);
ARX_GE_EXPORT int    arx_ge_curve2d_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_curve2d_type_id (intptr_t self);
ARX_GE_EXPORT int    arx_ge_curve2d_sample_count (intptr_t self, int numSample);
ARX_GE_EXPORT int    arx_ge_curve2d_sample_point (intptr_t self, int numSample, int index,
                                                  intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_curve2d_tol_sample_count (intptr_t self,
                                                      double fromParam, double toParam,
                                                      double approxEps);
ARX_GE_EXPORT int    arx_ge_curve2d_tol_sample_point (intptr_t self,
                                                      double fromParam, double toParam,
                                                      double approxEps, int index,
                                                      intptr_t outPnt);
ARX_GE_EXPORT double arx_ge_curve2d_tol_sample_param (intptr_t self,
                                                      double fromParam, double toParam,
                                                      double approxEps, int index);

/* ---------- AcGeCurve2d::getSplitCurves ----------
 *  index picks which piece: 0 = piece1, 1 = piece2.
 *  split_type returns that piece's AcGe::EntityId, or -1 invalid handle or
 *  index, -2 exception, -3 the SDK left that piece pointer null.
 *  split_into copies the piece into target only when both report the same
 *  entity id: 1 assigned, 0 null piece, 2 type mismatch, 3 piece neither
 *  assignable nor recognisable (deliberately not destroyed).
 */
ARX_GE_EXPORT int    arx_ge_curve2d_split_type (intptr_t self, double param, int index);
ARX_GE_EXPORT int    arx_ge_curve2d_split_into (intptr_t self, double param, int index,
                                                intptr_t target);

/* ---------- AcGeCircArc2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new_circle (double cx, double cy, double radius);
ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new_angles (double cx, double cy, double radius,
                                                    double startAng, double endAng,
                                                    double refX, double refY, int clockwise);
ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new_three (double x1, double y1,
                                                   double x2, double y2,
                                                   double x3, double y3);
ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new_bulge (double x1, double y1,
                                                   double x2, double y2,
                                                   double bulge, int bulgeIsHeight);
ARX_GE_EXPORT void     arx_ge_circarc2d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_circarc2d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_circle (intptr_t self, double cx, double cy,
                                                    double radius);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_angles (intptr_t self, double cx, double cy,
                                                    double radius, double startAng,
                                                    double endAng, double refX, double refY,
                                                    int clockwise);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_three (intptr_t self, double x1, double y1,
                                                   double x2, double y2,
                                                   double x3, double y3);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_three_err (intptr_t self, double x1, double y1,
                                                       double x2, double y2,
                                                       double x3, double y3);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_bulge (intptr_t self, double x1, double y1,
                                                   double x2, double y2,
                                                   double bulge, int bulgeIsHeight);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_center (intptr_t self, double cx, double cy);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_radius (intptr_t self, double radius);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_start_end_ang (intptr_t self, double startAng,
                                                           double endAng);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_to_complement (intptr_t self);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_ref_vec (intptr_t self, double vx, double vy);
ARX_GE_EXPORT int      arx_ge_circarc2d_center (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT double   arx_ge_circarc2d_radius (intptr_t self);
ARX_GE_EXPORT double   arx_ge_circarc2d_start_ang (intptr_t self);
ARX_GE_EXPORT double   arx_ge_circarc2d_end_ang (intptr_t self);
ARX_GE_EXPORT int      arx_ge_circarc2d_is_clockwise (intptr_t self);
ARX_GE_EXPORT int      arx_ge_circarc2d_ref_vec (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_circarc2d_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_circarc2d_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_circarc2d_intersect_with_line (intptr_t self, intptr_t other,
                                                             intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_circarc2d_intersect_with_arc (intptr_t self, intptr_t other,
                                                            intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_circarc2d_tangent (intptr_t self, double px, double py,
                                                 intptr_t outLine);
ARX_GE_EXPORT int      arx_ge_circarc2d_tangent_err (intptr_t self, double px, double py,
                                                     intptr_t outLine);
ARX_GE_EXPORT int      arx_ge_circarc2d_is_inside (intptr_t self, double px, double py);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_fillet (intptr_t self, intptr_t curve1,
                                                    intptr_t curve2, double radius,
                                                    intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_circarc2d_set_tangent_three (intptr_t self, intptr_t curve1,
                                                           intptr_t curve2, intptr_t curve3,
                                                           intptr_t outP1, intptr_t outP2,
                                                           intptr_t outP3);

/* ---------- AcGeCurve3d base surface (valid on any 3D curve handle) ----------
** Handles may point to an AcGeLine3d, an AcGeLineSeg3d or an AcGeCircArc3d; the
** static type used for the call is AcGeCurve3d, exactly like the ObjectARX
** signatures do. Do NOT feed a 3D arc handle to the lent3d_* helpers above:
** AcGeLinearEnt3d and AcGeCircArc3d are siblings, not related by inheritance.
*/

ARX_GE_EXPORT double arx_ge_curve3d_param_of (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT int    arx_ge_curve3d_eval_point (intptr_t self, double param, intptr_t outPnt);
ARX_GE_EXPORT double arx_ge_curve3d_distance_to_pnt (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT double arx_ge_curve3d_distance_to_curve (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_curve3d_closest_point_to (intptr_t self, double px, double py, double pz,
                                                      intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_curve3d_closest_point_to_curve (intptr_t self, intptr_t other,
                                                            intptr_t outThis, intptr_t outOther);
ARX_GE_EXPORT int    arx_ge_curve3d_proj_closest_point_to (intptr_t self, double px, double py, double pz,
                                                           double dx, double dy, double dz,
                                                           intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_curve3d_is_on_pnt (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT int    arx_ge_curve3d_is_on_param (intptr_t self, double param);
ARX_GE_EXPORT int    arx_ge_curve3d_is_closed (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve3d_period (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve3d_length (intptr_t self, double fromParam, double toParam);
ARX_GE_EXPORT double arx_ge_curve3d_param_at_length (intptr_t self, double datumParam, double length,
                                                     int positiveDir);
ARX_GE_EXPORT double arx_ge_curve3d_area (intptr_t self, double startParam, double endParam);
ARX_GE_EXPORT int    arx_ge_curve3d_has_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int    arx_ge_curve3d_has_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT double arx_ge_curve3d_interval_lower (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve3d_interval_upper (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve3d_set_interval (intptr_t self, double lower, double upper);
ARX_GE_EXPORT double arx_ge_curve3d_restore_interval (intptr_t self);
ARX_GE_EXPORT double arx_ge_curve3d_read_interval (intptr_t self, intptr_t outStart, intptr_t outEnd);
ARX_GE_EXPORT int    arx_ge_curve3d_is_linear (intptr_t self, intptr_t outLine);
ARX_GE_EXPORT int    arx_ge_curve3d_is_planar (intptr_t self, intptr_t outPlane);
ARX_GE_EXPORT int    arx_ge_curve3d_is_coplanar_with (intptr_t self, intptr_t other, intptr_t outPlane);
ARX_GE_EXPORT int    arx_ge_curve3d_reverse_param (intptr_t self);
ARX_GE_EXPORT int    arx_ge_curve3d_degenerate_type (intptr_t self);
ARX_GE_EXPORT int    arx_ge_curve3d_transform_by (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int    arx_ge_curve3d_translate_by (intptr_t self, double vx, double vy, double vz);
ARX_GE_EXPORT int    arx_ge_curve3d_rotate_by (intptr_t self, double angle,
                                               double ax, double ay, double az,
                                               double cx, double cy, double cz);
ARX_GE_EXPORT int    arx_ge_curve3d_mirror_by (intptr_t self, intptr_t plane);
ARX_GE_EXPORT int    arx_ge_curve3d_scale_by (intptr_t self, double factor,
                                              double cx, double cy, double cz);
ARX_GE_EXPORT int    arx_ge_curve3d_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int    arx_ge_curve3d_type_id (intptr_t self);
ARX_GE_EXPORT int    arx_ge_curve3d_sample_count (intptr_t self, int numSample);
ARX_GE_EXPORT int    arx_ge_curve3d_sample_point (intptr_t self, int numSample, int index,
                                                  intptr_t outPnt);
ARX_GE_EXPORT double arx_ge_curve3d_sample_param (intptr_t self, int numSample, int index);
ARX_GE_EXPORT int    arx_ge_curve3d_tol_sample_count (intptr_t self,
                                                      double fromParam, double toParam,
                                                      double approxEps, int forceResampling);
ARX_GE_EXPORT int    arx_ge_curve3d_tol_sample_point (intptr_t self,
                                                      double fromParam, double toParam,
                                                      double approxEps, int forceResampling,
                                                      int index, intptr_t outPnt);
ARX_GE_EXPORT double arx_ge_curve3d_tol_sample_param (intptr_t self,
                                                      double fromParam, double toParam,
                                                      double approxEps, int forceResampling,
                                                      int index);
ARX_GE_EXPORT int    arx_ge_curve3d_project_type (intptr_t source, intptr_t plane,
                                                  double dx, double dy, double dz,
                                                  int ortho);
ARX_GE_EXPORT int    arx_ge_curve3d_project_into (intptr_t source, intptr_t plane,
                                                  double dx, double dy, double dz,
                                                  int ortho, intptr_t target);

/* ---------- AcGeCurve3d::getSplitCurves ----------
 *  Same contract and return codes as the 2D pair above; the pieces are
 *  destroyed inside the bridge because ~AcGeEntity3d is not virtual.
 */
ARX_GE_EXPORT int    arx_ge_curve3d_split_type (intptr_t self, double param, int index);
ARX_GE_EXPORT int    arx_ge_curve3d_split_into (intptr_t self, double param, int index,
                                                intptr_t target);

/* ---------- AcGeCurve2d/3d::getTrimmedOffset ----------
 * The 3D trio carries the plane normal the overload needs; a zero-length
 * normal is rejected in the class library before it ever reaches these.
 * See the .cpp for the return codes.
 */
ARX_GE_EXPORT int arx_ge_curve2d_trim_offset_count (intptr_t self, double dist,
                                                    int ext);
ARX_GE_EXPORT int arx_ge_curve2d_trim_offset_type (intptr_t self, double dist,
                                                   int ext, int index);
ARX_GE_EXPORT int arx_ge_curve2d_trim_offset_into (intptr_t self, double dist,
                                                   int ext, int index,
                                                   intptr_t target);
ARX_GE_EXPORT int arx_ge_curve3d_trim_offset_count (intptr_t self, double dist,
                                                    int ext, double nrx,
                                                    double nry, double nrz);
ARX_GE_EXPORT int arx_ge_curve3d_trim_offset_type (intptr_t self, double dist,
                                                   int ext, int index,
                                                   double nrx, double nry,
                                                   double nrz);
ARX_GE_EXPORT int arx_ge_curve3d_trim_offset_into (intptr_t self, double dist,
                                                   int ext, int index,
                                                   double nrx, double nry,
                                                   double nrz, intptr_t target);

/* ---------- AcGePosition3d (point entity that project / orthoProject can return) */
ARX_GE_EXPORT intptr_t arx_ge_position3d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_position3d_new_pnt (double x, double y, double z);
ARX_GE_EXPORT void     arx_ge_position3d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_position3d_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_position3d_type (intptr_t self);

/* ---------- AcGeCircArc3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_circarc3d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_circarc3d_new_circle (double cx, double cy, double cz,
                                                    double nx, double ny, double nz,
                                                    double radius);
ARX_GE_EXPORT intptr_t arx_ge_circarc3d_new_angles (double cx, double cy, double cz,
                                                    double nx, double ny, double nz,
                                                    double rx, double ry, double rz,
                                                    double radius, double startAng, double endAng);
ARX_GE_EXPORT intptr_t arx_ge_circarc3d_new_three (double x1, double y1, double z1,
                                                   double x2, double y2, double z2,
                                                   double x3, double y3, double z3);
ARX_GE_EXPORT void     arx_ge_circarc3d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_circarc3d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_center (intptr_t self, double cx, double cy, double cz);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_axes (intptr_t self, double nx, double ny, double nz,
                                                  double rx, double ry, double rz);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_radius (intptr_t self, double radius);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_start_end_ang (intptr_t self, double startAng,
                                                           double endAng);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_circle (intptr_t self, double cx, double cy, double cz,
                                                    double nx, double ny, double nz, double radius);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_angles (intptr_t self, double cx, double cy, double cz,
                                                    double nx, double ny, double nz,
                                                    double rx, double ry, double rz,
                                                    double radius, double startAng, double endAng);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_three (intptr_t self,
                                                   double x1, double y1, double z1,
                                                   double x2, double y2, double z2,
                                                   double x3, double y3, double z3);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_three_err (intptr_t self,
                                                       double x1, double y1, double z1,
                                                       double x2, double y2, double z2,
                                                       double x3, double y3, double z3);
ARX_GE_EXPORT int      arx_ge_circarc3d_center (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_circarc3d_normal (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_circarc3d_ref_vec (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT double   arx_ge_circarc3d_radius (intptr_t self);
ARX_GE_EXPORT double   arx_ge_circarc3d_start_ang (intptr_t self);
ARX_GE_EXPORT double   arx_ge_circarc3d_end_ang (intptr_t self);
ARX_GE_EXPORT int      arx_ge_circarc3d_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_circarc3d_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_circarc3d_get_plane (intptr_t self, intptr_t outPlane);
ARX_GE_EXPORT int      arx_ge_circarc3d_is_inside (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT int      arx_ge_circarc3d_tangent (intptr_t self, double px, double py, double pz,
                                                 intptr_t outLine);
ARX_GE_EXPORT int      arx_ge_circarc3d_tangent_err (intptr_t self, double px, double py, double pz,
                                                     intptr_t outLine);
ARX_GE_EXPORT int      arx_ge_circarc3d_intersect_with_line (intptr_t self, intptr_t other,
                                                             intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_circarc3d_intersect_with_arc (intptr_t self, intptr_t other,
                                                            intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_circarc3d_intersect_with_plane (intptr_t self, intptr_t plane,
                                                              intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_circarc3d_proj_intersect_with (intptr_t self, intptr_t line,
                                                             double dx, double dy, double dz,
                                                             intptr_t outArc1, intptr_t outArc2,
                                                             intptr_t outLine1, intptr_t outLine2);
ARX_GE_EXPORT int      arx_ge_circarc3d_closest_point_to_plane (intptr_t self, intptr_t plane,
                                                                intptr_t outPnt, intptr_t outOnPlane);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_fillet (intptr_t self, intptr_t curve1,
                                                    intptr_t curve2, double radius,
                                                    intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_circarc3d_set_tangent_three (intptr_t self, intptr_t curve1,
                                                           intptr_t curve2, intptr_t curve3,
                                                           intptr_t outP1, intptr_t outP2,
                                                           intptr_t outP3);

/* ---------- AcGeEllipArc2d ----------
** Handles point to an AcGeEllipArc2d. The AcGeCurve2d/AcGeEntity2d surface is
** reached through the arx_ge_curve2d_* helpers above, exactly like the arc and
** line classes do. The intersectWith parameter is an AcGeLinearEnt2d, so line
** and segment handles are valid arguments.
*/

ARX_GE_EXPORT intptr_t arx_ge_ellip2d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_ellip2d_new_axes (double cx, double cy,
                                                double ax, double ay,
                                                double bx, double by,
                                                double majorRadius, double minorRadius);
ARX_GE_EXPORT intptr_t arx_ge_ellip2d_new_angles (double cx, double cy,
                                                  double ax, double ay,
                                                  double bx, double by,
                                                  double majorRadius, double minorRadius,
                                                  double startAng, double endAng);
ARX_GE_EXPORT intptr_t arx_ge_ellip2d_new_from_arc (intptr_t arc);
ARX_GE_EXPORT void     arx_ge_ellip2d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip2d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_ellip2d_set_axes (intptr_t self, double cx, double cy,
                                                double ax, double ay, double bx, double by,
                                                double majorRadius, double minorRadius);
ARX_GE_EXPORT int      arx_ge_ellip2d_set_angles (intptr_t self, double cx, double cy,
                                                  double ax, double ay, double bx, double by,
                                                  double majorRadius, double minorRadius,
                                                  double startAng, double endAng);
ARX_GE_EXPORT int      arx_ge_ellip2d_set_from_arc (intptr_t self, intptr_t arc);
ARX_GE_EXPORT int      arx_ge_ellip2d_set_center (intptr_t self, double cx, double cy);
ARX_GE_EXPORT int      arx_ge_ellip2d_set_major_radius (intptr_t self, double radius);
ARX_GE_EXPORT int      arx_ge_ellip2d_set_minor_radius (intptr_t self, double radius);
ARX_GE_EXPORT int      arx_ge_ellip2d_set_axis_vecs (intptr_t self, double ax, double ay,
                                                     double bx, double by);
ARX_GE_EXPORT int      arx_ge_ellip2d_set_angle_pair (intptr_t self, double startAng,
                                                      double endAng);
ARX_GE_EXPORT int      arx_ge_ellip2d_center (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT double   arx_ge_ellip2d_major_radius (intptr_t self);
ARX_GE_EXPORT double   arx_ge_ellip2d_minor_radius (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip2d_major_axis (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_ellip2d_minor_axis (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT double   arx_ge_ellip2d_start_ang (intptr_t self);
ARX_GE_EXPORT double   arx_ge_ellip2d_end_ang (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip2d_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_ellip2d_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_ellip2d_is_clockwise (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip2d_is_circular (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip2d_is_circular_tol (intptr_t self, double equalVector);
ARX_GE_EXPORT int      arx_ge_ellip2d_is_inside (intptr_t self, double px, double py);
ARX_GE_EXPORT int      arx_ge_ellip2d_intersect_with_line (intptr_t self, intptr_t other,
                                                           intptr_t outP1, intptr_t outP2);

/* ---------- AcGeEllipArc3d ----------
** Handles point to an AcGeEllipArc3d; the AcGeCurve3d surface is reached through
** the arx_ge_curve3d_* helpers above. Plane arguments are AcGePlane handles.
*/

ARX_GE_EXPORT intptr_t arx_ge_ellip3d_new (void);
ARX_GE_EXPORT intptr_t arx_ge_ellip3d_new_axes (double cx, double cy, double cz,
                                                double ax, double ay, double az,
                                                double bx, double by, double bz,
                                                double majorRadius, double minorRadius);
ARX_GE_EXPORT intptr_t arx_ge_ellip3d_new_angles (double cx, double cy, double cz,
                                                  double ax, double ay, double az,
                                                  double bx, double by, double bz,
                                                  double majorRadius, double minorRadius,
                                                  double startAng, double endAng);
ARX_GE_EXPORT intptr_t arx_ge_ellip3d_new_from_arc (intptr_t arc);
ARX_GE_EXPORT void     arx_ge_ellip3d_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip3d_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_ellip3d_set_axes (intptr_t self, double cx, double cy, double cz,
                                                double ax, double ay, double az,
                                                double bx, double by, double bz,
                                                double majorRadius, double minorRadius);
ARX_GE_EXPORT int      arx_ge_ellip3d_set_angles (intptr_t self, double cx, double cy, double cz,
                                                  double ax, double ay, double az,
                                                  double bx, double by, double bz,
                                                  double majorRadius, double minorRadius,
                                                  double startAng, double endAng);
ARX_GE_EXPORT int      arx_ge_ellip3d_set_from_arc (intptr_t self, intptr_t arc);
ARX_GE_EXPORT int      arx_ge_ellip3d_set_center (intptr_t self, double cx, double cy, double cz);
ARX_GE_EXPORT int      arx_ge_ellip3d_set_major_radius (intptr_t self, double radius);
ARX_GE_EXPORT int      arx_ge_ellip3d_set_minor_radius (intptr_t self, double radius);
ARX_GE_EXPORT int      arx_ge_ellip3d_set_axis_vecs (intptr_t self, double ax, double ay, double az,
                                                     double bx, double by, double bz);
ARX_GE_EXPORT int      arx_ge_ellip3d_set_angle_pair (intptr_t self, double startAng,
                                                      double endAng);
ARX_GE_EXPORT int      arx_ge_ellip3d_center (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT double   arx_ge_ellip3d_major_radius (intptr_t self);
ARX_GE_EXPORT double   arx_ge_ellip3d_minor_radius (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip3d_major_axis (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_ellip3d_minor_axis (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_ellip3d_normal (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT double   arx_ge_ellip3d_start_ang (intptr_t self);
ARX_GE_EXPORT double   arx_ge_ellip3d_end_ang (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip3d_start_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_ellip3d_end_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_ellip3d_get_plane (intptr_t self, intptr_t outPlane);
ARX_GE_EXPORT int      arx_ge_ellip3d_is_circular (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ellip3d_is_circular_tol (intptr_t self, double equalVector);
ARX_GE_EXPORT int      arx_ge_ellip3d_is_inside (intptr_t self, double px, double py, double pz);
ARX_GE_EXPORT int      arx_ge_ellip3d_intersect_with_line (intptr_t self, intptr_t other,
                                                           intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_ellip3d_intersect_with_plane (intptr_t self, intptr_t plane,
                                                            intptr_t outP1, intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_ellip3d_proj_intersect_with (intptr_t self, intptr_t line,
                                                           double dx, double dy, double dz,
                                                           intptr_t outSelf1, intptr_t outSelf2,
                                                           intptr_t outLine1, intptr_t outLine2);
ARX_GE_EXPORT int      arx_ge_ellip3d_closest_point_to_plane (intptr_t self, intptr_t plane,
                                                              intptr_t outPnt, intptr_t outOnPlane);

/* ---------- AcGeBoundBlock2d / AcGeBoundBlock3d ----------
** Handle layer over the two bounding-block entities (base point plus two or
** three side vectors, i.e. a parallelogram / parallelepiped).
**   readers      write into caller-owned point/vector handles
**   writes       copy/set/extend/swell/setToBox -> 1 done, 0 bad handle or threw
**   predicates   contains / isDisjoint / isBox -> 1 or 0, bad handle gives 0
**   type_id      AcGeEntity2d/3d::type(), -1 when the handle is unusable
**   from_curve   which 0 = boundBlock, 1 = orthoBoundBlock;
**                useRange 0 = no-arg overload, 1 = AcGeInterval (lo, hi)
**                (an unbounded default interval reads like case 0, so it is
**                not offered)
** The 3d class has no point-pair constructor, so 3d exposes set_pair only.
*/

ARX_GE_EXPORT intptr_t arx_ge_block2_new (void);
ARX_GE_EXPORT intptr_t arx_ge_block2_new_pair (double x1, double y1,
                                               double x2, double y2);
ARX_GE_EXPORT intptr_t arx_ge_block2_new_dirs (double bx, double by,
                                               double d1x, double d1y,
                                               double d2x, double d2y);
ARX_GE_EXPORT void     arx_ge_block2_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_block2_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_block2_set_pair (intptr_t self, double x1, double y1,
                                               double x2, double y2);
ARX_GE_EXPORT int      arx_ge_block2_set_dirs (intptr_t self, double bx, double by,
                                               double d1x, double d1y,
                                               double d2x, double d2y);
ARX_GE_EXPORT int      arx_ge_block2_get (intptr_t self, intptr_t outBase,
                                          intptr_t outDir1, intptr_t outDir2);
ARX_GE_EXPORT int      arx_ge_block2_get_minmax (intptr_t self, intptr_t outP1,
                                                 intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_block2_extend (intptr_t self, intptr_t point);
ARX_GE_EXPORT int      arx_ge_block2_swell (intptr_t self, double distance);
ARX_GE_EXPORT int      arx_ge_block2_contains (intptr_t self, intptr_t point);
ARX_GE_EXPORT int      arx_ge_block2_is_disjoint (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_block2_is_box (intptr_t self);
ARX_GE_EXPORT int      arx_ge_block2_set_to_box (intptr_t self, int flag);
ARX_GE_EXPORT int      arx_ge_block2_type_id (intptr_t self);
ARX_GE_EXPORT int      arx_ge_block2_from_curve (intptr_t self, intptr_t src,
                                                 int which, int useRange,
                                                 double lo, double hi);

ARX_GE_EXPORT intptr_t arx_ge_block3_new (void);
ARX_GE_EXPORT intptr_t arx_ge_block3_new_dirs (double bx, double by, double bz,
                                               double d1x, double d1y, double d1z,
                                               double d2x, double d2y, double d2z,
                                               double d3x, double d3y, double d3z);
ARX_GE_EXPORT void     arx_ge_block3_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_block3_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_block3_set_pair (intptr_t self, double x1, double y1,
                                               double z1, double x2, double y2,
                                               double z2);
ARX_GE_EXPORT int      arx_ge_block3_set_dirs (intptr_t self, double bx, double by,
                                               double bz, double d1x, double d1y,
                                               double d1z, double d2x, double d2y,
                                               double d2z, double d3x, double d3y,
                                               double d3z);
ARX_GE_EXPORT int      arx_ge_block3_get (intptr_t self, intptr_t outBase,
                                          intptr_t outDir1, intptr_t outDir2,
                                          intptr_t outDir3);
ARX_GE_EXPORT int      arx_ge_block3_get_minmax (intptr_t self, intptr_t outP1,
                                                 intptr_t outP2);
ARX_GE_EXPORT int      arx_ge_block3_extend (intptr_t self, intptr_t point);
ARX_GE_EXPORT int      arx_ge_block3_swell (intptr_t self, double distance);
ARX_GE_EXPORT int      arx_ge_block3_contains (intptr_t self, intptr_t point);
ARX_GE_EXPORT int      arx_ge_block3_is_disjoint (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_block3_is_box (intptr_t self);
ARX_GE_EXPORT int      arx_ge_block3_set_to_box (intptr_t self, int flag);
ARX_GE_EXPORT int      arx_ge_block3_type_id (intptr_t self);
ARX_GE_EXPORT int      arx_ge_block3_from_curve (intptr_t self, intptr_t src,
                                                 int which, int useRange,
                                                 double lo, double hi);

/* ---------- AcGeLinearEnt2d / AcGeLinearEnt3d : overlap ----------
** The overlap piece is allocated by the SDK and destroyed inside the bridge.
** Return codes: -1 invalid handle, -2 the SDK threw, -3 no piece came back.
** _take adds 0 = no overlap, 1 = assigned, 2 = piece class mismatch,
** 3 = piece left alive (unknown leaf class).
*/
ARX_GE_EXPORT int arx_ge_lent2d_overlap (intptr_t self, intptr_t other);
ARX_GE_EXPORT int arx_ge_lent2d_overlap_type (intptr_t self, intptr_t other);
ARX_GE_EXPORT int arx_ge_lent2d_overlap_take (intptr_t self, intptr_t other);
ARX_GE_EXPORT int arx_ge_lent3d_overlap (intptr_t self, intptr_t other);
ARX_GE_EXPORT int arx_ge_lent3d_overlap_type (intptr_t self, intptr_t other);
ARX_GE_EXPORT int arx_ge_lent3d_overlap_take (intptr_t self, intptr_t other);

/* ---------- AcGePointOnCurve2d / AcGePointOnCurve3d ----------
** A point sitting on a borrowed curve: the object stores a const reference plus
** a parameter, so the curve must outlive the handle and the bridge never frees
** it. Readers write into caller-owned point/vector handles and answer 1 done,
** 0 bad handle or threw; parameter/curvature answer ARX_GE_NAN when they cannot
** answer. On the 2d side curvature and isSingular have no export in lib-x64, so
** the bridge computes them (derivative formula, and |deriv (1)| <= 1e-12); the
** 3d side calls the SDK. see_curve compares curve() with a handle -- curve() is
** never null, a default object is bound to a line. take_proj_* exist on the 3d
** side only, because AcGeCurve2d has no projection family.
*/

ARX_GE_EXPORT intptr_t arx_ge_poc2_new (void);
ARX_GE_EXPORT intptr_t arx_ge_poc2_new_curve (intptr_t curve);
ARX_GE_EXPORT intptr_t arx_ge_poc2_new_param (intptr_t curve, double param);
ARX_GE_EXPORT void     arx_ge_poc2_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_poc2_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_poc2_set_curve (intptr_t self, intptr_t curve);
ARX_GE_EXPORT int      arx_ge_poc2_set_param (intptr_t self, double param);
ARX_GE_EXPORT int      arx_ge_poc2_same_curve (intptr_t self, intptr_t curve);
ARX_GE_EXPORT double   arx_ge_poc2_parameter (intptr_t self);
ARX_GE_EXPORT int      arx_ge_poc2_type_id (intptr_t self);
ARX_GE_EXPORT int      arx_ge_poc2_get_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_poc2_get_point_at (intptr_t self, double param,
                                                 intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_poc2_curve_point (intptr_t curve, double param,
                                                intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_poc2_get_deriv (intptr_t self, int order,
                                              intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_poc2_get_deriv_at (intptr_t self, int order,
                                                 double param, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_poc2_curve_deriv (intptr_t curve, int order,
                                                double param, intptr_t outVec);
ARX_GE_EXPORT double   arx_ge_poc2_curvature (intptr_t self);
ARX_GE_EXPORT double   arx_ge_poc2_curvature_at (intptr_t self, double param);
ARX_GE_EXPORT int      arx_ge_poc2_is_singular (intptr_t self);
ARX_GE_EXPORT int      arx_ge_poc2_take_closest (intptr_t self, intptr_t src,
                                                 double x, double y);
ARX_GE_EXPORT int      arx_ge_poc2_take_closest_pair (intptr_t self, intptr_t other,
                                                      intptr_t src_a,
                                                      intptr_t src_b);
ARX_GE_EXPORT int      arx_ge_poc2_normal (intptr_t self, intptr_t src,
                                           double x, double y);
ARX_GE_EXPORT int      arx_ge_poc2_local_point (intptr_t self, intptr_t src,
                                                double x, double y,
                                                int nbhd, double alo,
                                                double ahi);
ARX_GE_EXPORT int      arx_ge_poc2_local_pair (intptr_t self, intptr_t other,
                                               intptr_t src_a, intptr_t src_b,
                                               int nbhd, double alo,
                                               double ahi, double blo,
                                               double bhi);

ARX_GE_EXPORT intptr_t arx_ge_poc3_new (void);
ARX_GE_EXPORT intptr_t arx_ge_poc3_new_curve (intptr_t curve);
ARX_GE_EXPORT intptr_t arx_ge_poc3_new_param (intptr_t curve, double param);
ARX_GE_EXPORT void     arx_ge_poc3_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_poc3_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_poc3_set_curve (intptr_t self, intptr_t curve);
ARX_GE_EXPORT int      arx_ge_poc3_set_param (intptr_t self, double param);
ARX_GE_EXPORT int      arx_ge_poc3_same_curve (intptr_t self, intptr_t curve);
ARX_GE_EXPORT double   arx_ge_poc3_parameter (intptr_t self);
ARX_GE_EXPORT int      arx_ge_poc3_type_id (intptr_t self);
ARX_GE_EXPORT int      arx_ge_poc3_get_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_poc3_get_point_at (intptr_t self, double param,
                                                 intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_poc3_curve_point (intptr_t curve, double param,
                                                intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_poc3_get_deriv (intptr_t self, int order,
                                              intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_poc3_get_deriv_at (intptr_t self, int order,
                                                 double param, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_poc3_curve_deriv (intptr_t curve, int order,
                                                double param, intptr_t outVec);
ARX_GE_EXPORT double   arx_ge_poc3_curvature (intptr_t self);
ARX_GE_EXPORT double   arx_ge_poc3_curvature_at (intptr_t self, double param);
ARX_GE_EXPORT int      arx_ge_poc3_is_singular (intptr_t self);
ARX_GE_EXPORT int      arx_ge_poc3_take_closest (intptr_t self, intptr_t src,
                                                 double x, double y, double z);
ARX_GE_EXPORT int      arx_ge_poc3_take_closest_pair (intptr_t self, intptr_t other,
                                                      intptr_t src_a,
                                                      intptr_t src_b);
ARX_GE_EXPORT int      arx_ge_poc3_take_proj_closest (intptr_t self, intptr_t src,
                                                      double px, double py,
                                                      double pz, double dx,
                                                      double dy, double dz);
ARX_GE_EXPORT int      arx_ge_poc3_take_proj_closest_pair (intptr_t self,
                                                           intptr_t other,
                                                           intptr_t src_a,
                                                           intptr_t src_b,
                                                           double dx, double dy,
                                                           double dz);
ARX_GE_EXPORT int      arx_ge_poc3_normal (intptr_t self, intptr_t src,
                                           double x, double y, double z);
ARX_GE_EXPORT int      arx_ge_poc3_local_point (intptr_t self, intptr_t src,
                                                double x, double y, double z,
                                                int nbhd, double alo,
                                                double ahi);
ARX_GE_EXPORT int      arx_ge_poc3_local_pair (intptr_t self, intptr_t other,
                                               intptr_t src_a, intptr_t src_b,
                                               int nbhd, double alo,
                                               double ahi, double blo,
                                               double bhi);

/* ---------- AcGeOffsetCurve2d / AcGeOffsetCurve3d ----------
 * Every handle owns a private by-type clone of its source curve, made and
 * destroyed inside the bridge; see the block comment in the .cpp.
 */

ARX_GE_EXPORT intptr_t arx_ge_ofc2_new (intptr_t curve, double dist);
ARX_GE_EXPORT void     arx_ge_ofc2_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ofc2_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_ofc2_set_curve (intptr_t self, intptr_t curve);
ARX_GE_EXPORT int      arx_ge_ofc2_set_dist (intptr_t self, double dist);
ARX_GE_EXPORT double   arx_ge_ofc2_dist (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ofc2_param_direction (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ofc2_is_identity (intptr_t self);
ARX_GE_EXPORT double   arx_ge_ofc2_transform_entry (intptr_t self, int row, int col);
ARX_GE_EXPORT int      arx_ge_ofc2_src_type_id (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ofc2_struct_size (void);

ARX_GE_EXPORT intptr_t arx_ge_ofc3_new (intptr_t curve, double nx, double ny,
                                        double nz, double dist);
ARX_GE_EXPORT void     arx_ge_ofc3_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ofc3_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_ofc3_set_curve (intptr_t self, intptr_t curve);
ARX_GE_EXPORT int      arx_ge_ofc3_set_dist (intptr_t self, double dist);
ARX_GE_EXPORT double   arx_ge_ofc3_dist (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ofc3_set_normal (intptr_t self, double nx, double ny,
                                               double nz);
ARX_GE_EXPORT int      arx_ge_ofc3_get_normal (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_ofc3_param_direction (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ofc3_is_identity (intptr_t self);
ARX_GE_EXPORT double   arx_ge_ofc3_transform_entry (intptr_t self, int row, int col);
ARX_GE_EXPORT int      arx_ge_ofc3_src_type_id (intptr_t self);
ARX_GE_EXPORT int      arx_ge_ofc3_struct_size (void);

/* ---------- AcGeInterval ----------
** Heap-owned AcGeInterval handles.  Readers report the raw stored bounds, so the
** boundedness predicates are the only way to tell closed / half-open / open apart.
**   new_*      0 on throw (the SDK default tolerance overload is kept separate so the
**              library never hard-codes 1.e-12)
**   copy       operator= into an already created object, 1 done / 0 bad handle or threw
**   setters    1 done / 0 bad handle or threw; none of them rebalance the bounds
**   readers    ARX_GE_NAN on a bad handle
**   predicates 1 or 0; a bad handle gives 0
**   merge/intersect/overlap 1 or 0, subtract the piece count 0..2, -1 on bad handle.
**              None of them resets a result object -- the library does that.
**   periodic   flag and folded value are two calls; isPeriodicallyOn never mutates.
** The relational operators (< <= > >=) are deliberately absent: interval-vs-interval
** reads false for every pair including a == a, so only == and != are exposed.
*/

ARX_GE_EXPORT intptr_t arx_ge_iv_new (void);
ARX_GE_EXPORT intptr_t arx_ge_iv_new_tol (double tol);
ARX_GE_EXPORT intptr_t arx_ge_iv_new_bounds (double lower, double upper, double tol);
ARX_GE_EXPORT intptr_t arx_ge_iv_new_bounds_def (double lower, double upper);
ARX_GE_EXPORT intptr_t arx_ge_iv_new_half (int boundedBelow, double bound, double tol);
ARX_GE_EXPORT intptr_t arx_ge_iv_new_half_def (int boundedBelow, double bound);
ARX_GE_EXPORT void     arx_ge_iv_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_iv_copy (intptr_t self, intptr_t src);

ARX_GE_EXPORT double   arx_ge_iv_lower (intptr_t self);
ARX_GE_EXPORT double   arx_ge_iv_upper (intptr_t self);
ARX_GE_EXPORT double   arx_ge_iv_element (intptr_t self);
ARX_GE_EXPORT double   arx_ge_iv_length (intptr_t self);
ARX_GE_EXPORT double   arx_ge_iv_tol (intptr_t self);

ARX_GE_EXPORT int      arx_ge_iv_set_bounds (intptr_t self, double lower, double upper);
ARX_GE_EXPORT int      arx_ge_iv_set_half (intptr_t self, int boundedBelow, double bound);
ARX_GE_EXPORT int      arx_ge_iv_set_unbounded (intptr_t self);
ARX_GE_EXPORT int      arx_ge_iv_set_upper (intptr_t self, double upper);
ARX_GE_EXPORT int      arx_ge_iv_set_lower (intptr_t self, double lower);
ARX_GE_EXPORT int      arx_ge_iv_set_tol (intptr_t self, double tol);

ARX_GE_EXPORT int      arx_ge_iv_is_bounded (intptr_t self);
ARX_GE_EXPORT int      arx_ge_iv_is_bounded_above (intptr_t self);
ARX_GE_EXPORT int      arx_ge_iv_is_bounded_below (intptr_t self);
ARX_GE_EXPORT int      arx_ge_iv_is_unbounded (intptr_t self);
ARX_GE_EXPORT int      arx_ge_iv_is_singleton (intptr_t self);

ARX_GE_EXPORT int      arx_ge_iv_equals (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_iv_not_equals (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_iv_contains_iv (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_iv_contains_val (intptr_t self, double val);
ARX_GE_EXPORT int      arx_ge_iv_is_disjoint (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_iv_continuous_at_upper (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_iv_equal_at_upper_iv (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_iv_equal_at_upper_val (intptr_t self, double val);
ARX_GE_EXPORT int      arx_ge_iv_equal_at_lower_iv (intptr_t self, intptr_t other);
ARX_GE_EXPORT int      arx_ge_iv_equal_at_lower_val (intptr_t self, double val);

ARX_GE_EXPORT int      arx_ge_iv_merge (intptr_t self, intptr_t other, intptr_t res);
ARX_GE_EXPORT int      arx_ge_iv_subtract (intptr_t self, intptr_t other,
                                           intptr_t res_l, intptr_t res_r);
ARX_GE_EXPORT int      arx_ge_iv_intersect (intptr_t self, intptr_t other, intptr_t res);
ARX_GE_EXPORT int      arx_ge_iv_overlap_at_upper (intptr_t self, intptr_t other,
                                                   intptr_t res);

ARX_GE_EXPORT int      arx_ge_iv_periodic_on (intptr_t self, double period, double val);
ARX_GE_EXPORT double   arx_ge_iv_periodic_fold (intptr_t self, double period, double val);
ARX_GE_EXPORT int      arx_ge_iv_struct_size (void);

/* ---------- AcGePointOnSurface (package 19B) --------------------------------
**
** A surface parameter point: a borrowed const AcGeSurface& plus an (u, v) pair.
** surface_handle may be an AcGePlane or an AcGeBoundedPlane handle -- both
** derive from AcGeSurface as their first non virtual base, so the cast is the
** same address. The alias is never owned: freeing the point never frees the
** surface. No destructor is exported for this class (only ~AcGeEntity3d is, and
** it is not virtual), so handles never leave the bridge and the object is
** deleted through its own concrete type.
** parameter writes the pair into a caller created AcGePoint2d handle; the
** three evaluation forms per family mirror the point-on-curve classes: on self,
** on self at another (u, v), and on a fresh object for a bare surface handle.
** pos_probe_* are measurement only and are removed with the probe.
*/

ARX_GE_EXPORT intptr_t arx_ge_pos_new (void);
ARX_GE_EXPORT intptr_t arx_ge_pos_new_surface (intptr_t surf);
ARX_GE_EXPORT intptr_t arx_ge_pos_new_param (intptr_t surf, double u, double v);
ARX_GE_EXPORT void     arx_ge_pos_free (intptr_t self);
ARX_GE_EXPORT int      arx_ge_pos_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT int      arx_ge_pos_set_surface (intptr_t self, intptr_t surf);
ARX_GE_EXPORT int      arx_ge_pos_set_param (intptr_t self, double u, double v);
ARX_GE_EXPORT int      arx_ge_pos_same_surface (intptr_t self, intptr_t surf);
ARX_GE_EXPORT int      arx_ge_pos_parameter (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_pos_type_id (intptr_t self);
ARX_GE_EXPORT int      arx_ge_pos_point (intptr_t self, intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_pos_point_at (intptr_t self, double u, double v,
                                            intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_pos_surface_point (intptr_t surf, double u, double v,
                                                 intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_pos_normal (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_normal_at (intptr_t self, double u, double v,
                                             intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_surface_normal (intptr_t surf, double u, double v,
                                                  intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_u_deriv (intptr_t self, int order, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_u_deriv_at (intptr_t self, int order, double u,
                                              double v, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_surface_u_deriv (intptr_t surf, int order,
                                                   double u, double v,
                                                   intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_v_deriv (intptr_t self, int order, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_v_deriv_at (intptr_t self, int order, double u,
                                              double v, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_surface_v_deriv (intptr_t surf, int order,
                                                   double u, double v,
                                                   intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_mixed_deriv (intptr_t self, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_mixed_deriv_at (intptr_t self, double u, double v,
                                                  intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_surface_mixed_deriv (intptr_t surf, double u,
                                                       double v, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_tangent (intptr_t self, double du, double dv,
                                           intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_tangent_at (intptr_t self, double du, double dv,
                                              double u, double v, intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_surface_tangent (intptr_t surf, double du,
                                                   double dv, double u, double v,
                                                   intptr_t outVec);
ARX_GE_EXPORT int      arx_ge_pos_inverse_tangent (intptr_t self, double vx,
                                                   double vy, double vz,
                                                   intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_pos_inverse_tangent_at (intptr_t self, double vx,
                                                      double vy, double vz,
                                                      double u, double v,
                                                      intptr_t outPnt);
ARX_GE_EXPORT int      arx_ge_pos_surface_inverse_tangent (intptr_t surf, double vx,
                                                           double vy, double vz,
                                                           double u, double v,
                                                           intptr_t outPnt);

/* ---------- AcGeScale2d / AcGeScale3d (package 20) --------------------------
**
** Heap-owned scale handles.  Both classes are plain data (sx, sy[, sz]) with no
** entity id and no type(), so there is no type-number channel here, exactly like
** the AcGeInterval mirror.  Component access goes through the SDK operator[],
** which the headers define inline as  *(&sx + i)  with no bounds check, so the
** bridge range checks the index (0..1 for 2d, 0..2 for 3d) and the library layer
** passes only those values.
**   new_*       handle, or 0 when the source handle is bad or the ctor throws
**   free        no-op on a 0 handle
**   writers     1 done / 0 bad handle or threw
**   readers     ARX_GE_NAN on a bad handle
**   predicates  1 or 0; a bad handle gives 0
**   *_to        the value returning SDK forms (inverse(), the conversion
**               operator) write into a caller created handle
** Neither class declares a destructor or an assignment operator, so both are
** the compiler generated trivial forms and nothing about them has to be imported.
** operator == and operator != are header inline forwarders onto isEqualTo with
** the default tolerance, so equals / not_equals / is_equal_to land on the same
** imported entry point, and they were measured to give the same verdict.
** The four const operator* forms (scale*scale, scale*double, double*scale and
** the friend) do have import symbols but are not mirrored: the matrix mirror of
** this bridge exposes only preMultBy / postMultBy / setToProduct, and
** setToProduct is the same product with self as the output.
** AcGeScale2d::operator AcGeScale3d() is NOT mirrored -- it has no import
** symbol in any library under lib-x64, so the only cast that reaches is the
** matrix one.  That matrix cast operator is not mirrored either: it writes the
** same numbers getMatrix writes, element for element, so get_matrix is the
** single entry point for the matrix channel.
*/
/* AcGeScale2d */
ARX_GE_EXPORT intptr_t  arx_ge_sc2_new (void);
ARX_GE_EXPORT intptr_t  arx_ge_sc2_new_uniform (double factor);
ARX_GE_EXPORT intptr_t  arx_ge_sc2_new_components (double xFactor, double yFactor);
ARX_GE_EXPORT intptr_t  arx_ge_sc2_new_identity (void);
ARX_GE_EXPORT intptr_t  arx_ge_sc2_new_copy (intptr_t src);
ARX_GE_EXPORT void      arx_ge_sc2_free (intptr_t self);
ARX_GE_EXPORT int       arx_ge_sc2_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT double    arx_ge_sc2_component (intptr_t self, int index);
ARX_GE_EXPORT int       arx_ge_sc2_set_component (intptr_t self, int index, double value);
ARX_GE_EXPORT int       arx_ge_sc2_set_components (intptr_t self, double xFactor, double yFactor);
ARX_GE_EXPORT int       arx_ge_sc2_mul_scale (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc2_mul_double (intptr_t self, double factor);
ARX_GE_EXPORT int       arx_ge_sc2_pre_mult_by (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc2_post_mult_by (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc2_set_to_product (intptr_t self, intptr_t left, intptr_t right);
ARX_GE_EXPORT int       arx_ge_sc2_set_to_product_double (intptr_t self, intptr_t src, double factor);
ARX_GE_EXPORT int       arx_ge_sc2_invert (intptr_t self);
ARX_GE_EXPORT int       arx_ge_sc2_inverse_to (intptr_t self, intptr_t out);
ARX_GE_EXPORT int       arx_ge_sc2_equals (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc2_not_equals (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc2_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc2_is_proportional (intptr_t self);
ARX_GE_EXPORT int       arx_ge_sc2_is_identity (intptr_t self);
ARX_GE_EXPORT int       arx_ge_sc2_get_matrix (intptr_t self, intptr_t out_mat);
ARX_GE_EXPORT int       arx_ge_sc2_extract_from_matrix (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int       arx_ge_sc2_remove_from_matrix (intptr_t self, intptr_t mat);

/* AcGeScale3d */
ARX_GE_EXPORT intptr_t  arx_ge_sc3_new (void);
ARX_GE_EXPORT intptr_t  arx_ge_sc3_new_uniform (double factor);
ARX_GE_EXPORT intptr_t  arx_ge_sc3_new_components (double xFactor, double yFactor, double zFactor);
ARX_GE_EXPORT intptr_t  arx_ge_sc3_new_identity (void);
ARX_GE_EXPORT intptr_t  arx_ge_sc3_new_copy (intptr_t src);
ARX_GE_EXPORT void      arx_ge_sc3_free (intptr_t self);
ARX_GE_EXPORT int       arx_ge_sc3_copy (intptr_t self, intptr_t src);
ARX_GE_EXPORT double    arx_ge_sc3_component (intptr_t self, int index);
ARX_GE_EXPORT int       arx_ge_sc3_set_component (intptr_t self, int index, double value);
ARX_GE_EXPORT int       arx_ge_sc3_set_components (intptr_t self, double xFactor, double yFactor, double zFactor);
ARX_GE_EXPORT int       arx_ge_sc3_mul_scale (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc3_mul_double (intptr_t self, double factor);
ARX_GE_EXPORT int       arx_ge_sc3_pre_mult_by (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc3_post_mult_by (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc3_set_to_product (intptr_t self, intptr_t left, intptr_t right);
ARX_GE_EXPORT int       arx_ge_sc3_set_to_product_double (intptr_t self, intptr_t src, double factor);
ARX_GE_EXPORT int       arx_ge_sc3_invert (intptr_t self);
ARX_GE_EXPORT int       arx_ge_sc3_inverse_to (intptr_t self, intptr_t out);
ARX_GE_EXPORT int       arx_ge_sc3_equals (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc3_not_equals (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc3_is_equal_to (intptr_t self, intptr_t other);
ARX_GE_EXPORT int       arx_ge_sc3_is_proportional (intptr_t self);
ARX_GE_EXPORT int       arx_ge_sc3_is_identity (intptr_t self);
ARX_GE_EXPORT int       arx_ge_sc3_get_matrix (intptr_t self, intptr_t out_mat);
ARX_GE_EXPORT int       arx_ge_sc3_extract_from_matrix (intptr_t self, intptr_t mat);
ARX_GE_EXPORT int       arx_ge_sc3_remove_from_matrix (intptr_t self, intptr_t mat);

/* ---------- layout sanity ---------- */

ARX_GE_EXPORT int arx_ge_point_struct_size (void);
ARX_GE_EXPORT int arx_ge_vector_struct_size (void);
ARX_GE_EXPORT int arx_ge_matrix_struct_size (void);
ARX_GE_EXPORT int arx_ge_point2d_struct_size (void);
ARX_GE_EXPORT int arx_ge_vector2d_struct_size (void);
ARX_GE_EXPORT int arx_ge_matrix2d_struct_size (void);
ARX_GE_EXPORT int arx_ge_line2d_struct_size (void);
ARX_GE_EXPORT int arx_ge_lineseg2d_struct_size (void);
ARX_GE_EXPORT int arx_ge_line3d_struct_size (void);
ARX_GE_EXPORT int arx_ge_lineseg3d_struct_size (void);
ARX_GE_EXPORT int arx_ge_ray2d_struct_size (void);
ARX_GE_EXPORT int arx_ge_ray3d_struct_size (void);
ARX_GE_EXPORT int arx_ge_plane_struct_size (void);
ARX_GE_EXPORT int arx_ge_circarc2d_struct_size (void);
ARX_GE_EXPORT int arx_ge_circarc3d_struct_size (void);
ARX_GE_EXPORT int arx_ge_ellip2d_struct_size (void);
ARX_GE_EXPORT int arx_ge_ellip3d_struct_size (void);
ARX_GE_EXPORT int arx_ge_block2_struct_size (void);
ARX_GE_EXPORT int arx_ge_block3_struct_size (void);
ARX_GE_EXPORT int arx_ge_poc2_struct_size (void);
ARX_GE_EXPORT int arx_ge_poc3_struct_size (void);
ARX_GE_EXPORT int arx_ge_pos_struct_size (void);
ARX_GE_EXPORT int arx_ge_sc2_struct_size (void);
ARX_GE_EXPORT int arx_ge_sc3_struct_size (void);

#ifdef __cplusplus
}
#endif

#endif /* ARX_GE_BRIDGE_H */
