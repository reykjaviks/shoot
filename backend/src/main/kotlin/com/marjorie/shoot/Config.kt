package com.marjorie.shoot

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Config(
        @Value("\${placesAPI.baseUrl}") val placesBaseUrl: String
) {
    @Bean
    fun createPlacesWebClient(): WebClient {
        return WebClient.create(placesBaseUrl)
    }
}