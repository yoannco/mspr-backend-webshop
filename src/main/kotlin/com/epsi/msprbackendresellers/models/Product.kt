package com.epsi.msprbackendresellers.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Product @JsonCreator constructor(
    @JsonProperty("label") val label: String,
    @JsonProperty("description") val description: String
) {
}
