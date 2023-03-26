package com.developerscracks.ticketsapp.di

import com.developerscracks.ticketsapp.data.repository.ticket.TicketRepository
import com.developerscracks.ticketsapp.data.repository.userAuth.UserAuthRepository
import com.developerscracks.ticketsapp.domain.use_cases.ticket.CreateTicketUseCase
import com.developerscracks.ticketsapp.domain.use_cases.ticket.TicketUseCases
import com.developerscracks.ticketsapp.domain.use_cases.userAuth.AuthUseCases
import com.developerscracks.ticketsapp.domain.use_cases.userAuth.GetCurrentUserUseCase
import com.developerscracks.ticketsapp.domain.use_cases.userAuth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideAuthUseCases(repository: UserAuthRepository) = AuthUseCases(
        login = LoginUseCase(repository),
        getCurrentUser = GetCurrentUserUseCase(repository)
    )

    @Provides
    fun provideTicketUseCases(repository: TicketRepository) = TicketUseCases(
        createTicket = CreateTicketUseCase(repository)
    )
}