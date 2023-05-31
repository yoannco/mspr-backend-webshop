package com.epsi.msprbackendresellers.controllers

import com.epsi.msprbackendresellers.models.Product
import com.epsi.msprbackendresellers.services.impl.ProductServiceImpl
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
@RequestMapping(value = ["products"], produces = [MediaType.APPLICATION_JSON_VALUE])
class ProductController(private val productServiceImpl: ProductServiceImpl) {
    @GetMapping("{ref}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200", description = "Get product by ref", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = Product::class)
            )]
        ),])

    fun getProduct(@RequestHeader("token") token: String, @PathVariable ref: String) : Mono<Product> = productServiceImpl.getProductByRef(token, ref)

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200", description = "Get products", content = [Content(
                mediaType = "application/json", schema = Schema(implementation = Product::class)
            )]
        ),])

    fun getProducts(@RequestHeader("token") token: String) : Flux<Product> = productServiceImpl.getProducts(token)
}
