package com.developerscracks.ticketsapp.domain.use_cases

import com.developerscracks.ticketsapp.data.repository.UserAuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val userAuthRepository: UserAuthRepository) {
    suspend operator fun invoke(email: String, password:String) = userAuthRepository.login(email, password)
}