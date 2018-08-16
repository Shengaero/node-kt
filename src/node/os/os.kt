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
package node.os

@JsModule("os")
external object OS {
    val EOL: String

    // platform and os info
    fun platform(): String
    fun type(): String
    fun release(): String
    fun arch(): String
    fun endianness(): String

    // specs
    fun loadavg(): Array<String>
    fun cpus(): Array<CpuInfo>

    // stats
    fun uptime(): Int

    // mem
    fun freemem(): Int
    fun totalmem(): Int

    // dirs
    fun homedir(): String
    fun tmpdir(): String

    // user info
    fun userInfo(options: OSUserInfoOptions = definedExternally): OSUserInfo

    // network stuff
    fun hostname(): String
    fun networkInterfaces(): NetworkInterfaceMap
}

external interface OSUserInfoOptions {
    val encoding: String
}

external interface OSUserInfo {
    val username: String
    val uid: Int
    val gid: Int
    val shell: Any
    val homedir: String
}

external interface NetworkInterfaceInfo {
    val address: String
    val netmask: String
    val mac: String
    val internal: Boolean
    val family: String
}

external interface NetworkInterfaceInfoIPv4: NetworkInterfaceInfo

external interface NetworkInterfaceInfoIPv6: NetworkInterfaceInfo {
    val scopeid: Int
}

external interface NetworkInterfaceMap

inline operator fun NetworkInterfaceMap.get(index: String): Array<NetworkInterfaceInfo> {
    return asDynamic()[index].unsafeCast<Array<NetworkInterfaceInfo>>()
}

inline operator fun NetworkInterfaceInfo.set(index: String, info: NetworkInterfaceInfo) {
    asDynamic()[index] = info
}

external interface CpuInfo {
    val model: String
    val speed: Int
    val times: CpuInfo.Times

    interface Times {
        val user: Int
        val nice: Int
        val sys: Int
        val idle: Int
        val irq: Int
    }
}
