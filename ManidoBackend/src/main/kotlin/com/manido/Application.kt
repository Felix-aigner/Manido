package com.manido

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.manido.dtos.RentalType
import com.manido.dtos.Role
import com.manido.entities.Advertisement
import com.manido.entities.User
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.manido.plugins.*
import com.manido.services.AdvertisementService
import com.manido.services.JWTService
import com.manido.services.UserService
import com.manido.services.persistence.AdvertisementPersistenceService
import com.manido.services.persistence.UserPersistenceService
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.serialization.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


val secret = "secret"
val issuer = "http://0.0.0.0:8080/"
val audience = "http://0.0.0.0:8080/health"
val realm = "Access to 'health'"


fun main() {
    Database.connect("jdbc:h2:~/test", driver = "org.h2.Driver")
    setupDatabase()
    val jwtService = JWTService()
    val userService = UserService(userPersistenceService = UserPersistenceService())
    val advertisementService = AdvertisementService(AdvertisementPersistenceService(UserPersistenceService()))
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json()
        }
        install(Authentication) {
            jwt("jwt-auth") {
                realm = "Access to App"
                verifier(jwtService.tokenVerifier())
                validate {
                    jwtService.validateToken(it)
                }
            }
        }
        install(CORS) {
            anyHost()
            method(HttpMethod.Options)
            method(HttpMethod.Get)
            method(HttpMethod.Post)
            method(HttpMethod.Put)
            method(HttpMethod.Delete)
            method(HttpMethod.Patch)
            anyHost()
            header(HttpHeaders.AccessControlAllowHeaders)
            header(HttpHeaders.ContentType)
            header(HttpHeaders.AccessControlAllowOrigin)
            header("Authorization")
            allowNonSimpleContentTypes = true
        }

        configureRouting(jwtService, userService, advertisementService)
    }.start(wait = true)
}

private val encoder = BCryptPasswordEncoder()

fun setupDatabase() = transaction {
    SchemaUtils.drop(User, Advertisement)
    SchemaUtils.create(User, Advertisement)
    val userid = User.insertAndGetId {
        it[username] = "username"
        it[password] = encoder.encode("password")
        it[email] = "something@gmail.com"
        it[role] = Role.UNTERNEHMEN.toString()
        it[country] = null
        it[city] = null
        it[postalCode] = null
        it[addressLine] = null
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Beklebung.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Beklebung.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Anstrich.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Anstrich.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Anstrich.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Beklebung.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Beklebung.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Beklebung.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Beklebung.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Beklebung.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
    Advertisement.insertAndGetId {
        it[Advertisement.holder] = userid.value
        it[topics] = "all Topics allowed"
        it[description] = "thsi is a plakatwand, its a nice plakatwand"
        it[country] = "Österreich"
        it[city] = "Wien"
        it[postalCode] = "NA"
        it[addressline] = "gleich hinter dem Heiner auf der Landstraße"
        it[timelyRestricted] = Op.FALSE
        it[startOfRental] = "01-01-2021"
        it[endOfRental] = null
        it[typeOfRental] = RentalType.Beklebung.toString()
        it[changeWhileActive] = Op.TRUE
        it[pricePerMonth] = "50"
        it[additionalConditions] = "no additional Information"
    }
}


