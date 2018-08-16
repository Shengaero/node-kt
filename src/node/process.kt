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
@file:Suppress("Unused", "NOTHING_TO_INLINE", "UnsafeCastFromDynamic")
package node

import node.domain.Domain
import node.events.EventEmitter

external val process: Process

external interface Process: EventEmitter {
    val argv: Array<String>
    val argv0: String
    val execArgv: String
    val execPath: String
    val debugPort: Int
    val env: ProcessEnv
    val exitCode: Int
    val version: String
    val versions: ProcessVersions
    val pid: Int
    val ppid: Int
    val title: String
    val arch: String
    val platform: String
    val mainModule: NodeModule?
    val domain: Domain

    fun abort()
    fun chdir(directory: String)
    fun cwd(): String
    fun exit(code: Int = definedExternally): Nothing
    fun getgid(): Int
    fun setgid(id: Int)
    fun setgid(id: String)
    fun getuid(): Int
    fun setuid(id: Int)
    fun setuid(id: String)
    fun geteuid(): Int
    fun seteuid(id: Int)
    fun seteuid(id: String)
    fun getegid(): Int
    fun setegid(id: Int)
    fun setegid(id: String)
    fun getgroups(): IntArray
    fun setgroups(groups: Array<dynamic>)

    fun emitWarning(warning: String, name: String = definedExternally, ctor: Function<*>)
    fun emitWarning(warning: Error, name: String = definedExternally, ctor: Function<*>)

    fun setUncaughtExceptionCaptureCallback(cb: ((err: Error) -> Unit)?)
    fun hasUncaughtExceptionCaptureCallback(): Boolean

    fun memoryUsage(): MemoryUsage
    fun cpuUsage(previousValue: CpuUsage = definedExternally): CpuUsage
    fun nextTick(callback: Function<*>)
    fun nextTick(callback: Function<*>, vararg args: Any)
    fun umask(mask: Int = definedExternally): Int
    fun uptime(): Int
    fun hrtime(time: Array<Int> = definedExternally): Array<Int>

    fun kill(pid: Int)
    fun kill(pid: Int, signal: String)
    fun kill(pid: Int, signal: Int)
}

external interface ProcessConfig {
    @JsName("target_defaults")
    val targetDefaults: ProcessConfig.TargetDefaults
    val variables: ProcessConfig.Variables

    interface TargetDefaults {
        @JsName("cflags")
        val cFlags: Array<Any>
        @JsName("default_configuration")
        val defaultConfiguration: String
        val defines: Array<String>
        @JsName("include_dirs")
        val includeDirs: Array<String>
        val libraries: Array<String>
    }

    interface Variables {
        val clang: Int
        @JsName("host_arch")
        val hostArch: String
        @JsName("node_install_npm")
        val nodeInstallNpm: Boolean
        @JsName("node_install_waf")
        val nodeInstallWaf: Boolean
        @JsName("node_prefix")
        val nodePrefix: String
        @JsName("node_shared_openssl")
        val nodeSharedOpenSSL: Boolean
        @JsName("node_shared_v8")
        val nodeSharedV8: Boolean
        @JsName("node_shared_zlib")
        val nodeSharedZlib: Boolean
        @JsName("node_use_dtrace")
        val nodeUseDTrace: Boolean
        @JsName("node_use_etw")
        val nodeUseEtw: Boolean
        @JsName("node_use_openssl")
        val nodeUseOpenSSL: Boolean
        @JsName("target_arch")
        val targetArch: String
        @JsName("v8_no_strict_aliasing")
        val v8NoStrictAliasing: Int
        @JsName("v8_use_snapshot")
        val v8UseSnapshot: Boolean
        val visibility: String
    }
}

external interface ProcessVersions {
    @JsName("http_parser") val httpParser: String
    val node: String
    val v8: String
    val ares: String
    val uv: String
    val zlib: String
    val modules: String
    val openssl: String
}

external interface ProcessEnv
inline operator fun ProcessEnv.get(key: String): String = asDynamic()[key]
inline operator fun ProcessEnv.set(key: String, value: String) { asDynamic()[key] = value }

// memory

external interface MemoryUsage {
    val rss: Int
    val heapTotal: Int
    val heapUsed: Int
    val external: Int
}

external interface CpuUsage {
    val user: Int
    val system: Int
}
