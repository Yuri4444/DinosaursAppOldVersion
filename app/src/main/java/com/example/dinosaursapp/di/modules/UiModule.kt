package com.example.dinosaursapp.di.modules

import com.example.dinosaursapp.di.modules.ui.ActivityModule
import com.example.dinosaursapp.di.modules.ui.FragmentModule
import com.example.dinosaursapp.di.modules.ui.ViewModelModule
import dagger.Module

@Module(
    includes = [
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class
    ]
)
class UiModule