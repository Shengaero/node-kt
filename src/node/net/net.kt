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
@file:Suppress("Unused")
package node.net

@JsModule("net")
external val net: Net

external interface Net {
    fun createServer(connectionListener: (socket: ServerSocket) -> Unit = definedExternally): Server
    fun createServer(options: Server.Options = definedExternally,
                     connectionListener: (socket: ServerSocket) -> Unit = definedExternally): Server

    fun connect(port: Int, host: String = definedExternally,
                connectionListener: Function<Unit> = definedExternally): ServerSocket
    fun connect(options: NetConnectOptions,
                connectionListener: Function<Unit> = definedExternally): ServerSocket

    fun createConnection(port: Int, host: String = definedExternally,
                         connectionListener: Function<Unit> = definedExternally): ServerSocket
    fun createConnection(options: NetConnectOptions,
                         connectionListener: Function<Unit> = definedExternally): ServerSocket

    fun isIP(input: String): Int
    fun isIPv4(input: String): Boolean
    fun isIPv6(input: String): Boolean
}

external interface NetConnectOptions: ServerSocket.Options {
    val timeout: Int? get() = definedExternally
}

external interface TcpNetConnectOptions:
    TcpSocketConnectOptions,
    NetConnectOptions

external interface IpcNetConnectOpts:
    TcpSocketConnectOptions,
    NetConnectOptions