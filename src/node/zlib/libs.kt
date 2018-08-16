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
@file:Suppress("unused")
@file:JsModule("zlib")
package node.zlib

import node.stream.Transform

external interface Gzip: Transform, Zlib
external interface Gunzip: Transform, Zlib
external interface Deflate: Transform, Zlib, Zlib.Reset, Zlib.Params
external interface Inflate: Transform, Zlib, Zlib.Reset
external interface DeflateRaw: Transform, Zlib, Zlib.Reset, Zlib.Params
external interface InflateRaw: Transform, Zlib, Zlib.Reset
external interface Unzip: Transform, Zlib

external interface Zlib {
    val bytesRead: Int
    fun close(callback: () -> Unit = definedExternally)
    fun flush()
    fun flush(kind: Int, callback: () -> Unit = definedExternally)
    fun flush(kind: () -> Unit, callback: () -> Unit = definedExternally)

    interface Options {
        val flush: Int? get() = definedExternally
        val finishFlush: Int? get() = definedExternally
        val chunkSize: Int? get() = definedExternally
        val windowBits: Int? get() = definedExternally
        val level: Int? get() = definedExternally
        val memLevel: Int? get() = definedExternally
        val strategy: Int? get() = definedExternally
        val dictionary: dynamic get() = definedExternally
    }

    interface Params {
        fun params(level: Int, strategy: Int, callback: () -> Unit)
    }

    interface Reset {
        fun reset()
    }
}

