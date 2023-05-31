package com.epsi.msprbackendresellers.repository

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import org.slf4j.LoggerFactory
import com.epsi.msprbackendresellers.models.Product
import org.springframework.web.reactive.function.client.bodyToMono
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

//    private fun handleError(error: Throwable): Mono<Product> {
//        logger.error("Error while fetching products: ${error.message}", error)
//        return Mono.error(
//            ResponseStatusException(
//                HttpStatus.FORBIDDEN, error.message
//            )
//        )
//    }
}
