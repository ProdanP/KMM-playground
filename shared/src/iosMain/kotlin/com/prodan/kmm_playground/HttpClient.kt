package com.prodan.kmm_playground

import io.ktor.client.*
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.*
import io.ktor.client.engine.ios.*
import java.util.concurrent.TimeUnit

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Darwin) {
    config(this)

    engine {
        configureRequest {
           // setAllowsCellularAccess(true)
        }
    }
}
