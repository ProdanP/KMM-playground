package com.prodan.kmm_playground

expect val platform: String

class Greeting {
    fun greeting() = "Hello, $platform!"
}