package dev.yukado.quarkus.dto

import java.time.LocalDateTime

data class ProductDTO(
    val id: Long?,
    val name: String,
    val description: String?,
    val price: Double,
    val currency: String, // '€', 'USD', 'GBP'
    val tags: List<String>,
    val available: Boolean,
    val createdAt: LocalDateTime
)
