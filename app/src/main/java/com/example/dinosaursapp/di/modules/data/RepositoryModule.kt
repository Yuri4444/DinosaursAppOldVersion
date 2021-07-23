package com.example.dinosaursapp.di.modules.data

import com.example.dinosaursapp.data.network.Api
import com.example.dinosaursapp.data.repository.impl.NetRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNetRepository(api: Api) = NetRepositoryImpl(api)

}