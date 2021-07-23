package com.example.dinosaursapp.ui.screen.air

import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment

class AirFragment : AbsFragment<AirViewModel>() {

    override fun provideLayoutId() = R.layout.fragment_air

    override fun provideViewModelClass() = AirViewModel::class
}