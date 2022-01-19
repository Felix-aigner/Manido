package com.manido.entities

import com.manido.entities.Contract.references
import org.jetbrains.exposed.dao.id.IntIdTable

object Advertisement: IntIdTable() {
    val holder = integer("first_party_id").references(User.id)
    // rental object
    val topics = varchar("topics", 100)
    val description = varchar("desciption", 300)
    val country = varchar("country", 50)
    val city = varchar("city", 50)
    val postalCode = varchar("postalCode", 50)
    val addressline = varchar("addressline", 300)
    val timelyRestricted = bool("timelyRestricted")
    val startOfRental = varchar("startOfRental", 50)
    val endOfRental = varchar("endOfRental", 50).nullable()
    val typeOfRental = varchar("typeOfRental", 50)
    val changeWhileActive = bool("changeWhileActive")
    val pricePerMonth = varchar("pricePerMonth", 50)
    val additionalConditions = varchar("additionalConditions", 300)
}
