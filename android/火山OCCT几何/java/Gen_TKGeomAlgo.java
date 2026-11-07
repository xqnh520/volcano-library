package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKGeomAlgo 类=15 方法槽=166
public final class Gen_TKGeomAlgo {
    private Gen_TKGeomAlgo() {}

    public static final class Geom2dAPI_ExtremaCurveCurve {
        private Geom2dAPI_ExtremaCurveCurve() {}

    public static long 构造(
            long C1, long C2, double U1min, double U1max, double U2min, double U2max) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = C1;
        a[2] = C2;
        a[3] = Double.doubleToRawLongBits(U1min);
        a[4] = Double.doubleToRawLongBits(U1max);
        a[5] = Double.doubleToRawLongBits(U2min);
        a[6] = Double.doubleToRawLongBits(U2max);
        long r = OcctGen.occtCall(2248, a, box);
        return r;
    }
    public static int NbExtrema(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2249, a, box);
        return (int) r;
    }
    public static int 转整数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2250, a, box);
        return (int) r;
    }
    public static void Points(long self, int Index, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P1;
        a[3] = P2;
        OcctGen.occtCall(2251, a, box);
    }
    public static void Parameters(long self, int Index, double[] U1Out, double[] U2Out) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2252, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[2]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[3]);
    }
    public static double Distance(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2253, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void NearestPoints(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        OcctGen.occtCall(2254, a, box);
    }
    public static void LowerDistanceParameters(long self, double[] U1Out, double[] U2Out) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2255, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
    }
    public static double LowerDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2256, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double 转小数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2257, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class Geom2dAPI_InterCurveCurve {
        private Geom2dAPI_InterCurveCurve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2258, a, box);
        return r;
    }
    public static long 构造_2(long C1, long C2, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C1;
        a[2] = C2;
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(2259, a, box);
        return r;
    }
    public static long 构造_3(long C1, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C1;
        a[2] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(2260, a, box);
        return r;
    }
    public static void Init(long self, long C1, long C2, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C1;
        a[2] = C2;
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(2261, a, box);
    }
    public static void Init_2(long self, long C1, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C1;
        a[2] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(2262, a, box);
    }
    public static int NbPoints(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2263, a, box);
        return (int) r;
    }
    public static long Point(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2264, a, box);
        return r;
    }
    public static int NbSegments(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2265, a, box);
        return (int) r;
    }
    public static void Segment(long self, int Index, long[] Curve1Out, long[] Curve2Out) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2266, a, box);
        if (Curve1Out != null && Curve1Out.length != 0) Curve1Out[0] = a[2];
        if (Curve2Out != null && Curve2Out.length != 0) Curve2Out[0] = a[3];
    }
    }

    public static final class Geom2dAPI_Interpolate {
        private Geom2dAPI_Interpolate() {}

    public static void Load(long self, long InitialTangent, long FinalTangent, boolean Scale) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = InitialTangent;
        a[2] = FinalTangent;
        a[3] = Scale ? 1L : 0L;
        OcctGen.occtCall(2267, a, box);
    }
    public static void ClearTangents(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2268, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2269, a, box);
    }
    public static long Curve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2270, a, box);
        return r;
    }
    public static long 转Geom2d_BSplineCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2271, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2272, a, box);
        return r != 0;
    }
    }

    public static final class Geom2dAPI_PointsToBSpline {
        private Geom2dAPI_PointsToBSpline() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2273, a, box);
        return r;
    }
    public static long Curve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2274, a, box);
        return r;
    }
    public static long 转Geom2d_BSplineCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2275, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2276, a, box);
        return r != 0;
    }
    }

    public static final class Geom2dAPI_ProjectPointOnCurve {
        private Geom2dAPI_ProjectPointOnCurve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2277, a, box);
        return r;
    }
    public static long 构造_2(long P, long Curve) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P;
        a[2] = Curve;
        long r = OcctGen.occtCall(2278, a, box);
        return r;
    }
    public static long 构造_3(long P, long Curve, double Umin, double Usup) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = P;
        a[2] = Curve;
        a[3] = Double.doubleToRawLongBits(Umin);
        a[4] = Double.doubleToRawLongBits(Usup);
        long r = OcctGen.occtCall(2279, a, box);
        return r;
    }
    public static void Init(long self, long P, long Curve) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Curve;
        OcctGen.occtCall(2280, a, box);
    }
    public static void Init_2(long self, long P, long Curve, double Umin, double Usup) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Curve;
        a[3] = Double.doubleToRawLongBits(Umin);
        a[4] = Double.doubleToRawLongBits(Usup);
        OcctGen.occtCall(2281, a, box);
    }
    public static int NbPoints(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2282, a, box);
        return (int) r;
    }
    public static int 转整数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2283, a, box);
        return (int) r;
    }
    public static long Point(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2284, a, box);
        return r;
    }
    public static double Parameter(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2285, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Parameter_2(long self, int Index, double[] UOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2286, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static double Distance(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2287, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long NearestPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2288, a, box);
        return r;
    }
    public static long 转gp_Pnt2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2289, a, box);
        return r;
    }
    public static double LowerDistanceParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2290, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LowerDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2291, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double 转小数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2292, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GeomAPI_ExtremaCurveCurve {
        private GeomAPI_ExtremaCurveCurve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2782, a, box);
        return r;
    }
    public static long 构造_2(long C1, long C2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C1;
        a[2] = C2;
        long r = OcctGen.occtCall(2783, a, box);
        return r;
    }
    public static long 构造_3(
            long C1, long C2, double U1min, double U1max, double U2min, double U2max) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = C1;
        a[2] = C2;
        a[3] = Double.doubleToRawLongBits(U1min);
        a[4] = Double.doubleToRawLongBits(U1max);
        a[5] = Double.doubleToRawLongBits(U2min);
        a[6] = Double.doubleToRawLongBits(U2max);
        long r = OcctGen.occtCall(2784, a, box);
        return r;
    }
    public static void Init(long self, long C1, long C2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C1;
        a[2] = C2;
        OcctGen.occtCall(2785, a, box);
    }
    public static void Init_2(
            long self, long C1, long C2, double U1min, double U1max, double U2min, double U2max) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = C1;
        a[2] = C2;
        a[3] = Double.doubleToRawLongBits(U1min);
        a[4] = Double.doubleToRawLongBits(U1max);
        a[5] = Double.doubleToRawLongBits(U2min);
        a[6] = Double.doubleToRawLongBits(U2max);
        OcctGen.occtCall(2786, a, box);
    }
    public static int NbExtrema(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2787, a, box);
        return (int) r;
    }
    public static int 转整数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2788, a, box);
        return (int) r;
    }
    public static void Points(long self, int Index, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P1;
        a[3] = P2;
        OcctGen.occtCall(2789, a, box);
    }
    public static void Parameters(long self, int Index, double[] U1Out, double[] U2Out) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2790, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[2]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[3]);
    }
    public static double Distance(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2791, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsParallel(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2792, a, box);
        return r != 0;
    }
    public static void NearestPoints(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        OcctGen.occtCall(2793, a, box);
    }
    public static void LowerDistanceParameters(long self, double[] U1Out, double[] U2Out) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2794, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
    }
    public static double LowerDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2795, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double 转小数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2796, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean TotalNearestPoints(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(2797, a, box);
        return r != 0;
    }
    public static boolean TotalLowerDistanceParameters(long self, double[] U1Out, double[] U2Out) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2798, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static double TotalLowerDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2799, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GeomAPI_ExtremaCurveSurface {
        private GeomAPI_ExtremaCurveSurface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2800, a, box);
        return r;
    }
    public static long 构造_2(long Curve, long Surface) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Curve;
        a[2] = Surface;
        long r = OcctGen.occtCall(2801, a, box);
        return r;
    }
    public static long 构造_3(
            long Curve, long Surface, double Wmin, double Wmax, double Umin, double Umax,
            double Vmin, double Vmax) {
        long[] a = new long[9];
        Object[] box = null;
        a[1] = Curve;
        a[2] = Surface;
        a[3] = Double.doubleToRawLongBits(Wmin);
        a[4] = Double.doubleToRawLongBits(Wmax);
        a[5] = Double.doubleToRawLongBits(Umin);
        a[6] = Double.doubleToRawLongBits(Umax);
        a[7] = Double.doubleToRawLongBits(Vmin);
        a[8] = Double.doubleToRawLongBits(Vmax);
        long r = OcctGen.occtCall(2802, a, box);
        return r;
    }
    public static void Init(long self, long Curve, long Surface) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Curve;
        a[2] = Surface;
        OcctGen.occtCall(2803, a, box);
    }
    public static void Init_2(
            long self, long Curve, long Surface, double Wmin, double Wmax, double Umin,
            double Umax, double Vmin, double Vmax) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[1] = Curve;
        a[2] = Surface;
        a[3] = Double.doubleToRawLongBits(Wmin);
        a[4] = Double.doubleToRawLongBits(Wmax);
        a[5] = Double.doubleToRawLongBits(Umin);
        a[6] = Double.doubleToRawLongBits(Umax);
        a[7] = Double.doubleToRawLongBits(Vmin);
        a[8] = Double.doubleToRawLongBits(Vmax);
        OcctGen.occtCall(2804, a, box);
    }
    public static int NbExtrema(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2805, a, box);
        return (int) r;
    }
    public static int 转整数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2806, a, box);
        return (int) r;
    }
    public static void Points(long self, int Index, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P1;
        a[3] = P2;
        OcctGen.occtCall(2807, a, box);
    }
    public static void Parameters(
            long self, int Index, double[] WOut, double[] UOut, double[] VOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2808, a, box);
        if (WOut != null && WOut.length != 0) WOut[0] = Double.longBitsToDouble(a[2]);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[3]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static double Distance(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2809, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsParallel(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2810, a, box);
        return r != 0;
    }
    public static void NearestPoints(long self, long PC, long PS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = PC;
        a[2] = PS;
        OcctGen.occtCall(2811, a, box);
    }
    public static void LowerDistanceParameters(
            long self, double[] WOut, double[] UOut, double[] VOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2812, a, box);
        if (WOut != null && WOut.length != 0) WOut[0] = Double.longBitsToDouble(a[1]);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double LowerDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2813, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double 转小数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2814, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GeomAPI_ExtremaSurfaceSurface {
        private GeomAPI_ExtremaSurfaceSurface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2815, a, box);
        return r;
    }
    public static long 构造_2(long S1, long S2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        long r = OcctGen.occtCall(2816, a, box);
        return r;
    }
    public static long 构造_3(
            long S1, long S2, double U1min, double U1max, double V1min, double V1max,
            double U2min, double U2max, double V2min, double V2max) {
        long[] a = new long[11];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        a[3] = Double.doubleToRawLongBits(U1min);
        a[4] = Double.doubleToRawLongBits(U1max);
        a[5] = Double.doubleToRawLongBits(V1min);
        a[6] = Double.doubleToRawLongBits(V1max);
        a[7] = Double.doubleToRawLongBits(U2min);
        a[8] = Double.doubleToRawLongBits(U2max);
        a[9] = Double.doubleToRawLongBits(V2min);
        a[10] = Double.doubleToRawLongBits(V2max);
        long r = OcctGen.occtCall(2817, a, box);
        return r;
    }
    public static void Init(long self, long S1, long S2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S1;
        a[2] = S2;
        OcctGen.occtCall(2818, a, box);
    }
    public static void Init_2(
            long self, long S1, long S2, double U1min, double U1max, double V1min, double V1max,
            double U2min, double U2max, double V2min, double V2max) {
        long[] a = new long[11];
        Object[] box = null;
        a[0] = self;
        a[1] = S1;
        a[2] = S2;
        a[3] = Double.doubleToRawLongBits(U1min);
        a[4] = Double.doubleToRawLongBits(U1max);
        a[5] = Double.doubleToRawLongBits(V1min);
        a[6] = Double.doubleToRawLongBits(V1max);
        a[7] = Double.doubleToRawLongBits(U2min);
        a[8] = Double.doubleToRawLongBits(U2max);
        a[9] = Double.doubleToRawLongBits(V2min);
        a[10] = Double.doubleToRawLongBits(V2max);
        OcctGen.occtCall(2819, a, box);
    }
    public static int NbExtrema(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2820, a, box);
        return (int) r;
    }
    public static int 转整数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2821, a, box);
        return (int) r;
    }
    public static void Points(long self, int Index, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P1;
        a[3] = P2;
        OcctGen.occtCall(2822, a, box);
    }
    public static void Parameters(
            long self, int Index, double[] U1Out, double[] V1Out, double[] U2Out, double[] V2Out) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2823, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[4]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[5]);
    }
    public static double Distance(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2824, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsParallel(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2825, a, box);
        return r != 0;
    }
    public static void NearestPoints(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        OcctGen.occtCall(2826, a, box);
    }
    public static void LowerDistanceParameters(
            long self, double[] U1Out, double[] V1Out, double[] U2Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2827, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[2]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static double LowerDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2828, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double 转小数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2829, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GeomAPI_IntCS {
        private GeomAPI_IntCS() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2830, a, box);
        return r;
    }
    public static long 构造_2(long C, long S) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = S;
        long r = OcctGen.occtCall(2831, a, box);
        return r;
    }
    public static void Perform(long self, long C, long S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = S;
        OcctGen.occtCall(2832, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2833, a, box);
        return r != 0;
    }
    public static int NbPoints(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2834, a, box);
        return (int) r;
    }
    public static long Point(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2835, a, box);
        return r;
    }
    public static void Parameters(
            long self, int Index, double[] UOut, double[] VOut, double[] WOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2836, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[3]);
        if (WOut != null && WOut.length != 0) WOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static int NbSegments(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2837, a, box);
        return (int) r;
    }
    public static long Segment(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2838, a, box);
        return r;
    }
    public static void Parameters_2(
            long self, int Index, double[] U1Out, double[] V1Out, double[] U2Out, double[] V2Out) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2839, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[4]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[5]);
    }
    }

    public static final class GeomAPI_IntSS {
        private GeomAPI_IntSS() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2840, a, box);
        return r;
    }
    public static long 构造_2(long S1, long S2, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(2841, a, box);
        return r;
    }
    public static void Perform(long self, long S1, long S2, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S1;
        a[2] = S2;
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(2842, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2843, a, box);
        return r != 0;
    }
    public static int NbLines(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2844, a, box);
        return (int) r;
    }
    public static long Line(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2845, a, box);
        return r;
    }
    }

    public static final class GeomAPI_Interpolate {
        private GeomAPI_Interpolate() {}

    public static void Load(long self, long InitialTangent, long FinalTangent, boolean Scale) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = InitialTangent;
        a[2] = FinalTangent;
        a[3] = Scale ? 1L : 0L;
        OcctGen.occtCall(2846, a, box);
    }
    public static void ClearTangents(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2847, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2848, a, box);
    }
    public static long Curve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2849, a, box);
        return r;
    }
    public static long 转Geom_BSplineCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2850, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2851, a, box);
        return r != 0;
    }
    }

    public static final class GeomAPI_PointsToBSpline {
        private GeomAPI_PointsToBSpline() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2852, a, box);
        return r;
    }
    public static long Curve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2853, a, box);
        return r;
    }
    public static long 转Geom_BSplineCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2854, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2855, a, box);
        return r != 0;
    }
    }

    public static final class GeomAPI_PointsToBSplineSurface {
        private GeomAPI_PointsToBSplineSurface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2856, a, box);
        return r;
    }
    public static long Surface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2857, a, box);
        return r;
    }
    public static long 转Geom_BSplineSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2858, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2859, a, box);
        return r != 0;
    }
    }

    public static final class GeomAPI_ProjectPointOnCurve {
        private GeomAPI_ProjectPointOnCurve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2860, a, box);
        return r;
    }
    public static long 构造_2(long P, long Curve) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P;
        a[2] = Curve;
        long r = OcctGen.occtCall(2861, a, box);
        return r;
    }
    public static long 构造_3(long P, long Curve, double Umin, double Usup) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = P;
        a[2] = Curve;
        a[3] = Double.doubleToRawLongBits(Umin);
        a[4] = Double.doubleToRawLongBits(Usup);
        long r = OcctGen.occtCall(2862, a, box);
        return r;
    }
    public static void Init(long self, long P, long Curve) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Curve;
        OcctGen.occtCall(2863, a, box);
    }
    public static void Init_2(long self, long P, long Curve, double Umin, double Usup) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Curve;
        a[3] = Double.doubleToRawLongBits(Umin);
        a[4] = Double.doubleToRawLongBits(Usup);
        OcctGen.occtCall(2864, a, box);
    }
    public static void Init_3(long self, long Curve, double Umin, double Usup) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Curve;
        a[2] = Double.doubleToRawLongBits(Umin);
        a[3] = Double.doubleToRawLongBits(Usup);
        OcctGen.occtCall(2865, a, box);
    }
    public static void Perform(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2866, a, box);
    }
    public static int NbPoints(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2867, a, box);
        return (int) r;
    }
    public static int 转整数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2868, a, box);
        return (int) r;
    }
    public static long Point(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2869, a, box);
        return r;
    }
    public static double Parameter(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2870, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Parameter_2(long self, int Index, double[] UOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2871, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static double Distance(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2872, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long NearestPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2873, a, box);
        return r;
    }
    public static long 转gp_Pnt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2874, a, box);
        return r;
    }
    public static double LowerDistanceParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2875, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LowerDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2876, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double 转小数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2877, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GeomAPI_ProjectPointOnSurf {
        private GeomAPI_ProjectPointOnSurf() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2878, a, box);
        return r;
    }
    public static long 构造_2(long P, long Surface, int Algo) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = P;
        a[2] = Surface;
        a[3] = Algo;
        long r = OcctGen.occtCall(2879, a, box);
        return r;
    }
    public static long 构造_3(long P, long Surface, double Tolerance, int Algo) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = P;
        a[2] = Surface;
        a[3] = Double.doubleToRawLongBits(Tolerance);
        a[4] = Algo;
        long r = OcctGen.occtCall(2880, a, box);
        return r;
    }
    public static long 构造_4(
            long P, long Surface, double Umin, double Usup, double Vmin, double Vsup,
            double Tolerance, int Algo) {
        long[] a = new long[9];
        Object[] box = null;
        a[1] = P;
        a[2] = Surface;
        a[3] = Double.doubleToRawLongBits(Umin);
        a[4] = Double.doubleToRawLongBits(Usup);
        a[5] = Double.doubleToRawLongBits(Vmin);
        a[6] = Double.doubleToRawLongBits(Vsup);
        a[7] = Double.doubleToRawLongBits(Tolerance);
        a[8] = Algo;
        long r = OcctGen.occtCall(2881, a, box);
        return r;
    }
    public static long 构造_5(
            long P, long Surface, double Umin, double Usup, double Vmin, double Vsup, int Algo) {
        long[] a = new long[8];
        Object[] box = null;
        a[1] = P;
        a[2] = Surface;
        a[3] = Double.doubleToRawLongBits(Umin);
        a[4] = Double.doubleToRawLongBits(Usup);
        a[5] = Double.doubleToRawLongBits(Vmin);
        a[6] = Double.doubleToRawLongBits(Vsup);
        a[7] = Algo;
        long r = OcctGen.occtCall(2882, a, box);
        return r;
    }
    public static void Init(long self, long P, long Surface, double Tolerance, int Algo) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Surface;
        a[3] = Double.doubleToRawLongBits(Tolerance);
        a[4] = Algo;
        OcctGen.occtCall(2883, a, box);
    }
    public static void Init_2(long self, long P, long Surface, int Algo) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Surface;
        a[3] = Algo;
        OcctGen.occtCall(2884, a, box);
    }
    public static void Init_3(
            long self, long P, long Surface, double Umin, double Usup, double Vmin, double Vsup,
            double Tolerance, int Algo) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Surface;
        a[3] = Double.doubleToRawLongBits(Umin);
        a[4] = Double.doubleToRawLongBits(Usup);
        a[5] = Double.doubleToRawLongBits(Vmin);
        a[6] = Double.doubleToRawLongBits(Vsup);
        a[7] = Double.doubleToRawLongBits(Tolerance);
        a[8] = Algo;
        OcctGen.occtCall(2885, a, box);
    }
    public static void Init_4(
            long self, long P, long Surface, double Umin, double Usup, double Vmin, double Vsup,
            int Algo) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Surface;
        a[3] = Double.doubleToRawLongBits(Umin);
        a[4] = Double.doubleToRawLongBits(Usup);
        a[5] = Double.doubleToRawLongBits(Vmin);
        a[6] = Double.doubleToRawLongBits(Vsup);
        a[7] = Algo;
        OcctGen.occtCall(2886, a, box);
    }
    public static void Init_5(
            long self, long Surface, double Umin, double Usup, double Vmin, double Vsup,
            double Tolerance, int Algo) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = Surface;
        a[2] = Double.doubleToRawLongBits(Umin);
        a[3] = Double.doubleToRawLongBits(Usup);
        a[4] = Double.doubleToRawLongBits(Vmin);
        a[5] = Double.doubleToRawLongBits(Vsup);
        a[6] = Double.doubleToRawLongBits(Tolerance);
        a[7] = Algo;
        OcctGen.occtCall(2887, a, box);
    }
    public static void Init_6(
            long self, long Surface, double Umin, double Usup, double Vmin, double Vsup, int Algo) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Surface;
        a[2] = Double.doubleToRawLongBits(Umin);
        a[3] = Double.doubleToRawLongBits(Usup);
        a[4] = Double.doubleToRawLongBits(Vmin);
        a[5] = Double.doubleToRawLongBits(Vsup);
        a[6] = Algo;
        OcctGen.occtCall(2888, a, box);
    }
    public static void SetExtremaAlgo(long self, int theAlgo) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theAlgo;
        OcctGen.occtCall(2889, a, box);
    }
    public static void SetExtremaFlag(long self, int theExtFlag) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theExtFlag;
        OcctGen.occtCall(2890, a, box);
    }
    public static void Perform(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2891, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2892, a, box);
        return r != 0;
    }
    public static int NbPoints(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2893, a, box);
        return (int) r;
    }
    public static int 转整数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2894, a, box);
        return (int) r;
    }
    public static long Point(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2895, a, box);
        return r;
    }
    public static void Parameters(long self, int Index, double[] UOut, double[] VOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2896, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double Distance(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2897, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long NearestPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2898, a, box);
        return r;
    }
    public static long 转gp_Pnt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2899, a, box);
        return r;
    }
    public static void LowerDistanceParameters(long self, double[] UOut, double[] VOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2900, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static double LowerDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2901, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double 转小数(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2902, a, box);
        return Double.longBitsToDouble(r);
    }
    }

}
