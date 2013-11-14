/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.Encodable;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * Provides the constants for the standard HTTP header names and values and
 * commonly used utility methods that accesses an {@link HttpMessage}.
 */
public abstract class HttpHeaders implements Iterable<Map.Entry<String, String>> {

    public static final HttpHeaders EMPTY_HEADERS = new HttpHeaders() {
        @Override
        public String get(CharSequence name) {
            return null;
        }

        @Override
        public List<String> getAll(CharSequence name) {
            return Collections.emptyList();
        }

        @Override
        public List<Entry<String, String>> entries() {
            return Collections.emptyList();
        }

        @Override
        public boolean contains(CharSequence name) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public Set<String> names() {
            return Collections.emptySet();
        }

        @Override
        public HttpHeaders add(CharSequence name, Object value) {
            throw new UnsupportedOperationException("read only");
        }

        @Override
        public HttpHeaders add(CharSequence name, Iterable<?> values) {
            throw new UnsupportedOperationException("read only");
        }

        @Override
        public HttpHeaders set(CharSequence name, Object value) {
            throw new UnsupportedOperationException("read only");
        }

        @Override
        public HttpHeaders set(CharSequence name, Iterable<?> values) {
            throw new UnsupportedOperationException("read only");
        }

        @Override
        public HttpHeaders remove(CharSequence name) {
            throw new UnsupportedOperationException("read only");
        }

        @Override
        public HttpHeaders clear() {
            throw new UnsupportedOperationException("read only");
        }

        @Override
        public Iterator<Entry<String, String>> iterator() {
            return entries().iterator();
        }
    };

    /**
     * Standard HTTP header names.
     */
    public static final class Names {
        /**
         * {@code "Accept"}
         */
        public static final CharSequence ACCEPT = new HeaderCharSequence("Accept");
        /**
         * {@code "Accept-Charset"}
         */
        public static final CharSequence ACCEPT_CHARSET = new HeaderCharSequence("Accept-Charset");
        /**
         * {@code "Accept-Encoding"}
         */
        public static final CharSequence ACCEPT_ENCODING = new HeaderCharSequence("Accept-Encoding");
        /**
         * {@code "Accept-Language"}
         */
        public static final CharSequence ACCEPT_LANGUAGE = new HeaderCharSequence("Accept-Language");
        /**
         * {@code "Accept-Ranges"}
         */
        public static final CharSequence ACCEPT_RANGES = new HeaderCharSequence("Accept-Ranges");
        /**
         * {@code "Accept-Patch"}
         */
        public static final CharSequence ACCEPT_PATCH = new HeaderCharSequence("Accept-Patch");
        /**
         * {@code "Access-Control-Allow-Credentials"}
         */
        public static final CharSequence ACCESS_CONTROL_ALLOW_CREDENTIALS
                =
                new HeaderCharSequence("Access-Control-Allow-Credentials");
        /**
         * {@code "Access-Control-Allow-Headers"}
         */
        public static final CharSequence ACCESS_CONTROL_ALLOW_HEADERS
                = new HeaderCharSequence("Access-Control-Allow-Headers");
        /**
         * {@code "Access-Control-Allow-Methods"}
         */
        public static final CharSequence ACCESS_CONTROL_ALLOW_METHODS
                = new HeaderCharSequence("Access-Control-Allow-Methods");
        /**
         * {@code "Access-Control-Allow-Origin"}
         */
        public static final CharSequence ACCESS_CONTROL_ALLOW_ORIGIN
                = new HeaderCharSequence("Access-Control-Allow-Origin");
        /**
         * {@code "Access-Control-Expose-Headers"}
         */
        public static final CharSequence ACCESS_CONTROL_EXPOSE_HEADERS
                = new HeaderCharSequence("Access-Control-Expose-Headers");
        /**
         * {@code "Access-Control-Max-Age"}
         */
        public static final CharSequence ACCESS_CONTROL_MAX_AGE
                = new HeaderCharSequence("Access-Control-Max-Age");
        /**
         * {@code "Access-Control-Request-Headers"}
         */
        public static final CharSequence ACCESS_CONTROL_REQUEST_HEADERS
                = new HeaderCharSequence("Access-Control-Request-Headers");
        /**
         * {@code "Access-Control-Request-Method"}
         */
        public static final CharSequence ACCESS_CONTROL_REQUEST_METHOD
                = new HeaderCharSequence("Access-Control-Request-Method");
        /**
         * {@code "Age"}
         */
        public static final CharSequence AGE = new HeaderCharSequence("Age");
        /**
         * {@code "Allow"}
         */
        public static final CharSequence ALLOW = new HeaderCharSequence("Allow");
        /**
         * {@code "Authorization"}
         */
        public static final CharSequence AUTHORIZATION = new HeaderCharSequence("Authorization");
        /**
         * {@code "Cache-Control"}
         */
        public static final CharSequence CACHE_CONTROL = new HeaderCharSequence("Cache-Control");
        /**
         * {@code "Connection"}
         */
        public static final CharSequence CONNECTION = new HeaderCharSequence("Connection");
        /**
         * {@code "Content-Base"}
         */
        public static final CharSequence CONTENT_BASE = new HeaderCharSequence("Content-Base");
        /**
         * {@code "Content-Encoding"}
         */
        public static final CharSequence CONTENT_ENCODING = new HeaderCharSequence("Content-Encoding");
        /**
         * {@code "Content-Language"}
         */
        public static final CharSequence CONTENT_LANGUAGE = new HeaderCharSequence("Content-Language");
        /**
         * {@code "Content-Length"}
         */
        public static final CharSequence CONTENT_LENGTH = new HeaderCharSequence("Content-Length");
        /**
         * {@code "Content-Location"}
         */
        public static final CharSequence CONTENT_LOCATION = new HeaderCharSequence("Content-Location");
        /**
         * {@code "Content-Transfer-Encoding"}
         */
        public static final CharSequence CONTENT_TRANSFER_ENCODING
                = new HeaderCharSequence("Content-Transfer-Encoding");
        /**
         * {@code "Content-MD5"}
         */
        public static final CharSequence CONTENT_MD5 = new HeaderCharSequence("Content-MD5");
        /**
         * {@code "Content-Range"}
         */
        public static final CharSequence CONTENT_RANGE = new HeaderCharSequence("Content-Range");
        /**
         * {@code "Content-Type"}
         */
        public static final CharSequence CONTENT_TYPE = new HeaderCharSequence("Content-Type");
        /**
         * {@code "Cookie"}
         */
        public static final CharSequence COOKIE = new HeaderCharSequence("Cookie");
        /**
         * {@code "Date"}
         */
        public static final CharSequence DATE = new HeaderCharSequence("Date");
        /**
         * {@code "ETag"}
         */
        public static final CharSequence ETAG = new HeaderCharSequence("ETag");
        /**
         * {@code "Expect"}
         */
        public static final CharSequence EXPECT = new HeaderCharSequence("Expect");
        /**
         * {@code "Expires"}
         */
        public static final CharSequence EXPIRES = new HeaderCharSequence("Expires");
        /**
         * {@code "From"}
         */
        public static final CharSequence FROM = new HeaderCharSequence("From");
        /**
         * {@code "Host"}
         */
        public static final CharSequence HOST = new HeaderCharSequence("Host");
        /**
         * {@code "If-Match"}
         */
        public static final CharSequence IF_MATCH = new HeaderCharSequence("If-Match");
        /**
         * {@code "If-Modified-Since"}
         */
        public static final CharSequence IF_MODIFIED_SINCE = new HeaderCharSequence("If-Modified-Since");
        /**
         * {@code "If-None-Match"}
         */
        public static final CharSequence IF_NONE_MATCH = new HeaderCharSequence("If-None-Match");
        /**
         * {@code "If-Range"}
         */
        public static final CharSequence IF_RANGE = new HeaderCharSequence("If-Range");
        /**
         * {@code "If-Unmodified-Since"}
         */
        public static final CharSequence IF_UNMODIFIED_SINCE = new HeaderCharSequence("If-Unmodified-Since");
        /**
         * {@code "Last-Modified"}
         */
        public static final CharSequence LAST_MODIFIED = new HeaderCharSequence("Last-Modified");
        /**
         * {@code "Location"}
         */
        public static final CharSequence LOCATION = new HeaderCharSequence("Location");
        /**
         * {@code "Max-Forwards"}
         */
        public static final CharSequence MAX_FORWARDS = new HeaderCharSequence("Max-Forwards");
        /**
         * {@code "Origin"}
         */
        public static final CharSequence ORIGIN = new HeaderCharSequence("Origin");
        /**
         * {@code "Pragma"}
         */
        public static final CharSequence PRAGMA = new HeaderCharSequence("Pragma");
        /**
         * {@code "Proxy-Authenticate"}
         */
        public static final CharSequence PROXY_AUTHENTICATE = new HeaderCharSequence("Proxy-Authenticate");
        /**
         * {@code "Proxy-Authorization"}
         */
        public static final CharSequence PROXY_AUTHORIZATION = new HeaderCharSequence("Proxy-Authorization");
        /**
         * {@code "Range"}
         */
        public static final CharSequence RANGE = new HeaderCharSequence("Range");
        /**
         * {@code "Referer"}
         */
        public static final CharSequence REFERER = new HeaderCharSequence("Referer");
        /**
         * {@code "Retry-After"}
         */
        public static final CharSequence RETRY_AFTER = new HeaderCharSequence("Retry-After");
        /**
         * {@code "Sec-WebSocket-Key1"}
         */
        public static final CharSequence SEC_WEBSOCKET_KEY1 = new HeaderCharSequence("Sec-WebSocket-Key1");
        /**
         * {@code "Sec-WebSocket-Key2"}
         */
        public static final CharSequence SEC_WEBSOCKET_KEY2 = new HeaderCharSequence("Sec-WebSocket-Key2");
        /**
         * {@code "Sec-WebSocket-Location"}
         */
        public static final CharSequence SEC_WEBSOCKET_LOCATION = new HeaderCharSequence("Sec-WebSocket-Location");
        /**
         * {@code "Sec-WebSocket-Origin"}
         */
        public static final CharSequence SEC_WEBSOCKET_ORIGIN = new HeaderCharSequence("Sec-WebSocket-Origin");
        /**
         * {@code "Sec-WebSocket-Protocol"}
         */
        public static final CharSequence SEC_WEBSOCKET_PROTOCOL = new HeaderCharSequence("Sec-WebSocket-Protocol");
        /**
         * {@code "Sec-WebSocket-Version"}
         */
        public static final CharSequence SEC_WEBSOCKET_VERSION = new HeaderCharSequence("Sec-WebSocket-Version");
        /**
         * {@code "Sec-WebSocket-Key"}
         */
        public static final CharSequence SEC_WEBSOCKET_KEY = new HeaderCharSequence("Sec-WebSocket-Key");
        /**
         * {@code "Sec-WebSocket-Accept"}
         */
        public static final CharSequence SEC_WEBSOCKET_ACCEPT = new HeaderCharSequence("Sec-WebSocket-Accept");
        /**
         * {@code "Server"}
         */
        public static final CharSequence SERVER = new HeaderCharSequence("Server");
        /**
         * {@code "Set-Cookie"}
         */
        public static final CharSequence SET_COOKIE = new HeaderCharSequence("Set-Cookie");
        /**
         * {@code "Set-Cookie2"}
         */
        public static final CharSequence SET_COOKIE2 = new HeaderCharSequence("Set-Cookie2");
        /**
         * {@code "TE"}
         */
        public static final CharSequence TE = new HeaderCharSequence("TE");
        /**
         * {@code "Trailer"}
         */
        public static final CharSequence TRAILER = new HeaderCharSequence("Trailer");
        /**
         * {@code "Transfer-Encoding"}
         */
        public static final CharSequence TRANSFER_ENCODING = new HeaderCharSequence("Transfer-Encoding");
        /**
         * {@code "Upgrade"}
         */
        public static final CharSequence UPGRADE = new HeaderCharSequence("Upgrade");
        /**
         * {@code "User-Agent"}
         */
        public static final CharSequence USER_AGENT = new HeaderCharSequence("User-Agent");
        /**
         * {@code "Vary"}
         */
        public static final CharSequence VARY = new HeaderCharSequence("Vary");
        /**
         * {@code "Via"}
         */
        public static final CharSequence VIA = new HeaderCharSequence("Via");
        /**
         * {@code "Warning"}
         */
        public static final CharSequence WARNING = new HeaderCharSequence("Warning");
        /**
         * {@code "WebSocket-Location"}
         */
        public static final CharSequence WEBSOCKET_LOCATION = new HeaderCharSequence("WebSocket-Location");
        /**
         * {@code "WebSocket-Origin"}
         */
        public static final CharSequence WEBSOCKET_ORIGIN = new HeaderCharSequence("WebSocket-Origin");
        /**
         * {@code "WebSocket-Protocol"}
         */
        public static final CharSequence WEBSOCKET_PROTOCOL = new HeaderCharSequence("WebSocket-Protocol");
        /**
         * {@code "WWW-Authenticate"}
         */
        public static final CharSequence WWW_AUTHENTICATE = new HeaderCharSequence("WWW-Authenticate");

        private Names() {
        }
    }

    /**
     * Standard HTTP header values.
     */
    public static final class Values {
        /**
         * {@code "application/x-www-form-urlencoded"}
         */
         public static final CharSequence APPLICATION_X_WWW_FORM_URLENCODED =
                new HeaderCharSequence("application/x-www-form-urlencoded");
        /**
         * {@code "base64"}
         */
        public static final CharSequence BASE64 = new HeaderCharSequence("base64");
        /**
         * {@code "binary"}
         */
        public static final CharSequence BINARY = new HeaderCharSequence("binary");
        /**
         * {@code "boundary"}
         */
        public static final CharSequence BOUNDARY = new HeaderCharSequence("boundary");
        /**
         * {@code "bytes"}
         */
        public static final CharSequence BYTES = new HeaderCharSequence("bytes");
        /**
         * {@code "charset"}
         */
        public static final CharSequence CHARSET = new HeaderCharSequence("charset");
        /**
         * {@code "chunked"}
         */
        public static final CharSequence CHUNKED = new HeaderCharSequence("chunked");
        /**
         * {@code "close"}
         */
        public static final CharSequence CLOSE = new HeaderCharSequence("close");
        /**
         * {@code "compress"}
         */
        public static final CharSequence COMPRESS = new HeaderCharSequence("compress");
        /**
         * {@code "100-continue"}
         */
        public static final CharSequence CONTINUE =  new HeaderCharSequence("100-continue");
        /**
         * {@code "deflate"}
         */
        public static final CharSequence DEFLATE = new HeaderCharSequence("deflate");
        /**
         * {@code "gzip"}
         */
        public static final CharSequence GZIP = new HeaderCharSequence("gzip");
        /**
         * {@code "identity"}
         */
        public static final CharSequence IDENTITY = new HeaderCharSequence("identity");
        /**
         * {@code "keep-alive"}
         */
        public static final CharSequence KEEP_ALIVE = new HeaderCharSequence("keep-alive");
        /**
         * {@code "max-age"}
         */
        public static final CharSequence MAX_AGE = new HeaderCharSequence("max-age");
        /**
         * {@code "max-stale"}
         */
        public static final CharSequence MAX_STALE = new HeaderCharSequence("max-stale");
        /**
         * {@code "min-fresh"}
         */
        public static final CharSequence MIN_FRESH = new HeaderCharSequence("min-fresh");
        /**
         * {@code "multipart/form-data"}
         */
        public static final CharSequence MULTIPART_FORM_DATA = new HeaderCharSequence("multipart/form-data");
        /**
         * {@code "must-revalidate"}
         */
        public static final CharSequence MUST_REVALIDATE = new HeaderCharSequence("must-revalidate");
        /**
         * {@code "no-cache"}
         */
        public static final CharSequence NO_CACHE = new HeaderCharSequence("no-cache");
        /**
         * {@code "no-store"}
         */
        public static final CharSequence NO_STORE = new HeaderCharSequence("no-store");
        /**
         * {@code "no-transform"}
         */
        public static final CharSequence NO_TRANSFORM = new HeaderCharSequence("no-transform");
        /**
         * {@code "none"}
         */
        public static final CharSequence NONE = new HeaderCharSequence("none");
        /**
         * {@code "only-if-cached"}
         */
        public static final CharSequence ONLY_IF_CACHED = new HeaderCharSequence("only-if-cached");
        /**
         * {@code "private"}
         */
        public static final CharSequence PRIVATE = new HeaderCharSequence("private");
        /**
         * {@code "proxy-revalidate"}
         */
        public static final CharSequence PROXY_REVALIDATE = new HeaderCharSequence("proxy-revalidate");
        /**
         * {@code "public"}
         */
        public static final CharSequence PUBLIC = new HeaderCharSequence("public");
        /**
         * {@code "quoted-printable"}
         */
        public static final CharSequence QUOTED_PRINTABLE = new HeaderCharSequence("quoted-printable");
        /**
         * {@code "s-maxage"}
         */
        public static final CharSequence S_MAXAGE = new HeaderCharSequence("s-maxage");
        /**
         * {@code "trailers"}
         */
        public static final CharSequence TRAILERS = new HeaderCharSequence("trailers");
        /**
         * {@code "Upgrade"}
         */
        public static final CharSequence UPGRADE = new HeaderCharSequence("Upgrade");
        /**
         * {@code "WebSocket"}
         */
        public static final CharSequence WEBSOCKET = new HeaderCharSequence("WebSocket");

        private Values() {
        }
    }

    public static boolean eq(CharSequence name1, CharSequence name2) {
        int nameLen = name1.length();
        if (nameLen != name2.length()) {
            return false;
        }

        for (int i = nameLen - 1; i >= 0; i --) {
            char c1 = name1.charAt(i);
            char c2 = name2.charAt(i);
            if (c1 != c2) {
                if (c1 >= 'A' && c1 <= 'Z') {
                    c1 += 32;
                }
                if (c2 >= 'A' && c2 <= 'Z') {
                    c2 += 32;
                }
                if (c1 != c2) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns {@code true} if and only if the connection can remain open and
     * thus 'kept alive'.  This methods respects the value of the
     * {@code "Connection"} header first and then the return value of
     * {@link HttpVersion#isKeepAliveDefault()}.
     */
    public static boolean isKeepAlive(HttpMessage message) {
        String connection = message.headers().get(Names.CONNECTION);
        if (eq(Values.CLOSE, connection)) {
            return false;
        }

        if (message.getProtocolVersion().isKeepAliveDefault()) {
            return !eq(Values.CLOSE, connection);
        } else {
            return eq(Values.KEEP_ALIVE, connection);
        }
    }

    /**
     * Sets the value of the {@code "Connection"} header depending on the
     * protocol version of the specified message.  This getMethod sets or removes
     * the {@code "Connection"} header depending on what the default keep alive
     * mode of the message's protocol version is, as specified by
     * {@link HttpVersion#isKeepAliveDefault()}.
     * <ul>
     * <li>If the connection is kept alive by default:
     *     <ul>
     *     <li>set to {@code "close"} if {@code keepAlive} is {@code false}.</li>
     *     <li>remove otherwise.</li>
     *     </ul></li>
     * <li>If the connection is closed by default:
     *     <ul>
     *     <li>set to {@code "keep-alive"} if {@code keepAlive} is {@code true}.</li>
     *     <li>remove otherwise.</li>
     *     </ul></li>
     * </ul>
     */
    public static void setKeepAlive(HttpMessage message, boolean keepAlive) {
        HttpHeaders h = message.headers();
        if (message.getProtocolVersion().isKeepAliveDefault()) {
            if (keepAlive) {
                h.remove(Names.CONNECTION);
            } else {
                h.set(Names.CONNECTION, Values.CLOSE);
            }
        } else {
            if (keepAlive) {
                h.set(Names.CONNECTION, Values.KEEP_ALIVE);
            } else {
                h.remove(Names.CONNECTION);
            }
        }
    }

    /**
     * Returns the header value with the specified header name.  If there are
     * more than one header value for the specified header name, the first
     * value is returned.
     *
     * @return the header value or {@code null} if there is no such header
     */
    public static String getHeader(HttpMessage message, String name) {
        return message.headers().get(name);
    }

    /**
     * Returns the header value with the specified header name.  If there are
     * more than one header value for the specified header name, the first
     * value is returned.
     *
     * @return the header value or the {@code defaultValue} if there is no such
     *         header
     */
    public static String getHeader(HttpMessage message, String name, String defaultValue) {
        String value = message.headers().get(name);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Sets a new header with the specified name and value.  If there is an
     * existing header with the same name, the existing header is removed.
     * If the specified value is not a {@link String}, it is converted into a
     * {@link String} by {@link Object#toString()}, except for {@link Date}
     * and {@link Calendar} which are formatted to the date format defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>.
     */
    public static void setHeader(HttpMessage message, String name, Object value) {
        message.headers().set(name, value);
    }

    /**
     * Sets a new header with the specified name and values.  If there is an
     * existing header with the same name, the existing header is removed.
     * This getMethod can be represented approximately as the following code:
     * <pre>
     * removeHeader(message, name);
     * for (Object v: values) {
     *     if (v == null) {
     *         break;
     *     }
     *     addHeader(message, name, v);
     * }
     * </pre>
     */
    public static void setHeader(HttpMessage message, String name, Iterable<?> values) {
        message.headers().set(name, values);
    }

    /**
     * Adds a new header with the specified name and value.
     * If the specified value is not a {@link String}, it is converted into a
     * {@link String} by {@link Object#toString()}, except for {@link Date}
     * and {@link Calendar} which are formatted to the date format defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>.
     */
    public static void addHeader(HttpMessage message, CharSequence name, Object value) {
        message.headers().add(name, value);
    }

    /**
     * Removes the header with the specified name.
     */
    public static void removeHeader(HttpMessage message, CharSequence name) {
        message.headers().remove(name);
    }

    /**
     * Removes all headers from the specified message.
     */
    public static void clearHeaders(HttpMessage message) {
        message.headers().clear();
    }

    /**
     * Returns the integer header value with the specified header name.  If
     * there are more than one header value for the specified header name, the
     * first value is returned.
     *
     * @return the header value
     * @throws NumberFormatException
     *         if there is no such header or the header value is not a number
     */
    public static int getIntHeader(HttpMessage message, String name) {
        String value = getHeader(message, name);
        if (value == null) {
            throw new NumberFormatException("header not found: " + name);
        }
        return Integer.parseInt(value);
    }

    /**
     * Returns the integer header value with the specified header name.  If
     * there are more than one header value for the specified header name, the
     * first value is returned.
     *
     * @return the header value or the {@code defaultValue} if there is no such
     *         header or the header value is not a number
     */
    public static int getIntHeader(HttpMessage message, String name, int defaultValue) {
        String value = getHeader(message, name);
        if (value == null) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Sets a new integer header with the specified name and value.  If there
     * is an existing header with the same name, the existing header is removed.
     */
    public static void setIntHeader(HttpMessage message, String name, int value) {
        message.headers().set(name, value);
    }

    /**
     * Sets a new integer header with the specified name and values.  If there
     * is an existing header with the same name, the existing header is removed.
     */
    public static void setIntHeader(HttpMessage message, String name, Iterable<Integer> values) {
        message.headers().set(name, values);
    }

    /**
     * Adds a new integer header with the specified name and value.
     */
    public static void addIntHeader(HttpMessage message, String name, int value) {
        message.headers().add(name, value);
    }

    /**
     * Returns the date header value with the specified header name.  If
     * there are more than one header value for the specified header name, the
     * first value is returned.
     *
     * @return the header value
     * @throws ParseException
     *         if there is no such header or the header value is not a formatted date
     */
    public static Date getDateHeader(HttpMessage message, String name) throws ParseException {
        String value = getHeader(message, name);
        if (value == null) {
            throw new ParseException("header not found: " + name, 0);
        }
        return HttpHeaderDateFormat.get().parse(value);
    }

    /**
     * Returns the date header value with the specified header name.  If
     * there are more than one header value for the specified header name, the
     * first value is returned.
     *
     * @return the header value or the {@code defaultValue} if there is no such
     *         header or the header value is not a formatted date
     */
    public static Date getDateHeader(HttpMessage message, String name, Date defaultValue) {
        final String value = getHeader(message, name);
        if (value == null) {
            return defaultValue;
        }

        try {
            return HttpHeaderDateFormat.get().parse(value);
        } catch (ParseException e) {
            return defaultValue;
        }
    }

    /**
     * Sets a new date header with the specified name and value.  If there
     * is an existing header with the same name, the existing header is removed.
     * The specified value is formatted as defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>
     */
    public static void setDateHeader(HttpMessage message, String name, Date value) {
        if (value != null) {
            message.headers().set(name, HttpHeaderDateFormat.get().format(value));
        } else {
            message.headers().set(name, null);
        }
    }

    /**
     * Sets a new date header with the specified name and values.  If there
     * is an existing header with the same name, the existing header is removed.
     * The specified values are formatted as defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>
     */
    public static void setDateHeader(HttpMessage message, String name, Iterable<Date> values) {
        message.headers().set(name, values);
    }

    /**
     * Adds a new date header with the specified name and value.  The specified
     * value is formatted as defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>
     */
    public static void addDateHeader(HttpMessage message, String name, Date value) {
        message.headers().add(name, value);
    }

    /**
     * Returns the length of the content.  Please note that this value is
     * not retrieved from {@link HttpContent#content()} but from the
     * {@code "Content-Length"} header, and thus they are independent from each
     * other.
     *
     * @return the content length
     *
     * @throws NumberFormatException
     *         if the message does not have the {@code "Content-Length"} header
     *         or its value is not a number
     */
    public static long getContentLength(HttpMessage message) {
        String value = getHeader(message, Names.CONTENT_LENGTH.toString());
        if (value != null) {
            return Long.parseLong(value);
        }

        // We know the content length if it's a Web Socket message even if
        // Content-Length header is missing.
        long webSocketContentLength = getWebSocketContentLength(message);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }

        // Otherwise we don't.
        throw new NumberFormatException("header not found: " + Names.CONTENT_LENGTH);
    }

    /**
     * Returns the length of the content.  Please note that this value is
     * not retrieved from {@link HttpContent#content()} but from the
     * {@code "Content-Length"} header, and thus they are independent from each
     * other.
     *
     * @return the content length or {@code defaultValue} if this message does
     *         not have the {@code "Content-Length"} header or its value is not
     *         a number
     */
    public static long getContentLength(HttpMessage message, long defaultValue) {
        String contentLength = message.headers().get(Names.CONTENT_LENGTH);
        if (contentLength != null) {
            try {
                return Long.parseLong(contentLength);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }

        // We know the content length if it's a Web Socket message even if
        // Content-Length header is missing.
        long webSocketContentLength = getWebSocketContentLength(message);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }

        // Otherwise we don't.
        return defaultValue;
    }

    /**
     * Returns the content length of the specified web socket message.  If the
     * specified message is not a web socket message, {@code -1} is returned.
     */
    private static int getWebSocketContentLength(HttpMessage message) {
        // WebSockset messages have constant content-lengths.
        HttpHeaders h = message.headers();
        if (message instanceof HttpRequest) {
            HttpRequest req = (HttpRequest) message;
            if (HttpMethod.GET.equals(req.getMethod()) &&
                h.contains(Names.SEC_WEBSOCKET_KEY1) &&
                h.contains(Names.SEC_WEBSOCKET_KEY2)) {
                return 8;
            }
        } else if (message instanceof HttpResponse) {
            HttpResponse res = (HttpResponse) message;
            if (res.getStatus().code() == 101 &&
                h.contains(Names.SEC_WEBSOCKET_ORIGIN) &&
                h.contains(Names.SEC_WEBSOCKET_LOCATION)) {
                return 16;
            }
        }

        // Not a web socket message
        return -1;
    }

    /**
     * Sets the {@code "Content-Length"} header.
     */
    public static void setContentLength(HttpMessage message, long length) {
        message.headers().set(Names.CONTENT_LENGTH, length);
    }

    /**
     * Returns the value of the {@code "Host"} header.
     */
    public static String getHost(HttpMessage message) {
        return message.headers().get(Names.HOST);
    }

    /**
     * Returns the value of the {@code "Host"} header.  If there is no such
     * header, the {@code defaultValue} is returned.
     */
    public static String getHost(HttpMessage message, String defaultValue) {
        return getHeader(message, Names.HOST.toString(), defaultValue);
    }

    /**
     * Sets the {@code "Host"} header.
     */
    public static void setHost(HttpMessage message, String value) {
        message.headers().set(Names.HOST, value);
    }

    /**
     * Returns the value of the {@code "Date"} header.
     *
     * @throws ParseException
     *         if there is no such header or the header value is not a formatted date
     */
    public static Date getDate(HttpMessage message) throws ParseException {
        return getDateHeader(message, Names.DATE.toString());
    }

    /**
     * Returns the value of the {@code "Date"} header. If there is no such
     * header or the header is not a formatted date, the {@code defaultValue}
     * is returned.
     */
    public static Date getDate(HttpMessage message, Date defaultValue) {
        return getDateHeader(message, Names.DATE.toString(), defaultValue);
    }

    /**
     * Sets the {@code "Date"} header.
     */
    public static void setDate(HttpMessage message, Date value) {
        if (value != null) {
            message.headers().set(Names.DATE, HttpHeaderDateFormat.get().format(value));
        } else {
            message.headers().set(Names.DATE, null);
        }
    }

    /**
     * Returns {@code true} if and only if the specified message contains the
     * {@code "Expect: 100-continue"} header.
     */
    public static boolean is100ContinueExpected(HttpMessage message) {
        // Expect: 100-continue is for requests only.
        if (!(message instanceof HttpRequest)) {
            return false;
        }

        // It works only on HTTP/1.1 or later.
        if (message.getProtocolVersion().compareTo(HttpVersion.HTTP_1_1) < 0) {
            return false;
        }

        // In most cases, there will be one or zero 'Expect' header.
        String value = message.headers().get(Names.EXPECT);
        if (value == null) {
            return false;
        }
        if (eq(Values.CONTINUE, value)) {
            return true;
        }

        // Multiple 'Expect' headers.  Search through them.
        return message.headers().contains(Names.EXPECT, Values.CONTINUE, true);
    }

    /**
     * Sets the {@code "Expect: 100-continue"} header to the specified message.
     * If there is any existing {@code "Expect"} header, they are replaced with
     * the new one.
     */
    public static void set100ContinueExpected(HttpMessage message) {
        set100ContinueExpected(message, true);
    }

    /**
     * Sets or removes the {@code "Expect: 100-continue"} header to / from the
     * specified message.  If the specified {@code value} is {@code true},
     * the {@code "Expect: 100-continue"} header is set and all other previous
     * {@code "Expect"} headers are removed.  Otherwise, all {@code "Expect"}
     * headers are removed completely.
     */
    public static void set100ContinueExpected(HttpMessage message, boolean set) {
        if (set) {
            message.headers().set(Names.EXPECT, Values.CONTINUE);
        } else {
            message.headers().remove(Names.EXPECT);
        }
    }

    /**
     * Validates the name of a header
     *
     * @param headerName The header name being validated
     */
    static void validateHeaderName(CharSequence headerName) {
        //Check to see if the name is null
        if (headerName == null) {
            throw new NullPointerException("Header names cannot be null");
        }
        //Go through each of the characters in the name
        for (int index = 0; index < headerName.length(); index ++) {
            //Actually get the character
            char character = headerName.charAt(index);

            //Check to see if the character is not an ASCII character
            if (character > 127) {
                throw new IllegalArgumentException(
                        "Header name cannot contain non-ASCII characters: " + headerName);
            }

            //Check for prohibited characters.
            switch (character) {
                case '\t': case '\n': case 0x0b: case '\f': case '\r':
                case ' ':  case ',':  case ':':  case ';':  case '=':
                    throw new IllegalArgumentException(
                            "Header name cannot contain the following prohibited characters: " +
                                    "=,;: \\t\\r\\n\\v\\f: " + headerName);
            }
        }
    }

    /**
     * Validates the specified header value
     *
     * @param headerValue The value being validated
     */
    static void validateHeaderValue(CharSequence headerValue) {
        //Check to see if the value is null
        if (headerValue == null) {
            throw new NullPointerException("Header values cannot be null");
        }

        /*
         * Set up the state of the validation
         *
         * States are as follows:
         *
         * 0: Previous character was neither CR nor LF
         * 1: The previous character was CR
         * 2: The previous character was LF
         */
        int state = 0;

        //Start looping through each of the character

        for (int index = 0; index < headerValue.length(); index ++) {
            char character = headerValue.charAt(index);

            //Check the absolutely prohibited characters.
            switch (character) {
                case 0x0b: // Vertical tab
                    throw new IllegalArgumentException(
                            "Header value contains a prohibited character '\\v': " + headerValue);
                case '\f':
                    throw new IllegalArgumentException(
                            "Header value contains a prohibited character '\\f': " + headerValue);
            }

            // Check the CRLF (HT | SP) pattern
            switch (state) {
                case 0:
                    switch (character) {
                        case '\r':
                            state = 1;
                            break;
                        case '\n':
                            state = 2;
                            break;
                    }
                    break;
                case 1:
                    switch (character) {
                        case '\n':
                            state = 2;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Only '\\n' is allowed after '\\r': " + headerValue);
                    }
                    break;
                case 2:
                    switch (character) {
                        case '\t': case ' ':
                            state = 0;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Only ' ' and '\\t' are allowed after '\\n': " + headerValue);
                    }
            }
        }

        if (state != 0) {
            throw new IllegalArgumentException(
                    "Header value must not end with '\\r' or '\\n':" + headerValue);
        }
    }

    /**
     * Checks to see if the transfer encoding in a specified {@link HttpMessage} is chunked
     *
     * @param message The message to check
     * @return True if transfer encoding is chunked, otherwise false
     */
    public static boolean isTransferEncodingChunked(HttpMessage message) {
        return message.headers().contains(Names.TRANSFER_ENCODING, Values.CHUNKED, true);
    }

    public static void removeTransferEncodingChunked(HttpMessage m) {
        List<String> values = m.headers().getAll(Names.TRANSFER_ENCODING);
        if (values.isEmpty()) {
            return;
        }
        Iterator<String> valuesIt = values.iterator();
        while (valuesIt.hasNext()) {
            String value = valuesIt.next();
            if (eq(value, Values.CHUNKED)) {
                valuesIt.remove();
            }
        }
        if (values.isEmpty()) {
            m.headers().remove(Names.TRANSFER_ENCODING);
        } else {
            m.headers().set(Names.TRANSFER_ENCODING, values);
        }
    }

    public static void setTransferEncodingChunked(HttpMessage m) {
        addHeader(m, Names.TRANSFER_ENCODING, Values.CHUNKED);
        removeHeader(m, Names.CONTENT_LENGTH);
    }

    public static boolean isContentLengthSet(HttpMessage m) {
        return m.headers().contains(Names.CONTENT_LENGTH);
    }

    public static void encodeAscii(CharSequence s, ByteBuf buf) {
        if (s instanceof Encodable) {
            ((Encodable) s).encode(buf);
        } else {
            for (int i = 0; i < s.length(); i++) {
                buf.writeByte(s.charAt(i));
            }
        }
    }

    protected HttpHeaders() { }

    /**
     * Returns the value of a header with the specified name.  If there are
     * more than one values for the specified name, the first value is returned.
     *
     * @param name The name of the header to search
     * @return The first header value or {@code null} if there is no such header
     */
    public abstract String get(CharSequence name);

    /**
     * Returns the values of headers with the specified name
     *
     * @param name The name of the headers to search
     * @return A {@link List} of header values which will be empty if no values
     *         are found
     */
    public abstract List<String> getAll(CharSequence name);

    /**
     * Returns the all headers that this message contains.
     *
     * @return A {@link List} of the header name-value entries, which will be
     *         empty if no pairs are found
     */
    public abstract List<Map.Entry<String, String>> entries();

    /**
     * Checks to see if there is a header with the specified name
     *
     * @param name The name of the header to search for
     * @return True if at least one header is found
     */
    public abstract boolean contains(CharSequence name);

    /**
     * Checks if no header exists.
     */
    public abstract boolean isEmpty();

    /**
     * Gets a {@link Set} of all header names that this message contains
     *
     * @return A {@link Set} of all header names
     */
    public abstract Set<String> names();

    /**
     * Adds a new header with the specified name and value.
     *
     * If the specified value is not a {@link String}, it is converted
     * into a {@link String} by {@link Object#toString()}, except in the cases
     * of {@link Date} and {@link Calendar}, which are formatted to the date
     * format defined in <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>.
     *
     * @param name The name of the header being added
     * @param value The value of the header being added
     *
     * @return {@code this}
     */
    public abstract HttpHeaders add(CharSequence name, Object value);

    /**
     * Adds a new header with the specified name and values.
     *
     * This getMethod can be represented approximately as the following code:
     * <pre>
     * for (Object v: values) {
     *     if (v == null) {
     *         break;
     *     }
     *     headers.add(name, v);
     * }
     * </pre>
     *
     * @param name The name of the headers being set
     * @param values The values of the headers being set
     * @return {@code this}
     */
    public abstract HttpHeaders add(CharSequence name, Iterable<?> values);

    /**
     * Adds all header entries of the specified {@code headers}.
     *
     * @return {@code this}
     */
    public HttpHeaders add(HttpHeaders headers) {
        if (headers == null) {
            throw new NullPointerException("headers");
        }
        for (Map.Entry<String, String> e: headers) {
            add(e.getKey(), e.getValue());
        }
        return this;
    }

    /**
     * Sets a header with the specified name and value.
     *
     * If there is an existing header with the same name, it is removed.
     * If the specified value is not a {@link String}, it is converted into a
     * {@link String} by {@link Object#toString()}, except for {@link Date}
     * and {@link Calendar}, which are formatted to the date format defined in
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.3.1">RFC2616</a>.
     *
     * @param name The name of the header being set
     * @param value The value of the header being set
     * @return {@code this}
     */
    public abstract HttpHeaders set(CharSequence name, Object value);

    /**
     * Sets a header with the specified name and values.
     *
     * If there is an existing header with the same name, it is removed.
     * This getMethod can be represented approximately as the following code:
     * <pre>
     * headers.remove(name);
     * for (Object v: values) {
     *     if (v == null) {
     *         break;
     *     }
     *     headers.add(name, v);
     * }
     * </pre>
     *
     * @param name The name of the headers being set
     * @param values The values of the headers being set
     * @return {@code this}
     */
    public abstract HttpHeaders set(CharSequence name, Iterable<?> values);

    /**
     * Cleans the current header entries and copies all header entries of the specified {@code headers}.
     *
     * @return {@code this}
     */
    public HttpHeaders set(HttpHeaders headers) {
        if (headers == null) {
            throw new NullPointerException("headers");
        }
        clear();
        for (Map.Entry<String, String> e: headers) {
            add(e.getKey(), e.getValue());
        }
        return this;
    }

    /**
     * Removes the header with the specified name.
     *
     * @param name The name of the header to remove
     * @return {@code this}
     */
    public abstract HttpHeaders remove(CharSequence name);

    /**
     * Removes all headers from this {@link HttpMessage}.
     *
     * @return {@code this}
     */
    public abstract HttpHeaders clear();

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name              the headername
     * @param value             the value
     * @param ignoreCaseValue   {@code true} if case should be ignored
     * @return contains         {@code true} if it contains it {@code false} otherwise
     */
    public boolean contains(CharSequence name, CharSequence value, boolean ignoreCaseValue) {
        List<String> values = getAll(name);
        if (values.isEmpty()) {
            return false;
        }

        for (String v: values) {
            if (ignoreCaseValue) {
                if (eq(v, value)) {
                    return true;
                }
            } else {
                if (v.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
}
