package com.manido.services.persistence

import com.manido.dtos.*
import com.manido.entities.Advertisement
import com.manido.entities.Contract
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class AdvertisementPersistenceService(val userPersistenceService: UserPersistenceService) {

    fun insertAdvertisement(advertisement: AdvertisementDTO): Int = transaction {
        if (advertisement.holder.id == null) {
            return@transaction 0
        }
        Advertisement.insertAndGetId {
            it[Advertisement.holder] = advertisement.holder.id
            it[topics] = advertisement.topics
            it[description] = advertisement.description
            it[country] = advertisement.country
            it[city] = advertisement.city
            it[postalCode] = advertisement.postalCode
            it[addressline] = advertisement.addressLine
            it[timelyRestricted] = advertisement.timelyRestricted
            it[startOfRental] = advertisement.startOfRental
            it[endOfRental] = advertisement.endOfRental
            it[typeOfRental] = advertisement.typeOfRental.toString()
            it[changeWhileActive] = advertisement.changeWhileActive
            it[pricePerMonth] = advertisement.pricePerMonth
            it[additionalConditions] = advertisement.additionalConditions
        }.value
    }

    fun updateAdvertisement(advertisement: AdvertisementDTO): Int = transaction {
        if (advertisement.holder.id == null) {
            return@transaction 0
        }

        Advertisement.update({ Advertisement.id eq advertisement.id }) {
            it[Advertisement.holder] = advertisement.holder.id
            it[topics] = advertisement.topics
            it[description] = advertisement.description
            it[country] = advertisement.country
            it[city] = advertisement.city
            it[postalCode] = advertisement.postalCode
            it[addressline] = advertisement.addressLine
            it[timelyRestricted] = advertisement.timelyRestricted
            it[startOfRental] = advertisement.startOfRental
            it[endOfRental] = advertisement.endOfRental
            it[typeOfRental] = advertisement.typeOfRental.toString()
            it[changeWhileActive] = advertisement.changeWhileActive
            it[pricePerMonth] = advertisement.pricePerMonth
            it[additionalConditions] = advertisement.additionalConditions
        }
    }

    fun getAllAdvertisements(): List<AdvertisementDTO> = transaction {
        Advertisement.selectAll().map { it ->
            val user = userPersistenceService.getUserById(it[Advertisement.holder])?: UserDTO(
                role = Role.ANBIETER,
                username = "Max Mustermann",
                email = "max@mustermann.de",
                addressLine = null,
                city = null,
                country = null,
                postalCode = null,
                password = null,
                token = null
            )
            it.toAdvertisementDTO(user)
        }
    }


    private fun ResultRow.toAdvertisementDTO(holder: UserDTO) = AdvertisementDTO(
        id = this[Advertisement.id].value,
        holder = holder,
        // rental object
        topics = this[Advertisement.topics],
        description = this[Advertisement.description],
        country = this[Advertisement.country],
        city = this[Advertisement.city],
        postalCode = this[Advertisement.postalCode],
        addressLine = this[Advertisement.addressline],
        timelyRestricted = this[Advertisement.timelyRestricted],
        startOfRental = this[Advertisement.startOfRental],
        endOfRental = this[Advertisement.endOfRental],
        typeOfRental = RentalType.valueOf(this[Advertisement.typeOfRental]),
        changeWhileActive = this[Advertisement.changeWhileActive],
        pricePerMonth = this[Advertisement.pricePerMonth],
        additionalConditions = this[Advertisement.additionalConditions]
    )
}
