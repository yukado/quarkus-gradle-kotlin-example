package dev.yukado.quarkus.dto

// Datenklasse für Login-Anfrage
data class LoginDTO(
    val email: String,
    val password: String
)