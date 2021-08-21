package com.nick.auth.api.request

data class CreateUserRequest(
    val username: String,
    val password: String
)
