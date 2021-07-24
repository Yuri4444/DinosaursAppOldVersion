package com.example.dinosaursapp.ui.screen.land.tab.trias

import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment


class TriassicFragment : AbsFragment<TriassicViewModel>() {

    override fun provideLayoutId() = R.layout.fragment_triassic

    override fun provideViewModelClass() = TriassicViewModel::class
}