package com.marjorie.shoot

import com.fasterxml.jackson.annotation.JsonProperty

data class Place(
        val id: Long,

        @JsonProperty("info_url")
        val infoUrl: String,
)