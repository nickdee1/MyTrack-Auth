package com.nick.auth.exception

import org.springframework.http.HttpStatus

class AuthException(
    val reason: String?,
    val httpStatus: HttpStatus?
): RuntimeException()
