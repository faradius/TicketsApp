package com.developerscracks.ticketsapp.data.network.datasource.userAuth

import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.model.User
import com.google.firebase.auth.FirebaseUser

interface UserAuthDataSource {

    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): Response<FirebaseUser>
//    suspend fun signUp(user: User): Response<FirebaseUser>
//    fun logout()

}