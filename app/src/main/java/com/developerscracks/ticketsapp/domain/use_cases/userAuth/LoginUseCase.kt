package com.developerscracks.ticketsapp.domain.use_cases.userAuth

import com.developerscracks.ticketsapp.data.repository.userAuth.UserAuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val userAuthRepository: UserAuthRepository) {
    suspend operator fun invoke(email: String, password:String) = userAuthRepository.login(email, password)
}