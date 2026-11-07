package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKOffset 类=13 方法槽=143
public final class Gen_TKOffset {
    private Gen_TKOffset() {}

    public static final class BRepOffsetAPI_DraftAngle {
        private BRepOffsetAPI_DraftAngle() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1541, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(1542, a, box);
        return r;
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1543, a, box);
    }
    public static void Init(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1544, a, box);
    }
    public static void Add(
            long self, long F, long Direction, double Angle, long NeutralPlane, boolean Flag) {
        long[] a = new long[6];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        a[2] = Direction;
        a[3] = Double.doubleToRawLongBits(Angle);
        a[4] = NeutralPlane;
        a[5] = Flag ? 1L : 0L;
        OcctGen.occtCall(1545, a, box);
    }
    public static boolean AddDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1546, a, box);
        return r != 0;
    }
    public static void Remove(long self, long F) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = F;
        OcctGen.occtCall(1547, a, box);
    }
    public static long ProblematicShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1548, a, box);
        return r;
    }
    public static int Status(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1549, a, box);
        return (int) r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1550, a, box);
    }
    public static void CorrectWires(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1551, a, box);
    }
    public static long ModifiedShape(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(1552, a, box);
        return r;
    }
    }

    public static final class BRepOffsetAPI_FindContigousEdges {
        private BRepOffsetAPI_FindContigousEdges() {}

    public static long 构造(double tolerance, boolean option) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(tolerance);
        a[2] = option ? 1L : 0L;
        long r = OcctGen.occtCall(1553, a, box);
        return r;
    }
    public static void Init(long self, double tolerance, boolean option) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(tolerance);
        a[2] = option ? 1L : 0L;
        OcctGen.occtCall(1554, a, box);
    }
    public static void Add(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        OcctGen.occtCall(1555, a, box);
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1556, a, box);
    }
    public static int NbEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1557, a, box);
        return (int) r;
    }
    public static int NbContigousEdges(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1558, a, box);
        return (int) r;
    }
    public static long ContigousEdge(long self, int index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = index;
        long r = OcctGen.occtCall(1559, a, box);
        return r;
    }
    public static long SectionToBoundary(long self, long section) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = section;
        long r = OcctGen.occtCall(1560, a, box);
        return r;
    }
    public static int NbDegeneratedShapes(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1561, a, box);
        return (int) r;
    }
    public static long DegeneratedShape(long self, int index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = index;
        long r = OcctGen.occtCall(1562, a, box);
        return r;
    }
    public static boolean IsDegenerated(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(1563, a, box);
        return r != 0;
    }
    public static boolean IsModified(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(1564, a, box);
        return r != 0;
    }
    public static long Modified(long self, long shape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = shape;
        long r = OcctGen.occtCall(1565, a, box);
        return r;
    }
    public static void Dump(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1566, a, box);
    }
    }

    public static final class BRepOffsetAPI_MakeDraft {
        private BRepOffsetAPI_MakeDraft() {}

    public static long 构造(long Shape, long Dir, double Angle) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Shape;
        a[2] = Dir;
        a[3] = Double.doubleToRawLongBits(Angle);
        long r = OcctGen.occtCall(1567, a, box);
        return r;
    }
    public static void SetOptions(long self, int Style, double AngleMin, double AngleMax) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Style;
        a[2] = Double.doubleToRawLongBits(AngleMin);
        a[3] = Double.doubleToRawLongBits(AngleMax);
        OcctGen.occtCall(1568, a, box);
    }
    public static void SetDraft(long self, boolean IsInternal) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IsInternal ? 1L : 0L;
        OcctGen.occtCall(1569, a, box);
    }
    public static void Perform(long self, double LengthMax) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(LengthMax);
        OcctGen.occtCall(1570, a, box);
    }
    public static void Perform_2(long self, long Surface, boolean KeepInsideSurface) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Surface;
        a[2] = KeepInsideSurface ? 1L : 0L;
        OcctGen.occtCall(1571, a, box);
    }
    public static void Perform_3(long self, long StopShape, boolean KeepOutSide) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = StopShape;
        a[2] = KeepOutSide ? 1L : 0L;
        OcctGen.occtCall(1572, a, box);
    }
    public static long Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1573, a, box);
        return r;
    }
    }

    public static final class BRepOffsetAPI_MakeEvolved {
        private BRepOffsetAPI_MakeEvolved() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1574, a, box);
        return r;
    }
    public static long 构造_2(
            long theSpine, long theProfile, int theJoinType, boolean theIsAxeProf,
            boolean theIsSolid, boolean theIsProfOnSpine, double theTol, boolean theIsVolume,
            boolean theRunInParallel) {
        long[] a = new long[10];
        Object[] box = null;
        a[1] = theSpine;
        a[2] = theProfile;
        a[3] = theJoinType;
        a[4] = theIsAxeProf ? 1L : 0L;
        a[5] = theIsSolid ? 1L : 0L;
        a[6] = theIsProfOnSpine ? 1L : 0L;
        a[7] = Double.doubleToRawLongBits(theTol);
        a[8] = theIsVolume ? 1L : 0L;
        a[9] = theRunInParallel ? 1L : 0L;
        long r = OcctGen.occtCall(1575, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1576, a, box);
    }
    public static long Top(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1577, a, box);
        return r;
    }
    public static long Bottom(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1578, a, box);
        return r;
    }
    }

    public static final class BRepOffsetAPI_MakeFilling {
        private BRepOffsetAPI_MakeFilling() {}

    public static long 构造(
            int Degree, int NbPtsOnCur, int NbIter, boolean Anisotropie, double Tol2d,
            double Tol3d, double TolAng, double TolCurv, int MaxDeg, int MaxSegments) {
        long[] a = new long[11];
        Object[] box = null;
        a[1] = Degree;
        a[2] = NbPtsOnCur;
        a[3] = NbIter;
        a[4] = Anisotropie ? 1L : 0L;
        a[5] = Double.doubleToRawLongBits(Tol2d);
        a[6] = Double.doubleToRawLongBits(Tol3d);
        a[7] = Double.doubleToRawLongBits(TolAng);
        a[8] = Double.doubleToRawLongBits(TolCurv);
        a[9] = MaxDeg;
        a[10] = MaxSegments;
        long r = OcctGen.occtCall(1579, a, box);
        return r;
    }
    public static void SetConstrParam(
            long self, double Tol2d, double Tol3d, double TolAng, double TolCurv) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tol2d);
        a[2] = Double.doubleToRawLongBits(Tol3d);
        a[3] = Double.doubleToRawLongBits(TolAng);
        a[4] = Double.doubleToRawLongBits(TolCurv);
        OcctGen.occtCall(1580, a, box);
    }
    public static void SetResolParam(
            long self, int Degree, int NbPtsOnCur, int NbIter, boolean Anisotropie) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Degree;
        a[2] = NbPtsOnCur;
        a[3] = NbIter;
        a[4] = Anisotropie ? 1L : 0L;
        OcctGen.occtCall(1581, a, box);
    }
    public static void SetApproxParam(long self, int MaxDeg, int MaxSegments) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = MaxDeg;
        a[2] = MaxSegments;
        OcctGen.occtCall(1582, a, box);
    }
    public static void LoadInitSurface(long self, long Surf) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Surf;
        OcctGen.occtCall(1583, a, box);
    }
    public static int Add(long self, long Constr, int Order, boolean IsBound) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Constr;
        a[2] = Order;
        a[3] = IsBound ? 1L : 0L;
        long r = OcctGen.occtCall(1584, a, box);
        return (int) r;
    }
    public static int Add_2(long self, long Constr, long Support, int Order, boolean IsBound) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Constr;
        a[2] = Support;
        a[3] = Order;
        a[4] = IsBound ? 1L : 0L;
        long r = OcctGen.occtCall(1585, a, box);
        return (int) r;
    }
    public static int Add_3(long self, long Support, int Order) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Support;
        a[2] = Order;
        long r = OcctGen.occtCall(1586, a, box);
        return (int) r;
    }
    public static int Add_4(long self, long Point) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Point;
        long r = OcctGen.occtCall(1587, a, box);
        return (int) r;
    }
    public static int Add_5(long self, double U, double V, long Support, int Order) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(U);
        a[2] = Double.doubleToRawLongBits(V);
        a[3] = Support;
        a[4] = Order;
        long r = OcctGen.occtCall(1588, a, box);
        return (int) r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1589, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1590, a, box);
        return r != 0;
    }
    public static double G0Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1591, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double G1Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1592, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double G2Error(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1593, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double G0Error_2(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(1594, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double G1Error_2(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(1595, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double G2Error_2(long self, int Index) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Index;
        long r = OcctGen.occtCall(1596, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepOffsetAPI_MakeOffset {
        private BRepOffsetAPI_MakeOffset() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1597, a, box);
        return r;
    }
    public static long 构造_2(long Spine, int Join, boolean IsOpenResult) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Spine;
        a[2] = Join;
        a[3] = IsOpenResult ? 1L : 0L;
        long r = OcctGen.occtCall(1598, a, box);
        return r;
    }
    public static void Init(long self, long Spine, int Join, boolean IsOpenResult) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Spine;
        a[2] = Join;
        a[3] = IsOpenResult ? 1L : 0L;
        OcctGen.occtCall(1599, a, box);
    }
    public static long 构造_3(long Spine, int Join, boolean IsOpenResult) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Spine;
        a[2] = Join;
        a[3] = IsOpenResult ? 1L : 0L;
        long r = OcctGen.occtCall(1600, a, box);
        return r;
    }
    public static void Init_2(long self, int Join, boolean IsOpenResult) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Join;
        a[2] = IsOpenResult ? 1L : 0L;
        OcctGen.occtCall(1601, a, box);
    }
    public static void SetApprox(long self, boolean ToApprox) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ToApprox ? 1L : 0L;
        OcctGen.occtCall(1602, a, box);
    }
    public static void AddWire(long self, long Spine) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Spine;
        OcctGen.occtCall(1603, a, box);
    }
    public static void Perform(long self, double Offset, double Alt) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Offset);
        a[2] = Double.doubleToRawLongBits(Alt);
        OcctGen.occtCall(1604, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1605, a, box);
    }
    public static long ConvertFace(long theFace, double theAngleTolerance) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theFace;
        a[2] = Double.doubleToRawLongBits(theAngleTolerance);
        long r = OcctGen.occtCall(1606, a, box);
        return r;
    }
    }

    public static final class BRepOffsetAPI_MakeOffsetShape {
        private BRepOffsetAPI_MakeOffsetShape() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1607, a, box);
        return r;
    }
    public static void PerformBySimple(long self, long theS, double theOffsetValue) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theS;
        a[2] = Double.doubleToRawLongBits(theOffsetValue);
        OcctGen.occtCall(1608, a, box);
    }
    public static void PerformByJoin(
            long self, long S, double Offset, double Tol, int Mode, boolean Intersection,
            boolean SelfInter, int Join, boolean RemoveIntEdges) {
        long[] a = new long[9];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = Double.doubleToRawLongBits(Offset);
        a[3] = Double.doubleToRawLongBits(Tol);
        a[4] = Mode;
        a[5] = Intersection ? 1L : 0L;
        a[6] = SelfInter ? 1L : 0L;
        a[7] = Join;
        a[8] = RemoveIntEdges ? 1L : 0L;
        OcctGen.occtCall(1609, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1610, a, box);
    }
    public static boolean IsDeleted(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(1611, a, box);
        return r != 0;
    }
    public static int GetJoinType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1612, a, box);
        return (int) r;
    }
    }

    public static final class BRepOffsetAPI_MakePipe {
        private BRepOffsetAPI_MakePipe() {}

    public static long 构造(long Spine, long Profile) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Spine;
        a[2] = Profile;
        long r = OcctGen.occtCall(1613, a, box);
        return r;
    }
    public static long 构造_2(long Spine, long Profile, int aMode, boolean ForceApproxC1) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Spine;
        a[2] = Profile;
        a[3] = aMode;
        a[4] = ForceApproxC1 ? 1L : 0L;
        long r = OcctGen.occtCall(1614, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1615, a, box);
    }
    public static long FirstShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1616, a, box);
        return r;
    }
    public static long LastShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1617, a, box);
        return r;
    }
    public static long Generated(long self, long SSpine, long SProfile) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = SSpine;
        a[2] = SProfile;
        long r = OcctGen.occtCall(1618, a, box);
        return r;
    }
    public static double ErrorOnSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1619, a, box);
        return Double.longBitsToDouble(r);
    }
    }

    public static final class BRepOffsetAPI_MakePipeShell {
        private BRepOffsetAPI_MakePipeShell() {}

    public static long 构造(long Spine) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Spine;
        long r = OcctGen.occtCall(1620, a, box);
        return r;
    }
    public static void SetMode(long self, boolean IsFrenet) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = IsFrenet ? 1L : 0L;
        OcctGen.occtCall(1621, a, box);
    }
    public static void SetDiscreteMode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1622, a, box);
    }
    public static void SetMode_2(long self, long Axe) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Axe;
        OcctGen.occtCall(1623, a, box);
    }
    public static void SetMode_3(long self, long BiNormal) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = BiNormal;
        OcctGen.occtCall(1624, a, box);
    }
    public static boolean SetMode_4(long self, long SpineSupport) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = SpineSupport;
        long r = OcctGen.occtCall(1625, a, box);
        return r != 0;
    }
    public static void SetMode_5(
            long self, long AuxiliarySpine, boolean CurvilinearEquivalence, int KeepContact) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = AuxiliarySpine;
        a[2] = CurvilinearEquivalence ? 1L : 0L;
        a[3] = KeepContact;
        OcctGen.occtCall(1626, a, box);
    }
    public static void Add(long self, long Profile, boolean WithContact, boolean WithCorrection) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Profile;
        a[2] = WithContact ? 1L : 0L;
        a[3] = WithCorrection ? 1L : 0L;
        OcctGen.occtCall(1627, a, box);
    }
    public static void Add_2(
            long self, long Profile, long Location, boolean WithContact, boolean WithCorrection) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Profile;
        a[2] = Location;
        a[3] = WithContact ? 1L : 0L;
        a[4] = WithCorrection ? 1L : 0L;
        OcctGen.occtCall(1628, a, box);
    }
    public static void Delete(long self, long Profile) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Profile;
        OcctGen.occtCall(1629, a, box);
    }
    public static boolean IsReady(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1630, a, box);
        return r != 0;
    }
    public static int GetStatus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1631, a, box);
        return (int) r;
    }
    public static void SetTolerance(long self, double Tol3d, double BoundTol, double TolAngular) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(Tol3d);
        a[2] = Double.doubleToRawLongBits(BoundTol);
        a[3] = Double.doubleToRawLongBits(TolAngular);
        OcctGen.occtCall(1632, a, box);
    }
    public static void SetMaxDegree(long self, int NewMaxDegree) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = NewMaxDegree;
        OcctGen.occtCall(1633, a, box);
    }
    public static void SetMaxSegments(long self, int NewMaxSegments) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = NewMaxSegments;
        OcctGen.occtCall(1634, a, box);
    }
    public static void SetForceApproxC1(long self, boolean ForceApproxC1) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ForceApproxC1 ? 1L : 0L;
        OcctGen.occtCall(1635, a, box);
    }
    public static void SetTransitionMode(long self, int Mode) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Mode;
        OcctGen.occtCall(1636, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1637, a, box);
    }
    public static boolean MakeSolid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1638, a, box);
        return r != 0;
    }
    public static long FirstShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1639, a, box);
        return r;
    }
    public static long LastShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1640, a, box);
        return r;
    }
    public static double ErrorOnSurface(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1641, a, box);
        return Double.longBitsToDouble(r);
    }
    public static long Spine(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1642, a, box);
        return r;
    }
    }

    public static final class BRepOffsetAPI_MakeThickSolid {
        private BRepOffsetAPI_MakeThickSolid() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1643, a, box);
        return r;
    }
    public static void MakeThickSolidBySimple(long self, long theS, double theOffsetValue) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = theS;
        a[2] = Double.doubleToRawLongBits(theOffsetValue);
        OcctGen.occtCall(1644, a, box);
    }
    public static void MakeThickSolidByJoin(
            long self, long S, long ClosingFaces, double Offset, double Tol, int Mode,
            boolean Intersection, boolean SelfInter, int Join, boolean RemoveIntEdges) {
        long[] a = new long[10];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        a[2] = ClosingFaces;
        a[3] = Double.doubleToRawLongBits(Offset);
        a[4] = Double.doubleToRawLongBits(Tol);
        a[5] = Mode;
        a[6] = Intersection ? 1L : 0L;
        a[7] = SelfInter ? 1L : 0L;
        a[8] = Join;
        a[9] = RemoveIntEdges ? 1L : 0L;
        OcctGen.occtCall(1645, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1646, a, box);
    }
    }

    public static final class BRepOffsetAPI_MiddlePath {
        private BRepOffsetAPI_MiddlePath() {}

    public static long 构造(long aShape, long StartShape, long EndShape) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = aShape;
        a[2] = StartShape;
        a[3] = EndShape;
        long r = OcctGen.occtCall(1647, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1648, a, box);
    }
    }

    public static final class BRepOffsetAPI_NormalProjection {
        private BRepOffsetAPI_NormalProjection() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1649, a, box);
        return r;
    }
    public static long 构造_2(long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = S;
        long r = OcctGen.occtCall(1650, a, box);
        return r;
    }
    public static void Init(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        OcctGen.occtCall(1651, a, box);
    }
    public static void Add(long self, long ToProj) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ToProj;
        OcctGen.occtCall(1652, a, box);
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
        OcctGen.occtCall(1653, a, box);
    }
    public static void SetMaxDistance(long self, double MaxDist) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(MaxDist);
        OcctGen.occtCall(1654, a, box);
    }
    public static void SetLimit(long self, boolean FaceBoundaries) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = FaceBoundaries ? 1L : 0L;
        OcctGen.occtCall(1655, a, box);
    }
    public static void Compute3d(long self, boolean With3d) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = With3d ? 1L : 0L;
        OcctGen.occtCall(1656, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1657, a, box);
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1658, a, box);
        return r != 0;
    }
    public static long Projection(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1659, a, box);
        return r;
    }
    public static long Couple(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1660, a, box);
        return r;
    }
    public static long Ancestor(long self, long E) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = E;
        long r = OcctGen.occtCall(1661, a, box);
        return r;
    }
    }

    public static final class BRepOffsetAPI_ThruSections {
        private BRepOffsetAPI_ThruSections() {}

    public static long 构造(boolean isSolid, boolean ruled, double pres3d) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = isSolid ? 1L : 0L;
        a[2] = ruled ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(pres3d);
        long r = OcctGen.occtCall(1662, a, box);
        return r;
    }
    public static void Init(long self, boolean isSolid, boolean ruled, double pres3d) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = isSolid ? 1L : 0L;
        a[2] = ruled ? 1L : 0L;
        a[3] = Double.doubleToRawLongBits(pres3d);
        OcctGen.occtCall(1663, a, box);
    }
    public static void AddWire(long self, long wire) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = wire;
        OcctGen.occtCall(1664, a, box);
    }
    public static void AddVertex(long self, long aVertex) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = aVertex;
        OcctGen.occtCall(1665, a, box);
    }
    public static void CheckCompatibility(long self, boolean check) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = check ? 1L : 0L;
        OcctGen.occtCall(1666, a, box);
    }
    public static void SetSmoothing(long self, boolean UseSmoothing) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = UseSmoothing ? 1L : 0L;
        OcctGen.occtCall(1667, a, box);
    }
    public static void SetParType(long self, int ParType) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ParType;
        OcctGen.occtCall(1668, a, box);
    }
    public static void SetContinuity(long self, int C) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        OcctGen.occtCall(1669, a, box);
    }
    public static void SetCriteriumWeight(long self, double W1, double W2, double W3) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(W1);
        a[2] = Double.doubleToRawLongBits(W2);
        a[3] = Double.doubleToRawLongBits(W3);
        OcctGen.occtCall(1670, a, box);
    }
    public static void SetMaxDegree(long self, int MaxDeg) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = MaxDeg;
        OcctGen.occtCall(1671, a, box);
    }
    public static int ParType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1672, a, box);
        return (int) r;
    }
    public static int Continuity(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1673, a, box);
        return (int) r;
    }
    public static int MaxDegree(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1674, a, box);
        return (int) r;
    }
    public static boolean UseSmoothing(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1675, a, box);
        return r != 0;
    }
    public static void CriteriumWeight(long self, double[] W1Out, double[] W2Out, double[] W3Out) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1676, a, box);
        if (W1Out != null && W1Out.length != 0) W1Out[0] = Double.longBitsToDouble(a[1]);
        if (W2Out != null && W2Out.length != 0) W2Out[0] = Double.longBitsToDouble(a[2]);
        if (W3Out != null && W3Out.length != 0) W3Out[0] = Double.longBitsToDouble(a[3]);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1677, a, box);
    }
    public static long FirstShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1678, a, box);
        return r;
    }
    public static long LastShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1679, a, box);
        return r;
    }
    public static long GeneratedFace(long self, long Edge) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Edge;
        long r = OcctGen.occtCall(1680, a, box);
        return r;
    }
    public static void SetMutableInput(long self, boolean theIsMutableInput) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theIsMutableInput ? 1L : 0L;
        OcctGen.occtCall(1681, a, box);
    }
    public static boolean IsMutableInput(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1682, a, box);
        return r != 0;
    }
    public static int GetStatus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1683, a, box);
        return (int) r;
    }
    }

}
