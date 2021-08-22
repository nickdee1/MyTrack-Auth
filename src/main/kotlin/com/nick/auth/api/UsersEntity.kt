package com.nick.auth.api

import java.util.UUID
import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
class UsersEntity(
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: UUID? = null,

    @Basic
    @Column(name = "username", nullable = true)
    var username: String? = null,

    @Basic
    @Column(name = "password", nullable = true)
    var password: String? = null,

    @OneToMany(mappedBy = "refUsersEntity")
    var accessTokens: List<AccessTokensEntity>? = null,

    @OneToMany(mappedBy = "refUsersEntity")
    var refreshTokens: List<RefreshTokensEntity>? = null
)
