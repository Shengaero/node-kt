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
@file:Suppress("unused", "UnsafeCastFromDynamic", "NOTHING_TO_INLINE")
package es5

import kotlin.reflect.KClass

external object Object {
    fun <T: Any> create(o: JsClass<T>?, properties: PropertyDescriptorMap = definedExternally): T?

    fun getPrototypeOf(o: Any): dynamic
    fun getOwnPropertyDescriptor(o: Any, p: String): PropertyDescriptor?
    fun getOwnPropertyNames(o: Any): Array<String>
    fun defineProperty(o: Any, p: String, attributes: PropertyDescriptor): dynamic
    fun defineProperties(o: Any, attributes: PropertyDescriptorMap): dynamic
}

external interface PropertyDescriptor {
    val configurable: Boolean? get() = definedExternally
    val enumerable: Boolean? get() = definedExternally
    val value: Any? get() = definedExternally
    val writable: Boolean? get() = definedExternally
    val get: (() -> Any?)? get() = definedExternally
    val set: ((v: Any?) -> Unit)? get() = definedExternally
}

external interface PropertyDescriptorMap

inline operator fun PropertyDescriptorMap.get(s: String): PropertyDescriptor = asDynamic()[s]
inline operator fun PropertyDescriptorMap.set(s: String, value: PropertyDescriptor) { asDynamic()[s] = value }

inline fun <reified T: Any> Object.create(properties: PropertyDescriptorMap = js("({})")): T =
    create(T::class, properties)
inline fun <T: Any> Object.create(type: KClass<T>, properties: PropertyDescriptorMap = js("({})")): T =
    create(type.js, properties).unsafeCast<T>()
