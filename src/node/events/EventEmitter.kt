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
package node.events

external interface EventEmitter {
    var maxListeners: Int

    fun addListener(event: String, listener: Function<Unit>)
    fun on(event: String, listener: Function<Unit>)
    fun once(event: String, listener: Function<Unit>)
    fun removeListener(event: String, listener: Function<Unit>)
    fun off(event: String, listener: Function<Unit>)
    fun removeAllListeners(event: String = definedExternally)
    fun listeners(event: String): Array<Function<Unit>>
    fun rawListeners(event: String): Array<Function<Unit>>
    fun emit(event: String, vararg args: Any?): Boolean

    fun prependListener(event: String, listener: Function<Unit>)
    fun prependOnceListener(event: String, listener: Function<Unit>)
    fun eventNames(): Array<String>
}