package com.nick.auth.api.error.enum

import org.springframework.http.HttpStatus

enum class AuthErrorCodes(
    val reason: String,
    val scope: String,
    val httpStatus: HttpStatus
) {

    USER_NOT_FOUND("User was not found", "{headers}.userId", HttpStatus.NOT_FOUND),
    WRONG_REFRESH_TOKEN("Wrong refresh token provided", "{body}.refreshToken", HttpStatus.FORBIDDEN),
    REFRESH_TOKEN_EXPIRED("Refresh token is expired", "{body}.refreshToken", HttpStatus.FORBIDDEN)
}
