package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKMesh 类=6 方法槽=25
public final class Gen_TKMesh {
    private Gen_TKMesh() {}

    public static final class BRepMesh_DiscretFactory {
        private BRepMesh_DiscretFactory() {}

    public static long Get() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1518, a, box);
        return r;
    }
    public static boolean SetDefaultName(long self, String theName) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theName;
        long r = OcctGen.occtCall(1519, a, box);
        return r != 0;
    }
    public static String DefaultName(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(1520, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean SetFunctionName(long self, String theFuncName) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theFuncName;
        long r = OcctGen.occtCall(1521, a, box);
        return r != 0;
    }
    public static String FunctionName(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(1522, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static int ErrorStatus(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1523, a, box);
        return (int) r;
    }
    public static boolean SetDefault(long self, String theName, String theFuncName) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theName;
        box[2] = theFuncName;
        long r = OcctGen.occtCall(1524, a, box);
        return r != 0;
    }
    public static long Discret(
            long self, long theShape, double theLinDeflection, double theAngDeflection) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        a[2] = Double.doubleToRawLongBits(theLinDeflection);
        a[3] = Double.doubleToRawLongBits(theAngDeflection);
        long r = OcctGen.occtCall(1525, a, box);
        return r;
    }
    }

    public static final class BRepMesh_DiscretRoot {
        private BRepMesh_DiscretRoot() {}

    public static void SetShape(long self, long theShape) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theShape;
        OcctGen.occtCall(1526, a, box);
    }
    public static long Shape(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1527, a, box);
        return r;
    }
    public static boolean IsDone(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1528, a, box);
        return r != 0;
    }
    }

    public static final class BRepMesh_IncrementalMesh {
        private BRepMesh_IncrementalMesh() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1529, a, box);
        return r;
    }
    public static long 构造_2(
            long theShape, double theLinDeflection, boolean isRelative, double theAngDeflection,
            boolean isInParallel) {
        long[] a = new long[6];
        Object[] box = null;
        a[1] = theShape;
        a[2] = Double.doubleToRawLongBits(theLinDeflection);
        a[3] = isRelative ? 1L : 0L;
        a[4] = Double.doubleToRawLongBits(theAngDeflection);
        a[5] = isInParallel ? 1L : 0L;
        long r = OcctGen.occtCall(1530, a, box);
        return r;
    }
    public static long 构造_3(long theShape, long theParameters) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theShape;
        a[2] = theParameters;
        long r = OcctGen.occtCall(1531, a, box);
        return r;
    }
    public static void Perform(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(1532, a, box);
    }
    public static void Perform_2(long self, long theContext) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theContext;
        OcctGen.occtCall(1533, a, box);
    }
    public static long Parameters(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1534, a, box);
        return r;
    }
    public static long ChangeParameters(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1535, a, box);
        return r;
    }
    public static boolean IsModified(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1536, a, box);
        return r != 0;
    }
    public static int GetStatusFlags(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(1537, a, box);
        return (int) r;
    }
    public static int Discret(
            long theShape, double theLinDeflection, double theAngDeflection, long[] theAlgoOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theShape;
        a[2] = Double.doubleToRawLongBits(theLinDeflection);
        a[3] = Double.doubleToRawLongBits(theAngDeflection);
        long r = OcctGen.occtCall(1538, a, box);
        if (theAlgoOut != null && theAlgoOut.length != 0) theAlgoOut[0] = a[4];
        return (int) r;
    }
    public static boolean IsParallelDefault() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(1539, a, box);
        return r != 0;
    }
    public static void SetParallelDefault(boolean isInParallel) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = isInParallel ? 1L : 0L;
        OcctGen.occtCall(1540, a, box);
    }
    }

    public static final class IMeshTools_ModelAlgo {
        private IMeshTools_ModelAlgo() {}

    }

    public static final class IMeshTools_ModelBuilder {
        private IMeshTools_ModelBuilder() {}

    }

    public static final class IMeshTools_Parameters {
        private IMeshTools_Parameters() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4089, a, box);
        return r;
    }
    public static double RelMinSize() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4090, a, box);
        return Double.longBitsToDouble(r);
    }
    }

}
