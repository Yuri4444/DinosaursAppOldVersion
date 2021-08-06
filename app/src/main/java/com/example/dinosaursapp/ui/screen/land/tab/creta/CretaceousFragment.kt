package com.example.dinosaursapp.ui.screen.land.tab.creta

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import com.example.dinosaursapp.ui.screen.details.DetailActivity
import kotlinx.android.synthetic.main.fragment_cretaceous.*

class CretaceousFragment : AbsFragment<CretaceousViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext()) { _, item ->
            startActivity(DetailActivity.open(requireContext(), item))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCretaceous.adapter = adapter

        viewModel?.livedata?.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        viewModel?.fetchData()

    }

    override fun provideLayoutId() = R.layout.fragment_cretaceous

    override fun provideViewModelClass() = CretaceousViewModel::class
}