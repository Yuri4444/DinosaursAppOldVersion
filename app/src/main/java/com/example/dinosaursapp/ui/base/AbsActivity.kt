package com.example.dinosaursapp.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModel

abstract class AbsActivity<VM : ViewModel> : AbsDaggerActivity<VM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
    }


    abstract fun provideLayoutId(): Int

}