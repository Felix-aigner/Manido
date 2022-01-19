package com.manido.services.persistence

import com.manido.dtos.Role
import com.manido.dtos.UserDTO
import com.manido.entities.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class UserPersistenceService {

    private val encoder = BCryptPasswordEncoder()

    fun getUserById(id: Int): UserDTO? = transaction {
        User.select { User.id eq id }
            .map { it.toUserDTO() }
            .firstOrNull()
    }

    fun fetchUser(username: String): UserDTO? = transaction {
        User.select { User.username eq username }
            .map { it.toUserDTO() }
            .firstOrNull()
    }

    fun insertUser(user: UserDTO): Int = transaction {
        User.insertAndGetId {
            it[username] = user.username
            it[email] = user.email
            it[password] = encoder.encode(user.password)
            it[role] = user.role.toString()
            it[country] = user.country
            it[city] = user.city
            it[postalCode] = user.postalCode
            it[addressLine] = user.addressLine
        }.value
    }

    fun updateUser(user: UserDTO): Int = transaction {
        User.update({ User.id eq user.id }) {
            it[username] = user.username
            it[email] = user.email
            it[password] = encoder.encode(user.password)
            it[country] = user.country
            it[city] = user.city
            it[postalCode] = user.postalCode
            it[addressLine] = user.addressLine
        }
    }

    fun loginUser(username: String, password: String): UserDTO? = transaction {
        User.select{ User.username eq username}.firstOrNull()?.let {
            val storedPassword = it[User.password]
            if (encoder.matches(password, storedPassword)) it.toUserDTO()
            else null
        }
    }

    private fun ResultRow.toUserDTO() = UserDTO(
        id = this[User.id].value,
        role = Role.valueOf(this[User.role]),
        username = this[User.username],
        password = null,
        email = this[User.email],
        country = this[User.country],
        city = this[User.city],
        postalCode = this[User.postalCode],
        addressLine = this[User.addressLine],
        token = null
    )
}
