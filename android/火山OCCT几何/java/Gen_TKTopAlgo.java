package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKTopAlgo 类=72 方法槽=735
public final class Gen_TKTopAlgo {
    private Gen_TKTopAlgo() {}

    public static final class BRepBndLib {
        private BRepBndLib() {}

    public static void Add(long S, long B, boolean useTriangulation) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = B;
        a[3] = useTriangulation ? 1L : 0L;
        OcctGen.occtCall(577, a, box);
    }
    public static void AddClose(long S, long B) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S;
        a[2] = B;
        OcctGen.occtCall(578, a, box);
    }
    public static void AddOptimal(
            long S, long B, boolean useTriangulation, boolean useShapeTolerance) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = B;
        a[3] = useTriangulation ? 1L : 0L;
        a[4] = useShapeTolerance ? 1L : 0L;
        OcctGen.occtCall(579, a, box);
    }
    public static void AddOBB(
            long theS, long theOBB, boolean theIsTriangulationUsed, boolean theIsOptimal,
            boolean theIsShapeToleranceUsed) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = theS;
        a[2] = theOBB;
        a[3] = theIsTriangulationUsed ? 1L : 0L;
        a[4] = theIsOptimal ? 1L : 0L;
        a[5] = theIsShapeToleranceUsed ? 1L : 0L;
        OcctGen.occtCall(580, a, box);
    }
    }

    public static final class BRepBuilderAPI_BndBoxTreeSelector {
        private BRepBuilderAPI_BndBoxTreeSelector() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(581, a, box);
        return r;
    }
    public static boolean Reject(long self, long theBox) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theBox;
        long r = OcctGen.occtCall(582, a, box);
        return r != 0;
    }
    public static boolean Accept(long self, int theObj) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theObj;
        long r = OcctGen.occtCall(583, a, box);
        return r != 0;
    }
    public static void ClearResList(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(584, a, box);
    }
    public static void SetCurrent(long self, long theBox) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theBox;
        OcctGen.occtCall(585, a, box);
    }
    }

    public static final class BRepBuilderAPI_Collect {
        private BRepBuilderAPI_Collect() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(586, a, box);
        return r;
    }
    public static void Add(long self, long SI, long MKS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = SI;
        a[2] = MKS;
        OcctGen.occtCall(587, a, box);
    }
    public static void AddGenerated(long self, long S, long Gen) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Gen;
        OcctGen.occtCall(588, a, box);
    }
    public static void AddModif(long self, long S, long Mod) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Mod;
        OcctGen.occtCall(589, a, box);
    }
    public static void Filter(long self, long SF) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = SF;
        OcctGen.occtCall(590, a, box);
    }
    }

    public static final class BRepBuilderAPI_Command {
        private BRepBuilderAPI_Command() {}

    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(591, a, box);
        return r != 0;
    }
    public static void Check(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(592, a, box);
    }
    }

    public static final class BRepBuilderAPI_Copy {
        private BRepBuilderAPI_Copy() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(593, a, box);
        return r;
    }
    public static long 构造_2(long S, boolean copyGeom, boolean copyMesh) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = copyGeom ? 1L : 0L;
        a[3] = copyMesh ? 1L : 0L;
        long r = OcctGen.occtCall(594, a, box);
        return r;
    }
    public static void Perform(long self, long S, boolean copyGeom, boolean copyMesh) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = copyGeom ? 1L : 0L;
        a[3] = copyMesh ? 1L : 0L;
        OcctGen.occtCall(595, a, box);
    }
    }

    public static final class BRepBuilderAPI_FastSewing {
        private BRepBuilderAPI_FastSewing() {}

    public static long 构造(double theTolerance) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theTolerance);
        long r = OcctGen.occtCall(596, a, box);
        return r;
    }
    public static boolean Add(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        long r = OcctGen.occtCall(597, a, box);
        return r != 0;
    }
    public static boolean Add_2(long self, long theSurface) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        long r = OcctGen.occtCall(598, a, box);
        return r != 0;
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(599, a, box);
    }
    public static void SetTolerance(long self, double theToler) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theToler);
        OcctGen.occtCall(600, a, box);
    }
    public static double GetTolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(601, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long GetResult(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(602, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_FindPlane {
        private BRepBuilderAPI_FindPlane() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(603, a, box);
        return r;
    }
    public static long 构造_2(long S, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(604, a, box);
        return r;
    }
    public static void Init(long self, long S, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(605, a, box);
    }
    public static boolean Found(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(606, a, box);
        return r != 0;
    }
    public static long Plane(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(607, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_GTransform {
        private BRepBuilderAPI_GTransform() {}

    public static long 构造(long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = T;
        long r = OcctGen.occtCall(608, a, box);
        return r;
    }
    public static long 构造_2(long S, long T, boolean Copy) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = T;
        a[3] = Copy ? 1L : 0L;
        long r = OcctGen.occtCall(609, a, box);
        return r;
    }
    public static void Perform(long self, long S, boolean Copy) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Copy ? 1L : 0L;
        OcctGen.occtCall(610, a, box);
    }
    public static long ModifiedShape(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(611, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_MakeEdge {
        private BRepBuilderAPI_MakeEdge() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(612, a, box);
        return r;
    }
    public static long 构造_2(long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = V1;
        a[2] = V2;
        long r = OcctGen.occtCall(613, a, box);
        return r;
    }
    public static long 构造_3(long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(614, a, box);
        return r;
    }
    public static long 构造_4(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(615, a, box);
        return r;
    }
    public static long 构造_5(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(616, a, box);
        return r;
    }
    public static long 构造_6(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(617, a, box);
        return r;
    }
    public static long 构造_7(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(618, a, box);
        return r;
    }
    public static long 构造_8(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(619, a, box);
        return r;
    }
    public static long 构造_9(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(620, a, box);
        return r;
    }
    public static long 构造_10(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(621, a, box);
        return r;
    }
    public static long 构造_11(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(622, a, box);
        return r;
    }
    public static long 构造_12(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(623, a, box);
        return r;
    }
    public static long 构造_13(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(624, a, box);
        return r;
    }
    public static long 构造_14(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(625, a, box);
        return r;
    }
    public static long 构造_15(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(626, a, box);
        return r;
    }
    public static long 构造_16(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(627, a, box);
        return r;
    }
    public static long 构造_17(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(628, a, box);
        return r;
    }
    public static long 构造_18(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(629, a, box);
        return r;
    }
    public static long 构造_19(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(630, a, box);
        return r;
    }
    public static long 构造_20(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(631, a, box);
        return r;
    }
    public static long 构造_21(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(632, a, box);
        return r;
    }
    public static long 构造_22(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(633, a, box);
        return r;
    }
    public static long 构造_23(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(634, a, box);
        return r;
    }
    public static long 构造_24(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(635, a, box);
        return r;
    }
    public static long 构造_25(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(636, a, box);
        return r;
    }
    public static long 构造_26(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(637, a, box);
        return r;
    }
    public static long 构造_27(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(638, a, box);
        return r;
    }
    public static long 构造_28(long L, long P1, long P2, double p1, double p2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        a[4] = Double.doubleToRawLongBits(p1);
        a[5] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(639, a, box);
        return r;
    }
    public static long 构造_29(long L, long V1, long V2, double p1, double p2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        a[4] = Double.doubleToRawLongBits(p1);
        a[5] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(640, a, box);
        return r;
    }
    public static long 构造_30(long L, long S) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = L;
        a[2] = S;
        long r = OcctGen.occtCall(641, a, box);
        return r;
    }
    public static long 构造_31(long L, long S, double p1, double p2) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = L;
        a[2] = S;
        a[3] = Double.doubleToRawLongBits(p1);
        a[4] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(642, a, box);
        return r;
    }
    public static long 构造_32(long L, long S, long P1, long P2) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = L;
        a[2] = S;
        a[3] = P1;
        a[4] = P2;
        long r = OcctGen.occtCall(643, a, box);
        return r;
    }
    public static long 构造_33(long L, long S, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = L;
        a[2] = S;
        a[3] = V1;
        a[4] = V2;
        long r = OcctGen.occtCall(644, a, box);
        return r;
    }
    public static long 构造_34(long L, long S, long P1, long P2, double p1, double p2) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = L;
        a[2] = S;
        a[3] = P1;
        a[4] = P2;
        a[5] = Double.doubleToRawLongBits(p1);
        a[6] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(645, a, box);
        return r;
    }
    public static long 构造_35(long L, long S, long V1, long V2, double p1, double p2) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = L;
        a[2] = S;
        a[3] = V1;
        a[4] = V2;
        a[5] = Double.doubleToRawLongBits(p1);
        a[6] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(646, a, box);
        return r;
    }
    public static void Init(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(647, a, box);
    }
    public static void Init_2(long self, long C, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(648, a, box);
    }
    public static void Init_3(long self, long C, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = P1;
        a[3] = P2;
        OcctGen.occtCall(649, a, box);
    }
    public static void Init_4(long self, long C, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = V1;
        a[3] = V2;
        OcctGen.occtCall(650, a, box);
    }
    public static void Init_5(long self, long C, long P1, long P2, double p1, double p2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = P1;
        a[3] = P2;
        a[4] = Double.doubleToRawLongBits(p1);
        a[5] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(651, a, box);
    }
    public static void Init_6(long self, long C, long V1, long V2, double p1, double p2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = V1;
        a[3] = V2;
        a[4] = Double.doubleToRawLongBits(p1);
        a[5] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(652, a, box);
    }
    public static void Init_7(long self, long C, long S) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = S;
        OcctGen.occtCall(653, a, box);
    }
    public static void Init_8(long self, long C, long S, double p1, double p2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = S;
        a[3] = Double.doubleToRawLongBits(p1);
        a[4] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(654, a, box);
    }
    public static void Init_9(long self, long C, long S, long P1, long P2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = S;
        a[3] = P1;
        a[4] = P2;
        OcctGen.occtCall(655, a, box);
    }
    public static void Init_10(long self, long C, long S, long V1, long V2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = S;
        a[3] = V1;
        a[4] = V2;
        OcctGen.occtCall(656, a, box);
    }
    public static void Init_11(long self, long C, long S, long P1, long P2, double p1, double p2) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = S;
        a[3] = P1;
        a[4] = P2;
        a[5] = Double.doubleToRawLongBits(p1);
        a[6] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(657, a, box);
    }
    public static void Init_12(long self, long C, long S, long V1, long V2, double p1, double p2) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = S;
        a[3] = V1;
        a[4] = V2;
        a[5] = Double.doubleToRawLongBits(p1);
        a[6] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(658, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(659, a, box);
        return r != 0;
    }
    public static int Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(660, a, box);
        return (int) r;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(661, a, box);
        return r;
    }
    public static long 转TopoDS_Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(662, a, box);
        return r;
    }
    public static long Vertex1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(663, a, box);
        return r;
    }
    public static long Vertex2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(664, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_MakeEdge2d {
        private BRepBuilderAPI_MakeEdge2d() {}

    public static long 构造(long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = V1;
        a[2] = V2;
        long r = OcctGen.occtCall(665, a, box);
        return r;
    }
    public static long 构造_2(long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(666, a, box);
        return r;
    }
    public static long 构造_3(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(667, a, box);
        return r;
    }
    public static long 构造_4(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(668, a, box);
        return r;
    }
    public static long 构造_5(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(669, a, box);
        return r;
    }
    public static long 构造_6(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(670, a, box);
        return r;
    }
    public static long 构造_7(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(671, a, box);
        return r;
    }
    public static long 构造_8(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(672, a, box);
        return r;
    }
    public static long 构造_9(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(673, a, box);
        return r;
    }
    public static long 构造_10(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(674, a, box);
        return r;
    }
    public static long 构造_11(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(675, a, box);
        return r;
    }
    public static long 构造_12(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(676, a, box);
        return r;
    }
    public static long 构造_13(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(677, a, box);
        return r;
    }
    public static long 构造_14(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(678, a, box);
        return r;
    }
    public static long 构造_15(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(679, a, box);
        return r;
    }
    public static long 构造_16(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(680, a, box);
        return r;
    }
    public static long 构造_17(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(681, a, box);
        return r;
    }
    public static long 构造_18(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(682, a, box);
        return r;
    }
    public static long 构造_19(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(683, a, box);
        return r;
    }
    public static long 构造_20(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(684, a, box);
        return r;
    }
    public static long 构造_21(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(685, a, box);
        return r;
    }
    public static long 构造_22(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(686, a, box);
        return r;
    }
    public static long 构造_23(long L) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = L;
        long r = OcctGen.occtCall(687, a, box);
        return r;
    }
    public static long 构造_24(long L, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(688, a, box);
        return r;
    }
    public static long 构造_25(long L, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        long r = OcctGen.occtCall(689, a, box);
        return r;
    }
    public static long 构造_26(long L, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        long r = OcctGen.occtCall(690, a, box);
        return r;
    }
    public static long 构造_27(long L, long P1, long P2, double p1, double p2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = L;
        a[2] = P1;
        a[3] = P2;
        a[4] = Double.doubleToRawLongBits(p1);
        a[5] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(691, a, box);
        return r;
    }
    public static long 构造_28(long L, long V1, long V2, double p1, double p2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = L;
        a[2] = V1;
        a[3] = V2;
        a[4] = Double.doubleToRawLongBits(p1);
        a[5] = Double.doubleToRawLongBits(p2);
        long r = OcctGen.occtCall(692, a, box);
        return r;
    }
    public static void Init(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(693, a, box);
    }
    public static void Init_2(long self, long C, double p1, double p2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(p1);
        a[3] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(694, a, box);
    }
    public static void Init_3(long self, long C, long P1, long P2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = P1;
        a[3] = P2;
        OcctGen.occtCall(695, a, box);
    }
    public static void Init_4(long self, long C, long V1, long V2) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = V1;
        a[3] = V2;
        OcctGen.occtCall(696, a, box);
    }
    public static void Init_5(long self, long C, long P1, long P2, double p1, double p2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = P1;
        a[3] = P2;
        a[4] = Double.doubleToRawLongBits(p1);
        a[5] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(697, a, box);
    }
    public static void Init_6(long self, long C, long V1, long V2, double p1, double p2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = V1;
        a[3] = V2;
        a[4] = Double.doubleToRawLongBits(p1);
        a[5] = Double.doubleToRawLongBits(p2);
        OcctGen.occtCall(698, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(699, a, box);
        return r != 0;
    }
    public static int Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(700, a, box);
        return (int) r;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(701, a, box);
        return r;
    }
    public static long 转TopoDS_Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(702, a, box);
        return r;
    }
    public static long Vertex1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(703, a, box);
        return r;
    }
    public static long Vertex2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(704, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_MakeFace {
        private BRepBuilderAPI_MakeFace() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(705, a, box);
        return r;
    }
    public static long 构造_2(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        long r = OcctGen.occtCall(706, a, box);
        return r;
    }
    public static long 构造_3(long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = P;
        long r = OcctGen.occtCall(707, a, box);
        return r;
    }
    public static long 构造_4(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(708, a, box);
        return r;
    }
    public static long 构造_5(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(709, a, box);
        return r;
    }
    public static long 构造_6(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(710, a, box);
        return r;
    }
    public static long 构造_7(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(711, a, box);
        return r;
    }
    public static long 构造_8(long S, double TolDegen) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(TolDegen);
        long r = OcctGen.occtCall(712, a, box);
        return r;
    }
    public static long 构造_9(long P, double UMin, double UMax, double VMin, double VMax) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        long r = OcctGen.occtCall(713, a, box);
        return r;
    }
    public static long 构造_10(long C, double UMin, double UMax, double VMin, double VMax) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        long r = OcctGen.occtCall(714, a, box);
        return r;
    }
    public static long 构造_11(long C, double UMin, double UMax, double VMin, double VMax) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        long r = OcctGen.occtCall(715, a, box);
        return r;
    }
    public static long 构造_12(long S, double UMin, double UMax, double VMin, double VMax) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        long r = OcctGen.occtCall(716, a, box);
        return r;
    }
    public static long 构造_13(long C, double UMin, double UMax, double VMin, double VMax) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        long r = OcctGen.occtCall(717, a, box);
        return r;
    }
    public static long 构造_14(
            long S, double UMin, double UMax, double VMin, double VMax, double TolDegen) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        a[6] = Double.doubleToRawLongBits(TolDegen);
        long r = OcctGen.occtCall(718, a, box);
        return r;
    }
    public static long 构造_15(long W, boolean OnlyPlane) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = W;
        a[2] = OnlyPlane ? 1L : 0L;
        long r = OcctGen.occtCall(719, a, box);
        return r;
    }
    public static long 构造_16(long P, long W, boolean Inside) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = P;
        a[2] = W;
        a[3] = Inside ? 1L : 0L;
        long r = OcctGen.occtCall(720, a, box);
        return r;
    }
    public static long 构造_17(long C, long W, boolean Inside) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = W;
        a[3] = Inside ? 1L : 0L;
        long r = OcctGen.occtCall(721, a, box);
        return r;
    }
    public static long 构造_18(long C, long W, boolean Inside) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = W;
        a[3] = Inside ? 1L : 0L;
        long r = OcctGen.occtCall(722, a, box);
        return r;
    }
    public static long 构造_19(long S, long W, boolean Inside) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = W;
        a[3] = Inside ? 1L : 0L;
        long r = OcctGen.occtCall(723, a, box);
        return r;
    }
    public static long 构造_20(long C, long W, boolean Inside) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = C;
        a[2] = W;
        a[3] = Inside ? 1L : 0L;
        long r = OcctGen.occtCall(724, a, box);
        return r;
    }
    public static long 构造_21(long S, long W, boolean Inside) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = W;
        a[3] = Inside ? 1L : 0L;
        long r = OcctGen.occtCall(725, a, box);
        return r;
    }
    public static long 构造_22(long F, long W) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = F;
        a[2] = W;
        long r = OcctGen.occtCall(726, a, box);
        return r;
    }
    public static void Init(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        OcctGen.occtCall(727, a, box);
    }
    public static void Init_2(long self, long S, boolean Bound, double TolDegen) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Bound ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(TolDegen);
        OcctGen.occtCall(728, a, box);
    }
    public static void Init_3(
            long self, long S, double UMin, double UMax, double VMin, double VMax, double TolDegen) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        a[6] = Double.doubleToRawLongBits(TolDegen);
        OcctGen.occtCall(729, a, box);
    }
    public static void Add(long self, long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        OcctGen.occtCall(730, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(731, a, box);
        return r != 0;
    }
    public static int Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(732, a, box);
        return (int) r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(733, a, box);
        return r;
    }
    public static long 转TopoDS_Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(734, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_MakePolygon {
        private BRepBuilderAPI_MakePolygon() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(735, a, box);
        return r;
    }
    public static long 构造_2(long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(736, a, box);
        return r;
    }
    public static long 构造_3(long P1, long P2, long P3, boolean Close) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = P1;
        a[2] = P2;
        a[3] = P3;
        a[4] = Close ? 1L : 0L;
        long r = OcctGen.occtCall(737, a, box);
        return r;
    }
    public static long 构造_4(long P1, long P2, long P3, long P4, boolean Close) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = P1;
        a[2] = P2;
        a[3] = P3;
        a[4] = P4;
        a[5] = Close ? 1L : 0L;
        long r = OcctGen.occtCall(738, a, box);
        return r;
    }
    public static long 构造_5(long V1, long V2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = V1;
        a[2] = V2;
        long r = OcctGen.occtCall(739, a, box);
        return r;
    }
    public static long 构造_6(long V1, long V2, long V3, boolean Close) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = V1;
        a[2] = V2;
        a[3] = V3;
        a[4] = Close ? 1L : 0L;
        long r = OcctGen.occtCall(740, a, box);
        return r;
    }
    public static long 构造_7(long V1, long V2, long V3, long V4, boolean Close) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = V1;
        a[2] = V2;
        a[3] = V3;
        a[4] = V4;
        a[5] = Close ? 1L : 0L;
        long r = OcctGen.occtCall(741, a, box);
        return r;
    }
    public static void Add(long self, long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(742, a, box);
    }
    public static void Add_2(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(743, a, box);
    }
    public static boolean Added(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(744, a, box);
        return r != 0;
    }
    public static void Close(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(745, a, box);
    }
    public static long FirstVertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(746, a, box);
        return r;
    }
    public static long LastVertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(747, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(748, a, box);
        return r != 0;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(749, a, box);
        return r;
    }
    public static long 转TopoDS_Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(750, a, box);
        return r;
    }
    public static long Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(751, a, box);
        return r;
    }
    public static long 转TopoDS_Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(752, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_MakeShape {
        private BRepBuilderAPI_MakeShape() {}

    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(753, a, box);
    }
    public static long Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(754, a, box);
        return r;
    }
    public static long 转TopoDS_Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(755, a, box);
        return r;
    }
    public static boolean IsDeleted(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(756, a, box);
        return r != 0;
    }
    }

    public static final class BRepBuilderAPI_MakeShapeOnMesh {
        private BRepBuilderAPI_MakeShapeOnMesh() {}

    public static long 构造(long theMesh) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theMesh;
        long r = OcctGen.occtCall(757, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(758, a, box);
    }
    }

    public static final class BRepBuilderAPI_MakeShell {
        private BRepBuilderAPI_MakeShell() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(759, a, box);
        return r;
    }
    public static long 构造_2(long S, boolean Segment) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S;
        a[2] = Segment ? 1L : 0L;
        long r = OcctGen.occtCall(760, a, box);
        return r;
    }
    public static long 构造_3(
            long S, double UMin, double UMax, double VMin, double VMax, boolean Segment) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        a[6] = Segment ? 1L : 0L;
        long r = OcctGen.occtCall(761, a, box);
        return r;
    }
    public static void Init(
            long self, long S, double UMin, double UMax, double VMin, double VMax, boolean Segment) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(UMin);
        a[3] = Double.doubleToRawLongBits(UMax);
        a[4] = Double.doubleToRawLongBits(VMin);
        a[5] = Double.doubleToRawLongBits(VMax);
        a[6] = Segment ? 1L : 0L;
        OcctGen.occtCall(762, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(763, a, box);
        return r != 0;
    }
    public static int Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(764, a, box);
        return (int) r;
    }
    public static long Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(765, a, box);
        return r;
    }
    public static long 转TopoDS_Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(766, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_MakeSolid {
        private BRepBuilderAPI_MakeSolid() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(767, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(768, a, box);
        return r;
    }
    public static long 构造_3(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(769, a, box);
        return r;
    }
    public static long 构造_4(long S1, long S2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        long r = OcctGen.occtCall(770, a, box);
        return r;
    }
    public static long 构造_5(long S1, long S2, long S3) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        a[3] = S3;
        long r = OcctGen.occtCall(771, a, box);
        return r;
    }
    public static long 构造_6(long So) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = So;
        long r = OcctGen.occtCall(772, a, box);
        return r;
    }
    public static long 构造_7(long So, long S) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = So;
        a[2] = S;
        long r = OcctGen.occtCall(773, a, box);
        return r;
    }
    public static void Add(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(774, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(775, a, box);
        return r != 0;
    }
    public static long Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(776, a, box);
        return r;
    }
    public static long 转TopoDS_Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(777, a, box);
        return r;
    }
    public static boolean IsDeleted(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(778, a, box);
        return r != 0;
    }
    }

    public static final class BRepBuilderAPI_MakeVertex {
        private BRepBuilderAPI_MakeVertex() {}

    public static long 构造(long P) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = P;
        long r = OcctGen.occtCall(779, a, box);
        return r;
    }
    public static long Vertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(780, a, box);
        return r;
    }
    public static long 转TopoDS_Vertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(781, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_MakeWire {
        private BRepBuilderAPI_MakeWire() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(782, a, box);
        return r;
    }
    public static long 构造_2(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(783, a, box);
        return r;
    }
    public static long 构造_3(long E1, long E2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        long r = OcctGen.occtCall(784, a, box);
        return r;
    }
    public static long 构造_4(long E1, long E2, long E3) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        a[3] = E3;
        long r = OcctGen.occtCall(785, a, box);
        return r;
    }
    public static long 构造_5(long E1, long E2, long E3, long E4) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        a[3] = E3;
        a[4] = E4;
        long r = OcctGen.occtCall(786, a, box);
        return r;
    }
    public static long 构造_6(long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = W;
        long r = OcctGen.occtCall(787, a, box);
        return r;
    }
    public static long 构造_7(long W, long E) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = W;
        a[2] = E;
        long r = OcctGen.occtCall(788, a, box);
        return r;
    }
    public static void Add(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(789, a, box);
    }
    public static void Add_2(long self, long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        OcctGen.occtCall(790, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(791, a, box);
        return r != 0;
    }
    public static int Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(792, a, box);
        return (int) r;
    }
    public static long Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(793, a, box);
        return r;
    }
    public static long 转TopoDS_Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(794, a, box);
        return r;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(795, a, box);
        return r;
    }
    public static long Vertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(796, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_ModifyShape {
        private BRepBuilderAPI_ModifyShape() {}

    public static long ModifiedShape(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(797, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_NurbsConvert {
        private BRepBuilderAPI_NurbsConvert() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(798, a, box);
        return r;
    }
    public static long 构造_2(long S, boolean Copy) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S;
        a[2] = Copy ? 1L : 0L;
        long r = OcctGen.occtCall(799, a, box);
        return r;
    }
    public static void Perform(long self, long S, boolean Copy) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Copy ? 1L : 0L;
        OcctGen.occtCall(800, a, box);
    }
    public static long ModifiedShape(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(801, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_Sewing {
        private BRepBuilderAPI_Sewing() {}

    public static long 构造(
            double tolerance, boolean option1, boolean option2, boolean option3, boolean option4) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(tolerance);
        a[2] = option1 ? 1L : 0L;
        a[3] = option2 ? 1L : 0L;
        a[4] = option3 ? 1L : 0L;
        a[5] = option4 ? 1L : 0L;
        long r = OcctGen.occtCall(802, a, box);
        return r;
    }
    public static void Init(
            long self, double tolerance, boolean option1, boolean option2, boolean option3,
            boolean option4) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(tolerance);
        a[2] = option1 ? 1L : 0L;
        a[3] = option2 ? 1L : 0L;
        a[4] = option3 ? 1L : 0L;
        a[5] = option4 ? 1L : 0L;
        OcctGen.occtCall(803, a, box);
    }
    public static void Load(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        OcctGen.occtCall(804, a, box);
    }
    public static void Add(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        OcctGen.occtCall(805, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(806, a, box);
    }
    public static long SewedShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(807, a, box);
        return r;
    }
    public static void SetContext(long self, long theContext) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theContext;
        OcctGen.occtCall(808, a, box);
    }
    public static long GetContext(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(809, a, box);
        return r;
    }
    public static int NbFreeEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(810, a, box);
        return (int) r;
    }
    public static long FreeEdge(long self, int index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = index;
        long r = OcctGen.occtCall(811, a, box);
        return r;
    }
    public static int NbMultipleEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(812, a, box);
        return (int) r;
    }
    public static long MultipleEdge(long self, int index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = index;
        long r = OcctGen.occtCall(813, a, box);
        return r;
    }
    public static int NbContigousEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(814, a, box);
        return (int) r;
    }
    public static long ContigousEdge(long self, int index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = index;
        long r = OcctGen.occtCall(815, a, box);
        return r;
    }
    public static boolean IsSectionBound(long self, long section) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = section;
        long r = OcctGen.occtCall(816, a, box);
        return r != 0;
    }
    public static long SectionToBoundary(long self, long section) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = section;
        long r = OcctGen.occtCall(817, a, box);
        return r;
    }
    public static int NbDegeneratedShapes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(818, a, box);
        return (int) r;
    }
    public static long DegeneratedShape(long self, int index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = index;
        long r = OcctGen.occtCall(819, a, box);
        return r;
    }
    public static boolean IsDegenerated(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(820, a, box);
        return r != 0;
    }
    public static boolean IsModified(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(821, a, box);
        return r != 0;
    }
    public static long Modified(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(822, a, box);
        return r;
    }
    public static boolean IsModifiedSubShape(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(823, a, box);
        return r != 0;
    }
    public static long ModifiedSubShape(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(824, a, box);
        return r;
    }
    public static void Dump(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(825, a, box);
    }
    public static int NbDeletedFaces(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(826, a, box);
        return (int) r;
    }
    public static long DeletedFace(long self, int index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = index;
        long r = OcctGen.occtCall(827, a, box);
        return r;
    }
    public static long WhichFace(long self, long theEdg, int index) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theEdg;
        a[2] = index;
        long r = OcctGen.occtCall(828, a, box);
        return r;
    }
    public static boolean SameParameterMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(829, a, box);
        return r != 0;
    }
    public static void SetSameParameterMode(long self, boolean SameParameterMode) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = SameParameterMode ? 1L : 0L;
        OcctGen.occtCall(830, a, box);
    }
    public static double Tolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(831, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetTolerance(long self, double theToler) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theToler);
        OcctGen.occtCall(832, a, box);
    }
    public static double MinTolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(833, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetMinTolerance(long self, double theMinToler) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMinToler);
        OcctGen.occtCall(834, a, box);
    }
    public static double MaxTolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(835, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetMaxTolerance(long self, double theMaxToler) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theMaxToler);
        OcctGen.occtCall(836, a, box);
    }
    public static boolean FaceMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(837, a, box);
        return r != 0;
    }
    public static void SetFaceMode(long self, boolean theFaceMode) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theFaceMode ? 1L : 0L;
        OcctGen.occtCall(838, a, box);
    }
    public static boolean FloatingEdgesMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(839, a, box);
        return r != 0;
    }
    public static void SetFloatingEdgesMode(long self, boolean theFloatingEdgesMode) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theFloatingEdgesMode ? 1L : 0L;
        OcctGen.occtCall(840, a, box);
    }
    public static boolean LocalTolerancesMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(841, a, box);
        return r != 0;
    }
    public static void SetLocalTolerancesMode(long self, boolean theLocalTolerancesMode) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLocalTolerancesMode ? 1L : 0L;
        OcctGen.occtCall(842, a, box);
    }
    public static void SetNonManifoldMode(long self, boolean theNonManifoldMode) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theNonManifoldMode ? 1L : 0L;
        OcctGen.occtCall(843, a, box);
    }
    public static boolean NonManifoldMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(844, a, box);
        return r != 0;
    }
    }

    public static final class BRepBuilderAPI_Transform {
        private BRepBuilderAPI_Transform() {}

    public static long 构造(long T) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = T;
        long r = OcctGen.occtCall(845, a, box);
        return r;
    }
    public static long 构造_2(long theShape, long theTrsf, boolean theCopyGeom, boolean theCopyMesh) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theShape;
        a[2] = theTrsf;
        a[3] = theCopyGeom ? 1L : 0L;
        a[4] = theCopyMesh ? 1L : 0L;
        long r = OcctGen.occtCall(846, a, box);
        return r;
    }
    public static void Perform(long self, long theShape, boolean theCopyGeom, boolean theCopyMesh) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        a[2] = theCopyGeom ? 1L : 0L;
        a[3] = theCopyMesh ? 1L : 0L;
        OcctGen.occtCall(847, a, box);
    }
    public static long ModifiedShape(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(848, a, box);
        return r;
    }
    }

    public static final class BRepBuilderAPI_VertexInspector {
        private BRepBuilderAPI_VertexInspector() {}

    public static long 构造(double theTol) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theTol);
        long r = OcctGen.occtCall(849, a, box);
        return r;
    }
    public static void Add(long self, long thePnt) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = thePnt;
        OcctGen.occtCall(850, a, box);
    }
    public static void ClearResList(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(851, a, box);
    }
    public static void SetCurrent(long self, long theCurPnt) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCurPnt;
        OcctGen.occtCall(852, a, box);
    }
    public static int Inspect(long self, int theTarget) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theTarget;
        long r = OcctGen.occtCall(853, a, box);
        return (int) r;
    }
    }

    public static final class BRepCheck_Analyzer {
        private BRepCheck_Analyzer() {}

    public static long 构造(long S, boolean GeomControls, boolean theIsParallel, boolean theIsExact) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = GeomControls ? 1L : 0L;
        a[3] = theIsParallel ? 1L : 0L;
        a[4] = theIsExact ? 1L : 0L;
        long r = OcctGen.occtCall(854, a, box);
        return r;
    }
    public static void Init(long self, long S, boolean GeomControls) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = GeomControls ? 1L : 0L;
        OcctGen.occtCall(855, a, box);
    }
    public static void SetExactMethod(long self, boolean theIsExact) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsExact ? 1L : 0L;
        OcctGen.occtCall(856, a, box);
    }
    public static boolean IsExactMethod(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(857, a, box);
        return r != 0;
    }
    public static void SetParallel(long self, boolean theIsParallel) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsParallel ? 1L : 0L;
        OcctGen.occtCall(858, a, box);
    }
    public static boolean IsParallel(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(859, a, box);
        return r != 0;
    }
    public static boolean IsValid(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(860, a, box);
        return r != 0;
    }
    public static boolean IsValid_2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(861, a, box);
        return r != 0;
    }
    }

    public static final class BRepClass3d_BndBoxTreeSelectorLine {
        private BRepClass3d_BndBoxTreeSelectorLine() {}

    public static boolean Reject(long self, long theBox) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theBox;
        long r = OcctGen.occtCall(862, a, box);
        return r != 0;
    }
    public static boolean Accept(long self, int theObj) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theObj;
        long r = OcctGen.occtCall(863, a, box);
        return r != 0;
    }
    public static void SetCurrentLine(long self, long theL, double theMaxParam) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theL;
        a[2] = Double.doubleToRawLongBits(theMaxParam);
        OcctGen.occtCall(864, a, box);
    }
    public static void GetEdgeParam(
            long self, int i, long theOutE, double[] theOutParamOut, double[] outLParamOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = i;
        a[2] = theOutE;
        OcctGen.occtCall(865, a, box);
        if (theOutParamOut != null && theOutParamOut.length != 0) theOutParamOut[0] = Double.longBitsToDouble(a[3]);
        if (outLParamOut != null && outLParamOut.length != 0) outLParamOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static void GetVertParam(long self, int i, long theOutV, double[] outLParamOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = i;
        a[2] = theOutV;
        OcctGen.occtCall(866, a, box);
        if (outLParamOut != null && outLParamOut.length != 0) outLParamOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static int GetNbEdgeParam(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(867, a, box);
        return (int) r;
    }
    public static int GetNbVertParam(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(868, a, box);
        return (int) r;
    }
    public static void ClearResults(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(869, a, box);
    }
    public static boolean IsCorrect(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(870, a, box);
        return r != 0;
    }
    }

    public static final class BRepClass3d_BndBoxTreeSelectorPoint {
        private BRepClass3d_BndBoxTreeSelectorPoint() {}

    public static boolean Reject(long self, long theBox) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theBox;
        long r = OcctGen.occtCall(871, a, box);
        return r != 0;
    }
    public static boolean Accept(long self, int theObj) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theObj;
        long r = OcctGen.occtCall(872, a, box);
        return r != 0;
    }
    public static void SetCurrentPoint(long self, long theP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theP;
        OcctGen.occtCall(873, a, box);
    }
    }

    public static final class BRepClass3d_Intersector3d {
        private BRepClass3d_Intersector3d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(874, a, box);
        return r;
    }
    public static void Perform(long self, long L, double Prm, double Tol, long F) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(Prm);
        a[3] = Double.doubleToRawLongBits(Tol);
        a[4] = F;
        OcctGen.occtCall(875, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(876, a, box);
        return r != 0;
    }
    public static boolean HasAPoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(877, a, box);
        return r != 0;
    }
    public static double UParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(878, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(879, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double WParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(880, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Pnt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(881, a, box);
        return r;
    }
    public static int Transition(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(882, a, box);
        return (int) r;
    }
    public static int State(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(883, a, box);
        return (int) r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(884, a, box);
        return r;
    }
    }

    public static final class BRepClass3d_SClassifier {
        private BRepClass3d_SClassifier() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(885, a, box);
        return r;
    }
    public static boolean Rejected(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(886, a, box);
        return r != 0;
    }
    public static int State(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(887, a, box);
        return (int) r;
    }
    public static boolean IsOnAFace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(888, a, box);
        return r != 0;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(889, a, box);
        return r;
    }
    }

    public static final class BRepClass3d_SolidClassifier {
        private BRepClass3d_SolidClassifier() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(890, a, box);
        return r;
    }
    public static void Load(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(891, a, box);
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(892, a, box);
        return r;
    }
    public static long 构造_3(long S, long P, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = P;
        a[3] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(893, a, box);
        return r;
    }
    public static void Perform(long self, long P, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(894, a, box);
    }
    public static void PerformInfinitePoint(long self, double Tol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(895, a, box);
    }
    public static void Destroy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(896, a, box);
    }
    }

    public static final class BRepClass3d_SolidPassiveClassifier {
        private BRepClass3d_SolidPassiveClassifier() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(897, a, box);
        return r;
    }
    public static void Reset(long self, long L, double P, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(P);
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(898, a, box);
    }
    public static void Compare(long self, long F, int Or) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = Or;
        OcctGen.occtCall(899, a, box);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(900, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean HasIntersection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(901, a, box);
        return r != 0;
    }
    public static long Intersector(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(902, a, box);
        return r;
    }
    public static int State(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(903, a, box);
        return (int) r;
    }
    }

    public static final class BRepClass_Edge {
        private BRepClass_Edge() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(904, a, box);
        return r;
    }
    public static long 构造_2(long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        long r = OcctGen.occtCall(905, a, box);
        return r;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(906, a, box);
        return r;
    }
    public static long Edge_2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(907, a, box);
        return r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(908, a, box);
        return r;
    }
    public static long Face_2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(909, a, box);
        return r;
    }
    public static long NextEdge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(910, a, box);
        return r;
    }
    public static double MaxTolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(911, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetMaxTolerance(long self, double theValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theValue);
        OcctGen.occtCall(912, a, box);
    }
    public static boolean UseBndBox(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(913, a, box);
        return r != 0;
    }
    public static void SetUseBndBox(long self, boolean theValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theValue ? 1L : 0L;
        OcctGen.occtCall(914, a, box);
    }
    }

    public static final class BRepClass_FClass2dOfFClassifier {
        private BRepClass_FClass2dOfFClassifier() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(915, a, box);
        return r;
    }
    public static void Reset(long self, long L, double P, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(P);
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(916, a, box);
    }
    public static void Compare(long self, long E, int Or) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = Or;
        OcctGen.occtCall(917, a, box);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(918, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Intersector(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(919, a, box);
        return r;
    }
    public static int ClosestIntersection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(920, a, box);
        return (int) r;
    }
    public static int State(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(921, a, box);
        return (int) r;
    }
    public static boolean IsHeadOrEnd(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(922, a, box);
        return r != 0;
    }
    }

    public static final class BRepClass_FClassifier {
        private BRepClass_FClassifier() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(923, a, box);
        return r;
    }
    public static int State(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(924, a, box);
        return (int) r;
    }
    public static boolean Rejected(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(925, a, box);
        return r != 0;
    }
    public static boolean NoWires(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(926, a, box);
        return r != 0;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(927, a, box);
        return r;
    }
    public static double EdgeParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(928, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Position(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(929, a, box);
        return (int) r;
    }
    }

    public static final class BRepClass_FaceClassifier {
        private BRepClass_FaceClassifier() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(930, a, box);
        return r;
    }
    public static long 构造_2(
            long theF, long theP, double theTol, boolean theUseBndBox, double theGapCheckTol) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = theF;
        a[2] = theP;
        a[3] = Double.doubleToRawLongBits(theTol);
        a[4] = theUseBndBox ? 1L : 0L;
        a[5] = Double.doubleToRawLongBits(theGapCheckTol);
        long r = OcctGen.occtCall(931, a, box);
        return r;
    }
    public static void Perform(
            long self, long theF, long theP, double theTol, boolean theUseBndBox,
            double theGapCheckTol) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = theF;
        a[2] = theP;
        a[3] = Double.doubleToRawLongBits(theTol);
        a[4] = theUseBndBox ? 1L : 0L;
        a[5] = Double.doubleToRawLongBits(theGapCheckTol);
        OcctGen.occtCall(932, a, box);
    }
    public static long 构造_3(
            long theF, long theP, double theTol, boolean theUseBndBox, double theGapCheckTol) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = theF;
        a[2] = theP;
        a[3] = Double.doubleToRawLongBits(theTol);
        a[4] = theUseBndBox ? 1L : 0L;
        a[5] = Double.doubleToRawLongBits(theGapCheckTol);
        long r = OcctGen.occtCall(933, a, box);
        return r;
    }
    public static void Perform_2(
            long self, long theF, long theP, double theTol, boolean theUseBndBox,
            double theGapCheckTol) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = theF;
        a[2] = theP;
        a[3] = Double.doubleToRawLongBits(theTol);
        a[4] = theUseBndBox ? 1L : 0L;
        a[5] = Double.doubleToRawLongBits(theGapCheckTol);
        OcctGen.occtCall(934, a, box);
    }
    }

    public static final class BRepClass_FacePassiveClassifier {
        private BRepClass_FacePassiveClassifier() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(935, a, box);
        return r;
    }
    public static void Reset(long self, long L, double P, double Tol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(P);
        a[3] = Double.doubleToRawLongBits(Tol);
        OcctGen.occtCall(936, a, box);
    }
    public static void Compare(long self, long E, int Or) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = Or;
        OcctGen.occtCall(937, a, box);
    }
    public static double Parameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(938, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Intersector(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(939, a, box);
        return r;
    }
    public static int ClosestIntersection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(940, a, box);
        return (int) r;
    }
    public static int State(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(941, a, box);
        return (int) r;
    }
    public static boolean IsHeadOrEnd(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(942, a, box);
        return r != 0;
    }
    }

    public static final class BRepClass_Intersector {
        private BRepClass_Intersector() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(943, a, box);
        return r;
    }
    public static void Perform(long self, long L, double P, double Tol, long E) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = L;
        a[2] = Double.doubleToRawLongBits(P);
        a[3] = Double.doubleToRawLongBits(Tol);
        a[4] = E;
        OcctGen.occtCall(944, a, box);
    }
    public static void LocalGeometry(long self, long E, double U, long T, long N, double[] COut) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = T;
        a[4] = N;
        OcctGen.occtCall(945, a, box);
        if (COut != null && COut.length != 0) COut[0] = Double.longBitsToDouble(a[5]);
    }
    }

    public static final class BRepExtrema_DistShapeShape {
        private BRepExtrema_DistShapeShape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(946, a, box);
        return r;
    }
    public static long 构造_2(long Shape1, long Shape2, int F, int A) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Shape1;
        a[2] = Shape2;
        a[3] = F;
        a[4] = A;
        long r = OcctGen.occtCall(947, a, box);
        return r;
    }
    public static long 构造_3(long Shape1, long Shape2, double theDeflection, int F, int A) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Shape1;
        a[2] = Shape2;
        a[3] = Double.doubleToRawLongBits(theDeflection);
        a[4] = F;
        a[5] = A;
        long r = OcctGen.occtCall(948, a, box);
        return r;
    }
    public static void SetDeflection(long self, double theDeflection) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDeflection);
        OcctGen.occtCall(949, a, box);
    }
    public static void LoadS1(long self, long Shape1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Shape1;
        OcctGen.occtCall(950, a, box);
    }
    public static void LoadS2(long self, long Shape1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Shape1;
        OcctGen.occtCall(951, a, box);
    }
    public static boolean Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(952, a, box);
        return r != 0;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(953, a, box);
        return r != 0;
    }
    public static int NbSolution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(954, a, box);
        return (int) r;
    }
    public static double Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(955, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean InnerSolution(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(956, a, box);
        return r != 0;
    }
    public static long PointOnShape1(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(957, a, box);
        return r;
    }
    public static long PointOnShape2(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(958, a, box);
        return r;
    }
    public static int SupportTypeShape1(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(959, a, box);
        return (int) r;
    }
    public static int SupportTypeShape2(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(960, a, box);
        return (int) r;
    }
    public static long SupportOnShape1(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(961, a, box);
        return r;
    }
    public static long SupportOnShape2(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(962, a, box);
        return r;
    }
    public static void ParOnEdgeS1(long self, int N, double[] tOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(963, a, box);
        if (tOut != null && tOut.length != 0) tOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static void ParOnEdgeS2(long self, int N, double[] tOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(964, a, box);
        if (tOut != null && tOut.length != 0) tOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static void ParOnFaceS1(long self, int N, double[] uOut, double[] vOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(965, a, box);
        if (uOut != null && uOut.length != 0) uOut[0] = Double.longBitsToDouble(a[2]);
        if (vOut != null && vOut.length != 0) vOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static void ParOnFaceS2(long self, int N, double[] uOut, double[] vOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(966, a, box);
        if (uOut != null && uOut.length != 0) uOut[0] = Double.longBitsToDouble(a[2]);
        if (vOut != null && vOut.length != 0) vOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static String Dump(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(967, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void SetFlag(long self, int F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        OcctGen.occtCall(968, a, box);
    }
    public static void SetAlgo(long self, int A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        OcctGen.occtCall(969, a, box);
    }
    public static void SetMultiThread(long self, boolean theIsMultiThread) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsMultiThread ? 1L : 0L;
        OcctGen.occtCall(970, a, box);
    }
    public static boolean IsMultiThread(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(971, a, box);
        return r != 0;
    }
    }

    public static final class BRepExtrema_DistanceSS {
        private BRepExtrema_DistanceSS() {}

    public static long 构造(
            long theS1, long theS2, long theBox1, long theBox2, double theDstRef,
            double theDeflection, int theExtFlag, int theExtAlgo) {
        long[] a = new long[9];
        Object[] box = null;
        a[1] = theS1;
        a[2] = theS2;
        a[3] = theBox1;
        a[4] = theBox2;
        a[5] = Double.doubleToRawLongBits(theDstRef);
        a[6] = Double.doubleToRawLongBits(theDeflection);
        a[7] = theExtFlag;
        a[8] = theExtAlgo;
        long r = OcctGen.occtCall(972, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(973, a, box);
        return r != 0;
    }
    public static double DistValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(974, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepExtrema_ElementFilter {
        private BRepExtrema_ElementFilter() {}

    }

    public static final class BRepExtrema_ExtCC {
        private BRepExtrema_ExtCC() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(975, a, box);
        return r;
    }
    public static long 构造_2(long E1, long E2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        long r = OcctGen.occtCall(976, a, box);
        return r;
    }
    public static void Initialize(long self, long E2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E2;
        OcctGen.occtCall(977, a, box);
    }
    public static void Perform(long self, long E1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E1;
        OcctGen.occtCall(978, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(979, a, box);
        return r != 0;
    }
    public static int NbExt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(980, a, box);
        return (int) r;
    }
    public static boolean IsParallel(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(981, a, box);
        return r != 0;
    }
    public static double SquareDistance(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(982, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ParameterOnE1(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(983, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long PointOnE1(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(984, a, box);
        return r;
    }
    public static double ParameterOnE2(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(985, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long PointOnE2(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(986, a, box);
        return r;
    }
    public static void TrimmedSquareDistances(
            long self, double[] dist11Out, double[] distP12Out, double[] distP21Out,
            double[] distP22Out, long P11, long P12, long P21, long P22) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[5] = P11;
        a[6] = P12;
        a[7] = P21;
        a[8] = P22;
        OcctGen.occtCall(987, a, box);
        if (dist11Out != null && dist11Out.length != 0) dist11Out[0] = Double.longBitsToDouble(a[1]);
        if (distP12Out != null && distP12Out.length != 0) distP12Out[0] = Double.longBitsToDouble(a[2]);
        if (distP21Out != null && distP21Out.length != 0) distP21Out[0] = Double.longBitsToDouble(a[3]);
        if (distP22Out != null && distP22Out.length != 0) distP22Out[0] = Double.longBitsToDouble(a[4]);
    }
    }

    public static final class BRepExtrema_ExtCF {
        private BRepExtrema_ExtCF() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(988, a, box);
        return r;
    }
    public static long 构造_2(long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E;
        a[2] = F;
        long r = OcctGen.occtCall(989, a, box);
        return r;
    }
    public static void Initialize(long self, long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F;
        OcctGen.occtCall(990, a, box);
    }
    public static void Perform(long self, long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F;
        OcctGen.occtCall(991, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(992, a, box);
        return r != 0;
    }
    public static int NbExt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(993, a, box);
        return (int) r;
    }
    public static double SquareDistance(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(994, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsParallel(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(995, a, box);
        return r != 0;
    }
    public static double ParameterOnEdge(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(996, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void ParameterOnFace(long self, int N, double[] UOut, double[] VOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(997, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long PointOnEdge(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(998, a, box);
        return r;
    }
    public static long PointOnFace(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(999, a, box);
        return r;
    }
    }

    public static final class BRepExtrema_ExtFF {
        private BRepExtrema_ExtFF() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1000, a, box);
        return r;
    }
    public static long 构造_2(long F1, long F2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = F1;
        a[2] = F2;
        long r = OcctGen.occtCall(1001, a, box);
        return r;
    }
    public static void Initialize(long self, long F2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F2;
        OcctGen.occtCall(1002, a, box);
    }
    public static void Perform(long self, long F1, long F2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = F1;
        a[2] = F2;
        OcctGen.occtCall(1003, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1004, a, box);
        return r != 0;
    }
    public static boolean IsParallel(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1005, a, box);
        return r != 0;
    }
    public static int NbExt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1006, a, box);
        return (int) r;
    }
    public static double SquareDistance(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1007, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void ParameterOnFace1(long self, int N, double[] UOut, double[] VOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(1008, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static void ParameterOnFace2(long self, int N, double[] UOut, double[] VOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(1009, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long PointOnFace1(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1010, a, box);
        return r;
    }
    public static long PointOnFace2(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1011, a, box);
        return r;
    }
    }

    public static final class BRepExtrema_ExtPC {
        private BRepExtrema_ExtPC() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1012, a, box);
        return r;
    }
    public static long 构造_2(long V, long E) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = V;
        a[2] = E;
        long r = OcctGen.occtCall(1013, a, box);
        return r;
    }
    public static void Initialize(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(1014, a, box);
    }
    public static void Perform(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        OcctGen.occtCall(1015, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1016, a, box);
        return r != 0;
    }
    public static int NbExt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1017, a, box);
        return (int) r;
    }
    public static boolean IsMin(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1018, a, box);
        return r != 0;
    }
    public static double SquareDistance(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1019, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Parameter(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1020, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Point(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1021, a, box);
        return r;
    }
    public static void TrimmedSquareDistances(
            long self, double[] dist1Out, double[] dist2Out, long pnt1, long pnt2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[3] = pnt1;
        a[4] = pnt2;
        OcctGen.occtCall(1022, a, box);
        if (dist1Out != null && dist1Out.length != 0) dist1Out[0] = Double.longBitsToDouble(a[1]);
        if (dist2Out != null && dist2Out.length != 0) dist2Out[0] = Double.longBitsToDouble(a[2]);
    }
    }

    public static final class BRepExtrema_ExtPF {
        private BRepExtrema_ExtPF() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1023, a, box);
        return r;
    }
    public static long 构造_2(long TheVertex, long TheFace, int TheFlag, int TheAlgo) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = TheVertex;
        a[2] = TheFace;
        a[3] = TheFlag;
        a[4] = TheAlgo;
        long r = OcctGen.occtCall(1024, a, box);
        return r;
    }
    public static void Initialize(long self, long TheFace, int TheFlag, int TheAlgo) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = TheFace;
        a[2] = TheFlag;
        a[3] = TheAlgo;
        OcctGen.occtCall(1025, a, box);
    }
    public static void Perform(long self, long TheVertex, long TheFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = TheVertex;
        a[2] = TheFace;
        OcctGen.occtCall(1026, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1027, a, box);
        return r != 0;
    }
    public static int NbExt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1028, a, box);
        return (int) r;
    }
    public static double SquareDistance(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1029, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Parameter(long self, int N, double[] UOut, double[] VOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        OcctGen.occtCall(1030, a, box);
        if (UOut != null && UOut.length != 0) UOut[0] = Double.longBitsToDouble(a[2]);
        if (VOut != null && VOut.length != 0) VOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static long Point(long self, int N) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        long r = OcctGen.occtCall(1031, a, box);
        return r;
    }
    public static void SetFlag(long self, int F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        OcctGen.occtCall(1032, a, box);
    }
    public static void SetAlgo(long self, int A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        OcctGen.occtCall(1033, a, box);
    }
    }

    public static final class BRepExtrema_OverlapTool {
        private BRepExtrema_OverlapTool() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1034, a, box);
        return r;
    }
    public static long 构造_2(long theSet1, long theSet2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theSet1;
        a[2] = theSet2;
        long r = OcctGen.occtCall(1035, a, box);
        return r;
    }
    public static void LoadTriangleSets(long self, long theSet1, long theSet2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theSet1;
        a[2] = theSet2;
        OcctGen.occtCall(1036, a, box);
    }
    public static void Perform(long self, double theTolerance) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTolerance);
        OcctGen.occtCall(1037, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1038, a, box);
        return r != 0;
    }
    public static void MarkDirty(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1039, a, box);
    }
    public static void SetElementFilter(long self, long theFilter) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theFilter;
        OcctGen.occtCall(1040, a, box);
    }
    public static boolean Accept(long self, int theLeaf1, int theLeaf2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theLeaf1;
        a[2] = theLeaf2;
        long r = OcctGen.occtCall(1041, a, box);
        return r != 0;
    }
    }

    public static final class BRepExtrema_Poly {
        private BRepExtrema_Poly() {}

    public static boolean Distance(long S1, long S2, long P1, long P2, double[] distOut) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        a[3] = P1;
        a[4] = P2;
        long r = OcctGen.occtCall(1042, a, box);
        if (distOut != null && distOut.length != 0) distOut[0] = Double.longBitsToDouble(a[5]);
        return r != 0;
    }
    }

    public static final class BRepExtrema_ProximityDistTool {
        private BRepExtrema_ProximityDistTool() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1043, a, box);
        return r;
    }
    public static void LoadTriangleSets(long self, long theSet1, long theSet2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theSet1;
        a[2] = theSet2;
        OcctGen.occtCall(1044, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1045, a, box);
    }
    public static boolean Accept(long self, int theSgmIdx, double a1) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theSgmIdx;
        a[2] = Double.doubleToRawLongBits(a1);
        long r = OcctGen.occtCall(1046, a, box);
        return r != 0;
    }
    public static boolean IsNodeOnBorder(int theNodeIdx, long theTr) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theNodeIdx;
        a[2] = theTr;
        long r = OcctGen.occtCall(1047, a, box);
        return r != 0;
    }
    public static boolean IsEdgeOnBorder(
            int theTrgIdx, int theFirstEdgeNodeIdx, int theSecondEdgeNodeIdx, long theTr) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theTrgIdx;
        a[2] = theFirstEdgeNodeIdx;
        a[3] = theSecondEdgeNodeIdx;
        a[4] = theTr;
        long r = OcctGen.occtCall(1048, a, box);
        return r != 0;
    }
    public static void ProximityPointsStatus(
            long self, int[] thePointStatus1Out, int[] thePointStatus2Out) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1049, a, box);
        if (thePointStatus1Out != null && thePointStatus1Out.length != 0) thePointStatus1Out[0] = (int) a[1];
        if (thePointStatus2Out != null && thePointStatus2Out.length != 0) thePointStatus2Out[0] = (int) a[2];
    }
    public static double ProximityDistance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1050, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepExtrema_ProximityValueTool {
        private BRepExtrema_ProximityValueTool() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1051, a, box);
        return r;
    }
    public static void LoadTriangleSets(long self, long theSet1, long theSet2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theSet1;
        a[2] = theSet2;
        OcctGen.occtCall(1052, a, box);
    }
    public static void SetNbSamplePoints(long self, int theSamples1, int theSamples2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theSamples1;
        a[2] = theSamples2;
        OcctGen.occtCall(1053, a, box);
    }
    public static void Perform(long self, double[] theToleranceOut) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1054, a, box);
        if (theToleranceOut != null && theToleranceOut.length != 0) theToleranceOut[0] = Double.longBitsToDouble(a[1]);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1055, a, box);
        return r != 0;
    }
    public static void MarkDirty(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1056, a, box);
    }
    public static double Distance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1057, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void ProximityPoints(long self, long thePoint1, long thePoint2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = thePoint1;
        a[2] = thePoint2;
        OcctGen.occtCall(1058, a, box);
    }
    public static void ProximityPointsStatus(
            long self, int[] thePointStatus1Out, int[] thePointStatus2Out) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1059, a, box);
        if (thePointStatus1Out != null && thePointStatus1Out.length != 0) thePointStatus1Out[0] = (int) a[1];
        if (thePointStatus2Out != null && thePointStatus2Out.length != 0) thePointStatus2Out[0] = (int) a[2];
    }
    }

    public static final class BRepExtrema_SelfIntersection {
        private BRepExtrema_SelfIntersection() {}

    public static long 构造(double theTolerance) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theTolerance);
        long r = OcctGen.occtCall(1060, a, box);
        return r;
    }
    public static long 构造_2(long theShape, double theTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theShape;
        a[2] = Double.doubleToRawLongBits(theTolerance);
        long r = OcctGen.occtCall(1061, a, box);
        return r;
    }
    public static double Tolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1062, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetTolerance(long self, double theTolerance) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTolerance);
        OcctGen.occtCall(1063, a, box);
    }
    public static boolean LoadShape(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        long r = OcctGen.occtCall(1064, a, box);
        return r != 0;
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1065, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1066, a, box);
        return r != 0;
    }
    public static long GetSubShape(long self, int theID) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theID;
        long r = OcctGen.occtCall(1067, a, box);
        return r;
    }
    public static long ElementSet(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1068, a, box);
        return r;
    }
    }

    public static final class BRepExtrema_ShapeProximity {
        private BRepExtrema_ShapeProximity() {}

    public static long 构造(double theTolerance) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theTolerance);
        long r = OcctGen.occtCall(1069, a, box);
        return r;
    }
    public static long 构造_2(long theShape1, long theShape2, double theTolerance) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theShape1;
        a[2] = theShape2;
        a[3] = Double.doubleToRawLongBits(theTolerance);
        long r = OcctGen.occtCall(1070, a, box);
        return r;
    }
    public static double Tolerance(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1071, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetTolerance(long self, double theTolerance) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTolerance);
        OcctGen.occtCall(1072, a, box);
    }
    public static double Proximity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1073, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean LoadShape1(long self, long theShape1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape1;
        long r = OcctGen.occtCall(1074, a, box);
        return r != 0;
    }
    public static boolean LoadShape2(long self, long theShape2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape2;
        long r = OcctGen.occtCall(1075, a, box);
        return r != 0;
    }
    public static void SetNbSamples1(long self, int theNbSamples) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theNbSamples;
        OcctGen.occtCall(1076, a, box);
    }
    public static void SetNbSamples2(long self, int theNbSamples) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theNbSamples;
        OcctGen.occtCall(1077, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1078, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1079, a, box);
        return r != 0;
    }
    public static long GetSubShape1(long self, int theID) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theID;
        long r = OcctGen.occtCall(1080, a, box);
        return r;
    }
    public static long GetSubShape2(long self, int theID) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theID;
        long r = OcctGen.occtCall(1081, a, box);
        return r;
    }
    public static long ElementSet1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1082, a, box);
        return r;
    }
    public static long ElementSet2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1083, a, box);
        return r;
    }
    public static long ProximityPoint1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1084, a, box);
        return r;
    }
    public static long ProximityPoint2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1085, a, box);
        return r;
    }
    public static int ProxPntStatus1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1086, a, box);
        return (int) r;
    }
    public static int ProxPntStatus2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1087, a, box);
        return (int) r;
    }
    }

    public static final class BRepExtrema_SolutionElem {
        private BRepExtrema_SolutionElem() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1088, a, box);
        return r;
    }
    public static long 构造_2(double theDist, long thePoint, int theSolType, long theVertex) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theDist);
        a[2] = thePoint;
        a[3] = theSolType;
        a[4] = theVertex;
        long r = OcctGen.occtCall(1089, a, box);
        return r;
    }
    public static long 构造_3(
            double theDist, long thePoint, int theSolType, long theEdge, double theParam) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theDist);
        a[2] = thePoint;
        a[3] = theSolType;
        a[4] = theEdge;
        a[5] = Double.doubleToRawLongBits(theParam);
        long r = OcctGen.occtCall(1090, a, box);
        return r;
    }
    public static long 构造_4(
            double theDist, long thePoint, int theSolType, long theFace, double theU, double theV) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theDist);
        a[2] = thePoint;
        a[3] = theSolType;
        a[4] = theFace;
        a[5] = Double.doubleToRawLongBits(theU);
        a[6] = Double.doubleToRawLongBits(theV);
        long r = OcctGen.occtCall(1091, a, box);
        return r;
    }
    public static double Dist(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1092, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Point(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1093, a, box);
        return r;
    }
    public static int SupportKind(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1094, a, box);
        return (int) r;
    }
    public static long Vertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1095, a, box);
        return r;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1096, a, box);
        return r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1097, a, box);
        return r;
    }
    public static void EdgeParameter(long self, double[] theParamOut) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1098, a, box);
        if (theParamOut != null && theParamOut.length != 0) theParamOut[0] = Double.longBitsToDouble(a[1]);
    }
    public static void FaceParameter(long self, double[] theUOut, double[] theVOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1099, a, box);
        if (theUOut != null && theUOut.length != 0) theUOut[0] = Double.longBitsToDouble(a[1]);
        if (theVOut != null && theVOut.length != 0) theVOut[0] = Double.longBitsToDouble(a[2]);
    }
    }

    public static final class BRepExtrema_TriangleSet {
        private BRepExtrema_TriangleSet() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1100, a, box);
        return r;
    }
    public static int Size(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1101, a, box);
        return (int) r;
    }
    public static double Center(long self, int theIndex, int theAxis) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        a[2] = theAxis;
        long r = OcctGen.occtCall(1102, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Swap(long self, int theIndex1, int theIndex2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex1;
        a[2] = theIndex2;
        OcctGen.occtCall(1103, a, box);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1104, a, box);
    }
    public static int GetFaceID(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(1105, a, box);
        return (int) r;
    }
    public static int GetShapeIDOfVtx(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(1106, a, box);
        return (int) r;
    }
    public static int GetVtxIdxInShape(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(1107, a, box);
        return (int) r;
    }
    public static int GetTrgIdxInShape(long self, int theIndex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIndex;
        long r = OcctGen.occtCall(1108, a, box);
        return (int) r;
    }
    }

    public static final class BRepExtrema_VertexInspector {
        private BRepExtrema_VertexInspector() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1109, a, box);
        return r;
    }
    public static void Add(long self, long thePnt) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = thePnt;
        OcctGen.occtCall(1110, a, box);
    }
    public static void SetTol(long self, double theTol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTol);
        OcctGen.occtCall(1111, a, box);
    }
    public static void SetCurrent(long self, long theCurPnt) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCurPnt;
        OcctGen.occtCall(1112, a, box);
    }
    public static boolean IsNeedAdd(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1113, a, box);
        return r != 0;
    }
    public static int Inspect(long self, int theTarget) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theTarget;
        long r = OcctGen.occtCall(1114, a, box);
        return (int) r;
    }
    }

    public static final class BRepGProp {
        private BRepGProp() {}

    public static void LinearProperties(
            long S, long LProps, boolean SkipShared, boolean UseTriangulation) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = LProps;
        a[3] = SkipShared ? 1L : 0L;
        a[4] = UseTriangulation ? 1L : 0L;
        OcctGen.occtCall(1321, a, box);
    }
    public static void SurfaceProperties(
            long S, long SProps, boolean SkipShared, boolean UseTriangulation) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = SProps;
        a[3] = SkipShared ? 1L : 0L;
        a[4] = UseTriangulation ? 1L : 0L;
        OcctGen.occtCall(1322, a, box);
    }
    public static double SurfaceProperties_2(long S, long SProps, double Eps, boolean SkipShared) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = SProps;
        a[3] = Double.doubleToRawLongBits(Eps);
        a[4] = SkipShared ? 1L : 0L;
        long r = OcctGen.occtCall(1323, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void VolumeProperties(
            long S, long VProps, boolean OnlyClosed, boolean SkipShared, boolean UseTriangulation) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = VProps;
        a[3] = OnlyClosed ? 1L : 0L;
        a[4] = SkipShared ? 1L : 0L;
        a[5] = UseTriangulation ? 1L : 0L;
        OcctGen.occtCall(1324, a, box);
    }
    public static double VolumeProperties_2(
            long S, long VProps, double Eps, boolean OnlyClosed, boolean SkipShared) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = VProps;
        a[3] = Double.doubleToRawLongBits(Eps);
        a[4] = OnlyClosed ? 1L : 0L;
        a[5] = SkipShared ? 1L : 0L;
        long r = OcctGen.occtCall(1325, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VolumePropertiesGK(
            long S, long VProps, double Eps, boolean OnlyClosed, boolean IsUseSpan,
            boolean CGFlag, boolean IFlag, boolean SkipShared) {
        long[] a = new long[9];
        Object[] box = null;
        a[1] = S;
        a[2] = VProps;
        a[3] = Double.doubleToRawLongBits(Eps);
        a[4] = OnlyClosed ? 1L : 0L;
        a[5] = IsUseSpan ? 1L : 0L;
        a[6] = CGFlag ? 1L : 0L;
        a[7] = IFlag ? 1L : 0L;
        a[8] = SkipShared ? 1L : 0L;
        long r = OcctGen.occtCall(1326, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double VolumePropertiesGK_2(
            long S, long VProps, long thePln, double Eps, boolean OnlyClosed, boolean IsUseSpan,
            boolean CGFlag, boolean IFlag, boolean SkipShared) {
        long[] a = new long[10];
        Object[] box = null;
        a[1] = S;
        a[2] = VProps;
        a[3] = thePln;
        a[4] = Double.doubleToRawLongBits(Eps);
        a[5] = OnlyClosed ? 1L : 0L;
        a[6] = IsUseSpan ? 1L : 0L;
        a[7] = CGFlag ? 1L : 0L;
        a[8] = IFlag ? 1L : 0L;
        a[9] = SkipShared ? 1L : 0L;
        long r = OcctGen.occtCall(1327, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepGProp_Cinert {
        private BRepGProp_Cinert() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1328, a, box);
        return r;
    }
    public static long 构造_2(long C, long CLocation) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = CLocation;
        long r = OcctGen.occtCall(1329, a, box);
        return r;
    }
    public static void SetLocation(long self, long CLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = CLocation;
        OcctGen.occtCall(1330, a, box);
    }
    public static void Perform(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(1331, a, box);
    }
    }

    public static final class BRepGProp_Domain {
        private BRepGProp_Domain() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1332, a, box);
        return r;
    }
    public static long 构造_2(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        long r = OcctGen.occtCall(1333, a, box);
        return r;
    }
    public static void Init(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        OcctGen.occtCall(1334, a, box);
    }
    public static boolean More(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1335, a, box);
        return r != 0;
    }
    public static void Init_2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1336, a, box);
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1337, a, box);
        return r;
    }
    public static void Next(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1338, a, box);
    }
    }

    public static final class BRepGProp_EdgeTool {
        private BRepGProp_EdgeTool() {}

    public static double FirstParameter(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(1339, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(1340, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int IntegrationOrder(long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = C;
        long r = OcctGen.occtCall(1341, a, box);
        return (int) r;
    }
    public static long Value(long C, double U) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(1342, a, box);
        return r;
    }
    public static void D1(long C, double U, long P, long V1) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = C;
        a[2] = Double.doubleToRawLongBits(U);
        a[3] = P;
        a[4] = V1;
        OcctGen.occtCall(1343, a, box);
    }
    public static int NbIntervals(long C, int S) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = S;
        long r = OcctGen.occtCall(1344, a, box);
        return (int) r;
    }
    }

    public static final class BRepGProp_Face {
        private BRepGProp_Face() {}

    public static long 构造(boolean IsUseSpan) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = IsUseSpan ? 1L : 0L;
        long r = OcctGen.occtCall(1345, a, box);
        return r;
    }
    public static long 构造_2(long F, boolean IsUseSpan) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = F;
        a[2] = IsUseSpan ? 1L : 0L;
        long r = OcctGen.occtCall(1346, a, box);
        return r;
    }
    public static void Load(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        OcctGen.occtCall(1347, a, box);
    }
    public static int VIntegrationOrder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1348, a, box);
        return (int) r;
    }
    public static boolean NaturalRestriction(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1349, a, box);
        return r != 0;
    }
    public static long GetFace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1350, a, box);
        return r;
    }
    public static long Value2d(long self, double U) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        long r = OcctGen.occtCall(1351, a, box);
        return r;
    }
    public static int SIntOrder(long self, double Eps) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1352, a, box);
        return (int) r;
    }
    public static int SVIntSubs(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1353, a, box);
        return (int) r;
    }
    public static int SUIntSubs(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1354, a, box);
        return (int) r;
    }
    public static int LIntOrder(long self, double Eps) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1355, a, box);
        return (int) r;
    }
    public static int LIntSubs(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1356, a, box);
        return (int) r;
    }
    public static int UIntegrationOrder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1357, a, box);
        return (int) r;
    }
    public static void Bounds(
            long self, double[] U1Out, double[] U2Out, double[] V1Out, double[] V2Out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1358, a, box);
        if (U1Out != null && U1Out.length != 0) U1Out[0] = Double.longBitsToDouble(a[1]);
        if (U2Out != null && U2Out.length != 0) U2Out[0] = Double.longBitsToDouble(a[2]);
        if (V1Out != null && V1Out.length != 0) V1Out[0] = Double.longBitsToDouble(a[3]);
        if (V2Out != null && V2Out.length != 0) V2Out[0] = Double.longBitsToDouble(a[4]);
    }
    public static void Normal(long self, double U, double V, long P, long VNor) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = P;
        a[4] = VNor;
        OcctGen.occtCall(1359, a, box);
    }
    public static boolean Load_2(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1360, a, box);
        return r != 0;
    }
    public static double FirstParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1361, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double LastParameter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1362, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int IntegrationOrder(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1363, a, box);
        return (int) r;
    }
    public static void D12d(long self, double U, long P, long V1) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = P;
        a[3] = V1;
        OcctGen.occtCall(1364, a, box);
    }
    public static void Load_3(long self, boolean IsFirstParam, int theIsoType) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IsFirstParam ? 1L : 0L;
        a[2] = theIsoType;
        OcctGen.occtCall(1365, a, box);
    }
    }

    public static final class BRepGProp_Gauss {
        private BRepGProp_Gauss() {}

    public static void Compute(
            long self, long theSurface, long theLocation, double[] theOutMassOut,
            long theOutGravityCenter, long theOutInertia) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = theLocation;
        a[4] = theOutGravityCenter;
        a[5] = theOutInertia;
        OcctGen.occtCall(1366, a, box);
        if (theOutMassOut != null && theOutMassOut.length != 0) theOutMassOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static void Compute_2(
            long self, long theSurface, long theDomain, long theLocation, double[] theOutMassOut,
            long theOutGravityCenter, long theOutInertia) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = theDomain;
        a[3] = theLocation;
        a[5] = theOutGravityCenter;
        a[6] = theOutInertia;
        OcctGen.occtCall(1367, a, box);
        if (theOutMassOut != null && theOutMassOut.length != 0) theOutMassOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static double Compute_3(
            long self, long theSurface, long theDomain, long theLocation, double theEps,
            double[] theOutMassOut, long theOutGravityCenter, long theOutInertia) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = theDomain;
        a[3] = theLocation;
        a[4] = Double.doubleToRawLongBits(theEps);
        a[6] = theOutGravityCenter;
        a[7] = theOutInertia;
        long r = OcctGen.occtCall(1368, a, box);
        if (theOutMassOut != null && theOutMassOut.length != 0) theOutMassOut[0] = Double.longBitsToDouble(a[5]);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepGProp_MeshCinert {
        private BRepGProp_MeshCinert() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1369, a, box);
        return r;
    }
    public static void SetLocation(long self, long CLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = CLocation;
        OcctGen.occtCall(1370, a, box);
    }
    }

    public static final class BRepGProp_MeshProps {
        private BRepGProp_MeshProps() {}

    public static void SetLocation(long self, long theLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLocation;
        OcctGen.occtCall(1371, a, box);
    }
    public static void Perform(long self, long theMesh, long theLoc, int theOri) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theMesh;
        a[2] = theLoc;
        a[3] = theOri;
        OcctGen.occtCall(1372, a, box);
    }
    public static void Perform_2(long self, long theMesh, int theOri) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theMesh;
        a[2] = theOri;
        OcctGen.occtCall(1373, a, box);
    }
    }

    public static final class BRepGProp_Sinert {
        private BRepGProp_Sinert() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1374, a, box);
        return r;
    }
    public static long 构造_2(long S, long SLocation) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S;
        a[2] = SLocation;
        long r = OcctGen.occtCall(1375, a, box);
        return r;
    }
    public static long 构造_3(long S, long D, long SLocation) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = SLocation;
        long r = OcctGen.occtCall(1376, a, box);
        return r;
    }
    public static long 构造_4(long S, long SLocation, double Eps) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = SLocation;
        a[3] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1377, a, box);
        return r;
    }
    public static long 构造_5(long S, long D, long SLocation, double Eps) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = SLocation;
        a[4] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1378, a, box);
        return r;
    }
    public static void SetLocation(long self, long SLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = SLocation;
        OcctGen.occtCall(1379, a, box);
    }
    public static void Perform(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1380, a, box);
    }
    public static void Perform_2(long self, long S, long D) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = D;
        OcctGen.occtCall(1381, a, box);
    }
    public static double Perform_3(long self, long S, double Eps) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1382, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Perform_4(long self, long S, long D, double Eps) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = D;
        a[3] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1383, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double GetEpsilon(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1384, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepGProp_TFunction {
        private BRepGProp_TFunction() {}

    public static void Init(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1385, a, box);
    }
    public static void SetNbKronrodPoints(long self, int theNbPoints) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theNbPoints;
        OcctGen.occtCall(1386, a, box);
    }
    public static void SetValueType(long self, int aType) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = aType;
        OcctGen.occtCall(1387, a, box);
    }
    public static void SetTolerance(long self, double aTol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(aTol);
        OcctGen.occtCall(1388, a, box);
    }
    public static double ErrorReached(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1389, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double AbsolutError(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1390, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean Value(long self, double X, double[] FOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(1391, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    public static int GetStateNumber(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1392, a, box);
        return (int) r;
    }
    }

    public static final class BRepGProp_UFunction {
        private BRepGProp_UFunction() {}

    public static void SetValueType(long self, int theType) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theType;
        OcctGen.occtCall(1393, a, box);
    }
    public static void SetVParam(long self, double theVParam) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theVParam);
        OcctGen.occtCall(1394, a, box);
    }
    public static boolean Value(long self, double X, double[] FOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        long r = OcctGen.occtCall(1395, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[2]);
        return r != 0;
    }
    }

    public static final class BRepGProp_Vinert {
        private BRepGProp_Vinert() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1396, a, box);
        return r;
    }
    public static long 构造_2(long S, long VLocation) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S;
        a[2] = VLocation;
        long r = OcctGen.occtCall(1397, a, box);
        return r;
    }
    public static long 构造_3(long S, long VLocation, double Eps) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = VLocation;
        a[3] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1398, a, box);
        return r;
    }
    public static long 构造_4(long S, long O, long VLocation) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = O;
        a[3] = VLocation;
        long r = OcctGen.occtCall(1399, a, box);
        return r;
    }
    public static long 构造_5(long S, long O, long VLocation, double Eps) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = O;
        a[3] = VLocation;
        a[4] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1400, a, box);
        return r;
    }
    public static long 构造_6(long S, long Pl, long VLocation) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = Pl;
        a[3] = VLocation;
        long r = OcctGen.occtCall(1401, a, box);
        return r;
    }
    public static long 构造_7(long S, long Pl, long VLocation, double Eps) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = Pl;
        a[3] = VLocation;
        a[4] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1402, a, box);
        return r;
    }
    public static long 构造_8(long S, long D, long VLocation) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = VLocation;
        long r = OcctGen.occtCall(1403, a, box);
        return r;
    }
    public static long 构造_9(long S, long D, long VLocation, double Eps) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = VLocation;
        a[4] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1404, a, box);
        return r;
    }
    public static long 构造_10(long S, long D, long O, long VLocation) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = O;
        a[4] = VLocation;
        long r = OcctGen.occtCall(1405, a, box);
        return r;
    }
    public static long 构造_11(long S, long D, long O, long VLocation, double Eps) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = O;
        a[4] = VLocation;
        a[5] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1406, a, box);
        return r;
    }
    public static long 构造_12(long S, long D, long Pl, long VLocation) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = Pl;
        a[4] = VLocation;
        long r = OcctGen.occtCall(1407, a, box);
        return r;
    }
    public static long 构造_13(long S, long D, long Pl, long VLocation, double Eps) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = Pl;
        a[4] = VLocation;
        a[5] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1408, a, box);
        return r;
    }
    public static void SetLocation(long self, long VLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = VLocation;
        OcctGen.occtCall(1409, a, box);
    }
    public static void Perform(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1410, a, box);
    }
    public static double Perform_2(long self, long S, double Eps) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1411, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Perform_3(long self, long S, long O) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = O;
        OcctGen.occtCall(1412, a, box);
    }
    public static double Perform_4(long self, long S, long O, double Eps) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = O;
        a[3] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1413, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Perform_5(long self, long S, long Pl) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Pl;
        OcctGen.occtCall(1414, a, box);
    }
    public static double Perform_6(long self, long S, long Pl, double Eps) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Pl;
        a[3] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1415, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Perform_7(long self, long S, long D) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = D;
        OcctGen.occtCall(1416, a, box);
    }
    public static double Perform_8(long self, long S, long D, double Eps) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = D;
        a[3] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1417, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Perform_9(long self, long S, long D, long O) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = D;
        a[3] = O;
        OcctGen.occtCall(1418, a, box);
    }
    public static double Perform_10(long self, long S, long D, long O, double Eps) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = D;
        a[3] = O;
        a[4] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1419, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Perform_11(long self, long S, long D, long Pl) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = D;
        a[3] = Pl;
        OcctGen.occtCall(1420, a, box);
    }
    public static double Perform_12(long self, long S, long D, long Pl, double Eps) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = D;
        a[3] = Pl;
        a[4] = Double.doubleToRawLongBits(Eps);
        long r = OcctGen.occtCall(1421, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double GetEpsilon(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1422, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepGProp_VinertGK {
        private BRepGProp_VinertGK() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1423, a, box);
        return r;
    }
    public static long 构造_2(
            long theSurface, long theLocation, double theTolerance, boolean theCGFlag,
            boolean theIFlag) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = theSurface;
        a[2] = theLocation;
        a[3] = Double.doubleToRawLongBits(theTolerance);
        a[4] = theCGFlag ? 1L : 0L;
        a[5] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1424, a, box);
        return r;
    }
    public static long 构造_3(
            long theSurface, long thePoint, long theLocation, double theTolerance,
            boolean theCGFlag, boolean theIFlag) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = theSurface;
        a[2] = thePoint;
        a[3] = theLocation;
        a[4] = Double.doubleToRawLongBits(theTolerance);
        a[5] = theCGFlag ? 1L : 0L;
        a[6] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1425, a, box);
        return r;
    }
    public static long 构造_4(
            long theSurface, long theDomain, long theLocation, double theTolerance,
            boolean theCGFlag, boolean theIFlag) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = theSurface;
        a[2] = theDomain;
        a[3] = theLocation;
        a[4] = Double.doubleToRawLongBits(theTolerance);
        a[5] = theCGFlag ? 1L : 0L;
        a[6] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1426, a, box);
        return r;
    }
    public static long 构造_5(
            long theSurface, long theDomain, long thePoint, long theLocation, double theTolerance,
            boolean theCGFlag, boolean theIFlag) {
        long[] a = new long[8];
        Object[] box = null;
        a[1] = theSurface;
        a[2] = theDomain;
        a[3] = thePoint;
        a[4] = theLocation;
        a[5] = Double.doubleToRawLongBits(theTolerance);
        a[6] = theCGFlag ? 1L : 0L;
        a[7] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1427, a, box);
        return r;
    }
    public static long 构造_6(
            long theSurface, long thePlane, long theLocation, double theTolerance,
            boolean theCGFlag, boolean theIFlag) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = theSurface;
        a[2] = thePlane;
        a[3] = theLocation;
        a[4] = Double.doubleToRawLongBits(theTolerance);
        a[5] = theCGFlag ? 1L : 0L;
        a[6] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1428, a, box);
        return r;
    }
    public static long 构造_7(
            long theSurface, long theDomain, long thePlane, long theLocation, double theTolerance,
            boolean theCGFlag, boolean theIFlag) {
        long[] a = new long[8];
        Object[] box = null;
        a[1] = theSurface;
        a[2] = theDomain;
        a[3] = thePlane;
        a[4] = theLocation;
        a[5] = Double.doubleToRawLongBits(theTolerance);
        a[6] = theCGFlag ? 1L : 0L;
        a[7] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1429, a, box);
        return r;
    }
    public static void SetLocation(long self, long theLocation) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theLocation;
        OcctGen.occtCall(1430, a, box);
    }
    public static double Perform(
            long self, long theSurface, double theTolerance, boolean theCGFlag, boolean theIFlag) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = Double.doubleToRawLongBits(theTolerance);
        a[3] = theCGFlag ? 1L : 0L;
        a[4] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1431, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Perform_2(
            long self, long theSurface, long thePoint, double theTolerance, boolean theCGFlag,
            boolean theIFlag) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = thePoint;
        a[3] = Double.doubleToRawLongBits(theTolerance);
        a[4] = theCGFlag ? 1L : 0L;
        a[5] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1432, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Perform_3(
            long self, long theSurface, long theDomain, double theTolerance, boolean theCGFlag,
            boolean theIFlag) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = theDomain;
        a[3] = Double.doubleToRawLongBits(theTolerance);
        a[4] = theCGFlag ? 1L : 0L;
        a[5] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1433, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Perform_4(
            long self, long theSurface, long theDomain, long thePoint, double theTolerance,
            boolean theCGFlag, boolean theIFlag) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = theDomain;
        a[3] = thePoint;
        a[4] = Double.doubleToRawLongBits(theTolerance);
        a[5] = theCGFlag ? 1L : 0L;
        a[6] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1434, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Perform_5(
            long self, long theSurface, long thePlane, double theTolerance, boolean theCGFlag,
            boolean theIFlag) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = thePlane;
        a[3] = Double.doubleToRawLongBits(theTolerance);
        a[4] = theCGFlag ? 1L : 0L;
        a[5] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1435, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Perform_6(
            long self, long theSurface, long theDomain, long thePlane, double theTolerance,
            boolean theCGFlag, boolean theIFlag) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = theSurface;
        a[2] = theDomain;
        a[3] = thePlane;
        a[4] = Double.doubleToRawLongBits(theTolerance);
        a[5] = theCGFlag ? 1L : 0L;
        a[6] = theIFlag ? 1L : 0L;
        long r = OcctGen.occtCall(1436, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double GetErrorReached(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1437, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double GetAbsolutError(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1438, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepIntCurveSurface_Inter {
        private BRepIntCurveSurface_Inter() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1439, a, box);
        return r;
    }
    public static void Init(long self, long theShape, long theCurve, double theTol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        a[2] = theCurve;
        a[3] = Double.doubleToRawLongBits(theTol);
        OcctGen.occtCall(1440, a, box);
    }
    public static void Init_2(long self, long theShape, long theLine, double theTol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        a[2] = theLine;
        a[3] = Double.doubleToRawLongBits(theTol);
        OcctGen.occtCall(1441, a, box);
    }
    public static void Load(long self, long theShape, double theTol) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        a[2] = Double.doubleToRawLongBits(theTol);
        OcctGen.occtCall(1442, a, box);
    }
    public static void Init_3(long self, long theCurve) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCurve;
        OcctGen.occtCall(1443, a, box);
    }
    public static boolean More(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1444, a, box);
        return r != 0;
    }
    public static void Next(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1445, a, box);
    }
    public static long Pnt(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1446, a, box);
        return r;
    }
    public static double U(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1447, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double V(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1448, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double W(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1449, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int State(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1450, a, box);
        return (int) r;
    }
    public static int Transition(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1451, a, box);
        return (int) r;
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1452, a, box);
        return r;
    }
    }

    public static final class BRepLib_MakeWire {
        private BRepLib_MakeWire() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1504, a, box);
        return r;
    }
    public static long 构造_2(long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = E;
        long r = OcctGen.occtCall(1505, a, box);
        return r;
    }
    public static long 构造_3(long E1, long E2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        long r = OcctGen.occtCall(1506, a, box);
        return r;
    }
    public static long 构造_4(long E1, long E2, long E3) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        a[3] = E3;
        long r = OcctGen.occtCall(1507, a, box);
        return r;
    }
    public static long 构造_5(long E1, long E2, long E3, long E4) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = E1;
        a[2] = E2;
        a[3] = E3;
        a[4] = E4;
        long r = OcctGen.occtCall(1508, a, box);
        return r;
    }
    public static long 构造_6(long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = W;
        long r = OcctGen.occtCall(1509, a, box);
        return r;
    }
    public static long 构造_7(long W, long E) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = W;
        a[2] = E;
        long r = OcctGen.occtCall(1510, a, box);
        return r;
    }
    public static void Add(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(1511, a, box);
    }
    public static void Add_2(long self, long W) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        OcctGen.occtCall(1512, a, box);
    }
    public static int Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1513, a, box);
        return (int) r;
    }
    public static long Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1514, a, box);
        return r;
    }
    public static long 转TopoDS_Wire(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1515, a, box);
        return r;
    }
    public static long Edge(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1516, a, box);
        return r;
    }
    public static long Vertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1517, a, box);
        return r;
    }
    }

    public static final class BRepTopAdaptor_FClass2d {
        private BRepTopAdaptor_FClass2d() {}

    public static long 构造(long F, double Tol) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = F;
        a[2] = Double.doubleToRawLongBits(Tol);
        long r = OcctGen.occtCall(1897, a, box);
        return r;
    }
    public static int PerformInfinitePoint(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1898, a, box);
        return (int) r;
    }
    public static int Perform(long self, long Puv, boolean RecadreOnPeriodic) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Puv;
        a[2] = RecadreOnPeriodic ? 1L : 0L;
        long r = OcctGen.occtCall(1899, a, box);
        return (int) r;
    }
    public static void Destroy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1900, a, box);
    }
    public static long Copy(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(1901, a, box);
        return r;
    }
    public static int TestOnRestriction(
            long self, long Puv, double Tol, boolean RecadreOnPeriodic) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Puv;
        a[2] = Double.doubleToRawLongBits(Tol);
        a[3] = RecadreOnPeriodic ? 1L : 0L;
        long r = OcctGen.occtCall(1902, a, box);
        return (int) r;
    }
    }

    public static final class BRepTopAdaptor_HVertex {
        private BRepTopAdaptor_HVertex() {}

    public static long 构造(long Vtx, long Curve) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Vtx;
        a[2] = Curve;
        long r = OcctGen.occtCall(1903, a, box);
        return r;
    }
    public static long Vertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1904, a, box);
        return r;
    }
    public static long ChangeVertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1905, a, box);
        return r;
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1906, a, box);
        return r;
    }
    public static double Parameter(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(1907, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Resolution(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(1908, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Orientation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1909, a, box);
        return (int) r;
    }
    public static boolean IsSame(long self, long Other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Other;
        long r = OcctGen.occtCall(1910, a, box);
        return r != 0;
    }
    }

    public static final class BRepTopAdaptor_Tool {
        private BRepTopAdaptor_Tool() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1911, a, box);
        return r;
    }
    public static long 构造_2(long F, double Tol2d) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = F;
        a[2] = Double.doubleToRawLongBits(Tol2d);
        long r = OcctGen.occtCall(1912, a, box);
        return r;
    }
    public static long 构造_3(long Surface, double Tol2d) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Surface;
        a[2] = Double.doubleToRawLongBits(Tol2d);
        long r = OcctGen.occtCall(1913, a, box);
        return r;
    }
    public static void Init(long self, long F, double Tol2d) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = Double.doubleToRawLongBits(Tol2d);
        OcctGen.occtCall(1914, a, box);
    }
    public static void Init_2(long self, long Surface, double Tol2d) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Surface;
        a[2] = Double.doubleToRawLongBits(Tol2d);
        OcctGen.occtCall(1915, a, box);
    }
    public static long GetTopolTool(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1916, a, box);
        return r;
    }
    public static void SetTopolTool(long self, long TT) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = TT;
        OcctGen.occtCall(1917, a, box);
    }
    public static long GetSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1918, a, box);
        return r;
    }
    public static void Destroy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1919, a, box);
    }
    }

    public static final class BRepTopAdaptor_TopolTool {
        private BRepTopAdaptor_TopolTool() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1920, a, box);
        return r;
    }
    public static long 构造_2(long Surface) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Surface;
        long r = OcctGen.occtCall(1921, a, box);
        return r;
    }
    public static void Initialize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1922, a, box);
    }
    public static void Initialize_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1923, a, box);
    }
    public static void Initialize_3(long self, long Curve) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Curve;
        OcctGen.occtCall(1924, a, box);
    }
    public static void Init(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1925, a, box);
    }
    public static boolean More(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1926, a, box);
        return r != 0;
    }
    public static long Value(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1927, a, box);
        return r;
    }
    public static void Next(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1928, a, box);
    }
    public static void InitVertexIterator(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1929, a, box);
    }
    public static boolean MoreVertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1930, a, box);
        return r != 0;
    }
    public static long Vertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1931, a, box);
        return r;
    }
    public static void NextVertex(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1932, a, box);
    }
    public static int Classify(long self, long P2d, double Tol, boolean RecadreOnPeriodic) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = P2d;
        a[2] = Double.doubleToRawLongBits(Tol);
        a[3] = RecadreOnPeriodic ? 1L : 0L;
        long r = OcctGen.occtCall(1933, a, box);
        return (int) r;
    }
    public static boolean IsThePointOn(long self, long P2d, double Tol, boolean RecadreOnPeriodic) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = P2d;
        a[2] = Double.doubleToRawLongBits(Tol);
        a[3] = RecadreOnPeriodic ? 1L : 0L;
        long r = OcctGen.occtCall(1934, a, box);
        return r != 0;
    }
    public static int Orientation(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(1935, a, box);
        return (int) r;
    }
    public static int Orientation_2(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(1936, a, box);
        return (int) r;
    }
    public static void Destroy(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1937, a, box);
    }
    public static boolean Has3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1938, a, box);
        return r != 0;
    }
    public static double Tol3d(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(1939, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Tol3d_2(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        long r = OcctGen.occtCall(1940, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Pnt(long self, long V) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        long r = OcctGen.occtCall(1941, a, box);
        return r;
    }
    public static void ComputeSamplePoints(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1942, a, box);
    }
    public static int NbSamplesU(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1943, a, box);
        return (int) r;
    }
    public static int NbSamplesV(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1944, a, box);
        return (int) r;
    }
    public static int NbSamples(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1945, a, box);
        return (int) r;
    }
    public static void SamplePoint(long self, int Index, long P2d, long P3d) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        a[2] = P2d;
        a[3] = P3d;
        OcctGen.occtCall(1946, a, box);
    }
    public static boolean DomainIsInfinite(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1947, a, box);
        return r != 0;
    }
    }

}
