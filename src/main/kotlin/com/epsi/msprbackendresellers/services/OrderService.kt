package com.epsi.msprbackendresellers.services

import com.epsi.msprbackendresellers.models.Order
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface OrderService {
    fun getOrderByRef(token: String, ref : String) : Mono<Order>

    fun getOrders(token: String) : Flux<Order>
}
