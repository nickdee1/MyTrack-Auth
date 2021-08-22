package com.nick.auth.repository

import com.nick.auth.api.UsersEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UsersEntity, UUID>

