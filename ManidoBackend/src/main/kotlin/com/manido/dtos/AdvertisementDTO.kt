package com.manido.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AdvertisementDTO(
    val id: Int?,
    val holder: UserDTO,
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
    val pricePerMonth: String,
    val additionalConditions: String
)

//enum class RentalType {
//    ANSTRICH,
//    BEKLEBUNG,
//    HALTERUNG,
//    OHNEHALTERUNG
//}
