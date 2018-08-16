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
@file:Suppress("unused", "NOTHING_TO_INLINE", "UnsafeCastFromDynamic")
package node.path

import kotlin.js.Json

@JsModule("path")
external val path: Path

external interface Path {
    val sep: String
    val delimiter: String
    val posix: Path
    val win32: Path
    fun normalize(p: String): String
    fun join(vararg paths: String): String
    fun resolve(vararg paths: String): String
    fun isAbsolute(path: String): Boolean
    fun relative(from: String, to: String): String
    fun dirname(path: String): String
    fun basename(path: String, ext: String = definedExternally): String
    fun extname(p: String): String
    fun parse(pathString: String): ParsedPathOutput
    fun format(pathObject: Json): String
    fun format(pathObject: FormatPathInput): String
}

external interface FormatPathInput {
    val root: String? get() = definedExternally
    val dir: String? get() = definedExternally
    val base: String? get() = definedExternally
    val ext: String? get() = definedExternally
    val name: String? get() = definedExternally
}

external interface ParsedPathOutput {
    val root: String
    val dir: String
    val base: String
    val ext: String
    val name: String
}

inline fun Path.format(
    name: String? = null, root: String? = null, dir: String? = null,
    base: String? = null, ext: String? = null
): String = format(formatPathOf(name, root, dir, base, ext))

inline fun formatPathOf(
    name: String? = null, root: String? = null, dir: String? = null,
    base: String? = null, ext: String? = null
): FormatPathInput {
    val obj = js("({})")
    name?.let { obj["name"] = name }
    root?.let { obj["root"] = root }
    dir?.let { obj["dir"] = dir }
    base?.let { obj["base"] = base }
    ext?.let { obj["ext"] = ext }
    return obj
}
