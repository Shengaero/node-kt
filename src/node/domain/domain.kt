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
@file:JsModule("domain")
@file:Suppress("Unused")
package node.domain

import node.events.EventEmitter

@JsName("create")
external fun createDomain(): Domain

external interface Domain: EventEmitter {
    val members: Array<Any>

    fun enter()
    fun exit()

    fun run(fn: Function<dynamic>)
    fun add(emitter: EventEmitter)
    fun remove(emitter: EventEmitter)
    fun bind(cb: (err: Throwable, data: Any) -> Any): Any
    fun intercept(cb: (data: Any) -> Any): Any
}