package com.nick.auth.api.error

data class RestError(
    val message: String,
    val scope: String? = null
)
