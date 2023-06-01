package com.epsi.msprbackendresellers.controllers

import com.epsi.msprbackendresellers.models.Customer
import com.epsi.msprbackendresellers.models.Order
import com.epsi.msprbackendresellers.services.impl.CustomerServiceImpl
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["customers"], produces = [MediaType.APPLICATION_JSON_VALUE])
class CustomerController(private val customerServiceImpl: CustomerServiceImpl) {
    @GetMapping("{email}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200", description = "Get customer by ref", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = Customer::class)
            )]
        ),])

    fun getCustomer(@RequestHeader("token") token: String, @PathVariable email: String) : Mono<Customer> = customerServiceImpl.getCustomerByEmail(token, email)

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200", description = "Get customers", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = Customer::class)
            )]
        ),])

    fun getCustomers(@RequestHeader("token") token: String) : Flux<Customer> = customerServiceImpl.getCustomers(token)

    // get orders by email
    @GetMapping("{email}/orders")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200", description = "Get orders by email", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = Customer::class)
            )]
        ),])

    fun getOrders(@RequestHeader("token") token: String, @PathVariable email: String) : Flux<Order> = customerServiceImpl.getOrders(token, email)
}
