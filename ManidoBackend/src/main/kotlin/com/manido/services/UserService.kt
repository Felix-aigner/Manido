package com.manido.services

import com.manido.dtos.UserDTO
import com.manido.services.persistence.UserPersistenceService

class UserService(private val userPersistenceService: UserPersistenceService) {
    fun loginuser(username: String, password: String): UserDTO? = when {
        username.isNotBlank() && password.isNotBlank() -> userPersistenceService.loginUser(username, password)
        else -> null
    }

    fun createUser(userDTO: UserDTO): Int = userPersistenceService.insertUser(userDTO)
}
