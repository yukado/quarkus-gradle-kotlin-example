package dev.yukado.quarkus.dto

import java.time.LocalDateTime

data class OrderDTO(
    val id: Long?,
    val userId: Long?,
    val productIds: List<Long>,
    val total: Double,
    val shipped: Boolean,
    val createdAt: LocalDateTime
)
