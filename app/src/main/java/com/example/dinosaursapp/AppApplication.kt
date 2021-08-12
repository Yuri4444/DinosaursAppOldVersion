package com.example.dinosaursapp

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AppApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this@AppApplication)
        FirebaseAnalytics.getInstance(this)
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build().apply {
                inject(this@AppApplication)
            }
    }

    override fun androidInjector() = androidInjector

}