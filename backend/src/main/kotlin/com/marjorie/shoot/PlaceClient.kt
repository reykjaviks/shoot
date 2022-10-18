package com.marjorie.shoot

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

/**
 * Calls the Helsinki API
 */
@Component
class PlaceClient(
        @Qualifier("helsinkiAPIWebClient")
        private val helsinkiAPIWebClient: WebClient
) {

    fun getById(id: String): Mono<Place> {
        return helsinkiAPIWebClient.get()
                .uri("/place/".plus(id))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Place::class.java)
    }
}