package com.nick.auth.service

import com.nick.auth.api.request.CreateAccessTokenRequest
import com.nick.auth.api.request.CreateRefreshTokenRequest
import com.nick.auth.api.request.CreateUserRequest
import com.nick.auth.api.response.CreateAccessTokenResponse
import com.nick.auth.api.response.CreateRefreshTokenResponse
import com.nick.auth.api.response.CreateUserResponse
import com.nick.auth.repository.UserRepository
import com.nick.auth.service.validate.AuthValidator
import java.time.LocalDate
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val authValidator: AuthValidator
) {

    fun generateAccessToken(accessTokenRequest: CreateAccessTokenRequest, userId: UUID): CreateAccessTokenResponse {
        authValidator.validateOnGenerateAccessToken(userId, accessTokenRequest.refreshToken)
        return CreateAccessTokenResponse("token", "token", LocalDate.now())
    }

    fun generateRefreshToken(refreshTokenRequest: CreateRefreshTokenRequest): CreateRefreshTokenResponse {
        return CreateRefreshTokenResponse("token", "token", LocalDate.now())
    }

    fun createUser(createUserRequest: CreateUserRequest): CreateUserResponse {
        return CreateUserResponse(1, "user")
    }
}
