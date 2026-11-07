package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKXMesh 类=1 方法槽=1
public final class Gen_TKXMesh {
    private Gen_TKXMesh() {}

    public static final class XBRepMesh {
        private XBRepMesh() {}

    public static int Discret(
            long theShape, double theDeflection, double theAngle, long[] theAlgoOut) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = theShape;
        a[2] = Double.doubleToRawLongBits(theDeflection);
        a[3] = Double.doubleToRawLongBits(theAngle);
        long r = OcctGen.occtCall(4939, a, box);
        if (theAlgoOut != null && theAlgoOut.length != 0) theAlgoOut[0] = a[4];
        return (int) r;
    }
    }

}
