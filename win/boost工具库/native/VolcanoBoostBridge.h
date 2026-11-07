/* ============================================================
   Volcano Windows x Boost bridge - public C ABI header
   This header must stay pure ASCII (ANSI requirement of
   "@shi_chuang.wai_bu_tou_wen_jian" in Volcano).
   Text is always UTF-16 (wchar_t) and never crosses free/alloc.
   Every returned "const wchar_t*" points to a thread-local
   buffer that stays valid until the next bridge call on the
   same thread; the Volcano side copies it immediately.
   Handles are intptr_t; 0 means invalid.
   ============================================================ */
#ifndef VOL_BOOST_BRIDGE_H
#define VOL_BOOST_BRIDGE_H

#include <stdint.h>

#ifdef __cplusplus
extern "C" {
#endif

/* ---- version / error ---- */
const wchar_t* FB_version(void);
const wchar_t* FB_error_text(void);

/* ---- text (boost/algorithm/string) ---- */
const wchar_t* FB_text_trim(const wchar_t* s);
const wchar_t* FB_text_trim_left(const wchar_t* s);
const wchar_t* FB_text_trim_right(const wchar_t* s);
const wchar_t* FB_text_trim_chars(const wchar_t* s, const wchar_t* chars);
const wchar_t* FB_text_upper(const wchar_t* s);
const wchar_t* FB_text_lower(const wchar_t* s);
const wchar_t* FB_text_replace_all(const wchar_t* s, const wchar_t* find, const wchar_t* rep);
const wchar_t* FB_text_replace_first(const wchar_t* s, const wchar_t* find, const wchar_t* rep);
const wchar_t* FB_text_erase_all(const wchar_t* s, const wchar_t* find);
int FB_text_icontains(const wchar_t* s, const wchar_t* find);
int FB_text_istarts_with(const wchar_t* s, const wchar_t* find);
int FB_text_iends_with(const wchar_t* s, const wchar_t* find);
int FB_text_iequals(const wchar_t* a, const wchar_t* b);
int FB_text_index_of(const wchar_t* s, const wchar_t* find);

/* ---- split handle (boost/algorithm/string split) ---- */
intptr_t FB_split_create(const wchar_t* s, const wchar_t* sep);
int FB_split_count(intptr_t h);
const wchar_t* FB_split_get(intptr_t h, int index);
const wchar_t* FB_split_join(intptr_t h, const wchar_t* sep);
int FB_split_free(intptr_t h);

/* ---- lexical cast (boost/lexical_cast) ---- */
int64_t FB_text_to_int64(const wchar_t* s);
double FB_text_to_double(const wchar_t* s);
const wchar_t* FB_number_to_text(double v, int digits);
int FB_last_ok(void);

/* ---- format (boost/format) ---- */
intptr_t FB_fmt_create(const wchar_t* fmt);
int FB_fmt_add_text(intptr_t h, const wchar_t* v);
int FB_fmt_add_int(intptr_t h, int64_t v);
int FB_fmt_add_double(intptr_t h, double v, int digits);
const wchar_t* FB_fmt_result(intptr_t h);
int FB_fmt_free(intptr_t h);

/* ---- regex (boost/regex) ---- */
int FB_regex_match(const wchar_t* s, const wchar_t* pat);
int FB_regex_search(const wchar_t* s, const wchar_t* pat);
const wchar_t* FB_regex_find(const wchar_t* s, const wchar_t* pat, int group);
const wchar_t* FB_regex_replace(const wchar_t* s, const wchar_t* pat, const wchar_t* rep);
intptr_t FB_regex_split(const wchar_t* s, const wchar_t* pat);

/* ---- date (boost/gregorian), packed as yyyymmdd int64 ---- */
int64_t FB_date_today(void);
int64_t FB_date_make(int y, int m, int d);
const wchar_t* FB_date_text(int64_t d);
int64_t FB_date_parse(const wchar_t* s);
int64_t FB_date_add_days(int64_t d, int days);
int FB_date_diff_days(int64_t a, int64_t b);
int FB_date_year(int64_t d);
int FB_date_month(int64_t d);
int FB_date_day(int64_t d);
int FB_date_weekday(int64_t d);
int FB_date_is_leap(int y);
int FB_date_days_in_month(int y, int m);
const wchar_t* FB_date_format(int64_t d, const wchar_t* fmt);

/* ---- time (boost/posix_time), milliseconds since 1970 UTC ---- */
int64_t FB_time_now_ms(void);
const wchar_t* FB_time_text(int64_t ms);
const wchar_t* FB_time_format(int64_t ms, const wchar_t* fmt);
int64_t FB_time_add_ms(int64_t ms, int64_t delta);
int64_t FB_time_from_text(const wchar_t* s);
int FB_time_year(int64_t ms);
int FB_time_month(int64_t ms);
int FB_time_day(int64_t ms);
int FB_time_hour(int64_t ms);
int FB_time_minute(int64_t ms);
int FB_time_second(int64_t ms);

/* ---- checksum / uuid (boost/crc, boost/uuid) ---- */
int64_t FB_crc32(const wchar_t* s);
const wchar_t* FB_uuid_new(void);
int FB_uuid_valid(const wchar_t* s);

/* ---- statistics (boost/accumulators) ---- */
intptr_t FB_series_create(void);
int FB_series_push(intptr_t h, double v);
int FB_series_clear(intptr_t h);
int FB_series_count(intptr_t h);
double FB_series_sum(intptr_t h);
double FB_series_mean(intptr_t h);
double FB_series_variance(intptr_t h);
double FB_series_stddev(intptr_t h);
double FB_series_median(intptr_t h);
double FB_series_min(intptr_t h);
double FB_series_max(intptr_t h);
int FB_series_free(intptr_t h);

/* ---- big integer (boost/multiprecision) ---- */
intptr_t FB_big_from_text(const wchar_t* s);
const wchar_t* FB_big_text(intptr_t h);
intptr_t FB_big_op(intptr_t a, intptr_t b, int op);   /* 0=+  1=-  2=*  3=/  4=% */
intptr_t FB_big_add(intptr_t a, intptr_t b);
intptr_t FB_big_sub(intptr_t a, intptr_t b);
intptr_t FB_big_mul(intptr_t a, intptr_t b);
intptr_t FB_big_div(intptr_t a, intptr_t b);
intptr_t FB_big_mod(intptr_t a, intptr_t b);
intptr_t FB_big_pow(intptr_t a, int exp);
intptr_t FB_big_fact(int n);
int FB_big_cmp(intptr_t a, intptr_t b);
int FB_big_sign(intptr_t h);
int FB_big_free(intptr_t h);

/* ---- json / property tree (boost/property_tree) ---- */
intptr_t FB_json_parse(const wchar_t* s);
int FB_json_has(intptr_t h, const wchar_t* path);
const wchar_t* FB_json_text(intptr_t h, const wchar_t* path, const wchar_t* def);
int64_t FB_json_int(intptr_t h, const wchar_t* path, int64_t def);
double FB_json_num(intptr_t h, const wchar_t* path, double def);
int FB_json_set(intptr_t h, const wchar_t* path, const wchar_t* v);
const wchar_t* FB_json_dump(intptr_t h);
int FB_json_free(intptr_t h);

/* ---- text slicing / reshaping (boost/algorithm/string, v1.1) ----
   Indexes are 0-based character (not byte) offsets. Out-of-range
   requests are clamped instead of failing. */
int FB_text_length(const wchar_t* s);                                  /* character count */
const wchar_t* FB_text_left(const wchar_t* s, int count);              /* first count chars */
const wchar_t* FB_text_right(const wchar_t* s, int count);             /* last count chars */
const wchar_t* FB_text_mid(const wchar_t* s, int start, int count);    /* count chars from start */
const wchar_t* FB_text_repeat(const wchar_t* s, int times);            /* times <= 0 yields "" */
const wchar_t* FB_text_trim_dup_spaces(const wchar_t* s);              /* trim + collapse blank runs into one space */
const wchar_t* FB_text_unique(const wchar_t* s);                       /* drop consecutive duplicate chars */

/* ---- per-line view of a text, reuses the split handle table (v1.1) ---- */
intptr_t FB_lines_create(const wchar_t* s);                            /* split on \r\n and \n */

/* ---- date extensions (v1.1) ---- */
int64_t FB_date_first_of_month(int64_t d);
int64_t FB_date_last_of_month(int64_t d);
int64_t FB_date_add_months(int64_t d, int months);                     /* month-end aligned */
int64_t FB_date_add_years(int64_t d, int years);
int64_t FB_date_to_time_ms(int64_t d);                                 /* 00:00:00 of that day, ms */

/* ---- time extensions (v1.1) ---- */
int64_t FB_time_to_date(int64_t ms);                                   /* ms -> packed yyyymmdd */
int64_t FB_time_seconds_to_ms(int64_t s);
int64_t FB_time_ms_to_seconds(int64_t ms);
int64_t FB_time_day_start_ms(int64_t ms);                              /* midnight of that day, ms */

/* ---- ini document (boost/property_tree/ini_parser, v1.1) ---- */
intptr_t FB_ini_parse(const wchar_t* s);
int FB_ini_has(intptr_t h, const wchar_t* path);
const wchar_t* FB_ini_text(intptr_t h, const wchar_t* path, const wchar_t* def);
int64_t FB_ini_int(intptr_t h, const wchar_t* path, int64_t def);
int FB_ini_set(intptr_t h, const wchar_t* path, const wchar_t* v);
const wchar_t* FB_ini_dump(intptr_t h);
int FB_ini_free(intptr_t h);

/* ---- two-way name <-> value map (boost/container/flat_map, v1.1) ---- */
intptr_t FB_map_create(void);
int FB_map_put(intptr_t h, const wchar_t* name, int64_t value);
int FB_map_has(intptr_t h, const wchar_t* name);
int64_t FB_map_get(intptr_t h, const wchar_t* name, int64_t def);
const wchar_t* FB_map_reverse_get(intptr_t h, int64_t value, const wchar_t* def);
int FB_map_count(intptr_t h);
const wchar_t* FB_map_name_at(intptr_t h, int index);                  /* insertion order */
int FB_map_free(intptr_t h);

/* ---- xml document (boost/property_tree/xml_parser, v1.2) ----
   Same shape as the JSON document functions, but every document lives
   in its own handle table so an XML handle can never be mistaken for
   a JSON or INI handle. XML attributes are stored as child nodes
   named xmlattr: the id attribute of element item under root is
   addressed with the path  root.item.<xmlattr>.id  . The text of an
   element that has children stays on the element node itself. */
intptr_t FB_xml_parse(const wchar_t* s);
int FB_xml_has(intptr_t h, const wchar_t* path);
const wchar_t* FB_xml_text(intptr_t h, const wchar_t* path, const wchar_t* def);
int64_t FB_xml_int(intptr_t h, const wchar_t* path, int64_t def);
double FB_xml_num(intptr_t h, const wchar_t* path, double def);
int FB_xml_set(intptr_t h, const wchar_t* path, const wchar_t* v);
const wchar_t* FB_xml_dump(intptr_t h);
int FB_xml_free(intptr_t h);

/* ---- random numbers (boost/random, v1.2) ----
   The engine is thread_local: the seed function only resets the
   calling thread, and a fixed seed always reproduces the same
   sequence on the same thread. The integer call is a closed interval
   lo..hi and swaps lo and hi when they arrive reversed; the double
   call is a half-open interval lo..hi. */
int FB_random_seed(int64_t seed);
int64_t FB_random_int(int64_t lo, int64_t hi);
double FB_random_double(double lo, double hi);
double FB_random_normal(double mean, double sigma);
int FB_random_bool(double probability);
const wchar_t* FB_random_pick(const wchar_t* items);
intptr_t FB_random_shuffle(const wchar_t* items);

/* ---- high precision decimal (boost/multiprecision cpp_dec_float_50, v1.2) ---- */
intptr_t FB_dec_from_text(const wchar_t* s);
const wchar_t* FB_dec_text(intptr_t h, int digits);   /* digits < 0 = default precision */
intptr_t FB_dec_op(intptr_t a, intptr_t b, int op);   /* 0=+ 1=- 2=* 3=/ ; 0 on divide by zero */
intptr_t FB_dec_round(intptr_t h, int digits);        /* round half away from zero */
intptr_t FB_dec_abs(intptr_t h);
int FB_dec_cmp(intptr_t a, intptr_t b);
int FB_dec_sign(intptr_t h);
double FB_dec_to_double(intptr_t h);
int FB_dec_free(intptr_t h);

/* ---- filesystem (boost/filesystem, v1.3) ----
   Every path parameter arrives as UTF-16 and is turned into a
   boost::filesystem::path through a std::wstring.  That detail is not
   cosmetic: on Windows the path stores wchar_t, and building it from a
   narrow std::string decodes the bytes with the ANSI code page, so a
   UTF-8 path containing Chinese characters simply does not match.
   No function here throws: failures write a Chinese reason into the
   error slot and return the documented sentinel (0 / -1 / empty text /
   0 handle).  The remove functions are idempotent - removing something
   that is already gone returns 1. */
int FB_fs_exists(const wchar_t* p);
int FB_fs_is_dir(const wchar_t* p);
int FB_fs_is_file(const wchar_t* p);
int64_t FB_fs_size(const wchar_t* p);                  /* -1 when unavailable */
int64_t FB_fs_modified_ms(const wchar_t* p);           /* 0 when unavailable */
const wchar_t* FB_fs_absolute(const wchar_t* p);
const wchar_t* FB_fs_join(const wchar_t* a, const wchar_t* b);
const wchar_t* FB_fs_filename(const wchar_t* p);       /* with extension */
const wchar_t* FB_fs_stem(const wchar_t* p);           /* without extension */
const wchar_t* FB_fs_extension(const wchar_t* p);      /* includes the dot */
const wchar_t* FB_fs_parent(const wchar_t* p);
int FB_fs_make_dir(const wchar_t* p);                  /* recursive; 1 if it already exists */
int FB_fs_remove_file(const wchar_t* p);               /* 1 if it never existed */
int FB_fs_remove_dir(const wchar_t* p);                /* empty dirs only; 1 if absent */
int FB_fs_copy_file(const wchar_t* from, const wchar_t* to, int overwrite);
int FB_fs_rename(const wchar_t* from, const wchar_t* to);
intptr_t FB_fs_list(const wchar_t* dir, int recursive, int dirs_only);  /* split handle, sorted */
const wchar_t* FB_fs_temp_dir(void);
const wchar_t* FB_fs_current_dir(void);

/* ---- encoding (boost archive iterators + hand written hex, v1.3) ----
   Base64 works on the UTF-8 bytes of the text, not on wide characters:
   that is what every other tool in the world means by "base64 of this
   string", and it keeps ASCII output identical to RFC 4648.  Decoding
   validates the result as UTF-8 and returns empty text when the bytes
   are not a legal UTF-8 sequence.  Hex is lowercase on encode and
   accepts both cases on decode. */
const wchar_t* FB_b64_encode(const wchar_t* s);
const wchar_t* FB_b64_decode(const wchar_t* s);
const wchar_t* FB_hex_encode(const wchar_t* s);
const wchar_t* FB_hex_decode(const wchar_t* s);

/* ---- hash: sha1 and md5 (v1.4) ----
   Both digests are computed over the UTF-8 bytes of the text, so the
   result matches every other tool that hashes "this string" and the
   reference vectors of RFC 3174 / RFC 1321 come out byte for byte.
   The text result is 40 (sha1) or 32 (md5) lowercase hex characters.
   The file variants read the file in 64 KiB chunks, so a large file
   never has to fit in memory; on failure they return empty text and
   write a Chinese reason into the error slot.
   NOTE: boost/uuid/detail/sha1.hpp and md5.hpp are boost *internal*
   headers, not part of the documented public API.  They are used here
   because they are header-only and fully inlined, so the code is bound
   to the header text and carries no ABI or link-time risk.  A future
   boost upgrade may move them; the only symptom would be a compile
   error, never a silent behaviour change. */
const wchar_t* FB_hash_sha1_text(const wchar_t* s);
const wchar_t* FB_hash_sha1_file(const wchar_t* path);
const wchar_t* FB_hash_md5_text(const wchar_t* s);
const wchar_t* FB_hash_md5_file(const wchar_t* path);

/* ---- csv document (v1.4, hand written parser) ----
   boost/tokenizer is not usable here: it has no notion of quoted
   fields, so a field containing the separator or a line break cannot
   survive.  The rules implemented below are the ones the class
   documents: a field starting with a double quote is a quoted field,
   an inner "" means one quote character, the separator and line
   breaks are literal inside a quoted field, blanks between the
   closing quote and the separator are ignored, a completely empty
   line is skipped, and trailing empty columns are preserved
   (   "a,b," is three columns).  An empty separator text or a null
   pointer means the comma, and only the *first* character of the
   separator is used - on input AND on output - so that a dumped
   document parses back to the same table.  Rows are accepted with
   \r\n, \n or \r,
   mixed in the same document.  An empty document yields zero rows.
   Rows may have different column counts; out-of-range requests never
   fail hard: they yield empty text / 0 (see each function). */
intptr_t FB_csv_parse(const wchar_t* text, const wchar_t* sep);
int FB_csv_rows(intptr_t h);                            /* -1 = invalid handle */
int FB_csv_cols(intptr_t h, int row);                   /* -1 = invalid handle, 0 = row out of range */
const wchar_t* FB_csv_cell(intptr_t h, int row, int col);
const wchar_t* FB_csv_row_text(intptr_t h, int row, const wchar_t* sep);
int FB_csv_set(intptr_t h, int row, int col, const wchar_t* v);   /* 0 = out of range */
const wchar_t* FB_csv_dump(intptr_t h, const wchar_t* sep);       /* quotes and "" escapes as needed */
int FB_csv_free(intptr_t h);

/* ---- url encoding and query string (v1.4) ----
   Encoding works on the UTF-8 bytes: A-Za-z0-9-_.~ are kept, the
   space becomes %20 (or a plus sign in the form variant) and every
   other byte becomes %XX with uppercase hex digits.  Decoding turns
   %XX back into a byte and a plus sign into a space; an illegal %
   sequence is copied through literally instead of failing, and a byte
   run that is not legal UTF-8 is widened byte by byte so nothing is
   lost.  The query string functions accept an optional leading '?',
   split on '&', skip empty pieces, and return *decoded* names and
   values; a repeated key resolves to its first occurrence.  A piece
   without '=' is a parameter whose name is the whole piece and whose
   value is empty text: the by-key lookup reports empty text for it
   and does NOT fall back to the caller's default, so "is this key
   there" and "what is its value" always agree. */
const wchar_t* FB_url_encode(const wchar_t* s);
const wchar_t* FB_url_encode_form(const wchar_t* s);
const wchar_t* FB_url_decode(const wchar_t* s);
int FB_url_query_count(const wchar_t* query);
const wchar_t* FB_url_query_key_at(const wchar_t* query, int index);
const wchar_t* FB_url_query_value_at(const wchar_t* query, int index);
const wchar_t* FB_url_query_get(const wchar_t* query, const wchar_t* key, const wchar_t* def);

/* ---- text file reading and writing (v1.5, Win32 code page conversion) ----
   The whole point of this group is that the Volcano side never sees bytes:
   every encoding conversion happens here, and the caller always receives
   ordinary UTF-16 text.  Byte strings are deliberately NOT exposed.

   Encoding parameter, used by read / write / append:
     0 = auto   1 = UTF-8   2 = GBK (code page 936)
     3 = UTF-16LE   4 = UTF-16BE   5 = GBK, replacement allowed (write only)
   Detection order on read with 0: a BOM wins (EF BB BF -> 1, FF FE -> 3,
   FE FF -> 4); with no BOM the bytes are validated as UTF-8 through
   MultiByteToWideChar(CP_UTF8, MB_ERR_INVALID_CHARS, ...) and only when that
   fails is GBK assumed.  Pure ASCII therefore reports 1 (UTF-8), which is
   correct - ASCII is valid UTF-8 and decodes identically either way.
   Note that a byte run which is valid BOTH ways always resolves to UTF-8:
   E4 B8 AD 41 is U+4E2D 'A' in UTF-8 and U+6D93 U+747C in GBK, and this
   module reports 1.  A GBK file that happens to be ambiguous must be read
   with an explicit 2.
   On write, 0 behaves like 1 (UTF-8, no BOM); 1 writes UTF-8 without a BOM;
   2 writes GBK; 3 and 4 write UTF-16 with the matching BOM.  Append writes a
   BOM only when the file is new or empty, so appending never corrupts a
   UTF-16 file.

   GBK on WRITE is strict by default: a character that code page 936 cannot
   represent (an emoji, a CJK extension-A ideograph, ...) makes the whole call
   fail with a Chinese reason and NOTHING is written, so an existing file is
   left untouched.  Encoding 5 is the opt-in lenient variant: those characters
   become '?' (one per UTF-16 code unit, so one emoji yields two '?'), the call
   returns 1, and a visible note counting the substitutions is placed in the
   error slot while the success flag stays true - judge success by the return
   value, not by the note.  Encoding 5 is rejected on read (0..4 only), because
   reading GBK never validates strictly, so there is no strict/lenient split.

   Files larger than 64 MiB are refused by read (empty text plus the reason
   "too large") instead of being loaded, so a wrong path can never exhaust
   memory.  Files are opened in binary mode, so a file containing NUL bytes
   reads back as text with embedded NULs rather than being truncated by the
   CRT - note that a returned const wchar_t* still cannot carry a NUL across
   the C ABI, so such a text is cut at the first NUL exactly like the URL
   %00 case documented in the README. */
const wchar_t* FB_file_read_text(const wchar_t* path, int encoding);
int FB_file_write_text(const wchar_t* path, const wchar_t* text, int encoding);
int FB_file_append_text(const wchar_t* path, const wchar_t* text, int encoding);
int FB_file_detect_encoding(const wchar_t* path);          /* 0..4, or -1 on failure */

/* ---- bitset (v1.5, boost/dynamic_bitset) ----
   Bit order is fixed and load bearing: bit 0 is the RIGHT-most character.
   FB_bitset_from_text("1010") therefore yields test(1) == 1 and test(0) == 0,
   and to_binary always prints the high bit on the left with a length equal
   to the bit count (an all-zero 8 bit set prints "00000000", never "").
   to_hex groups bits from the low end in nibbles, drops leading zeros and
   prints "0" for an all-zero set.
   Handles live in their own table; 0 is invalid, freeing twice returns 0. */
intptr_t FB_bitset_new(int64_t bit_count);              /* all zero; negative counts as 0 */
intptr_t FB_bitset_from_text(const wchar_t* bits);      /* "1010", "0b1010" or "1010b" */
int FB_bitset_count(intptr_t h);                        /* -1 = invalid handle */
int FB_bitset_true_count(intptr_t h);
int FB_bitset_test(intptr_t h, int64_t i);              /* 1/0; out of range -1 */
int FB_bitset_set(intptr_t h, int64_t i, int v);        /* 0 = out of range or invalid */
int FB_bitset_flip(intptr_t h, int64_t i);              /* 0 = out of range or invalid */
int FB_bitset_flip_all(intptr_t h);                     /* 0 = invalid handle */
int FB_bitset_resize(intptr_t h, int64_t n, int fill);  /* 1 = success */
const wchar_t* FB_bitset_to_binary(intptr_t h);         /* high bit left, length = bit count */
const wchar_t* FB_bitset_to_hex(intptr_t h);            /* "0" when all zero, no leading zeros */
intptr_t FB_bitset_op(intptr_t a, intptr_t b, int op);  /* 0=and 1=or 2=xor 3=a and not b */
intptr_t FB_bitset_clone(intptr_t h);
int FB_bitset_free(intptr_t h);                         /* freeing twice returns 0 */

/* ---- text tool extensions (v1.5) ---- */
int FB_text_glob(const wchar_t* text, const wchar_t* pattern);   /* * ? [abc] [!abc]; case sensitive */
const wchar_t* FB_text_convert_base(const wchar_t* number, int from_base, int to_base);
const wchar_t* FB_text_pad_display(const wchar_t* text, int width, int mode);

#ifdef __cplusplus
}
#endif

#endif /* VOL_BOOST_BRIDGE_H */
