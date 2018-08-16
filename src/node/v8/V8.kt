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
package node.v8

@JsModule("v8")
external object V8 {
    interface HeapInfo {
        @JsName("total_heap_size") val totalHeapSize: Int
        @JsName("total_heap_size_executable") val totalHeapSizeExecutable: Int
        @JsName("total_physical_size") val totalPhysicalSize: Int
        @JsName("total_available_size") val totalAvailableSize: Int
        @JsName("used_heap_size") val usedHeapSize: Int
        @JsName("heap_size_limit") val heapSizeLimit: Int
        @JsName("malloced_memory") val mallocedMemory: Int
        @JsName("peak_malloced_memory") val peakMallocedMemory: Int
        @JsName("does_zap_garbage") val doesZapGarbage: Int
    }

    interface HeapSpaceInfo {
        @JsName("space_name") val spaceName: String
        @JsName("space_size") val spaceSize: Int
        @JsName("space_used_size") val spaceUsedSize: Int
        @JsName("space_available_size") val spaceAvailableSize: Int
        @JsName("physical_space_size") val physicalSpaceSize: Int
    }

    fun getHeapStatistics(): HeapInfo
    fun getHeapSpaceStatistics(): Array<HeapSpaceInfo>
    fun setFlagsFromString(flags: String)
}