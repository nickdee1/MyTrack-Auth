package com.nick.auth.service.validate

import com.nick.auth.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import com.nick.auth.exception.AuthException
import com.nick.auth.repository.RefreshTokenRepository
import org.springframework.http.HttpStatus

@Service
class AuthValidator(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository
) {

    fun validateUser(byId: UUID) =
        userRepository.findByIdOrNull(byId) ?:
            throw AuthException(
                reason = "User was not found",
                scope = "{headers}.userId",
                httpStatus = HttpStatus.NOT_FOUND
            )

    fun validateRefreshToken(token: String) {
        refreshTokenRepository.findByRefreshToken(token) ?:
        throw AuthException(
            reason = "Wrong refresh token provided",
            scope = "{body}.refreshToken",
            httpStatus = HttpStatus.FORBIDDEN
        )

    }
}
