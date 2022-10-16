package com.marjorie.shoot

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlaceService(private val apiService: APIService) {
    fun getPlace(id: Long): Mono<Place> {
        return apiService.fetch("/place/".plus(id)).bodyToMono(Place::class.java)
    }
}