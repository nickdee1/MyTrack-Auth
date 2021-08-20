package com.nick.auth.api

data class CreateRefreshTokenRequest(
    val username: String,
    val password: String
)
