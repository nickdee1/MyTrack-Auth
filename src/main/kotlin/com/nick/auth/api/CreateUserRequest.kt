package com.nick.auth.api

data class CreateUserRequest(
    val username: String,
    val password: String
)
