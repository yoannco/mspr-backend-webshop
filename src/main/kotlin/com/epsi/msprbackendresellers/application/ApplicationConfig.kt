package com.epsi.msprbackendresellers.application

import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class ApplicationConfig {
    @Bean
    fun restTemplate(): RestTemplate? {
        return RestTemplate()
    }
}

@Configuration
class WebClientConfig {
    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl("http://192.168.5.65:8888/doli/api/index.php")
            .build()
    }
}


object SpringMongoConnectionViaPropertiesApp {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(SpringMongoConnectionViaPropertiesApp::class.java, *args)
    }
}
