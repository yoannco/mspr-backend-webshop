package com.epsi.msprbackendwebshop.services

import com.epsi.msprbackendwebshop.models.Order
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface OrderService {
    fun getOrderByRef(token: String, ref : String) : Mono<Order>

    fun getOrders(token: String) : Flux<Order>
}
