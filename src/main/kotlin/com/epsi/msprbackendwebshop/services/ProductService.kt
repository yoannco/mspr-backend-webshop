package com.epsi.msprbackendwebshop.services

import com.epsi.msprbackendwebshop.models.Product
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ProductService {
    fun getProductByRef(token: String, ref : String) : Mono<Product>

    fun getProducts(token: String) : Flux<Product>
}
