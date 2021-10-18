package com.nick.auth.api.error.enum

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.FORBIDDEN
import org.springframework.http.HttpStatus.NOT_FOUND

enum class AuthErrorCodes(
    val reason: String,
    val scope: String,
    val httpStatus: HttpStatus
) {

    USER_NOT_FOUND("User was not found", "{headers}.userId", NOT_FOUND),
    PASSWORD_VALIDATION_FAILED("Password does not satisfy the rules", "{body}.password", BAD_REQUEST),
    WRONG_REFRESH_TOKEN("Wrong refresh token provided", "{body}.refreshToken", FORBIDDEN),
    REFRESH_TOKEN_EXPIRED("Refresh token is expired", "{body}.refreshToken", FORBIDDEN),
    ACCESS_TOKEN_EXPIRED("Access token is expired", "{headers}.token", FORBIDDEN)
}
