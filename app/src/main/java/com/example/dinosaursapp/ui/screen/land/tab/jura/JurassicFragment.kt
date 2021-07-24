package com.example.dinosaursapp.ui.screen.land.tab.jura

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import kotlinx.android.synthetic.main.fragment_jurassic.*

class JurassicFragment : AbsFragment<JurassicViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvJurassic.adapter = adapter

        viewModel?.livedata?.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        viewModel?.fetchData()

    }

    override fun provideLayoutId() = R.layout.fragment_jurassic

    override fun provideViewModelClass() = JurassicViewModel::class
}