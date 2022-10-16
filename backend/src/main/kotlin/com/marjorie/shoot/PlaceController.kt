package com.marjorie.shoot

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class PlaceController(private val placeService: PlaceService) {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPlace(@PathVariable id: Long): Mono<Place> {
        return placeService.getPlace(id)
    }
}