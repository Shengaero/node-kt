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
package node.buffer

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array

open external class Buffer internal constructor(): Uint8Array {
    fun write(string: String,
              offset: Int = definedExternally,
              length: Int = definedExternally,
              encoding: String = definedExternally): Int
    fun toString(encoding: String = definedExternally,
                 start: Int = definedExternally,
                 end: Int = definedExternally): String
    fun toJSON(): BufferJson
    fun equals(otherBuffer: Uint8Array): Boolean
    fun compare(otherBuffer: Uint8Array,
                targetStart: Int = definedExternally,
                targetEnd: Int = definedExternally,
                sourceStart: Int = definedExternally,
                sourceEnd: Int = definedExternally): Int
    fun copy(targetBuffer: Uint8Array,
             targetStart: Int = definedExternally,
             sourceStart: Int = definedExternally,
             sourceEnd: Int = definedExternally): Int
    fun slice(start: Int = definedExternally, end: Int = definedExternally): Buffer
    fun writeUIntLE(value: Int, offset: Int, byteLength: Int, noAssert: Boolean = definedExternally): Int
    fun writeUIntBE(value: Int, offset: Int, byteLength: Int, noAssert: Boolean = definedExternally): Int
    fun writeIntLE(value: Int, offset: Int, byteLength: Int, noAssert: Boolean = definedExternally): Int
    fun writeIntBE(value: Int, offset: Int, byteLength: Int, noAssert: Boolean = definedExternally): Int
    fun readUIntLE(offset: Int, byteLength: Int, noAssert: Boolean = definedExternally): Int
    fun readUIntBE(offset: Int, byteLength: Int, noAssert: Boolean = definedExternally): Int
    fun readIntLE(offset: Int, byteLength: Int, noAssert: Boolean = definedExternally): Int
    fun readIntBE(offset: Int, byteLength: Int, noAssert: Boolean = definedExternally): Int
    fun readUInt8(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readUInt16LE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readUInt16BE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readUInt32LE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readUInt32BE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readInt8(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readInt16LE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readInt16BE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readInt32LE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readInt32BE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readFloatLE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readFloatBE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readDoubleLE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun readDoubleBE(offset: Int, noAssert: Boolean = definedExternally): Int
    fun swap16(): Buffer
    fun swap32(): Buffer
    fun swap64(): Buffer
    fun writeUInt8(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeUInt16LE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeUInt16BE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeUInt32LE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeUInt32BE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeInt8(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeInt16LE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeInt16BE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeInt32LE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeInt32BE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeFloatLE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeFloatBE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeDoubleLE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun writeDoubleBE(value: Int, offset: Int, noAssert: Boolean = definedExternally): Int
    fun fill(value: Any, offset: Int = definedExternally, end: Int = definedExternally): Buffer
    fun indexOf(value: String, byteOffset: Int = definedExternally, encoding: String = definedExternally): Int
    fun indexOf(value: Int, byteOffset: Int = definedExternally, encoding: String = definedExternally): Int
    fun indexOf(value: Uint8Array, byteOffset: Int = definedExternally, encoding: String = definedExternally): Int
    fun lastIndexOf(value: String, byteOffset: Int = definedExternally, encoding: String = definedExternally): Int
    fun lastIndexOf(value: Int, byteOffset: Int = definedExternally, encoding: String = definedExternally): Int
    fun lastIndexOf(value: Uint8Array, byteOffset: Int = definedExternally, encoding: String = definedExternally): Int

    fun includes(value: String, byteOffset: Int = definedExternally, encoding: String = definedExternally): Boolean
    fun includes(value: Int, byteOffset: Int = definedExternally, encoding: String = definedExternally): Boolean
    fun includes(value: Buffer, byteOffset: Int = definedExternally, encoding: String = definedExternally): Boolean

    companion object {
        // note that the single parameter overload is to prevent call ambiguity
        //when using this function without defining the type of the "fill" parameter.
        fun alloc(size: Int): Buffer
        fun alloc(size: Int, fill: String, encoding: String = definedExternally): Buffer
        fun alloc(size: Int, fill: Buffer, encoding: String = definedExternally): Buffer
        fun alloc(size: Int, fill: Int, encoding: String = definedExternally): Buffer

        fun from(data: Uint8Array): Buffer
        fun from(str: String, encoding: String = definedExternally): Buffer
        fun from(arrayBuffer: ArrayBuffer, byteOffset: Int = definedExternally, length: Int = definedExternally): Buffer
    }

    interface BufferJson {
        val type: String
        val data: Array<*>
    }
}
