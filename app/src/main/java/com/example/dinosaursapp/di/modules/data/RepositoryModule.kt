package com.example.dinosaursapp.di.modules.data

import com.example.dinosaursapp.data.network.Api
import com.example.dinosaursapp.data.repository.NetRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(api : Api) = NetRepository(api)

}