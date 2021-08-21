package com.nick.auth.repository

import com.nick.auth.api.RefreshTokensEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

interface RefreshTokenRepository : JpaRepository<RefreshTokensEntity, String> {
    fun findByRefreshToken(token: String): RefreshTokensEntity? {
        return findByIdOrNull(token)
    }
}
