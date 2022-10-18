package com.marjorie.shoot

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/**
 * Generates responses to requests
 */
@Component
class PlaceHandler(
        private val placeClient: PlaceClient
) {
    fun getPlaceById(request: ServerRequest): Mono<ServerResponse> {
        return this.placeClient.getById(request.pathVariable("id"))
                .flatMap { place -> ServerResponse.ok().body(Mono.just(place), Place::class.java) }
                .switchIfEmpty(ServerResponse.notFound().build())
    }

    // TODO
    fun getAllPlaces(request: ServerRequest): Mono<ServerResponse>? {
        return null
    }
}