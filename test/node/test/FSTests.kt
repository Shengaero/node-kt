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
package node.test

import node.fs.fs
import node.invoke
import node.path.path
import node.require
import kotlin.test.*

/**
 * @author Kaidan Gustave
 */
class FSTests {
    data class Data(val foo: String, val baz: Int)

    @Test fun testReadTextFile() {
        val path = require.resolve("test.json")
        val content = fs.readFileStringSync(path, "utf8")
        val data = JSON.parse<Data>(content)
        assertEquals("bar", data.foo)
        assertEquals(123, data.baz)
    }

    @Test fun testCopyFile() {
        val src = require.resolve("test.txt")
        val dest = path.join(path.dirname(src), "test-copy.txt")

        // copy the file
        fs.copyFileSync(src, dest)

        val srcContent = fs.readFileStringSync(src, "utf8")
        val destContent = fs.readFileStringSync(dest, "utf8")
        assertEquals(srcContent, destContent)
    }
}