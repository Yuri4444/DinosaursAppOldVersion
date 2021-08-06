package com.example.dinosaursapp.ui.screen.air

import android.os.Bundle
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import com.example.dinosaursapp.ui.screen.details.DetailActivity
import com.example.dinosaursapp.utils.isFirstVisible
import com.example.dinosaursapp.utils.isLastVisible
import kotlinx.android.synthetic.main.fragment_air.*

class AirFragment : AbsFragment<AirViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext()) { _, item ->
            startActivity(DetailActivity.open(requireContext(), item))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAir.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, { list ->
            adapter.setData(list)

            fabAir.setOnClickListener {
                if (rvAir.isFirstVisible()) {
                    fabAir.setImageResource(R.drawable.ic_arrow_up)
                    rvAir.smoothScrollToPosition(list.lastIndex)
                }
                if (rvAir.isLastVisible()) {
                    fabAir.setImageResource(R.drawable.ic_arrow_down)
                    rvAir.smoothScrollToPosition(list.lastIndex - list.lastIndex)
                }

            }
        })

        viewModel?.fetch()
    }

    override fun provideLayoutId() = R.layout.fragment_air

    override fun provideViewModelClass() = AirViewModel::class
}