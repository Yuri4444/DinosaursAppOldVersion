package com.example.dinosaursapp.di.modules.ui

import com.example.dinosaursapp.ui.screen.air.AirFragment
import com.example.dinosaursapp.ui.screen.aqua.AquaFragment
import com.example.dinosaursapp.ui.screen.land.LandFragment
import com.example.dinosaursapp.ui.screen.land.main.MainLandFragment
import com.example.dinosaursapp.ui.screen.land.tab.creta.CretaceousFragment
import com.example.dinosaursapp.ui.screen.land.tab.jura.JurassicFragment
import com.example.dinosaursapp.ui.screen.land.tab.trias.TriassicFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeLandFragment() : LandFragment

    @ContributesAndroidInjector
    internal abstract fun contributeAquaFragment() : AquaFragment

    @ContributesAndroidInjector
    internal abstract fun contributeAirFragment() : AirFragment

    @ContributesAndroidInjector
    internal abstract fun contributeMainLandFragment() : MainLandFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCretaceousFragment() : CretaceousFragment

    @ContributesAndroidInjector
    internal abstract fun contributeJurassicFragment() : JurassicFragment

    @ContributesAndroidInjector
    internal abstract fun contributeTriassicFragment() : TriassicFragment
}