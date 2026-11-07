package com.volcano.occt;

/**
 * OpenCASCADE 几何内核安卓门面。所有方法为静态，返回值中的 long 为本地 TopoDS_Shape 句柄，0 表示失败。
 *
 * 覆盖范围：18 个 libTK*.so 每个都被 libocctjni.so 直接引用（见 out/tk_direct_coverage.txt）。
 */
public final class OcctJni {
    static {
        System.loadLibrary("occtjni");
    }

    private OcctJni() {}

    /* ------------------------------------------------ 诊断 / 内核 (TKernel) */

    /** OCCT 内核版本号字符串 */
    public static native String kernelInfo();

    /** 定宽数值文本，走 TCollection_AsciiString */
    public static native String formatNumber(double value, int width);

    /** 探测本地库与导出符号：0=库已加载且符号可解析, 1=dlopen 失败, 2=符号未找到, 3=其它 */
    public static native int probeLibrary(String libName, String mangledSymbol);

    /* ------------------------------------------------------ 初等体 (TKPrim) */

    public static native long makeBox(double lx, double ly, double lz);

    public static native long makeCylinder(double radius, double height);

    public static native long makeSphere(double radius);

    public static native long makeCone(double radius1, double radius2, double height);

    public static native long makeTorus(double radiusMajor, double radiusMinor);

    /** 楔体：底面 (0,0)-(dx,dz)，y=dy 处的截面矩形为 (xmin,zmin)-(xmax,zmax)；
     *  四个截面参数取 0,0,dx,dz 时退化为长方体 */
    public static native long makeWedge(double dx, double dy, double dz,
                                        double xmin, double zmin, double xmax, double zmax);

    /** 面沿向量拉伸成实体 */
    public static native long extrude(long shape, double dx, double dy, double dz);

    /** 绕 Z 轴回转 */
    public static native long revolve(long shape, double angleRad);

    /* ------------------------------------------- 布尔运算 (TKBO / TKBool) */

    public static native long cut(long shapeA, long shapeB);

    public static native long fuse(long shapeA, long shapeB);

    public static native long common(long shapeA, long shapeB);

    /** 求交结果里的交线边数，失败返回 -1 */
    public static native int sectionEdgeCount(long shapeA, long shapeB);

    /** 绕 Z 轴旋转 angleRad 后平移到 (dx,dy,dz)，变换矩阵来自 gp_Trsf (TKMath) */
    public static native long transformShape(long shape, double dx, double dy, double dz, double angleRad);

    /* ----------------------------------------------- 测量 (TKTopAlgo / TKBRep) */

    public static native double getVolume(long shape);

    public static native double getArea(long shape);

    /** 边（或边的集合）的总长度 */
    public static native double getLinearLength(long shape);

    /** 质心 [x,y,z] */
    public static native double[] getCenterOfMass(long shape);

    /** 拓扑统计 [顶点, 边, 线框, 面, 壳, 实体] */
    public static native int[] getTopologyCounts(long shape);

    /** 轴测包围盒 [xmin,ymin,zmin,xmax,ymax,zmax] */
    public static native double[] getBoundingBox(long shape);

    /** 1=有效, 0=无效, -1=出错 */
    public static native int isValidShape(long shape);

    /** BREP 文本文件写出，1=成功 */
    public static native int writeBRep(long shape, String path);

    public static native long readBRep(String path);

    /* ---------------------------------- 构造 (TKTopAlgo / TKG3d / TKG2d / TKGeomAlgo / TKGeomBase) */

    /** 由两点建线段，返回边句柄；投影/求交类算法要求被投影形状是边或线框 */
    public static native long makeSegment(double x1, double y1, double z1,
                                          double x2, double y2, double z2);

    /** 由 12 个 double（4 个 xyz 点）围成平面，返回面句柄 */
    public static native long makeFaceFromQuad(double[] points);

    /** 整圆周长：Geom_Circle + GCPnts 弧长积分 */
    public static native double circleLength(double radius);

    /** 3D 点列插值曲线长度，points 为 xyz 连续排布 */
    public static native double interpolateCurveLength(double[] points);

    /** 二维圆求交，圆心分别在 (0,0) 与 (centerDistance,0)；返回 [交点数, x1, y1, x2, y2] */
    public static native double[] intersectCircles2d(double radius1, double radius2, double centerDistance);

    /* --------------------------------------------- 特征 (TKFillet / TKOffset / TKFeat) */

    public static native long chamferAllEdges(long shape, double distance);

    public static native long filletAllEdges(long shape, double radius);

    /** 整体偏移，负值向内；闭合实体向内偏移可用于抽壳 */
    public static native long offsetShape(long shape, double offset);

    /** 沿过 (axisX,axisY) 的 Z 轴钻通孔 */
    public static native long drillHole(long shape, double axisX, double axisY, double radius);

    /** 把 projectShape 沿 (dx,dy,dz) 投影到 targetShape 上（TKBool BRepProj_Projection） */
    public static native long projectOntoShape(long targetShape, long projectShape,
                                               double dx, double dy, double dz);

    /* ------------------------------------- 修复与缝合 (TKShHealing / TKTopAlgo) */

    /** 缝合若干面成闭合实体 */
    public static native long sewToSolid(long[] faceHandles, double tolerance);

    /** 同域面合并 */
    public static native long unifySameDomain(long shape);

    /* ----------------------------------------------- 网格 (TKMesh / TKXMesh) */

    /** 非索引三角形顶点，按 xyz 连续排布；长度为 0 表示失败或无网格 */
    public static native float[] tessellate(long shape, double linearDeflection);

    /** 走 XBRepMesh 插件入口网格化后的三角形总数，失败返回 -1 */
    public static native int xmeshTriangleCount(long shape, double linearDeflection);

    /* ------------------------------------------------------- 隐藏线 (TKHLR) */

    /** 指定视角方向下的可见边数，失败返回 -1 */
    public static native int hlrVisibleEdgeCount(long shape, double dx, double dy, double dz,
                                                 double linearDeflection);

    /* ------------------------------------------------------------ 收尾 */

    public static native void release(long shape);

    public static native String lastError();
}
