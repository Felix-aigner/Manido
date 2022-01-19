package com.manido.entities

import com.manido.entities.User.nullable
import org.jetbrains.exposed.dao.id.IntIdTable

object Contract: IntIdTable() {
    val first_party = integer("first_party_id").references(User.id)
    val second_party = integer("second_party_id").references(User.id)
    // rental object
    val topics = varchar("topics", 100)
    val description = varchar("desciption", 300)
    val country = varchar("country", 50)
    val city = varchar("city", 50)
    val postalCode = varchar("postalCode", 50)
    val addressLine = varchar("addressLine", 300)
    val timelyRestricted = bool("timelyRestricted")
    val startOfRental = varchar("startOfRental", 50)
    val endOfRental = varchar("endOfRental", 50)
    val typeOfRental = varchar("typeOfRental", 50)
    val changeWhileActive = bool("changeWhileActive")
    val costHolder = varchar("costHolder", 50)
    val pricePerMonth = float("pricePerMonth")
    val additionalConditions = varchar("additionalConditions", 300)
}
