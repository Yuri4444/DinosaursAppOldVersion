package com.example.dinosaursapp.ui.screen.aqua

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import com.example.dinosaursapp.ui.screen.details.DetailActivity
import com.example.dinosaursapp.utils.isFirstVisible
import com.example.dinosaursapp.utils.isLastVisible
import kotlinx.android.synthetic.main.fragment_aqua.*

class AquaFragment : AbsFragment<AquaViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext()) { _, item ->
            startActivity(DetailActivity.open(requireContext(), item))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAqua.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, { list ->
            adapter.setData(list)

            fabAqua.setOnClickListener {
                if (rvAqua.isFirstVisible()) {
                    fabAqua.setImageResource(R.drawable.ic_arrow_up)
                    rvAqua.smoothScrollToPosition(list.lastIndex)
                }
                if (rvAqua.isLastVisible()) {
                    fabAqua.setImageResource(R.drawable.ic_arrow_down)
                    rvAqua.smoothScrollToPosition(list.lastIndex - list.lastIndex)
                }

            }
        })

        viewModel?.fetch()
    }

    override fun provideLayoutId() = R.layout.fragment_aqua

    override fun provideViewModelClass() = AquaViewModel::class
}