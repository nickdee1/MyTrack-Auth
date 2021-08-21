package com.nick.auth.api.request

data class CreateRefreshTokenRequest(
    val username: String,
    val password: String
)
