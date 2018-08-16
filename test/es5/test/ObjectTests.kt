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
package es5.test

import es5.Object
import es5.PropertyDescriptorMap
import es5.create
import es5.get
import node.new
import kotlin.js.json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ObjectTests {
    data class TestClass(val foo: String, val bar: Int)

    @Test fun testCreate() {
        val props = new<PropertyDescriptorMap>(
            "foo" to json("value" to "Hello"),
            "bar" to json("value" to 123)
        )
        val test = Object.create<TestClass>(props)
        assertEquals(props["foo"].value, test.foo)
        assertEquals(props["bar"].value, test.bar)
    }

    @Test fun testListProperties() {
        val test = TestClass("Hello", 123)
        val names = Object.getOwnPropertyNames(test)
        assertEquals(2, names.size)
        assertEquals("foo", names[0])
        assertEquals("bar", names[1])
    }

    @Test fun testGetPropertyDescriptor() {
        val test = TestClass("Hello", 123)
        val descriptor = assertNotNull(Object.getOwnPropertyDescriptor(test, "foo"))
        assertEquals("Hello", descriptor.value)
    }
}
