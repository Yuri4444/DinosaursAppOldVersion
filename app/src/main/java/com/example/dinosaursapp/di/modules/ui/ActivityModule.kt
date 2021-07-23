package com.example.dinosaursapp.di.modules.ui

import com.example.dinosaursapp.ui.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity() : MainActivity

}