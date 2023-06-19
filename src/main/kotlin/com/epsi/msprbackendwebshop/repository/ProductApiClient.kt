package com.epsi.msprbackendwebshop.repository

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import com.epsi.msprbackendwebshop.models.Product
import reactor.core.publisher.Mono

@Component
class ProductApiClient(private val webClient: WebClient) {

    fun getProduct(token: String, ref: String): Mono<Product> {
        val url = "/products/ref/$ref"
        return webClient.get()
            .uri(url)
            .header("DOLAPIKEY", token)
            .retrieve()
            .bodyToMono(Product::class.java)
    }

    fun getProducts(token: String): Flux<Product> {
        val url = "/products"
        return webClient.get()
            .uri(url)
            .header("DOLAPIKEY", token)
            .retrieve()
            .bodyToFlux(Product::class.java)
    }
}
