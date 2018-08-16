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

import node.vm.VM
import kotlin.js.json
import kotlin.test.Test
import kotlin.test.assertEquals

class VMTests {
    @Test fun testRunVM() {
        val output = VM.runInThisContext<Int>("4 + 1;")
        assertEquals(4 + 1, output)
    }

    @Test fun testRunInVMWithContext() {
        val sandbox = json("a" to "Hello", "b" to "World")
        VM.createContext(sandbox) // contextify the sandbox
        val output = VM.runInContext<String>("`\${a}, \${b}!`;", sandbox)
        assertEquals("Hello, World!", output)
    }

    @Test fun testRunVMScript() {
        val script = VM.Script<Int>("""
            function run() {
                a = a + 1;
                return a;
            }

            run()
        """.trimIndent())

        val sandbox = json("a" to 0)
        VM.createContext(sandbox)

        for(i in 1..3) {
            script.runInContext(sandbox)
            assertEquals(i, sandbox["a"])
        }
    }
}