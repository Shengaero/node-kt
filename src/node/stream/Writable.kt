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
@file:JsModule("stream")
package node.stream

import node.WritableStream

external interface Writable: Stream, WritableStream {
    val writableHighWaterMark: Int
    val writableLength: Int

    fun write(chunk: Any, encoding: String = definedExternally, cb: Function<Unit> = definedExternally): Boolean
    fun setDefaultEncoding(encoding: String): Writable
    fun end(chunk: Any, encoding: String = definedExternally, cb: Function<Unit> = definedExternally)
    fun cork()
    fun uncork()

    interface Options {
        val highWaterMark: Int? get() = definedExternally
        val decodeStrings: Boolean? get() = definedExternally
        val objectMode: Boolean? get() = definedExternally
        val write: ((chunk: Any, encoding: String, callback: Function<Unit>) -> Any)? get() = definedExternally
        val writev: ((chunks: Array<Chunk>, callback: Function<Unit>) -> Any)? get() = definedExternally
        val destroy: ((error: Throwable?, callback: (error: Throwable?) -> Unit) -> Unit)? get() = definedExternally
        val final: ((callback: (error: Error?) -> Unit) -> Unit)? get() = definedExternally
    }

    interface Chunk {
        val chunk: Any
        val encoding: String
    }
}
