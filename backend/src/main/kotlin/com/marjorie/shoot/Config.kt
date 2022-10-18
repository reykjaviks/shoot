package com.marjorie.shoot

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Config(
        @Value("\${helsinkiAPI.baseUrl}")
        val helsinkiAPI: String
) {
    @Bean
    @Qualifier("helsinkiAPIWebClient")
    fun helsinkiAPIWebClient(webClientBuilder: WebClient.Builder): WebClient {
        return webClientBuilder
                .clone()
                .baseUrl(helsinkiAPI)
                .build()
    }
}