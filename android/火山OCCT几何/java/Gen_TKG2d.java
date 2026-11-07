package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKG2d 类=30 方法槽=584
public final class Gen_TKG2d {
    private Gen_TKG2d() {}

    public static final class Adaptor2d_Curve2d {
        private Adaptor2d_Curve2d() {}

    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(0, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(3, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(5, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(7, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(8, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(9, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(10, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(11, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(12, a, box);
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
        OcctGen.occtCall(13, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(14, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(15, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(16, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(17, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(18, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(19, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(20, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(21, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(22, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(23, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(24, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(25, a, box);
        return (int) r;
    }
    public static int NbSamples(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(26, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(27, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(28, a, box);
        return r;
    }
    }

    public static final class Adaptor2d_Line2d {
        private Adaptor2d_Line2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(29, a, box);
        return r;
    }
    public static long 构造_2(long P, long D, double UFirst, double ULast) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = P;
        a[2] = D;
        a[3] = Double.doubleToRawLongBits(UFirst);
        a[4] = Double.doubleToRawLongBits(ULast);
        long r = OcctGen.occtCall(30, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(31, a, box);
        return r;
    }
    public static void Load(long self, long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        OcctGen.occtCall(32, a, box);
    }
    public static void Load_2(long self, long L, double UFirst, double ULast) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(UFirst);
        a[3] = Double.doubleToRawLongBits(ULast);
        OcctGen.occtCall(33, a, box);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(34, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(35, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(36, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(37, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(38, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(39, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(40, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(41, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double X) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(42, a, box);
        return r;
    }
    public static void D0(long self, double X, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = P;
        OcctGen.occtCall(43, a, box);
    }
    public static void D1(long self, double X, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(44, a, box);
    }
    public static void D2(long self, double X, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(45, a, box);
    }
    public static void D3(long self, double X, long P, long V1, long V2, long V3) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        a[5] = V3;
        OcctGen.occtCall(46, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(47, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(48, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(49, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(50, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(51, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(52, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(53, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(54, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(55, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(56, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(57, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(58, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(59, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(60, a, box);
        return r;
    }
    }

    public static final class Adaptor2d_OffsetCurve {
        private Adaptor2d_OffsetCurve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(61, a, box);
        return r;
    }
    public static long 构造_2(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(62, a, box);
        return r;
    }
    public static long 构造_3(long C, double Offset) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(Offset);
        long r = OcctGen.occtCall(63, a, box);
        return r;
    }
    public static long 构造_4(long C, double Offset, double WFirst, double WLast) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(Offset);
        a[3] = Double.doubleToRawLongBits(WFirst);
        a[4] = Double.doubleToRawLongBits(WLast);
        long r = OcctGen.occtCall(64, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(65, a, box);
        return r;
    }
    public static void Load(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(66, a, box);
    }
    public static void Load_2(long self, double Offset) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Offset);
        OcctGen.occtCall(67, a, box);
    }
    public static void Load_3(long self, double Offset, double WFirst, double WLast) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Offset);
        a[2] = Double.doubleToRawLongBits(WFirst);
        a[3] = Double.doubleToRawLongBits(WLast);
        OcctGen.occtCall(68, a, box);
    }
    public static long Curve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(69, a, box);
        return r;
    }
    public static double Offset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(70, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(71, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(72, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(73, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(74, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(75, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(76, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(77, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(78, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(79, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(80, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(81, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(82, a, box);
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
        OcctGen.occtCall(83, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(84, a, box);
        return r;
    }
    public static double Resolution(long self, double R3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R3d);
        long r = OcctGen.occtCall(85, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(86, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(87, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(88, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(89, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(90, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(91, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(92, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(93, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(94, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(95, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(96, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(97, a, box);
        return r;
    }
    public static int NbSamples(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(98, a, box);
        return (int) r;
    }
    }

    public static final class Geom2dAdaptor_Curve {
        private Geom2dAdaptor_Curve() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2293, a, box);
        return r;
    }
    public static long 构造_2(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(2294, a, box);
        return r;
    }
    public static long 构造_3(long C, double UFirst, double ULast) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(UFirst);
        a[3] = Double.doubleToRawLongBits(ULast);
        long r = OcctGen.occtCall(2295, a, box);
        return r;
    }
    public static long ShallowCopy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2296, a, box);
        return r;
    }
    public static void Reset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2297, a, box);
    }
    public static void Load(long self, long theCurve) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCurve;
        OcctGen.occtCall(2298, a, box);
    }
    public static void Load_2(long self, long theCurve, double theUFirst, double theULast) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theCurve;
        a[2] = Double.doubleToRawLongBits(theUFirst);
        a[3] = Double.doubleToRawLongBits(theULast);
        OcctGen.occtCall(2299, a, box);
    }
    public static long Curve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2300, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2301, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2302, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2303, a, box);
        return (int) r;
    }
    public static int NbIntervals(long self, int S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(2304, a, box);
        return (int) r;
    }
    public static long Trim(long self, double First, double Last, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(First);
        a[2] = Double.doubleToRawLongBits(Last);
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(2305, a, box);
        return r;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2306, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2307, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2308, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2309, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2310, a, box);
    }
    public static void D1(long self, double U, long P, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V;
        OcctGen.occtCall(2311, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2312, a, box);
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
        OcctGen.occtCall(2313, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2314, a, box);
        return r;
    }
    public static double Resolution(long self, double Ruv) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Ruv);
        long r = OcctGen.occtCall(2315, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int GetType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2316, a, box);
        return (int) r;
    }
    public static long Line(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2317, a, box);
        return r;
    }
    public static long Circle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2318, a, box);
        return r;
    }
    public static long Ellipse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2319, a, box);
        return r;
    }
    public static long Hyperbola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2320, a, box);
        return r;
    }
    public static long Parabola(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2321, a, box);
        return r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2322, a, box);
        return (int) r;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2323, a, box);
        return r != 0;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2324, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2325, a, box);
        return (int) r;
    }
    public static int NbSamples(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2326, a, box);
        return (int) r;
    }
    public static long Bezier(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2327, a, box);
        return r;
    }
    public static long BSpline(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2328, a, box);
        return r;
    }
    }

    public static final class Geom2dLProp_CLProps2d {
        private Geom2dLProp_CLProps2d() {}

    public static long 构造(long C, int N, double Resolution) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = N;
        a[3] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(2333, a, box);
        return r;
    }
    public static long 构造_2(long C, double U, int N, double Resolution) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = N;
        a[4] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(2334, a, box);
        return r;
    }
    public static long 构造_3(int N, double Resolution) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = N;
        a[2] = Double.doubleToRawLongBits(Resolution);
        long r = OcctGen.occtCall(2335, a, box);
        return r;
    }
    public static void SetParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        OcctGen.occtCall(2336, a, box);
    }
    public static void SetCurve(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(2337, a, box);
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2338, a, box);
        return r;
    }
    public static long D1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2339, a, box);
        return r;
    }
    public static long D2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2340, a, box);
        return r;
    }
    public static long D3(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2341, a, box);
        return r;
    }
    public static boolean IsTangentDefined(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2342, a, box);
        return r != 0;
    }
    public static void Tangent(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(2343, a, box);
    }
    public static double Curvature(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2344, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Normal(long self, long N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(2345, a, box);
    }
    public static void CentreOfCurvature(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2346, a, box);
    }
    }

    public static final class Geom2dLProp_CurAndInf2d {
        private Geom2dLProp_CurAndInf2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2347, a, box);
        return r;
    }
    public static void Perform(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(2348, a, box);
    }
    public static void PerformCurExt(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(2349, a, box);
    }
    public static void PerformInf(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(2350, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2351, a, box);
        return r != 0;
    }
    }

    public static final class Geom2dLProp_Curve2dTool {
        private Geom2dLProp_Curve2dTool() {}

    public static void Value(long C, double U, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        OcctGen.occtCall(2352, a, box);
    }
    public static void D1(long C, double U, long P, long V1) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        a[4] = V1;
        OcctGen.occtCall(2353, a, box);
    }
    public static void D2(long C, double U, long P, long V1, long V2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        a[4] = V1;
        a[5] = V2;
        OcctGen.occtCall(2354, a, box);
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
        OcctGen.occtCall(2355, a, box);
    }
    public static int Continuity(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(2356, a, box);
        return (int) r;
    }
    public static double FirstParameter(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(2357, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(2358, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class Geom2dLProp_FuncCurExt {
        private Geom2dLProp_FuncCurExt() {}

    public static long 构造(long C, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(2359, a, box);
        return r;
    }
    public static boolean Value(long self, double X, double[] FOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(2360, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static boolean Derivative(long self, double X, double[] DOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(2361, a, box);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static boolean Values(long self, double X, double[] FOut, double[] DOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(2362, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[2]);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[3]);
        return r != 0;
    }
    public static boolean IsMinKC(long self, double Param) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Param);
        long r = OcctGen.occtCall(2363, a, box);
        return r != 0;
    }
    }

    public static final class Geom2dLProp_FuncCurNul {
        private Geom2dLProp_FuncCurNul() {}

    public static long 构造(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(2364, a, box);
        return r;
    }
    public static boolean Value(long self, double X, double[] FOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(2365, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static boolean Derivative(long self, double X, double[] DOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(2366, a, box);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static boolean Values(long self, double X, double[] FOut, double[] DOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(2367, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[2]);
        if (DOut != null && DOut.length != 0) DOut[0] = Double.longBitsToDouble(a[3]);
        return r != 0;
    }
    }

    public static final class Geom2dLProp_NumericCurInf2d {
        private Geom2dLProp_NumericCurInf2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2368, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2369, a, box);
        return r != 0;
    }
    }

    public static final class Geom2d_AxisPlacement {
        private Geom2d_AxisPlacement() {}

    public static long 构造(long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A;
        long r = OcctGen.occtCall(2370, a, box);
        return r;
    }
    public static long 构造_2(long P, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P;
        a[2] = V;
        long r = OcctGen.occtCall(2371, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2372, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2373, a, box);
        return r;
    }
    public static void SetAxis(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        OcctGen.occtCall(2374, a, box);
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(2375, a, box);
    }
    public static void SetLocation(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2376, a, box);
    }
    public static double Angle(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2377, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Ax2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2378, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2379, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2380, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2381, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2382, a, box);
        return r;
    }
    }

    public static final class Geom2d_BSplineCurve {
        private Geom2d_BSplineCurve() {}

    public static void IncreaseDegree(long self, int Degree) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Degree;
        OcctGen.occtCall(2383, a, box);
    }
    public static void IncreaseMultiplicity(long self, int Index, int M) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = M;
        OcctGen.occtCall(2384, a, box);
    }
    public static void IncreaseMultiplicity_2(long self, int I1, int I2, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = I1;
        a[2] = I2;
        a[3] = M;
        OcctGen.occtCall(2385, a, box);
    }
    public static void IncrementMultiplicity(long self, int I1, int I2, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = I1;
        a[2] = I2;
        a[3] = M;
        OcctGen.occtCall(2386, a, box);
    }
    public static void InsertKnot(long self, double U, int M, double ParametricTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = M;
        a[3] = Double.doubleToRawLongBits(ParametricTolerance);
        OcctGen.occtCall(2387, a, box);
    }
    public static boolean RemoveKnot(long self, int Index, int M, double Tolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = M;
        a[3] = Double.doubleToRawLongBits(Tolerance);
        long r = OcctGen.occtCall(2388, a, box);
        return r != 0;
    }
    public static void InsertPoleAfter(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(2389, a, box);
    }
    public static void InsertPoleBefore(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(2390, a, box);
    }
    public static void RemovePole(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2391, a, box);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2392, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2393, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Segment(long self, double U1, double U2, double theTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        a[3] = Double.doubleToRawLongBits(theTolerance);
        OcctGen.occtCall(2394, a, box);
    }
    public static void SetKnot(long self, int Index, double K) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = Double.doubleToRawLongBits(K);
        OcctGen.occtCall(2395, a, box);
    }
    public static void SetKnot_2(long self, int Index, double K, int M) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = Double.doubleToRawLongBits(K);
        a[3] = M;
        OcctGen.occtCall(2396, a, box);
    }
    public static void PeriodicNormalization(long self, double[] UOut) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2397, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[1]);
    }
    public static void SetPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2398, a, box);
    }
    public static void SetOrigin(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2399, a, box);
    }
    public static void SetNotPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2400, a, box);
    }
    public static void SetPole(long self, int Index, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        OcctGen.occtCall(2401, a, box);
    }
    public static void SetPole_2(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(2402, a, box);
    }
    public static void SetWeight(long self, int Index, double Weight) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(2403, a, box);
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
        OcctGen.occtCall(2404, a, box);
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
        OcctGen.occtCall(2405, a, box);
        if (ErrorStatusOut != null && ErrorStatusOut.length != 0) ErrorStatusOut[0] = (int) a[7];
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(2406, a, box);
        return r != 0;
    }
    public static boolean IsG1(long self, double theTf, double theTl, double theAngTol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTf);
        a[2] = Double.doubleToRawLongBits(theTl);
        a[3] = Double.doubleToRawLongBits(theAngTol);
        long r = OcctGen.occtCall(2407, a, box);
        return r != 0;
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2408, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2409, a, box);
        return r != 0;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2410, a, box);
        return r != 0;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2411, a, box);
        return (int) r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2412, a, box);
        return (int) r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2413, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2414, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2415, a, box);
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
        OcctGen.occtCall(2416, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2417, a, box);
        return r;
    }
    public static long LocalValue(long self, double U, int FromK1, int ToK2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = FromK1;
        a[3] = ToK2;
        long r = OcctGen.occtCall(2418, a, box);
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
        OcctGen.occtCall(2419, a, box);
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
        OcctGen.occtCall(2420, a, box);
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
        OcctGen.occtCall(2421, a, box);
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
        OcctGen.occtCall(2422, a, box);
    }
    public static long LocalDN(long self, double U, int FromK1, int ToK2, int N) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = FromK1;
        a[3] = ToK2;
        a[4] = N;
        long r = OcctGen.occtCall(2423, a, box);
        return r;
    }
    public static long EndPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2424, a, box);
        return r;
    }
    public static int FirstUKnotIndex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2425, a, box);
        return (int) r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2426, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Knot(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2427, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int KnotDistribution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2428, a, box);
        return (int) r;
    }
    public static int LastUKnotIndex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2429, a, box);
        return (int) r;
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2430, a, box);
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
        OcctGen.occtCall(2431, a, box);
        if (I1Out != null && I1Out.length != 0) I1Out[0] = (int) a[3];
        if (I2Out != null && I2Out.length != 0) I2Out[0] = (int) a[4];
    }
    public static int Multiplicity(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2432, a, box);
        return (int) r;
    }
    public static int NbKnots(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2433, a, box);
        return (int) r;
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2434, a, box);
        return (int) r;
    }
    public static long Pole(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2435, a, box);
        return r;
    }
    public static long StartPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2436, a, box);
        return r;
    }
    public static double Weight(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2437, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2438, a, box);
    }
    public static int MaxDegree() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2439, a, box);
        return (int) r;
    }
    public static void Resolution(long self, double ToleranceUV, double[] UToleranceOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(ToleranceUV);
        OcctGen.occtCall(2440, a, box);
        if (UToleranceOut != null && UToleranceOut.length != 0) UToleranceOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2441, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2442, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_BezierCurve {
        private Geom2d_BezierCurve() {}

    public static void Increase(long self, int Degree) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Degree;
        OcctGen.occtCall(2443, a, box);
    }
    public static void InsertPoleAfter(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(2444, a, box);
    }
    public static void InsertPoleBefore(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(2445, a, box);
    }
    public static void RemovePole(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        OcctGen.occtCall(2446, a, box);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2447, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2448, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Segment(long self, double U1, double U2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        OcctGen.occtCall(2449, a, box);
    }
    public static void SetPole(long self, int Index, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        OcctGen.occtCall(2450, a, box);
    }
    public static void SetPole_2(long self, int Index, long P, double Weight) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(2451, a, box);
    }
    public static void SetWeight(long self, int Index, double Weight) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = Double.doubleToRawLongBits(Weight);
        OcctGen.occtCall(2452, a, box);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2453, a, box);
        return r != 0;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(2454, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2455, a, box);
        return r != 0;
    }
    public static boolean IsRational(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2456, a, box);
        return r != 0;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2457, a, box);
        return (int) r;
    }
    public static int Degree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2458, a, box);
        return (int) r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2459, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2460, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2461, a, box);
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
        OcctGen.occtCall(2462, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2463, a, box);
        return r;
    }
    public static long EndPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2464, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2465, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2466, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int NbPoles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2467, a, box);
        return (int) r;
    }
    public static long Pole(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2468, a, box);
        return r;
    }
    public static long StartPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2469, a, box);
        return r;
    }
    public static double Weight(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(2470, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2471, a, box);
    }
    public static int MaxDegree() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2472, a, box);
        return (int) r;
    }
    public static void Resolution(long self, double ToleranceUV, double[] UToleranceOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(ToleranceUV);
        OcctGen.occtCall(2473, a, box);
        if (UToleranceOut != null && UToleranceOut.length != 0) UToleranceOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2474, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2475, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_BoundedCurve {
        private Geom2d_BoundedCurve() {}

    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2476, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_CartesianPoint {
        private Geom2d_CartesianPoint() {}

    public static long 构造(long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = P;
        long r = OcctGen.occtCall(2477, a, box);
        return r;
    }
    public static long 构造_2(double X, double Y) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        long r = OcctGen.occtCall(2478, a, box);
        return r;
    }
    public static void SetCoord(long self, double X, double Y) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(2479, a, box);
    }
    public static void SetPnt2d(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2480, a, box);
    }
    public static void SetX(long self, double X) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        OcctGen.occtCall(2481, a, box);
    }
    public static void SetY(long self, double Y) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(2482, a, box);
    }
    public static void Coord(long self, double[] XOut, double[] YOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2483, a, box);
        if (XOut != null && XOut.length != 0) XOut[0] = Double.longBitsToDouble(a[1]);
        if (YOut != null && YOut.length != 0) YOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long Pnt2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2484, a, box);
        return r;
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2485, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2486, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2487, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2488, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2489, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Circle {
        private Geom2d_Circle() {}

    public static long 构造(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(2490, a, box);
        return r;
    }
    public static long 构造_2(long A, double Radius, boolean Sense) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = A;
        a[2] = Double.doubleToRawLongBits(Radius);
        a[3] = Sense ? 1L : 0L;
        long r = OcctGen.occtCall(2491, a, box);
        return r;
    }
    public static long 构造_3(long A, double Radius) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = A;
        a[2] = Double.doubleToRawLongBits(Radius);
        long r = OcctGen.occtCall(2492, a, box);
        return r;
    }
    public static void SetCirc2d(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(2493, a, box);
    }
    public static void SetRadius(long self, double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R);
        OcctGen.occtCall(2494, a, box);
    }
    public static long Circ2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2495, a, box);
        return r;
    }
    public static double Radius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2496, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2497, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2498, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2499, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2500, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2501, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2502, a, box);
        return r != 0;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2503, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2504, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2505, a, box);
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
        OcctGen.occtCall(2506, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2507, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2508, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2509, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2510, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Conic {
        private Geom2d_Conic() {}

    public static void SetAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(2511, a, box);
    }
    public static void SetXAxis(long self, long theAX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theAX;
        OcctGen.occtCall(2512, a, box);
    }
    public static void SetYAxis(long self, long theAY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theAY;
        OcctGen.occtCall(2513, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(2514, a, box);
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2515, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2516, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2517, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2518, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2519, a, box);
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2520, a, box);
        return (int) r;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(2521, a, box);
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2522, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Curve {
        private Geom2d_Curve() {}

    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(2523, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(2524, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2525, a, box);
        return r;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2526, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2527, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2528, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Direction {
        private Geom2d_Direction() {}

    public static long 构造(double X, double Y) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        long r = OcctGen.occtCall(2529, a, box);
        return r;
    }
    public static long 构造_2(long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = V;
        long r = OcctGen.occtCall(2530, a, box);
        return r;
    }
    public static void SetCoord(long self, double X, double Y) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(2531, a, box);
    }
    public static void SetDir2d(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(2532, a, box);
    }
    public static void SetX(long self, double X) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        OcctGen.occtCall(2533, a, box);
    }
    public static void SetY(long self, double Y) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(2534, a, box);
    }
    public static long Dir2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2535, a, box);
        return r;
    }
    public static double Magnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2536, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareMagnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2537, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Crossed(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2538, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2539, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2540, a, box);
        return r;
    }
    }

    public static final class Geom2d_Ellipse {
        private Geom2d_Ellipse() {}

    public static long 构造(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(2541, a, box);
        return r;
    }
    public static long 构造_2(long MajorAxis, double MajorRadius, double MinorRadius, boolean Sense) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = MajorAxis;
        a[2] = Double.doubleToRawLongBits(MajorRadius);
        a[3] = Double.doubleToRawLongBits(MinorRadius);
        a[4] = Sense ? 1L : 0L;
        long r = OcctGen.occtCall(2542, a, box);
        return r;
    }
    public static long 构造_3(long Axis, double MajorRadius, double MinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Axis;
        a[2] = Double.doubleToRawLongBits(MajorRadius);
        a[3] = Double.doubleToRawLongBits(MinorRadius);
        long r = OcctGen.occtCall(2543, a, box);
        return r;
    }
    public static void SetElips2d(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(2544, a, box);
    }
    public static void SetMajorRadius(long self, double MajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MajorRadius);
        OcctGen.occtCall(2545, a, box);
    }
    public static void SetMinorRadius(long self, double MinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MinorRadius);
        OcctGen.occtCall(2546, a, box);
    }
    public static long Elips2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2547, a, box);
        return r;
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2548, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Directrix1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2549, a, box);
        return r;
    }
    public static long Directrix2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2550, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2551, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2552, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2553, a, box);
        return r;
    }
    public static long Focus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2554, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2555, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2556, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2557, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2558, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2559, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2560, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2561, a, box);
        return r != 0;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2562, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2563, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2564, a, box);
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
        OcctGen.occtCall(2565, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2566, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2567, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2568, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2569, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Geometry {
        private Geom2d_Geometry() {}

    public static void Mirror(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2570, a, box);
    }
    public static void Mirror_2(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        OcctGen.occtCall(2571, a, box);
    }
    public static void Rotate(long self, long P, double Ang) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(Ang);
        OcctGen.occtCall(2572, a, box);
    }
    public static void Scale(long self, long P, double S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(S);
        OcctGen.occtCall(2573, a, box);
    }
    public static void Translate(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(2574, a, box);
    }
    public static void Translate_2(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        OcctGen.occtCall(2575, a, box);
    }
    public static long Mirrored(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(2576, a, box);
        return r;
    }
    public static long Mirrored_2(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        long r = OcctGen.occtCall(2577, a, box);
        return r;
    }
    public static long Rotated(long self, long P, double Ang) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(Ang);
        long r = OcctGen.occtCall(2578, a, box);
        return r;
    }
    public static long Scaled(long self, long P, double S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(S);
        long r = OcctGen.occtCall(2579, a, box);
        return r;
    }
    public static long Transformed(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(2580, a, box);
        return r;
    }
    public static long Translated(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        long r = OcctGen.occtCall(2581, a, box);
        return r;
    }
    public static long Translated_2(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(2582, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2583, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Hyperbola {
        private Geom2d_Hyperbola() {}

    public static long 构造(long H) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = H;
        long r = OcctGen.occtCall(2584, a, box);
        return r;
    }
    public static long 构造_2(long MajorAxis, double MajorRadius, double MinorRadius, boolean Sense) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = MajorAxis;
        a[2] = Double.doubleToRawLongBits(MajorRadius);
        a[3] = Double.doubleToRawLongBits(MinorRadius);
        a[4] = Sense ? 1L : 0L;
        long r = OcctGen.occtCall(2585, a, box);
        return r;
    }
    public static long 构造_3(long Axis, double MajorRadius, double MinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Axis;
        a[2] = Double.doubleToRawLongBits(MajorRadius);
        a[3] = Double.doubleToRawLongBits(MinorRadius);
        long r = OcctGen.occtCall(2586, a, box);
        return r;
    }
    public static void SetHypr2d(long self, long H) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = H;
        OcctGen.occtCall(2587, a, box);
    }
    public static void SetMajorRadius(long self, double MajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MajorRadius);
        OcctGen.occtCall(2588, a, box);
    }
    public static void SetMinorRadius(long self, double MinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MinorRadius);
        OcctGen.occtCall(2589, a, box);
    }
    public static long Hypr2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2590, a, box);
        return r;
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2591, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2592, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2593, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2594, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2595, a, box);
        return r != 0;
    }
    public static long Asymptote1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2596, a, box);
        return r;
    }
    public static long Asymptote2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2597, a, box);
        return r;
    }
    public static long ConjugateBranch1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2598, a, box);
        return r;
    }
    public static long ConjugateBranch2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2599, a, box);
        return r;
    }
    public static long Directrix1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2600, a, box);
        return r;
    }
    public static long Directrix2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2601, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2602, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2603, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2604, a, box);
        return r;
    }
    public static long Focus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2605, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2606, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2607, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long OtherBranch(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2608, a, box);
        return r;
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2609, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2610, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2611, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2612, a, box);
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
        OcctGen.occtCall(2613, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2614, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2615, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2616, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2617, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Line {
        private Geom2d_Line() {}

    public static long 构造(long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A;
        long r = OcctGen.occtCall(2618, a, box);
        return r;
    }
    public static long 构造_2(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(2619, a, box);
        return r;
    }
    public static long 构造_3(long P, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P;
        a[2] = V;
        long r = OcctGen.occtCall(2620, a, box);
        return r;
    }
    public static void SetLin2d(long self, long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        OcctGen.occtCall(2621, a, box);
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(2622, a, box);
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2623, a, box);
        return r;
    }
    public static void SetLocation(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2624, a, box);
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2625, a, box);
        return r;
    }
    public static void SetPosition(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        OcctGen.occtCall(2626, a, box);
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2627, a, box);
        return r;
    }
    public static long Lin2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2628, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2629, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2630, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2631, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2632, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2633, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2634, a, box);
        return r != 0;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2635, a, box);
        return (int) r;
    }
    public static double Distance(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(2636, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(2637, a, box);
        return r != 0;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2638, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2639, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2640, a, box);
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
        OcctGen.occtCall(2641, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2642, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2643, a, box);
    }
    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(2644, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(2645, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2646, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2647, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_OffsetCurve {
        private Geom2d_OffsetCurve() {}

    public static long 构造(long C, double Offset, boolean isNotCheckC0) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(Offset);
        a[3] = isNotCheckC0 ? 1L : 0L;
        long r = OcctGen.occtCall(2648, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2649, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2650, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetBasisCurve(long self, long C, boolean isNotCheckC0) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = isNotCheckC0 ? 1L : 0L;
        OcctGen.occtCall(2651, a, box);
    }
    public static void SetOffsetValue(long self, double D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(D);
        OcctGen.occtCall(2652, a, box);
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2653, a, box);
        return r;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2654, a, box);
        return (int) r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2655, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2656, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2657, a, box);
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
        OcctGen.occtCall(2658, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2659, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2660, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2661, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Offset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2662, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2663, a, box);
        return r != 0;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(2664, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2665, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2666, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2667, a, box);
    }
    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(2668, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(2669, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2670, a, box);
        return r;
    }
    public static int GetBasisCurveContinuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2671, a, box);
        return (int) r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2672, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Parabola {
        private Geom2d_Parabola() {}

    public static long 构造(long Prb) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Prb;
        long r = OcctGen.occtCall(2673, a, box);
        return r;
    }
    public static long 构造_2(long MirrorAxis, double Focal, boolean Sense) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = MirrorAxis;
        a[2] = Double.doubleToRawLongBits(Focal);
        a[3] = Sense ? 1L : 0L;
        long r = OcctGen.occtCall(2674, a, box);
        return r;
    }
    public static long 构造_3(long Axis, double Focal) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Axis;
        a[2] = Double.doubleToRawLongBits(Focal);
        long r = OcctGen.occtCall(2675, a, box);
        return r;
    }
    public static long 构造_4(long D, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = D;
        a[2] = F;
        long r = OcctGen.occtCall(2676, a, box);
        return r;
    }
    public static void SetFocal(long self, double Focal) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Focal);
        OcctGen.occtCall(2677, a, box);
    }
    public static void SetParab2d(long self, long Prb) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Prb;
        OcctGen.occtCall(2678, a, box);
    }
    public static long Parab2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2679, a, box);
        return r;
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2680, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2681, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2682, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2683, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2684, a, box);
        return r != 0;
    }
    public static long Directrix(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2685, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2686, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2687, a, box);
        return r;
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2688, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2689, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2690, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2691, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2692, a, box);
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
        OcctGen.occtCall(2693, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2694, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2695, a, box);
    }
    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(2696, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(2697, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2698, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2699, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Point {
        private Geom2d_Point() {}

    public static double Distance(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2700, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2701, a, box);
        return Double.longBitsToDouble(r);
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2702, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Transformation {
        private Geom2d_Transformation() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2703, a, box);
        return r;
    }
    public static long 构造_2(long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = T;
        long r = OcctGen.occtCall(2704, a, box);
        return r;
    }
    public static void SetMirror(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2705, a, box);
    }
    public static void SetMirror_2(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        OcctGen.occtCall(2706, a, box);
    }
    public static void SetRotation(long self, long P, double Ang) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(Ang);
        OcctGen.occtCall(2707, a, box);
    }
    public static void SetScale(long self, long P, double S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(S);
        OcctGen.occtCall(2708, a, box);
    }
    public static void SetTransformation(long self, long FromSystem1, long ToSystem2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = FromSystem1;
        a[2] = ToSystem2;
        OcctGen.occtCall(2709, a, box);
    }
    public static void SetTransformation_2(long self, long ToSystem) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ToSystem;
        OcctGen.occtCall(2710, a, box);
    }
    public static void SetTranslation(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(2711, a, box);
    }
    public static void SetTranslation_2(long self, long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        OcctGen.occtCall(2712, a, box);
    }
    public static void SetTrsf2d(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2713, a, box);
    }
    public static boolean IsNegative(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2714, a, box);
        return r != 0;
    }
    public static int Form(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2715, a, box);
        return (int) r;
    }
    public static double ScaleFactor(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2716, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Trsf2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2717, a, box);
        return r;
    }
    public static double Value(long self, int Row, int Col) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Row;
        a[2] = Col;
        long r = OcctGen.occtCall(2718, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2719, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2720, a, box);
        return r;
    }
    public static long Multiplied(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2721, a, box);
        return r;
    }
    public static void Multiply(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(2722, a, box);
    }
    public static void Power(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(2723, a, box);
    }
    public static long Powered(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(2724, a, box);
        return r;
    }
    public static void PreMultiply(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(2725, a, box);
    }
    public static void Transforms(long self, double[] XOut, double[] YOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2726, a, box);
        if (XOut != null && XOut.length != 0) XOut[0] = Double.longBitsToDouble(a[1]);
        if (YOut != null && YOut.length != 0) YOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2727, a, box);
        return r;
    }
    }

    public static final class Geom2d_TrimmedCurve {
        private Geom2d_TrimmedCurve() {}

    public static long 构造(long C, double U1, double U2, boolean Sense, boolean theAdjustPeriodic) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U1);
        a[3] = Double.doubleToRawLongBits(U2);
        a[4] = Sense ? 1L : 0L;
        a[5] = theAdjustPeriodic ? 1L : 0L;
        long r = OcctGen.occtCall(2728, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2729, a, box);
    }
    public static double ReversedParameter(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(2730, a, box);
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
        OcctGen.occtCall(2731, a, box);
    }
    public static long BasisCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2732, a, box);
        return r;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2733, a, box);
        return (int) r;
    }
    public static boolean IsCN(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(2734, a, box);
        return r != 0;
    }
    public static long EndPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2735, a, box);
        return r;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2736, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsClosed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2737, a, box);
        return r != 0;
    }
    public static boolean IsPeriodic(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2738, a, box);
        return r != 0;
    }
    public static double Period(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2739, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2740, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long StartPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2741, a, box);
        return r;
    }
    public static void D0(long self, double U, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        OcctGen.occtCall(2742, a, box);
    }
    public static void D1(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(2743, a, box);
    }
    public static void D2(long self, double U, long P, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(2744, a, box);
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
        OcctGen.occtCall(2745, a, box);
    }
    public static long DN(long self, double U, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = N;
        long r = OcctGen.occtCall(2746, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2747, a, box);
    }
    public static double TransformedParameter(long self, double U, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = T;
        long r = OcctGen.occtCall(2748, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParametricTransformation(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(2749, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2750, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2751, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Geom2d_Vector {
        private Geom2d_Vector() {}

    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2752, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2753, a, box);
        return r;
    }
    public static double Angle(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2754, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord(long self, double[] XOut, double[] YOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2755, a, box);
        if (XOut != null && XOut.length != 0) XOut[0] = Double.longBitsToDouble(a[1]);
        if (YOut != null && YOut.length != 0) YOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2756, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2757, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Dot(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2758, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Vec2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2759, a, box);
        return r;
    }
    }

    public static final class Geom2d_VectorWithMagnitude {
        private Geom2d_VectorWithMagnitude() {}

    public static long 构造(long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = V;
        long r = OcctGen.occtCall(2760, a, box);
        return r;
    }
    public static long 构造_2(double X, double Y) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        long r = OcctGen.occtCall(2761, a, box);
        return r;
    }
    public static long 构造_3(long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(2762, a, box);
        return r;
    }
    public static void SetCoord(long self, double X, double Y) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(2763, a, box);
    }
    public static void SetVec2d(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(2764, a, box);
    }
    public static void SetX(long self, double X) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        OcctGen.occtCall(2765, a, box);
    }
    public static void SetY(long self, double Y) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(2766, a, box);
    }
    public static double Magnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2767, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareMagnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2768, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Add(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(2769, a, box);
    }
    public static long Added(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2770, a, box);
        return r;
    }
    public static double Crossed(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2771, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Divide(long self, double Scalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Scalar);
        OcctGen.occtCall(2772, a, box);
    }
    public static long Divided(long self, double Scalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Scalar);
        long r = OcctGen.occtCall(2773, a, box);
        return r;
    }
    public static long Multiplied(long self, double Scalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Scalar);
        long r = OcctGen.occtCall(2774, a, box);
        return r;
    }
    public static void Multiply(long self, double Scalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Scalar);
        OcctGen.occtCall(2775, a, box);
    }
    public static void Normalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2776, a, box);
    }
    public static long Normalized(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2777, a, box);
        return r;
    }
    public static void Subtract(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(2778, a, box);
    }
    public static long Subtracted(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2779, a, box);
        return r;
    }
    public static void Transform(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        OcctGen.occtCall(2780, a, box);
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2781, a, box);
        return r;
    }
    }

}
