// ASCII only. Volcano requires external native sources/headers to be ANSI charset.
// Thin extern "C" ABI boundary over the real ObjectARX 2026 AcGe classes.
// Every numeric result below is produced by the Autodesk AcGe implementation.

#include "arx_ge_bridge.h"

#include <limits>
#include <stdio.h>

#include <gegbl.h>
#include <getol.h>
#include <gepnt3d.h>
#include <gevec3d.h>
#include <gemat3d.h>
#include <gepnt2d.h>
#include <gevec2d.h>
#include <gemat2d.h>
#include <geline2d.h>
#include <gelnsg2d.h>
#include <geline3d.h>
#include <gelnsg3d.h>
#include <geplane.h>
#include <gebndpln.h>
#include <gearc2d.h>
#include <gearc3d.h>
#include <geell2d.h>
#include <geell3d.h>
#include <geent2d.h>
#include <geent3d.h>
#include <geray2d.h>
#include <geray3d.h>
#include <gepos3d.h>
#include <gecurv2d.h>
#include <gecurv3d.h>
#include <gept2dar.h>
#include <gept3dar.h>
#include <gedblar.h>
#include <gevptar.h>
#include <geoffc2d.h>
#include <geoffc3d.h>
#include <geintrvl.h>
#include <geblok2d.h>
#include <geblok3d.h>
#include <geponsrf.h>
#include <gescl2d.h>
#include <gescl3d.h>

#define ARX_GE_NAN (std::numeric_limits<double>::quiet_NaN ())

static inline AcGePoint3d* arx_pt (intptr_t value)
{
    return reinterpret_cast<AcGePoint3d*> (value);
}

static inline AcGeVector3d* arx_vec (intptr_t value)
{
    return reinterpret_cast<AcGeVector3d*> (value);
}

static inline AcGeMatrix3d* arx_mat (intptr_t value)
{
    return reinterpret_cast<AcGeMatrix3d*> (value);
}

static inline AcGePoint2d* arx_pt2 (intptr_t value)
{
    return reinterpret_cast<AcGePoint2d*> (value);
}

static inline AcGeVector2d* arx_vec2 (intptr_t value)
{
    return reinterpret_cast<AcGeVector2d*> (value);
}

static inline AcGeMatrix2d* arx_mat2 (intptr_t value)
{
    return reinterpret_cast<AcGeMatrix2d*> (value);
}

static inline AcGeLine2d* arx_line2 (intptr_t value)
{
    return reinterpret_cast<AcGeLine2d*> (value);
}

static inline AcGeLineSeg2d* arx_seg2 (intptr_t value)
{
    return reinterpret_cast<AcGeLineSeg2d*> (value);
}

static inline AcGeLinearEnt2d* arx_lent2 (intptr_t value)
{
    return reinterpret_cast<AcGeLinearEnt2d*> (value);
}

static inline AcGeEntity2d* arx_ent2 (intptr_t value)
{
    return reinterpret_cast<AcGeEntity2d*> (value);
}

static inline AcGeLine3d* arx_line3 (intptr_t value)
{
    return reinterpret_cast<AcGeLine3d*> (value);
}

static inline AcGeLineSeg3d* arx_seg3 (intptr_t value)
{
    return reinterpret_cast<AcGeLineSeg3d*> (value);
}

static inline AcGeLinearEnt3d* arx_lent3 (intptr_t value)
{
    return reinterpret_cast<AcGeLinearEnt3d*> (value);
}

static inline AcGePlane* arx_plane (intptr_t value)
{
    return reinterpret_cast<AcGePlane*> (value);
}

static inline AcGeBoundedPlane* arx_bplane (intptr_t value)
{
    return reinterpret_cast<AcGeBoundedPlane*> (value);
}

static inline AcGePlanarEnt* arx_planar (intptr_t value)
{
    return reinterpret_cast<AcGePlanarEnt*> (value);
}

static inline AcGeCurve2d* arx_curve2 (intptr_t value)
{
    return reinterpret_cast<AcGeCurve2d*> (value);
}

static inline AcGeCircArc2d* arx_arc2 (intptr_t value)
{
    return reinterpret_cast<AcGeCircArc2d*> (value);
}

static inline AcGeCurve3d* arx_curve3 (intptr_t value)
{
    return reinterpret_cast<AcGeCurve3d*> (value);
}

static inline AcGeCircArc3d* arx_arc3 (intptr_t value)
{
    return reinterpret_cast<AcGeCircArc3d*> (value);
}

static inline AcGeEllipArc2d* arx_ellip2 (intptr_t value)
{
    return reinterpret_cast<AcGeEllipArc2d*> (value);
}

static inline AcGeEllipArc3d* arx_ellip3 (intptr_t value)
{
    return reinterpret_cast<AcGeEllipArc3d*> (value);
}
static inline AcGeEntity3d* arx_ent3 (intptr_t value)
{
    return reinterpret_cast<AcGeEntity3d*> (value);
}
static inline AcGePosition3d* arx_position3 (intptr_t value)
{
    return reinterpret_cast<AcGePosition3d*> (value);
}
static inline AcGeBoundBlock2d* arx_block2 (intptr_t value)
{
    return reinterpret_cast<AcGeBoundBlock2d*> (value);
}
static inline AcGeBoundBlock3d* arx_block3 (intptr_t value)
{
    return reinterpret_cast<AcGeBoundBlock3d*> (value);
}
static inline AcGePointOnCurve2d* arx_poc2 (intptr_t value)
{
    return reinterpret_cast<AcGePointOnCurve2d*> (value);
}
static inline AcGePointOnCurve3d* arx_poc3 (intptr_t value)
{
    return reinterpret_cast<AcGePointOnCurve3d*> (value);
}


static inline AcGeOffsetCurve2d* arx_ofc2 (intptr_t value)
{
    return reinterpret_cast<AcGeOffsetCurve2d*> (value);
}
static inline AcGeOffsetCurve3d* arx_ofc3 (intptr_t value)
{
    return reinterpret_cast<AcGeOffsetCurve3d*> (value);
}

static inline AcGeRay2d* arx_ray2 (intptr_t value)
{
    return reinterpret_cast<AcGeRay2d*> (value);
}
static inline AcGeRay3d* arx_ray3 (intptr_t value)
{
    return reinterpret_cast<AcGeRay3d*> (value);
}

/* Both AcGePlane and AcGeBoundedPlane hang off AcGePlanarEnt, whose first non
** virtual base is AcGeSurface, so the surface view of either handle is the very
** same address. No type check here: the class library is the one that decides
** which handle is legal, same as the curve helpers above.
*/
static inline AcGeSurface* arx_surf (intptr_t value)
{
    return reinterpret_cast<AcGeSurface*> (value);
}

static inline AcGePointOnSurface* arx_pos (intptr_t value)
{
    return reinterpret_cast<AcGePointOnSurface*> (value);
}

static inline bool arx_idx_ok (int index)
{
    return index >= 0 && index <= 3;
}

static inline bool arx_idx2_ok (int index)
{
    return index >= 0 && index <= 2;
}

static inline bool arx_ok (intptr_t value)
{
    return value != 0;
}

extern "C" {

/* ---------- AcGePoint3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_point_new (double x, double y, double z)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePoint3d (x, y, z));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_point_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_pt (self);
}

ARX_GE_EXPORT double arx_ge_point_x (intptr_t self)
{
    return arx_ok (self) ? arx_pt (self)->x : ARX_GE_NAN;
}

ARX_GE_EXPORT double arx_ge_point_y (intptr_t self)
{
    return arx_ok (self) ? arx_pt (self)->y : ARX_GE_NAN;
}

ARX_GE_EXPORT double arx_ge_point_z (intptr_t self)
{
    return arx_ok (self) ? arx_pt (self)->z : ARX_GE_NAN;
}

ARX_GE_EXPORT int arx_ge_point_set (intptr_t self, double x, double y, double z)
{
    if (!arx_ok (self))
        return 0;
    arx_pt (self)->set (x, y, z);
    return 1;
}

ARX_GE_EXPORT double arx_ge_point_distance_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return -1.0;
    return self == other ? 0.0 : arx_pt (self)->distanceTo (*arx_pt (other));
}

ARX_GE_EXPORT int arx_ge_point_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return arx_pt (self)->isEqualTo (*arx_pt (other)) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_point_add_vector (intptr_t self, intptr_t vec)
{
    if (!arx_ok (self) || !arx_ok (vec))
        return 0;
    *arx_pt (self) += *arx_vec (vec);
    return 1;
}

ARX_GE_EXPORT int arx_ge_point_sub_vector (intptr_t self, intptr_t vec)
{
    if (!arx_ok (self) || !arx_ok (vec))
        return 0;
    *arx_pt (self) -= *arx_vec (vec);
    return 1;
}

ARX_GE_EXPORT int arx_ge_point_sub_point (intptr_t self, intptr_t other, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outVec))
        return 0;
    *arx_vec (outVec) = *arx_pt (self) - *arx_pt (other);
    return 1;
}

ARX_GE_EXPORT int arx_ge_point_as_vector (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    *arx_vec (outVec) = arx_pt (self)->asVector ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_point_scale_by (intptr_t self, double scale, double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    arx_pt (self)->scaleBy (scale, AcGePoint3d (cx, cy, cz));
    return 1;
}

ARX_GE_EXPORT int arx_ge_point_rotate_by (intptr_t self, double angle,
                                          double axisX, double axisY, double axisZ,
                                          double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_pt (self)->rotateBy (angle, AcGeVector3d (axisX, axisY, axisZ), AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeVector3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_vector_new (double x, double y, double z)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeVector3d (x, y, z));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_vector_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_vec (self);
}

ARX_GE_EXPORT double arx_ge_vector_x (intptr_t self)
{
    return arx_ok (self) ? arx_vec (self)->x : ARX_GE_NAN;
}

ARX_GE_EXPORT double arx_ge_vector_y (intptr_t self)
{
    return arx_ok (self) ? arx_vec (self)->y : ARX_GE_NAN;
}

ARX_GE_EXPORT double arx_ge_vector_z (intptr_t self)
{
    return arx_ok (self) ? arx_vec (self)->z : ARX_GE_NAN;
}

ARX_GE_EXPORT int arx_ge_vector_set (intptr_t self, double x, double y, double z)
{
    if (!arx_ok (self))
        return 0;
    arx_vec (self)->set (x, y, z);
    return 1;
}

ARX_GE_EXPORT double arx_ge_vector_length (intptr_t self)
{
    return arx_ok (self) ? arx_vec (self)->length () : -1.0;
}

ARX_GE_EXPORT double arx_ge_vector_length_sqrd (intptr_t self)
{
    return arx_ok (self) ? arx_vec (self)->lengthSqrd () : -1.0;
}

ARX_GE_EXPORT int arx_ge_vector_normalize (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_vec (self)->normalize ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_vector_dot_product (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0.0;
    return arx_vec (self)->dotProduct (*arx_vec (other));
}

ARX_GE_EXPORT int arx_ge_vector_cross_product (intptr_t self, intptr_t other, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outVec))
        return 0;
    *arx_vec (outVec) = arx_vec (self)->crossProduct (*arx_vec (other));
    return 1;
}

ARX_GE_EXPORT double arx_ge_vector_angle_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return -1.0;
    return arx_vec (self)->angleTo (*arx_vec (other));
}

ARX_GE_EXPORT int arx_ge_vector_is_parallel_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return arx_vec (self)->isParallelTo (*arx_vec (other)) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector_is_perpendicular_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return arx_vec (self)->isPerpendicularTo (*arx_vec (other)) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector_negate (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    arx_vec (self)->negate ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector_add (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    *arx_vec (self) += *arx_vec (other);
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector_scale (intptr_t self, double scale)
{
    if (!arx_ok (self))
        return 0;
    *arx_vec (self) *= scale;
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector_perp_vector (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    *arx_vec (outVec) = arx_vec (self)->perpVector ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector_rotate_by (intptr_t self, double angle,
                                           double axisX, double axisY, double axisZ)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_vec (self)->rotateBy (angle, AcGeVector3d (axisX, axisY, axisZ));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return self == other ? 1 : (arx_vec (self)->isEqualTo (*arx_vec (other)) ? 1 : 0);
}

ARX_GE_EXPORT int arx_ge_vector_is_unit_length (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    return arx_vec (self)->isUnitLength () ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector_is_zero_length (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    return arx_vec (self)->isZeroLength () ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector_is_codirectional_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return arx_vec (self)->isCodirectionalTo (*arx_vec (other)) ? 1 : 0;
}

/* largestElement reports which component wins, so a legal answer already covers 0.
** -1 is the only value left over to mean "no object here".
*/
ARX_GE_EXPORT int arx_ge_vector_largest_element (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    return (int) arx_vec (self)->largestElement ();
}

/* ---------- AcGeVector3d mapping onto a plane (UCS helpers) ----------
** angleOnPlane and convert2d both take a const AcGePlanarEnt&, so one entry point
** covers a plane and a bounded plane alike.  angleOnPlane is a signed angle, hence
** NaN rather than -1 marks an invalid handle (same reasoning as the AcGeVector2d
** angle accessors below).
** rotateTo returns the matrix that turns this vector onto the argument vector about
** an axis.  The SDK declares that axis with a default of AcGeVector3d::kIdentity, so
** the no-axis entry point simply omits the argument instead of restating the value.
*/

ARX_GE_EXPORT double arx_ge_vector_angle_on_plane (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return ARX_GE_NAN;
    try
    {
        return arx_vec (self)->angleOnPlane (*arx_planar (plane));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_vector_convert2d (intptr_t self, intptr_t plane, intptr_t outVec2)
{
    if (!arx_ok (self) || !arx_ok (plane) || !arx_ok (outVec2))
        return 0;
    try
    {
        *arx_vec2 (outVec2) = arx_vec (self)->convert2d (*arx_planar (plane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector_rotate_to (intptr_t self, intptr_t vec, intptr_t outMat)
{
    if (!arx_ok (self) || !arx_ok (vec) || !arx_ok (outMat))
        return 0;
    try
    {
        *arx_mat (outMat) = arx_vec (self)->rotateTo (*arx_vec (vec));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector_rotate_to_axis (intptr_t self, intptr_t vec,
                                                double axisX, double axisY, double axisZ,
                                                intptr_t outMat)
{
    if (!arx_ok (self) || !arx_ok (vec) || !arx_ok (outMat))
        return 0;
    try
    {
        *arx_mat (outMat) = arx_vec (self)->rotateTo (*arx_vec (vec),
                                                      AcGeVector3d (axisX, axisY, axisZ));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeTol (AcGeContext::gTol) and explicit-tolerance comparisons ---- */

ARX_GE_EXPORT double arx_ge_tol_equal_point (void)
{
    try
    {
        return AcGeContext::gTol.equalPoint ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_tol_equal_vector (void)
{
    try
    {
        return AcGeContext::gTol.equalVector ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_point_is_equal_to_tol (intptr_t self, intptr_t other, double equalPoint)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalPoint >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualPoint (equalPoint);
        return arx_pt (self)->isEqualTo (*arx_pt (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector_is_equal_to_tol (intptr_t self, intptr_t other, double equalVector)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_vec (self)->isEqualTo (*arx_vec (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector_is_parallel_to_tol (intptr_t self, intptr_t other, double equalVector)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_vec (self)->isParallelTo (*arx_vec (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector_is_perpendicular_to_tol (intptr_t self, intptr_t other, double equalVector)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_vec (self)->isPerpendicularTo (*arx_vec (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeMatrix3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_matrix_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeMatrix3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_matrix_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_mat (self);
}

ARX_GE_EXPORT int arx_ge_matrix_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    *arx_mat (self) = *arx_mat (src);
    return 1;
}

ARX_GE_EXPORT double arx_ge_matrix_get_elem (intptr_t self, int row, int col)
{
    if (!arx_ok (self) || !arx_idx_ok (row) || !arx_idx_ok (col))
        return ARX_GE_NAN;
    return arx_mat (self)->entry[row][col];
}

ARX_GE_EXPORT int arx_ge_matrix_set_elem (intptr_t self, int row, int col, double value)
{
    if (!arx_ok (self) || !arx_idx_ok (row) || !arx_idx_ok (col))
        return 0;
    arx_mat (self)->entry[row][col] = value;
    return 1;
}

ARX_GE_EXPORT int arx_ge_matrix_set_identity (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    arx_mat (self)->setToIdentity ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_translation (intptr_t self, double dx, double dy, double dz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat (self)->setToTranslation (AcGeVector3d (dx, dy, dz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_get_translation (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_mat (self)->translation ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_rotation (intptr_t self, double angle,
                                                double axisX, double axisY, double axisZ,
                                                double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat (self)->setToRotation (angle, AcGeVector3d (axisX, axisY, axisZ),
                                       AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_scaling (intptr_t self, double scaleAll,
                                                double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat (self)->setToScaling (scaleAll, AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_post_mult_by (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        arx_mat (self)->postMultBy (*arx_mat (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_pre_mult_by (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        arx_mat (self)->preMultBy (*arx_mat (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_product (intptr_t self, intptr_t mat1, intptr_t mat2)
{
    if (!arx_ok (self) || !arx_ok (mat1) || !arx_ok (mat2))
        return 0;
    try
    {
        arx_mat (self)->setToProduct (*arx_mat (mat1), *arx_mat (mat2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_invert (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        /* invert() returns the matrix reference, so singularity has to be tested first. */
        if (arx_mat (self)->isSingular ())
            return 0;
        AcGeMatrix3d inv = arx_mat (self)->inverse ();
        *arx_mat (self) = inv;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_get_inverse (intptr_t self, intptr_t outMat)
{
    if (!arx_ok (self) || !arx_ok (outMat))
        return 0;
    try
    {
        if (arx_mat (self)->isSingular ())
            return 0;
        AcGeMatrix3d inv = arx_mat (self)->inverse ();
        *arx_mat (outMat) = inv;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_is_singular (intptr_t self)
{
    if (!arx_ok (self))
        return 1;
    try
    {
        return arx_mat (self)->isSingular () ? 1 : 0;
    }
    catch (...)
    {
        return 1;
    }
}

ARX_GE_EXPORT double arx_ge_matrix_det (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_mat (self)->det ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_transpose_it (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    arx_mat (self)->transposeIt ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_matrix_get_transpose (intptr_t self, intptr_t outMat)
{
    if (!arx_ok (self) || !arx_ok (outMat))
        return 0;
    *arx_mat (outMat) = arx_mat (self)->transpose ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_matrix_is_equal_to_tol (intptr_t self, intptr_t other, double equalVector)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_mat (self)->isEqualTo (*arx_mat (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_is_scaled_ortho (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_mat (self)->isScaledOrtho () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_is_uni_scaled_ortho (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_mat (self)->isUniScaledOrtho () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_matrix_scale (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    return arx_mat (self)->scale ();
}

ARX_GE_EXPORT double arx_ge_matrix_norm (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    return arx_mat (self)->norm ();
}

ARX_GE_EXPORT int arx_ge_matrix_set_coord_system (intptr_t self,
                                                double ox, double oy, double oz,
                                                double xx, double xy, double xz,
                                                double yx, double yy, double yz,
                                                double zx, double zy, double zz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat (self)->setCoordSystem (AcGePoint3d (ox, oy, oz),
                                       AcGeVector3d (xx, xy, xz),
                                       AcGeVector3d (yx, yy, yz),
                                       AcGeVector3d (zx, zy, zz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_get_coord_system (intptr_t self, intptr_t outOrigin,
                                                intptr_t outX, intptr_t outY, intptr_t outZ)
{
    if (!arx_ok (self) || !arx_ok (outOrigin) || !arx_ok (outX) || !arx_ok (outY) || !arx_ok (outZ))
        return 0;
    try
    {
        arx_mat (self)->getCoordSystem (*arx_pt (outOrigin), *arx_vec (outX),
                                       *arx_vec (outY), *arx_vec (outZ));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_align_coord_sys (intptr_t self,
                                                        double fromOx, double fromOy, double fromOz,
                                                        double fromXx, double fromXy, double fromXz,
                                                        double fromYx, double fromYy, double fromYz,
                                                        double fromZx, double fromZy, double fromZz,
                                                        double toOx, double toOy, double toOz,
                                                        double toXx, double toXy, double toXz,
                                                        double toYx, double toYy, double toYz,
                                                        double toZx, double toZy, double toZz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        /* Flattened to 24 scalars so the 3D entry point reads like the 2D one above. */
        arx_mat (self)->setToAlignCoordSys (AcGePoint3d (fromOx, fromOy, fromOz),
                                            AcGeVector3d (fromXx, fromXy, fromXz),
                                            AcGeVector3d (fromYx, fromYy, fromYz),
                                            AcGeVector3d (fromZx, fromZy, fromZz),
                                            AcGePoint3d (toOx, toOy, toOz),
                                            AcGeVector3d (toXx, toXy, toXz),
                                            AcGeVector3d (toYx, toYy, toYz),
                                            AcGeVector3d (toZx, toZy, toZz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_mirroring (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat (self)->setToMirroring (AcGePoint3d (px, py, pz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- matrix driven transform ---------- */

ARX_GE_EXPORT int arx_ge_point_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_pt (self)->transformBy (*arx_mat (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_vec (self)->transformBy (*arx_mat (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGePoint2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_point2d_new (double x, double y)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePoint2d (x, y));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_point2d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_pt2 (self);
}

ARX_GE_EXPORT double arx_ge_point2d_x (intptr_t self)
{
    return arx_ok (self) ? arx_pt2 (self)->x : ARX_GE_NAN;
}

ARX_GE_EXPORT double arx_ge_point2d_y (intptr_t self)
{
    return arx_ok (self) ? arx_pt2 (self)->y : ARX_GE_NAN;
}

ARX_GE_EXPORT int arx_ge_point2d_set (intptr_t self, double x, double y)
{
    if (!arx_ok (self))
        return 0;
    arx_pt2 (self)->set (x, y);
    return 1;
}

ARX_GE_EXPORT double arx_ge_point2d_distance_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return -1.0;
    try
    {
        return arx_pt2 (self)->distanceTo (*arx_pt2 (other));
    }
    catch (...)
    {
        return -1.0;
    }
}

ARX_GE_EXPORT int arx_ge_point2d_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return arx_pt2 (self)->isEqualTo (*arx_pt2 (other)) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_point2d_is_equal_to_tol (intptr_t self, intptr_t other, double equalPoint)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalPoint >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualPoint (equalPoint);
        return arx_pt2 (self)->isEqualTo (*arx_pt2 (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_point2d_add_vector (intptr_t self, intptr_t vec)
{
    if (!arx_ok (self) || !arx_ok (vec))
        return 0;
    *arx_pt2 (self) += *arx_vec2 (vec);
    return 1;
}

ARX_GE_EXPORT int arx_ge_point2d_sub_vector (intptr_t self, intptr_t vec)
{
    if (!arx_ok (self) || !arx_ok (vec))
        return 0;
    *arx_pt2 (self) -= *arx_vec2 (vec);
    return 1;
}

ARX_GE_EXPORT int arx_ge_point2d_sub_point (intptr_t self, intptr_t other, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outVec))
        return 0;
    *arx_vec2 (outVec) = *arx_pt2 (self) - *arx_pt2 (other);
    return 1;
}

ARX_GE_EXPORT int arx_ge_point2d_as_vector (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    *arx_vec2 (outVec) = arx_pt2 (self)->asVector ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_point2d_set_to_sum (intptr_t self, intptr_t pnt, intptr_t vec)
{
    if (!arx_ok (self) || !arx_ok (pnt) || !arx_ok (vec))
        return 0;
    arx_pt2 (self)->setToSum (*arx_pt2 (pnt), *arx_vec2 (vec));
    return 1;
}

ARX_GE_EXPORT int arx_ge_point2d_scale_by (intptr_t self, double scale, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_pt2 (self)->scaleBy (scale, AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_point2d_rotate_by (intptr_t self, double angle, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_pt2 (self)->rotateBy (angle, AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeVector2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_vector2d_new (double x, double y)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeVector2d (x, y));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_vector2d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_vec2 (self);
}

ARX_GE_EXPORT double arx_ge_vector2d_x (intptr_t self)
{
    return arx_ok (self) ? arx_vec2 (self)->x : ARX_GE_NAN;
}

ARX_GE_EXPORT double arx_ge_vector2d_y (intptr_t self)
{
    return arx_ok (self) ? arx_vec2 (self)->y : ARX_GE_NAN;
}

ARX_GE_EXPORT int arx_ge_vector2d_set (intptr_t self, double x, double y)
{
    if (!arx_ok (self))
        return 0;
    arx_vec2 (self)->set (x, y);
    return 1;
}

ARX_GE_EXPORT double arx_ge_vector2d_length (intptr_t self)
{
    if (!arx_ok (self))
        return -1.0;
    return arx_vec2 (self)->length ();
}

ARX_GE_EXPORT double arx_ge_vector2d_length_sqrd (intptr_t self)
{
    if (!arx_ok (self))
        return -1.0;
    return arx_vec2 (self)->lengthSqrd ();
}

ARX_GE_EXPORT int arx_ge_vector2d_normalize (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_vec2 (self)->normalize ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector2d_get_normal (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec2 (outVec) = arx_vec2 (self)->normal ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_vector2d_dot_product (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0.0;
    return arx_vec2 (self)->dotProduct (*arx_vec2 (other));
}

/* angle() and angleTo() are signed, so NaN (not -1) marks an invalid handle. */

ARX_GE_EXPORT double arx_ge_vector2d_angle (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    return arx_vec2 (self)->angle ();
}

ARX_GE_EXPORT double arx_ge_vector2d_angle_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return ARX_GE_NAN;
    return arx_vec2 (self)->angleTo (*arx_vec2 (other));
}

ARX_GE_EXPORT int arx_ge_vector2d_negate (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    arx_vec2 (self)->negate ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector2d_add (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    *arx_vec2 (self) += *arx_vec2 (other);
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector2d_sub (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    *arx_vec2 (self) -= *arx_vec2 (other);
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector2d_scale (intptr_t self, double scale)
{
    if (!arx_ok (self))
        return 0;
    *arx_vec2 (self) *= scale;
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector2d_perp_vector (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    *arx_vec2 (outVec) = arx_vec2 (self)->perpVector ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_vector2d_rotate_by (intptr_t self, double angle)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_vec2 (self)->rotateBy (angle);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector2d_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    if (self == other)
        return 1;
    return arx_vec2 (self)->isEqualTo (*arx_vec2 (other)) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector2d_is_equal_to_tol (intptr_t self, intptr_t other, double equalVector)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_vec2 (self)->isEqualTo (*arx_vec2 (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector2d_is_unit_length (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    return arx_vec2 (self)->isUnitLength () ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector2d_is_zero_length (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    return arx_vec2 (self)->isZeroLength () ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector2d_is_codirectional_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return arx_vec2 (self)->isCodirectionalTo (*arx_vec2 (other)) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector2d_is_parallel_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return arx_vec2 (self)->isParallelTo (*arx_vec2 (other)) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector2d_is_perpendicular_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    return arx_vec2 (self)->isPerpendicularTo (*arx_vec2 (other)) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_vector2d_is_parallel_to_tol (intptr_t self, intptr_t other, double equalVector)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_vec2 (self)->isParallelTo (*arx_vec2 (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector2d_is_perpendicular_to_tol (intptr_t self, intptr_t other, double equalVector)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_vec2 (self)->isPerpendicularTo (*arx_vec2 (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeMatrix2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_matrix2d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeMatrix2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_matrix2d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_mat2 (self);
}

ARX_GE_EXPORT int arx_ge_matrix2d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    *arx_mat2 (self) = *arx_mat2 (src);
    return 1;
}

ARX_GE_EXPORT double arx_ge_matrix2d_get_elem (intptr_t self, int row, int col)
{
    if (!arx_ok (self) || !arx_idx2_ok (row) || !arx_idx2_ok (col))
        return ARX_GE_NAN;
    return arx_mat2 (self)->entry[row][col];
}

ARX_GE_EXPORT int arx_ge_matrix2d_set_elem (intptr_t self, int row, int col, double value)
{
    if (!arx_ok (self) || !arx_idx2_ok (row) || !arx_idx2_ok (col))
        return 0;
    arx_mat2 (self)->entry[row][col] = value;
    return 1;
}

ARX_GE_EXPORT int arx_ge_matrix2d_set_identity (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    arx_mat2 (self)->setToIdentity ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_matrix2d_set_to_translation (intptr_t self, double dx, double dy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat2 (self)->setToTranslation (AcGeVector2d (dx, dy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_get_translation (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec2 (outVec) = arx_mat2 (self)->translation ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_set_to_rotation (intptr_t self, double angle, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat2 (self)->setToRotation (angle, AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_set_to_scaling (intptr_t self, double scaleAll, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat2 (self)->setToScaling (scaleAll, AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* Central mirroring about a point. The AcGeLine2d overload is not wrapped yet. */
ARX_GE_EXPORT int arx_ge_matrix2d_set_to_mirroring (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat2 (self)->setToMirroring (AcGePoint2d (px, py));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_post_mult_by (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        arx_mat2 (self)->postMultBy (*arx_mat2 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_pre_mult_by (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        arx_mat2 (self)->preMultBy (*arx_mat2 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_set_to_product (intptr_t self, intptr_t mat1, intptr_t mat2)
{
    if (!arx_ok (self) || !arx_ok (mat1) || !arx_ok (mat2))
        return 0;
    try
    {
        arx_mat2 (self)->setToProduct (*arx_mat2 (mat1), *arx_mat2 (mat2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_invert (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        /* invert() returns the matrix reference, so singularity has to be tested first. */
        if (arx_mat2 (self)->isSingular ())
            return 0;
        AcGeMatrix2d inv = arx_mat2 (self)->inverse ();
        *arx_mat2 (self) = inv;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_get_inverse (intptr_t self, intptr_t outMat)
{
    if (!arx_ok (self) || !arx_ok (outMat))
        return 0;
    try
    {
        if (arx_mat2 (self)->isSingular ())
            return 0;
        AcGeMatrix2d inv = arx_mat2 (self)->inverse ();
        *arx_mat2 (outMat) = inv;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_is_singular (intptr_t self)
{
    if (!arx_ok (self))
        return 1;
    try
    {
        return arx_mat2 (self)->isSingular () ? 1 : 0;
    }
    catch (...)
    {
        return 1;
    }
}

ARX_GE_EXPORT double arx_ge_matrix2d_det (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_mat2 (self)->det ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_transpose_it (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    arx_mat2 (self)->transposeIt ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_matrix2d_get_transpose (intptr_t self, intptr_t outMat)
{
    if (!arx_ok (self) || !arx_ok (outMat))
        return 0;
    *arx_mat2 (outMat) = arx_mat2 (self)->transpose ();
    return 1;
}

ARX_GE_EXPORT int arx_ge_matrix2d_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_mat2 (self)->isEqualTo (*arx_mat2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_is_equal_to_tol (intptr_t self, intptr_t other, double equalVector)
{
    if (!arx_ok (self) || !arx_ok (other) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_mat2 (self)->isEqualTo (*arx_mat2 (other), tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_is_scaled_ortho (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_mat2 (self)->isScaledOrtho () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_is_uni_scaled_ortho (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_mat2 (self)->isUniScaledOrtho () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_matrix2d_scale (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_mat2 (self)->scale ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_set_coord_system (intptr_t self,
                                                    double ox, double oy,
                                                    double ex0x, double ex0y,
                                                    double ex1x, double ex1y)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat2 (self)->setCoordSystem (AcGePoint2d (ox, oy),
                                         AcGeVector2d (ex0x, ex0y),
                                         AcGeVector2d (ex1x, ex1y));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_get_coord_system (intptr_t self, intptr_t outOrigin,
                                                    intptr_t outE0, intptr_t outE1)
{
    if (!arx_ok (self) || !arx_ok (outOrigin) || !arx_ok (outE0) || !arx_ok (outE1))
        return 0;
    try
    {
        arx_mat2 (self)->getCoordSystem (*arx_pt2 (outOrigin), *arx_vec2 (outE0), *arx_vec2 (outE1));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_set_to_align_coord_sys (intptr_t self,
                                                          double fromOx, double fromOy,
                                                          double fromE0x, double fromE0y,
                                                          double fromE1x, double fromE1y,
                                                          double toOx, double toOy,
                                                          double toE0x, double toE0y,
                                                          double toE1x, double toE1y)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_mat2 (self)->setToAlignCoordSys (AcGePoint2d (fromOx, fromOy),
                                             AcGeVector2d (fromE0x, fromE0y),
                                             AcGeVector2d (fromE1x, fromE1y),
                                             AcGePoint2d (toOx, toOy),
                                             AcGeVector2d (toE0x, toE0y),
                                             AcGeVector2d (toE1x, toE1y));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeMatrix2d::isConformal ----------
** One const call, four results: scale, angle, isMirror and the reflex axis, plus the
** Adesk::Boolean the call itself returns.  Volcano cannot consume a C++ struct across the
** extern "C" boundary, so as with AcGeSurface::getEnvelope every result has its own
** read-only entry point and every entry point re-runs the call.
** The four locals are prefilled with NaN before the call.  A matrix that is not conformal
** is expected to leave them alone, and the getters then report NaN instead of inventing a
** value; which fields the SDK really writes is settled by measurement, not by this comment.
*/

struct arx_ge_conformal
{
    int    flag;      /* the Adesk::Boolean returned by isConformal itself */
    double scale;     /* out param scale                                  */
    double angle;     /* out param angle                                  */
    int    isMirror;  /* out param isMirror                               */
    double reflexX;   /* out param reflex, an AcGeVector2d                */
    double reflexY;
};

static bool arx_conformal_of (intptr_t self, arx_ge_conformal& out)
{
    out.flag = 0;
    out.scale = ARX_GE_NAN;
    out.angle = ARX_GE_NAN;
    out.isMirror = 0;
    out.reflexX = ARX_GE_NAN;
    out.reflexY = ARX_GE_NAN;
    if (!arx_ok (self))
        return false;
    try
    {
        double scale = ARX_GE_NAN;
        double angle = ARX_GE_NAN;
        Adesk::Boolean isMirror = false;
        AcGeVector2d reflex (ARX_GE_NAN, ARX_GE_NAN);
        out.flag = arx_mat2 (self)->isConformal (scale, angle, isMirror, reflex) ? 1 : 0;
        out.scale = scale;
        out.angle = angle;
        out.isMirror = isMirror ? 1 : 0;
        out.reflexX = reflex.x;
        out.reflexY = reflex.y;
        return true;
    }
    catch (...)
    {
        return false;
    }
}

ARX_GE_EXPORT int arx_ge_matrix2d_is_conformal (intptr_t self)
{
    arx_ge_conformal c;
    if (!arx_conformal_of (self, c))
        return 0;
    return c.flag;
}

ARX_GE_EXPORT double arx_ge_matrix2d_conformal_scale (intptr_t self)
{
    arx_ge_conformal c;
    if (!arx_conformal_of (self, c))
        return ARX_GE_NAN;
    return c.scale;
}

ARX_GE_EXPORT double arx_ge_matrix2d_conformal_angle (intptr_t self)
{
    arx_ge_conformal c;
    if (!arx_conformal_of (self, c))
        return ARX_GE_NAN;
    return c.angle;
}

ARX_GE_EXPORT int arx_ge_matrix2d_conformal_is_mirror (intptr_t self)
{
    arx_ge_conformal c;
    if (!arx_conformal_of (self, c))
        return -1;
    return c.isMirror;
}

ARX_GE_EXPORT int arx_ge_matrix2d_conformal_reflex (intptr_t self, intptr_t outVec2)
{
    arx_ge_conformal c;
    if (!arx_conformal_of (self, c) || !arx_ok (outVec2))
        return 0;
    *arx_vec2 (outVec2) = AcGeVector2d (c.reflexX, c.reflexY);
    return 1;
}

/* ---------- AcGeMatrix2d mirror about a line ---------- */

ARX_GE_EXPORT int arx_ge_matrix2d_set_to_mirroring_line (intptr_t self, intptr_t axisLine)
{
    if (!arx_ok (self) || !arx_ok (axisLine))
        return 0;
    try
    {
        arx_mat2 (self)->setToMirroring (*arx_line2 (axisLine));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeLine2d ----------
** AcGeEntity2d has a non virtual destructor, so an object must always be deleted
** through a pointer of the concrete type it was created with. That is why the line
** and the line segment keep separate new/free entry points instead of one shared
** handle whose dynamic type the bridge cannot recover.
*/

ARX_GE_EXPORT intptr_t arx_ge_line2d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLine2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_line2d_new_through_points (double x1, double y1, double x2, double y2)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLine2d (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_line2d_new_direction (double px, double py, double vx, double vy)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLine2d (AcGePoint2d (px, py), AcGeVector2d (vx, vy)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_line2d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_line2 (self);
}

ARX_GE_EXPORT int arx_ge_line2d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    *arx_line2 (self) = *arx_line2 (src);
    return 1;
}

ARX_GE_EXPORT int arx_ge_line2d_set (intptr_t self, double px, double py, double vx, double vy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_line2 (self)->set (AcGePoint2d (px, py), AcGeVector2d (vx, vy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_line2d_set_through_points (intptr_t self, double x1, double y1, double x2, double y2)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_line2 (self)->set (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeRay2d ----------
** A ray is a third leaf of the linear family: same base, same non virtual
** destructor, so it needs its own new/free pair rather than borrowing the line
** handle. getSplitCurves hands out AcGeRay2d pieces when the source is an
** infinite line, which is what makes this class worth wrapping.
*/

ARX_GE_EXPORT intptr_t arx_ge_ray2d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeRay2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ray2d_new_through_points (double x1, double y1, double x2, double y2)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeRay2d (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ray2d_new_direction (double px, double py, double vx, double vy)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeRay2d (AcGePoint2d (px, py), AcGeVector2d (vx, vy)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_ray2d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_ray2 (self);
}

ARX_GE_EXPORT int arx_ge_ray2d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    *arx_ray2 (self) = *arx_ray2 (src);
    return 1;
}

ARX_GE_EXPORT int arx_ge_ray2d_set (intptr_t self, double px, double py, double vx, double vy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ray2 (self)->set (AcGePoint2d (px, py), AcGeVector2d (vx, vy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ray2d_set_through_points (intptr_t self, double x1, double y1, double x2, double y2)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ray2 (self)->set (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeLineSeg2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_lineseg2d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLineSeg2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_lineseg2d_new_through_points (double x1, double y1, double x2, double y2)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLineSeg2d (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_lineseg2d_new_direction (double px, double py, double vx, double vy)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLineSeg2d (AcGePoint2d (px, py), AcGeVector2d (vx, vy)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_lineseg2d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_seg2 (self);
}

ARX_GE_EXPORT int arx_ge_lineseg2d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    *arx_seg2 (self) = *arx_seg2 (src);
    return 1;
}

ARX_GE_EXPORT int arx_ge_lineseg2d_set (intptr_t self, double px, double py, double vx, double vy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_seg2 (self)->set (AcGePoint2d (px, py), AcGeVector2d (vx, vy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg2d_set_through_points (intptr_t self, double x1, double y1, double x2, double y2)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_seg2 (self)->set (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg2d_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_seg2 (self)->startPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg2d_mid_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_seg2 (self)->midPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg2d_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_seg2 (self)->endPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_lineseg2d_length (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_seg2 (self)->length ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_lineseg2d_length_range (intptr_t self, double fromParam, double toParam)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_seg2 (self)->length (fromParam, toParam);
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg2d_bary_comb (intptr_t self, double blend, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_seg2 (self)->baryComb (blend);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg2d_get_bisector (intptr_t self, intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return 0;
    try
    {
        arx_seg2 (self)->getBisector (*arx_line2 (outLine));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeLinearEnt2d shared surface ----------
** self/other accept the handle of either an AcGeLine2d or an AcGeLineSeg2d.
** The base class reference in the ObjectARX signature performs the same upcast.
*/

ARX_GE_EXPORT int arx_ge_lent2d_intersect_with (intptr_t self, intptr_t other, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_lent2 (self)->intersectWith (*arx_lent2 (other), *arx_pt2 (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_is_parallel_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_lent2 (self)->isParallelTo (*arx_lent2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_is_perpendicular_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_lent2 (self)->isPerpendicularTo (*arx_lent2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_is_colinear_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_lent2 (self)->isColinearTo (*arx_lent2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_lent2 (self)->isEqualTo (*arx_lent2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_get_perp_line (intptr_t self, double px, double py, intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return 0;
    try
    {
        arx_lent2 (self)->getPerpLine (AcGePoint2d (px, py), *arx_line2 (outLine));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_point_on_line (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_lent2 (self)->pointOnLine ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_direction (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec2 (outVec) = arx_lent2 (self)->direction ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_is_on_pnt (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_lent2 (self)->isOn (AcGePoint2d (px, py)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_lent2d_param_of (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_lent2 (self)->paramOf (AcGePoint2d (px, py));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_lent2d_distance_to_pnt (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_lent2 (self)->distanceTo (AcGePoint2d (px, py));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_closest_point_to (intptr_t self, double px, double py, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_lent2 (self)->closestPointTo (AcGePoint2d (px, py));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_eval_point (intptr_t self, double param, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_lent2 (self)->evalPoint (param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_lent2 (self)->transformBy (*arx_mat2 (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_translate_by (intptr_t self, double vx, double vy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_lent2 (self)->translateBy (AcGeVector2d (vx, vy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_rotate_by (intptr_t self, double angle, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_lent2 (self)->rotateBy (angle, AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_mirror_by (intptr_t self, intptr_t axisLine)
{
    if (!arx_ok (self) || !arx_ok (axisLine))
        return 0;
    try
    {
        arx_lent2 (self)->mirror (*arx_line2 (axisLine));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_scale_by (intptr_t self, double factor, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_lent2 (self)->scaleBy (factor, AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_lent2 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT double arx_ge_lent2d_interval_lower (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGeInterval interval;
        arx_lent2 (self)->getInterval (interval);
        return interval.lowerBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_lent2d_interval_upper (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGeInterval interval;
        arx_lent2 (self)->getInterval (interval);
        return interval.upperBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_has_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_lent2 (self)->hasStartPoint (*arx_pt2 (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_has_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_lent2 (self)->hasEndPoint (*arx_pt2 (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_is_closed (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_lent2 (self)->isClosed () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_is_linear (intptr_t self, intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return 0;
    try
    {
        return arx_lent2 (self)->isLinear (*arx_line2 (outLine)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent2d_reverse_param (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_lent2 (self)->reverseParam ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- 2D matrix driven transform ---------- */

ARX_GE_EXPORT int arx_ge_point2d_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_pt2 (self)->transformBy (*arx_mat2 (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_vector2d_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_vec2 (self)->transformBy (*arx_mat2 (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeLine3d ----------
** Same rule as the 2D pair: AcGeEntity3d has a non virtual destructor, so every
** object must be deleted through a pointer of the concrete type it was created with.
*/

ARX_GE_EXPORT intptr_t arx_ge_line3d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLine3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_line3d_new_through_points (double x1, double y1, double z1,
                                                          double x2, double y2, double z2)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLine3d (AcGePoint3d (x1, y1, z1),
                                                           AcGePoint3d (x2, y2, z2)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_line3d_new_direction (double px, double py, double pz,
                                                     double vx, double vy, double vz)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLine3d (AcGePoint3d (px, py, pz),
                                                           AcGeVector3d (vx, vy, vz)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_line3d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_line3 (self);
}

ARX_GE_EXPORT int arx_ge_line3d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    *arx_line3 (self) = *arx_line3 (src);
    return 1;
}

ARX_GE_EXPORT int arx_ge_line3d_set (intptr_t self, double px, double py, double pz,
                                      double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_line3 (self)->set (AcGePoint3d (px, py, pz), AcGeVector3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_line3d_set_through_points (intptr_t self, double x1, double y1, double z1,
                                                     double x2, double y2, double z2)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_line3 (self)->set (AcGePoint3d (x1, y1, z1), AcGePoint3d (x2, y2, z2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeRay3d ----------
** Three dimensional twin of the ray block above: its own new/free pair because
** AcGeEntity3d cannot be deleted through a base pointer.
*/

ARX_GE_EXPORT intptr_t arx_ge_ray3d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeRay3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ray3d_new_through_points (double x1, double y1, double z1,
                                                          double x2, double y2, double z2)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeRay3d (AcGePoint3d (x1, y1, z1),
                                                          AcGePoint3d (x2, y2, z2)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ray3d_new_direction (double px, double py, double pz,
                                                    double vx, double vy, double vz)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeRay3d (AcGePoint3d (px, py, pz),
                                                          AcGeVector3d (vx, vy, vz)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_ray3d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_ray3 (self);
}

ARX_GE_EXPORT int arx_ge_ray3d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    *arx_ray3 (self) = *arx_ray3 (src);
    return 1;
}

ARX_GE_EXPORT int arx_ge_ray3d_set (intptr_t self, double px, double py, double pz,
                                     double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ray3 (self)->set (AcGePoint3d (px, py, pz), AcGeVector3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ray3d_set_through_points (intptr_t self, double x1, double y1, double z1,
                                                     double x2, double y2, double z2)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ray3 (self)->set (AcGePoint3d (x1, y1, z1), AcGePoint3d (x2, y2, z2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeLineSeg3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_lineseg3d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLineSeg3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_lineseg3d_new_through_points (double x1, double y1, double z1,
                                                              double x2, double y2, double z2)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLineSeg3d (AcGePoint3d (x1, y1, z1),
                                                              AcGePoint3d (x2, y2, z2)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_lineseg3d_new_direction (double px, double py, double pz,
                                                        double vx, double vy, double vz)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeLineSeg3d (AcGePoint3d (px, py, pz),
                                                              AcGeVector3d (vx, vy, vz)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_lineseg3d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_seg3 (self);
}

ARX_GE_EXPORT int arx_ge_lineseg3d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    *arx_seg3 (self) = *arx_seg3 (src);
    return 1;
}

ARX_GE_EXPORT int arx_ge_lineseg3d_set (intptr_t self, double px, double py, double pz,
                                         double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_seg3 (self)->set (AcGePoint3d (px, py, pz), AcGeVector3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg3d_set_through_points (intptr_t self, double x1, double y1, double z1,
                                                        double x2, double y2, double z2)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_seg3 (self)->set (AcGePoint3d (x1, y1, z1), AcGePoint3d (x2, y2, z2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg3d_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_seg3 (self)->startPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg3d_mid_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_seg3 (self)->midPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg3d_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_seg3 (self)->endPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_lineseg3d_length (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_seg3 (self)->length ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg3d_bary_comb (intptr_t self, double blend, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_seg3 (self)->baryComb (blend);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeLinearEnt3d shared surface ----------
** self/other accept the handle of either an AcGeLine3d or an AcGeLineSeg3d.
** The base class reference in the ObjectARX signature performs the same upcast.
*/

ARX_GE_EXPORT int arx_ge_lent3d_intersect_with (intptr_t self, intptr_t other, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_lent3 (self)->intersectWith (*arx_lent3 (other), *arx_pt (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_proj_intersect_with (intptr_t self, intptr_t other,
                                                      double dx, double dy, double dz,
                                                      intptr_t outThis, intptr_t outOther)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outThis) || !arx_ok (outOther))
        return 0;
    try
    {
        return arx_lent3 (self)->projIntersectWith (*arx_lent3 (other),
                                                    AcGeVector3d (dx, dy, dz),
                                                    *arx_pt (outThis),
                                                    *arx_pt (outOther)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_parallel_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_lent3 (self)->isParallelTo (*arx_lent3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_perpendicular_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_lent3 (self)->isPerpendicularTo (*arx_lent3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_colinear_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_lent3 (self)->isColinearTo (*arx_lent3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_lent3 (self)->isEqualTo (*arx_lent3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_point_on_line (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_lent3 (self)->pointOnLine ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_direction (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_lent3 (self)->direction ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_on_pnt (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_lent3 (self)->isOn (AcGePoint3d (px, py, pz)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_lent3d_param_of (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_lent3 (self)->paramOf (AcGePoint3d (px, py, pz));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_lent3d_distance_to_pnt (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_lent3 (self)->distanceTo (AcGePoint3d (px, py, pz));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_lent3d_distance_to_curve (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return ARX_GE_NAN;
    try
    {
        return arx_lent3 (self)->distanceTo (*arx_lent3 (other));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_closest_point_to (intptr_t self, double px, double py, double pz,
                                                   intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_lent3 (self)->closestPointTo (AcGePoint3d (px, py, pz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_closest_point_to_curve (intptr_t self, intptr_t other,
                                                         intptr_t outThis, intptr_t outOther)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outThis) || !arx_ok (outOther))
        return 0;
    try
    {
        *arx_pt (outThis) = arx_lent3 (self)->closestPointTo (*arx_lent3 (other), *arx_pt (outOther));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_proj_closest_point_to (intptr_t self, double px, double py, double pz,
                                                       double dx, double dy, double dz,
                                                       intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_lent3 (self)->projClosestPointTo (AcGePoint3d (px, py, pz),
                                                                 AcGeVector3d (dx, dy, dz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_eval_point (intptr_t self, double param, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_lent3 (self)->evalPoint (param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_lent3d_length_range (intptr_t self, double fromParam, double toParam)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_lent3 (self)->length (fromParam, toParam);
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_lent3d_param_at_length (intptr_t self, double datumParam, double length)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_lent3 (self)->paramAtLength (datumParam, length);
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_lent3 (self)->transformBy (*arx_mat (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_translate_by (intptr_t self, double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_lent3 (self)->translateBy (AcGeVector3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_rotate_by (intptr_t self, double angle,
                                           double ax, double ay, double az,
                                           double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_lent3 (self)->rotateBy (angle, AcGeVector3d (ax, ay, az), AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_scale_by (intptr_t self, double factor, double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_lent3 (self)->scaleBy (factor, AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_lent3 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT double arx_ge_lent3d_interval_lower (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGeInterval interval;
        arx_lent3 (self)->getInterval (interval);
        return interval.lowerBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_lent3d_interval_upper (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGeInterval interval;
        arx_lent3 (self)->getInterval (interval);
        return interval.upperBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_has_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_lent3 (self)->hasStartPoint (*arx_pt (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_has_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_lent3 (self)->hasEndPoint (*arx_pt (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_closed (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_lent3 (self)->isClosed () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_linear (intptr_t self, intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return 0;
    try
    {
        return arx_lent3 (self)->isLinear (*arx_line3 (outLine)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_reverse_param (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_lent3 (self)->reverseParam ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGePlane (incl. AcGePlanarEnt / AcGeSurface surface) ----------
** Every plane handle below points to an AcGePlane. ObjectARX declares several
** parameters as AcGePlanarEnt&; dereferencing an AcGePlane* binds to that base
** reference exactly like a native C++ call site does.
*/

ARX_GE_EXPORT intptr_t arx_ge_plane_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePlane ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_plane_new_normal (double px, double py, double pz,
                                                double nx, double ny, double nz)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePlane (AcGePoint3d (px, py, pz),
                                                          AcGeVector3d (nx, ny, nz)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_plane_new_three (double ux, double uy, double uz,
                                               double ox, double oy, double oz,
                                               double vx, double vy, double vz)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePlane (AcGePoint3d (ux, uy, uz),
                                                          AcGePoint3d (ox, oy, oz),
                                                          AcGePoint3d (vx, vy, vz)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_plane_new_axes (double ox, double oy, double oz,
                                              double ux, double uy, double uz,
                                              double vx, double vy, double vz)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePlane (AcGePoint3d (ox, oy, oz),
                                                          AcGeVector3d (ux, uy, uz),
                                                          AcGeVector3d (vx, vy, vz)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_plane_new_coeff (double a, double b, double c, double d)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePlane (a, b, c, d));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_plane_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_plane (self);
}

ARX_GE_EXPORT int arx_ge_plane_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_plane (self) = *arx_plane (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_set_normal (intptr_t self, double px, double py, double pz,
                                           double nx, double ny, double nz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_plane (self)->set (AcGePoint3d (px, py, pz), AcGeVector3d (nx, ny, nz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_set_three (intptr_t self,
                                          double ux, double uy, double uz,
                                          double ox, double oy, double oz,
                                          double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_plane (self)->set (AcGePoint3d (ux, uy, uz), AcGePoint3d (ox, oy, oz),
                               AcGePoint3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_set_axes (intptr_t self,
                                         double ox, double oy, double oz,
                                         double ux, double uy, double uz,
                                         double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_plane (self)->set (AcGePoint3d (ox, oy, oz), AcGeVector3d (ux, uy, uz),
                               AcGeVector3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_set_coeff (intptr_t self, double a, double b, double c, double d)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_plane (self)->set (a, b, c, d);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_normal (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_plane (self)->normal ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_point_on_plane (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_plane (self)->pointOnPlane ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

static inline void arx_plane_read_coeff (intptr_t self, double* a, double* b,
                                         double* c, double* d)
{
    arx_plane (self)->getCoefficients (*a, *b, *c, *d);
}

ARX_GE_EXPORT double arx_ge_plane_coeff_a (intptr_t self)
{
    double a = 0, b = 0, c = 0, d = 0;
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        arx_plane_read_coeff (self, &a, &b, &c, &d);
        return a;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_plane_coeff_b (intptr_t self)
{
    double a = 0, b = 0, c = 0, d = 0;
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        arx_plane_read_coeff (self, &a, &b, &c, &d);
        return b;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_plane_coeff_c (intptr_t self)
{
    double a = 0, b = 0, c = 0, d = 0;
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        arx_plane_read_coeff (self, &a, &b, &c, &d);
        return c;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_plane_coeff_d (intptr_t self)
{
    double a = 0, b = 0, c = 0, d = 0;
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        arx_plane_read_coeff (self, &a, &b, &c, &d);
        return d;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_plane_coord_system (intptr_t self, intptr_t outOrigin,
                                             intptr_t outU, intptr_t outV)
{
    if (!arx_ok (self) || !arx_ok (outOrigin) || !arx_ok (outU) || !arx_ok (outV))
        return 0;
    try
    {
        arx_plane (self)->getCoordSystem (*arx_pt (outOrigin), *arx_vec (outU), *arx_vec (outV));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_plane_signed_distance_to (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_plane (self)->signedDistanceTo (AcGePoint3d (px, py, pz));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_plane_distance_to (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_plane (self)->distanceTo (AcGePoint3d (px, py, pz));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_plane_intersect_with_line (intptr_t self, intptr_t lineEnt, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (lineEnt) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_plane (self)->intersectWith (*arx_lent3 (lineEnt), *arx_pt (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_intersect_with_plane (intptr_t self, intptr_t other, intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outLine))
        return 0;
    try
    {
        return arx_plane (self)->intersectWith (*arx_plane (other), *arx_line3 (outLine)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_is_parallel_to_line (intptr_t self, intptr_t lineEnt)
{
    if (!arx_ok (self) || !arx_ok (lineEnt))
        return 0;
    try
    {
        return arx_plane (self)->isParallelTo (*arx_lent3 (lineEnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_is_perpendicular_to_line (intptr_t self, intptr_t lineEnt)
{
    if (!arx_ok (self) || !arx_ok (lineEnt))
        return 0;
    try
    {
        return arx_plane (self)->isPerpendicularTo (*arx_lent3 (lineEnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_is_parallel_to_plane (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_plane (self)->isParallelTo (*arx_plane (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_is_perpendicular_to_plane (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_plane (self)->isPerpendicularTo (*arx_plane (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_is_coplanar_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_plane (self)->isCoplanarTo (*arx_plane (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_closest_point_to_linear_ent (intptr_t self, intptr_t lineEnt,
                                                             intptr_t outPnt, intptr_t outOnLine)
{
    if (!arx_ok (self) || !arx_ok (lineEnt) || !arx_ok (outPnt) || !arx_ok (outOnLine))
        return 0;
    try
    {
        AcGePoint3d onLine;
        AcGePoint3d onPlane = arx_plane (self)->closestPointToLinearEnt (*arx_lent3 (lineEnt), onLine);
        *arx_pt (outPnt) = onPlane;
        *arx_pt (outOnLine) = onLine;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_closest_point_to_planar_ent (intptr_t self, intptr_t other,
                                                             intptr_t outPnt, intptr_t outOnOther)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outPnt) || !arx_ok (outOnOther))
        return 0;
    try
    {
        AcGePoint3d onOther;
        AcGePoint3d onPlane = arx_plane (self)->closestPointToPlanarEnt (*arx_plane (other), onOther);
        *arx_pt (outPnt) = onPlane;
        *arx_pt (outOnOther) = onOther;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_is_on_pnt (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_plane (self)->isOn (AcGePoint3d (px, py, pz)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_closest_point_to (intptr_t self, double px, double py, double pz,
                                                 intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_plane (self)->closestPointTo (AcGePoint3d (px, py, pz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_param_of (intptr_t self, double px, double py, double pz,
                                         intptr_t outPnt2)
{
    if (!arx_ok (self) || !arx_ok (outPnt2))
        return 0;
    try
    {
        *arx_pt2 (outPnt2) = arx_plane (self)->paramOf (AcGePoint3d (px, py, pz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_eval_point (intptr_t self, double u, double v, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_plane (self)->evalPoint (AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_reverse_normal (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_plane (self)->reverseNormal ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_is_normal_reversed (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_plane (self)->isNormalReversed () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_plane (self)->transformBy (*arx_mat (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_plane (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

/* ---------- AcGeBoundedPlane ---------- */

ARX_GE_EXPORT intptr_t arx_ge_bplane_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeBoundedPlane ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_bplane_new_axes (double ox, double oy, double oz,
                                               double ux, double uy, double uz,
                                               double vx, double vy, double vz)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeBoundedPlane (AcGePoint3d (ox, oy, oz),
                                                                 AcGeVector3d (ux, uy, uz),
                                                                 AcGeVector3d (vx, vy, vz)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_bplane_new_three (double ux, double uy, double uz,
                                                double ox, double oy, double oz,
                                                double vx, double vy, double vz)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeBoundedPlane (AcGePoint3d (ux, uy, uz),
                                                                 AcGePoint3d (ox, oy, oz),
                                                                 AcGePoint3d (vx, vy, vz)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_bplane_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_bplane (self);
}

ARX_GE_EXPORT int arx_ge_bplane_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_bplane (self) = *arx_bplane (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_bplane_set_axes (intptr_t self, double ox, double oy, double oz,
                                          double ux, double uy, double uz,
                                          double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_bplane (self)->set (AcGePoint3d (ox, oy, oz), AcGeVector3d (ux, uy, uz),
                                AcGeVector3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_bplane_set_three (intptr_t self,
                                           double ux, double uy, double uz,
                                           double ox, double oy, double oz,
                                           double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_bplane (self)->set (AcGePoint3d (ux, uy, uz), AcGePoint3d (ox, oy, oz),
                                AcGePoint3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_bplane_intersect_with_line (intptr_t self, intptr_t lineEnt,
                                                     intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (lineEnt) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_bplane (self)->intersectWith (*arx_lent3 (lineEnt), *arx_pt (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_bplane_intersect_with_plane (intptr_t self, intptr_t plane,
                                                      intptr_t outSeg)
{
    if (!arx_ok (self) || !arx_ok (plane) || !arx_ok (outSeg))
        return 0;
    try
    {
        return arx_bplane (self)->intersectWith (*arx_plane (plane), *arx_seg3 (outSeg)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_bplane_intersect_with_bplane (intptr_t self, intptr_t other,
                                                       intptr_t outSeg)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outSeg))
        return 0;
    try
    {
        return arx_bplane (self)->intersectWith (*arx_bplane (other), *arx_seg3 (outSeg)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_plane_intersect_with_bplane (intptr_t self, intptr_t bplane,
                                                      intptr_t outSeg)
{
    if (!arx_ok (self) || !arx_ok (bplane) || !arx_ok (outSeg))
        return 0;
    try
    {
        return arx_plane (self)->intersectWith (*arx_bplane (bplane), *arx_seg3 (outSeg)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_bplane_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeBoundedPlane));
}

/* ---------- AcGePlanarEnt::get (handle may be AcGePlane or AcGeBoundedPlane) ---------- */

ARX_GE_EXPORT int arx_ge_planar_get_axes (intptr_t self, intptr_t outPnt,
                                          intptr_t outUVec, intptr_t outVVec)
{
    if (!arx_ok (self) || !arx_ok (outPnt) || !arx_ok (outUVec) || !arx_ok (outVVec))
        return 0;
    try
    {
        arx_planar (self)->get (*arx_pt (outPnt), *arx_vec (outUVec), *arx_vec (outVVec));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_planar_get_points (intptr_t self, intptr_t outPnt,
                                            intptr_t outOrigin, intptr_t outPnt2)
{
    if (!arx_ok (self) || !arx_ok (outPnt) || !arx_ok (outOrigin) || !arx_ok (outPnt2))
        return 0;
    try
    {
        arx_planar (self)->get (*arx_pt (outPnt), *arx_pt (outOrigin), *arx_pt (outPnt2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeSurface::getEnvelope ----------
** The only SDK overload is void getEnvelope (AcGeInterval&, AcGeInterval&).
** AcGeInterval (geintrvl.h) is a pImpl value class: its only data members are
** an AcGeImpInterval pointer and a delete flag, so it carries no AcGe entity id
** and no handle semantics and is not mirrored as a Volcano class. The two out
** intervals are snapshotted through their public accessors into the POD below,
** which is a bridge-internal fill target only -- Volcano cannot consume a C++
** struct across the extern "C" boundary, so the six values still leave the
** bridge as six scalar functions, the same shape used by
** arx_ge_lent2d_interval_lower / arx_ge_lent2d_interval_upper.
** The handle may be an AcGePlane or an AcGeBoundedPlane; both reach
** getEnvelope through AcGePlanarEnt, and neither redeclares it.
*/

struct arx_ge_interval
{
    double lower;    /* lowerBound()    -- geintrvl.h:48 */
    double upper;    /* upperBound()    -- geintrvl.h:49 */
    int    bounded;  /* isBounded()     -- geintrvl.h:72; 1 both ends finite, 0 interval open */
};

struct arx_ge_envelope
{
    arx_ge_interval u;
    arx_ge_interval v;
};

/* Fills all six scalars from one getEnvelope call. Returns false when the
** handle is bad or the SDK throws; callers then report ARX_GE_NAN / -1.
*/
static bool arx_envelope_of (intptr_t self, arx_ge_envelope& out)
{
    if (!arx_ok (self))
        return false;
    try
    {
        AcGeInterval u;
        AcGeInterval v;
        arx_planar (self)->getEnvelope (u, v);
        out.u.lower    = u.lowerBound ();
        out.u.upper    = u.upperBound ();
        out.u.bounded  = u.isBounded () ? 1 : 0;
        out.v.lower    = v.lowerBound ();
        out.v.upper    = v.upperBound ();
        out.v.bounded  = v.isBounded () ? 1 : 0;
        return true;
    }
    catch (...)
    {
        return false;
    }
}

ARX_GE_EXPORT double arx_ge_planar_envelope_u_lower (intptr_t self)
{
    arx_ge_envelope e = {};
    if (!arx_envelope_of (self, e))
        return ARX_GE_NAN;
    return e.u.lower;
}

ARX_GE_EXPORT double arx_ge_planar_envelope_u_upper (intptr_t self)
{
    arx_ge_envelope e = {};
    if (!arx_envelope_of (self, e))
        return ARX_GE_NAN;
    return e.u.upper;
}

ARX_GE_EXPORT double arx_ge_planar_envelope_v_lower (intptr_t self)
{
    arx_ge_envelope e = {};
    if (!arx_envelope_of (self, e))
        return ARX_GE_NAN;
    return e.v.lower;
}

ARX_GE_EXPORT double arx_ge_planar_envelope_v_upper (intptr_t self)
{
    arx_ge_envelope e = {};
    if (!arx_envelope_of (self, e))
        return ARX_GE_NAN;
    return e.v.upper;
}

ARX_GE_EXPORT int arx_ge_planar_envelope_u_bounded (intptr_t self)
{
    arx_ge_envelope e = {};
    if (!arx_envelope_of (self, e))
        return -1;
    return e.u.bounded;
}

ARX_GE_EXPORT int arx_ge_planar_envelope_v_bounded (intptr_t self)
{
    arx_ge_envelope e = {};
    if (!arx_envelope_of (self, e))
        return -1;
    return e.v.bounded;
}

ARX_GE_EXPORT int arx_ge_planar_is_closed_in_u (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return arx_planar (self)->isClosedInU () ? 1 : 0;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_planar_is_closed_in_v (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return arx_planar (self)->isClosedInV () ? 1 : 0;
    }
    catch (...)
    {
        return -1;
    }
}

/* ---------- plane overloads on AcGeLinearEnt3d / AcGeLineSeg3d ---------- */

ARX_GE_EXPORT int arx_ge_lent3d_intersect_with_plane (intptr_t self, intptr_t plane, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (plane) || !arx_ok (outPnt))
        return 0;
    try
    {
        return arx_lent3 (self)->intersectWith (*arx_plane (plane), *arx_pt (outPnt)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_on_plane (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        return arx_lent3 (self)->isOn (*arx_plane (plane)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_parallel_to_plane (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        return arx_lent3 (self)->isParallelTo (*arx_plane (plane)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_perpendicular_to_plane (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        return arx_lent3 (self)->isPerpendicularTo (*arx_plane (plane)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_get_perp_plane (intptr_t self, double px, double py, double pz,
                                                intptr_t outPlane)
{
    if (!arx_ok (self) || !arx_ok (outPlane))
        return 0;
    try
    {
        arx_lent3 (self)->getPerpPlane (AcGePoint3d (px, py, pz), *arx_plane (outPlane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_mirror_by_plane (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        arx_lent3 (self)->mirror (*arx_plane (plane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lent3d_is_planar (intptr_t self, intptr_t outPlane)
{
    if (!arx_ok (self) || !arx_ok (outPlane))
        return 0;
    try
    {
        return arx_lent3 (self)->isPlanar (*arx_plane (outPlane)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_lineseg3d_get_bisector (intptr_t self, intptr_t outPlane)
{
    if (!arx_ok (self) || !arx_ok (outPlane))
        return 0;
    try
    {
        arx_seg3 (self)->getBisector (*arx_plane (outPlane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- plane overloads on AcGeMatrix3d ---------- */

ARX_GE_EXPORT int arx_ge_matrix_set_to_mirroring_plane (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        arx_mat (self)->setToMirroring (*arx_plane (plane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_projection (intptr_t self, intptr_t plane,
                                                   double dx, double dy, double dz)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        const AcGeVector3d dir (dx, dy, dz);
        double along = arx_plane (plane)->normal ().dotProduct (dir);
        /* Measured on AcGe25: setToProjection divides by the component of dir along the
        ** normal, so a direction parallel to the plane leaves 0/0 in every cell and even
        ** breaks isSingular. Refuse instead of writing that matrix out.
        */
        if (dir.lengthSqrd () <= 0 || along == 0)
            return 0;
        arx_mat (self)->setToProjection (*arx_plane (plane), dir);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_world_to_plane (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        arx_mat (self)->setToWorldToPlane (*arx_plane (plane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_set_to_plane_to_world (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        arx_mat (self)->setToPlaneToWorld (*arx_plane (plane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeMatrix3d::convertToLocal ----------
** The only overload is AcGeMatrix2d convertToLocal (AcGeVector3d& normal, double& elev)
** const.  Both reference arguments are read by the SDK as well as written: a different
** input normal gives a different 2D matrix, and the elevation comes back derived from
** whatever the caller passed in, so a bridge-local blank would silently degrade every
** call.  A C++ struct does not cross the extern "C" boundary, hence as with
** AcGeSurface::getEnvelope each result has its own entry point and every entry point
** re-runs the same const call.
*/

static bool arx_local_of (intptr_t self, double normalX, double normalY, double normalZ,
                          double elevIn, AcGeMatrix2d& mat, AcGeVector3d& normal, double& elev)
{
    if (!arx_ok (self))
        return false;
    normal = AcGeVector3d (normalX, normalY, normalZ);
    elev = elevIn;
    try
    {
        mat = arx_mat (self)->convertToLocal (normal, elev);
        return true;
    }
    catch (...)
    {
        return false;
    }
}

ARX_GE_EXPORT int arx_ge_matrix_convert_to_local (intptr_t self, double normalX, double normalY,
                                                  double normalZ, double elevIn,
                                                  intptr_t outMat2d, intptr_t outNormal)
{
    if (!arx_ok (self) || !arx_ok (outMat2d) || !arx_ok (outNormal))
        return 0;
    AcGeMatrix2d mat;
    AcGeVector3d normal;
    double elev = 0;
    if (!arx_local_of (self, normalX, normalY, normalZ, elevIn, mat, normal, elev))
        return 0;
    *arx_mat2 (outMat2d) = mat;
    *arx_vec (outNormal) = normal;
    return 1;
}

ARX_GE_EXPORT double arx_ge_matrix_local_elevation (intptr_t self, double normalX,
                                                    double normalY, double normalZ,
                                                    double elevIn)
{
    AcGeMatrix2d mat;
    AcGeVector3d normal;
    double elev = ARX_GE_NAN;
    if (!arx_local_of (self, normalX, normalY, normalZ, elevIn, mat, normal, elev))
        return ARX_GE_NAN;
    return elev;
}

/* ---------- AcGeCurve2d base surface (valid on any 2D curve handle) ---------- */

ARX_GE_EXPORT double arx_ge_curve2d_param_of (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_curve2 (self)->paramOf (AcGePoint2d (px, py));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_eval_point (intptr_t self, double param, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_curve2 (self)->evalPoint (param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_distance_to_pnt (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_curve2 (self)->distanceTo (AcGePoint2d (px, py));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_distance_to_curve (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return ARX_GE_NAN;
    try
    {
        return arx_curve2 (self)->distanceTo (*arx_curve2 (other));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_closest_point_to (intptr_t self, double px, double py,
                                                   intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_curve2 (self)->closestPointTo (AcGePoint2d (px, py));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_closest_point_to_curve (intptr_t self, intptr_t other,
                                                         intptr_t outThis, intptr_t outOther)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outThis) || !arx_ok (outOther))
        return 0;
    try
    {
        *arx_pt2 (outThis) = arx_curve2 (self)->closestPointTo (*arx_curve2 (other),
                                                                *arx_pt2 (outOther));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_is_on_pnt (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_curve2 (self)->isOn (AcGePoint2d (px, py)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_is_on_param (intptr_t self, double param)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_curve2 (self)->isOn (param) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_is_closed (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_curve2 (self)->isClosed () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_period (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        double period = 0;
        if (!arx_curve2 (self)->isPeriodic (period))
            return ARX_GE_NAN;
        return period;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_length (intptr_t self, double fromParam, double toParam)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_curve2 (self)->length (fromParam, toParam);
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_param_at_length (intptr_t self, double datumParam,
                                                     double length, int positiveDir)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_curve2 (self)->paramAtLength (datumParam, length,
                                                 positiveDir ? Adesk::kTrue : Adesk::kFalse);
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_area (intptr_t self, double startParam, double endParam)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        double value = 0;
        if (!arx_curve2 (self)->area (startParam, endParam, value))
            return ARX_GE_NAN;
        return value;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_has_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGePoint2d pnt (ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_curve2 (self)->hasStartPoint (pnt))
            return 0;
        *arx_pt2 (outPnt) = pnt;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_has_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGePoint2d pnt (ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_curve2 (self)->hasEndPoint (pnt))
            return 0;
        *arx_pt2 (outPnt) = pnt;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_interval_lower (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGeInterval interval;
        arx_curve2 (self)->getInterval (interval);
        return interval.lowerBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_interval_upper (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGeInterval interval;
        arx_curve2 (self)->getInterval (interval);
        return interval.upperBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_is_linear (intptr_t self, intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return 0;
    try
    {
        AcGeLine2d line;
        if (!arx_curve2 (self)->isLinear (line))
            return 0;
        *arx_line2 (outLine) = line;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_reverse_param (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve2 (self)->reverseParam ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_degenerate_type (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        AcGe::EntityId degenerateType = AcGe::kEntity2d;
        if (!arx_curve2 (self)->isDegenerate (degenerateType))
            return -1;
        return static_cast<int> (degenerateType);
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_curve2 (self)->transformBy (*arx_mat2 (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_translate_by (intptr_t self, double vx, double vy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve2 (self)->translateBy (AcGeVector2d (vx, vy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_rotate_by (intptr_t self, double angle, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve2 (self)->rotateBy (angle, AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_mirror_by (intptr_t self, intptr_t axisLine)
{
    if (!arx_ok (self) || !arx_ok (axisLine))
        return 0;
    try
    {
        arx_curve2 (self)->mirror (*arx_line2 (axisLine));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_scale_by (intptr_t self, double factor, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve2 (self)->scaleBy (factor, AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_curve2 (self)->isEqualTo (*arx_curve2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_curve2 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

/* ---------- AcGeCurve2d::getSplitCurves ----------
 *
 * AcGeCurve2d::getSplitCurves (double, AcGeCurve2d*&, AcGeCurve2d*&) returns
 * void, so a null piece pointer is the only failure signal the SDK offers.
 * Both pieces are newed objects the caller would own, and ~AcGeEntity2d is
 * not virtual, so neither pointer may leave the bridge: the concrete leaf
 * class is recovered through type(), the value is copied into a target that
 * reports the same entity id, and both pieces are destroyed right here.
 */

static int arx_entity2d_delete (AcGeEntity2d* entity)
{
    if (entity == 0)
        return 1;
    switch (entity->type ())
    {
    case AcGe::kLine2d:
        delete static_cast<AcGeLine2d*> (entity);
        break;
    case AcGe::kLineSeg2d:
        delete static_cast<AcGeLineSeg2d*> (entity);
        break;
    case AcGe::kCircArc2d:
        delete static_cast<AcGeCircArc2d*> (entity);
        break;
    case AcGe::kEllipArc2d:
        delete static_cast<AcGeEllipArc2d*> (entity);
        break;
    case AcGe::kRay2d:
        /* getSplitCurves hands back rays when the source is an infinite
         * AcGeLine2d. Since package 19A the class library has a public ray
         * class that receives such pieces, but every handle reaching here is
         * still owned by this bridge, so it has to die as its own type:
         * ~AcGeEntity2d is not virtual. */
        delete static_cast<AcGeRay2d*> (entity);
        break;
    case AcGe::kOffsetCurve2d:
        /* getTrimmedOffset answers a full AcGeEllipArc2d with a lazy
         * AcGeOffsetCurve2d rather than a leaf curve. The class library has
         * no Volcano class for it, so no public method receives one, but the
         * piece still has to die as its own type instead of being leaked. */
        delete static_cast<AcGeOffsetCurve2d*> (entity);
        break;
    default:
        /* Unrecognised leaf class: the object is deliberately left alive
         * rather than destroyed through a non virtual base destructor. */
        return 0;
    }
    return 1;
}

/* An offset curve nested as a source is cloned by rebuilding it from a fresh
 * clone of its own source, so the uniqueness invariant survives nesting. */
static AcGeCurve2d* arx_curve2d_clone (const AcGeCurve2d* src)
{
    if (src == 0)
        return 0;
    switch (src->type ())
    {
    case AcGe::kLine2d:
    {
        AcGeLine2d* copy = new AcGeLine2d ();
        *copy = *static_cast<const AcGeLine2d*> (src);
        return copy;
    }
    case AcGe::kLineSeg2d:
    {
        AcGeLineSeg2d* copy = new AcGeLineSeg2d ();
        *copy = *static_cast<const AcGeLineSeg2d*> (src);
        return copy;
    }
    case AcGe::kCircArc2d:
    {
        AcGeCircArc2d* copy = new AcGeCircArc2d ();
        *copy = *static_cast<const AcGeCircArc2d*> (src);
        return copy;
    }
    case AcGe::kEllipArc2d:
    {
        AcGeEllipArc2d* copy = new AcGeEllipArc2d ();
        *copy = *static_cast<const AcGeEllipArc2d*> (src);
        return copy;
    }
    case AcGe::kRay2d:
    {
        AcGeRay2d* copy = new AcGeRay2d ();
        *copy = *static_cast<const AcGeRay2d*> (src);
        return copy;
    }
    case AcGe::kOffsetCurve2d:
    {
        AcGeOffsetCurve2d* other = static_cast<AcGeOffsetCurve2d*> (const_cast<AcGeCurve2d*> (src));
        AcGeCurve2d* inner = arx_curve2d_clone (other->curve ());
        if (inner == 0)
            return 0;
        try
        {
            return new AcGeOffsetCurve2d (*inner, other->offsetDistance ());
        }
        catch (...)
        {
            arx_entity2d_delete (inner);
        }
        return 0;
    }
    default:
        return 0;
    }
}

static bool arx_curve2d_has_girth (const AcGeCurve2d* src)
{
    try
    {
        AcGeInterval interval;
        src->getInterval (interval);
        const double len = src->length (interval.lowerBound (), interval.upperBound ());
        return len > 0.0 && len == len;
    }
    catch (...)
    {
        return false;
    }
}

/* type() is the only handle validation AcGe offers from the bridge side, and
 * every entry point here needs it: reading a foreign object as an offset curve
 * would hand back whatever the borrowed-curve slot happens to point at. */
static bool arx_is_offset2 (intptr_t value)
{
    if (!arx_ok (value))
        return false;
    try
    {
        return arx_ent2 (value)->type () == AcGe::kOffsetCurve2d;
    }
    catch (...)
    {
        return false;
    }
}

static AcGeCurve2d* arx_offset2_source (intptr_t self)
{
    return const_cast<AcGeCurve2d*> (arx_ofc2 (self)->curve ());
}

/* Adopts another offset curve into an existing handle. The SDK assignment
 * operator only shares the borrowed source pointer, so the transfer goes
 * through a fresh private clone here and the previous clone is dropped only
 * after the object stopped referring to it. The same path serves 1:1 copying
 * and the split / trimmed-offset pieces, which measured as offset curves. */
static int arx_offset2_adopt (intptr_t target, const AcGeOffsetCurve2d* src)
{
    if (!arx_is_offset2 (target) || src == 0)
        return 0;
    AcGeCurve2d* mine = 0;
    try
    {
        AcGeOffsetCurve2d* f = const_cast<AcGeOffsetCurve2d*> (src);
        mine = arx_curve2d_clone (f->curve ());
        if (mine == 0)
            return 0;
        AcGeOffsetCurve2d* o = arx_ofc2 (target);
        AcGeCurve2d* old = arx_offset2_source (target);
        AcGeInterval interval;
        f->getInterval (interval);
        o->setCurve (*mine);
        o->setOffsetDistance (f->offsetDistance ());
        o->setInterval (interval);
        arx_entity2d_delete (old);
        return 1;
    }
    catch (...)
    {
        arx_entity2d_delete (mine);
    }
    return 0;
}

static int arx_entity2d_assign (const AcGeEntity2d* src, intptr_t target)
{
    switch (src->type ())
    {
    case AcGe::kLine2d:
        *arx_line2 (target) = *static_cast<const AcGeLine2d*> (src);
        return 1;
    case AcGe::kLineSeg2d:
        *arx_seg2 (target) = *static_cast<const AcGeLineSeg2d*> (src);
        return 1;
    case AcGe::kCircArc2d:
        *arx_arc2 (target) = *static_cast<const AcGeCircArc2d*> (src);
        return 1;
    case AcGe::kEllipArc2d:
        *arx_ellip2 (target) = *static_cast<const AcGeEllipArc2d*> (src);
        return 1;
    case AcGe::kRay2d:
        *arx_ray2 (target) = *static_cast<const AcGeRay2d*> (src);
        return 1;
    case AcGe::kOffsetCurve2d:
        /* Splitting or trimming the offset of an offset curve answers another
         * offset curve (measured type 63), so such a piece is adopted here
         * through the private-clone path rather than refused. */
        return arx_offset2_adopt (target, static_cast<const AcGeOffsetCurve2d*> (src));
    default:
        return 0;
    }
}

static int arx_curve2_split (intptr_t self, double param, AcGeCurve2d* pieces[2])
{
    pieces[0] = 0;
    pieces[1] = 0;
    if (!arx_ok (self))
        return -1;
    try
    {
        arx_curve2 (self)->getSplitCurves (param, pieces[0], pieces[1]);
    }
    catch (...)
    {
        return -2;
    }
    return 0;
}

ARX_GE_EXPORT int arx_ge_curve2d_split_type (intptr_t self, double param, int index)
{
    if (index != 0 && index != 1)
        return -1;
    AcGeCurve2d* pieces[2];
    int code = arx_curve2_split (self, param, pieces);
    if (code != 0)
        return code;
    AcGeEntity2d* piece = pieces[index];
    if (piece == 0)
        return -3;
    int id = -2;
    try
    {
        id = static_cast<int> (piece->type ());
    }
    catch (...)
    {
        id = -2;
    }
    try
    {
        arx_entity2d_delete (pieces[0]);
        arx_entity2d_delete (pieces[1]);
    }
    catch (...)
    {
        id = -2;
    }
    return id;
}

ARX_GE_EXPORT int arx_ge_curve2d_split_into (intptr_t self, double param, int index,
                                             intptr_t target)
{
    if ((index != 0 && index != 1) || !arx_ok (target))
        return -1;
    AcGeCurve2d* pieces[2];
    int code = arx_curve2_split (self, param, pieces);
    if (code != 0)
        return code;
    AcGeEntity2d* piece = pieces[index];
    int status = 0;
    if (piece != 0)
    {
        status = 2;
        try
        {
            if (piece->type () == arx_ent2 (target)->type ()
                && arx_entity2d_assign (piece, target) != 0)
                status = 1;
        }
        catch (...)
        {
            status = -2;
        }
    }
    int freed0 = 0;
    int freed1 = 0;
    try
    {
        freed0 = arx_entity2d_delete (pieces[0]);
        freed1 = arx_entity2d_delete (pieces[1]);
    }
    catch (...)
    {
        status = -2;
    }
    /* Code 3 is reported only when nothing was handed out: it says a piece
     * was left alive because the bridge does not know its leaf class. */
    if ((status == 0 || status == 2) && (freed0 == 0 || freed1 == 0))
        return 3;
    return status;
}

/* ---------- AcGeCurve2d::getSamplePoints ----------
 *
 * AcGeCurve2d::getSamplePoints (int, AcGePoint2dArray&) returns void, so the
 * SDK gives no error code to forward, and the array it fills never leaves
 * this bridge: AcGePoint2dArray is an AcArray that allocates through
 * ::operator new inside the calling module, which would make a cross-DLL
 * buffer a shared-allocator contract.  Each helper therefore rebuilds the
 * sample set in its own frame, exactly like the planar envelope helpers, and
 * hands out one scalar or one point per call.  The 2D class has no
 * getSamplePoints overload that also fills a parameter array (unlike
 * AcGeCurve3d), so this dimension exposes the count and the indexed point
 * only.
 */

ARX_GE_EXPORT int arx_ge_curve2d_sample_count (intptr_t self, int numSample)
{
    if (!arx_ok (self) || numSample <= 0)
        return 0;
    try
    {
        AcGePoint2dArray points;
        arx_curve2 (self)->getSamplePoints (numSample, points);
        return static_cast<int> (points.length ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_sample_point (intptr_t self, int numSample, int index,
                                               intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt) || numSample <= 0 || index < 0)
        return 0;
    try
    {
        AcGePoint2dArray points;
        arx_curve2 (self)->getSamplePoints (numSample, points);
        if (index >= static_cast<int> (points.length ()))
            return 0;
        *arx_pt2 (outPnt) = points[index];
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeCurve2d::getSamplePoints, tolerance driven ----------
 *
 * The other overload polygonizes between two parameters to within approxEps, so
 * the SDK picks the sample count instead of being told it.  Both output arrays
 * belong to acge25.dll and stay in this frame; each helper rebuilds the sample
 * set and hands out one reading, exactly like the numSample helpers above.
 * AcGeCurve2d has no forceResampling argument (only AcGeCurve3d declares it) and
 * no variant that fills the points without the parameters, so the parameter
 * array is always built even when only a point is asked for.
 *
 * The interval and the tolerance go through untouched, reversed, degenerate and
 * non-positive inputs included: what those inputs are worth is the SDK's answer,
 * not a refusal by this bridge.
 */

ARX_GE_EXPORT int arx_ge_curve2d_tol_sample_count (intptr_t self,
                                                   double fromParam, double toParam,
                                                   double approxEps)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        AcGePoint2dArray points;
        AcGeDoubleArray params;
        arx_curve2 (self)->getSamplePoints (fromParam, toParam, approxEps, points, params);
        return static_cast<int> (points.length ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve2d_tol_sample_point (intptr_t self,
                                                   double fromParam, double toParam,
                                                   double approxEps, int index,
                                                   intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt) || index < 0)
        return 0;
    try
    {
        AcGePoint2dArray points;
        AcGeDoubleArray params;
        arx_curve2 (self)->getSamplePoints (fromParam, toParam, approxEps, points, params);
        if (index >= static_cast<int> (points.length ()))
            return 0;
        *arx_pt2 (outPnt) = points[index];
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_tol_sample_param (intptr_t self,
                                                      double fromParam, double toParam,
                                                      double approxEps, int index)
{
    if (!arx_ok (self) || index < 0)
        return ARX_GE_NAN;
    try
    {
        AcGePoint2dArray points;
        AcGeDoubleArray params;
        arx_curve2 (self)->getSamplePoints (fromParam, toParam, approxEps, points, params);
        if (index >= static_cast<int> (params.length ()))
            return ARX_GE_NAN;
        return params[index];
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

/* ---------- AcGeCircArc2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new_circle (double cx, double cy, double radius)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc2d (AcGePoint2d (cx, cy), radius));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new_angles (double cx, double cy, double radius,
                                                    double startAng, double endAng,
                                                    double refX, double refY, int clockwise)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc2d (
            AcGePoint2d (cx, cy), radius, startAng, endAng, AcGeVector2d (refX, refY),
            clockwise ? Adesk::kTrue : Adesk::kFalse));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new_three (double x1, double y1,
                                                   double x2, double y2,
                                                   double x3, double y3)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc2d (AcGePoint2d (x1, y1),
                                                              AcGePoint2d (x2, y2),
                                                              AcGePoint2d (x3, y3)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_circarc2d_new_bulge (double x1, double y1,
                                                   double x2, double y2,
                                                   double bulge, int bulgeIsHeight)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc2d (
            AcGePoint2d (x1, y1), AcGePoint2d (x2, y2), bulge,
            bulgeIsHeight ? Adesk::kTrue : Adesk::kFalse));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_circarc2d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_arc2 (self);
}

ARX_GE_EXPORT int arx_ge_circarc2d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_arc2 (self) = *arx_arc2 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_circle (intptr_t self, double cx, double cy, double radius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->set (AcGePoint2d (cx, cy), radius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_angles (intptr_t self, double cx, double cy, double radius,
                                               double startAng, double endAng,
                                               double refX, double refY, int clockwise)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->set (AcGePoint2d (cx, cy), radius, startAng, endAng,
                              AcGeVector2d (refX, refY),
                              clockwise ? Adesk::kTrue : Adesk::kFalse);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_three (intptr_t self, double x1, double y1,
                                              double x2, double y2,
                                              double x3, double y3)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->set (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2), AcGePoint2d (x3, y3));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_three_err (intptr_t self, double x1, double y1,
                                                  double x2, double y2,
                                                  double x3, double y3)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        AcGe::ErrorCondition error = AcGe::kOk;
        arx_arc2 (self)->set (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2),
                              AcGePoint2d (x3, y3), error);
        return static_cast<int> (error);
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_bulge (intptr_t self, double x1, double y1,
                                              double x2, double y2,
                                              double bulge, int bulgeIsHeight)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->set (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2), bulge,
                              bulgeIsHeight ? Adesk::kTrue : Adesk::kFalse);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_center (intptr_t self, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->setCenter (AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_radius (intptr_t self, double radius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->setRadius (radius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_start_end_ang (intptr_t self, double startAng, double endAng)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->setAngles (startAng, endAng);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_to_complement (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->setToComplement ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_ref_vec (intptr_t self, double vx, double vy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc2 (self)->setRefVec (AcGeVector2d (vx, vy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_center (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_arc2 (self)->center ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_circarc2d_radius (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_arc2 (self)->radius ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_circarc2d_start_ang (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_arc2 (self)->startAng ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_circarc2d_end_ang (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_arc2 (self)->endAng ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_is_clockwise (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_arc2 (self)->isClockWise () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_ref_vec (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec2 (outVec) = arx_arc2 (self)->refVec ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_arc2 (self)->startPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_arc2 (self)->endPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_intersect_with_line (intptr_t self, intptr_t other,
                                                        intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outP1) || !arx_ok (outP2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint2d p1 (ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint2d p2 (ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_arc2 (self)->intersectWith (*arx_lent2 (other), count, p1, p2))
            return -1;
        if (count >= 1)
            *arx_pt2 (outP1) = p1;
        if (count >= 2)
            *arx_pt2 (outP2) = p2;
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_intersect_with_arc (intptr_t self, intptr_t other,
                                                       intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outP1) || !arx_ok (outP2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint2d p1 (ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint2d p2 (ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_arc2 (self)->intersectWith (*arx_arc2 (other), count, p1, p2))
            return -1;
        if (count >= 1)
            *arx_pt2 (outP1) = p1;
        if (count >= 2)
            *arx_pt2 (outP2) = p2;
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_tangent (intptr_t self, double px, double py, intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return 0;
    try
    {
        AcGeLine2d line;
        if (!arx_arc2 (self)->tangent (AcGePoint2d (px, py), line))
            return 0;
        *arx_line2 (outLine) = line;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_tangent_err (intptr_t self, double px, double py,
                                                intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return -1;
    try
    {
        AcGeLine2d line;
        AcGe::ErrorCondition error = AcGe::kOk;
        if (!arx_arc2 (self)->tangent (AcGePoint2d (px, py), line, AcGeContext::gTol, error))
            return static_cast<int> (error);
        *arx_line2 (outLine) = line;
        return static_cast<int> (error);
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_is_inside (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_arc2 (self)->isInside (AcGePoint2d (px, py)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_fillet (intptr_t self, intptr_t curve1, intptr_t curve2,
                                               double radius, intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (curve1) || !arx_ok (curve2)
        || !arx_ok (outP1) || !arx_ok (outP2))
        return 0;
    try
    {
        double param1 = 0;
        double param2 = 0;
        Adesk::Boolean success = Adesk::kFalse;
        arx_arc2 (self)->set (*arx_curve2 (curve1), *arx_curve2 (curve2), radius,
                              param1, param2, success);
        if (!success)
            return 0;
        *arx_pt2 (outP1) = arx_curve2 (curve1)->evalPoint (param1);
        *arx_pt2 (outP2) = arx_curve2 (curve2)->evalPoint (param2);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc2d_set_tangent_three (intptr_t self, intptr_t curve1,
                                                      intptr_t curve2, intptr_t curve3,
                                                      intptr_t outP1, intptr_t outP2,
                                                      intptr_t outP3)
{
    if (!arx_ok (self) || !arx_ok (curve1) || !arx_ok (curve2) || !arx_ok (curve3)
        || !arx_ok (outP1) || !arx_ok (outP2) || !arx_ok (outP3))
        return 0;
    try
    {
        double param1 = 0;
        double param2 = 0;
        double param3 = 0;
        Adesk::Boolean success = Adesk::kFalse;
        arx_arc2 (self)->set (*arx_curve2 (curve1), *arx_curve2 (curve2), *arx_curve2 (curve3),
                              param1, param2, param3, success);
        if (!success)
            return 0;
        *arx_pt2 (outP1) = arx_curve2 (curve1)->evalPoint (param1);
        *arx_pt2 (outP2) = arx_curve2 (curve2)->evalPoint (param2);
        *arx_pt2 (outP3) = arx_curve2 (curve3)->evalPoint (param3);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeCurve3d base surface ---------- */

ARX_GE_EXPORT double arx_ge_curve3d_param_of (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_curve3 (self)->paramOf (AcGePoint3d (px, py, pz));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_eval_point (intptr_t self, double param, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_curve3 (self)->evalPoint (param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_distance_to_pnt (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_curve3 (self)->distanceTo (AcGePoint3d (px, py, pz));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_distance_to_curve (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return ARX_GE_NAN;
    try
    {
        return arx_curve3 (self)->distanceTo (*arx_curve3 (other));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_closest_point_to (intptr_t self, double px, double py, double pz,
                                                   intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_curve3 (self)->closestPointTo (AcGePoint3d (px, py, pz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_closest_point_to_curve (intptr_t self, intptr_t other,
                                                         intptr_t outThis, intptr_t outOther)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outThis) || !arx_ok (outOther))
        return 0;
    try
    {
        *arx_pt (outThis) = arx_curve3 (self)->closestPointTo (*arx_curve3 (other),
                                                               *arx_pt (outOther));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_proj_closest_point_to (intptr_t self, double px, double py, double pz,
                                                        double dx, double dy, double dz,
                                                        intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_curve3 (self)->projClosestPointTo (AcGePoint3d (px, py, pz),
                                                                  AcGeVector3d (dx, dy, dz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_is_on_pnt (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_curve3 (self)->isOn (AcGePoint3d (px, py, pz)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_is_on_param (intptr_t self, double param)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_curve3 (self)->isOn (param) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_is_closed (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_curve3 (self)->isClosed () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_period (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        double period = 0;
        if (!arx_curve3 (self)->isPeriodic (period))
            return ARX_GE_NAN;
        return period;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_length (intptr_t self, double fromParam, double toParam)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_curve3 (self)->length (fromParam, toParam);
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_param_at_length (intptr_t self, double datumParam, double length,
                                                     int positiveDir)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_curve3 (self)->paramAtLength (datumParam, length,
                                                 positiveDir ? Adesk::kTrue : Adesk::kFalse);
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_area (intptr_t self, double startParam, double endParam)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        double value = 0;
        if (!arx_curve3 (self)->area (startParam, endParam, value))
            return ARX_GE_NAN;
        return value;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_has_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGePoint3d pnt (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_curve3 (self)->hasStartPoint (pnt))
            return 0;
        *arx_pt (outPnt) = pnt;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_has_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGePoint3d pnt (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_curve3 (self)->hasEndPoint (pnt))
            return 0;
        *arx_pt (outPnt) = pnt;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_interval_lower (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGeInterval interval;
        arx_curve3 (self)->getInterval (interval);
        return interval.lowerBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_interval_upper (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGeInterval interval;
        arx_curve3 (self)->getInterval (interval);
        return interval.upperBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_is_linear (intptr_t self, intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return 0;
    try
    {
        AcGeLine3d line;
        if (!arx_curve3 (self)->isLinear (line))
            return 0;
        *arx_line3 (outLine) = line;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_is_planar (intptr_t self, intptr_t outPlane)
{
    if (!arx_ok (self) || !arx_ok (outPlane))
        return 0;
    try
    {
        AcGePlane plane;
        if (!arx_curve3 (self)->isPlanar (plane))
            return 0;
        *arx_plane (outPlane) = plane;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_is_coplanar_with (intptr_t self, intptr_t other, intptr_t outPlane)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outPlane))
        return 0;
    try
    {
        AcGePlane plane;
        if (!arx_curve3 (self)->isCoplanarWith (*arx_curve3 (other), plane))
            return 0;
        *arx_plane (outPlane) = plane;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_reverse_param (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve3 (self)->reverseParam ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_degenerate_type (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        AcGe::EntityId degenerateType = AcGe::kEntity3d;
        if (!arx_curve3 (self)->isDegenerate (degenerateType))
            return -1;
        return static_cast<int> (degenerateType);
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_transform_by (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_curve3 (self)->transformBy (*arx_mat (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_translate_by (intptr_t self, double vx, double vy, double vz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve3 (self)->translateBy (AcGeVector3d (vx, vy, vz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_rotate_by (intptr_t self, double angle,
                                            double ax, double ay, double az,
                                            double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve3 (self)->rotateBy (angle, AcGeVector3d (ax, ay, az),
                                     AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_mirror_by (intptr_t self, intptr_t plane)
{
    if (!arx_ok (self) || !arx_ok (plane))
        return 0;
    try
    {
        arx_curve3 (self)->mirror (*arx_plane (plane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_scale_by (intptr_t self, double factor,
                                           double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve3 (self)->scaleBy (factor, AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_curve3 (self)->isEqualTo (*arx_curve3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_curve3 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

/* ---------- AcGeCurve3d::getSamplePoints ----------
 *
 * Same contract as the 2D helpers above: the SDK returns void, fills an
 * AcGePoint3dArray owned by this module, and the array never crosses the
 * bridge.  Each helper rebuilds the sample set in its own frame and hands
 * out one reading per call.  AcGeCurve3d does have the overload that also
 * fills an AcGeDoubleArray of parameters, so this dimension additionally
 * reports the parameter of a sampled point.
 */

ARX_GE_EXPORT int arx_ge_curve3d_sample_count (intptr_t self, int numSample)
{
    if (!arx_ok (self) || numSample <= 0)
        return 0;
    try
    {
        AcGePoint3dArray points;
        arx_curve3 (self)->getSamplePoints (numSample, points);
        return static_cast<int> (points.length ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_sample_point (intptr_t self, int numSample, int index,
                                               intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt) || numSample <= 0 || index < 0)
        return 0;
    try
    {
        AcGePoint3dArray points;
        arx_curve3 (self)->getSamplePoints (numSample, points);
        if (index >= static_cast<int> (points.length ()))
            return 0;
        *arx_pt (outPnt) = points[index];
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_sample_param (intptr_t self, int numSample, int index)
{
    if (!arx_ok (self) || numSample <= 0 || index < 0)
        return ARX_GE_NAN;
    try
    {
        AcGePoint3dArray points;
        AcGeDoubleArray params;
        arx_curve3 (self)->getSamplePoints (numSample, points, params);
        if (index >= static_cast<int> (params.length ()))
            return ARX_GE_NAN;
        return params[index];
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

/* ---------- AcGeCurve3d::getSamplePoints, tolerance driven ----------
 *
 * Same frame-owned sample set as the 2D block above, plus the one argument this
 * dimension has and 2D does not: forceResampling, which the SDK documents as
 * pushing the actual error as close to approxEps as it can.  The library exposes
 * it as an int (0 or 1) because the language binding carries no bool across the
 * boundary, and only the two legal values are ever passed down here.
 */

ARX_GE_EXPORT int arx_ge_curve3d_tol_sample_count (intptr_t self,
                                                   double fromParam, double toParam,
                                                   double approxEps, int forceResampling)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        AcGePoint3dArray points;
        AcGeDoubleArray params;
        arx_curve3 (self)->getSamplePoints (fromParam, toParam, approxEps, points, params,
                                            forceResampling != 0);
        return static_cast<int> (points.length ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_curve3d_tol_sample_point (intptr_t self,
                                                   double fromParam, double toParam,
                                                   double approxEps, int forceResampling,
                                                   int index, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt) || index < 0)
        return 0;
    try
    {
        AcGePoint3dArray points;
        AcGeDoubleArray params;
        arx_curve3 (self)->getSamplePoints (fromParam, toParam, approxEps, points, params,
                                            forceResampling != 0);
        if (index >= static_cast<int> (points.length ()))
            return 0;
        *arx_pt (outPnt) = points[index];
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_tol_sample_param (intptr_t self,
                                                      double fromParam, double toParam,
                                                      double approxEps, int forceResampling,
                                                      int index)
{
    if (!arx_ok (self) || index < 0)
        return ARX_GE_NAN;
    try
    {
        AcGePoint3dArray points;
        AcGeDoubleArray params;
        arx_curve3 (self)->getSamplePoints (fromParam, toParam, approxEps, points, params,
                                            forceResampling != 0);
        if (index >= static_cast<int> (params.length ()))
            return ARX_GE_NAN;
        return params[index];
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

/* ---------- AcGeCurve3d projection ----------
 *
 * AcGeCurve3d::project / orthoProject hand back a newed AcGeEntity3d*, and
 * ~AcGeEntity3d is not virtual, so destroying that pointer through its
 * static type is undefined behaviour.  AcGeEntity3d::type() is driven by the
 * implementation pointer, so the concrete leaf class is recovered from the
 * object itself: arx_entity3d_delete casts back to a known class before
 * deleting, and arx_entity3d_assign only writes into a target that reports
 * the same entity id.
 */

static int arx_entity3d_delete (AcGeEntity3d* entity)
{
    if (entity == 0)
        return 1;
    switch (entity->type ())
    {
    case AcGe::kPosition3d:
        delete static_cast<AcGePosition3d*> (entity);
        break;
    case AcGe::kLine3d:
        delete static_cast<AcGeLine3d*> (entity);
        break;
    case AcGe::kLineSeg3d:
        delete static_cast<AcGeLineSeg3d*> (entity);
        break;
    case AcGe::kCircArc3d:
        delete static_cast<AcGeCircArc3d*> (entity);
        break;
    case AcGe::kEllipArc3d:
        delete static_cast<AcGeEllipArc3d*> (entity);
        break;
    case AcGe::kPlane:
        delete static_cast<AcGePlane*> (entity);
        break;
    case AcGe::kRay3d:
        /* Splitting an infinite AcGeLine3d yields AcGeRay3d pieces. Since
         * package 19A the class library has a public ray class that receives
         * them; here the piece still dies as its own type because
         * ~AcGeEntity3d is not virtual. */
        delete static_cast<AcGeRay3d*> (entity);
        break;
    case AcGe::kOffsetCurve3d:
        /* getTrimmedOffset answers a full AcGeEllipArc3d with a lazy
         * AcGeOffsetCurve3d rather than a leaf curve. No public class
         * receives one, but the piece still dies as its own type. */
        delete static_cast<AcGeOffsetCurve3d*> (entity);
        break;
    default:
        /* Unrecognised leaf class: the object is deliberately left alive
         * rather than destroyed through a non virtual base destructor. */
        return 0;
    }
    return 1;
}

static AcGeCurve3d* arx_curve3d_clone (const AcGeCurve3d* src)
{
    if (src == 0)
        return 0;
    switch (src->type ())
    {
    case AcGe::kLine3d:
    {
        AcGeLine3d* copy = new AcGeLine3d ();
        *copy = *static_cast<const AcGeLine3d*> (src);
        return copy;
    }
    case AcGe::kLineSeg3d:
    {
        AcGeLineSeg3d* copy = new AcGeLineSeg3d ();
        *copy = *static_cast<const AcGeLineSeg3d*> (src);
        return copy;
    }
    case AcGe::kCircArc3d:
    {
        AcGeCircArc3d* copy = new AcGeCircArc3d ();
        *copy = *static_cast<const AcGeCircArc3d*> (src);
        return copy;
    }
    case AcGe::kEllipArc3d:
    {
        AcGeEllipArc3d* copy = new AcGeEllipArc3d ();
        *copy = *static_cast<const AcGeEllipArc3d*> (src);
        return copy;
    }
    case AcGe::kRay3d:
    {
        AcGeRay3d* copy = new AcGeRay3d ();
        *copy = *static_cast<const AcGeRay3d*> (src);
        return copy;
    }
    case AcGe::kOffsetCurve3d:
    {
        AcGeOffsetCurve3d* other = static_cast<AcGeOffsetCurve3d*> (const_cast<AcGeCurve3d*> (src));
        AcGeCurve3d* inner = arx_curve3d_clone (other->curve ());
        if (inner == 0)
            return 0;
        try
        {
            return new AcGeOffsetCurve3d (*inner, other->normal (),
                                          other->offsetDistance ());
        }
        catch (...)
        {
            arx_entity3d_delete (inner);
        }
        return 0;
    }
    default:
        return 0;
    }
}

static bool arx_curve3d_has_girth (const AcGeCurve3d* src)
{
    try
    {
        AcGeInterval interval;
        src->getInterval (interval);
        const double len = src->length (interval.lowerBound (), interval.upperBound ());
        return len > 0.0 && len == len;
    }
    catch (...)
    {
        return false;
    }
}

static bool arx_is_offset3 (intptr_t value)
{
    if (!arx_ok (value))
        return false;
    try
    {
        return arx_ent3 (value)->type () == AcGe::kOffsetCurve3d;
    }
    catch (...)
    {
        return false;
    }
}

static AcGeCurve3d* arx_offset3_source (intptr_t self)
{
    return const_cast<AcGeCurve3d*> (arx_ofc3 (self)->curve ());
}

static int arx_offset3_adopt (intptr_t target, const AcGeOffsetCurve3d* src)
{
    if (!arx_is_offset3 (target) || src == 0)
        return 0;
    AcGeCurve3d* mine = 0;
    try
    {
        AcGeOffsetCurve3d* f = const_cast<AcGeOffsetCurve3d*> (src);
        mine = arx_curve3d_clone (f->curve ());
        if (mine == 0)
            return 0;
        AcGeOffsetCurve3d* o = arx_ofc3 (target);
        AcGeCurve3d* old = arx_offset3_source (target);
        AcGeInterval interval;
        f->getInterval (interval);
        o->setCurve (*mine);
        o->setOffsetDistance (f->offsetDistance ());
        o->setNormal (f->normal ());
        o->setInterval (interval);
        arx_entity3d_delete (old);
        return 1;
    }
    catch (...)
    {
        arx_entity3d_delete (mine);
    }
    return 0;
}

static int arx_entity3d_assign (const AcGeEntity3d* src, intptr_t target)
{
    switch (src->type ())
    {
    case AcGe::kPosition3d:
        *arx_position3 (target) = *static_cast<const AcGePosition3d*> (src);
        return 1;
    case AcGe::kLine3d:
        *arx_line3 (target) = *static_cast<const AcGeLine3d*> (src);
        return 1;
    case AcGe::kLineSeg3d:
        *arx_seg3 (target) = *static_cast<const AcGeLineSeg3d*> (src);
        return 1;
    case AcGe::kCircArc3d:
        *arx_arc3 (target) = *static_cast<const AcGeCircArc3d*> (src);
        return 1;
    case AcGe::kEllipArc3d:
        *arx_ellip3 (target) = *static_cast<const AcGeEllipArc3d*> (src);
        return 1;
    case AcGe::kRay3d:
        *arx_ray3 (target) = *static_cast<const AcGeRay3d*> (src);
        return 1;
    case AcGe::kOffsetCurve3d:
        /* The pieces of an offset curve are offset curves again (measured type
         * 64) and follow the same adoption path as the 2d channel. */
        return arx_offset3_adopt (target, static_cast<const AcGeOffsetCurve3d*> (src));
    default:
        return 0;
    }
}

static AcGeEntity3d* arx_curve3_project (intptr_t source, intptr_t plane,
                                         double dx, double dy, double dz,
                                         int ortho)
{
    if (ortho != 0)
        return arx_curve3 (source)->orthoProject (*arx_plane (plane));
    const AcGeVector3d direction (dx, dy, dz);
    return arx_curve3 (source)->project (*arx_plane (plane), direction);
}

/* Measured on AcGe25: project() divides by the component of the direction along
** the plane normal, so a direction parallel to the plane -- or the zero vector --
** still returns a newed entity of a plausible type while every coordinate inside
** it is NaN/Inf. Refuse it the same way arx_ge_matrix_set_to_projection does.
** orthoProject walks along the normal itself, so it never hits this case.
*/
static int arx_curve3_project_refused (intptr_t plane, double dx, double dy,
                                       double dz, int ortho)
{
    if (ortho != 0)
        return 0;
    const AcGeVector3d direction (dx, dy, dz);
    double along = arx_plane (plane)->normal ().dotProduct (direction);
    return (direction.lengthSqrd () <= 0 || along == 0) ? 1 : 0;
}

ARX_GE_EXPORT int arx_ge_curve3d_project_type (intptr_t source, intptr_t plane,
                                               double dx, double dy, double dz,
                                               int ortho)
{
    if (!arx_ok (source) || !arx_ok (plane))
        return -1;
    AcGeEntity3d* result = 0;
    int refused = 0;
    try
    {
        refused = arx_curve3_project_refused (plane, dx, dy, dz, ortho);
        if (refused == 0)
            result = arx_curve3_project (source, plane, dx, dy, dz, ortho);
    }
    catch (...)
    {
        return -2;
    }
    if (refused != 0)
        return -4;
    if (result == 0)
        return -3;
    int id = -2;
    try
    {
        id = static_cast<int> (result->type ());
    }
    catch (...)
    {
        id = -2;
    }
    arx_entity3d_delete (result);
    return id;
}

ARX_GE_EXPORT int arx_ge_curve3d_project_into (intptr_t source, intptr_t plane,
                                               double dx, double dy, double dz,
                                               int ortho, intptr_t target)
{
    if (!arx_ok (source) || !arx_ok (plane) || !arx_ok (target))
        return -1;
    try
    {
        if (arx_curve3_project_refused (plane, dx, dy, dz, ortho) != 0)
            return -4;
    }
    catch (...)
    {
        return -2;
    }
    AcGeEntity3d* result = 0;
    try
    {
        result = arx_curve3_project (source, plane, dx, dy, dz, ortho);
    }
    catch (...)
    {
        return -2;
    }
    if (result == 0)
        return 0;
    int status = 2;
    int freed = 0;
    try
    {
        if (result->type () == arx_ent3 (target)->type ()
            && arx_entity3d_assign (result, target) != 0)
            status = 1;
    }
    catch (...)
    {
        status = -2;
    }
    try
    {
        freed = arx_entity3d_delete (result);
    }
    catch (...)
    {
        status = -2;
    }
    if (status == 2 && freed == 0)
        return 3;
    return status;
}

/* ---------- AcGeCurve3d::getSplitCurves ----------
 *
 * Same contract as the 2D pair above, riding on the entity dispatchers the
 * projection helpers already installed.
 */

static int arx_curve3_split (intptr_t self, double param, AcGeCurve3d* pieces[2])
{
    pieces[0] = 0;
    pieces[1] = 0;
    if (!arx_ok (self))
        return -1;
    try
    {
        arx_curve3 (self)->getSplitCurves (param, pieces[0], pieces[1]);
    }
    catch (...)
    {
        return -2;
    }
    return 0;
}

ARX_GE_EXPORT int arx_ge_curve3d_split_type (intptr_t self, double param, int index)
{
    if (index != 0 && index != 1)
        return -1;
    AcGeCurve3d* pieces[2];
    int code = arx_curve3_split (self, param, pieces);
    if (code != 0)
        return code;
    AcGeEntity3d* piece = pieces[index];
    if (piece == 0)
        return -3;
    int id = -2;
    try
    {
        id = static_cast<int> (piece->type ());
    }
    catch (...)
    {
        id = -2;
    }
    try
    {
        arx_entity3d_delete (pieces[0]);
        arx_entity3d_delete (pieces[1]);
    }
    catch (...)
    {
        id = -2;
    }
    return id;
}

ARX_GE_EXPORT int arx_ge_curve3d_split_into (intptr_t self, double param, int index,
                                             intptr_t target)
{
    if ((index != 0 && index != 1) || !arx_ok (target))
        return -1;
    AcGeCurve3d* pieces[2];
    int code = arx_curve3_split (self, param, pieces);
    if (code != 0)
        return code;
    AcGeEntity3d* piece = pieces[index];
    int status = 0;
    if (piece != 0)
    {
        status = 2;
        try
        {
            if (piece->type () == arx_ent3 (target)->type ()
                && arx_entity3d_assign (piece, target) != 0)
                status = 1;
        }
        catch (...)
        {
            status = -2;
        }
    }
    int freed0 = 0;
    int freed1 = 0;
    try
    {
        freed0 = arx_entity3d_delete (pieces[0]);
        freed1 = arx_entity3d_delete (pieces[1]);
    }
    catch (...)
    {
        status = -2;
    }
    if ((status == 0 || status == 2) && (freed0 == 0 || freed1 == 0))
        return 3;
    return status;
}

/* ---------- AcGeCurve2d::getTrimmedOffset / AcGeCurve3d::getTrimmedOffset ----
 *
 * Both overloads return void and hand the result back through an
 * AcGeVoidPointerArray of newly allocated curves, so the piece count is the
 * only success signal the SDK offers and the array carries no ownership flag.
 * Measured on AcGe25: every piece is a fresh object (repeated calls inside one
 * array rebuild never reuse an address, and no piece ever aliases the source),
 * which lets the helpers below follow the same ownership rule as the split
 * helpers -- the handle never leaves this bridge, each piece is cast back to
 * its own leaf class through type() and destroyed here, because AcGeEntity2d
 * and AcGeEntity3d have non virtual destructors.
 *
 * extensionType is passed through as given (0/1/2); the caller sees no
 * difference between the three on any single leaf curve, which is measured, so
 * the guard here is only that the value is one the SDK enum can hold.
 *
 * Return codes: -1 invalid handle, bad index or extensionType outside 0..2,
 * -2 the SDK threw, -3 the SDK handed back a null piece, and for the _into
 * helpers 3 means a piece had to be left alive because the bridge does not
 * know its leaf class.
 */

static int arx_trim_offset_free2 (AcGeVoidPointerArray& pieces)
{
    int n = static_cast<int> (pieces.length ());
    int all = 1;
    for (int i = 0; i < n; ++i)
    {
        if (pieces[i] != 0
            && arx_entity2d_delete (static_cast<AcGeEntity2d*> (pieces[i])) == 0)
            all = 0;
    }
    return all;
}

static int arx_trim_offset_free3 (AcGeVoidPointerArray& pieces)
{
    int n = static_cast<int> (pieces.length ());
    int all = 1;
    for (int i = 0; i < n; ++i)
    {
        if (pieces[i] != 0
            && arx_entity3d_delete (static_cast<AcGeEntity3d*> (pieces[i])) == 0)
            all = 0;
    }
    return all;
}

static int arx_curve2_trim_offset (intptr_t self, double dist, int ext,
                                   AcGeVoidPointerArray& pieces)
{
    if (!arx_ok (self) || ext < 0 || ext > 2)
        return -1;
    try
    {
        arx_curve2 (self)->getTrimmedOffset (
            dist, pieces, static_cast<AcGe::OffsetCrvExtType> (ext));
    }
    catch (...)
    {
        return -2;
    }
    return static_cast<int> (pieces.length ());
}

static int arx_curve3_trim_offset (intptr_t self, double dist, int ext,
                                   double nrx, double nry, double nrz,
                                   AcGeVoidPointerArray& pieces)
{
    if (!arx_ok (self) || ext < 0 || ext > 2)
        return -1;
    try
    {
        arx_curve3 (self)->getTrimmedOffset (
            dist, AcGeVector3d (nrx, nry, nrz), pieces,
            static_cast<AcGe::OffsetCrvExtType> (ext));
    }
    catch (...)
    {
        return -2;
    }
    return static_cast<int> (pieces.length ());
}

ARX_GE_EXPORT int arx_ge_curve2d_trim_offset_count (intptr_t self, double dist,
                                                    int ext)
{
    AcGeVoidPointerArray pieces;
    int count = arx_curve2_trim_offset (self, dist, ext, pieces);
    if (count < 0)
        return count;
    arx_trim_offset_free2 (pieces);
    return count;
}

ARX_GE_EXPORT int arx_ge_curve2d_trim_offset_type (intptr_t self, double dist,
                                                   int ext, int index)
{
    AcGeVoidPointerArray pieces;
    int count = arx_curve2_trim_offset (self, dist, ext, pieces);
    if (count < 0)
        return count;
    int id = -1;
    if (index >= 0 && index < count && pieces[index] != 0)
    {
        try
        {
            id = static_cast<int> (
                static_cast<AcGeCurve2d*> (pieces[index])->type ());
        }
        catch (...)
        {
            id = -2;
        }
    }
    arx_trim_offset_free2 (pieces);
    return id;
}

ARX_GE_EXPORT int arx_ge_curve2d_trim_offset_into (intptr_t self, double dist,
                                                   int ext, int index,
                                                   intptr_t target)
{
    if (!arx_ok (target))
        return -1;
    AcGeVoidPointerArray pieces;
    int count = arx_curve2_trim_offset (self, dist, ext, pieces);
    if (count < 0)
        return count;
    int status = -1;
    if (index >= 0 && index < count)
    {
        AcGeEntity2d* piece = static_cast<AcGeEntity2d*> (pieces[index]);
        if (piece == 0)
            status = -3;
        else
        {
            status = 2;
            try
            {
                if (piece->type () == arx_ent2 (target)->type ()
                    && arx_entity2d_assign (piece, target) != 0)
                    status = 1;
            }
            catch (...)
            {
                status = -2;
            }
        }
    }
    int freed = 1;
    try
    {
        freed = arx_trim_offset_free2 (pieces);
    }
    catch (...)
    {
        status = -2;
    }
    if ((status == 0 || status == 2) && freed == 0)
        return 3;
    return status;
}

ARX_GE_EXPORT int arx_ge_curve3d_trim_offset_count (intptr_t self, double dist,
                                                    int ext, double nrx, double nry,
                                                    double nrz)
{
    AcGeVoidPointerArray pieces;
    int count = arx_curve3_trim_offset (self, dist, ext, nrx, nry, nrz, pieces);
    if (count < 0)
        return count;
    arx_trim_offset_free3 (pieces);
    return count;
}

ARX_GE_EXPORT int arx_ge_curve3d_trim_offset_type (intptr_t self, double dist,
                                                   int ext, int index,
                                                   double nrx, double nry,
                                                   double nrz)
{
    AcGeVoidPointerArray pieces;
    int count = arx_curve3_trim_offset (self, dist, ext, nrx, nry, nrz, pieces);
    if (count < 0)
        return count;
    int id = -1;
    if (index >= 0 && index < count && pieces[index] != 0)
    {
        try
        {
            id = static_cast<int> (
                static_cast<AcGeCurve3d*> (pieces[index])->type ());
        }
        catch (...)
        {
            id = -2;
        }
    }
    arx_trim_offset_free3 (pieces);
    return id;
}

ARX_GE_EXPORT int arx_ge_curve3d_trim_offset_into (intptr_t self, double dist,
                                                   int ext, int index,
                                                   double nrx, double nry,
                                                   double nrz, intptr_t target)
{
    if (!arx_ok (target))
        return -1;
    AcGeVoidPointerArray pieces;
    int count = arx_curve3_trim_offset (self, dist, ext, nrx, nry, nrz, pieces);
    if (count < 0)
        return count;
    int status = -1;
    if (index >= 0 && index < count)
    {
        AcGeEntity3d* piece = static_cast<AcGeEntity3d*> (pieces[index]);
        if (piece == 0)
            status = -3;
        else
        {
            status = 2;
            try
            {
                if (piece->type () == arx_ent3 (target)->type ()
                    && arx_entity3d_assign (piece, target) != 0)
                    status = 1;
            }
            catch (...)
            {
                status = -2;
            }
        }
    }
    int freed = 1;
    try
    {
        freed = arx_trim_offset_free3 (pieces);
    }
    catch (...)
    {
        status = -2;
    }
    if ((status == 0 || status == 2) && freed == 0)
        return 3;
    return status;
}

/* ---------- AcGePosition3d ----------
 *
 * The point entity project / orthoProject returns once the source curve
 * collapses onto the plane (AcGe::kPosition3d, id 5).  It needs its own
 * exports because AcGePosition3d derives from AcGeEntity3d while AcGePoint3d
 * does not, so the point bridge above cannot hand out a usable receiver.
 */

ARX_GE_EXPORT intptr_t arx_ge_position3d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePosition3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_position3d_new_pnt (double x, double y, double z)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePosition3d (x, y, z));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_position3d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_position3 (self);
}

ARX_GE_EXPORT int arx_ge_position3d_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_position3 (self)->point3d ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_position3d_type (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_ent3 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

/* ---------- AcGeCircArc3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_circarc3d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_circarc3d_new_circle (double cx, double cy, double cz,
                                                    double nx, double ny, double nz,
                                                    double radius)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc3d (AcGePoint3d (cx, cy, cz),
                                                              AcGeVector3d (nx, ny, nz),
                                                              radius));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_circarc3d_new_angles (double cx, double cy, double cz,
                                                    double nx, double ny, double nz,
                                                    double rx, double ry, double rz,
                                                    double radius, double startAng, double endAng)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc3d (
            AcGePoint3d (cx, cy, cz), AcGeVector3d (nx, ny, nz), AcGeVector3d (rx, ry, rz),
            radius, startAng, endAng));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_circarc3d_new_three (double x1, double y1, double z1,
                                                   double x2, double y2, double z2,
                                                   double x3, double y3, double z3)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeCircArc3d (AcGePoint3d (x1, y1, z1),
                                                              AcGePoint3d (x2, y2, z2),
                                                              AcGePoint3d (x3, y3, z3)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_circarc3d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_arc3 (self);
}

ARX_GE_EXPORT int arx_ge_circarc3d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_arc3 (self) = *arx_arc3 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_center (intptr_t self, double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc3 (self)->setCenter (AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_axes (intptr_t self, double nx, double ny, double nz,
                                             double rx, double ry, double rz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc3 (self)->setAxes (AcGeVector3d (nx, ny, nz), AcGeVector3d (rx, ry, rz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_radius (intptr_t self, double radius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc3 (self)->setRadius (radius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_start_end_ang (intptr_t self, double startAng, double endAng)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc3 (self)->setAngles (startAng, endAng);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_circle (intptr_t self, double cx, double cy, double cz,
                                               double nx, double ny, double nz, double radius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc3 (self)->set (AcGePoint3d (cx, cy, cz), AcGeVector3d (nx, ny, nz), radius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_angles (intptr_t self, double cx, double cy, double cz,
                                               double nx, double ny, double nz,
                                               double rx, double ry, double rz,
                                               double radius, double startAng, double endAng)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc3 (self)->set (AcGePoint3d (cx, cy, cz), AcGeVector3d (nx, ny, nz),
                              AcGeVector3d (rx, ry, rz), radius, startAng, endAng);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_three (intptr_t self,
                                              double x1, double y1, double z1,
                                              double x2, double y2, double z2,
                                              double x3, double y3, double z3)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_arc3 (self)->set (AcGePoint3d (x1, y1, z1), AcGePoint3d (x2, y2, z2),
                              AcGePoint3d (x3, y3, z3));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_three_err (intptr_t self,
                                                  double x1, double y1, double z1,
                                                  double x2, double y2, double z2,
                                                  double x3, double y3, double z3)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        AcGe::ErrorCondition error = AcGe::kOk;
        arx_arc3 (self)->set (AcGePoint3d (x1, y1, z1), AcGePoint3d (x2, y2, z2),
                              AcGePoint3d (x3, y3, z3), error);
        return static_cast<int> (error);
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_center (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_arc3 (self)->center ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_normal (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_arc3 (self)->normal ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_ref_vec (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_arc3 (self)->refVec ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_circarc3d_radius (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_arc3 (self)->radius ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_circarc3d_start_ang (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_arc3 (self)->startAng ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_circarc3d_end_ang (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_arc3 (self)->endAng ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_arc3 (self)->startPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_arc3 (self)->endPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_get_plane (intptr_t self, intptr_t outPlane)
{
    if (!arx_ok (self) || !arx_ok (outPlane))
        return 0;
    try
    {
        arx_arc3 (self)->getPlane (*arx_plane (outPlane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_is_inside (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_arc3 (self)->isInside (AcGePoint3d (px, py, pz)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_tangent (intptr_t self, double px, double py, double pz,
                                            intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return 0;
    try
    {
        AcGeLine3d line;
        if (!arx_arc3 (self)->tangent (AcGePoint3d (px, py, pz), line))
            return 0;
        *arx_line3 (outLine) = line;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_tangent_err (intptr_t self, double px, double py, double pz,
                                                intptr_t outLine)
{
    if (!arx_ok (self) || !arx_ok (outLine))
        return -1;
    try
    {
        AcGeLine3d line;
        AcGe::ErrorCondition error = AcGe::kOk;
        if (!arx_arc3 (self)->tangent (AcGePoint3d (px, py, pz), line, AcGeContext::gTol, error))
            return static_cast<int> (error);
        *arx_line3 (outLine) = line;
        return static_cast<int> (error);
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_intersect_with_line (intptr_t self, intptr_t other,
                                                        intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outP1) || !arx_ok (outP2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint3d p1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d p2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_arc3 (self)->intersectWith (*arx_lent3 (other), count, p1, p2))
            return -1;
        if (count >= 1)
            *arx_pt (outP1) = p1;
        if (count >= 2)
            *arx_pt (outP2) = p2;
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_intersect_with_arc (intptr_t self, intptr_t other,
                                                       intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outP1) || !arx_ok (outP2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint3d p1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d p2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_arc3 (self)->intersectWith (*arx_arc3 (other), count, p1, p2))
            return -1;
        if (count >= 1)
            *arx_pt (outP1) = p1;
        if (count >= 2)
            *arx_pt (outP2) = p2;
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_intersect_with_plane (intptr_t self, intptr_t plane,
                                                         intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (plane) || !arx_ok (outP1) || !arx_ok (outP2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint3d p1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d p2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_arc3 (self)->intersectWith (*arx_plane (plane), count, p1, p2))
            return -1;
        if (count >= 1)
            *arx_pt (outP1) = p1;
        if (count >= 2)
            *arx_pt (outP2) = p2;
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_proj_intersect_with (intptr_t self, intptr_t line,
                                                        double dx, double dy, double dz,
                                                        intptr_t outArc1, intptr_t outArc2,
                                                        intptr_t outLine1, intptr_t outLine2)
{
    if (!arx_ok (self) || !arx_ok (line) || !arx_ok (outArc1) || !arx_ok (outArc2)
        || !arx_ok (outLine1) || !arx_ok (outLine2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint3d a1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d a2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d l1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d l2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_arc3 (self)->projIntersectWith (*arx_lent3 (line), AcGeVector3d (dx, dy, dz),
                                                 count, a1, a2, l1, l2))
            return -1;
        if (count >= 1)
        {
            *arx_pt (outArc1) = a1;
            *arx_pt (outLine1) = l1;
        }
        if (count >= 2)
        {
            *arx_pt (outArc2) = a2;
            *arx_pt (outLine2) = l2;
        }
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_closest_point_to_plane (intptr_t self, intptr_t plane,
                                                           intptr_t outPnt, intptr_t outOnPlane)
{
    if (!arx_ok (self) || !arx_ok (plane) || !arx_ok (outPnt) || !arx_ok (outOnPlane))
        return 0;
    try
    {
        AcGePoint3d onPlane (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d onArc = arx_arc3 (self)->closestPointToPlane (*arx_plane (plane), onPlane);
        *arx_pt (outPnt) = onArc;
        *arx_pt (outOnPlane) = onPlane;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_fillet (intptr_t self, intptr_t curve1, intptr_t curve2,
                                               double radius, intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (curve1) || !arx_ok (curve2)
        || !arx_ok (outP1) || !arx_ok (outP2))
        return 0;
    try
    {
        double param1 = 0;
        double param2 = 0;
        Adesk::Boolean success = Adesk::kFalse;
        arx_arc3 (self)->set (*arx_curve3 (curve1), *arx_curve3 (curve2), radius,
                              param1, param2, success);
        if (!success)
            return 0;
        *arx_pt (outP1) = arx_curve3 (curve1)->evalPoint (param1);
        *arx_pt (outP2) = arx_curve3 (curve2)->evalPoint (param2);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_circarc3d_set_tangent_three (intptr_t self, intptr_t curve1,
                                                      intptr_t curve2, intptr_t curve3,
                                                      intptr_t outP1, intptr_t outP2,
                                                      intptr_t outP3)
{
    if (!arx_ok (self) || !arx_ok (curve1) || !arx_ok (curve2) || !arx_ok (curve3)
        || !arx_ok (outP1) || !arx_ok (outP2) || !arx_ok (outP3))
        return 0;
    try
    {
        double param1 = 0;
        double param2 = 0;
        double param3 = 0;
        Adesk::Boolean success = Adesk::kFalse;
        arx_arc3 (self)->set (*arx_curve3 (curve1), *arx_curve3 (curve2), *arx_curve3 (curve3),
                              param1, param2, param3, success);
        if (!success)
            return 0;
        *arx_pt (outP1) = arx_curve3 (curve1)->evalPoint (param1);
        *arx_pt (outP2) = arx_curve3 (curve2)->evalPoint (param2);
        *arx_pt (outP3) = arx_curve3 (curve3)->evalPoint (param3);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeEllipArc2d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_ellip2d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeEllipArc2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ellip2d_new_axes (double cx, double cy,
                                                double ax, double ay,
                                                double bx, double by,
                                                double majorRadius, double minorRadius)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeEllipArc2d (
            AcGePoint2d (cx, cy), AcGeVector2d (ax, ay), AcGeVector2d (bx, by),
            majorRadius, minorRadius));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ellip2d_new_angles (double cx, double cy,
                                                  double ax, double ay,
                                                  double bx, double by,
                                                  double majorRadius, double minorRadius,
                                                  double startAng, double endAng)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeEllipArc2d (
            AcGePoint2d (cx, cy), AcGeVector2d (ax, ay), AcGeVector2d (bx, by),
            majorRadius, minorRadius, startAng, endAng));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ellip2d_new_from_arc (intptr_t arc)
{
    if (!arx_ok (arc))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeEllipArc2d (*arx_arc2 (arc)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_ellip2d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_ellip2 (self);
}

ARX_GE_EXPORT int arx_ge_ellip2d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_ellip2 (self) = *arx_ellip2 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_set_axes (intptr_t self, double cx, double cy,
                                           double ax, double ay, double bx, double by,
                                           double majorRadius, double minorRadius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip2 (self)->set (AcGePoint2d (cx, cy), AcGeVector2d (ax, ay),
                                AcGeVector2d (bx, by), majorRadius, minorRadius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_set_angles (intptr_t self, double cx, double cy,
                                             double ax, double ay, double bx, double by,
                                             double majorRadius, double minorRadius,
                                             double startAng, double endAng)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip2 (self)->set (AcGePoint2d (cx, cy), AcGeVector2d (ax, ay),
                                AcGeVector2d (bx, by), majorRadius, minorRadius,
                                startAng, endAng);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_set_from_arc (intptr_t self, intptr_t arc)
{
    if (!arx_ok (self) || !arx_ok (arc))
        return 0;
    try
    {
        arx_ellip2 (self)->set (*arx_arc2 (arc));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_set_center (intptr_t self, double cx, double cy)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip2 (self)->setCenter (AcGePoint2d (cx, cy));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_set_major_radius (intptr_t self, double radius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip2 (self)->setMajorRadius (radius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_set_minor_radius (intptr_t self, double radius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip2 (self)->setMinorRadius (radius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_set_axis_vecs (intptr_t self, double ax, double ay,
                                                double bx, double by)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip2 (self)->setAxes (AcGeVector2d (ax, ay), AcGeVector2d (bx, by));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_set_angle_pair (intptr_t self, double startAng, double endAng)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip2 (self)->setAngles (startAng, endAng);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_center (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_ellip2 (self)->center ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_ellip2d_major_radius (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ellip2 (self)->majorRadius ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_ellip2d_minor_radius (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ellip2 (self)->minorRadius ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_major_axis (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec2 (outVec) = arx_ellip2 (self)->majorAxis ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_minor_axis (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec2 (outVec) = arx_ellip2 (self)->minorAxis ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_ellip2d_start_ang (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ellip2 (self)->startAng ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_ellip2d_end_ang (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ellip2 (self)->endAng ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_ellip2 (self)->startPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_ellip2 (self)->endPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_is_clockwise (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_ellip2 (self)->isClockWise () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_is_circular (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_ellip2 (self)->isCircular () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_is_circular_tol (intptr_t self, double equalVector)
{
    if (!arx_ok (self) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_ellip2 (self)->isCircular (tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_is_inside (intptr_t self, double px, double py)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_ellip2 (self)->isInside (AcGePoint2d (px, py)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip2d_intersect_with_line (intptr_t self, intptr_t other,
                                                      intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outP1) || !arx_ok (outP2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint2d p1 (ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint2d p2 (ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_ellip2 (self)->intersectWith (*arx_lent2 (other), count, p1, p2))
            return -1;
        if (count >= 1)
            *arx_pt2 (outP1) = p1;
        if (count >= 2)
            *arx_pt2 (outP2) = p2;
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

/* ---------- AcGeEllipArc3d ---------- */

ARX_GE_EXPORT intptr_t arx_ge_ellip3d_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeEllipArc3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ellip3d_new_axes (double cx, double cy, double cz,
                                                double ax, double ay, double az,
                                                double bx, double by, double bz,
                                                double majorRadius, double minorRadius)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeEllipArc3d (
            AcGePoint3d (cx, cy, cz), AcGeVector3d (ax, ay, az), AcGeVector3d (bx, by, bz),
            majorRadius, minorRadius));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ellip3d_new_angles (double cx, double cy, double cz,
                                                  double ax, double ay, double az,
                                                  double bx, double by, double bz,
                                                  double majorRadius, double minorRadius,
                                                  double startAng, double endAng)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeEllipArc3d (
            AcGePoint3d (cx, cy, cz), AcGeVector3d (ax, ay, az), AcGeVector3d (bx, by, bz),
            majorRadius, minorRadius, startAng, endAng));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ellip3d_new_from_arc (intptr_t arc)
{
    if (!arx_ok (arc))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeEllipArc3d (*arx_arc3 (arc)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_ellip3d_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_ellip3 (self);
}

ARX_GE_EXPORT int arx_ge_ellip3d_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_ellip3 (self) = *arx_ellip3 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_set_axes (intptr_t self, double cx, double cy, double cz,
                                           double ax, double ay, double az,
                                           double bx, double by, double bz,
                                           double majorRadius, double minorRadius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip3 (self)->set (AcGePoint3d (cx, cy, cz), AcGeVector3d (ax, ay, az),
                                AcGeVector3d (bx, by, bz), majorRadius, minorRadius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_set_angles (intptr_t self, double cx, double cy, double cz,
                                             double ax, double ay, double az,
                                             double bx, double by, double bz,
                                             double majorRadius, double minorRadius,
                                             double startAng, double endAng)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip3 (self)->set (AcGePoint3d (cx, cy, cz), AcGeVector3d (ax, ay, az),
                                AcGeVector3d (bx, by, bz), majorRadius, minorRadius,
                                startAng, endAng);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_set_from_arc (intptr_t self, intptr_t arc)
{
    if (!arx_ok (self) || !arx_ok (arc))
        return 0;
    try
    {
        arx_ellip3 (self)->set (*arx_arc3 (arc));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_set_center (intptr_t self, double cx, double cy, double cz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip3 (self)->setCenter (AcGePoint3d (cx, cy, cz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_set_major_radius (intptr_t self, double radius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip3 (self)->setMajorRadius (radius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_set_minor_radius (intptr_t self, double radius)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip3 (self)->setMinorRadius (radius);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_set_axis_vecs (intptr_t self, double ax, double ay, double az,
                                                double bx, double by, double bz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip3 (self)->setAxes (AcGeVector3d (ax, ay, az), AcGeVector3d (bx, by, bz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_set_angle_pair (intptr_t self, double startAng, double endAng)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_ellip3 (self)->setAngles (startAng, endAng);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_center (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_ellip3 (self)->center ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_ellip3d_major_radius (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ellip3 (self)->majorRadius ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_ellip3d_minor_radius (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ellip3 (self)->minorRadius ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_major_axis (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_ellip3 (self)->majorAxis ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_minor_axis (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_ellip3 (self)->minorAxis ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_normal (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_ellip3 (self)->normal ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_ellip3d_start_ang (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ellip3 (self)->startAng ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_ellip3d_end_ang (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ellip3 (self)->endAng ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_start_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_ellip3 (self)->startPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_end_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_ellip3 (self)->endPoint ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_get_plane (intptr_t self, intptr_t outPlane)
{
    if (!arx_ok (self) || !arx_ok (outPlane))
        return 0;
    try
    {
        arx_ellip3 (self)->getPlane (*arx_plane (outPlane));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_is_circular (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_ellip3 (self)->isCircular () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_is_circular_tol (intptr_t self, double equalVector)
{
    if (!arx_ok (self) || !(equalVector >= 0.0))
        return 0;
    try
    {
        AcGeTol tol;
        tol.setEqualVector (equalVector);
        return arx_ellip3 (self)->isCircular (tol) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_is_inside (intptr_t self, double px, double py, double pz)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_ellip3 (self)->isInside (AcGePoint3d (px, py, pz)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_intersect_with_line (intptr_t self, intptr_t other,
                                                      intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (outP1) || !arx_ok (outP2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint3d p1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d p2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_ellip3 (self)->intersectWith (*arx_lent3 (other), count, p1, p2))
            return -1;
        if (count >= 1)
            *arx_pt (outP1) = p1;
        if (count >= 2)
            *arx_pt (outP2) = p2;
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_intersect_with_plane (intptr_t self, intptr_t plane,
                                                       intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (plane) || !arx_ok (outP1) || !arx_ok (outP2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint3d p1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d p2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_ellip3 (self)->intersectWith (*arx_plane (plane), count, p1, p2))
            return -1;
        if (count >= 1)
            *arx_pt (outP1) = p1;
        if (count >= 2)
            *arx_pt (outP2) = p2;
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_proj_intersect_with (intptr_t self, intptr_t line,
                                                      double dx, double dy, double dz,
                                                      intptr_t outSelf1, intptr_t outSelf2,
                                                      intptr_t outLine1, intptr_t outLine2)
{
    if (!arx_ok (self) || !arx_ok (line) || !arx_ok (outSelf1) || !arx_ok (outSelf2)
        || !arx_ok (outLine1) || !arx_ok (outLine2))
        return -1;
    try
    {
        int count = 0;
        AcGePoint3d e1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d e2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d l1 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d l2 (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        if (!arx_ellip3 (self)->projIntersectWith (*arx_lent3 (line), AcGeVector3d (dx, dy, dz),
                                                   count, e1, e2, l1, l2))
            return -1;
        if (count >= 1)
        {
            *arx_pt (outSelf1) = e1;
            *arx_pt (outLine1) = l1;
        }
        if (count >= 2)
        {
            *arx_pt (outSelf2) = e2;
            *arx_pt (outLine2) = l2;
        }
        return count;
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_ellip3d_closest_point_to_plane (intptr_t self, intptr_t plane,
                                                         intptr_t outPnt, intptr_t outOnPlane)
{
    if (!arx_ok (self) || !arx_ok (plane) || !arx_ok (outPnt) || !arx_ok (outOnPlane))
        return 0;
    try
    {
        AcGePoint3d onPlane (ARX_GE_NAN, ARX_GE_NAN, ARX_GE_NAN);
        AcGePoint3d onEllipse = arx_ellip3 (self)->closestPointToPlane (*arx_plane (plane),
                                                                       onPlane);
        *arx_pt (outPnt) = onEllipse;
        *arx_pt (outOnPlane) = onPlane;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeBoundBlock2d ----------
** Owns a heap AcGeBoundBlock2d (a parallelogram: base point plus two side
** vectors). Readers write into caller-owned point/vector handles. Following the
** file-wide convention, every write and every predicate collapses a bad handle
** or an SDK throw to 0; only the type id reports -1 for an unusable handle.
*/

ARX_GE_EXPORT intptr_t arx_ge_block2_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeBoundBlock2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_block2_new_pair (double x1, double y1,
                                               double x2, double y2)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeBoundBlock2d (AcGePoint2d (x1, y1),
                                                                 AcGePoint2d (x2, y2)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_block2_new_dirs (double bx, double by,
                                               double d1x, double d1y,
                                               double d2x, double d2y)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeBoundBlock2d (
            AcGePoint2d (bx, by), AcGeVector2d (d1x, d1y), AcGeVector2d (d2x, d2y)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_block2_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_block2 (self);
}

ARX_GE_EXPORT int arx_ge_block2_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_block2 (self) = *arx_block2 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_set_pair (intptr_t self, double x1, double y1,
                                          double x2, double y2)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_block2 (self)->set (AcGePoint2d (x1, y1), AcGePoint2d (x2, y2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_set_dirs (intptr_t self, double bx, double by,
                                          double d1x, double d1y,
                                          double d2x, double d2y)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_block2 (self)->set (AcGePoint2d (bx, by),
                                AcGeVector2d (d1x, d1y), AcGeVector2d (d2x, d2y));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_get (intptr_t self, intptr_t outBase,
                                     intptr_t outDir1, intptr_t outDir2)
{
    if (!arx_ok (self) || !arx_ok (outBase) || !arx_ok (outDir1) || !arx_ok (outDir2))
        return 0;
    try
    {
        AcGePoint2d base;
        AcGeVector2d dir1;
        AcGeVector2d dir2;
        arx_block2 (self)->get (base, dir1, dir2);
        *arx_pt2 (outBase) = base;
        *arx_vec2 (outDir1) = dir1;
        *arx_vec2 (outDir2) = dir2;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_get_minmax (intptr_t self, intptr_t outP1,
                                            intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (outP1) || !arx_ok (outP2))
        return 0;
    try
    {
        AcGePoint2d low;
        AcGePoint2d high;
        arx_block2 (self)->getMinMaxPoints (low, high);
        *arx_pt2 (outP1) = low;
        *arx_pt2 (outP2) = high;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_extend (intptr_t self, intptr_t point)
{
    if (!arx_ok (self) || !arx_ok (point))
        return 0;
    try
    {
        arx_block2 (self)->extend (*arx_pt2 (point));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_swell (intptr_t self, double distance)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_block2 (self)->swell (distance);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_contains (intptr_t self, intptr_t point)
{
    if (!arx_ok (self) || !arx_ok (point))
        return 0;
    try
    {
        return arx_block2 (self)->contains (*arx_pt2 (point)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_is_disjoint (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_block2 (self)->isDisjoint (*arx_block2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_is_box (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_block2 (self)->isBox () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_set_to_box (intptr_t self, int flag)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_block2 (self)->setToBox (flag ? Adesk::kTrue : Adesk::kFalse);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block2_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_block2 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

/* which: 0 boundBlock, 1 orthoBoundBlock.
 * useRange: 0 no-argument overload, 1 AcGeInterval (lo, hi). A
 * default-constructed (unbounded) interval reads the same as case 0 on every
 * bounded curve, so it is not offered. */
ARX_GE_EXPORT int arx_ge_block2_from_curve (intptr_t self, intptr_t src, int which,
                                            int useRange, double lo, double hi)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    if (which != 0 && which != 1)
        return 0;
    if (useRange != 0 && useRange != 1)
        return 0;
    try
    {
        AcGeCurve2d* curve = arx_curve2 (src);
        AcGeBoundBlock2d block;
        if (useRange == 0)
            block = which ? curve->orthoBoundBlock () : curve->boundBlock ();
        else
        {
            AcGeInterval range (lo, hi);
            block = which ? curve->orthoBoundBlock (range) : curve->boundBlock (range);
        }
        *arx_block2 (self) = block;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeBoundBlock3d ----------
** Same surface as the 2d block, with a third side vector. ObjectARX gives the
** 3d class no point-pair constructor but does give it set(point1, point2), so
** the pair shape is reachable only through the setter. Move operations are not
** wrapped: the library hands out copy semantics only.
*/

ARX_GE_EXPORT intptr_t arx_ge_block3_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeBoundBlock3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_block3_new_dirs (double bx, double by, double bz,
                                               double d1x, double d1y, double d1z,
                                               double d2x, double d2y, double d2z,
                                               double d3x, double d3y, double d3z)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeBoundBlock3d (
            AcGePoint3d (bx, by, bz), AcGeVector3d (d1x, d1y, d1z),
            AcGeVector3d (d2x, d2y, d2z), AcGeVector3d (d3x, d3y, d3z)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_block3_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_block3 (self);
}

ARX_GE_EXPORT int arx_ge_block3_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_block3 (self) = *arx_block3 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_set_pair (intptr_t self, double x1, double y1, double z1,
                                          double x2, double y2, double z2)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_block3 (self)->set (AcGePoint3d (x1, y1, z1), AcGePoint3d (x2, y2, z2));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_set_dirs (intptr_t self, double bx, double by, double bz,
                                          double d1x, double d1y, double d1z,
                                          double d2x, double d2y, double d2z,
                                          double d3x, double d3y, double d3z)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_block3 (self)->set (AcGePoint3d (bx, by, bz),
                                AcGeVector3d (d1x, d1y, d1z),
                                AcGeVector3d (d2x, d2y, d2z),
                                AcGeVector3d (d3x, d3y, d3z));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_get (intptr_t self, intptr_t outBase, intptr_t outDir1,
                                     intptr_t outDir2, intptr_t outDir3)
{
    if (!arx_ok (self) || !arx_ok (outBase) || !arx_ok (outDir1)
        || !arx_ok (outDir2) || !arx_ok (outDir3))
        return 0;
    try
    {
        AcGePoint3d base;
        AcGeVector3d dir1;
        AcGeVector3d dir2;
        AcGeVector3d dir3;
        arx_block3 (self)->get (base, dir1, dir2, dir3);
        *arx_pt (outBase) = base;
        *arx_vec (outDir1) = dir1;
        *arx_vec (outDir2) = dir2;
        *arx_vec (outDir3) = dir3;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_get_minmax (intptr_t self, intptr_t outP1, intptr_t outP2)
{
    if (!arx_ok (self) || !arx_ok (outP1) || !arx_ok (outP2))
        return 0;
    try
    {
        AcGePoint3d low;
        AcGePoint3d high;
        arx_block3 (self)->getMinMaxPoints (low, high);
        *arx_pt (outP1) = low;
        *arx_pt (outP2) = high;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_extend (intptr_t self, intptr_t point)
{
    if (!arx_ok (self) || !arx_ok (point))
        return 0;
    try
    {
        arx_block3 (self)->extend (*arx_pt (point));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_swell (intptr_t self, double distance)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_block3 (self)->swell (distance);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_contains (intptr_t self, intptr_t point)
{
    if (!arx_ok (self) || !arx_ok (point))
        return 0;
    try
    {
        return arx_block3 (self)->contains (*arx_pt (point)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_is_disjoint (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_block3 (self)->isDisjoint (*arx_block3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_is_box (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_block3 (self)->isBox () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_set_to_box (intptr_t self, int flag)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_block3 (self)->setToBox (flag ? Adesk::kTrue : Adesk::kFalse);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_block3_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_block3 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_block3_from_curve (intptr_t self, intptr_t src, int which,
                                            int useRange, double lo, double hi)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    if (which != 0 && which != 1)
        return 0;
    if (useRange != 0 && useRange != 1)
        return 0;
    try
    {
        AcGeCurve3d* curve = arx_curve3 (src);
        AcGeBoundBlock3d block;
        if (useRange == 0)
            block = which ? curve->orthoBoundBlock () : curve->boundBlock ();
        else
        {
            AcGeInterval range (lo, hi);
            block = which ? curve->orthoBoundBlock (range) : curve->boundBlock (range);
        }
        *arx_block3 (self) = block;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- layout sanity ---------- */

ARX_GE_EXPORT int arx_ge_point_struct_size (void)
{
    return static_cast<int> (sizeof (AcGePoint3d));
}

ARX_GE_EXPORT int arx_ge_vector_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeVector3d));
}

ARX_GE_EXPORT int arx_ge_matrix_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeMatrix3d));
}

ARX_GE_EXPORT int arx_ge_point2d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGePoint2d));
}

ARX_GE_EXPORT int arx_ge_vector2d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeVector2d));
}

ARX_GE_EXPORT int arx_ge_matrix2d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeMatrix2d));
}

ARX_GE_EXPORT int arx_ge_line2d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeLine2d));
}

ARX_GE_EXPORT int arx_ge_lineseg2d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeLineSeg2d));
}

ARX_GE_EXPORT int arx_ge_line3d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeLine3d));
}

ARX_GE_EXPORT int arx_ge_lineseg3d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeLineSeg3d));
}

ARX_GE_EXPORT int arx_ge_ray2d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeRay2d));
}

ARX_GE_EXPORT int arx_ge_ray3d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeRay3d));
}

ARX_GE_EXPORT int arx_ge_plane_struct_size (void)
{
    return static_cast<int> (sizeof (AcGePlane));
}

ARX_GE_EXPORT int arx_ge_circarc2d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeCircArc2d));
}

ARX_GE_EXPORT int arx_ge_circarc3d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeCircArc3d));
}

ARX_GE_EXPORT int arx_ge_ellip2d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeEllipArc2d));
}

ARX_GE_EXPORT int arx_ge_ellip3d_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeEllipArc3d));
}

ARX_GE_EXPORT int arx_ge_block2_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeBoundBlock2d));
}

ARX_GE_EXPORT int arx_ge_block3_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeBoundBlock3d));
}

/* ---------- AcGeLinearEnt2d / AcGeLinearEnt3d : overlap -------------------
 *
 *   Adesk::Boolean overlap (const AcGeLinearEnt2d& line,
 *                           AcGeLinearEnt2d*&    overlap,
 *                           const AcGeTol&       tol = AcGeContext::gTol) const
 *
 * The SDK allocates the overlap piece itself, so that handle never leaves this
 * bridge: the piece is cast back to its own leaf class through type() and
 * destroyed here, exactly like the split and trimmed-offset helpers, because
 * AcGeEntity2d and AcGeEntity3d have non virtual destructors.
 *
 * Measured on AcGe25, same shape in both dimensions:
 *  - Only collinear pairs answer yes.  Two segments touching at one endpoint,
 *    two segments crossing at one interior point, a zero-length segment sitting
 *    on the other curve, a parallel offset pair, two intersecting infinite
 *    lines and two skew lines all answer no.  Nothing threw, so -2 is a guard
 *    rather than an observed path.
 *  - A no always comes back with no piece and a yes always comes back with a
 *    piece; the "yes but null piece" combination was never observed.
 *  - The piece is built in the RECEIVER's class, not in the class of the common
 *    part: a segment receiver gets kLineSeg2d / kLineSeg3d, an infinite line
 *    receiver gets kLine2d / kLine3d, even when the partner is the other one of
 *    the pair.  Each of the four leaf classes therefore receives its own piece
 *    and the type gate below stays untriggered insurance.
 *  - A segment piece is the clipped common part.  A line piece keeps the
 *    receiver's own reference point and unnormalised direction but has its
 *    interval rewritten to the overlap expressed in the receiver's parameter
 *    space, which can read as a negative or descending pair.
 *
 * Return codes: -1 invalid handle, -2 the SDK threw, -3 the SDK returned a
 * piece-less answer.  _take adds 0 = no overlap, 1 = assigned, 2 = the piece
 * class did not match this object, 3 = the piece had to be left alive.
 */

static int arx_lent2_overlap (intptr_t self, intptr_t other,
                              AcGeLinearEnt2d** piece)
{
    *piece = 0;
    if (!arx_ok (self) || !arx_ok (other))
        return -1;
    try
    {
        if (arx_lent2 (self)->overlap (*arx_lent2 (other), *piece))
            return 1;
    }
    catch (...)
    {
        if (*piece != 0)
            arx_entity2d_delete (*piece);
        *piece = 0;
        return -2;
    }
    return 0;
}

static int arx_lent3_overlap (intptr_t self, intptr_t other,
                              AcGeLinearEnt3d** piece)
{
    *piece = 0;
    if (!arx_ok (self) || !arx_ok (other))
        return -1;
    try
    {
        if (arx_lent3 (self)->overlap (*arx_lent3 (other), *piece))
            return 1;
    }
    catch (...)
    {
        if (*piece != 0)
            arx_entity3d_delete (*piece);
        *piece = 0;
        return -2;
    }
    return 0;
}

ARX_GE_EXPORT int arx_ge_lent2d_overlap (intptr_t self, intptr_t other)
{
    AcGeLinearEnt2d* piece;
    int code = arx_lent2_overlap (self, other, &piece);
    int yes = (code == 1 && piece != 0) ? 1 : 0;
    if (piece != 0)
        arx_entity2d_delete (piece);
    return yes;
}

ARX_GE_EXPORT int arx_ge_lent2d_overlap_type (intptr_t self, intptr_t other)
{
    AcGeLinearEnt2d* piece;
    int code = arx_lent2_overlap (self, other, &piece);
    if (code < 0)
        return code;
    if (piece == 0)
        return -3;
    int id;
    try
    {
        id = static_cast<int> (piece->type ());
    }
    catch (...)
    {
        return -2;
    }
    if (arx_entity2d_delete (piece) == 0)
        return -4;
    return id;
}

ARX_GE_EXPORT int arx_ge_lent2d_overlap_take (intptr_t self, intptr_t other)
{
    AcGeLinearEnt2d* piece;
    int code = arx_lent2_overlap (self, other, &piece);
    if (code < 0)
        return code;
    if (piece == 0)
        return 0;
    int status = 2;
    try
    {
        if (piece->type () == arx_ent2 (self)->type ()
            && arx_entity2d_assign (piece, self) != 0)
            status = 1;
    }
    catch (...)
    {
        status = -2;
    }
    int freed = 0;
    try
    {
        freed = arx_entity2d_delete (piece);
    }
    catch (...)
    {
        status = -2;
    }
    if ((status == 0 || status == 2) && freed == 0)
        return 3;
    return status;
}

ARX_GE_EXPORT int arx_ge_lent3d_overlap (intptr_t self, intptr_t other)
{
    AcGeLinearEnt3d* piece;
    int code = arx_lent3_overlap (self, other, &piece);
    int yes = (code == 1 && piece != 0) ? 1 : 0;
    if (piece != 0)
        arx_entity3d_delete (piece);
    return yes;
}

ARX_GE_EXPORT int arx_ge_lent3d_overlap_type (intptr_t self, intptr_t other)
{
    AcGeLinearEnt3d* piece;
    int code = arx_lent3_overlap (self, other, &piece);
    if (code < 0)
        return code;
    if (piece == 0)
        return -3;
    int id;
    try
    {
        id = static_cast<int> (piece->type ());
    }
    catch (...)
    {
        return -2;
    }
    if (arx_entity3d_delete (piece) == 0)
        return -4;
    return id;
}

ARX_GE_EXPORT int arx_ge_lent3d_overlap_take (intptr_t self, intptr_t other)
{
    AcGeLinearEnt3d* piece;
    int code = arx_lent3_overlap (self, other, &piece);
    if (code < 0)
        return code;
    if (piece == 0)
        return 0;
    int status = 2;
    try
    {
        if (piece->type () == arx_ent3 (self)->type ()
            && arx_entity3d_assign (piece, self) != 0)
            status = 1;
    }
    catch (...)
    {
        status = -2;
    }
    int freed = 0;
    try
    {
        freed = arx_entity3d_delete (piece);
    }
    catch (...)
    {
        status = -2;
    }
    if ((status == 0 || status == 2) && freed == 0)
        return 3;
    return status;
}


/* ---------- AcGePointOnCurve2d / AcGePointOnCurve3d ----------
** Handle layer over "a point sitting on a borrowed curve", the out-parameter
** type of AcGeCurve2d / AcGeCurve3d::getClosestPointTo. The object keeps only a
** const reference to the curve plus a parameter, so the bridge never copies the
** curve and never frees it: the curve must outlive the handle.
**   new / new_curve / new_param  heap constructors; 0 when the curve handle is
**                            unusable or the SDK threw.
**   readers                write into caller-owned point/vector handles and
**                            answer 1 done, 0 bad handle or threw.
**   parameter              the stored parameter, ARX_GE_NAN on a bad handle.
**   curve_point / curve_deriv  the point(crv, param) and deriv(order, crv,
**                            param) shapes. They need no receiver of their own,
**                            so they run on a throwaway object.
**   curvature              3d calls the SDK and reports ARX_GE_NAN when it
**                            answers false (measured on a zero-length segment).
**                            2d cannot: curvature (double&) and
**                            curvature (double, double&) have no export in
**                            lib-x64, so the bridge evaluates
**                            |x'y'' - y'x''| / |d1|^3 from deriv (1) and
**                            deriv (2). Measured bit-identical to the 3d SDK:
**                            circle 0.2, ellipse 0.278779083406933 and
**                            0.400703391821629, tiny circle 1000, line and
**                            segment 0.
**   is_singular            3d calls isSingular () with the default gTol. 2d
**                            cannot (the same missing export), so the bridge
**                            asks |deriv (1)| <= arx_poc2_singular_floor: the
**                            3d scan flips between 1e-12 singular and 3e-12
**                            not, and that one constant reproduces all
**                            eighteen scanned cases. Two notes for whoever
**                            wraps AcGeTol later: isSingular does read the
**                            tolerance it is handed (a tol whose equalVector is
**                            1e6 calls a chord-0.1 segment singular), yet both
**                            a fresh AcGeTol and AcGeContext::gTol report 0 in
**                            every one of their five internal slots, so the
**                            default path is really the library's own floor.
**                            The 2d rule cannot be handed a tolerance at all.
**   same_curve             curve() == handle, 1 or 0. curve() is never null: a
**                            default object is bound to a static AcGeLine2d
**                            (type 18, shared by every fresh object) or to an
**                            AcGeLine3d (type 19, one per object), so emptiness
**                            is judged by the handle only, never by this.
**   take_closest / _pair   the two getClosestPointTo overloads. Both rewrite
**                            the receiver, and a receiver that was already
**                            seeded gets re-targeted to the solving curve. 3d
**                            adds the two projection forms, which AcGeCurve2d
**                            does not have at all.
**   type_id                6 or 7 for a live object, -1 on a bad handle.
*/

static const double arx_poc2_singular_floor = 1e-12;

static double arx_poc2_curvature_of (const AcGeVector2d& d1, const AcGeVector2d& d2)
{
    double len = d1.length ();
    if (len <= 0.0)
        return ARX_GE_NAN;
    double num = d1.x * d2.y - d1.y * d2.x;
    if (num < 0.0)
        num = -num;
    return num / (len * len * len);
}

ARX_GE_EXPORT intptr_t arx_ge_poc2_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePointOnCurve2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_poc2_new_curve (intptr_t curve)
{
    if (!arx_ok (curve))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (
            new AcGePointOnCurve2d (*arx_curve2 (curve)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_poc2_new_param (intptr_t curve, double param)
{
    if (!arx_ok (curve))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (
            new AcGePointOnCurve2d (*arx_curve2 (curve), param));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_poc2_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_poc2 (self);
}

ARX_GE_EXPORT int arx_ge_poc2_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_poc2 (self) = *arx_poc2 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_set_curve (intptr_t self, intptr_t curve)
{
    if (!arx_ok (self) || !arx_ok (curve))
        return 0;
    try
    {
        arx_poc2 (self)->setCurve (*arx_curve2 (curve));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_set_param (intptr_t self, double param)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_poc2 (self)->setParameter (param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_same_curve (intptr_t self, intptr_t curve)
{
    if (!arx_ok (self) || !arx_ok (curve))
        return 0;
    try
    {
        return arx_poc2 (self)->curve () == arx_curve2 (curve) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_poc2_parameter (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_poc2 (self)->parameter ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_poc2 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_get_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_poc2 (self)->point ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_get_point_at (intptr_t self, double param,
                                            intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_poc2 (self)->point (param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_curve_point (intptr_t curve, double param,
                                           intptr_t outPnt)
{
    if (!arx_ok (curve) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGePointOnCurve2d fresh;
        *arx_pt2 (outPnt) = fresh.point (*arx_curve2 (curve), param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_get_deriv (intptr_t self, int order, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec2 (outVec) = arx_poc2 (self)->deriv (order);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_get_deriv_at (intptr_t self, int order, double param,
                                            intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec2 (outVec) = arx_poc2 (self)->deriv (order, param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_curve_deriv (intptr_t curve, int order, double param,
                                           intptr_t outVec)
{
    if (!arx_ok (curve) || !arx_ok (outVec))
        return 0;
    try
    {
        AcGePointOnCurve2d fresh;
        *arx_vec2 (outVec) = fresh.deriv (order, *arx_curve2 (curve), param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_poc2_curvature (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGePointOnCurve2d* poc = arx_poc2 (self);
        return arx_poc2_curvature_of (poc->deriv (1), poc->deriv (2));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_poc2_curvature_at (intptr_t self, double param)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        AcGePointOnCurve2d* poc = arx_poc2 (self);
        return arx_poc2_curvature_of (poc->deriv (1, param), poc->deriv (2, param));
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_is_singular (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_poc2 (self)->deriv (1).length () <= arx_poc2_singular_floor
             ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_take_closest (intptr_t self, intptr_t src,
                                            double x, double y)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        arx_curve2 (src)->getClosestPointTo (AcGePoint2d (x, y), *arx_poc2 (self));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_take_closest_pair (intptr_t self, intptr_t other,
                                                 intptr_t src_a, intptr_t src_b)
{
    if (!arx_ok (self) || !arx_ok (other)
        || !arx_ok (src_a) || !arx_ok (src_b))
        return 0;
    try
    {
        arx_curve2 (src_a)->getClosestPointTo (*arx_curve2 (src_b),
                                               *arx_poc2 (self), *arx_poc2 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_struct_size (void)
{
    return static_cast<int> (sizeof (AcGePointOnCurve2d));
}

ARX_GE_EXPORT intptr_t arx_ge_poc3_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePointOnCurve3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_poc3_new_curve (intptr_t curve)
{
    if (!arx_ok (curve))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (
            new AcGePointOnCurve3d (*arx_curve3 (curve)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_poc3_new_param (intptr_t curve, double param)
{
    if (!arx_ok (curve))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (
            new AcGePointOnCurve3d (*arx_curve3 (curve), param));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_poc3_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_poc3 (self);
}

ARX_GE_EXPORT int arx_ge_poc3_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_poc3 (self) = *arx_poc3 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_set_curve (intptr_t self, intptr_t curve)
{
    if (!arx_ok (self) || !arx_ok (curve))
        return 0;
    try
    {
        arx_poc3 (self)->setCurve (*arx_curve3 (curve));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_set_param (intptr_t self, double param)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_poc3 (self)->setParameter (param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_same_curve (intptr_t self, intptr_t curve)
{
    if (!arx_ok (self) || !arx_ok (curve))
        return 0;
    try
    {
        return arx_poc3 (self)->curve () == arx_curve3 (curve) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_poc3_parameter (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_poc3 (self)->parameter ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_poc3 (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_get_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_poc3 (self)->point ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_get_point_at (intptr_t self, double param,
                                            intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_poc3 (self)->point (param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_curve_point (intptr_t curve, double param,
                                           intptr_t outPnt)
{
    if (!arx_ok (curve) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGePointOnCurve3d fresh;
        *arx_pt (outPnt) = fresh.point (*arx_curve3 (curve), param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_get_deriv (intptr_t self, int order, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_poc3 (self)->deriv (order);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_get_deriv_at (intptr_t self, int order, double param,
                                            intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_poc3 (self)->deriv (order, param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_curve_deriv (intptr_t curve, int order, double param,
                                           intptr_t outVec)
{
    if (!arx_ok (curve) || !arx_ok (outVec))
        return 0;
    try
    {
        AcGePointOnCurve3d fresh;
        *arx_vec (outVec) = fresh.deriv (order, *arx_curve3 (curve), param);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_poc3_curvature (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        double res = ARX_GE_NAN;
        if (!arx_poc3 (self)->curvature (res))
            return ARX_GE_NAN;
        return res;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_poc3_curvature_at (intptr_t self, double param)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        double res = ARX_GE_NAN;
        if (!arx_poc3 (self)->curvature (param, res))
            return ARX_GE_NAN;
        return res;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_is_singular (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_poc3 (self)->isSingular () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_take_closest (intptr_t self, intptr_t src,
                                            double x, double y, double z)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        arx_curve3 (src)->getClosestPointTo (AcGePoint3d (x, y, z), *arx_poc3 (self));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_take_closest_pair (intptr_t self, intptr_t other,
                                                 intptr_t src_a, intptr_t src_b)
{
    if (!arx_ok (self) || !arx_ok (other)
        || !arx_ok (src_a) || !arx_ok (src_b))
        return 0;
    try
    {
        arx_curve3 (src_a)->getClosestPointTo (*arx_curve3 (src_b),
                                               *arx_poc3 (self), *arx_poc3 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_take_proj_closest (intptr_t self, intptr_t src,
                                                 double px, double py, double pz,
                                                 double dx, double dy, double dz)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        arx_curve3 (src)->getProjClosestPointTo (AcGePoint3d (px, py, pz),
                                                 AcGeVector3d (dx, dy, dz),
                                                 *arx_poc3 (self));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_take_proj_closest_pair (intptr_t self, intptr_t other,
                                                      intptr_t src_a, intptr_t src_b,
                                                      double dx, double dy, double dz)
{
    if (!arx_ok (self) || !arx_ok (other)
        || !arx_ok (src_a) || !arx_ok (src_b))
        return 0;
    try
    {
        arx_curve3 (src_a)->getProjClosestPointTo (*arx_curve3 (src_b),
                                                   AcGeVector3d (dx, dy, dz),
                                                   *arx_poc3 (self), *arx_poc3 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_struct_size (void)
{
    return static_cast<int> (sizeof (AcGePointOnCurve3d));
}

/* ==================== package 15B: normal point + local closest points =========
** Three AcGeCurve2d / AcGeCurve3d entries that write into an already built
** AcGePointOnCurve object. Measured on AcGe25, none of them throws on the eight
** leaf curves, and none of them moves the poc's curve alias:
**   normal       Adesk::Boolean getNormalPoint (point, poc, tol = gTol)
**                answers false for a circle / ellipse centre in 2D and for any
**                point off the circle plane in 3D; a false answer leaves the poc
**                exactly as it was, parameter included. The stored parameter is
**                the search seed and picks which branch comes back on a closed
**                curve (circle r5, point (1,2): seed 0 -> 1.10714871779409,
**                seed pi -> the antipodal 4.24874137138388).
**   local_point  void getLocalClosestPoints (point, poc, nbhd = 0, tol = gTol)
**   local_pair   void getLocalClosestPoints (crv, pocThis, pocOther,
**                                            nbhd1 = 0, nbhd2 = 0, tol = gTol)
** Both are local solvers: the measured answer is either the true minimum or one
** of the two interval bounds, and an out of range bound is written back without
** being normalised to the curve domain. They return 1 for "the call went
** through", which carries no geometric guarantee.
** nbhd is a flag word: bit 0 = (alo, ahi) goes to this curve, bit 1 = (blo, bhi)
** goes to the other one. Anything outside 0..1 (point form) or 0..3 (pair form)
** is refused without calling. No tolerance parameter is exposed, so every call
** runs on gTol.
*/

ARX_GE_EXPORT int arx_ge_poc2_normal (intptr_t self, intptr_t src,
                                      double x, double y)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        return arx_curve2 (src)->getNormalPoint (AcGePoint2d (x, y),
                                                 *arx_poc2 (self)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_local_point (intptr_t self, intptr_t src,
                                           double x, double y,
                                           int nbhd, double alo, double ahi)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    if (nbhd != 0 && nbhd != 1)
        return 0;
    try
    {
        AcGeInterval iv (alo, ahi);
        arx_curve2 (src)->getLocalClosestPoints (AcGePoint2d (x, y),
                                                 *arx_poc2 (self),
                                                 nbhd ? &iv : 0);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc2_local_pair (intptr_t self, intptr_t other,
                                          intptr_t src_a, intptr_t src_b,
                                          int nbhd, double alo, double ahi,
                                          double blo, double bhi)
{
    if (!arx_ok (self) || !arx_ok (other)
        || !arx_ok (src_a) || !arx_ok (src_b))
        return 0;
    if (nbhd < 0 || nbhd > 3)
        return 0;
    try
    {
        AcGeInterval ivA (alo, ahi);
        AcGeInterval ivB (blo, bhi);
        arx_curve2 (src_a)->getLocalClosestPoints (*arx_curve2 (src_b),
                                                   *arx_poc2 (self),
                                                   *arx_poc2 (other),
                                                   (nbhd & 1) ? &ivA : 0,
                                                   (nbhd & 2) ? &ivB : 0);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_normal (intptr_t self, intptr_t src,
                                      double x, double y, double z)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        return arx_curve3 (src)->getNormalPoint (AcGePoint3d (x, y, z),
                                                 *arx_poc3 (self)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_local_point (intptr_t self, intptr_t src,
                                           double x, double y, double z,
                                           int nbhd, double alo, double ahi)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    if (nbhd != 0 && nbhd != 1)
        return 0;
    try
    {
        AcGeInterval iv (alo, ahi);
        arx_curve3 (src)->getLocalClosestPoints (AcGePoint3d (x, y, z),
                                                 *arx_poc3 (self),
                                                 nbhd ? &iv : 0);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_poc3_local_pair (intptr_t self, intptr_t other,
                                          intptr_t src_a, intptr_t src_b,
                                          int nbhd, double alo, double ahi,
                                          double blo, double bhi)
{
    if (!arx_ok (self) || !arx_ok (other)
        || !arx_ok (src_a) || !arx_ok (src_b))
        return 0;
    if (nbhd < 0 || nbhd > 3)
        return 0;
    try
    {
        AcGeInterval ivA (alo, ahi);
        AcGeInterval ivB (blo, bhi);
        arx_curve3 (src_a)->getLocalClosestPoints (*arx_curve3 (src_b),
                                                   *arx_poc3 (self),
                                                   *arx_poc3 (other),
                                                   (nbhd & 1) ? &ivA : 0,
                                                   (nbhd & 2) ? &ivB : 0);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeCurve2d/3d::setInterval and the 3-out getInterval (pkg 16) ---------- */
/* The interval is flattened to (lower, upper): the AcGeInterval object is built inside
   these functions and never escapes, so the library needs no AcGeInterval mirror.
   Only the finite closed form is exposed; the half bounded and default-interval forms
   answer false on every bounded leaf curve in AcGe25 (an unbounded line is the single
   case that accepts the default form, and it refuses every finite interval).
   Status: 1 = SDK accepted the call, 0 = bad handle, SDK refused, or SDK threw. */

ARX_GE_EXPORT double arx_ge_curve2d_set_interval (intptr_t self, double lower, double upper)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        AcGeInterval interval (lower, upper);
        return arx_curve2 (self)->setInterval (interval) ? 1.0 : 0.0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_restore_interval (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve2 (self)->setInterval ();
        return 1.0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve2d_read_interval (intptr_t self, intptr_t outStart, intptr_t outEnd)
{
    if (!arx_ok (self) || !arx_ok (outStart) || !arx_ok (outEnd))
        return 0;
    try
    {
        AcGeInterval interval;
        /* Seeded from the caller's points on purpose: AcGe25 leaves both untouched on an
           unbounded line, so a fresh sentinel here would overwrite the caller's data. */
        AcGePoint2d start = *arx_pt2 (outStart);
        AcGePoint2d end   = *arx_pt2 (outEnd);
        arx_curve2 (self)->getInterval (interval, start, end);
        *arx_pt2 (outStart) = start;
        *arx_pt2 (outEnd)   = end;
        return 1.0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_set_interval (intptr_t self, double lower, double upper)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        AcGeInterval interval (lower, upper);
        return arx_curve3 (self)->setInterval (interval) ? 1.0 : 0.0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_restore_interval (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_curve3 (self)->setInterval ();
        return 1.0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_curve3d_read_interval (intptr_t self, intptr_t outStart, intptr_t outEnd)
{
    if (!arx_ok (self) || !arx_ok (outStart) || !arx_ok (outEnd))
        return 0;
    try
    {
        AcGeInterval interval;
        AcGePoint3d start = *arx_pt (outStart);
        AcGePoint3d end   = *arx_pt (outEnd);
        arx_curve3 (self)->getInterval (interval, start, end);
        *arx_pt (outStart) = start;
        *arx_pt (outEnd)   = end;
        return 1.0;
    }
    catch (...)
    {
        return 0;
    }
}

/* ---------- AcGeOffsetCurve2d / AcGeOffsetCurve3d ----------
 *
 * Measured on this AcGe25 build: an offset curve keeps nothing but a reference
 * to the curve it was handed. curve() answered the constructor argument for
 * every source type tried, and the SDK copy constructor shares that same
 * pointer, so a caller that releases its source first leaves the offset object
 * bound to freed memory while AcGe neither checks nor complains. Each handle
 * below therefore owns a private by-type clone of its source: the clone is newed
 * before the SDK ever sees it, the previous clone is destroyed only after the
 * object stopped referring to it, and free() drops both. No clone is ever
 * shared between two handles, which is why copying does not call the SDK copy
 * constructor at all.
 *
 * The visible cost is that curve() no longer answers the caller's handle, so
 * there is no same-curve query in this block. The type id of the stored clone
 * is exposed instead; the probe measured that a cloned circle keeps reporting
 * 10, which is the proof that the by-type clone preserved the leaf class.
 *
 * The constructor also refuses two sources that measured as silent garbage
 * rather than as failures: an infinite line (interval 0..0, arc length 0, the
 * offset collapsing to the single point (0,2)) and a zero length segment
 * (interval 0..1, arc length 0, every evaluation NaN). Both would otherwise be
 * handed back as a live but meaningless object. A default constructed arc does
 * throw inside new AcGeOffsetCurve2d and is caught here.
 */

ARX_GE_EXPORT int arx_ge_ofc2_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeOffsetCurve2d));
}

ARX_GE_EXPORT int arx_ge_ofc3_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeOffsetCurve3d));
}

ARX_GE_EXPORT intptr_t arx_ge_ofc2_new (intptr_t curve, double dist)
{
    if (!arx_ok (curve))
        return 0;
    AcGeCurve2d* copy = 0;
    try
    {
        AcGeCurve2d* src = arx_curve2 (curve);
        if (!arx_curve2d_has_girth (src))
            return 0;
        copy = arx_curve2d_clone (src);
        if (copy == 0)
            return 0;
        return reinterpret_cast<intptr_t> (new AcGeOffsetCurve2d (*copy, dist));
    }
    catch (...)
    {
        arx_entity2d_delete (copy);
    }
    return 0;
}

ARX_GE_EXPORT void arx_ge_ofc2_free (intptr_t self)
{
    if (!arx_is_offset2 (self))
        return;
    try
    {
        AcGeCurve2d* copy = arx_offset2_source (self);
        delete arx_ofc2 (self);
        arx_entity2d_delete (copy);
    }
    catch (...)
    {
    }
}

ARX_GE_EXPORT int arx_ge_ofc2_copy (intptr_t self, intptr_t src)
{
    if (!arx_is_offset2 (self) || !arx_is_offset2 (src))
        return 0;
    return arx_offset2_adopt (self, arx_ofc2 (src));
}

ARX_GE_EXPORT int arx_ge_ofc2_set_curve (intptr_t self, intptr_t curve)
{
    if (!arx_is_offset2 (self) || !arx_ok (curve))
        return 0;
    AcGeCurve2d* mine = 0;
    try
    {
        AcGeCurve2d* src = arx_curve2 (curve);
        if (!arx_curve2d_has_girth (src))
            return 0;
        mine = arx_curve2d_clone (src);
        if (mine == 0)
            return 0;
        AcGeCurve2d* old = arx_offset2_source (self);
        arx_ofc2 (self)->setCurve (*mine);
        arx_entity2d_delete (old);
        return 1;
    }
    catch (...)
    {
        arx_entity2d_delete (mine);
    }
    return 0;
}

ARX_GE_EXPORT int arx_ge_ofc2_set_dist (intptr_t self, double dist)
{
    if (!arx_is_offset2 (self))
        return 0;
    try
    {
        arx_ofc2 (self)->setOffsetDistance (dist);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_ofc2_dist (intptr_t self)
{
    if (!arx_is_offset2 (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ofc2 (self)->offsetDistance ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_ofc2_param_direction (intptr_t self)
{
    if (!arx_is_offset2 (self))
        return 0;
    try
    {
        return arx_ofc2 (self)->paramDirection () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ofc2_is_identity (intptr_t self)
{
    if (!arx_is_offset2 (self))
        return 0;
    try
    {
        const AcGeMatrix2d m = arx_ofc2 (self)->transformation ();
        return (m.entry[0][0] == 1.0 && m.entry[1][1] == 1.0 && m.entry[2][2] == 1.0
                && m.entry[0][1] == 0.0 && m.entry[0][2] == 0.0
                && m.entry[1][0] == 0.0 && m.entry[1][2] == 0.0
                && m.entry[2][0] == 0.0 && m.entry[2][1] == 0.0) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_ofc2_transform_entry (intptr_t self, int row, int col)
{
    if (!arx_is_offset2 (self) || !arx_idx2_ok (row) || !arx_idx2_ok (col))
        return ARX_GE_NAN;
    try
    {
        return arx_ofc2 (self)->transformation ().entry[row][col];
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_ofc2_src_type_id (intptr_t self)
{
    if (!arx_is_offset2 (self))
        return -1;
    try
    {
        return static_cast<int> (arx_offset2_source (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_ofc3_new (intptr_t curve, double nx, double ny,
                                        double nz, double dist)
{
    if (!arx_ok (curve))
        return 0;
    AcGeCurve3d* copy = 0;
    try
    {
        AcGeCurve3d* src = arx_curve3 (curve);
        if (!arx_curve3d_has_girth (src))
            return 0;
        copy = arx_curve3d_clone (src);
        if (copy == 0)
            return 0;
        return reinterpret_cast<intptr_t> (
            new AcGeOffsetCurve3d (*copy, AcGeVector3d (nx, ny, nz), dist));
    }
    catch (...)
    {
        arx_entity3d_delete (copy);
    }
    return 0;
}

ARX_GE_EXPORT void arx_ge_ofc3_free (intptr_t self)
{
    if (!arx_is_offset3 (self))
        return;
    try
    {
        AcGeCurve3d* copy = arx_offset3_source (self);
        delete arx_ofc3 (self);
        arx_entity3d_delete (copy);
    }
    catch (...)
    {
    }
}

ARX_GE_EXPORT int arx_ge_ofc3_copy (intptr_t self, intptr_t src)
{
    if (!arx_is_offset3 (self) || !arx_is_offset3 (src))
        return 0;
    return arx_offset3_adopt (self, arx_ofc3 (src));
}

ARX_GE_EXPORT int arx_ge_ofc3_set_curve (intptr_t self, intptr_t curve)
{
    if (!arx_is_offset3 (self) || !arx_ok (curve))
        return 0;
    AcGeCurve3d* mine = 0;
    try
    {
        AcGeCurve3d* src = arx_curve3 (curve);
        if (!arx_curve3d_has_girth (src))
            return 0;
        mine = arx_curve3d_clone (src);
        if (mine == 0)
            return 0;
        AcGeCurve3d* old = arx_offset3_source (self);
        arx_ofc3 (self)->setCurve (*mine);
        arx_entity3d_delete (old);
        return 1;
    }
    catch (...)
    {
        arx_entity3d_delete (mine);
    }
    return 0;
}

ARX_GE_EXPORT int arx_ge_ofc3_set_dist (intptr_t self, double dist)
{
    if (!arx_is_offset3 (self))
        return 0;
    try
    {
        arx_ofc3 (self)->setOffsetDistance (dist);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_ofc3_dist (intptr_t self)
{
    if (!arx_is_offset3 (self))
        return ARX_GE_NAN;
    try
    {
        return arx_ofc3 (self)->offsetDistance ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

/* A zero normal is what the SDK accepts and then silently ignores: the probe
 * measured a 3d circle with normal (0,0,0) answering a curve with the source
 * radius and
 * distance-to-source 0, while setNormal(AcGeVector3d::kZero) still returned
 * success. Nothing to be read from the object later, so it is refused here. */
ARX_GE_EXPORT int arx_ge_ofc3_set_normal (intptr_t self, double nx, double ny, double nz)
{
    if (!arx_is_offset3 (self))
        return 0;
    if (nx != nx || ny != ny || nz != nz
        || (nx == 0.0 && ny == 0.0 && nz == 0.0))
        return 0;
    try
    {
        arx_ofc3 (self)->setNormal (AcGeVector3d (nx, ny, nz));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ofc3_get_normal (intptr_t self, intptr_t outVec)
{
    if (!arx_is_offset3 (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_ofc3 (self)->normal ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ofc3_param_direction (intptr_t self)
{
    if (!arx_is_offset3 (self))
        return 0;
    try
    {
        return arx_ofc3 (self)->paramDirection () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_ofc3_is_identity (intptr_t self)
{
    if (!arx_is_offset3 (self))
        return 0;
    try
    {
        const AcGeMatrix3d m = arx_ofc3 (self)->transformation ();
        return (m.entry[0][0] == 1.0 && m.entry[1][1] == 1.0
                && m.entry[2][2] == 1.0 && m.entry[3][3] == 1.0
                && m.entry[0][1] == 0.0 && m.entry[0][2] == 0.0 && m.entry[0][3] == 0.0
                && m.entry[1][0] == 0.0 && m.entry[1][2] == 0.0 && m.entry[1][3] == 0.0
                && m.entry[2][0] == 0.0 && m.entry[2][1] == 0.0 && m.entry[2][3] == 0.0
                && m.entry[3][0] == 0.0 && m.entry[3][1] == 0.0 && m.entry[3][2] == 0.0)
                   ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_ofc3_transform_entry (intptr_t self, int row, int col)
{
    if (!arx_is_offset3 (self) || !arx_idx_ok (row) || !arx_idx_ok (col))
        return ARX_GE_NAN;
    try
    {
        return arx_ofc3 (self)->transformation ().entry[row][col];
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_ofc3_src_type_id (intptr_t self)
{
    if (!arx_is_offset3 (self))
        return -1;
    try
    {
        return static_cast<int> (arx_offset3_source (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

/* ---------- AcGeInterval ----------
** Heap-owned AcGeInterval.  Everything else in this file only ever built one on the
** stack and let it die at the end of the call, so this is the first place that has to
** own one.  sizeof is 16: a pImpl pointer plus an ownership flag, and the copy
** constructor does not share that pImpl -- measured on AcGe25, mutating or deleting a
** copy leaves the source alone, which is why the library copy method can be a plain operator=.
**
** Contracts the library comments rely on, all measured on AcGe25:
**  - Readers hand back the stored numbers.  An unbounded interval reads lower = upper
**    = 0 with length -1; a half-bounded one duplicates its single bound
**    (boundedBelow with bound 2 reads lower = upper = 2).  Only the five boundedness
**    predicates tell the three shapes apart.
**  - Nothing rebalances the bounds: set(5, 2) keeps the pair and length() reads -3, so
**    length may legitimately be negative.  element() is upperBound unless singleton.
**  - isSingleton is true when upper - lower <= tolerance.
**  - set() with no argument makes the interval fully unbounded and keeps the tolerance.
**  - operator ==, contains(interval) and isDisjoint ignore tolerance;
**    contains(double) and isEqualAtUpper/Lower(double) respect it.
**  - The relational operators are unusable for interval-vs-interval: every pair reads
**    false, including a < a and a <= a.  Only == and != are wrapped.
**  - getMerge always writes result, takes its tolerance from the LEFT operand and
**    overwrites whatever the result object had; separated operands merge to the outer
**    envelope with no warning, and any unbounded operand makes the result unbounded.
**  - subtract / intersectWith / isOverlapAtUpper leave a result object exactly as it
**    was when they do not write it.  The reset is done in the library layer, not here,
**    so this stays a thin ABI boundary.
**  - isPeriodicallyOn is non-const but never mutates the interval.  It folds val when
**    the span covers a full period and leaves val untouched otherwise, hence the flag
**    and the folded value are two independent calls with the same arguments.
*/

static inline AcGeInterval* arx_iv (intptr_t value)
{
    return reinterpret_cast<AcGeInterval*> (value);
}

ARX_GE_EXPORT intptr_t arx_ge_iv_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeInterval ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_iv_new_tol (double tol)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeInterval (tol));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_iv_new_bounds (double lower, double upper, double tol)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeInterval (lower, upper, tol));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_iv_new_bounds_def (double lower, double upper)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeInterval (lower, upper));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_iv_new_half (int boundedBelow, double bound, double tol)
{
    try
    {
        return reinterpret_cast<intptr_t> (
            new AcGeInterval (boundedBelow != 0 ? Adesk::kTrue : Adesk::kFalse, bound, tol));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_iv_new_half_def (int boundedBelow, double bound)
{
    try
    {
        return reinterpret_cast<intptr_t> (
            new AcGeInterval (boundedBelow != 0 ? Adesk::kTrue : Adesk::kFalse, bound));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_iv_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_iv (self);
}

ARX_GE_EXPORT int arx_ge_iv_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_iv (self) = *arx_iv (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_iv_lower (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_iv (self)->lowerBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_iv_upper (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_iv (self)->upperBound ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_iv_element (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_iv (self)->element ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_iv_length (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_iv (self)->length ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT double arx_ge_iv_tol (intptr_t self)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        return arx_iv (self)->tolerance ();
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_iv_set_bounds (intptr_t self, double lower, double upper)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_iv (self)->set (lower, upper);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_set_half (intptr_t self, int boundedBelow, double bound)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_iv (self)->set (boundedBelow != 0 ? Adesk::kTrue : Adesk::kFalse, bound);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_set_unbounded (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_iv (self)->set ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_set_upper (intptr_t self, double upper)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_iv (self)->setUpper (upper);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_set_lower (intptr_t self, double lower)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_iv (self)->setLower (lower);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_set_tol (intptr_t self, double tol)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_iv (self)->setTolerance (tol);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_is_bounded (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_iv (self)->isBounded () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_is_bounded_above (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_iv (self)->isBoundedAbove () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_is_bounded_below (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_iv (self)->isBoundedBelow () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_is_unbounded (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_iv (self)->isUnBounded () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_is_singleton (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_iv (self)->isSingleton () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_equals (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return (*arx_iv (self) == *arx_iv (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_not_equals (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return (*arx_iv (self) != *arx_iv (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_contains_iv (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_iv (self)->contains (*arx_iv (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_contains_val (intptr_t self, double val)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_iv (self)->contains (val) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_is_disjoint (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_iv (self)->isDisjoint (*arx_iv (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_continuous_at_upper (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_iv (self)->isContinuousAtUpper (*arx_iv (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_equal_at_upper_iv (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_iv (self)->isEqualAtUpper (*arx_iv (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_equal_at_upper_val (intptr_t self, double val)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_iv (self)->isEqualAtUpper (val) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_equal_at_lower_iv (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_iv (self)->isEqualAtLower (*arx_iv (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_equal_at_lower_val (intptr_t self, double val)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_iv (self)->isEqualAtLower (val) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_merge (intptr_t self, intptr_t other, intptr_t res)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (res))
        return 0;
    try
    {
        arx_iv (self)->getMerge (*arx_iv (other), *arx_iv (res));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_subtract (intptr_t self, intptr_t other,
                                      intptr_t res_l, intptr_t res_r)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (res_l) || !arx_ok (res_r))
        return -1;
    try
    {
        return arx_iv (self)->subtract (*arx_iv (other), *arx_iv (res_l), *arx_iv (res_r));
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_iv_intersect (intptr_t self, intptr_t other, intptr_t res)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (res))
        return 0;
    try
    {
        return arx_iv (self)->intersectWith (*arx_iv (other), *arx_iv (res)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_overlap_at_upper (intptr_t self, intptr_t other, intptr_t res)
{
    if (!arx_ok (self) || !arx_ok (other) || !arx_ok (res))
        return 0;
    try
    {
        return arx_iv (self)->isOverlapAtUpper (*arx_iv (other), *arx_iv (res)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_iv_periodic_on (intptr_t self, double period, double val)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        double out = val;
        return arx_iv (self)->isPeriodicallyOn (period, out) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_iv_periodic_fold (intptr_t self, double period, double val)
{
    if (!arx_ok (self))
        return ARX_GE_NAN;
    try
    {
        double out = val;
        arx_iv (self)->isPeriodicallyOn (period, out);
        return out;
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_iv_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeInterval));
}

/* ---------- AcGePointOnSurface (package 19B) --------------------------------
**
** Value semantics evaluation family over a borrowed surface. Every read form is
** one SDK call; the three forms per family are the const member, the member that
** takes another (u, v), and the form that takes a bare surface handle, which the
** bridge runs on a stack object so the caller's object stays untouched.
** Nothing here is computed in the bridge, so no formula constants exist.
*/

ARX_GE_EXPORT intptr_t arx_ge_pos_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGePointOnSurface ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_pos_new_surface (intptr_t surf)
{
    if (!arx_ok (surf))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (
            new AcGePointOnSurface (*arx_surf (surf)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_pos_new_param (intptr_t surf, double u, double v)
{
    if (!arx_ok (surf))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (
            new AcGePointOnSurface (*arx_surf (surf), AcGePoint2d (u, v)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_pos_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_pos (self);
}

ARX_GE_EXPORT int arx_ge_pos_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_pos (self) = *arx_pos (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_set_surface (intptr_t self, intptr_t surf)
{
    if (!arx_ok (self) || !arx_ok (surf))
        return 0;
    try
    {
        arx_pos (self)->setSurface (*arx_surf (surf));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_set_param (intptr_t self, double u, double v)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_pos (self)->setParameter (AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_same_surface (intptr_t self, intptr_t surf)
{
    if (!arx_ok (self) || !arx_ok (surf))
        return 0;
    try
    {
        return arx_pos (self)->surface () == arx_surf (surf) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_parameter (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt2 (outPnt) = arx_pos (self)->parameter ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_type_id (intptr_t self)
{
    if (!arx_ok (self))
        return -1;
    try
    {
        return static_cast<int> (arx_pos (self)->type ());
    }
    catch (...)
    {
        return -1;
    }
}

ARX_GE_EXPORT int arx_ge_pos_point (intptr_t self, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_pos (self)->point ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_point_at (intptr_t self, double u, double v,
                                       intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        *arx_pt (outPnt) = arx_pos (self)->point (AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_surface_point (intptr_t surf, double u, double v,
                                            intptr_t outPnt)
{
    if (!arx_ok (surf) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGePointOnSurface fresh;
        *arx_pt (outPnt) = fresh.point (*arx_surf (surf), AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_normal (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->normal ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_normal_at (intptr_t self, double u, double v,
                                        intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->normal (AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_surface_normal (intptr_t surf, double u, double v,
                                             intptr_t outVec)
{
    if (!arx_ok (surf) || !arx_ok (outVec))
        return 0;
    try
    {
        AcGePointOnSurface fresh;
        *arx_vec (outVec) = fresh.normal (*arx_surf (surf), AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_u_deriv (intptr_t self, int order, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->uDeriv (order);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_u_deriv_at (intptr_t self, int order, double u,
                                         double v, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->uDeriv (order, AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_surface_u_deriv (intptr_t surf, int order, double u,
                                              double v, intptr_t outVec)
{
    if (!arx_ok (surf) || !arx_ok (outVec))
        return 0;
    try
    {
        AcGePointOnSurface fresh;
        *arx_vec (outVec) = fresh.uDeriv (order, *arx_surf (surf),
                                           AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_v_deriv (intptr_t self, int order, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->vDeriv (order);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_v_deriv_at (intptr_t self, int order, double u,
                                         double v, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->vDeriv (order, AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_surface_v_deriv (intptr_t surf, int order, double u,
                                              double v, intptr_t outVec)
{
    if (!arx_ok (surf) || !arx_ok (outVec))
        return 0;
    try
    {
        AcGePointOnSurface fresh;
        *arx_vec (outVec) = fresh.vDeriv (order, *arx_surf (surf),
                                           AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_mixed_deriv (intptr_t self, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->mixedPartial ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_mixed_deriv_at (intptr_t self, double u, double v,
                                             intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->mixedPartial (AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_surface_mixed_deriv (intptr_t surf, double u, double v,
                                                  intptr_t outVec)
{
    if (!arx_ok (surf) || !arx_ok (outVec))
        return 0;
    try
    {
        AcGePointOnSurface fresh;
        *arx_vec (outVec) = fresh.mixedPartial (*arx_surf (surf),
                                                AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_tangent (intptr_t self, double du, double dv,
                                      intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->tangentVector (AcGeVector2d (du, dv));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_tangent_at (intptr_t self, double du, double dv,
                                         double u, double v, intptr_t outVec)
{
    if (!arx_ok (self) || !arx_ok (outVec))
        return 0;
    try
    {
        *arx_vec (outVec) = arx_pos (self)->tangentVector (AcGeVector2d (du, dv),
                                                           AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_surface_tangent (intptr_t surf, double du, double dv,
                                              double u, double v, intptr_t outVec)
{
    if (!arx_ok (surf) || !arx_ok (outVec))
        return 0;
    try
    {
        AcGePointOnSurface fresh;
        *arx_vec (outVec) = fresh.tangentVector (AcGeVector2d (du, dv),
                                                 *arx_surf (surf),
                                                 AcGePoint2d (u, v));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_inverse_tangent (intptr_t self, double vx, double vy,
                                              double vz, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGeVector2d r = arx_pos (self)->inverseTangentVector (
            AcGeVector3d (vx, vy, vz));
        *arx_pt2 (outPnt) = AcGePoint2d (r.x, r.y);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_inverse_tangent_at (intptr_t self, double vx,
                                                 double vy, double vz, double u,
                                                 double v, intptr_t outPnt)
{
    if (!arx_ok (self) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGeVector2d r = arx_pos (self)->inverseTangentVector (
            AcGeVector3d (vx, vy, vz), AcGePoint2d (u, v));
        *arx_pt2 (outPnt) = AcGePoint2d (r.x, r.y);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_surface_inverse_tangent (intptr_t surf, double vx,
                                                      double vy, double vz,
                                                      double u, double v,
                                                      intptr_t outPnt)
{
    if (!arx_ok (surf) || !arx_ok (outPnt))
        return 0;
    try
    {
        AcGePointOnSurface fresh;
        AcGeVector2d r = fresh.inverseTangentVector (AcGeVector3d (vx, vy, vz),
                                                    *arx_surf (surf),
                                                    AcGePoint2d (u, v));
        *arx_pt2 (outPnt) = AcGePoint2d (r.x, r.y);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_pos_struct_size (void)
{
    return static_cast<int> (sizeof (AcGePointOnSurface));
}

/* ---------- AcGeScale2d (package 20) ---------- */
static inline AcGeScale2d* arx_sc2 (intptr_t value)
{
    return reinterpret_cast<AcGeScale2d*> (value);
}

static inline bool arx_sc2_idx_ok (int index)
{
    return index >= 0 && index <= 1;
}

ARX_GE_EXPORT intptr_t arx_ge_sc2_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale2d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_sc2_new_uniform (double factor)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale2d (factor));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_sc2_new_components (double xFactor, double yFactor)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale2d (xFactor, yFactor));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_sc2_new_identity (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale2d (AcGeScale2d::kIdentity));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_sc2_new_copy (intptr_t src)
{
    if (!arx_ok (src))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale2d (*arx_sc2 (src)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_sc2_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_sc2 (self);
}

ARX_GE_EXPORT int arx_ge_sc2_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_sc2 (self) = *arx_sc2 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_sc2_component (intptr_t self, int index)
{
    if (!arx_ok (self) || !arx_sc2_idx_ok (index))
        return ARX_GE_NAN;
    try
    {
        return (*arx_sc2 (self))[static_cast<unsigned int> (index)];
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_set_component (intptr_t self, int index, double value)
{
    if (!arx_ok (self) || !arx_sc2_idx_ok (index))
        return 0;
    try
    {
        (*arx_sc2 (self))[static_cast<unsigned int> (index)] = value;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_set_components (intptr_t self, double xFactor, double yFactor)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_sc2 (self)->set (xFactor, yFactor);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_mul_scale (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        *arx_sc2 (self) *= *arx_sc2 (other);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_mul_double (intptr_t self, double factor)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        *arx_sc2 (self) *= factor;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_pre_mult_by (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        arx_sc2 (self)->preMultBy (*arx_sc2 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_post_mult_by (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        arx_sc2 (self)->postMultBy (*arx_sc2 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_set_to_product (intptr_t self, intptr_t left, intptr_t right)
{
    if (!arx_ok (self) || !arx_ok (left) || !arx_ok (right))
        return 0;
    try
    {
        arx_sc2 (self)->setToProduct (*arx_sc2 (left), *arx_sc2 (right));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_set_to_product_double (intptr_t self, intptr_t src, double factor)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        arx_sc2 (self)->setToProduct (*arx_sc2 (src), factor);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_invert (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_sc2 (self)->invert ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_inverse_to (intptr_t self, intptr_t out)
{
    if (!arx_ok (self) || !arx_ok (out))
        return 0;
    try
    {
        *arx_sc2 (out) = arx_sc2 (self)->inverse ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_equals (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return (*arx_sc2 (self) == *arx_sc2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_not_equals (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return (*arx_sc2 (self) != *arx_sc2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_sc2 (self)->isEqualTo (*arx_sc2 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_is_proportional (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_sc2 (self)->isProportional () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_is_identity (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_sc2 (self)->isEqualTo (AcGeScale2d::kIdentity) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_get_matrix (intptr_t self, intptr_t out_mat)
{
    if (!arx_ok (self) || !arx_ok (out_mat))
        return 0;
    try
    {
        arx_sc2 (self)->getMatrix (*arx_mat2 (out_mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_extract_from_matrix (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_sc2 (self)->extractScale (*arx_mat2 (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_remove_from_matrix (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_sc2 (self)->removeScale (*arx_mat2 (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc2_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeScale2d));
}

/* ---------- AcGeScale3d (package 20) ---------- */
static inline AcGeScale3d* arx_sc3 (intptr_t value)
{
    return reinterpret_cast<AcGeScale3d*> (value);
}

static inline bool arx_sc3_idx_ok (int index)
{
    return index >= 0 && index <= 2;
}

ARX_GE_EXPORT intptr_t arx_ge_sc3_new (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale3d ());
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_sc3_new_uniform (double factor)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale3d (factor));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_sc3_new_components (double xFactor, double yFactor, double zFactor)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale3d (xFactor, yFactor, zFactor));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_sc3_new_identity (void)
{
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale3d (AcGeScale3d::kIdentity));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT intptr_t arx_ge_sc3_new_copy (intptr_t src)
{
    if (!arx_ok (src))
        return 0;
    try
    {
        return reinterpret_cast<intptr_t> (new AcGeScale3d (*arx_sc3 (src)));
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT void arx_ge_sc3_free (intptr_t self)
{
    if (!arx_ok (self))
        return;
    delete arx_sc3 (self);
}

ARX_GE_EXPORT int arx_ge_sc3_copy (intptr_t self, intptr_t src)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        *arx_sc3 (self) = *arx_sc3 (src);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT double arx_ge_sc3_component (intptr_t self, int index)
{
    if (!arx_ok (self) || !arx_sc3_idx_ok (index))
        return ARX_GE_NAN;
    try
    {
        return (*arx_sc3 (self))[static_cast<unsigned int> (index)];
    }
    catch (...)
    {
        return ARX_GE_NAN;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_set_component (intptr_t self, int index, double value)
{
    if (!arx_ok (self) || !arx_sc3_idx_ok (index))
        return 0;
    try
    {
        (*arx_sc3 (self))[static_cast<unsigned int> (index)] = value;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_set_components (intptr_t self, double xFactor, double yFactor, double zFactor)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_sc3 (self)->set (xFactor, yFactor, zFactor);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_mul_scale (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        *arx_sc3 (self) *= *arx_sc3 (other);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_mul_double (intptr_t self, double factor)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        *arx_sc3 (self) *= factor;
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_pre_mult_by (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        arx_sc3 (self)->preMultBy (*arx_sc3 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_post_mult_by (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        arx_sc3 (self)->postMultBy (*arx_sc3 (other));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_set_to_product (intptr_t self, intptr_t left, intptr_t right)
{
    if (!arx_ok (self) || !arx_ok (left) || !arx_ok (right))
        return 0;
    try
    {
        arx_sc3 (self)->setToProduct (*arx_sc3 (left), *arx_sc3 (right));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_set_to_product_double (intptr_t self, intptr_t src, double factor)
{
    if (!arx_ok (self) || !arx_ok (src))
        return 0;
    try
    {
        arx_sc3 (self)->setToProduct (*arx_sc3 (src), factor);
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_invert (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        arx_sc3 (self)->invert ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_inverse_to (intptr_t self, intptr_t out)
{
    if (!arx_ok (self) || !arx_ok (out))
        return 0;
    try
    {
        *arx_sc3 (out) = arx_sc3 (self)->inverse ();
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_equals (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return (*arx_sc3 (self) == *arx_sc3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_not_equals (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return (*arx_sc3 (self) != *arx_sc3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_is_equal_to (intptr_t self, intptr_t other)
{
    if (!arx_ok (self) || !arx_ok (other))
        return 0;
    try
    {
        return arx_sc3 (self)->isEqualTo (*arx_sc3 (other)) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_is_proportional (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_sc3 (self)->isProportional () ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_is_identity (intptr_t self)
{
    if (!arx_ok (self))
        return 0;
    try
    {
        return arx_sc3 (self)->isEqualTo (AcGeScale3d::kIdentity) ? 1 : 0;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_get_matrix (intptr_t self, intptr_t out_mat)
{
    if (!arx_ok (self) || !arx_ok (out_mat))
        return 0;
    try
    {
        arx_sc3 (self)->getMatrix (*arx_mat (out_mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_extract_from_matrix (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_sc3 (self)->extractScale (*arx_mat (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_remove_from_matrix (intptr_t self, intptr_t mat)
{
    if (!arx_ok (self) || !arx_ok (mat))
        return 0;
    try
    {
        arx_sc3 (self)->removeScale (*arx_mat (mat));
        return 1;
    }
    catch (...)
    {
        return 0;
    }
}

ARX_GE_EXPORT int arx_ge_sc3_struct_size (void)
{
    return static_cast<int> (sizeof (AcGeScale3d));
}

} /* extern "C" */
