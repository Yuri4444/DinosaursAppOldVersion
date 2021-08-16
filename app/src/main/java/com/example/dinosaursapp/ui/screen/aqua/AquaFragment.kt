package com.example.dinosaursapp.ui.screen.aqua

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
import kotlinx.android.synthetic.main.fragment_aqua.*
import kotlinx.android.synthetic.main.shimmer_layout.*

class AquaFragment : AbsFragment<AquaViewModel>() {

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
                rvAqua.adapter = adapter
                fabChangeMode.setImageDrawable(resources.getDrawable(R.drawable.ic_mode_big))
                prefStorage.saveStateMainList(false)
            } else {
                adapter.isBigModeRecyclerView(true)
                rvAqua.adapter = adapter
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

        rvAqua.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, { list ->
            adapter.setData(list)

            shimmerLayoutBig.gone()
            shimmerLayoutLittle.gone()

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

        setHasOptionsMenu(true)
    }

    override fun provideLayoutId() = R.layout.fragment_aqua
    override fun provideViewModelClass() = AquaViewModel::class

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    rvAqua.scrollToPosition(0)
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