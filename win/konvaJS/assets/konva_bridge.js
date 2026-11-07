/* global Konva */
(function () {
  "use strict";

  const state = {
    stage: null,
    layer: null,
    transformer: null,
    containerId: "container",
    tool: "select",
    selectedId: "",
    drawing: false,
    drawNode: null,
    drawStart: null,
    lastPointer: null,
    stroke: "#1f2937",
    fill: "#2f80ed",
    strokeWidth: 2,
    freeLine: null,
    seq: 1,
    objectSeq: 1,
    objects: Object.create(null),
  };

  /**
   * Sends a structured event to the WebView2 host when WebView2 messaging is available.
   * @param {string} type Event name consumed by Volcano.
   * @param {object} payload Event detail object.
   */
  function post(type, payload) {
    const message = JSON.stringify({ type, payload: payload || {} });
    if (window.chrome && window.chrome.webview) {
      window.chrome.webview.postMessage(message);
    }
    appendLog(type + " " + JSON.stringify(payload || {}));
  }

  /**
   * Appends a short diagnostic line to the visible event log.
   * @param {string} text Text to append.
   */
  function appendLog(text) {
    const log = document.getElementById("eventLog");
    if (!log) return;
    const stamp = new Date().toLocaleTimeString();
    log.value = `[${stamp}] ${text}\n` + log.value;
  }

  /**
   * Returns a stable id for a new Konva node.
   * @param {string} prefix Node id prefix.
   * @returns {string} Unique id.
   */
  function nextId(prefix) {
    state.seq += 1;
    return `${prefix || "node"}_${state.seq}`;
  }

  /**
   * Finds a Konva node by id on the current stage.
   * @param {string} id Node id.
   * @returns {Konva.Node|null} Matching node or null.
   */
  function findNode(id) {
    if (!state.stage || !id) return null;
    return state.stage.findOne("#" + id);
  }

  /**
   * Returns a nested property from the Konva namespace by dot path.
   * @param {string} path Dot path such as "Util.getRandomColor" or "Easings.EaseIn".
   * @returns {*} Resolved value.
   */
  function resolveKonvaPath(path) {
    if (!path) throw new Error("path is required");
    const parts = String(path).split(".");
    let target = Konva;
    for (const part of parts) {
      if (!part) continue;
      if (target == null || !(part in target)) {
        throw new Error("Konva path not found: " + path);
      }
      target = target[part];
    }
    return target;
  }

  /**
   * Returns the parent object and property name for a Konva dot path.
   * @param {string} path Dot path.
   * @returns {{owner: object, name: string, value: *}} Owner, property name, and value.
   */
  function resolveKonvaMember(path) {
    if (!path) throw new Error("path is required");
    const parts = String(path).split(".");
    const name = parts.pop();
    let owner = Konva;
    parts.forEach((part) => {
      if (!part) return;
      if (owner == null || !(part in owner)) throw new Error("Konva path not found: " + path);
      owner = owner[part];
    });
    if (!owner || !name || !(name in owner)) throw new Error("Konva path not found: " + path);
    return { owner, name, value: owner[name] };
  }

  /**
   * Stores a non-node JavaScript object returned by Konva for later calls.
   * @param {string} prefix Object id prefix.
   * @param {*} value JavaScript value.
   * @returns {string} Stored object id.
   */
  function storeObject(prefix, value) {
    const id = `${prefix || "object"}_${state.objectSeq++}`;
    state.objects[id] = value;
    return id;
  }

  /**
   * Tests whether a value is a plain JSON-like object.
   * @param {*} value Value to test.
   * @returns {boolean} True for plain objects.
   */
  function isPlainObject(value) {
    if (!value || typeof value !== "object") return false;
    const proto = Object.getPrototypeOf(value);
    return proto === Object.prototype || proto === null;
  }

  /**
   * Decodes bridge reference objects inside argument JSON.
   * @param {*} value JSON argument value.
   * @returns {*} Decoded argument value.
   */
  function decodeArg(value) {
    if (Array.isArray(value)) return value.map(decodeArg);
    if (value && typeof value === "object") {
      if (value.$node) return findNode(value.$node);
      if (value.$selectedNode) return findNode(state.selectedId);
      if (value.$object) return state.objects[value.$object];
      const out = {};
      Object.keys(value).forEach((key) => {
        out[key] = decodeArg(value[key]);
      });
      return out;
    }
    return value;
  }

  /**
   * Decodes an argument array passed through the bridge.
   * @param {Array} args JSON argument array.
   * @returns {Array} Decoded arguments.
   */
  function decodeArgs(args) {
    return (args || []).map(decodeArg);
  }

  /**
   * Converts any command result to a JSON-safe value for Volcano.
   * @param {*} value JavaScript return value.
   * @returns {*} JSON-safe value.
   */
  function serializeResult(value) {
    if (value == null) return value;
    if (typeof value === "number" || typeof value === "string" || typeof value === "boolean") return value;
    if (Array.isArray(value)) return value.map(serializeResult);
    if (value instanceof Konva.Node) return nodeSnapshot(value);
    if (typeof value === "function") return { kind: "function", name: value.name || "" };
    if (typeof value === "object") {
      if (typeof value.toObject === "function") return value.toObject();
      if (isPlainObject(value)) {
        const out = {};
        Object.keys(value).forEach((key) => {
          out[key] = serializeResult(value[key]);
        });
        return out;
      }
      const objectId = storeObject("konva", value);
      return { kind: "object", objectId };
    }
    return String(value);
  }

  /**
   * Returns public static entries, classes, and prototype methods found on the loaded Konva object.
   * @returns {object} API map.
   */
  function buildApiMap() {
    const classes = {};
    const statics = [];
    Object.keys(Konva).sort().forEach((key) => {
      const value = Konva[key];
      if (typeof value === "function" && value.prototype) {
        const methods = new Set();
        let proto = value.prototype;
        while (proto && proto !== Object.prototype) {
          Object.getOwnPropertyNames(proto).forEach((name) => {
            const descriptor = Object.getOwnPropertyDescriptor(proto, name);
            if (name !== "constructor" && descriptor && typeof descriptor.value === "function") methods.add(name);
          });
          proto = Object.getPrototypeOf(proto);
        }
        classes[key] = Array.from(methods).sort();
      } else if (typeof value === "function") {
        statics.push(key);
      } else if (value && typeof value === "object") {
        statics.push(key);
      } else {
        statics.push(key);
      }
    });
    return { version: Konva.version, statics, classes };
  }

  /**
   * Returns the current pointer position or a default zero point.
   * @returns {{x:number,y:number}} Pointer position.
   */
  function pointer() {
    return state.stage.getPointerPosition() || { x: 0, y: 0 };
  }

  /**
   * Selects a node and attaches the transformer to it.
   * @param {Konva.Node|null} node Node to select.
   */
  function selectNode(node) {
    if (!state.transformer) return;
    if (!node || node === state.stage || node === state.layer) {
      state.transformer.nodes([]);
      state.selectedId = "";
      post("selection", { id: "" });
      return;
    }
    state.transformer.nodes([node]);
    state.selectedId = node.id();
    post("selection", { id: node.id(), type: node.className });
  }

  /**
   * Registers common click, drag, and transform events for a shape.
   * @param {Konva.Node} node Shape node.
   */
  function wireShape(node) {
    node.on("click tap", function (evt) {
      evt.cancelBubble = true;
      selectNode(node);
      post("shapeClick", { id: node.id(), type: node.className });
    });
    node.on("dragstart", function () {
      post("dragStart", { id: node.id(), x: node.x(), y: node.y() });
    });
    node.on("dragmove", function () {
      post("dragMove", { id: node.id(), x: node.x(), y: node.y() });
    });
    node.on("dragend", function () {
      post("dragEnd", { id: node.id(), x: node.x(), y: node.y() });
    });
    node.on("transformend", function () {
      post("transformEnd", nodeSnapshot(node));
    });
  }

  /**
   * Builds a serializable snapshot for one node.
   * @param {Konva.Node} node Shape node.
   * @returns {object} Snapshot.
   */
  function nodeSnapshot(node) {
    return {
      id: node.id(),
      type: node.className,
      x: node.x(),
      y: node.y(),
      width: typeof node.width === "function" ? node.width() : 0,
      height: typeof node.height === "function" ? node.height() : 0,
      radius: typeof node.radius === "function" ? node.radius() : 0,
      scaleX: node.scaleX(),
      scaleY: node.scaleY(),
      rotation: node.rotation(),
    };
  }

  /**
   * Creates the stage, layer, transformer, and canvas-level event handlers.
   * @param {object} options Stage options.
   * @returns {object} Result object.
   */
  function init(options) {
    const containerId = options.containerId || state.containerId;
    const container = document.getElementById(containerId);
    if (!container) throw new Error("container not found: " + containerId);

    state.containerId = containerId;
    state.stage = new Konva.Stage({
      container: containerId,
      width: options.width || container.clientWidth || 800,
      height: options.height || container.clientHeight || 600,
    });
    state.layer = new Konva.Layer();
    state.transformer = new Konva.Transformer({
      rotateEnabled: true,
      ignoreStroke: false,
    });
    state.stage.add(state.layer);
    state.layer.add(state.transformer);

    state.stage.on("mousedown touchstart", onPointerDown);
    state.stage.on("mousemove touchmove", onPointerMove);
    state.stage.on("mouseup touchend", onPointerUp);
    state.stage.on("click tap", function (evt) {
      if (evt.target === state.stage) selectNode(null);
    });

    window.addEventListener("resize", resizeToContainer);
    resizeToContainer();
    post("ready", { width: state.stage.width(), height: state.stage.height(), konva: Konva.version });
    return { ok: true, version: Konva.version };
  }

  /**
   * Resizes the stage to its container size.
   */
  function resizeToContainer() {
    if (!state.stage) return;
    const container = document.getElementById(state.containerId);
    if (!container) return;
    const width = Math.max(1, container.clientWidth);
    const height = Math.max(1, container.clientHeight);
    state.stage.size({ width, height });
    state.stage.batchDraw();
  }

  /**
   * Applies the selected draw or select tool.
   * @param {object|string} tool Tool name or option object.
   * @returns {object} Result object.
   */
  function setTool(tool) {
    const opts = typeof tool === "string" ? { tool } : tool || {};
    state.tool = opts.tool || "select";
    if (opts.fill) state.fill = opts.fill;
    if (opts.stroke) state.stroke = opts.stroke;
    if (opts.strokeWidth) state.strokeWidth = Number(opts.strokeWidth);
    post("tool", { tool: state.tool });
    return { ok: true, tool: state.tool };
  }

  /**
   * Handles pointer down for drawing tools.
   * @param {Konva.KonvaEventObject<MouseEvent|TouchEvent>} evt Konva event.
   */
  function onPointerDown(evt) {
    if (state.tool === "select") return;
    if (evt.target !== state.stage) return;

    const pos = pointer();
    state.drawing = true;
    state.drawStart = pos;
    state.lastPointer = pos;

    if (state.tool === "rect") {
      state.drawNode = api.addRect({ id: nextId("rect"), x: pos.x, y: pos.y, width: 1, height: 1, fill: state.fill, stroke: state.stroke, draggable: true });
    } else if (state.tool === "circle") {
      state.drawNode = api.addCircle({ id: nextId("circle"), x: pos.x, y: pos.y, radius: 1, fill: state.fill, stroke: state.stroke, draggable: true });
    } else if (state.tool === "ellipse") {
      state.drawNode = api.addEllipse({ id: nextId("ellipse"), x: pos.x, y: pos.y, radiusX: 1, radiusY: 1, fill: state.fill, stroke: state.stroke, draggable: true });
    } else if (state.tool === "line") {
      state.drawNode = api.addLine({ id: nextId("line"), points: [pos.x, pos.y, pos.x + 1, pos.y + 1], stroke: state.stroke, strokeWidth: state.strokeWidth, draggable: true });
    } else if (state.tool === "free") {
      state.freeLine = api.addLine({ id: nextId("free"), points: [pos.x, pos.y], stroke: state.stroke, strokeWidth: state.strokeWidth, draggable: true, lineCap: "round", lineJoin: "round" });
      state.drawNode = state.freeLine;
    }
    post("drawStart", { tool: state.tool, x: pos.x, y: pos.y });
  }

  /**
   * Handles pointer move for drawing tools.
   * @param {Konva.KonvaEventObject<MouseEvent|TouchEvent>} evt Konva event.
   */
  function onPointerMove(evt) {
    if (!state.drawing || !state.drawNode) return;
    evt.evt.preventDefault();
    const pos = pointer();
    const start = state.drawStart;
    const dx = pos.x - start.x;
    const dy = pos.y - start.y;

    if (state.tool === "rect") {
      state.drawNode.position({ x: Math.min(start.x, pos.x), y: Math.min(start.y, pos.y) });
      state.drawNode.size({ width: Math.abs(dx), height: Math.abs(dy) });
    } else if (state.tool === "circle") {
      state.drawNode.radius(Math.max(1, Math.sqrt(dx * dx + dy * dy)));
    } else if (state.tool === "ellipse") {
      state.drawNode.radiusX(Math.max(1, Math.abs(dx)));
      state.drawNode.radiusY(Math.max(1, Math.abs(dy)));
    } else if (state.tool === "line") {
      state.drawNode.points([start.x, start.y, pos.x, pos.y]);
    } else if (state.tool === "free") {
      state.drawNode.points(state.drawNode.points().concat([pos.x, pos.y]));
    }
    state.layer.batchDraw();
  }

  /**
   * Handles pointer up for drawing tools.
   */
  function onPointerUp() {
    if (!state.drawing) return;
    state.drawing = false;
    if (state.drawNode) {
      selectNode(state.drawNode);
      post("drawEnd", nodeSnapshot(state.drawNode));
    }
    state.drawNode = null;
    state.freeLine = null;
    state.drawStart = null;
  }

  const api = {
    /**
     * Initializes a Konva stage in the configured container.
     * @param {object} options Stage width, height, and containerId.
     * @returns {object} Result object.
     */
    init,

    /**
     * Resizes the stage to explicit dimensions.
     * @param {object} args Width and height.
     * @returns {object} Result object.
     */
    resizeStage(args) {
      state.stage.size({ width: Number(args.width), height: Number(args.height) });
      state.stage.batchDraw();
      return { ok: true };
    },

    /**
     * Changes the current interaction tool.
     * @param {object|string} args Tool options.
     * @returns {object} Result object.
     */
    setTool,

    /**
     * Adds a draggable rectangle.
     * @param {object} args Rectangle parameters.
     * @returns {Konva.Rect} Created node.
     */
    addRect(args) {
      const node = new Konva.Rect({
        id: args.id || nextId("rect"),
        x: Number(args.x || 0),
        y: Number(args.y || 0),
        width: Number(args.width || 120),
        height: Number(args.height || 80),
        fill: args.fill || state.fill,
        stroke: args.stroke || state.stroke,
        strokeWidth: Number(args.strokeWidth || 2),
        cornerRadius: Number(args.cornerRadius || 0),
        draggable: args.draggable !== false,
      });
      state.layer.add(node);
      wireShape(node);
      state.layer.batchDraw();
      post("created", nodeSnapshot(node));
      return node;
    },

    /**
     * Adds a draggable circle.
     * @param {object} args Circle parameters.
     * @returns {Konva.Circle} Created node.
     */
    addCircle(args) {
      const node = new Konva.Circle({
        id: args.id || nextId("circle"),
        x: Number(args.x || 0),
        y: Number(args.y || 0),
        radius: Number(args.radius || 40),
        fill: args.fill || state.fill,
        stroke: args.stroke || state.stroke,
        strokeWidth: Number(args.strokeWidth || 2),
        draggable: args.draggable !== false,
      });
      state.layer.add(node);
      wireShape(node);
      state.layer.batchDraw();
      post("created", nodeSnapshot(node));
      return node;
    },

    /**
     * Adds a draggable ellipse.
     * @param {object} args Ellipse parameters.
     * @returns {Konva.Ellipse} Created node.
     */
    addEllipse(args) {
      const node = new Konva.Ellipse({
        id: args.id || nextId("ellipse"),
        x: Number(args.x || 0),
        y: Number(args.y || 0),
        radiusX: Number(args.radiusX || 70),
        radiusY: Number(args.radiusY || 40),
        fill: args.fill || state.fill,
        stroke: args.stroke || state.stroke,
        strokeWidth: Number(args.strokeWidth || 2),
        draggable: args.draggable !== false,
      });
      state.layer.add(node);
      wireShape(node);
      state.layer.batchDraw();
      post("created", nodeSnapshot(node));
      return node;
    },

    /**
     * Adds a draggable line or freehand polyline.
     * @param {object} args Line parameters.
     * @returns {Konva.Line} Created node.
     */
    addLine(args) {
      const node = new Konva.Line({
        id: args.id || nextId("line"),
        points: args.points || [0, 0, 100, 100],
        stroke: args.stroke || state.stroke,
        strokeWidth: Number(args.strokeWidth || 2),
        lineCap: args.lineCap || "butt",
        lineJoin: args.lineJoin || "miter",
        draggable: args.draggable !== false,
      });
      state.layer.add(node);
      wireShape(node);
      state.layer.batchDraw();
      post("created", nodeSnapshot(node));
      return node;
    },

    /**
     * Adds editable text.
     * @param {object} args Text parameters.
     * @returns {Konva.Text} Created node.
     */
    addText(args) {
      const node = new Konva.Text({
        id: args.id || nextId("text"),
        x: Number(args.x || 0),
        y: Number(args.y || 0),
        text: args.text || "文本",
        fontSize: Number(args.fontSize || 22),
        fill: args.fill || "#111827",
        draggable: args.draggable !== false,
      });
      state.layer.add(node);
      wireShape(node);
      state.layer.batchDraw();
      post("created", nodeSnapshot(node));
      return node;
    },

    /**
     * Updates arbitrary Konva attributes on a node.
     * @param {object} args Node id and attrs.
     * @returns {object} Result object.
     */
    updateNode(args) {
      const node = findNode(args.id || state.selectedId);
      if (!node) return { ok: false, error: "node not found" };
      node.setAttrs(args.attrs || {});
      state.layer.batchDraw();
      post("updated", nodeSnapshot(node));
      return { ok: true };
    },

    /**
     * Updates width and height for the selected or specified shape.
     * @param {object} args Node id, width, and height.
     * @returns {object} Result object.
     */
    setNodeSize(args) {
      const node = findNode(args.id || state.selectedId);
      if (!node) return { ok: false, error: "node not found" };
      if (node.className === "Circle") {
        node.radius(Math.max(1, Number(args.width || args.height || 1) / 2));
      } else if (node.className === "Ellipse") {
        node.radiusX(Math.max(1, Number(args.width || 1) / 2));
        node.radiusY(Math.max(1, Number(args.height || 1) / 2));
      } else if (typeof node.width === "function" && typeof node.height === "function") {
        node.width(Math.max(1, Number(args.width || node.width())));
        node.height(Math.max(1, Number(args.height || node.height())));
      }
      node.scale({ x: 1, y: 1 });
      state.layer.batchDraw();
      post("resized", nodeSnapshot(node));
      return { ok: true };
    },

    /**
     * Deletes the selected or specified node.
     * @param {object} args Node id.
     * @returns {object} Result object.
     */
    deleteNode(args) {
      const node = findNode((args && args.id) || state.selectedId);
      if (!node) return { ok: false, error: "node not found" };
      const id = node.id();
      node.destroy();
      state.transformer.nodes([]);
      state.layer.batchDraw();
      post("deleted", { id });
      return { ok: true };
    },

    /**
     * Clears all user-created shapes from the layer.
     * @returns {object} Result object.
     */
    clear() {
      state.layer.getChildren().forEach((node) => {
        if (node !== state.transformer) node.destroy();
      });
      state.transformer.nodes([]);
      state.selectedId = "";
      state.layer.batchDraw();
      post("cleared", {});
      return { ok: true };
    },

    /**
     * Serializes the whole stage to a Konva JSON string.
     * @returns {string} Stage JSON.
     */
    getJson() {
      return state.stage.toJSON();
    },

    /**
     * Serializes the current stage to a PNG data URL.
     * @returns {string} PNG data URL.
     */
    exportPng() {
      return state.stage.toDataURL({ pixelRatio: 1 });
    },

    /**
     * Returns the full live Konva API map detected from the local konva.js file.
     * @returns {object} Konva API map.
     */
    getApiMap() {
      return buildApiMap();
    },

    /**
     * Calls any static function under the Konva namespace by dot path.
     * @param {object} args Path and JSON argument array.
     * @returns {*} JSON-safe call result.
     */
    callKonva(args) {
      const member = resolveKonvaMember(args.path);
      const fn = member.value;
      if (typeof fn !== "function") throw new Error("Konva path is not a function: " + args.path);
      return serializeResult(fn.apply(member.owner, decodeArgs(args.args)));
    },

    /**
     * Reads any public value under the Konva namespace by dot path.
     * @param {object} args Path to read.
     * @returns {*} JSON-safe value.
     */
    getKonvaValue(args) {
      return serializeResult(resolveKonvaPath(args.path));
    },

    /**
     * Sets any writable value under the Konva namespace by dot path.
     * @param {object} args Path and JSON value.
     * @returns {object} Result object.
     */
    setKonvaValue(args) {
      const parts = String(args.path || "").split(".");
      const prop = parts.pop();
      let target = Konva;
      parts.forEach((part) => {
        if (part) target = target[part];
      });
      if (!target || !prop) throw new Error("invalid Konva path: " + args.path);
      target[prop] = decodeArg(args.value);
      return { ok: true };
    },

    /**
     * Creates any Konva class instance by class name and optional constructor args.
     * @param {object} args Class name, constructor arguments, and addTo target.
     * @returns {*} JSON-safe created object summary.
     */
    newKonva(args) {
      const Klass = resolveKonvaPath(args.className);
      if (typeof Klass !== "function") throw new Error("Konva class not found: " + args.className);
      const ctorArgs = decodeArgs(args.args || [args.attrs || {}]);
      const value = new Klass(...ctorArgs);
      if (value instanceof Konva.Node) {
        if (args.id) value.id(args.id);
        const addTo = args.addTo || "layer";
        const parent = addTo === "stage" ? state.stage : addTo === "none" ? null : findNode(addTo) || state.layer;
        if (parent && typeof parent.add === "function") parent.add(value);
        wireShape(value);
        state.layer.batchDraw();
        post("created", nodeSnapshot(value));
        return nodeSnapshot(value);
      }
      const objectId = args.objectId || storeObject(args.className || "object", value);
      state.objects[objectId] = value;
      return { kind: "object", objectId };
    },

    /**
     * Calls a method on a stage node found by id, or on the selected node when id is empty.
     * @param {object} args Node id, method name, and argument array.
     * @returns {*} JSON-safe call result.
     */
    callNode(args) {
      const node = args.id === "$stage" ? state.stage : args.id === "$layer" ? state.layer : args.id === "$transformer" ? state.transformer : findNode(args.id || state.selectedId);
      if (!node) throw new Error("node not found");
      const fn = node[args.method];
      if (typeof fn !== "function") throw new Error("node method not found: " + args.method);
      const result = fn.apply(node, decodeArgs(args.args));
      state.layer.batchDraw();
      return serializeResult(result === node ? node : result);
    },

    /**
     * Reads one attribute or methodless property from a stage node.
     * @param {object} args Node id and property name.
     * @returns {*} JSON-safe property value.
     */
    getNodeValue(args) {
      const node = args.id === "$stage" ? state.stage : args.id === "$layer" ? state.layer : args.id === "$transformer" ? state.transformer : findNode(args.id || state.selectedId);
      if (!node) throw new Error("node not found");
      const value = typeof node[args.name] === "function" ? node[args.name]() : node[args.name];
      return serializeResult(value);
    },

    /**
     * Calls a method on an object previously returned by newKonva or callKonva.
     * @param {object} args Stored object id, method name, and argument array.
     * @returns {*} JSON-safe call result.
     */
    callObject(args) {
      const obj = state.objects[args.objectId];
      if (!obj) throw new Error("object not found: " + args.objectId);
      const fn = obj[args.method];
      if (typeof fn !== "function") throw new Error("object method not found: " + args.method);
      return serializeResult(fn.apply(obj, decodeArgs(args.args)));
    },

    /**
     * Destroys a stored non-node JavaScript object reference.
     * @param {object} args Stored object id.
     * @returns {object} Result object.
     */
    releaseObject(args) {
      delete state.objects[args.objectId];
      return { ok: true };
    },
  };

  /**
   * Executes one command object sent by Volcano.
   * @param {object|string} command Command object or JSON string.
   * @returns {*} Command result.
   */
  function run(command) {
    const msg = typeof command === "string" ? JSON.parse(command) : command;
    const method = msg.method || msg.cmd;
    if (!api[method]) throw new Error("unknown command: " + method);
    const result = api[method](msg.args || {});
    return serializeResult(result);
  }

  /**
   * Receives WebView2 messages from Volcano and dispatches them as bridge commands.
   * @param {MessageEvent} event WebView2 message event.
   */
  function onHostMessage(event) {
    try {
      const result = run(event.data);
      post("commandResult", { ok: true, result });
    } catch (err) {
      post("error", { message: err.message });
    }
  }

  /**
   * Wires the visible demo controls in AppStartPage.html.
   */
  function wireDemoControls() {
    const tool = document.getElementById("tool");
    const width = document.getElementById("shapeWidth");
    const height = document.getElementById("shapeHeight");
    const fill = document.getElementById("fill");
    const stroke = document.getElementById("stroke");

    tool.addEventListener("change", () => api.setTool({ tool: tool.value, fill: fill.value, stroke: stroke.value }));
    fill.addEventListener("change", () => api.setTool({ tool: tool.value, fill: fill.value, stroke: stroke.value }));
    stroke.addEventListener("change", () => api.setTool({ tool: tool.value, fill: fill.value, stroke: stroke.value }));
    document.getElementById("addRect").addEventListener("click", () => {
      api.addRect({ x: 80, y: 80, width: Number(width.value), height: Number(height.value), fill: fill.value, stroke: stroke.value, draggable: true });
    });
    document.getElementById("addCircle").addEventListener("click", () => {
      api.addCircle({ x: 180, y: 180, radius: Math.max(8, Number(width.value) / 2), fill: fill.value, stroke: stroke.value, draggable: true });
    });
    document.getElementById("applySize").addEventListener("click", () => {
      api.setNodeSize({ width: Number(width.value), height: Number(height.value) });
    });
    document.getElementById("clear").addEventListener("click", () => api.clear());
  }

  /**
   * Starts the standalone demo page and seeds it with sample shapes.
   */
  function startDemo() {
    init({ containerId: "container" });
    wireDemoControls();
    api.addRect({ id: "demo_rect", x: 80, y: 80, width: 160, height: 90, fill: "#2f80ed", stroke: "#1f2937", cornerRadius: 6, draggable: true });
    api.addCircle({ id: "demo_circle", x: 340, y: 150, radius: 54, fill: "#22c55e", stroke: "#14532d", draggable: true });
    api.addText({ id: "demo_text", x: 80, y: 220, text: "拖动图形，或选择左侧绘图模式后在画布上拖拽绘制。", fontSize: 18, fill: "#0f172a", draggable: true });
    if (window.chrome && window.chrome.webview) {
      window.chrome.webview.addEventListener("message", onHostMessage);
    }
  }

  window.KonvaBridge = { api, run, startDemo };
})();
