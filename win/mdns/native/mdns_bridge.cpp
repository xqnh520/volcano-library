#define NOMINMAX
#define WIN32_LEAN_AND_MEAN
#define MDNS_BRIDGE_EXPORTS

#include "mdns_bridge.h"

#include <winsock2.h>
#include <ws2tcpip.h>
#include <windows.h>

#include <algorithm>
#include <cstring>
#include <deque>
#include <mutex>
#include <new>
#include <sstream>
#include <string>
#include <utility>
#include <vector>

#include "../../mDNS/Include/dns_sd.h"

namespace
{
thread_local int32_t g_last_error = 0;
thread_local MdnsEvent g_current_event = {};
thread_local std::wstring g_text_result;

struct Operation
{
    DNSServiceRef ref = nullptr;
};

struct MdnsContext
{
    std::mutex lock;
    DNSServiceRef register_ref = nullptr;
    DNSServiceRef browse_ref = nullptr;
    std::vector<Operation*> one_shot_refs;
    std::deque<MdnsEvent> events;
};

void set_last_error(int32_t value)
{
    g_last_error = value;
}

std::string wide_to_utf8(const wchar_t* value)
{
    if (!value || !*value)
    {
        return std::string();
    }

    int size = WideCharToMultiByte(CP_UTF8, 0, value, -1, nullptr, 0, nullptr, nullptr);
    if (size <= 1)
    {
        return std::string();
    }

    std::string result(static_cast<size_t>(size - 1), '\0');
    WideCharToMultiByte(CP_UTF8, 0, value, -1, &result[0], size, nullptr, nullptr);
    return result;
}

std::wstring utf8_to_wide(const char* value)
{
    if (!value || !*value)
    {
        return std::wstring();
    }

    int size = MultiByteToWideChar(CP_UTF8, 0, value, -1, nullptr, 0);
    if (size <= 1)
    {
        return std::wstring();
    }

    std::wstring result(static_cast<size_t>(size - 1), L'\0');
    MultiByteToWideChar(CP_UTF8, 0, value, -1, &result[0], size);
    return result;
}

void copy_text(char* target, size_t target_size, const char* source)
{
    if (!target || target_size == 0)
    {
        return;
    }

    target[0] = '\0';
    if (!source)
    {
        return;
    }

    strncpy_s(target, target_size, source, _TRUNCATE);
}

void copy_wide(wchar_t* target, int32_t target_chars, const std::wstring& source)
{
    if (!target || target_chars <= 0)
    {
        return;
    }

    target[0] = L'\0';
    wcsncpy_s(target, static_cast<size_t>(target_chars), source.c_str(), _TRUNCATE);
}

std::wstring error_text(int32_t code)
{
    switch (code)
    {
    case kDNSServiceErr_NoError: return L"No error";
    case kDNSServiceErr_Unknown: return L"Unknown error";
    case kDNSServiceErr_NoSuchName: return L"No such name";
    case kDNSServiceErr_NoMemory: return L"No memory";
    case kDNSServiceErr_BadParam: return L"Bad parameter";
    case kDNSServiceErr_BadReference: return L"Bad reference";
    case kDNSServiceErr_BadState: return L"Bad state";
    case kDNSServiceErr_BadFlags: return L"Bad flags";
    case kDNSServiceErr_Unsupported: return L"Unsupported";
    case kDNSServiceErr_NotInitialized: return L"Not initialized";
    case kDNSServiceErr_AlreadyRegistered: return L"Already registered";
    case kDNSServiceErr_NameConflict: return L"Name conflict";
    case kDNSServiceErr_Invalid: return L"Invalid";
    case kDNSServiceErr_Firewall: return L"Blocked by firewall";
    case kDNSServiceErr_Incompatible: return L"Incompatible daemon";
    case kDNSServiceErr_BadInterfaceIndex: return L"Bad interface index";
    case kDNSServiceErr_Refused: return L"Refused";
    case kDNSServiceErr_ServiceNotRunning: return L"Bonjour service is not running";
    case kDNSServiceErr_Timeout: return L"Timeout";
    default:
        return L"DNS-SD error " + std::to_wstring(code);
    }
}

void push_event(MdnsContext* ctx, const MdnsEvent& event)
{
    if (!ctx)
    {
        return;
    }

    std::lock_guard<std::mutex> guard(ctx->lock);
    ctx->events.push_back(event);
    while (ctx->events.size() > 256)
    {
        ctx->events.pop_front();
    }
}

std::vector<std::pair<std::string, std::string>> parse_txt_pairs(const std::string& text)
{
    std::vector<std::pair<std::string, std::string>> result;
    size_t start = 0;
    while (start < text.size())
    {
        size_t end = text.find_first_of(";\r\n", start);
        if (end == std::string::npos)
        {
            end = text.size();
        }

        std::string item = text.substr(start, end - start);
        size_t eq = item.find('=');
        if (eq != std::string::npos && eq > 0)
        {
            result.emplace_back(item.substr(0, eq), item.substr(eq + 1));
        }
        else if (!item.empty())
        {
            result.emplace_back(item, std::string());
        }

        start = end + 1;
    }
    return result;
}

std::string txt_record_to_string(uint16_t len, const unsigned char* data)
{
    if (!data || len == 0)
    {
        return std::string();
    }

    std::ostringstream out;
    uint16_t pos = 0;
    bool first = true;
    while (pos < len)
    {
        uint8_t item_len = data[pos++];
        if (pos + item_len > len)
        {
            break;
        }

        if (!first)
        {
            out << ';';
        }
        first = false;
        out.write(reinterpret_cast<const char*>(data + pos), item_len);
        pos = static_cast<uint16_t>(pos + item_len);
    }
    return out.str();
}

MdnsEvent make_error_event(DNSServiceErrorType error)
{
    MdnsEvent event = {};
    event.type = MDNS_EVENT_ERROR;
    event.error_code = error;
    return event;
}

void DNSSD_API register_reply(
    DNSServiceRef,
    DNSServiceFlags flags,
    DNSServiceErrorType error_code,
    const char* name,
    const char* regtype,
    const char* domain,
    void* context)
{
    MdnsEvent event = {};
    event.type = error_code == kDNSServiceErr_NoError ? MDNS_EVENT_REGISTERED : MDNS_EVENT_ERROR;
    event.flags = static_cast<int32_t>(flags);
    event.error_code = error_code;
    copy_text(event.name, sizeof(event.name), name);
    copy_text(event.service_type, sizeof(event.service_type), regtype);
    copy_text(event.domain, sizeof(event.domain), domain);
    push_event(static_cast<MdnsContext*>(context), event);
}

void DNSSD_API browse_reply(
    DNSServiceRef,
    DNSServiceFlags flags,
    uint32_t interface_index,
    DNSServiceErrorType error_code,
    const char* service_name,
    const char* regtype,
    const char* reply_domain,
    void* context)
{
    MdnsEvent event = {};
    event.type = (error_code == kDNSServiceErr_NoError)
        ? ((flags & kDNSServiceFlagsAdd) ? MDNS_EVENT_SERVICE_ADD : MDNS_EVENT_SERVICE_REMOVE)
        : MDNS_EVENT_ERROR;
    event.flags = static_cast<int32_t>(flags);
    event.interface_index = static_cast<int32_t>(interface_index);
    event.error_code = error_code;
    copy_text(event.name, sizeof(event.name), service_name);
    copy_text(event.service_type, sizeof(event.service_type), regtype);
    copy_text(event.domain, sizeof(event.domain), reply_domain);
    push_event(static_cast<MdnsContext*>(context), event);
}

void DNSSD_API resolve_reply(
    DNSServiceRef,
    DNSServiceFlags flags,
    uint32_t interface_index,
    DNSServiceErrorType error_code,
    const char* fullname,
    const char* hosttarget,
    uint16_t port,
    uint16_t txt_len,
    const unsigned char* txt_record,
    void* context)
{
    MdnsEvent event = {};
    event.type = error_code == kDNSServiceErr_NoError ? MDNS_EVENT_RESOLVED : MDNS_EVENT_ERROR;
    event.flags = static_cast<int32_t>(flags);
    event.interface_index = static_cast<int32_t>(interface_index);
    event.error_code = error_code;
    copy_text(event.name, sizeof(event.name), fullname);
    copy_text(event.host, sizeof(event.host), hosttarget);
    event.port = ntohs(port);
    std::string txt = txt_record_to_string(txt_len, txt_record);
    copy_text(event.txt, sizeof(event.txt), txt.c_str());
    push_event(static_cast<MdnsContext*>(context), event);
}

void DNSSD_API address_reply(
    DNSServiceRef,
    DNSServiceFlags flags,
    uint32_t interface_index,
    DNSServiceErrorType error_code,
    const char* hostname,
    const struct sockaddr* address,
    uint32_t,
    void* context)
{
    MdnsEvent event = {};
    event.type = error_code == kDNSServiceErr_NoError ? MDNS_EVENT_ADDRESS : MDNS_EVENT_ERROR;
    event.flags = static_cast<int32_t>(flags);
    event.interface_index = static_cast<int32_t>(interface_index);
    event.error_code = error_code;
    copy_text(event.host, sizeof(event.host), hostname);

    if (address && error_code == kDNSServiceErr_NoError)
    {
        if (address->sa_family == AF_INET)
        {
            const sockaddr_in* addr = reinterpret_cast<const sockaddr_in*>(address);
            InetNtopA(AF_INET, const_cast<IN_ADDR*>(&addr->sin_addr), event.address, sizeof(event.address));
        }
        else if (address->sa_family == AF_INET6)
        {
            const sockaddr_in6* addr = reinterpret_cast<const sockaddr_in6*>(address);
            InetNtopA(AF_INET6, const_cast<IN6_ADDR*>(&addr->sin6_addr), event.address, sizeof(event.address));
        }
    }

    push_event(static_cast<MdnsContext*>(context), event);
}

int process_ref(DNSServiceRef ref, int32_t timeout_ms)
{
    if (!ref)
    {
        return kDNSServiceErr_BadReference;
    }

    int fd = DNSServiceRefSockFD(ref);
    if (fd < 0)
    {
        return kDNSServiceErr_BadReference;
    }

    fd_set read_fds;
    FD_ZERO(&read_fds);
    FD_SET(static_cast<SOCKET>(fd), &read_fds);

    timeval tv = {};
    tv.tv_sec = timeout_ms / 1000;
    tv.tv_usec = (timeout_ms % 1000) * 1000;
    int ready = select(fd + 1, &read_fds, nullptr, nullptr, timeout_ms < 0 ? nullptr : &tv);
    if (ready > 0 && FD_ISSET(fd, &read_fds))
    {
        return DNSServiceProcessResult(ref);
    }
    if (ready == 0)
    {
        return kDNSServiceErr_Timeout;
    }
    return WSAGetLastError();
}

std::wstring event_to_wide(const MdnsEvent& event)
{
    std::wostringstream out;
    out << L"type=" << event.type
        << L", error=" << event.error_code
        << L", if=" << event.interface_index;

    std::wstring name = utf8_to_wide(event.name);
    std::wstring service_type = utf8_to_wide(event.service_type);
    std::wstring domain = utf8_to_wide(event.domain);
    std::wstring host = utf8_to_wide(event.host);
    std::wstring address = utf8_to_wide(event.address);
    std::wstring txt = utf8_to_wide(event.txt);

    if (!name.empty()) out << L", name=" << name;
    if (!service_type.empty()) out << L", type=" << service_type;
    if (!domain.empty()) out << L", domain=" << domain;
    if (!host.empty()) out << L", host=" << host;
    if (!address.empty()) out << L", address=" << address;
    if (event.port) out << L", port=" << event.port;
    if (!txt.empty()) out << L", txt=" << txt;
    return out.str();
}
}

BOOL APIENTRY DllMain(HMODULE, DWORD reason, LPVOID)
{
    if (reason == DLL_PROCESS_ATTACH)
    {
        WSADATA data = {};
        WSAStartup(MAKEWORD(2, 2), &data);
    }
    else if (reason == DLL_PROCESS_DETACH)
    {
        WSACleanup();
    }
    return TRUE;
}

int32_t MDNS_BRIDGE_CALL mdns_last_error(void)
{
    return g_last_error;
}

int32_t MDNS_BRIDGE_CALL mdns_error_text(int32_t error_code, wchar_t* buffer, int32_t buffer_chars)
{
    copy_wide(buffer, buffer_chars, error_text(error_code));
    return 0;
}

const wchar_t* MDNS_BRIDGE_CALL mdns_error_text_ptr(int32_t error_code)
{
    g_text_result = error_text(error_code);
    return g_text_result.c_str();
}

MdnsHandle MDNS_BRIDGE_CALL mdns_create(void)
{
    set_last_error(0);
    return new (std::nothrow) MdnsContext();
}

void MDNS_BRIDGE_CALL mdns_destroy(MdnsHandle handle)
{
    mdns_close(handle);
    delete static_cast<MdnsContext*>(handle);
}

int32_t MDNS_BRIDGE_CALL mdns_close(MdnsHandle handle)
{
    MdnsContext* ctx = static_cast<MdnsContext*>(handle);
    if (!ctx)
    {
        set_last_error(kDNSServiceErr_BadReference);
        return kDNSServiceErr_BadReference;
    }

    if (ctx->register_ref)
    {
        DNSServiceRefDeallocate(ctx->register_ref);
        ctx->register_ref = nullptr;
    }
    if (ctx->browse_ref)
    {
        DNSServiceRefDeallocate(ctx->browse_ref);
        ctx->browse_ref = nullptr;
    }
    for (Operation* op : ctx->one_shot_refs)
    {
        if (op && op->ref)
        {
            DNSServiceRefDeallocate(op->ref);
        }
        delete op;
    }
    ctx->one_shot_refs.clear();

    set_last_error(0);
    return 0;
}

int32_t MDNS_BRIDGE_CALL mdns_poll(MdnsHandle handle, int32_t timeout_ms)
{
    MdnsContext* ctx = static_cast<MdnsContext*>(handle);
    if (!ctx)
    {
        set_last_error(kDNSServiceErr_BadReference);
        return kDNSServiceErr_BadReference;
    }

    int32_t result = kDNSServiceErr_Timeout;
    if (ctx->register_ref)
    {
        int32_t rc = process_ref(ctx->register_ref, timeout_ms);
        if (rc != kDNSServiceErr_Timeout)
        {
            result = rc;
        }
    }
    if (ctx->browse_ref)
    {
        int32_t rc = process_ref(ctx->browse_ref, timeout_ms);
        if (rc != kDNSServiceErr_Timeout)
        {
            result = rc;
        }
    }

    for (auto it = ctx->one_shot_refs.begin(); it != ctx->one_shot_refs.end();)
    {
        Operation* op = *it;
        int32_t rc = op && op->ref ? process_ref(op->ref, timeout_ms) : kDNSServiceErr_BadReference;
        if (rc == kDNSServiceErr_NoError)
        {
            result = rc;
            DNSServiceRefDeallocate(op->ref);
            delete op;
            it = ctx->one_shot_refs.erase(it);
        }
        else
        {
            if (rc != kDNSServiceErr_Timeout)
            {
                result = rc;
            }
            ++it;
        }
    }

    set_last_error(result == kDNSServiceErr_Timeout ? 0 : result);
    return result;
}

int32_t MDNS_BRIDGE_CALL mdns_next_event(MdnsHandle handle, MdnsEvent* event_out)
{
    MdnsContext* ctx = static_cast<MdnsContext*>(handle);
    if (!ctx || !event_out)
    {
        set_last_error(kDNSServiceErr_BadParam);
        return 0;
    }

    std::lock_guard<std::mutex> guard(ctx->lock);
    if (ctx->events.empty())
    {
        return 0;
    }

    *event_out = ctx->events.front();
    ctx->events.pop_front();
    return 1;
}

int32_t MDNS_BRIDGE_CALL mdns_event_to_text(const MdnsEvent* event_in, wchar_t* buffer, int32_t buffer_chars)
{
    if (!event_in)
    {
        set_last_error(kDNSServiceErr_BadParam);
        return kDNSServiceErr_BadParam;
    }

    copy_wide(buffer, buffer_chars, event_to_wide(*event_in));
    set_last_error(0);
    return 0;
}

int32_t MDNS_BRIDGE_CALL mdns_pop_event(MdnsHandle handle)
{
    MdnsContext* ctx = static_cast<MdnsContext*>(handle);
    if (!ctx)
    {
        set_last_error(kDNSServiceErr_BadReference);
        return MDNS_EVENT_NONE;
    }

    std::lock_guard<std::mutex> guard(ctx->lock);
    if (ctx->events.empty())
    {
        memset(&g_current_event, 0, sizeof(g_current_event));
        return MDNS_EVENT_NONE;
    }

    g_current_event = ctx->events.front();
    ctx->events.pop_front();
    return g_current_event.type;
}

int32_t MDNS_BRIDGE_CALL mdns_current_event_error(void)
{
    return g_current_event.error_code;
}

int32_t MDNS_BRIDGE_CALL mdns_current_event_interface_index(void)
{
    return g_current_event.interface_index;
}

int32_t MDNS_BRIDGE_CALL mdns_current_event_port(void)
{
    return g_current_event.port;
}

const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_text(void)
{
    g_text_result = event_to_wide(g_current_event);
    return g_text_result.c_str();
}

const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_name(void)
{
    g_text_result = utf8_to_wide(g_current_event.name);
    return g_text_result.c_str();
}

const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_service_type(void)
{
    g_text_result = utf8_to_wide(g_current_event.service_type);
    return g_text_result.c_str();
}

const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_domain(void)
{
    g_text_result = utf8_to_wide(g_current_event.domain);
    return g_text_result.c_str();
}

const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_host(void)
{
    g_text_result = utf8_to_wide(g_current_event.host);
    return g_text_result.c_str();
}

const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_address(void)
{
    g_text_result = utf8_to_wide(g_current_event.address);
    return g_text_result.c_str();
}

const wchar_t* MDNS_BRIDGE_CALL mdns_current_event_txt(void)
{
    g_text_result = utf8_to_wide(g_current_event.txt);
    return g_text_result.c_str();
}

int32_t MDNS_BRIDGE_CALL mdns_register_service(
    MdnsHandle handle,
    const wchar_t* name,
    const wchar_t* service_type,
    const wchar_t* domain,
    const wchar_t* host,
    uint16_t port,
    const wchar_t* txt_pairs)
{
    MdnsContext* ctx = static_cast<MdnsContext*>(handle);
    if (!ctx || !service_type || !*service_type || port == 0)
    {
        set_last_error(kDNSServiceErr_BadParam);
        return kDNSServiceErr_BadParam;
    }

    if (ctx->register_ref)
    {
        DNSServiceRefDeallocate(ctx->register_ref);
        ctx->register_ref = nullptr;
    }

    std::string name8 = wide_to_utf8(name);
    std::string type8 = wide_to_utf8(service_type);
    std::string domain8 = wide_to_utf8(domain);
    std::string host8 = wide_to_utf8(host);
    std::string txt8 = wide_to_utf8(txt_pairs);

    TXTRecordRef txt = {};
    TXTRecordCreate(&txt, 0, nullptr);
    for (const auto& item : parse_txt_pairs(txt8))
    {
        TXTRecordSetValue(
            &txt,
            item.first.c_str(),
            static_cast<uint8_t>((std::min)(item.second.size(), static_cast<size_t>(255))),
            item.second.empty() ? nullptr : item.second.data());
    }

    DNSServiceErrorType rc = DNSServiceRegister(
        &ctx->register_ref,
        0,
        0,
        name8.empty() ? nullptr : name8.c_str(),
        type8.c_str(),
        domain8.empty() ? nullptr : domain8.c_str(),
        host8.empty() ? nullptr : host8.c_str(),
        htons(port),
        TXTRecordGetLength(&txt),
        TXTRecordGetBytesPtr(&txt),
        register_reply,
        ctx);

    TXTRecordDeallocate(&txt);
    set_last_error(rc);
    if (rc != kDNSServiceErr_NoError)
    {
        push_event(ctx, make_error_event(rc));
    }
    return rc;
}

int32_t MDNS_BRIDGE_CALL mdns_browse_services(
    MdnsHandle handle,
    const wchar_t* service_type,
    const wchar_t* domain)
{
    MdnsContext* ctx = static_cast<MdnsContext*>(handle);
    if (!ctx || !service_type || !*service_type)
    {
        set_last_error(kDNSServiceErr_BadParam);
        return kDNSServiceErr_BadParam;
    }

    if (ctx->browse_ref)
    {
        DNSServiceRefDeallocate(ctx->browse_ref);
        ctx->browse_ref = nullptr;
    }

    std::string type8 = wide_to_utf8(service_type);
    std::string domain8 = wide_to_utf8(domain);
    DNSServiceErrorType rc = DNSServiceBrowse(
        &ctx->browse_ref,
        0,
        0,
        type8.c_str(),
        domain8.empty() ? nullptr : domain8.c_str(),
        browse_reply,
        ctx);

    set_last_error(rc);
    if (rc != kDNSServiceErr_NoError)
    {
        push_event(ctx, make_error_event(rc));
    }
    return rc;
}

int32_t MDNS_BRIDGE_CALL mdns_resolve_service(
    MdnsHandle handle,
    int32_t interface_index,
    const wchar_t* name,
    const wchar_t* service_type,
    const wchar_t* domain)
{
    MdnsContext* ctx = static_cast<MdnsContext*>(handle);
    if (!ctx || !name || !*name || !service_type || !*service_type || !domain || !*domain)
    {
        set_last_error(kDNSServiceErr_BadParam);
        return kDNSServiceErr_BadParam;
    }

    std::string name8 = wide_to_utf8(name);
    std::string type8 = wide_to_utf8(service_type);
    std::string domain8 = wide_to_utf8(domain);

    Operation* op = new (std::nothrow) Operation();
    if (!op)
    {
        set_last_error(kDNSServiceErr_NoMemory);
        return kDNSServiceErr_NoMemory;
    }

    DNSServiceErrorType rc = DNSServiceResolve(
        &op->ref,
        0,
        static_cast<uint32_t>(interface_index),
        name8.c_str(),
        type8.c_str(),
        domain8.c_str(),
        resolve_reply,
        ctx);

    if (rc == kDNSServiceErr_NoError)
    {
        ctx->one_shot_refs.push_back(op);
    }
    else
    {
        delete op;
        push_event(ctx, make_error_event(rc));
    }

    set_last_error(rc);
    return rc;
}
