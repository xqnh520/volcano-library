package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKBRep 类=31 方法槽=492
public final class Gen_TKBRep {
    private Gen_TKBRep() {}

    public static final class BRepAdaptor_CompCurve {
        private BRepAdaptor_CompCurve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(333, a, box);
        return r;
    }
    public static long 构造_2(long W, boolean KnotByCurvilinearAbcissa) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = W;
        a[2] = KnotByCurvilinearAbcissa ? 1L : 0L;
        long r = OcctGen.occtCall(334, a, box);
        return r;
    }
    public static long 构造_3(
            long W, boolean KnotByCurvilinearAbcissa, double First, double Last, double Tol) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = W;
        a[2] = KnotByCurvilinearAbcissa ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(First);
        a[4] = Double.doubleToRawLongBits(Last);
        a[5] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(335, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(336, a, box);
        return r;
    }
    public static void Initialize(long self, long W, boolean KnotByCurvilinearAbcissa) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        a[2] = KnotByCurvilinearAbcissa ? 1L : 0L;
        OcctGen.occtCall(337, a, box);
    }
    public static void Initialize_2(
            long self, long W, boolean KnotByCurvilinearAbcissa, double First, double Last,
            double Tol) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        a[2] = KnotByCurvilinearAbcissa ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(First);
        a[4] = Double.doubleToRawLongBits(Last);
        a[5] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(338, a, box);
    }
    public static long Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(339, a, box);
        return r;
    }
    public static void Edge(long self, double U, long E, double[] UonEOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = E;
        OcctGen.occtCall(340, a, box);
        if (UonEOut != null && UonEOut.length != 0) UonEOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(341, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(342, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(343, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(344, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(345, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(346, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(347, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(348, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(349, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(350, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(351, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(352, a, box);
    }
    public static void D3(long self, double U, long P, long V1, long V2, long V3) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        a[5] = V3;
        OcctGen.occtCall(353, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(354, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(355, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(356, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(357, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(358, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(359, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(360, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(361, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(362, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(363, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(364, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(365, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(366, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(367, a, box);
        return r;
    }
    }

    public static final class BRepAdaptor_Curve {
        private BRepAdaptor_Curve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(368, a, box);
        return r;
    }
    public static long 构造_2(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(369, a, box);
        return r;
    }
    public static long 构造_3(long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        long r = OcctGen.occtCall(370, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(371, a, box);
        return r;
    }
    public static void Reset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(372, a, box);
    }
    public static void Initialize(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(373, a, box);
    }
    public static void Initialize_2(long self, long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F;
        OcctGen.occtCall(374, a, box);
    }
    public static long Trsf(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(375, a, box);
        return r;
    }
    public static boolean Is3DCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(376, a, box);
        return r != 0;
    }
    public static boolean IsCurveOnSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(377, a, box);
        return r != 0;
    }
    public static long Curve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(378, a, box);
        return r;
    }
    public static long CurveOnSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(379, a, box);
        return r;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(380, a, box);
        return r;
    }
    public static double Tolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(381, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(382, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(383, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(384, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(385, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(386, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(387, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(388, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(389, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(390, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(391, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(392, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(393, a, box);
    }
    public static void D3(long self, double U, long P, long V1, long V2, long V3) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        a[5] = V3;
        OcctGen.occtCall(394, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(395, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(396, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(397, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(398, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(399, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(400, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(401, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(402, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(403, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(404, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(405, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(406, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(407, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(408, a, box);
        return r;
    }
    public static long OffsetCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(409, a, box);
        return r;
    }
    }

    public static final class BRepAdaptor_Curve2d {
        private BRepAdaptor_Curve2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(410, a, box);
        return r;
    }
    public static long 构造_2(long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        long r = OcctGen.occtCall(411, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(412, a, box);
        return r;
    }
    public static void Initialize(long self, long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F;
        OcctGen.occtCall(413, a, box);
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(414, a, box);
        return r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(415, a, box);
        return r;
    }
    }

    public static final class BRepAdaptor_Surface {
        private BRepAdaptor_Surface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(416, a, box);
        return r;
    }
    public static long 构造_2(long F, boolean R) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = F;
        a[2] = R ? 1L : 0L;
        long r = OcctGen.occtCall(417, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(418, a, box);
        return r;
    }
    public static void Initialize(long self, long F, boolean Restriction) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = Restriction ? 1L : 0L;
        OcctGen.occtCall(419, a, box);
    }
    public static long Surface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(420, a, box);
        return r;
    }
    public static long ChangeSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(421, a, box);
        return r;
    }
    public static long Trsf(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(422, a, box);
        return r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(423, a, box);
        return r;
    }
    public static double Tolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(424, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(425, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(426, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(427, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(428, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int UContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(429, a, box);
        return (int) r;
    }
    public static int VContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(430, a, box);
        return (int) r;
    }
    public static int NbUIntervals(long self, int theSh) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theSh;
        long r = OcctGen.occtCall(431, a, box);
        return (int) r;
    }
    public static int NbVIntervals(long self, int theSh) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theSh;
        long r = OcctGen.occtCall(432, a, box);
        return (int) r;
    }
    public static long UTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(433, a, box);
        return r;
    }
    public static long VTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(434, a, box);
        return r;
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(435, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(436, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(437, a, box);
        return r != 0;
    }
    public static double UPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(438, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(439, a, box);
        return r != 0;
    }
    public static double VPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(440, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U, double V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(441, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(442, a, box);
    }
    public static void D1(long self, double U, double V, long P, long D1U, long D1V) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        a[4] = D1U;
        a[5] = D1V;
        OcctGen.occtCall(443, a, box);
    }
    public static void D2(
            long self, double U, double V, long P, long D1U, long D1V, long D2U, long D2V,
            long D2UV) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        a[4] = D1U;
        a[5] = D1V;
        a[6] = D2U;
        a[7] = D2V;
        a[8] = D2UV;
        OcctGen.occtCall(444, a, box);
    }
    public static void D3(
            long self, double U, double V, long P, long D1U, long D1V, long D2U, long D2V,
            long D2UV, long D3U, long D3V, long D3UUV, long D3UVV) {
        long[] a = new long[13];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        a[4] = D1U;
        a[5] = D1V;
        a[6] = D2U;
        a[7] = D2V;
        a[8] = D2UV;
        a[9] = D3U;
        a[10] = D3V;
        a[11] = D3UUV;
        a[12] = D3UVV;
        OcctGen.occtCall(445, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(446, a, box);
        return r;
    }
    public static double UResolution(long self, double theR3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theR3d);
        long r = OcctGen.occtCall(447, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VResolution(long self, double theR3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theR3d);
        long r = OcctGen.occtCall(448, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(449, a, box);
        return (int) r;
    }
    public static long Plane(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(450, a, box);
        return r;
    }
    public static long Cylinder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(451, a, box);
        return r;
    }
    public static long Cone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(452, a, box);
        return r;
    }
    public static long Sphere(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(453, a, box);
        return r;
    }
    public static long Torus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(454, a, box);
        return r;
    }
    public static int UDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(455, a, box);
        return (int) r;
    }
    public static int NbUPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(456, a, box);
        return (int) r;
    }
    public static int VDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(457, a, box);
        return (int) r;
    }
    public static int NbVPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(458, a, box);
        return (int) r;
    }
    public static int NbUKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(459, a, box);
        return (int) r;
    }
    public static int NbVKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(460, a, box);
        return (int) r;
    }
    public static boolean IsURational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(461, a, box);
        return r != 0;
    }
    public static boolean IsVRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(462, a, box);
        return r != 0;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(463, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(464, a, box);
        return r;
    }
    public static long AxeOfRevolution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(465, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(466, a, box);
        return r;
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(467, a, box);
        return r;
    }
    public static long BasisSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(468, a, box);
        return r;
    }
    public static double OffsetValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(469, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepLProp_CLProps {
        private BRepLProp_CLProps() {}

    public static long 构造(long C, int N, double Resolution) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = N;
        a[3] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(1453, a, box);
        return r;
    }
    public static long 构造_2(long C, double U, int N, double Resolution) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = N;
        a[4] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(1454, a, box);
        return r;
    }
    public static long 构造_3(int N, double Resolution) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = N;
        a[2] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(1455, a, box);
        return r;
    }
    public static void SetParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        OcctGen.occtCall(1456, a, box);
    }
    public static void SetCurve(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(1457, a, box);
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1458, a, box);
        return r;
    }
    public static long D1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1459, a, box);
        return r;
    }
    public static long D2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1460, a, box);
        return r;
    }
    public static long D3(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1461, a, box);
        return r;
    }
    public static boolean IsTangentDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1462, a, box);
        return r != 0;
    }
    public static void Tangent(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(1463, a, box);
    }
    public static double Curvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1464, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Normal(long self, long N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(1465, a, box);
    }
    public static void CentreOfCurvature(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(1466, a, box);
    }
    }

    public static final class BRepLProp_CurveTool {
        private BRepLProp_CurveTool() {}

    public static void Value(long C, double U, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        OcctGen.occtCall(1467, a, box);
    }
    public static void D1(long C, double U, long P, long V1) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        a[4] = V1;
        OcctGen.occtCall(1468, a, box);
    }
    public static void D2(long C, double U, long P, long V1, long V2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        a[4] = V1;
        a[5] = V2;
        OcctGen.occtCall(1469, a, box);
    }
    public static void D3(long C, double U, long P, long V1, long V2, long V3) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        a[4] = V1;
        a[5] = V2;
        a[6] = V3;
        OcctGen.occtCall(1470, a, box);
    }
    public static int Continuity(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(1471, a, box);
        return (int) r;
    }
    public static double FirstParameter(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(1472, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(1473, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepLProp_SLProps {
        private BRepLProp_SLProps() {}

    public static long 构造(long S, double U, double V, int N, double Resolution) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = N;
        a[5] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(1474, a, box);
        return r;
    }
    public static long 构造_2(long S, int N, double Resolution) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = N;
        a[3] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(1475, a, box);
        return r;
    }
    public static long 构造_3(int N, double Resolution) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = N;
        a[2] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(1476, a, box);
        return r;
    }
    public static void SetSurface(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1477, a, box);
    }
    public static void SetParameters(long self, double U, double V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        OcctGen.occtCall(1478, a, box);
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1479, a, box);
        return r;
    }
    public static long D1U(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1480, a, box);
        return r;
    }
    public static long D1V(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1481, a, box);
        return r;
    }
    public static long D2U(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1482, a, box);
        return r;
    }
    public static long D2V(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1483, a, box);
        return r;
    }
    public static long DUV(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1484, a, box);
        return r;
    }
    public static boolean IsTangentUDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1485, a, box);
        return r != 0;
    }
    public static void TangentU(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(1486, a, box);
    }
    public static boolean IsTangentVDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1487, a, box);
        return r != 0;
    }
    public static void TangentV(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(1488, a, box);
    }
    public static boolean IsNormalDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1489, a, box);
        return r != 0;
    }
    public static long Normal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1490, a, box);
        return r;
    }
    public static boolean IsCurvatureDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1491, a, box);
        return r != 0;
    }
    public static boolean IsUmbilic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1492, a, box);
        return r != 0;
    }
    public static double MaxCurvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1493, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinCurvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1494, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void CurvatureDirections(long self, long MaxD, long MinD) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = MaxD;
        a[2] = MinD;
        OcctGen.occtCall(1495, a, box);
    }
    public static double MeanCurvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1496, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double GaussianCurvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1497, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepLProp_SurfaceTool {
        private BRepLProp_SurfaceTool() {}

    public static void Value(long S, double U, double V, long P) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = P;
        OcctGen.occtCall(1498, a, box);
    }
    public static void D1(long S, double U, double V, long P, long D1U, long D1V) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = P;
        a[5] = D1U;
        a[6] = D1V;
        OcctGen.occtCall(1499, a, box);
    }
    public static void D2(
            long S, double U, double V, long P, long D1U, long D1V, long D2U, long D2V, long DUV) {
        long[] a = new long[10];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = P;
        a[5] = D1U;
        a[6] = D1V;
        a[7] = D2U;
        a[8] = D2V;
        a[9] = DUV;
        OcctGen.occtCall(1500, a, box);
    }
    public static long DN(long S, double U, double V, int IU, int IV) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = IU;
        a[5] = IV;
        long r = OcctGen.occtCall(1501, a, box);
        return r;
    }
    public static int Continuity(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(1502, a, box);
        return (int) r;
    }
    public static void Bounds(
            long S, double[] U1Out, double[] V1Out, double[] U2Out, double[] V2Out) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        OcctGen.occtCall(1503, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[4]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[5]);
    }
    }

    public static final class BRepTools {
        private BRepTools() {}

    public static void UVBounds(
            long F, double[] UMinOut, double[] UMaxOut, double[] VMinOut, double[] VMaxOut) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = F;
        OcctGen.occtCall(1785, a, box);
        if (UMinOut != null && UMinOut.length != 0) UMinOut[0] = Double.longBitsToDouble(a[2]);
        if (UMaxOut != null && UMaxOut.length != 0) UMaxOut[0] = Double.longBitsToDouble(a[3]);
        if (VMinOut != null && VMinOut.length != 0) VMinOut[0] = Double.longBitsToDouble(a[4]);
        if (VMaxOut != null && VMaxOut.length != 0) VMaxOut[0] = Double.longBitsToDouble(a[5]);
    }
    public static void UVBounds_2(
            long F, long W, double[] UMinOut, double[] UMaxOut, double[] VMinOut, double[] VMaxOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = F;
        a[2] = W;
        OcctGen.occtCall(1786, a, box);
        if (UMinOut != null && UMinOut.length != 0) UMinOut[0] = Double.longBitsToDouble(a[3]);
        if (UMaxOut != null && UMaxOut.length != 0) UMaxOut[0] = Double.longBitsToDouble(a[4]);
        if (VMinOut != null && VMinOut.length != 0) VMinOut[0] = Double.longBitsToDouble(a[5]);
        if (VMaxOut != null && VMaxOut.length != 0) VMaxOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static void UVBounds_3(
            long F, long E, double[] UMinOut, double[] UMaxOut, double[] VMinOut, double[] VMaxOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = F;
        a[2] = E;
        OcctGen.occtCall(1787, a, box);
        if (UMinOut != null && UMinOut.length != 0) UMinOut[0] = Double.longBitsToDouble(a[3]);
        if (UMaxOut != null && UMaxOut.length != 0) UMaxOut[0] = Double.longBitsToDouble(a[4]);
        if (VMinOut != null && VMinOut.length != 0) VMinOut[0] = Double.longBitsToDouble(a[5]);
        if (VMaxOut != null && VMaxOut.length != 0) VMaxOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static void AddUVBounds(long F, long B) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = F;
        a[2] = B;
        OcctGen.occtCall(1788, a, box);
    }
    public static void AddUVBounds_2(long F, long W, long B) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = F;
        a[2] = W;
        a[3] = B;
        OcctGen.occtCall(1789, a, box);
    }
    public static void AddUVBounds_3(long F, long E, long B) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = F;
        a[2] = E;
        a[3] = B;
        OcctGen.occtCall(1790, a, box);
    }
    public static void Update(long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = V;
        OcctGen.occtCall(1791, a, box);
    }
    public static void Update_2(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        OcctGen.occtCall(1792, a, box);
    }
    public static void Update_3(long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = W;
        OcctGen.occtCall(1793, a, box);
    }
    public static void Update_4(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        OcctGen.occtCall(1794, a, box);
    }
    public static void Update_5(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        OcctGen.occtCall(1795, a, box);
    }
    public static void Update_6(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        OcctGen.occtCall(1796, a, box);
    }
    public static void Update_7(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        OcctGen.occtCall(1797, a, box);
    }
    public static void Update_8(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        OcctGen.occtCall(1798, a, box);
    }
    public static void Update_9(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        OcctGen.occtCall(1799, a, box);
    }
    public static void UpdateFaceUVPoints(long theF) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theF;
        OcctGen.occtCall(1800, a, box);
    }
    public static void Clean(long theShape, boolean theForce) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theShape;
        a[2] = theForce ? 1L : 0L;
        OcctGen.occtCall(1801, a, box);
    }
    public static void CleanGeometry(long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theShape;
        OcctGen.occtCall(1802, a, box);
    }
    public static void RemoveUnusedPCurves(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        OcctGen.occtCall(1803, a, box);
    }
    public static boolean Triangulation(
            long theShape, double theLinDefl, boolean theToCheckFreeEdges) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theShape;
        a[2] = Double.doubleToRawLongBits(theLinDefl);
        a[3] = theToCheckFreeEdges ? 1L : 0L;
        long r = OcctGen.occtCall(1804, a, box);
        return r != 0;
    }
    public static boolean LoadTriangulation(
            long theShape, int theTriangulationIdx, boolean theToSetAsActive) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theShape;
        a[2] = theTriangulationIdx;
        a[3] = theToSetAsActive ? 1L : 0L;
        long r = OcctGen.occtCall(1805, a, box);
        return r != 0;
    }
    public static boolean UnloadTriangulation(long theShape, int theTriangulationIdx) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theShape;
        a[2] = theTriangulationIdx;
        long r = OcctGen.occtCall(1806, a, box);
        return r != 0;
    }
    public static boolean ActivateTriangulation(
            long theShape, int theTriangulationIdx, boolean theToActivateStrictly) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theShape;
        a[2] = theTriangulationIdx;
        a[3] = theToActivateStrictly ? 1L : 0L;
        long r = OcctGen.occtCall(1807, a, box);
        return r != 0;
    }
    public static boolean LoadAllTriangulations(long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theShape;
        long r = OcctGen.occtCall(1808, a, box);
        return r != 0;
    }
    public static boolean UnloadAllTriangulations(long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theShape;
        long r = OcctGen.occtCall(1809, a, box);
        return r != 0;
    }
    public static boolean Compare(long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = V1;
        a[2] = V2;
        long r = OcctGen.occtCall(1810, a, box);
        return r != 0;
    }
    public static boolean Compare_2(long E1, long E2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        long r = OcctGen.occtCall(1811, a, box);
        return r != 0;
    }
    public static long OuterWire(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        long r = OcctGen.occtCall(1812, a, box);
        return r;
    }
    public static boolean IsReallyClosed(long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        long r = OcctGen.occtCall(1813, a, box);
        return r != 0;
    }
    public static void DetectClosedness(
            long theFace, boolean[] theUclosedOut, boolean[] theVclosedOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theFace;
        OcctGen.occtCall(1814, a, box);
        if (theUclosedOut != null && theUclosedOut.length != 0) theUclosedOut[0] = a[2] != 0;
        if (theVclosedOut != null && theVclosedOut.length != 0) theVclosedOut[0] = a[3] != 0;
    }
    public static String Dump(long Sh) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[1] = Sh;
        OcctGen.occtCall(1815, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void Write(long theShape, String theStream) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[1] = theShape;
        box[2] = theStream;
        OcctGen.occtCall(1816, a, box);
    }
    public static void Write_2(
            long theShape, String theStream, boolean theWithTriangles, boolean theWithNormals,
            int theVersion) {
        long[] a = new long[6];
        Object[] box = new Object[6];
        a[1] = theShape;
        box[2] = theStream;
        a[3] = theWithTriangles ? 1L : 0L;
        a[4] = theWithNormals ? 1L : 0L;
        a[5] = theVersion;
        OcctGen.occtCall(1817, a, box);
    }
    public static void Read(long Sh, String S, long B) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[1] = Sh;
        box[2] = S;
        a[3] = B;
        OcctGen.occtCall(1818, a, box);
    }
    public static boolean Write_3(long theShape, String theFile) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[1] = theShape;
        box[2] = theFile;
        long r = OcctGen.occtCall(1819, a, box);
        return r != 0;
    }
    public static boolean Write_4(
            long theShape, String theFile, boolean theWithTriangles, boolean theWithNormals,
            int theVersion) {
        long[] a = new long[6];
        Object[] box = new Object[6];
        a[1] = theShape;
        box[2] = theFile;
        a[3] = theWithTriangles ? 1L : 0L;
        a[4] = theWithNormals ? 1L : 0L;
        a[5] = theVersion;
        long r = OcctGen.occtCall(1820, a, box);
        return r != 0;
    }
    public static boolean Read_2(long Sh, String File, long B) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[1] = Sh;
        box[2] = File;
        a[3] = B;
        long r = OcctGen.occtCall(1821, a, box);
        return r != 0;
    }
    public static double EvalAndUpdateTol(
            long theE, long theC3d, long theC2d, long theS, double theF, double theL) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = theE;
        a[2] = theC3d;
        a[3] = theC2d;
        a[4] = theS;
        a[5] = Double.doubleToRawLongBits(theF);
        a[6] = Double.doubleToRawLongBits(theL);
        long r = OcctGen.occtCall(1822, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int OriEdgeInFace(long theEdge, long theFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theEdge;
        a[2] = theFace;
        long r = OcctGen.occtCall(1823, a, box);
        return (int) r;
    }
    public static void RemoveInternals(long theS, boolean theForce) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theS;
        a[2] = theForce ? 1L : 0L;
        OcctGen.occtCall(1824, a, box);
    }
    }

    public static final class BRepTools_History {
        private BRepTools_History() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1825, a, box);
        return r;
    }
    public static boolean IsSupportedType(long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theShape;
        long r = OcctGen.occtCall(1826, a, box);
        return r != 0;
    }
    public static void AddGenerated(long self, long theInitial, long theGenerated) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theInitial;
        a[2] = theGenerated;
        OcctGen.occtCall(1827, a, box);
    }
    public static void AddModified(long self, long theInitial, long theModified) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theInitial;
        a[2] = theModified;
        OcctGen.occtCall(1828, a, box);
    }
    public static void Remove(long self, long theRemoved) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRemoved;
        OcctGen.occtCall(1829, a, box);
    }
    public static void ReplaceGenerated(long self, long theInitial, long theGenerated) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theInitial;
        a[2] = theGenerated;
        OcctGen.occtCall(1830, a, box);
    }
    public static void ReplaceModified(long self, long theInitial, long theModified) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theInitial;
        a[2] = theModified;
        OcctGen.occtCall(1831, a, box);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1832, a, box);
    }
    public static boolean IsRemoved(long self, long theInitial) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theInitial;
        long r = OcctGen.occtCall(1833, a, box);
        return r != 0;
    }
    public static boolean HasGenerated(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1834, a, box);
        return r != 0;
    }
    public static boolean HasModified(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1835, a, box);
        return r != 0;
    }
    public static boolean HasRemoved(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1836, a, box);
        return r != 0;
    }
    public static void Merge(long self, long theHistory23) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theHistory23;
        OcctGen.occtCall(1837, a, box);
    }
    public static void Merge_2(long self, long theHistory23) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theHistory23;
        OcctGen.occtCall(1838, a, box);
    }
    public static String Dump(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(1839, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class BRepTools_Modifier {
        private BRepTools_Modifier() {}

    public static long 构造(boolean theMutableInput) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theMutableInput ? 1L : 0L;
        long r = OcctGen.occtCall(1840, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(1841, a, box);
        return r;
    }
    public static void Init(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1842, a, box);
    }
    public static void Perform(long self, long M) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = M;
        OcctGen.occtCall(1843, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1844, a, box);
        return r != 0;
    }
    public static boolean IsMutableInput(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1845, a, box);
        return r != 0;
    }
    public static void SetMutableInput(long self, boolean theMutableInput) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theMutableInput ? 1L : 0L;
        OcctGen.occtCall(1846, a, box);
    }
    public static long ModifiedShape(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(1847, a, box);
        return r;
    }
    }

    public static final class BRepTools_ReShape {
        private BRepTools_ReShape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1848, a, box);
        return r;
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1849, a, box);
    }
    public static void Remove(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        OcctGen.occtCall(1850, a, box);
    }
    public static void Replace(long self, long shape, long newshape) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        a[2] = newshape;
        OcctGen.occtCall(1851, a, box);
    }
    public static boolean IsRecorded(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(1852, a, box);
        return r != 0;
    }
    public static long Value(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(1853, a, box);
        return r;
    }
    public static int Status(long self, long shape, long newsh, boolean last) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        a[2] = newsh;
        a[3] = last ? 1L : 0L;
        long r = OcctGen.occtCall(1854, a, box);
        return (int) r;
    }
    public static long Apply(long self, long theShape, int theUntil) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        a[2] = theUntil;
        long r = OcctGen.occtCall(1855, a, box);
        return r;
    }
    public static boolean ModeConsiderLocation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1856, a, box);
        return r != 0;
    }
    public static long CopyVertex(long self, long theV, double theTol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        a[2] = Double.doubleToRawLongBits(theTol);
        long r = OcctGen.occtCall(1857, a, box);
        return r;
    }
    public static long CopyVertex_2(long self, long theV, long theNewPos, double aTol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        a[2] = theNewPos;
        a[3] = Double.doubleToRawLongBits(aTol);
        long r = OcctGen.occtCall(1858, a, box);
        return r;
    }
    public static boolean IsNewShape(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        long r = OcctGen.occtCall(1859, a, box);
        return r != 0;
    }
    public static long History(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1860, a, box);
        return r;
    }
    }

    public static final class BRepTools_ShapeSet {
        private BRepTools_ShapeSet() {}

    public static long 构造(boolean theWithTriangles, boolean theWithNormals) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theWithTriangles ? 1L : 0L;
        a[2] = theWithNormals ? 1L : 0L;
        long r = OcctGen.occtCall(1861, a, box);
        return r;
    }
    public static long 构造_2(long theBuilder, boolean theWithTriangles, boolean theWithNormals) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theBuilder;
        a[2] = theWithTriangles ? 1L : 0L;
        a[3] = theWithNormals ? 1L : 0L;
        long r = OcctGen.occtCall(1862, a, box);
        return r;
    }
    public static boolean IsWithTriangles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1863, a, box);
        return r != 0;
    }
    public static boolean IsWithNormals(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1864, a, box);
        return r != 0;
    }
    public static void SetWithTriangles(long self, boolean theWithTriangles) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theWithTriangles ? 1L : 0L;
        OcctGen.occtCall(1865, a, box);
    }
    public static void SetWithNormals(long self, boolean theWithNormals) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theWithNormals ? 1L : 0L;
        OcctGen.occtCall(1866, a, box);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1867, a, box);
    }
    public static void AddGeometry(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1868, a, box);
    }
    public static String DumpGeometry(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(1869, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void WriteGeometry(long self, String OS) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = OS;
        OcctGen.occtCall(1870, a, box);
    }
    public static void ReadGeometry(long self, String IS) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = IS;
        OcctGen.occtCall(1871, a, box);
    }
    public static String DumpGeometry_2(long self, long S) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1872, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String WriteGeometry_2(long self, long S) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1873, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void AddShapes(long self, long S1, long S2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S1;
        a[2] = S2;
        OcctGen.occtCall(1874, a, box);
    }
    public static void Check(long self, int T, long S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        a[2] = S;
        OcctGen.occtCall(1875, a, box);
    }
    public static void ReadPolygon3D(long self, String IS) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = IS;
        OcctGen.occtCall(1876, a, box);
    }
    public static void WritePolygon3D(long self, String OS, boolean Compact) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = OS;
        a[2] = Compact ? 1L : 0L;
        OcctGen.occtCall(1877, a, box);
    }
    public static String DumpPolygon3D(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(1878, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void ReadTriangulation(long self, String IS) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = IS;
        OcctGen.occtCall(1879, a, box);
    }
    public static void WriteTriangulation(long self, String OS, boolean Compact) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = OS;
        a[2] = Compact ? 1L : 0L;
        OcctGen.occtCall(1880, a, box);
    }
    public static String DumpTriangulation(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(1881, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void ReadPolygonOnTriangulation(long self, String IS) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = IS;
        OcctGen.occtCall(1882, a, box);
    }
    public static void WritePolygonOnTriangulation(long self, String OS, boolean Compact) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = OS;
        a[2] = Compact ? 1L : 0L;
        OcctGen.occtCall(1883, a, box);
    }
    public static String DumpPolygonOnTriangulation(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(1884, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class BRepTools_WireExplorer {
        private BRepTools_WireExplorer() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1885, a, box);
        return r;
    }
    public static long 构造_2(long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = W;
        long r = OcctGen.occtCall(1886, a, box);
        return r;
    }
    public static long 构造_3(long W, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = W;
        a[2] = F;
        long r = OcctGen.occtCall(1887, a, box);
        return r;
    }
    public static void Init(long self, long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        OcctGen.occtCall(1888, a, box);
    }
    public static void Init_2(long self, long W, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        a[2] = F;
        OcctGen.occtCall(1889, a, box);
    }
    public static void Init_3(
            long self, long W, long F, double UMin, double UMax, double VMin, double VMax) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        a[2] = F;
        a[3] = Double.doubleToRawLongBits(UMin);
        a[4] = Double.doubleToRawLongBits(UMax);
        a[5] = Double.doubleToRawLongBits(VMin);
        a[6] = Double.doubleToRawLongBits(VMax);
        OcctGen.occtCall(1890, a, box);
    }
    public static boolean More(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1891, a, box);
        return r != 0;
    }
    public static void Next(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1892, a, box);
    }
    public static long Current(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1893, a, box);
        return r;
    }
    public static int Orientation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1894, a, box);
        return (int) r;
    }
    public static long CurrentVertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1895, a, box);
        return r;
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1896, a, box);
    }
    }

    public static final class BRep_Builder {
        private BRep_Builder() {}

    public static void MakeFace(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        OcctGen.occtCall(1948, a, box);
    }
    public static void MakeFace_2(long self, long F, long S, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = S;
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1949, a, box);
    }
    public static void MakeFace_3(long self, long F, long S, long L, double Tol) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = S;
        a[3] = L;
        a[4] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1950, a, box);
    }
    public static void MakeFace_4(long self, long theFace, long theTriangulation) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theFace;
        a[2] = theTriangulation;
        OcctGen.occtCall(1951, a, box);
    }
    public static void UpdateFace(long self, long F, long S, long L, double Tol) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = S;
        a[3] = L;
        a[4] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1952, a, box);
    }
    public static void UpdateFace_2(
            long self, long theFace, long theTriangulation, boolean theToReset) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theFace;
        a[2] = theTriangulation;
        a[3] = theToReset ? 1L : 0L;
        OcctGen.occtCall(1953, a, box);
    }
    public static void UpdateFace_3(long self, long F, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1954, a, box);
    }
    public static void NaturalRestriction(long self, long F, boolean N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = N ? 1L : 0L;
        OcctGen.occtCall(1955, a, box);
    }
    public static void MakeEdge(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(1956, a, box);
    }
    public static void MakeEdge_2(long self, long E, long C, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C;
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1957, a, box);
    }
    public static void MakeEdge_3(long self, long E, long C, long L, double Tol) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C;
        a[3] = L;
        a[4] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1958, a, box);
    }
    public static void MakeEdge_4(long self, long E, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = P;
        OcctGen.occtCall(1959, a, box);
    }
    public static void MakeEdge_5(long self, long E, long N, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = N;
        a[3] = T;
        OcctGen.occtCall(1960, a, box);
    }
    public static void MakeEdge_6(long self, long E, long N, long T, long L) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = N;
        a[3] = T;
        a[4] = L;
        OcctGen.occtCall(1961, a, box);
    }
    public static void UpdateEdge(long self, long E, long C, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C;
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1962, a, box);
    }
    public static void UpdateEdge_2(long self, long E, long C, long L, double Tol) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C;
        a[3] = L;
        a[4] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1963, a, box);
    }
    public static void UpdateEdge_3(long self, long E, long C, long F, double Tol) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C;
        a[3] = F;
        a[4] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1964, a, box);
    }
    public static void UpdateEdge_4(long self, long E, long C1, long C2, long F, double Tol) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C1;
        a[3] = C2;
        a[4] = F;
        a[5] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1965, a, box);
    }
    public static void UpdateEdge_5(long self, long E, long C, long S, long L, double Tol) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C;
        a[3] = S;
        a[4] = L;
        a[5] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1966, a, box);
    }
    public static void UpdateEdge_6(
            long self, long E, long C, long S, long L, double Tol, long Pf, long Pl) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C;
        a[3] = S;
        a[4] = L;
        a[5] = Double.doubleToRawLongBits(Tol);
        a[6] = Pf;
        a[7] = Pl;
        OcctGen.occtCall(1967, a, box);
    }
    public static void UpdateEdge_7(
            long self, long E, long C1, long C2, long S, long L, double Tol) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C1;
        a[3] = C2;
        a[4] = S;
        a[5] = L;
        a[6] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1968, a, box);
    }
    public static void UpdateEdge_8(
            long self, long E, long C1, long C2, long S, long L, double Tol, long Pf, long Pl) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = C1;
        a[3] = C2;
        a[4] = S;
        a[5] = L;
        a[6] = Double.doubleToRawLongBits(Tol);
        a[7] = Pf;
        a[8] = Pl;
        OcctGen.occtCall(1969, a, box);
    }
    public static void UpdateEdge_9(long self, long E, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = P;
        OcctGen.occtCall(1970, a, box);
    }
    public static void UpdateEdge_10(long self, long E, long P, long L) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = P;
        a[3] = L;
        OcctGen.occtCall(1971, a, box);
    }
    public static void UpdateEdge_11(long self, long E, long N, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = N;
        a[3] = T;
        OcctGen.occtCall(1972, a, box);
    }
    public static void UpdateEdge_12(long self, long E, long N, long T, long L) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = N;
        a[3] = T;
        a[4] = L;
        OcctGen.occtCall(1973, a, box);
    }
    public static void UpdateEdge_13(long self, long E, long N1, long N2, long T) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = N1;
        a[3] = N2;
        a[4] = T;
        OcctGen.occtCall(1974, a, box);
    }
    public static void UpdateEdge_14(long self, long E, long N1, long N2, long T, long L) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = N1;
        a[3] = N2;
        a[4] = T;
        a[5] = L;
        OcctGen.occtCall(1975, a, box);
    }
    public static void UpdateEdge_15(long self, long E, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1976, a, box);
    }
    public static void Continuity(long self, long E, long F1, long F2, int C) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F1;
        a[3] = F2;
        a[4] = C;
        OcctGen.occtCall(1977, a, box);
    }
    public static void Continuity_2(long self, long E, long S1, long S2, long L1, long L2, int C) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = S1;
        a[3] = S2;
        a[4] = L1;
        a[5] = L2;
        a[6] = C;
        OcctGen.occtCall(1978, a, box);
    }
    public static void SameParameter(long self, long E, boolean S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = S ? 1L : 0L;
        OcctGen.occtCall(1979, a, box);
    }
    public static void SameRange(long self, long E, boolean S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = S ? 1L : 0L;
        OcctGen.occtCall(1980, a, box);
    }
    public static void Degenerated(long self, long E, boolean D) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = D ? 1L : 0L;
        OcctGen.occtCall(1981, a, box);
    }
    public static void Range(long self, long E, double First, double Last, boolean Only3d) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = Double.doubleToRawLongBits(First);
        a[3] = Double.doubleToRawLongBits(Last);
        a[4] = Only3d ? 1L : 0L;
        OcctGen.occtCall(1982, a, box);
    }
    public static void Range_2(long self, long E, long S, long L, double First, double Last) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = S;
        a[3] = L;
        a[4] = Double.doubleToRawLongBits(First);
        a[5] = Double.doubleToRawLongBits(Last);
        OcctGen.occtCall(1983, a, box);
    }
    public static void Range_3(long self, long E, long F, double First, double Last) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F;
        a[3] = Double.doubleToRawLongBits(First);
        a[4] = Double.doubleToRawLongBits(Last);
        OcctGen.occtCall(1984, a, box);
    }
    public static void Transfert(long self, long Ein, long Eout) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Ein;
        a[2] = Eout;
        OcctGen.occtCall(1985, a, box);
    }
    public static void MakeVertex(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(1986, a, box);
    }
    public static void MakeVertex_2(long self, long V, long P, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1987, a, box);
    }
    public static void UpdateVertex(long self, long V, long P, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1988, a, box);
    }
    public static void UpdateVertex_2(long self, long V, double P, long E, double Tol) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        a[2] = Double.doubleToRawLongBits(P);
        a[3] = E;
        a[4] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1989, a, box);
    }
    public static void UpdateVertex_3(long self, long V, double P, long E, long F, double Tol) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        a[2] = Double.doubleToRawLongBits(P);
        a[3] = E;
        a[4] = F;
        a[5] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1990, a, box);
    }
    public static void UpdateVertex_4(
            long self, long V, double P, long E, long S, long L, double Tol) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        a[2] = Double.doubleToRawLongBits(P);
        a[3] = E;
        a[4] = S;
        a[5] = L;
        a[6] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1991, a, box);
    }
    public static void UpdateVertex_5(long self, long Ve, double U, double V, long F, double Tol) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Ve;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = F;
        a[5] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1992, a, box);
    }
    public static void UpdateVertex_6(long self, long V, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        a[2] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(1993, a, box);
    }
    public static void Transfert_2(long self, long Ein, long Eout, long Vin, long Vout) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Ein;
        a[2] = Eout;
        a[3] = Vin;
        a[4] = Vout;
        OcctGen.occtCall(1994, a, box);
    }
    }

    public static final class BRep_Tool {
        private BRep_Tool() {}

    public static boolean IsClosed(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(1995, a, box);
        return r != 0;
    }
    public static long Surface(long F, long L) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = F;
        a[2] = L;
        long r = OcctGen.occtCall(1996, a, box);
        return r;
    }
    public static long Surface_2(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        long r = OcctGen.occtCall(1997, a, box);
        return r;
    }
    public static long Triangulation(long theFace, long theLocation) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theFace;
        a[2] = theLocation;
        long r = OcctGen.occtCall(1998, a, box);
        return r;
    }
    public static double Tolerance(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        long r = OcctGen.occtCall(1999, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean NaturalRestriction(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        long r = OcctGen.occtCall(2000, a, box);
        return r != 0;
    }
    public static boolean IsGeometric(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        long r = OcctGen.occtCall(2001, a, box);
        return r != 0;
    }
    public static boolean IsGeometric_2(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(2002, a, box);
        return r != 0;
    }
    public static long Curve(long E, long L, double[] FirstOut, double[] LastOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = E;
        a[2] = L;
        long r = OcctGen.occtCall(2003, a, box);
        if (FirstOut != null && FirstOut.length != 0) FirstOut[0] = Double.longBitsToDouble(a[3]);
        if (LastOut != null && LastOut.length != 0) LastOut[0] = Double.longBitsToDouble(a[4]);
        return r;
    }
    public static long Curve_2(long E, double[] FirstOut, double[] LastOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(2004, a, box);
        if (FirstOut != null && FirstOut.length != 0) FirstOut[0] = Double.longBitsToDouble(a[2]);
        if (LastOut != null && LastOut.length != 0) LastOut[0] = Double.longBitsToDouble(a[3]);
        return r;
    }
    public static long Polygon3D(long E, long L) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = L;
        long r = OcctGen.occtCall(2005, a, box);
        return r;
    }
    public static long CurveOnPlane(long E, long S, long L, double[] FirstOut, double[] LastOut) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = E;
        a[2] = S;
        a[3] = L;
        long r = OcctGen.occtCall(2006, a, box);
        if (FirstOut != null && FirstOut.length != 0) FirstOut[0] = Double.longBitsToDouble(a[4]);
        if (LastOut != null && LastOut.length != 0) LastOut[0] = Double.longBitsToDouble(a[5]);
        return r;
    }
    public static void CurveOnSurface(
            long E, long[] COut, long[] SOut, long L, double[] FirstOut, double[] LastOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = E;
        a[4] = L;
        OcctGen.occtCall(2007, a, box);
        if (COut != null && COut.length != 0) COut[0] = a[2];
        if (SOut != null && SOut.length != 0) SOut[0] = a[3];
        if (FirstOut != null && FirstOut.length != 0) FirstOut[0] = Double.longBitsToDouble(a[5]);
        if (LastOut != null && LastOut.length != 0) LastOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static void CurveOnSurface_2(
            long E, long[] COut, long[] SOut, long L, double[] FirstOut, double[] LastOut,
            int Index) {
        long[] a = new long[8];
        Object[] box = null;
        a[1] = E;
        a[4] = L;
        a[7] = Index;
        OcctGen.occtCall(2008, a, box);
        if (COut != null && COut.length != 0) COut[0] = a[2];
        if (SOut != null && SOut.length != 0) SOut[0] = a[3];
        if (FirstOut != null && FirstOut.length != 0) FirstOut[0] = Double.longBitsToDouble(a[5]);
        if (LastOut != null && LastOut.length != 0) LastOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static long PolygonOnTriangulation(long E, long T, long L) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E;
        a[2] = T;
        a[3] = L;
        long r = OcctGen.occtCall(2009, a, box);
        return r;
    }
    public static void PolygonOnTriangulation_2(long E, long[] POut, long[] TOut, long L) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = E;
        a[4] = L;
        OcctGen.occtCall(2010, a, box);
        if (POut != null && POut.length != 0) POut[0] = a[2];
        if (TOut != null && TOut.length != 0) TOut[0] = a[3];
    }
    public static void PolygonOnTriangulation_3(
            long E, long[] POut, long[] TOut, long L, int Index) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = E;
        a[4] = L;
        a[5] = Index;
        OcctGen.occtCall(2011, a, box);
        if (POut != null && POut.length != 0) POut[0] = a[2];
        if (TOut != null && TOut.length != 0) TOut[0] = a[3];
    }
    public static boolean IsClosed_2(long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        long r = OcctGen.occtCall(2012, a, box);
        return r != 0;
    }
    public static boolean IsClosed_3(long E, long S, long L) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E;
        a[2] = S;
        a[3] = L;
        long r = OcctGen.occtCall(2013, a, box);
        return r != 0;
    }
    public static boolean IsClosed_4(long E, long T, long L) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E;
        a[2] = T;
        a[3] = L;
        long r = OcctGen.occtCall(2014, a, box);
        return r != 0;
    }
    public static double Tolerance_2(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(2015, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean SameParameter(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(2016, a, box);
        return r != 0;
    }
    public static boolean SameRange(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(2017, a, box);
        return r != 0;
    }
    public static boolean Degenerated(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(2018, a, box);
        return r != 0;
    }
    public static void Range(long E, double[] FirstOut, double[] LastOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E;
        OcctGen.occtCall(2019, a, box);
        if (FirstOut != null && FirstOut.length != 0) FirstOut[0] = Double.longBitsToDouble(a[2]);
        if (LastOut != null && LastOut.length != 0) LastOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static void Range_2(long E, long S, long L, double[] FirstOut, double[] LastOut) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = E;
        a[2] = S;
        a[3] = L;
        OcctGen.occtCall(2020, a, box);
        if (FirstOut != null && FirstOut.length != 0) FirstOut[0] = Double.longBitsToDouble(a[4]);
        if (LastOut != null && LastOut.length != 0) LastOut[0] = Double.longBitsToDouble(a[5]);
    }
    public static void Range_3(long E, long F, double[] FirstOut, double[] LastOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        OcctGen.occtCall(2021, a, box);
        if (FirstOut != null && FirstOut.length != 0) FirstOut[0] = Double.longBitsToDouble(a[3]);
        if (LastOut != null && LastOut.length != 0) LastOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static void UVPoints(long E, long S, long L, long PFirst, long PLast) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = E;
        a[2] = S;
        a[3] = L;
        a[4] = PFirst;
        a[5] = PLast;
        OcctGen.occtCall(2022, a, box);
    }
    public static void UVPoints_2(long E, long F, long PFirst, long PLast) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        a[3] = PFirst;
        a[4] = PLast;
        OcctGen.occtCall(2023, a, box);
    }
    public static void SetUVPoints(long E, long S, long L, long PFirst, long PLast) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = E;
        a[2] = S;
        a[3] = L;
        a[4] = PFirst;
        a[5] = PLast;
        OcctGen.occtCall(2024, a, box);
    }
    public static void SetUVPoints_2(long E, long F, long PFirst, long PLast) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        a[3] = PFirst;
        a[4] = PLast;
        OcctGen.occtCall(2025, a, box);
    }
    public static boolean HasContinuity(long E, long F1, long F2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E;
        a[2] = F1;
        a[3] = F2;
        long r = OcctGen.occtCall(2026, a, box);
        return r != 0;
    }
    public static int Continuity(long E, long F1, long F2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E;
        a[2] = F1;
        a[3] = F2;
        long r = OcctGen.occtCall(2027, a, box);
        return (int) r;
    }
    public static boolean HasContinuity_2(long E, long S1, long S2, long L1, long L2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = E;
        a[2] = S1;
        a[3] = S2;
        a[4] = L1;
        a[5] = L2;
        long r = OcctGen.occtCall(2028, a, box);
        return r != 0;
    }
    public static int Continuity_2(long E, long S1, long S2, long L1, long L2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = E;
        a[2] = S1;
        a[3] = S2;
        a[4] = L1;
        a[5] = L2;
        long r = OcctGen.occtCall(2029, a, box);
        return (int) r;
    }
    public static boolean HasContinuity_3(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(2030, a, box);
        return r != 0;
    }
    public static int MaxContinuity(long theEdge) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theEdge;
        long r = OcctGen.occtCall(2031, a, box);
        return (int) r;
    }
    public static long Pnt(long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = V;
        long r = OcctGen.occtCall(2032, a, box);
        return r;
    }
    public static double Tolerance_3(long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = V;
        long r = OcctGen.occtCall(2033, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean Parameter(long theV, long theE, double[] theParamOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theV;
        a[2] = theE;
        long r = OcctGen.occtCall(2034, a, box);
        if (theParamOut != null && theParamOut.length != 0) theParamOut[0] = Double.longBitsToDouble(a[3]);
        return r != 0;
    }
    public static double Parameter_2(long V, long E) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = V;
        a[2] = E;
        long r = OcctGen.occtCall(2035, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter_3(long V, long E, long F) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = V;
        a[2] = E;
        a[3] = F;
        long r = OcctGen.occtCall(2036, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter_4(long V, long E, long S, long L) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = V;
        a[2] = E;
        a[3] = S;
        a[4] = L;
        long r = OcctGen.occtCall(2037, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Parameters(long V, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = V;
        a[2] = F;
        long r = OcctGen.occtCall(2038, a, box);
        return r;
    }
    public static double MaxTolerance(long theShape, int theSubShape) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theShape;
        a[2] = theSubShape;
        long r = OcctGen.occtCall(2039, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class TopExp {
        private TopExp() {}

    public static long FirstVertex(long E, boolean CumOri) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = CumOri ? 1L : 0L;
        long r = OcctGen.occtCall(4813, a, box);
        return r;
    }
    public static long LastVertex(long E, boolean CumOri) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = CumOri ? 1L : 0L;
        long r = OcctGen.occtCall(4814, a, box);
        return r;
    }
    public static void Vertices(long E, long Vfirst, long Vlast, boolean CumOri) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = E;
        a[2] = Vfirst;
        a[3] = Vlast;
        a[4] = CumOri ? 1L : 0L;
        OcctGen.occtCall(4815, a, box);
    }
    public static void Vertices_2(long W, long Vfirst, long Vlast) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = W;
        a[2] = Vfirst;
        a[3] = Vlast;
        OcctGen.occtCall(4816, a, box);
    }
    public static boolean CommonVertex(long E1, long E2, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        a[3] = V;
        long r = OcctGen.occtCall(4817, a, box);
        return r != 0;
    }
    }

    public static final class TopExp_Explorer {
        private TopExp_Explorer() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4818, a, box);
        return r;
    }
    public static long 构造_2(long S, int ToFind, int ToAvoid) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = ToFind;
        a[3] = ToAvoid;
        long r = OcctGen.occtCall(4819, a, box);
        return r;
    }
    public static void Init(long self, long S, int ToFind, int ToAvoid) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = ToFind;
        a[3] = ToAvoid;
        OcctGen.occtCall(4820, a, box);
    }
    public static boolean More(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4821, a, box);
        return r != 0;
    }
    public static void Next(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4822, a, box);
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4823, a, box);
        return r;
    }
    public static long Current(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4824, a, box);
        return r;
    }
    public static void ReInit(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4825, a, box);
    }
    public static long ExploredShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4826, a, box);
        return r;
    }
    public static int Depth(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4827, a, box);
        return (int) r;
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4828, a, box);
    }
    }

    public static final class TopoDS {
        private TopoDS() {}

    public static long Vertex(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4849, a, box);
        return r;
    }
    public static long Vertex_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4850, a, box);
        return r;
    }
    public static long Edge(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4851, a, box);
        return r;
    }
    public static long Edge_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4852, a, box);
        return r;
    }
    public static long Wire(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4853, a, box);
        return r;
    }
    public static long Wire_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4854, a, box);
        return r;
    }
    public static long Face(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4855, a, box);
        return r;
    }
    public static long Face_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4856, a, box);
        return r;
    }
    public static long Shell(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4857, a, box);
        return r;
    }
    public static long Shell_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4858, a, box);
        return r;
    }
    public static long Solid(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4859, a, box);
        return r;
    }
    public static long Solid_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4860, a, box);
        return r;
    }
    public static long CompSolid(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4861, a, box);
        return r;
    }
    public static long CompSolid_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4862, a, box);
        return r;
    }
    public static long Compound(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4863, a, box);
        return r;
    }
    public static long Compound_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4864, a, box);
        return r;
    }
    }

    public static final class TopoDS_Builder {
        private TopoDS_Builder() {}

    public static void MakeWire(long self, long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        OcctGen.occtCall(4865, a, box);
    }
    public static void MakeShell(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(4866, a, box);
    }
    public static void MakeSolid(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(4867, a, box);
    }
    public static void MakeCompSolid(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(4868, a, box);
    }
    public static void MakeCompound(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(4869, a, box);
    }
    public static void Add(long self, long S, long C) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = C;
        OcctGen.occtCall(4870, a, box);
    }
    public static void Remove(long self, long S, long C) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = C;
        OcctGen.occtCall(4871, a, box);
    }
    }

    public static final class TopoDS_CompSolid {
        private TopoDS_CompSolid() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4872, a, box);
        return r;
    }
    }

    public static final class TopoDS_Compound {
        private TopoDS_Compound() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4873, a, box);
        return r;
    }
    }

    public static final class TopoDS_Edge {
        private TopoDS_Edge() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4874, a, box);
        return r;
    }
    }

    public static final class TopoDS_Face {
        private TopoDS_Face() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4875, a, box);
        return r;
    }
    }

    public static final class TopoDS_HShape {
        private TopoDS_HShape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4876, a, box);
        return r;
    }
    public static long 构造_2(long aShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = aShape;
        long r = OcctGen.occtCall(4877, a, box);
        return r;
    }
    public static void Shape(long self, long aShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = aShape;
        OcctGen.occtCall(4878, a, box);
    }
    public static long Shape_2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4879, a, box);
        return r;
    }
    public static long ChangeShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4880, a, box);
        return r;
    }
    }

    public static final class TopoDS_Iterator {
        private TopoDS_Iterator() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4881, a, box);
        return r;
    }
    public static long 构造_2(long S, boolean cumOri, boolean cumLoc) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = cumOri ? 1L : 0L;
        a[3] = cumLoc ? 1L : 0L;
        long r = OcctGen.occtCall(4882, a, box);
        return r;
    }
    public static void Initialize(long self, long S, boolean cumOri, boolean cumLoc) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = cumOri ? 1L : 0L;
        a[3] = cumLoc ? 1L : 0L;
        OcctGen.occtCall(4883, a, box);
    }
    public static boolean More(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4884, a, box);
        return r != 0;
    }
    public static void Next(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4885, a, box);
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4886, a, box);
        return r;
    }
    }

    public static final class TopoDS_Shape {
        private TopoDS_Shape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4887, a, box);
        return r;
    }
    public static boolean IsNull(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4888, a, box);
        return r != 0;
    }
    public static void Nullify(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4889, a, box);
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4890, a, box);
        return r;
    }
    public static void Location_2(long self, long theLoc, boolean theRaiseExc) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theLoc;
        a[2] = theRaiseExc ? 1L : 0L;
        OcctGen.occtCall(4891, a, box);
    }
    public static long Located(long self, long theLoc, boolean theRaiseExc) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theLoc;
        a[2] = theRaiseExc ? 1L : 0L;
        long r = OcctGen.occtCall(4892, a, box);
        return r;
    }
    public static int Orientation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4893, a, box);
        return (int) r;
    }
    public static void Orientation_2(long self, int theOrient) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOrient;
        OcctGen.occtCall(4894, a, box);
    }
    public static long Oriented(long self, int theOrient) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOrient;
        long r = OcctGen.occtCall(4895, a, box);
        return r;
    }
    public static int ShapeType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4896, a, box);
        return (int) r;
    }
    public static boolean Free(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4897, a, box);
        return r != 0;
    }
    public static void Free_2(long self, boolean theIsFree) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsFree ? 1L : 0L;
        OcctGen.occtCall(4898, a, box);
    }
    public static boolean Locked(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4899, a, box);
        return r != 0;
    }
    public static void Locked_2(long self, boolean theIsLocked) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsLocked ? 1L : 0L;
        OcctGen.occtCall(4900, a, box);
    }
    public static boolean Modified(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4901, a, box);
        return r != 0;
    }
    public static void Modified_2(long self, boolean theIsModified) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsModified ? 1L : 0L;
        OcctGen.occtCall(4902, a, box);
    }
    public static boolean Checked(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4903, a, box);
        return r != 0;
    }
    public static void Checked_2(long self, boolean theIsChecked) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsChecked ? 1L : 0L;
        OcctGen.occtCall(4904, a, box);
    }
    public static boolean Orientable(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4905, a, box);
        return r != 0;
    }
    public static void Orientable_2(long self, boolean theIsOrientable) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsOrientable ? 1L : 0L;
        OcctGen.occtCall(4906, a, box);
    }
    public static boolean Closed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4907, a, box);
        return r != 0;
    }
    public static void Closed_2(long self, boolean theIsClosed) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsClosed ? 1L : 0L;
        OcctGen.occtCall(4908, a, box);
    }
    public static boolean Infinite(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4909, a, box);
        return r != 0;
    }
    public static void Infinite_2(long self, boolean theIsInfinite) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsInfinite ? 1L : 0L;
        OcctGen.occtCall(4910, a, box);
    }
    public static boolean Convex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4911, a, box);
        return r != 0;
    }
    public static void Convex_2(long self, boolean theIsConvex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsConvex ? 1L : 0L;
        OcctGen.occtCall(4912, a, box);
    }
    public static void Move(long self, long thePosition, boolean theRaiseExc) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = thePosition;
        a[2] = theRaiseExc ? 1L : 0L;
        OcctGen.occtCall(4913, a, box);
    }
    public static long Moved(long self, long thePosition, boolean theRaiseExc) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = thePosition;
        a[2] = theRaiseExc ? 1L : 0L;
        long r = OcctGen.occtCall(4914, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4915, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4916, a, box);
        return r;
    }
    public static void Complement(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4917, a, box);
    }
    public static long Complemented(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4918, a, box);
        return r;
    }
    public static void Compose(long self, int theOrient) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOrient;
        OcctGen.occtCall(4919, a, box);
    }
    public static long Composed(long self, int theOrient) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOrient;
        long r = OcctGen.occtCall(4920, a, box);
        return r;
    }
    public static int NbChildren(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4921, a, box);
        return (int) r;
    }
    public static boolean IsPartner(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4922, a, box);
        return r != 0;
    }
    public static boolean IsSame(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4923, a, box);
        return r != 0;
    }
    public static boolean IsEqual(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4924, a, box);
        return r != 0;
    }
    public static boolean IsNotEqual(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4925, a, box);
        return r != 0;
    }
    public static void EmptyCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4926, a, box);
    }
    public static long EmptyCopied(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4927, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(4928, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class TopoDS_Shell {
        private TopoDS_Shell() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4929, a, box);
        return r;
    }
    }

    public static final class TopoDS_Solid {
        private TopoDS_Solid() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4930, a, box);
        return r;
    }
    }

    public static final class TopoDS_Vertex {
        private TopoDS_Vertex() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4931, a, box);
        return r;
    }
    }

    public static final class TopoDS_Wire {
        private TopoDS_Wire() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4932, a, box);
        return r;
    }
    }

}
