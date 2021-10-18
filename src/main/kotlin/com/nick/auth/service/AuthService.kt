package com.nick.auth.service

import com.nick.auth.api.AccessTokensEntity
import com.nick.auth.api.RefreshTokensEntity
import com.nick.auth.api.UsersEntity
import com.nick.auth.api.request.CreateAccessTokenRequest
import com.nick.auth.api.request.CreateRefreshTokenRequest
import com.nick.auth.api.request.CreateUserRequest
import com.nick.auth.api.response.CreateAccessTokenResponse
import com.nick.auth.api.response.CreateRefreshTokenResponse
import com.nick.auth.api.response.CreateUserResponse
import com.nick.auth.repository.AccessTokenRepository
import com.nick.auth.repository.UserRepository
import com.nick.auth.service.validate.AuthValidator
import com.nick.auth.util.BaseEncoder
import java.time.LocalDateTime
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val accessTokenRepository: AccessTokenRepository,
    private val authValidator: AuthValidator
) {

    fun generateAccessToken(accessTokenRequest: CreateAccessTokenRequest, userId: UUID): CreateAccessTokenResponse {
        authValidator.validateUserOnGenerateAccessToken(userId, accessTokenRequest.refreshToken)
        val dateNow = LocalDateTime.now()
        val dataString = userId.toString() + accessTokenRequest.refreshToken + dateNow.toString()
        val token = BaseEncoder.base64Encode(dataString)
        saveAccessToken(token, userId, accessTokenRequest.refreshToken, dateNow)
        return CreateAccessTokenResponse(accessTokenRequest.refreshToken, token, LocalDateTime.now())
    }

    fun generateRefreshToken(refreshTokenRequest: CreateRefreshTokenRequest): CreateRefreshTokenResponse {
        return CreateRefreshTokenResponse("token", "token", LocalDateTime.now())
    }

    fun createUser(createUserRequest: CreateUserRequest): CreateUserResponse {
        return CreateUserResponse(1, "user")
    }

    private fun saveAccessToken(accessToken: String, userId: UUID, refreshToken: String, dateNow: LocalDateTime) {
        val userEntity = UsersEntity(userId)
        val refreshTokenEntity = RefreshTokensEntity(refreshToken)
        val accessTokenEntity = AccessTokensEntity(accessToken, dateNow, refRefreshTokensEntity = refreshTokenEntity, refUsersEntity = userEntity)
        accessTokenRepository.save(accessTokenEntity)
    }
}
