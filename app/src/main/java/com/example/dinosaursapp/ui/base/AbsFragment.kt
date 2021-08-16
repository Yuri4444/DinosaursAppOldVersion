package com.example.dinosaursapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dinosaursapp.storage.shared.PrefStorage
import javax.inject.Inject

abstract class AbsFragment<VM: AbsViewModel> : AbsDaggerFragment<VM>() {

    @Inject
    lateinit var prefStorage: PrefStorage

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideLayoutId(), container, false)
    }

    abstract fun provideLayoutId() : Int
}