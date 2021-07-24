package com.example.dinosaursapp.ui.screen.land.tab.jura

import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment

class JurassicFragment : AbsFragment<JurassicViewModel>() {

    override fun provideLayoutId() = R.layout.fragment_jurassic

    override fun provideViewModelClass() = JurassicViewModel::class
}