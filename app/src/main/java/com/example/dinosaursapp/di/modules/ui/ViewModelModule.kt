package com.example.dinosaursapp.di.modules.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dinosaursapp.di.ViewModelFactory
import com.example.dinosaursapp.di.ViewModelKey
import com.example.dinosaursapp.ui.screen.air.AirViewModel
import com.example.dinosaursapp.ui.screen.aqua.AquaViewModel
import com.example.dinosaursapp.ui.screen.land.main.MainLandViewModel
import com.example.dinosaursapp.ui.screen.land.tab.creta.CretaceousViewModel
import com.example.dinosaursapp.ui.screen.land.tab.jura.JurassicViewModel
import com.example.dinosaursapp.ui.screen.land.tab.trias.TriassicViewModel
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
    @ViewModelKey(AquaViewModel::class)
    abstract fun provideAquaViewModel(viewModel: AquaViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AirViewModel::class)
    abstract fun provideAirViewModel(viewModel: AirViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainLandViewModel::class)
    abstract fun provideMainLandViewModel(viewModel : MainLandViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CretaceousViewModel::class)
    abstract fun provideCretaceousViewModel(viewModel : CretaceousViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(JurassicViewModel::class)
    abstract fun provideJurassicViewModel(viewModel : JurassicViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TriassicViewModel::class)
    abstract fun provideTriassicViewModel(viewModel : TriassicViewModel): ViewModel
}