package com.nick.auth.controller

import com.nick.auth.api.request.CreateRefreshTokenRequest
import com.nick.auth.api.request.CreateUserRequest
import com.nick.auth.api.request.CreateAccessTokenRequest
import com.nick.auth.api.response.CreateRefreshTokenResponse
import com.nick.auth.api.response.CreateUserResponse
import com.nick.auth.api.response.CreateAccessTokenResponse
import com.nick.auth.service.AuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/token")
    fun generateAccessToken(@RequestHeader(required = true) userId: UUID,
                            @RequestBody tokenRequestBody: CreateAccessTokenRequest): ResponseEntity<CreateAccessTokenResponse> {
        val accessToken = authService.generateAccessToken(tokenRequestBody, userId)
        return ResponseEntity(accessToken, HttpStatus.OK)
    }

    @PostMapping("/refresh")
    fun generateRefreshToken(@RequestBody tokenRequest: CreateRefreshTokenRequest): ResponseEntity<CreateRefreshTokenResponse> {
        val refreshToken = authService.generateRefreshToken(tokenRequest)
        return ResponseEntity(refreshToken, HttpStatus.OK)
    }

    @PostMapping("/createUser")
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): ResponseEntity<CreateUserResponse> {
        val createdUser = authService.createUser(createUserRequest)
        return ResponseEntity(createdUser, HttpStatus.OK)
    }
}
