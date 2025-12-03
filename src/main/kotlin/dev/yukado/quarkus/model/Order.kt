package dev.yukado.quarkus.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order : PanacheEntity() {

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    lateinit var user: User

    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var products: MutableList<Product> = mutableListOf()

    @Column(nullable = false)
    var total: Double = 0.0

    @Column(nullable = false)
    var shipped: Boolean = false

    @Column(nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
}
