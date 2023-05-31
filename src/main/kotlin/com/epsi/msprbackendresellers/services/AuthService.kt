package com.epsi.msprbackendresellers.services

import com.epsi.msprbackendresellers.models.User
import reactor.core.publisher.Mono

interface AuthService {
    fun login(username : String, password: String) : Mono<User>
}
