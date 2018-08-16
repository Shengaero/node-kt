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

import node.ReadableStream
import node.WritableStream

external interface Readable: Stream, ReadableStream {
    val readableHighWaterMark: Int
    val readableLength: Int

    fun read(size: Int = definedExternally): Any
    override fun pause(): Readable
    override fun resume(): Readable
    override fun isPaused(): Boolean
    fun unshift(chunk: Any)
    fun push(chunk: Any, encoding: String = definedExternally): Boolean

    override fun <T: WritableStream> pipe(destination: T, options: Stream.PipeOptions): T

    interface Options {
        val highWaterMark: Int? get() = definedExternally
        val encoding: String? get() = definedExternally
        val objectMode: Boolean? get() = definedExternally
        val read: ((readable: Readable, size: Int?) -> Any)? get() = definedExternally
        val destroy: ((error: Throwable?, callback: (error: Throwable?) -> Unit) -> Unit)? get() = definedExternally
    }
}
