package com.example.dinosaursapp.ui.screen.air

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.land.adapter.BaseAdapter
import kotlinx.android.synthetic.main.fragment_air.*
import kotlinx.android.synthetic.main.fragment_land.*

class AirFragment : AbsFragment<AirViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAir.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        viewModel?.fetch()
    }

    override fun provideLayoutId() = R.layout.fragment_air

    override fun provideViewModelClass() = AirViewModel::class
}