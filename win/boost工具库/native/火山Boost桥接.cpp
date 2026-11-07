// =====================================================================
//  火山视窗 Boost 工具库 —— 原生桥接层实现
//  编译：cl /LD /EHsc /std:c++17 /utf-8 /O2 /MD /DUNICODE /D_UNICODE ...
//
//  设计约定（与火山侧一一对应，务必保持一致）：
//   1. 文本一律 UTF-16（wchar_t），绝不跨 DLL 边界传递堆内存；
//      返回的 const wchar_t* 指向线程局部缓冲，下一次同线程调用前有效，
//      火山侧拿到后立即拷入“文本型”，因此不存在释放责任问题。
//   2. 句柄统一为 intptr_t，0 表示无效句柄。
//   3. 失败不抛异常（异常在 DLL 内被拦截），返回哨兵值，并把原因写入
//      “最后错误”，火山侧通过 FB_error_text 读取中文错误说明。
//   4. C ABI 导出名保持 ASCII（跨编译器符号名一致），
//      面向用户的中文名称由火山侧 .wsv 提供。
// =====================================================================

#include "VolcanoBoostBridge.h"

#include <string>
#include <vector>
#include <map>
#include <memory>
#include <mutex>
#include <sstream>
#include <iomanip>
#include <locale>
#include <algorithm>
#include <cmath>
#include <climits>
#include <cstdint>
#include <random>

#include <boost/version.hpp>
#include <boost/algorithm/string.hpp>
#include <boost/algorithm/string/trim_all.hpp>
#include <boost/range/algorithm/unique.hpp>
#include <boost/container/flat_map.hpp>
#include <boost/lexical_cast.hpp>
#include <boost/format.hpp>
#include <boost/regex.hpp>
#include <boost/date_time/gregorian/gregorian.hpp>
#include <boost/date_time/gregorian/gregorian_io.hpp>
#include <boost/date_time/posix_time/posix_time.hpp>
#include <boost/date_time/posix_time/posix_time_io.hpp>
#include <boost/crc.hpp>
#include <boost/uuid/uuid.hpp>
#include <boost/uuid/uuid_io.hpp>
#include <boost/uuid/random_generator.hpp>
#include <boost/accumulators/accumulators.hpp>
#include <boost/accumulators/statistics/stats.hpp>
#include <boost/accumulators/statistics/mean.hpp>
#include <boost/accumulators/statistics/variance.hpp>
#include <boost/multiprecision/cpp_int.hpp>
#include <boost/multiprecision/cpp_dec_float.hpp>
#include <boost/property_tree/ptree.hpp>
#include <boost/property_tree/json_parser.hpp>
#include <boost/property_tree/ini_parser.hpp>
#include <boost/property_tree/xml_parser.hpp>
#include <boost/random/mersenne_twister.hpp>
#include <boost/random/uniform_int_distribution.hpp>
#include <boost/random/uniform_real_distribution.hpp>
#include <boost/random/normal_distribution.hpp>

// v1.3：文件系统（需要把 filesystem 的 10 个 .cpp 一起编译，见 build_bridge.bat）
#include <boost/filesystem.hpp>
// v1.3：Base64 走序列化迭代器（头文件即可用，不需要编译 boost 库）
#include <boost/archive/iterators/base64_from_binary.hpp>
#include <boost/archive/iterators/binary_from_base64.hpp>
#include <boost/archive/iterators/transform_width.hpp>
#include <boost/system/error_code.hpp>
#include <ctime>

// v1.4：哈希。boost/uuid/detail/sha1.hpp 与 md5.hpp 是 boost 的「内部实现头」，
// 不在公开 API 的兼容承诺内；选它们是因为完全内联、不产生任何链接依赖，
// 因此整份实现只依赖头文件本身的文本（详见 README 第十节）。
#include <boost/uuid/detail/sha1.hpp>
#include <boost/uuid/detail/md5.hpp>
#include <cstdio>

// v1.5：文本文件的编码转换要靠 MultiByteToWideChar / WideCharToMultiByte，
// 所以这一轮才真正需要 <windows.h>（此前的实现全部只依赖 CRT）。
// WIN32_LEAN_AND_MEAN 与 NOMINMAX 已在 build_bridge.bat 里定义，
// 因此不会带进 winsock 头，也不会出现和 std::min / std::max 冲突的宏。
// <sys/stat.h> 只为 _wstat64 服务：追加写之前要先知道文件是不是空的。
#include <windows.h>
#include <sys/stat.h>
// v1.5：位集（纯头文件，无需编译 boost 库）。
#include <boost/dynamic_bitset.hpp>

namespace {

// ---------- 线程局部的返回缓冲与错误信息 ----------
thread_local std::wstring 返回缓冲;
thread_local std::wstring 错误缓冲;
thread_local bool 上次成功 = true;

// 把结果放进线程局部缓冲并交出指针（调用方必须立即拷贝）
const wchar_t* 交出文本(const std::wstring& 文本)
{
    返回缓冲 = 文本;
    return 返回缓冲.c_str();
}

const wchar_t* 记录错误(const wchar_t* 说明)
{
    错误缓冲 = (说明 != nullptr) ? 说明 : L"未知错误";
    上次成功 = false;
    return L"";
}

void 清空错误()
{
    错误缓冲.clear();
}

// 安全取宽文本（空指针按空文本处理）
std::wstring 取文本(const wchar_t* 源)
{
    return (源 != nullptr) ? std::wstring(源) : std::wstring();
}

// ---------- 通用句柄表 ----------
// 所有“需要保存状态”的对象（分词结果、格式化器、数列、大整数、JSON 树）
// 都放进对应句柄表，火山侧只持有整数句柄，避免跨语言对象生命周期问题。
template <typename 对象类型>
class 句柄表
{
public:
    intptr_t 加入(std::shared_ptr<对象类型> 对象)
    {
        std::lock_guard<std::mutex> 锁(互斥量);
        intptr_t 编号 = 下一个编号++;
        if (编号 == 0)                       // 理论上不会发生，防御性处理
            编号 = 下一个编号++;
        表[编号] = 对象;
        return 编号;
    }

    std::shared_ptr<对象类型> 取(intptr_t 编号)
    {
        std::lock_guard<std::mutex> 锁(互斥量);
        auto 位置 = 表.find(编号);
        if (位置 == 表.end())
            return nullptr;
        return 位置->second;
    }

    bool 删(intptr_t 编号)
    {
        std::lock_guard<std::mutex> 锁(互斥量);
        return 表.erase(编号) > 0;
    }

private:
    std::mutex 互斥量;
    std::map<intptr_t, std::shared_ptr<对象类型>> 表;
    intptr_t 下一个编号 = 1;
};

struct 分词结果 { std::vector<std::wstring> 项; };
struct 格式化器 { boost::wformat 格式; explicit 格式化器(const std::wstring& 文本) : 格式(文本) {} };
struct 数列   { std::vector<double> 值; };

typedef boost::multiprecision::cpp_int 大整数类型;
typedef boost::property_tree::wptree  属性树类型;

// v1.2：高精度十进制小数（50 位十进制有效数字，boost/multiprecision）。
typedef boost::multiprecision::cpp_dec_float_50 高精度类型;

句柄表<分词结果> 分词句柄表;
句柄表<格式化器> 格式化句柄表;
句柄表<数列>     数列句柄表;
句柄表<大整数类型> 大整数句柄表;
句柄表<属性树类型> 属性树句柄表;

// v1.1：INI 文档与 JSON 共用同一种属性树类型，但使用独立的句柄表，
// 这样两边的句柄编号互不干扰，误用也只会得到“句柄无效”而不是读到别的文档。
句柄表<属性树类型> INI句柄表;

// v1.2：XML 文档同样使用独立的句柄表（理由与 INI 相同）。
句柄表<属性树类型> XML句柄表;

// v1.2：高精度小数的句柄表。
句柄表<高精度类型> 高精度句柄表;

// v1.1：名称与数值的双向映射表（boost::container::flat_map）。
// 「顺序」保存名称的加入次序，供按序号取名使用；重复赋值同一个名称不改变次序。
struct 映射表数据
{
    boost::container::flat_map<std::wstring, int64_t> 名到值;
    boost::container::flat_map<int64_t, std::wstring> 值到名;
    std::vector<std::wstring> 顺序;
};

句柄表<映射表数据> 映射表句柄表;

// ---------- 日期与时间辅助 ----------
// 日期在跨边界时压成一个 int64：yyyymmdd，0 表示无效日期。
int64_t 压缩日期(const boost::gregorian::date& 日期)
{
    if (日期.is_not_a_date())
        return 0;
    return (int64_t)日期.year() * 10000 + (int64_t)日期.month() * 100 + (int64_t)日期.day();
}

boost::gregorian::date 解压日期(int64_t 压缩值)
{
    if (压缩值 <= 0)
        return boost::gregorian::date();
    int 年 = (int)(压缩值 / 10000);
    int 月 = (int)((压缩值 / 100) % 100);
    int 日 = (int)(压缩值 % 100);
    try {
        return boost::gregorian::date(年, 月, 日);
    }
    catch (...) {
        return boost::gregorian::date();
    }
}

boost::posix_time::ptime 毫秒转时间点(int64_t 毫秒)
{
    static const boost::posix_time::ptime 纪元(boost::gregorian::date(1970, 1, 1));
    return 纪元 + boost::posix_time::milliseconds(毫秒);
}

int64_t 时间点转毫秒(const boost::posix_time::ptime& 时间点)
{
    static const boost::posix_time::ptime 纪元(boost::gregorian::date(1970, 1, 1));
    return (时间点 - 纪元).total_milliseconds();
}

std::wstring 格式化日期(const boost::gregorian::date& 日期, const std::wstring& 格式串)
{
    std::wstringstream 流;
    流.imbue(std::locale(std::locale::classic(),
             new boost::gregorian::wdate_facet(格式串.c_str())));
    流 << 日期;
    return 流.str();
}

std::wstring 格式化时间(const boost::posix_time::ptime& 时间点, const std::wstring& 格式串)
{
    std::wstringstream 流;
    流.imbue(std::locale(std::locale::classic(),
             new boost::posix_time::wtime_facet(格式串.c_str())));
    流 << 时间点;
    return 流.str();
}

// ---------- 大整数与文本互转 ----------
std::string 窄化(const std::wstring& 宽文本)
{
    std::string 结果;
    结果.reserve(宽文本.size());
    for (size_t 序 = 0; 序 < 宽文本.size(); ++序)
    {
        wchar_t 字 = 宽文本[序];
        结果.push_back((字 < 128) ? (char)字 : '?');
    }
    return 结果;
}

// 宽文本转 UTF-8 字节串（CRC32、Base64、十六进制等按字节计算的场合使用）。
// 必须按**码点**编码，不能按 UTF-16 码元逐个编码：
//   1) 代理对（高 D800-DBFF + 低 DC00-DFFF）要合成一个 U+10000..U+10FFFF 的码点，
//      输出 4 字节（F0-F4 领头）。逐码元编码得到的是 CESU-8：
//      "😀" 会变成 ED A0 BD ED B8 80，而解码侧按严格 UTF-8 校验会拒收代理区码点，
//      等于"自己编出来的字节自己解不回来"（QA P1 就是这个）。
//   2) 孤立代理（不成对）不是合法码点，统一输出 U+FFFD 的 EF BF BD，
//      保证任何输入都不会产出非法字节序列。
std::string 转为UTF8(const std::wstring& 宽文本)
{
    std::string 结果;
    结果.reserve(宽文本.size() * 3);
    for (size_t 序 = 0; 序 < 宽文本.size(); ++序)
    {
        unsigned int 码点 = (unsigned int)宽文本[序];
        if (码点 >= 0xD800 && 码点 <= 0xDBFF)
        {
            // 高代理：只有紧跟一个低代理才构成合法字符
            bool 成对 = false;
            if (序 + 1 < 宽文本.size())
            {
                unsigned int 低位 = (unsigned int)宽文本[序 + 1];
                if (低位 >= 0xDC00 && 低位 <= 0xDFFF)
                {
                    码点 = 0x10000u + ((码点 - 0xD800u) << 10) + (低位 - 0xDC00u);
                    ++序;                     // 低代理已被吃掉
                    成对 = true;
                }
            }
            if (!成对)
                码点 = 0xFFFDu;               // 孤立高代理 → 替换字符
        }
        else if (码点 >= 0xDC00 && 码点 <= 0xDFFF)
        {
            码点 = 0xFFFDu;                   // 孤立低代理 → 替换字符
        }
        else if (码点 > 0x10FFFF)
        {
            码点 = 0xFFFDu;                   // 超出 Unicode 范围（wchar_t 为 16 位时不可达，防御性保留）
        }

        if (码点 < 0x80)
        {
            结果.push_back((char)码点);
        }
        else if (码点 < 0x800)
        {
            结果.push_back((char)(0xC0 | (码点 >> 6)));
            结果.push_back((char)(0x80 | (码点 & 0x3F)));
        }
        else if (码点 < 0x10000)
        {
            结果.push_back((char)(0xE0 | (码点 >> 12)));
            结果.push_back((char)(0x80 | ((码点 >> 6) & 0x3F)));
            结果.push_back((char)(0x80 | (码点 & 0x3F)));
        }
        else
        {
            结果.push_back((char)(0xF0 | (码点 >> 18)));
            结果.push_back((char)(0x80 | ((码点 >> 12) & 0x3F)));
            结果.push_back((char)(0x80 | ((码点 >> 6) & 0x3F)));
            结果.push_back((char)(0x80 | (码点 & 0x3F)));
        }
    }
    return 结果;
}

std::wstring 宽化(const std::string& 窄文本)
{
    std::wstring 结果;
    结果.reserve(窄文本.size());
    for (size_t 序 = 0; 序 < 窄文本.size(); ++序)
        结果.push_back((wchar_t)(unsigned char)窄文本[序]);
    return 结果;
}

} // namespace

// =====================================================================
//  版本与错误
// =====================================================================
extern "C" const wchar_t* FB_version(void)
{
    static std::wstring 版本文本;
    if (版本文本.empty())
    {
        std::wstringstream 流;
        流 << L"火山Boost工具库 1.5.0 （boost " << BOOST_LIB_VERSION << L"）";
        版本文本 = 流.str();
    }
    return 版本文本.c_str();
}

extern "C" const wchar_t* FB_error_text(void)
{
    return 错误缓冲.c_str();
}

extern "C" int FB_last_ok(void)
{
    return 上次成功 ? 1 : 0;
}

// =====================================================================
//  一、文字工具（boost/algorithm/string）
// =====================================================================
extern "C" const wchar_t* FB_text_trim(const wchar_t* s)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    trim(结果);
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_trim_left(const wchar_t* s)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    trim_left(结果);
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_trim_right(const wchar_t* s)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    trim_right(结果);
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_trim_chars(const wchar_t* s, const wchar_t* chars)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    if (chars == nullptr || *chars == L'\0')
        trim(结果);
    else
        trim_if(结果, is_any_of(取文本(chars)));
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_upper(const wchar_t* s)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    to_upper(结果);
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_lower(const wchar_t* s)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    to_lower(结果);
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_replace_all(const wchar_t* s, const wchar_t* find, const wchar_t* rep)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    if (find != nullptr && *find != L'\0')
        replace_all(结果, 取文本(find), 取文本(rep));
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_replace_first(const wchar_t* s, const wchar_t* find, const wchar_t* rep)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    if (find != nullptr && *find != L'\0')
        replace_first(结果, 取文本(find), 取文本(rep));
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_erase_all(const wchar_t* s, const wchar_t* find)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    if (find != nullptr && *find != L'\0')
        erase_all(结果, 取文本(find));
    return 交出文本(结果);
}

extern "C" int FB_text_icontains(const wchar_t* s, const wchar_t* find)
{
    using namespace boost::algorithm;
    return icontains(取文本(s), 取文本(find)) ? 1 : 0;
}

extern "C" int FB_text_istarts_with(const wchar_t* s, const wchar_t* find)
{
    using namespace boost::algorithm;
    return istarts_with(取文本(s), 取文本(find)) ? 1 : 0;
}

extern "C" int FB_text_iends_with(const wchar_t* s, const wchar_t* find)
{
    using namespace boost::algorithm;
    return iends_with(取文本(s), 取文本(find)) ? 1 : 0;
}

extern "C" int FB_text_iequals(const wchar_t* a, const wchar_t* b)
{
    using namespace boost::algorithm;
    return iequals(取文本(a), 取文本(b)) ? 1 : 0;
}

extern "C" int FB_text_index_of(const wchar_t* s, const wchar_t* find)
{
    std::wstring 原文本 = 取文本(s);
    std::wstring 目标 = 取文本(find);
    if (目标.empty())
        return 0;
    size_t 位置 = 原文本.find(目标);
    if (位置 == std::wstring::npos)
        return -1;
    return (int)位置;
}

// =====================================================================
//  二、分词（boost/algorithm/string split）
// =====================================================================
extern "C" intptr_t FB_split_create(const wchar_t* s, const wchar_t* sep)
{
    using namespace boost::algorithm;
    std::wstring 分隔符 = 取文本(sep);
    std::shared_ptr<分词结果> 结果(new 分词结果());
    std::wstring 原文本 = 取文本(s);
    if (分隔符.empty())
        结果->项.push_back(原文本);
    else
        split(结果->项, 原文本, is_any_of(分隔符), token_compress_off);
    return 分词句柄表.加入(结果);
}

extern "C" int FB_split_count(intptr_t h)
{
    std::shared_ptr<分词结果> 结果 = 分词句柄表.取(h);
    if (!结果)
        return -1;
    return (int)结果->项.size();
}

extern "C" const wchar_t* FB_split_get(intptr_t h, int index)
{
    std::shared_ptr<分词结果> 结果 = 分词句柄表.取(h);
    if (!结果)
        return 记录错误(L"分词句柄无效");
    if (index < 0 || index >= (int)结果->项.size())
        return 记录错误(L"分词序号越界");
    return 结果->项[(size_t)index].c_str();
}

extern "C" const wchar_t* FB_split_join(intptr_t h, const wchar_t* sep)
{
    std::shared_ptr<分词结果> 结果 = 分词句柄表.取(h);
    if (!结果)
        return 记录错误(L"分词句柄无效");
    std::wstring 连接符 = 取文本(sep);
    std::wstring 合并文本;
    for (size_t 序 = 0; 序 < 结果->项.size(); ++序)
    {
        if (序 > 0)
            合并文本 += 连接符;
        合并文本 += 结果->项[序];
    }
    return 交出文本(合并文本);
}

extern "C" int FB_split_free(intptr_t h)
{
    return 分词句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  三、词法转换（boost/lexical_cast）
// =====================================================================
extern "C" int64_t FB_text_to_int64(const wchar_t* s)
{
    清空错误();
    try
    {
        上次成功 = true;
        return boost::lexical_cast<int64_t>(取文本(s));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"整数转换失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return (int64_t)LLONG_MIN;
    }
}

extern "C" double FB_text_to_double(const wchar_t* s)
{
    清空错误();
    try
    {
        上次成功 = true;
        return boost::lexical_cast<double>(取文本(s));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"小数转换失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return std::nan("");
    }
}

extern "C" const wchar_t* FB_number_to_text(double v, int digits)
{
    if (std::isnan(v))
        return L"";
    std::wstringstream 流;
    if (digits < 0)
        流 << v;
    else
        流 << std::fixed << std::setprecision(digits) << v;
    return 交出文本(流.str());
}

// =====================================================================
//  四、格式化（boost/format）
// =====================================================================
extern "C" intptr_t FB_fmt_create(const wchar_t* fmt)
{
    try
    {
        std::shared_ptr<格式化器> 对象(new 格式化器(取文本(fmt)));
        return 格式化句柄表.加入(对象);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"格式串无效：";
        错误缓冲 += 宽化(异常.what());
        return 0;
    }
}

extern "C" int FB_fmt_add_text(intptr_t h, const wchar_t* v)
{
    std::shared_ptr<格式化器> 对象 = 格式化句柄表.取(h);
    if (!对象)
        return 0;
    try
    {
        对象->格式 % 取文本(v);
        return 1;
    }
    catch (...) { return 0; }
}

extern "C" int FB_fmt_add_int(intptr_t h, int64_t v)
{
    std::shared_ptr<格式化器> 对象 = 格式化句柄表.取(h);
    if (!对象)
        return 0;
    try
    {
        对象->格式 % v;
        return 1;
    }
    catch (...) { return 0; }
}

extern "C" int FB_fmt_add_double(intptr_t h, double v, int digits)
{
    std::shared_ptr<格式化器> 对象 = 格式化句柄表.取(h);
    if (!对象)
        return 0;
    try
    {
        std::wstringstream 流;
        if (digits < 0)
            流 << v;
        else
            流 << std::fixed << std::setprecision(digits) << v;
        对象->格式 % 流.str();
        return 1;
    }
    catch (...) { return 0; }
}

extern "C" const wchar_t* FB_fmt_result(intptr_t h)
{
    std::shared_ptr<格式化器> 对象 = 格式化句柄表.取(h);
    if (!对象)
        return 记录错误(L"格式化句柄无效");
    try
    {
        std::wstring 结果 = 对象->格式.str();
        return 交出文本(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"格式化失败（参数个数或类型不符）：";
        错误缓冲 += 宽化(异常.what());
        return L"";
    }
}

extern "C" int FB_fmt_free(intptr_t h)
{
    return 格式化句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  五、正则（boost/regex，宽字符 wregex）
// =====================================================================
namespace {
bool 编译正则(const std::wstring& 模式, boost::wregex& 正则)
{
    try
    {
        正则.assign(模式, boost::regex::perl);   // 默认区分大小写
        return true;
    }
    catch (const boost::regex_error& 异常)
    {
        错误缓冲 = L"正则表达式有误：";
        错误缓冲 += 宽化(异常.what());
        return false;
    }
}
}

extern "C" int FB_regex_match(const wchar_t* s, const wchar_t* pat)
{
    boost::wregex 正则;
    if (!编译正则(取文本(pat), 正则))
        return -1;
    return boost::regex_match(取文本(s), 正则) ? 1 : 0;
}

extern "C" int FB_regex_search(const wchar_t* s, const wchar_t* pat)
{
    boost::wregex 正则;
    if (!编译正则(取文本(pat), 正则))
        return -1;
    return boost::regex_search(取文本(s), 正则) ? 1 : 0;
}

extern "C" const wchar_t* FB_regex_find(const wchar_t* s, const wchar_t* pat, int group)
{
    boost::wregex 正则;
    if (!编译正则(取文本(pat), 正则))
        return L"";
    std::wstring 原文本 = 取文本(s);
    boost::wsmatch 匹配;
    if (!boost::regex_search(原文本, 匹配, 正则))
        return L"";
    if (group < 0 || group >= (int)匹配.size())
        return L"";
    return 交出文本(匹配[(size_t)group].str());
}

extern "C" const wchar_t* FB_regex_replace(const wchar_t* s, const wchar_t* pat, const wchar_t* rep)
{
    boost::wregex 正则;
    if (!编译正则(取文本(pat), 正则))
        return L"";
    try
    {
        std::wstring 结果 = boost::regex_replace(取文本(s), 正则, 取文本(rep));
        return 交出文本(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"正则替换失败：";
        错误缓冲 += 宽化(异常.what());
        return L"";
    }
}

extern "C" intptr_t FB_regex_split(const wchar_t* s, const wchar_t* pat)
{
    boost::wregex 正则;
    if (!编译正则(取文本(pat), 正则))
        return 0;
    std::shared_ptr<分词结果> 结果(new 分词结果());
    std::wstring 原文本 = 取文本(s);
    boost::wsregex_token_iterator 起点(原文本.begin(), 原文本.end(), 正则, -1);
    boost::wsregex_token_iterator 终点;
    for (; 起点 != 终点; ++起点)
        结果->项.push_back(起点->str());
    return 分词句柄表.加入(结果);
}

// =====================================================================
//  六、日期（boost/gregorian）
// =====================================================================
extern "C" int64_t FB_date_today(void)
{
    return 压缩日期(boost::gregorian::day_clock::local_day());
}

extern "C" int64_t FB_date_make(int y, int m, int d)
{
    try
    {
        if (m < 1 || m > 12 || d < 1 || d > 31)
            return 0;
        return 压缩日期(boost::gregorian::date((unsigned short)y, (unsigned short)m, (unsigned short)d));
    }
    catch (...) { return 0; }
}

extern "C" const wchar_t* FB_date_text(int64_t d)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return L"";
    return 交出文本(格式化日期(日期, L"%Y-%m-%d"));
}

extern "C" int64_t FB_date_parse(const wchar_t* s)
{
    try
    {
        std::wstringstream 流(取文本(s));
        流.imbue(std::locale(std::locale::classic(),
                 new boost::gregorian::wdate_input_facet(L"%Y-%m-%d")));
        boost::gregorian::date 日期;
        流 >> 日期;
        if (流.fail())
            return 0;
        return 压缩日期(日期);
    }
    catch (...) { return 0; }
}

extern "C" int64_t FB_date_add_days(int64_t d, int days)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return 0;
    try
    {
        return 压缩日期(日期 + boost::gregorian::days(days));
    }
    catch (...) { return 0; }
}

extern "C" int FB_date_diff_days(int64_t a, int64_t b)
{
    boost::gregorian::date 甲 = 解压日期(a);
    boost::gregorian::date 乙 = 解压日期(b);
    if (甲.is_not_a_date() || 乙.is_not_a_date())
        return 0;
    return (int)(甲 - 乙).days();
}

extern "C" int FB_date_year(int64_t d)
{
    boost::gregorian::date 日期 = 解压日期(d);
    return 日期.is_not_a_date() ? 0 : (int)日期.year();
}

extern "C" int FB_date_month(int64_t d)
{
    boost::gregorian::date 日期 = 解压日期(d);
    return 日期.is_not_a_date() ? 0 : (int)日期.month();
}

extern "C" int FB_date_day(int64_t d)
{
    boost::gregorian::date 日期 = 解压日期(d);
    return 日期.is_not_a_date() ? 0 : (int)日期.day();
}

extern "C" int FB_date_weekday(int64_t d)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return -1;
    // 0 = 星期日，1 = 星期一 ... 6 = 星期六
    return (int)日期.day_of_week().as_number();
}

extern "C" int FB_date_is_leap(int y)
{
    return boost::gregorian::gregorian_calendar::is_leap_year(y) ? 1 : 0;
}

extern "C" int FB_date_days_in_month(int y, int m)
{
    if (m < 1 || m > 12)
        return 0;
    boost::gregorian::date 日期((unsigned short)y, (unsigned short)m, 1);
    return (int)boost::gregorian::gregorian_calendar::end_of_month_day(
        (unsigned short)y, (unsigned short)m);
}

extern "C" const wchar_t* FB_date_format(int64_t d, const wchar_t* fmt)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return L"";
    std::wstring 格式串 = 取文本(fmt);
    if (格式串.empty())
        格式串 = L"%Y-%m-%d";
    return 交出文本(格式化日期(日期, 格式串));
}

// =====================================================================
//  七、时间（boost/posix_time，毫秒时间戳）
// =====================================================================
extern "C" int64_t FB_time_now_ms(void)
{
    return 时间点转毫秒(boost::posix_time::microsec_clock::local_time());
}

extern "C" const wchar_t* FB_time_text(int64_t ms)
{
    return 交出文本(格式化时间(毫秒转时间点(ms), L"%Y-%m-%d %H:%M:%S"));
}

extern "C" const wchar_t* FB_time_format(int64_t ms, const wchar_t* fmt)
{
    std::wstring 格式串 = 取文本(fmt);
    if (格式串.empty())
        格式串 = L"%Y-%m-%d %H:%M:%S";
    return 交出文本(格式化时间(毫秒转时间点(ms), 格式串));
}

extern "C" int64_t FB_time_add_ms(int64_t ms, int64_t delta)
{
    return ms + delta;
}

// boost 1.86 的 time_input_facet 在解析“特殊值”时会用 convert_string_type<wchar_t,char>
// 转出一个窄串，MSVC 因此报 C4244（宽字符转窄字符可能丢数据）。这是 boost 内部实现产生的
// 无害告警（只有输入 "not-a-date-time" 这类特殊文本才会走到），在此处局部屏蔽，避免污染构建日志。
#pragma warning(push)
#pragma warning(disable : 4244)
extern "C" int64_t FB_time_from_text(const wchar_t* s)
{
    try
    {
        std::wstringstream 流(取文本(s));
        流.imbue(std::locale(std::locale::classic(),
                 new boost::posix_time::wtime_input_facet(L"%Y-%m-%d %H:%M:%S")));
        boost::posix_time::ptime 时间点;
        流 >> 时间点;
        if (流.fail())
            return 0;
        return 时间点转毫秒(时间点);
    }
    catch (...) { return 0; }
}
#pragma warning(pop)

extern "C" int FB_time_year(int64_t ms)
{
    return (int)毫秒转时间点(ms).date().year();
}

extern "C" int FB_time_month(int64_t ms)
{
    return (int)毫秒转时间点(ms).date().month();
}

extern "C" int FB_time_day(int64_t ms)
{
    return (int)毫秒转时间点(ms).date().day();
}

extern "C" int FB_time_hour(int64_t ms)
{
    return (int)毫秒转时间点(ms).time_of_day().hours();
}

extern "C" int FB_time_minute(int64_t ms)
{
    return (int)毫秒转时间点(ms).time_of_day().minutes();
}

extern "C" int FB_time_second(int64_t ms)
{
    return (int)毫秒转时间点(ms).time_of_day().seconds();
}

// =====================================================================
//  八、校验与唯一标识（boost/crc、boost/uuid）
// =====================================================================
extern "C" int64_t FB_crc32(const wchar_t* s)
{
    // 约定：对文本的 UTF-8 字节串计算 CRC32，便于和其它工具互通。
    std::string 窄文本 = 转为UTF8(取文本(s));
    boost::crc_32_type 校验器;
    校验器.process_bytes(窄文本.data(), 窄文本.size());
    return (int64_t)校验器.checksum();
}

extern "C" const wchar_t* FB_uuid_new(void)
{
    try
    {
        boost::uuids::random_generator 生成器;
        boost::uuids::uuid 标识 = 生成器();
        std::wstringstream 流;
        流 << boost::uuids::to_wstring(标识);
        return 交出文本(流.str());
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"生成唯一标识失败：";
        错误缓冲 += 宽化(异常.what());
        return L"";
    }
}

extern "C" int FB_uuid_valid(const wchar_t* s)
{
    try
    {
        std::wstringstream 流(取文本(s));
        boost::uuids::uuid 标识;
        流 >> 标识;
        return 流.fail() ? 0 : 1;
    }
    catch (...) { return 0; }
}

// =====================================================================
//  九、数值统计（boost/accumulators）
// =====================================================================
extern "C" intptr_t FB_series_create(void)
{
    std::shared_ptr<数列> 对象(new 数列());
    return 数列句柄表.加入(对象);
}

extern "C" int FB_series_push(intptr_t h, double v)
{
    std::shared_ptr<数列> 对象 = 数列句柄表.取(h);
    if (!对象 || std::isnan(v))
        return 0;
    对象->值.push_back(v);
    return 1;
}

extern "C" int FB_series_clear(intptr_t h)
{
    std::shared_ptr<数列> 对象 = 数列句柄表.取(h);
    if (!对象)
        return 0;
    对象->值.clear();
    return 1;
}

extern "C" int FB_series_count(intptr_t h)
{
    std::shared_ptr<数列> 对象 = 数列句柄表.取(h);
    if (!对象)
        return -1;
    return (int)对象->值.size();
}

namespace {
// 统一的空数列哨兵：NaN，火山侧用“值 != 值”判定
const double 空值 = std::nan("");

bool 取数列(intptr_t h, std::vector<double>& 副本)
{
    std::shared_ptr<数列> 对象 = 数列句柄表.取(h);
    if (!对象 || 对象->值.empty())
        return false;
    副本 = 对象->值;
    return true;
}
}

extern "C" double FB_series_sum(intptr_t h)
{
    std::vector<double> 副本;
    if (!取数列(h, 副本))
        return 空值;
    double 合计 = 0;
    for (size_t 序 = 0; 序 < 副本.size(); ++序)
        合计 += 副本[序];
    return 合计;
}

extern "C" double FB_series_mean(intptr_t h)
{
    std::vector<double> 副本;
    if (!取数列(h, 副本))
        return 空值;
    using namespace boost::accumulators;
    accumulator_set<double, stats<tag::mean>> 累加器;
    for (size_t 序 = 0; 序 < 副本.size(); ++序)
        累加器(副本[序]);
    return mean(累加器);
}

extern "C" double FB_series_variance(intptr_t h)
{
    std::vector<double> 副本;
    if (!取数列(h, 副本))
        return 空值;
    using namespace boost::accumulators;
    accumulator_set<double, stats<tag::variance>> 累加器;
    for (size_t 序 = 0; 序 < 副本.size(); ++序)
        累加器(副本[序]);
    return variance(累加器);      // 总体方差（除以 N）
}

extern "C" double FB_series_stddev(intptr_t h)
{
    double 方差 = FB_series_variance(h);
    if (std::isnan(方差))
        return 空值;
    return std::sqrt(方差);
}

extern "C" double FB_series_median(intptr_t h)
{
    std::vector<double> 副本;
    if (!取数列(h, 副本))
        return 空值;
    std::sort(副本.begin(), 副本.end());
    size_t 数量 = 副本.size();
    if (数量 % 2 == 1)
        return 副本[数量 / 2];
    return (副本[数量 / 2 - 1] + 副本[数量 / 2]) / 2.0;
}

extern "C" double FB_series_min(intptr_t h)
{
    std::vector<double> 副本;
    if (!取数列(h, 副本))
        return 空值;
    double 最小 = 副本[0];
    for (size_t 序 = 1; 序 < 副本.size(); ++序)
        if (副本[序] < 最小)
            最小 = 副本[序];
    return 最小;
}

extern "C" double FB_series_max(intptr_t h)
{
    std::vector<double> 副本;
    if (!取数列(h, 副本))
        return 空值;
    double 最大 = 副本[0];
    for (size_t 序 = 1; 序 < 副本.size(); ++序)
        if (副本[序] > 最大)
            最大 = 副本[序];
    return 最大;
}

extern "C" int FB_series_free(intptr_t h)
{
    return 数列句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  十、大整数（boost/multiprecision cpp_int）
// =====================================================================
extern "C" intptr_t FB_big_from_text(const wchar_t* s)
{
    try
    {
        大整数类型 值(窄化(取文本(s)));
        std::shared_ptr<大整数类型> 对象(new 大整数类型(值));
        return 大整数句柄表.加入(对象);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"大整数解析失败：";
        错误缓冲 += 宽化(异常.what());
        return 0;
    }
}

extern "C" const wchar_t* FB_big_text(intptr_t h)
{
    std::shared_ptr<大整数类型> 对象 = 大整数句柄表.取(h);
    if (!对象)
        return 记录错误(L"大整数句柄无效");
    return 交出文本(宽化(对象->str(0, std::ios_base::fmtflags(0))));
}

namespace {
// 二元运算统一模板：结果生成一个新句柄
template <typename 运算>
intptr_t 大整数二元运算(intptr_t a, intptr_t b, 运算 计算)
{
    std::shared_ptr<大整数类型> 甲 = 大整数句柄表.取(a);
    std::shared_ptr<大整数类型> 乙 = 大整数句柄表.取(b);
    if (!甲 || !乙)
    {
        记录错误(L"大整数句柄无效");
        return 0;
    }
    try
    {
        std::shared_ptr<大整数类型> 结果(new 大整数类型(计算(*甲, *乙)));
        return 大整数句柄表.加入(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"大整数运算失败：";
        错误缓冲 += 宽化(异常.what());
        return 0;
    }
}
}

extern "C" intptr_t FB_big_op(intptr_t a, intptr_t b, int op)
{
    std::shared_ptr<大整数类型> 乙 = 大整数句柄表.取(b);
    if (!乙)
        return 0;
    if ((op == 3 || op == 4) && *乙 == 0)
    {
        记录错误(L"大整数除数为零");
        return 0;
    }
    switch (op)
    {
    case 0: return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 丙) { return 甲 + 丙; });
    case 1: return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 丙) { return 甲 - 丙; });
    case 2: return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 丙) { return 甲 * 丙; });
    case 3: return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 丙) { return 甲 / 丙; });
    case 4: return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 丙) { return 甲 % 丙; });
    default:
        记录错误(L"大整数运算代号无效");
        return 0;
    }
}

extern "C" intptr_t FB_big_add(intptr_t a, intptr_t b)
{
    return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 乙) { return 甲 + 乙; });
}

extern "C" intptr_t FB_big_sub(intptr_t a, intptr_t b)
{
    return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 乙) { return 甲 - 乙; });
}

extern "C" intptr_t FB_big_mul(intptr_t a, intptr_t b)
{
    return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 乙) { return 甲 * 乙; });
}

extern "C" intptr_t FB_big_div(intptr_t a, intptr_t b)
{
    std::shared_ptr<大整数类型> 乙 = 大整数句柄表.取(b);
    if (乙 && *乙 == 0)
    {
        记录错误(L"大整数除数为零");
        return 0;
    }
    return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 丙) { return 甲 / 丙; });
}

extern "C" intptr_t FB_big_mod(intptr_t a, intptr_t b)
{
    std::shared_ptr<大整数类型> 乙 = 大整数句柄表.取(b);
    if (乙 && *乙 == 0)
    {
        记录错误(L"大整数取余的除数为零");
        return 0;
    }
    return 大整数二元运算(a, b, [](const 大整数类型& 甲, const 大整数类型& 丙) { return 甲 % 丙; });
}

extern "C" intptr_t FB_big_pow(intptr_t a, int exp)
{
    std::shared_ptr<大整数类型> 甲 = 大整数句柄表.取(a);
    if (!甲 || exp < 0)
    {
        记录错误(L"大整数幂运算参数无效");
        return 0;
    }
    try
    {
        大整数类型 结果 = 1;
        for (int 序 = 0; 序 < exp; ++序)
            结果 *= *甲;
        std::shared_ptr<大整数类型> 对象(new 大整数类型(结果));
        return 大整数句柄表.加入(对象);
    }
    catch (...) { return 0; }
}

extern "C" intptr_t FB_big_fact(int n)
{
    if (n < 0 || n > 100000)
    {
        记录错误(L"阶乘参数必须在 0 到 100000 之间");
        return 0;
    }
    try
    {
        大整数类型 结果 = 1;
        for (int 序 = 2; 序 <= n; ++序)
            结果 *= 序;
        std::shared_ptr<大整数类型> 对象(new 大整数类型(结果));
        return 大整数句柄表.加入(对象);
    }
    catch (...) { return 0; }
}

extern "C" int FB_big_cmp(intptr_t a, intptr_t b)
{
    std::shared_ptr<大整数类型> 甲 = 大整数句柄表.取(a);
    std::shared_ptr<大整数类型> 乙 = 大整数句柄表.取(b);
    if (!甲 || !乙)
        return -2;               // -2 专门表示句柄无效
    if (*甲 < *乙) return -1;
    if (*甲 > *乙) return 1;
    return 0;
}

extern "C" int FB_big_sign(intptr_t h)
{
    std::shared_ptr<大整数类型> 对象 = 大整数句柄表.取(h);
    if (!对象)
        return -2;
    if (*对象 < 0) return -1;
    if (*对象 > 0) return 1;
    return 0;
}

extern "C" int FB_big_free(intptr_t h)
{
    return 大整数句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  十一、JSON（boost/property_tree）
// =====================================================================
extern "C" intptr_t FB_json_parse(const wchar_t* s)
{
    try
    {
        std::wstring 原文本 = 取文本(s);
        std::wstringstream 流(原文本);
        std::shared_ptr<属性树类型> 树(new 属性树类型());
        boost::property_tree::read_json(流, *树);
        return 属性树句柄表.加入(树);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"JSON 解析失败：";
        错误缓冲 += 宽化(异常.what());
        return 0;
    }
}

extern "C" int FB_json_has(intptr_t h, const wchar_t* path)
{
    std::shared_ptr<属性树类型> 树 = 属性树句柄表.取(h);
    if (!树)
        return -1;
    try
    {
        return 树->get_optional<std::wstring>(取文本(path)).is_initialized() ? 1 : 0;
    }
    catch (...) { return 0; }
}

extern "C" const wchar_t* FB_json_text(intptr_t h, const wchar_t* path, const wchar_t* def)
{
    std::shared_ptr<属性树类型> 树 = 属性树句柄表.取(h);
    if (!树)
        return 记录错误(L"JSON 句柄无效");
    try
    {
        std::wstring 结果 = 树->get<std::wstring>(取文本(path), 取文本(def));
        return 交出文本(结果);
    }
    catch (...)
    {
        return 交出文本(取文本(def));
    }
}

extern "C" int64_t FB_json_int(intptr_t h, const wchar_t* path, int64_t def)
{
    std::shared_ptr<属性树类型> 树 = 属性树句柄表.取(h);
    if (!树)
        return def;
    try
    {
        return 树->get<int64_t>(取文本(path), def);
    }
    catch (...) { return def; }
}

extern "C" double FB_json_num(intptr_t h, const wchar_t* path, double def)
{
    std::shared_ptr<属性树类型> 树 = 属性树句柄表.取(h);
    if (!树)
        return def;
    try
    {
        return 树->get<double>(取文本(path), def);
    }
    catch (...) { return def; }
}

extern "C" int FB_json_set(intptr_t h, const wchar_t* path, const wchar_t* v)
{
    std::shared_ptr<属性树类型> 树 = 属性树句柄表.取(h);
    if (!树)
        return 0;
    try
    {
        树->put<std::wstring>(取文本(path), 取文本(v));
        return 1;
    }
    catch (...) { return 0; }
}

extern "C" const wchar_t* FB_json_dump(intptr_t h)
{
    std::shared_ptr<属性树类型> 树 = 属性树句柄表.取(h);
    if (!树)
        return 记录错误(L"JSON 句柄无效");
    try
    {
        std::wstringstream 流;
        boost::property_tree::write_json(流, *树, false);
        return 交出文本(流.str());
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"JSON 输出失败：";
        错误缓冲 += 宽化(异常.what());
        return L"";
    }
}

extern "C" int FB_json_free(intptr_t h)
{
    return 属性树句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  十二、文字截取与重塑（boost/algorithm/string，v1.1 增量）
//  说明：下标一律按「字符」计，与火山侧文本型的字符语义一致；
//        越界一律截断而不是报错，因为这几支函数是给界面拼字符串用的。
// =====================================================================
namespace {
// 重复文本的字符总数上限（1600 万字符），防止 times 极大时把内存吃光。
const size_t 最大重复字符数 = (size_t)16 * 1024 * 1024;
}

extern "C" int FB_text_length(const wchar_t* s)
{
    return (int)取文本(s).size();
}

extern "C" const wchar_t* FB_text_left(const wchar_t* s, int count)
{
    using namespace boost::algorithm;
    std::wstring 原文本 = 取文本(s);
    if (count <= 0 || 原文本.empty())
        return 交出文本(std::wstring());
    if ((size_t)count >= 原文本.size())
        return 交出文本(原文本);
    // 去掉尾部多余的字符，剩下的就是最前面的 count 个字符。
    return 交出文本(erase_tail_copy(原文本, (int)原文本.size() - count));
}

extern "C" const wchar_t* FB_text_right(const wchar_t* s, int count)
{
    using namespace boost::algorithm;
    std::wstring 原文本 = 取文本(s);
    if (count <= 0 || 原文本.empty())
        return 交出文本(std::wstring());
    if ((size_t)count >= 原文本.size())
        return 交出文本(原文本);
    // 去掉首部多余的字符，剩下的就是最后面的 count 个字符。
    return 交出文本(erase_head_copy(原文本, (int)原文本.size() - count));
}

extern "C" const wchar_t* FB_text_mid(const wchar_t* s, int start, int count)
{
    using namespace boost::algorithm;
    std::wstring 原文本 = 取文本(s);
    if (count <= 0 || 原文本.empty())
        return 交出文本(std::wstring());
    if (start < 0)
        start = 0;
    if ((size_t)start >= 原文本.size())
        return 交出文本(std::wstring());
    std::wstring 结果 = erase_head_copy(原文本, start);
    if ((size_t)count < 结果.size())
        结果 = erase_tail_copy(结果, (int)结果.size() - count);
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_repeat(const wchar_t* s, int times)
{
    std::wstring 原文本 = 取文本(s);
    if (times <= 0 || 原文本.empty())
        return 交出文本(std::wstring());
    // 按字符总量限制重复次数，避免异常参数导致内存耗尽。
    size_t 允许次数 = 最大重复字符数 / 原文本.size();
    if (允许次数 == 0)
        允许次数 = 1;
    if ((size_t)times > 允许次数)
        times = (int)允许次数;
    std::wstring 结果;
    结果.reserve(原文本.size() * (size_t)times);
    for (int 序 = 0; 序 < times; ++序)
        结果 += 原文本;
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_trim_dup_spaces(const wchar_t* s)
{
    using namespace boost::algorithm;
    std::wstring 结果 = 取文本(s);
    // trim_fill：去首尾空白，并把中间的每一段连续空白替换成一个空格。
    结果 = trim_fill_copy(结果, L" ", std::locale::classic());
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_text_unique(const wchar_t* s)
{
    std::wstring 结果 = 取文本(s);
    // boost::range::unique 返回 [起点, 新终点) 的区间，只搬移元素、不缩短容器，
    // 因此还要把新终点之后的残留字符抹掉。
    auto 有效区间 = boost::range::unique(结果);
    结果.erase(有效区间.end(), 结果.end());
    return 交出文本(结果);
}

// =====================================================================
//  十三、按行切分（复用分词句柄，v1.1 增量）
// =====================================================================
extern "C" intptr_t FB_lines_create(const wchar_t* s)
{
    using namespace boost::algorithm;
    std::shared_ptr<分词结果> 结果(new 分词结果());
    std::wstring 原文本 = 取文本(s);
    if (!原文本.empty())
    {
        std::vector<std::wstring> 行表;
        // \r 与 \n 都当分隔符，token_compress_on 让 \r\n 只算一次切分，
        // 顺带忽略连续空行，与用户在编辑器里看到的行一致。
        split(行表, 原文本, is_any_of(std::wstring(L"\r\n")), token_compress_on);
        for (size_t 序 = 0; 序 < 行表.size(); ++序)
            if (!行表[序].empty())
                结果->项.push_back(行表[序]);
    }
    return 分词句柄表.加入(结果);
}

// =====================================================================
//  十四、日期扩展（boost/gregorian，v1.1 增量）
// =====================================================================
extern "C" int64_t FB_date_first_of_month(int64_t d)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return 0;
    try
    {
        return 压缩日期(boost::gregorian::date(日期.year(), 日期.month(), 1));
    }
    catch (...) { return 0; }
}

extern "C" int64_t FB_date_last_of_month(int64_t d)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return 0;
    try
    {
        unsigned short 末日 = boost::gregorian::gregorian_calendar::end_of_month_day(
            日期.year(), 日期.month());
        return 压缩日期(boost::gregorian::date(日期.year(), 日期.month(), 末日));
    }
    catch (...) { return 0; }
}

extern "C" int64_t FB_date_add_months(int64_t d, int months)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return 0;
    try
    {
        // boost 的 months 运算自带「月末对齐」：
        // 2026-01-31 加 1 个月得到 2026-02-28，而不是溢出到 3 月。
        return 压缩日期(日期 + boost::gregorian::months(months));
    }
    catch (...) { return 0; }
}

extern "C" int64_t FB_date_add_years(int64_t d, int years)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return 0;
    try
    {
        // 闰日加年同样对齐到月末：2024-02-29 加 1 年得到 2025-02-28。
        return 压缩日期(日期 + boost::gregorian::years(years));
    }
    catch (...) { return 0; }
}

extern "C" int64_t FB_date_to_time_ms(int64_t d)
{
    boost::gregorian::date 日期 = 解压日期(d);
    if (日期.is_not_a_date())
        return 0;
    try
    {
        // 与 FB_time_from_text / FB_time_text 使用同一套时间点基准（本机时区）。
        return 时间点转毫秒(boost::posix_time::ptime(日期));
    }
    catch (...) { return 0; }
}

// =====================================================================
//  十五、时间扩展（boost/posix_time，v1.1 增量）
// =====================================================================
extern "C" int64_t FB_time_to_date(int64_t ms)
{
    try
    {
        return 压缩日期(毫秒转时间点(ms).date());
    }
    catch (...) { return 0; }
}

extern "C" int64_t FB_time_seconds_to_ms(int64_t s)
{
    // 秒转毫秒：溢出时返回 0，避免把无意义的大数传回火山侧。
    if (s > (int64_t)9223372036854775LL || s < (int64_t)(-9223372036854775LL))
        return 0;
    return s * 1000;
}

extern "C" int64_t FB_time_ms_to_seconds(int64_t ms)
{
    // 毫秒转秒：向零取整（-1500 毫秒得到 -1 秒），与整数除法语义一致。
    return ms / 1000;
}

extern "C" int64_t FB_time_day_start_ms(int64_t ms)
{
    try
    {
        boost::posix_time::ptime 时间点 = 毫秒转时间点(ms);
        return 时间点转毫秒(boost::posix_time::ptime(时间点.date()));
    }
    catch (...) { return 0; }
}

// =====================================================================
//  十六、INI 配置文档（boost/property_tree/ini_parser，v1.1 增量）
//  路径写法与 JSON 相同：段名.键名 ，例如 主窗口.标题 。
// =====================================================================
extern "C" intptr_t FB_ini_parse(const wchar_t* s)
{
    清空错误();
    try
    {
        std::wstring 原文本 = 取文本(s);
        std::wstringstream 流(原文本);
        std::shared_ptr<属性树类型> 树(new 属性树类型());
        boost::property_tree::read_ini(流, *树);
        上次成功 = true;
        return INI句柄表.加入(树);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"INI 解析失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
}

extern "C" int FB_ini_has(intptr_t h, const wchar_t* path)
{
    std::shared_ptr<属性树类型> 树 = INI句柄表.取(h);
    if (!树)
        return -1;
    try
    {
        return 树->get_optional<std::wstring>(取文本(path)).is_initialized() ? 1 : 0;
    }
    catch (...) { return 0; }
}

extern "C" const wchar_t* FB_ini_text(intptr_t h, const wchar_t* path, const wchar_t* def)
{
    std::shared_ptr<属性树类型> 树 = INI句柄表.取(h);
    if (!树)
        return 记录错误(L"INI 句柄无效");
    try
    {
        return 交出文本(树->get<std::wstring>(取文本(path), 取文本(def)));
    }
    catch (...)
    {
        return 交出文本(取文本(def));
    }
}

extern "C" int64_t FB_ini_int(intptr_t h, const wchar_t* path, int64_t def)
{
    std::shared_ptr<属性树类型> 树 = INI句柄表.取(h);
    if (!树)
        return def;
    try
    {
        return 树->get<int64_t>(取文本(path), def);
    }
    catch (...) { return def; }
}

extern "C" int FB_ini_set(intptr_t h, const wchar_t* path, const wchar_t* v)
{
    std::shared_ptr<属性树类型> 树 = INI句柄表.取(h);
    if (!树)
        return 0;
    try
    {
        树->put<std::wstring>(取文本(path), 取文本(v));
        return 1;
    }
    catch (...) { return 0; }
}

extern "C" const wchar_t* FB_ini_dump(intptr_t h)
{
    std::shared_ptr<属性树类型> 树 = INI句柄表.取(h);
    if (!树)
        return 记录错误(L"INI 句柄无效");
    try
    {
        std::wstringstream 流;
        boost::property_tree::write_ini(流, *树);
        return 交出文本(流.str());
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"INI 输出失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
}

extern "C" int FB_ini_free(intptr_t h)
{
    return INI句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  十七、双向映射表（boost/container/flat_map，v1.1 增量）
//  同一个名称重复加入时覆盖旧数值；同一个数值被多个名称占用时，
// 反查返回最后写入的那个名称。
// =====================================================================
extern "C" intptr_t FB_map_create(void)
{
    std::shared_ptr<映射表数据> 表(new 映射表数据());
    return 映射表句柄表.加入(表);
}

extern "C" int FB_map_put(intptr_t h, const wchar_t* name, int64_t value)
{
    std::shared_ptr<映射表数据> 表 = 映射表句柄表.取(h);
    if (!表)
        return 0;
    std::wstring 名称 = 取文本(name);
    if (名称.empty())
    {
        记录错误(L"映射表的名称不能为空");
        return 0;
    }
    boost::container::flat_map<std::wstring, int64_t>::iterator 已存在 = 表->名到值.find(名称);
    if (已存在 != 表->名到值.end())
    {
        // 覆盖旧数值：先把旧数值的反查项清掉（仅当它确实指向本名称）。
        int64_t 旧值 = 已存在->second;
        表->名到值[名称] = value;
        boost::container::flat_map<int64_t, std::wstring>::iterator 反查 = 表->值到名.find(旧值);
        if (反查 != 表->值到名.end() && 反查->second == 名称)
            表->值到名.erase(反查);
    }
    else
    {
        表->名到值[名称] = value;
        表->顺序.push_back(名称);       // 只在首次加入时登记次序
    }
    表->值到名[value] = 名称;
    return 1;
}

extern "C" int FB_map_has(intptr_t h, const wchar_t* name)
{
    std::shared_ptr<映射表数据> 表 = 映射表句柄表.取(h);
    if (!表)
        return 0;
    return 表->名到值.find(取文本(name)) != 表->名到值.end() ? 1 : 0;
}

extern "C" int64_t FB_map_get(intptr_t h, const wchar_t* name, int64_t def)
{
    std::shared_ptr<映射表数据> 表 = 映射表句柄表.取(h);
    if (!表)
        return def;
    boost::container::flat_map<std::wstring, int64_t>::const_iterator 位置 =
        表->名到值.find(取文本(name));
    if (位置 == 表->名到值.end())
        return def;
    return 位置->second;
}

extern "C" const wchar_t* FB_map_reverse_get(intptr_t h, int64_t value, const wchar_t* def)
{
    std::shared_ptr<映射表数据> 表 = 映射表句柄表.取(h);
    if (!表)
        return 交出文本(取文本(def));
    boost::container::flat_map<int64_t, std::wstring>::const_iterator 位置 = 表->值到名.find(value);
    if (位置 == 表->值到名.end())
        return 交出文本(取文本(def));
    return 交出文本(位置->second);
}

extern "C" int FB_map_count(intptr_t h)
{
    std::shared_ptr<映射表数据> 表 = 映射表句柄表.取(h);
    if (!表)
        return -1;
    return (int)表->名到值.size();
}

extern "C" const wchar_t* FB_map_name_at(intptr_t h, int index)
{
    std::shared_ptr<映射表数据> 表 = 映射表句柄表.取(h);
    if (!表)
        return 记录错误(L"映射表句柄无效");
    if (index < 0 || index >= (int)表->顺序.size())
        return 交出文本(std::wstring());
    return 交出文本(表->顺序[(size_t)index]);
}

extern "C" int FB_map_free(intptr_t h)
{
    return 映射表句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  十八、XML 文档（boost/property_tree/xml_parser，v1.2 增量）
//  路径写法与 JSON 基本相同，但 XML 的「属性」在属性树里是一组名为
//  <xmlattr> 的子节点，因此元素的 id 属性要写成
//      根节点.子节点.<xmlattr>.id
//  而元素本身的文本仍然挂在该元素节点上（路径写到元素名为止）。
//  本模块使用独立的 XML句柄表，XML 句柄与 JSON / INI 句柄互不通用。
// =====================================================================
extern "C" intptr_t FB_xml_parse(const wchar_t* s)
{
    清空错误();
    std::wstring 原文本 = 取文本(s);
    // boost 的 read_xml 对空输入不会报错，而是给出一个没有根的空属性树，
    // 于是“解析成功但什么也没有”。这与 FB_json_parse 不对称，因此显式拒绝：
    // 空文本一律视为解析失败（未闭合等真正的语法错误仍走下面的 catch）。
    if (原文本.empty())
    {
        记录错误(L"XML 文本为空，无法解析");
        return 0;
    }
    try
    {
        std::wstringstream 流(原文本);
        std::shared_ptr<属性树类型> 树(new 属性树类型());
        boost::property_tree::read_xml(流, *树);
        上次成功 = true;
        return XML句柄表.加入(树);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"XML 解析失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
}

extern "C" int FB_xml_has(intptr_t h, const wchar_t* path)
{
    std::shared_ptr<属性树类型> 树 = XML句柄表.取(h);
    if (!树)
        return -1;
    try
    {
        return 树->get_optional<std::wstring>(取文本(path)).is_initialized() ? 1 : 0;
    }
    catch (...) { return 0; }
}

extern "C" const wchar_t* FB_xml_text(intptr_t h, const wchar_t* path, const wchar_t* def)
{
    std::shared_ptr<属性树类型> 树 = XML句柄表.取(h);
    if (!树)
        return 记录错误(L"XML 句柄无效");
    try
    {
        return 交出文本(树->get<std::wstring>(取文本(path), 取文本(def)));
    }
    catch (...)
    {
        return 交出文本(取文本(def));
    }
}

extern "C" int64_t FB_xml_int(intptr_t h, const wchar_t* path, int64_t def)
{
    std::shared_ptr<属性树类型> 树 = XML句柄表.取(h);
    if (!树)
        return def;
    try
    {
        return 树->get<int64_t>(取文本(path), def);
    }
    catch (...) { return def; }
}

extern "C" double FB_xml_num(intptr_t h, const wchar_t* path, double def)
{
    std::shared_ptr<属性树类型> 树 = XML句柄表.取(h);
    if (!树)
        return def;
    try
    {
        return 树->get<double>(取文本(path), def);
    }
    catch (...) { return def; }
}

extern "C" int FB_xml_set(intptr_t h, const wchar_t* path, const wchar_t* v)
{
    std::shared_ptr<属性树类型> 树 = XML句柄表.取(h);
    if (!树)
        return 0;
    try
    {
        树->put<std::wstring>(取文本(path), 取文本(v));
        return 1;
    }
    catch (...) { return 0; }
}

extern "C" const wchar_t* FB_xml_dump(intptr_t h)
{
    std::shared_ptr<属性树类型> 树 = XML句柄表.取(h);
    if (!树)
        return 记录错误(L"XML 句柄无效");
    try
    {
        std::wstringstream 流;
        boost::property_tree::write_xml(流, *树);
        return 交出文本(流.str());
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"XML 输出失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
}

extern "C" int FB_xml_free(intptr_t h)
{
    return XML句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  十九、随机数（boost/random，v1.2 增量）
//  引擎是 thread_local：每个线程一份，播种只影响当前线程。固定种子在
//  同一线程上可复现同一序列；不同线程互不干扰（也就互不保证相同序列）。
// =====================================================================
namespace {

// 线程局部引擎与其播种状态
thread_local boost::random::mt19937 随机引擎;
thread_local bool 随机引擎已播种 = false;

// 首次使用时用系统熵播种，之后一直沿用（除非显式播种）。
// 注意：这里用标准库的 std::random_device，而不是 boost::random::random_device
//       —— 后者的构造函数/析构函数与 operator() 是编译期源文件里的实体，
//       只包含头文件会得到 LNK2019 无法解析的外部符号（实测确认）。
void 确保随机引擎()
{
    if (!随机引擎已播种)
    {
        try
        {
            std::random_device 熵源;
            随机引擎.seed((boost::random::mt19937::result_type)熵源());
        }
        catch (...)
        {
            // 熵源不可用时退化为固定种子，保证函数依然可用。
            随机引擎.seed(5489u);
        }
        随机引擎已播种 = true;
    }
}

// 按逗号切分列表，保留空项（与 FB_split_create 的逗号语义一致）。
std::vector<std::wstring> 切分逗号列表(const wchar_t* items)
{
    using namespace boost::algorithm;
    std::vector<std::wstring> 结果;
    std::wstring 原文本 = 取文本(items);
    if (原文本.empty())
        return 结果;
    split(结果, 原文本, is_any_of(std::wstring(L",")), token_compress_off);
    return 结果;
}

} // namespace

extern "C" int FB_random_seed(int64_t seed)
{
    清空错误();
    // mt19937 的种子类型是 32 位无符号整数，取低 32 位即可。
    随机引擎.seed((boost::random::mt19937::result_type)((uint64_t)seed & 0xFFFFFFFFull));
    随机引擎已播种 = true;
    上次成功 = true;
    return 1;
}

extern "C" int64_t FB_random_int(int64_t lo, int64_t hi)
{
    确保随机引擎();
    if (lo > hi)
    {
        int64_t 临时 = lo;
        lo = hi;
        hi = 临时;
    }
    if (lo == hi)
        return lo;
    boost::random::uniform_int_distribution<int64_t> 分布(lo, hi);
    return 分布(随机引擎);
}

extern "C" double FB_random_double(double lo, double hi)
{
    确保随机引擎();
    if (lo > hi)
    {
        double 临时 = lo;
        lo = hi;
        hi = 临时;
    }
    if (lo == hi)
        return lo;
    boost::random::uniform_real_distribution<double> 分布(lo, hi);
    return 分布(随机引擎);
}

extern "C" double FB_random_normal(double mean, double sigma)
{
    // 必须先判断再构造：boost::random::normal_distribution 用 BOOST_ASSERT 校验
    // sigma >= 0，assert 不是 C++ 异常，catch(...) 捕不到，负值会直接把宿主进程
    // 断言掉（0xC0000409）。sigma == 0 则会在内部算 (x-mean)/sigma 得到 inf/nan，
    // 所以这里把“非正标准差”统一当作“没有分散度”，直接返回均值。
    if (!(sigma > 0.0))
    {
        记录错误(L"标准差必须为正，已按均值返回");
        return mean;
    }
    确保随机引擎();
    try
    {
        boost::random::normal_distribution<double> 分布(mean, sigma);
        return 分布(随机引擎);
    }
    catch (...)
    {
        // 兜底：任何其它异常也退化为返回均值，避免把 NaN 传回火山侧。
        记录错误(L"正态分布参数无效，已按均值返回");
        return mean;
    }
}

extern "C" int FB_random_bool(double probability)
{
    // 边界优先：概率 <= 0 恒假、>= 1 恒真，不消耗随机数。
    if (!(probability > 0.0))
        return 0;
    if (probability >= 1.0)
        return 1;
    确保随机引擎();
    boost::random::uniform_real_distribution<double> 分布(0.0, 1.0);
    return (分布(随机引擎) < probability) ? 1 : 0;
}

extern "C" const wchar_t* FB_random_pick(const wchar_t* items)
{
    确保随机引擎();
    std::vector<std::wstring> 列表 = 切分逗号列表(items);
    if (列表.empty())
        return 记录错误(L"随机抽取的列表不能为空");
    boost::random::uniform_int_distribution<size_t> 分布(0, 列表.size() - 1);
    return 交出文本(列表[分布(随机引擎)]);
}

extern "C" intptr_t FB_random_shuffle(const wchar_t* items)
{
    确保随机引擎();
    std::shared_ptr<分词结果> 结果(new 分词结果());
    结果->项 = 切分逗号列表(items);
    if (结果->项.empty())
    {
        记录错误(L"打乱列表的列表不能为空");
        return 0;
    }
    // mt19937 满足 UniformRandomBitGenerator，可直接喂给标准库的洗牌算法。
    std::shuffle(结果->项.begin(), 结果->项.end(), 随机引擎);
    return 分词句柄表.加入(结果);
}

// =====================================================================
//  二十、高精度十进制小数（boost/multiprecision cpp_dec_float_50，v1.2 增量）
//  50 位十进制有效数字，0.1 + 0.2 在十进制下精确等于 0.3（不是二进制的
//  0.30000000000000004）。所有构造与运算失败都写中文错误并返回 0。
// =====================================================================
namespace {

// 高精度小数的取句柄辅助：句柄无效时写错误并返回空指针。
std::shared_ptr<高精度类型> 取高精度(intptr_t h, const wchar_t* 无效说明)
{
    std::shared_ptr<高精度类型> 对象 = 高精度句柄表.取(h);
    if (!对象)
        记录错误(无效说明);
    return 对象;
}

// 二元运算统一模板：结果生成一个新句柄（与 大整数二元运算 同一套写法）。
template <typename 运算>
intptr_t 高精度二元运算(intptr_t a, intptr_t b, 运算 计算)
{
    std::shared_ptr<高精度类型> 甲 = 高精度句柄表.取(a);
    std::shared_ptr<高精度类型> 乙 = 高精度句柄表.取(b);
    if (!甲 || !乙)
    {
        记录错误(L"高精度小数句柄无效");
        return 0;
    }
    try
    {
        std::shared_ptr<高精度类型> 结果(new 高精度类型(计算(*甲, *乙)));
        return 高精度句柄表.加入(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"高精度小数运算失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
}

// 四舍五入（远离零）到指定小数位，是 FB_dec_text 与 FB_dec_round 共用的唯一实现。
//   位数 >= 0：保留小数点后 位数 位（位数 = 0 即取整）；
//   位数 < 0 ：对整数部分舍入（-2 表示舍入到百位），沿用 FB_dec_round 的既有语义。
// 之所以必须共用：cpp_dec_float 的 str(位数, fixed) 自带的是“银行家舍入”
// （2.5→2、0.5→0），与四舍五入不一致；先按本函数舍入再打印，两边的值才完全相同。
高精度类型 四舍五入至小数位(const 高精度类型& 值, int 位数)
{
    // 位数限制：|digits| <= 200，避免指数循环过长（50 位有效数字远用不到）。
    int 次 = 位数 >= 0 ? 位数 : -位数;
    if (次 > 200)
        次 = 200;
    高精度类型 倍率 = 1;
    for (int 序 = 0; 序 < 次; ++序)
        倍率 *= 10;
    if (位数 < 0)
        倍率 = 高精度类型(1) / 倍率;

    高精度类型 缩放 = 值 * 倍率;
    高精度类型 绝对 = 缩放 < 0 ? -缩放 : 缩放;
    绝对 += 高精度类型("0.5");                       // 加半个单位后向下取整 = 远离零
    绝对 = boost::multiprecision::floor(绝对);
    return (缩放 < 0 ? -绝对 : 绝对) / 倍率;
}

} // namespace

extern "C" intptr_t FB_dec_from_text(const wchar_t* s)
{
    清空错误();
    std::wstring 原文本 = 取文本(s);
    if (原文本.empty())
    {
        记录错误(L"高精度小数的文本不能为空");
        return 0;
    }
    try
    {
        // 窄化 只允许 ASCII 字符通过，正是数字文本需要的字符集；
        // 出现非法字符时由 boost 抛出异常，转成中文错误说明。
        高精度类型 值(窄化(原文本).c_str());
        std::shared_ptr<高精度类型> 对象(new 高精度类型(值));
        上次成功 = true;
        return 高精度句柄表.加入(对象);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"高精度小数解析失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
}

extern "C" const wchar_t* FB_dec_text(intptr_t h, int digits)
{
    std::shared_ptr<高精度类型> 对象 = 取高精度(h, L"高精度小数句柄无效");
    if (!对象)
        return L"";
    try
    {
        // cpp_dec_float 只对窄字符流提供了 operator<<，因此统一走成员 str()：
        //   str(位数, fixed)      —— 位数表示小数点后的位数
        //   str(50, 默认标志)     —— 按 cpp_dec_float_50 的 50 位有效数字输出
        // 拿到窄文本后再逐字符扩宽，避免任何代码页转换。
        // 注意：str(位数, fixed) 自带银行家舍入（2.5→2、0.5→0），与 FB_dec_round 的
        // 四舍五入不一致，因此先用 四舍五入至小数位 舍入，再原样打印，两边才一致。
        std::string 窄文本;
        if (digits >= 0)
        {
            高精度类型 舍入值 = 四舍五入至小数位(*对象, digits);
            窄文本 = 舍入值.str((std::intmax_t)digits, std::ios_base::fixed);
        }
        else
        {
            窄文本 = 对象->str((std::intmax_t)50, std::ios_base::fmtflags(0));
        }
        return 交出文本(宽化(窄文本));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"高精度小数转文本失败：";
        错误缓冲 += 宽化(异常.what());
        return L"";
    }
}

extern "C" intptr_t FB_dec_op(intptr_t a, intptr_t b, int op)
{
    清空错误();
    std::shared_ptr<高精度类型> 乙 = 高精度句柄表.取(b);
    if (!乙)
    {
        记录错误(L"高精度小数句柄无效");
        return 0;
    }
    if (op == 3 && *乙 == 0)
    {
        记录错误(L"高精度小数除数为零");
        return 0;
    }
    switch (op)
    {
    case 0: return 高精度二元运算(a, b, [](const 高精度类型& 甲, const 高精度类型& 丙) { return 甲 + 丙; });
    case 1: return 高精度二元运算(a, b, [](const 高精度类型& 甲, const 高精度类型& 丙) { return 甲 - 丙; });
    case 2: return 高精度二元运算(a, b, [](const 高精度类型& 甲, const 高精度类型& 丙) { return 甲 * 丙; });
    case 3: return 高精度二元运算(a, b, [](const 高精度类型& 甲, const 高精度类型& 丙) { return 甲 / 丙; });
    default:
        记录错误(L"高精度小数运算代号无效");
        return 0;
    }
}

extern "C" intptr_t FB_dec_round(intptr_t h, int digits)
{
    std::shared_ptr<高精度类型> 对象 = 取高精度(h, L"高精度小数句柄无效");
    if (!对象)
        return 0;
    try
    {
        // 与 FB_dec_text 共用同一套四舍五入实现，保证“打印出来的值”与
        // “四舍五入得到的值”永远是同一个数。
        高精度类型 结果 = 四舍五入至小数位(*对象, digits);
        std::shared_ptr<高精度类型> 新对象(new 高精度类型(结果));
        return 高精度句柄表.加入(新对象);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"高精度小数四舍五入失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
}

extern "C" intptr_t FB_dec_abs(intptr_t h)
{
    std::shared_ptr<高精度类型> 对象 = 取高精度(h, L"高精度小数句柄无效");
    if (!对象)
        return 0;
    try
    {
        高精度类型 结果 = *对象 < 0 ? -*对象 : *对象;
        std::shared_ptr<高精度类型> 新对象(new 高精度类型(结果));
        return 高精度句柄表.加入(新对象);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"高精度小数取绝对值失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
}

extern "C" int FB_dec_cmp(intptr_t a, intptr_t b)
{
    std::shared_ptr<高精度类型> 甲 = 高精度句柄表.取(a);
    std::shared_ptr<高精度类型> 乙 = 高精度句柄表.取(b);
    if (!甲 || !乙)
        return -2;                       // -2 专门表示句柄无效
    if (*甲 < *乙) return -1;
    if (*甲 > *乙) return 1;
    return 0;
}

extern "C" int FB_dec_sign(intptr_t h)
{
    std::shared_ptr<高精度类型> 对象 = 高精度句柄表.取(h);
    if (!对象)
        return -2;
    if (*对象 < 0) return -1;
    if (*对象 > 0) return 1;
    return 0;
}

extern "C" double FB_dec_to_double(intptr_t h)
{
    std::shared_ptr<高精度类型> 对象 = 高精度句柄表.取(h);
    if (!对象)
        return std::nan("");
    try
    {
        return 对象->convert_to<double>();
    }
    catch (...)
    {
        记录错误(L"高精度小数转双精度失败");
        return std::nan("");
    }
}

extern "C" int FB_dec_free(intptr_t h)
{
    return 高精度句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  二十一、文件与目录（boost/filesystem，v1.3 增量）
//
//  中文路径为什么必须走宽字符：
//    boost::filesystem::path 在 Windows 上用 wchar_t 存路径。如果拿窄
//    std::string 构造，boost 会按当前 ANSI 代码页解释那些字节，UTF-8 编码
//    的中文路径会被解释成另一串字符，exists 之类的调用于是全部失配
//    （实测直接返回 0）。所以这里统一用 std::wstring 构造路径，
//    输出统一用 .wstring()。
//
//  两个实测踩到的坑，写在这里免得后来人重犯：
//   1) boost 1.86 的 exists(p, ec) 在"路径不存在"时会**设置** ec（ENOENT），
//      同时返回 false。于是 `if (!exists(p, ec)) { if (ec) 报错 }` 会把
//      "不存在"误判成"底层出错"。本层改用 status() 自己判 not_found：
//      不存在是正常结果，不写错误槽。
//   2) error_code::message() 返回的是 **ANSI(GBK)** 字节，直接逐字节放宽
//      会得到乱码（ÏµÍ³ÕÒ²»µ½...）。本层用 系统错误说明() 把常见错误码
//      映射成中文，未知错误给出错误码数字。
//
//  所有失败路径都返回哨兵值并把中文原因写进错误槽，
//  boost::filesystem 的 filesystem_error 绝不外泄到火山侧。
// =====================================================================
namespace {

// 把常见系统错误码翻成中文；不认识的就报出错误码数字。
std::wstring 系统错误说明(const boost::system::error_code& 错误码)
{
    if (!错误码)
        return std::wstring();
    switch (错误码.value())
    {
    case 2:   return L"系统找不到指定的文件";
    case 3:   return L"系统找不到指定的路径";
    case 5:   return L"拒绝访问";
    case 32:  return L"文件正被另一个程序使用";
    case 80:  return L"目标文件已存在";
    case 123: return L"文件名、目录名或卷标语法不正确";
    case 145: return L"目录不是空的";
    case 183: return L"目标已存在";
    case 206: return L"文件名或扩展名太长";
    case 267: return L"目录名无效";
    default:  break;
    }
    std::wstring 结果 = L"系统错误码 ";
    结果 += std::to_wstring((long long)错误码.value());
    return 结果;
}

const wchar_t* 文件失败(const wchar_t* 前缀, const boost::system::error_code& 错误码)
{
    错误缓冲 = 前缀;
    std::wstring 说明 = 系统错误说明(错误码);
    if (!说明.empty())
    {
        错误缓冲 += L"：";
        错误缓冲 += 说明;
    }
    上次成功 = false;
    return L"";
}

void 文件异常(const wchar_t* 前缀, const std::exception& 异常)
{
    错误缓冲 = 前缀;
    错误缓冲 += L"：";
    错误缓冲 += 宽化(异常.what());
    上次成功 = false;
}

// 把宽文本转成 boost 路径。空指针与空文本一律当错误：
// path("") 会让 absolute / current_path 落到进程当前目录，
// 静默地"操作了别的目录"是最难排查的一类错误。
bool 建立文件路径(const wchar_t* 源, boost::filesystem::path& 路径, const wchar_t* 用途)
{
    if (源 == nullptr || 源[0] == L'\0')
    {
        错误缓冲 = 用途;
        错误缓冲 += L"：路径文本为空";
        上次成功 = false;
        return false;
    }
    路径 = boost::filesystem::path(std::wstring(源));
    return true;
}

// 取路径状态。"不存在"是正常结果（不设错误码），只有真正的失败才设错误码。
boost::filesystem::file_status 取路径状态(const boost::filesystem::path& 路径,
                                          boost::system::error_code& 错误码)
{
    boost::system::error_code 本地错误;
    boost::filesystem::file_status 状态 = boost::filesystem::status(路径, 本地错误);
    if (状态.type() == boost::filesystem::file_not_found)
    {
        错误码.clear();
        return 状态;
    }
    错误码 = 本地错误;
    return 状态;
}

} // namespace

extern "C" int FB_fs_exists(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"判断路径是否存在"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 状态 = 取路径状态(路径, 错误码);
        if (错误码)
        {
            文件失败(L"判断路径是否存在失败", 错误码);
            return 0;
        }
        上次成功 = true;
        return boost::filesystem::exists(状态) ? 1 : 0;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"判断路径是否存在失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"判断路径是否存在失败：未知异常");
        return 0;
    }
}

extern "C" int FB_fs_is_dir(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"判断是否为目录"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 状态 = 取路径状态(路径, 错误码);
        if (错误码)
        {
            文件失败(L"判断是否为目录失败", 错误码);
            return 0;
        }
        上次成功 = true;
        return boost::filesystem::is_directory(状态) ? 1 : 0;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"判断是否为目录失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"判断是否为目录失败：未知异常");
        return 0;
    }
}

extern "C" int FB_fs_is_file(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"判断是否为文件"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 状态 = 取路径状态(路径, 错误码);
        if (错误码)
        {
            文件失败(L"判断是否为文件失败", 错误码);
            return 0;
        }
        上次成功 = true;
        return boost::filesystem::is_regular_file(状态) ? 1 : 0;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"判断是否为文件失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"判断是否为文件失败：未知异常");
        return 0;
    }
}

extern "C" int64_t FB_fs_size(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"取尺寸失败"))
        return -1;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 状态 = 取路径状态(路径, 错误码);
        if (错误码)
        {
            文件失败(L"取尺寸失败", 错误码);
            return -1;
        }
        if (!boost::filesystem::exists(状态))
        {
            记录错误(L"取尺寸失败：路径不存在");
            return -1;
        }
        // 目录在 Windows 上也可能报出一个"尺寸"（0 或簇大小），不同文件系统
        // 还不一样，因此显式拒绝，保证语义确定。
        if (boost::filesystem::is_directory(状态))
        {
            记录错误(L"取尺寸失败：目标是目录，目录没有尺寸");
            return -1;
        }
        boost::uintmax_t 字节数 = boost::filesystem::file_size(路径, 错误码);
        if (错误码)
        {
            文件失败(L"取尺寸失败", 错误码);
            return -1;
        }
        上次成功 = true;
        return (int64_t)字节数;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取尺寸失败", 异常);
        return -1;
    }
    catch (...)
    {
        记录错误(L"取尺寸失败：未知异常");
        return -1;
    }
}

extern "C" int64_t FB_fs_modified_ms(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"取修改时间失败"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        std::time_t 时刻 = boost::filesystem::last_write_time(路径, 错误码);
        if (错误码)
        {
            文件失败(L"取修改时间失败", 错误码);
            return 0;
        }
        if (时刻 == (std::time_t)(-1))
        {
            记录错误(L"取修改时间失败：系统没有提供修改时间");
            return 0;
        }
        上次成功 = true;
        // 与既有「时间点转毫秒」同一基准：1970-01-01 起算的毫秒数。
        return 时间点转毫秒(boost::posix_time::from_time_t(时刻));
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取修改时间失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"取修改时间失败：未知异常");
        return 0;
    }
}

extern "C" const wchar_t* FB_fs_absolute(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"取绝对路径失败"))
        return L"";
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::path 结果 = boost::filesystem::absolute(路径, 错误码);
        if (错误码)
            return 文件失败(L"取绝对路径失败", 错误码);
        上次成功 = true;
        return 交出文本(结果.wstring());
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取绝对路径失败", 异常);
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取绝对路径失败：未知异常");
    }
}

extern "C" const wchar_t* FB_fs_join(const wchar_t* a, const wchar_t* b)
{
    清空错误();
    boost::filesystem::path 甲路径;
    if (!建立文件路径(a, 甲路径, L"合并路径失败"))
        return L"";
    try
    {
        std::wstring 乙文本 = 取文本(b);
        if (乙文本.empty())
        {
            上次成功 = true;
            return 交出文本(甲路径.wstring());
        }
        boost::filesystem::path 乙路径(乙文本);
        // boost 的 operator/ 只会拼接，**不**像 std::filesystem 那样识别绝对路径：
        //   path("C:/甲") / path("D:/乙")  ==  "C:/甲/D:/乙"（无效路径）
        // 所以子路径是绝对路径时直接顶掉前一段，与 README 的承诺一致。
        // 判定必须用 boost 自己的 is_absolute()：在 Windows 上 "C:" 是"根相对"（不算绝对），
        // 只有 "C:\" 或 "\\服务器\共享" 才算绝对。
        if (乙路径.is_absolute())
        {
            上次成功 = true;
            return 交出文本(乙路径.wstring());
        }
        boost::filesystem::path 结果 = 甲路径 / 乙路径;
        上次成功 = true;
        return 交出文本(结果.wstring());
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"合并路径失败", 异常);
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"合并路径失败：未知异常");
    }
}

extern "C" const wchar_t* FB_fs_filename(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"取文件名失败"))
        return L"";
    try
    {
        上次成功 = true;
        return 交出文本(路径.filename().wstring());
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取文件名失败", 异常);
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取文件名失败：未知异常");
    }
}

extern "C" const wchar_t* FB_fs_stem(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"取主文件名失败"))
        return L"";
    try
    {
        上次成功 = true;
        return 交出文本(路径.stem().wstring());
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取主文件名失败", 异常);
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取主文件名失败：未知异常");
    }
}

extern "C" const wchar_t* FB_fs_extension(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"取扩展名失败"))
        return L"";
    try
    {
        上次成功 = true;
        // 结果带点（例如 .txt）；没有扩展名时为空文本。
        return 交出文本(路径.extension().wstring());
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取扩展名失败", 异常);
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取扩展名失败：未知异常");
    }
}

extern "C" const wchar_t* FB_fs_parent(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"取父目录失败"))
        return L"";
    try
    {
        上次成功 = true;
        return 交出文本(路径.parent_path().wstring());
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取父目录失败", 异常);
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取父目录失败：未知异常");
    }
}

extern "C" int FB_fs_make_dir(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"建立目录失败"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        // 目录已存在时 create_directories 返回 false 但不设错误码，
        // 按约定"已存在也返回 1"，所以这里只看错误码。
        boost::filesystem::create_directories(路径, 错误码);
        if (错误码)
        {
            文件失败(L"建立目录失败", 错误码);
            return 0;
        }
        boost::filesystem::file_status 状态 = 取路径状态(路径, 错误码);
        if (错误码)
        {
            文件失败(L"建立目录失败", 错误码);
            return 0;
        }
        if (boost::filesystem::is_directory(状态))
        {
            上次成功 = true;
            return 1;
        }
        // 目标已存在但其实是文件：create_directories 会静默返回 false。
        记录错误(L"建立目录失败：同名文件已存在，无法建立目录");
        return 0;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"建立目录失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"建立目录失败：未知异常");
        return 0;
    }
}

extern "C" int FB_fs_remove_file(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"删除文件失败"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 状态 = 取路径状态(路径, 错误码);
        if (错误码)
        {
            文件失败(L"删除文件失败", 错误码);
            return 0;
        }
        if (!boost::filesystem::exists(状态))
        {
            上次成功 = true;
            return 1;                     // 幂等：本来就不存在
        }
        if (boost::filesystem::is_directory(状态))
        {
            记录错误(L"删除文件失败：目标是目录，请改用删除目录");
            return 0;
        }
        boost::filesystem::remove(路径, 错误码);
        if (错误码)
        {
            文件失败(L"删除文件失败", 错误码);
            return 0;
        }
        上次成功 = true;
        return 1;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"删除文件失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"删除文件失败：未知异常");
        return 0;
    }
}

extern "C" int FB_fs_remove_dir(const wchar_t* p)
{
    清空错误();
    boost::filesystem::path 路径;
    if (!建立文件路径(p, 路径, L"删除目录失败"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 状态 = 取路径状态(路径, 错误码);
        if (错误码)
        {
            文件失败(L"删除目录失败", 错误码);
            return 0;
        }
        if (!boost::filesystem::exists(状态))
        {
            上次成功 = true;
            return 1;                     // 幂等：本来就不存在
        }
        if (!boost::filesystem::is_directory(状态))
        {
            记录错误(L"删除目录失败：目标不是目录，请改用删除文件");
            return 0;
        }
        // 只删空目录：非空目录 boost 会以 ERROR_DIR_NOT_EMPTY 失败，正是需要的语义。
        boost::filesystem::remove(路径, 错误码);
        if (错误码)
        {
            错误缓冲 = L"删除目录失败：目录必须为空才能删除";
            std::wstring 说明 = 系统错误说明(错误码);
            if (!说明.empty())
            {
                错误缓冲 += L"（";
                错误缓冲 += 说明;
                错误缓冲 += L"）";
            }
            上次成功 = false;
            return 0;
        }
        上次成功 = true;
        return 1;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"删除目录失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"删除目录失败：未知异常");
        return 0;
    }
}

extern "C" int FB_fs_copy_file(const wchar_t* from, const wchar_t* to, int overwrite)
{
    清空错误();
    boost::filesystem::path 源路径;
    boost::filesystem::path 目标路径;
    if (!建立文件路径(from, 源路径, L"复制文件失败：源路径"))
        return 0;
    if (!建立文件路径(to, 目标路径, L"复制文件失败：目标路径"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 源状态 = 取路径状态(源路径, 错误码);
        if (错误码)
        {
            文件失败(L"复制文件失败", 错误码);
            return 0;
        }
        if (!boost::filesystem::exists(源状态))
        {
            记录错误(L"复制文件失败：源文件不存在");
            return 0;
        }
        if (boost::filesystem::is_directory(源状态))
        {
            记录错误(L"复制文件失败：源是目录，本方法只复制单个文件");
            return 0;
        }
        // boost 1.86 起选项类型是 enum class copy_options（旧名 copy_option 已移除）。
        boost::filesystem::copy_options 选项 = (overwrite != 0)
            ? boost::filesystem::copy_options::overwrite_existing
            : boost::filesystem::copy_options::none;
        boost::filesystem::copy_file(源路径, 目标路径, 选项, 错误码);
        if (错误码)
        {
            文件失败((overwrite != 0) ? L"复制文件失败" : L"复制文件失败：目标已存在（覆盖为假）",
                     错误码);
            return 0;
        }
        上次成功 = true;
        return 1;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"复制文件失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"复制文件失败：未知异常");
        return 0;
    }
}

extern "C" int FB_fs_rename(const wchar_t* from, const wchar_t* to)
{
    清空错误();
    boost::filesystem::path 源路径;
    boost::filesystem::path 目标路径;
    if (!建立文件路径(from, 源路径, L"移动文件失败：源路径"))
        return 0;
    if (!建立文件路径(to, 目标路径, L"移动文件失败：目标路径"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 源状态 = 取路径状态(源路径, 错误码);
        if (错误码)
        {
            文件失败(L"移动文件失败", 错误码);
            return 0;
        }
        if (!boost::filesystem::exists(源状态))
        {
            记录错误(L"移动文件失败：源路径不存在");
            return 0;
        }
        // boost 在 Windows 上底层用 MoveFileEx(MOVEFILE_REPLACE_EXISTING)，
        // 也就是说**会静默覆盖**同名目标。这里显式挡掉，避免"移过去把别人覆盖了"
        // 这类数据丢失；要覆盖请先自己删或改用 复制文件 (…, 真)。
        boost::filesystem::file_status 目标状态 = 取路径状态(目标路径, 错误码);
        if (错误码)
        {
            文件失败(L"移动文件失败", 错误码);
            return 0;
        }
        if (boost::filesystem::exists(目标状态))
        {
            记录错误(L"移动文件失败：目标已存在，本方法不覆盖");
            return 0;
        }
        boost::filesystem::rename(源路径, 目标路径, 错误码);
        if (错误码)
        {
            文件失败(L"移动文件失败", 错误码);
            return 0;
        }
        上次成功 = true;
        return 1;
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"移动文件失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"移动文件失败：未知异常");
        return 0;
    }
}

extern "C" intptr_t FB_fs_list(const wchar_t* dir, int recursive, int dirs_only)
{
    清空错误();
    boost::filesystem::path 基路径;
    if (!建立文件路径(dir, 基路径, L"枚举目录失败"))
        return 0;
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::file_status 状态 = 取路径状态(基路径, 错误码);
        if (错误码)
        {
            文件失败(L"枚举目录失败", 错误码);
            return 0;
        }
        if (!boost::filesystem::exists(状态))
        {
            记录错误(L"枚举目录失败：目录不存在");
            return 0;
        }
        if (!boost::filesystem::is_directory(状态))
        {
            记录错误(L"枚举目录失败：给出的路径不是目录");
            return 0;
        }
        // 用绝对路径做起点，保证每一项都是完整路径。
        boost::filesystem::path 绝对基 = boost::filesystem::absolute(基路径, 错误码);
        if (错误码)
        {
            文件失败(L"枚举目录失败", 错误码);
            return 0;
        }

        std::vector<std::wstring> 项;
        if (recursive != 0)
        {
            boost::filesystem::recursive_directory_iterator 起(
                绝对基, boost::filesystem::directory_options::skip_permission_denied, 错误码);
            boost::filesystem::recursive_directory_iterator 终;
            for (; !错误码 && 起 != 终; 起.increment(错误码))
            {
                bool 是目录 = 起->is_directory(错误码);
                if (错误码)
                    break;
                if (dirs_only != 0 && !是目录)
                    continue;
                项.push_back(起->path().wstring());
            }
        }
        else
        {
            boost::filesystem::directory_iterator 起(绝对基, 错误码);
            boost::filesystem::directory_iterator 终;
            for (; !错误码 && 起 != 终; 起.increment(错误码))
            {
                bool 是目录 = 起->is_directory(错误码);
                if (错误码)
                    break;
                if (dirs_only != 0 && !是目录)
                    continue;
                项.push_back(起->path().wstring());
            }
        }
        if (错误码)
        {
            文件失败(L"枚举目录失败", 错误码);
            return 0;
        }

        // 排序：文件系统的枚举顺序本身不保证稳定（NTFS 与 FAT 就不同），
        // 排一次序让"同一目录、同一参数"的两次调用结果完全一致。
        std::sort(项.begin(), 项.end());

        std::shared_ptr<分词结果> 结果(new 分词结果());
        结果->项.swap(项);
        上次成功 = true;
        return 分词句柄表.加入(结果);     // 复用既有分词句柄表
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"枚举目录失败", 异常);
        return 0;
    }
    catch (...)
    {
        记录错误(L"枚举目录失败：未知异常");
        return 0;
    }
}

extern "C" const wchar_t* FB_fs_temp_dir(void)
{
    清空错误();
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::path 结果 = boost::filesystem::temp_directory_path(错误码);
        if (错误码)
            return 文件失败(L"取临时目录失败", 错误码);
        上次成功 = true;
        return 交出文本(结果.wstring());
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取临时目录失败", 异常);
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取临时目录失败：未知异常");
    }
}

extern "C" const wchar_t* FB_fs_current_dir(void)
{
    清空错误();
    try
    {
        boost::system::error_code 错误码;
        boost::filesystem::path 结果 = boost::filesystem::current_path(错误码);
        if (错误码)
            return 文件失败(L"取当前目录失败", 错误码);
        上次成功 = true;
        return 交出文本(结果.wstring());
    }
    catch (const std::exception& 异常)
    {
        文件异常(L"取当前目录失败", 异常);
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取当前目录失败：未知异常");
    }
}

// =====================================================================
//  二十二、编码（Base64 与十六进制，v1.3 增量）
//
//  Base64 用 boost 的序列化迭代器（纯头文件）：
//    编码 base64_from_binary<transform_width<const char*, 6, 8> >
//    解码 transform_width<binary_from_base64<迭代器>, 8, 6>
//  语义按「文本的 UTF-8 字节」处理：这样 ASCII 输入与 RFC 4648 完全一致，
//  中文也不会因为 UTF-16 内部表示而被编成别的样子。
// =====================================================================
namespace {

// 宽文本转窄 ASCII；出现任何非 ASCII 字符即失败（Base64/Hex 输入必须全是 ASCII）。
bool 宽文本转ASCII(const std::wstring& 宽文本, std::string& 结果)
{
    结果.clear();
    结果.reserve(宽文本.size());
    for (size_t 序 = 0; 序 < 宽文本.size(); ++序)
    {
        wchar_t 字 = 宽文本[序];
        if (字 > 127 || 字 < 0)
            return false;
        结果.push_back((char)字);
    }
    return true;
}

// UTF-8 字节串转宽文本，同时做严格校验（非法序列返回 false）。
bool UTF8转宽文本(const std::string& 字节, std::wstring& 结果)
{
    结果.clear();
    结果.reserve(字节.size());
    size_t 序 = 0;
    while (序 < 字节.size())
    {
        unsigned char 首 = (unsigned char)字节[序];
        unsigned int 码点 = 0;
        size_t 后续 = 0;
        if (首 < 0x80)
        {
            码点 = 首;
            后续 = 0;
        }
        else if ((首 & 0xE0) == 0xC0)
        {
            码点 = (unsigned int)(首 & 0x1Fu);
            后续 = 1;
        }
        else if ((首 & 0xF0) == 0xE0)
        {
            码点 = (unsigned int)(首 & 0x0Fu);
            后续 = 2;
        }
        else if ((首 & 0xF8) == 0xF0)
        {
            码点 = (unsigned int)(首 & 0x07u);
            后续 = 3;
        }
        else
        {
            return false;                 // 0x80..0xBF 开头或 0xF8 以上：非法
        }
        if (序 + 后续 >= 字节.size() && 后续 > 0)
            return false;                 // 后续字节不够：截断
        for (size_t 位 = 1; 位 <= 后续; ++位)
        {
            unsigned char 续 = (unsigned char)字节[序 + 位];
            if ((续 & 0xC0) != 0x80)
                return false;             // 不是 10xxxxxx
            码点 = (码点 << 6) | (unsigned int)(续 & 0x3Fu);
        }
        if (后续 == 1 && 码点 < 0x80) return false;        // 过长编码
        if (后续 == 2 && 码点 < 0x800) return false;
        if (后续 == 3 && 码点 < 0x10000) return false;
        if (码点 > 0x10FFFF) return false;                 // 超出 Unicode 范围
        if (码点 >= 0xD800 && 码点 <= 0xDFFF) return false; // 代理区不允许直接编码
        if (码点 < 0x10000)
        {
            结果.push_back((wchar_t)码点);
        }
        else
        {
            unsigned int 偏移 = 码点 - 0x10000;
            结果.push_back((wchar_t)(0xD800 + (偏移 >> 10)));
            结果.push_back((wchar_t)(0xDC00 + (偏移 & 0x3FF)));
        }
        序 += 后续 + 1;
    }
    return true;
}

bool 是Base64字符(wchar_t 字)
{
    if (字 >= L'A' && 字 <= L'Z') return true;
    if (字 >= L'a' && 字 <= L'z') return true;
    if (字 >= L'0' && 字 <= L'9') return true;
    return (字 == L'+') || (字 == L'/');
}

int 取十六进制值(wchar_t 字)
{
    if (字 >= L'0' && 字 <= L'9') return (int)(字 - L'0');
    if (字 >= L'a' && 字 <= L'f') return (int)(字 - L'a') + 10;
    if (字 >= L'A' && 字 <= L'F') return (int)(字 - L'A') + 10;
    return -1;
}

} // namespace

extern "C" const wchar_t* FB_b64_encode(const wchar_t* s)
{
    清空错误();
    try
    {
        std::string 字节 = 转为UTF8(取文本(s));
        if (字节.empty())
        {
            上次成功 = true;
            return 交出文本(L"");
        }
        typedef boost::archive::iterators::transform_width<const char*, 6, 8> 六位迭代器;
        typedef boost::archive::iterators::base64_from_binary<六位迭代器>    编码迭代器;
        std::string 编码文本(编码迭代器(字节.data()), 编码迭代器(字节.data() + 字节.size()));
        // 补齐到 4 的倍数（RFC 4648 的 = 填充）
        while (编码文本.size() % 4 != 0)
            编码文本.push_back('=');
        上次成功 = true;
        return 交出文本(宽化(编码文本));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"Base64 编码失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"Base64 编码失败：未知异常");
    }
}

extern "C" const wchar_t* FB_b64_decode(const wchar_t* s)
{
    清空错误();
    try
    {
        std::wstring 原文本 = 取文本(s);
        if (原文本.empty())
        {
            上次成功 = true;
            return 交出文本(L"");
        }
        // 先去掉尾部填充符：留着它们会让解码迭代器按 4 个字符一组吐出多余的 0 字节。
        size_t 有效长度 = 原文本.size();
        while (有效长度 > 0 && 原文本[有效长度 - 1] == L'=')
            --有效长度;
        if (有效长度 == 0)
        {
            记录错误(L"Base64 解码失败：文本只有填充符");
            return L"";
        }
        std::string 输入;
        输入.reserve(有效长度);
        for (size_t 序 = 0; 序 < 有效长度; ++序)
        {
            wchar_t 字 = 原文本[序];
            if (!是Base64字符(字))
            {
                记录错误(L"Base64 解码失败：含有非法字符（只允许 A-Z a-z 0-9 + / 与尾部 = ）");
                return L"";
            }
            输入.push_back((char)字);
        }
        if (输入.size() % 4 == 1)
        {
            记录错误(L"Base64 解码失败：去掉填充符后的长度不合法（不可能余 1）");
            return L"";
        }

        typedef boost::archive::iterators::binary_from_base64<std::string::const_iterator> 六位解码器;
        typedef boost::archive::iterators::transform_width<六位解码器, 8, 6>               解码迭代器;
        std::string 字节(解码迭代器(输入.begin()), 解码迭代器(输入.end()));
        // 迭代器按 6 位一组吐字节，理论上长度正好；这里再按数学期望截一次，
        // 防止实现细节差异带来的尾部 0 字节。
        size_t 期望长度 = 输入.size() * 6 / 8;
        if (字节.size() > 期望长度)
            字节.resize(期望长度);

        std::wstring 结果;
        if (!UTF8转宽文本(字节, 结果))
        {
            记录错误(L"Base64 解码失败：解码结果不是合法的 UTF-8 文本");
            return L"";
        }
        上次成功 = true;
        return 交出文本(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"Base64 解码失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"Base64 解码失败：未知异常");
    }
}

extern "C" const wchar_t* FB_hex_encode(const wchar_t* s)
{
    清空错误();
    try
    {
        std::string 字节 = 转为UTF8(取文本(s));
        static const char 十六进制表[] = "0123456789abcdef";
        std::string 结果;
        结果.reserve(字节.size() * 2);
        for (size_t 序 = 0; 序 < 字节.size(); ++序)
        {
            unsigned char 值 = (unsigned char)字节[序];
            结果.push_back(十六进制表[(值 >> 4) & 0x0F]);
            结果.push_back(十六进制表[值 & 0x0F]);
        }
        上次成功 = true;
        return 交出文本(宽化(结果));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"十六进制编码失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"十六进制编码失败：未知异常");
    }
}

extern "C" const wchar_t* FB_hex_decode(const wchar_t* s)
{
    清空错误();
    try
    {
        std::wstring 原文本 = 取文本(s);
        if (原文本.empty())
        {
            上次成功 = true;
            return 交出文本(L"");
        }
        if (原文本.size() % 2 != 0)
        {
            记录错误(L"十六进制解码失败：字符个数必须为偶数");
            return L"";
        }
        std::string 字节;
        字节.reserve(原文本.size() / 2);
        for (size_t 序 = 0; 序 + 1 < 原文本.size(); 序 += 2)
        {
            int 高 = 取十六进制值(原文本[序]);
            int 低 = 取十六进制值(原文本[序 + 1]);
            if (高 < 0 || 低 < 0)
            {
                记录错误(L"十六进制解码失败：含有非十六进制字符");
                return L"";
            }
            字节.push_back((char)(unsigned char)((高 << 4) | 低));
        }
        std::wstring 结果;
        if (!UTF8转宽文本(字节, 结果))
        {
            记录错误(L"十六进制解码失败：解码结果不是合法的 UTF-8 文本");
            return L"";
        }
        上次成功 = true;
        return 交出文本(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"十六进制解码失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"十六进制解码失败：未知异常");
    }
}

// =====================================================================
//  十七、哈希（SHA1 / MD5，v1.4）
//  设计说明：
//   1. 两个摘要器都是 boost/uuid/detail 下的「内部实现头」。选它们的原因是
//      完全内联、不产生任何链接依赖（不需要编译 boost 库），代价是它们不在
//      boost 公开 API 的兼容承诺内：升级 boost 时如果头文件改名或接口变化，
//      表现为编译报错，而不会在运行期悄悄换掉哈希结果。
//   2. 输入一律取文本的 **UTF-8 字节**，因此 RFC 3174 / RFC 1321 的标准
//      测试向量逐字相等，也与其他语言、其他工具的 hash("这个字符串") 一致。
//   3. get_digest 会改写摘要器内部状态（追加填充位），所以每个摘要器对象
//      只能用一次；文件版因此也在函数内部新建对象。
//   4. 文件版按 64 KiB 分块读取，大文件不需要一次性装进内存。
// =====================================================================
namespace {

// 把一段摘要字节格式化成小写十六进制文本（每字节两位）。
std::wstring 摘要转十六进制文本(const unsigned char* 摘要, size_t 字节数)
{
    static const wchar_t 十六进制表[] = L"0123456789abcdef";
    std::wstring 结果;
    结果.reserve(字节数 * 2);
    for (size_t 序 = 0; 序 < 字节数; ++序)
    {
        结果.push_back(十六进制表[(摘要[序] >> 4) & 0x0F]);
        结果.push_back(十六进制表[摘要[序] & 0x0F]);
    }
    return 结果;
}

// 分块读文件算摘要。摘要器类型只需要提供 process_bytes 与 get_digest，
// boost 的 sha1 与 md5 正好同形，所以同一段读取逻辑可以复用。
// 摘要参数用 digest_type 的引用（它是 unsigned char[20] / [16] 的数组类型），
// 这样 sizeof 就能直接得到字节数，不必在调用处再手写一遍。
template <typename 摘要器类型>
bool 计算文件摘要(const std::wstring& 路径文本,
                   typename 摘要器类型::digest_type& 摘要,
                   std::wstring& 错误说明)
{
    if (路径文本.empty())
    {
        错误说明 = L"计算文件哈希：路径文本为空";
        return false;
    }
    FILE* 文件 = nullptr;
    // 用 _wfopen_s 而不是 _wfopen：后者在 /W3 下报 C4996（不安全函数），
    // 而本模块要求「0 警告」，所以直接用带返回码的安全版本，不改编译开关。
    const errno_t 打开结果 = _wfopen_s(&文件, 路径文本.c_str(), L"rb");
    if (打开结果 != 0 || 文件 == nullptr)
    {
        错误说明 = L"计算文件哈希：无法打开文件（路径不存在或没有读取权限）";
        return false;
    }
    bool 成功 = true;
    摘要器类型 摘要器;
    {
        std::vector<char> 缓冲(65536);
        for (;;)
        {
            size_t 读入 = fread(&缓冲[0], 1, 缓冲.size(), 文件);
            if (读入 > 0)
                摘要器.process_bytes(&缓冲[0], 读入);
            if (读入 < 缓冲.size())
            {
                if (ferror(文件) != 0)
                {
                    错误说明 = L"计算文件哈希：读取文件内容失败";
                    成功 = false;
                }
                break;
            }
        }
    }
    fclose(文件);
    if (!成功)
        return false;
    摘要器.get_digest(摘要);
    return true;
}

} // namespace

extern "C" const wchar_t* FB_hash_sha1_text(const wchar_t* s)
{
    清空错误();
    try
    {
        std::string 字节 = 转为UTF8(取文本(s));
        boost::uuids::detail::sha1 摘要器;
        if (!字节.empty())
            摘要器.process_bytes(字节.data(), 字节.size());
        boost::uuids::detail::sha1::digest_type 摘要;
        摘要器.get_digest(摘要);
        上次成功 = true;
        return 交出文本(摘要转十六进制文本(摘要, sizeof(摘要)));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"SHA1 计算失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"SHA1 计算失败：未知异常");
    }
}

extern "C" const wchar_t* FB_hash_sha1_file(const wchar_t* path)
{
    清空错误();
    try
    {
        boost::uuids::detail::sha1::digest_type 摘要;
        std::wstring 错误说明;
        if (!计算文件摘要<boost::uuids::detail::sha1>(取文本(path), 摘要, 错误说明))
            return 记录错误(错误说明.c_str());
        上次成功 = true;
        return 交出文本(摘要转十六进制文本(摘要, sizeof(摘要)));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"SHA1 文件计算失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"SHA1 文件计算失败：未知异常");
    }
}

extern "C" const wchar_t* FB_hash_md5_text(const wchar_t* s)
{
    清空错误();
    try
    {
        std::string 字节 = 转为UTF8(取文本(s));
        boost::uuids::detail::md5 摘要器;
        if (!字节.empty())
            摘要器.process_bytes(字节.data(), 字节.size());
        boost::uuids::detail::md5::digest_type 摘要;
        摘要器.get_digest(摘要);
        上次成功 = true;
        return 交出文本(摘要转十六进制文本(摘要, sizeof(摘要)));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"MD5 计算失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"MD5 计算失败：未知异常");
    }
}

extern "C" const wchar_t* FB_hash_md5_file(const wchar_t* path)
{
    清空错误();
    try
    {
        boost::uuids::detail::md5::digest_type 摘要;
        std::wstring 错误说明;
        if (!计算文件摘要<boost::uuids::detail::md5>(取文本(path), 摘要, 错误说明))
            return 记录错误(错误说明.c_str());
        上次成功 = true;
        return 交出文本(摘要转十六进制文本(摘要, sizeof(摘要)));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"MD5 文件计算失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"MD5 文件计算失败：未知异常");
    }
}

// =====================================================================
//  十八、CSV 文档（v1.4，自研解析器）
//  为什么不用 boost/tokenizer：tokenizer 没有「引号字段」的概念，字段里出现
//  分隔符或换行就必然拆错，而带引号的多行字段正是 CSV 最常用的场景。
//  这里实现的是本类文档化的规则：
//   1. 字段以双引号开头即「引号字段」；内部连续两个双引号表示一个双引号；
//   2. 引号内的分隔符与换行都是普通字符（因此支持多行字段）；
//   3. 引号字段闭合后到分隔符之间的空格与制表符忽略；
//   4. 各行的列数可以不相同；
//   5. 完全空的行跳过，行尾多余的尾随空列保留（"a,b," 是三列）；
//   6. 全空文本得到 0 行；换行符 \r\n、\n、\r 混用也接受。
// =====================================================================
namespace {

struct 表格文档
{
    std::vector<std::vector<std::wstring>> 行集;
};

句柄表<表格文档> 表格句柄表;

// 分隔符参数是文本型：空文本或空指针都用英文逗号，多字符只取第一个字符。
// 这样火山侧只需要一个文本参数，不需要为「分隔符」再定义一个类型。
wchar_t 取CSV分隔符(const std::wstring& 分隔符文本)
{
    if (分隔符文本.empty())
        return L',';
    return 分隔符文本[0];
}

// 真正的解析过程：一次扫描完成，不需要回溯，也不会因为字段跨行而复制整份文本。
void 解析CSV文本(const std::wstring& 文本, wchar_t 分隔符, 表格文档& 文档)
{
    文档.行集.clear();
    const size_t 总长 = 文本.size();
    size_t 位置 = 0;
    while (位置 < 总长)
    {
        std::vector<std::wstring> 行;
        bool 本行有内容 = false;             // 只有分隔符或引号字段才算「不是空行」
        bool 本行结束 = false;
        while (!本行结束)
        {
            std::wstring 字段;
            if (位置 < 总长 && 文本[位置] == L'"')
            {
                本行有内容 = true;            // 引号字段即使是空串也算有内容
                ++位置;
                while (位置 < 总长)
                {
                    if (文本[位置] == L'"')
                    {
                        if (位置 + 1 < 总长 && 文本[位置 + 1] == L'"')
                        {
                            字段.push_back(L'"');  // "" 转义成一个双引号
                            位置 += 2;
                            continue;
                        }
                        ++位置;                    // 闭合引号，不要把它算进字段
                        break;
                    }
                    字段.push_back(文本[位置]);
                    ++位置;
                }
                // 引号闭合后到分隔符之间的空白忽略；引号没闭合时也照此收尾（宽容处理）
                while (位置 < 总长 && (文本[位置] == L' ' || 文本[位置] == L'\t'))
                    ++位置;
            }
            else
            {
                while (位置 < 总长 && 文本[位置] != 分隔符 &&
                       文本[位置] != L'\r' && 文本[位置] != L'\n')
                {
                    字段.push_back(文本[位置]);
                    ++位置;
                }
            }
            if (!字段.empty())
                本行有内容 = true;
            行.push_back(字段);

            if (位置 >= 总长)
            {
                本行结束 = true;
            }
            else if (文本[位置] == 分隔符)
            {
                ++位置;
                本行有内容 = true;                // 见到分隔符即视为多列，"a,b," 的尾随空列要保留
                if (位置 >= 总长)
                {
                    行.push_back(L"");            // 文本正好以分隔符收尾
                    本行结束 = true;
                }
            }
            else if (文本[位置] == L'\r')
            {
                ++位置;
                if (位置 < 总长 && 文本[位置] == L'\n')
                    ++位置;                        // 吃掉 CRLF 的 LF
                本行结束 = true;
            }
            else if (文本[位置] == L'\n')
            {
                ++位置;
                本行结束 = true;
            }
            else
            {
                ++位置;                            // 防御性分支：正常不会走到
                本行结束 = true;
            }
        }
        if (本行有内容)
            文档.行集.push_back(行);
    }
}

// 该字段在重新输出时是否需要加引号：
// 含分隔符、含双引号、含换行，或首尾有空白（否则再解析时空白会被吃掉）。
bool 字段需要加引号(const std::wstring& 字段, wchar_t 分隔符)
{
    if (字段.empty())
        return false;                          // 空字段不加引号，保证 "a,b," 仍然输出 "a,b,"
    if (字段.find(分隔符) != std::wstring::npos)
        return true;
    if (字段.find(L'"') != std::wstring::npos)
        return true;
    if (字段.find(L'\r') != std::wstring::npos)
        return true;
    if (字段.find(L'\n') != std::wstring::npos)
        return true;
    if (字段[0] == L' ' || 字段[0] == L'\t')
        return true;
    if (字段[字段.size() - 1] == L' ' || 字段[字段.size() - 1] == L'\t')
        return true;
    return false;
}

// 按 CSV 规则输出一个字段：需要时加引号，并把内部的双引号写成两个。
void 写出CSV字段(std::wstring& 目标, const std::wstring& 字段, wchar_t 分隔符)
{
    if (!字段需要加引号(字段, 分隔符))
    {
        目标 += 字段;
        return;
    }
    目标.push_back(L'"');
    for (size_t 序 = 0; 序 < 字段.size(); ++序)
    {
        if (字段[序] == L'"')
            目标.push_back(L'"');              // 一个双引号写成两个
        目标.push_back(字段[序]);
    }
    目标.push_back(L'"');
}

} // namespace

extern "C" intptr_t FB_csv_parse(const wchar_t* text, const wchar_t* sep)
{
    清空错误();
    try
    {
        std::shared_ptr<表格文档> 文档 = std::make_shared<表格文档>();
        解析CSV文本(取文本(text), 取CSV分隔符(取文本(sep)), *文档);
        上次成功 = true;
        return 表格句柄表.加入(文档);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"CSV 解析失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"CSV 解析失败：未知异常");
        return 0;
    }
}

extern "C" int FB_csv_rows(intptr_t h)
{
    std::shared_ptr<表格文档> 文档 = 表格句柄表.取(h);
    if (!文档)
        return -1;
    return (int)文档->行集.size();
}

extern "C" int FB_csv_cols(intptr_t h, int row)
{
    std::shared_ptr<表格文档> 文档 = 表格句柄表.取(h);
    if (!文档)
        return -1;
    if (row < 0 || (size_t)row >= 文档->行集.size())
        return 0;
    return (int)文档->行集[(size_t)row].size();
}

extern "C" const wchar_t* FB_csv_cell(intptr_t h, int row, int col)
{
    std::shared_ptr<表格文档> 文档 = 表格句柄表.取(h);
    if (!文档)
        return 交出文本(L"");
    if (row < 0 || (size_t)row >= 文档->行集.size())
        return 交出文本(L"");
    const std::vector<std::wstring>& 行 = 文档->行集[(size_t)row];
    if (col < 0 || (size_t)col >= 行.size())
        return 交出文本(L"");
    return 交出文本(行[(size_t)col]);
}

extern "C" const wchar_t* FB_csv_row_text(intptr_t h, int row, const wchar_t* sep)
{
    std::shared_ptr<表格文档> 文档 = 表格句柄表.取(h);
    if (!文档)
        return 交出文本(L"");
    if (row < 0 || (size_t)row >= 文档->行集.size())
        return 交出文本(L"");
    const std::wstring 分隔符文本 = 取文本(sep);
    // 分隔符只取首字符：解析侧（取CSV分隔符）也只认首字符，两侧必须一致，
    // 否则「取整行 / 转文本 → 解析」的往返会散架（"a,b,c" 用 "||" 输出成
    // a||b||c，解析侧按单字符 '|' 切成 5 列）。见 README 第十节第 9 条。
    const wchar_t 分隔符字符 = 分隔符文本.empty() ? L',' : 分隔符文本[0];
    const std::vector<std::wstring>& 行 = 文档->行集[(size_t)row];
    std::wstring 结果;
    for (size_t 序 = 0; 序 < 行.size(); ++序)
    {
        if (序 > 0)
            结果.push_back(分隔符字符);
        结果 += 行[序];                        // 取整行不转义，只做连接
    }
    return 交出文本(结果);
}

extern "C" int FB_csv_set(intptr_t h, int row, int col, const wchar_t* v)
{
    std::shared_ptr<表格文档> 文档 = 表格句柄表.取(h);
    if (!文档)
        return 0;
    if (row < 0 || (size_t)row >= 文档->行集.size())
        return 0;
    std::vector<std::wstring>& 行 = 文档->行集[(size_t)row];
    if (col < 0 || (size_t)col >= 行.size())
        return 0;                              // 不自动扩列：越界就是失败
    行[(size_t)col] = 取文本(v);
    return 1;
}

extern "C" const wchar_t* FB_csv_dump(intptr_t h, const wchar_t* sep)
{
    std::shared_ptr<表格文档> 文档 = 表格句柄表.取(h);
    if (!文档)
        return 交出文本(L"");
    const std::wstring 分隔符文本 = 取文本(sep);
    // 与 FB_csv_row_text 同一规则：只输出分隔符的首字符，保证输出能被
    // 解析侧（取CSV分隔符，同样只取首字符）原样读回。
    const wchar_t 分隔符字符 = 分隔符文本.empty() ? L',' : 分隔符文本[0];
    std::wstring 结果;
    for (size_t 行序 = 0; 行序 < 文档->行集.size(); ++行序)
    {
        if (行序 > 0)
            结果 += L"\r\n";                   // 行间用 CRLF，解析时三种换行都吃
        const std::vector<std::wstring>& 行 = 文档->行集[行序];
        for (size_t 列序 = 0; 列序 < 行.size(); ++列序)
        {
            if (列序 > 0)
                结果.push_back(分隔符字符);
            写出CSV字段(结果, 行[列序], 分隔符字符);
        }
    }
    return 交出文本(结果);
}

extern "C" int FB_csv_free(intptr_t h)
{
    return 表格句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  十九、URL 编码与查询串（v1.4）
//  编码按文本的 **UTF-8 字节** 处理，因此结果是标准百分号编码：
//    A-Z a-z 0-9 - _ . ~ 原样保留，空格编成 %20（表单版编成 +），
//    其余字节编成 %XX，十六进制字母大写。
//  解码把 %XX 还原成字节、把 + 还原成空格；非法的 % 序列原样保留
//  （既不吞字符也不崩），还原出的字节若不是合法 UTF-8 就逐字节宽化，
//  保证「编进去的东西一定还能拿出来」。
// =====================================================================
namespace {

int 取URL十六进制值(wchar_t 字)
{
    if (字 >= L'0' && 字 <= L'9') return (int)(字 - L'0');
    if (字 >= L'a' && 字 <= L'f') return (int)(字 - L'a') + 10;
    if (字 >= L'A' && 字 <= L'F') return (int)(字 - L'A') + 10;
    return -1;
}

bool 是URL安全字符(unsigned char 值)
{
    if (值 >= 'A' && 值 <= 'Z') return true;
    if (值 >= 'a' && 值 <= 'z') return true;
    if (值 >= '0' && 值 <= '9') return true;
    return 值 == '-' || 值 == '_' || 值 == '.' || 值 == '~';
}

std::string 执行URL编码(const std::wstring& 原文本, bool 表单模式)
{
    const std::string 字节 = 转为UTF8(原文本);
    static const char 十六进制表[] = "0123456789ABCDEF";
    std::string 结果;
    结果.reserve(字节.size() * 3);
    for (size_t 序 = 0; 序 < 字节.size(); ++序)
    {
        const unsigned char 值 = (unsigned char)字节[序];
        if (是URL安全字符(值))
        {
            结果.push_back((char)值);
        }
        else if (表单模式 && 值 == 0x20)
        {
            结果.push_back('+');                // 表单版：空格用加号
        }
        else
        {
            结果.push_back('%');
            结果.push_back(十六进制表[(值 >> 4) & 0x0F]);
            结果.push_back(十六进制表[值 & 0x0F]);
        }
    }
    return 结果;
}

std::wstring 执行URL解码(const std::wstring& 原文本)
{
    std::string 字节;
    字节.reserve(原文本.size());
    std::wstring 待编码;                        // 非 % 的宽字符先攒起来，按码点整体转 UTF-8
    for (size_t 序 = 0; 序 < 原文本.size(); ++序)
    {
        const wchar_t 字 = 原文本[序];
        if (字 == L'%' && 序 + 2 < 原文本.size())
        {
            const int 高 = 取URL十六进制值(原文本[序 + 1]);
            const int 低 = 取URL十六进制值(原文本[序 + 2]);
            if (高 >= 0 && 低 >= 0)
            {
                if (!待编码.empty())
                {
                    字节 += 转为UTF8(待编码);
                    待编码.clear();
                }
                字节.push_back((char)(unsigned char)((高 << 4) | 低));
                序 += 2;
                continue;
            }
            // 非法的 % 序列：落到下面按普通字符处理，原样保留
        }
        if (字 == L'+')
        {
            if (!待编码.empty())
            {
                字节 += 转为UTF8(待编码);
                待编码.clear();
            }
            字节.push_back(' ');
            continue;
        }
        待编码.push_back(字);
    }
    if (!待编码.empty())
        字节 += 转为UTF8(待编码);

    std::wstring 结果;
    if (!UTF8转宽文本(字节, 结果))
        结果 = 宽化(字节);                      // 不是合法 UTF-8：逐字节宽化，不丢数据也不崩
    return 结果;
}

// 把查询串切成「名=值」片段：可选前导问号，按 & 分段，空片段跳过。
std::vector<std::wstring> 切分查询串(const std::wstring& 查询串)
{
    std::vector<std::wstring> 片段;
    size_t 起点 = 0;
    if (!查询串.empty() && 查询串[0] == L'?')
        起点 = 1;
    std::wstring 当前;
    for (size_t 序 = 起点; 序 < 查询串.size(); ++序)
    {
        if (查询串[序] == L'&')
        {
            if (!当前.empty())
                片段.push_back(当前);
            当前.clear();
        }
        else
        {
            当前.push_back(查询串[序]);
        }
    }
    if (!当前.empty())
        片段.push_back(当前);
    return 片段;
}

} // namespace

extern "C" const wchar_t* FB_url_encode(const wchar_t* s)
{
    清空错误();
    try
    {
        上次成功 = true;
        return 交出文本(宽化(执行URL编码(取文本(s), false)));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"URL 编码失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"URL 编码失败：未知异常");
    }
}

extern "C" const wchar_t* FB_url_encode_form(const wchar_t* s)
{
    清空错误();
    try
    {
        上次成功 = true;
        return 交出文本(宽化(执行URL编码(取文本(s), true)));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"URL 表单编码失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"URL 表单编码失败：未知异常");
    }
}

extern "C" const wchar_t* FB_url_decode(const wchar_t* s)
{
    清空错误();
    try
    {
        上次成功 = true;
        return 交出文本(执行URL解码(取文本(s)));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"URL 解码失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"URL 解码失败：未知异常");
    }
}

extern "C" int FB_url_query_count(const wchar_t* query)
{
    清空错误();
    try
    {
        上次成功 = true;
        return (int)切分查询串(取文本(query)).size();
    }
    catch (...)
    {
        记录错误(L"查询串解析失败：未知异常");
        return 0;
    }
}

extern "C" const wchar_t* FB_url_query_key_at(const wchar_t* query, int index)
{
    清空错误();
    try
    {
        const std::vector<std::wstring> 片段 = 切分查询串(取文本(query));
        if (index < 0 || (size_t)index >= 片段.size())
        {
            上次成功 = true;
            return 交出文本(L"");
        }
        const std::wstring 片段文本 = 片段[(size_t)index];
        const size_t 等号位置 = 片段文本.find(L'=');
        const std::wstring 名 = (等号位置 == std::wstring::npos)
                                    ? 片段文本
                                    : 片段文本.substr(0, 等号位置);
        上次成功 = true;
        return 交出文本(执行URL解码(名));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"取查询串参数名失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取查询串参数名失败：未知异常");
    }
}

extern "C" const wchar_t* FB_url_query_value_at(const wchar_t* query, int index)
{
    清空错误();
    try
    {
        const std::vector<std::wstring> 片段 = 切分查询串(取文本(query));
        if (index < 0 || (size_t)index >= 片段.size())
        {
            上次成功 = true;
            return 交出文本(L"");
        }
        const std::wstring 片段文本 = 片段[(size_t)index];
        const size_t 等号位置 = 片段文本.find(L'=');
        if (等号位置 == std::wstring::npos)
        {
            上次成功 = true;
            return 交出文本(L"");              // 没有等号就没有值
        }
        上次成功 = true;
        return 交出文本(执行URL解码(片段文本.substr(等号位置 + 1)));
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"取查询串参数值失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取查询串参数值失败：未知异常");
    }
}

extern "C" const wchar_t* FB_url_query_get(const wchar_t* query, const wchar_t* key, const wchar_t* def)
{
    清空错误();
    try
    {
        const std::wstring 目标键 = 取文本(key);
        const std::wstring 兜底值 = 取文本(def);
        const std::vector<std::wstring> 片段 = 切分查询串(取文本(query));
        for (size_t 序 = 0; 序 < 片段.size(); ++序)
        {
            const size_t 等号位置 = 片段[序].find(L'=');
            const bool 有等号 = (等号位置 != std::wstring::npos);
            // 没有等号的段，整段都是名字（与 取参数名 一致）
            const std::wstring 段名 = 有等号
                                          ? 片段[序].substr(0, 等号位置)
                                          : 片段[序];
            if (执行URL解码(段名) != 目标键)
                continue;                      // 重复键取第一个：命中即返回
            上次成功 = true;
            if (!有等号)
                return 交出文本(L"");          // 键存在但没有等号：值为空文本，不回落默认值
            return 交出文本(执行URL解码(片段[序].substr(等号位置 + 1)));
        }
        上次成功 = true;
        return 交出文本(兜底值);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"取查询串参数失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"取查询串参数失败：未知异常");
    }
}

// =====================================================================
//  二十一、文本文件读写（v1.5，Win32 代码页转换）
//  设计前提：火山侧的用户永远只看到「文本」，看不到「字节」。
//  所有 GBK / UTF-8 / UTF-16 的转换都在本层内部完成，原因很实际：
//   1) 火山没有「无符号字节数组」这种好用的类型，一旦把字节交给用户，
//      用户就得自己写一套转换，等于把最容易出错的部分外包给调用方；
//   2) 「每个 wchar 存一个字节」那种伪字节串在中文上必然出错，
//      因为 0x81 之类的值在 UTF-16 里是控制字符 U+0081，过一次文本
//      处理就可能被当成空白或非法字符处理掉。
//  编码参数与火山侧的常量类严格一一对应：
//    0=自动  1=UTF-8  2=GBK(936)  3=UTF-16LE  4=UTF-16BE  5=GBK 宽松（只写）
//  自动判定的顺序是「BOM 优先，其次严格试解 UTF-8，最后回退 GBK」。
//  纯 ASCII 会被判成 UTF-8——这不是近似，ASCII 本身就是合法 UTF-8，
//  两种解释解出来的字符完全相同，所以报 1 是准确的。
//  「两种解释都合法」的字节串一律判 UTF-8：E4 B8 AD 41 既是合法 UTF-8
//  （"中A"）又是合法 GBK（U+6D93 U+747C），这里必须选 UTF-8；这种 GBK 文件
//  只能显式传 2 才读得对。
//  GBK 写在默认（编码 2）下是**严格**的：CP936 表示不了的字符一律拒绝写入，
//  一个字节都不落盘，原文件保持不变；要「替换成 ?」必须显式用编码 5。
//  这个选择是刻意的——静默丢数据比报错难查得多。
// =====================================================================
namespace {

// 编码常量（值与火山侧「文件工具」类里公开的常量保持一致）。
const int 编码_自动    = 0;
const int 编码_UTF8    = 1;
const int 编码_GBK     = 2;
const int 编码_UTF16LE = 3;
const int 编码_UTF16BE = 4;
// v1.5 修复轮：GBK 宽松（**只在写入时有意义**）。
// 单独给一个取值，就是为了让「默认拒绝」成为唯一安全的默认行为：
// 编码 2 遇到 CP936 表示不了的字符（emoji、CJK 扩展 A 区汉字等）直接拒绝写入，
// 只有用户明确写 5 才允许把它们替换成 '?'。读取侧仍然只接受 0~4——
// 读 GBK 本来就不做严格校验，不存在「严格读 / 宽松读」两种读法。
const int 编码_GBK宽松 = 5;

// GBK 就是 Windows 的简体中文代码页 936。
const UINT 代码页_GBK = 936;

// 读取上限：超过这个尺寸直接报错返回，绝不尝试装进内存。
// 64 MiB 是一个折中：足够覆盖任何真实的 CSV / INI / 日志文本，
// 又小到即使连续误调用也不会把进程撑爆。
const long long 文本文件读取上限 = 64LL * 1024 * 1024;

// 取文件的字节数；拿不到返回 -1。只用于「追加写之前判断要不要写 BOM」。
long long 取文件字节数(const std::wstring& 路径文本)
{
    if (路径文本.empty())
        return -1;
    struct _stat64 信息;
    if (_wstat64(路径文本.c_str(), &信息) != 0)
        return -1;
    return (long long)信息.st_size;
}

bool 起始字节是(const std::vector<char>& 字节, size_t 位置, unsigned char 甲)
{
    return 字节.size() > 位置 && (unsigned char)字节[位置] == 甲;
}

bool 有UTF8BOM(const std::vector<char>& 字节)
{
    return 字节.size() >= 3 && 起始字节是(字节, 0, 0xEF) &&
           起始字节是(字节, 1, 0xBB) && 起始字节是(字节, 2, 0xBF);
}

bool 有UTF16LEBOM(const std::vector<char>& 字节)
{
    return 字节.size() >= 2 && 起始字节是(字节, 0, 0xFF) && 起始字节是(字节, 1, 0xFE);
}

bool 有UTF16BEBOM(const std::vector<char>& 字节)
{
    return 字节.size() >= 2 && 起始字节是(字节, 0, 0xFE) && 起始字节是(字节, 1, 0xFF);
}

// 判定一段字节的编码，返回 1/2/3/4。
// 顺序：BOM → 严格 UTF-8 校验 → 回退 GBK。
int 判定编码(const std::vector<char>& 字节)
{
    if (有UTF8BOM(字节))
        return 编码_UTF8;
    if (有UTF16LEBOM(字节))
        return 编码_UTF16LE;
    if (有UTF16BEBOM(字节))
        return 编码_UTF16BE;
    if (字节.empty())
        return 编码_UTF8;                 // 空文件：解出来就是空文本，报 UTF-8 不会误导
    // MB_ERR_INVALID_CHARS 让 MultiByteToWideChar 在遇到非法序列时返回 0，
    // 而不是悄悄插入 U+FFFD——只有这样才能把「UTF-8」和「GBK」区分开。
    const int 字符数 = MultiByteToWideChar(CP_UTF8, MB_ERR_INVALID_CHARS,
                                           &字节[0], (int)字节.size(), nullptr, 0);
    if (字符数 > 0)
        return 编码_UTF8;
    return 编码_GBK;
}

// 按代码页把多字节文本解成宽文本。
bool 多字节转宽文本(UINT 代码页, DWORD 标志, const char* 数据, size_t 字节数,
                    const wchar_t* 失败说明, std::wstring& 结果, std::wstring& 错误说明)
{
    结果.clear();
    if (字节数 == 0)
        return true;
    if (字节数 > (size_t)INT_MAX)
    {
        错误说明 = 失败说明;
        return false;
    }
    const int 字符数 = MultiByteToWideChar(代码页, 标志, 数据, (int)字节数, nullptr, 0);
    if (字符数 <= 0)
    {
        错误说明 = 失败说明;
        return false;
    }
    结果.assign((size_t)字符数, L'\0');
    const int 写入数 = MultiByteToWideChar(代码页, 标志, 数据, (int)字节数, &结果[0], 字符数);
    if (写入数 <= 0)
    {
        结果.clear();
        错误说明 = 失败说明;
        return false;
    }
    结果.resize((size_t)写入数);
    return true;
}

// UTF-16 字节流解成宽文本；字节序由参数决定，BOM 已由调用方剥掉。
bool UTF16转宽文本(const char* 数据, size_t 字节数, bool 小端,
                   std::wstring& 结果, std::wstring& 错误说明)
{
    结果.clear();
    if ((字节数 % 2) != 0)
    {
        错误说明 = L"读取文本文件：UTF-16 内容的字节数为奇数，文件已损坏";
        return false;
    }
    结果.resize(字节数 / 2);
    if (结果.empty())
        return true;
    const unsigned char* 源 = (const unsigned char*)数据;
    for (size_t 序 = 0; 序 < 结果.size(); ++序)
    {
        const unsigned int 低 = 源[序 * 2];
        const unsigned int 高 = 源[序 * 2 + 1];
        const unsigned int 码元 = 小端 ? (低 | (高 << 8)) : (高 | (低 << 8));
        结果[序] = (wchar_t)码元;
    }
    return true;
}

// 字节 → 文本。编码 0 时先判定再解；其余按指定编码解。
// BOM 一律剥掉，不进入结果文本：调用方读的是「内容」，不该看到 BOM。
bool 字节转文本(const std::vector<char>& 字节, int 编码, std::wstring& 结果, std::wstring& 错误说明)
{
    结果.clear();
    if (编码 < 编码_自动 || 编码 > 编码_UTF16BE)
    {
        错误说明 = L"读取文本文件：编码参数无效（只接受 0~4）";
        return false;
    }
    int 实际编码 = 编码;
    if (编码 == 编码_自动)
        实际编码 = 判定编码(字节);

    switch (实际编码)
    {
    case 编码_UTF8:
    {
        const size_t 偏移 = 有UTF8BOM(字节) ? 3 : 0;
        const size_t 剩余 = 字节.size() - 偏移;
        if (剩余 == 0)
            return true;
        // 自动判定成功过的内容一定是合法 UTF-8；显式指定 UTF-8 时也做严格校验，
        // 免得把一段 GBK 当成 UTF-8 读出一堆 U+FFFD 却不告诉用户。
        return 多字节转宽文本(CP_UTF8, MB_ERR_INVALID_CHARS, &字节[偏移], 剩余,
                             L"读取文本文件：内容不是合法的 UTF-8（可改用编码 2 按 GBK 读取）",
                             结果, 错误说明);
    }
    case 编码_GBK:
    {
        // GBK 不做严格校验：Windows 的 936 代码页遇到无法解释的字节会给出
        // 双字节的「最接近」结果，这比整份文件读失败有用得多。
        return 多字节转宽文本(代码页_GBK, 0, &字节[0], 字节.size(),
                             L"读取文本文件：GBK 解码失败", 结果, 错误说明);
    }
    case 编码_UTF16LE:
    {
        const size_t 偏移 = 有UTF16LEBOM(字节) ? 2 : 0;
        if (字节.size() <= 偏移)
            return true;
        return UTF16转宽文本(&字节[偏移], 字节.size() - 偏移, true, 结果, 错误说明);
    }
    case 编码_UTF16BE:
    {
        const size_t 偏移 = 有UTF16BEBOM(字节) ? 2 : 0;
        if (字节.size() <= 偏移)
            return true;
        return UTF16转宽文本(&字节[偏移], 字节.size() - 偏移, false, 结果, 错误说明);
    }
    default:
        错误说明 = L"读取文本文件：编码参数无效（只接受 0~4）";
        return false;
    }
}

// 统计有多少个 UTF-16 码元在 GBK 里表示不了（它们在转换时会被换成默认字符 '?'）。
// 只在「已经确认至少有一处替换」时才调用，所以这里的逐个转换不构成性能问题：
// 阈值判断放在调用处，ASCII 码元直接跳过（>= 0x80 才需要问系统）。
int 统计不可表示码元(const std::wstring& 文本)
{
    const char 默认字符 = '?';
    int 个数 = 0;
    char 单个[8] = { 0, 0, 0, 0, 0, 0, 0, 0 };
    for (size_t 序 = 0; 序 < 文本.size(); ++序)
    {
        const wchar_t 字 = 文本[序];
        if ((unsigned int)字 < 0x80u)
            continue;                      // ASCII 一定能表示，省掉一次系统调用
        BOOL 用了默认字符 = FALSE;
        const int 写入数 = WideCharToMultiByte(代码页_GBK, WC_NO_BEST_FIT_CHARS, &字, 1,
                                               单个, (int)sizeof(单个), &默认字符, &用了默认字符);
        if (写入数 <= 0 || 用了默认字符 != FALSE)
            ++个数;
    }
    return 个数;
}

// 文本 → 字节。写 BOM 只对 UTF-16 有意义，而且只在「新文件」时写。
// 提示是「成功但有话要说」的出口：例如 GBK 宽松模式替换了 N 处不可表示字符。
// 它不改变成败判定（成败只看返回值），调用方把它放进错误槽当告警用。
bool 文本转字节(const std::wstring& 文本, int 编码, bool 写BOM,
                std::vector<char>& 字节, std::wstring& 错误说明, std::wstring& 提示)
{
    字节.clear();
    提示.clear();
    // 写入侧比读取侧多接受一个 5（GBK 宽松）。
    if (编码 < 编码_自动 || 编码 > 编码_GBK宽松)
    {
        错误说明 = L"写入文本文件：编码参数无效（写入只接受 0~5）";
        return false;
    }
    // 写的时候 0 与 1 等价：UTF-8 且不写 BOM。
    // 理由：用户说「自动」时并没有表达「请加 BOM」的意愿，而带 BOM 的 UTF-8
    // 会被不少老工具当成乱码，所以默认不写是最安全的。
    const int 实际编码 = (编码 == 编码_自动) ? 编码_UTF8 : 编码;

    switch (实际编码)
    {
    case 编码_UTF8:
    {
        // 复用已有的按码点编码实现：代理对合成一个码点，孤立代理输出 U+FFFD，
        // 因此写出的永远是合法 UTF-8。
        const std::string 窄 = 转为UTF8(文本);
        字节.assign(窄.begin(), 窄.end());
        return true;
    }
    case 编码_GBK:
    case 编码_GBK宽松:
    {
        if (文本.empty())
            return true;
        if (文本.size() > (size_t)INT_MAX)
        {
            错误说明 = L"写入文本文件：文本过长，无法转换";
            return false;
        }
        const bool 严格 = (实际编码 == 编码_GBK);
        // WC_NO_BEST_FIT_CHARS 必须带：不带它，Windows 会把表示不了的字符「就近」
        // 映射成相似字符（例如某些带音调的字母变成裸字母），这种静默改写比 '?' 更难发现。
        // 带上之后，表示不了的码元一律变成 lpDefaultChar（这里是 '?'）。
        // lpUsedDefaultChar 只有在**真正转换**时才会被置位，所以探测与转换合成一遍：
        // 先按同一套标志问需要的字节数，再真正转进缓冲并顺手拿到「有没有替换」。
        const char 默认字符 = '?';
        const int 需要的字节数 = WideCharToMultiByte(代码页_GBK, WC_NO_BEST_FIT_CHARS,
                                                    文本.c_str(), (int)文本.size(),
                                                    nullptr, 0, &默认字符, nullptr);
        if (需要的字节数 <= 0)
        {
            错误说明 = L"写入文本文件：无法把文本转成 GBK";
            return false;
        }
        字节.assign((size_t)需要的字节数, '\0');
        BOOL 用了默认字符 = FALSE;
        const int 写入数 = WideCharToMultiByte(代码页_GBK, WC_NO_BEST_FIT_CHARS,
                                              文本.c_str(), (int)文本.size(),
                                              &字节[0], 需要的字节数,
                                              &默认字符, &用了默认字符);
        if (写入数 <= 0)
        {
            字节.clear();
            错误说明 = L"写入文本文件：无法把文本转成 GBK";
            return false;
        }
        字节.resize((size_t)写入数);
        if (用了默认字符 != FALSE)
        {
            if (严格)
            {
                // 默认行为：拒绝写入。文件由调用方负责「根本没碰」——
                // 因为这里还没写盘，原文件内容天然保持不变。
                字节.clear();
                错误说明 = L"目标编码（GBK）无法表示文本中的部分字符（如 emoji、生僻字），"
                           L"已拒绝写入；如需强制替换为 ? 请用编码 5，或改用 UTF-8（编码 1）";
                return false;
            }
            // 宽松模式：字节已经替换好了，只留一条可见提示。
            // 注意这不是失败——成败由返回值判定，提示只是写进错误槽给用户看。
            const int 处数 = 统计不可表示码元(文本);
            std::wstringstream 流;
            流 << L"已按目标编码（GBK）替换 " << 处数 << L" 处不可表示字符（替换为 ?，内容不可逆丢失）";
            提示 = 流.str();
        }
        return true;
    }
    case 编码_UTF16LE:
    case 编码_UTF16BE:
    {
        const bool 小端 = (实际编码 == 编码_UTF16LE);
        const size_t 前缀 = 写BOM ? 2 : 0;
        字节.assign(前缀 + 文本.size() * 2, '\0');
        if (写BOM)
        {
            字节[0] = (char)(小端 ? 0xFF : 0xFE);
            字节[1] = (char)(小端 ? 0xFE : 0xFF);
        }
        for (size_t 序 = 0; 序 < 文本.size(); ++序)
        {
            const unsigned int 码元 = (unsigned int)(unsigned short)文本[序];
            const char 低 = (char)(码元 & 0xFF);
            const char 高 = (char)((码元 >> 8) & 0xFF);
            字节[前缀 + 序 * 2] = 小端 ? 低 : 高;
            字节[前缀 + 序 * 2 + 1] = 小端 ? 高 : 低;
        }
        return true;
    }
    default:
        错误说明 = L"写入文本文件：编码参数无效（写入只接受 0~5）";
        return false;
    }
}

// 整份读进内存（二进制模式，绝不走文本模式：文本模式会把 0x1A 当 EOF，
// 还会悄悄改写 CRLF，两者都会毁掉非文本文件与 UTF-16 内容）。
bool 读取文件全部字节(const std::wstring& 路径文本, std::vector<char>& 字节, std::wstring& 错误说明)
{
    字节.clear();
    if (路径文本.empty())
    {
        错误说明 = L"读取文本文件：路径为空";
        return false;
    }
    FILE* 文件 = nullptr;
    if (_wfopen_s(&文件, 路径文本.c_str(), L"rb") != 0 || 文件 == nullptr)
    {
        错误说明 = L"读取文本文件：无法打开文件（路径不存在或没有读取权限）";
        return false;
    }
    // 先量尺寸：超过上限的直接拒绝，连一次分配都不做。
    if (_fseeki64(文件, 0, SEEK_END) == 0)
    {
        const long long 尺寸 = _ftelli64(文件);
        if (尺寸 > 文本文件读取上限)
        {
            fclose(文件);
            std::wstringstream 流;
            流 << L"文件过大（超过 64 MiB），本方法不读取：实际 " << 尺寸 << L" 字节";
            错误说明 = 流.str();
            return false;
        }
        if (_fseeki64(文件, 0, SEEK_SET) != 0)
        {
            fclose(文件);
            错误说明 = L"读取文本文件：无法定位到文件开头";
            return false;
        }
    }
    std::vector<char> 缓冲(65536);
    for (;;)
    {
        const size_t 读入 = fread(&缓冲[0], 1, 缓冲.size(), 文件);
        if (读入 > 0)
            字节.insert(字节.end(), 缓冲.begin(), 缓冲.begin() + (std::ptrdiff_t)读入);
        if (读入 < 缓冲.size())
        {
            if (ferror(文件) != 0)
            {
                fclose(文件);
                字节.clear();
                错误说明 = L"读取文本文件：读取文件内容失败";
                return false;
            }
            break;
        }
    }
    fclose(文件);
    return true;
}

bool 写出文件字节(const std::wstring& 路径文本, const std::vector<char>& 字节, bool 追加,
                   std::wstring& 错误说明)
{
    if (路径文本.empty())
    {
        错误说明 = 追加 ? L"追加文本文件：路径为空" : L"写入文本文件：路径为空";
        return false;
    }
    FILE* 文件 = nullptr;
    if (_wfopen_s(&文件, 路径文本.c_str(), 追加 ? L"ab" : L"wb") != 0 || 文件 == nullptr)
    {
        错误说明 = 追加 ? L"追加文本文件：无法打开文件（目录不存在或没有写入权限）"
                        : L"写入文本文件：无法打开文件（目录不存在或没有写入权限）";
        return false;
    }
    bool 成功 = true;
    if (!字节.empty() &&
        fwrite(&字节[0], 1, 字节.size(), 文件) != 字节.size())
    {
        错误说明 = 追加 ? L"追加文本文件：写入内容失败（磁盘已满或没有权限）"
                        : L"写入文本文件：写入内容失败（磁盘已满或没有权限）";
        成功 = false;
    }
    // fclose 会刷新缓冲区，因此它的返回值必须看：磁盘满往往在这一步才暴露。
    if (fclose(文件) != 0 && 成功)
    {
        错误说明 = 追加 ? L"追加文本文件：关闭文件时刷新失败"
                        : L"写入文本文件：关闭文件时刷新失败";
        成功 = false;
    }
    return 成功;
}

} // namespace

extern "C" const wchar_t* FB_file_read_text(const wchar_t* path, int encoding)
{
    清空错误();
    try
    {
        std::wstring 错误说明;
        std::vector<char> 字节;
        if (!读取文件全部字节(取文本(path), 字节, 错误说明))
            return 记录错误(错误说明.c_str());
        std::wstring 结果;
        if (!字节转文本(字节, encoding, 结果, 错误说明))
            return 记录错误(错误说明.c_str());
        上次成功 = true;
        return 交出文本(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"读取文本文件失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"读取文本文件失败：未知异常");
    }
}

extern "C" int FB_file_write_text(const wchar_t* path, const wchar_t* text, int encoding)
{
    清空错误();
    try
    {
        std::wstring 错误说明;
        std::wstring 提示;
        std::vector<char> 字节;
        if (!文本转字节(取文本(text), encoding, true, 字节, 错误说明, 提示))
        {
            记录错误(错误说明.c_str());
            return 0;                     // 转换阶段失败 = 一个字节都没写，原文件原样保留
        }
        if (!写出文件字节(取文本(path), 字节, false, 错误说明))
        {
            记录错误(错误说明.c_str());
            return 0;
        }
        上次成功 = true;
        if (!提示.empty())
            错误缓冲 = 提示;              // 成功但有提示：只写错误槽，不改成败判定
        return 1;
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"写入文本文件失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"写入文本文件失败：未知异常");
        return 0;
    }
}

extern "C" int FB_file_append_text(const wchar_t* path, const wchar_t* text, int encoding)
{
    清空错误();
    try
    {
        const std::wstring 路径文本 = 取文本(path);
        // 只有「新文件或空文件」才写 BOM：往已有内容后面再塞一个 BOM，
        // 会在文件中间留下一个看不见的字符，读回来就是正文里多一个 U+FEFF。
        const bool 写BOM = (取文件字节数(路径文本) <= 0);
        std::wstring 错误说明;
        std::wstring 提示;
        std::vector<char> 字节;
        if (!文本转字节(取文本(text), encoding, 写BOM, 字节, 错误说明, 提示))
        {
            记录错误(错误说明.c_str());
            return 0;                     // 转换阶段失败 = 一个字节都没追加，文件长度不变
        }
        if (!写出文件字节(路径文本, 字节, true, 错误说明))
        {
            记录错误(错误说明.c_str());
            return 0;
        }
        上次成功 = true;
        if (!提示.empty())
            错误缓冲 = 提示;              // 成功但有提示：只写错误槽，不改成败判定
        return 1;
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"追加文本文件失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"追加文本文件失败：未知异常");
        return 0;
    }
}

extern "C" int FB_file_detect_encoding(const wchar_t* path)
{
    清空错误();
    try
    {
        std::wstring 错误说明;
        std::vector<char> 字节;
        if (!读取文件全部字节(取文本(path), 字节, 错误说明))
        {
            记录错误(错误说明.c_str());
            return -1;
        }
        上次成功 = true;
        return 判定编码(字节);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"判定文件编码失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return -1;
    }
    catch (...)
    {
        记录错误(L"判定文件编码失败：未知异常");
        return -1;
    }
}

// =====================================================================
//  二十二、位集（v1.5，boost/dynamic_bitset）
//  位序是这一组 API 唯一的「隐式契约」，所以定死并写进 README：
//    第 0 位（最低位）是文本里**最右**的那个字符。
//  于是 from_text(L"1010") 之后 test(1) == 1、test(0) == 0；
//  to_binary 永远高位在左、长度等于位数（全 0 的 8 位是 "00000000"，
//  不是空文本）；to_hex 从低位开始每 4 位一组，去掉前导 0，
//  全 0 输出 "0"。
// =====================================================================
namespace {

struct 位集数据
{
    boost::dynamic_bitset<> 位;
};

// 位集使用独立句柄表：即使误把 CSV 句柄传进来，也只会得到「句柄无效」，
// 而不会读到另一个对象的内存。
句柄表<位集数据> 位集句柄表;

} // namespace

extern "C" intptr_t FB_bitset_new(int64_t bit_count)
{
    清空错误();
    try
    {
        // 负数按 0 处理（文档化），不是错误：调用方算出一个空集合是正常需求。
        const int64_t 实际位数 = (bit_count < 0) ? 0 : bit_count;
        std::shared_ptr<位集数据> 对象 = std::make_shared<位集数据>();
        if (实际位数 > 0)
        {
            // 不在这里手写「位数上限」检查：dynamic_bitset::resize 在位数超出
            // 可分配范围时会抛 length_error / bad_alloc，下面两个 catch 已经
            // 把它变成「返回 0 + 中文错误」，比手写一个魔数上限更准确。
            对象->位.resize((size_t)实际位数, false);
        }
        上次成功 = true;
        return 位集句柄表.加入(对象);
    }
    catch (const std::bad_alloc&)
    {
        记录错误(L"新建位集：内存不足，位数过大");
        return 0;
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"新建位集失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"新建位集失败：未知异常");
        return 0;
    }
}

extern "C" intptr_t FB_bitset_from_text(const wchar_t* bits)
{
    清空错误();
    try
    {
        std::wstring 原文 = 取文本(bits);
        // 前缀 0b / 0B
        if (原文.size() >= 2 && 原文[0] == L'0' && (原文[1] == L'b' || 原文[1] == L'B'))
            原文 = 原文.substr(2);
        // 后缀 b / B（二进制字面量的另一种写法）
        if (!原文.empty() && (原文[原文.size() - 1] == L'b' || 原文[原文.size() - 1] == L'B'))
            原文.erase(原文.size() - 1);
        if (原文.empty())
        {
            记录错误(L"解析位集文本：文本为空（至少要有一个 0 或 1）");
            return 0;
        }
        for (size_t 序 = 0; 序 < 原文.size(); ++序)
        {
            if (原文[序] != L'0' && 原文[序] != L'1')
            {
                记录错误(L"解析位集文本：含非法字符（只允许 0 与 1）");
                return 0;
            }
        }
        std::shared_ptr<位集数据> 对象 = std::make_shared<位集数据>();
        对象->位.resize(原文.size(), false);
        // 最右边的字符是第 0 位。
        const size_t 位总数 = 原文.size();
        for (size_t 序 = 0; 序 < 位总数; ++序)
        {
            if (原文[位总数 - 1 - 序] == L'1')
                对象->位.set(序);
        }
        上次成功 = true;
        return 位集句柄表.加入(对象);
    }
    catch (const std::bad_alloc&)
    {
        记录错误(L"解析位集文本：内存不足，位数过大");
        return 0;
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"解析位集文本失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"解析位集文本失败：未知异常");
        return 0;
    }
}

extern "C" int FB_bitset_count(intptr_t h)
{
    std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
    if (!对象)
        return -1;
    const size_t 位数 = 对象->位.size();
    if (位数 > (size_t)INT_MAX)
        return INT_MAX;                    // 溢出钳制：宁可少报也不能报成负数
    return (int)位数;
}

extern "C" int FB_bitset_true_count(intptr_t h)
{
    std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
    if (!对象)
        return -1;
    const size_t 个数 = 对象->位.count();
    if (个数 > (size_t)INT_MAX)
        return INT_MAX;
    return (int)个数;
}

extern "C" int FB_bitset_test(intptr_t h, int64_t i)
{
    std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
    if (!对象)
        return -1;
    if (i < 0 || (uint64_t)i >= (uint64_t)对象->位.size())
        return -1;
    return 对象->位[(size_t)i] ? 1 : 0;
}

extern "C" int FB_bitset_set(intptr_t h, int64_t i, int v)
{
    std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
    if (!对象)
        return 0;
    if (i < 0 || (uint64_t)i >= (uint64_t)对象->位.size())
        return 0;                          // 越界不扩容：扩容是 resize 的职责
    对象->位.set((size_t)i, v != 0);
    return 1;
}

extern "C" int FB_bitset_flip(intptr_t h, int64_t i)
{
    std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
    if (!对象)
        return 0;
    if (i < 0 || (uint64_t)i >= (uint64_t)对象->位.size())
        return 0;
    对象->位.flip((size_t)i);
    return 1;
}

extern "C" int FB_bitset_flip_all(intptr_t h)
{
    std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
    if (!对象)
        return 0;
    对象->位.flip();
    return 1;
}

extern "C" int FB_bitset_resize(intptr_t h, int64_t n, int fill)
{
    清空错误();
    try
    {
        std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
        if (!对象)
            return 0;
        if (n < 0)
        {
            记录错误(L"调整位集长度：位数不能为负数");
            return 0;
        }
        // 同上：上限交给 resize 自己抛异常，不手写魔数。
        对象->位.resize((size_t)n, fill != 0);
        上次成功 = true;
        return 1;
    }
    catch (const std::bad_alloc&)
    {
        记录错误(L"调整位集长度：内存不足，位数过大");
        return 0;
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"调整位集长度失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"调整位集长度失败：未知异常");
        return 0;
    }
}

extern "C" const wchar_t* FB_bitset_to_binary(intptr_t h)
{
    std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
    if (!对象)
        return 交出文本(L"");
    const size_t 位数 = 对象->位.size();
    std::wstring 结果;
    结果.reserve(位数);
    // 高位在左：从最高位往下写。
    for (size_t 序 = 位数; 序 > 0; --序)
        结果.push_back(对象->位[序 - 1] ? L'1' : L'0');
    return 交出文本(结果);
}

extern "C" const wchar_t* FB_bitset_to_hex(intptr_t h)
{
    static const wchar_t 十六进制表[] = L"0123456789abcdef";
    std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
    if (!对象)
        return 交出文本(L"");
    const size_t 位数 = 对象->位.size();
    if (位数 == 0)
        return 交出文本(L"0");
    const size_t 组数 = (位数 + 3) / 4;    // 小数位补齐到 4 的倍数
    std::wstring 结果;
    结果.reserve(组数);
    for (size_t 组 = 0; 组 < 组数; ++组)
    {
        unsigned int 值 = 0;
        for (size_t 偏移 = 0; 偏移 < 4; ++偏移)
        {
            const size_t 位号 = 组 * 4 + 偏移;
            if (位号 < 位数 && 对象->位[位号])
                值 |= (1u << 偏移);            // 组内也是低位在右
        }
        结果.push_back(十六进制表[值 & 0x0F]);
    }
    std::reverse(结果.begin(), 结果.end());
    const size_t 起点 = 结果.find_first_not_of(L'0');
    if (起点 == std::wstring::npos)
        return 交出文本(L"0");             // 全 0 输出 "0"，不是空文本
    return 交出文本(结果.substr(起点));
}

extern "C" intptr_t FB_bitset_op(intptr_t a, intptr_t b, int op)
{
    清空错误();
    try
    {
        std::shared_ptr<位集数据> 甲 = 位集句柄表.取(a);
        std::shared_ptr<位集数据> 乙 = 位集句柄表.取(b);
        if (!甲 || !乙)
        {
            记录错误(L"位集运算：句柄无效");
            return 0;
        }
        if (甲->位.size() != 乙->位.size())
        {
            记录错误(L"位集运算：两个位集的长度不同，无法运算");
            return 0;
        }
        std::shared_ptr<位集数据> 结果 = std::make_shared<位集数据>();
        switch (op)
        {
        case 0: 结果->位 = 甲->位 & 乙->位; break;
        case 1: 结果->位 = 甲->位 | 乙->位; break;
        case 2: 结果->位 = 甲->位 ^ 乙->位; break;
        case 3: 结果->位 = 甲->位 - 乙->位; break;   // dynamic_bitset 的差集就是「与非」
        default:
            记录错误(L"位集运算：运算类型无效（只接受 0=与 1=或 2=异或 3=与非）");
            return 0;
        }
        上次成功 = true;
        return 位集句柄表.加入(结果);
    }
    catch (const std::bad_alloc&)
    {
        记录错误(L"位集运算：内存不足");
        return 0;
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"位集运算失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"位集运算失败：未知异常");
        return 0;
    }
}

extern "C" intptr_t FB_bitset_clone(intptr_t h)
{
    清空错误();
    try
    {
        std::shared_ptr<位集数据> 对象 = 位集句柄表.取(h);
        if (!对象)
        {
            记录错误(L"复制位集：句柄无效");
            return 0;
        }
        std::shared_ptr<位集数据> 副本 = std::make_shared<位集数据>();
        副本->位 = 对象->位;
        上次成功 = true;
        return 位集句柄表.加入(副本);
    }
    catch (const std::bad_alloc&)
    {
        记录错误(L"复制位集：内存不足");
        return 0;
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"复制位集失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"复制位集失败：未知异常");
        return 0;
    }
}

extern "C" int FB_bitset_free(intptr_t h)
{
    // 二次释放返回 0，而不是报错：句柄表里已经没有这个编号，擦不掉就是 0。
    return 位集句柄表.删(h) ? 1 : 0;
}

// =====================================================================
//  二十三、文字工具扩展（v1.5）：通配符、进制转换、按显示宽度补齐
// =====================================================================
namespace {

// 把 shell 通配符翻译成 boost 正则。
// 支持 * ? [abc] [!abc]；其余正则元字符按字面量转义，
// 否则 a.txt 里的 '.' 会变成「任意字符」，*.txt 就会匹配上 axtxt。
bool 通配符转正则(const std::wstring& 模式, std::wstring& 正则, std::wstring& 错误说明)
{
    正则.clear();
    正则.reserve(模式.size() * 2 + 2);
    const size_t 长度 = 模式.size();
    size_t 序 = 0;
    while (序 < 长度)
    {
        const wchar_t 字 = 模式[序];
        if (字 == L'*')
        {
            正则 += L".*";
            ++序;
            continue;
        }
        if (字 == L'?')
        {
            正则 += L".";
            ++序;
            continue;
        }
        if (字 == L'[')
        {
            // 先找收尾的 ']'。紧跟 '[' 或 '[!' 之后的 ']' 是字面量，不能当收尾。
            size_t 收尾 = 序 + 1;
            if (收尾 < 长度 && (模式[收尾] == L'!' || 模式[收尾] == L'^'))
                ++收尾;
            if (收尾 < 长度 && 模式[收尾] == L']')
                ++收尾;
            while (收尾 < 长度 && 模式[收尾] != L']')
                ++收尾;
            if (收尾 >= 长度)
            {
                错误说明 = L"通配符匹配：模式里的方括号没有闭合";
                return false;
            }
            正则 += L'[';
            size_t 内部 = 序 + 1;
            if (模式[内部] == L'!')
            {
                正则 += L'^';                  // [!abc] 就是 [^abc]
                ++内部;
            }
            else if (模式[内部] == L'^')
            {
                正则 += L"\\^";                // 字面量 ^ 保持字面量，不变成取反
                ++内部;
            }
            for (; 内部 < 收尾; ++内部)
            {
                const wchar_t 成员 = 模式[内部];
                if (成员 == L'\\' || 成员 == L']')
                {
                    正则 += L'\\';
                    正则.push_back(成员);
                }
                else
                {
                    正则.push_back(成员);
                }
            }
            正则 += L']';
            序 = 收尾 + 1;
            continue;
        }
        // 其余正则元字符一律转义成字面量。
        if (字 == L'\\' || 字 == L'.' || 字 == L'+' || 字 == L'(' || 字 == L')' ||
            字 == L'{' || 字 == L'}' || 字 == L'|' || 字 == L'^' || 字 == L'$')
            正则 += L'\\';
        正则.push_back(字);
        ++序;
    }
    return true;
}

// 按需求给定的区间表判断是否占两格。刻意不引第三方宽度库：
// 版本差异会让「补齐」这种纯显示功能的结果随依赖升级而变，
// 而这里有七个区间就够了，且完全可复现。
bool 是宽字符(wchar_t 字)
{
    const unsigned int 码点 = (unsigned int)字;
    return (码点 >= 0x1100u && 码点 <= 0x115Fu) ||   // 韩文字母
           (码点 >= 0x2E80u && 码点 <= 0xA4CFu) ||   // CJK 部首扩展 ~ 彝文
           (码点 >= 0xAC00u && 码点 <= 0xD7A3u) ||   // 韩文音节
           (码点 >= 0xF900u && 码点 <= 0xFAFFu) ||   // CJK 兼容汉字
           (码点 >= 0xFE30u && 码点 <= 0xFE6Fu) ||   // CJK 兼容形式
           (码点 >= 0xFF00u && 码点 <= 0xFF60u) ||   // 全角 ASCII
           (码点 >= 0xFFE0u && 码点 <= 0xFFE6u);     // 全角符号
}

int 显示宽度(const std::wstring& 文本)
{
    long long 合计 = 0;
    for (size_t 序 = 0; 序 < 文本.size(); ++序)
        合计 += 是宽字符(文本[序]) ? 2 : 1;
    if (合计 > (long long)INT_MAX)
        合计 = (long long)INT_MAX;
    return (int)合计;
}

} // namespace

extern "C" int FB_text_glob(const wchar_t* text, const wchar_t* pattern)
{
    清空错误();
    try
    {
        std::wstring 正则文本;
        std::wstring 错误说明;
        if (!通配符转正则(取文本(pattern), 正则文本, 错误说明))
        {
            记录错误(错误说明.c_str());
            return 0;
        }
        const boost::wregex 表达式(正则文本);
        const std::wstring 原文 = 取文本(text);
        上次成功 = true;
        return boost::regex_match(原文, 表达式) ? 1 : 0;
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"通配符匹配失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return 0;
    }
    catch (...)
    {
        记录错误(L"通配符匹配失败：未知异常");
        return 0;
    }
}

extern "C" const wchar_t* FB_text_convert_base(const wchar_t* number, int from_base, int to_base)
{
    清空错误();
    try
    {
        if (from_base < 2 || from_base > 36 || to_base < 2 || to_base > 36)
            return 记录错误(L"进制转换：进制只接受 2~36");
        const std::wstring 原文 = 取文本(number);
        if (原文.empty())
            return 记录错误(L"进制转换：文本为空");

        size_t 位置 = 0;
        bool 负数 = false;
        if (原文[0] == L'-')
        {
            负数 = true;
            位置 = 1;
        }
        else if (原文[0] == L'+')
        {
            位置 = 1;
        }
        if (位置 >= 原文.size())
            return 记录错误(L"进制转换：只有符号，没有数字");

        // 用任意精度整数累加：36 进制的长串很容易超过 64 位，
        // 而这里的目的就是「正确换算」，截断会让结果静默出错。
        boost::multiprecision::cpp_int 值 = 0;
        for (; 位置 < 原文.size(); ++位置)
        {
            const wchar_t 字 = 原文[位置];
            int 数码 = -1;
            if (字 >= L'0' && 字 <= L'9')
                数码 = (int)(字 - L'0');
            else if (字 >= L'a' && 字 <= L'z')
                数码 = (int)(字 - L'a') + 10;
            else if (字 >= L'A' && 字 <= L'Z')
                数码 = (int)(字 - L'A') + 10;
            else
                return 记录错误(L"进制转换：含非法字符（只允许 0-9 a-z A-Z 与前导正负号）");
            if (数码 >= from_base)
                return 记录错误(L"进制转换：某一位数字超出了源进制的范围");
            值 = 值 * from_base + 数码;
        }

        std::wstring 结果;
        if (值 == 0)
        {
            结果 = L"0";
        }
        else
        {
            static const wchar_t 数码表[] = L"0123456789abcdefghijklmnopqrstuvwxyz";
            boost::multiprecision::cpp_int 剩余 = 值;
            while (剩余 != 0)
            {
                // 先落到具体的 cpp_int 再 convert_to：直接对表达式模板调用
                // convert_to 在不同 boost 小版本上支持程度不一致，写成两步最稳。
                const boost::multiprecision::cpp_int 余数 = 剩余 % to_base;
                const boost::multiprecision::cpp_int 商 = 剩余 / to_base;
                const int 数码 = 余数.convert_to<int>();
                结果.push_back(数码表[数码]);
                剩余 = 商;
            }
            std::reverse(结果.begin(), 结果.end());
        }
        if (负数)
            结果 = L"-" + 结果;
        上次成功 = true;
        return 交出文本(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"进制转换失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"进制转换失败：未知异常");
    }
}

extern "C" const wchar_t* FB_text_pad_display(const wchar_t* text, int width, int mode)
{
    清空错误();
    try
    {
        const std::wstring 原文 = 取文本(text);
        const int 实际宽度 = 显示宽度(原文);
        // 已经够宽（或超宽）就原样返回：补齐方法没有「截断」这个能力，
        // 截断会把内容变成错误的数据，比不整齐严重得多。
        if (width <= 0 || 实际宽度 >= width)
        {
            上次成功 = true;
            return 交出文本(原文);
        }
        const int 补齐数 = width - 实际宽度;
        int 左空格 = 0;
        int 右空格 = 0;
        if (mode == 1)                          // 右对齐
        {
            左空格 = 补齐数;
        }
        else if (mode == 2)                     // 居中：左边少放一个，右边多放一个
        {
            左空格 = 补齐数 / 2;
            右空格 = 补齐数 - 左空格;
        }
        else                                    // 0 及其它值都按左对齐处理
        {
            右空格 = 补齐数;
        }
        std::wstring 结果;
        结果.reserve(原文.size() + (size_t)补齐数);
        结果.append((size_t)左空格, L' ');
        结果.append(原文);
        结果.append((size_t)右空格, L' ');
        上次成功 = true;
        return 交出文本(结果);
    }
    catch (const std::exception& 异常)
    {
        错误缓冲 = L"按宽度补齐失败：";
        错误缓冲 += 宽化(异常.what());
        上次成功 = false;
        return L"";
    }
    catch (...)
    {
        return 记录错误(L"按宽度补齐失败：未知异常");
    }
}
