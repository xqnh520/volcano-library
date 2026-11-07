// b2vol.h  (include root forwarder)
//
// The Volcano package attribute for external headers is resolved through the
// header search directory "include", so this forwarder is the file that ends
// up in stdafx.h. It pulls in the upstream Box2D C API first (the real shim
// needs it) and then the real shim that lives next to the static libraries.
//
// The canonical shim is ../native/b2vol.h (pure ASCII).
// Keep this file pure ASCII too: MSVC reports C4819 for non-ASCII bytes here.

#ifndef B2VOL_FORWARD_H
#define B2VOL_FORWARD_H

#include <box2d/box2d.h>

#include "../native/b2vol.h"

#endif // B2VOL_FORWARD_H
