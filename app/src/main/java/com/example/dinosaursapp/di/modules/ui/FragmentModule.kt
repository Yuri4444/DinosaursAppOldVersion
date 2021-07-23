package com.example.dinosaursapp.di.modules.ui

import com.example.dinosaursapp.ui.screen.air.AirFragment
import com.example.dinosaursapp.ui.screen.aqua.AquaFragment
import com.example.dinosaursapp.ui.screen.land.LandFragment
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
}