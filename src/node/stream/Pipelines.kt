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
package node.stream

import node.ReadWriteStream
import node.ReadableStream
import node.WritableStream

@JsModule("stream")
external object Pipelines {
    fun <T: WritableStream> pipeline(stream1: ReadableStream,
                                     stream2: T,
                                     callback: (err: Throwable) -> Unit = definedExternally): T

    fun <T: WritableStream> pipeline(stream1: ReadableStream,
                                     stream2: ReadWriteStream,
                                     stream3: T,
                                     callback: (err: Throwable) -> Unit = definedExternally): T

    fun <T: WritableStream> pipeline(stream1: ReadableStream,
                                     stream2: ReadWriteStream,
                                     stream3: ReadWriteStream,
                                     stream4: T,
                                     callback: (err: Throwable) -> Unit = definedExternally): T

    fun <T: WritableStream> pipeline(stream1: ReadableStream,
                                     stream2: ReadWriteStream,
                                     stream3: ReadWriteStream,
                                     stream4: ReadWriteStream,
                                     stream5: T,
                                     callback: (err: Throwable) -> Unit = definedExternally): T

    fun pipeline(streams: Array<*>, callback: (err: Throwable) -> Unit = definedExternally): WritableStream
}