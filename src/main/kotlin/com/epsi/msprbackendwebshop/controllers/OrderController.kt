package com.epsi.msprbackendwebshop.controllers

import com.epsi.msprbackendwebshop.services.impl.OrderServiceImpl
import com.epsi.msprbackendwebshop.models.Order
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
@RequestMapping(value = ["orders"], produces = [MediaType.APPLICATION_JSON_VALUE])
class OrderController(private val orderServiceImpl: OrderServiceImpl) {
    @GetMapping("{ref}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200", description = "Get order by ref", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = Order::class)
            )]
        ),])

    fun getOrder(@RequestHeader("token") token: String, @PathVariable ref: String) : Mono<Order> = orderServiceImpl.getOrderByRef(token, ref)

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200", description = "Get orders", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = Order::class)
            )]
        ),])

    fun getOrders(@RequestHeader("token") token: String) : Flux<Order> = orderServiceImpl.getOrders(token)
}
