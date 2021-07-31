package com.example.dinosaursapp.ui.screen.aqua

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import kotlinx.android.synthetic.main.fragment_aqua.*

class AquaFragment : AbsFragment<AquaViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext(), {

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAqua.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        viewModel?.fetch()
    }

    override fun provideLayoutId() = R.layout.fragment_aqua

    override fun provideViewModelClass() = AquaViewModel::class
}