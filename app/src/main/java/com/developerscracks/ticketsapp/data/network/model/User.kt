package com.developerscracks.ticketsapp.data.network.model

data class User(
    val id: String,
    val name: String,
    val userType: String,
    val email: String,
    val password: String
)
