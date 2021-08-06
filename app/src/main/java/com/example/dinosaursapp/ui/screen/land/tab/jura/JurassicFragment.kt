package com.example.dinosaursapp.ui.screen.land.tab.jura

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import com.example.dinosaursapp.ui.screen.details.DetailActivity
import com.example.dinosaursapp.utils.isFirstVisible
import com.example.dinosaursapp.utils.isLastVisible
import kotlinx.android.synthetic.main.fragment_jurassic.*

class JurassicFragment : AbsFragment<JurassicViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext()) { _, item ->
            startActivity(DetailActivity.open(requireContext(), item))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvJurassic.adapter = adapter

        viewModel?.livedata?.observe(viewLifecycleOwner, { list ->
            adapter.setData(list)

            fabJurassic.setOnClickListener {
                if (rvJurassic.isFirstVisible()) {
                    fabJurassic.setImageResource(R.drawable.ic_arrow_up)
                    rvJurassic.smoothScrollToPosition(list.lastIndex)
                }
                if (rvJurassic.isLastVisible()) {
                    fabJurassic.setImageResource(R.drawable.ic_arrow_down)
                    rvJurassic.smoothScrollToPosition(list.lastIndex - list.lastIndex)
                }

            }
        })

        viewModel?.fetchData()

    }

    override fun provideLayoutId() = R.layout.fragment_jurassic

    override fun provideViewModelClass() = JurassicViewModel::class
}