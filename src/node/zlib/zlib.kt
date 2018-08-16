/*
 * Copyright 2018 Kaidan Gustave
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("unused", "PropertyName")
package node.zlib

import node.buffer.Buffer

@JsModule("zlib")
external val zlib: ZlibAPI

external interface ZlibAPI {
    val constants: Constants

    fun createGzip(options: Zlib.Options = definedExternally): Gzip
    fun createGunzip(options: Zlib.Options = definedExternally): Gunzip
    fun createDeflate(options: Zlib.Options = definedExternally): Deflate
    fun createInflate(options: Zlib.Options = definedExternally): Inflate
    fun createDeflateRaw(options: Zlib.Options = definedExternally): DeflateRaw
    fun createInflateRaw(options: Zlib.Options = definedExternally): InflateRaw
    fun createUnzip(options: Zlib.Options = definedExternally): Unzip

    fun deflate(buf: dynamic, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun deflate(buf: dynamic, options: Zlib.Options, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun deflateSync(buf: dynamic, options: Zlib.Options = definedExternally): Buffer
    fun deflateRaw(buf: dynamic, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun deflateRaw(buf: dynamic, options: Zlib.Options, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun deflateRawSync(buf: dynamic, options: Zlib.Options = definedExternally): Buffer
    fun gzip(buf: dynamic, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun gzip(buf: dynamic, options: Zlib.Options, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun gzipSync(buf: dynamic, options: Zlib.Options = definedExternally): Buffer
    fun gunzip(buf: dynamic, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun gunzip(buf: dynamic, options: Zlib.Options, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun gunzipSync(buf: dynamic, options: Zlib.Options = definedExternally): Buffer
    fun inflate(buf: dynamic, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun inflate(buf: dynamic, options: Zlib.Options, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun inflateSync(buf: dynamic, options: Zlib.Options = definedExternally): Buffer
    fun inflateRaw(buf: dynamic, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun inflateRaw(buf: dynamic, options: Zlib.Options, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun inflateRawSync(buf: dynamic, options: Zlib.Options = definedExternally): Buffer
    fun unzip(buf: dynamic, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun unzip(buf: dynamic, options: Zlib.Options, callback: (error: Throwable?, result: Buffer) -> Unit)
    fun unzipSync(buf: dynamic, options: Zlib.Options = definedExternally): Buffer

    interface Constants {
        // flush values

        val Z_NO_FLUSH: Int
        val Z_PARTIAL_FLUSH: Int
        val Z_SYNC_FLUSH: Int
        val Z_FULL_FLUSH: Int
        val Z_FINISH: Int
        val Z_BLOCK: Int
        val Z_TREES: Int

        // returning codes for the compression/decompression functions

        val Z_OK: Int
        val Z_STREAM_END: Int
        val Z_NEED_DICT: Int
        val Z_ERRNO: Int
        val Z_STREAM_ERROR: Int
        val Z_DATA_ERROR: Int
        val Z_MEM_ERROR: Int
        val Z_BUF_ERROR: Int
        val Z_VERSION_ERROR: Int

        // compression levels

        val Z_NO_COMPRESSION: Int
        val Z_BEST_SPEED: Int
        val Z_BEST_COMPRESSION: Int
        val Z_DEFAULT_COMPRESSION: Int

        // compression strategy

        val Z_FILTERED: Int
        val Z_HUFFMAN_ONLY: Int
        val Z_RLE: Int
        val Z_FIXED: Int
        val Z_DEFAULT_STRATEGY: Int
    }
}