package com.example.dinosaursapp.ui.screen.aqua

import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment

class AquaFragment : AbsFragment<AquaViewModel>() {

    override fun provideLayoutId() = R.layout.fragment_aqua

    override fun provideViewModelClass() = AquaViewModel::class
}