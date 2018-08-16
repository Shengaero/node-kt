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
package node.fs

import node.buffer.Buffer
import node.events.EventEmitter
import kotlin.js.Date

@JsModule("fs") external val fs: FS

typealias FSCallback = (err: Exception?) -> Unit
typealias FSOpenCallback = (err: Exception?, fd: Int) -> Unit
typealias FSStatCallback = (err: Exception?, stats: FSStats) -> Unit
typealias FSWatcherCallback = (event: String, filename: String) -> Unit
typealias FSReadFileCallback<D> = (err: Exception?, data: D) -> Unit
typealias FSExistsCallback = (exists: Boolean) -> Unit

external interface FS {
    val constants: FSConstants

    fun accessSync(path: dynamic, mode: Int = definedExternally)
    fun access(path: dynamic, mode: Int = definedExternally,
               callback: FSCallback)

    fun renameSync(oldPath: dynamic, newPath: dynamic)
    fun rename(oldPath: dynamic, newPath: dynamic,
               callback: FSCallback)

    // renamed to readFileStringSync and readFileBuffer to deter call ambiguity
    @JsName("readFileSync") fun readFileStringSync(path: dynamic, options: FSReadFileOptions): String
    @JsName("readFileSync") fun readFileStringSync(path: dynamic, options: String): String
    @JsName("readFileSync") fun readFileBufferSync(path: dynamic, options: FSFlagOptions = definedExternally): Buffer

    // renamed to readFileString and readFileBuffer to deter call ambiguity
    @JsName("readFile") fun readFileString(path: dynamic, options: FSReadFileOptions,
                                           callback: FSReadFileCallback<String>)
    @JsName("readFile") fun readFileString(path: dynamic, options: String,
                                           callback: FSReadFileCallback<String>)
    @JsName("readFile") fun readFileBuffer(path: dynamic, options: FSFlagOptions = definedExternally,
                                           callback: FSReadFileCallback<Buffer>)

    fun writeFileSync(path: dynamic, data: Any, options: FSWriteFileOptions = definedExternally)
    fun writeFile(path: dynamic, data: Any, options: FSWriteFileOptions = definedExternally,
                  callback: FSCallback)

    fun appendFileSync(path: dynamic, data: Any, options: FSWriteFileOptions = definedExternally)
    fun appendFile(path: dynamic, data: Any, options: FSWriteFileOptions = definedExternally,
                   callback: FSCallback)

    fun truncateSync(path: dynamic, len: Int? = definedExternally)
    fun truncate(path: dynamic, len: Int? = definedExternally,
                 callback: FSCallback)

    // these are technically ftruncate, but we use truncate for simplicity's sake.
    @JsName("ftruncateSync") fun truncateSync(fd: Int, len: Int? = definedExternally)
    @JsName("ftruncate") fun truncate(fd: Int, len: Int? = definedExternally,
                                      callback: FSCallback)

    fun copyFileSync(src: dynamic, dest: dynamic, flags: Int = definedExternally)
    fun copyFile(src: dynamic, dest: dynamic, flags: Int = definedExternally,
                 callback: FSCallback)

    fun openSync(path: dynamic, flags: dynamic, mode: dynamic = definedExternally): Int
    fun open(path: dynamic, flags: dynamic, mode: dynamic = definedExternally,
             callback: FSOpenCallback)

    fun statSync(path: dynamic): FSStats
    fun stat(path: dynamic,
             callback: FSStatCallback)

    fun closeSync(fd: Int)
    fun close(fd: Int,
              callback: FSCallback)

    fun existsSync(path: dynamic): Boolean
    fun exists(path: dynamic,
               callback: FSExistsCallback)

    fun watch(path: dynamic, options: FSWatchOptions,
              listener: FSWatcherCallback = definedExternally): FSWatcher
}

external interface FSReadFileOptions: FSFlagOptions {
    val encoding: String
}

external interface FSWriteFileOptions: FSFlagOptions {
    val encoding: String
    val mode: dynamic get() = definedExternally
}

external interface FSWatchOptions {
    val encoding: String? get() = definedExternally
    val persistent: Boolean? get() = definedExternally
    val recursive: Boolean? get() = definedExternally
}

external interface FSFlagOptions {
    val flag: String? get() = definedExternally
}

external interface FSWatcher: EventEmitter {
    fun close()
}

@Suppress("PropertyName")
external interface FSConstants {
    // File Access Constants

    val F_OK: Int
    val R_OK: Int
    val W_OK: Int
    val X_OK: Int

    // File Copy Constants

    val COPYFILE_EXCL: Int
    val COPYFILE_FICLONE: Int
    val COPYFILE_FICLONE_FORCE: Int

    // File Open Constants

    val O_RDONLY: Int
    val O_WRONLY: Int
    val O_RDWR: Int
    val O_CREAT: Int
    val O_EXCL: Int
    val O_NOCTTY: Int
    val O_TRUNC: Int
    val O_APPEND: Int
    val O_DIRECTORY: Int
    val O_NOATIME: Int
    val O_NOFOLLOW: Int
    val O_SYNC: Int
    val O_DSYNC: Int
    val O_SYMLINK: Int
    val O_DIRECT: Int
    val O_NONBLOCK: Int

    // File Type Constants

    val S_IFMT: Int
    val S_IFREG: Int
    val S_IFDIR: Int
    val S_IFCHR: Int
    val S_IFBLK: Int
    val S_IFIFO: Int
    val S_IFLNK: Int
    val S_IFSOCK: Int

    // File Mode Constants

    val S_IRWXU: Int
    val S_IRUSR: Int
    val S_IWUSR: Int
    val S_IXUSR: Int
    val S_IRWXG: Int
    val S_IRGRP: Int
    val S_IWGRP: Int
    val S_IXGRP: Int
    val S_IRWXO: Int
    val S_IROTH: Int
    val S_IWOTH: Int
    val S_IXOTH: Int
}

@JsName("Stats")
external class FSStats internal constructor() {
    val dev: Int
    val ino: Int
    val mode: Int
    val nlink: Int
    val uid: Int
    val gid: Int
    val rdev: Int
    val size: Int
    val blksize: Int
    val blocks: Int
    val atimeMs: Int
    val mtimeMs: Int
    val ctimeMs: Int
    val birthtimeMs: Int
    val atime: Date
    val mtime: Date
    val ctime: Date
    val birthtime: Date

    fun isFile(): Boolean
    fun isDirectory(): Boolean
    fun isBlockDevice(): Boolean
    fun isCharacterDevice(): Boolean
    fun isSymbolicLink(): Boolean
    fun isFIFO(): Boolean
    fun isSocket(): Boolean
}
