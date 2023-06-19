package com.epsi.msprbackendwebshop.services.impl

import com.epsi.msprbackendwebshop.models.Order
import com.epsi.msprbackendwebshop.repository.OrderApiClient
import com.epsi.msprbackendwebshop.services.OrderService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OrderServiceImpl(private val orderApiClient: OrderApiClient) : OrderService {

    override fun getOrderByRef(token: String, ref: String): Mono<Order> {
        return orderApiClient.getOrder(token, ref)
    }

    override fun getOrders(token: String): Flux<Order> {
        return orderApiClient.getOrders(token)
    }
}
