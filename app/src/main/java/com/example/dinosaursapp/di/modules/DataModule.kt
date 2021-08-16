package com.example.dinosaursapp.di.modules

import android.content.Context
import com.example.dinosaursapp.AppApplication
import com.example.dinosaursapp.di.modules.data.NetworkModule
import com.example.dinosaursapp.di.modules.data.RepositoryModule
import com.example.dinosaursapp.di.modules.data.StorageModule
import com.example.dinosaursapp.di.modules.data.UseCaseModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        StorageModule::class
    ]
)
class DataModule {

    @Singleton
    @Provides
    fun provideContext(application: AppApplication): Context =
        application.applicationContext
}