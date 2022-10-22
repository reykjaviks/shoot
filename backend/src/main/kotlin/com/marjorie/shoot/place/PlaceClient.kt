package com.marjorie.shoot.place

import com.marjorie.shoot.Place
import com.marjorie.shoot.Places
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

    fun getAll(): Mono<Places> {
        return this.helsinkiAPIWebClient.get()
            .uri("/places/")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Places::class.java)
    }
}