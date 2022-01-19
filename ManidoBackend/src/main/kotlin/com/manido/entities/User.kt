package com.manido.entities

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object User : IntIdTable() {
    val username = varchar("username", 50)
    val email = varchar("email", 50)
    val password = varchar("password", 300)
    val role = varchar("role", 50)
    val country = varchar("country", 50).nullable()
    val city = varchar("city", 50).nullable()
    val postalCode = varchar("postalCode", 50).nullable()
    val addressLine = varchar("addressLine", 300).nullable()
}
