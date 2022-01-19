package com.manido.services

import com.manido.dtos.AdvertisementDTO
import com.manido.services.persistence.AdvertisementPersistenceService

class AdvertisementService(private val advertisementPersistenceService: AdvertisementPersistenceService) {
    fun retrieveAllAdvertisements() = advertisementPersistenceService.getAllAdvertisements()
    fun createAdvertisement(advertisement: AdvertisementDTO) = advertisementPersistenceService.insertAdvertisement(advertisement)
}
