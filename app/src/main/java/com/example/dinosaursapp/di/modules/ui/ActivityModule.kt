package com.example.dinosaursapp.di.modules.ui

import com.example.dinosaursapp.ui.screen.details.DetailActivity
import com.example.dinosaursapp.ui.screen.main.MainActivity
import com.example.dinosaursapp.ui.screen.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity() : MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSplashActivity() : SplashActivity

    @ContributesAndroidInjector
    internal abstract fun contributeDetailActivity() : DetailActivity

}