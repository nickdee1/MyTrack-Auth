package com.nick.auth.controller

import com.nick.auth.api.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/auth")
class AuthController {

    @PostMapping("/token")
    fun generateAccessToken(@RequestHeader(required = true) userId: Long,
                            @RequestBody tokenRequestBody: GetAccessTokenRequest): ResponseEntity<GetAccessTokenResponse> {

        return ResponseEntity(GetAccessTokenResponse("refreshToken", "AccessToken", LocalDate.now()), HttpStatus.OK)
    }

    @PostMapping("/refresh")
    fun generateRefreshToken(@RequestBody tokenRequest: CreateRefreshTokenRequest): ResponseEntity<CreateRefreshTokenResponse> {

        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping("/createUser")
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): ResponseEntity<CreateUserResponse> {

        return ResponseEntity(HttpStatus.OK)
    }
}
