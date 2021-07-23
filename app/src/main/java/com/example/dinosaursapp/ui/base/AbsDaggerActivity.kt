package com.example.dinosaursapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class AbsDaggerActivity<VM : ViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    var viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        AndroidInjection.inject(this)

        provideViewModelClass()?.run {
            viewModel = ViewModelProvider(
                this@AbsDaggerActivity,
                viewModelFactory
            ).get(this.java)
        }
    }

    abstract fun provideViewModelClass(): KClass<VM>?
}