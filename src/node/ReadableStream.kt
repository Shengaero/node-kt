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
package node

import node.buffer.Buffer
import node.events.EventEmitter

external interface ReadableStream: EventEmitter {
    var readable: Boolean

    // TODO lookup to see if size specification determines type output
    // if this is the case, then what we'll do is:
    //
    // fun read(): String
    // fun read(size: Int): Buffer
    @JsName("read") fun readString(size: Int = definedExternally): String
    @JsName("read") fun readBuffer(size: Int = definedExternally): Buffer

    fun setEncoding(encoding: String): ReadableStream
    fun pause(): ReadableStream
    fun resume(): ReadableStream
    fun isPaused(): Boolean
    fun <T: WritableStream> pipe(destination: T, options: Any = definedExternally): T
    fun <T: WritableStream> unpipe(destination: T = definedExternally): ReadableStream
    fun unshift(chunk: String)
    fun unshift(chunk: Buffer)
    fun wrap(oldStream: ReadableStream): ReadableStream
}