package com.epsi.msprbackendresellers.services

import com.epsi.msprbackendresellers.models.Customer
import com.epsi.msprbackendresellers.models.Order
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
    fun getCustomerByEmail(token: String, email : String) : Mono<Customer>

    fun getCustomers(token: String) : Flux<Customer>

    fun getOrders(token: String, email: String) : Flux<Order>
}
