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
package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpHeaderName;
import io.netty.handler.codec.http.HttpHeaders;


/**
 * Standard RTSP header names and values.
 */
public final class RtspHeaders {

    /**
     * Standard RTSP header names.
     */
    public static final class Names {
        /**
         * {@code "Accept"}
         */
        public static final CharSequence ACCEPT = HttpHeaders.Names.ACCEPT;
        /**
         * {@code "Accept-Encoding"}
         */
        public static final CharSequence ACCEPT_ENCODING = HttpHeaders.Names.ACCEPT_ENCODING;
        /**
         * {@code "Accept-Lanugage"}
         */
        public static final CharSequence ACCEPT_LANGUAGE = HttpHeaders.Names.ACCEPT_LANGUAGE;
        /**
         * {@code "Allow"}
         */
        public static final CharSequence ALLOW = new HttpHeaderName("Allow");
        /**
         * {@code "Authorization"}
         */
        public static final CharSequence AUTHORIZATION = HttpHeaders.Names.AUTHORIZATION;
        /**
         * {@code "Bandwidth"}
         */
        public static final CharSequence BANDWIDTH = new HttpHeaderName("Bandwidth");
        /**
         * {@code "Blocksize"}
         */
        public static final CharSequence BLOCKSIZE = new HttpHeaderName("Blocksize");
        /**
         * {@code "Cache-Control"}
         */
        public static final CharSequence CACHE_CONTROL = HttpHeaders.Names.CACHE_CONTROL;
        /**
         * {@code "Conference"}
         */
        public static final CharSequence CONFERENCE = new HttpHeaderName("Conference");
        /**
         * {@code "Connection"}
         */
        public static final CharSequence CONNECTION = HttpHeaders.Names.CONNECTION;
        /**
         * {@code "Content-Base"}
         */
        public static final CharSequence CONTENT_BASE = HttpHeaders.Names.CONTENT_BASE;
        /**
         * {@code "Content-Encoding"}
         */
        public static final CharSequence CONTENT_ENCODING = HttpHeaders.Names.CONTENT_ENCODING;
        /**
         * {@code "Content-Language"}
         */
        public static final CharSequence CONTENT_LANGUAGE = HttpHeaders.Names.CONTENT_LANGUAGE;
        /**
         * {@code "Content-Length"}
         */
        public static final CharSequence CONTENT_LENGTH = HttpHeaders.Names.CONTENT_LENGTH;
        /**
         * {@code "Content-Location"}
         */
        public static final CharSequence CONTENT_LOCATION = HttpHeaders.Names.CONTENT_LOCATION;
        /**
         * {@code "Content-Type"}
         */
        public static final CharSequence CONTENT_TYPE = HttpHeaders.Names.CONTENT_TYPE;
        /**
         * {@code "CSeq"}
         */
        public static final CharSequence CSEQ = new HttpHeaderName("CSeq");
        /**
         * {@code "Date"}
         */
        public static final CharSequence DATE = HttpHeaders.Names.DATE;
        /**
         * {@code "Expires"}
         */
        public static final CharSequence EXPIRES = HttpHeaders.Names.EXPIRES;
        /**
         * {@code "From"}
         */
        public static final CharSequence FROM = HttpHeaders.Names.FROM;
        /**
         * {@code "Host"}
         */
        public static final CharSequence HOST = HttpHeaders.Names.HOST;
        /**
         * {@code "If-Match"}
         */
        public static final CharSequence IF_MATCH = HttpHeaders.Names.IF_MATCH;
        /**
         * {@code "If-Modified-Since"}
         */
        public static final CharSequence IF_MODIFIED_SINCE = HttpHeaders.Names.IF_MODIFIED_SINCE;
        /**
         * {@code "KeyMgmt"}
         */
        public static final CharSequence KEYMGMT = new HttpHeaderName("KeyMgmt");
        /**
         * {@code "Last-Modified"}
         */
        public static final CharSequence LAST_MODIFIED = HttpHeaders.Names.LAST_MODIFIED;
        /**
         * {@code "Proxy-Authenticate"}
         */
        public static final CharSequence PROXY_AUTHENTICATE = HttpHeaders.Names.PROXY_AUTHENTICATE;
        /**
         * {@code "Proxy-Require"}
         */
        public static final CharSequence PROXY_REQUIRE = new HttpHeaderName("Proxy-Require");
        /**
         * {@code "Public"}
         */
        public static final CharSequence PUBLIC = new HttpHeaderName("Public");
        /**
         * {@code "Range"}
         */
        public static final CharSequence RANGE = HttpHeaders.Names.RANGE;
        /**
         * {@code "Referer"}
         */
        public static final CharSequence REFERER = HttpHeaders.Names.REFERER;
        /**
         * {@code "Require"}
         */
        public static final CharSequence REQUIRE = new HttpHeaderName("Require");
        /**
         * {@code "Retry-After"}
         */
        public static final CharSequence RETRT_AFTER = HttpHeaders.Names.RETRY_AFTER;
        /**
         * {@code "RTP-Info"}
         */
        public static final CharSequence RTP_INFO = new HttpHeaderName("RTP-Info");
        /**
         * {@code "Scale"}
         */
        public static final CharSequence SCALE = new HttpHeaderName("Scale");
        /**
         * {@code "Session"}
         */
        public static final CharSequence SESSION = new HttpHeaderName("Session");
        /**
         * {@code "Server"}
         */
        public static final CharSequence SERVER = HttpHeaders.Names.SERVER;
        /**
         * {@code "Speed"}
         */
        public static final CharSequence SPEED = new HttpHeaderName("Speed");
        /**
         * {@code "Timestamp"}
         */
        public static final CharSequence TIMESTAMP = new HttpHeaderName("Timestamp");
        /**
         * {@code "Transport"}
         */
        public static final CharSequence TRANSPORT = new HttpHeaderName("Transport");
        /**
         * {@code "Unsupported"}
         */
        public static final CharSequence UNSUPPORTED = new HttpHeaderName("Unsupported");
        /**
         * {@code "User-Agent"}
         */
        public static final CharSequence USER_AGENT = HttpHeaders.Names.USER_AGENT;
        /**
         * {@code "Vary"}
         */
        public static final CharSequence VARY = HttpHeaders.Names.VARY;
        /**
         * {@code "Via"}
         */
        public static final CharSequence VIA = HttpHeaders.Names.VIA;
        /**
         * {@code "WWW-Authenticate"}
         */
        public static final CharSequence WWW_AUTHENTICATE = HttpHeaders.Names.WWW_AUTHENTICATE;

        private Names() {
        }
    }

    /**
     * Standard RTSP header values.
     */
    public static final class Values {
        /**
         * {@code "append"}
         */
        public static final String APPEND = "append";
        /**
         * {@code "AVP"}
         */
        public static final String AVP = "AVP";
        /**
         * {@code "bytes"}
         */
        public static final String BYTES = HttpHeaders.Values.BYTES;
        /**
         * {@code "charset"}
         */
        public static final String CHARSET = HttpHeaders.Values.CHARSET;
        /**
         * {@code "client_port"}
         */
        public static final String CLIENT_PORT = "client_port";
        /**
         * {@code "clock"}
         */
        public static final String CLOCK = "clock";
        /**
         * {@code "close"}
         */
        public static final String CLOSE = HttpHeaders.Values.CLOSE;
        /**
         * {@code "compress"}
         */
        public static final String COMPRESS = HttpHeaders.Values.COMPRESS;
        /**
         * {@code "100-continue"}
         */
        public static final String CONTINUE =  HttpHeaders.Values.CONTINUE;
        /**
         * {@code "deflate"}
         */
        public static final String DEFLATE = HttpHeaders.Values.DEFLATE;
        /**
         * {@code "destination"}
         */
        public static final String DESTINATION = "destination";
        /**
         * {@code "gzip"}
         */
        public static final String GZIP = HttpHeaders.Values.GZIP;
        /**
         * {@code "identity"}
         */
        public static final String IDENTITY = HttpHeaders.Values.IDENTITY;
        /**
         * {@code "interleaved"}
         */
        public static final String INTERLEAVED = "interleaved";
        /**
         * {@code "keep-alive"}
         */
        public static final String KEEP_ALIVE = HttpHeaders.Values.KEEP_ALIVE;
        /**
         * {@code "layers"}
         */
        public static final String LAYERS = "layers";
        /**
         * {@code "max-age"}
         */
        public static final String MAX_AGE = HttpHeaders.Values.MAX_AGE;
        /**
         * {@code "max-stale"}
         */
        public static final String MAX_STALE = HttpHeaders.Values.MAX_STALE;
        /**
         * {@code "min-fresh"}
         */
        public static final String MIN_FRESH = HttpHeaders.Values.MIN_FRESH;
        /**
         * {@code "mode"}
         */
        public static final String MODE = "mode";
        /**
         * {@code "multicast"}
         */
        public static final String MULTICAST = "multicast";
        /**
         * {@code "must-revalidate"}
         */
        public static final String MUST_REVALIDATE = HttpHeaders.Values.MUST_REVALIDATE;
        /**
         * {@code "none"}
         */
        public static final String NONE = HttpHeaders.Values.NONE;
        /**
         * {@code "no-cache"}
         */
        public static final String NO_CACHE = HttpHeaders.Values.NO_CACHE;
        /**
         * {@code "no-transform"}
         */
        public static final String NO_TRANSFORM = HttpHeaders.Values.NO_TRANSFORM;
        /**
         * {@code "only-if-cached"}
         */
        public static final String ONLY_IF_CACHED = HttpHeaders.Values.ONLY_IF_CACHED;
        /**
         * {@code "port"}
         */
        public static final String PORT = "port";
        /**
         * {@code "private"}
         */
        public static final String PRIVATE = HttpHeaders.Values.PRIVATE;
        /**
         * {@code "proxy-revalidate"}
         */
        public static final String PROXY_REVALIDATE = HttpHeaders.Values.PROXY_REVALIDATE;
        /**
         * {@code "public"}
         */
        public static final String PUBLIC = HttpHeaders.Values.PUBLIC;
        /**
         * {@code "RTP"}
         */
        public static final String RTP = "RTP";
        /**
         * {@code "rtptime"}
         */
        public static final String RTPTIME = "rtptime";
        /**
         * {@code "seq"}
         */
        public static final String SEQ = "seq";
        /**
         * {@code "server_port"}
         */
        public static final String SERVER_PORT = "server_port";
        /**
         * {@code "ssrc"}
         */
        public static final String SSRC = "ssrc";
        /**
         * {@code "TCP"}
         */
        public static final String TCP = "TCP";
        /**
         * {@code "time"}
         */
        public static final String TIME = "time";
        /**
         * {@code "timeout"}
         */
        public static final String TIMEOUT = "timeout";
        /**
         * {@code "ttl"}
         */
        public static final String TTL = "ttl";
        /**
         * {@code "UDP"}
         */
        public static final String UDP = "UDP";
        /**
         * {@code "unicast"}
         */
        public static final String UNICAST = "unicast";
        /**
         * {@code "url"}
         */
        public static final String URL = "url";

        private Values() { }
    }

    private RtspHeaders() { }
}
