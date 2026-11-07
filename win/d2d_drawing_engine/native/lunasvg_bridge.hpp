#pragma once

#include <vector>

namespace volcano_d2d {

bool RenderSvgToBgraBitmap(
    const void* data,
    int dataSize,
    int requestedWidth,
    int requestedHeight,
    std::vector<unsigned char>& bgraPixels,
    int& width,
    int& height,
    int& stride);

}  // namespace volcano_d2d
