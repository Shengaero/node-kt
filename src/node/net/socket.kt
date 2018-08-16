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
@file:JsModule("net")
@file:Suppress("unused")
package node.net

import node.buffer.Buffer
import node.stream.Duplex

@JsName("Socket")
external interface ServerSocket: Duplex {
    var bufferSize: Int
    val remoteAddress: String
    val remoteFamily: String
    val remotePort: Int
    val localAddress: String
    val localPort: Int
    val bytesRead: Int
    val bytesWritten: Int
    val connecting: Boolean
    val destroyed: Boolean

    fun write(buffer: Buffer): Boolean
    fun write(str: String, cb: Function<Unit> = definedExternally): Boolean
    fun write(str: String, encoding: String = definedExternally, fd: String = definedExternally): Boolean

    fun connect(options: TcpSocketConnectOptions,
                connectionListener: Function<Unit> = definedExternally): ServerSocket
    fun connect(options: IcpSocketConnectOptions,
                connectionListener: Function<Unit> = definedExternally): ServerSocket
    fun connect(port: Int, host: String,
                connectionListener: Function<Unit> = definedExternally): ServerSocket
    fun connect(port: Int,
                connectionListener: Function<Unit> = definedExternally): ServerSocket
    fun connect(path: String,
                connectionListener: Function<Unit> = definedExternally): ServerSocket

    fun setTimeout(timeout: Int, callback: Function<Unit> = definedExternally): ServerSocket
    fun setNoDelay(noDelay: Boolean = definedExternally): ServerSocket
    fun setKeepAlive(enable: Boolean = definedExternally,
                     initialDelay: Int = definedExternally): ServerSocket

    fun ref()
    fun unref()

    interface Options {
        val fd: Int? get() = definedExternally
        val allowHalfOpen: Boolean? get() = definedExternally
        val readable: Boolean? get() = definedExternally
        val writable: Boolean? get() = definedExternally
    }
}

external interface TcpSocketConnectOptions {
    val port: Int
    val host: String? get() = definedExternally
    val localAddress: String? get() = definedExternally
    val localPort: Int? get() = definedExternally
    val hints: Int? get() = definedExternally
    val family: Int? get() = definedExternally
    val lookup: LookupFunction? get() = definedExternally
}

external interface IcpSocketConnectOptions {
    val path: String
}