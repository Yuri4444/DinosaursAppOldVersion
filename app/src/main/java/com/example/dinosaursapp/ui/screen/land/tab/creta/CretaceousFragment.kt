package com.example.dinosaursapp.ui.screen.land.tab.creta

import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment

class CretaceousFragment : AbsFragment<CretaceousViewModel>() {

    override fun provideLayoutId() = R.layout.fragment_cretaceous

    override fun provideViewModelClass() = CretaceousViewModel::class
}