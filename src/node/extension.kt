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

import kotlin.js.Json

/**
 * Creates a new instance of [T] with the specified property [values].
 *
 * @param values The property names and their values.
 *
 * @return A newly created instance of [T].
 */
fun <T> new(vararg values: Pair<String, Any?>): T {
    val new: dynamic = js("({})")
    for((key, value) in values) {
        new[key] = value
    }
    return new.unsafeCast<T>()
}

/**
 * Creates a new instance of [T] with the specified [object][obj].
 *
 * @param obj The [Json] object.
 *
 * @return A newly created instance of [T].
 */
inline fun <T> new(obj: Json): T = obj.unsafeCast<T>()