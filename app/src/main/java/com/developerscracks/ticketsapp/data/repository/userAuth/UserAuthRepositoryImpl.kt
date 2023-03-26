package com.developerscracks.ticketsapp.data.repository.userAuth

import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.datasource.userAuth.UserAuthDataSource
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class UserAuthRepositoryImpl @Inject constructor(private val userAuthDataSource: UserAuthDataSource):
    UserAuthRepository {

    override val currentUser: FirebaseUser?
        get() = userAuthDataSource.currentUser

    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
        return userAuthDataSource.login(email, password)
    }
}