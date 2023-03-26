package com.developerscracks.ticketsapp.data.repository

import com.developerscracks.ticketsapp.core.Response
import com.google.firebase.auth.FirebaseUser

interface UserAuthRepository {
    suspend fun login(email:String, password: String): Response<FirebaseUser>
}