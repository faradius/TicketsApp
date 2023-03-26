package com.developerscracks.ticketsapp.data.network.datasource.userAuth

import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserAuthDataSourceImpl @Inject constructor (private val firebaseAuth: FirebaseAuth): UserAuthDataSource{
    override val currentUser: FirebaseUser? get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Response.Success(result.user!!)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }


}