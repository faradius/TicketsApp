package com.developerscracks.ticketsapp.domain.use_cases.userAuth

import com.developerscracks.ticketsapp.data.repository.userAuth.UserAuthRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(private val userAuthRespository: UserAuthRepository) {
    operator fun invoke() = userAuthRespository.currentUser
}