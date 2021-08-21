package com.nick.auth.service.validate

import com.nick.auth.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import com.nick.auth.exception.AuthException
import org.springframework.http.HttpStatus

@Service
class AuthValidator(
    private val userRepository: UserRepository
) {

    fun validateUser(byId: UUID) {
        userRepository.findByIdOrNull(byId) ?:
            throw AuthException(reason = "User not found", httpStatus = HttpStatus.NOT_FOUND)
    }
}
