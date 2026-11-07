#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Skia 火山封装 · 冒烟守门一键脚本。

一条命令完成：

    生成冒烟桩 (tools/gen_smoke.py)  →  火山命令行全量编译  →  解析日志  →  打印结论

退出码：
    0  通过（0 错误，且桩确实覆盖了 wsv 里的方法）
    1  失败（编译错误 / 生成失败 / 桩没覆盖到方法 / 产物缺失）

用法：
    python tools/smoke.py            # 常规守门
    python tools/smoke.py -v         # 额外打印日志尾部与全部错误行

判定口径（重要，不要只看退出码）：
    火山对「从未被调用的方法」根本不生成 C++，所以**没有冒烟桩时 0 错误毫无意义**。
    本脚本先跑 gen_smoke 生成桩、再编译，因此「0 错误」才等价于
    「wsv 里每一个公开方法的方法体都真的进了 MSVC」。
    但请注意：桩只保证**能编译**，不保证语义正确、也不保证运行时不崩。
"""

import os
import re
import subprocess
import sys
import time

# ---------------------------------------------------------------- 路径常量
ROOT = r"E:\AI开发\Skia工具"
GEN_SMOKE = os.path.join(ROOT, "tools", "gen_smoke.py")
STUB_WSV = os.path.join(ROOT, "Skia冒烟.wsv")
VSLN = os.path.join(ROOT, "examples", "Skia冒烟测试.vsln")
LOG = os.path.join(ROOT, "examples", "Skia冒烟测试", "build.log")
LINKER_DIR = os.path.join(ROOT, "examples", "_int", "Skia冒烟测试",
                          "release", "x64", "linker")
VOLDEV = r"D:\Voldev\bin\x64\voldev_awp.exe"

# 功能/像素验证（第二步；工程不存在时自动跳过）
FUNC_VSLN = os.path.join(ROOT, "examples", "Skia功能验证.vsln")
FUNC_LOG = os.path.join(ROOT, "examples", "Skia功能验证", "build.log")
FUNC_EXE = os.path.join(ROOT, "examples", "_int", "Skia功能验证",
                        "release", "x64", "linker", "Skia功能验证.exe")
FUNC_REPORT = os.path.join(ROOT, "examples", "verify_report.txt")

# 像素级验证（第三步；工程不存在时自动跳过）
PIXEL_VSLN = os.path.join(ROOT, "examples", "Skia像素验证.vsln")
PIXEL_LOG = os.path.join(ROOT, "examples", "Skia像素验证", "build.log")
PIXEL_EXE = os.path.join(ROOT, "examples", "_int", "Skia像素验证",
                         "release", "x64", "linker", "Skia像素验证.exe")
PIXEL_REPORT = os.path.join(ROOT, "examples", "pixel_report.txt")

# ---------------------------------------------------------------- 正则
RE_SUMMARY = re.compile(r"成功\s*(\d+)\s*个\s*,\s*失败\s*(\d+)\s*个")
RE_WARN = re.compile(r"共遇到了\s*(\d+)\s*个警告")
RE_METHOD_TOTAL = re.compile(r"wsv 方法总数\s*:\s*(\d+)")
RE_MISSING = re.compile(r"映射里有、wsv 里还没有\s*(\d+)\s*条")
# 编译器诊断行：MSVC 的 error C####/LNK####，以及火山自己的「错误:」行
RE_ERR_LINE = re.compile(r"(error\s+[CL]\d{4}|fatal error|错误\s*[:：])")
# 从诊断行里抠出可用于回查 wsv 的符号
RE_SYMBOL = re.compile(r"(sk_[A-Za-z0-9_]+)")
RE_QUOTED = re.compile(r'[\"\u201c]([^\"]{2,40})[\"\u201d]')


def _decode_line(bs):
    """单行解码。火山自己的输出是 UTF-8，内嵌 MSVC 的诊断是 GBK，必须按行探。

    注意：火山写 /ff 日志时会把 MSVC 的 GBK 中文转成 U+FFFD 替换字符（信息已丢失，
    无法还原）。所以错误行里的中文描述会变成乱码，但 **错误码 / 文件:行号 / 符号名**
    都是 ASCII，完整可用，足以定位问题。这里把连续替换字符压成 '?' 以便阅读。
    """
    for enc in ("utf-8", "gbk"):
        try:
            text = bs.decode(enc)
            break
        except UnicodeDecodeError:
            continue
    else:
        text = bs.decode("utf-8", errors="replace")
    return re.sub("\ufffd+", "?", text)


def _decode(raw):
    """voldev 的输出是 UTF-8 与 GBK 混排（它自己 UTF-8，内嵌 MSVC 是 GBK），逐行探。"""
    if not raw:
        return ""
    return "\n".join(_decode_line(ln) for ln in raw.split(b"\n"))


def _read_text(path):
    try:
        with open(path, "rb") as fp:
            return _decode(fp.read())
    except OSError:
        return ""


def module_wsv_files():
    """从 skia.vgrp 取模块内的 .wsv 清单（体积拆分后不能写死文件名）。"""
    names = []
    try:
        with open(os.path.join(ROOT, "skia.vgrp"), "r", encoding="utf-8") as fp:
            in_block = False
            for raw in fp:
                line = raw.strip()
                if line == "file":
                    in_block = True
                    continue
                if in_block:
                    if line.startswith("}"):
                        break
                    m = re.match(r'name\s*=\s*"([^"]+\.wsv)"', line)
                    if m:
                        names.append(m.group(1))
    except OSError:
        pass
    if not names:
        names = sorted(f for f in os.listdir(ROOT)
                       if f.endswith(".wsv") and f != os.path.basename(STUB_WSV))
    return [os.path.join(ROOT, n) for n in names]


def locate_in_wsv(symbols, limit_per_symbol=3):
    """把诊断行里的符号回查到具体 wsv 的「文件:行号」，工程被拆成多文件时尤其有用。

    火山会把生成的 cpp 文件名按 GBK→UTF-8 有损转码（`vpkg_Skia核心.cpp` 与
    `vpkg_Skia几何.cpp` 都变成 `vpkg_Skia?.cpp`），光看文件名分不出是哪个文件；
    用符号回查 wsv 才是可靠的。
    """
    hits = {}
    if not symbols:
        return hits
    for path in module_wsv_files():
        try:
            with open(path, "r", encoding="utf-8") as fp:
                lines = fp.readlines()
        except OSError:
            continue
        base = os.path.basename(path)
        for idx, line in enumerate(lines, 1):
            for sym in symbols:
                if sym in line and len(hits.get(sym, [])) < limit_per_symbol:
                    hits.setdefault(sym, []).append(f"{base}:{idx}")
    return hits


def extract_symbols(err_lines):
    """从错误行里提取能回查 wsv 的符号：sk_* 原生名 + 引号里的中文名。"""
    syms = set()
    for ln in err_lines:
        for m in RE_SYMBOL.finditer(ln):
            syms.add(m.group(1))
        for m in RE_QUOTED.finditer(ln):
            s = m.group(1).strip()
            if s and not s.startswith(".") and len(s) <= 40:
                syms.add(s)
    return sorted(syms)


def _is_lock_conflict(err_lines):
    """并发编译冲突识别：同时有别人在编同一套工程时会锁 .pch/.obj。

    这不是代码缺陷，等一会儿重试即可（见 docs/封装流程.md §4.14）。
    """
    text = "\n".join(err_lines)
    return ("Permission denied" in text) and (".pch" in text or ".obj" in text)


def step(title):
    print()
    print("-" * 72)
    print(title)
    print("-" * 72)


def run_gen():
    """第 1 步：生成冒烟桩。返回 (ok, 输出文本, 覆盖方法数, 缺失条数)。"""
    step("[1/3] 生成冒烟桩  tools/gen_smoke.py")
    files = module_wsv_files()
    missing_files = [f for f in files if not os.path.isfile(f)]
    if not files or missing_files:
        print(f"× 模块 wsv 缺失: {missing_files or '（skia.vgrp 里没读到文件清单）'}")
        return False, "", 0, 0

    proc = subprocess.run([sys.executable, GEN_SMOKE],
                          cwd=ROOT, capture_output=True)
    out = _decode(proc.stdout) + _decode(proc.stderr)
    print(out.rstrip())

    if proc.returncode != 0:
        print(f"× 生成器退出码 {proc.returncode}")
        return False, out, 0, 0

    if not os.path.isfile(STUB_WSV):
        print(f"× 生成器没有产出桩文件: {STUB_WSV}")
        return False, out, 0, 0

    m = RE_METHOD_TOTAL.search(out)
    total = int(m.group(1)) if m else 0
    m = RE_MISSING.search(out)
    missing = int(m.group(1)) if m else 0

    if total == 0:
        print("× 桩覆盖 0 个方法，冒烟闸门没有意义")
        return False, out, 0, missing

    print(f"√ 桩已生成，覆盖 {total} 个方法")
    return True, out, total, missing


def run_compile(verbose=False):
    """第 2 步：火山命令行全量编译。返回 (ok, 错误行列表, 成功数, 失败数, 警告数)。"""
    step("[2/3] 火山命令行编译  voldev_awp @compile")
    if not os.path.isfile(VSLN):
        print(f"× 找不到解决方案: {VSLN}")
        return False, [f"缺少解决方案文件 {VSLN}"], 0, 0, 0
    if not os.path.isfile(VOLDEV):
        print(f"× 找不到火山命令行编译器: {VOLDEV}")
        return False, [f"缺少编译器 {VOLDEV}"], 0, 0, 0

    if os.path.isfile(LOG):
        os.remove(LOG)

    env = dict(os.environ)
    # 保险：即使以后有人从 Git Bash 里调本脚本，也不让 MSYS 改写 /r /ff 这类开关
    env["MSYS_NO_PATHCONV"] = "1"

    cmd = [VOLDEV, "@compile", VSLN, "/r", "/ff", LOG]
    print("命令: " + " ".join(f'"{c}"' if " " in c else c for c in cmd))
    proc = subprocess.run(cmd, cwd=os.path.dirname(VSLN),
                          capture_output=True, env=env)

    stdout = _decode(proc.stdout)
    stderr = _decode(proc.stderr)
    logtext = _read_text(LOG)

    print(stdout.rstrip() if stdout.strip() else "(stdout 为空)")
    if stderr.strip():
        # 沙箱可能会拒绝启动 reg.exe，这条与编译结果无关，单独标注避免误判
        noise = [ln for ln in stderr.splitlines()
                 if "PROGRAM BLOCKED BY SECURITY POLICY" in ln
                 or ln.strip().startswith("- ")]
        real = [ln for ln in stderr.splitlines() if ln not in noise]
        for ln in real:
            print("stderr: " + ln)
        if noise:
            print("(注: 上面的 reg.exe 安全策略拦截与本工程编译无关, 已忽略)")

    corpus = "\n".join([stdout, stderr, logtext])
    m = RE_SUMMARY.search(corpus)
    ok_n, bad_n = (int(m.group(1)), int(m.group(2))) if m else (0, 0)
    m = RE_WARN.search(corpus)
    warn_n = int(m.group(1)) if m else 0

    err_lines = []
    for ln in corpus.splitlines():
        if RE_ERR_LINE.search(ln) and "PROGRAM BLOCKED" not in ln:
            s = ln.strip()
            if s and s not in err_lines:
                err_lines.append(s)

    if verbose and logtext.strip():
        print()
        print("--- build.log 末 25 行 ---")
        for ln in logtext.splitlines()[-25:]:
            print(ln)

    ok = (proc.returncode == 0 and bad_n == 0 and not err_lines)
    if not ok and not err_lines:
        err_lines.append(f"编译器退出码 {proc.returncode}，但未捕获到 error 行（请用 -v 看完整日志）")

    # 并发编译会锁 .pch/.obj（报 Permission denied）。这不是缺陷，等一会儿重试一次。
    if not ok and _is_lock_conflict(err_lines):
        print()
        print("检测到并发编译冲突（.pch/.obj 被占用，Permission denied）——")
        print("通常是工程师正在编同一套工程。**这不是代码缺陷**，等 30 秒自动重试一次…")
        time.sleep(30)
        proc = subprocess.run(cmd, cwd=os.path.dirname(VSLN),
                              capture_output=True, env=env)
        stdout = _decode(proc.stdout)
        stderr = _decode(proc.stderr)
        logtext = _read_text(LOG)
        corpus = "\n".join([stdout, stderr, logtext])
        m = RE_SUMMARY.search(corpus)
        ok_n, bad_n = (int(m.group(1)), int(m.group(2))) if m else (0, 0)
        m = RE_WARN.search(corpus)
        warn_n = int(m.group(1)) if m else 0
        err_lines = []
        for ln in corpus.splitlines():
            if RE_ERR_LINE.search(ln) and "PROGRAM BLOCKED" not in ln:
                t = ln.strip()
                if t and t not in err_lines:
                    err_lines.append(t)
        ok = (proc.returncode == 0 and bad_n == 0 and not err_lines)
        if ok:
            print("重试成功：之前的 Permission denied 确认为并发冲突。")
        else:
            print("重试后仍失败。若仍是 Permission denied，请确认没有其他进程在编译。")

    return ok, err_lines, ok_n, bad_n, warn_n


def check_artifacts():
    """第 3 步：确认产物与随包 DLL 都在位。返回 (ok, 说明)。"""
    step("[3/3] 校验产物")
    exe = os.path.join(LINKER_DIR, "Skia冒烟测试.exe")
    dll = os.path.join(LINKER_DIR, "libSkiaSharp.dll")
    ok = True
    if os.path.isfile(exe):
        size = os.path.getsize(exe)
        print(f"√ exe   {exe}  ({size / 1048576:.2f} MB)")
    else:
        print(f"× 缺少 exe: {exe}")
        ok = False
    if os.path.isfile(dll):
        size = os.path.getsize(dll)
        print(f"√ dll   {dll}  ({size / 1048576:.2f} MB)   <- 由 @视窗.附属文件 自动复制")
    else:
        print(f"× 缺少 libSkiaSharp.dll，运行时会因找不到 DLL 直接退出: {dll}")
        ok = False
    return ok


def run_verify_project(label, vsln, log_path, exe, report_path, verbose=False):
    """通用：编译 + 运行一个「写报告」型验证工程，读回报告判定。

    返回 (state, 说明)，state ∈ {'skip', 'pass', 'fail'}。工程不存在时 'skip'。
    """
    step(f"[验证] {label}")
    if not os.path.isfile(vsln):
        print(f"跳过：{os.path.basename(vsln)} 不存在")
        return "skip", ""

    env = dict(os.environ)
    env["MSYS_NO_PATHCONV"] = "1"
    if os.path.isfile(log_path):
        os.remove(log_path)
    proc = subprocess.run([VOLDEV, "@compile", vsln, "/r", "/ff", log_path],
                          cwd=os.path.dirname(vsln), capture_output=True, env=env)
    corpus = _decode(proc.stdout) + "\n" + _decode(proc.stderr) + "\n" + _read_text(log_path)
    m = RE_SUMMARY.search(corpus)
    bad = int(m.group(2)) if m else 1
    if proc.returncode != 0 or bad:
        print(f"× {label} 工程编译失败（退出码 {proc.returncode}，失败 {bad} 个）")
        for ln in corpus.splitlines():
            if RE_ERR_LINE.search(ln) and "PROGRAM BLOCKED" not in ln:
                print("  " + ln.strip())
        return "fail", f"{label} 工程编译失败"

    if not os.path.isfile(exe):
        print(f"× 缺少 exe: {exe}")
        return "fail", f"缺少 {label} exe"

    if os.path.isfile(report_path):
        os.remove(report_path)

    p = subprocess.Popen([exe], cwd=os.path.dirname(exe))
    report = ""
    for _ in range(40):                      # 最多等 20 秒
        if os.path.isfile(report_path):
            report = _read_text(report_path)
            if "汇总:" in report:
                break
        time.sleep(0.5)
    try:
        p.kill()
    except Exception:
        pass

    if not report:
        print(f"× 没有产出报告: {report_path}")
        return "fail", f"{label} 没有产出报告"

    m = re.search(r"汇总:\s*通过\s*(\d+)\s*项\s*,\s*失败\s*(\d+)\s*项", report)
    if not m:
        print("× 报告里没有「汇总: 通过 N 项, 失败 M 项」")
        if verbose:
            print(report[-1500:])
        return "fail", f"{label} 报告格式异常"
    ok_n, bad_n = int(m.group(1)), int(m.group(2))

    print(f"{label}: 通过 {ok_n} 项，失败 {bad_n} 项   （报告: {report_path}）")
    if bad_n:
        print("失败项:")
        for ln in report.splitlines():
            if "[NG]" in ln:
                print("  " + ln.strip())
        return "fail", f"{label} 失败 {bad_n} 项"
    return "pass", f"通过 {ok_n} 项"


def main():
    verbose = "-v" in sys.argv[1:] or "--verbose" in sys.argv[1:]

    print("=" * 72)
    print("Skia 封装 · 冒烟守门")
    print("=" * 72)
    print(f"工程根  : {ROOT}")
    print("模块文件:")
    for p in module_wsv_files():
        state = "ok" if os.path.isfile(p) else "缺失"
        print(f"          {os.path.basename(p)}  [{state}]")
    print(f"桩      : {STUB_WSV}")
    print(f"宿主    : {VSLN}")

    gen_ok, _, total, missing = run_gen()
    if not gen_ok:
        print()
        print("=" * 72)
        print("【失败】冒烟桩生成阶段就没过，后续编译无意义。")
        return 1

    comp_ok, err_lines, ok_n, bad_n, warn_n = run_compile(verbose)
    art_ok = check_artifacts() if comp_ok else False

    func_state, func_note = ("skip", "")
    pixel_state, pixel_note = ("skip", "")
    if comp_ok and art_ok and "--no-func" not in sys.argv[1:]:
        func_state, func_note = run_verify_project(
            "功能读回验证", FUNC_VSLN, FUNC_LOG, FUNC_EXE, FUNC_REPORT, verbose)
        pixel_state, pixel_note = run_verify_project(
            "像素级验证", PIXEL_VSLN, PIXEL_LOG, PIXEL_EXE, PIXEL_REPORT, verbose)

    print()
    print("=" * 72)
    if comp_ok and art_ok and func_state != "fail" and pixel_state != "fail":
        extra = f"，映射缺口 {missing} 条（未实现，不参与本次编译）" if missing else ""
        print(f"【通过】覆盖 {total} 个方法，0 个错误，{warn_n} 个警告{extra}")
        print(f"        功能读回验证: {func_note if func_state == 'pass' else '跳过（工程未建）'}")
        print(f"        像素级验证  : {pixel_note if pixel_state == 'pass' else '跳过（工程未建）'}")
        print("=" * 72)
        print("说明: 通过 = 「wsv 里每个公开方法的方法体都真的进了 MSVC」+ 功能/像素断言全绿。")
        if func_state != "pass" or pixel_state != "pass":
            print("      注意: 有验证工程被跳过, 语义正确性尚未完全覆盖。")
        return 0

    print(f"【失败】编译结果: 成功 {ok_n} 个，失败 {bad_n} 个，{warn_n} 个警告")
    if func_state == "fail":
        print(f"        功能读回验证: {func_note}")
    if pixel_state == "fail":
        print(f"        像素级验证  : {pixel_note}")
    print("=" * 72)
    if err_lines:
        print()
        print(f"错误原文（共 {len(err_lines)} 行）:")
        for ln in err_lines:
            print("  " + ln)

        print()
        print("符号回查（错误行里的符号 -> wsv 位置，最多列 12 个）:")
        hits = locate_in_wsv(extract_symbols(err_lines))
        if not hits:
            print("  （没抠到可回查的符号，请用 -v 看完整日志）")
        # sk_* 原生符号最有定位价值，排前面；其余（引号里的中文名）噪声大，靠后并限量
        ordered = sorted(hits, key=lambda s: (not s.startswith("sk_"), -len(hits[s]), s))
        for sym in ordered[:12]:
            print(f"  {sym:<34} <- {', '.join(hits[sym])}")
        if len(ordered) > 12:
            print(f"  ... 另有 {len(ordered) - 12} 个符号命中（噪声较多，已省略）")
    print()
    print("排查顺序建议:")
    print("  1. 若错误集中在 vpkg_Skia冒烟.cpp      -> 桩生成的问题, 改 tools/gen_smoke.py")
    print("  2. 若错误在 vpkg_Skia核心.cpp 的 @ 行  -> wsv 真实缺陷, 报给工程师(附行号+原生函数名)")
    print("  3. 若报 C1083 找不到 skia_include.h    -> wsv 被移出了工程根, 相对路径失效")
    return 1


if __name__ == "__main__":
    sys.exit(main())
