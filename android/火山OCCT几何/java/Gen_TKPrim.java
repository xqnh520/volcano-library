package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKPrim 类=12 方法槽=93
public final class Gen_TKPrim {
    private Gen_TKPrim() {}

    public static final class BRepPrimAPI_MakeBox {
        private BRepPrimAPI_MakeBox() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1684, a, box);
        return r;
    }
    public static long 构造_2(double dx, double dy, double dz) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(dx);
        a[2] = Double.doubleToRawLongBits(dy);
        a[3] = Double.doubleToRawLongBits(dz);
        long r = OcctGen.occtCall(1685, a, box);
        return r;
    }
    public static long 构造_3(long P, double dx, double dy, double dz) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = P;
        a[2] = Double.doubleToRawLongBits(dx);
        a[3] = Double.doubleToRawLongBits(dy);
        a[4] = Double.doubleToRawLongBits(dz);
        long r = OcctGen.occtCall(1686, a, box);
        return r;
    }
    public static long 构造_4(long P1, long P2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = P1;
        a[2] = P2;
        long r = OcctGen.occtCall(1687, a, box);
        return r;
    }
    public static long 构造_5(long Axes, double dx, double dy, double dz) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(dx);
        a[3] = Double.doubleToRawLongBits(dy);
        a[4] = Double.doubleToRawLongBits(dz);
        long r = OcctGen.occtCall(1688, a, box);
        return r;
    }
    public static void Init(long self, double theDX, double theDY, double theDZ) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDX);
        a[2] = Double.doubleToRawLongBits(theDY);
        a[3] = Double.doubleToRawLongBits(theDZ);
        OcctGen.occtCall(1689, a, box);
    }
    public static void Init_2(long self, long thePnt, double theDX, double theDY, double theDZ) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = thePnt;
        a[2] = Double.doubleToRawLongBits(theDX);
        a[3] = Double.doubleToRawLongBits(theDY);
        a[4] = Double.doubleToRawLongBits(theDZ);
        OcctGen.occtCall(1690, a, box);
    }
    public static void Init_3(long self, long thePnt1, long thePnt2) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = thePnt1;
        a[2] = thePnt2;
        OcctGen.occtCall(1691, a, box);
    }
    public static void Init_4(long self, long theAxes, double theDX, double theDY, double theDZ) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = theAxes;
        a[2] = Double.doubleToRawLongBits(theDX);
        a[3] = Double.doubleToRawLongBits(theDY);
        a[4] = Double.doubleToRawLongBits(theDZ);
        OcctGen.occtCall(1692, a, box);
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1693, a, box);
    }
    public static long Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1694, a, box);
        return r;
    }
    public static long 转TopoDS_Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1695, a, box);
        return r;
    }
    public static long Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1696, a, box);
        return r;
    }
    public static long 转TopoDS_Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1697, a, box);
        return r;
    }
    public static long BottomFace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1698, a, box);
        return r;
    }
    public static long BackFace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1699, a, box);
        return r;
    }
    public static long FrontFace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1700, a, box);
        return r;
    }
    public static long LeftFace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1701, a, box);
        return r;
    }
    public static long RightFace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1702, a, box);
        return r;
    }
    public static long TopFace(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1703, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakeCone {
        private BRepPrimAPI_MakeCone() {}

    public static long 构造(double R1, double R2, double H) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R1);
        a[2] = Double.doubleToRawLongBits(R2);
        a[3] = Double.doubleToRawLongBits(H);
        long r = OcctGen.occtCall(1704, a, box);
        return r;
    }
    public static long 构造_2(double R1, double R2, double H, double angle) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R1);
        a[2] = Double.doubleToRawLongBits(R2);
        a[3] = Double.doubleToRawLongBits(H);
        a[4] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1705, a, box);
        return r;
    }
    public static long 构造_3(long Axes, double R1, double R2, double H) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(R1);
        a[3] = Double.doubleToRawLongBits(R2);
        a[4] = Double.doubleToRawLongBits(H);
        long r = OcctGen.occtCall(1706, a, box);
        return r;
    }
    public static long 构造_4(long Axes, double R1, double R2, double H, double angle) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(R1);
        a[3] = Double.doubleToRawLongBits(R2);
        a[4] = Double.doubleToRawLongBits(H);
        a[5] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1707, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakeCylinder {
        private BRepPrimAPI_MakeCylinder() {}

    public static long 构造(double R, double H) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        a[2] = Double.doubleToRawLongBits(H);
        long r = OcctGen.occtCall(1708, a, box);
        return r;
    }
    public static long 构造_2(double R, double H, double Angle) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        a[2] = Double.doubleToRawLongBits(H);
        a[3] = Double.doubleToRawLongBits(Angle);
        long r = OcctGen.occtCall(1709, a, box);
        return r;
    }
    public static long 构造_3(long Axes, double R, double H) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(R);
        a[3] = Double.doubleToRawLongBits(H);
        long r = OcctGen.occtCall(1710, a, box);
        return r;
    }
    public static long 构造_4(long Axes, double R, double H, double Angle) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(R);
        a[3] = Double.doubleToRawLongBits(H);
        a[4] = Double.doubleToRawLongBits(Angle);
        long r = OcctGen.occtCall(1711, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakeHalfSpace {
        private BRepPrimAPI_MakeHalfSpace() {}

    public static long 构造(long Face, long RefPnt) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Face;
        a[2] = RefPnt;
        long r = OcctGen.occtCall(1712, a, box);
        return r;
    }
    public static long 构造_2(long Shell, long RefPnt) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Shell;
        a[2] = RefPnt;
        long r = OcctGen.occtCall(1713, a, box);
        return r;
    }
    public static long Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1714, a, box);
        return r;
    }
    public static long 转TopoDS_Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1715, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakeOneAxis {
        private BRepPrimAPI_MakeOneAxis() {}

    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1716, a, box);
    }
    public static long Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1717, a, box);
        return r;
    }
    public static long 转TopoDS_Face(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1718, a, box);
        return r;
    }
    public static long Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1719, a, box);
        return r;
    }
    public static long 转TopoDS_Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1720, a, box);
        return r;
    }
    public static long Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1721, a, box);
        return r;
    }
    public static long 转TopoDS_Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1722, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakePrism {
        private BRepPrimAPI_MakePrism() {}

    public static long 构造(long S, long V, boolean Copy, boolean Canonize) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = V;
        a[3] = Copy ? 1L : 0L;
        a[4] = Canonize ? 1L : 0L;
        long r = OcctGen.occtCall(1723, a, box);
        return r;
    }
    public static long 构造_2(long S, long D, boolean Inf, boolean Copy, boolean Canonize) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = S;
        a[2] = D;
        a[3] = Inf ? 1L : 0L;
        a[4] = Copy ? 1L : 0L;
        a[5] = Canonize ? 1L : 0L;
        long r = OcctGen.occtCall(1724, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1725, a, box);
    }
    public static long FirstShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1726, a, box);
        return r;
    }
    public static long LastShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1727, a, box);
        return r;
    }
    public static boolean IsDeleted(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(1728, a, box);
        return r != 0;
    }
    public static long FirstShape_2(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        long r = OcctGen.occtCall(1729, a, box);
        return r;
    }
    public static long LastShape_2(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        long r = OcctGen.occtCall(1730, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakeRevol {
        private BRepPrimAPI_MakeRevol() {}

    public static long 构造(long S, long A, double D, boolean Copy) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = S;
        a[2] = A;
        a[3] = Double.doubleToRawLongBits(D);
        a[4] = Copy ? 1L : 0L;
        long r = OcctGen.occtCall(1731, a, box);
        return r;
    }
    public static long 构造_2(long S, long A, boolean Copy) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = S;
        a[2] = A;
        a[3] = Copy ? 1L : 0L;
        long r = OcctGen.occtCall(1732, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1733, a, box);
    }
    public static long FirstShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1734, a, box);
        return r;
    }
    public static long LastShape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1735, a, box);
        return r;
    }
    public static boolean IsDeleted(long self, long S) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = S;
        long r = OcctGen.occtCall(1736, a, box);
        return r != 0;
    }
    public static long FirstShape_2(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        long r = OcctGen.occtCall(1737, a, box);
        return r;
    }
    public static long LastShape_2(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        long r = OcctGen.occtCall(1738, a, box);
        return r;
    }
    public static boolean HasDegenerated(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1739, a, box);
        return r != 0;
    }
    }

    public static final class BRepPrimAPI_MakeRevolution {
        private BRepPrimAPI_MakeRevolution() {}

    public static long 构造(long Meridian) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Meridian;
        long r = OcctGen.occtCall(1740, a, box);
        return r;
    }
    public static long 构造_2(long Meridian, double angle) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Meridian;
        a[2] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1741, a, box);
        return r;
    }
    public static long 构造_3(long Meridian, double VMin, double VMax) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Meridian;
        a[2] = Double.doubleToRawLongBits(VMin);
        a[3] = Double.doubleToRawLongBits(VMax);
        long r = OcctGen.occtCall(1742, a, box);
        return r;
    }
    public static long 构造_4(long Meridian, double VMin, double VMax, double angle) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Meridian;
        a[2] = Double.doubleToRawLongBits(VMin);
        a[3] = Double.doubleToRawLongBits(VMax);
        a[4] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1743, a, box);
        return r;
    }
    public static long 构造_5(long Axes, long Meridian) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Meridian;
        long r = OcctGen.occtCall(1744, a, box);
        return r;
    }
    public static long 构造_6(long Axes, long Meridian, double angle) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Meridian;
        a[3] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1745, a, box);
        return r;
    }
    public static long 构造_7(long Axes, long Meridian, double VMin, double VMax) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Meridian;
        a[3] = Double.doubleToRawLongBits(VMin);
        a[4] = Double.doubleToRawLongBits(VMax);
        long r = OcctGen.occtCall(1746, a, box);
        return r;
    }
    public static long 构造_8(long Axes, long Meridian, double VMin, double VMax, double angle) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Meridian;
        a[3] = Double.doubleToRawLongBits(VMin);
        a[4] = Double.doubleToRawLongBits(VMax);
        a[5] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1747, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakeSphere {
        private BRepPrimAPI_MakeSphere() {}

    public static long 构造(double R) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        long r = OcctGen.occtCall(1748, a, box);
        return r;
    }
    public static long 构造_2(double R, double angle) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        a[2] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1749, a, box);
        return r;
    }
    public static long 构造_3(double R, double angle1, double angle2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        a[2] = Double.doubleToRawLongBits(angle1);
        a[3] = Double.doubleToRawLongBits(angle2);
        long r = OcctGen.occtCall(1750, a, box);
        return r;
    }
    public static long 构造_4(double R, double angle1, double angle2, double angle3) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R);
        a[2] = Double.doubleToRawLongBits(angle1);
        a[3] = Double.doubleToRawLongBits(angle2);
        a[4] = Double.doubleToRawLongBits(angle3);
        long r = OcctGen.occtCall(1751, a, box);
        return r;
    }
    public static long 构造_5(long Center, double R) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Center;
        a[2] = Double.doubleToRawLongBits(R);
        long r = OcctGen.occtCall(1752, a, box);
        return r;
    }
    public static long 构造_6(long Center, double R, double angle) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Center;
        a[2] = Double.doubleToRawLongBits(R);
        a[3] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1753, a, box);
        return r;
    }
    public static long 构造_7(long Center, double R, double angle1, double angle2) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Center;
        a[2] = Double.doubleToRawLongBits(R);
        a[3] = Double.doubleToRawLongBits(angle1);
        a[4] = Double.doubleToRawLongBits(angle2);
        long r = OcctGen.occtCall(1754, a, box);
        return r;
    }
    public static long 构造_8(long Center, double R, double angle1, double angle2, double angle3) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Center;
        a[2] = Double.doubleToRawLongBits(R);
        a[3] = Double.doubleToRawLongBits(angle1);
        a[4] = Double.doubleToRawLongBits(angle2);
        a[5] = Double.doubleToRawLongBits(angle3);
        long r = OcctGen.occtCall(1755, a, box);
        return r;
    }
    public static long 构造_9(long Axis, double R) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Axis;
        a[2] = Double.doubleToRawLongBits(R);
        long r = OcctGen.occtCall(1756, a, box);
        return r;
    }
    public static long 构造_10(long Axis, double R, double angle) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Axis;
        a[2] = Double.doubleToRawLongBits(R);
        a[3] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1757, a, box);
        return r;
    }
    public static long 构造_11(long Axis, double R, double angle1, double angle2) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Axis;
        a[2] = Double.doubleToRawLongBits(R);
        a[3] = Double.doubleToRawLongBits(angle1);
        a[4] = Double.doubleToRawLongBits(angle2);
        long r = OcctGen.occtCall(1758, a, box);
        return r;
    }
    public static long 构造_12(long Axis, double R, double angle1, double angle2, double angle3) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Axis;
        a[2] = Double.doubleToRawLongBits(R);
        a[3] = Double.doubleToRawLongBits(angle1);
        a[4] = Double.doubleToRawLongBits(angle2);
        a[5] = Double.doubleToRawLongBits(angle3);
        long r = OcctGen.occtCall(1759, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakeSweep {
        private BRepPrimAPI_MakeSweep() {}

    }

    public static final class BRepPrimAPI_MakeTorus {
        private BRepPrimAPI_MakeTorus() {}

    public static long 构造(double R1, double R2) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R1);
        a[2] = Double.doubleToRawLongBits(R2);
        long r = OcctGen.occtCall(1760, a, box);
        return r;
    }
    public static long 构造_2(double R1, double R2, double angle) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R1);
        a[2] = Double.doubleToRawLongBits(R2);
        a[3] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1761, a, box);
        return r;
    }
    public static long 构造_3(double R1, double R2, double angle1, double angle2) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R1);
        a[2] = Double.doubleToRawLongBits(R2);
        a[3] = Double.doubleToRawLongBits(angle1);
        a[4] = Double.doubleToRawLongBits(angle2);
        long r = OcctGen.occtCall(1762, a, box);
        return r;
    }
    public static long 构造_4(double R1, double R2, double angle1, double angle2, double angle) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(R1);
        a[2] = Double.doubleToRawLongBits(R2);
        a[3] = Double.doubleToRawLongBits(angle1);
        a[4] = Double.doubleToRawLongBits(angle2);
        a[5] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1763, a, box);
        return r;
    }
    public static long 构造_5(long Axes, double R1, double R2) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(R1);
        a[3] = Double.doubleToRawLongBits(R2);
        long r = OcctGen.occtCall(1764, a, box);
        return r;
    }
    public static long 构造_6(long Axes, double R1, double R2, double angle) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(R1);
        a[3] = Double.doubleToRawLongBits(R2);
        a[4] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1765, a, box);
        return r;
    }
    public static long 构造_7(long Axes, double R1, double R2, double angle1, double angle2) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(R1);
        a[3] = Double.doubleToRawLongBits(R2);
        a[4] = Double.doubleToRawLongBits(angle1);
        a[5] = Double.doubleToRawLongBits(angle2);
        long r = OcctGen.occtCall(1766, a, box);
        return r;
    }
    public static long 构造_8(
            long Axes, double R1, double R2, double angle1, double angle2, double angle) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(R1);
        a[3] = Double.doubleToRawLongBits(R2);
        a[4] = Double.doubleToRawLongBits(angle1);
        a[5] = Double.doubleToRawLongBits(angle2);
        a[6] = Double.doubleToRawLongBits(angle);
        long r = OcctGen.occtCall(1767, a, box);
        return r;
    }
    }

    public static final class BRepPrimAPI_MakeWedge {
        private BRepPrimAPI_MakeWedge() {}

    public static long 构造(double dx, double dy, double dz, double ltx) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(dx);
        a[2] = Double.doubleToRawLongBits(dy);
        a[3] = Double.doubleToRawLongBits(dz);
        a[4] = Double.doubleToRawLongBits(ltx);
        long r = OcctGen.occtCall(1768, a, box);
        return r;
    }
    public static long 构造_2(long Axes, double dx, double dy, double dz, double ltx) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(dx);
        a[3] = Double.doubleToRawLongBits(dy);
        a[4] = Double.doubleToRawLongBits(dz);
        a[5] = Double.doubleToRawLongBits(ltx);
        long r = OcctGen.occtCall(1769, a, box);
        return r;
    }
    public static long 构造_3(
            double dx, double dy, double dz, double xmin, double zmin, double xmax, double zmax) {
        long[] a = new long[8];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(dx);
        a[2] = Double.doubleToRawLongBits(dy);
        a[3] = Double.doubleToRawLongBits(dz);
        a[4] = Double.doubleToRawLongBits(xmin);
        a[5] = Double.doubleToRawLongBits(zmin);
        a[6] = Double.doubleToRawLongBits(xmax);
        a[7] = Double.doubleToRawLongBits(zmax);
        long r = OcctGen.occtCall(1770, a, box);
        return r;
    }
    public static long 构造_4(
            long Axes, double dx, double dy, double dz, double xmin, double zmin, double xmax,
            double zmax) {
        long[] a = new long[9];
        Object[] box = null;
        a[1] = Axes;
        a[2] = Double.doubleToRawLongBits(dx);
        a[3] = Double.doubleToRawLongBits(dy);
        a[4] = Double.doubleToRawLongBits(dz);
        a[5] = Double.doubleToRawLongBits(xmin);
        a[6] = Double.doubleToRawLongBits(zmin);
        a[7] = Double.doubleToRawLongBits(xmax);
        a[8] = Double.doubleToRawLongBits(zmax);
        long r = OcctGen.occtCall(1771, a, box);
        return r;
    }
    public static void Build(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1772, a, box);
    }
    public static long Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1773, a, box);
        return r;
    }
    public static long 转TopoDS_Shell(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1774, a, box);
        return r;
    }
    public static long Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1775, a, box);
        return r;
    }
    public static long 转TopoDS_Solid(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1776, a, box);
        return r;
    }
    }

}
