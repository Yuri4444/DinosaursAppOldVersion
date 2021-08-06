package com.example.dinosaursapp.ui.screen.land.tab.trias

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import com.example.dinosaursapp.ui.screen.details.DetailActivity
import com.example.dinosaursapp.utils.isFirstVisible
import com.example.dinosaursapp.utils.isLastVisible
import kotlinx.android.synthetic.main.fragment_triassic.*

class TriassicFragment : AbsFragment<TriassicViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext()) { _, item ->
            startActivity(DetailActivity.open(requireContext(), item))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTriassic.adapter = adapter

        viewModel?.livedata?.observe(viewLifecycleOwner, { list ->
            adapter.setData(list)

            fabTriassic.setOnClickListener {
                if (rvTriassic.isFirstVisible()) {
                    fabTriassic.setImageResource(R.drawable.ic_arrow_up)
                    rvTriassic.smoothScrollToPosition(list.lastIndex)
                }
                if (rvTriassic.isLastVisible()) {
                    fabTriassic.setImageResource(R.drawable.ic_arrow_down)
                    rvTriassic.smoothScrollToPosition(list.lastIndex - list.lastIndex)
                }

            }
        })

        viewModel?.fetchData()

    }

    override fun provideLayoutId() = R.layout.fragment_triassic

    override fun provideViewModelClass() = TriassicViewModel::class
}