package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKFillet 类=4 方法槽=99
public final class Gen_TKFillet {
    private Gen_TKFillet() {}

    public static final class BRepFilletAPI_LocalOperation {
        private BRepFilletAPI_LocalOperation() {}

    }

    public static final class BRepFilletAPI_MakeChamfer {
        private BRepFilletAPI_MakeChamfer() {}

    public static long 构造(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(1222, a, box);
        return r;
    }
    public static void Add(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(1223, a, box);
    }
    public static void Add_2(long self, double Dis, long E) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Dis);
        a[2] = E;
        OcctGen.occtCall(1224, a, box);
    }
    public static void SetDist(long self, double Dis, int IC, long F) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Dis);
        a[2] = IC;
        a[3] = F;
        OcctGen.occtCall(1225, a, box);
    }
    public static void GetDist(long self, int IC, double[] DisOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        OcctGen.occtCall(1226, a, box);
        if (DisOut != null && DisOut.length != 0) DisOut[0] = Double.longBitsToDouble(a[2]);
    }
    public static void Add_3(long self, double Dis1, double Dis2, long E, long F) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Dis1);
        a[2] = Double.doubleToRawLongBits(Dis2);
        a[3] = E;
        a[4] = F;
        OcctGen.occtCall(1227, a, box);
    }
    public static void SetDists(long self, double Dis1, double Dis2, int IC, long F) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Dis1);
        a[2] = Double.doubleToRawLongBits(Dis2);
        a[3] = IC;
        a[4] = F;
        OcctGen.occtCall(1228, a, box);
    }
    public static void Dists(long self, int IC, double[] Dis1Out, double[] Dis2Out) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        OcctGen.occtCall(1229, a, box);
        if (Dis1Out != null && Dis1Out.length != 0) Dis1Out[0] = Double.longBitsToDouble(a[2]);
        if (Dis2Out != null && Dis2Out.length != 0) Dis2Out[0] = Double.longBitsToDouble(a[3]);
    }
    public static void AddDA(long self, double Dis, double Angle, long E, long F) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Dis);
        a[2] = Double.doubleToRawLongBits(Angle);
        a[3] = E;
        a[4] = F;
        OcctGen.occtCall(1230, a, box);
    }
    public static void SetDistAngle(long self, double Dis, double Angle, int IC, long F) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Dis);
        a[2] = Double.doubleToRawLongBits(Angle);
        a[3] = IC;
        a[4] = F;
        OcctGen.occtCall(1231, a, box);
    }
    public static void GetDistAngle(long self, int IC, double[] DisOut, double[] AngleOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        OcctGen.occtCall(1232, a, box);
        if (DisOut != null && DisOut.length != 0) DisOut[0] = Double.longBitsToDouble(a[2]);
        if (AngleOut != null && AngleOut.length != 0) AngleOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static void SetMode(long self, int theMode) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theMode;
        OcctGen.occtCall(1233, a, box);
    }
    public static boolean IsSymetric(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1234, a, box);
        return r != 0;
    }
    public static boolean IsTwoDistances(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1235, a, box);
        return r != 0;
    }
    public static boolean IsDistanceAngle(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1236, a, box);
        return r != 0;
    }
    public static void ResetContour(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        OcctGen.occtCall(1237, a, box);
    }
    public static int NbContours(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1238, a, box);
        return (int) r;
    }
    public static int Contour(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1239, a, box);
        return (int) r;
    }
    public static int NbEdges(long self, int I) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = I;
        long r = OcctGen.occtCall(1240, a, box);
        return (int) r;
    }
    public static long Edge(long self, int I, int J) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = I;
        a[2] = J;
        long r = OcctGen.occtCall(1241, a, box);
        return r;
    }
    public static void Remove(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(1242, a, box);
    }
    public static double Length(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1243, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long FirstVertex(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1244, a, box);
        return r;
    }
    public static long LastVertex(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1245, a, box);
        return r;
    }
    public static double Abscissa(long self, int IC, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        a[2] = V;
        long r = OcctGen.occtCall(1246, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double RelativeAbscissa(long self, int IC, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        a[2] = V;
        long r = OcctGen.occtCall(1247, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean ClosedAndTangent(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1248, a, box);
        return r != 0;
    }
    public static boolean Closed(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1249, a, box);
        return r != 0;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1250, a, box);
    }
    public static void Reset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1251, a, box);
    }
    public static boolean IsDeleted(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        long r = OcctGen.occtCall(1252, a, box);
        return r != 0;
    }
    public static void Simulate(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        OcctGen.occtCall(1253, a, box);
    }
    public static int NbSurf(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1254, a, box);
        return (int) r;
    }
    }

    public static final class BRepFilletAPI_MakeFillet {
        private BRepFilletAPI_MakeFillet() {}

    public static long 构造(long S, int FShape) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = S;
        a[2] = FShape;
        long r = OcctGen.occtCall(1255, a, box);
        return r;
    }
    public static void SetParams(
            long self, double Tang, double Tesp, double T2d, double TApp3d, double TolApp2d,
            double Fleche) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tang);
        a[2] = Double.doubleToRawLongBits(Tesp);
        a[3] = Double.doubleToRawLongBits(T2d);
        a[4] = Double.doubleToRawLongBits(TApp3d);
        a[5] = Double.doubleToRawLongBits(TolApp2d);
        a[6] = Double.doubleToRawLongBits(Fleche);
        OcctGen.occtCall(1256, a, box);
    }
    public static void SetContinuity(long self, int InternalContinuity, double AngularTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = InternalContinuity;
        a[2] = Double.doubleToRawLongBits(AngularTolerance);
        OcctGen.occtCall(1257, a, box);
    }
    public static void Add(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(1258, a, box);
    }
    public static void Add_2(long self, double Radius, long E) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        a[2] = E;
        OcctGen.occtCall(1259, a, box);
    }
    public static void Add_3(long self, double R1, double R2, long E) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R1);
        a[2] = Double.doubleToRawLongBits(R2);
        a[3] = E;
        OcctGen.occtCall(1260, a, box);
    }
    public static void SetRadius(long self, double Radius, int IC, int IinC) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        a[2] = IC;
        a[3] = IinC;
        OcctGen.occtCall(1261, a, box);
    }
    public static void SetRadius_2(long self, double R1, double R2, int IC, int IinC) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(R1);
        a[2] = Double.doubleToRawLongBits(R2);
        a[3] = IC;
        a[4] = IinC;
        OcctGen.occtCall(1262, a, box);
    }
    public static void ResetContour(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        OcctGen.occtCall(1263, a, box);
    }
    public static boolean IsConstant(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1264, a, box);
        return r != 0;
    }
    public static double Radius(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1265, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean IsConstant_2(long self, int IC, long E) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        a[2] = E;
        long r = OcctGen.occtCall(1266, a, box);
        return r != 0;
    }
    public static double Radius_2(long self, int IC, long E) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        a[2] = E;
        long r = OcctGen.occtCall(1267, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetRadius_3(long self, double Radius, int IC, long E) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        a[2] = IC;
        a[3] = E;
        OcctGen.occtCall(1268, a, box);
    }
    public static void SetRadius_4(long self, double Radius, int IC, long V) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        a[2] = IC;
        a[3] = V;
        OcctGen.occtCall(1269, a, box);
    }
    public static boolean GetBounds(long self, int IC, long E, double[] FOut, double[] LOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        a[2] = E;
        long r = OcctGen.occtCall(1270, a, box);
        if (FOut != null && FOut.length != 0) FOut[0] = Double.longBitsToDouble(a[3]);
        if (LOut != null && LOut.length != 0) LOut[0] = Double.longBitsToDouble(a[4]);
        return r != 0;
    }
    public static void SetFilletShape(long self, int FShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = FShape;
        OcctGen.occtCall(1271, a, box);
    }
    public static int GetFilletShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1272, a, box);
        return (int) r;
    }
    public static int NbContours(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1273, a, box);
        return (int) r;
    }
    public static int Contour(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1274, a, box);
        return (int) r;
    }
    public static int NbEdges(long self, int I) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = I;
        long r = OcctGen.occtCall(1275, a, box);
        return (int) r;
    }
    public static long Edge(long self, int I, int J) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = I;
        a[2] = J;
        long r = OcctGen.occtCall(1276, a, box);
        return r;
    }
    public static void Remove(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        OcctGen.occtCall(1277, a, box);
    }
    public static double Length(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1278, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long FirstVertex(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1279, a, box);
        return r;
    }
    public static long LastVertex(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1280, a, box);
        return r;
    }
    public static double Abscissa(long self, int IC, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        a[2] = V;
        long r = OcctGen.occtCall(1281, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double RelativeAbscissa(long self, int IC, long V) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        a[2] = V;
        long r = OcctGen.occtCall(1282, a, box);
        return Double.longBitsToDouble(r);
    }
    public static boolean ClosedAndTangent(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1283, a, box);
        return r != 0;
    }
    public static boolean Closed(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1284, a, box);
        return r != 0;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1285, a, box);
    }
    public static void Reset(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1286, a, box);
    }
    public static boolean IsDeleted(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        long r = OcctGen.occtCall(1287, a, box);
        return r != 0;
    }
    public static int NbSurfaces(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1288, a, box);
        return (int) r;
    }
    public static void Simulate(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        OcctGen.occtCall(1289, a, box);
    }
    public static int NbSurf(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1290, a, box);
        return (int) r;
    }
    public static int NbFaultyContours(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1291, a, box);
        return (int) r;
    }
    public static int FaultyContour(long self, int I) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = I;
        long r = OcctGen.occtCall(1292, a, box);
        return (int) r;
    }
    public static int NbComputedSurfaces(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1293, a, box);
        return (int) r;
    }
    public static long ComputedSurface(long self, int IC, int IS) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        a[2] = IS;
        long r = OcctGen.occtCall(1294, a, box);
        return r;
    }
    public static int NbFaultyVertices(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1295, a, box);
        return (int) r;
    }
    public static long FaultyVertex(long self, int IV) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IV;
        long r = OcctGen.occtCall(1296, a, box);
        return r;
    }
    public static boolean HasResult(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1297, a, box);
        return r != 0;
    }
    public static long BadShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1298, a, box);
        return r;
    }
    public static int StripeStatus(long self, int IC) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IC;
        long r = OcctGen.occtCall(1299, a, box);
        return (int) r;
    }
    }

    public static final class BRepFilletAPI_MakeFillet2d {
        private BRepFilletAPI_MakeFillet2d() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1300, a, box);
        return r;
    }
    public static long 构造_2(long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = F;
        long r = OcctGen.occtCall(1301, a, box);
        return r;
    }
    public static void Init(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        OcctGen.occtCall(1302, a, box);
    }
    public static void Init_2(long self, long RefFace, long ModFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = RefFace;
        a[2] = ModFace;
        OcctGen.occtCall(1303, a, box);
    }
    public static long AddFillet(long self, long V, double Radius) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = V;
        a[2] = Double.doubleToRawLongBits(Radius);
        long r = OcctGen.occtCall(1304, a, box);
        return r;
    }
    public static long ModifyFillet(long self, long Fillet, double Radius) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Fillet;
        a[2] = Double.doubleToRawLongBits(Radius);
        long r = OcctGen.occtCall(1305, a, box);
        return r;
    }
    public static long RemoveFillet(long self, long Fillet) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Fillet;
        long r = OcctGen.occtCall(1306, a, box);
        return r;
    }
    public static long AddChamfer(long self, long E1, long E2, double D1, double D2) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E1;
        a[2] = E2;
        a[3] = Double.doubleToRawLongBits(D1);
        a[4] = Double.doubleToRawLongBits(D2);
        long r = OcctGen.occtCall(1307, a, box);
        return r;
    }
    public static long AddChamfer_2(long self, long E, long V, double D, double Ang) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = V;
        a[3] = Double.doubleToRawLongBits(D);
        a[4] = Double.doubleToRawLongBits(Ang);
        long r = OcctGen.occtCall(1308, a, box);
        return r;
    }
    public static long ModifyChamfer(
            long self, long Chamfer, long E1, long E2, double D1, double D2) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = Chamfer;
        a[2] = E1;
        a[3] = E2;
        a[4] = Double.doubleToRawLongBits(D1);
        a[5] = Double.doubleToRawLongBits(D2);
        long r = OcctGen.occtCall(1309, a, box);
        return r;
    }
    public static long ModifyChamfer_2(long self, long Chamfer, long E, double D, double Ang) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Chamfer;
        a[2] = E;
        a[3] = Double.doubleToRawLongBits(D);
        a[4] = Double.doubleToRawLongBits(Ang);
        long r = OcctGen.occtCall(1310, a, box);
        return r;
    }
    public static long RemoveChamfer(long self, long Chamfer) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Chamfer;
        long r = OcctGen.occtCall(1311, a, box);
        return r;
    }
    public static boolean IsModified(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1312, a, box);
        return r != 0;
    }
    public static int NbFillet(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1313, a, box);
        return (int) r;
    }
    public static int NbChamfer(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1314, a, box);
        return (int) r;
    }
    public static int NbCurves(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1315, a, box);
        return (int) r;
    }
    public static boolean HasDescendant(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1316, a, box);
        return r != 0;
    }
    public static long DescendantEdge(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1317, a, box);
        return r;
    }
    public static long BasisEdge(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1318, a, box);
        return r;
    }
    public static int Status(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1319, a, box);
        return (int) r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1320, a, box);
    }
    }

}
