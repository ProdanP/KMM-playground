package com.prodan.kmm_playground

import io.ktor.client.*
import io.ktor.client.engine.*

expect val platform: String


expect fun httpClient(): HttpClientEngine


class Greeting {

    fun greeting() = "Hello, $platform!"
}