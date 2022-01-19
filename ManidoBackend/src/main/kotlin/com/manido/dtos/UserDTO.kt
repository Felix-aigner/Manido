package com.manido.dtos

import com.manido.entities.User
import com.manido.entities.User.nullable
import kotlinx.serialization.Serializable


@Serializable
data class UserDTO(
    val id: Int? = null,
    val role: Role,
    val username: String,
    val password: String?,
    val email: String,
    // address
    val country: String?,
    val city: String?,
    val postalCode: String?,
    val addressLine: String?,
    var token: String?
)

enum class Role {
    ANBIETER,
    UNTERNEHMEN
}
