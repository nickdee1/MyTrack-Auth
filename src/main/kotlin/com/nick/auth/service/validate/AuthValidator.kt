package com.nick.auth.service.validate

import com.nick.auth.api.RefreshTokensEntity
import com.nick.auth.api.error.enum.AuthErrorCodes.REFRESH_TOKEN_EXPIRED
import com.nick.auth.api.error.enum.AuthErrorCodes.USER_NOT_FOUND
import com.nick.auth.api.error.enum.AuthErrorCodes.WRONG_REFRESH_TOKEN
import com.nick.auth.exception.AuthException
import com.nick.auth.repository.RefreshTokenRepository
import com.nick.auth.repository.UserRepository
import com.nick.auth.repository.findByRefreshTokenOrNull
import java.time.LocalDateTime
import java.util.UUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthValidator(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository
) {

    fun validateOnGenerateAccessToken(userId: UUID, refreshToken: String) {
        validateUser(userId)
        validateRefreshToken(refreshToken)
    }

    private fun validateUser(byId: UUID) =
        userRepository.findByIdOrNull(byId) ?: throw AuthException(
            reason = USER_NOT_FOUND.reason,
            scope = USER_NOT_FOUND.scope,
            httpStatus = USER_NOT_FOUND.httpStatus
        )

    private fun validateRefreshToken(token: String) {
        val refreshTokenEntity = refreshTokenRepository.findByRefreshTokenOrNull(token) ?: throw AuthException(
            reason = WRONG_REFRESH_TOKEN.reason,
            scope = WRONG_REFRESH_TOKEN.scope,
            httpStatus = WRONG_REFRESH_TOKEN.httpStatus
        )
        validateRefreshTokenExpiration(refreshTokenEntity)
    }

    private fun validateRefreshTokenExpiration(tokenEntity: RefreshTokensEntity) {
        val tokenExpirationDate = tokenEntity.dateIssued!!.toLocalDateTime().plusDays(90)
        if (tokenExpirationDate.isBefore(LocalDateTime.now())) {
            throw AuthException(
                reason = REFRESH_TOKEN_EXPIRED.reason,
                scope = REFRESH_TOKEN_EXPIRED.scope,
                httpStatus = REFRESH_TOKEN_EXPIRED.httpStatus
            )
        }
    }
}
