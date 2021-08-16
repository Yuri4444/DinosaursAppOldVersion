package com.example.dinosaursapp.ui.screen.land.main

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.land.TabAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_main_land.*

class MainLandFragment : AbsFragment<MainLandViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabAdapter = TabAdapter(childFragmentManager, requireContext())
        viewPager.adapter = tabAdapter

        tabLayout.setupWithViewPager(viewPager)

    }

    override fun provideLayoutId() = R.layout.fragment_main_land

    override fun provideViewModelClass() = MainLandViewModel::class

}