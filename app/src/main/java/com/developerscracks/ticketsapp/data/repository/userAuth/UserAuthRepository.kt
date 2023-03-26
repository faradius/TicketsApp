package com.developerscracks.ticketsapp.data.repository.userAuth

import com.developerscracks.ticketsapp.core.Response
import com.google.firebase.auth.FirebaseUser

interface UserAuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email:String, password: String): Response<FirebaseUser>
}