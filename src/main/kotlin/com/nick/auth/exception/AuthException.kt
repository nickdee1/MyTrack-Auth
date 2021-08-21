package com.nick.auth.exception

import org.springframework.http.HttpStatus

class AuthException(
    val reason: String,
    val scope: String? = null,
    val httpStatus: HttpStatus
): RuntimeException()
