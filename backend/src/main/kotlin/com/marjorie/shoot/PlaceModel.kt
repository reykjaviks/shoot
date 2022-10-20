package com.marjorie.shoot

import com.fasterxml.jackson.annotation.JsonProperty

data class Places(
        @JsonProperty("data")
        val places: List<Place>,
)

data class Place(
        val id: Long,
        @JsonProperty("info_url")
        val infoUrl: String?,
        var nameFi: String?,
) {
        @JsonProperty("name")
        fun unpackNameFromNestedJSON(name: Map<String, Any>) {
                this.nameFi = name["fi"].toString()
        }
}