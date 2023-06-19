package com.epsi.msprbackendwebshop.services.impl

import com.epsi.msprbackendwebshop.models.Product
import com.epsi.msprbackendwebshop.repository.ProductApiClient
import com.epsi.msprbackendwebshop.services.ProductService
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
