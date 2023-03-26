package com.developerscracks.ticketsapp.di

import com.developerscracks.ticketsapp.data.network.datasource.ticket.TicketDataSource
import com.developerscracks.ticketsapp.data.network.datasource.ticket.TicketDataSourceImpl
import com.developerscracks.ticketsapp.data.repository.ticket.TicketRepository
import com.developerscracks.ticketsapp.data.repository.ticket.TicketRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TicketModule {

    @Binds
    abstract fun bindsTicketDataSource(impl: TicketDataSourceImpl): TicketDataSource

    @Binds
    abstract fun bindsTicketRepository(impl: TicketRepositoryImpl): TicketRepository

}