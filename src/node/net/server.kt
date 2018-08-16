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
@file:JsModule("net")
package node.net

import node.events.EventEmitter

external interface Server: EventEmitter {
    var maxConnections: Int
    val connections: Int
    val listening: Boolean

    fun listen(port: Int = definedExternally,
               hostname: String = definedExternally,
               backlog: Int = definedExternally,
               listeningListener: Function<Unit> = definedExternally)

    fun listen(port: Int = definedExternally,
               hostname: String = definedExternally,
               listeningListener: Function<Unit> = definedExternally)

    fun listen(port: Int = definedExternally,
               backlog: Int = definedExternally,
               listeningListener: Function<Unit> = definedExternally)

    fun listen(port: Int = definedExternally,
               listeningListener: Function<Unit> = definedExternally)

    fun listen(path: String,
               backlog: Int = definedExternally,
               listeningListener: Function<Unit> = definedExternally)

    fun listen(path: String,
               listeningListener: Function<Unit> = definedExternally)

    fun listen(options: ListenOptions,
               listeningListener: Function<Unit> = definedExternally)

    fun listen(handle: Any,
               backlog: Int = definedExternally,
               listeningListener: Function<Unit> = definedExternally)

    fun listen(handle: Any,
               listeningListener: Function<Unit> = definedExternally)

    fun close(callback: Function<Unit> = definedExternally)

    fun getConnections(cb: (error: Throwable?, count: Int) -> Unit)

    fun ref(): Server
    fun unref(): Server

    override fun addListener(event: String, listener: Function<Unit>)
    override fun emit(event: String, vararg args: Any?): Boolean
    override fun eventNames(): Array<String>
    override fun listeners(event: String): Array<Function<Unit>>
    override fun off(event: String, listener: Function<Unit>)
    override fun on(event: String, listener: Function<Unit>)
    override fun once(event: String, listener: Function<Unit>)
    override fun prependListener(event: String, listener: Function<Unit>)
    override fun prependOnceListener(event: String, listener: Function<Unit>)
    override fun rawListeners(event: String): Array<Function<Unit>>
    override fun removeAllListeners(event: String)
    override fun removeListener(event: String, listener: Function<Unit>)

    interface Options {
        val allowHalfOpen: Boolean? get() = definedExternally
        val pauseOnConnect: Boolean? get() = definedExternally
    }
}

external interface ListenOptions {
    val port: Int? get() = definedExternally
    val host: String? get() = definedExternally
    val backlog: Int? get() = definedExternally
    val path: String? get() = definedExternally
    val exclusive: Boolean? get() = definedExternally
    val readableAll: Boolean? get() = definedExternally
    val writableAll: Boolean? get() = definedExternally
}