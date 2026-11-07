#pragma once

#include <stdint.h>

#ifdef _WIN32
#define MDNS_BRIDGE_CALL __stdcall
#ifdef MDNS_BRIDGE_EXPORTS
#define MDNS_BRIDGE_API extern "C" __declspec(dllexport)
#else
#define MDNS_BRIDGE_API extern "C" __declspec(dllimport)
#endif
#else
#define MDNS_BRIDGE_CALL
#define MDNS_BRIDGE_API extern "C"
#endif

typedef void* MdnsHandle;

enum MdnsEventType
{
    MDNS_EVENT_NONE = 0,
    MDNS_EVENT_REGISTERED = 1,
    MDNS_EVENT_SERVICE_ADD = 2,
    MDNS_EVENT_SERVICE_REMOVE = 3,
    MDNS_EVENT_RESOLVED = 4,
    MDNS_EVENT_ADDRESS = 5,
    MDNS_EVENT_ERROR = 100
};

struct MdnsEvent
{
    int32_t type;
    int32_t flags;
    int32_t interface_index;
    int32_t error_code;
    char name[256];
    char service_type[128];
    char domain[256];
    char host[256];
    char address[64];
    uint16_t port;
    char txt[1024];
};

MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_last_error(void);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_error_text(int32_t error_code, wchar_t* buffer, int32_t buffer_chars);

MDNS_BRIDGE_API MdnsHandle MDNS_BRIDGE_CALL mdns_create(void);
MDNS_BRIDGE_API void MDNS_BRIDGE_CALL mdns_destroy(MdnsHandle handle);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_close(MdnsHandle handle);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_poll(MdnsHandle handle, int32_t timeout_ms);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_next_event(MdnsHandle handle, MdnsEvent* event_out);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_event_to_text(const MdnsEvent* event_in, wchar_t* buffer, int32_t buffer_chars);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_pop_event(MdnsHandle handle);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_current_event_error(void);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_current_event_interface_index(void);
MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_current_event_port(void);
MDNS_BRIDGE_API const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_text(void);
MDNS_BRIDGE_API const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_name(void);
MDNS_BRIDGE_API const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_service_type(void);
MDNS_BRIDGE_API const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_domain(void);
MDNS_BRIDGE_API const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_host(void);
MDNS_BRIDGE_API const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_address(void);
MDNS_BRIDGE_API const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_txt(void);
MDNS_BRIDGE_API const wchar_t* MDNS_BRIDGE_CALL mdns_error_text_ptr(int32_t error_code);

MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_register_service(
    MdnsHandle handle,
    const wchar_t* name,
    const wchar_t* service_type,
    const wchar_t* domain,
    const wchar_t* host,
    uint16_t port,
    const wchar_t* txt_pairs);

MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_browse_services(
    MdnsHandle handle,
    const wchar_t* service_type,
    const wchar_t* domain);

MDNS_BRIDGE_API int32_t MDNS_BRIDGE_CALL mdns_resolve_service(
    MdnsHandle handle,
    int32_t interface_index,
    const wchar_t* name,
    const wchar_t* service_type,
    const wchar_t* domain);
