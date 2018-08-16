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
@file:Suppress("NOTHING_TO_INLINE")
package es5

/**
 * Appends new elements to an array, and returns the new length of the array.
 *
 * @receiver The Array to push to.
 * @param items New elements of the Array.
 *
 * @return The new length of the array.
 */
inline fun <T> Array<T>.push(vararg items: T): Int = asDynamic().push.apply(this, items).unsafeCast<Int>()

/**
 * Removes the last element from an array and returns it.
 *
 * @receiver The Array to pop from.
 *
 * @return The removed item, or `null` if the array was empty.
 */
inline fun <T> Array<T>.pop(): T? = asDynamic().pop().unsafeCast<T?>()
