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

external interface WritableStream: EventEmitter {
    var writable: Boolean
    fun write(buffer: Buffer, cb: Function<Unit> = definedExternally): Boolean
    fun write(str: String, encoding: String = definedExternally, cb: Function<Unit> = definedExternally): Boolean
    fun end(cb: Function<Unit> = definedExternally)
    fun end(buffer: Buffer, cb: Function<Unit> = definedExternally)
    fun end(str: String, encoding: String = definedExternally, cb: Function<Unit> = definedExternally)
}