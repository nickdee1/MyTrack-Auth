package com.nick.auth.api

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "access_tokens", schema = "public", catalog = "postgres")
data class AccessTokensEntity(
    @Id
    @Column(name = "access_token", nullable = false)
    var accessToken: String? = null,

    @Basic
    @Column(name = "date_issued", nullable = true)
    var dateIssued: java.sql.Timestamp? = null,

    @Basic
    @Column(name = "refresh_token", nullable = true, insertable = false, updatable = false)
    var refreshToken: String? = null,

    @Basic
    @Column(name = "user_id", nullable = true, insertable = false, updatable = false)
    var userId: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refresh_token", referencedColumnName = "refresh_token")
    var refRefreshTokensEntity: RefreshTokensEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var refUsersEntity: UsersEntity? = null
)

