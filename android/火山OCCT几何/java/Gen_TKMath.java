package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKMath 类=49 方法槽=1530
public final class Gen_TKMath {
    private Gen_TKMath() {}

    public static final class Bnd_Box {
        private Bnd_Box() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2062, a, box);
        return r;
    }
    public static long 构造_2(long theMin, long theMax) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theMin;
        a[2] = theMax;
        long r = OcctGen.occtCall(2063, a, box);
        return r;
    }
    public static void SetWhole(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2064, a, box);
    }
    public static void Set(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2065, a, box);
    }
    public static void Set_2(long self, long P, long D) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = D;
        OcctGen.occtCall(2066, a, box);
    }
    public static void Update(
            long self, double aXmin, double aYmin, double aZmin, double aXmax, double aYmax,
            double aZmax) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(aXmin);
        a[2] = Double.doubleToRawLongBits(aYmin);
        a[3] = Double.doubleToRawLongBits(aZmin);
        a[4] = Double.doubleToRawLongBits(aXmax);
        a[5] = Double.doubleToRawLongBits(aYmax);
        a[6] = Double.doubleToRawLongBits(aZmax);
        OcctGen.occtCall(2067, a, box);
    }
    public static void Update_2(long self, double X, double Y, double Z) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        a[3] = Double.doubleToRawLongBits(Z);
        OcctGen.occtCall(2068, a, box);
    }
    public static double GetGap(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2069, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetGap(long self, double Tol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(2070, a, box);
    }
    public static void Enlarge(long self, double Tol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(2071, a, box);
    }
    public static void Get(
            long self, double[] theXminOut, double[] theYminOut, double[] theZminOut,
            double[] theXmaxOut, double[] theYmaxOut, double[] theZmaxOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2072, a, box);
        if (theXminOut != null && theXminOut.length != 0) theXminOut[0] = Double.longBitsToDouble(a[1]);
        if (theYminOut != null && theYminOut.length != 0) theYminOut[0] = Double.longBitsToDouble(a[2]);
        if (theZminOut != null && theZminOut.length != 0) theZminOut[0] = Double.longBitsToDouble(a[3]);
        if (theXmaxOut != null && theXmaxOut.length != 0) theXmaxOut[0] = Double.longBitsToDouble(a[4]);
        if (theYmaxOut != null && theYmaxOut.length != 0) theYmaxOut[0] = Double.longBitsToDouble(a[5]);
        if (theZmaxOut != null && theZmaxOut.length != 0) theZmaxOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static long CornerMin(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2073, a, box);
        return r;
    }
    public static long CornerMax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2074, a, box);
        return r;
    }
    public static void OpenXmin(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2075, a, box);
    }
    public static void OpenXmax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2076, a, box);
    }
    public static void OpenYmin(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2077, a, box);
    }
    public static void OpenYmax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2078, a, box);
    }
    public static void OpenZmin(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2079, a, box);
    }
    public static void OpenZmax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2080, a, box);
    }
    public static boolean IsWhole(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2081, a, box);
        return r != 0;
    }
    public static boolean IsXThin(long self, double tol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(tol);
        long r = OcctGen.occtCall(2082, a, box);
        return r != 0;
    }
    public static boolean IsYThin(long self, double tol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(tol);
        long r = OcctGen.occtCall(2083, a, box);
        return r != 0;
    }
    public static boolean IsZThin(long self, double tol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(tol);
        long r = OcctGen.occtCall(2084, a, box);
        return r != 0;
    }
    public static boolean IsThin(long self, double tol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(tol);
        long r = OcctGen.occtCall(2085, a, box);
        return r != 0;
    }
    public static long Transformed(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(2086, a, box);
        return r;
    }
    public static void Add(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(2087, a, box);
    }
    public static void Add_2(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(2088, a, box);
    }
    public static void Add_3(long self, long P, long D) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = D;
        OcctGen.occtCall(2089, a, box);
    }
    public static void Add_4(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(2090, a, box);
    }
    public static boolean IsOut(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(2091, a, box);
        return r != 0;
    }
    public static boolean IsOut_2(long self, long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        long r = OcctGen.occtCall(2092, a, box);
        return r != 0;
    }
    public static boolean IsOut_3(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(2093, a, box);
        return r != 0;
    }
    public static boolean IsOut_4(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2094, a, box);
        return r != 0;
    }
    public static boolean IsOut_5(long self, long Other, long T) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        a[2] = T;
        long r = OcctGen.occtCall(2095, a, box);
        return r != 0;
    }
    public static boolean IsOut_6(long self, long T1, long Other, long T2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = T1;
        a[2] = Other;
        a[3] = T2;
        long r = OcctGen.occtCall(2096, a, box);
        return r != 0;
    }
    public static boolean IsOut_7(long self, long P1, long P2, long D) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = P1;
        a[2] = P2;
        a[3] = D;
        long r = OcctGen.occtCall(2097, a, box);
        return r != 0;
    }
    public static double Distance(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2098, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Dump(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2099, a, box);
    }
    public static double SquareExtent(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2100, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long FinitePart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2101, a, box);
        return r;
    }
    public static boolean HasFinitePart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2102, a, box);
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2103, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(2104, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class Bnd_Box2d {
        private Bnd_Box2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2105, a, box);
        return r;
    }
    public static void SetWhole(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2106, a, box);
    }
    public static void Update(long self, double aXmin, double aYmin, double aXmax, double aYmax) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(aXmin);
        a[2] = Double.doubleToRawLongBits(aYmin);
        a[3] = Double.doubleToRawLongBits(aXmax);
        a[4] = Double.doubleToRawLongBits(aYmax);
        OcctGen.occtCall(2107, a, box);
    }
    public static void Update_2(long self, double X, double Y) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        OcctGen.occtCall(2108, a, box);
    }
    public static double GetGap(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2109, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetGap(long self, double Tol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(2110, a, box);
    }
    public static void Enlarge(long self, double theTol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTol);
        OcctGen.occtCall(2111, a, box);
    }
    public static void Get(
            long self, double[] aXminOut, double[] aYminOut, double[] aXmaxOut, double[] aYmaxOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2112, a, box);
        if (aXminOut != null && aXminOut.length != 0) aXminOut[0] = Double.longBitsToDouble(a[1]);
        if (aYminOut != null && aYminOut.length != 0) aYminOut[0] = Double.longBitsToDouble(a[2]);
        if (aXmaxOut != null && aXmaxOut.length != 0) aXmaxOut[0] = Double.longBitsToDouble(a[3]);
        if (aYmaxOut != null && aYmaxOut.length != 0) aYmaxOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static void OpenXmin(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2113, a, box);
    }
    public static void OpenXmax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2114, a, box);
    }
    public static void OpenYmin(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2115, a, box);
    }
    public static void OpenYmax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2116, a, box);
    }
    public static boolean IsWhole(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2117, a, box);
        return r != 0;
    }
    public static long Transformed(long self, long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        long r = OcctGen.occtCall(2118, a, box);
        return r;
    }
    public static void Add(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(2119, a, box);
    }
    public static void Add_2(long self, long thePnt) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = thePnt;
        OcctGen.occtCall(2120, a, box);
    }
    public static void Add_3(long self, long thePnt, long theDir) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = thePnt;
        a[2] = theDir;
        OcctGen.occtCall(2121, a, box);
    }
    public static void Add_4(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(2122, a, box);
    }
    public static boolean IsOut(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(2123, a, box);
        return r != 0;
    }
    public static boolean IsOut_2(long self, long theL) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theL;
        long r = OcctGen.occtCall(2124, a, box);
        return r != 0;
    }
    public static boolean IsOut_3(long self, long theP0, long theP1) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP0;
        a[2] = theP1;
        long r = OcctGen.occtCall(2125, a, box);
        return r != 0;
    }
    public static boolean IsOut_4(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(2126, a, box);
        return r != 0;
    }
    public static boolean IsOut_5(long self, long theOther, long theTrsf) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = theTrsf;
        long r = OcctGen.occtCall(2127, a, box);
        return r != 0;
    }
    public static boolean IsOut_6(long self, long T1, long Other, long T2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = T1;
        a[2] = Other;
        a[3] = T2;
        long r = OcctGen.occtCall(2128, a, box);
        return r != 0;
    }
    public static void Dump(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2129, a, box);
    }
    public static double SquareExtent(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2130, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class Bnd_OBB {
        private Bnd_OBB() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(2131, a, box);
        return r;
    }
    public static void SetCenter(long self, long theCenter) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCenter;
        OcctGen.occtCall(2132, a, box);
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2133, a, box);
        return r;
    }
    public static long Center(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2134, a, box);
        return r;
    }
    public static long XDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2135, a, box);
        return r;
    }
    public static long YDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2136, a, box);
        return r;
    }
    public static long ZDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2137, a, box);
        return r;
    }
    public static double XHSize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2138, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double YHSize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2139, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ZHSize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2140, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsVoid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2141, a, box);
        return r != 0;
    }
    public static void SetVoid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2142, a, box);
    }
    public static void SetAABox(long self, boolean theFlag) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theFlag ? 1L : 0L;
        OcctGen.occtCall(2143, a, box);
    }
    public static boolean IsAABox(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2144, a, box);
        return r != 0;
    }
    public static void Enlarge(long self, double theGapAdd) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theGapAdd);
        OcctGen.occtCall(2145, a, box);
    }
    public static double SquareExtent(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2146, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsOut(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(2147, a, box);
        return r != 0;
    }
    public static boolean IsOut_2(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(2148, a, box);
        return r != 0;
    }
    public static boolean IsCompletelyInside(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(2149, a, box);
        return r != 0;
    }
    public static void Add(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(2150, a, box);
    }
    public static void Add_2(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(2151, a, box);
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(2152, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Expr_GeneralExpression {
        private Expr_GeneralExpression() {}

    public static boolean IsShareable(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2153, a, box);
        return r != 0;
    }
    public static long NDerivative(long self, long X, int N) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = X;
        a[2] = N;
        long r = OcctGen.occtCall(2154, a, box);
        return r;
    }
    public static double EvaluateNumeric(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2155, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class Expr_NamedUnknown {
        private Expr_NamedUnknown() {}

    public static long 构造(String name) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = name;
        long r = OcctGen.occtCall(2156, a, box);
        return r;
    }
    public static boolean IsAssigned(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2157, a, box);
        return r != 0;
    }
    public static long AssignedExpression(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2158, a, box);
        return r;
    }
    public static void Assign(long self, long exp) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = exp;
        OcctGen.occtCall(2159, a, box);
    }
    public static void Deassign(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(2160, a, box);
    }
    public static int NbSubExpressions(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2161, a, box);
        return (int) r;
    }
    public static long SubExpression(long self, int I) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = I;
        long r = OcctGen.occtCall(2162, a, box);
        return r;
    }
    public static long Simplified(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2163, a, box);
        return r;
    }
    public static long ShallowSimplified(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2164, a, box);
        return r;
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2165, a, box);
        return r;
    }
    public static boolean ContainsUnknowns(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2166, a, box);
        return r != 0;
    }
    public static boolean Contains(long self, long exp) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = exp;
        long r = OcctGen.occtCall(2167, a, box);
        return r != 0;
    }
    public static boolean IsLinear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(2168, a, box);
        return r != 0;
    }
    public static long Derivative(long self, long X) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = X;
        long r = OcctGen.occtCall(2169, a, box);
        return r;
    }
    public static void Replace(long self, long var_, long with) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = var_;
        a[2] = with;
        OcctGen.occtCall(2170, a, box);
    }
    }

    public static final class Poly_Polygon3D {
        private Poly_Polygon3D() {}

    public static long 构造(int theNbNodes, boolean theHasParams) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theNbNodes;
        a[2] = theHasParams ? 1L : 0L;
        long r = OcctGen.occtCall(4091, a, box);
        return r;
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4092, a, box);
        return r;
    }
    public static double Deflection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4093, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Deflection_2(long self, double theDefl) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDefl);
        OcctGen.occtCall(4094, a, box);
    }
    public static int NbNodes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4095, a, box);
        return (int) r;
    }
    public static boolean HasParameters(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4096, a, box);
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(4097, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Poly_PolygonOnTriangulation {
        private Poly_PolygonOnTriangulation() {}

    public static long 构造(int theNbNodes, boolean theHasParams) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theNbNodes;
        a[2] = theHasParams ? 1L : 0L;
        long r = OcctGen.occtCall(4098, a, box);
        return r;
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4099, a, box);
        return r;
    }
    public static double Deflection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4100, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Deflection_2(long self, double theDefl) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDefl);
        OcctGen.occtCall(4101, a, box);
    }
    public static int NbNodes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4102, a, box);
        return (int) r;
    }
    public static int Node(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(4103, a, box);
        return (int) r;
    }
    public static void SetNode(long self, int theIndex, int theNode) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = theNode;
        OcctGen.occtCall(4104, a, box);
    }
    public static boolean HasParameters(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4105, a, box);
        return r != 0;
    }
    public static double Parameter(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(4106, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetParameter(long self, int theIndex, double theValue) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theValue);
        OcctGen.occtCall(4107, a, box);
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(4108, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class Poly_Triangle {
        private Poly_Triangle() {}

    public static long 构造(int theN1, int theN2, int theN3) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theN1;
        a[2] = theN2;
        a[3] = theN3;
        long r = OcctGen.occtCall(4109, a, box);
        return r;
    }
    public static void Set(long self, int theN1, int theN2, int theN3) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theN1;
        a[2] = theN2;
        a[3] = theN3;
        OcctGen.occtCall(4110, a, box);
    }
    public static void Set_2(long self, int theIndex, int theNode) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = theNode;
        OcctGen.occtCall(4111, a, box);
    }
    public static void Get(long self, int[] theN1Out, int[] theN2Out, int[] theN3Out) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4112, a, box);
        if (theN1Out != null && theN1Out.length != 0) theN1Out[0] = (int) a[1];
        if (theN2Out != null && theN2Out.length != 0) theN2Out[0] = (int) a[2];
        if (theN3Out != null && theN3Out.length != 0) theN3Out[0] = (int) a[3];
    }
    public static int Value(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(4113, a, box);
        return (int) r;
    }
    public static int ChangeValue(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(4114, a, box);
        return (int) r;
    }
    }

    public static final class Poly_Triangulation {
        private Poly_Triangulation() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4115, a, box);
        return r;
    }
    public static long 构造_2(
            int theNbNodes, int theNbTriangles, boolean theHasUVNodes, boolean theHasNormals) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theNbNodes;
        a[2] = theNbTriangles;
        a[3] = theHasUVNodes ? 1L : 0L;
        a[4] = theHasNormals ? 1L : 0L;
        long r = OcctGen.occtCall(4116, a, box);
        return r;
    }
    public static long Copy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4117, a, box);
        return r;
    }
    public static long 构造_3(long theTriangulation) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theTriangulation;
        long r = OcctGen.occtCall(4118, a, box);
        return r;
    }
    public static double Deflection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4119, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Deflection_2(long self, double theDeflection) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDeflection);
        OcctGen.occtCall(4120, a, box);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4121, a, box);
    }
    public static boolean HasGeometry(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4122, a, box);
        return r != 0;
    }
    public static int NbNodes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4123, a, box);
        return (int) r;
    }
    public static int NbTriangles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4124, a, box);
        return (int) r;
    }
    public static boolean HasUVNodes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4125, a, box);
        return r != 0;
    }
    public static boolean HasNormals(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4126, a, box);
        return r != 0;
    }
    public static long Node(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(4127, a, box);
        return r;
    }
    public static void SetNode(long self, int theIndex, long thePnt) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = thePnt;
        OcctGen.occtCall(4128, a, box);
    }
    public static long UVNode(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(4129, a, box);
        return r;
    }
    public static void SetUVNode(long self, int theIndex, long thePnt) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = thePnt;
        OcctGen.occtCall(4130, a, box);
    }
    public static long Triangle(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(4131, a, box);
        return r;
    }
    public static void SetTriangle(long self, int theIndex, long theTriangle) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = theTriangle;
        OcctGen.occtCall(4132, a, box);
    }
    public static long Normal(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(4133, a, box);
        return r;
    }
    public static void SetNormal(long self, int theIndex, long theNormal) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = theNormal;
        OcctGen.occtCall(4134, a, box);
    }
    public static long CachedMinMax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4135, a, box);
        return r;
    }
    public static void SetCachedMinMax(long self, long theBox) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theBox;
        OcctGen.occtCall(4136, a, box);
    }
    public static boolean HasCachedMinMax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4137, a, box);
        return r != 0;
    }
    public static void UpdateCachedMinMax(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4138, a, box);
    }
    public static boolean MinMax(long self, long theBox, long theTrsf, boolean theIsAccurate) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theBox;
        a[2] = theTrsf;
        a[3] = theIsAccurate ? 1L : 0L;
        long r = OcctGen.occtCall(4139, a, box);
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(4140, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean IsDoublePrecision(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4141, a, box);
        return r != 0;
    }
    public static void SetDoublePrecision(long self, boolean theIsDouble) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsDouble ? 1L : 0L;
        OcctGen.occtCall(4142, a, box);
    }
    public static void ResizeNodes(long self, int theNbNodes, boolean theToCopyOld) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theNbNodes;
        a[2] = theToCopyOld ? 1L : 0L;
        OcctGen.occtCall(4143, a, box);
    }
    public static void ResizeTriangles(long self, int theNbTriangles, boolean theToCopyOld) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theNbTriangles;
        a[2] = theToCopyOld ? 1L : 0L;
        OcctGen.occtCall(4144, a, box);
    }
    public static void AddUVNodes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4145, a, box);
    }
    public static void RemoveUVNodes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4146, a, box);
    }
    public static void AddNormals(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4147, a, box);
    }
    public static void RemoveNormals(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4148, a, box);
    }
    public static void ComputeNormals(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4149, a, box);
    }
    public static int NbDeferredNodes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4150, a, box);
        return (int) r;
    }
    public static int NbDeferredTriangles(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4151, a, box);
        return (int) r;
    }
    public static boolean HasDeferredData(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4152, a, box);
        return r != 0;
    }
    public static boolean LoadDeferredData(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4153, a, box);
        return r != 0;
    }
    public static long DetachedLoadDeferredData(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4154, a, box);
        return r;
    }
    public static boolean UnloadDeferredData(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4155, a, box);
        return r != 0;
    }
    }

    public static final class Precision {
        private Precision() {}

    public static double Angular() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4156, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Confusion() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4157, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareConfusion() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4158, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Intersection() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4159, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Approximation() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4160, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parametric(double P, double T) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(P);
        a[2] = Double.doubleToRawLongBits(T);
        long r = OcctGen.occtCall(4161, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double PConfusion(double T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(T);
        long r = OcctGen.occtCall(4162, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquarePConfusion() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4163, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double PIntersection(double T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(T);
        long r = OcctGen.occtCall(4164, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double PApproximation(double T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(T);
        long r = OcctGen.occtCall(4165, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parametric_2(double P) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(P);
        long r = OcctGen.occtCall(4166, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double PConfusion_2() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4167, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double PIntersection_2() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4168, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double PApproximation_2() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4169, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsInfinite(double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        long r = OcctGen.occtCall(4170, a, box);
        return r != 0;
    }
    public static boolean IsPositiveInfinite(double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        long r = OcctGen.occtCall(4171, a, box);
        return r != 0;
    }
    public static boolean IsNegativeInfinite(double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        long r = OcctGen.occtCall(4172, a, box);
        return r != 0;
    }
    public static double Infinite() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4173, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class TopLoc_Location {
        private TopLoc_Location() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4829, a, box);
        return r;
    }
    public static long 构造_2(long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = T;
        long r = OcctGen.occtCall(4830, a, box);
        return r;
    }
    public static boolean IsIdentity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4831, a, box);
        return r != 0;
    }
    public static void Identity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4832, a, box);
    }
    public static int FirstPower(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4833, a, box);
        return (int) r;
    }
    public static long NextLocation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4834, a, box);
        return r;
    }
    public static long Transformation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4835, a, box);
        return r;
    }
    public static long 转gp_Trsf(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4836, a, box);
        return r;
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4837, a, box);
        return r;
    }
    public static long Multiplied(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(4838, a, box);
        return r;
    }
    public static long Divided(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(4839, a, box);
        return r;
    }
    public static long Predivided(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(4840, a, box);
        return r;
    }
    public static long Powered(long self, int pwr) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = pwr;
        long r = OcctGen.occtCall(4841, a, box);
        return r;
    }
    public static long HashCode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4842, a, box);
        return r;
    }
    public static boolean IsEqual(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(4843, a, box);
        return r != 0;
    }
    public static boolean IsDifferent(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(4844, a, box);
        return r != 0;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(4845, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String ShallowDump(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4846, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4847, a, box);
    }
    public static double ScalePrec() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4848, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class gp_Ax1 {
        private gp_Ax1() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4940, a, box);
        return r;
    }
    public static long 构造_2(long theP, long theV) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theP;
        a[2] = theV;
        long r = OcctGen.occtCall(4941, a, box);
        return r;
    }
    public static void SetDirection(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(4942, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(4943, a, box);
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4944, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4945, a, box);
        return r;
    }
    public static boolean IsCoaxial(
            long self, long Other, double AngularTolerance, double LinearTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        a[2] = Double.doubleToRawLongBits(AngularTolerance);
        a[3] = Double.doubleToRawLongBits(LinearTolerance);
        long r = OcctGen.occtCall(4946, a, box);
        return r != 0;
    }
    public static boolean IsNormal(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(4947, a, box);
        return r != 0;
    }
    public static boolean IsOpposite(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(4948, a, box);
        return r != 0;
    }
    public static boolean IsParallel(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(4949, a, box);
        return r != 0;
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4950, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4951, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4952, a, box);
        return r;
    }
    public static void Mirror(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(4953, a, box);
    }
    public static long Mirrored(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(4954, a, box);
        return r;
    }
    public static void Mirror_2(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        OcctGen.occtCall(4955, a, box);
    }
    public static long Mirrored_2(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        long r = OcctGen.occtCall(4956, a, box);
        return r;
    }
    public static void Mirror_3(long self, long A2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A2;
        OcctGen.occtCall(4957, a, box);
    }
    public static long Mirrored_3(long self, long A2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A2;
        long r = OcctGen.occtCall(4958, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAngRad) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAngRad);
        OcctGen.occtCall(4959, a, box);
    }
    public static long Rotated(long self, long theA1, double theAngRad) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAngRad);
        long r = OcctGen.occtCall(4960, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(4961, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(4962, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(4963, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(4964, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(4965, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(4966, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(4967, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(4968, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(4969, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(4970, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class gp_Ax2 {
        private gp_Ax2() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4971, a, box);
        return r;
    }
    public static long 构造_2(long P, long N, long Vx) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = P;
        a[2] = N;
        a[3] = Vx;
        long r = OcctGen.occtCall(4972, a, box);
        return r;
    }
    public static long 构造_3(long P, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P;
        a[2] = V;
        long r = OcctGen.occtCall(4973, a, box);
        return r;
    }
    public static void SetAxis(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        OcctGen.occtCall(4974, a, box);
    }
    public static void SetDirection(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(4975, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(4976, a, box);
    }
    public static void SetXDirection(long self, long theVx) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theVx;
        OcctGen.occtCall(4977, a, box);
    }
    public static void SetYDirection(long self, long theVy) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theVy;
        OcctGen.occtCall(4978, a, box);
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4979, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4980, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4981, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4982, a, box);
        return r;
    }
    public static long XDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4983, a, box);
        return r;
    }
    public static long YDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4984, a, box);
        return r;
    }
    public static boolean IsCoplanar(
            long self, long Other, double LinearTolerance, double AngularTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        a[2] = Double.doubleToRawLongBits(LinearTolerance);
        a[3] = Double.doubleToRawLongBits(AngularTolerance);
        long r = OcctGen.occtCall(4985, a, box);
        return r != 0;
    }
    public static boolean IsCoplanar_2(
            long self, long A1, double LinearTolerance, double AngularTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        a[2] = Double.doubleToRawLongBits(LinearTolerance);
        a[3] = Double.doubleToRawLongBits(AngularTolerance);
        long r = OcctGen.occtCall(4986, a, box);
        return r != 0;
    }
    public static void Mirror(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(4987, a, box);
    }
    public static long Mirrored(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(4988, a, box);
        return r;
    }
    public static void Mirror_2(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        OcctGen.occtCall(4989, a, box);
    }
    public static long Mirrored_2(long self, long A1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A1;
        long r = OcctGen.occtCall(4990, a, box);
        return r;
    }
    public static void Mirror_3(long self, long A2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A2;
        OcctGen.occtCall(4991, a, box);
    }
    public static long Mirrored_3(long self, long A2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A2;
        long r = OcctGen.occtCall(4992, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(4993, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(4994, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(4995, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(4996, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(4997, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(4998, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(4999, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5000, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5001, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5002, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5003, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(5004, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class gp_Ax22d {
        private gp_Ax22d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5005, a, box);
        return r;
    }
    public static long 构造_2(long theP, long theV, boolean theIsSense) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theP;
        a[2] = theV;
        a[3] = theIsSense ? 1L : 0L;
        long r = OcctGen.occtCall(5006, a, box);
        return r;
    }
    public static long 构造_3(long theA, boolean theIsSense) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theA;
        a[2] = theIsSense ? 1L : 0L;
        long r = OcctGen.occtCall(5007, a, box);
        return r;
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5008, a, box);
    }
    public static void SetXAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5009, a, box);
    }
    public static void SetYAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5010, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5011, a, box);
    }
    public static void SetXDirection(long self, long theVx) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theVx;
        OcctGen.occtCall(5012, a, box);
    }
    public static void SetYDirection(long self, long theVy) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theVy;
        OcctGen.occtCall(5013, a, box);
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5014, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5015, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5016, a, box);
        return r;
    }
    public static long XDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5017, a, box);
        return r;
    }
    public static long YDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5018, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5019, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5020, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5021, a, box);
    }
    public static long Mirrored_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        long r = OcctGen.occtCall(5022, a, box);
        return r;
    }
    public static void Rotate(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5023, a, box);
    }
    public static long Rotated(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5024, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5025, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5026, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5027, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5028, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5029, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5030, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5031, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5032, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5033, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class gp_Ax2d {
        private gp_Ax2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5034, a, box);
        return r;
    }
    public static long 构造_2(long theP, long theV) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theP;
        a[2] = theV;
        long r = OcctGen.occtCall(5035, a, box);
        return r;
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5036, a, box);
    }
    public static void SetDirection(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5037, a, box);
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5038, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5039, a, box);
        return r;
    }
    public static boolean IsCoaxial(
            long self, long Other, double AngularTolerance, double LinearTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        a[2] = Double.doubleToRawLongBits(AngularTolerance);
        a[3] = Double.doubleToRawLongBits(LinearTolerance);
        long r = OcctGen.occtCall(5040, a, box);
        return r != 0;
    }
    public static boolean IsNormal(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5041, a, box);
        return r != 0;
    }
    public static boolean IsOpposite(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5042, a, box);
        return r != 0;
    }
    public static boolean IsParallel(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5043, a, box);
        return r != 0;
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5044, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5045, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5046, a, box);
        return r;
    }
    public static void Mirror(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(5047, a, box);
    }
    public static long Mirrored(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        long r = OcctGen.occtCall(5048, a, box);
        return r;
    }
    public static void Mirror_2(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        OcctGen.occtCall(5049, a, box);
    }
    public static long Mirrored_2(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        long r = OcctGen.occtCall(5050, a, box);
        return r;
    }
    public static void Rotate(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5051, a, box);
    }
    public static long Rotated(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5052, a, box);
        return r;
    }
    public static void Scale(long self, long P, double S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(S);
        OcctGen.occtCall(5053, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5054, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5055, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5056, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5057, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5058, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5059, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5060, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5061, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class gp_Ax3 {
        private gp_Ax3() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5062, a, box);
        return r;
    }
    public static long 构造_2(long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theA;
        long r = OcctGen.occtCall(5063, a, box);
        return r;
    }
    public static long 构造_3(long theP, long theN, long theVx) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theP;
        a[2] = theN;
        a[3] = theVx;
        long r = OcctGen.occtCall(5064, a, box);
        return r;
    }
    public static long 构造_4(long theP, long theV) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theP;
        a[2] = theV;
        long r = OcctGen.occtCall(5065, a, box);
        return r;
    }
    public static void XReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5066, a, box);
    }
    public static void YReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5067, a, box);
    }
    public static void ZReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5068, a, box);
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5069, a, box);
    }
    public static void SetDirection(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5070, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5071, a, box);
    }
    public static void SetXDirection(long self, long theVx) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theVx;
        OcctGen.occtCall(5072, a, box);
    }
    public static void SetYDirection(long self, long theVy) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theVy;
        OcctGen.occtCall(5073, a, box);
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5074, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5075, a, box);
        return r;
    }
    public static long Ax2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5076, a, box);
        return r;
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5077, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5078, a, box);
        return r;
    }
    public static long XDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5079, a, box);
        return r;
    }
    public static long YDirection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5080, a, box);
        return r;
    }
    public static boolean Direct(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5081, a, box);
        return r != 0;
    }
    public static boolean IsCoplanar(
            long self, long theOther, double theLinearTolerance, double theAngularTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        a[3] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5082, a, box);
        return r != 0;
    }
    public static boolean IsCoplanar_2(
            long self, long theA1, double theLinearTolerance, double theAngularTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        a[3] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5083, a, box);
        return r != 0;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5084, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5085, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5086, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5087, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5088, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5089, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5090, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5091, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5092, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5093, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5094, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5095, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5096, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5097, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5098, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5099, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5100, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(5101, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class gp_Circ {
        private gp_Circ() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5102, a, box);
        return r;
    }
    public static long 构造_2(long theA2, double theRadius) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theA2;
        a[2] = Double.doubleToRawLongBits(theRadius);
        long r = OcctGen.occtCall(5103, a, box);
        return r;
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5104, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5105, a, box);
    }
    public static void SetPosition(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5106, a, box);
    }
    public static void SetRadius(long self, double theRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theRadius);
        OcctGen.occtCall(5107, a, box);
    }
    public static double Area(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5108, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5109, a, box);
        return r;
    }
    public static double Length(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5110, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5111, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5112, a, box);
        return r;
    }
    public static double Radius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5113, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5114, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5115, a, box);
        return r;
    }
    public static double Distance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5116, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5117, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean Contains(long self, long theP, double theLinearTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        long r = OcctGen.occtCall(5118, a, box);
        return r != 0;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5119, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5120, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5121, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5122, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5123, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5124, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5125, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5126, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5127, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5128, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5129, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5130, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5131, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5132, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5133, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5134, a, box);
        return r;
    }
    }

    public static final class gp_Circ2d {
        private gp_Circ2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5135, a, box);
        return r;
    }
    public static long 构造_2(long theXAxis, double theRadius, boolean theIsSense) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theXAxis;
        a[2] = Double.doubleToRawLongBits(theRadius);
        a[3] = theIsSense ? 1L : 0L;
        long r = OcctGen.occtCall(5136, a, box);
        return r;
    }
    public static long 构造_3(long theAxis, double theRadius) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theAxis;
        a[2] = Double.doubleToRawLongBits(theRadius);
        long r = OcctGen.occtCall(5137, a, box);
        return r;
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5138, a, box);
    }
    public static void SetXAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5139, a, box);
    }
    public static void SetAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5140, a, box);
    }
    public static void SetYAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5141, a, box);
    }
    public static void SetRadius(long self, double theRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theRadius);
        OcctGen.occtCall(5142, a, box);
    }
    public static double Area(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5143, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coefficients(
            long self, double[] theAOut, double[] theBOut, double[] theCOut, double[] theDOut,
            double[] theEOut, double[] theFOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5144, a, box);
        if (theAOut != null && theAOut.length != 0) theAOut[0] = Double.longBitsToDouble(a[1]);
        if (theBOut != null && theBOut.length != 0) theBOut[0] = Double.longBitsToDouble(a[2]);
        if (theCOut != null && theCOut.length != 0) theCOut[0] = Double.longBitsToDouble(a[3]);
        if (theDOut != null && theDOut.length != 0) theDOut[0] = Double.longBitsToDouble(a[4]);
        if (theEOut != null && theEOut.length != 0) theEOut[0] = Double.longBitsToDouble(a[5]);
        if (theFOut != null && theFOut.length != 0) theFOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static boolean Contains(long self, long theP, double theLinearTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        long r = OcctGen.occtCall(5145, a, box);
        return r != 0;
    }
    public static double Distance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5146, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5147, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Length(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5148, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5149, a, box);
        return r;
    }
    public static double Radius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5150, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5151, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5152, a, box);
        return r;
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5153, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5154, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5155, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5156, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5157, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5158, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5159, a, box);
    }
    public static long Mirrored_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        long r = OcctGen.occtCall(5160, a, box);
        return r;
    }
    public static void Rotate(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5161, a, box);
    }
    public static long Rotated(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5162, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5163, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5164, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5165, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5166, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5167, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5168, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5169, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5170, a, box);
        return r;
    }
    }

    public static final class gp_Cone {
        private gp_Cone() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5171, a, box);
        return r;
    }
    public static long 构造_2(long theA3, double theAng, double theRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theA3;
        a[2] = Double.doubleToRawLongBits(theAng);
        a[3] = Double.doubleToRawLongBits(theRadius);
        long r = OcctGen.occtCall(5172, a, box);
        return r;
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5173, a, box);
    }
    public static void SetLocation(long self, long theLoc) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLoc;
        OcctGen.occtCall(5174, a, box);
    }
    public static void SetPosition(long self, long theA3) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA3;
        OcctGen.occtCall(5175, a, box);
    }
    public static void SetRadius(long self, double theR) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theR);
        OcctGen.occtCall(5176, a, box);
    }
    public static void SetSemiAngle(long self, double theAng) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5177, a, box);
    }
    public static long Apex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5178, a, box);
        return r;
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5179, a, box);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5180, a, box);
    }
    public static boolean Direct(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5181, a, box);
        return r != 0;
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5182, a, box);
        return r;
    }
    public static void Coefficients(
            long self, double[] theA1Out, double[] theA2Out, double[] theA3Out, double[] theB1Out,
            double[] theB2Out, double[] theB3Out, double[] theC1Out, double[] theC2Out,
            double[] theC3Out, double[] theDOut) {
        long[] a = new long[11];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5183, a, box);
        if (theA1Out != null && theA1Out.length != 0) theA1Out[0] = Double.longBitsToDouble(a[1]);
        if (theA2Out != null && theA2Out.length != 0) theA2Out[0] = Double.longBitsToDouble(a[2]);
        if (theA3Out != null && theA3Out.length != 0) theA3Out[0] = Double.longBitsToDouble(a[3]);
        if (theB1Out != null && theB1Out.length != 0) theB1Out[0] = Double.longBitsToDouble(a[4]);
        if (theB2Out != null && theB2Out.length != 0) theB2Out[0] = Double.longBitsToDouble(a[5]);
        if (theB3Out != null && theB3Out.length != 0) theB3Out[0] = Double.longBitsToDouble(a[6]);
        if (theC1Out != null && theC1Out.length != 0) theC1Out[0] = Double.longBitsToDouble(a[7]);
        if (theC2Out != null && theC2Out.length != 0) theC2Out[0] = Double.longBitsToDouble(a[8]);
        if (theC3Out != null && theC3Out.length != 0) theC3Out[0] = Double.longBitsToDouble(a[9]);
        if (theDOut != null && theDOut.length != 0) theDOut[0] = Double.longBitsToDouble(a[10]);
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5184, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5185, a, box);
        return r;
    }
    public static double RefRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5186, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SemiAngle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5187, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5188, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5189, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5190, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5191, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5192, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5193, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5194, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5195, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5196, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5197, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5198, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5199, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5200, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5201, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5202, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5203, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5204, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5205, a, box);
        return r;
    }
    }

    public static final class gp_Cylinder {
        private gp_Cylinder() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5206, a, box);
        return r;
    }
    public static long 构造_2(long theA3, double theRadius) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theA3;
        a[2] = Double.doubleToRawLongBits(theRadius);
        long r = OcctGen.occtCall(5207, a, box);
        return r;
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5208, a, box);
    }
    public static void SetLocation(long self, long theLoc) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLoc;
        OcctGen.occtCall(5209, a, box);
    }
    public static void SetPosition(long self, long theA3) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA3;
        OcctGen.occtCall(5210, a, box);
    }
    public static void SetRadius(long self, double theR) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theR);
        OcctGen.occtCall(5211, a, box);
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5212, a, box);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5213, a, box);
    }
    public static boolean Direct(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5214, a, box);
        return r != 0;
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5215, a, box);
        return r;
    }
    public static void Coefficients(
            long self, double[] theA1Out, double[] theA2Out, double[] theA3Out, double[] theB1Out,
            double[] theB2Out, double[] theB3Out, double[] theC1Out, double[] theC2Out,
            double[] theC3Out, double[] theDOut) {
        long[] a = new long[11];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5216, a, box);
        if (theA1Out != null && theA1Out.length != 0) theA1Out[0] = Double.longBitsToDouble(a[1]);
        if (theA2Out != null && theA2Out.length != 0) theA2Out[0] = Double.longBitsToDouble(a[2]);
        if (theA3Out != null && theA3Out.length != 0) theA3Out[0] = Double.longBitsToDouble(a[3]);
        if (theB1Out != null && theB1Out.length != 0) theB1Out[0] = Double.longBitsToDouble(a[4]);
        if (theB2Out != null && theB2Out.length != 0) theB2Out[0] = Double.longBitsToDouble(a[5]);
        if (theB3Out != null && theB3Out.length != 0) theB3Out[0] = Double.longBitsToDouble(a[6]);
        if (theC1Out != null && theC1Out.length != 0) theC1Out[0] = Double.longBitsToDouble(a[7]);
        if (theC2Out != null && theC2Out.length != 0) theC2Out[0] = Double.longBitsToDouble(a[8]);
        if (theC3Out != null && theC3Out.length != 0) theC3Out[0] = Double.longBitsToDouble(a[9]);
        if (theDOut != null && theDOut.length != 0) theDOut[0] = Double.longBitsToDouble(a[10]);
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5217, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5218, a, box);
        return r;
    }
    public static double Radius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5219, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5220, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5221, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5222, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5223, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5224, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5225, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5226, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5227, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5228, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5229, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5230, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5231, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5232, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5233, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5234, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5235, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5236, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5237, a, box);
        return r;
    }
    }

    public static final class gp_Dir {
        private gp_Dir() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5238, a, box);
        return r;
    }
    public static long 构造_2(long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theV;
        long r = OcctGen.occtCall(5239, a, box);
        return r;
    }
    public static long 构造_3(long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theCoord;
        long r = OcctGen.occtCall(5240, a, box);
        return r;
    }
    public static long 构造_4(double theXv, double theYv, double theZv) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theXv);
        a[2] = Double.doubleToRawLongBits(theYv);
        a[3] = Double.doubleToRawLongBits(theZv);
        long r = OcctGen.occtCall(5241, a, box);
        return r;
    }
    public static void SetCoord(long self, int theIndex, double theXi) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theXi);
        OcctGen.occtCall(5242, a, box);
    }
    public static void SetCoord_2(long self, double theXv, double theYv, double theZv) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theXv);
        a[2] = Double.doubleToRawLongBits(theYv);
        a[3] = Double.doubleToRawLongBits(theZv);
        OcctGen.occtCall(5243, a, box);
    }
    public static void SetX(long self, double theX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        OcctGen.occtCall(5244, a, box);
    }
    public static void SetY(long self, double theY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(5245, a, box);
    }
    public static void SetZ(long self, double theZ) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theZ);
        OcctGen.occtCall(5246, a, box);
    }
    public static void SetXYZ(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5247, a, box);
    }
    public static double Coord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(5248, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord_2(long self, double[] theXvOut, double[] theYvOut, double[] theZvOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5249, a, box);
        if (theXvOut != null && theXvOut.length != 0) theXvOut[0] = Double.longBitsToDouble(a[1]);
        if (theYvOut != null && theYvOut.length != 0) theYvOut[0] = Double.longBitsToDouble(a[2]);
        if (theZvOut != null && theZvOut.length != 0) theZvOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5250, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5251, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Z(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5252, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XYZ(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5253, a, box);
        return r;
    }
    public static boolean IsEqual(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5254, a, box);
        return r != 0;
    }
    public static boolean IsNormal(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5255, a, box);
        return r != 0;
    }
    public static boolean IsOpposite(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5256, a, box);
        return r != 0;
    }
    public static boolean IsParallel(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5257, a, box);
        return r != 0;
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5258, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double AngleWithRef(long self, long theOther, long theVRef) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = theVRef;
        long r = OcctGen.occtCall(5259, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Cross(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        OcctGen.occtCall(5260, a, box);
    }
    public static long Crossed(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(5261, a, box);
        return r;
    }
    public static void CrossCross(long self, long theV1, long theV2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV1;
        a[2] = theV2;
        OcctGen.occtCall(5262, a, box);
    }
    public static long CrossCrossed(long self, long theV1, long theV2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV1;
        a[2] = theV2;
        long r = OcctGen.occtCall(5263, a, box);
        return r;
    }
    public static double Dot(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5264, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double DotCross(long self, long theV1, long theV2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV1;
        a[2] = theV2;
        long r = OcctGen.occtCall(5265, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5266, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5267, a, box);
        return r;
    }
    public static void Mirror(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5268, a, box);
    }
    public static long Mirrored(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5269, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5270, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5271, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5272, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5273, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5274, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5275, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5276, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5277, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5278, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(5279, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class gp_Dir2d {
        private gp_Dir2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5280, a, box);
        return r;
    }
    public static long 构造_2(long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theV;
        long r = OcctGen.occtCall(5281, a, box);
        return r;
    }
    public static long 构造_3(long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theCoord;
        long r = OcctGen.occtCall(5282, a, box);
        return r;
    }
    public static long 构造_4(double theXv, double theYv) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theXv);
        a[2] = Double.doubleToRawLongBits(theYv);
        long r = OcctGen.occtCall(5283, a, box);
        return r;
    }
    public static void SetCoord(long self, int theIndex, double theXi) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theXi);
        OcctGen.occtCall(5284, a, box);
    }
    public static void SetCoord_2(long self, double theXv, double theYv) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theXv);
        a[2] = Double.doubleToRawLongBits(theYv);
        OcctGen.occtCall(5285, a, box);
    }
    public static void SetX(long self, double theX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        OcctGen.occtCall(5286, a, box);
    }
    public static void SetY(long self, double theY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(5287, a, box);
    }
    public static void SetXY(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5288, a, box);
    }
    public static double Coord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(5289, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord_2(long self, double[] theXvOut, double[] theYvOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5290, a, box);
        if (theXvOut != null && theXvOut.length != 0) theXvOut[0] = Double.longBitsToDouble(a[1]);
        if (theYvOut != null && theYvOut.length != 0) theYvOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5291, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5292, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XY(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5293, a, box);
        return r;
    }
    public static boolean IsEqual(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5294, a, box);
        return r != 0;
    }
    public static boolean IsNormal(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5295, a, box);
        return r != 0;
    }
    public static boolean IsOpposite(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5296, a, box);
        return r != 0;
    }
    public static boolean IsParallel(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5297, a, box);
        return r != 0;
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5298, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Crossed(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(5299, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Dot(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5300, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5301, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5302, a, box);
        return r;
    }
    public static void Mirror(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5303, a, box);
    }
    public static long Mirrored(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5304, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5305, a, box);
    }
    public static long Mirrored_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        long r = OcctGen.occtCall(5306, a, box);
        return r;
    }
    public static void Rotate(long self, double Ang) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Ang);
        OcctGen.occtCall(5307, a, box);
    }
    public static long Rotated(long self, double theAng) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5308, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5309, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5310, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5311, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class gp_Elips {
        private gp_Elips() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5312, a, box);
        return r;
    }
    public static long 构造_2(long theA2, double theMajorRadius, double theMinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theA2;
        a[2] = Double.doubleToRawLongBits(theMajorRadius);
        a[3] = Double.doubleToRawLongBits(theMinorRadius);
        long r = OcctGen.occtCall(5313, a, box);
        return r;
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5314, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5315, a, box);
    }
    public static void SetMajorRadius(long self, double theMajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMajorRadius);
        OcctGen.occtCall(5316, a, box);
    }
    public static void SetMinorRadius(long self, double theMinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMinorRadius);
        OcctGen.occtCall(5317, a, box);
    }
    public static void SetPosition(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5318, a, box);
    }
    public static double Area(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5319, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5320, a, box);
        return r;
    }
    public static long Directrix1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5321, a, box);
        return r;
    }
    public static long Directrix2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5322, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5323, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5324, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5325, a, box);
        return r;
    }
    public static long Focus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5326, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5327, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5328, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5329, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5330, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5331, a, box);
        return r;
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5332, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5333, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5334, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5335, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5336, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5337, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5338, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5339, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5340, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5341, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5342, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5343, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5344, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5345, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5346, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5347, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5348, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5349, a, box);
        return r;
    }
    }

    public static final class gp_Elips2d {
        private gp_Elips2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5350, a, box);
        return r;
    }
    public static long 构造_2(
            long theMajorAxis, double theMajorRadius, double theMinorRadius, boolean theIsSense) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theMajorAxis;
        a[2] = Double.doubleToRawLongBits(theMajorRadius);
        a[3] = Double.doubleToRawLongBits(theMinorRadius);
        a[4] = theIsSense ? 1L : 0L;
        long r = OcctGen.occtCall(5351, a, box);
        return r;
    }
    public static long 构造_3(long theA, double theMajorRadius, double theMinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theA;
        a[2] = Double.doubleToRawLongBits(theMajorRadius);
        a[3] = Double.doubleToRawLongBits(theMinorRadius);
        long r = OcctGen.occtCall(5352, a, box);
        return r;
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5353, a, box);
    }
    public static void SetMajorRadius(long self, double theMajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMajorRadius);
        OcctGen.occtCall(5354, a, box);
    }
    public static void SetMinorRadius(long self, double theMinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMinorRadius);
        OcctGen.occtCall(5355, a, box);
    }
    public static void SetAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5356, a, box);
    }
    public static void SetXAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5357, a, box);
    }
    public static void SetYAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5358, a, box);
    }
    public static double Area(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5359, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coefficients(
            long self, double[] theAOut, double[] theBOut, double[] theCOut, double[] theDOut,
            double[] theEOut, double[] theFOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5360, a, box);
        if (theAOut != null && theAOut.length != 0) theAOut[0] = Double.longBitsToDouble(a[1]);
        if (theBOut != null && theBOut.length != 0) theBOut[0] = Double.longBitsToDouble(a[2]);
        if (theCOut != null && theCOut.length != 0) theCOut[0] = Double.longBitsToDouble(a[3]);
        if (theDOut != null && theDOut.length != 0) theDOut[0] = Double.longBitsToDouble(a[4]);
        if (theEOut != null && theEOut.length != 0) theEOut[0] = Double.longBitsToDouble(a[5]);
        if (theFOut != null && theFOut.length != 0) theFOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static long Directrix1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5361, a, box);
        return r;
    }
    public static long Directrix2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5362, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5363, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5364, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5365, a, box);
        return r;
    }
    public static long Focus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5366, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5367, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5368, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5369, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5370, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5371, a, box);
        return r;
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5372, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5373, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5374, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5375, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5376, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5377, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5378, a, box);
    }
    public static long Mirrored_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        long r = OcctGen.occtCall(5379, a, box);
        return r;
    }
    public static void Rotate(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5380, a, box);
    }
    public static long Rotated(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5381, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5382, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5383, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5384, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5385, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5386, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5387, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5388, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5389, a, box);
        return r;
    }
    }

    public static final class gp_GTrsf {
        private gp_GTrsf() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5390, a, box);
        return r;
    }
    public static long 构造_2(long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theT;
        long r = OcctGen.occtCall(5391, a, box);
        return r;
    }
    public static void SetAffinity(long self, long theA1, double theRatio) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theRatio);
        OcctGen.occtCall(5392, a, box);
    }
    public static void SetAffinity_2(long self, long theA2, double theRatio) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        a[2] = Double.doubleToRawLongBits(theRatio);
        OcctGen.occtCall(5393, a, box);
    }
    public static void SetValue(long self, int theRow, int theCol, double theValue) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        a[3] = Double.doubleToRawLongBits(theValue);
        OcctGen.occtCall(5394, a, box);
    }
    public static void SetTranslationPart(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5395, a, box);
    }
    public static void SetTrsf(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5396, a, box);
    }
    public static boolean IsNegative(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5397, a, box);
        return r != 0;
    }
    public static boolean IsSingular(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5398, a, box);
        return r != 0;
    }
    public static int Form(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5399, a, box);
        return (int) r;
    }
    public static void SetForm(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5400, a, box);
    }
    public static long TranslationPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5401, a, box);
        return r;
    }
    public static long VectorialPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5402, a, box);
        return r;
    }
    public static double Value(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(5403, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5404, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5405, a, box);
        return r;
    }
    public static long Multiplied(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5406, a, box);
        return r;
    }
    public static void Multiply(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5407, a, box);
    }
    public static void PreMultiply(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5408, a, box);
    }
    public static void Power(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        OcctGen.occtCall(5409, a, box);
    }
    public static long Powered(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        long r = OcctGen.occtCall(5410, a, box);
        return r;
    }
    public static void Transforms(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5411, a, box);
    }
    public static void Transforms_2(
            long self, double[] theXOut, double[] theYOut, double[] theZOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5412, a, box);
        if (theXOut != null && theXOut.length != 0) theXOut[0] = Double.longBitsToDouble(a[1]);
        if (theYOut != null && theYOut.length != 0) theYOut[0] = Double.longBitsToDouble(a[2]);
        if (theZOut != null && theZOut.length != 0) theZOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long Trsf(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5413, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5414, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class gp_GTrsf2d {
        private gp_GTrsf2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5415, a, box);
        return r;
    }
    public static long 构造_2(long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theT;
        long r = OcctGen.occtCall(5416, a, box);
        return r;
    }
    public static void SetAffinity(long self, long theA, double theRatio) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        a[2] = Double.doubleToRawLongBits(theRatio);
        OcctGen.occtCall(5417, a, box);
    }
    public static void SetValue(long self, int theRow, int theCol, double theValue) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        a[3] = Double.doubleToRawLongBits(theValue);
        OcctGen.occtCall(5418, a, box);
    }
    public static void SetTranslationPart(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5419, a, box);
    }
    public static void SetTrsf2d(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5420, a, box);
    }
    public static boolean IsNegative(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5421, a, box);
        return r != 0;
    }
    public static boolean IsSingular(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5422, a, box);
        return r != 0;
    }
    public static int Form(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5423, a, box);
        return (int) r;
    }
    public static long TranslationPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5424, a, box);
        return r;
    }
    public static long VectorialPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5425, a, box);
        return r;
    }
    public static double Value(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(5426, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5427, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5428, a, box);
        return r;
    }
    public static long Multiplied(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5429, a, box);
        return r;
    }
    public static void Multiply(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5430, a, box);
    }
    public static void PreMultiply(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5431, a, box);
    }
    public static void Power(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        OcctGen.occtCall(5432, a, box);
    }
    public static long Powered(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        long r = OcctGen.occtCall(5433, a, box);
        return r;
    }
    public static void Transforms(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5434, a, box);
    }
    public static long Transformed(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        long r = OcctGen.occtCall(5435, a, box);
        return r;
    }
    public static void Transforms_2(long self, double[] theXOut, double[] theYOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5436, a, box);
        if (theXOut != null && theXOut.length != 0) theXOut[0] = Double.longBitsToDouble(a[1]);
        if (theYOut != null && theYOut.length != 0) theYOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static long Trsf2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5437, a, box);
        return r;
    }
    }

    public static final class gp_Hypr {
        private gp_Hypr() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5438, a, box);
        return r;
    }
    public static long 构造_2(long theA2, double theMajorRadius, double theMinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theA2;
        a[2] = Double.doubleToRawLongBits(theMajorRadius);
        a[3] = Double.doubleToRawLongBits(theMinorRadius);
        long r = OcctGen.occtCall(5439, a, box);
        return r;
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5440, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5441, a, box);
    }
    public static void SetMajorRadius(long self, double theMajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMajorRadius);
        OcctGen.occtCall(5442, a, box);
    }
    public static void SetMinorRadius(long self, double theMinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMinorRadius);
        OcctGen.occtCall(5443, a, box);
    }
    public static void SetPosition(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5444, a, box);
    }
    public static long Asymptote1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5445, a, box);
        return r;
    }
    public static long Asymptote2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5446, a, box);
        return r;
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5447, a, box);
        return r;
    }
    public static long ConjugateBranch1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5448, a, box);
        return r;
    }
    public static long ConjugateBranch2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5449, a, box);
        return r;
    }
    public static long Directrix1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5450, a, box);
        return r;
    }
    public static long Directrix2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5451, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5452, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5453, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5454, a, box);
        return r;
    }
    public static long Focus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5455, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5456, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5457, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5458, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long OtherBranch(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5459, a, box);
        return r;
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5460, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5461, a, box);
        return r;
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5462, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5463, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5464, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5465, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5466, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5467, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5468, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5469, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5470, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5471, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5472, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5473, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5474, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5475, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5476, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5477, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5478, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5479, a, box);
        return r;
    }
    }

    public static final class gp_Hypr2d {
        private gp_Hypr2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5480, a, box);
        return r;
    }
    public static long 构造_2(
            long theMajorAxis, double theMajorRadius, double theMinorRadius, boolean theIsSense) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theMajorAxis;
        a[2] = Double.doubleToRawLongBits(theMajorRadius);
        a[3] = Double.doubleToRawLongBits(theMinorRadius);
        a[4] = theIsSense ? 1L : 0L;
        long r = OcctGen.occtCall(5481, a, box);
        return r;
    }
    public static long 构造_3(long theA, double theMajorRadius, double theMinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theA;
        a[2] = Double.doubleToRawLongBits(theMajorRadius);
        a[3] = Double.doubleToRawLongBits(theMinorRadius);
        long r = OcctGen.occtCall(5482, a, box);
        return r;
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5483, a, box);
    }
    public static void SetMajorRadius(long self, double theMajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMajorRadius);
        OcctGen.occtCall(5484, a, box);
    }
    public static void SetMinorRadius(long self, double theMinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMinorRadius);
        OcctGen.occtCall(5485, a, box);
    }
    public static void SetAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5486, a, box);
    }
    public static void SetXAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5487, a, box);
    }
    public static void SetYAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5488, a, box);
    }
    public static long Asymptote1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5489, a, box);
        return r;
    }
    public static long Asymptote2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5490, a, box);
        return r;
    }
    public static void Coefficients(
            long self, double[] theAOut, double[] theBOut, double[] theCOut, double[] theDOut,
            double[] theEOut, double[] theFOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5491, a, box);
        if (theAOut != null && theAOut.length != 0) theAOut[0] = Double.longBitsToDouble(a[1]);
        if (theBOut != null && theBOut.length != 0) theBOut[0] = Double.longBitsToDouble(a[2]);
        if (theCOut != null && theCOut.length != 0) theCOut[0] = Double.longBitsToDouble(a[3]);
        if (theDOut != null && theDOut.length != 0) theDOut[0] = Double.longBitsToDouble(a[4]);
        if (theEOut != null && theEOut.length != 0) theEOut[0] = Double.longBitsToDouble(a[5]);
        if (theFOut != null && theFOut.length != 0) theFOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static long Directrix1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5492, a, box);
        return r;
    }
    public static long Directrix2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5493, a, box);
        return r;
    }
    public static double Eccentricity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5494, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5495, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5496, a, box);
        return r;
    }
    public static long Focus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5497, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5498, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5499, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5500, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5501, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5502, a, box);
        return r;
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5503, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5504, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5505, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5506, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5507, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5508, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5509, a, box);
    }
    public static long Mirrored_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        long r = OcctGen.occtCall(5510, a, box);
        return r;
    }
    public static void Rotate(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5511, a, box);
    }
    public static long Rotated(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5512, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5513, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5514, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5515, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5516, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5517, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5518, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5519, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5520, a, box);
        return r;
    }
    }

    public static final class gp_Lin {
        private gp_Lin() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5521, a, box);
        return r;
    }
    public static long 构造_2(long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theA1;
        long r = OcctGen.occtCall(5522, a, box);
        return r;
    }
    public static long 构造_3(long theP, long theV) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theP;
        a[2] = theV;
        long r = OcctGen.occtCall(5523, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5524, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5525, a, box);
        return r;
    }
    public static void SetDirection(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5526, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5527, a, box);
    }
    public static void SetPosition(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5528, a, box);
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5529, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5530, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5531, a, box);
        return r;
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5532, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean Contains(long self, long theP, double theLinearTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        long r = OcctGen.occtCall(5533, a, box);
        return r != 0;
    }
    public static double Distance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5534, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Distance_2(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5535, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5536, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance_2(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5537, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Normal(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5538, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5539, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5540, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5541, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5542, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5543, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5544, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5545, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5546, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5547, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5548, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5549, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5550, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5551, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5552, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5553, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5554, a, box);
        return r;
    }
    }

    public static final class gp_Lin2d {
        private gp_Lin2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5555, a, box);
        return r;
    }
    public static long 构造_2(long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theA;
        long r = OcctGen.occtCall(5556, a, box);
        return r;
    }
    public static long 构造_3(long theP, long theV) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theP;
        a[2] = theV;
        long r = OcctGen.occtCall(5557, a, box);
        return r;
    }
    public static long 构造_4(double theA, double theB, double theC) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theA);
        a[2] = Double.doubleToRawLongBits(theB);
        a[3] = Double.doubleToRawLongBits(theC);
        long r = OcctGen.occtCall(5558, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5559, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5560, a, box);
        return r;
    }
    public static void SetDirection(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5561, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5562, a, box);
    }
    public static void SetPosition(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5563, a, box);
    }
    public static void Coefficients(
            long self, double[] theAOut, double[] theBOut, double[] theCOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5564, a, box);
        if (theAOut != null && theAOut.length != 0) theAOut[0] = Double.longBitsToDouble(a[1]);
        if (theBOut != null && theBOut.length != 0) theBOut[0] = Double.longBitsToDouble(a[2]);
        if (theCOut != null && theCOut.length != 0) theCOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long Direction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5565, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5566, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5567, a, box);
        return r;
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5568, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean Contains(long self, long theP, double theLinearTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        long r = OcctGen.occtCall(5569, a, box);
        return r != 0;
    }
    public static double Distance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5570, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Distance_2(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5571, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5572, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance_2(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5573, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Normal(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5574, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5575, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5576, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5577, a, box);
    }
    public static long Mirrored_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        long r = OcctGen.occtCall(5578, a, box);
        return r;
    }
    public static void Rotate(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5579, a, box);
    }
    public static long Rotated(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5580, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5581, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5582, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5583, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5584, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5585, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5586, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5587, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5588, a, box);
        return r;
    }
    }

    public static final class gp_Mat {
        private gp_Mat() {}

    public static long 构造(
            double theA11, double theA12, double theA13, double theA21, double theA22,
            double theA23, double theA31, double theA32, double theA33) {
        long[] a = new long[10];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theA11);
        a[2] = Double.doubleToRawLongBits(theA12);
        a[3] = Double.doubleToRawLongBits(theA13);
        a[4] = Double.doubleToRawLongBits(theA21);
        a[5] = Double.doubleToRawLongBits(theA22);
        a[6] = Double.doubleToRawLongBits(theA23);
        a[7] = Double.doubleToRawLongBits(theA31);
        a[8] = Double.doubleToRawLongBits(theA32);
        a[9] = Double.doubleToRawLongBits(theA33);
        long r = OcctGen.occtCall(5589, a, box);
        return r;
    }
    public static long 构造_2(long theCol1, long theCol2, long theCol3) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theCol1;
        a[2] = theCol2;
        a[3] = theCol3;
        long r = OcctGen.occtCall(5590, a, box);
        return r;
    }
    public static void SetCol(long self, int theCol, long theValue) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theCol;
        a[2] = theValue;
        OcctGen.occtCall(5591, a, box);
    }
    public static void SetCols(long self, long theCol1, long theCol2, long theCol3) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theCol1;
        a[2] = theCol2;
        a[3] = theCol3;
        OcctGen.occtCall(5592, a, box);
    }
    public static void SetCross(long self, long theRef) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRef;
        OcctGen.occtCall(5593, a, box);
    }
    public static void SetDiagonal(long self, double theX1, double theX2, double theX3) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX1);
        a[2] = Double.doubleToRawLongBits(theX2);
        a[3] = Double.doubleToRawLongBits(theX3);
        OcctGen.occtCall(5594, a, box);
    }
    public static void SetDot(long self, long theRef) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRef;
        OcctGen.occtCall(5595, a, box);
    }
    public static void SetRotation(long self, long theAxis, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theAxis;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5596, a, box);
    }
    public static void SetRow(long self, int theRow, long theValue) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theValue;
        OcctGen.occtCall(5597, a, box);
    }
    public static void SetRows(long self, long theRow1, long theRow2, long theRow3) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow1;
        a[2] = theRow2;
        a[3] = theRow3;
        OcctGen.occtCall(5598, a, box);
    }
    public static void SetValue(long self, int theRow, int theCol, double theValue) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        a[3] = Double.doubleToRawLongBits(theValue);
        OcctGen.occtCall(5599, a, box);
    }
    public static long Column(long self, int theCol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCol;
        long r = OcctGen.occtCall(5600, a, box);
        return r;
    }
    public static double Determinant(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5601, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Diagonal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5602, a, box);
        return r;
    }
    public static long Row(long self, int theRow) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        long r = OcctGen.occtCall(5603, a, box);
        return r;
    }
    public static double Value(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(5604, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ChangeValue(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(5605, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsSingular(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5606, a, box);
        return r != 0;
    }
    public static void Add(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5607, a, box);
    }
    public static long Added(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5608, a, box);
        return r;
    }
    public static void Divide(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(5609, a, box);
    }
    public static long Divided(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(5610, a, box);
        return r;
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5611, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5612, a, box);
        return r;
    }
    public static long Multiplied(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5613, a, box);
        return r;
    }
    public static void Multiply(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5614, a, box);
    }
    public static void PreMultiply(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5615, a, box);
    }
    public static long Multiplied_2(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(5616, a, box);
        return r;
    }
    public static void Multiply_2(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(5617, a, box);
    }
    public static void Power(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(5618, a, box);
    }
    public static long Powered(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        long r = OcctGen.occtCall(5619, a, box);
        return r;
    }
    public static void Subtract(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5620, a, box);
    }
    public static long Subtracted(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5621, a, box);
        return r;
    }
    public static void Transpose(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5622, a, box);
    }
    public static long Transposed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5623, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5624, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class gp_Mat2d {
        private gp_Mat2d() {}

    public static long 构造(long theCol1, long theCol2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theCol1;
        a[2] = theCol2;
        long r = OcctGen.occtCall(5625, a, box);
        return r;
    }
    public static void SetCol(long self, int theCol, long theValue) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theCol;
        a[2] = theValue;
        OcctGen.occtCall(5626, a, box);
    }
    public static void SetCols(long self, long theCol1, long theCol2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theCol1;
        a[2] = theCol2;
        OcctGen.occtCall(5627, a, box);
    }
    public static void SetDiagonal(long self, double theX1, double theX2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX1);
        a[2] = Double.doubleToRawLongBits(theX2);
        OcctGen.occtCall(5628, a, box);
    }
    public static void SetRotation(long self, double theAng) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5629, a, box);
    }
    public static void SetRow(long self, int theRow, long theValue) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theValue;
        OcctGen.occtCall(5630, a, box);
    }
    public static void SetRows(long self, long theRow1, long theRow2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow1;
        a[2] = theRow2;
        OcctGen.occtCall(5631, a, box);
    }
    public static void SetValue(long self, int theRow, int theCol, double theValue) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        a[3] = Double.doubleToRawLongBits(theValue);
        OcctGen.occtCall(5632, a, box);
    }
    public static long Column(long self, int theCol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCol;
        long r = OcctGen.occtCall(5633, a, box);
        return r;
    }
    public static double Determinant(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5634, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Diagonal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5635, a, box);
        return r;
    }
    public static long Row(long self, int theRow) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        long r = OcctGen.occtCall(5636, a, box);
        return r;
    }
    public static double Value(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(5637, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ChangeValue(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(5638, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsSingular(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5639, a, box);
        return r != 0;
    }
    public static void Add(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        OcctGen.occtCall(5640, a, box);
    }
    public static long Added(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5641, a, box);
        return r;
    }
    public static void Divide(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(5642, a, box);
    }
    public static long Divided(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(5643, a, box);
        return r;
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5644, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5645, a, box);
        return r;
    }
    public static long Multiplied(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5646, a, box);
        return r;
    }
    public static void Multiply(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5647, a, box);
    }
    public static void PreMultiply(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5648, a, box);
    }
    public static long Multiplied_2(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(5649, a, box);
        return r;
    }
    public static void Multiply_2(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(5650, a, box);
    }
    public static void Power(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        OcctGen.occtCall(5651, a, box);
    }
    public static long Powered(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        long r = OcctGen.occtCall(5652, a, box);
        return r;
    }
    public static void Subtract(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5653, a, box);
    }
    public static long Subtracted(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5654, a, box);
        return r;
    }
    public static void Transpose(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5655, a, box);
    }
    public static long Transposed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5656, a, box);
        return r;
    }
    }

    public static final class gp_Parab {
        private gp_Parab() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5657, a, box);
        return r;
    }
    public static long 构造_2(long theD, long theF) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theD;
        a[2] = theF;
        long r = OcctGen.occtCall(5658, a, box);
        return r;
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5659, a, box);
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5660, a, box);
    }
    public static void SetPosition(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5661, a, box);
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5662, a, box);
        return r;
    }
    public static long Directrix(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5663, a, box);
        return r;
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5664, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5665, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5666, a, box);
        return r;
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5667, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5668, a, box);
        return r;
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5669, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5670, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5671, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5672, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5673, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5674, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5675, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5676, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5677, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5678, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5679, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5680, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5681, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5682, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5683, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5684, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5685, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5686, a, box);
        return r;
    }
    }

    public static final class gp_Parab2d {
        private gp_Parab2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5687, a, box);
        return r;
    }
    public static long 构造_2(long theDirectrix, long theFocus, boolean theSense) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theDirectrix;
        a[2] = theFocus;
        a[3] = theSense ? 1L : 0L;
        long r = OcctGen.occtCall(5688, a, box);
        return r;
    }
    public static void SetLocation(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5689, a, box);
    }
    public static void SetMirrorAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5690, a, box);
    }
    public static void SetAxis(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5691, a, box);
    }
    public static void Coefficients(
            long self, double[] theAOut, double[] theBOut, double[] theCOut, double[] theDOut,
            double[] theEOut, double[] theFOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5692, a, box);
        if (theAOut != null && theAOut.length != 0) theAOut[0] = Double.longBitsToDouble(a[1]);
        if (theBOut != null && theBOut.length != 0) theBOut[0] = Double.longBitsToDouble(a[2]);
        if (theCOut != null && theCOut.length != 0) theCOut[0] = Double.longBitsToDouble(a[3]);
        if (theDOut != null && theDOut.length != 0) theDOut[0] = Double.longBitsToDouble(a[4]);
        if (theEOut != null && theEOut.length != 0) theEOut[0] = Double.longBitsToDouble(a[5]);
        if (theFOut != null && theFOut.length != 0) theFOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static long Directrix(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5693, a, box);
        return r;
    }
    public static double Focal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5694, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Focus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5695, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5696, a, box);
        return r;
    }
    public static long MirrorAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5697, a, box);
        return r;
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5698, a, box);
        return r;
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5699, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5700, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5701, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5702, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5703, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5704, a, box);
    }
    public static long Mirrored_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        long r = OcctGen.occtCall(5705, a, box);
        return r;
    }
    public static void Rotate(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5706, a, box);
    }
    public static long Rotated(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5707, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5708, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5709, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5710, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5711, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5712, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5713, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5714, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5715, a, box);
        return r;
    }
    }

    public static final class gp_Pln {
        private gp_Pln() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5716, a, box);
        return r;
    }
    public static long 构造_2(long theA3) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theA3;
        long r = OcctGen.occtCall(5717, a, box);
        return r;
    }
    public static long 构造_3(long theP, long theV) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theP;
        a[2] = theV;
        long r = OcctGen.occtCall(5718, a, box);
        return r;
    }
    public static long 构造_4(double theA, double theB, double theC, double theD) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theA);
        a[2] = Double.doubleToRawLongBits(theB);
        a[3] = Double.doubleToRawLongBits(theC);
        a[4] = Double.doubleToRawLongBits(theD);
        long r = OcctGen.occtCall(5719, a, box);
        return r;
    }
    public static void Coefficients(
            long self, double[] theAOut, double[] theBOut, double[] theCOut, double[] theDOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5720, a, box);
        if (theAOut != null && theAOut.length != 0) theAOut[0] = Double.longBitsToDouble(a[1]);
        if (theBOut != null && theBOut.length != 0) theBOut[0] = Double.longBitsToDouble(a[2]);
        if (theCOut != null && theCOut.length != 0) theCOut[0] = Double.longBitsToDouble(a[3]);
        if (theDOut != null && theDOut.length != 0) theDOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5721, a, box);
    }
    public static void SetLocation(long self, long theLoc) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLoc;
        OcctGen.occtCall(5722, a, box);
    }
    public static void SetPosition(long self, long theA3) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA3;
        OcctGen.occtCall(5723, a, box);
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5724, a, box);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5725, a, box);
    }
    public static boolean Direct(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5726, a, box);
        return r != 0;
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5727, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5728, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5729, a, box);
        return r;
    }
    public static double Distance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5730, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Distance_2(long self, long theL) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theL;
        long r = OcctGen.occtCall(5731, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Distance_3(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5732, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5733, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance_2(long self, long theL) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theL;
        long r = OcctGen.occtCall(5734, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance_3(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5735, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5736, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5737, a, box);
        return r;
    }
    public static boolean Contains(long self, long theP, double theLinearTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        long r = OcctGen.occtCall(5738, a, box);
        return r != 0;
    }
    public static boolean Contains_2(
            long self, long theL, double theLinearTolerance, double theAngularTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theL;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        a[3] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(5739, a, box);
        return r != 0;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5740, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5741, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5742, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5743, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5744, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5745, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5746, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5747, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5748, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5749, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5750, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5751, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5752, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5753, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5754, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5755, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5756, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class gp_Pnt {
        private gp_Pnt() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5757, a, box);
        return r;
    }
    public static long 构造_2(long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theCoord;
        long r = OcctGen.occtCall(5758, a, box);
        return r;
    }
    public static long 构造_3(double theXp, double theYp, double theZp) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theXp);
        a[2] = Double.doubleToRawLongBits(theYp);
        a[3] = Double.doubleToRawLongBits(theZp);
        long r = OcctGen.occtCall(5759, a, box);
        return r;
    }
    public static void SetCoord(long self, int theIndex, double theXi) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theXi);
        OcctGen.occtCall(5760, a, box);
    }
    public static void SetCoord_2(long self, double theXp, double theYp, double theZp) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theXp);
        a[2] = Double.doubleToRawLongBits(theYp);
        a[3] = Double.doubleToRawLongBits(theZp);
        OcctGen.occtCall(5761, a, box);
    }
    public static void SetX(long self, double theX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        OcctGen.occtCall(5762, a, box);
    }
    public static void SetY(long self, double theY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(5763, a, box);
    }
    public static void SetZ(long self, double theZ) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theZ);
        OcctGen.occtCall(5764, a, box);
    }
    public static void SetXYZ(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5765, a, box);
    }
    public static double Coord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(5766, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord_2(long self, double[] theXpOut, double[] theYpOut, double[] theZpOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5767, a, box);
        if (theXpOut != null && theXpOut.length != 0) theXpOut[0] = Double.longBitsToDouble(a[1]);
        if (theYpOut != null && theYpOut.length != 0) theYpOut[0] = Double.longBitsToDouble(a[2]);
        if (theZpOut != null && theZpOut.length != 0) theZpOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5768, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5769, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Z(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5770, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XYZ(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5771, a, box);
        return r;
    }
    public static long Coord_3(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5772, a, box);
        return r;
    }
    public static long ChangeCoord(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5773, a, box);
        return r;
    }
    public static void BaryCenter(long self, double theAlpha, long theP, double theBeta) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theAlpha);
        a[2] = theP;
        a[3] = Double.doubleToRawLongBits(theBeta);
        OcctGen.occtCall(5774, a, box);
    }
    public static boolean IsEqual(long self, long theOther, double theLinearTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        long r = OcctGen.occtCall(5775, a, box);
        return r != 0;
    }
    public static double Distance(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5776, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5777, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5778, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5779, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5780, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5781, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5782, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5783, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5784, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5785, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5786, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5787, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5788, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5789, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5790, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5791, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5792, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5793, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5794, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(5795, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class gp_Pnt2d {
        private gp_Pnt2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5796, a, box);
        return r;
    }
    public static long 构造_2(long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theCoord;
        long r = OcctGen.occtCall(5797, a, box);
        return r;
    }
    public static long 构造_3(double theXp, double theYp) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theXp);
        a[2] = Double.doubleToRawLongBits(theYp);
        long r = OcctGen.occtCall(5798, a, box);
        return r;
    }
    public static void SetCoord(long self, int theIndex, double theXi) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theXi);
        OcctGen.occtCall(5799, a, box);
    }
    public static void SetCoord_2(long self, double theXp, double theYp) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theXp);
        a[2] = Double.doubleToRawLongBits(theYp);
        OcctGen.occtCall(5800, a, box);
    }
    public static void SetX(long self, double theX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        OcctGen.occtCall(5801, a, box);
    }
    public static void SetY(long self, double theY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(5802, a, box);
    }
    public static void SetXY(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5803, a, box);
    }
    public static double Coord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(5804, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord_2(long self, double[] theXpOut, double[] theYpOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5805, a, box);
        if (theXpOut != null && theXpOut.length != 0) theXpOut[0] = Double.longBitsToDouble(a[1]);
        if (theYpOut != null && theYpOut.length != 0) theYpOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5806, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5807, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XY(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5808, a, box);
        return r;
    }
    public static long Coord_3(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5809, a, box);
        return r;
    }
    public static long ChangeCoord(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5810, a, box);
        return r;
    }
    public static boolean IsEqual(long self, long theOther, double theLinearTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        long r = OcctGen.occtCall(5811, a, box);
        return r != 0;
    }
    public static double Distance(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5812, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5813, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5814, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5815, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5816, a, box);
    }
    public static long Mirrored_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        long r = OcctGen.occtCall(5817, a, box);
        return r;
    }
    public static void Rotate(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5818, a, box);
    }
    public static long Rotated(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5819, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5820, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5821, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5822, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5823, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5824, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5825, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5826, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5827, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5828, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class gp_Quaternion {
        private gp_Quaternion() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5829, a, box);
        return r;
    }
    public static long 构造_2(double theX, double theY, double theZ, double theW) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theX);
        a[2] = Double.doubleToRawLongBits(theY);
        a[3] = Double.doubleToRawLongBits(theZ);
        a[4] = Double.doubleToRawLongBits(theW);
        long r = OcctGen.occtCall(5830, a, box);
        return r;
    }
    public static long 构造_3(long theVecFrom, long theVecTo) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theVecFrom;
        a[2] = theVecTo;
        long r = OcctGen.occtCall(5831, a, box);
        return r;
    }
    public static long 构造_4(long theVecFrom, long theVecTo, long theHelpCrossVec) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theVecFrom;
        a[2] = theVecTo;
        a[3] = theHelpCrossVec;
        long r = OcctGen.occtCall(5832, a, box);
        return r;
    }
    public static long 构造_5(long theAxis, double theAngle) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theAxis;
        a[2] = Double.doubleToRawLongBits(theAngle);
        long r = OcctGen.occtCall(5833, a, box);
        return r;
    }
    public static long 构造_6(long theMat) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theMat;
        long r = OcctGen.occtCall(5834, a, box);
        return r;
    }
    public static boolean IsEqual(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5835, a, box);
        return r != 0;
    }
    public static void SetRotation(long self, long theVecFrom, long theVecTo) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theVecFrom;
        a[2] = theVecTo;
        OcctGen.occtCall(5836, a, box);
    }
    public static void SetRotation_2(
            long self, long theVecFrom, long theVecTo, long theHelpCrossVec) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theVecFrom;
        a[2] = theVecTo;
        a[3] = theHelpCrossVec;
        OcctGen.occtCall(5837, a, box);
    }
    public static void SetVectorAndAngle(long self, long theAxis, double theAngle) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theAxis;
        a[2] = Double.doubleToRawLongBits(theAngle);
        OcctGen.occtCall(5838, a, box);
    }
    public static void GetVectorAndAngle(long self, long theAxis, double[] theAngleOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theAxis;
        OcctGen.occtCall(5839, a, box);
        if (theAngleOut != null && theAngleOut.length != 0) theAngleOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static void SetMatrix(long self, long theMat) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theMat;
        OcctGen.occtCall(5840, a, box);
    }
    public static long GetMatrix(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5841, a, box);
        return r;
    }
    public static void SetEulerAngles(
            long self, int theOrder, double theAlpha, double theBeta, double theGamma) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = theOrder;
        a[2] = Double.doubleToRawLongBits(theAlpha);
        a[3] = Double.doubleToRawLongBits(theBeta);
        a[4] = Double.doubleToRawLongBits(theGamma);
        OcctGen.occtCall(5842, a, box);
    }
    public static void GetEulerAngles(
            long self, int theOrder, double[] theAlphaOut, double[] theBetaOut,
            double[] theGammaOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = theOrder;
        OcctGen.occtCall(5843, a, box);
        if (theAlphaOut != null && theAlphaOut.length != 0) theAlphaOut[0] = Double.longBitsToDouble(a[2]);
        if (theBetaOut != null && theBetaOut.length != 0) theBetaOut[0] = Double.longBitsToDouble(a[3]);
        if (theGammaOut != null && theGammaOut.length != 0) theGammaOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static void Set(long self, double theX, double theY, double theZ, double theW) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        a[2] = Double.doubleToRawLongBits(theY);
        a[3] = Double.doubleToRawLongBits(theZ);
        a[4] = Double.doubleToRawLongBits(theW);
        OcctGen.occtCall(5844, a, box);
    }
    public static void Set_2(long self, long theQuaternion) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theQuaternion;
        OcctGen.occtCall(5845, a, box);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5846, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5847, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Z(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5848, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double W(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5849, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5850, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5851, a, box);
        return r;
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5852, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5853, a, box);
        return r;
    }
    public static double SquareNorm(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5854, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Norm(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5855, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Scale(long self, double theScale) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScale);
        OcctGen.occtCall(5856, a, box);
    }
    public static long Scaled(long self, double theScale) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScale);
        long r = OcctGen.occtCall(5857, a, box);
        return r;
    }
    public static void StabilizeLength(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5858, a, box);
    }
    public static void Normalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5859, a, box);
    }
    public static long Normalized(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5860, a, box);
        return r;
    }
    public static long Negated(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5861, a, box);
        return r;
    }
    public static long Added(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5862, a, box);
        return r;
    }
    public static long Subtracted(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5863, a, box);
        return r;
    }
    public static long Multiplied(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5864, a, box);
        return r;
    }
    public static void Add(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5865, a, box);
    }
    public static void Subtract(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5866, a, box);
    }
    public static void Multiply(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(5867, a, box);
    }
    public static double Dot(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(5868, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double GetRotationAngle(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5869, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Multiply_2(long self, long theVec) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theVec;
        long r = OcctGen.occtCall(5870, a, box);
        return r;
    }
    }

    public static final class gp_QuaternionNLerp {
        private gp_QuaternionNLerp() {}

    public static long Interpolate(long theQStart, long theQEnd, double theT) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theQStart;
        a[2] = theQEnd;
        a[3] = Double.doubleToRawLongBits(theT);
        long r = OcctGen.occtCall(5871, a, box);
        return r;
    }
    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5872, a, box);
        return r;
    }
    public static long 构造_2(long theQStart, long theQEnd) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theQStart;
        a[2] = theQEnd;
        long r = OcctGen.occtCall(5873, a, box);
        return r;
    }
    public static void Init(long self, long theQStart, long theQEnd) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theQStart;
        a[2] = theQEnd;
        OcctGen.occtCall(5874, a, box);
    }
    public static void InitFromUnit(long self, long theQStart, long theQEnd) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theQStart;
        a[2] = theQEnd;
        OcctGen.occtCall(5875, a, box);
    }
    public static void Interpolate_2(long self, double theT, long theResultQ) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theT);
        a[2] = theResultQ;
        OcctGen.occtCall(5876, a, box);
    }
    }

    public static final class gp_QuaternionSLerp {
        private gp_QuaternionSLerp() {}

    public static long Interpolate(long theQStart, long theQEnd, double theT) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theQStart;
        a[2] = theQEnd;
        a[3] = Double.doubleToRawLongBits(theT);
        long r = OcctGen.occtCall(5877, a, box);
        return r;
    }
    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5878, a, box);
        return r;
    }
    public static long 构造_2(long theQStart, long theQEnd) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theQStart;
        a[2] = theQEnd;
        long r = OcctGen.occtCall(5879, a, box);
        return r;
    }
    public static void Init(long self, long theQStart, long theQEnd) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theQStart;
        a[2] = theQEnd;
        OcctGen.occtCall(5880, a, box);
    }
    public static void Interpolate_2(long self, double theT, long theResultQ) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theT);
        a[2] = theResultQ;
        OcctGen.occtCall(5881, a, box);
    }
    }

    public static final class gp_Sphere {
        private gp_Sphere() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5882, a, box);
        return r;
    }
    public static void SetLocation(long self, long theLoc) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLoc;
        OcctGen.occtCall(5883, a, box);
    }
    public static void SetPosition(long self, long theA3) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA3;
        OcctGen.occtCall(5884, a, box);
    }
    public static double Area(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5885, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coefficients(
            long self, double[] theA1Out, double[] theA2Out, double[] theA3Out, double[] theB1Out,
            double[] theB2Out, double[] theB3Out, double[] theC1Out, double[] theC2Out,
            double[] theC3Out, double[] theDOut) {
        long[] a = new long[11];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5886, a, box);
        if (theA1Out != null && theA1Out.length != 0) theA1Out[0] = Double.longBitsToDouble(a[1]);
        if (theA2Out != null && theA2Out.length != 0) theA2Out[0] = Double.longBitsToDouble(a[2]);
        if (theA3Out != null && theA3Out.length != 0) theA3Out[0] = Double.longBitsToDouble(a[3]);
        if (theB1Out != null && theB1Out.length != 0) theB1Out[0] = Double.longBitsToDouble(a[4]);
        if (theB2Out != null && theB2Out.length != 0) theB2Out[0] = Double.longBitsToDouble(a[5]);
        if (theB3Out != null && theB3Out.length != 0) theB3Out[0] = Double.longBitsToDouble(a[6]);
        if (theC1Out != null && theC1Out.length != 0) theC1Out[0] = Double.longBitsToDouble(a[7]);
        if (theC2Out != null && theC2Out.length != 0) theC2Out[0] = Double.longBitsToDouble(a[8]);
        if (theC3Out != null && theC3Out.length != 0) theC3Out[0] = Double.longBitsToDouble(a[9]);
        if (theDOut != null && theDOut.length != 0) theDOut[0] = Double.longBitsToDouble(a[10]);
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5887, a, box);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5888, a, box);
    }
    public static boolean Direct(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5889, a, box);
        return r != 0;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5890, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5891, a, box);
        return r;
    }
    public static double Radius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5892, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Volume(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5893, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5894, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5895, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5896, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5897, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5898, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5899, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5900, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5901, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5902, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5903, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5904, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5905, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5906, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5907, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5908, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5909, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5910, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5911, a, box);
        return r;
    }
    }

    public static final class gp_Torus {
        private gp_Torus() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5912, a, box);
        return r;
    }
    public static long 构造_2(long theA3, double theMajorRadius, double theMinorRadius) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theA3;
        a[2] = Double.doubleToRawLongBits(theMajorRadius);
        a[3] = Double.doubleToRawLongBits(theMinorRadius);
        long r = OcctGen.occtCall(5913, a, box);
        return r;
    }
    public static void SetAxis(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5914, a, box);
    }
    public static void SetLocation(long self, long theLoc) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLoc;
        OcctGen.occtCall(5915, a, box);
    }
    public static void SetMajorRadius(long self, double theMajorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMajorRadius);
        OcctGen.occtCall(5916, a, box);
    }
    public static void SetMinorRadius(long self, double theMinorRadius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMinorRadius);
        OcctGen.occtCall(5917, a, box);
    }
    public static void SetPosition(long self, long theA3) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA3;
        OcctGen.occtCall(5918, a, box);
    }
    public static double Area(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5919, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void UReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5920, a, box);
    }
    public static void VReverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5921, a, box);
    }
    public static boolean Direct(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5922, a, box);
        return r != 0;
    }
    public static long Axis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5923, a, box);
        return r;
    }
    public static long Location(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5924, a, box);
        return r;
    }
    public static long Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5925, a, box);
        return r;
    }
    public static double MajorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5926, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinorRadius(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5927, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Volume(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5928, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5929, a, box);
        return r;
    }
    public static long YAxis(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5930, a, box);
        return r;
    }
    public static void Mirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5931, a, box);
    }
    public static long Mirrored(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        long r = OcctGen.occtCall(5932, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5933, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(5934, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5935, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(5936, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5937, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(5938, a, box);
        return r;
    }
    public static void Scale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5939, a, box);
    }
    public static long Scaled(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(5940, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5941, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5942, a, box);
        return r;
    }
    public static void Translate(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5943, a, box);
    }
    public static long Translated(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(5944, a, box);
        return r;
    }
    public static void Translate_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5945, a, box);
    }
    public static long Translated_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(5946, a, box);
        return r;
    }
    }

    public static final class gp_Trsf {
        private gp_Trsf() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5947, a, box);
        return r;
    }
    public static long 构造_2(long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theT;
        long r = OcctGen.occtCall(5948, a, box);
        return r;
    }
    public static void SetMirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5949, a, box);
    }
    public static void SetMirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(5950, a, box);
    }
    public static void SetMirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(5951, a, box);
    }
    public static void SetRotation(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5952, a, box);
    }
    public static void SetRotation_2(long self, long theR) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theR;
        OcctGen.occtCall(5953, a, box);
    }
    public static void SetRotationPart(long self, long theR) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theR;
        OcctGen.occtCall(5954, a, box);
    }
    public static void SetScale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5955, a, box);
    }
    public static void SetDisplacement(long self, long theFromSystem1, long theToSystem2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theFromSystem1;
        a[2] = theToSystem2;
        OcctGen.occtCall(5956, a, box);
    }
    public static void SetTransformation(long self, long theFromSystem1, long theToSystem2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theFromSystem1;
        a[2] = theToSystem2;
        OcctGen.occtCall(5957, a, box);
    }
    public static void SetTransformation_2(long self, long theToSystem) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theToSystem;
        OcctGen.occtCall(5958, a, box);
    }
    public static void SetTransformation_3(long self, long R, long theT) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = R;
        a[2] = theT;
        OcctGen.occtCall(5959, a, box);
    }
    public static void SetTranslation(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5960, a, box);
    }
    public static void SetTranslation_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5961, a, box);
    }
    public static void SetTranslationPart(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5962, a, box);
    }
    public static void SetScaleFactor(long self, double theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5963, a, box);
    }
    public static void SetForm(long self, int theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5964, a, box);
    }
    public static void SetValues(
            long self, double a11, double a12, double a13, double a14, double a21, double a22,
            double a23, double a24, double a31, double a32, double a33, double a34) {
        long[] a = new long[13];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(a11);
        a[2] = Double.doubleToRawLongBits(a12);
        a[3] = Double.doubleToRawLongBits(a13);
        a[4] = Double.doubleToRawLongBits(a14);
        a[5] = Double.doubleToRawLongBits(a21);
        a[6] = Double.doubleToRawLongBits(a22);
        a[7] = Double.doubleToRawLongBits(a23);
        a[8] = Double.doubleToRawLongBits(a24);
        a[9] = Double.doubleToRawLongBits(a31);
        a[10] = Double.doubleToRawLongBits(a32);
        a[11] = Double.doubleToRawLongBits(a33);
        a[12] = Double.doubleToRawLongBits(a34);
        OcctGen.occtCall(5965, a, box);
    }
    public static boolean IsNegative(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5966, a, box);
        return r != 0;
    }
    public static int Form(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5967, a, box);
        return (int) r;
    }
    public static double ScaleFactor(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5968, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long TranslationPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5969, a, box);
        return r;
    }
    public static boolean GetRotation(long self, long theAxis, double[] theAngleOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theAxis;
        long r = OcctGen.occtCall(5970, a, box);
        if (theAngleOut != null && theAngleOut.length != 0) theAngleOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static long GetRotation_2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5971, a, box);
        return r;
    }
    public static long VectorialPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5972, a, box);
        return r;
    }
    public static long HVectorialPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5973, a, box);
        return r;
    }
    public static double Value(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(5974, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5975, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5976, a, box);
        return r;
    }
    public static long Multiplied(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(5977, a, box);
        return r;
    }
    public static void Multiply(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5978, a, box);
    }
    public static void PreMultiply(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(5979, a, box);
    }
    public static void Power(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        OcctGen.occtCall(5980, a, box);
    }
    public static long Powered(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        long r = OcctGen.occtCall(5981, a, box);
        return r;
    }
    public static void Transforms(long self, double[] theXOut, double[] theYOut, double[] theZOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(5982, a, box);
        if (theXOut != null && theXOut.length != 0) theXOut[0] = Double.longBitsToDouble(a[1]);
        if (theYOut != null && theYOut.length != 0) theYOut[0] = Double.longBitsToDouble(a[2]);
        if (theZOut != null && theZOut.length != 0) theZOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static void Transforms_2(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(5983, a, box);
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(5984, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(5985, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class gp_Trsf2d {
        private gp_Trsf2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(5986, a, box);
        return r;
    }
    public static long 构造_2(long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theT;
        long r = OcctGen.occtCall(5987, a, box);
        return r;
    }
    public static void SetMirror(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(5988, a, box);
    }
    public static void SetMirror_2(long self, long theA) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA;
        OcctGen.occtCall(5989, a, box);
    }
    public static void SetRotation(long self, long theP, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(5990, a, box);
    }
    public static void SetScale(long self, long theP, double theS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        a[2] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5991, a, box);
    }
    public static void SetTransformation(long self, long theFromSystem1, long theToSystem2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theFromSystem1;
        a[2] = theToSystem2;
        OcctGen.occtCall(5992, a, box);
    }
    public static void SetTransformation_2(long self, long theToSystem) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theToSystem;
        OcctGen.occtCall(5993, a, box);
    }
    public static void SetTranslation(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5994, a, box);
    }
    public static void SetTranslation_2(long self, long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theP1;
        a[2] = theP2;
        OcctGen.occtCall(5995, a, box);
    }
    public static void SetTranslationPart(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(5996, a, box);
    }
    public static void SetScaleFactor(long self, double theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(5997, a, box);
    }
    public static boolean IsNegative(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5998, a, box);
        return r != 0;
    }
    public static int Form(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(5999, a, box);
        return (int) r;
    }
    public static double ScaleFactor(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6000, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long TranslationPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6001, a, box);
        return r;
    }
    public static long VectorialPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6002, a, box);
        return r;
    }
    public static long HVectorialPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6003, a, box);
        return r;
    }
    public static double RotationPart(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6004, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Value(long self, int theRow, int theCol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theRow;
        a[2] = theCol;
        long r = OcctGen.occtCall(6005, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6006, a, box);
    }
    public static long Inverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6007, a, box);
        return r;
    }
    public static long Multiplied(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(6008, a, box);
        return r;
    }
    public static void Multiply(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(6009, a, box);
    }
    public static void PreMultiply(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(6010, a, box);
    }
    public static void Power(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        OcctGen.occtCall(6011, a, box);
    }
    public static long Powered(long self, int theN) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theN;
        long r = OcctGen.occtCall(6012, a, box);
        return r;
    }
    public static void Transforms(long self, double[] theXOut, double[] theYOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6013, a, box);
        if (theXOut != null && theXOut.length != 0) theXOut[0] = Double.longBitsToDouble(a[1]);
        if (theYOut != null && theYOut.length != 0) theYOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static void Transforms_2(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(6014, a, box);
    }
    public static void SetValues(
            long self, double a11, double a12, double a13, double a21, double a22, double a23) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(a11);
        a[2] = Double.doubleToRawLongBits(a12);
        a[3] = Double.doubleToRawLongBits(a13);
        a[4] = Double.doubleToRawLongBits(a21);
        a[5] = Double.doubleToRawLongBits(a22);
        a[6] = Double.doubleToRawLongBits(a23);
        OcctGen.occtCall(6015, a, box);
    }
    }

    public static final class gp_Vec {
        private gp_Vec() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(6016, a, box);
        return r;
    }
    public static long 构造_2(long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theV;
        long r = OcctGen.occtCall(6017, a, box);
        return r;
    }
    public static long 构造_3(long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theCoord;
        long r = OcctGen.occtCall(6018, a, box);
        return r;
    }
    public static long 构造_4(double theXv, double theYv, double theZv) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theXv);
        a[2] = Double.doubleToRawLongBits(theYv);
        a[3] = Double.doubleToRawLongBits(theZv);
        long r = OcctGen.occtCall(6019, a, box);
        return r;
    }
    public static long 构造_5(long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(6020, a, box);
        return r;
    }
    public static void SetCoord(long self, int theIndex, double theXi) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theXi);
        OcctGen.occtCall(6021, a, box);
    }
    public static void SetCoord_2(long self, double theXv, double theYv, double theZv) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theXv);
        a[2] = Double.doubleToRawLongBits(theYv);
        a[3] = Double.doubleToRawLongBits(theZv);
        OcctGen.occtCall(6022, a, box);
    }
    public static void SetX(long self, double theX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        OcctGen.occtCall(6023, a, box);
    }
    public static void SetY(long self, double theY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(6024, a, box);
    }
    public static void SetZ(long self, double theZ) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theZ);
        OcctGen.occtCall(6025, a, box);
    }
    public static void SetXYZ(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(6026, a, box);
    }
    public static double Coord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(6027, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord_2(long self, double[] theXvOut, double[] theYvOut, double[] theZvOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6028, a, box);
        if (theXvOut != null && theXvOut.length != 0) theXvOut[0] = Double.longBitsToDouble(a[1]);
        if (theYvOut != null && theYvOut.length != 0) theYvOut[0] = Double.longBitsToDouble(a[2]);
        if (theZvOut != null && theZvOut.length != 0) theZvOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6029, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6030, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Z(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6031, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XYZ(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6032, a, box);
        return r;
    }
    public static boolean IsEqual(
            long self, long theOther, double theLinearTolerance, double theAngularTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        a[3] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(6033, a, box);
        return r != 0;
    }
    public static boolean IsNormal(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(6034, a, box);
        return r != 0;
    }
    public static boolean IsOpposite(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(6035, a, box);
        return r != 0;
    }
    public static boolean IsParallel(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(6036, a, box);
        return r != 0;
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6037, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double AngleWithRef(long self, long theOther, long theVRef) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = theVRef;
        long r = OcctGen.occtCall(6038, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Magnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6039, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareMagnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6040, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Add(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6041, a, box);
    }
    public static long Added(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6042, a, box);
        return r;
    }
    public static void Subtract(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        OcctGen.occtCall(6043, a, box);
    }
    public static long Subtracted(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6044, a, box);
        return r;
    }
    public static void Multiply(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(6045, a, box);
    }
    public static long Multiplied(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(6046, a, box);
        return r;
    }
    public static void Divide(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(6047, a, box);
    }
    public static long Divided(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(6048, a, box);
        return r;
    }
    public static void Cross(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        OcctGen.occtCall(6049, a, box);
    }
    public static long Crossed(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6050, a, box);
        return r;
    }
    public static double CrossMagnitude(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6051, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double CrossSquareMagnitude(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6052, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void CrossCross(long self, long theV1, long theV2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV1;
        a[2] = theV2;
        OcctGen.occtCall(6053, a, box);
    }
    public static long CrossCrossed(long self, long theV1, long theV2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV1;
        a[2] = theV2;
        long r = OcctGen.occtCall(6054, a, box);
        return r;
    }
    public static double Dot(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6055, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double DotCross(long self, long theV1, long theV2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV1;
        a[2] = theV2;
        long r = OcctGen.occtCall(6056, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Normalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6057, a, box);
    }
    public static long Normalized(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6058, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6059, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6060, a, box);
        return r;
    }
    public static void SetLinearForm(
            long self, double theA1, long theV1, double theA2, long theV2, double theA3,
            long theV3, long theV4) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theV1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theV2;
        a[5] = Double.doubleToRawLongBits(theA3);
        a[6] = theV3;
        a[7] = theV4;
        OcctGen.occtCall(6061, a, box);
    }
    public static void SetLinearForm_2(
            long self, double theA1, long theV1, double theA2, long theV2, double theA3,
            long theV3) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theV1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theV2;
        a[5] = Double.doubleToRawLongBits(theA3);
        a[6] = theV3;
        OcctGen.occtCall(6062, a, box);
    }
    public static void SetLinearForm_3(
            long self, double theA1, long theV1, double theA2, long theV2, long theV3) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theV1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theV2;
        a[5] = theV3;
        OcctGen.occtCall(6063, a, box);
    }
    public static void SetLinearForm_4(
            long self, double theA1, long theV1, double theA2, long theV2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theV1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theV2;
        OcctGen.occtCall(6064, a, box);
    }
    public static void SetLinearForm_5(long self, double theA1, long theV1, long theV2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theV1;
        a[3] = theV2;
        OcctGen.occtCall(6065, a, box);
    }
    public static void SetLinearForm_6(long self, long theV1, long theV2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV1;
        a[2] = theV2;
        OcctGen.occtCall(6066, a, box);
    }
    public static void Mirror(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(6067, a, box);
    }
    public static long Mirrored(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(6068, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(6069, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(6070, a, box);
        return r;
    }
    public static void Mirror_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        OcctGen.occtCall(6071, a, box);
    }
    public static long Mirrored_3(long self, long theA2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA2;
        long r = OcctGen.occtCall(6072, a, box);
        return r;
    }
    public static void Rotate(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(6073, a, box);
    }
    public static long Rotated(long self, long theA1, double theAng) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        a[2] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(6074, a, box);
        return r;
    }
    public static void Scale(long self, double theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(6075, a, box);
    }
    public static long Scaled(long self, double theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(6076, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(6077, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(6078, a, box);
        return r;
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(6079, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class gp_Vec2d {
        private gp_Vec2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(6080, a, box);
        return r;
    }
    public static long 构造_2(long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theV;
        long r = OcctGen.occtCall(6081, a, box);
        return r;
    }
    public static long 构造_3(long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theCoord;
        long r = OcctGen.occtCall(6082, a, box);
        return r;
    }
    public static long 构造_4(double theXv, double theYv) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theXv);
        a[2] = Double.doubleToRawLongBits(theYv);
        long r = OcctGen.occtCall(6083, a, box);
        return r;
    }
    public static long 构造_5(long theP1, long theP2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theP1;
        a[2] = theP2;
        long r = OcctGen.occtCall(6084, a, box);
        return r;
    }
    public static void SetCoord(long self, int theIndex, double theXi) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theXi);
        OcctGen.occtCall(6085, a, box);
    }
    public static void SetCoord_2(long self, double theXv, double theYv) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theXv);
        a[2] = Double.doubleToRawLongBits(theYv);
        OcctGen.occtCall(6086, a, box);
    }
    public static void SetX(long self, double theX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        OcctGen.occtCall(6087, a, box);
    }
    public static void SetY(long self, double theY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(6088, a, box);
    }
    public static void SetXY(long self, long theCoord) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord;
        OcctGen.occtCall(6089, a, box);
    }
    public static double Coord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(6090, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord_2(long self, double[] theXvOut, double[] theYvOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6091, a, box);
        if (theXvOut != null && theXvOut.length != 0) theXvOut[0] = Double.longBitsToDouble(a[1]);
        if (theYvOut != null && theYvOut.length != 0) theYvOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6092, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6093, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long XY(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6094, a, box);
        return r;
    }
    public static boolean IsEqual(
            long self, long theOther, double theLinearTolerance, double theAngularTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theLinearTolerance);
        a[3] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(6095, a, box);
        return r != 0;
    }
    public static boolean IsNormal(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(6096, a, box);
        return r != 0;
    }
    public static boolean IsOpposite(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(6097, a, box);
        return r != 0;
    }
    public static boolean IsParallel(long self, long theOther, double theAngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theAngularTolerance);
        long r = OcctGen.occtCall(6098, a, box);
        return r != 0;
    }
    public static double Angle(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6099, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Magnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6100, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareMagnitude(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6101, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Add(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6102, a, box);
    }
    public static long Added(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6103, a, box);
        return r;
    }
    public static double Crossed(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6104, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double CrossMagnitude(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6105, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double CrossSquareMagnitude(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6106, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Divide(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(6107, a, box);
    }
    public static long Divided(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(6108, a, box);
        return r;
    }
    public static double Dot(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6109, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long GetNormal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6110, a, box);
        return r;
    }
    public static void Multiply(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(6111, a, box);
    }
    public static long Multiplied(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(6112, a, box);
        return r;
    }
    public static void Normalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6113, a, box);
    }
    public static long Normalized(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6114, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6115, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6116, a, box);
        return r;
    }
    public static void Subtract(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        OcctGen.occtCall(6117, a, box);
    }
    public static long Subtracted(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6118, a, box);
        return r;
    }
    public static void SetLinearForm(
            long self, double theA1, long theV1, double theA2, long theV2, long theV3) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theV1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theV2;
        a[5] = theV3;
        OcctGen.occtCall(6119, a, box);
    }
    public static void SetLinearForm_2(
            long self, double theA1, long theV1, double theA2, long theV2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theV1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theV2;
        OcctGen.occtCall(6120, a, box);
    }
    public static void SetLinearForm_3(long self, double theA1, long theV1, long theV2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theV1;
        a[3] = theV2;
        OcctGen.occtCall(6121, a, box);
    }
    public static void SetLinearForm_4(long self, long theV1, long theV2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theV1;
        a[2] = theV2;
        OcctGen.occtCall(6122, a, box);
    }
    public static void Mirror(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        OcctGen.occtCall(6123, a, box);
    }
    public static long Mirrored(long self, long theV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theV;
        long r = OcctGen.occtCall(6124, a, box);
        return r;
    }
    public static void Mirror_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        OcctGen.occtCall(6125, a, box);
    }
    public static long Mirrored_2(long self, long theA1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theA1;
        long r = OcctGen.occtCall(6126, a, box);
        return r;
    }
    public static void Rotate(long self, double theAng) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theAng);
        OcctGen.occtCall(6127, a, box);
    }
    public static long Rotated(long self, double theAng) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theAng);
        long r = OcctGen.occtCall(6128, a, box);
        return r;
    }
    public static void Scale(long self, double theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(6129, a, box);
    }
    public static long Scaled(long self, double theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theS);
        long r = OcctGen.occtCall(6130, a, box);
        return r;
    }
    public static void Transform(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        OcctGen.occtCall(6131, a, box);
    }
    public static long Transformed(long self, long theT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theT;
        long r = OcctGen.occtCall(6132, a, box);
        return r;
    }
    }

    public static final class gp_XY {
        private gp_XY() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(6133, a, box);
        return r;
    }
    public static long 构造_2(double theX, double theY) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theX);
        a[2] = Double.doubleToRawLongBits(theY);
        long r = OcctGen.occtCall(6134, a, box);
        return r;
    }
    public static void SetCoord(long self, int theIndex, double theXi) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theXi);
        OcctGen.occtCall(6135, a, box);
    }
    public static void SetCoord_2(long self, double theX, double theY) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        a[2] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(6136, a, box);
    }
    public static void SetX(long self, double theX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        OcctGen.occtCall(6137, a, box);
    }
    public static void SetY(long self, double theY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(6138, a, box);
    }
    public static double Coord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(6139, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ChangeCoord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(6140, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord_2(long self, double[] theXOut, double[] theYOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6141, a, box);
        if (theXOut != null && theXOut.length != 0) theXOut[0] = Double.longBitsToDouble(a[1]);
        if (theYOut != null && theYOut.length != 0) theYOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6142, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6143, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Modulus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6144, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareModulus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6145, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsEqual(long self, long theOther, double theTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theTolerance);
        long r = OcctGen.occtCall(6146, a, box);
        return r != 0;
    }
    public static void Add(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6147, a, box);
    }
    public static long Added(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6148, a, box);
        return r;
    }
    public static double Crossed(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6149, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double CrossMagnitude(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6150, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double CrossSquareMagnitude(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6151, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Divide(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(6152, a, box);
    }
    public static long Divided(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(6153, a, box);
        return r;
    }
    public static double Dot(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6154, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Multiply(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(6155, a, box);
    }
    public static void Multiply_2(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6156, a, box);
    }
    public static void Multiply_3(long self, long theMatrix) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theMatrix;
        OcctGen.occtCall(6157, a, box);
    }
    public static long Multiplied(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(6158, a, box);
        return r;
    }
    public static long Multiplied_2(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6159, a, box);
        return r;
    }
    public static long Multiplied_3(long self, long theMatrix) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theMatrix;
        long r = OcctGen.occtCall(6160, a, box);
        return r;
    }
    public static void Normalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6161, a, box);
    }
    public static long Normalized(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6162, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6163, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6164, a, box);
        return r;
    }
    public static void SetLinearForm(
            long self, double theA1, long theXY1, double theA2, long theXY2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theXY1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theXY2;
        OcctGen.occtCall(6165, a, box);
    }
    public static void SetLinearForm_2(
            long self, double theA1, long theXY1, double theA2, long theXY2, long theXY3) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theXY1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theXY2;
        a[5] = theXY3;
        OcctGen.occtCall(6166, a, box);
    }
    public static void SetLinearForm_3(long self, double theA1, long theXY1, long theXY2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theXY1;
        a[3] = theXY2;
        OcctGen.occtCall(6167, a, box);
    }
    public static void SetLinearForm_4(long self, long theXY1, long theXY2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theXY1;
        a[2] = theXY2;
        OcctGen.occtCall(6168, a, box);
    }
    public static void Subtract(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6169, a, box);
    }
    public static long Subtracted(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6170, a, box);
        return r;
    }
    }

    public static final class gp_XYZ {
        private gp_XYZ() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(6171, a, box);
        return r;
    }
    public static long 构造_2(double theX, double theY, double theZ) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theX);
        a[2] = Double.doubleToRawLongBits(theY);
        a[3] = Double.doubleToRawLongBits(theZ);
        long r = OcctGen.occtCall(6172, a, box);
        return r;
    }
    public static void SetCoord(long self, double theX, double theY, double theZ) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        a[2] = Double.doubleToRawLongBits(theY);
        a[3] = Double.doubleToRawLongBits(theZ);
        OcctGen.occtCall(6173, a, box);
    }
    public static void SetCoord_2(long self, int theIndex, double theXi) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = Double.doubleToRawLongBits(theXi);
        OcctGen.occtCall(6174, a, box);
    }
    public static void SetX(long self, double theX) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theX);
        OcctGen.occtCall(6175, a, box);
    }
    public static void SetY(long self, double theY) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theY);
        OcctGen.occtCall(6176, a, box);
    }
    public static void SetZ(long self, double theZ) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theZ);
        OcctGen.occtCall(6177, a, box);
    }
    public static double Coord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(6178, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ChangeCoord(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(6179, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Coord_2(long self, double[] theXOut, double[] theYOut, double[] theZOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6180, a, box);
        if (theXOut != null && theXOut.length != 0) theXOut[0] = Double.longBitsToDouble(a[1]);
        if (theYOut != null && theYOut.length != 0) theYOut[0] = Double.longBitsToDouble(a[2]);
        if (theZOut != null && theZOut.length != 0) theZOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double X(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6181, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Y(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6182, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Z(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6183, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Modulus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6184, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareModulus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6185, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsEqual(long self, long theOther, double theTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        a[2] = Double.doubleToRawLongBits(theTolerance);
        long r = OcctGen.occtCall(6186, a, box);
        return r != 0;
    }
    public static void Add(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6187, a, box);
    }
    public static long Added(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6188, a, box);
        return r;
    }
    public static void Cross(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6189, a, box);
    }
    public static long Crossed(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6190, a, box);
        return r;
    }
    public static double CrossMagnitude(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6191, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double CrossSquareMagnitude(long self, long theRight) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRight;
        long r = OcctGen.occtCall(6192, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void CrossCross(long self, long theCoord1, long theCoord2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord1;
        a[2] = theCoord2;
        OcctGen.occtCall(6193, a, box);
    }
    public static long CrossCrossed(long self, long theCoord1, long theCoord2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord1;
        a[2] = theCoord2;
        long r = OcctGen.occtCall(6194, a, box);
        return r;
    }
    public static void Divide(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(6195, a, box);
    }
    public static long Divided(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(6196, a, box);
        return r;
    }
    public static double Dot(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6197, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double DotCross(long self, long theCoord1, long theCoord2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theCoord1;
        a[2] = theCoord2;
        long r = OcctGen.occtCall(6198, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Multiply(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        OcctGen.occtCall(6199, a, box);
    }
    public static void Multiply_2(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6200, a, box);
    }
    public static void Multiply_3(long self, long theMatrix) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theMatrix;
        OcctGen.occtCall(6201, a, box);
    }
    public static long Multiplied(long self, double theScalar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theScalar);
        long r = OcctGen.occtCall(6202, a, box);
        return r;
    }
    public static long Multiplied_2(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6203, a, box);
        return r;
    }
    public static long Multiplied_3(long self, long theMatrix) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theMatrix;
        long r = OcctGen.occtCall(6204, a, box);
        return r;
    }
    public static void Normalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6205, a, box);
    }
    public static long Normalized(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6206, a, box);
        return r;
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6207, a, box);
    }
    public static long Reversed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6208, a, box);
        return r;
    }
    public static void Subtract(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        OcctGen.occtCall(6209, a, box);
    }
    public static long Subtracted(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(6210, a, box);
        return r;
    }
    public static void SetLinearForm(
            long self, double theA1, long theXYZ1, double theA2, long theXYZ2, double theA3,
            long theXYZ3, long theXYZ4) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theXYZ1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theXYZ2;
        a[5] = Double.doubleToRawLongBits(theA3);
        a[6] = theXYZ3;
        a[7] = theXYZ4;
        OcctGen.occtCall(6211, a, box);
    }
    public static void SetLinearForm_2(
            long self, double theA1, long theXYZ1, double theA2, long theXYZ2, double theA3,
            long theXYZ3) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theXYZ1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theXYZ2;
        a[5] = Double.doubleToRawLongBits(theA3);
        a[6] = theXYZ3;
        OcctGen.occtCall(6212, a, box);
    }
    public static void SetLinearForm_3(
            long self, double theA1, long theXYZ1, double theA2, long theXYZ2, long theXYZ3) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theXYZ1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theXYZ2;
        a[5] = theXYZ3;
        OcctGen.occtCall(6213, a, box);
    }
    public static void SetLinearForm_4(
            long self, double theA1, long theXYZ1, double theA2, long theXYZ2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theXYZ1;
        a[3] = Double.doubleToRawLongBits(theA2);
        a[4] = theXYZ2;
        OcctGen.occtCall(6214, a, box);
    }
    public static void SetLinearForm_5(long self, double theA1, long theXYZ1, long theXYZ2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theA1);
        a[2] = theXYZ1;
        a[3] = theXYZ2;
        OcctGen.occtCall(6215, a, box);
    }
    public static void SetLinearForm_6(long self, long theXYZ1, long theXYZ2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theXYZ1;
        a[2] = theXYZ2;
        OcctGen.occtCall(6216, a, box);
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(6217, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(6218, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class math_Matrix {
        private math_Matrix() {}

    public static long 构造(int LowerRow, int UpperRow, int LowerCol, int UpperCol) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = LowerRow;
        a[2] = UpperRow;
        a[3] = LowerCol;
        a[4] = UpperCol;
        long r = OcctGen.occtCall(6219, a, box);
        return r;
    }
    public static long 构造_2(
            int LowerRow, int UpperRow, int LowerCol, int UpperCol, double InitialValue) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = LowerRow;
        a[2] = UpperRow;
        a[3] = LowerCol;
        a[4] = UpperCol;
        a[5] = Double.doubleToRawLongBits(InitialValue);
        long r = OcctGen.occtCall(6220, a, box);
        return r;
    }
    public static long 构造_3(long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Other;
        long r = OcctGen.occtCall(6221, a, box);
        return r;
    }
    public static void Init(long self, double InitialValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(InitialValue);
        OcctGen.occtCall(6222, a, box);
    }
    public static int RowNumber(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6223, a, box);
        return (int) r;
    }
    public static int ColNumber(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6224, a, box);
        return (int) r;
    }
    public static int LowerRow(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6225, a, box);
        return (int) r;
    }
    public static int UpperRow(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6226, a, box);
        return (int) r;
    }
    public static int LowerCol(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6227, a, box);
        return (int) r;
    }
    public static int UpperCol(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6228, a, box);
        return (int) r;
    }
    public static double Determinant(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6229, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transpose(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6230, a, box);
    }
    public static void Invert(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(6231, a, box);
    }
    public static void Multiply(long self, double Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Right);
        OcctGen.occtCall(6232, a, box);
    }
    public static long Multiplied(long self, double Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Right);
        long r = OcctGen.occtCall(6233, a, box);
        return r;
    }
    public static long TMultiplied(long self, double Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Right);
        long r = OcctGen.occtCall(6234, a, box);
        return r;
    }
    public static void Divide(long self, double Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Right);
        OcctGen.occtCall(6235, a, box);
    }
    public static long Divided(long self, double Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Right);
        long r = OcctGen.occtCall(6236, a, box);
        return r;
    }
    public static void Add(long self, long Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Right;
        OcctGen.occtCall(6237, a, box);
    }
    public static long Added(long self, long Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Right;
        long r = OcctGen.occtCall(6238, a, box);
        return r;
    }
    public static void Add_2(long self, long Left, long Right) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Left;
        a[2] = Right;
        OcctGen.occtCall(6239, a, box);
    }
    public static void Subtract(long self, long Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Right;
        OcctGen.occtCall(6240, a, box);
    }
    public static long Subtracted(long self, long Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Right;
        long r = OcctGen.occtCall(6241, a, box);
        return r;
    }
    public static void Set(long self, int I1, int I2, int J1, int J2, long M) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = I1;
        a[2] = I2;
        a[3] = J1;
        a[4] = J2;
        a[5] = M;
        OcctGen.occtCall(6242, a, box);
    }
    public static void SetDiag(long self, double Value) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Value);
        OcctGen.occtCall(6243, a, box);
    }
    public static void SwapRow(long self, int Row1, int Row2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Row1;
        a[2] = Row2;
        OcctGen.occtCall(6244, a, box);
    }
    public static void SwapCol(long self, int Col1, int Col2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Col1;
        a[2] = Col2;
        OcctGen.occtCall(6245, a, box);
    }
    public static long Transposed(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6246, a, box);
        return r;
    }
    public static long Inverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6247, a, box);
        return r;
    }
    public static long TMultiply(long self, long Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Right;
        long r = OcctGen.occtCall(6248, a, box);
        return r;
    }
    public static void Multiply_2(long self, long Left, long Right) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Left;
        a[2] = Right;
        OcctGen.occtCall(6249, a, box);
    }
    public static void TMultiply_2(long self, long TLeft, long Right) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = TLeft;
        a[2] = Right;
        OcctGen.occtCall(6250, a, box);
    }
    public static void Subtract_2(long self, long Left, long Right) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Left;
        a[2] = Right;
        OcctGen.occtCall(6251, a, box);
    }
    public static double Value(long self, int Row, int Col) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Row;
        a[2] = Col;
        long r = OcctGen.occtCall(6252, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Initialized(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(6253, a, box);
        return r;
    }
    public static void Multiply_3(long self, long Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Right;
        OcctGen.occtCall(6254, a, box);
    }
    public static long Multiplied_2(long self, long Right) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Right;
        long r = OcctGen.occtCall(6255, a, box);
        return r;
    }
    public static long Opposite(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(6256, a, box);
        return r;
    }
    public static String Dump(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(6257, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

}
