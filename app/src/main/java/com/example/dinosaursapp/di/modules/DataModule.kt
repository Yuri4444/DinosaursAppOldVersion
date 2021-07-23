package com.example.dinosaursapp.di.modules

import com.example.dinosaursapp.di.modules.data.NetworkModule
import com.example.dinosaursapp.di.modules.data.RepositoryModule
import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        RepositoryModule::class
    ]
)
class DataModule