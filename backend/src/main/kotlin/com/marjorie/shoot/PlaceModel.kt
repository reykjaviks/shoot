package com.marjorie.shoot

import com.fasterxml.jackson.annotation.JsonProperty

data class Places(
        @JsonProperty("data")
        val places: List<Place>,
)

data class Place(
        val id: Long,
        @JsonProperty("info_url")
        val infoUrl: String,
        val name: Name,
)

data class Name(
        val fi: String,
        val en: String,
)