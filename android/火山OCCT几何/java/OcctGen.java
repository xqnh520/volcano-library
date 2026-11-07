package com.volcano.occt;

// 由 gen/emit_java.py 生成，请勿手改。
//
// OpenCASCADE 通用入口（4 个 native，JNI 导出名 Java_com_volcano_occt_OcctGen_*）。
// 调用协议：
//   long[] a   ：a[0] = 接收者句柄（static/构造 传 0），a[1+i] = 第 i 个参数；
//                出参写回同一 a 槽，调用返回后读 a[slot] 取回。
//   Object[] box：box[0] 兼作文本返回值；box[1+i] 与第 i 个参数同下标（文本参数）。
// 失败口径：返回 0 / "" / false，原因用 lastError() 读（读一次即清空，线程内有效）。
// 生命周期：所有对象都是"代次句柄"，用完必须 free(h)；句柄释放后再用会报 stale handle。
public final class OcctGen {
    static { System.loadLibrary("occtjni"); }
    private OcctGen() {}

    static native long occtCall(int mid, long[] a, Object[] box);
    static native void occtFree(long h);
    static native String occtError();
    static native long occtMeta(int what, long arg);

    /** 释放对象句柄（0 忽略；重复释放报 stale handle 而不是崩溃）。 */
    public static void free(long h) { occtFree(h); }

    /** 读并清空最近一次错误（空串 = 无错）。 */
    public static String lastError() { return occtError(); }

    /** 内核信息：1=方法槽数、2=类数、3=OCC_VERSION_HEX、4=池槽总数(含已释放空槽)。 */
    public static long meta(int what, long arg) { return occtMeta(what, arg); }
}
