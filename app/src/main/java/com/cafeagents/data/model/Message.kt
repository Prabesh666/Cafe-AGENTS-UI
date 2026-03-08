package com.cafeagents.data.model

data class Message(
    val id: String,
    val text: String,
    val senderId: String,
    val timestamp: Long,
    val isFromUser: Boolean
)
