package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKBO 类=10 方法槽=71
public final class Gen_TKBO {
    private Gen_TKBO() {}

    public static final class BRepAlgoAPI_Algo {
        private BRepAlgoAPI_Algo() {}

    public static long Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(470, a, box);
        return r;
    }
    }

    public static final class BRepAlgoAPI_BooleanOperation {
        private BRepAlgoAPI_BooleanOperation() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(471, a, box);
        return r;
    }
    public static long Shape1(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(472, a, box);
        return r;
    }
    public static long Shape2(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(473, a, box);
        return r;
    }
    public static void SetOperation(long self, int theBOP) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theBOP;
        OcctGen.occtCall(474, a, box);
    }
    public static int Operation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(475, a, box);
        return (int) r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(476, a, box);
    }
    }

    public static final class BRepAlgoAPI_BuilderAlgo {
        private BRepAlgoAPI_BuilderAlgo() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(477, a, box);
        return r;
    }
    public static void SetNonDestructive(long self, boolean theFlag) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theFlag ? 1L : 0L;
        OcctGen.occtCall(478, a, box);
    }
    public static boolean NonDestructive(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(479, a, box);
        return r != 0;
    }
    public static void SetGlue(long self, int theGlue) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theGlue;
        OcctGen.occtCall(480, a, box);
    }
    public static int Glue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(481, a, box);
        return (int) r;
    }
    public static void SetCheckInverted(long self, boolean theCheck) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theCheck ? 1L : 0L;
        OcctGen.occtCall(482, a, box);
    }
    public static boolean CheckInverted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(483, a, box);
        return r != 0;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(484, a, box);
    }
    public static void SimplifyResult(
            long self, boolean theUnifyEdges, boolean theUnifyFaces, double theAngularTol) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theUnifyEdges ? 1L : 0L;
        a[2] = theUnifyFaces ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(theAngularTol);
        OcctGen.occtCall(485, a, box);
    }
    public static boolean IsDeleted(long self, long aS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = aS;
        long r = OcctGen.occtCall(486, a, box);
        return r != 0;
    }
    public static boolean HasModified(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(487, a, box);
        return r != 0;
    }
    public static boolean HasGenerated(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(488, a, box);
        return r != 0;
    }
    public static boolean HasDeleted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(489, a, box);
        return r != 0;
    }
    public static void SetToFillHistory(long self, boolean theHistFlag) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theHistFlag ? 1L : 0L;
        OcctGen.occtCall(490, a, box);
    }
    public static boolean HasHistory(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(491, a, box);
        return r != 0;
    }
    public static long History(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(492, a, box);
        return r;
    }
    }

    public static final class BRepAlgoAPI_Check {
        private BRepAlgoAPI_Check() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(493, a, box);
        return r;
    }
    public static long 构造_2(long theS, boolean bTestSE, boolean bTestSI) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = theS;
        a[2] = bTestSE ? 1L : 0L;
        a[3] = bTestSI ? 1L : 0L;
        long r = OcctGen.occtCall(494, a, box);
        return r;
    }
    public static long 构造_3(long theS1, long theS2, int theOp, boolean bTestSE, boolean bTestSI) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = theS1;
        a[2] = theS2;
        a[3] = theOp;
        a[4] = bTestSE ? 1L : 0L;
        a[5] = bTestSI ? 1L : 0L;
        long r = OcctGen.occtCall(495, a, box);
        return r;
    }
    public static void SetData(long self, long theS, boolean bTestSE, boolean bTestSI) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theS;
        a[2] = bTestSE ? 1L : 0L;
        a[3] = bTestSI ? 1L : 0L;
        OcctGen.occtCall(496, a, box);
    }
    public static void SetData_2(
            long self, long theS1, long theS2, int theOp, boolean bTestSE, boolean bTestSI) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = theS1;
        a[2] = theS2;
        a[3] = theOp;
        a[4] = bTestSE ? 1L : 0L;
        a[5] = bTestSI ? 1L : 0L;
        OcctGen.occtCall(497, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(498, a, box);
    }
    public static boolean IsValid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(499, a, box);
        return r != 0;
    }
    }

    public static final class BRepAlgoAPI_Common {
        private BRepAlgoAPI_Common() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(500, a, box);
        return r;
    }
    public static long 构造_2(long S1, long S2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        long r = OcctGen.occtCall(501, a, box);
        return r;
    }
    public static long 构造_3(long S1, long S2, long PF) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        a[3] = PF;
        long r = OcctGen.occtCall(502, a, box);
        return r;
    }
    }

    public static final class BRepAlgoAPI_Cut {
        private BRepAlgoAPI_Cut() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(503, a, box);
        return r;
    }
    public static long 构造_2(long S1, long S2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        long r = OcctGen.occtCall(504, a, box);
        return r;
    }
    public static long 构造_3(long S1, long S2, long aDSF, boolean bFWD) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        a[3] = aDSF;
        a[4] = bFWD ? 1L : 0L;
        long r = OcctGen.occtCall(505, a, box);
        return r;
    }
    }

    public static final class BRepAlgoAPI_Defeaturing {
        private BRepAlgoAPI_Defeaturing() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(506, a, box);
        return r;
    }
    public static void SetShape(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        OcctGen.occtCall(507, a, box);
    }
    public static long InputShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(508, a, box);
        return r;
    }
    public static void AddFaceToRemove(long self, long theFace) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theFace;
        OcctGen.occtCall(509, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(510, a, box);
    }
    public static void SetToFillHistory(long self, boolean theFlag) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theFlag ? 1L : 0L;
        OcctGen.occtCall(511, a, box);
    }
    public static boolean HasHistory(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(512, a, box);
        return r != 0;
    }
    public static boolean IsDeleted(long self, long theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theS;
        long r = OcctGen.occtCall(513, a, box);
        return r != 0;
    }
    public static boolean HasModified(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(514, a, box);
        return r != 0;
    }
    public static boolean HasGenerated(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(515, a, box);
        return r != 0;
    }
    public static boolean HasDeleted(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(516, a, box);
        return r != 0;
    }
    public static long History(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(517, a, box);
        return r;
    }
    }

    public static final class BRepAlgoAPI_Fuse {
        private BRepAlgoAPI_Fuse() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(518, a, box);
        return r;
    }
    public static long 构造_2(long S1, long S2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        long r = OcctGen.occtCall(519, a, box);
        return r;
    }
    public static long 构造_3(long S1, long S2, long aDSF) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        a[3] = aDSF;
        long r = OcctGen.occtCall(520, a, box);
        return r;
    }
    }

    public static final class BRepAlgoAPI_Section {
        private BRepAlgoAPI_Section() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(521, a, box);
        return r;
    }
    public static long 构造_2(long S1, long S2, boolean PerformNow) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S1;
        a[2] = S2;
        a[3] = PerformNow ? 1L : 0L;
        long r = OcctGen.occtCall(522, a, box);
        return r;
    }
    public static long 构造_3(long S1, long Pl, boolean PerformNow) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S1;
        a[2] = Pl;
        a[3] = PerformNow ? 1L : 0L;
        long r = OcctGen.occtCall(523, a, box);
        return r;
    }
    public static long 构造_4(long S1, long Sf, boolean PerformNow) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S1;
        a[2] = Sf;
        a[3] = PerformNow ? 1L : 0L;
        long r = OcctGen.occtCall(524, a, box);
        return r;
    }
    public static long 构造_5(long Sf, long S2, boolean PerformNow) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Sf;
        a[2] = S2;
        a[3] = PerformNow ? 1L : 0L;
        long r = OcctGen.occtCall(525, a, box);
        return r;
    }
    public static long 构造_6(long Sf1, long Sf2, boolean PerformNow) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Sf1;
        a[2] = Sf2;
        a[3] = PerformNow ? 1L : 0L;
        long r = OcctGen.occtCall(526, a, box);
        return r;
    }
    public static void Init1(long self, long S1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S1;
        OcctGen.occtCall(527, a, box);
    }
    public static void Init1_2(long self, long Pl) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Pl;
        OcctGen.occtCall(528, a, box);
    }
    public static void Init1_3(long self, long Sf) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Sf;
        OcctGen.occtCall(529, a, box);
    }
    public static void Init2(long self, long S2) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S2;
        OcctGen.occtCall(530, a, box);
    }
    public static void Init2_2(long self, long Pl) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Pl;
        OcctGen.occtCall(531, a, box);
    }
    public static void Init2_3(long self, long Sf) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Sf;
        OcctGen.occtCall(532, a, box);
    }
    public static void Approximation(long self, boolean B) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = B ? 1L : 0L;
        OcctGen.occtCall(533, a, box);
    }
    public static void ComputePCurveOn1(long self, boolean B) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = B ? 1L : 0L;
        OcctGen.occtCall(534, a, box);
    }
    public static void ComputePCurveOn2(long self, boolean B) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = B ? 1L : 0L;
        OcctGen.occtCall(535, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(536, a, box);
    }
    public static boolean HasAncestorFaceOn1(long self, long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F;
        long r = OcctGen.occtCall(537, a, box);
        return r != 0;
    }
    public static boolean HasAncestorFaceOn2(long self, long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F;
        long r = OcctGen.occtCall(538, a, box);
        return r != 0;
    }
    }

    public static final class BRepAlgoAPI_Splitter {
        private BRepAlgoAPI_Splitter() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(539, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(540, a, box);
    }
    }

}
