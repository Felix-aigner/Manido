package com.manido.dtos

import com.manido.entities.Contract
import com.manido.entities.Contract.references
import com.manido.entities.User

data class ContractDTO (
    val first_party: UserDTO,
    val second_party: UserDTO,
    // rental object
    val topics: String,
    val description: String,
    val country: String,
    val city: String,
    val postalCode: String,
    val addressLine: String,
    val timelyRestricted: Boolean,
    val startOfRental: String,
    val endOfRental: String?,
    val typeOfRental: RentalType,
    val changeWhileActive: Boolean,
    val costHolder: String,
    val pricePerMonth: Float,
    val additionalConditions: String
)

enum class RentalType {
    Anstrich,
    Beklebung,
    Halterung,
    OhneHalterung
}
