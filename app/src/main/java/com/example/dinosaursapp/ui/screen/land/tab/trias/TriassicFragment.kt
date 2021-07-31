package com.example.dinosaursapp.ui.screen.land.tab.trias

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import kotlinx.android.synthetic.main.fragment_triassic.*


class TriassicFragment : AbsFragment<TriassicViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext(), {

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTriassic.adapter = adapter

        viewModel?.livedata?.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        viewModel?.fetchData()

    }

    override fun provideLayoutId() = R.layout.fragment_triassic

    override fun provideViewModelClass() = TriassicViewModel::class
}