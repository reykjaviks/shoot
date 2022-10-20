package com.marjorie.shoot

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class Config(
        @Value("\${helsinkiAPI.baseUrl}")
        val helsinkiAPI: String
) {
    @Bean
    @Qualifier("helsinkiAPIWebClient")
    fun helsinkiAPIWebClient(webClientBuilder: WebClient.Builder): WebClient {
        val size = 16 * 1024 * 1024
        val strategies = ExchangeStrategies.builder()
            .codecs { codecs: ClientCodecConfigurer ->
                codecs.defaultCodecs().maxInMemorySize(size)
            }.build()
        return WebClient.builder()
            .exchangeStrategies(strategies)
            .baseUrl(helsinkiAPI)
            .build()
    }
}