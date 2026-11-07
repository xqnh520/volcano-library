#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Skia 火山封装 · 编译期冒烟闸门生成器。

背景
----
火山只为「从启动类可达」的方法生成 C++ 代码。示例程序只调用几十个方法，
剩余几百个 `@` 方法体 MSVC 根本看不到，里面有 C2664/C3861 也照样报「0 警告」。
本脚本生成一个「每个公开方法都被调用一次」的桩文件 `Skia冒烟.wsv`，
强制全部方法体进入编译。

覆盖范围
--------
1. `Skia核心.wsv` 存在时：**以 wsv 里真实声明的全部方法为准**（这是完备的），
   同时用《命名映射-批次1.md》做交叉核对，报告「映射里有、wsv 里还没有」的缺口。
2. wsv 不存在时：退回《命名映射》生成（只覆盖映射里列出的方法）。

生成策略
--------
- 跳过 `类_初始化` / `类_清理`（火山在对象构造/析构时自动调用，无需显式调）。
- `属性读` 方法用 `临时变量 = 实例.属性名` 形式调用（属性不能用括号形式调用）。
- 普通方法用 `实例.名 (实参)`；`静态` 方法用 `类名.名 (实参)`。
- 返回值一律不接收（独立语句），避免类型不匹配。
- 实参按类型填默认值；对象类型按参数位置取「同类实例」甲/乙/丙…，
  批次1 没有构造入口的类型退化为空对象并在注释里标注。
- 结尾只调 `释放 ()`，不调 `类_清理`。

用法
----
    python tools/gen_smoke.py

路径全部内置为常量（不走命令行，避免 Git Bash 把中文路径 mangle）。

输出
----
    E:\\AI开发\\Skia工具\\Skia冒烟.wsv      （UTF-8 无 BOM + CRLF）
    stdout 打印统计：覆盖方法数 / 跳过数 / 缺实例类型 / 映射缺口
"""

import os
import re
import glob
import sys

# ---------------------------------------------------------------- 路径常量
ROOT = r"E:\AI开发\Skia工具"
MAPPING_GLOBS = [os.path.join(ROOT, "docs", "命名映射-批次*.md"),
                 os.path.join(ROOT, "docs", "命名映射-补丁*.md")]  # 补丁是批次1~4 的正式勘误
VALUE_MD = os.path.join(ROOT, "docs", "值类清单.md")
VGRP = os.path.join(ROOT, "skia.vgrp")          # 模块定义，权威文件清单
OUT_WSV = os.path.join(ROOT, "Skia冒烟.wsv")

# ---------------------------------------------------------------- 命名常量
PACKAGE = "火山.Skia"
SMOKE_CLASS = "Skia冒烟"
SMOKE_METHOD = "执行全部"
SMOKE_SWITCH_PARAM = "冒烟开关"
INSTANCE_SUFFIXES = "甲乙丙丁戊己庚辛壬癸"

# 参数默认值（基础类型）。注意: 火山里没有名为「字节集」的类型, 正式类型名是「字节集类」。
BASIC_DEFAULTS = {
    "小数": "0.0",
    "整数": "0",
    "变整数": "0",
    "长整数": "0",
    "短整数": "0",
    "字节": "0",
    "逻辑型": "假",
    "文本型": '""',
    "字节集类": "取空白字节集 (64)",
    "字节集": "取空白字节集 (64)",
}

CTOR_PREFIX = "新建"
LIFECYCLE_METHODS = {"类_初始化", "类_清理"}

# 映射未标 静态 但整类都是静态方法的类（仅 wsv 不存在时兜底）
STATIC_ONLY_CLASS_FALLBACK = {"Skia全局", "Skia颜色", "Skia路径运算"}


# ---------------------------------------------------------------- 数据模型
class Param:
    __slots__ = ("name", "type")

    def __init__(self, name, type_):
        self.name = name
        self.type = type_

    def __repr__(self):
        return f"{self.name}:{self.type}"


class Method:
    __slots__ = ("native", "cls", "name", "params", "ret", "comment",
                 "static", "prop_read", "lineno")

    def __init__(self, native, cls, name, params, ret, comment, static,
                 prop_read=False, lineno=0):
        self.native = native
        self.cls = cls
        self.name = name
        self.params = params
        self.ret = ret
        self.comment = comment
        self.static = static
        self.prop_read = prop_read
        self.lineno = lineno

    def __repr__(self):
        return (f"{self.cls}.{self.name}({self.params}) -> {self.ret}"
                f"{' [静态]' if self.static else ''}"
                f"{' [属性读]' if self.prop_read else ''}")


# ---------------------------------------------------------------- 解析：值类清单
def parse_value_classes(path):
    names = set()
    row = re.compile(r"^\|\s*`?[a-zA-Z0-9_]+`?\s*\|\s*(Skia[^|]+?)\s*\|")
    with open(path, "r", encoding="utf-8") as fp:
        for line in fp:
            m = row.match(line.strip())
            if not m:
                continue
            name = m.group(1).strip()
            if not name or "不封装" in name:
                continue
            names.add(name)
    return names


# ---------------------------------------------------------------- 解析：Skia核心.wsv
WSV_CLASS_RE = re.compile(r"^类\s+(?P<name>[^(<>\s]+)\s*<")
WSV_METHOD_RE = re.compile(r"^\s*方法\s+(?P<name>[^(<>]+?)\s*<(?P<attrs>[^>]*)>")
WSV_PARAM_RE = re.compile(r"^\s*参数\s+(?P<name>[^<>]+?)\s*<(?P<attrs>[^>]*)>")
TYPE_ATTR_RE = re.compile(r"类型\s*=\s*([^\s>]+)")
VGRP_FILE_RE = re.compile(r'^\s*name\s*=\s*"([^"]+\.wsv)"')


def parse_vgrp_files(path):
    """从 skia.vgrp 读取模块真正包含的 .wsv 清单（模块拆分后必须以此为准）。"""
    if not os.path.isfile(path):
        return []
    files = []
    in_file_block = False
    with open(path, "r", encoding="utf-8") as fp:
        for raw in fp:
            line = raw.rstrip("\n").rstrip("\r")
            if line.strip() == "file":
                in_file_block = True
                continue
            if in_file_block:
                if line.strip().startswith("}"):
                    break
                m = VGRP_FILE_RE.match(line)
                if m:
                    files.append(m.group(1))
    return files


def module_wsv_paths():
    """模块内全部 .wsv 的绝对路径（清单来自 skia.vgrp）。"""
    files = parse_vgrp_files(VGRP)
    if not files:
        files = sorted(f for f in os.listdir(ROOT)
                       if f.endswith(".wsv") and f != os.path.basename(OUT_WSV))
    return [os.path.join(ROOT, n) for n in files]


def parse_all_wsv():
    """解析模块内全部 .wsv，合并成 {类名: [Method]}。返回 (classes, 每文件统计)。"""
    files = parse_vgrp_files(VGRP)
    if not files:
        # 兜底：工程根下所有 wsv（排除桩本身）
        files = sorted(f for f in os.listdir(ROOT)
                       if f.endswith(".wsv") and f != os.path.basename(OUT_WSV))

    merged = {}
    per_file = []
    for name in files:
        path = os.path.join(ROOT, name)
        if not os.path.isfile(path):
            per_file.append((name, 0, 0, "缺失"))
            continue
        part = parse_core_wsv(path)
        n_cls, n_m = len(part), sum(len(v) for v in part.values())
        per_file.append((name, n_cls, n_m, "ok"))
        for cls, ms in part.items():
            merged.setdefault(cls, [])
            existing = {m.name for m in merged[cls]}
            for m in ms:
                if m.name not in existing:
                    merged[cls].append(m)
    return merged, per_file


# ---------------------------------------------------------------- 交付自检
def _comment_broken_by_quote(line):
    """`注释 = "..."` 的值被英文双引号劈开时返回真。

    实测后果（已用探针验证）：整个 .wsv 被**静默丢弃** —— 模块文件本身 0 报错，
    只有调用方报「没有找到所指定名称的类」。`Skia流.wsv` 就因为一句
    `写成 "-42"` 让 8 个类 75 个方法全部消失。
    判定方法：注释值收尾之后，行内剩余部分必须只有合法属性（`名 = "值"` 或裸关键词）
    与结束符 `>`；出现游离的 `"` 或其他字符即判为被劈开。
    """
    m = re.search(r'注释\s*=\s*"', line)
    if not m:
        return False
    end = line.find('"', m.end())
    if end < 0:                      # 注释值跨行，本行内无法判定
        return False
    tail = line[end + 1:].strip()
    if not tail:
        return False
    ok = re.fullmatch(r'(?:[^\s="]+(?:\s*=\s*"[^"]*")?|\s)*>?\s*', tail)
    return ok is None


def scan_broken_comments(paths):
    hits = []
    for path in paths:
        try:
            with open(path, "r", encoding="utf-8") as fp:
                for idx, line in enumerate(fp, 1):
                    if _comment_broken_by_quote(line.rstrip("\r\n")):
                        hits.append(f"{os.path.basename(path)}:{idx}")
        except OSError:
            continue
    return hits


def attr_flags(attrs):
    """从 `<...>` 属性区里判定 静态 / 属性读 / 嵌入式方法。

    ⚠️ 不能对整段做 `in` 判断：`注释 = "..."` 的正文里也会出现「静态」「属性读」
    （例如注释写「静态图为 1」「避免与同类属性读方法重名」），会把普通方法误判成
    静态调用 / 属性读调用，编译时报「未找到 XXX」。
    正确做法：先把所有带引号的值内容挖空，再判关键词。
    """
    cleaned = re.sub(r'"[^"]*"', '""', attrs)   # 挖掉属性值正文（注释/空串等）
    return {
        "static": "静态" in cleaned,
        "prop_read": "属性读" in cleaned,
        "embedded": "嵌入式方法" in cleaned,
    }


def parse_structure(paths):
    """解析出「类 -> 变量表 / 方法体」，专供交付自检用（不参与代码生成）。

    返回 {类名: {'vars': {名: 类型},
                 'methods': {名: {'params': [(名, 类型)], 'body': [语句行],
                                  'static': bool, 'prop_read': bool}}}}
    """
    result = {}
    for path in paths:
        cur_cls = None
        cur_m = None
        depth = 0
        with open(path, "r", encoding="utf-8") as fp:
            for raw in fp:
                line = raw.rstrip("\r").rstrip("\n")
                s = line.strip()

                m = WSV_CLASS_RE.match(line)
                if m:
                    cur_cls = m.group("name")
                    result.setdefault(cur_cls, {"vars": {}, "methods": {}, "base": None})
                    bm = re.search(r"基础类\s*=\s*([^\s>]+)", line)
                    if bm:
                        result[cur_cls]["base"] = bm.group(1)
                    cur_m = None
                    continue
                if cur_cls is None:
                    continue

                if s.startswith("变量 "):
                    mm = re.match(r"变量\s+(\S+)\s*<([^>]*)>", s)
                    if mm:
                        tm = TYPE_ATTR_RE.search(mm.group(2))
                        result[cur_cls]["vars"][mm.group(1)] = tm.group(1) if tm else "?"
                    continue

                mm = WSV_METHOD_RE.match(line)
                if mm:
                    attrs = mm.group("attrs")
                    rm = TYPE_ATTR_RE.search(attrs)
                    flags = attr_flags(attrs)
                    info = {"params": [], "body": None, "_depth": None,
                            "static": flags["static"],
                            "prop_read": flags["prop_read"],
                            "embedded": flags["embedded"],
                            "ret": rm.group(1) if rm else None,
                            "file": os.path.basename(path), "line": None}
                    result[cur_cls]["methods"][mm.group("name").strip()] = info
                    cur_m = info
                    continue

                if s.startswith("参数 ") and cur_m is not None:
                    pm = WSV_PARAM_RE.match(line)
                    if pm:
                        tm = TYPE_ATTR_RE.search(pm.group("attrs"))
                        cur_m["params"].append((pm.group(1).strip(),
                                                tm.group(1) if tm else "?"))
                    continue

                if s == "{":
                    depth += 1
                    if cur_m is not None and cur_m["body"] is None:
                        cur_m["body"] = []
                        cur_m["_depth"] = depth
                    continue

                if s == "}":
                    if cur_m is not None and cur_m.get("_depth") == depth:
                        cur_m = None
                    depth -= 1
                    continue

                if cur_m is not None and cur_m["body"] is not None and s:
                    cur_m["body"].append(s)
    return result


HANDLE_PTR_FIELD = "对象指针"
# 句柄类认可的「释放入口」名。Skia 的 wstream 家族原生没有 destroy，用 关闭 销毁。
TEARDOWN_NAMES = ("释放", "关闭", "销毁")


def run_self_checks(structure, value_classes):
    """交付自检。返回 (violations, warnings)。

    violations —— 不合格，必须修（会让 gen_smoke 退出码非 0）
      1) 句柄类缺 `释放` 方法
      2) 句柄类的 `类_清理` 不是空实现（值语义下会重复释放原生句柄）
      3) 句柄类 `释放` 不可重复调用（没有「句柄为 0 时直接返回」的守卫）

    warnings —— 能编过但极易静默出错，必须人看一眼
      1) 参数名与同类方法名重名（`@<上>` 会解析成方法而不是参数）
      2) 参数名与同类变量名重名
    """
    violations, warnings = [], []

    # --- 注释被英文双引号劈开（会让整个 wsv 静默消失）
    for loc in scan_broken_comments(module_wsv_paths()):
        violations.append(
            f"{loc}: `注释` 正文里出现英文双引号 —— 整个 .wsv 会被**静默丢弃**"
            f"（模块 0 报错, 只有调用方报「未找到类」）。改用中文引号或去掉引号")

    for cls, info in structure.items():
        methods = info["methods"]
        is_handle = HANDLE_PTR_FIELD in info["vars"]

        # --- 非嵌入式方法却写了单行 `@` 体（漏 `折叠 @嵌入式方法 = ""`）
        # 火山不会把这一行当成返回值，有返回值的方法会直接报「需要返回值但未返回」。
        for mname, m in methods.items():
            if m["embedded"]:
                continue
            body = [ln for ln in (m["body"] or []) if ln and not ln.startswith("//")]
            if len(body) == 1 and body[0].startswith("@"):
                msg = (f"{cls}.{mname}: 单行 `@` 体但没有 `折叠 @嵌入式方法 = \"\"`"
                       f" —— `@` 行不会作为返回值")
                if m["ret"]:
                    violations.append(msg + f"，会报「需要返回值但未返回」（返回类型 {m['ret']}）")
                else:
                    warnings.append(msg + "，无返回值时该行可能被忽略")

        # --- 参数名与同类方法名/变量名重名（对所有类都查, 值类最容易踩）
        for mname, minfo in methods.items():
            for pname, ptype in minfo["params"]:
                if pname in methods and pname != mname:
                    kind = "属性读方法" if methods[pname]["prop_read"] else "方法"
                    warnings.append(
                        f"{cls}.{mname}: 参数名 `{pname}` 与同类{kind} `{pname}` 重名"
                        f" —— 嵌入行里的 @<{pname}> 可能解析成{kind}而不是参数，会静默读回错值")
                elif pname in info["vars"]:
                    warnings.append(
                        f"{cls}.{mname}: 参数名 `{pname}` 与同类变量 `{pname}` 重名"
                        f" —— 嵌入行里的 @<{pname}> 可能解析成变量而不是参数")

        if not is_handle:
            continue

        teardown = next((t for t in TEARDOWN_NAMES if t in methods), None)
        base_classes = {i.get("base") for i in structure.values() if i.get("base")}

        if teardown is None:
            # 无释放入口：能不能被实例化决定性质
            has_ctor = any(m["static"] and m["ret"] == cls and n.startswith(CTOR_PREFIX)
                           for n, m in methods.items())
            if not has_ctor:
                warnings.append(
                    f"{cls}: 句柄类没有释放入口, 但也没有构造入口（只能作为借用参数）"
                    f" —— 确认它确实不可被实例化, 否则持有者无法释放")
            elif cls in base_classes:
                warnings.append(
                    f"{cls}: 句柄基类没有释放入口（派生类负责销毁）。"
                    f"确认它不可被直接实例化, 且借用时不会泄漏")
            else:
                violations.append(
                    f"{cls}: 句柄类有构造入口但没有释放入口（需 `释放` 或 `关闭`），必然泄漏")
            continue

        # --- 释放必须可重复调用：body 里要出现「对象指针 == 0」这类守卫
        rel_body = methods[teardown]["body"] or []
        rel_text = "\n".join(rel_body)
        if HANDLE_PTR_FIELD not in rel_text:
            violations.append(
                f"{cls}.{teardown}: 没有先判断 `{HANDLE_PTR_FIELD} == 0` 就返回，重复调用会重复释放")

        # --- 类_清理 必须存在且为空
        cleanup = methods.get("类_清理")
        if cleanup is None:
            violations.append(f"{cls}: 句柄类缺少 `类_清理`（必须存在且为空实现）")
        else:
            stmts = [ln for ln in (cleanup["body"] or [])
                     if ln and not ln.startswith("//")]
            if stmts:
                violations.append(
                    f"{cls}.类_清理: 不是空实现（{len(stmts)} 条语句）。"
                    f"火山类按值复制会共享原生句柄，在 类_清理 里释放必然重复释放")

    return violations, warnings


def parse_core_wsv(path):
    """返回 {类名: [MethodInfo, ...]}。"""
    classes = {}
    if not os.path.isfile(path):
        return classes

    cur_cls = None
    pending = None

    with open(path, "r", encoding="utf-8") as fp:
        for lineno, raw in enumerate(fp, 1):
            line = raw.rstrip("\n").rstrip("\r")
            stripped = line.strip()

            m = WSV_CLASS_RE.match(line)
            if m:
                cur_cls = m.group("name")
                classes.setdefault(cur_cls, [])
                pending = None
                continue

            if stripped.startswith("方法 ") or stripped.startswith("方法\t"):
                m = WSV_METHOD_RE.match(line)
                if m and cur_cls:
                    attrs = m.group("attrs")
                    name = m.group("name").strip()
                    tm = TYPE_ATTR_RE.search(attrs)
                    ret = tm.group(1) if tm else None
                    mi = Method(None, cur_cls, name, [], ret, "",
                                static=attr_flags(attrs)["static"],
                                prop_read=attr_flags(attrs)["prop_read"],
                                lineno=lineno)
                    classes[cur_cls].append(mi)
                    pending = mi
                else:
                    pending = None
                continue

            if stripped.startswith("参数 ") and pending is not None:
                m = WSV_PARAM_RE.match(line)
                if m:
                    tm = TYPE_ATTR_RE.search(m.group("attrs"))
                    pending.params.append(
                        Param(m.group("name").strip(), tm.group(1) if tm else "整数"))
                continue

            if stripped == "{" or stripped == "}" or stripped == "}":
                pending = None
    return classes


# ---------------------------------------------------------------- 解析：命名映射
SECTION_RE = re.compile(r"^##\s+(?P<num>[\d.]+)\s+(?P<title>\S+)")
MAPLINE_RE = re.compile(r"^sk_[A-Za-z0-9_]+\s*→")


def parse_params(text):
    params = []
    for chunk in text.strip().split(","):
        chunk = chunk.strip()
        if not chunk:
            continue
        if ":" in chunk:
            pname, ptype = chunk.split(":", 1)
            params.append(Param(pname.strip(), ptype.strip()))
        else:
            params.append(Param(chunk, "整数"))
    return params


def clean_section_title(title):
    return re.split(r"[（(]", title)[0].strip()


RE_PATCH_ROW = re.compile(r"^\|\s*\d+\s*\|\s*`(sk_[a-z0-9_]+)`\s*\|\s*(批次[1-4])\s*\|")


def parse_patch_batch_map(path):
    """从补丁文档「总览」表里取 {原生函数: 批次N}。

    补丁是批次1~3 的勘误补项，统计时必须**并回对应批次**，
    否则「批次2 完成 214/214」会被误读成已完成，而实际应为 226。
    """
    mp = {}
    try:
        with open(path, "r", encoding="utf-8") as fp:
            for line in fp:
                m = RE_PATCH_ROW.match(line.strip())
                if m:
                    mp[m.group(1)] = m.group(2)
    except OSError:
        pass
    return mp


def parse_mapping(path):
    methods = []
    skipped = []
    cur_cls = None
    cur_all_static = False
    in_code = False

    with open(path, "r", encoding="utf-8") as fp:
        lines = fp.readlines()

    for lineno, raw in enumerate(lines, 1):
        line = raw.rstrip("\n").rstrip("\r")

        if line.startswith("## "):
            m = SECTION_RE.match(line)
            if m:
                cur_cls = clean_section_title(m.group("title"))
                cur_all_static = "全静态" in line
            continue

        if line.startswith("```"):
            in_code = not in_code
            continue
        if not in_code or not MAPLINE_RE.match(line):
            continue

        if "✗" in line:
            skipped.append((lineno, line, "含 ✗ 标记"))
            continue
        if "（无原生对应）" in line or "(无原生对应)" in line:
            skipped.append((lineno, line, "无原生对应"))
            continue

        body, comment = line, ""
        if " | " in line:
            body, comment = line.split(" | ", 1)
        body = body.strip()
        if "→" not in body:
            skipped.append((lineno, line, "缺少 → 分隔"))
            continue

        native, rest = body.split("→", 1)
        native, rest = native.strip(), rest.strip()
        ret = None
        if "→" in rest:
            rest, ret = rest.split("→", 1)
            rest, ret = rest.strip(), ret.strip()
        if ret:
            toks = ret.split()
            ret = toks[0] if toks else ret

        m = re.match(r"^(?:(?P<cls>[^.()（）]+?)\.)?(?P<name>[^()（）]+?)"
                     r"\((?P<params>[^()（）]*)\)$", rest.strip())
        if not m:
            skipped.append((lineno, line, f"签名无法解析: {rest!r}"))
            continue

        explicit = m.group("cls")
        cls = explicit.strip() if explicit else cur_cls
        if not cls:
            skipped.append((lineno, line, "无法确定所属类"))
            continue

        methods.append(Method(native, cls, m.group("name").strip(),
                              parse_params(m.group("params")), ret, comment,
                              cur_all_static or comment.strip().startswith("静态"),
                              lineno=lineno))
    return methods, skipped


# ---------------------------------------------------------------- 实例规划
def pick_ctor(cls_methods, available):
    """挑构造入口：优先「参数全部可得」，其次「不可得参数最少」，再其次参数最少。"""
    best, best_key = None, None
    for m in cls_methods:
        if not m.static or not m.name.startswith(CTOR_PREFIX) or m.ret != m.cls:
            continue
        unavail = sum(1 for p in m.params
                      if p.type not in BASIC_DEFAULTS and p.type not in available)
        key = (unavail, len(m.params), m.name)
        if best_key is None or key < best_key:
            best, best_key = m, key
    return best


def plan_instances(classes, value_classes):
    param_types = set()
    for ms in classes.values():
        for m in ms:
            for p in m.params:
                if p.type not in BASIC_DEFAULTS:
                    param_types.add(p.type)

    need = {c for c, ms in classes.items()
            if any(not m.static for m in ms)}
    need |= param_types
    handle_cls = {c for c in need if c not in value_classes}

    counts = {c: 1 for c in need}
    for ms in classes.values():
        for m in ms:
            per_call = {}
            for p in m.params:
                if p.type in BASIC_DEFAULTS:
                    continue
                per_call[p.type] = per_call.get(p.type, 0) + 1
            for t, n in per_call.items():
                counts[t] = max(counts.get(t, 1), n)

    ctors = {c: (None if c in value_classes else None) for c in need}

    # 第一轮：参数全部可得的构造
    built = set()
    for _ in range(len(need) + 2):
        available = set(built) | {c for c in need if c in value_classes}
        changed = False
        for c in need:
            if c in value_classes or c in built:
                continue
            ctor = pick_ctor(classes.get(c, []), available)
            if ctor and all(p.type in BASIC_DEFAULTS or p.type in available
                            for p in ctor.params):
                ctors[c] = ctor
                built.add(c)
                changed = True
        if not changed:
            break

    # 第二轮：剩下的一律取参数最少的构造（会借用空对象）
    for c in need:
        if c in value_classes:
            continue
        if ctors.get(c) is None:
            ctors[c] = pick_ctor(classes.get(c, []), set())

    return counts, ctors, handle_cls


def sort_by_dependency(classes_, ctors):
    order, state = [], {}

    def visit(c):
        if state.get(c, 0) in (1, 2):
            return
        state[c] = 1
        ctor = ctors.get(c)
        if ctor is not None:
            for p in ctor.params:
                if p.type in ctors and p.type != c:
                    visit(p.type)
        state[c] = 2
        order.append(c)

    for c in classes_:
        visit(c)
    return order


# ---------------------------------------------------------------- 名称工具
def inst_base(cls):
    return cls[4:] if cls.startswith("Skia") and len(cls) > 4 else cls


def inst_name(cls, idx):
    if idx < len(INSTANCE_SUFFIXES):
        return inst_base(cls) + INSTANCE_SUFFIXES[idx]
    return f"{inst_base(cls)}{idx + 1}"


def temp_name(type_name):
    return "属性" + inst_base(type_name) if type_name.startswith("Skia") else "属性" + type_name


# ---------------------------------------------------------------- 生成
def gen_wsv(classes, value_classes, counts, ctors, handle_cls):
    lines = []
    stats = {
        "calls": 0,
        "prop_calls": 0,
        "lifecycle_skipped": [],
        "empty_types": [],
        "ctor_missing": [],
        "ctor_with_empty": [],
        "instantiated": [],
        "released": [],
        "prop_skipped": [],
    }

    need_vars = sorted(counts.keys())
    prop_types = sorted({m.ret for ms in classes.values() for m in ms
                         if m.prop_read and m.ret and m.ret in BASIC_DEFAULTS})

    lines.append('<火山程序 类型 = "通常" 版本 = 1 />')
    lines.append("")
    lines.append(f'包 {PACKAGE} <注释 = "编译期冒烟闸门（自动生成，请勿手改）。'
                 f'生成器 tools/gen_smoke.py，数据源 Skia核心.wsv + docs/命名映射-批次1.md。">')
    lines.append("")
    lines.append(f'类 {SMOKE_CLASS} <公开 注释 = "编译期冒烟闸门: 覆盖全部公开方法, '
                 f'只在 {SMOKE_SWITCH_PARAM}=1 时执行。正常程序不会进入本方法, '
                 f'唯一目的是让全部方法体进入 C++ 编译。">')
    lines.append("{")
    lines.append(f'    方法 {SMOKE_METHOD} <公开 静态 注释 = "调用每个公开方法一次; '
                 f'用于强制编译检查, 正常不执行。">')
    lines.append(f'    参数 {SMOKE_SWITCH_PARAM} <类型 = 整数 @默认值 = 0>')
    lines.append("    {")

    for cls in need_vars:
        for i in range(counts[cls]):
            lines.append(f"        变量 {inst_name(cls, i)} <类型 = {cls}>")
    for t in prop_types:
        lines.append(f"        变量 {temp_name(t)} <类型 = {t}>")
    lines.append("")

    lines.append(f"        如果 ({SMOKE_SWITCH_PARAM} != 1)")
    lines.append("        {")
    lines.append("            返回")
    lines.append("        }")
    lines.append("")

    # ---- 建实例
    created = set()
    for cls in sort_by_dependency(need_vars, ctors):
        ctor = ctors.get(cls)
        if ctor is None:
            continue
        used_empty = []
        for i in range(counts[cls]):
            args = []
            for p in ctor.params:
                if p.type in BASIC_DEFAULTS:
                    args.append(BASIC_DEFAULTS[p.type])
                elif p.type in value_classes or p.type in created:
                    args.append(inst_name(p.type, 0))
                else:
                    args.append(inst_name(p.type, 0))
                    used_empty.append(p.type)
            lines.append(f"        {inst_name(cls, i)} = {cls}.{ctor.name} ({', '.join(args)})")
        created.add(cls)
        stats["instantiated"].append(cls)
        if used_empty:
            uniq = sorted(set(used_empty))
            stats["ctor_with_empty"].append(f"{cls}.{ctor.name} 借用空对象: {', '.join(uniq)}")
            lines.append(f"        // 缺实例: {', '.join(uniq)}"
                         f" （{cls}.{ctor.name} 需要它, 当前 wsv 无构造入口, 传空对象）")

    for cls in need_vars:
        if cls in handle_cls and cls not in created:
            stats["ctor_missing"].append(cls)
            stats["empty_types"].append(cls)

    if created:
        lines.append("")

    # ---- 逐类调用
    for cls in sorted(classes):
        seg = [f"        // === {cls} ({len(classes[cls])} 个方法) ==="]
        for m in classes[cls]:
            if m.name in LIFECYCLE_METHODS:
                stats["lifecycle_skipped"].append(f"{cls}.{m.name}")
                continue

            per_type_idx = {}
            args = []
            for p in m.params:
                if p.type in BASIC_DEFAULTS:
                    args.append(BASIC_DEFAULTS[p.type])
                    continue
                idx = per_type_idx.get(p.type, 0)
                per_type_idx[p.type] = idx + 1
                if idx >= counts.get(p.type, 1):
                    idx = 0
                args.append(inst_name(p.type, idx))
            argtext = ", ".join(args)

            if m.prop_read:
                if m.ret in BASIC_DEFAULTS:
                    src = (f"{m.cls}.{m.name}" if m.static else f"{inst_name(m.cls, 0)}.{m.name}")
                    seg.append(f"        {temp_name(m.ret)} = {src}")
                    stats["prop_calls"] += 1
                    if m.params:
                        stats["calls"] += 1
                else:
                    stats["prop_skipped"].append(f"{cls}.{m.name} (返回 {m.ret})")
                continue

            if m.static:
                call = f"{m.cls}.{m.name} ({argtext})" if argtext else f"{m.cls}.{m.name} ()"
            else:
                call = (f"{inst_name(m.cls, 0)}.{m.name} ({argtext})" if argtext
                        else f"{inst_name(m.cls, 0)}.{m.name} ()")
            seg.append(f"        {call}")
            stats["calls"] += 1
        seg.append("")
        lines.extend(seg)

    # ---- 释放
    rel = []
    for cls in need_vars:
        if cls in value_classes:
            continue
        if "释放" not in [m.name for m in classes.get(cls, [])]:
            continue
        rel.append(f"        // === 释放 {cls} ===")
        for i in range(counts[cls]):
            rel.append(f"        {inst_name(cls, i)}.释放 ()")
        stats["released"].append(cls)
    if rel:
        lines.extend(rel)

    lines.append("    }")
    lines.append("}")
    lines.append("")

    return "\r\n".join(lines), stats


# ---------------------------------------------------------------- 主流程
def main():
    mapping_paths = []
    for pattern in MAPPING_GLOBS:
        mapping_paths.extend(sorted(glob.glob(pattern)))
    if not mapping_paths:
        sys.stderr.write(f"找不到命名映射文件: {MAPPING_GLOBS}\n")
        return 2

    value_classes = parse_value_classes(VALUE_MD) if os.path.isfile(VALUE_MD) else set()

    # 逐批次解析：缺口必须按批次核对，否则「缺口 0」只对已落盘的那一批成立
    mapping_groups = []          # [(文件名, [Method], [跳过])]
    for path in mapping_paths:
        ms, sk = parse_mapping(path)
        mapping_groups.append((os.path.basename(path), ms, sk))
    mapping = [m for _, ms, _ in mapping_groups for m in ms]
    skipped = [s for _, _, sk in mapping_groups for s in sk]
    wsv_classes, per_file = parse_all_wsv()

    if wsv_classes:
        classes = wsv_classes
        mode = "wsv 权威（覆盖模块内全部 .wsv 的全部方法）"
        wsv_keys = {(c, m.name) for c, ms in wsv_classes.items() for m in ms}
        missing = [f"{m.cls}.{m.name} (映射 L{m.lineno}, {m.native})"
                   for m in mapping if (m.cls, m.name) not in wsv_keys]
        miss_by_cls = {}
        for t in missing:
            miss_by_cls.setdefault(t.split(".")[0], []).append(t)
    else:
        classes = {}
        for m in mapping:
            classes.setdefault(m.cls, []).append(m)
        for ms in classes.values():
            for m in ms:
                if not m.static and m.cls in STATIC_ONLY_CLASS_FALLBACK:
                    m.static = True
        mode = "映射回退（wsv 不存在）"
        missing, miss_by_cls = [], {}

    counts, ctors, handle_cls = plan_instances(classes, value_classes)
    text, stats = gen_wsv(classes, value_classes, counts, ctors, handle_cls)

    with open(OUT_WSV, "w", encoding="utf-8", newline="") as fp:
        fp.write(text)

    # ---- 交付自检（不合格项会阻止交付）
    structure = parse_structure(module_wsv_paths())
    violations, warnings = run_self_checks(structure, value_classes)

    total_methods = sum(len(v) for v in classes.values())
    print("=" * 72)
    print("Skia 冒烟桩生成结果")
    print("=" * 72)
    print(f"模式            : {mode}")
    print(f"模块定义        : {VGRP}")
    print(f"输出文件        : {OUT_WSV}")
    print(f"值类数量        : {len(value_classes)}")
    print("模块源文件:")
    for name, n_cls, n_m, state in per_file:
        print(f"    {name:<20} {n_cls:>3} 个类  {n_m:>4} 个方法  [{state}]")
    print(f"类数量          : {len(classes)}")
    print(f"wsv 方法总数    : {total_methods}")
    print(f"生成普通调用    : {stats['calls']}")
    print(f"生成属性读调用  : {stats['prop_calls']}")
    print(f"跳过生命周期    : {len(stats['lifecycle_skipped'])} "
          f"({'/'.join(sorted(set(x.split('.')[-1] for x in stats['lifecycle_skipped'])))})"
          f"  —— 火山在对象构造/析构时自动调用, 无需显式调")
    print(f"跳过属性读      : {len(stats['prop_skipped'])}")
    print(f"需建实例类型数  : {len(counts)}  "
          f"(已建 {len(stats['instantiated'])} / 空对象 {len(stats['empty_types'])})")
    if wsv_classes:
        print(f"映射条数        : {len(mapping)} 条（跨 {len(mapping_groups)} 个批次文件）, "
              f"wsv 已实现 {len(mapping) - len(missing)} 条, 未实现 {len(missing)} 条")
        # ---- 双口径：按文件明细（可追溯） + 按批次合并补丁（看完成度）
        patch_map = {}
        file_batch = {}
        for fname, ms, _ in mapping_groups:
            if "补丁" in fname:
                for path in mapping_paths:
                    if os.path.basename(path) == fname:
                        patch_map = parse_patch_batch_map(path)
                        break
                for m in ms:
                    b = patch_map.get(m.native)
                    if b:
                        file_batch.setdefault(fname, set()).add(b)
            else:
                mm = re.search(r"批次(\d)", fname)
                if mm:
                    file_batch[fname] = {f"批次{mm.group(1)}"}

        # 按批次合并。**必须按 (类, 方法名) 去重**：
        # 架构师可能把补丁条目直接并进批次文档，此时补丁里的同名条目会重复计数。
        batch_total, batch_impl = {}, {}
        seen = set()
        dup = 0
        for fname, ms, _ in mapping_groups:
            batches = file_batch.get(fname, set())
            for m in ms:
                key = (m.cls, m.name)
                if key in seen:
                    dup += 1
                    continue
                seen.add(key)
                # 补丁条目按原生函数归属到具体批次；无归属的记到「补丁(未归属)」
                if "补丁" in fname:
                    b = patch_map.get(m.native, "补丁(未归属)")
                else:
                    b = next(iter(batches), "批次?")
                batch_total[b] = batch_total.get(b, 0) + 1
                if key in wsv_keys:
                    batch_impl[b] = batch_impl.get(b, 0) + 1
        if dup:
            print(f"    （合并时已去重 {dup} 条：补丁条目已并入对应批次文档）")

        print("按批次（补丁已并入对应批次）:")
        for b in sorted(batch_total):
            tot = batch_total[b]
            impl = batch_impl.get(b, 0)
            gap = tot - impl
            flag = "√ 完成" if gap == 0 else f"缺 {gap:>3} 条"
            print(f"    {b:<6} {tot:>4} 条   已实现 {impl:>4}   {flag}")
        t_all = sum(batch_total.values())
        i_all = sum(batch_impl.values())
        pct = (i_all * 100 // t_all) if t_all else 0
        print(f"    合计   {t_all:>4} 条   已实现 {i_all:>4}   （{pct}%）")

        print("按文件（逐份可核）:")
        for fname, ms, _ in mapping_groups:
            impl = sum(1 for m in ms if (m.cls, m.name) in wsv_keys)
            gap = len(ms) - impl
            flag = "√ 完成" if gap == 0 else f"缺 {gap:>3} 条"
            print(f"    {fname:<24} {len(ms):>4} 条   已实现 {impl:>4}   {flag}")

        # 区分「映射对应方法」与「辅助方法」，避免「实现数 > 映射数」被误读
        # 用「去重后的已实现条数」，不能用 len(mapping)（含补丁重复项）
        mapped_impl = sum(batch_impl.values())
        helper_n = total_methods - mapped_impl
        print(f"方法构成           : 映射对应 {mapped_impl} 个  +  辅助方法 {helper_n} 个"
              f"（值类 置左/取地址、新建_完整 这类纯火山便利方法）= {total_methods}")
    print()

    print("逐类覆盖:")
    for cls in sorted(classes, key=lambda c: (-len(classes[c]), c)):
        static_n = sum(1 for m in classes[cls] if m.static)
        prop_n = sum(1 for m in classes[cls] if m.prop_read)
        print(f"    {cls:<14} {len(classes[cls]):>3} 个  "
              f"(静态 {static_n:>2} / 属性读 {prop_n:>2} / 实例 {len(classes[cls]) - static_n - prop_n:>2})  "
              f"实例×{counts.get(cls, 0)}  构造="
              f"{('.' + ctors[cls].name) if ctors.get(cls) else '（无/值类）'}")
    print()

    if stats["ctor_missing"]:
        print(f"无构造入口、只能以空对象出现 {len(stats['ctor_missing'])} 个:")
        for t in stats["ctor_missing"]:
            print(f"    {t}")
        print()

    if stats["ctor_with_empty"]:
        print(f"构造时借用空对象参数 {len(stats['ctor_with_empty'])} 处（编译可过, 运行不可）:")
        for t in stats["ctor_with_empty"]:
            print(f"    {t}")
        print()

    if stats["prop_skipped"]:
        print(f"属性读返回非基础类型、未覆盖 {len(stats['prop_skipped'])} 条:")
        for t in stats["prop_skipped"]:
            print(f"    {t}")
        print()

    if missing:
        print(f"映射里有、wsv 里还没有 {len(missing)} 条，按类汇总:")
        for cls in sorted(miss_by_cls, key=lambda c: (-len(miss_by_cls[c]), c)):
            print(f"    {cls:<14} 缺 {len(miss_by_cls[cls]):>3} 条")
        show = missing[:40]
        print(f"    明细（前 {len(show)} 条，共 {len(missing)} 条）:")
        for t in show:
            print(f"        {t}")
        if len(missing) > len(show):
            print(f"        ... 另有 {len(missing) - len(show)} 条，见 docs\\命名映射-批次*.md")
        print()

    # ---- 交付自检结果
    print("=" * 72)
    print("交付自检（所有权约定 + 命名陷阱）")
    print("=" * 72)
    handle_n = sum(1 for info in structure.values() if HANDLE_PTR_FIELD in info["vars"])
    print(f"句柄类数量      : {handle_n}   "
          f"(检查项: 有 释放 / 释放可重复调用 / 类_清理 空实现)")
    if violations:
        print(f"✗ 不合格 {len(violations)} 项:")
        for v in violations:
            print(f"    {v}")
    else:
        print("√ 全部句柄类符合所有权约定（释放可重复调用 + 类_清理 空实现）")
    if warnings:
        print(f"⚠ 命名警告 {len(warnings)} 项（能编过但可能静默读回错值）:")
        for w in warnings:
            print(f"    {w}")
    print()

    print("写入编码: UTF-8 无 BOM, CRLF")
    if violations:
        print(f"生成器退出码 1：有 {len(violations)} 项交付不合格项，未通过自检。")
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
