package dev.yukado.quarkus.mapper

import dev.yukado.quarkus.dto.UserDTO
import dev.yukado.quarkus.model.User
//UserExtension.kt
fun User.toDTO(): UserDTO = UserDTO(
    id = this.id,
    username = this.username,
    email = this.email,
    roles = this.roles.toList(),
    isAdmin = this.isAdmin,
    createdAt = this.createdAt
)

fun UserDTO.toEntity(): User {
    val user = User(1, dto.email, "admin")
    user.id = this.id
    user.username = this.username
    user.email = this.email
    user.roles = this.roles.toMutableSet()
    user.isAdmin = this.isAdmin
    user.createdAt = this.createdAt
    return user
}

