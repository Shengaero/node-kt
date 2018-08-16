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

import node.path.format
import node.path.path
import kotlin.test.Test
import kotlin.test.assertEquals

class PathTests {
    @Test fun testPathJoin() {
        val manuallyJoined = "foo${path.sep}bar"
        val functionJoined = path.join("foo", "bar")
        assertEquals(expected = manuallyJoined, actual = functionJoined)
    }

    @Test fun testPathFormatting() {
        val path = path.format(name = "index", ext = ".html")
        assertEquals("index.html", path)
    }
}