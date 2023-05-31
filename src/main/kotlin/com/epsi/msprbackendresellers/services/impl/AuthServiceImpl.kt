package com.epsi.msprbackendresellers.services.impl

import com.epsi.msprbackendresellers.models.User
import com.epsi.msprbackendresellers.repository.AuthApiClient
import com.epsi.msprbackendresellers.services.AuthService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AuthServiceImpl(private val authApiClient: AuthApiClient) : AuthService {
    override fun login(username: String, password: String): Mono<User> {
        val token = authApiClient.getToken(username, password)
        return Mono.just(User(username = username, token = token))
    }
}
