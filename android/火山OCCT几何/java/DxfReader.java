package com.volcano.occt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * DXF (ASCII) 读入器：解析 ENTITIES 段中的 LINE/CIRCLE/ARC/LWPOLYLINE/POLYLINE/POINT 子集，
 * 输出扁平化 double 协议数组供火山侧使用。
 *
 * 协议：[总数 N, (型别, 数据个数, 数据...)*N]，型别 1=线[4] 2=圆[3] 3=弧[5: 圆心x,圆心y,半径,起始角°,终止角°]
 * 4=多段线[3+2k: 闭合标志, 顶点数k, 坐标...] 5=点[2]。失败返回 [-1] 并用 lastError() 给出原因（读到即清空）。
 *
 * 解析只消费数字组码，图层名等字符串值一律跳过——因此文件无论 UTF-8 还是 GBK 都不影响结果。
 */
public final class DxfReader {
    private static String lastError = "";

    private DxfReader() {}

    /** 读取并清空最近一次错误；空文本表示无错误。 */
    public static String lastError() {
        String e = lastError;
        lastError = "";
        return e;
    }

    public static double[] parse(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"), 1 << 16);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
            return parseText(sb.toString());
        } catch (Throwable t) {
            lastError = "dxf 读取失败: " + t;
            return new double[]{-1};
        } finally {
            if (br != null) {
                try { br.close(); } catch (IOException ignored) {}
            }
        }
    }

    /** 内置演示图形的实体表: 与外部测试文件同构的小样例 (线4/圆2/弧1/多段线3/点2), 供界面自检使用. */
    public static double[] demoTable() {
        StringBuilder sb = new StringBuilder();
        e(sb, "0", "SECTION", "2", "ENTITIES");
        // 矩形轮廓 4 条线
        e(sb, "0", "LINE", "8", "轮廓层", "10", "0", "20", "0", "11", "100", "21", "0");
        e(sb, "0", "LINE", "8", "轮廓层", "10", "100", "20", "0", "11", "100", "21", "60");
        e(sb, "0", "LINE", "8", "轮廓层", "10", "100", "20", "60", "11", "0", "21", "60");
        e(sb, "0", "LINE", "8", "轮廓层", "10", "0", "20", "60", "11", "0", "21", "0");
        // 同心圆
        e(sb, "0", "CIRCLE", "8", "圆层", "10", "50", "20", "30", "40", "20");
        e(sb, "0", "CIRCLE", "8", "圆层", "10", "50", "20", "30", "40", "10");
        // 四分之三圆弧
        e(sb, "0", "ARC", "8", "圆层", "10", "150", "20", "30", "40", "25", "50", "0", "51", "270");
        // 闭合五边形 (轻量多段线)
        e(sb, "0", "LWPOLYLINE", "8", "轮廓层", "70", "1", "90", "5", "10", "200", "20", "0",
                "10", "230", "20", "0", "10", "245", "20", "20", "10", "215", "20", "40", "10", "185", "20", "20");
        // 开口折线 (轻量多段线)
        e(sb, "0", "LWPOLYLINE", "8", "标注层", "70", "0", "90", "4", "10", "0", "20", "80",
                "10", "30", "20", "110", "10", "60", "20", "80", "10", "90", "20", "110");
        // 老式多段线
        e(sb, "0", "POLYLINE", "8", "标注层", "66", "1", "70", "0");
        e(sb, "0", "VERTEX", "10", "200", "20", "60");
        e(sb, "0", "VERTEX", "10", "220", "20", "80");
        e(sb, "0", "VERTEX", "10", "240", "20", "60");
        e(sb, "0", "SEQEND");
        // 两个点
        e(sb, "0", "POINT", "8", "标注层", "10", "10", "20", "10");
        e(sb, "0", "POINT", "8", "标注层", "10", "240", "20", "90");
        e(sb, "0", "ENDSEC", "0", "EOF");
        return parseText(sb.toString());
    }

    private static void e(StringBuilder sb, String... codeValuePairs) {
        for (int i = 0; i + 1 < codeValuePairs.length; i += 2) {
            sb.append(codeValuePairs[i]).append('\n').append(codeValuePairs[i + 1]).append('\n');
        }
    }

    public static double[] parseText(String text) {
        String[] L = text.replace("\r\n", "\n").replace('\r', '\n').split("\n", -1);
        ArrayList<Double> out = new ArrayList<>();
        out.add(0.0); // 占位：总数

        boolean inEntities = false;
        boolean sawEntities = false;
        boolean pendingSection = false;
        String cur = null;

        double v10 = Double.NaN, v20 = Double.NaN, v11 = Double.NaN, v21 = Double.NaN;
        double v40 = Double.NaN, v50 = Double.NaN, v51 = Double.NaN;
        int lwFlag = 0;
        double lwx = Double.NaN;
        ArrayList<Double> pts = new ArrayList<>();

        int n = L.length;
        int i = 0;
        while (i + 1 < n) {
            String codeS = L[i].trim();
            String valS = L[i + 1];
            i += 2;
            int code;
            try {
                code = Integer.parseInt(codeS);
            } catch (NumberFormatException e) {
                continue; // 非组码行：容错跳过
            }

            if (code == 0) {
                // 新记录开始前，先结算上一个实体
                boolean isVertexRec = "VERTEX".equals(valS);
                if ("VERTEX".equals(cur)) {
                    if (!isVertexRec) {
                        // 顶点序列结束（SEQEND 或容错：直接遇到其它记录）
                        flushPolyline(out, lwFlag, pts);
                        cur = null;
                    }
                } else if ("POLYLINE".equals(cur) && !isVertexRec) {
                    flushPolyline(out, lwFlag, pts); // 无顶点就遇到别的记录
                    cur = null;
                } else if ("LWPOLYLINE".equals(cur)) {
                    flushPolyline(out, lwFlag, pts);
                    cur = null;
                } else if (cur != null && !"POLYLINE".equals(cur)) {
                    flushSimple(out, cur, v10, v20, v11, v21, v40, v50, v51);
                    cur = null;
                }
                if ("SECTION".equals(valS)) {
                    pendingSection = true;
                } else if ("ENDSEC".equals(valS)) {
                    inEntities = false;
                } else if ("EOF".equals(valS)) {
                    break;
                } else if (inEntities) {
                    if ("VERTEX".equals(valS)) {
                        if ("POLYLINE".equals(cur) || "VERTEX".equals(cur)) {
                            cur = "VERTEX"; // 顶点序列延续
                        } else {
                            cur = null; // 野顶点：忽略
                        }
                    } else if ("SEQEND".equals(valS)) {
                        // POLYLINE 已在上面结算；此处无事
                    } else if (isKnown(valS)) {
                        cur = valS;
                        v10 = v20 = v11 = v21 = v40 = v50 = v51 = Double.NaN;
                        lwFlag = 0;
                        lwx = Double.NaN;
                        pts.clear();
                    } else {
                        cur = null; // 未知实体：跳过
                    }
                }
            } else if (pendingSection && code == 2) {
                inEntities = "ENTITIES".equals(valS.trim());
                if (inEntities) {
                    sawEntities = true;
                }
                pendingSection = false;
            } else if (inEntities && cur != null) {
                double d;
                try {
                    d = Double.parseDouble(valS.trim());
                } catch (NumberFormatException e) {
                    continue;
                }
                if ("VERTEX".equals(cur)) {
                    if (code == 10) {
                        lwx = d;
                    } else if (code == 20 && !Double.isNaN(lwx)) {
                        pts.add(lwx);
                        pts.add(d);
                        lwx = Double.NaN;
                    }
                } else if (code == 10) {
                    if ("LWPOLYLINE".equals(cur)) {
                        if (!Double.isNaN(lwx)) {
                            // 上一个顶点只有 x：按 y=0 容错补入
                            pts.add(lwx);
                            pts.add(0.0);
                        }
                        lwx = d;
                    } else {
                        v10 = d;
                    }
                } else if (code == 20) {
                    if ("LWPOLYLINE".equals(cur)) {
                        if (!Double.isNaN(lwx)) {
                            pts.add(lwx);
                            pts.add(d);
                            lwx = Double.NaN;
                        }
                    } else {
                        v20 = d;
                    }
                } else if ("LWPOLYLINE".equals(cur)) {
                    if (code == 70) {
                        lwFlag = (int) d;
                    }
                } else if (code == 11) {
                    v11 = d;
                } else if (code == 21) {
                    v21 = d;
                } else if (code == 40) {
                    v40 = d;
                } else if (code == 50) {
                    v50 = d;
                } else if (code == 51) {
                    v51 = d;
                } else if (code == 70) {
                    lwFlag = (int) d;
                }
            }
        }

        // 文件末尾结算最后一个实体
        if (cur != null) {
            if ("POLYLINE".equals(cur) || "VERTEX".equals(cur) || "LWPOLYLINE".equals(cur)) {
                flushPolyline(out, lwFlag, pts);
            } else {
                flushSimple(out, cur, v10, v20, v11, v21, v40, v50, v51);
            }
        }

        if (!sawEntities) {
            lastError = "dxf 中没有 ENTITIES 段";
            return new double[]{-1};
        }
        out.set(0, (double) countEntities(out));
        double[] r = new double[out.size()];
        for (int k = 0; k < out.size(); k++) {
            r[k] = out.get(k);
        }
        return r;
    }

    private static boolean isKnown(String val) {
        return "LINE".equals(val) || "CIRCLE".equals(val) || "ARC".equals(val)
                || "LWPOLYLINE".equals(val) || "POLYLINE".equals(val) || "POINT".equals(val);
    }

    private static void flushSimple(ArrayList<Double> out, String cur,
                                    double v10, double v20, double v11, double v21,
                                    double v40, double v50, double v51) {
        if ("LINE".equals(cur)) {
            if (has(v10, v20, v11, v21)) {
                out.add(1.0); out.add(4.0);
                out.add(v10); out.add(v20); out.add(v11); out.add(v21);
            }
        } else if ("CIRCLE".equals(cur)) {
            if (has(v10, v20, v40)) {
                out.add(2.0); out.add(3.0);
                out.add(v10); out.add(v20); out.add(v40);
            }
        } else if ("ARC".equals(cur)) {
            if (has(v10, v20, v40, v50, v51)) {
                out.add(3.0); out.add(5.0);
                out.add(v10); out.add(v20); out.add(v40); out.add(v50); out.add(v51);
            }
        } else if ("POINT".equals(cur)) {
            if (has(v10, v20)) {
                out.add(5.0); out.add(2.0);
                out.add(v10); out.add(v20);
            }
        }
    }

    private static void flushPolyline(ArrayList<Double> out, int flag, ArrayList<Double> pts) {
        if (pts.isEmpty()) {
            return;
        }
        int k = pts.size() / 2;
        if (k < 1) {
            return;
        }
        out.add(4.0);
        out.add((double) (2 + 2 * k)); // 闭合标志 + 顶点数 + 2k 坐标
        out.add((flag & 1) == 1 ? 1.0 : 0.0);
        out.add((double) k);
        out.addAll(pts);
    }

    private static boolean has(double... v) {
        for (double d : v) {
            if (Double.isNaN(d)) {
                return false;
            }
        }
        return true;
    }

    private static int countEntities(ArrayList<Double> out) {
        int count = 0;
        int i = 1;
        while (i + 1 < out.size()) {
            int cnt = out.get(i + 1).intValue();
            count++;
            i += 2 + cnt;
        }
        return count;
    }
}
