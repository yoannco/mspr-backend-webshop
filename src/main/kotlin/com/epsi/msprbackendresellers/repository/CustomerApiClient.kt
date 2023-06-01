package com.epsi.msprbackendresellers.repository

import com.epsi.msprbackendresellers.models.Customer
import com.epsi.msprbackendresellers.models.Order
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CustomerApiClient(private val webClient: WebClient) {

    fun getCustomerByEmail(token: String, email: String): Mono<Customer> {
        val url = "/thirdparties/email/$email"
        return webClient.get()
            .uri(url)
            .header("DOLAPIKEY", token)
            .retrieve()
            .bodyToMono(Customer::class.java)
    }

    fun getCustomers(token: String): Flux<Customer> {
        val url = "/thirdparties"
        return webClient.get()
            .uri(url)
            .header("DOLAPIKEY", token)
            .retrieve()
            .bodyToFlux(Customer::class.java)
    }

    fun getOrders(token: String, codeClient: String): Flux<Order> {
        val url = "/orders?sqlfilters=(t.ref_client:like:'$codeClient')"
        return webClient.get()
            .uri(url)
            .header("DOLAPIKEY", token)
            .retrieve()
            .bodyToFlux(Order::class.java)
    }
}
