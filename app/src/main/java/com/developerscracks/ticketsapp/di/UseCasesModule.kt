package com.developerscracks.ticketsapp.di

import com.developerscracks.ticketsapp.data.repository.UserAuthRepository
import com.developerscracks.ticketsapp.domain.use_cases.AuthUseCases
import com.developerscracks.ticketsapp.domain.use_cases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideAuthUseCases(repository: UserAuthRepository) = AuthUseCases(
        login = LoginUseCase(repository)
    )
}