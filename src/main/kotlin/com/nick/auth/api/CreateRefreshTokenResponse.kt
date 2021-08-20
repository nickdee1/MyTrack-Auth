package com.nick.auth.api

import java.time.LocalDate

data class CreateRefreshTokenResponse(
    val refreshToken: String,
    val accessToken: String,
    val date: LocalDate
)
