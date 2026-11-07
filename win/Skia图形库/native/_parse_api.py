import os, re, json

SRC = r"E:\AI开发\Skia工具\deps\skia\include\c"
OUT = r"E:\AI开发\Skia工具\native\skia_api.json"
EXPORTS = r"C:\Users\bmy\AppData\Local\Temp\skia_all_fns.txt"

exports = set(open(EXPORTS, encoding="utf-8").read().split())

def strip_comments(s):
    s = re.sub(r"/\*.*?\*/", " ", s, flags=re.S)
    s = re.sub(r"//[^\n]*", " ", s)
    return s

funcs = []
enums = {}
structs = {}

for name in sorted(os.listdir(SRC)):
    if not name.endswith(".h"):
        continue
    text = strip_comments(open(os.path.join(SRC, name), encoding="utf-8", errors="replace").read())

    # 收集 typedef enum
    for m in re.finditer(r"typedef\s+enum\s*\{(.*?)\}\s*(\w+)\s*;", text, re.S):
        body, tname = m.group(1), m.group(2)
        items = []
        for part in body.split(","):
            part = part.strip()
            if not part:
                continue
            if "=" in part:
                n, v = part.split("=", 1)
                items.append([n.strip(), v.strip()])
            else:
                items.append([part, None])
        enums[tname] = items

    # 收集 typedef struct
    for m in re.finditer(r"typedef\s+struct\s*\{(.*?)\}\s*(\w+)\s*;", text, re.S):
        body, tname = m.group(1), m.group(2)
        fields = []
        for part in body.split(";"):
            part = part.strip()
            if not part:
                continue
            mm = re.match(r"(.+?)\s+(\w+)\s*(\[[^\]]*\])?$", part)
            if mm:
                fields.append([mm.group(1).strip(), mm.group(2)])
        structs[tname] = fields

    # 收集函数声明（允许跨行）
    for m in re.finditer(r"SK_C_API\s+([A-Za-z_][\w\s\*]*?)\s+(sk_\w+)\s*\((.*?)\)\s*;", text, re.S):
        ret = " ".join(m.group(1).split())
        fname = m.group(2)
        raw_params = " ".join(m.group(3).split())
        params = []
        if raw_params and raw_params != "void":
            # 按逗号切分（函数指针参数极少，这里按简单规则处理）
            depth = 0
            cur = ""
            for ch in raw_params:
                if ch == "(":
                    depth += 1
                if ch == ")":
                    depth -= 1
                if ch == "," and depth == 0:
                    params.append(cur.strip())
                    cur = ""
                else:
                    cur += ch
            if cur.strip():
                params.append(cur.strip())
        funcs.append({
            "name": fname,
            "ret": ret,
            "params": params,
            "header": name,
            "exported": fname in exports,
        })

exported_names = {f["name"] for f in funcs if f["exported"]}
missing_decl = sorted(exports - exported_names - {""})

data = {
    "count_declared": len(funcs),
    "count_exported_declared": len(exported_names),
    "count_exported_total": len(exports),
    "exported_without_decl": missing_decl,
    "enums": enums,
    "structs": structs,
    "funcs": funcs,
}
json.dump(data, open(OUT, "w", encoding="utf-8"), ensure_ascii=False, indent=1)

print("声明函数数:", len(funcs))
print("已导出且已声明:", len(exported_names))
print("导出总数:", len(exports))
print("导出但无声明:", len(missing_decl))
print("枚举数:", len(enums), "结构数:", len(structs))
print("无声明样例:", missing_decl[:12])
