package com.example.dinosaursapp.di.modules.ui

import com.example.dinosaursapp.ui.screen.characters.LandFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeCharactersFragment() : LandFragment
}