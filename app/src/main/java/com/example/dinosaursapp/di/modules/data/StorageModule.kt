package com.example.dinosaursapp.di.modules.data

import android.content.Context
import com.example.dinosaursapp.storage.shared.SharedMemory
import com.example.dinosaursapp.storage.shared.PrefStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun providesSharedPreferences(context: Context): SharedMemory = PrefStorage(context)

}