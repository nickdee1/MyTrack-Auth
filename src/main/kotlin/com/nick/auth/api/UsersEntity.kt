package com.nick.auth.api

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
class UsersEntity (
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
    var refreshTokens: List<RefreshTokensEntity>? = null,

//    override fun toString(): String =
//        "Entity of type: ${javaClass.name} ( " +
//            "id = $id " +
//            "username = $username " +
//            "password = $password " +
//            ")" )
)
