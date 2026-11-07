package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。TK 库=libTKernel 类=10 方法槽=312
public final class Gen_TKernel {
    private Gen_TKernel() {}

    public static final class Quantity_Color {
        private Quantity_Color() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4174, a, box);
        return r;
    }
    public static long 构造_2(int theName) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theName;
        long r = OcctGen.occtCall(4175, a, box);
        return r;
    }
    public static long 构造_3(double theC1, double theC2, double theC3, int theType) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theC1);
        a[2] = Double.doubleToRawLongBits(theC2);
        a[3] = Double.doubleToRawLongBits(theC3);
        a[4] = theType;
        long r = OcctGen.occtCall(4176, a, box);
        return r;
    }
    public static int Name(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4177, a, box);
        return (int) r;
    }
    public static void SetValues(long self, int theName) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theName;
        OcctGen.occtCall(4178, a, box);
    }
    public static void Values(
            long self, double[] theC1Out, double[] theC2Out, double[] theC3Out, int theType) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[4] = theType;
        OcctGen.occtCall(4179, a, box);
        if (theC1Out != null && theC1Out.length != 0) theC1Out[0] = Double.longBitsToDouble(a[1]);
        if (theC2Out != null && theC2Out.length != 0) theC2Out[0] = Double.longBitsToDouble(a[2]);
        if (theC3Out != null && theC3Out.length != 0) theC3Out[0] = Double.longBitsToDouble(a[3]);
    }
    public static void SetValues_2(
            long self, double theC1, double theC2, double theC3, int theType) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theC1);
        a[2] = Double.doubleToRawLongBits(theC2);
        a[3] = Double.doubleToRawLongBits(theC3);
        a[4] = theType;
        OcctGen.occtCall(4180, a, box);
    }
    public static double Red(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4181, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Green(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4182, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Blue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4183, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Hue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4184, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Light(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4185, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void ChangeIntensity(long self, double theDelta) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDelta);
        OcctGen.occtCall(4186, a, box);
    }
    public static double Saturation(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4187, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void ChangeContrast(long self, double theDelta) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theDelta);
        OcctGen.occtCall(4188, a, box);
    }
    public static boolean IsDifferent(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4189, a, box);
        return r != 0;
    }
    public static boolean IsEqual(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4190, a, box);
        return r != 0;
    }
    public static double Distance(long self, long theColor) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theColor;
        long r = OcctGen.occtCall(4191, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double SquareDistance(long self, long theColor) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theColor;
        long r = OcctGen.occtCall(4192, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void Delta(long self, long theColor, double[] DCOut, double[] DIOut) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = theColor;
        OcctGen.occtCall(4193, a, box);
        if (DCOut != null && DCOut.length != 0) DCOut[0] = Double.longBitsToDouble(a[2]);
        if (DIOut != null && DIOut.length != 0) DIOut[0] = Double.longBitsToDouble(a[3]);
    }
    public static double DeltaE2000(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4194, a, box);
        return Double.longBitsToDouble(r);
    }
    public static int Name_2(double theR, double theG, double theB) {
        long[] a = new long[4];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theR);
        a[2] = Double.doubleToRawLongBits(theG);
        a[3] = Double.doubleToRawLongBits(theB);
        long r = OcctGen.occtCall(4195, a, box);
        return (int) r;
    }
    public static String StringName(int theColor) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[1] = theColor;
        OcctGen.occtCall(4196, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean ColorFromName(String theName, int[] theColorOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theName;
        long r = OcctGen.occtCall(4197, a, box);
        if (theColorOut != null && theColorOut.length != 0) theColorOut[0] = (int) a[2];
        return r != 0;
    }
    public static boolean ColorFromName_2(String theColorNameString, long theColor) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theColorNameString;
        a[2] = theColor;
        long r = OcctGen.occtCall(4198, a, box);
        return r != 0;
    }
    public static boolean ColorFromHex(String theHexColorString, long theColor) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theHexColorString;
        a[2] = theColor;
        long r = OcctGen.occtCall(4199, a, box);
        return r != 0;
    }
    public static String ColorToHex(long theColor, boolean theToPrefixHash) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[1] = theColor;
        a[2] = theToPrefixHash ? 1L : 0L;
        OcctGen.occtCall(4200, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void Color2argb(long theColor, int[] theARGBOut) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theColor;
        OcctGen.occtCall(4201, a, box);
        if (theARGBOut != null && theARGBOut.length != 0) theARGBOut[0] = (int) a[2];
    }
    public static void Argb2color(int theARGB, long theColor) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theARGB;
        a[2] = theColor;
        OcctGen.occtCall(4202, a, box);
    }
    public static double Convert_LinearRGB_To_sRGB_approx22(double theLinearValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theLinearValue);
        long r = OcctGen.occtCall(4203, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double Convert_sRGB_To_LinearRGB_approx22(double thesRGBValue) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(thesRGBValue);
        long r = OcctGen.occtCall(4204, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void HlsRgb(
            double theH, double theL, double theS, double[] theROut, double[] theGOut,
            double[] theBOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theH);
        a[2] = Double.doubleToRawLongBits(theL);
        a[3] = Double.doubleToRawLongBits(theS);
        OcctGen.occtCall(4205, a, box);
        if (theROut != null && theROut.length != 0) theROut[0] = Double.longBitsToDouble(a[4]);
        if (theGOut != null && theGOut.length != 0) theGOut[0] = Double.longBitsToDouble(a[5]);
        if (theBOut != null && theBOut.length != 0) theBOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static void RgbHls(
            double theR, double theG, double theB, double[] theHOut, double[] theLOut,
            double[] theSOut) {
        long[] a = new long[7];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theR);
        a[2] = Double.doubleToRawLongBits(theG);
        a[3] = Double.doubleToRawLongBits(theB);
        OcctGen.occtCall(4206, a, box);
        if (theHOut != null && theHOut.length != 0) theHOut[0] = Double.longBitsToDouble(a[4]);
        if (theLOut != null && theLOut.length != 0) theLOut[0] = Double.longBitsToDouble(a[5]);
        if (theSOut != null && theSOut.length != 0) theSOut[0] = Double.longBitsToDouble(a[6]);
    }
    public static double Epsilon() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4207, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetEpsilon(double theEpsilon) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theEpsilon);
        OcctGen.occtCall(4208, a, box);
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(4209, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(4210, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class Quantity_ColorRGBA {
        private Quantity_ColorRGBA() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4211, a, box);
        return r;
    }
    public static long 构造_2(long theRgb) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theRgb;
        long r = OcctGen.occtCall(4212, a, box);
        return r;
    }
    public static long 构造_3(long theRgb, double theAlpha) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = theRgb;
        a[2] = Double.doubleToRawLongBits(theAlpha);
        long r = OcctGen.occtCall(4213, a, box);
        return r;
    }
    public static long 构造_4(double theRed, double theGreen, double theBlue, double theAlpha) {
        long[] a = new long[5];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(theRed);
        a[2] = Double.doubleToRawLongBits(theGreen);
        a[3] = Double.doubleToRawLongBits(theBlue);
        a[4] = Double.doubleToRawLongBits(theAlpha);
        long r = OcctGen.occtCall(4214, a, box);
        return r;
    }
    public static void SetValues(
            long self, double theRed, double theGreen, double theBlue, double theAlpha) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theRed);
        a[2] = Double.doubleToRawLongBits(theGreen);
        a[3] = Double.doubleToRawLongBits(theBlue);
        a[4] = Double.doubleToRawLongBits(theAlpha);
        OcctGen.occtCall(4215, a, box);
    }
    public static long GetRGB(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4216, a, box);
        return r;
    }
    public static long ChangeRGB(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4217, a, box);
        return r;
    }
    public static void SetRGB(long self, long theRgb) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theRgb;
        OcctGen.occtCall(4218, a, box);
    }
    public static double Alpha(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4219, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void SetAlpha(long self, double theAlpha) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(theAlpha);
        OcctGen.occtCall(4220, a, box);
    }
    public static boolean IsDifferent(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4221, a, box);
        return r != 0;
    }
    public static boolean IsEqual(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4222, a, box);
        return r != 0;
    }
    public static boolean ColorFromName(String theColorNameString, long theColor) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theColorNameString;
        a[2] = theColor;
        long r = OcctGen.occtCall(4223, a, box);
        return r != 0;
    }
    public static boolean ColorFromHex(
            String theHexColorString, long theColor, boolean theAlphaComponentIsOff) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        box[1] = theHexColorString;
        a[2] = theColor;
        a[3] = theAlphaComponentIsOff ? 1L : 0L;
        long r = OcctGen.occtCall(4224, a, box);
        return r != 0;
    }
    public static String ColorToHex(long theColor, boolean theToPrefixHash) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[1] = theColor;
        a[2] = theToPrefixHash ? 1L : 0L;
        OcctGen.occtCall(4225, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String DumpJson(long self, int theDepth) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[2] = theDepth;
        OcctGen.occtCall(4226, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean InitFromJson(long self, String theSStream, int[] theStreamPosOut) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = theSStream;
        long r = OcctGen.occtCall(4227, a, box);
        if (theStreamPosOut != null && theStreamPosOut.length != 0) theStreamPosOut[0] = (int) a[2];
        return r != 0;
    }
    }

    public static final class Standard_Failure {
        private Standard_Failure() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4552, a, box);
        return r;
    }
    public static long 构造_2(long f) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = f;
        long r = OcctGen.occtCall(4553, a, box);
        return r;
    }
    public static long 构造_3(String theDesc) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theDesc;
        long r = OcctGen.occtCall(4554, a, box);
        return r;
    }
    public static long 构造_4(String theDesc, String theStackTrace) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theDesc;
        box[2] = theStackTrace;
        long r = OcctGen.occtCall(4555, a, box);
        return r;
    }
    public static String Print(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4556, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String GetMessageString(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(4557, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void SetMessageString(long self, String theMessage) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theMessage;
        OcctGen.occtCall(4558, a, box);
    }
    public static String GetStackString(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(4559, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void SetStackString(long self, String theStack) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theStack;
        OcctGen.occtCall(4560, a, box);
    }
    public static void Reraise(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4561, a, box);
    }
    public static void Reraise_2(long self, String aMessage) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = aMessage;
        OcctGen.occtCall(4562, a, box);
    }
    public static void Reraise_3(long self, String aReason) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = aReason;
        OcctGen.occtCall(4563, a, box);
    }
    public static void Raise(String aMessage) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = aMessage;
        OcctGen.occtCall(4564, a, box);
    }
    public static void Raise_2(String aReason) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = aReason;
        OcctGen.occtCall(4565, a, box);
    }
    public static long NewInstance(String theMessage) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theMessage;
        long r = OcctGen.occtCall(4566, a, box);
        return r;
    }
    public static long NewInstance_2(String theMessage, String theStackTrace) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theMessage;
        box[2] = theStackTrace;
        long r = OcctGen.occtCall(4567, a, box);
        return r;
    }
    public static int DefaultStackTraceLength() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4568, a, box);
        return (int) r;
    }
    public static void SetDefaultStackTraceLength(int theNbStackTraces) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = theNbStackTraces;
        OcctGen.occtCall(4569, a, box);
    }
    public static void Jump(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4570, a, box);
    }
    }

    public static final class Standard_GUID {
        private Standard_GUID() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4571, a, box);
        return r;
    }
    public static long 构造_2(String aGuid) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = aGuid;
        long r = OcctGen.occtCall(4572, a, box);
        return r;
    }
    public static long 构造_3(String aGuid) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = aGuid;
        long r = OcctGen.occtCall(4573, a, box);
        return r;
    }
    public static long 构造_4(long aGuid) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = aGuid;
        long r = OcctGen.occtCall(4574, a, box);
        return r;
    }
    public static String ToCString(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4575, a, box);
        return (box[1] instanceof String) ? (String) box[1] : "";
    }
    public static String ToExtString(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4576, a, box);
        return (box[1] instanceof String) ? (String) box[1] : "";
    }
    public static boolean IsSame(long self, long uid) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = uid;
        long r = OcctGen.occtCall(4577, a, box);
        return r != 0;
    }
    public static boolean IsNotSame(long self, long uid) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = uid;
        long r = OcctGen.occtCall(4578, a, box);
        return r != 0;
    }
    public static void Assign(long self, long uid) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = uid;
        OcctGen.occtCall(4579, a, box);
    }
    public static String ShallowDump(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4580, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean CheckGUIDFormat(String aGuid) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = aGuid;
        long r = OcctGen.occtCall(4581, a, box);
        return r != 0;
    }
    }

    public static final class Standard_Transient {
        private Standard_Transient() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4582, a, box);
        return r;
    }
    public static long 构造_2(long a0) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = a0;
        long r = OcctGen.occtCall(4583, a, box);
        return r;
    }
    public static String get_type_name() {
        long[] a = new long[1];
        Object[] box = new Object[1];
        OcctGen.occtCall(4584, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static long get_type_descriptor() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4585, a, box);
        return r;
    }
    public static long DynamicType(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4586, a, box);
        return r;
    }
    public static boolean IsInstance(long self, long theType) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theType;
        long r = OcctGen.occtCall(4587, a, box);
        return r != 0;
    }
    public static boolean IsInstance_2(long self, String theTypeName) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theTypeName;
        long r = OcctGen.occtCall(4588, a, box);
        return r != 0;
    }
    public static boolean IsKind(long self, long theType) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theType;
        long r = OcctGen.occtCall(4589, a, box);
        return r != 0;
    }
    public static boolean IsKind_2(long self, String theTypeName) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theTypeName;
        long r = OcctGen.occtCall(4590, a, box);
        return r != 0;
    }
    public static long This(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4591, a, box);
        return r;
    }
    public static int GetRefCount(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4592, a, box);
        return (int) r;
    }
    public static void IncrementRefCounter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4593, a, box);
    }
    public static int DecrementRefCounter(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4594, a, box);
        return (int) r;
    }
    }

    public static final class Standard_Type {
        private Standard_Type() {}

    public static String SystemName(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(4595, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Name(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(4596, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static long Size(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4597, a, box);
        return r;
    }
    public static long Parent(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4598, a, box);
        return r;
    }
    public static boolean SubType(long self, long theOther) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theOther;
        long r = OcctGen.occtCall(4599, a, box);
        return r != 0;
    }
    public static boolean SubType_2(long self, String theOther) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theOther;
        long r = OcctGen.occtCall(4600, a, box);
        return r != 0;
    }
    public static String Print(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4601, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    }

    public static final class TCollection_AsciiString {
        private TCollection_AsciiString() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4602, a, box);
        return r;
    }
    public static long 构造_2(String message) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = message;
        long r = OcctGen.occtCall(4603, a, box);
        return r;
    }
    public static long 构造_3(String message, int aLen) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = message;
        a[2] = aLen;
        long r = OcctGen.occtCall(4604, a, box);
        return r;
    }
    public static long 构造_4(int aChar) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = aChar;
        long r = OcctGen.occtCall(4605, a, box);
        return r;
    }
    public static long 构造_5(int length, int filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = length;
        a[2] = filler;
        long r = OcctGen.occtCall(4606, a, box);
        return r;
    }
    public static long 构造_6(int value) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = value;
        long r = OcctGen.occtCall(4607, a, box);
        return r;
    }
    public static long 构造_7(double value) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(value);
        long r = OcctGen.occtCall(4608, a, box);
        return r;
    }
    public static long 构造_8(String astring) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = astring;
        long r = OcctGen.occtCall(4609, a, box);
        return r;
    }
    public static long 构造_9(String theOther) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theOther;
        long r = OcctGen.occtCall(4610, a, box);
        return r;
    }
    public static long 构造_10(String astring, int message) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = astring;
        a[2] = message;
        long r = OcctGen.occtCall(4611, a, box);
        return r;
    }
    public static long 构造_11(String astring, String message) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = astring;
        box[2] = message;
        long r = OcctGen.occtCall(4612, a, box);
        return r;
    }
    public static long 构造_12(String astring, String message) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = astring;
        box[2] = message;
        long r = OcctGen.occtCall(4613, a, box);
        return r;
    }
    public static long 构造_13(String astring, int replaceNonAscii) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = astring;
        a[2] = replaceNonAscii;
        long r = OcctGen.occtCall(4614, a, box);
        return r;
    }
    public static long 构造_14(String theStringUtf) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theStringUtf;
        long r = OcctGen.occtCall(4615, a, box);
        return r;
    }
    public static void AssignCat(long self, int other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = other;
        OcctGen.occtCall(4616, a, box);
    }
    public static void AssignCat_2(long self, int other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = other;
        OcctGen.occtCall(4617, a, box);
    }
    public static void AssignCat_3(long self, double other) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(other);
        OcctGen.occtCall(4618, a, box);
    }
    public static void AssignCat_4(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4619, a, box);
    }
    public static void AssignCat_5(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4620, a, box);
    }
    public static void Capitalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4621, a, box);
    }
    public static String Cat(long self, int other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        a[1] = other;
        OcctGen.occtCall(4622, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Cat_2(long self, int other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        a[1] = other;
        OcctGen.occtCall(4623, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Cat_3(long self, double other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        a[1] = Double.doubleToRawLongBits(other);
        OcctGen.occtCall(4624, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Cat_4(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4625, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Cat_5(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4626, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void Center(long self, int Width, int Filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Width;
        a[2] = Filler;
        OcctGen.occtCall(4627, a, box);
    }
    public static void ChangeAll(long self, int aChar, int NewChar, boolean CaseSensitive) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = aChar;
        a[2] = NewChar;
        a[3] = CaseSensitive ? 1L : 0L;
        OcctGen.occtCall(4628, a, box);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4629, a, box);
    }
    public static void Copy(long self, String fromwhere) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = fromwhere;
        OcctGen.occtCall(4630, a, box);
    }
    public static void Copy_2(long self, String fromwhere) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = fromwhere;
        OcctGen.occtCall(4631, a, box);
    }
    public static void Move(long self, String theOther) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theOther;
        OcctGen.occtCall(4632, a, box);
    }
    public static void Swap(long self, String theOther) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theOther;
        OcctGen.occtCall(4633, a, box);
    }
    public static int FirstLocationInSet(long self, String Set, int FromIndex, int ToIndex) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[0] = self;
        box[1] = Set;
        a[2] = FromIndex;
        a[3] = ToIndex;
        long r = OcctGen.occtCall(4634, a, box);
        return (int) r;
    }
    public static int FirstLocationNotInSet(long self, String Set, int FromIndex, int ToIndex) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[0] = self;
        box[1] = Set;
        a[2] = FromIndex;
        a[3] = ToIndex;
        long r = OcctGen.occtCall(4635, a, box);
        return (int) r;
    }
    public static void Insert(long self, int where, int what) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = what;
        OcctGen.occtCall(4636, a, box);
    }
    public static void Insert_2(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4637, a, box);
    }
    public static void Insert_3(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4638, a, box);
    }
    public static void InsertAfter(long self, int Index, String other) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = Index;
        box[2] = other;
        OcctGen.occtCall(4639, a, box);
    }
    public static void InsertBefore(long self, int Index, String other) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = Index;
        box[2] = other;
        OcctGen.occtCall(4640, a, box);
    }
    public static boolean IsEqual(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4641, a, box);
        return r != 0;
    }
    public static boolean IsEqual_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4642, a, box);
        return r != 0;
    }
    public static boolean IsDifferent(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4643, a, box);
        return r != 0;
    }
    public static boolean IsDifferent_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4644, a, box);
        return r != 0;
    }
    public static boolean IsLess(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4645, a, box);
        return r != 0;
    }
    public static boolean IsLess_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4646, a, box);
        return r != 0;
    }
    public static boolean IsGreater(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4647, a, box);
        return r != 0;
    }
    public static boolean IsGreater_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4648, a, box);
        return r != 0;
    }
    public static boolean StartsWith(long self, String theStartString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theStartString;
        long r = OcctGen.occtCall(4649, a, box);
        return r != 0;
    }
    public static boolean EndsWith(long self, String theEndString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theEndString;
        long r = OcctGen.occtCall(4650, a, box);
        return r != 0;
    }
    public static int IntegerValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4651, a, box);
        return (int) r;
    }
    public static boolean IsIntegerValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4652, a, box);
        return r != 0;
    }
    public static boolean IsRealValue(long self, boolean theToCheckFull) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theToCheckFull ? 1L : 0L;
        long r = OcctGen.occtCall(4653, a, box);
        return r != 0;
    }
    public static boolean IsAscii(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4654, a, box);
        return r != 0;
    }
    public static void LeftAdjust(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4655, a, box);
    }
    public static void LeftJustify(long self, int Width, int Filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Width;
        a[2] = Filler;
        OcctGen.occtCall(4656, a, box);
    }
    public static int Length(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4657, a, box);
        return (int) r;
    }
    public static int Location(long self, String other, int FromIndex, int ToIndex) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[0] = self;
        box[1] = other;
        a[2] = FromIndex;
        a[3] = ToIndex;
        long r = OcctGen.occtCall(4658, a, box);
        return (int) r;
    }
    public static int Location_2(long self, int N, int C, int FromIndex, int ToIndex) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        a[2] = C;
        a[3] = FromIndex;
        a[4] = ToIndex;
        long r = OcctGen.occtCall(4659, a, box);
        return (int) r;
    }
    public static void LowerCase(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4660, a, box);
    }
    public static void Prepend(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4661, a, box);
    }
    public static String Print(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4662, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static double RealValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4663, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void RemoveAll(long self, int C, boolean CaseSensitive) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = CaseSensitive ? 1L : 0L;
        OcctGen.occtCall(4664, a, box);
    }
    public static void RemoveAll_2(long self, int what) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = what;
        OcctGen.occtCall(4665, a, box);
    }
    public static void Remove(long self, int where, int ahowmany) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = ahowmany;
        OcctGen.occtCall(4666, a, box);
    }
    public static void RightAdjust(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4667, a, box);
    }
    public static void RightJustify(long self, int Width, int Filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Width;
        a[2] = Filler;
        OcctGen.occtCall(4668, a, box);
    }
    public static int Search(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4669, a, box);
        return (int) r;
    }
    public static int Search_2(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4670, a, box);
        return (int) r;
    }
    public static int SearchFromEnd(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4671, a, box);
        return (int) r;
    }
    public static int SearchFromEnd_2(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4672, a, box);
        return (int) r;
    }
    public static void SetValue(long self, int where, int what) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = what;
        OcctGen.occtCall(4673, a, box);
    }
    public static void SetValue_2(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4674, a, box);
    }
    public static void SetValue_3(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4675, a, box);
    }
    public static String Split(long self, int where) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        a[1] = where;
        OcctGen.occtCall(4676, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String SubString(long self, int FromIndex, int ToIndex) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = FromIndex;
        a[2] = ToIndex;
        OcctGen.occtCall(4677, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String ToCString(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(4678, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Token(long self, String separators, int whichone) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = separators;
        a[2] = whichone;
        OcctGen.occtCall(4679, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void Trunc(long self, int ahowmany) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ahowmany;
        OcctGen.occtCall(4680, a, box);
    }
    public static void UpperCase(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4681, a, box);
    }
    public static int UsefullLength(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4682, a, box);
        return (int) r;
    }
    public static int Value(long self, int where) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        long r = OcctGen.occtCall(4683, a, box);
        return (int) r;
    }
    public static long HashCode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4684, a, box);
        return r;
    }
    public static boolean IsEqual_3(String string1, String string2) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = string1;
        box[2] = string2;
        long r = OcctGen.occtCall(4685, a, box);
        return r != 0;
    }
    public static boolean IsEqual_4(String string1, String string2) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = string1;
        box[2] = string2;
        long r = OcctGen.occtCall(4686, a, box);
        return r != 0;
    }
    public static boolean IsSameString(
            String theString1, String theString2, boolean theIsCaseSensitive) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        box[1] = theString1;
        box[2] = theString2;
        a[3] = theIsCaseSensitive ? 1L : 0L;
        long r = OcctGen.occtCall(4687, a, box);
        return r != 0;
    }
    }

    public static final class TCollection_ExtendedString {
        private TCollection_ExtendedString() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4688, a, box);
        return r;
    }
    public static long 构造_2(String astring, boolean isMultiByte) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = astring;
        a[2] = isMultiByte ? 1L : 0L;
        long r = OcctGen.occtCall(4689, a, box);
        return r;
    }
    public static long 构造_3(String astring) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = astring;
        long r = OcctGen.occtCall(4690, a, box);
        return r;
    }
    public static long 构造_4(String theStringUtf) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theStringUtf;
        long r = OcctGen.occtCall(4691, a, box);
        return r;
    }
    public static long 构造_5(int aChar) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = aChar;
        long r = OcctGen.occtCall(4692, a, box);
        return r;
    }
    public static long 构造_6(int aChar) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = aChar;
        long r = OcctGen.occtCall(4693, a, box);
        return r;
    }
    public static long 构造_7(int length, int filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = length;
        a[2] = filler;
        long r = OcctGen.occtCall(4694, a, box);
        return r;
    }
    public static long 构造_8(int value) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = value;
        long r = OcctGen.occtCall(4695, a, box);
        return r;
    }
    public static long 构造_9(double value) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(value);
        long r = OcctGen.occtCall(4696, a, box);
        return r;
    }
    public static long 构造_10(String astring) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = astring;
        long r = OcctGen.occtCall(4697, a, box);
        return r;
    }
    public static long 构造_11(String theOther) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theOther;
        long r = OcctGen.occtCall(4698, a, box);
        return r;
    }
    public static long 构造_12(String astring, boolean isMultiByte) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = astring;
        a[2] = isMultiByte ? 1L : 0L;
        long r = OcctGen.occtCall(4699, a, box);
        return r;
    }
    public static void AssignCat(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4700, a, box);
    }
    public static void AssignCat_2(long self, int theChar) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = theChar;
        OcctGen.occtCall(4701, a, box);
    }
    public static String Cat(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4702, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void ChangeAll(long self, int aChar, int NewChar) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = aChar;
        a[2] = NewChar;
        OcctGen.occtCall(4703, a, box);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4704, a, box);
    }
    public static void Copy(long self, String fromwhere) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = fromwhere;
        OcctGen.occtCall(4705, a, box);
    }
    public static void Move(long self, String theOther) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theOther;
        OcctGen.occtCall(4706, a, box);
    }
    public static void Swap(long self, String theOther) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theOther;
        OcctGen.occtCall(4707, a, box);
    }
    public static void Insert(long self, int where, int what) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = what;
        OcctGen.occtCall(4708, a, box);
    }
    public static void Insert_2(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4709, a, box);
    }
    public static boolean IsEqual(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4710, a, box);
        return r != 0;
    }
    public static boolean IsEqual_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4711, a, box);
        return r != 0;
    }
    public static boolean IsDifferent(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4712, a, box);
        return r != 0;
    }
    public static boolean IsDifferent_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4713, a, box);
        return r != 0;
    }
    public static boolean IsLess(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4714, a, box);
        return r != 0;
    }
    public static boolean IsLess_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4715, a, box);
        return r != 0;
    }
    public static boolean IsGreater(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4716, a, box);
        return r != 0;
    }
    public static boolean IsGreater_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4717, a, box);
        return r != 0;
    }
    public static boolean StartsWith(long self, String theStartString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theStartString;
        long r = OcctGen.occtCall(4718, a, box);
        return r != 0;
    }
    public static boolean EndsWith(long self, String theEndString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theEndString;
        long r = OcctGen.occtCall(4719, a, box);
        return r != 0;
    }
    public static boolean IsAscii(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4720, a, box);
        return r != 0;
    }
    public static int Length(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4721, a, box);
        return (int) r;
    }
    public static String Print(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4722, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void RemoveAll(long self, int what) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = what;
        OcctGen.occtCall(4723, a, box);
    }
    public static void Remove(long self, int where, int ahowmany) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = ahowmany;
        OcctGen.occtCall(4724, a, box);
    }
    public static int Search(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4725, a, box);
        return (int) r;
    }
    public static int SearchFromEnd(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4726, a, box);
        return (int) r;
    }
    public static void SetValue(long self, int where, int what) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = what;
        OcctGen.occtCall(4727, a, box);
    }
    public static void SetValue_2(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4728, a, box);
    }
    public static String Split(long self, int where) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        a[1] = where;
        OcctGen.occtCall(4729, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Token(long self, String separators, int whichone) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = separators;
        a[2] = whichone;
        OcctGen.occtCall(4730, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String ToExtString(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(4731, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void Trunc(long self, int ahowmany) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ahowmany;
        OcctGen.occtCall(4732, a, box);
    }
    public static int Value(long self, int where) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        long r = OcctGen.occtCall(4733, a, box);
        return (int) r;
    }
    public static long HashCode(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4734, a, box);
        return r;
    }
    public static boolean IsEqual_3(String theString1, String theString2) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = theString1;
        box[2] = theString2;
        long r = OcctGen.occtCall(4735, a, box);
        return r != 0;
    }
    public static int ToUTF8CString(long self, String theCString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = theCString;
        long r = OcctGen.occtCall(4736, a, box);
        return (int) r;
    }
    public static int LengthOfCString(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4737, a, box);
        return (int) r;
    }
    }

    public static final class TCollection_HAsciiString {
        private TCollection_HAsciiString() {}

    public static long 构造() {
        long[] a = new long[1];
        Object[] box = null;
        long r = OcctGen.occtCall(4738, a, box);
        return r;
    }
    public static long 构造_2(String message) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = message;
        long r = OcctGen.occtCall(4739, a, box);
        return r;
    }
    public static long 构造_3(int aChar) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = aChar;
        long r = OcctGen.occtCall(4740, a, box);
        return r;
    }
    public static long 构造_4(int length, int filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[1] = length;
        a[2] = filler;
        long r = OcctGen.occtCall(4741, a, box);
        return r;
    }
    public static long 构造_5(int value) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = value;
        long r = OcctGen.occtCall(4742, a, box);
        return r;
    }
    public static long 构造_6(double value) {
        long[] a = new long[2];
        Object[] box = null;
        a[1] = Double.doubleToRawLongBits(value);
        long r = OcctGen.occtCall(4743, a, box);
        return r;
    }
    public static long 构造_7(String aString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = aString;
        long r = OcctGen.occtCall(4744, a, box);
        return r;
    }
    public static long 构造_8(String theString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = theString;
        long r = OcctGen.occtCall(4745, a, box);
        return r;
    }
    public static long 构造_9(String aString) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = aString;
        long r = OcctGen.occtCall(4746, a, box);
        return r;
    }
    public static long 构造_10(String aString, int replaceNonAscii) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        box[1] = aString;
        a[2] = replaceNonAscii;
        long r = OcctGen.occtCall(4747, a, box);
        return r;
    }
    public static void AssignCat(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4748, a, box);
    }
    public static void AssignCat_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4749, a, box);
    }
    public static void Capitalize(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4750, a, box);
    }
    public static String Cat(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4751, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Cat_2(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4752, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void Center(long self, int Width, int Filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Width;
        a[2] = Filler;
        OcctGen.occtCall(4753, a, box);
    }
    public static void ChangeAll(long self, int aChar, int NewChar, boolean CaseSensitive) {
        long[] a = new long[4];
        Object[] box = null;
        a[0] = self;
        a[1] = aChar;
        a[2] = NewChar;
        a[3] = CaseSensitive ? 1L : 0L;
        OcctGen.occtCall(4754, a, box);
    }
    public static void Clear(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4755, a, box);
    }
    public static int FirstLocationInSet(long self, String Set, int FromIndex, int ToIndex) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[0] = self;
        box[1] = Set;
        a[2] = FromIndex;
        a[3] = ToIndex;
        long r = OcctGen.occtCall(4756, a, box);
        return (int) r;
    }
    public static int FirstLocationNotInSet(long self, String Set, int FromIndex, int ToIndex) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[0] = self;
        box[1] = Set;
        a[2] = FromIndex;
        a[3] = ToIndex;
        long r = OcctGen.occtCall(4757, a, box);
        return (int) r;
    }
    public static void Insert(long self, int where, int what) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = what;
        OcctGen.occtCall(4758, a, box);
    }
    public static void Insert_2(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4759, a, box);
    }
    public static void Insert_3(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4760, a, box);
    }
    public static void InsertAfter(long self, int Index, String other) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = Index;
        box[2] = other;
        OcctGen.occtCall(4761, a, box);
    }
    public static void InsertBefore(long self, int Index, String other) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = Index;
        box[2] = other;
        OcctGen.occtCall(4762, a, box);
    }
    public static boolean IsEmpty(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4763, a, box);
        return r != 0;
    }
    public static boolean IsLess(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4764, a, box);
        return r != 0;
    }
    public static boolean IsGreater(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4765, a, box);
        return r != 0;
    }
    public static int IntegerValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4766, a, box);
        return (int) r;
    }
    public static boolean IsIntegerValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4767, a, box);
        return r != 0;
    }
    public static boolean IsRealValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4768, a, box);
        return r != 0;
    }
    public static boolean IsAscii(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4769, a, box);
        return r != 0;
    }
    public static boolean IsDifferent(long self, String S) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = S;
        long r = OcctGen.occtCall(4770, a, box);
        return r != 0;
    }
    public static boolean IsSameString(long self, String S) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = S;
        long r = OcctGen.occtCall(4771, a, box);
        return r != 0;
    }
    public static boolean IsSameString_2(long self, String S, boolean CaseSensitive) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = S;
        a[2] = CaseSensitive ? 1L : 0L;
        long r = OcctGen.occtCall(4772, a, box);
        return r != 0;
    }
    public static void LeftAdjust(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4773, a, box);
    }
    public static void LeftJustify(long self, int Width, int Filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Width;
        a[2] = Filler;
        OcctGen.occtCall(4774, a, box);
    }
    public static int Length(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4775, a, box);
        return (int) r;
    }
    public static int Location(long self, String other, int FromIndex, int ToIndex) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[0] = self;
        box[1] = other;
        a[2] = FromIndex;
        a[3] = ToIndex;
        long r = OcctGen.occtCall(4776, a, box);
        return (int) r;
    }
    public static int Location_2(long self, int N, int C, int FromIndex, int ToIndex) {
        long[] a = new long[5];
        Object[] box = null;
        a[0] = self;
        a[1] = N;
        a[2] = C;
        a[3] = FromIndex;
        a[4] = ToIndex;
        long r = OcctGen.occtCall(4777, a, box);
        return (int) r;
    }
    public static void LowerCase(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4778, a, box);
    }
    public static void Prepend(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        OcctGen.occtCall(4779, a, box);
    }
    public static String Print(long self) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        OcctGen.occtCall(4780, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static double RealValue(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4781, a, box);
        return Double.longBitsToDouble(r);
    }
    public static void RemoveAll(long self, int C, boolean CaseSensitive) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = C;
        a[2] = CaseSensitive ? 1L : 0L;
        OcctGen.occtCall(4782, a, box);
    }
    public static void RemoveAll_2(long self, int what) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = what;
        OcctGen.occtCall(4783, a, box);
    }
    public static void Remove(long self, int where, int ahowmany) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = ahowmany;
        OcctGen.occtCall(4784, a, box);
    }
    public static void RightAdjust(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4785, a, box);
    }
    public static void RightJustify(long self, int Width, int Filler) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = Width;
        a[2] = Filler;
        OcctGen.occtCall(4786, a, box);
    }
    public static int Search(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4787, a, box);
        return (int) r;
    }
    public static int Search_2(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4788, a, box);
        return (int) r;
    }
    public static int SearchFromEnd(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4789, a, box);
        return (int) r;
    }
    public static int SearchFromEnd_2(long self, String what) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = what;
        long r = OcctGen.occtCall(4790, a, box);
        return (int) r;
    }
    public static void SetValue(long self, int where, int what) {
        long[] a = new long[3];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        a[2] = what;
        OcctGen.occtCall(4791, a, box);
    }
    public static void SetValue_2(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4792, a, box);
    }
    public static void SetValue_3(long self, int where, String what) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = where;
        box[2] = what;
        OcctGen.occtCall(4793, a, box);
    }
    public static String Split(long self, int where) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        a[1] = where;
        OcctGen.occtCall(4794, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String SubString(long self, int FromIndex, int ToIndex) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        a[1] = FromIndex;
        a[2] = ToIndex;
        OcctGen.occtCall(4795, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String ToCString(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(4796, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static String Token(long self, String separators, int whichone) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[0] = self;
        box[1] = separators;
        a[2] = whichone;
        OcctGen.occtCall(4797, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static void Trunc(long self, int ahowmany) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = ahowmany;
        OcctGen.occtCall(4798, a, box);
    }
    public static void UpperCase(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        OcctGen.occtCall(4799, a, box);
    }
    public static int UsefullLength(long self) {
        long[] a = new long[1];
        Object[] box = null;
        a[0] = self;
        long r = OcctGen.occtCall(4800, a, box);
        return (int) r;
    }
    public static int Value(long self, int where) {
        long[] a = new long[2];
        Object[] box = null;
        a[0] = self;
        a[1] = where;
        long r = OcctGen.occtCall(4801, a, box);
        return (int) r;
    }
    public static String String(long self) {
        long[] a = new long[1];
        Object[] box = new Object[1];
        a[0] = self;
        OcctGen.occtCall(4802, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static boolean IsSameState(long self, String other) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        a[0] = self;
        box[1] = other;
        long r = OcctGen.occtCall(4803, a, box);
        return r != 0;
    }
    }

    public static final class Units {
        private Units() {}

    public static void UnitsFile(String afile) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = afile;
        OcctGen.occtCall(4933, a, box);
    }
    public static void LexiconFile(String afile) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = afile;
        OcctGen.occtCall(4934, a, box);
    }
    public static String FirstQuantity(String aunit) {
        long[] a = new long[2];
        Object[] box = new Object[2];
        box[1] = aunit;
        OcctGen.occtCall(4935, a, box);
        return (box[0] instanceof String) ? (String) box[0] : "";
    }
    public static double Convert(double avalue, String afirstunit, String asecondunit) {
        long[] a = new long[4];
        Object[] box = new Object[4];
        a[1] = Double.doubleToRawLongBits(avalue);
        box[2] = afirstunit;
        box[3] = asecondunit;
        long r = OcctGen.occtCall(4936, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double ToSI(double aData, String aUnit) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[1] = Double.doubleToRawLongBits(aData);
        box[2] = aUnit;
        long r = OcctGen.occtCall(4937, a, box);
        return Double.longBitsToDouble(r);
    }
    public static double FromSI(double aData, String aUnit) {
        long[] a = new long[3];
        Object[] box = new Object[3];
        a[1] = Double.doubleToRawLongBits(aData);
        box[2] = aUnit;
        long r = OcctGen.occtCall(4938, a, box);
        return Double.longBitsToDouble(r);
    }
    }

}
