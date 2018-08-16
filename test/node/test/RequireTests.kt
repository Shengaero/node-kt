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

import node.invoke
import node.require
import kotlin.test.Test
import kotlin.test.assertEquals

class RequireTests {
    @Test fun testRequireModule() {
        val a = 3
        val b = 5
        val c = 2
        val test = require<TestModule>("test")
        assertEquals("testing123", test.test)
        assertEquals(a + b + c, test.funABC(a, b, c))
    }

    @Test fun testRequireDynamicModule() {
        val a = "Peanut Butter"
        val b = "Jelly"
        val test = require("test")
        assertEquals("$a & $b", test.funAB(a, b))
    }

    interface TestModule {
        val test: String
        @JsName("funABC") fun funABC(a: Int, b: Int, c: Int): Int
    }
}