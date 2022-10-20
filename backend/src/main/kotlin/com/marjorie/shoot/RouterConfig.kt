package com.marjorie.shoot

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

/**
 * Alternative to the RequestMapping annotation.
 */
@Configuration
class RouterConfig {
    @Bean
    fun routes(placeHandler: PlaceHandler): RouterFunction<ServerResponse> {
        return route(
            GET("/places/{id}"), placeHandler::getPlaceById
        ).andRoute(
            GET("/places"), placeHandler::getAllPlaces
        )
    }
}