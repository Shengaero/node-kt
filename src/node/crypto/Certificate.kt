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
@file:Suppress("unused", "FunctionName")
@file:JsModule("crypto")
package node.crypto

import node.buffer.Buffer
import org.khronos.webgl.DataView

open external class Certificate {
    fun exportChallenge(spkac: String): Buffer
    fun exportChallenge(spkac: Buffer): Buffer
    fun exportChallenge(spkac: dynamic): Buffer
    fun exportChallenge(spkac: DataView): Buffer

    fun exportPublicKey(spkac: String): Buffer
    fun exportPublicKey(spkac: Buffer): Buffer
    fun exportPublicKey(spkac: dynamic): Buffer
    fun exportPublicKey(spkac: DataView): Buffer

    fun verifySpkac(spkac: Buffer)
    fun verifySpkac(spkac: dynamic)
    fun verifySpkac(spkac: DataView)

    companion object: Certificate {
        fun exportPublicKey(spkac: String, encoding: String): Buffer
        fun exportPublicKey(spkac: Buffer, encoding: String): Buffer
        fun exportPublicKey(spkac: dynamic, encoding: String): Buffer
        fun exportPublicKey(spkac: DataView, encoding: String): Buffer
    }
}
