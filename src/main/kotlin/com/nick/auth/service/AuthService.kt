package com.nick.auth.service

import com.nick.auth.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthService(
    val userRepository: UserRepository
) {


}
