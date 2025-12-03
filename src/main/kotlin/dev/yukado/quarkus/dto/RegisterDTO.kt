package dev.yukado.quarkus.dto

data class RegisterDTO(
    val email: String,
    val password: String,
    val role: String = "user" // Standardrolle
)
