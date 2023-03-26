package com.developerscracks.ticketsapp.domain.use_cases.userAuth

data class AuthUseCases(
    val login: LoginUseCase,
    val getCurrentUser: GetCurrentUserUseCase
)