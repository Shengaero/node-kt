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
package node.vm

import node.buffer.Buffer

@JsModule("vm")
external object VM {
    interface RunningScriptOptions {
        val filename: String? get() = definedExternally
        val lineOffset: Int? get() = definedExternally
        val columnOffset: Int? get() = definedExternally
        val displayErrors: Boolean? get() = definedExternally
        val timeout: Int? get() = definedExternally
    }

    interface ScriptOptions: RunningScriptOptions {
        val cachedData: Buffer? get() = definedExternally
        val produceCachedData: Boolean? get() = definedExternally
    }

    class Script<R> (code: String, options: ScriptOptions = definedExternally) {
        fun runInContext(contextifiedSandbox: dynamic, options: RunningScriptOptions = definedExternally): R
        fun runInNewContext(sandbox: dynamic, options: RunningScriptOptions = definedExternally): R
        fun runInThisContext(options: RunningScriptOptions = definedExternally): R
    }

    fun createContext(sandbox: dynamic = definedExternally): dynamic
    fun isContext(sandbox: dynamic): Boolean
    fun <R> runInContext(code: String, contextifiedSandbox: dynamic, options: RunningScriptOptions = definedExternally): R
    fun <R> runInNewContext(code: String, sandbox: dynamic = definedExternally, options: RunningScriptOptions = definedExternally): R
    fun <R> runInThisContext(code: String, options: RunningScriptOptions = definedExternally): R
}