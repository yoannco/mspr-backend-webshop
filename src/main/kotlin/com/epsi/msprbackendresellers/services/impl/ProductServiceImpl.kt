package com.epsi.msprbackendresellers.services.impl

import com.epsi.msprbackendresellers.models.Product
import com.epsi.msprbackendresellers.repository.ProductApiClient
import com.epsi.msprbackendresellers.services.ProductService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductServiceImpl(private val productApiClient: ProductApiClient) : ProductService {

    override fun getProductByRef(token: String, ref: String): Mono<Product> {
        return productApiClient.getProduct(token, ref)
    }

    override fun getProducts(token: String): Flux<Product> {
        return productApiClient.getProducts(token)
    }
}
