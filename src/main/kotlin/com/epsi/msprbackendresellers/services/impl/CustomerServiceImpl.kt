package com.epsi.msprbackendresellers.services.impl

import com.epsi.msprbackendresellers.models.Customer
import com.epsi.msprbackendresellers.models.Order
import com.epsi.msprbackendresellers.repository.CustomerApiClient
import com.epsi.msprbackendresellers.services.CustomerService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CustomerServiceImpl(private val customerApiClient: CustomerApiClient) : CustomerService {

    override fun getCustomerByEmail(token: String, email: String): Mono<Customer> {
        return customerApiClient.getCustomerByEmail(token, email)
    }

    override fun getCustomers(token: String): Flux<Customer> {
        return customerApiClient.getCustomers(token)
    }

    override fun getOrders(token: String, email: String): Flux<Order> {
        val customer: Customer = customerApiClient.getCustomerByEmail(token, email).block()!!
        return customerApiClient.getOrders(token, customer.codeClient)
    }
}
