package com.prodan.kmm_playground

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}