package dev.yukado.quarkus.dto

import java.time.LocalDateTime

data class UserDTO(
    val id: Long?,
    val username: String,
    val email: String,
    val roles: List<String>,
    val isAdmin: Boolean,
    val createdAt: LocalDateTime
)
