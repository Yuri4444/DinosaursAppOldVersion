package com.example.dinosaursapp.di.modules.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dinosaursapp.di.ViewModelFactory
import com.example.dinosaursapp.di.ViewModelKey
import com.example.dinosaursapp.ui.screen.characters.LandViewModel
import com.example.dinosaursapp.ui.screen.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LandViewModel::class)
    abstract fun provideCharactersViewModel(viewModel: LandViewModel): ViewModel
}