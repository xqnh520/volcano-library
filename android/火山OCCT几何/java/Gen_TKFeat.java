package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKFeat 类=12 方法槽=107
public final class Gen_TKFeat {
    private Gen_TKFeat() {}

    public static final class BRepFeat_Builder {
        private BRepFeat_Builder() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1115, a, box);
        return r;
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1116, a, box);
    }
    public static void Init(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        OcctGen.occtCall(1117, a, box);
    }
    public static void Init_2(long self, long theShape, long theTool) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        a[2] = theTool;
        OcctGen.occtCall(1118, a, box);
    }
    public static void SetOperation(long self, int theFuse) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theFuse;
        OcctGen.occtCall(1119, a, box);
    }
    public static void SetOperation_2(long self, int theFuse, boolean theFlag) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theFuse;
        a[2] = theFlag ? 1L : 0L;
        OcctGen.occtCall(1120, a, box);
    }
    public static void KeepPart(long self, long theS) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theS;
        OcctGen.occtCall(1121, a, box);
    }
    public static void PerformResult(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1122, a, box);
    }
    public static void RebuildFaces(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1123, a, box);
    }
    public static void CheckSolidImages(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1124, a, box);
    }
    public static void FillRemoved(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1125, a, box);
    }
    }

    public static final class BRepFeat_Form {
        private BRepFeat_Form() {}

    public static boolean IsDeleted(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(1126, a, box);
        return r != 0;
    }
    public static void BasisShapeValid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1127, a, box);
    }
    public static void GeneratedShapeValid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1128, a, box);
    }
    public static void ShapeFromValid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1129, a, box);
    }
    public static void ShapeUntilValid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1130, a, box);
    }
    public static void GluedFacesValid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1131, a, box);
    }
    public static void SketchFaceValid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1132, a, box);
    }
    public static void PerfSelectionValid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1133, a, box);
    }
    public static int CurrentStatusError(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1134, a, box);
        return (int) r;
    }
    }

    public static final class BRepFeat_Gluer {
        private BRepFeat_Gluer() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1135, a, box);
        return r;
    }
    public static long 构造_2(long Snew, long Sbase) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Snew;
        a[2] = Sbase;
        long r = OcctGen.occtCall(1136, a, box);
        return r;
    }
    public static void Init(long self, long Snew, long Sbase) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Snew;
        a[2] = Sbase;
        OcctGen.occtCall(1137, a, box);
    }
    public static void Bind(long self, long Fnew, long Fbase) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Fnew;
        a[2] = Fbase;
        OcctGen.occtCall(1138, a, box);
    }
    public static void Bind_2(long self, long Enew, long Ebase) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Enew;
        a[2] = Ebase;
        OcctGen.occtCall(1139, a, box);
    }
    public static int OpeType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1140, a, box);
        return (int) r;
    }
    public static long BasisShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1141, a, box);
        return r;
    }
    public static long GluedShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1142, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1143, a, box);
    }
    public static boolean IsDeleted(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        long r = OcctGen.occtCall(1144, a, box);
        return r != 0;
    }
    }

    public static final class BRepFeat_MakeCylindricalHole {
        private BRepFeat_MakeCylindricalHole() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1145, a, box);
        return r;
    }
    public static void Init(long self, long Axis) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Axis;
        OcctGen.occtCall(1146, a, box);
    }
    public static void Init_2(long self, long S, long Axis) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Axis;
        OcctGen.occtCall(1147, a, box);
    }
    public static void Perform(long self, double Radius) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        OcctGen.occtCall(1148, a, box);
    }
    public static void Perform_2(
            long self, double Radius, double PFrom, double PTo, boolean WithControl) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        a[2] = Double.doubleToRawLongBits(PFrom);
        a[3] = Double.doubleToRawLongBits(PTo);
        a[4] = WithControl ? 1L : 0L;
        OcctGen.occtCall(1149, a, box);
    }
    public static void PerformThruNext(long self, double Radius, boolean WithControl) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        a[2] = WithControl ? 1L : 0L;
        OcctGen.occtCall(1150, a, box);
    }
    public static void PerformUntilEnd(long self, double Radius, boolean WithControl) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        a[2] = WithControl ? 1L : 0L;
        OcctGen.occtCall(1151, a, box);
    }
    public static void PerformBlind(long self, double Radius, double Length, boolean WithControl) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Radius);
        a[2] = Double.doubleToRawLongBits(Length);
        a[3] = WithControl ? 1L : 0L;
        OcctGen.occtCall(1152, a, box);
    }
    public static int Status(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1153, a, box);
        return (int) r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1154, a, box);
    }
    }

    public static final class BRepFeat_MakeDPrism {
        private BRepFeat_MakeDPrism() {}

    public static long 构造(
            long Sbase, long Pbase, long Skface, double Angle, int Fuse, boolean Modify) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = Sbase;
        a[2] = Pbase;
        a[3] = Skface;
        a[4] = Double.doubleToRawLongBits(Angle);
        a[5] = Fuse;
        a[6] = Modify ? 1L : 0L;
        long r = OcctGen.occtCall(1155, a, box);
        return r;
    }
    public static long 构造_2() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1156, a, box);
        return r;
    }
    public static void Init(
            long self, long Sbase, long Pbase, long Skface, double Angle, int Fuse, boolean Modify) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Sbase;
        a[2] = Pbase;
        a[3] = Skface;
        a[4] = Double.doubleToRawLongBits(Angle);
        a[5] = Fuse;
        a[6] = Modify ? 1L : 0L;
        OcctGen.occtCall(1157, a, box);
    }
    public static void Add(long self, long E, long OnFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = OnFace;
        OcctGen.occtCall(1158, a, box);
    }
    public static void Perform(long self, double Height) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Height);
        OcctGen.occtCall(1159, a, box);
    }
    public static void Perform_2(long self, long Until) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Until;
        OcctGen.occtCall(1160, a, box);
    }
    public static void Perform_3(long self, long From, long Until) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = From;
        a[2] = Until;
        OcctGen.occtCall(1161, a, box);
    }
    public static void PerformUntilEnd(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1162, a, box);
    }
    public static void PerformFromEnd(long self, long FUntil) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = FUntil;
        OcctGen.occtCall(1163, a, box);
    }
    public static void PerformThruAll(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1164, a, box);
    }
    public static void PerformUntilHeight(long self, long Until, double Height) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Until;
        a[2] = Double.doubleToRawLongBits(Height);
        OcctGen.occtCall(1165, a, box);
    }
    public static long BarycCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1166, a, box);
        return r;
    }
    public static void BossEdges(long self, int sig) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = sig;
        OcctGen.occtCall(1167, a, box);
    }
    }

    public static final class BRepFeat_MakeLinearForm {
        private BRepFeat_MakeLinearForm() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1168, a, box);
        return r;
    }
    public static long 构造_2(
            long Sbase, long W, long P, long Direction, long Direction1, int Fuse, boolean Modify) {
        long[] a = new long[8];
        Object[] box = null;
        a[1] = Sbase;
        a[2] = W;
        a[3] = P;
        a[4] = Direction;
        a[5] = Direction1;
        a[6] = Fuse;
        a[7] = Modify ? 1L : 0L;
        long r = OcctGen.occtCall(1169, a, box);
        return r;
    }
    public static void Init(
            long self, long Sbase, long W, long P, long Direction, long Direction1, int Fuse,
            boolean Modify) {
        long[] a = new long[8];
        Object[] box = null;
        a[0] = self;
        a[1] = Sbase;
        a[2] = W;
        a[3] = P;
        a[4] = Direction;
        a[5] = Direction1;
        a[6] = Fuse;
        a[7] = Modify ? 1L : 0L;
        OcctGen.occtCall(1170, a, box);
    }
    public static void Add(long self, long E, long OnFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = OnFace;
        OcctGen.occtCall(1171, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1172, a, box);
    }
    public static void TransformShapeFU(long self, int flag) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = flag;
        OcctGen.occtCall(1173, a, box);
    }
    }

    public static final class BRepFeat_MakePipe {
        private BRepFeat_MakePipe() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1174, a, box);
        return r;
    }
    public static long 构造_2(
            long Sbase, long Pbase, long Skface, long Spine, int Fuse, boolean Modify) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = Sbase;
        a[2] = Pbase;
        a[3] = Skface;
        a[4] = Spine;
        a[5] = Fuse;
        a[6] = Modify ? 1L : 0L;
        long r = OcctGen.occtCall(1175, a, box);
        return r;
    }
    public static void Init(
            long self, long Sbase, long Pbase, long Skface, long Spine, int Fuse, boolean Modify) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Sbase;
        a[2] = Pbase;
        a[3] = Skface;
        a[4] = Spine;
        a[5] = Fuse;
        a[6] = Modify ? 1L : 0L;
        OcctGen.occtCall(1176, a, box);
    }
    public static void Add(long self, long E, long OnFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = OnFace;
        OcctGen.occtCall(1177, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1178, a, box);
    }
    public static void Perform_2(long self, long Until) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Until;
        OcctGen.occtCall(1179, a, box);
    }
    public static void Perform_3(long self, long From, long Until) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = From;
        a[2] = Until;
        OcctGen.occtCall(1180, a, box);
    }
    public static long BarycCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1181, a, box);
        return r;
    }
    }

    public static final class BRepFeat_MakePrism {
        private BRepFeat_MakePrism() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1182, a, box);
        return r;
    }
    public static long 构造_2(
            long Sbase, long Pbase, long Skface, long Direction, int Fuse, boolean Modify) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = Sbase;
        a[2] = Pbase;
        a[3] = Skface;
        a[4] = Direction;
        a[5] = Fuse;
        a[6] = Modify ? 1L : 0L;
        long r = OcctGen.occtCall(1183, a, box);
        return r;
    }
    public static void Init(
            long self, long Sbase, long Pbase, long Skface, long Direction, int Fuse,
            boolean Modify) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Sbase;
        a[2] = Pbase;
        a[3] = Skface;
        a[4] = Direction;
        a[5] = Fuse;
        a[6] = Modify ? 1L : 0L;
        OcctGen.occtCall(1184, a, box);
    }
    public static void Add(long self, long E, long OnFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = OnFace;
        OcctGen.occtCall(1185, a, box);
    }
    public static void Perform(long self, double Length) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Length);
        OcctGen.occtCall(1186, a, box);
    }
    public static void Perform_2(long self, long Until) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Until;
        OcctGen.occtCall(1187, a, box);
    }
    public static void Perform_3(long self, long From, long Until) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = From;
        a[2] = Until;
        OcctGen.occtCall(1188, a, box);
    }
    public static void PerformUntilEnd(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1189, a, box);
    }
    public static void PerformFromEnd(long self, long FUntil) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = FUntil;
        OcctGen.occtCall(1190, a, box);
    }
    public static void PerformThruAll(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1191, a, box);
    }
    public static void PerformUntilHeight(long self, long Until, double Length) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Until;
        a[2] = Double.doubleToRawLongBits(Length);
        OcctGen.occtCall(1192, a, box);
    }
    public static long BarycCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1193, a, box);
        return r;
    }
    }

    public static final class BRepFeat_MakeRevol {
        private BRepFeat_MakeRevol() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1194, a, box);
        return r;
    }
    public static long 构造_2(
            long Sbase, long Pbase, long Skface, long Axis, int Fuse, boolean Modify) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = Sbase;
        a[2] = Pbase;
        a[3] = Skface;
        a[4] = Axis;
        a[5] = Fuse;
        a[6] = Modify ? 1L : 0L;
        long r = OcctGen.occtCall(1195, a, box);
        return r;
    }
    public static void Init(
            long self, long Sbase, long Pbase, long Skface, long Axis, int Fuse, boolean Modify) {
        long[] a = new long[7];
        Object[] box = null;
        a[0] = self;
        a[1] = Sbase;
        a[2] = Pbase;
        a[3] = Skface;
        a[4] = Axis;
        a[5] = Fuse;
        a[6] = Modify ? 1L : 0L;
        OcctGen.occtCall(1196, a, box);
    }
    public static void Add(long self, long E, long OnFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = OnFace;
        OcctGen.occtCall(1197, a, box);
    }
    public static void Perform(long self, double Angle) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Angle);
        OcctGen.occtCall(1198, a, box);
    }
    public static void Perform_2(long self, long Until) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Until;
        OcctGen.occtCall(1199, a, box);
    }
    public static void Perform_3(long self, long From, long Until) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = From;
        a[2] = Until;
        OcctGen.occtCall(1200, a, box);
    }
    public static void PerformThruAll(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1201, a, box);
    }
    public static void PerformUntilAngle(long self, long Until, double Angle) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Until;
        a[2] = Double.doubleToRawLongBits(Angle);
        OcctGen.occtCall(1202, a, box);
    }
    public static long BarycCurve(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1203, a, box);
        return r;
    }
    }

    public static final class BRepFeat_MakeRevolutionForm {
        private BRepFeat_MakeRevolutionForm() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1204, a, box);
        return r;
    }
    public static long 构造_2(
            long Sbase, long W, long Plane, long Axis, double Height1, double Height2, int Fuse,
            boolean[] SlidingOut) {
        long[] a = new long[9];
        Object[] box = null;
        a[1] = Sbase;
        a[2] = W;
        a[3] = Plane;
        a[4] = Axis;
        a[5] = Double.doubleToRawLongBits(Height1);
        a[6] = Double.doubleToRawLongBits(Height2);
        a[7] = Fuse;
        long r = OcctGen.occtCall(1205, a, box);
        if (SlidingOut != null && SlidingOut.length != 0) SlidingOut[0] = a[8] != 0;
        return r;
    }
    public static void Init(
            long self, long Sbase, long W, long Plane, long Axis, double Height1, double Height2,
            int Fuse, boolean[] SlidingOut) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[1] = Sbase;
        a[2] = W;
        a[3] = Plane;
        a[4] = Axis;
        a[5] = Double.doubleToRawLongBits(Height1);
        a[6] = Double.doubleToRawLongBits(Height2);
        a[7] = Fuse;
        OcctGen.occtCall(1206, a, box);
        if (SlidingOut != null && SlidingOut.length != 0) SlidingOut[0] = a[8] != 0;
    }
    public static void Add(long self, long E, long OnFace) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = OnFace;
        OcctGen.occtCall(1207, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1208, a, box);
    }
    }

    public static final class BRepFeat_RibSlot {
        private BRepFeat_RibSlot() {}

    public static boolean IsDeleted(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        long r = OcctGen.occtCall(1209, a, box);
        return r != 0;
    }
    public static double IntPar(long C, long P) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = C;
        a[2] = P;
        long r = OcctGen.occtCall(1210, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int CurrentStatusError(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1211, a, box);
        return (int) r;
    }
    }

    public static final class BRepFeat_SplitShape {
        private BRepFeat_SplitShape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1212, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(1213, a, box);
        return r;
    }
    public static void Init(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1214, a, box);
    }
    public static void SetCheckInterior(long self, boolean ToCheckInterior) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ToCheckInterior ? 1L : 0L;
        OcctGen.occtCall(1215, a, box);
    }
    public static void Add(long self, long W, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = W;
        a[2] = F;
        OcctGen.occtCall(1216, a, box);
    }
    public static void Add_2(long self, long E, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = F;
        OcctGen.occtCall(1217, a, box);
    }
    public static void Add_3(long self, long Comp, long F) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Comp;
        a[2] = F;
        OcctGen.occtCall(1218, a, box);
    }
    public static void Add_4(long self, long E, long EOn) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        a[2] = EOn;
        OcctGen.occtCall(1219, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1220, a, box);
    }
    public static boolean IsDeleted(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(1221, a, box);
        return r != 0;
    }
    }

}
