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
@file:Suppress("NOTHING_TO_INLINE", "unused")
package node

import kotlin.js.json

external val require: NodeRequire

external interface NodeRequireFunction

inline operator fun NodeRequireFunction.invoke(id: String): dynamic
    = asDynamic()(id)
inline operator fun <T: Any> NodeRequireFunction.invoke(id: String): T
    = asDynamic()(id).unsafeCast<T>()

external interface NodeRequire: NodeRequireFunction {
    val resolve: RequireResolve
    val cache: Any
    val extensions: NodeExtensions
    val main: NodeModule?
}

external interface RequireResolve {
    fun paths(request: String): Array<String>?
}

inline operator fun RequireResolve.invoke(id: String): String
    = asDynamic()(id).unsafeCast<String>()
inline operator fun RequireResolve.invoke(id: String, vararg paths: String): String
    = asDynamic()(id, json("paths" to paths)).unsafeCast<String>()

typealias NodeExtensionFunction = (m: NodeModule, filename: String) -> Any

external interface NodeExtensions {
    val js: NodeExtensionFunction
    val json: NodeExtensionFunction
    val node: NodeExtensionFunction
}

inline operator fun NodeExtensions.get(ext: String): NodeExtensionFunction {
    return asDynamic()[ext].unsafeCast<NodeExtensionFunction>()
}

inline operator fun NodeExtensions.set(ext: String, noinline function: NodeExtensionFunction) {
    asDynamic()[ext] = function
}

