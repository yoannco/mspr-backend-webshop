package com.epsi.msprbackendresellers.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Customer @JsonCreator constructor(
        @JsonProperty("id") val id: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("country_code") val countryCode: String,
        @JsonProperty("code_client") val codeClient: String,
        @JsonProperty("email") val email: String? = null,
        ) {
}
