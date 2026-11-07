const fs = require("fs");
const Konva = require("../assets/konva.js");
const corePrelude = fs.readFileSync("tools/konva_core_prelude.wsvinc", "utf8").trimEnd();

const classNames = [
  "Transform",
  "Context",
  "Canvas",
  "Node",
  "Container",
  "Stage",
  "Shape",
  "Layer",
  "FastLayer",
  "Group",
  "Animation",
  "Tween",
  "Arc",
  "Line",
  "Path",
  "Arrow",
  "Circle",
  "Ellipse",
  "Image",
  "Label",
  "Tag",
  "Rect",
  "RegularPolygon",
  "Ring",
  "Sprite",
  "Star",
  "Text",
  "TextPath",
  "Transformer",
  "Wedge",
];

const nodeClasses = new Set(
  classNames.filter((name) => {
    const Klass = Konva[name];
    return Boolean(Klass && Klass.prototype && (Klass.prototype instanceof Konva.Node || name === "Node"));
  })
);

const specialIds = {
  Stage: "$stage",
  Layer: "$layer",
  FastLayer: "$layer",
  Transformer: "$transformer",
};

const classZh = {
  Transform: "变换",
  Context: "绘图上下文",
  Canvas: "画布",
  Node: "节点",
  Container: "容器",
  Stage: "舞台",
  Shape: "图形",
  Layer: "图层",
  FastLayer: "快速图层",
  Group: "分组",
  Animation: "动画",
  Tween: "补间动画",
  Arc: "弧形",
  Line: "线条",
  Path: "路径",
  Arrow: "箭头",
  Circle: "圆形",
  Ellipse: "椭圆",
  Image: "图像",
  Label: "标签组",
  Tag: "标签背景",
  Rect: "矩形",
  RegularPolygon: "正多边形",
  Ring: "圆环",
  Sprite: "精灵",
  Star: "星形",
  Text: "文本",
  TextPath: "路径文本",
  Transformer: "变换器",
  Wedge: "扇形",
};

const methodZh = {
  add: "添加",
  addEventListener: "添加事件监听",
  addLayer: "添加图层",
  attach: "附加",
  attachTo: "附加到",
  beginPath: "开始路径",
  cache: "缓存",
  clear: "清除",
  clearCache: "清除缓存",
  clearRect: "清除矩形区",
  clearTrace: "清除跟踪",
  clip: "裁剪",
  clone: "克隆",
  closePath: "闭合路径",
  copy: "复制",
  copyInto: "复制到",
  createImageData: "创建图像数据",
  createLinearGradient: "创建线性渐变",
  createPNGStream: "创建PNG流",
  createPattern: "创建图案",
  createRadialGradient: "创建径向渐变",
  destroy: "销毁",
  destroyChildren: "销毁子节点",
  disableHitGraph: "禁用命中图",
  dispatchEvent: "派发事件",
  draw: "绘制",
  drawHit: "绘制命中",
  drawHitFromCache: "从缓存绘制命中",
  drawImage: "绘制图像",
  drawScene: "绘制场景",
  enableHitGraph: "启用命中图",
  fill: "填充",
  fillRect: "填充矩形",
  fillShape: "填充图形",
  fillStrokeShape: "填充并描边图形",
  fillText: "填充文本",
  find: "查找",
  findAncestor: "查找祖先",
  findAncestors: "查找全部祖先",
  findOne: "查找一个",
  finish: "完成",
  fire: "触发事件",
  getAllIntersections: "取全部交点",
  getCanvas: "取画布",
  getChildren: "取子节点",
  getClassName: "取类名",
  getClientRect: "取客户矩形",
  getContext: "取上下文",
  getDepth: "取深度",
  getHitCanvas: "取命中画布",
  getIntersection: "取交点",
  getLayer: "取图层",
  getParent: "取父节点",
  getStage: "取舞台",
  hasChildren: "是否有子节点",
  hide: "隐藏",
  isAncestorOf: "是否祖先",
  isCached: "是否已缓存",
  isDragging: "是否正在拖动",
  isRunning: "是否正在运行",
  isVisible: "是否可见",
  lineTo: "连线到",
  measureText: "测量文本",
  move: "移动",
  moveDown: "下移",
  moveTo: "移动到",
  moveToBottom: "移到底层",
  moveToTop: "移到顶层",
  moveUp: "上移",
  off: "取消监听",
  on: "监听",
  pause: "暂停",
  play: "播放",
  preventDefault: "阻止默认行为",
  remove: "移除",
  removeChildren: "移除子节点",
  removeEventListener: "移除事件监听",
  reset: "重置",
  reverse: "反向播放",
  save: "保存",
  seek: "跳转",
  setContainer: "置容器",
  setLineDash: "置线段虚线",
  show: "显示",
  start: "开始",
  stop: "停止",
  stroke: "描边",
  strokeShape: "描边图形",
  to: "转到",
  toBlob: "转Blob",
  toCanvas: "转画布",
  toDataURL: "转数据URL",
  toImage: "转图像",
  toJSON: "转JSON",
  toObject: "转对象",
  toggleHitCanvas: "切换命中画布",
};

const tokenZh = {
  absolute: "绝对",
  active: "活动",
  add: "添加",
  after: "后",
  align: "对齐",
  all: "全部",
  alpha: "透明通道",
  ancestor: "祖先",
  ancestors: "祖先集",
  anchor: "锚点",
  anchors: "锚点集",
  angle: "角度",
  animation: "动画",
  animations: "动画集",
  arc: "弧",
  area: "区域",
  array: "数组",
  attr: "属性",
  attrs: "属性集",
  baseline: "基线",
  batch: "批量",
  before: "前",
  begin: "开始",
  beginning: "起点",
  behavior: "行为",
  bezier: "贝塞尔",
  blend: "混合",
  blob: "Blob",
  blue: "蓝色",
  blur: "模糊",
  border: "边框",
  bottom: "底层",
  bound: "边界",
  box: "框",
  brightness: "亮度",
  cached: "已缓存",
  canvas: "画布",
  cap: "端点",
  capture: "捕获",
  centered: "居中",
  char: "字符",
  children: "子节点",
  class: "类",
  clear: "清除",
  client: "客户区",
  clip: "裁剪",
  clockwise: "顺时针",
  closed: "闭合",
  color: "颜色",
  composite: "合成",
  container: "容器",
  content: "内容",
  context: "上下文",
  contrast: "对比度",
  corner: "圆角",
  crop: "裁剪",
  cursor: "光标",
  dash: "虚线",
  data: "数据",
  decompose: "分解",
  decoration: "装饰",
  default: "默认",
  deg: "角度",
  depth: "深度",
  detach: "分离",
  direction: "方向",
  distance: "距离",
  drag: "拖动",
  draggable: "可拖动",
  dragging: "拖动中",
  draw: "绘制",
  element: "元素",
  ellipse: "椭圆",
  ellipsis: "省略",
  emboss: "浮雕",
  enable: "启用",
  enabled: "启用",
  end: "结束",
  ending: "终点",
  enhance: "增强",
  event: "事件",
  family: "族",
  fill: "填充",
  filters: "滤镜",
  flip: "翻转",
  font: "字体",
  force: "强制",
  frame: "帧",
  func: "函数",
  global: "全局",
  gradient: "渐变",
  graph: "图",
  green: "绿色",
  handler: "处理器",
  handlers: "处理器集",
  height: "高度",
  hit: "命中",
  hue: "色相",
  id: "标识",
  ignore: "忽略",
  image: "图像",
  in: "内",
  index: "索引",
  inner: "内",
  invert: "反转",
  intersection: "交点",
  intersections: "交点集",
  intersects: "相交",
  join: "连接",
  json: "JSON",
  kaleidoscope: "万花筒",
  keep: "保持",
  kerning: "字偶距",
  layer: "图层",
  layers: "图层集",
  length: "长度",
  letter: "字母",
  level: "级别",
  levels: "色阶",
  limit: "限制",
  line: "线条",
  linear: "线性",
  listening: "监听",
  luminance: "亮度",
  matrix: "矩阵",
  measure: "测量",
  miter: "斜接",
  multiply: "乘以",
  name: "名称",
  native: "原生",
  node: "节点",
  nodes: "节点集",
  noise: "噪声",
  num: "数量",
  object: "对象",
  off: "关闭",
  offset: "偏移",
  on: "开启",
  opacity: "透明度",
  operation: "操作",
  outer: "外",
  overdraw: "覆盖绘制",
  padding: "内边距",
  parent: "父节点",
  path: "路径",
  pattern: "图案",
  perfect: "完美",
  pixel: "像素",
  png: "PNG",
  point: "点",
  points: "点集",
  pointer: "指针",
  pointers: "指针集",
  position: "位置",
  positions: "位置集",
  power: "强度",
  priority: "优先级",
  put: "放入",
  quadratic: "二次",
  radial: "径向",
  radius: "半径",
  rate: "速率",
  ratio: "比例",
  rect: "矩形",
  red: "红色",
  release: "释放",
  remove: "移除",
  relative: "相对",
  render: "渲染",
  repeat: "重复",
  resize: "调整大小",
  restore: "恢复",
  rgb: "RGB",
  rgba: "RGBA",
  rotate: "旋转",
  rotation: "旋转",
  round: "圆形",
  rule: "规则",
  saturation: "饱和度",
  scale: "缩放",
  scaling: "缩放",
  scene: "场景",
  screen: "屏幕",
  self: "自身",
  shadow: "阴影",
  shape: "图形",
  shift: "Shift",
  should: "应当",
  sides: "边数",
  single: "单节点",
  size: "尺寸",
  skew: "倾斜",
  smoothing: "平滑",
  snap: "吸附",
  snaps: "吸附点",
  spacing: "间距",
  stage: "舞台",
  start: "起始",
  stop: "停止",
  stops: "停止点",
  strength: "强度",
  stroke: "描边",
  stream: "流",
  style: "样式",
  tag: "标签",
  tension: "张力",
  text: "文本",
  threshold: "阈值",
  to: "到",
  tolerance: "容差",
  top: "顶层",
  trace: "跟踪",
  transform: "变换",
  transforming: "变换中",
  transforms: "变换集",
  translate: "平移",
  translation: "平移",
  type: "类型",
  underline: "下划线",
  up: "上",
  update: "更新",
  url: "URL",
  use: "使用",
  value: "值",
  variant: "变体",
  vertical: "垂直",
  visible: "可见",
  white: "白色",
  whole: "整体",
  width: "宽度",
  wrap: "换行",
  x: "横坐标",
  y: "纵坐标",
  z: "层级",
};

function splitWords(name) {
  return name
    .replace(/([a-z0-9])([A-Z])/g, "$1 $2")
    .replace(/([A-Z]+)([A-Z][a-z])/g, "$1 $2")
    .split(/\s+/)
    .filter(Boolean)
    .map((word) => word.toLowerCase());
}

function phraseZh(name) {
  return splitWords(name)
    .map((word) => tokenZh[word] || `原${word}`)
    .join("");
}

function methodNameZh(name) {
  if (methodZh[name]) return methodZh[name];
  const getter = name.match(/^get([A-Z].*)$/);
  if (getter) return `取${phraseZh(getter[1])}`;
  const setter = name.match(/^set([A-Z].*)$/);
  if (setter) return `置${phraseZh(setter[1])}`;
  const haser = name.match(/^has([A-Z].*)$/);
  if (haser) return `是否有${phraseZh(haser[1])}`;
  const iser = name.match(/^is([A-Z].*)$/);
  if (iser) return `是否${phraseZh(iser[1])}`;
  const should = name.match(/^should([A-Z].*)$/);
  if (should) return `是否应${phraseZh(should[1])}`;
  return phraseZh(name);
}

function uniqueName(base, used) {
  let name = base;
  let index = 2;
  while (used.has(name)) {
    name = `${base}重名${index}`;
    index += 1;
  }
  used.add(name);
  return name;
}

function methodsOf(name) {
  const Klass = Konva[name];
  const methods = new Set();
  if (Klass && Klass.prototype) {
    let proto = Klass.prototype;
    while (proto && proto !== Object.prototype) {
      for (const methodName of Object.getOwnPropertyNames(proto)) {
        const descriptor = Object.getOwnPropertyDescriptor(proto, methodName);
        if (
          methodName !== "constructor" &&
          descriptor &&
          typeof descriptor.value === "function" &&
          !methodName.startsWith("_")
        ) {
          methods.add(methodName);
        }
      }
      proto = Object.getPrototypeOf(proto);
    }
  }
  return Array.from(methods).sort((a, b) => a.localeCompare(b));
}

let out = "";
out += '<火山程序 类型 = "通常" 版本 = 1 />\n\n';
out += '包 火山.KonvaWebView2 <注释 = "由本地 assets\\\\konva.js 自动反射生成的 Konva API 显式类封装。"\n';
out += '        注释 = "每个类对应 Konva 同名 JS 类；每个公开方法通过 Konva画布框 的 WebView2 网关转发调用。"\n';
out += '        注释 = "参数JSON 为 JS 方法实参数组 JSON，例如 []、[10]、[{\\"x\\":1}]；返回值统一为 JSON 文本或普通文本。">\n\n';
out += corePrelude + "\n\n";

for (const className of classNames) {
  const isNode = nodeClasses.has(className);
  const methods = methodsOf(className);
  const wrapperClassName = `Konva${classZh[className]}`;
  const usedMethodNames = new Set(["画布"]);
  out += `类 ${wrapperClassName} <公开 注释 = "封装本地 konva.js 中的 Konva.${className} 类。共生成 ${methods.length} 个公开原型方法。">\n{\n`;
  out += '    变量 画布 <类型 = Konva画布框 注释 = "承载 Konva 页面的 WebView2 画布封装对象。调用任何方法前必须先绑定。">\n';

  if (isNode) {
    out += `    变量 节点ID <公开 类型 = 文本型 值 = "${specialIds[className] || ""}" 注释 = "Konva 节点 ID。为空时部分方法会作用于当前选中节点；Stage/Layer/Transformer 使用特殊 ID。">\n\n`;
    usedMethodNames.add("节点ID");
    usedMethodNames.add("绑定画布");
    usedMethodNames.add("绑定节点");
    usedMethodNames.add("创建");
    usedMethodNames.add("取节点ID");
    out += `    方法 绑定画布 <公开 类型 = 逻辑型 注释 = "绑定 Konva画布框，后续 Konva.${className} 方法都会转发到该画布。">\n`;
    out += '    参数 欲绑定画布 <类型 = Konva画布框 注释 = "已绑定 Edge浏览框 的 Konva画布框。">\n';
    out += "    {\n        画布 = 欲绑定画布\n        返回 (真)\n    }\n\n";
    out += `    方法 绑定节点 <公开 类型 = 逻辑型 注释 = "绑定已经存在的 Konva.${className} 节点 ID，不创建新节点。">\n`;
    out += '    参数 欲ID <类型 = 文本型 注释 = "已有 Konva 节点 ID；可用 $stage、$layer、$transformer 表示内置对象。">\n';
    out += "    {\n        节点ID = 欲ID\n        返回 (真)\n    }\n\n";
    out += `    方法 创建 <公开 类型 = 文本型 注释 = "创建 Konva.${className} 节点实例并保存 ID。构造参数来自本地 konva.js；通常传 [{...attrs...}]。">\n`;
    out += '    参数 欲ID <类型 = 文本型 注释 = "新节点 ID。">\n';
    out += '    参数 构造参数JSON <类型 = 文本型 注释 = "构造函数参数数组 JSON，例如 [{\\"x\\":10,\\"y\\":10}]。" @默认值 = "[]">\n';
    out += '    参数 加入目标 <类型 = 文本型 注释 = "加入目标。默认 layer；可填 stage、none 或某个 Group 节点 ID。" @默认值 = "layer">\n';
    out += `    {\n        节点ID = 欲ID\n        返回 (画布.执行命令 ("{\\\"method\\\":\\\"newKonva\\\",\\\"args\\\":{\\\"className\\\":\\\"${className}\\\",\\\"id\\\":\\\"" + 节点ID + "\\\",\\\"args\\\":" + 构造参数JSON + ",\\\"addTo\\\":\\\"" + 加入目标 + "\\\"}}", 3000))\n    }\n\n`;
    out += `    方法 取节点ID <公开 类型 = 文本型 注释 = "返回当前 Konva.${className} 封装对象绑定的节点 ID。">\n    {\n        返回 (节点ID)\n    }\n\n`;

    for (const methodName of methods) {
      const wrapperMethodName = uniqueName(methodNameZh(methodName), usedMethodNames);
      out += `    方法 ${wrapperMethodName} <公开 类型 = 文本型 注释 = "封装 Konva.${className}.prototype.${methodName}()。参数JSON 是该 JS 方法的实参数组；返回 WebView2 序列化结果。">\n`;
      out += '    参数 参数JSON <类型 = 文本型 注释 = "JS 实参数组 JSON，例如 []、[10]、[{\\"x\\":1}]。" @默认值 = "[]">\n';
      out += '    参数 超时毫秒 <类型 = 整数 注释 = "等待 JS 返回值的最长时间。" @默认值 = 2000>\n';
      out += `    {\n        返回 (画布.调用图形方法 (节点ID, "${methodName}", 参数JSON, 超时毫秒))\n    }\n\n`;
    }
  } else {
    out += '    变量 对象ID <公开 类型 = 文本型 注释 = "WebView2 桥接层中保存的非节点 Konva 对象 ID。">\n\n';
    usedMethodNames.add("对象ID");
    usedMethodNames.add("绑定画布");
    usedMethodNames.add("绑定对象ID");
    usedMethodNames.add("创建");
    usedMethodNames.add("取对象ID");
    usedMethodNames.add("释放");
    out += `    方法 绑定画布 <公开 类型 = 逻辑型 注释 = "绑定 Konva画布框，后续 Konva.${className} 方法都会转发到该画布。">\n`;
    out += '    参数 欲绑定画布 <类型 = Konva画布框 注释 = "已绑定 Edge浏览框 的 Konva画布框。">\n';
    out += "    {\n        画布 = 欲绑定画布\n        返回 (真)\n    }\n\n";
    out += `    方法 绑定对象ID <公开 类型 = 逻辑型 注释 = "绑定已经由桥接层返回的 Konva.${className} objectId，不创建新对象。">\n`;
    out += '    参数 欲对象ID <类型 = 文本型 注释 = "桥接层返回的 objectId。">\n';
    out += "    {\n        对象ID = 欲对象ID\n        返回 (真)\n    }\n\n";
    out += `    方法 创建 <公开 类型 = 文本型 注释 = "创建 Konva.${className} 非节点对象并保存 objectId。构造参数来自本地 konva.js。">\n`;
    out += '    参数 欲对象ID <类型 = 文本型 注释 = "要保存到桥接层的 objectId，建议保证唯一。">\n';
    out += '    参数 构造参数JSON <类型 = 文本型 注释 = "构造函数参数数组 JSON，例如 [] 或 [{...}]。" @默认值 = "[]">\n';
    out += `    {\n        对象ID = 欲对象ID\n        返回 (画布.执行命令 ("{\\\"method\\\":\\\"newKonva\\\",\\\"args\\\":{\\\"className\\\":\\\"${className}\\\",\\\"objectId\\\":\\\"" + 对象ID + "\\\",\\\"args\\\":" + 构造参数JSON + ",\\\"addTo\\\":\\\"none\\\"}}", 3000))\n    }\n\n`;
    out += `    方法 取对象ID <公开 类型 = 文本型 注释 = "返回当前 Konva.${className} 封装对象绑定的 objectId。">\n    {\n        返回 (对象ID)\n    }\n\n`;
    out += `    方法 释放 <公开 类型 = 逻辑型 注释 = "释放当前 Konva.${className} 非节点对象在 WebView2 桥接层中的引用。">\n    {\n        返回 (画布.释放Konva对象 (对象ID))\n    }\n\n`;

    for (const methodName of methods) {
      const wrapperMethodName = uniqueName(methodNameZh(methodName), usedMethodNames);
      out += `    方法 ${wrapperMethodName} <公开 类型 = 文本型 注释 = "封装 Konva.${className}.prototype.${methodName}()。参数JSON 是该 JS 方法的实参数组；返回 WebView2 序列化结果。">\n`;
      out += '    参数 参数JSON <类型 = 文本型 注释 = "JS 实参数组 JSON，例如 []、[10]、[{\\"x\\":1}]。" @默认值 = "[]">\n';
      out += '    参数 超时毫秒 <类型 = 整数 注释 = "等待 JS 返回值的最长时间。" @默认值 = 2000>\n';
      out += `    {\n        返回 (画布.调用Konva对象方法 (对象ID, "${methodName}", 参数JSON, 超时毫秒))\n    }\n\n`;
    }
  }

  out += "}\n\n";
}

fs.writeFileSync("src/KonvaApiWrappers.wsv", out, "utf8");

const summary = {};
for (const className of classNames) {
  const used = new Set(
    nodeClasses.has(className)
      ? ["画布", "节点ID", "绑定画布", "绑定节点", "创建", "取节点ID"]
      : ["画布", "对象ID", "绑定画布", "绑定对象ID", "创建", "取对象ID", "释放"]
  );
  const methodMap = {};
  for (const methodName of methodsOf(className)) {
    methodMap[methodName] = uniqueName(methodNameZh(methodName), used);
  }
  summary[className] = {
    exists: Boolean(Konva[className]),
    wrapperClass: `Konva${classZh[className]}`,
    nodeClass: nodeClasses.has(className),
    methodCount: methodsOf(className).length,
    methods: methodsOf(className),
    methodMap,
  };
}

fs.writeFileSync(
  "docs/konva_local_wrapper_map.json",
  JSON.stringify({ version: Konva.version, classes: summary }, null, 2),
  "utf8"
);

console.log(`generated src/KonvaApiWrappers.wsv ${out.length} chars`);
console.log(`classes ${classNames.length}, method entries ${Object.values(summary).reduce((n, c) => n + c.methodCount, 0)}`);
