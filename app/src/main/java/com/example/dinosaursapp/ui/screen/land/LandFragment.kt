package com.example.dinosaursapp.ui.screen.land

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.land.adapter.BaseAdapter
import kotlinx.android.synthetic.main.fragment_land.*

class LandFragment : AbsFragment<LandViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCommon.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        viewModel?.fetch()
    }


    override fun provideLayoutId() = R.layout.fragment_land

    override fun provideViewModelClass() = LandViewModel::class
}