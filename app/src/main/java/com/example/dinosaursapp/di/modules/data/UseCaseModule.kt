package com.example.dinosaursapp.di.modules.data

import android.content.Context
import com.example.dinosaursapp.data.repository.NetRepository
import com.example.dinosaursapp.domain.usecase.air.AirUseCase
import com.example.dinosaursapp.domain.usecase.aqua.AquaUseCase
import com.example.dinosaursapp.domain.usecase.land.LandUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideLandUseCase(context: Context, netRepository: NetRepository) =
        LandUseCase(context, netRepository)

    @Provides
    fun provideAquaUseCase(context: Context, netRepository: NetRepository) =
        AquaUseCase(context, netRepository)

    @Provides
    fun provideAirUseCase(context: Context, netRepository: NetRepository) =
        AirUseCase(context, netRepository)
}