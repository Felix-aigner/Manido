package com.manido.services.persistence

import com.manido.dtos.ContractDTO
import com.manido.dtos.RentalType
import com.manido.dtos.UserDTO
import com.manido.entities.Contract
import org.jetbrains.exposed.sql.ResultRow

class ContractPersistenceService {


    private fun ResultRow.toContractDTO(first_user: UserDTO, second_user: UserDTO) = ContractDTO(
        first_party = first_user,
        second_party = second_user,
        // rental object
        topics = this[Contract.topics],
        description = this[Contract.description],
        country = this[Contract.country],
        city = this[Contract.city],
        postalCode = this[Contract.postalCode],
        addressLine = this[Contract.addressLine],
        timelyRestricted = this[Contract.timelyRestricted],
        startOfRental = this[Contract.startOfRental],
        endOfRental = this[Contract.endOfRental],
        typeOfRental = RentalType.valueOf(this[Contract.typeOfRental]),
        changeWhileActive = this[Contract.changeWhileActive],
        costHolder = this[Contract.costHolder],
        pricePerMonth = this[Contract.pricePerMonth],
        additionalConditions = this[Contract.additionalConditions]
    )
}
