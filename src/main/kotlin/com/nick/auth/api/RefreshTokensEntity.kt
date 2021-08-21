package com.nick.auth.api

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "refresh_tokens", schema = "public", catalog = "postgres")
data class RefreshTokensEntity(
    @Id
    @Column(name = "refresh_token", nullable = false, insertable = false, updatable = false)
    var refreshToken: String? = null,

    @Basic
    @Column(name = "date_issued", nullable = true)
    var dateIssued: java.sql.Timestamp? = null,

    @Basic
    @Column(name = "user_id", nullable = true, insertable = false, updatable = false)
    var userId: UUID? = null,

    @OneToMany(mappedBy = "refRefreshTokensEntity")
    var refAccessTokensEntities: List<AccessTokensEntity>? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var refUsersEntity: UsersEntity? = null
)

