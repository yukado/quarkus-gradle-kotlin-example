package dev.yukado.quarkus.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(i: Int, email1: String, string: String) : PanacheEntity() {

    @Column(nullable = false, unique = true)
    lateinit var username: String

    @Column(nullable = false, unique = true)
    lateinit var email: String

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "role")
    var roles: MutableSet<String> = mutableSetOf()

    @Column(nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    var isAdmin: Boolean = false
        get() = roles.contains("admin")
}
