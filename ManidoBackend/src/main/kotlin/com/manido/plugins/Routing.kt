package com.manido.plugins

import com.manido.dtos.AdvertisementDTO
import com.manido.dtos.Role
import com.manido.dtos.UserDTO
import com.manido.services.AdvertisementService
import com.manido.services.JWTService
import com.manido.services.UserService
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*


val secret = "secret"
val issuer = "http://0.0.0.0:8080/"
val audience = "http://0.0.0.0:8080/health"


fun Application.configureRouting(jwtService: JWTService, userService: UserService, advertisementService: AdvertisementService) {

    // Starting point for a Ktor app:
    routing {
        route("/api") {
            get("/") {
                call.respondText("Hello World!")
            }


            post("/login") {
                val user = call.receive<Map<String, String>>()
                userService.loginuser(user["username"] ?: "", user["password"]?: "")?.let { ret ->
                    ret.token = jwtService.createToken(ret.username, ret.role)
                    call.respond(Json.encodeToString(ret))
                }?: call.respond(HttpStatusCode.BadRequest, "invalid login data")
            }

            post("/signup") {
                val signup = call.receive<Map<String, String>>()
                val user: UserDTO = UserDTO(
                    username = signup["username"]?: "",
                    password = signup["password"]?: "",
                    email = signup["email"]?: "",
                    role = Role.valueOf(signup["role"]?.uppercase()?: ""),
                    country = signup["country"]?: "",
                    city = signup["city"]?: "",
                    postalCode = signup["postalCode"]?: "",
                    addressLine = signup["addressLine"]?: "",
                    token = ""
                )
                userService.createUser(user)
                user.token = jwtService.createToken(user.username, user.role)
                call.respond(user)
            }

            route("/advertisement") {
                get("/all") {
                    call.respond(advertisementService.retrieveAllAdvertisements())
                }

                authenticate("jwt-auth") {
                    post("/create") {
                        val advert = call.receive<AdvertisementDTO>()
                        println(advert)
                        advertisementService.createAdvertisement(advert)
                        call.respond(HttpStatusCode.OK)
                    }
                    put("/update") {

                    }
                    post("/interest"){
                        call.respond(HttpStatusCode.OK)
                    }
                }
            }

        }
    }
}
