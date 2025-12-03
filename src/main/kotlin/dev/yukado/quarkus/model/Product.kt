package dev.yukado.quarkus.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "products")
class Product : PanacheEntity() {

    @Column(nullable = false)
    lateinit var name: String

    @Column(columnDefinition = "TEXT")
    var description: String? = null

    @Column(nullable = false)
    var price: Double = 0.0

    @Column(nullable = false)
    lateinit var currency: String // '€', 'USD', 'GBP'

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_tags", joinColumns = [JoinColumn(name = "product_id")])
    @Column(name = "tag")
    var tags: MutableSet<String> = mutableSetOf()

    @Column(nullable = false)
    var available: Boolean = true

    @Column(nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
}
