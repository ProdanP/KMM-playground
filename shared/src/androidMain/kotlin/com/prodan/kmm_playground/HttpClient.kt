package com.prodan.kmm_playground

import io.ktor.client.engine.android.*

actual fun httpClient() = Android.create()