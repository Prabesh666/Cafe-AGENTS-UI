package com.cafeagents.data.model

data class Order(
    val id: String,
    val userId: String,
    val items: List<String>,
    val totalAmount: Double,
    val status: String
)
