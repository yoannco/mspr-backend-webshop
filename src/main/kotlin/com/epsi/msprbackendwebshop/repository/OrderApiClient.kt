package com.epsi.msprbackendwebshop.repository

import com.epsi.msprbackendwebshop.models.Order
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class OrderApiClient(private val webClient: WebClient) {

    fun getOrder(token: String, ref: String): Mono<Order> {
        val url = "/orders/ref/$ref"
        return webClient.get()
            .uri(url)
            .header("DOLAPIKEY", token)
            .retrieve()
            .bodyToMono(Order::class.java)
    }

    fun getOrders(token: String): Flux<Order> {
        val url = "/orders"
        return webClient.get()
            .uri(url)
            .header("DOLAPIKEY", token)
            .retrieve()
            .bodyToFlux(Order::class.java)
    }
}
