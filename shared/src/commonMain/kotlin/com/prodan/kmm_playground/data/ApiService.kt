package com.prodan.kmm_playground.data

import com.prodan.kmm_playground.httpClient
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.json.*

class ApiService {
    private val httpClient = HttpClient(httpClient()){
        install(ContentNegotiation) {
            json(Json { isLenient = true; ignoreUnknownKeys = true })
        }

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.BODY
        }
    }

    suspend fun getRandomUsers() = httpClient.get("https://randomuser.me/api/?results=20").body<UsersResponse>()
}