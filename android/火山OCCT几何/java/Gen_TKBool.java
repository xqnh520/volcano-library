package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKBool 类=4 方法槽=44
public final class Gen_TKBool {
    private Gen_TKBool() {}

    public static final class BRepAlgo_AsDes {
        private BRepAlgo_AsDes() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(541, a, box);
        return r;
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(542, a, box);
    }
    public static void Add(long self, long S, long SS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = SS;
        OcctGen.occtCall(543, a, box);
    }
    public static boolean HasAscendant(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(544, a, box);
        return r != 0;
    }
    public static boolean HasDescendant(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(545, a, box);
        return r != 0;
    }
    public static void Replace(long self, long theOldS, long theNewS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theOldS;
        a[2] = theNewS;
        OcctGen.occtCall(546, a, box);
    }
    public static void Remove(long self, long theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theS;
        OcctGen.occtCall(547, a, box);
    }
    }

    public static final class BRepAlgo_Image {
        private BRepAlgo_Image() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(548, a, box);
        return r;
    }
    public static void SetRoot(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(549, a, box);
    }
    public static void Bind(long self, long OldS, long NewS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = OldS;
        a[2] = NewS;
        OcctGen.occtCall(550, a, box);
    }
    public static void Add(long self, long OldS, long NewS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = OldS;
        a[2] = NewS;
        OcctGen.occtCall(551, a, box);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(552, a, box);
    }
    public static void Remove(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(553, a, box);
    }
    public static void RemoveRoot(long self, long Root) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Root;
        OcctGen.occtCall(554, a, box);
    }
    public static void ReplaceRoot(long self, long OldRoot, long NewRoot) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = OldRoot;
        a[2] = NewRoot;
        OcctGen.occtCall(555, a, box);
    }
    public static boolean IsImage(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(556, a, box);
        return r != 0;
    }
    public static long ImageFrom(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(557, a, box);
        return r;
    }
    public static long Root(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(558, a, box);
        return r;
    }
    public static boolean HasImage(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(559, a, box);
        return r != 0;
    }
    public static void Compact(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(560, a, box);
    }
    public static void Filter(long self, long S, int ShapeType) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = ShapeType;
        OcctGen.occtCall(561, a, box);
    }
    }

    public static final class BRepAlgo_NormalProjection {
        private BRepAlgo_NormalProjection() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(562, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(563, a, box);
        return r;
    }
    public static void Init(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(564, a, box);
    }
    public static void Add(long self, long ToProj) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ToProj;
        OcctGen.occtCall(565, a, box);
    }
    public static void SetParams(
            long self, double Tol3D, double Tol2D, int InternalContinuity, int MaxDegree,
            int MaxSeg) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tol3D);
        a[2] = Double.doubleToRawLongBits(Tol2D);
        a[3] = InternalContinuity;
        a[4] = MaxDegree;
        a[5] = MaxSeg;
        OcctGen.occtCall(566, a, box);
    }
    public static void SetDefaultParams(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(567, a, box);
    }
    public static void SetMaxDistance(long self, double MaxDist) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MaxDist);
        OcctGen.occtCall(568, a, box);
    }
    public static void Compute3d(long self, boolean With3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = With3d ? 1L : 0L;
        OcctGen.occtCall(569, a, box);
    }
    public static void SetLimit(long self, boolean FaceBoundaries) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = FaceBoundaries ? 1L : 0L;
        OcctGen.occtCall(570, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(571, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(572, a, box);
        return r != 0;
    }
    public static long Projection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(573, a, box);
        return r;
    }
    public static long Ancestor(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(574, a, box);
        return r;
    }
    public static long Couple(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(575, a, box);
        return r;
    }
    public static boolean IsElementary(long self, long C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        long r = OcctGen.occtCall(576, a, box);
        return r != 0;
    }
    }

    public static final class BRepProj_Projection {
        private BRepProj_Projection() {}

    public static long 构造(long Wire, long Shape, long D) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Wire;
        a[2] = Shape;
        a[3] = D;
        long r = OcctGen.occtCall(1777, a, box);
        return r;
    }
    public static long 构造_2(long Wire, long Shape, long P) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Wire;
        a[2] = Shape;
        a[3] = P;
        long r = OcctGen.occtCall(1778, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1779, a, box);
        return r != 0;
    }
    public static void Init(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1780, a, box);
    }
    public static boolean More(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1781, a, box);
        return r != 0;
    }
    public static void Next(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1782, a, box);
    }
    public static long Current(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1783, a, box);
        return r;
    }
    public static long Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1784, a, box);
        return r;
    }
    }

}
