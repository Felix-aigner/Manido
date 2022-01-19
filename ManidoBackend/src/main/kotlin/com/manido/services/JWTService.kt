package com.manido.services

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.manido.dtos.Role
import io.ktor.auth.jwt.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


class JWTService {
    private val algorithm = Algorithm.HMAC256("secret")
    private val issuer = "http://0.0.0.0:8080/"

    fun tokenVerifier(): JWTVerifier =  JWT
        .require(algorithm)
        .withIssuer(issuer)
        .build()

    fun createToken(username: String, role: Role): String =
        JWT.create()
            .withIssuer(issuer)
            .withSubject(username)
            .withIssuedAt(Date())
            .withExpiresAt(
                Date.from(
                LocalDateTime.now().plusHours(8).atZone(
                    ZoneId.systemDefault()
                ).toInstant()
            ))
            .withClaim("username", username)
            .withClaim("role", role.toString())
            .sign(algorithm)

    fun validateToken(token: JWTCredential): JWTPrincipal? =
        token.payload.claims.let { claims ->
            if(
                claims.contains("username") &&
                claims.contains("role")
            ) JWTPrincipal(token.payload)
            else null
        }
}
