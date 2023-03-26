package com.developerscracks.ticketsapp.di

import com.developerscracks.ticketsapp.data.network.datasource.userAuth.UserAuthDataSource
import com.developerscracks.ticketsapp.data.network.datasource.userAuth.UserAuthDataSourceImpl
import com.developerscracks.ticketsapp.data.repository.UserAuthRepository
import com.developerscracks.ticketsapp.data.repository.UserAuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserAuthModule {

    @Binds
    abstract fun bindsUserAuthDataSource(impl: UserAuthDataSourceImpl): UserAuthDataSource

    @Binds
    abstract fun bindsUserAuthRepository(impl: UserAuthRepositoryImpl): UserAuthRepository
}