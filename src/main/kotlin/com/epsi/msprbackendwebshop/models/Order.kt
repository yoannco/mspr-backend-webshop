package com.epsi.msprbackendwebshop.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Order @JsonCreator constructor(
    @JsonProperty("socid") val socid: String,
    @JsonProperty("statut") val statut: String,
    @JsonProperty("billed") val billed: String,
    @JsonProperty("lines") val lines: List<Line>,
    @JsonProperty("ref") val ref: String,
) {
}

data class Line @JsonCreator constructor(
    @JsonProperty("fk_commande") val fkCommande: String,
    @JsonProperty("commande_id") val commandeId: String,
    @JsonProperty("ref") val ref: String,
    @JsonProperty("libelle") val libelle: String,
) {
}
