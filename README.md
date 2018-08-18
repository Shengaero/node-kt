# node-kt

Kotlin2Js bindings for the node.js standard library.

This is currently an experimental library, it's recommended you approach individual APIs with caution
of possible changes. The status of each API can be found in the
[Supported APIs](https://github.com/Shengaero/node-kt/blob/master/README.md#currently-supported-apis)
section of this readme.

## Why?

The Kotlin2Js standard library has absolutely no support for some of the most
popular APIs in the node.js ecosystem.

The goal of this library is to provide clean, lightweight, and as much support
for the node.js standard library of APIs in Kotlin!

In addition, this library will also provide some missing support for ECMAScript 5,
such as the `Object` API.

## Installation

#### With NPM

`npm i node-kt`

If you are using Intellij IDEA and [`create-react-kotlin-app`](https://github.com/JetBrains/create-react-kotlin-app),
you can run the following to have your IDE resolve the library:

`npm run gen-idea-libs`

#### With Gradle

```gradle
repositories {
    jcenter()
}

dependencies {
    compile "me.kgustave:node-kt:nodektVersion"
}
```

## Currently Supported APIs

API                     |        Status         |       Progress
----------------------- | --------------------- | --------------------
Buffer                  |        Stable         |      Unfinished
Crypto                  |       On Hold         |      Unfinished
Datagram                |       Planned         |         None
DNS                     |       On Hold         |      Unfinished
Domain                  |        Stable         |       Complete
Events                  |        Stable         |      Unfinished
File System             |       Unstable*       |      Unfinished
Modules & Require       |        Stable         |      Unfinished
Net                     |        Stable         |      Unfinished
OS                      |        Stable         |       Complete
Path                    |        Stable         |       Complete
Process                 |        Stable         |      Unfinished
Stream                  |       Unstable        |      Unfinished
TLS/SSL                 |       Planned         |         None
TTY                     |       Planned         |         None
V8                      |        Stable         |       Complete
VM                      |        Stable         |       Complete
Zlib                    |       Unstable        |      Unfinished


> \* This API is unstable due to the nature of the function bindings.<br>
>    This might result in function names changing in later releases, or
>    parameters of functions changing.

Please note that any missing or unlisted APIs will eventually be added, minus deprecated
APIs prior to [node.js version 10.9.0](https://nodejs.org/api/documentation.html)

## License

node-kt is licensed under the Apache 2.0 License

```
Copyright 2018 Kaidan Gustave

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
