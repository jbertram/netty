/*
 * Copyright 2013 The Netty Project
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
import io.netty.util.CharsetUtil;

public final class HeaderCharSequence implements CharSequence, Encodable {
    private final byte[] bytes;
    private final String value;

    public HeaderCharSequence(String value) {
        this.value = value;
        bytes = value.getBytes(CharsetUtil.US_ASCII);
    }

    public HeaderCharSequence(byte[] bytes) {
        this.bytes = bytes.clone();
        value = new String(bytes, CharsetUtil.US_ASCII);
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new HeaderCharSequence(value.substring(start, end));
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public void encode(ByteBuf buf) {
        buf.writeBytes(bytes);
    }
}

