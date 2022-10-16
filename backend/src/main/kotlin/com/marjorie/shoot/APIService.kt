package com.marjorie.shoot

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class APIService(private val client: WebClient) {
    fun fetch(path: String): WebClient.ResponseSpec {
        return client
                .get()
                .uri(path)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
    }
}