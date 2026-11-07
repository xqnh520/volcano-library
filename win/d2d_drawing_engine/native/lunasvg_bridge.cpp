#include "lunasvg_bridge.hpp"

#include "third_party/lunasvg/include/lunasvg.h"

#include <algorithm>
#include <cmath>
#include <string>

namespace volcano_d2d {

bool RenderSvgToBgraBitmap(
    const void* data,
    int dataSize,
    int requestedWidth,
    int requestedHeight,
    std::vector<unsigned char>& bgraPixels,
    int& width,
    int& height,
    int& stride) {
    bgraPixels.clear();
    width = 0;
    height = 0;
    stride = 0;
    if (!data || dataSize <= 0) return false;

    std::string svgText(static_cast<const char*>(data), static_cast<size_t>(dataSize));
    auto document = lunasvg::Document::loadFromData(svgText.data(), svgText.size());
    if (!document) return false;

    int targetWidth = requestedWidth > 0 ? requestedWidth : static_cast<int>(std::ceil(document->width()));
    int targetHeight = requestedHeight > 0 ? requestedHeight : static_cast<int>(std::ceil(document->height()));
    if (targetWidth <= 0 || targetHeight <= 0) {
        targetWidth = 128;
        targetHeight = 128;
    }
    targetWidth = std::max(1, std::min(targetWidth, 4096));
    targetHeight = std::max(1, std::min(targetHeight, 4096));

    auto bitmap = document->renderToBitmap(targetWidth, targetHeight, 0x00000000);
    if (bitmap.isNull() || bitmap.width() <= 0 || bitmap.height() <= 0 || !bitmap.data()) return false;

    width = bitmap.width();
    height = bitmap.height();
    stride = width * 4;
    bgraPixels.resize(static_cast<size_t>(stride) * static_cast<size_t>(height));

    const unsigned char* src = bitmap.data();
    const int srcStride = bitmap.stride();
    for (int y = 0; y < height; ++y) {
        const unsigned char* srcRow = src + static_cast<size_t>(srcStride) * static_cast<size_t>(y);
        unsigned char* dstRow = bgraPixels.data() + static_cast<size_t>(stride) * static_cast<size_t>(y);
        std::copy(srcRow, srcRow + stride, dstRow);
    }

    return true;
}

}  // namespace volcano_d2d
