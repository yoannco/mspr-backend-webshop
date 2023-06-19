package com.epsi.msprbackendwebshop.services

import com.epsi.msprbackendwebshop.models.Customer
import com.epsi.msprbackendwebshop.models.Order
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
    fun getCustomerByEmail(token: String, email : String) : Mono<Customer>

    fun getCustomers(token: String) : Flux<Customer>

    fun getOrders(token: String, email: String) : Flux<Order>
}
