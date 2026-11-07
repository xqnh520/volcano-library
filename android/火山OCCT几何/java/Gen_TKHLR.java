package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKHLR 类=5 方法槽=93
public final class Gen_TKHLR {
    private Gen_TKHLR() {}

    public static final class HLRAlgo_Projector {
        private HLRAlgo_Projector() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(3996, a, box);
        return r;
    }
    public static long 构造_2(long CS) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = CS;
        long r = OcctGen.occtCall(3997, a, box);
        return r;
    }
    public static long 构造_3(long CS, double Focus) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = CS;
        a[2] = Double.doubleToRawLongBits(Focus);
        long r = OcctGen.occtCall(3998, a, box);
        return r;
    }
    public static long 构造_4(long T, boolean Persp, double Focus) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = T;
        a[2] = Persp ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(Focus);
        long r = OcctGen.occtCall(3999, a, box);
        return r;
    }
    public static long 构造_5(long T, boolean Persp, double Focus, long v1, long v2, long v3) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = T;
        a[2] = Persp ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(Focus);
        a[4] = v1;
        a[5] = v2;
        a[6] = v3;
        long r = OcctGen.occtCall(4000, a, box);
        return r;
    }
    public static void Set(long self, long T, boolean Persp, double Focus) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = T;
        a[2] = Persp ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(Focus);
        OcctGen.occtCall(4001, a, box);
    }
    public static void Directions(long self, long D1, long D2, long D3) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = D1;
        a[2] = D2;
        a[3] = D3;
        OcctGen.occtCall(4002, a, box);
    }
    public static void Scaled(long self, boolean On) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = On ? 1L : 0L;
        OcctGen.occtCall(4003, a, box);
    }
    public static boolean Perspective(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4004, a, box);
        return r != 0;
    }
    public static long Transformation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4005, a, box);
        return r;
    }
    public static long InvertedTransformation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4006, a, box);
        return r;
    }
    public static long FullTransformation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4007, a, box);
        return r;
    }
    public static double Focus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4008, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Transform(long self, long D) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = D;
        OcctGen.occtCall(4009, a, box);
    }
    public static void Transform_2(long self, long Pnt) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Pnt;
        OcctGen.occtCall(4010, a, box);
    }
    public static void Project(long self, long P, long Pout) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = Pout;
        OcctGen.occtCall(4011, a, box);
    }
    public static void Project_2(long self, long P, double[] XOut, double[] YOut, double[] ZOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        OcctGen.occtCall(4012, a, box);
        if (XOut != null && XOut.length != 0) XOut[0] = Double.longBitsToDouble(a[2]);
        if (YOut != null && YOut.length != 0) YOut[0] = Double.longBitsToDouble(a[3]);
        if (ZOut != null && ZOut.length != 0) ZOut[0] = Double.longBitsToDouble(a[4]);
    }
    public static void Project_3(long self, long P, long D1, long Pout, long D1out) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = P;
        a[2] = D1;
        a[3] = Pout;
        a[4] = D1out;
        OcctGen.occtCall(4013, a, box);
    }
    public static long Shoot(long self, double X, double Y) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(X);
        a[2] = Double.doubleToRawLongBits(Y);
        long r = OcctGen.occtCall(4014, a, box);
        return r;
    }
    }

    public static final class HLRBRep_Algo {
        private HLRBRep_Algo() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4015, a, box);
        return r;
    }
    public static long 构造_2(long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A;
        long r = OcctGen.occtCall(4016, a, box);
        return r;
    }
    public static void Add(long self, long S, long SData, int nbIso) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = SData;
        a[3] = nbIso;
        OcctGen.occtCall(4017, a, box);
    }
    public static void Add_2(long self, long S, int nbIso) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = nbIso;
        OcctGen.occtCall(4018, a, box);
    }
    public static int Index(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4019, a, box);
        return (int) r;
    }
    public static void OutLinedShapeNullify(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4020, a, box);
    }
    }

    public static final class HLRBRep_HLRToShape {
        private HLRBRep_HLRToShape() {}

    public static long 构造(long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A;
        long r = OcctGen.occtCall(4021, a, box);
        return r;
    }
    public static long VCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4022, a, box);
        return r;
    }
    public static long VCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4023, a, box);
        return r;
    }
    public static long Rg1LineVCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4024, a, box);
        return r;
    }
    public static long Rg1LineVCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4025, a, box);
        return r;
    }
    public static long RgNLineVCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4026, a, box);
        return r;
    }
    public static long RgNLineVCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4027, a, box);
        return r;
    }
    public static long OutLineVCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4028, a, box);
        return r;
    }
    public static long OutLineVCompound3d(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4029, a, box);
        return r;
    }
    public static long OutLineVCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4030, a, box);
        return r;
    }
    public static long IsoLineVCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4031, a, box);
        return r;
    }
    public static long IsoLineVCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4032, a, box);
        return r;
    }
    public static long HCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4033, a, box);
        return r;
    }
    public static long HCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4034, a, box);
        return r;
    }
    public static long Rg1LineHCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4035, a, box);
        return r;
    }
    public static long Rg1LineHCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4036, a, box);
        return r;
    }
    public static long RgNLineHCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4037, a, box);
        return r;
    }
    public static long RgNLineHCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4038, a, box);
        return r;
    }
    public static long OutLineHCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4039, a, box);
        return r;
    }
    public static long OutLineHCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4040, a, box);
        return r;
    }
    public static long IsoLineHCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4041, a, box);
        return r;
    }
    public static long IsoLineHCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4042, a, box);
        return r;
    }
    public static long CompoundOfEdges(long self, int type, boolean visible, boolean In3d) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = type;
        a[2] = visible ? 1L : 0L;
        a[3] = In3d ? 1L : 0L;
        long r = OcctGen.occtCall(4043, a, box);
        return r;
    }
    public static long CompoundOfEdges_2(
            long self, long S, int type, boolean visible, boolean In3d) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = type;
        a[3] = visible ? 1L : 0L;
        a[4] = In3d ? 1L : 0L;
        long r = OcctGen.occtCall(4044, a, box);
        return r;
    }
    }

    public static final class HLRBRep_PolyAlgo {
        private HLRBRep_PolyAlgo() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4045, a, box);
        return r;
    }
    public static long 构造_2(long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = A;
        long r = OcctGen.occtCall(4046, a, box);
        return r;
    }
    public static long 构造_3(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(4047, a, box);
        return r;
    }
    public static int NbShapes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4048, a, box);
        return (int) r;
    }
    public static long Shape(long self, int I) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = I;
        long r = OcctGen.occtCall(4049, a, box);
        return r;
    }
    public static void Remove(long self, int I) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = I;
        OcctGen.occtCall(4050, a, box);
    }
    public static int Index(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4051, a, box);
        return (int) r;
    }
    public static void Load(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        OcctGen.occtCall(4052, a, box);
    }
    public static long Projector(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4053, a, box);
        return r;
    }
    public static void Projector_2(long self, long theProj) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theProj;
        OcctGen.occtCall(4054, a, box);
    }
    public static double TolAngular(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4055, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void TolAngular_2(long self, double theTol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTol);
        OcctGen.occtCall(4056, a, box);
    }
    public static double TolCoef(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4057, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void TolCoef_2(long self, double theTol) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theTol);
        OcctGen.occtCall(4058, a, box);
    }
    public static void Update(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4059, a, box);
    }
    public static void InitHide(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4060, a, box);
    }
    public static boolean MoreHide(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4061, a, box);
        return r != 0;
    }
    public static void NextHide(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4062, a, box);
    }
    public static void InitShow(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4063, a, box);
    }
    public static boolean MoreShow(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4064, a, box);
        return r != 0;
    }
    public static void NextShow(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4065, a, box);
    }
    public static long OutLinedShape(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4066, a, box);
        return r;
    }
    public static boolean Debug(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4067, a, box);
        return r != 0;
    }
    public static void Debug_2(long self, boolean theDebug) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theDebug ? 1L : 0L;
        OcctGen.occtCall(4068, a, box);
    }
    }

    public static final class HLRBRep_PolyHLRToShape {
        private HLRBRep_PolyHLRToShape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4069, a, box);
        return r;
    }
    public static void Update(long self, long A) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = A;
        OcctGen.occtCall(4070, a, box);
    }
    public static void Show(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4071, a, box);
    }
    public static void Hide(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4072, a, box);
    }
    public static long VCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4073, a, box);
        return r;
    }
    public static long VCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4074, a, box);
        return r;
    }
    public static long Rg1LineVCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4075, a, box);
        return r;
    }
    public static long Rg1LineVCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4076, a, box);
        return r;
    }
    public static long RgNLineVCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4077, a, box);
        return r;
    }
    public static long RgNLineVCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4078, a, box);
        return r;
    }
    public static long OutLineVCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4079, a, box);
        return r;
    }
    public static long OutLineVCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4080, a, box);
        return r;
    }
    public static long HCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4081, a, box);
        return r;
    }
    public static long HCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4082, a, box);
        return r;
    }
    public static long Rg1LineHCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4083, a, box);
        return r;
    }
    public static long Rg1LineHCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4084, a, box);
        return r;
    }
    public static long RgNLineHCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4085, a, box);
        return r;
    }
    public static long RgNLineHCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4086, a, box);
        return r;
    }
    public static long OutLineHCompound(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4087, a, box);
        return r;
    }
    public static long OutLineHCompound_2(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(4088, a, box);
        return r;
    }
    }

}
