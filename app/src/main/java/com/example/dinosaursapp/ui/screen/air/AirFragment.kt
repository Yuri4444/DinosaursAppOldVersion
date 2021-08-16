package com.example.dinosaursapp.ui.screen.air

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import com.example.dinosaursapp.ui.screen.details.DetailActivity
import com.example.dinosaursapp.utils.gone
import com.example.dinosaursapp.utils.isFirstVisible
import com.example.dinosaursapp.utils.isLastVisible
import com.example.dinosaursapp.utils.visible
import kotlinx.android.synthetic.main.fragment_air.*
import kotlinx.android.synthetic.main.shimmer_layout.*

class AirFragment : AbsFragment<AirViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext()) { _, item ->
            startActivity(DetailActivity.open(requireContext(), item))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabChangeMode.setOnClickListener {

            if (prefStorage.getStateMainList()) {
                adapter.isBigModeRecyclerView(false)
                rvAir.adapter = adapter
                fabChangeMode.setImageDrawable(resources.getDrawable(R.drawable.ic_mode_big))
                prefStorage.saveStateMainList(false)
            } else {
                adapter.isBigModeRecyclerView(true)
                rvAir.adapter = adapter
                fabChangeMode.setImageDrawable(resources.getDrawable(R.drawable.ic_mode_little))
                prefStorage.saveStateMainList(true)
            }
        }

        when (prefStorage.getStateMainList()) {
            true -> {
                shimmerLayoutBig.startShimmerAnimation()
                shimmerLayoutBig.visible()
                adapter.isBigModeRecyclerView(true)
            }
            false -> {
                shimmerLayoutLittle.startShimmerAnimation()
                shimmerLayoutLittle.visible()
                adapter.isBigModeRecyclerView(false)
            }
        }

        rvAir.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, { list ->
            adapter.setData(list)

            shimmerLayoutBig.gone()
            shimmerLayoutLittle.gone()

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

        setHasOptionsMenu(true)
    }

    override fun provideLayoutId() = R.layout.fragment_air

    override fun provideViewModelClass() = AirViewModel::class

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    rvAir.scrollToPosition(0)
                    viewModel?.searchItem(query)
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrBlank()) {
                    viewModel?.searchItem(newText)
                } else {
                    viewModel?.fetch()
                }
                return true
            }

        })
    }

}