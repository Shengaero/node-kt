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

import es5.pop
import es5.push
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.asserter

class ArrayTests {
    @Test fun testArrayPush() {
        val array = arrayOf<Int>()
        for(i in 1..4) {
            assertEquals(i, array.push(i))
            assertEquals(i, array.size)
        }
    }

    @Test fun testMultiArgumentPush() {
        val array = arrayOf<String>()
        for(i in 0 until array.push("a", "b", "c")) assertEquals(when(i) {
            0 -> "a"
            1 -> "b"
            2 -> "c"
            else -> asserter.fail("Exceeded expected max index: $i")
        }, actual = array[i])
    }

    @Test fun testNOPPush() {
        val array = arrayOf('a', 'b', 'c')
        val before = array.size
        val after = array.push()
        assertEquals(expected = before, actual = after)
    }

    @Test fun testArrayPop() {
        val array = arrayOf(1, 2, 3, 4)
        val start = array.size
        for(i in 0 until start) {
            assertEquals(start - i, array.pop())
            assertEquals(start - (i + 1), array.size)
        }
    }

    @Test fun testEmptyArrayPop() {
        val array = emptyArray<String>()
        assertNull(array.pop())
    }
}
