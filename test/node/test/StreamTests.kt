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
package node.test

import node.stream.Duplex
import node.stream.Readable
import node.stream.Writable
import kotlin.test.Test

// TODO Stream tests

class StreamTests {
    class ReadableStreamTests {
        @Test fun testCreateReadable() {
            val stream = Readable(object: Readable.Options {
                override val encoding = "utf8"
            })

            stream.destroy()
        }
    }

    class WritableStreamTests {
        @Test fun testCreateWritable() {
            val stream = Writable(object: Writable.Options {
                override val decodeStrings = false
            })

            stream.destroy()
        }
    }

    class DuplexStreamTests {
        @Test fun testCreateDuplex() {
            val stream = Duplex(object: Duplex.Options {
                override val encoding = "utf8"
                override val decodeStrings = false
            })
            
            stream.destroy()
        }
    }
}