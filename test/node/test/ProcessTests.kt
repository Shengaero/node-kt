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

import node.get
import node.os.OS
import node.__dirname
import node.process
import node.set
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ProcessTests {
    @Test fun testProcessGetAndSetMaxListeners() {
        process.maxListeners = 5
        assertEquals(5, process.maxListeners)
    }

    @Test fun testProcessCwd() {
        assertTrue(__dirname.startsWith(process.cwd()))
    }

    @Test fun testProcessEnv() {
        val testVariable = "testing123"
        process.env["TEST_VARIABLE"] = testVariable
        assertEquals(testVariable, process.env["TEST_VARIABLE"])
    }

    @Test fun testProcessEvents() {
        var added = false
        var removed = false

        process.on("newListener") { added = true }
        process.on("removeListener") { removed = true }

        val listener = fun(code: Int) = console.log("Exiting with code: $code")

        process.addListener("beforeExit", listener)
        process.removeListener("beforeExit", listener)

        assertTrue(added)
        assertTrue(removed)
    }

    @Test fun testProcessPlatform() {
        assertEquals(expected = OS.platform(), actual = process.platform)
    }
}