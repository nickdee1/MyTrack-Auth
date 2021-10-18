package com.nick.auth.api

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "access_tokens", schema = "public", catalog = "postgres")
data class AccessTokensEntity(
    @Id
    @Column(name = "access_token", nullable = false)
    var accessToken: String? = null,

    @Basic
    @Column(name = "date_issued", nullable = true)
    var dateIssued: LocalDateTime? = null,

    @Basic
    @Column(name = "refresh_token", nullable = true, insertable = false, updatable = false)
    var refreshToken: String? = null,

    @Basic
    @Column(name = "user_id", nullable = true, insertable = false, updatable = false)
    var userId: UUID? = null,

    @Basic
    @Column(name = "revoked", nullable = false)
    var revoked: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refresh_token", referencedColumnName = "refresh_token")
    var refRefreshTokensEntity: RefreshTokensEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var refUsersEntity: UsersEntity? = null
)

