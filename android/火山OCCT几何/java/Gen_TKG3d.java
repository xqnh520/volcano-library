package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKG3d 类=62 方法槽=1370
public final class Gen_TKG3d {
    private Gen_TKG3d() {}

    public static final class Adaptor3d_Curve {
        private Adaptor3d_Curve() {}

    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(99, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(100, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(101, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(102, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(103, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(104, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(105, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(106, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(107, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(108, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(109, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(110, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(111, a, box);
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
        OcctGen.occtCall(112, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(113, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(114, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(115, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(116, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(117, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(118, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(119, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(120, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(121, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(122, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(123, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(124, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(125, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(126, a, box);
        return r;
    }
    public static long OffsetCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(127, a, box);
        return r;
    }
    }

    public static final class Adaptor3d_CurveOnSurface {
        private Adaptor3d_CurveOnSurface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(128, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(129, a, box);
        return r;
    }
    public static long 构造_3(long C, long S) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = S;
        long r = OcctGen.occtCall(130, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(131, a, box);
        return r;
    }
    public static void Load(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(132, a, box);
    }
    public static void Load_2(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(133, a, box);
    }
    public static void Load_3(long self, long C, long S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = S;
        OcctGen.occtCall(134, a, box);
    }
    public static long GetCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(135, a, box);
        return r;
    }
    public static long GetSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(136, a, box);
        return r;
    }
    public static long ChangeCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(137, a, box);
        return r;
    }
    public static long ChangeSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(138, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(139, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(140, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(141, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(142, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(143, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(144, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(145, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(146, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(147, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(148, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(149, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(150, a, box);
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
        OcctGen.occtCall(151, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(152, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(153, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(154, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(155, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(156, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(157, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(158, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(159, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(160, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(161, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(162, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(163, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(164, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(165, a, box);
        return r;
    }
    }

    public static final class Adaptor3d_HSurfaceTool {
        private Adaptor3d_HSurfaceTool() {}

    public static double FirstUParameter(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(166, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstVParameter(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(167, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastUParameter(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(168, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastVParameter(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(169, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int NbUIntervals(long theSurf, int theSh) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = theSh;
        long r = OcctGen.occtCall(170, a, box);
        return (int) r;
    }
    public static int NbVIntervals(long theSurf, int theSh) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = theSh;
        long r = OcctGen.occtCall(171, a, box);
        return (int) r;
    }
    public static long UTrim(long theSurf, double theFirst, double theLast, double theTol) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theFirst);
        a[3] = Double.doubleToRawLongBits(theLast);
        a[4] = Double.doubleToRawLongBits(theTol);
        long r = OcctGen.occtCall(172, a, box);
        return r;
    }
    public static long VTrim(long theSurf, double theFirst, double theLast, double theTol) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theFirst);
        a[3] = Double.doubleToRawLongBits(theLast);
        a[4] = Double.doubleToRawLongBits(theTol);
        long r = OcctGen.occtCall(173, a, box);
        return r;
    }
    public static boolean IsUClosed(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(174, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(175, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(176, a, box);
        return r != 0;
    }
    public static double UPeriod(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(177, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVPeriodic(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(178, a, box);
        return r != 0;
    }
    public static double VPeriod(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(179, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long theSurf, double theU, double theV) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theU);
        a[3] = Double.doubleToRawLongBits(theV);
        long r = OcctGen.occtCall(180, a, box);
        return r;
    }
    public static void D0(long theSurf, double theU, double theV, long thePnt) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theU);
        a[3] = Double.doubleToRawLongBits(theV);
        a[4] = thePnt;
        OcctGen.occtCall(181, a, box);
    }
    public static void D1(
            long theSurf, double theU, double theV, long thePnt, long theD1U, long theD1V) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theU);
        a[3] = Double.doubleToRawLongBits(theV);
        a[4] = thePnt;
        a[5] = theD1U;
        a[6] = theD1V;
        OcctGen.occtCall(182, a, box);
    }
    public static void D2(
            long theSurf, double theU, double theV, long thePnt, long theD1U, long theD1V,
            long theD2U, long theD2V, long theD2UV) {
        long[] a = new long[10];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theU);
        a[3] = Double.doubleToRawLongBits(theV);
        a[4] = thePnt;
        a[5] = theD1U;
        a[6] = theD1V;
        a[7] = theD2U;
        a[8] = theD2V;
        a[9] = theD2UV;
        OcctGen.occtCall(183, a, box);
    }
    public static void D3(
            long theSurf, double theU, double theV, long thePnt, long theD1U, long theD1V,
            long theD2U, long theD2V, long theD2UV, long theD3U, long theD3V, long theD3UUV,
            long theD3UVV) {
        long[] a = new long[14];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theU);
        a[3] = Double.doubleToRawLongBits(theV);
        a[4] = thePnt;
        a[5] = theD1U;
        a[6] = theD1V;
        a[7] = theD2U;
        a[8] = theD2V;
        a[9] = theD2UV;
        a[10] = theD3U;
        a[11] = theD3V;
        a[12] = theD3UUV;
        a[13] = theD3UVV;
        OcctGen.occtCall(184, a, box);
    }
    public static long DN(long theSurf, double theU, double theV, int theNU, int theNV) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theU);
        a[3] = Double.doubleToRawLongBits(theV);
        a[4] = theNU;
        a[5] = theNV;
        long r = OcctGen.occtCall(185, a, box);
        return r;
    }
    public static double UResolution(long theSurf, double theR3d) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theR3d);
        long r = OcctGen.occtCall(186, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VResolution(long theSurf, double theR3d) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theR3d);
        long r = OcctGen.occtCall(187, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(188, a, box);
        return (int) r;
    }
    public static long Plane(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(189, a, box);
        return r;
    }
    public static long Cylinder(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(190, a, box);
        return r;
    }
    public static long Cone(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(191, a, box);
        return r;
    }
    public static long Torus(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(192, a, box);
        return r;
    }
    public static long Sphere(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(193, a, box);
        return r;
    }
    public static long Bezier(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(194, a, box);
        return r;
    }
    public static long BSpline(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(195, a, box);
        return r;
    }
    public static long AxeOfRevolution(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(196, a, box);
        return r;
    }
    public static long Direction(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(197, a, box);
        return r;
    }
    public static long BasisCurve(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(198, a, box);
        return r;
    }
    public static long BasisSurface(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(199, a, box);
        return r;
    }
    public static double OffsetValue(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(200, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsSurfG1(long theSurf, boolean theAlongU, double theAngTol) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = theAlongU ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(theAngTol);
        long r = OcctGen.occtCall(201, a, box);
        return r != 0;
    }
    public static int NbSamplesU(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(202, a, box);
        return (int) r;
    }
    public static int NbSamplesV(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(203, a, box);
        return (int) r;
    }
    public static int NbSamplesU_2(long S, double u1, double u2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(u1);
        a[3] = Double.doubleToRawLongBits(u2);
        long r = OcctGen.occtCall(204, a, box);
        return (int) r;
    }
    public static int NbSamplesV_2(long a0, double v1, double v2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = a0;
        a[2] = Double.doubleToRawLongBits(v1);
        a[3] = Double.doubleToRawLongBits(v2);
        long r = OcctGen.occtCall(205, a, box);
        return (int) r;
    }
    }

    public static final class Adaptor3d_HVertex {
        private Adaptor3d_HVertex() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(206, a, box);
        return r;
    }
    public static long 构造_2(long P, int Ori, double Resolution) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = P;
        a[2] = Ori;
        a[3] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(207, a, box);
        return r;
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(208, a, box);
        return r;
    }
    public static double Parameter(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(209, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Resolution(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(210, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Orientation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(211, a, box);
        return (int) r;
    }
    public static boolean IsSame(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(212, a, box);
        return r != 0;
    }
    }

    public static final class Adaptor3d_InterFunc {
        private Adaptor3d_InterFunc() {}

    public static long 构造(long C, double FixVal, int Fix) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(FixVal);
        a[3] = Fix;
        long r = OcctGen.occtCall(213, a, box);
        return r;
    }
    public static boolean Value(long self, double X, double[] FOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(214, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static boolean Derivative(long self, double X, double[] DOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(215, a, box);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static boolean Values(long self, double X, double[] FOut, double[] DOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(216, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[2]);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[3]);
        return r != 0;
    }
    }

    public static final class Adaptor3d_IsoCurve {
        private Adaptor3d_IsoCurve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(217, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(218, a, box);
        return r;
    }
    public static long 构造_3(long S, int Iso, double Param) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = Iso;
        a[3] = Double.doubleToRawLongBits(Param);
        long r = OcctGen.occtCall(219, a, box);
        return r;
    }
    public static long 构造_4(long S, int Iso, double Param, double WFirst, double WLast) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = Iso;
        a[3] = Double.doubleToRawLongBits(Param);
        a[4] = Double.doubleToRawLongBits(WFirst);
        a[5] = Double.doubleToRawLongBits(WLast);
        long r = OcctGen.occtCall(220, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(221, a, box);
        return r;
    }
    public static void Load(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(222, a, box);
    }
    public static void Load_2(long self, int Iso, double Param) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Iso;
        a[2] = Double.doubleToRawLongBits(Param);
        OcctGen.occtCall(223, a, box);
    }
    public static void Load_3(long self, int Iso, double Param, double WFirst, double WLast) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Iso;
        a[2] = Double.doubleToRawLongBits(Param);
        a[3] = Double.doubleToRawLongBits(WFirst);
        a[4] = Double.doubleToRawLongBits(WLast);
        OcctGen.occtCall(224, a, box);
    }
    public static long Surface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(225, a, box);
        return r;
    }
    public static int Iso(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(226, a, box);
        return (int) r;
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(227, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(228, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(229, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(230, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(231, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(232, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(233, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(234, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(235, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(236, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(237, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(238, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(239, a, box);
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
        OcctGen.occtCall(240, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(241, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(242, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(243, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(244, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(245, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(246, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(247, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(248, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(249, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(250, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(251, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(252, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(253, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(254, a, box);
        return r;
    }
    }

    public static final class Adaptor3d_Surface {
        private Adaptor3d_Surface() {}

    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(255, a, box);
        return r;
    }
    public static double FirstUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(256, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(257, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(258, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(259, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int UContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(260, a, box);
        return (int) r;
    }
    public static int VContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(261, a, box);
        return (int) r;
    }
    public static int NbUIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(262, a, box);
        return (int) r;
    }
    public static int NbVIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(263, a, box);
        return (int) r;
    }
    public static long UTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(264, a, box);
        return r;
    }
    public static long VTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(265, a, box);
        return r;
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(266, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(267, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(268, a, box);
        return r != 0;
    }
    public static double UPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(269, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(270, a, box);
        return r != 0;
    }
    public static double VPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(271, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U, double V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(272, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(273, a, box);
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
        OcctGen.occtCall(274, a, box);
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
        OcctGen.occtCall(275, a, box);
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
        OcctGen.occtCall(276, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(277, a, box);
        return r;
    }
    public static double UResolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(278, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VResolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(279, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(280, a, box);
        return (int) r;
    }
    public static long Plane(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(281, a, box);
        return r;
    }
    public static long Cylinder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(282, a, box);
        return r;
    }
    public static long Cone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(283, a, box);
        return r;
    }
    public static long Sphere(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(284, a, box);
        return r;
    }
    public static long Torus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(285, a, box);
        return r;
    }
    public static int UDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(286, a, box);
        return (int) r;
    }
    public static int NbUPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(287, a, box);
        return (int) r;
    }
    public static int VDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(288, a, box);
        return (int) r;
    }
    public static int NbVPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(289, a, box);
        return (int) r;
    }
    public static int NbUKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(290, a, box);
        return (int) r;
    }
    public static int NbVKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(291, a, box);
        return (int) r;
    }
    public static boolean IsURational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(292, a, box);
        return r != 0;
    }
    public static boolean IsVRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(293, a, box);
        return r != 0;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(294, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(295, a, box);
        return r;
    }
    public static long AxeOfRevolution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(296, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(297, a, box);
        return r;
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(298, a, box);
        return r;
    }
    public static long BasisSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(299, a, box);
        return r;
    }
    public static double OffsetValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(300, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class Adaptor3d_TopolTool {
        private Adaptor3d_TopolTool() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(301, a, box);
        return r;
    }
    public static long 构造_2(long Surface) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Surface;
        long r = OcctGen.occtCall(302, a, box);
        return r;
    }
    public static void Initialize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(303, a, box);
    }
    public static void Initialize_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(304, a, box);
    }
    public static void Initialize_3(long self, long Curve) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Curve;
        OcctGen.occtCall(305, a, box);
    }
    public static void Init(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(306, a, box);
    }
    public static boolean More(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(307, a, box);
        return r != 0;
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(308, a, box);
        return r;
    }
    public static void Next(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(309, a, box);
    }
    public static void InitVertexIterator(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(310, a, box);
    }
    public static boolean MoreVertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(311, a, box);
        return r != 0;
    }
    public static long Vertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(312, a, box);
        return r;
    }
    public static void NextVertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(313, a, box);
    }
    public static int Classify(long self, long P, double Tol, boolean ReacdreOnPeriodic) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(Tol);
        a[3] = ReacdreOnPeriodic ? 1L : 0L;
        long r = OcctGen.occtCall(314, a, box);
        return (int) r;
    }
    public static boolean IsThePointOn(long self, long P, double Tol, boolean ReacdreOnPeriodic) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(Tol);
        a[3] = ReacdreOnPeriodic ? 1L : 0L;
        long r = OcctGen.occtCall(315, a, box);
        return r != 0;
    }
    public static int Orientation(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(316, a, box);
        return (int) r;
    }
    public static int Orientation_2(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        long r = OcctGen.occtCall(317, a, box);
        return (int) r;
    }
    public static boolean Identical(long self, long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = V1;
        a[2] = V2;
        long r = OcctGen.occtCall(318, a, box);
        return r != 0;
    }
    public static boolean Has3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(319, a, box);
        return r != 0;
    }
    public static double Tol3d(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(320, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Tol3d_2(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        long r = OcctGen.occtCall(321, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Pnt(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        long r = OcctGen.occtCall(322, a, box);
        return r;
    }
    public static void ComputeSamplePoints(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(323, a, box);
    }
    public static int NbSamplesU(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(324, a, box);
        return (int) r;
    }
    public static int NbSamplesV(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(325, a, box);
        return (int) r;
    }
    public static int NbSamples(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(326, a, box);
        return (int) r;
    }
    public static void SamplePoint(long self, int Index, long P2d, long P3d) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P2d;
        a[3] = P3d;
        OcctGen.occtCall(327, a, box);
    }
    public static boolean DomainIsInfinite(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(328, a, box);
        return r != 0;
    }
    public static void SamplePnts(long self, double theDefl, int theNUmin, int theNVmin) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDefl);
        a[2] = theNUmin;
        a[3] = theNVmin;
        OcctGen.occtCall(329, a, box);
    }
    public static void BSplSamplePnts(long self, double theDefl, int theNUmin, int theNVmin) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDefl);
        a[2] = theNUmin;
        a[3] = theNVmin;
        OcctGen.occtCall(330, a, box);
    }
    public static boolean IsUniformSampling(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(331, a, box);
        return r != 0;
    }
    public static void GetConeApexParam(long theC, double[] theUOut, double[] theVOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theC;
        OcctGen.occtCall(332, a, box);
        if (theUOut != null && theUOut.length != 0) theUOut[0] = Double.longBitsToDouble(a[2]);
        if (theVOut != null && theVOut.length != 0) theVOut[0] = Double.longBitsToDouble(a[3]);
    }
    }

    public static final class GProp_CelGProps {
        private GProp_CelGProps() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2190, a, box);
        return r;
    }
    public static long 构造_2(long C, long CLocation) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = CLocation;
        long r = OcctGen.occtCall(2191, a, box);
        return r;
    }
    public static long 构造_3(long C, double U1, double U2, long CLocation) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U1);
        a[3] = Double.doubleToRawLongBits(U2);
        a[4] = CLocation;
        long r = OcctGen.occtCall(2192, a, box);
        return r;
    }
    public static long 构造_4(long C, double U1, double U2, long CLocation) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U1);
        a[3] = Double.doubleToRawLongBits(U2);
        a[4] = CLocation;
        long r = OcctGen.occtCall(2193, a, box);
        return r;
    }
    public static void SetLocation(long self, long CLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = CLocation;
        OcctGen.occtCall(2194, a, box);
    }
    public static void Perform(long self, long C, double U1, double U2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U1);
        a[3] = Double.doubleToRawLongBits(U2);
        OcctGen.occtCall(2195, a, box);
    }
    public static void Perform_2(long self, long C, double U1, double U2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U1);
        a[3] = Double.doubleToRawLongBits(U2);
        OcctGen.occtCall(2196, a, box);
    }
    }

    public static final class GProp_GProps {
        private GProp_GProps() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2197, a, box);
        return r;
    }
    public static long 构造_2(long SystemLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = SystemLocation;
        long r = OcctGen.occtCall(2198, a, box);
        return r;
    }
    public static void Add(long self, long Item, double Density) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Item;
        a[2] = Double.doubleToRawLongBits(Density);
        OcctGen.occtCall(2199, a, box);
    }
    public static double Mass(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2200, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long CentreOfMass(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2201, a, box);
        return r;
    }
    public static long MatrixOfInertia(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2202, a, box);
        return r;
    }
    public static void StaticMoments(long self, double[] IxOut, double[] IyOut, double[] IzOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2203, a, box);
        if (IxOut != null && IxOut.length != 0) IxOut[0] = Double.longBitsToDouble(a[1]);
        if (IyOut != null && IyOut.length != 0) IyOut[0] = Double.longBitsToDouble(a[2]);
        if (IzOut != null && IzOut.length != 0) IzOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double MomentOfInertia(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        long r = OcctGen.occtCall(2204, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long PrincipalProperties(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2205, a, box);
        return r;
    }
    public static double RadiusOfGyration(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        long r = OcctGen.occtCall(2206, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GProp_PEquation {
        private GProp_PEquation() {}

    public static boolean IsPlanar(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2207, a, box);
        return r != 0;
    }
    public static boolean IsLinear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2208, a, box);
        return r != 0;
    }
    public static boolean IsPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2209, a, box);
        return r != 0;
    }
    public static boolean IsSpace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2210, a, box);
        return r != 0;
    }
    public static long Plane(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2211, a, box);
        return r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2212, a, box);
        return r;
    }
    public static long Point(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2213, a, box);
        return r;
    }
    public static void Box(long self, long P, long V1, long V2, long V3) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = V1;
        a[3] = V2;
        a[4] = V3;
        OcctGen.occtCall(2214, a, box);
    }
    }

    public static final class GProp_PGProps {
        private GProp_PGProps() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2215, a, box);
        return r;
    }
    public static void AddPoint(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2216, a, box);
    }
    public static void AddPoint_2(long self, long P, double Density) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(Density);
        OcctGen.occtCall(2217, a, box);
    }
    }

    public static final class GProp_PrincipalProps {
        private GProp_PrincipalProps() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2218, a, box);
        return r;
    }
    public static boolean HasSymmetryAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2219, a, box);
        return r != 0;
    }
    public static boolean HasSymmetryAxis_2(long self, double aTol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(aTol);
        long r = OcctGen.occtCall(2220, a, box);
        return r != 0;
    }
    public static boolean HasSymmetryPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2221, a, box);
        return r != 0;
    }
    public static boolean HasSymmetryPoint_2(long self, double aTol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(aTol);
        long r = OcctGen.occtCall(2222, a, box);
        return r != 0;
    }
    public static void Moments(long self, double[] IxxOut, double[] IyyOut, double[] IzzOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2223, a, box);
        if (IxxOut != null && IxxOut.length != 0) IxxOut[0] = Double.longBitsToDouble(a[1]);
        if (IyyOut != null && IyyOut.length != 0) IyyOut[0] = Double.longBitsToDouble(a[2]);
        if (IzzOut != null && IzzOut.length != 0) IzzOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long FirstAxisOfInertia(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2224, a, box);
        return r;
    }
    public static long SecondAxisOfInertia(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2225, a, box);
        return r;
    }
    public static long ThirdAxisOfInertia(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2226, a, box);
        return r;
    }
    public static void RadiusOfGyration(
            long self, double[] RxxOut, double[] RyyOut, double[] RzzOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2227, a, box);
        if (RxxOut != null && RxxOut.length != 0) RxxOut[0] = Double.longBitsToDouble(a[1]);
        if (RyyOut != null && RyyOut.length != 0) RyyOut[0] = Double.longBitsToDouble(a[2]);
        if (RzzOut != null && RzzOut.length != 0) RzzOut[0] = Double.longBitsToDouble(a[3]);
    }
    }

    public static final class GProp_SelGProps {
        private GProp_SelGProps() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2228, a, box);
        return r;
    }
    public static long 构造_2(
            long S, double Alpha1, double Alpha2, double Z1, double Z2, long SLocation) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Alpha1);
        a[3] = Double.doubleToRawLongBits(Alpha2);
        a[4] = Double.doubleToRawLongBits(Z1);
        a[5] = Double.doubleToRawLongBits(Z2);
        a[6] = SLocation;
        long r = OcctGen.occtCall(2229, a, box);
        return r;
    }
    public static long 构造_3(
            long S, double Alpha1, double Alpha2, double Z1, double Z2, long SLocation) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Alpha1);
        a[3] = Double.doubleToRawLongBits(Alpha2);
        a[4] = Double.doubleToRawLongBits(Z1);
        a[5] = Double.doubleToRawLongBits(Z2);
        a[6] = SLocation;
        long r = OcctGen.occtCall(2230, a, box);
        return r;
    }
    public static long 构造_4(
            long S, double Teta1, double Teta2, double Alpha1, double Alpha2, long SLocation) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Teta1);
        a[3] = Double.doubleToRawLongBits(Teta2);
        a[4] = Double.doubleToRawLongBits(Alpha1);
        a[5] = Double.doubleToRawLongBits(Alpha2);
        a[6] = SLocation;
        long r = OcctGen.occtCall(2231, a, box);
        return r;
    }
    public static long 构造_5(
            long S, double Teta1, double Teta2, double Alpha1, double Alpha2, long SLocation) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Teta1);
        a[3] = Double.doubleToRawLongBits(Teta2);
        a[4] = Double.doubleToRawLongBits(Alpha1);
        a[5] = Double.doubleToRawLongBits(Alpha2);
        a[6] = SLocation;
        long r = OcctGen.occtCall(2232, a, box);
        return r;
    }
    public static void SetLocation(long self, long SLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = SLocation;
        OcctGen.occtCall(2233, a, box);
    }
    public static void Perform(
            long self, long S, double Alpha1, double Alpha2, double Z1, double Z2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Alpha1);
        a[3] = Double.doubleToRawLongBits(Alpha2);
        a[4] = Double.doubleToRawLongBits(Z1);
        a[5] = Double.doubleToRawLongBits(Z2);
        OcctGen.occtCall(2234, a, box);
    }
    public static void Perform_2(
            long self, long S, double Alpha1, double Alpha2, double Z1, double Z2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Alpha1);
        a[3] = Double.doubleToRawLongBits(Alpha2);
        a[4] = Double.doubleToRawLongBits(Z1);
        a[5] = Double.doubleToRawLongBits(Z2);
        OcctGen.occtCall(2235, a, box);
    }
    public static void Perform_3(
            long self, long S, double Teta1, double Teta2, double Alpha1, double Alpha2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Teta1);
        a[3] = Double.doubleToRawLongBits(Teta2);
        a[4] = Double.doubleToRawLongBits(Alpha1);
        a[5] = Double.doubleToRawLongBits(Alpha2);
        OcctGen.occtCall(2236, a, box);
    }
    public static void Perform_4(
            long self, long S, double Teta1, double Teta2, double Alpha1, double Alpha2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Teta1);
        a[3] = Double.doubleToRawLongBits(Teta2);
        a[4] = Double.doubleToRawLongBits(Alpha1);
        a[5] = Double.doubleToRawLongBits(Alpha2);
        OcctGen.occtCall(2237, a, box);
    }
    }

    public static final class GProp_VelGProps {
        private GProp_VelGProps() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2238, a, box);
        return r;
    }
    public static long 构造_2(
            long S, double Alpha1, double Alpha2, double Z1, double Z2, long VLocation) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Alpha1);
        a[3] = Double.doubleToRawLongBits(Alpha2);
        a[4] = Double.doubleToRawLongBits(Z1);
        a[5] = Double.doubleToRawLongBits(Z2);
        a[6] = VLocation;
        long r = OcctGen.occtCall(2239, a, box);
        return r;
    }
    public static long 构造_3(
            long S, double Alpha1, double Alpha2, double Z1, double Z2, long VLocation) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Alpha1);
        a[3] = Double.doubleToRawLongBits(Alpha2);
        a[4] = Double.doubleToRawLongBits(Z1);
        a[5] = Double.doubleToRawLongBits(Z2);
        a[6] = VLocation;
        long r = OcctGen.occtCall(2240, a, box);
        return r;
    }
    public static long 构造_4(
            long S, double Teta1, double Teta2, double Alpha1, double Alpha2, long VLocation) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Teta1);
        a[3] = Double.doubleToRawLongBits(Teta2);
        a[4] = Double.doubleToRawLongBits(Alpha1);
        a[5] = Double.doubleToRawLongBits(Alpha2);
        a[6] = VLocation;
        long r = OcctGen.occtCall(2241, a, box);
        return r;
    }
    public static long 构造_5(
            long S, double Teta1, double Teta2, double Alpha1, double Alpha2, long VLocation) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Teta1);
        a[3] = Double.doubleToRawLongBits(Teta2);
        a[4] = Double.doubleToRawLongBits(Alpha1);
        a[5] = Double.doubleToRawLongBits(Alpha2);
        a[6] = VLocation;
        long r = OcctGen.occtCall(2242, a, box);
        return r;
    }
    public static void SetLocation(long self, long VLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = VLocation;
        OcctGen.occtCall(2243, a, box);
    }
    public static void Perform(
            long self, long S, double Alpha1, double Alpha2, double Z1, double Z2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Alpha1);
        a[3] = Double.doubleToRawLongBits(Alpha2);
        a[4] = Double.doubleToRawLongBits(Z1);
        a[5] = Double.doubleToRawLongBits(Z2);
        OcctGen.occtCall(2244, a, box);
    }
    public static void Perform_2(
            long self, long S, double Alpha1, double Alpha2, double Z1, double Z2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Alpha1);
        a[3] = Double.doubleToRawLongBits(Alpha2);
        a[4] = Double.doubleToRawLongBits(Z1);
        a[5] = Double.doubleToRawLongBits(Z2);
        OcctGen.occtCall(2245, a, box);
    }
    public static void Perform_3(
            long self, long S, double Teta1, double Teta2, double Alpha1, double Alpha2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Teta1);
        a[3] = Double.doubleToRawLongBits(Teta2);
        a[4] = Double.doubleToRawLongBits(Alpha1);
        a[5] = Double.doubleToRawLongBits(Alpha2);
        OcctGen.occtCall(2246, a, box);
    }
    public static void Perform_4(
            long self, long S, double Teta1, double Teta2, double Alpha1, double Alpha2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Teta1);
        a[3] = Double.doubleToRawLongBits(Teta2);
        a[4] = Double.doubleToRawLongBits(Alpha1);
        a[5] = Double.doubleToRawLongBits(Alpha2);
        OcctGen.occtCall(2247, a, box);
    }
    }

    public static final class GeomAdaptor_Curve {
        private GeomAdaptor_Curve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2903, a, box);
        return r;
    }
    public static long 构造_2(long theCurve) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theCurve;
        long r = OcctGen.occtCall(2904, a, box);
        return r;
    }
    public static long 构造_3(long theCurve, double theUFirst, double theULast) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theCurve;
        a[2] = Double.doubleToRawLongBits(theUFirst);
        a[3] = Double.doubleToRawLongBits(theULast);
        long r = OcctGen.occtCall(2905, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2906, a, box);
        return r;
    }
    public static void Reset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2907, a, box);
    }
    public static void Load(long self, long theCurve) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCurve;
        OcctGen.occtCall(2908, a, box);
    }
    public static void Load_2(long self, long theCurve, double theUFirst, double theULast) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theCurve;
        a[2] = Double.doubleToRawLongBits(theUFirst);
        a[3] = Double.doubleToRawLongBits(theULast);
        OcctGen.occtCall(2909, a, box);
    }
    public static long Curve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2910, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2911, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2912, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2913, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(2914, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(2915, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2916, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2917, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2918, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2919, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2920, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(2921, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2922, a, box);
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
        OcctGen.occtCall(2923, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2924, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(2925, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2926, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2927, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2928, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2929, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2930, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2931, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2932, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2933, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2934, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2935, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2936, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2937, a, box);
        return r;
    }
    public static long OffsetCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2938, a, box);
        return r;
    }
    }

    public static final class GeomAdaptor_Surface {
        private GeomAdaptor_Surface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2939, a, box);
        return r;
    }
    public static long 构造_2(long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theSurf;
        long r = OcctGen.occtCall(2940, a, box);
        return r;
    }
    public static long 构造_3(
            long theSurf, double theUFirst, double theULast, double theVFirst, double theVLast,
            double theTolU, double theTolV) {
        long[] a = new long[8];
        Object[] box = null;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theUFirst);
        a[3] = Double.doubleToRawLongBits(theULast);
        a[4] = Double.doubleToRawLongBits(theVFirst);
        a[5] = Double.doubleToRawLongBits(theVLast);
        a[6] = Double.doubleToRawLongBits(theTolU);
        a[7] = Double.doubleToRawLongBits(theTolV);
        long r = OcctGen.occtCall(2941, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2942, a, box);
        return r;
    }
    public static void Load(long self, long theSurf) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurf;
        OcctGen.occtCall(2943, a, box);
    }
    public static void Load_2(
            long self, long theSurf, double theUFirst, double theULast, double theVFirst,
            double theVLast, double theTolU, double theTolV) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurf;
        a[2] = Double.doubleToRawLongBits(theUFirst);
        a[3] = Double.doubleToRawLongBits(theULast);
        a[4] = Double.doubleToRawLongBits(theVFirst);
        a[5] = Double.doubleToRawLongBits(theVLast);
        a[6] = Double.doubleToRawLongBits(theTolU);
        a[7] = Double.doubleToRawLongBits(theTolV);
        OcctGen.occtCall(2944, a, box);
    }
    public static long Surface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2945, a, box);
        return r;
    }
    public static double FirstUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2946, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2947, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2948, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2949, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int UContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2950, a, box);
        return (int) r;
    }
    public static int VContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2951, a, box);
        return (int) r;
    }
    public static int NbUIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(2952, a, box);
        return (int) r;
    }
    public static int NbVIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(2953, a, box);
        return (int) r;
    }
    public static long UTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(2954, a, box);
        return r;
    }
    public static long VTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(2955, a, box);
        return r;
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2956, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2957, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2958, a, box);
        return r != 0;
    }
    public static double UPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2959, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2960, a, box);
        return r != 0;
    }
    public static double VPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2961, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U, double V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(2962, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(2963, a, box);
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
        OcctGen.occtCall(2964, a, box);
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
        OcctGen.occtCall(2965, a, box);
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
        OcctGen.occtCall(2966, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(2967, a, box);
        return r;
    }
    public static double UResolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(2968, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VResolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(2969, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2970, a, box);
        return (int) r;
    }
    public static long Plane(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2971, a, box);
        return r;
    }
    public static long Cylinder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2972, a, box);
        return r;
    }
    public static long Cone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2973, a, box);
        return r;
    }
    public static long Sphere(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2974, a, box);
        return r;
    }
    public static long Torus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2975, a, box);
        return r;
    }
    public static int UDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2976, a, box);
        return (int) r;
    }
    public static int NbUPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2977, a, box);
        return (int) r;
    }
    public static int VDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2978, a, box);
        return (int) r;
    }
    public static int NbVPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2979, a, box);
        return (int) r;
    }
    public static int NbUKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2980, a, box);
        return (int) r;
    }
    public static int NbVKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2981, a, box);
        return (int) r;
    }
    public static boolean IsURational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2982, a, box);
        return r != 0;
    }
    public static boolean IsVRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2983, a, box);
        return r != 0;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2984, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2985, a, box);
        return r;
    }
    public static long AxeOfRevolution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2986, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2987, a, box);
        return r;
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2988, a, box);
        return r;
    }
    public static long BasisSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2989, a, box);
        return r;
    }
    public static double OffsetValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2990, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GeomAdaptor_SurfaceOfLinearExtrusion {
        private GeomAdaptor_SurfaceOfLinearExtrusion() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2991, a, box);
        return r;
    }
    public static long 构造_2(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(2992, a, box);
        return r;
    }
    public static long 构造_3(long C, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = V;
        long r = OcctGen.occtCall(2993, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2994, a, box);
        return r;
    }
    public static void Load(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(2995, a, box);
    }
    public static void Load_2(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(2996, a, box);
    }
    public static double FirstUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2997, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2998, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2999, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3000, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int UContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3001, a, box);
        return (int) r;
    }
    public static int VContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3002, a, box);
        return (int) r;
    }
    public static int NbUIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(3003, a, box);
        return (int) r;
    }
    public static int NbVIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(3004, a, box);
        return (int) r;
    }
    public static long UTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(3005, a, box);
        return r;
    }
    public static long VTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(3006, a, box);
        return r;
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3007, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3008, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3009, a, box);
        return r != 0;
    }
    public static double UPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3010, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3011, a, box);
        return r != 0;
    }
    public static double VPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3012, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double UResolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(3013, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VResolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(3014, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3015, a, box);
        return (int) r;
    }
    public static long Plane(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3016, a, box);
        return r;
    }
    public static long Cylinder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3017, a, box);
        return r;
    }
    public static long Cone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3018, a, box);
        return r;
    }
    public static long Sphere(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3019, a, box);
        return r;
    }
    public static long Torus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3020, a, box);
        return r;
    }
    public static int UDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3021, a, box);
        return (int) r;
    }
    public static int NbUPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3022, a, box);
        return (int) r;
    }
    public static boolean IsURational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3023, a, box);
        return r != 0;
    }
    public static boolean IsVRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3024, a, box);
        return r != 0;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3025, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3026, a, box);
        return r;
    }
    public static long AxeOfRevolution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3027, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3028, a, box);
        return r;
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3029, a, box);
        return r;
    }
    }

    public static final class GeomAdaptor_SurfaceOfRevolution {
        private GeomAdaptor_SurfaceOfRevolution() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(3030, a, box);
        return r;
    }
    public static long 构造_2(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(3031, a, box);
        return r;
    }
    public static long 构造_3(long C, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = V;
        long r = OcctGen.occtCall(3032, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3033, a, box);
        return r;
    }
    public static void Load(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(3034, a, box);
    }
    public static void Load_2(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3035, a, box);
    }
    public static long AxeOfRevolution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3036, a, box);
        return r;
    }
    public static double FirstUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3037, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastUParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3038, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3039, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastVParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3040, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int UContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3041, a, box);
        return (int) r;
    }
    public static int VContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3042, a, box);
        return (int) r;
    }
    public static int NbUIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(3043, a, box);
        return (int) r;
    }
    public static int NbVIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(3044, a, box);
        return (int) r;
    }
    public static long UTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(3045, a, box);
        return r;
    }
    public static long VTrim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(3046, a, box);
        return r;
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3047, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3048, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3049, a, box);
        return r != 0;
    }
    public static double UPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3050, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3051, a, box);
        return r != 0;
    }
    public static double VPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3052, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double UResolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(3053, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VResolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(3054, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3055, a, box);
        return (int) r;
    }
    public static long Plane(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3056, a, box);
        return r;
    }
    public static long Cylinder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3057, a, box);
        return r;
    }
    public static long Cone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3058, a, box);
        return r;
    }
    public static long Sphere(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3059, a, box);
        return r;
    }
    public static long Torus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3060, a, box);
        return r;
    }
    public static int VDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3061, a, box);
        return (int) r;
    }
    public static int NbVPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3062, a, box);
        return (int) r;
    }
    public static int NbVKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3063, a, box);
        return (int) r;
    }
    public static boolean IsURational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3064, a, box);
        return r != 0;
    }
    public static boolean IsVRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3065, a, box);
        return r != 0;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3066, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3067, a, box);
        return r;
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3068, a, box);
        return r;
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3069, a, box);
        return r;
    }
    }

    public static final class GeomLProp_CLProps {
        private GeomLProp_CLProps() {}

    public static long 构造(long C, int N, double Resolution) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = N;
        a[3] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(3070, a, box);
        return r;
    }
    public static long 构造_2(long C, double U, int N, double Resolution) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = N;
        a[4] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(3071, a, box);
        return r;
    }
    public static long 构造_3(int N, double Resolution) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = N;
        a[2] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(3072, a, box);
        return r;
    }
    public static void SetParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        OcctGen.occtCall(3073, a, box);
    }
    public static void SetCurve(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(3074, a, box);
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3075, a, box);
        return r;
    }
    public static long D1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3076, a, box);
        return r;
    }
    public static long D2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3077, a, box);
        return r;
    }
    public static long D3(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3078, a, box);
        return r;
    }
    public static boolean IsTangentDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3079, a, box);
        return r != 0;
    }
    public static void Tangent(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(3080, a, box);
    }
    public static double Curvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3081, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Normal(long self, long N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(3082, a, box);
    }
    public static void CentreOfCurvature(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(3083, a, box);
    }
    }

    public static final class GeomLProp_CurveTool {
        private GeomLProp_CurveTool() {}

    public static void Value(long C, double U, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        OcctGen.occtCall(3084, a, box);
    }
    public static void D1(long C, double U, long P, long V1) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        a[4] = V1;
        OcctGen.occtCall(3085, a, box);
    }
    public static void D2(long C, double U, long P, long V1, long V2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        a[4] = V1;
        a[5] = V2;
        OcctGen.occtCall(3086, a, box);
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
        OcctGen.occtCall(3087, a, box);
    }
    public static int Continuity(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(3088, a, box);
        return (int) r;
    }
    public static double FirstParameter(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(3089, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(3090, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GeomLProp_SLProps {
        private GeomLProp_SLProps() {}

    public static long 构造(long S, double U, double V, int N, double Resolution) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = N;
        a[5] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(3091, a, box);
        return r;
    }
    public static long 构造_2(long S, int N, double Resolution) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = N;
        a[3] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(3092, a, box);
        return r;
    }
    public static long 构造_3(int N, double Resolution) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = N;
        a[2] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(3093, a, box);
        return r;
    }
    public static void SetSurface(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(3094, a, box);
    }
    public static void SetParameters(long self, double U, double V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        OcctGen.occtCall(3095, a, box);
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3096, a, box);
        return r;
    }
    public static long D1U(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3097, a, box);
        return r;
    }
    public static long D1V(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3098, a, box);
        return r;
    }
    public static long D2U(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3099, a, box);
        return r;
    }
    public static long D2V(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3100, a, box);
        return r;
    }
    public static long DUV(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3101, a, box);
        return r;
    }
    public static boolean IsTangentUDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3102, a, box);
        return r != 0;
    }
    public static void TangentU(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(3103, a, box);
    }
    public static boolean IsTangentVDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3104, a, box);
        return r != 0;
    }
    public static void TangentV(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(3105, a, box);
    }
    public static boolean IsNormalDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3106, a, box);
        return r != 0;
    }
    public static long Normal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3107, a, box);
        return r;
    }
    public static boolean IsCurvatureDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3108, a, box);
        return r != 0;
    }
    public static boolean IsUmbilic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3109, a, box);
        return r != 0;
    }
    public static double MaxCurvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3110, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinCurvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3111, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void CurvatureDirections(long self, long MaxD, long MinD) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = MaxD;
        a[2] = MinD;
        OcctGen.occtCall(3112, a, box);
    }
    public static double MeanCurvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3113, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double GaussianCurvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3114, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class GeomLProp_SurfaceTool {
        private GeomLProp_SurfaceTool() {}

    public static void Value(long S, double U, double V, long P) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = P;
        OcctGen.occtCall(3115, a, box);
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
        OcctGen.occtCall(3116, a, box);
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
        OcctGen.occtCall(3117, a, box);
    }
    public static long DN(long S, double U, double V, int IU, int IV) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = Double.doubleToRawLongBits(V);
        a[4] = IU;
        a[5] = IV;
        long r = OcctGen.occtCall(3118, a, box);
        return r;
    }
    public static int Continuity(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(3119, a, box);
        return (int) r;
    }
    public static void Bounds(
            long S, double[] U1Out, double[] V1Out, double[] U2Out, double[] V2Out) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        OcctGen.occtCall(3120, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[4]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[5]);
    }
    }

    public static final class Geom_Axis1Placement {
        private Geom_Axis1Placement() {}

    public static long 构造(long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A1;
        long r = OcctGen.occtCall(3145, a, box);
        return r;
    }
    public static long 构造_2(long P, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P;
        a[2] = V;
        long r = OcctGen.occtCall(3146, a, box);
        return r;
    }
    public static long Ax1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3147, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3148, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3149, a, box);
        return r;
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3150, a, box);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3151, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3152, a, box);
        return r;
    }
    }

    public static final class Geom_Axis2Placement {
        private Geom_Axis2Placement() {}

    public static long 构造(long A2) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A2;
        long r = OcctGen.occtCall(3153, a, box);
        return r;
    }
    public static long 构造_2(long P, long N, long Vx) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = P;
        a[2] = N;
        a[3] = Vx;
        long r = OcctGen.occtCall(3154, a, box);
        return r;
    }
    public static void SetAx2(long self, long A2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A2;
        OcctGen.occtCall(3155, a, box);
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3156, a, box);
    }
    public static void SetXDirection(long self, long Vx) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Vx;
        OcctGen.occtCall(3157, a, box);
    }
    public static void SetYDirection(long self, long Vy) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Vy;
        OcctGen.occtCall(3158, a, box);
    }
    public static long Ax2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3159, a, box);
        return r;
    }
    public static long XDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3160, a, box);
        return r;
    }
    public static long YDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3161, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3162, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3163, a, box);
        return r;
    }
    }

    public static final class Geom_AxisPlacement {
        private Geom_AxisPlacement() {}

    public static void SetAxis(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        OcctGen.occtCall(3164, a, box);
    }
    public static void SetLocation(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(3165, a, box);
    }
    public static double Angle(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3166, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3167, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3168, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3169, a, box);
        return r;
    }
    }

    public static final class Geom_BSplineCurve {
        private Geom_BSplineCurve() {}

    public static void IncreaseDegree(long self, int Degree) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Degree;
        OcctGen.occtCall(3170, a, box);
    }
    public static void IncreaseMultiplicity(long self, int Index, int M) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = M;
        OcctGen.occtCall(3171, a, box);
    }
    public static void IncreaseMultiplicity_2(long self, int I1, int I2, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = I1;
        a[2] = I2;
        a[3] = M;
        OcctGen.occtCall(3172, a, box);
    }
    public static void IncrementMultiplicity(long self, int I1, int I2, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = I1;
        a[2] = I2;
        a[3] = M;
        OcctGen.occtCall(3173, a, box);
    }
    public static void InsertKnot(
            long self, double U, int M, double ParametricTolerance, boolean Add) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = M;
        a[3] = Double.doubleToRawLongBits(ParametricTolerance);
        a[4] = Add ? 1L : 0L;
        OcctGen.occtCall(3174, a, box);
    }
    public static boolean RemoveKnot(long self, int Index, int M, double Tolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = M;
        a[3] = Double.doubleToRawLongBits(Tolerance);
        long r = OcctGen.occtCall(3175, a, box);
        return r != 0;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3176, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3177, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Segment(long self, double U1, double U2, double theTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        a[3] = Double.doubleToRawLongBits(theTolerance);
        OcctGen.occtCall(3178, a, box);
    }
    public static void SetKnot(long self, int Index, double K) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = Double.doubleToRawLongBits(K);
        OcctGen.occtCall(3179, a, box);
    }
    public static void SetKnot_2(long self, int Index, double K, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = Double.doubleToRawLongBits(K);
        a[3] = M;
        OcctGen.occtCall(3180, a, box);
    }
    public static void PeriodicNormalization(long self, double[] UOut) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3181, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
    }
    public static void SetPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3182, a, box);
    }
    public static void SetOrigin(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(3183, a, box);
    }
    public static void SetOrigin_2(long self, double U, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(3184, a, box);
    }
    public static void SetNotPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3185, a, box);
    }
    public static void SetPole(long self, int Index, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        OcctGen.occtCall(3186, a, box);
    }
    public static void SetPole_2(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3187, a, box);
    }
    public static void SetWeight(long self, int Index, double Weight) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3188, a, box);
    }
    public static void MovePoint(
            long self, double U, long P, int Index1, int Index2, int[] FirstModifiedPoleOut,
            int[] LastModifiedPoleOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = Index1;
        a[4] = Index2;
        OcctGen.occtCall(3189, a, box);
        if (FirstModifiedPoleOut != null && FirstModifiedPoleOut.length != 0) FirstModifiedPoleOut[0] = (int) a[5];
        if (LastModifiedPoleOut != null && LastModifiedPoleOut.length != 0) LastModifiedPoleOut[0] = (int) a[6];
    }
    public static void MovePointAndTangent(
            long self, double U, long P, long Tangent, double Tolerance, int StartingCondition,
            int EndingCondition, int[] ErrorStatusOut) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = Tangent;
        a[4] = Double.doubleToRawLongBits(Tolerance);
        a[5] = StartingCondition;
        a[6] = EndingCondition;
        OcctGen.occtCall(3190, a, box);
        if (ErrorStatusOut != null && ErrorStatusOut.length != 0) ErrorStatusOut[0] = (int) a[7];
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3191, a, box);
        return r != 0;
    }
    public static boolean IsG1(long self, double theTf, double theTl, double theAngTol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTf);
        a[2] = Double.doubleToRawLongBits(theTl);
        a[3] = Double.doubleToRawLongBits(theAngTol);
        long r = OcctGen.occtCall(3192, a, box);
        return r != 0;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3193, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3194, a, box);
        return r != 0;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3195, a, box);
        return r != 0;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3196, a, box);
        return (int) r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3197, a, box);
        return (int) r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3198, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3199, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3200, a, box);
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
        OcctGen.occtCall(3201, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3202, a, box);
        return r;
    }
    public static long LocalValue(long self, double U, int FromK1, int ToK2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = FromK1;
        a[3] = ToK2;
        long r = OcctGen.occtCall(3203, a, box);
        return r;
    }
    public static void LocalD0(long self, double U, int FromK1, int ToK2, long P) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = FromK1;
        a[3] = ToK2;
        a[4] = P;
        OcctGen.occtCall(3204, a, box);
    }
    public static void LocalD1(long self, double U, int FromK1, int ToK2, long P, long V1) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = FromK1;
        a[3] = ToK2;
        a[4] = P;
        a[5] = V1;
        OcctGen.occtCall(3205, a, box);
    }
    public static void LocalD2(
            long self, double U, int FromK1, int ToK2, long P, long V1, long V2) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = FromK1;
        a[3] = ToK2;
        a[4] = P;
        a[5] = V1;
        a[6] = V2;
        OcctGen.occtCall(3206, a, box);
    }
    public static void LocalD3(
            long self, double U, int FromK1, int ToK2, long P, long V1, long V2, long V3) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = FromK1;
        a[3] = ToK2;
        a[4] = P;
        a[5] = V1;
        a[6] = V2;
        a[7] = V3;
        OcctGen.occtCall(3207, a, box);
    }
    public static long LocalDN(long self, double U, int FromK1, int ToK2, int N) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = FromK1;
        a[3] = ToK2;
        a[4] = N;
        long r = OcctGen.occtCall(3208, a, box);
        return r;
    }
    public static long EndPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3209, a, box);
        return r;
    }
    public static int FirstUKnotIndex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3210, a, box);
        return (int) r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3211, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Knot(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(3212, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int KnotDistribution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3213, a, box);
        return (int) r;
    }
    public static int LastUKnotIndex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3214, a, box);
        return (int) r;
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3215, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void LocateU(
            long self, double U, double ParametricTolerance, int[] I1Out, int[] I2Out,
            boolean WithKnotRepetition) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(ParametricTolerance);
        a[5] = WithKnotRepetition ? 1L : 0L;
        OcctGen.occtCall(3216, a, box);
        if (I1Out != null && I1Out.length != 0) I1Out[0] = (int) a[3];
        if (I2Out != null && I2Out.length != 0) I2Out[0] = (int) a[4];
    }
    public static int Multiplicity(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(3217, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3218, a, box);
        return (int) r;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3219, a, box);
        return (int) r;
    }
    public static long Pole(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(3220, a, box);
        return r;
    }
    public static long StartPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3221, a, box);
        return r;
    }
    public static double Weight(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(3222, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3223, a, box);
    }
    public static int MaxDegree() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(3224, a, box);
        return (int) r;
    }
    public static void Resolution(long self, double Tolerance3D, double[] UToleranceOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tolerance3D);
        OcctGen.occtCall(3225, a, box);
        if (UToleranceOut != null && UToleranceOut.length != 0) UToleranceOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3226, a, box);
        return r;
    }
    public static boolean IsEqual(long self, long theOther, double thePreci) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(thePreci);
        long r = OcctGen.occtCall(3227, a, box);
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3228, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_BSplineSurface {
        private Geom_BSplineSurface() {}

    public static void ExchangeUV(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3229, a, box);
    }
    public static void SetUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3230, a, box);
    }
    public static void SetVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3231, a, box);
    }
    public static void PeriodicNormalization(long self, double[] UOut, double[] VOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3232, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static void SetUOrigin(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(3233, a, box);
    }
    public static void SetVOrigin(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(3234, a, box);
    }
    public static void SetUNotPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3235, a, box);
    }
    public static void SetVNotPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3236, a, box);
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3237, a, box);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3238, a, box);
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3239, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3240, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void IncreaseDegree(long self, int UDegree, int VDegree) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = UDegree;
        a[2] = VDegree;
        OcctGen.occtCall(3241, a, box);
    }
    public static boolean RemoveUKnot(long self, int Index, int M, double Tolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = M;
        a[3] = Double.doubleToRawLongBits(Tolerance);
        long r = OcctGen.occtCall(3242, a, box);
        return r != 0;
    }
    public static boolean RemoveVKnot(long self, int Index, int M, double Tolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = M;
        a[3] = Double.doubleToRawLongBits(Tolerance);
        long r = OcctGen.occtCall(3243, a, box);
        return r != 0;
    }
    public static void IncreaseUMultiplicity(long self, int UIndex, int M) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = M;
        OcctGen.occtCall(3244, a, box);
    }
    public static void IncreaseUMultiplicity_2(long self, int FromI1, int ToI2, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = FromI1;
        a[2] = ToI2;
        a[3] = M;
        OcctGen.occtCall(3245, a, box);
    }
    public static void IncrementUMultiplicity(long self, int FromI1, int ToI2, int Step) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = FromI1;
        a[2] = ToI2;
        a[3] = Step;
        OcctGen.occtCall(3246, a, box);
    }
    public static void IncreaseVMultiplicity(long self, int VIndex, int M) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = VIndex;
        a[2] = M;
        OcctGen.occtCall(3247, a, box);
    }
    public static void IncreaseVMultiplicity_2(long self, int FromI1, int ToI2, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = FromI1;
        a[2] = ToI2;
        a[3] = M;
        OcctGen.occtCall(3248, a, box);
    }
    public static void IncrementVMultiplicity(long self, int FromI1, int ToI2, int Step) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = FromI1;
        a[2] = ToI2;
        a[3] = Step;
        OcctGen.occtCall(3249, a, box);
    }
    public static void InsertUKnot(
            long self, double U, int M, double ParametricTolerance, boolean Add) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = M;
        a[3] = Double.doubleToRawLongBits(ParametricTolerance);
        a[4] = Add ? 1L : 0L;
        OcctGen.occtCall(3250, a, box);
    }
    public static void InsertVKnot(
            long self, double V, int M, double ParametricTolerance, boolean Add) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        a[2] = M;
        a[3] = Double.doubleToRawLongBits(ParametricTolerance);
        a[4] = Add ? 1L : 0L;
        OcctGen.occtCall(3251, a, box);
    }
    public static void Segment(
            long self, double U1, double U2, double V1, double V2, double theUTolerance,
            double theVTolerance) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        a[3] = Double.doubleToRawLongBits(V1);
        a[4] = Double.doubleToRawLongBits(V2);
        a[5] = Double.doubleToRawLongBits(theUTolerance);
        a[6] = Double.doubleToRawLongBits(theVTolerance);
        OcctGen.occtCall(3252, a, box);
    }
    public static void CheckAndSegment(
            long self, double U1, double U2, double V1, double V2, double theUTolerance,
            double theVTolerance) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        a[3] = Double.doubleToRawLongBits(V1);
        a[4] = Double.doubleToRawLongBits(V2);
        a[5] = Double.doubleToRawLongBits(theUTolerance);
        a[6] = Double.doubleToRawLongBits(theVTolerance);
        OcctGen.occtCall(3253, a, box);
    }
    public static void SetUKnot(long self, int UIndex, double K) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = Double.doubleToRawLongBits(K);
        OcctGen.occtCall(3254, a, box);
    }
    public static void SetUKnot_2(long self, int UIndex, double K, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = Double.doubleToRawLongBits(K);
        a[3] = M;
        OcctGen.occtCall(3255, a, box);
    }
    public static void SetVKnot(long self, int VIndex, double K) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = VIndex;
        a[2] = Double.doubleToRawLongBits(K);
        OcctGen.occtCall(3256, a, box);
    }
    public static void SetVKnot_2(long self, int VIndex, double K, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = VIndex;
        a[2] = Double.doubleToRawLongBits(K);
        a[3] = M;
        OcctGen.occtCall(3257, a, box);
    }
    public static void LocateU(
            long self, double U, double ParametricTolerance, int[] I1Out, int[] I2Out,
            boolean WithKnotRepetition) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(ParametricTolerance);
        a[5] = WithKnotRepetition ? 1L : 0L;
        OcctGen.occtCall(3258, a, box);
        if (I1Out != null && I1Out.length != 0) I1Out[0] = (int) a[3];
        if (I2Out != null && I2Out.length != 0) I2Out[0] = (int) a[4];
    }
    public static void LocateV(
            long self, double V, double ParametricTolerance, int[] I1Out, int[] I2Out,
            boolean WithKnotRepetition) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        a[2] = Double.doubleToRawLongBits(ParametricTolerance);
        a[5] = WithKnotRepetition ? 1L : 0L;
        OcctGen.occtCall(3259, a, box);
        if (I1Out != null && I1Out.length != 0) I1Out[0] = (int) a[3];
        if (I2Out != null && I2Out.length != 0) I2Out[0] = (int) a[4];
    }
    public static void SetPole(long self, int UIndex, int VIndex, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        a[3] = P;
        OcctGen.occtCall(3260, a, box);
    }
    public static void SetPole_2(long self, int UIndex, int VIndex, long P, double Weight) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        a[3] = P;
        a[4] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3261, a, box);
    }
    public static void SetWeight(long self, int UIndex, int VIndex, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3262, a, box);
    }
    public static void MovePoint(
            long self, double U, double V, long P, int UIndex1, int UIndex2, int VIndex1,
            int VIndex2, int[] UFirstIndexOut, int[] ULastIndexOut, int[] VFirstIndexOut,
            int[] VLastIndexOut) {
        long[] a = new long[12];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        a[4] = UIndex1;
        a[5] = UIndex2;
        a[6] = VIndex1;
        a[7] = VIndex2;
        OcctGen.occtCall(3263, a, box);
        if (UFirstIndexOut != null && UFirstIndexOut.length != 0) UFirstIndexOut[0] = (int) a[8];
        if (ULastIndexOut != null && ULastIndexOut.length != 0) ULastIndexOut[0] = (int) a[9];
        if (VFirstIndexOut != null && VFirstIndexOut.length != 0) VFirstIndexOut[0] = (int) a[10];
        if (VLastIndexOut != null && VLastIndexOut.length != 0) VLastIndexOut[0] = (int) a[11];
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3264, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3265, a, box);
        return r != 0;
    }
    public static boolean IsCNu(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3266, a, box);
        return r != 0;
    }
    public static boolean IsCNv(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3267, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3268, a, box);
        return r != 0;
    }
    public static boolean IsURational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3269, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3270, a, box);
        return r != 0;
    }
    public static boolean IsVRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3271, a, box);
        return r != 0;
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3272, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3273, a, box);
        return (int) r;
    }
    public static int FirstUKnotIndex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3274, a, box);
        return (int) r;
    }
    public static int FirstVKnotIndex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3275, a, box);
        return (int) r;
    }
    public static int LastUKnotIndex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3276, a, box);
        return (int) r;
    }
    public static int LastVKnotIndex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3277, a, box);
        return (int) r;
    }
    public static int NbUKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3278, a, box);
        return (int) r;
    }
    public static int NbUPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3279, a, box);
        return (int) r;
    }
    public static int NbVKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3280, a, box);
        return (int) r;
    }
    public static int NbVPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3281, a, box);
        return (int) r;
    }
    public static long Pole(long self, int UIndex, int VIndex) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        long r = OcctGen.occtCall(3282, a, box);
        return r;
    }
    public static int UDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3283, a, box);
        return (int) r;
    }
    public static double UKnot(long self, int UIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        long r = OcctGen.occtCall(3284, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int UKnotDistribution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3285, a, box);
        return (int) r;
    }
    public static int UMultiplicity(long self, int UIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        long r = OcctGen.occtCall(3286, a, box);
        return (int) r;
    }
    public static int VDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3287, a, box);
        return (int) r;
    }
    public static double VKnot(long self, int VIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = VIndex;
        long r = OcctGen.occtCall(3288, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int VKnotDistribution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3289, a, box);
        return (int) r;
    }
    public static int VMultiplicity(long self, int VIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = VIndex;
        long r = OcctGen.occtCall(3290, a, box);
        return (int) r;
    }
    public static double Weight(long self, int UIndex, int VIndex) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        long r = OcctGen.occtCall(3291, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3292, a, box);
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
        OcctGen.occtCall(3293, a, box);
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
        OcctGen.occtCall(3294, a, box);
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
        OcctGen.occtCall(3295, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3296, a, box);
        return r;
    }
    public static void LocalD0(
            long self, double U, double V, int FromUK1, int ToUK2, int FromVK1, int ToVK2, long P) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = FromUK1;
        a[4] = ToUK2;
        a[5] = FromVK1;
        a[6] = ToVK2;
        a[7] = P;
        OcctGen.occtCall(3297, a, box);
    }
    public static void LocalD1(
            long self, double U, double V, int FromUK1, int ToUK2, int FromVK1, int ToVK2, long P,
            long D1U, long D1V) {
        long[] a = new long[10];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = FromUK1;
        a[4] = ToUK2;
        a[5] = FromVK1;
        a[6] = ToVK2;
        a[7] = P;
        a[8] = D1U;
        a[9] = D1V;
        OcctGen.occtCall(3298, a, box);
    }
    public static void LocalD2(
            long self, double U, double V, int FromUK1, int ToUK2, int FromVK1, int ToVK2, long P,
            long D1U, long D1V, long D2U, long D2V, long D2UV) {
        long[] a = new long[13];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = FromUK1;
        a[4] = ToUK2;
        a[5] = FromVK1;
        a[6] = ToVK2;
        a[7] = P;
        a[8] = D1U;
        a[9] = D1V;
        a[10] = D2U;
        a[11] = D2V;
        a[12] = D2UV;
        OcctGen.occtCall(3299, a, box);
    }
    public static void LocalD3(
            long self, double U, double V, int FromUK1, int ToUK2, int FromVK1, int ToVK2, long P,
            long D1U, long D1V, long D2U, long D2V, long D2UV, long D3U, long D3V, long D3UUV,
            long D3UVV) {
        long[] a = new long[17];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = FromUK1;
        a[4] = ToUK2;
        a[5] = FromVK1;
        a[6] = ToVK2;
        a[7] = P;
        a[8] = D1U;
        a[9] = D1V;
        a[10] = D2U;
        a[11] = D2V;
        a[12] = D2UV;
        a[13] = D3U;
        a[14] = D3V;
        a[15] = D3UUV;
        a[16] = D3UVV;
        OcctGen.occtCall(3300, a, box);
    }
    public static long LocalDN(
            long self, double U, double V, int FromUK1, int ToUK2, int FromVK1, int ToVK2, int Nu,
            int Nv) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = FromUK1;
        a[4] = ToUK2;
        a[5] = FromVK1;
        a[6] = ToVK2;
        a[7] = Nu;
        a[8] = Nv;
        long r = OcctGen.occtCall(3301, a, box);
        return r;
    }
    public static long LocalValue(
            long self, double U, double V, int FromUK1, int ToUK2, int FromVK1, int ToVK2) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = FromUK1;
        a[4] = ToUK2;
        a[5] = FromVK1;
        a[6] = ToVK2;
        long r = OcctGen.occtCall(3302, a, box);
        return r;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3303, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3304, a, box);
        return r;
    }
    public static long UIso_2(long self, double U, boolean CheckRational) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = CheckRational ? 1L : 0L;
        long r = OcctGen.occtCall(3305, a, box);
        return r;
    }
    public static long VIso_2(long self, double V, boolean CheckRational) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        a[2] = CheckRational ? 1L : 0L;
        long r = OcctGen.occtCall(3306, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3307, a, box);
    }
    public static int MaxDegree() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(3308, a, box);
        return (int) r;
    }
    public static void Resolution(
            long self, double Tolerance3D, double[] UToleranceOut, double[] VToleranceOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tolerance3D);
        OcctGen.occtCall(3309, a, box);
        if (UToleranceOut != null && UToleranceOut.length != 0) UToleranceOut[0] = Double.longBitsToDouble(a[2]);
        if (VToleranceOut != null && VToleranceOut.length != 0) VToleranceOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3310, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3311, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_BezierCurve {
        private Geom_BezierCurve() {}

    public static void Increase(long self, int Degree) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Degree;
        OcctGen.occtCall(3312, a, box);
    }
    public static void InsertPoleAfter(long self, int Index, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        OcctGen.occtCall(3313, a, box);
    }
    public static void InsertPoleAfter_2(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3314, a, box);
    }
    public static void InsertPoleBefore(long self, int Index, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        OcctGen.occtCall(3315, a, box);
    }
    public static void InsertPoleBefore_2(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3316, a, box);
    }
    public static void RemovePole(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(3317, a, box);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3318, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3319, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Segment(long self, double U1, double U2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        OcctGen.occtCall(3320, a, box);
    }
    public static void SetPole(long self, int Index, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        OcctGen.occtCall(3321, a, box);
    }
    public static void SetPole_2(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3322, a, box);
    }
    public static void SetWeight(long self, int Index, double Weight) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3323, a, box);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3324, a, box);
        return r != 0;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3325, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3326, a, box);
        return r != 0;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3327, a, box);
        return r != 0;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3328, a, box);
        return (int) r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3329, a, box);
        return (int) r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3330, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3331, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3332, a, box);
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
        OcctGen.occtCall(3333, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3334, a, box);
        return r;
    }
    public static long StartPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3335, a, box);
        return r;
    }
    public static long EndPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3336, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3337, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3338, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3339, a, box);
        return (int) r;
    }
    public static long Pole(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(3340, a, box);
        return r;
    }
    public static double Weight(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(3341, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3342, a, box);
    }
    public static int MaxDegree() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(3343, a, box);
        return (int) r;
    }
    public static void Resolution(long self, double Tolerance3D, double[] UToleranceOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tolerance3D);
        OcctGen.occtCall(3344, a, box);
        if (UToleranceOut != null && UToleranceOut.length != 0) UToleranceOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3345, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3346, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_BezierSurface {
        private Geom_BezierSurface() {}

    public static void ExchangeUV(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3347, a, box);
    }
    public static void Increase(long self, int UDeg, int VDeg) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = UDeg;
        a[2] = VDeg;
        OcctGen.occtCall(3348, a, box);
    }
    public static void RemovePoleCol(long self, int VIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = VIndex;
        OcctGen.occtCall(3349, a, box);
    }
    public static void RemovePoleRow(long self, int UIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        OcctGen.occtCall(3350, a, box);
    }
    public static void Segment(long self, double U1, double U2, double V1, double V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        a[3] = Double.doubleToRawLongBits(V1);
        a[4] = Double.doubleToRawLongBits(V2);
        OcctGen.occtCall(3351, a, box);
    }
    public static void SetPole(long self, int UIndex, int VIndex, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        a[3] = P;
        OcctGen.occtCall(3352, a, box);
    }
    public static void SetPole_2(long self, int UIndex, int VIndex, long P, double Weight) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        a[3] = P;
        a[4] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3353, a, box);
    }
    public static void SetWeight(long self, int UIndex, int VIndex, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(3354, a, box);
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3355, a, box);
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3356, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3357, a, box);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3358, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3359, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3360, a, box);
        return (int) r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3361, a, box);
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
        OcctGen.occtCall(3362, a, box);
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
        OcctGen.occtCall(3363, a, box);
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
        OcctGen.occtCall(3364, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3365, a, box);
        return r;
    }
    public static int NbUPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3366, a, box);
        return (int) r;
    }
    public static int NbVPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3367, a, box);
        return (int) r;
    }
    public static long Pole(long self, int UIndex, int VIndex) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        long r = OcctGen.occtCall(3368, a, box);
        return r;
    }
    public static int UDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3369, a, box);
        return (int) r;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3370, a, box);
        return r;
    }
    public static int VDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3371, a, box);
        return (int) r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3372, a, box);
        return r;
    }
    public static double Weight(long self, int UIndex, int VIndex) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = UIndex;
        a[2] = VIndex;
        long r = OcctGen.occtCall(3373, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3374, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3375, a, box);
        return r != 0;
    }
    public static boolean IsCNu(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3376, a, box);
        return r != 0;
    }
    public static boolean IsCNv(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3377, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3378, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3379, a, box);
        return r != 0;
    }
    public static boolean IsURational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3380, a, box);
        return r != 0;
    }
    public static boolean IsVRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3381, a, box);
        return r != 0;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3382, a, box);
    }
    public static int MaxDegree() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(3383, a, box);
        return (int) r;
    }
    public static void Resolution(
            long self, double Tolerance3D, double[] UToleranceOut, double[] VToleranceOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tolerance3D);
        OcctGen.occtCall(3384, a, box);
        if (UToleranceOut != null && UToleranceOut.length != 0) UToleranceOut[0] = Double.longBitsToDouble(a[2]);
        if (VToleranceOut != null && VToleranceOut.length != 0) VToleranceOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3385, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3386, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_BoundedCurve {
        private Geom_BoundedCurve() {}

    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3387, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_BoundedSurface {
        private Geom_BoundedSurface() {}

    }

    public static final class Geom_CartesianPoint {
        private Geom_CartesianPoint() {}

    public static long 构造(long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = P;
        long r = OcctGen.occtCall(3388, a, box);
        return r;
    }
    public static long 构造_2(double X, double Y, double Z) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        a[3] = Double.doubleToRawLongBits(Z);
        long r = OcctGen.occtCall(3389, a, box);
        return r;
    }
    public static void SetCoord(long self, double X, double Y, double Z) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        a[3] = Double.doubleToRawLongBits(Z);
        OcctGen.occtCall(3390, a, box);
    }
    public static void SetPnt(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(3391, a, box);
    }
    public static void SetX(long self, double X) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        OcctGen.occtCall(3392, a, box);
    }
    public static void SetY(long self, double Y) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(3393, a, box);
    }
    public static void SetZ(long self, double Z) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Z);
        OcctGen.occtCall(3394, a, box);
    }
    public static void Coord(long self, double[] XOut, double[] YOut, double[] ZOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3395, a, box);
        if (XOut != null && XOut.length != 0) XOut[0] = Double.longBitsToDouble(a[1]);
        if (YOut != null && YOut.length != 0) YOut[0] = Double.longBitsToDouble(a[2]);
        if (ZOut != null && ZOut.length != 0) ZOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long Pnt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3396, a, box);
        return r;
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3397, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3398, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Z(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3399, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3400, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3401, a, box);
        return r;
    }
    }

    public static final class Geom_Circle {
        private Geom_Circle() {}

    public static long 构造(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(3402, a, box);
        return r;
    }
    public static long 构造_2(long A2, double Radius) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = A2;
        a[2] = Double.doubleToRawLongBits(Radius);
        long r = OcctGen.occtCall(3403, a, box);
        return r;
    }
    public static void SetCirc(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(3404, a, box);
    }
    public static void SetRadius(long self, double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R);
        OcctGen.occtCall(3405, a, box);
    }
    public static long Circ(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3406, a, box);
        return r;
    }
    public static double Radius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3407, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3408, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3409, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3410, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3411, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3412, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3413, a, box);
        return r != 0;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3414, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3415, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3416, a, box);
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
        OcctGen.occtCall(3417, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3418, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3419, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3420, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3421, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Conic {
        private Geom_Conic() {}

    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(3422, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(3423, a, box);
    }
    public static void SetPosition(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(3424, a, box);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3425, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3426, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3427, a, box);
        return r;
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3428, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3429, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3430, a, box);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3431, a, box);
        return (int) r;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3432, a, box);
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3433, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_ConicalSurface {
        private Geom_ConicalSurface() {}

    public static long 构造(long A3, double Ang, double Radius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = A3;
        a[2] = Double.doubleToRawLongBits(Ang);
        a[3] = Double.doubleToRawLongBits(Radius);
        long r = OcctGen.occtCall(3434, a, box);
        return r;
    }
    public static long 构造_2(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(3435, a, box);
        return r;
    }
    public static void SetCone(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(3436, a, box);
    }
    public static void SetRadius(long self, double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R);
        OcctGen.occtCall(3437, a, box);
    }
    public static void SetSemiAngle(long self, double Ang) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Ang);
        OcctGen.occtCall(3438, a, box);
    }
    public static long Cone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3439, a, box);
        return r;
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3440, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3441, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3442, a, box);
    }
    public static void TransformParameters(long self, double[] UOut, double[] VOut, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[3] = T;
        OcctGen.occtCall(3443, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3444, a, box);
        return r;
    }
    public static long Apex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3445, a, box);
        return r;
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3446, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static void Coefficients(
            long self, double[] A1Out, double[] A2Out, double[] A3Out, double[] B1Out,
            double[] B2Out, double[] B3Out, double[] C1Out, double[] C2Out, double[] C3Out,
            double[] DOut) {
        long[] a = new long[11];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3447, a, box);
        if (A1Out != null && A1Out.length != 0) A1Out[0] = Double.longBitsToDouble(a[1]);
        if (A2Out != null && A2Out.length != 0) A2Out[0] = Double.longBitsToDouble(a[2]);
        if (A3Out != null && A3Out.length != 0) A3Out[0] = Double.longBitsToDouble(a[3]);
        if (B1Out != null && B1Out.length != 0) B1Out[0] = Double.longBitsToDouble(a[4]);
        if (B2Out != null && B2Out.length != 0) B2Out[0] = Double.longBitsToDouble(a[5]);
        if (B3Out != null && B3Out.length != 0) B3Out[0] = Double.longBitsToDouble(a[6]);
        if (C1Out != null && C1Out.length != 0) C1Out[0] = Double.longBitsToDouble(a[7]);
        if (C2Out != null && C2Out.length != 0) C2Out[0] = Double.longBitsToDouble(a[8]);
        if (C3Out != null && C3Out.length != 0) C3Out[0] = Double.longBitsToDouble(a[9]);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[10]);
    }
    public static double RefRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3448, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SemiAngle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3449, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3450, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3451, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3452, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3453, a, box);
        return r != 0;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3454, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3455, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3456, a, box);
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
        OcctGen.occtCall(3457, a, box);
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
        OcctGen.occtCall(3458, a, box);
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
        OcctGen.occtCall(3459, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3460, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3461, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3462, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3463, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Curve {
        private Geom_Curve() {}

    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(3464, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3465, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3466, a, box);
        return r;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3467, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3468, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3469, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_CylindricalSurface {
        private Geom_CylindricalSurface() {}

    public static long 构造(long A3, double Radius) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = A3;
        a[2] = Double.doubleToRawLongBits(Radius);
        long r = OcctGen.occtCall(3470, a, box);
        return r;
    }
    public static long 构造_2(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(3471, a, box);
        return r;
    }
    public static void SetCylinder(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(3472, a, box);
    }
    public static void SetRadius(long self, double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R);
        OcctGen.occtCall(3473, a, box);
    }
    public static long Cylinder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3474, a, box);
        return r;
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3475, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3476, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void TransformParameters(long self, double[] UOut, double[] VOut, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[3] = T;
        OcctGen.occtCall(3477, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3478, a, box);
        return r;
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3479, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static void Coefficients(
            long self, double[] A1Out, double[] A2Out, double[] A3Out, double[] B1Out,
            double[] B2Out, double[] B3Out, double[] C1Out, double[] C2Out, double[] C3Out,
            double[] DOut) {
        long[] a = new long[11];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3480, a, box);
        if (A1Out != null && A1Out.length != 0) A1Out[0] = Double.longBitsToDouble(a[1]);
        if (A2Out != null && A2Out.length != 0) A2Out[0] = Double.longBitsToDouble(a[2]);
        if (A3Out != null && A3Out.length != 0) A3Out[0] = Double.longBitsToDouble(a[3]);
        if (B1Out != null && B1Out.length != 0) B1Out[0] = Double.longBitsToDouble(a[4]);
        if (B2Out != null && B2Out.length != 0) B2Out[0] = Double.longBitsToDouble(a[5]);
        if (B3Out != null && B3Out.length != 0) B3Out[0] = Double.longBitsToDouble(a[6]);
        if (C1Out != null && C1Out.length != 0) C1Out[0] = Double.longBitsToDouble(a[7]);
        if (C2Out != null && C2Out.length != 0) C2Out[0] = Double.longBitsToDouble(a[8]);
        if (C3Out != null && C3Out.length != 0) C3Out[0] = Double.longBitsToDouble(a[9]);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[10]);
    }
    public static double Radius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3481, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3482, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3483, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3484, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3485, a, box);
        return r != 0;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3486, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3487, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3488, a, box);
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
        OcctGen.occtCall(3489, a, box);
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
        OcctGen.occtCall(3490, a, box);
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
        OcctGen.occtCall(3491, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3492, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3493, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3494, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3495, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Direction {
        private Geom_Direction() {}

    public static long 构造(double X, double Y, double Z) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        a[3] = Double.doubleToRawLongBits(Z);
        long r = OcctGen.occtCall(3496, a, box);
        return r;
    }
    public static long 构造_2(long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = V;
        long r = OcctGen.occtCall(3497, a, box);
        return r;
    }
    public static void SetCoord(long self, double X, double Y, double Z) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        a[3] = Double.doubleToRawLongBits(Z);
        OcctGen.occtCall(3498, a, box);
    }
    public static void SetDir(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3499, a, box);
    }
    public static void SetX(long self, double X) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        OcctGen.occtCall(3500, a, box);
    }
    public static void SetY(long self, double Y) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(3501, a, box);
    }
    public static void SetZ(long self, double Z) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Z);
        OcctGen.occtCall(3502, a, box);
    }
    public static long Dir(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3503, a, box);
        return r;
    }
    public static double Magnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3504, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareMagnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3505, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Cross(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(3506, a, box);
    }
    public static void CrossCross(long self, long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = V1;
        a[2] = V2;
        OcctGen.occtCall(3507, a, box);
    }
    public static long Crossed(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3508, a, box);
        return r;
    }
    public static long CrossCrossed(long self, long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = V1;
        a[2] = V2;
        long r = OcctGen.occtCall(3509, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3510, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3511, a, box);
        return r;
    }
    }

    public static final class Geom_ElementarySurface {
        private Geom_ElementarySurface() {}

    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(3512, a, box);
    }
    public static void SetLocation(long self, long theLoc) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLoc;
        OcctGen.occtCall(3513, a, box);
    }
    public static void SetPosition(long self, long theAx3) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theAx3;
        OcctGen.occtCall(3514, a, box);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3515, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3516, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3517, a, box);
        return r;
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3518, a, box);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3519, a, box);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3520, a, box);
        return (int) r;
    }
    public static boolean IsCNu(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3521, a, box);
        return r != 0;
    }
    public static boolean IsCNv(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3522, a, box);
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3523, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Ellipse {
        private Geom_Ellipse() {}

    public static long 构造(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(3524, a, box);
        return r;
    }
    public static long 构造_2(long A2, double MajorRadius, double MinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = A2;
        a[2] = Double.doubleToRawLongBits(MajorRadius);
        a[3] = Double.doubleToRawLongBits(MinorRadius);
        long r = OcctGen.occtCall(3525, a, box);
        return r;
    }
    public static void SetElips(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(3526, a, box);
    }
    public static void SetMajorRadius(long self, double MajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MajorRadius);
        OcctGen.occtCall(3527, a, box);
    }
    public static void SetMinorRadius(long self, double MinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MinorRadius);
        OcctGen.occtCall(3528, a, box);
    }
    public static long Elips(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3529, a, box);
        return r;
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3530, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Directrix1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3531, a, box);
        return r;
    }
    public static long Directrix2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3532, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3533, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3534, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3535, a, box);
        return r;
    }
    public static long Focus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3536, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3537, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3538, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3539, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3540, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3541, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3542, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3543, a, box);
        return r != 0;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3544, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3545, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3546, a, box);
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
        OcctGen.occtCall(3547, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3548, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3549, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3550, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3551, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Geometry {
        private Geom_Geometry() {}

    public static void Mirror(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(3552, a, box);
    }
    public static void Mirror_2(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        OcctGen.occtCall(3553, a, box);
    }
    public static void Mirror_3(long self, long A2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A2;
        OcctGen.occtCall(3554, a, box);
    }
    public static void Rotate(long self, long A1, double Ang) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        a[2] = Double.doubleToRawLongBits(Ang);
        OcctGen.occtCall(3555, a, box);
    }
    public static void Scale(long self, long P, double S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(S);
        OcctGen.occtCall(3556, a, box);
    }
    public static void Translate(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3557, a, box);
    }
    public static void Translate_2(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        OcctGen.occtCall(3558, a, box);
    }
    public static long Mirrored(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(3559, a, box);
        return r;
    }
    public static long Mirrored_2(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        long r = OcctGen.occtCall(3560, a, box);
        return r;
    }
    public static long Mirrored_3(long self, long A2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A2;
        long r = OcctGen.occtCall(3561, a, box);
        return r;
    }
    public static long Rotated(long self, long A1, double Ang) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        a[2] = Double.doubleToRawLongBits(Ang);
        long r = OcctGen.occtCall(3562, a, box);
        return r;
    }
    public static long Scaled(long self, long P, double S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(S);
        long r = OcctGen.occtCall(3563, a, box);
        return r;
    }
    public static long Transformed(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3564, a, box);
        return r;
    }
    public static long Translated(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        long r = OcctGen.occtCall(3565, a, box);
        return r;
    }
    public static long Translated_2(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(3566, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3567, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Hyperbola {
        private Geom_Hyperbola() {}

    public static long 构造(long H) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = H;
        long r = OcctGen.occtCall(3568, a, box);
        return r;
    }
    public static long 构造_2(long A2, double MajorRadius, double MinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = A2;
        a[2] = Double.doubleToRawLongBits(MajorRadius);
        a[3] = Double.doubleToRawLongBits(MinorRadius);
        long r = OcctGen.occtCall(3569, a, box);
        return r;
    }
    public static void SetHypr(long self, long H) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = H;
        OcctGen.occtCall(3570, a, box);
    }
    public static void SetMajorRadius(long self, double MajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MajorRadius);
        OcctGen.occtCall(3571, a, box);
    }
    public static void SetMinorRadius(long self, double MinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MinorRadius);
        OcctGen.occtCall(3572, a, box);
    }
    public static long Hypr(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3573, a, box);
        return r;
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3574, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3575, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3576, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3577, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3578, a, box);
        return r != 0;
    }
    public static long Asymptote1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3579, a, box);
        return r;
    }
    public static long Asymptote2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3580, a, box);
        return r;
    }
    public static long ConjugateBranch1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3581, a, box);
        return r;
    }
    public static long ConjugateBranch2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3582, a, box);
        return r;
    }
    public static long Directrix1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3583, a, box);
        return r;
    }
    public static long Directrix2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3584, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3585, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3586, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3587, a, box);
        return r;
    }
    public static long Focus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3588, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3589, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3590, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long OtherBranch(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3591, a, box);
        return r;
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3592, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3593, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3594, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3595, a, box);
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
        OcctGen.occtCall(3596, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3597, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3598, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3599, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3600, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Line {
        private Geom_Line() {}

    public static long 构造(long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A1;
        long r = OcctGen.occtCall(3601, a, box);
        return r;
    }
    public static long 构造_2(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(3602, a, box);
        return r;
    }
    public static long 构造_3(long P, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P;
        a[2] = V;
        long r = OcctGen.occtCall(3603, a, box);
        return r;
    }
    public static void SetLin(long self, long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        OcctGen.occtCall(3604, a, box);
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3605, a, box);
    }
    public static void SetLocation(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(3606, a, box);
    }
    public static void SetPosition(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        OcctGen.occtCall(3607, a, box);
    }
    public static long Lin(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3608, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3609, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3610, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3611, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3612, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3613, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3614, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3615, a, box);
        return r != 0;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3616, a, box);
        return (int) r;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3617, a, box);
        return r != 0;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3618, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3619, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3620, a, box);
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
        OcctGen.occtCall(3621, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3622, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3623, a, box);
    }
    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(3624, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3625, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3626, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3627, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_OffsetCurve {
        private Geom_OffsetCurve() {}

    public static long 构造(long C, double Offset, long V, boolean isNotCheckC0) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(Offset);
        a[3] = V;
        a[4] = isNotCheckC0 ? 1L : 0L;
        long r = OcctGen.occtCall(3628, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3629, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3630, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetBasisCurve(long self, long C, boolean isNotCheckC0) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = isNotCheckC0 ? 1L : 0L;
        OcctGen.occtCall(3631, a, box);
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3632, a, box);
    }
    public static void SetOffsetValue(long self, double D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(D);
        OcctGen.occtCall(3633, a, box);
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3634, a, box);
        return r;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3635, a, box);
        return (int) r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3636, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3637, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3638, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3639, a, box);
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
        OcctGen.occtCall(3640, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3641, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3642, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3643, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Offset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3644, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3645, a, box);
        return r != 0;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3646, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3647, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3648, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3649, a, box);
    }
    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(3650, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3651, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3652, a, box);
        return r;
    }
    public static int GetBasisCurveContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3653, a, box);
        return (int) r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3654, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_OffsetSurface {
        private Geom_OffsetSurface() {}

    public static long 构造(long S, double Offset, boolean isNotCheckC0) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Offset);
        a[3] = isNotCheckC0 ? 1L : 0L;
        long r = OcctGen.occtCall(3655, a, box);
        return r;
    }
    public static void SetBasisSurface(long self, long S, boolean isNotCheckC0) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = isNotCheckC0 ? 1L : 0L;
        OcctGen.occtCall(3656, a, box);
    }
    public static void SetOffsetValue(long self, double D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(D);
        OcctGen.occtCall(3657, a, box);
    }
    public static double Offset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3658, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long BasisSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3659, a, box);
        return r;
    }
    public static long OsculatingSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3660, a, box);
        return r;
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3661, a, box);
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3662, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3663, a, box);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3664, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3665, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3666, a, box);
        return (int) r;
    }
    public static boolean IsCNu(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3667, a, box);
        return r != 0;
    }
    public static boolean IsCNv(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3668, a, box);
        return r != 0;
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3669, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3670, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3671, a, box);
        return r != 0;
    }
    public static double UPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3672, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3673, a, box);
        return r != 0;
    }
    public static double VPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3674, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3675, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3676, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3677, a, box);
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
        OcctGen.occtCall(3678, a, box);
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
        OcctGen.occtCall(3679, a, box);
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
        OcctGen.occtCall(3680, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3681, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3682, a, box);
    }
    public static void TransformParameters(long self, double[] UOut, double[] VOut, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[3] = T;
        OcctGen.occtCall(3683, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3684, a, box);
        return r;
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3685, a, box);
        return r;
    }
    public static long Surface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3686, a, box);
        return r;
    }
    public static boolean UOsculatingSurface(
            long self, double U, double V, boolean[] IsOppositeOut, long[] UOsculSurfOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3687, a, box);
        if (IsOppositeOut != null && IsOppositeOut.length != 0) IsOppositeOut[0] = a[3] != 0;
        if (UOsculSurfOut != null && UOsculSurfOut.length != 0) UOsculSurfOut[0] = a[4];
        return r != 0;
    }
    public static boolean VOsculatingSurface(
            long self, double U, double V, boolean[] IsOppositeOut, long[] VOsculSurfOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3688, a, box);
        if (IsOppositeOut != null && IsOppositeOut.length != 0) IsOppositeOut[0] = a[3] != 0;
        if (VOsculSurfOut != null && VOsculSurfOut.length != 0) VOsculSurfOut[0] = a[4];
        return r != 0;
    }
    public static int GetBasisSurfContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3689, a, box);
        return (int) r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3690, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_OsculatingSurface {
        private Geom_OsculatingSurface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(3691, a, box);
        return r;
    }
    public static long 构造_2(long BS, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = BS;
        a[2] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(3692, a, box);
        return r;
    }
    public static void Init(long self, long BS, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = BS;
        a[2] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(3693, a, box);
    }
    public static long BasisSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3694, a, box);
        return r;
    }
    public static double Tolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3695, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean UOscSurf(long self, double U, double V, boolean[] tOut, long[] LOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3696, a, box);
        if (tOut != null && tOut.length != 0) tOut[0] = a[3] != 0;
        if (LOut != null && LOut.length != 0) LOut[0] = a[4];
        return r != 0;
    }
    public static boolean VOscSurf(long self, double U, double V, boolean[] tOut, long[] LOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3697, a, box);
        if (tOut != null && tOut.length != 0) tOut[0] = a[3] != 0;
        if (LOut != null && LOut.length != 0) LOut[0] = a[4];
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3698, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Parabola {
        private Geom_Parabola() {}

    public static long 构造(long Prb) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Prb;
        long r = OcctGen.occtCall(3699, a, box);
        return r;
    }
    public static long 构造_2(long A2, double Focal) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = A2;
        a[2] = Double.doubleToRawLongBits(Focal);
        long r = OcctGen.occtCall(3700, a, box);
        return r;
    }
    public static long 构造_3(long D, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = D;
        a[2] = F;
        long r = OcctGen.occtCall(3701, a, box);
        return r;
    }
    public static void SetFocal(long self, double Focal) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Focal);
        OcctGen.occtCall(3702, a, box);
    }
    public static void SetParab(long self, long Prb) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Prb;
        OcctGen.occtCall(3703, a, box);
    }
    public static long Parab(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3704, a, box);
        return r;
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3705, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3706, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3707, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3708, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3709, a, box);
        return r != 0;
    }
    public static long Directrix(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3710, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3711, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3712, a, box);
        return r;
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3713, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3714, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3715, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3716, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3717, a, box);
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
        OcctGen.occtCall(3718, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3719, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3720, a, box);
    }
    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(3721, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3722, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3723, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3724, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Plane {
        private Geom_Plane() {}

    public static long 构造(long A3) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A3;
        long r = OcctGen.occtCall(3725, a, box);
        return r;
    }
    public static long 构造_2(long Pl) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Pl;
        long r = OcctGen.occtCall(3726, a, box);
        return r;
    }
    public static long 构造_3(long P, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P;
        a[2] = V;
        long r = OcctGen.occtCall(3727, a, box);
        return r;
    }
    public static long 构造_4(double A, double B, double C, double D) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(A);
        a[2] = Double.doubleToRawLongBits(B);
        a[3] = Double.doubleToRawLongBits(C);
        a[4] = Double.doubleToRawLongBits(D);
        long r = OcctGen.occtCall(3728, a, box);
        return r;
    }
    public static void SetPln(long self, long Pl) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Pl;
        OcctGen.occtCall(3729, a, box);
    }
    public static long Pln(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3730, a, box);
        return r;
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3731, a, box);
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3732, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3733, a, box);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3734, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void TransformParameters(long self, double[] UOut, double[] VOut, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[3] = T;
        OcctGen.occtCall(3735, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3736, a, box);
        return r;
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3737, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static void Coefficients(
            long self, double[] AOut, double[] BOut, double[] COut, double[] DOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3738, a, box);
        if (AOut != null && AOut.length != 0) AOut[0] = Double.longBitsToDouble(a[1]);
        if (BOut != null && BOut.length != 0) BOut[0] = Double.longBitsToDouble(a[2]);
        if (COut != null && COut.length != 0) COut[0] = Double.longBitsToDouble(a[3]);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3739, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3740, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3741, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3742, a, box);
        return r != 0;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3743, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3744, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3745, a, box);
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
        OcctGen.occtCall(3746, a, box);
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
        OcctGen.occtCall(3747, a, box);
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
        OcctGen.occtCall(3748, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3749, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3750, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3751, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3752, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Point {
        private Geom_Point() {}

    public static double Distance(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3753, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3754, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class Geom_RectangularTrimmedSurface {
        private Geom_RectangularTrimmedSurface() {}

    public static long 构造(
            long S, double U1, double U2, double V1, double V2, boolean USense, boolean VSense) {
        long[] a = new long[8];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(U1);
        a[3] = Double.doubleToRawLongBits(U2);
        a[4] = Double.doubleToRawLongBits(V1);
        a[5] = Double.doubleToRawLongBits(V2);
        a[6] = USense ? 1L : 0L;
        a[7] = VSense ? 1L : 0L;
        long r = OcctGen.occtCall(3755, a, box);
        return r;
    }
    public static long 构造_2(long S, double Param1, double Param2, boolean UTrim, boolean Sense) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Param1);
        a[3] = Double.doubleToRawLongBits(Param2);
        a[4] = UTrim ? 1L : 0L;
        a[5] = Sense ? 1L : 0L;
        long r = OcctGen.occtCall(3756, a, box);
        return r;
    }
    public static void SetTrim(
            long self, double U1, double U2, double V1, double V2, boolean USense, boolean VSense) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        a[3] = Double.doubleToRawLongBits(V1);
        a[4] = Double.doubleToRawLongBits(V2);
        a[5] = USense ? 1L : 0L;
        a[6] = VSense ? 1L : 0L;
        OcctGen.occtCall(3757, a, box);
    }
    public static void SetTrim_2(
            long self, double Param1, double Param2, boolean UTrim, boolean Sense) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Param1);
        a[2] = Double.doubleToRawLongBits(Param2);
        a[3] = UTrim ? 1L : 0L;
        a[4] = Sense ? 1L : 0L;
        OcctGen.occtCall(3758, a, box);
    }
    public static long BasisSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3759, a, box);
        return r;
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3760, a, box);
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3761, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3762, a, box);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3763, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3764, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3765, a, box);
        return (int) r;
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3766, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3767, a, box);
        return r != 0;
    }
    public static boolean IsCNu(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3768, a, box);
        return r != 0;
    }
    public static boolean IsCNv(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3769, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3770, a, box);
        return r != 0;
    }
    public static double UPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3771, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3772, a, box);
        return r != 0;
    }
    public static double VPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3773, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3774, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3775, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3776, a, box);
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
        OcctGen.occtCall(3777, a, box);
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
        OcctGen.occtCall(3778, a, box);
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
        OcctGen.occtCall(3779, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3780, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3781, a, box);
    }
    public static void TransformParameters(long self, double[] UOut, double[] VOut, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[3] = T;
        OcctGen.occtCall(3782, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3783, a, box);
        return r;
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3784, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3785, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_SphericalSurface {
        private Geom_SphericalSurface() {}

    public static long 构造(long A3, double Radius) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = A3;
        a[2] = Double.doubleToRawLongBits(Radius);
        long r = OcctGen.occtCall(3786, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(3787, a, box);
        return r;
    }
    public static void SetRadius(long self, double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R);
        OcctGen.occtCall(3788, a, box);
    }
    public static void SetSphere(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(3789, a, box);
    }
    public static long Sphere(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3790, a, box);
        return r;
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3791, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3792, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Area(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3793, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3794, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static void Coefficients(
            long self, double[] A1Out, double[] A2Out, double[] A3Out, double[] B1Out,
            double[] B2Out, double[] B3Out, double[] C1Out, double[] C2Out, double[] C3Out,
            double[] DOut) {
        long[] a = new long[11];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3795, a, box);
        if (A1Out != null && A1Out.length != 0) A1Out[0] = Double.longBitsToDouble(a[1]);
        if (A2Out != null && A2Out.length != 0) A2Out[0] = Double.longBitsToDouble(a[2]);
        if (A3Out != null && A3Out.length != 0) A3Out[0] = Double.longBitsToDouble(a[3]);
        if (B1Out != null && B1Out.length != 0) B1Out[0] = Double.longBitsToDouble(a[4]);
        if (B2Out != null && B2Out.length != 0) B2Out[0] = Double.longBitsToDouble(a[5]);
        if (B3Out != null && B3Out.length != 0) B3Out[0] = Double.longBitsToDouble(a[6]);
        if (C1Out != null && C1Out.length != 0) C1Out[0] = Double.longBitsToDouble(a[7]);
        if (C2Out != null && C2Out.length != 0) C2Out[0] = Double.longBitsToDouble(a[8]);
        if (C3Out != null && C3Out.length != 0) C3Out[0] = Double.longBitsToDouble(a[9]);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[10]);
    }
    public static double Radius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3796, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Volume(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3797, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3798, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3799, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3800, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3801, a, box);
        return r != 0;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3802, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3803, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3804, a, box);
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
        OcctGen.occtCall(3805, a, box);
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
        OcctGen.occtCall(3806, a, box);
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
        OcctGen.occtCall(3807, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3808, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3809, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3810, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3811, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Surface {
        private Geom_Surface() {}

    public static long UReversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3812, a, box);
        return r;
    }
    public static long VReversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3813, a, box);
        return r;
    }
    public static void TransformParameters(long self, double[] UOut, double[] VOut, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[3] = T;
        OcctGen.occtCall(3814, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3815, a, box);
        return r;
    }
    public static double UPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3816, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VPeriod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3817, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U, double V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3818, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3819, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_SurfaceOfLinearExtrusion {
        private Geom_SurfaceOfLinearExtrusion() {}

    public static long 构造(long C, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = V;
        long r = OcctGen.occtCall(3820, a, box);
        return r;
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3821, a, box);
    }
    public static void SetBasisCurve(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(3822, a, box);
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3823, a, box);
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3824, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3825, a, box);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3826, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3827, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3828, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3829, a, box);
        return r != 0;
    }
    public static boolean IsCNu(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3830, a, box);
        return r != 0;
    }
    public static boolean IsCNv(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3831, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3832, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3833, a, box);
        return r != 0;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3834, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3835, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3836, a, box);
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
        OcctGen.occtCall(3837, a, box);
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
        OcctGen.occtCall(3838, a, box);
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
        OcctGen.occtCall(3839, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3840, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3841, a, box);
    }
    public static void TransformParameters(long self, double[] UOut, double[] VOut, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[3] = T;
        OcctGen.occtCall(3842, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3843, a, box);
        return r;
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3844, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3845, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_SurfaceOfRevolution {
        private Geom_SurfaceOfRevolution() {}

    public static long 构造(long C, long A1) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = A1;
        long r = OcctGen.occtCall(3846, a, box);
        return r;
    }
    public static void SetAxis(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        OcctGen.occtCall(3847, a, box);
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3848, a, box);
    }
    public static void SetBasisCurve(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(3849, a, box);
    }
    public static void SetLocation(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(3850, a, box);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3851, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3852, a, box);
        return r;
    }
    public static long ReferencePlane(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3853, a, box);
        return r;
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3854, a, box);
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3855, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3856, a, box);
    }
    public static double VReversedParameter(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3857, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void TransformParameters(long self, double[] UOut, double[] VOut, long T) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[3] = T;
        OcctGen.occtCall(3858, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3859, a, box);
        return r;
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3860, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3861, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3862, a, box);
        return r != 0;
    }
    public static boolean IsCNu(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3863, a, box);
        return r != 0;
    }
    public static boolean IsCNv(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3864, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3865, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3866, a, box);
        return r != 0;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3867, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3868, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3869, a, box);
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
        OcctGen.occtCall(3870, a, box);
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
        OcctGen.occtCall(3871, a, box);
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
        OcctGen.occtCall(3872, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3873, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3874, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3875, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3876, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_SweptSurface {
        private Geom_SweptSurface() {}

    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3877, a, box);
        return (int) r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3878, a, box);
        return r;
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3879, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3880, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_ToroidalSurface {
        private Geom_ToroidalSurface() {}

    public static long 构造(long A3, double MajorRadius, double MinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = A3;
        a[2] = Double.doubleToRawLongBits(MajorRadius);
        a[3] = Double.doubleToRawLongBits(MinorRadius);
        long r = OcctGen.occtCall(3881, a, box);
        return r;
    }
    public static long 构造_2(long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = T;
        long r = OcctGen.occtCall(3882, a, box);
        return r;
    }
    public static void SetMajorRadius(long self, double MajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MajorRadius);
        OcctGen.occtCall(3883, a, box);
    }
    public static void SetMinorRadius(long self, double MinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MinorRadius);
        OcctGen.occtCall(3884, a, box);
    }
    public static void SetTorus(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3885, a, box);
    }
    public static long Torus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3886, a, box);
        return r;
    }
    public static double UReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3887, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3888, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Area(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3889, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3890, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3891, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3892, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Volume(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3893, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsUClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3894, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3895, a, box);
        return r != 0;
    }
    public static boolean IsUPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3896, a, box);
        return r != 0;
    }
    public static boolean IsVPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3897, a, box);
        return r != 0;
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3898, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(3899, a, box);
        return r;
    }
    public static void D0(long self, double U, double V, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        OcctGen.occtCall(3900, a, box);
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
        OcctGen.occtCall(3901, a, box);
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
        OcctGen.occtCall(3902, a, box);
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
        OcctGen.occtCall(3903, a, box);
    }
    public static long DN(long self, double U, double V, int Nu, int Nv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Nu;
        a[4] = Nv;
        long r = OcctGen.occtCall(3904, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3905, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3906, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3907, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Transformation {
        private Geom_Transformation() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(3908, a, box);
        return r;
    }
    public static long 构造_2(long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = T;
        long r = OcctGen.occtCall(3909, a, box);
        return r;
    }
    public static void SetMirror(long self, long thePnt) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = thePnt;
        OcctGen.occtCall(3910, a, box);
    }
    public static void SetMirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(3911, a, box);
    }
    public static void SetMirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(3912, a, box);
    }
    public static void SetRotation(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(3913, a, box);
    }
    public static void SetScale(long self, long thePnt, double theScale) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = thePnt;
        a[2] = Double.doubleToRawLongBits(theScale);
        OcctGen.occtCall(3914, a, box);
    }
    public static void SetTransformation(long self, long theFromSystem1, long theToSystem2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theFromSystem1;
        a[2] = theToSystem2;
        OcctGen.occtCall(3915, a, box);
    }
    public static void SetTransformation_2(long self, long theToSystem) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theToSystem;
        OcctGen.occtCall(3916, a, box);
    }
    public static void SetTranslation(long self, long theVec) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theVec;
        OcctGen.occtCall(3917, a, box);
    }
    public static void SetTranslation_2(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        OcctGen.occtCall(3918, a, box);
    }
    public static void SetTrsf(long self, long theTrsf) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theTrsf;
        OcctGen.occtCall(3919, a, box);
    }
    public static boolean IsNegative(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3920, a, box);
        return r != 0;
    }
    public static int Form(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3921, a, box);
        return (int) r;
    }
    public static double ScaleFactor(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3922, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Trsf(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3923, a, box);
        return r;
    }
    public static double Value(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(3924, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3925, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3926, a, box);
        return r;
    }
    public static long Multiplied(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3927, a, box);
        return r;
    }
    public static void Multiply(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(3928, a, box);
    }
    public static void Power(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(3929, a, box);
    }
    public static long Powered(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3930, a, box);
        return r;
    }
    public static void PreMultiply(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(3931, a, box);
    }
    public static void Transforms(long self, double[] theXOut, double[] theYOut, double[] theZOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3932, a, box);
        if (theXOut != null && theXOut.length != 0) theXOut[0] = Double.longBitsToDouble(a[1]);
        if (theYOut != null && theYOut.length != 0) theYOut[0] = Double.longBitsToDouble(a[2]);
        if (theZOut != null && theZOut.length != 0) theZOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3933, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3934, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_TrimmedCurve {
        private Geom_TrimmedCurve() {}

    public static long 构造(long C, double U1, double U2, boolean Sense, boolean theAdjustPeriodic) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U1);
        a[3] = Double.doubleToRawLongBits(U2);
        a[4] = Sense ? 1L : 0L;
        a[5] = theAdjustPeriodic ? 1L : 0L;
        long r = OcctGen.occtCall(3935, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3936, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(3937, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetTrim(
            long self, double U1, double U2, boolean Sense, boolean theAdjustPeriodic) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        a[3] = Sense ? 1L : 0L;
        a[4] = theAdjustPeriodic ? 1L : 0L;
        OcctGen.occtCall(3938, a, box);
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3939, a, box);
        return r;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3940, a, box);
        return (int) r;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(3941, a, box);
        return r != 0;
    }
    public static long EndPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3942, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3943, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3944, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3945, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3946, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3947, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long StartPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3948, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(3949, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(3950, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(3951, a, box);
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
        OcctGen.occtCall(3952, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(3953, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3954, a, box);
    }
    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(3955, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(3956, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3957, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(3958, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom_Vector {
        private Geom_Vector() {}

    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3959, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3960, a, box);
        return r;
    }
    public static double Angle(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3961, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double AngleWithRef(long self, long Other, long VRef) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        a[2] = VRef;
        long r = OcctGen.occtCall(3962, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord(long self, double[] XOut, double[] YOut, double[] ZOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3963, a, box);
        if (XOut != null && XOut.length != 0) XOut[0] = Double.longBitsToDouble(a[1]);
        if (YOut != null && YOut.length != 0) YOut[0] = Double.longBitsToDouble(a[2]);
        if (ZOut != null && ZOut.length != 0) ZOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3964, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3965, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Z(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3966, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Dot(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3967, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double DotCross(long self, long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = V1;
        a[2] = V2;
        long r = OcctGen.occtCall(3968, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Vec(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3969, a, box);
        return r;
    }
    }

    public static final class Geom_VectorWithMagnitude {
        private Geom_VectorWithMagnitude() {}

    public static long 构造(long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = V;
        long r = OcctGen.occtCall(3970, a, box);
        return r;
    }
    public static long 构造_2(double X, double Y, double Z) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        a[3] = Double.doubleToRawLongBits(Z);
        long r = OcctGen.occtCall(3971, a, box);
        return r;
    }
    public static long 构造_3(long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(3972, a, box);
        return r;
    }
    public static void SetCoord(long self, double X, double Y, double Z) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        a[3] = Double.doubleToRawLongBits(Z);
        OcctGen.occtCall(3973, a, box);
    }
    public static void SetVec(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(3974, a, box);
    }
    public static void SetX(long self, double X) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        OcctGen.occtCall(3975, a, box);
    }
    public static void SetY(long self, double Y) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(3976, a, box);
    }
    public static void SetZ(long self, double Z) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Z);
        OcctGen.occtCall(3977, a, box);
    }
    public static double Magnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3978, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareMagnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3979, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Add(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(3980, a, box);
    }
    public static long Added(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3981, a, box);
        return r;
    }
    public static void Cross(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(3982, a, box);
    }
    public static long Crossed(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3983, a, box);
        return r;
    }
    public static void CrossCross(long self, long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = V1;
        a[2] = V2;
        OcctGen.occtCall(3984, a, box);
    }
    public static long CrossCrossed(long self, long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = V1;
        a[2] = V2;
        long r = OcctGen.occtCall(3985, a, box);
        return r;
    }
    public static void Divide(long self, double Scalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Scalar);
        OcctGen.occtCall(3986, a, box);
    }
    public static long Divided(long self, double Scalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Scalar);
        long r = OcctGen.occtCall(3987, a, box);
        return r;
    }
    public static long Multiplied(long self, double Scalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Scalar);
        long r = OcctGen.occtCall(3988, a, box);
        return r;
    }
    public static void Multiply(long self, double Scalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Scalar);
        OcctGen.occtCall(3989, a, box);
    }
    public static void Normalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(3990, a, box);
    }
    public static long Normalized(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3991, a, box);
        return r;
    }
    public static void Subtract(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(3992, a, box);
    }
    public static long Subtracted(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(3993, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(3994, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3995, a, box);
        return r;
    }
    }

    public static final class TopAbs {
        private TopAbs() {}

    public static int Compose(int Or1, int Or2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Or1;
        a[2] = Or2;
        long r = OcctGen.occtCall(4804, a, box);
        return (int) r;
    }
    public static int Reverse(int Or) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Or;
        long r = OcctGen.occtCall(4805, a, box);
        return (int) r;
    }
    public static int Complement(int Or) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Or;
        long r = OcctGen.occtCall(4806, a, box);
        return (int) r;
    }
    public static String ShapeTypeToString(int theType) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[1] = theType;
        OcctGen.occtCall(4807, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static int ShapeTypeFromString(String theTypeString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theTypeString;
        long r = OcctGen.occtCall(4808, a, box);
        return (int) r;
    }
    public static boolean ShapeTypeFromString_2(String theTypeString, int[] theTypeOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theTypeString;
        long r = OcctGen.occtCall(4809, a, box);
        if (theTypeOut != null && theTypeOut.length != 0) theTypeOut[0] = (int) a[2];
        return r != 0;
    }
    public static String ShapeOrientationToString(int theOrientation) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[1] = theOrientation;
        OcctGen.occtCall(4810, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static int ShapeOrientationFromString(String theOrientationString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theOrientationString;
        long r = OcctGen.occtCall(4811, a, box);
        return (int) r;
    }
    public static boolean ShapeOrientationFromString_2(
            String theOrientationString, int[] theOrientationOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theOrientationString;
        long r = OcctGen.occtCall(4812, a, box);
        if (theOrientationOut != null && theOrientationOut.length != 0) theOrientationOut[0] = (int) a[2];
        return r != 0;
    }
    }

}
