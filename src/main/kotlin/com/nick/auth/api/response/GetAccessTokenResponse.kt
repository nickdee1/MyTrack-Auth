package com.nick.auth.api.response

import java.time.LocalDate

data class GetAccessTokenResponse(
    val refreshToken: String,
    val accessToken: String,
    val date: LocalDate
)
