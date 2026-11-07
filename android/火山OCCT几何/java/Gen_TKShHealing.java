package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKShHealing 类=12 方法槽=324
public final class Gen_TKShHealing {
    private Gen_TKShHealing() {}

    public static final class ShapeAnalysis_Surface {
        private ShapeAnalysis_Surface() {}

    public static long 构造(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4228, a, box);
        return r;
    }
    public static void Init(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(4229, a, box);
    }
    public static void Init_2(long self, long other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = other;
        OcctGen.occtCall(4230, a, box);
    }
    public static void SetDomain(long self, double U1, double U2, double V1, double V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U1);
        a[2] = Double.doubleToRawLongBits(U2);
        a[3] = Double.doubleToRawLongBits(V1);
        a[4] = Double.doubleToRawLongBits(V2);
        OcctGen.occtCall(4231, a, box);
    }
    public static long Surface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4232, a, box);
        return r;
    }
    public static long Adaptor3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4233, a, box);
        return r;
    }
    public static long TrueAdaptor3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4234, a, box);
        return r;
    }
    public static double Gap(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4235, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Value(long self, double u, double v) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(u);
        a[2] = Double.doubleToRawLongBits(v);
        long r = OcctGen.occtCall(4236, a, box);
        return r;
    }
    public static long Value_2(long self, long p2d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = p2d;
        long r = OcctGen.occtCall(4237, a, box);
        return r;
    }
    public static boolean HasSingularities(long self, double preci) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(preci);
        long r = OcctGen.occtCall(4238, a, box);
        return r != 0;
    }
    public static int NbSingularities(long self, double preci) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(preci);
        long r = OcctGen.occtCall(4239, a, box);
        return (int) r;
    }
    public static boolean Singularity(
            long self, int num, double[] preciOut, long P3d, long firstP2d, long lastP2d,
            double[] firstparOut, double[] lastparOut, boolean[] uisodegOut) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[3] = P3d;
        a[4] = firstP2d;
        a[5] = lastP2d;
        long r = OcctGen.occtCall(4240, a, box);
        if (preciOut != null && preciOut.length != 0) preciOut[0] = Double.longBitsToDouble(a[2]);
        if (firstparOut != null && firstparOut.length != 0) firstparOut[0] = Double.longBitsToDouble(a[6]);
        if (lastparOut != null && lastparOut.length != 0) lastparOut[0] = Double.longBitsToDouble(a[7]);
        if (uisodegOut != null && uisodegOut.length != 0) uisodegOut[0] = a[8] != 0;
        return r != 0;
    }
    public static boolean IsDegenerated(long self, long P3d, double preci) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P3d;
        a[2] = Double.doubleToRawLongBits(preci);
        long r = OcctGen.occtCall(4241, a, box);
        return r != 0;
    }
    public static boolean DegeneratedValues(
            long self, long P3d, double preci, long firstP2d, long lastP2d, double[] firstparOut,
            double[] lastparOut, boolean forward) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = P3d;
        a[2] = Double.doubleToRawLongBits(preci);
        a[3] = firstP2d;
        a[4] = lastP2d;
        a[7] = forward ? 1L : 0L;
        long r = OcctGen.occtCall(4242, a, box);
        if (firstparOut != null && firstparOut.length != 0) firstparOut[0] = Double.longBitsToDouble(a[5]);
        if (lastparOut != null && lastparOut.length != 0) lastparOut[0] = Double.longBitsToDouble(a[6]);
        return r != 0;
    }
    public static boolean ProjectDegenerated(
            long self, long P3d, double preci, long neighbour, long result) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = P3d;
        a[2] = Double.doubleToRawLongBits(preci);
        a[3] = neighbour;
        a[4] = result;
        long r = OcctGen.occtCall(4243, a, box);
        return r != 0;
    }
    public static boolean IsDegenerated_2(
            long self, long p2d1, long p2d2, double tol, double ratio) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = p2d1;
        a[2] = p2d2;
        a[3] = Double.doubleToRawLongBits(tol);
        a[4] = Double.doubleToRawLongBits(ratio);
        long r = OcctGen.occtCall(4244, a, box);
        return r != 0;
    }
    public static void Bounds(
            long self, double[] ufirstOut, double[] ulastOut, double[] vfirstOut,
            double[] vlastOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4245, a, box);
        if (ufirstOut != null && ufirstOut.length != 0) ufirstOut[0] = Double.longBitsToDouble(a[1]);
        if (ulastOut != null && ulastOut.length != 0) ulastOut[0] = Double.longBitsToDouble(a[2]);
        if (vfirstOut != null && vfirstOut.length != 0) vfirstOut[0] = Double.longBitsToDouble(a[3]);
        if (vlastOut != null && vlastOut.length != 0) vlastOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static void ComputeBoundIsos(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4246, a, box);
    }
    public static long UIso(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(4247, a, box);
        return r;
    }
    public static long VIso(long self, double V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(V);
        long r = OcctGen.occtCall(4248, a, box);
        return r;
    }
    public static boolean IsUClosed(long self, double preci) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(preci);
        long r = OcctGen.occtCall(4249, a, box);
        return r != 0;
    }
    public static boolean IsVClosed(long self, double preci) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(preci);
        long r = OcctGen.occtCall(4250, a, box);
        return r != 0;
    }
    public static long ValueOfUV(long self, long P3D, double preci) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P3D;
        a[2] = Double.doubleToRawLongBits(preci);
        long r = OcctGen.occtCall(4251, a, box);
        return r;
    }
    public static long NextValueOfUV(
            long self, long p2dPrev, long P3D, double preci, double maxpreci) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = p2dPrev;
        a[2] = P3D;
        a[3] = Double.doubleToRawLongBits(preci);
        a[4] = Double.doubleToRawLongBits(maxpreci);
        long r = OcctGen.occtCall(4252, a, box);
        return r;
    }
    public static double UVFromIso(
            long self, long P3D, double preci, double[] UOut, double[] VOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = P3D;
        a[2] = Double.doubleToRawLongBits(preci);
        long r = OcctGen.occtCall(4253, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[3]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[4]);
        return Double.longBitsToDouble(r);
    }
    public static double UCloseVal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4254, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VCloseVal(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4255, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long GetBoxUF(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4256, a, box);
        return r;
    }
    public static long GetBoxUL(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4257, a, box);
        return r;
    }
    public static long GetBoxVF(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4258, a, box);
        return r;
    }
    public static long GetBoxVL(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4259, a, box);
        return r;
    }
    }

    public static final class ShapeAnalysis_Wire {
        private ShapeAnalysis_Wire() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4260, a, box);
        return r;
    }
    public static long 构造_2(long wire, long face, double precision) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = wire;
        a[2] = face;
        a[3] = Double.doubleToRawLongBits(precision);
        long r = OcctGen.occtCall(4261, a, box);
        return r;
    }
    public static long 构造_3(long sbwd, long face, double precision) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = sbwd;
        a[2] = face;
        a[3] = Double.doubleToRawLongBits(precision);
        long r = OcctGen.occtCall(4262, a, box);
        return r;
    }
    public static void Init(long self, long wire, long face, double precision) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        a[2] = face;
        a[3] = Double.doubleToRawLongBits(precision);
        OcctGen.occtCall(4263, a, box);
    }
    public static void Init_2(long self, long sbwd, long face, double precision) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = sbwd;
        a[2] = face;
        a[3] = Double.doubleToRawLongBits(precision);
        OcctGen.occtCall(4264, a, box);
    }
    public static void Load(long self, long wire) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        OcctGen.occtCall(4265, a, box);
    }
    public static void Load_2(long self, long sbwd) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = sbwd;
        OcctGen.occtCall(4266, a, box);
    }
    public static void SetFace(long self, long face) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = face;
        OcctGen.occtCall(4267, a, box);
    }
    public static void SetSurface(long self, long surface) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = surface;
        OcctGen.occtCall(4268, a, box);
    }
    public static void SetSurface_2(long self, long surface, long location) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = surface;
        a[2] = location;
        OcctGen.occtCall(4269, a, box);
    }
    public static void SetPrecision(long self, double precision) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(precision);
        OcctGen.occtCall(4270, a, box);
    }
    public static void ClearStatuses(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4271, a, box);
    }
    public static boolean IsLoaded(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4272, a, box);
        return r != 0;
    }
    public static boolean IsReady(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4273, a, box);
        return r != 0;
    }
    public static double Precision(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4274, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long WireData(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4275, a, box);
        return r;
    }
    public static int NbEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4276, a, box);
        return (int) r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4277, a, box);
        return r;
    }
    public static long Surface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4278, a, box);
        return r;
    }
    public static boolean Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4279, a, box);
        return r != 0;
    }
    public static boolean CheckOrder(long self, boolean isClosed, boolean mode3d) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = isClosed ? 1L : 0L;
        a[2] = mode3d ? 1L : 0L;
        long r = OcctGen.occtCall(4280, a, box);
        return r != 0;
    }
    public static boolean CheckConnected(long self, double prec) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4281, a, box);
        return r != 0;
    }
    public static boolean CheckSmall(long self, double precsmall) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(precsmall);
        long r = OcctGen.occtCall(4282, a, box);
        return r != 0;
    }
    public static boolean CheckEdgeCurves(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4283, a, box);
        return r != 0;
    }
    public static boolean CheckDegenerated(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4284, a, box);
        return r != 0;
    }
    public static boolean CheckClosed(long self, double prec) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4285, a, box);
        return r != 0;
    }
    public static boolean CheckSelfIntersection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4286, a, box);
        return r != 0;
    }
    public static boolean CheckLacking(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4287, a, box);
        return r != 0;
    }
    public static boolean CheckGaps3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4288, a, box);
        return r != 0;
    }
    public static boolean CheckGaps2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4289, a, box);
        return r != 0;
    }
    public static boolean CheckCurveGaps(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4290, a, box);
        return r != 0;
    }
    public static boolean CheckOrder_2(
            long self, long sawo, boolean isClosed, boolean theMode3D, boolean theModeBoth) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = sawo;
        a[2] = isClosed ? 1L : 0L;
        a[3] = theMode3D ? 1L : 0L;
        a[4] = theModeBoth ? 1L : 0L;
        long r = OcctGen.occtCall(4291, a, box);
        return r != 0;
    }
    public static boolean CheckConnected_2(long self, int num, double prec) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4292, a, box);
        return r != 0;
    }
    public static boolean CheckSmall_2(long self, int num, double precsmall) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = Double.doubleToRawLongBits(precsmall);
        long r = OcctGen.occtCall(4293, a, box);
        return r != 0;
    }
    public static boolean CheckSeam(
            long self, int num, long[] C1Out, long[] C2Out, double[] cfOut, double[] clOut) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4294, a, box);
        if (C1Out != null && C1Out.length != 0) C1Out[0] = a[2];
        if (C2Out != null && C2Out.length != 0) C2Out[0] = a[3];
        if (cfOut != null && cfOut.length != 0) cfOut[0] = Double.longBitsToDouble(a[4]);
        if (clOut != null && clOut.length != 0) clOut[0] = Double.longBitsToDouble(a[5]);
        return r != 0;
    }
    public static boolean CheckSeam_2(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4295, a, box);
        return r != 0;
    }
    public static boolean CheckDegenerated_2(long self, int num, long dgnr1, long dgnr2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = dgnr1;
        a[3] = dgnr2;
        long r = OcctGen.occtCall(4296, a, box);
        return r != 0;
    }
    public static boolean CheckDegenerated_3(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4297, a, box);
        return r != 0;
    }
    public static boolean CheckGap3d(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4298, a, box);
        return r != 0;
    }
    public static boolean CheckGap2d(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4299, a, box);
        return r != 0;
    }
    public static boolean CheckCurveGap(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4300, a, box);
        return r != 0;
    }
    public static boolean CheckSelfIntersectingEdge(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4301, a, box);
        return r != 0;
    }
    public static boolean CheckIntersectingEdges(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4302, a, box);
        return r != 0;
    }
    public static boolean CheckIntersectingEdges_2(long self, int num1, int num2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = num1;
        a[2] = num2;
        long r = OcctGen.occtCall(4303, a, box);
        return r != 0;
    }
    public static boolean CheckLacking_2(
            long self, int num, double Tolerance, long p2d1, long p2d2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = Double.doubleToRawLongBits(Tolerance);
        a[3] = p2d1;
        a[4] = p2d2;
        long r = OcctGen.occtCall(4304, a, box);
        return r != 0;
    }
    public static boolean CheckLacking_3(long self, int num, double Tolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = Double.doubleToRawLongBits(Tolerance);
        long r = OcctGen.occtCall(4305, a, box);
        return r != 0;
    }
    public static boolean CheckOuterBound(long self, boolean APIMake) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = APIMake ? 1L : 0L;
        long r = OcctGen.occtCall(4306, a, box);
        return r != 0;
    }
    public static boolean CheckNotchedEdges(
            long self, int num, int[] shortNumOut, double[] paramOut, double Tolerance) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[4] = Double.doubleToRawLongBits(Tolerance);
        long r = OcctGen.occtCall(4307, a, box);
        if (shortNumOut != null && shortNumOut.length != 0) shortNumOut[0] = (int) a[2];
        if (paramOut != null && paramOut.length != 0) paramOut[0] = Double.longBitsToDouble(a[3]);
        return r != 0;
    }
    public static boolean CheckSmallArea(long self, long theWire) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theWire;
        long r = OcctGen.occtCall(4308, a, box);
        return r != 0;
    }
    public static boolean CheckShapeConnect(long self, long shape, double prec) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        a[2] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4309, a, box);
        return r != 0;
    }
    public static boolean CheckShapeConnect_2(
            long self, double[] tailheadOut, double[] tailtailOut, double[] headtailOut,
            double[] headheadOut, long shape, double prec) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[5] = shape;
        a[6] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4310, a, box);
        if (tailheadOut != null && tailheadOut.length != 0) tailheadOut[0] = Double.longBitsToDouble(a[1]);
        if (tailtailOut != null && tailtailOut.length != 0) tailtailOut[0] = Double.longBitsToDouble(a[2]);
        if (headtailOut != null && headtailOut.length != 0) headtailOut[0] = Double.longBitsToDouble(a[3]);
        if (headheadOut != null && headheadOut.length != 0) headheadOut[0] = Double.longBitsToDouble(a[4]);
        return r != 0;
    }
    public static boolean CheckTail(
            long self, long theEdge1, long theEdge2, double theMaxSine, double theMaxWidth,
            double theMaxTolerance, long theEdge11, long theEdge12, long theEdge21, long theEdge22) {
        long[] a = new long[10];
        Object[] box = null;
        a[0] = self;
        a[1] = theEdge1;
        a[2] = theEdge2;
        a[3] = Double.doubleToRawLongBits(theMaxSine);
        a[4] = Double.doubleToRawLongBits(theMaxWidth);
        a[5] = Double.doubleToRawLongBits(theMaxTolerance);
        a[6] = theEdge11;
        a[7] = theEdge12;
        a[8] = theEdge21;
        a[9] = theEdge22;
        long r = OcctGen.occtCall(4311, a, box);
        return r != 0;
    }
    public static boolean StatusOrder(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4312, a, box);
        return r != 0;
    }
    public static boolean StatusConnected(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4313, a, box);
        return r != 0;
    }
    public static boolean StatusEdgeCurves(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4314, a, box);
        return r != 0;
    }
    public static boolean StatusDegenerated(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4315, a, box);
        return r != 0;
    }
    public static boolean StatusClosed(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4316, a, box);
        return r != 0;
    }
    public static boolean StatusSmall(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4317, a, box);
        return r != 0;
    }
    public static boolean StatusSelfIntersection(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4318, a, box);
        return r != 0;
    }
    public static boolean StatusLacking(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4319, a, box);
        return r != 0;
    }
    public static boolean StatusGaps3d(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4320, a, box);
        return r != 0;
    }
    public static boolean StatusGaps2d(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4321, a, box);
        return r != 0;
    }
    public static boolean StatusCurveGaps(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4322, a, box);
        return r != 0;
    }
    public static boolean StatusLoop(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4323, a, box);
        return r != 0;
    }
    public static boolean LastCheckStatus(long self, int Status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Status;
        long r = OcctGen.occtCall(4324, a, box);
        return r != 0;
    }
    public static double MinDistance3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4325, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MinDistance2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4326, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MaxDistance3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4327, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double MaxDistance2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4328, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class ShapeAnalysis_WireOrder {
        private ShapeAnalysis_WireOrder() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4329, a, box);
        return r;
    }
    public static long 构造_2(boolean theMode3D, double theTolerance, boolean theModeBoth) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theMode3D ? 1L : 0L;
        a[2] = Double.doubleToRawLongBits(theTolerance);
        a[3] = theModeBoth ? 1L : 0L;
        long r = OcctGen.occtCall(4330, a, box);
        return r;
    }
    public static void SetMode(
            long self, boolean theMode3D, double theTolerance, boolean theModeBoth) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theMode3D ? 1L : 0L;
        a[2] = Double.doubleToRawLongBits(theTolerance);
        a[3] = theModeBoth ? 1L : 0L;
        OcctGen.occtCall(4331, a, box);
    }
    public static double Tolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4332, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4333, a, box);
    }
    public static void Add(long self, long theStart3d, long theEnd3d) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theStart3d;
        a[2] = theEnd3d;
        OcctGen.occtCall(4334, a, box);
    }
    public static void Add_2(long self, long theStart2d, long theEnd2d) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theStart2d;
        a[2] = theEnd2d;
        OcctGen.occtCall(4335, a, box);
    }
    public static void Add_3(
            long self, long theStart3d, long theEnd3d, long theStart2d, long theEnd2d) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = theStart3d;
        a[2] = theEnd3d;
        a[3] = theStart2d;
        a[4] = theEnd2d;
        OcctGen.occtCall(4336, a, box);
    }
    public static int NbEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4337, a, box);
        return (int) r;
    }
    public static boolean KeepLoopsMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4338, a, box);
        return r != 0;
    }
    public static void Perform(long self, boolean closed) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = closed ? 1L : 0L;
        OcctGen.occtCall(4339, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4340, a, box);
        return r != 0;
    }
    public static int Status(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4341, a, box);
        return (int) r;
    }
    public static int Ordered(long self, int theIdx) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIdx;
        long r = OcctGen.occtCall(4342, a, box);
        return (int) r;
    }
    public static void XYZ(long self, int theIdx, long theStart3D, long theEnd3D) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theIdx;
        a[2] = theStart3D;
        a[3] = theEnd3D;
        OcctGen.occtCall(4343, a, box);
    }
    public static void XY(long self, int theIdx, long theStart2D, long theEnd2D) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theIdx;
        a[2] = theStart2D;
        a[3] = theEnd2D;
        OcctGen.occtCall(4344, a, box);
    }
    public static double Gap(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4345, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetChains(long self, double gap) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(gap);
        OcctGen.occtCall(4346, a, box);
    }
    public static int NbChains(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4347, a, box);
        return (int) r;
    }
    public static void Chain(long self, int num, int[] n1Out, int[] n2Out) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        OcctGen.occtCall(4348, a, box);
        if (n1Out != null && n1Out.length != 0) n1Out[0] = (int) a[2];
        if (n2Out != null && n2Out.length != 0) n2Out[0] = (int) a[3];
    }
    public static void SetCouples(long self, double gap) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(gap);
        OcctGen.occtCall(4349, a, box);
    }
    public static int NbCouples(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4350, a, box);
        return (int) r;
    }
    public static void Couple(long self, int num, int[] n1Out, int[] n2Out) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        OcctGen.occtCall(4351, a, box);
        if (n1Out != null && n1Out.length != 0) n1Out[0] = (int) a[2];
        if (n2Out != null && n2Out.length != 0) n2Out[0] = (int) a[3];
    }
    }

    public static final class ShapeBuild_ReShape {
        private ShapeBuild_ReShape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4352, a, box);
        return r;
    }
    public static long Apply(long self, long shape, int until, int buildmode) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        a[2] = until;
        a[3] = buildmode;
        long r = OcctGen.occtCall(4353, a, box);
        return r;
    }
    public static long Apply_2(long self, long shape, int until) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        a[2] = until;
        long r = OcctGen.occtCall(4354, a, box);
        return r;
    }
    public static int Status(long self, long shape, long newsh, boolean last) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        a[2] = newsh;
        a[3] = last ? 1L : 0L;
        long r = OcctGen.occtCall(4355, a, box);
        return (int) r;
    }
    public static boolean Status_2(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4356, a, box);
        return r != 0;
    }
    }

    public static final class ShapeConstruct_ProjectCurveOnSurface {
        private ShapeConstruct_ProjectCurveOnSurface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4357, a, box);
        return r;
    }
    public static void Init(long self, long surf, double preci) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = surf;
        a[2] = Double.doubleToRawLongBits(preci);
        OcctGen.occtCall(4358, a, box);
    }
    public static void Init_2(long self, long surf, double preci) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = surf;
        a[2] = Double.doubleToRawLongBits(preci);
        OcctGen.occtCall(4359, a, box);
    }
    public static void SetSurface(long self, long surf) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = surf;
        OcctGen.occtCall(4360, a, box);
    }
    public static void SetSurface_2(long self, long surf) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = surf;
        OcctGen.occtCall(4361, a, box);
    }
    public static void SetPrecision(long self, double preci) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(preci);
        OcctGen.occtCall(4362, a, box);
    }
    public static boolean BuildCurveMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4363, a, box);
        return r != 0;
    }
    public static int AdjustOverDegenMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4364, a, box);
        return (int) r;
    }
    public static boolean Status(long self, int theStatus) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theStatus;
        long r = OcctGen.occtCall(4365, a, box);
        return r != 0;
    }
    public static boolean Perform(
            long self, long[] c3dOut, double First, double Last, long[] c2dOut, double TolFirst,
            double TolLast) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[2] = Double.doubleToRawLongBits(First);
        a[3] = Double.doubleToRawLongBits(Last);
        a[5] = Double.doubleToRawLongBits(TolFirst);
        a[6] = Double.doubleToRawLongBits(TolLast);
        long r = OcctGen.occtCall(4366, a, box);
        if (c3dOut != null && c3dOut.length != 0) c3dOut[0] = a[1];
        if (c2dOut != null && c2dOut.length != 0) c2dOut[0] = a[4];
        return r != 0;
    }
    public static boolean PerformByProjLib(
            long self, long[] c3dOut, double First, double Last, long[] c2dOut, int continuity,
            int maxdeg, int nbinterval) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[2] = Double.doubleToRawLongBits(First);
        a[3] = Double.doubleToRawLongBits(Last);
        a[5] = continuity;
        a[6] = maxdeg;
        a[7] = nbinterval;
        long r = OcctGen.occtCall(4367, a, box);
        if (c3dOut != null && c3dOut.length != 0) c3dOut[0] = a[1];
        if (c2dOut != null && c2dOut.length != 0) c2dOut[0] = a[4];
        return r != 0;
    }
    }

    public static final class ShapeExtend_WireData {
        private ShapeExtend_WireData() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4368, a, box);
        return r;
    }
    public static long 构造_2(long wire, boolean chained, boolean theManifoldMode) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = wire;
        a[2] = chained ? 1L : 0L;
        a[3] = theManifoldMode ? 1L : 0L;
        long r = OcctGen.occtCall(4369, a, box);
        return r;
    }
    public static void Init(long self, long other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = other;
        OcctGen.occtCall(4370, a, box);
    }
    public static boolean Init_2(long self, long wire, boolean chained, boolean theManifoldMode) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        a[2] = chained ? 1L : 0L;
        a[3] = theManifoldMode ? 1L : 0L;
        long r = OcctGen.occtCall(4371, a, box);
        return r != 0;
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4372, a, box);
    }
    public static void ComputeSeams(long self, boolean enforce) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = enforce ? 1L : 0L;
        OcctGen.occtCall(4373, a, box);
    }
    public static void SetLast(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        OcctGen.occtCall(4374, a, box);
    }
    public static void SetDegeneratedLast(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4375, a, box);
    }
    public static void Add(long self, long edge, int atnum) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = edge;
        a[2] = atnum;
        OcctGen.occtCall(4376, a, box);
    }
    public static void Add_2(long self, long wire, int atnum) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        a[2] = atnum;
        OcctGen.occtCall(4377, a, box);
    }
    public static void Add_3(long self, long wire, int atnum) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        a[2] = atnum;
        OcctGen.occtCall(4378, a, box);
    }
    public static void Add_4(long self, long shape, int atnum) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        a[2] = atnum;
        OcctGen.occtCall(4379, a, box);
    }
    public static void AddOriented(long self, long edge, int mode) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = edge;
        a[2] = mode;
        OcctGen.occtCall(4380, a, box);
    }
    public static void AddOriented_2(long self, long wire, int mode) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        a[2] = mode;
        OcctGen.occtCall(4381, a, box);
    }
    public static void AddOriented_3(long self, long shape, int mode) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        a[2] = mode;
        OcctGen.occtCall(4382, a, box);
    }
    public static void Remove(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        OcctGen.occtCall(4383, a, box);
    }
    public static void Set(long self, long edge, int num) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = edge;
        a[2] = num;
        OcctGen.occtCall(4384, a, box);
    }
    public static void Reverse(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4385, a, box);
    }
    public static void Reverse_2(long self, long face) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = face;
        OcctGen.occtCall(4386, a, box);
    }
    public static int NbEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4387, a, box);
        return (int) r;
    }
    public static int NbNonManifoldEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4388, a, box);
        return (int) r;
    }
    public static long NonmanifoldEdge(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4389, a, box);
        return r;
    }
    public static boolean ManifoldMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4390, a, box);
        return r != 0;
    }
    public static long Edge(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4391, a, box);
        return r;
    }
    public static int Index(long self, long edge) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = edge;
        long r = OcctGen.occtCall(4392, a, box);
        return (int) r;
    }
    public static boolean IsSeam(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4393, a, box);
        return r != 0;
    }
    public static long Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4394, a, box);
        return r;
    }
    public static long WireAPIMake(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4395, a, box);
        return r;
    }
    }

    public static final class ShapeFix_Shape {
        private ShapeFix_Shape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4396, a, box);
        return r;
    }
    public static long 构造_2(long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = shape;
        long r = OcctGen.occtCall(4397, a, box);
        return r;
    }
    public static void Init(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        OcctGen.occtCall(4398, a, box);
    }
    public static boolean Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4399, a, box);
        return r != 0;
    }
    public static long Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4400, a, box);
        return r;
    }
    public static long FixShellTool(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4401, a, box);
        return r;
    }
    public static long FixWireTool(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4402, a, box);
        return r;
    }
    public static boolean Status(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4403, a, box);
        return r != 0;
    }
    public static void SetPrecision(long self, double preci) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(preci);
        OcctGen.occtCall(4404, a, box);
    }
    public static void SetMinTolerance(long self, double mintol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(mintol);
        OcctGen.occtCall(4405, a, box);
    }
    public static void SetMaxTolerance(long self, double maxtol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(maxtol);
        OcctGen.occtCall(4406, a, box);
    }
    public static int FixSolidMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4407, a, box);
        return (int) r;
    }
    public static int FixFreeShellMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4408, a, box);
        return (int) r;
    }
    public static int FixFreeFaceMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4409, a, box);
        return (int) r;
    }
    public static int FixFreeWireMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4410, a, box);
        return (int) r;
    }
    public static int FixSameParameterMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4411, a, box);
        return (int) r;
    }
    public static int FixVertexPositionMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4412, a, box);
        return (int) r;
    }
    public static int FixVertexTolMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4413, a, box);
        return (int) r;
    }
    }

    public static final class ShapeFix_Shell {
        private ShapeFix_Shell() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4414, a, box);
        return r;
    }
    public static long 构造_2(long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = shape;
        long r = OcctGen.occtCall(4415, a, box);
        return r;
    }
    public static void Init(long self, long shell) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shell;
        OcctGen.occtCall(4416, a, box);
    }
    public static boolean Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4417, a, box);
        return r != 0;
    }
    public static boolean FixFaceOrientation(
            long self, long shell, boolean isAccountMultiConex, boolean NonManifold) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = shell;
        a[2] = isAccountMultiConex ? 1L : 0L;
        a[3] = NonManifold ? 1L : 0L;
        long r = OcctGen.occtCall(4418, a, box);
        return r != 0;
    }
    public static long Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4419, a, box);
        return r;
    }
    public static long Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4420, a, box);
        return r;
    }
    public static int NbShells(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4421, a, box);
        return (int) r;
    }
    public static long ErrorFaces(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4422, a, box);
        return r;
    }
    public static boolean Status(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4423, a, box);
        return r != 0;
    }
    public static void SetPrecision(long self, double preci) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(preci);
        OcctGen.occtCall(4424, a, box);
    }
    public static void SetMinTolerance(long self, double mintol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(mintol);
        OcctGen.occtCall(4425, a, box);
    }
    public static void SetMaxTolerance(long self, double maxtol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(maxtol);
        OcctGen.occtCall(4426, a, box);
    }
    public static int FixFaceMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4427, a, box);
        return (int) r;
    }
    public static int FixOrientationMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4428, a, box);
        return (int) r;
    }
    public static void SetNonManifoldFlag(long self, boolean isNonManifold) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = isNonManifold ? 1L : 0L;
        OcctGen.occtCall(4429, a, box);
    }
    }

    public static final class ShapeFix_Wire {
        private ShapeFix_Wire() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4430, a, box);
        return r;
    }
    public static long 构造_2(long wire, long face, double prec) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = wire;
        a[2] = face;
        a[3] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4431, a, box);
        return r;
    }
    public static void ClearModes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4432, a, box);
    }
    public static void ClearStatuses(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4433, a, box);
    }
    public static void Init(long self, long wire, long face, double prec) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        a[2] = face;
        a[3] = Double.doubleToRawLongBits(prec);
        OcctGen.occtCall(4434, a, box);
    }
    public static void Init_2(long self, long saw) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = saw;
        OcctGen.occtCall(4435, a, box);
    }
    public static void Load(long self, long wire) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        OcctGen.occtCall(4436, a, box);
    }
    public static void Load_2(long self, long sbwd) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = sbwd;
        OcctGen.occtCall(4437, a, box);
    }
    public static void SetFace(long self, long face) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = face;
        OcctGen.occtCall(4438, a, box);
    }
    public static void SetSurface(long self, long surf) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = surf;
        OcctGen.occtCall(4439, a, box);
    }
    public static void SetSurface_2(long self, long surf, long loc) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = surf;
        a[2] = loc;
        OcctGen.occtCall(4440, a, box);
    }
    public static void SetPrecision(long self, double prec) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(prec);
        OcctGen.occtCall(4441, a, box);
    }
    public static void SetMaxTailAngle(long self, double theMaxTailAngle) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMaxTailAngle);
        OcctGen.occtCall(4442, a, box);
    }
    public static void SetMaxTailWidth(long self, double theMaxTailWidth) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMaxTailWidth);
        OcctGen.occtCall(4443, a, box);
    }
    public static boolean IsLoaded(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4444, a, box);
        return r != 0;
    }
    public static boolean IsReady(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4445, a, box);
        return r != 0;
    }
    public static int NbEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4446, a, box);
        return (int) r;
    }
    public static long Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4447, a, box);
        return r;
    }
    public static long WireAPIMake(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4448, a, box);
        return r;
    }
    public static long Analyzer(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4449, a, box);
        return r;
    }
    public static long WireData(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4450, a, box);
        return r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4451, a, box);
        return r;
    }
    public static boolean ModifyTopologyMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4452, a, box);
        return r != 0;
    }
    public static boolean ModifyGeometryMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4453, a, box);
        return r != 0;
    }
    public static int ModifyRemoveLoopMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4454, a, box);
        return (int) r;
    }
    public static boolean ClosedWireMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4455, a, box);
        return r != 0;
    }
    public static boolean PreferencePCurveMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4456, a, box);
        return r != 0;
    }
    public static boolean FixGapsByRangesMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4457, a, box);
        return r != 0;
    }
    public static int FixReorderMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4458, a, box);
        return (int) r;
    }
    public static int FixSmallMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4459, a, box);
        return (int) r;
    }
    public static int FixConnectedMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4460, a, box);
        return (int) r;
    }
    public static int FixEdgeCurvesMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4461, a, box);
        return (int) r;
    }
    public static int FixDegeneratedMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4462, a, box);
        return (int) r;
    }
    public static int FixSelfIntersectionMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4463, a, box);
        return (int) r;
    }
    public static int FixLackingMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4464, a, box);
        return (int) r;
    }
    public static int FixGaps3dMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4465, a, box);
        return (int) r;
    }
    public static int FixGaps2dMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4466, a, box);
        return (int) r;
    }
    public static int FixReversed2dMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4467, a, box);
        return (int) r;
    }
    public static int FixRemovePCurveMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4468, a, box);
        return (int) r;
    }
    public static int FixAddPCurveMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4469, a, box);
        return (int) r;
    }
    public static int FixRemoveCurve3dMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4470, a, box);
        return (int) r;
    }
    public static int FixAddCurve3dMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4471, a, box);
        return (int) r;
    }
    public static int FixSeamMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4472, a, box);
        return (int) r;
    }
    public static int FixShiftedMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4473, a, box);
        return (int) r;
    }
    public static int FixSameParameterMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4474, a, box);
        return (int) r;
    }
    public static int FixVertexToleranceMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4475, a, box);
        return (int) r;
    }
    public static int FixNotchedEdgesMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4476, a, box);
        return (int) r;
    }
    public static int FixSelfIntersectingEdgeMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4477, a, box);
        return (int) r;
    }
    public static int FixIntersectingEdgesMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4478, a, box);
        return (int) r;
    }
    public static int FixNonAdjacentIntersectingEdgesMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4479, a, box);
        return (int) r;
    }
    public static int FixTailMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4480, a, box);
        return (int) r;
    }
    public static boolean Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4481, a, box);
        return r != 0;
    }
    public static boolean FixReorder(long self, boolean theModeBoth) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theModeBoth ? 1L : 0L;
        long r = OcctGen.occtCall(4482, a, box);
        return r != 0;
    }
    public static int FixSmall(long self, boolean lockvtx, double precsmall) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = lockvtx ? 1L : 0L;
        a[2] = Double.doubleToRawLongBits(precsmall);
        long r = OcctGen.occtCall(4483, a, box);
        return (int) r;
    }
    public static boolean FixConnected(long self, double prec) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4484, a, box);
        return r != 0;
    }
    public static boolean FixEdgeCurves(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4485, a, box);
        return r != 0;
    }
    public static boolean FixDegenerated(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4486, a, box);
        return r != 0;
    }
    public static boolean FixSelfIntersection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4487, a, box);
        return r != 0;
    }
    public static boolean FixLacking(long self, boolean force) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = force ? 1L : 0L;
        long r = OcctGen.occtCall(4488, a, box);
        return r != 0;
    }
    public static boolean FixClosed(long self, double prec) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4489, a, box);
        return r != 0;
    }
    public static boolean FixGaps3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4490, a, box);
        return r != 0;
    }
    public static boolean FixGaps2d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4491, a, box);
        return r != 0;
    }
    public static boolean FixReorder_2(long self, long wi) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = wi;
        long r = OcctGen.occtCall(4492, a, box);
        return r != 0;
    }
    public static boolean FixSmall_2(long self, int num, boolean lockvtx, double precsmall) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = lockvtx ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(precsmall);
        long r = OcctGen.occtCall(4493, a, box);
        return r != 0;
    }
    public static boolean FixConnected_2(long self, int num, double prec) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = Double.doubleToRawLongBits(prec);
        long r = OcctGen.occtCall(4494, a, box);
        return r != 0;
    }
    public static boolean FixSeam(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4495, a, box);
        return r != 0;
    }
    public static boolean FixShifted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4496, a, box);
        return r != 0;
    }
    public static boolean FixDegenerated_2(long self, int num) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        long r = OcctGen.occtCall(4497, a, box);
        return r != 0;
    }
    public static boolean FixLacking_2(long self, int num, boolean force) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = force ? 1L : 0L;
        long r = OcctGen.occtCall(4498, a, box);
        return r != 0;
    }
    public static boolean FixNotchedEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4499, a, box);
        return r != 0;
    }
    public static boolean FixGap3d(long self, int num, boolean convert) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = convert ? 1L : 0L;
        long r = OcctGen.occtCall(4500, a, box);
        return r != 0;
    }
    public static boolean FixGap2d(long self, int num, boolean convert) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = num;
        a[2] = convert ? 1L : 0L;
        long r = OcctGen.occtCall(4501, a, box);
        return r != 0;
    }
    public static boolean FixTails(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4502, a, box);
        return r != 0;
    }
    public static boolean StatusReorder(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4503, a, box);
        return r != 0;
    }
    public static boolean StatusSmall(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4504, a, box);
        return r != 0;
    }
    public static boolean StatusConnected(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4505, a, box);
        return r != 0;
    }
    public static boolean StatusEdgeCurves(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4506, a, box);
        return r != 0;
    }
    public static boolean StatusDegenerated(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4507, a, box);
        return r != 0;
    }
    public static boolean StatusSelfIntersection(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4508, a, box);
        return r != 0;
    }
    public static boolean StatusLacking(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4509, a, box);
        return r != 0;
    }
    public static boolean StatusClosed(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4510, a, box);
        return r != 0;
    }
    public static boolean StatusGaps3d(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4511, a, box);
        return r != 0;
    }
    public static boolean StatusGaps2d(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4512, a, box);
        return r != 0;
    }
    public static boolean StatusNotches(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4513, a, box);
        return r != 0;
    }
    public static boolean StatusRemovedSegment(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4514, a, box);
        return r != 0;
    }
    public static boolean StatusFixTails(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4515, a, box);
        return r != 0;
    }
    public static boolean LastFixStatus(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4516, a, box);
        return r != 0;
    }
    }

    public static final class ShapeProcess_ShapeContext {
        private ShapeProcess_ShapeContext() {}

    public static long 构造(String file, String seq) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = file;
        box[2] = seq;
        long r = OcctGen.occtCall(4517, a, box);
        return r;
    }
    public static long 构造_2(long S, String file, String seq) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[1] = S;
        box[2] = file;
        box[3] = seq;
        long r = OcctGen.occtCall(4518, a, box);
        return r;
    }
    public static void Init(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(4519, a, box);
    }
    public static long Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4520, a, box);
        return r;
    }
    public static long Result(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4521, a, box);
        return r;
    }
    public static void SetDetalisation(long self, int level) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = level;
        OcctGen.occtCall(4522, a, box);
    }
    public static int GetDetalisation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4523, a, box);
        return (int) r;
    }
    public static void SetResult(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(4524, a, box);
    }
    public static void RecordModification(long self, long repl) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = repl;
        OcctGen.occtCall(4525, a, box);
    }
    public static void RecordModification_2(long self, long repl) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = repl;
        OcctGen.occtCall(4526, a, box);
    }
    public static void RecordModification_3(long self, long sh, long repl) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = sh;
        a[2] = repl;
        OcctGen.occtCall(4527, a, box);
    }
    public static boolean GetContinuity(long self, String param, int[] valOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = param;
        long r = OcctGen.occtCall(4528, a, box);
        if (valOut != null && valOut.length != 0) valOut[0] = (int) a[2];
        return r != 0;
    }
    public static int ContinuityVal(long self, String param, int def) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = param;
        a[2] = def;
        long r = OcctGen.occtCall(4529, a, box);
        return (int) r;
    }
    public static void PrintStatistics(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4530, a, box);
    }
    public static void SetNonManifold(long self, boolean theNonManifold) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theNonManifold ? 1L : 0L;
        OcctGen.occtCall(4531, a, box);
    }
    public static boolean IsNonManifold(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4532, a, box);
        return r != 0;
    }
    }

    public static final class ShapeUpgrade_SplitSurface {
        private ShapeUpgrade_SplitSurface() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4533, a, box);
        return r;
    }
    public static void Init(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(4534, a, box);
    }
    public static void Init_2(
            long self, long S, double UFirst, double ULast, double VFirst, double VLast,
            double theArea) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(UFirst);
        a[3] = Double.doubleToRawLongBits(ULast);
        a[4] = Double.doubleToRawLongBits(VFirst);
        a[5] = Double.doubleToRawLongBits(VLast);
        a[6] = Double.doubleToRawLongBits(theArea);
        OcctGen.occtCall(4535, a, box);
    }
    public static void Build(long self, boolean Segment) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Segment ? 1L : 0L;
        OcctGen.occtCall(4536, a, box);
    }
    public static void Compute(long self, boolean Segment) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Segment ? 1L : 0L;
        OcctGen.occtCall(4537, a, box);
    }
    public static void Perform(long self, boolean Segment) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Segment ? 1L : 0L;
        OcctGen.occtCall(4538, a, box);
    }
    public static boolean Status(long self, int status) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = status;
        long r = OcctGen.occtCall(4539, a, box);
        return r != 0;
    }
    }

    public static final class ShapeUpgrade_UnifySameDomain {
        private ShapeUpgrade_UnifySameDomain() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4540, a, box);
        return r;
    }
    public static long 构造_2(
            long aShape, boolean UnifyEdges, boolean UnifyFaces, boolean ConcatBSplines) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = aShape;
        a[2] = UnifyEdges ? 1L : 0L;
        a[3] = UnifyFaces ? 1L : 0L;
        a[4] = ConcatBSplines ? 1L : 0L;
        long r = OcctGen.occtCall(4541, a, box);
        return r;
    }
    public static void Initialize(
            long self, long aShape, boolean UnifyEdges, boolean UnifyFaces, boolean ConcatBSplines) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = aShape;
        a[2] = UnifyEdges ? 1L : 0L;
        a[3] = UnifyFaces ? 1L : 0L;
        a[4] = ConcatBSplines ? 1L : 0L;
        OcctGen.occtCall(4542, a, box);
    }
    public static void AllowInternalEdges(long self, boolean theValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theValue ? 1L : 0L;
        OcctGen.occtCall(4543, a, box);
    }
    public static void KeepShape(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        OcctGen.occtCall(4544, a, box);
    }
    public static void SetSafeInputMode(long self, boolean theValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theValue ? 1L : 0L;
        OcctGen.occtCall(4545, a, box);
    }
    public static void SetLinearTolerance(long self, double theValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theValue);
        OcctGen.occtCall(4546, a, box);
    }
    public static void SetAngularTolerance(long self, double theValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theValue);
        OcctGen.occtCall(4547, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4548, a, box);
    }
    public static long Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4549, a, box);
        return r;
    }
    public static long History(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4550, a, box);
        return r;
    }
    public static long History_2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4551, a, box);
        return r;
    }
    }

}
