package com.marjorie.shoot

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class APIService(
        private val client: WebClient
) {
    fun fetch(path: String): WebClient.ResponseSpec {
        return client
                .get()
                .uri(path)
                .retrieve()
    }
}