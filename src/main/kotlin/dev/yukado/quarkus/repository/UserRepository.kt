package dev.yukado.quarkus.repository

import dev.yukado.quarkus.model.User
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository : PanacheRepository<User> {

    fun findByUsername(username: String): User? =
        find("username", username).firstResult()

    fun findByEmail(email: String): User? =
        find("email", email).firstResult()

    fun findAdmins(): List<User> =
        listAll().filter { it.roles.contains("admin") }

    fun existsByEmail(email: String): Boolean =
        count("email", email) > 0

    fun deleteByUsername(username: String): Boolean =
        delete("username", username) > 0
}
