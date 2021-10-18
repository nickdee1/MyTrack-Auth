package com.nick.auth.repository

import com.nick.auth.api.AccessTokensEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccessTokenRepository : JpaRepository<AccessTokensEntity, String>
