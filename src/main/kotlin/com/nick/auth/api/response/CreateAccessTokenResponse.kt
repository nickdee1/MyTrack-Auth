package com.nick.auth.api.response

import java.time.LocalDateTime

data class CreateAccessTokenResponse(
    val refreshToken: String,
    val accessToken: String,
    val date: LocalDateTime
)
