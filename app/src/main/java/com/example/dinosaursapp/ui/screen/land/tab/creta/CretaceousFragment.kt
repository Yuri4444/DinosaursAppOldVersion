package com.example.dinosaursapp.ui.screen.land.tab.creta

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.BaseAdapter
import com.example.dinosaursapp.ui.screen.details.DetailActivity
import com.example.dinosaursapp.utils.isFirstVisible
import com.example.dinosaursapp.utils.isLastVisible
import kotlinx.android.synthetic.main.fragment_aqua.*
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

        viewModel?.liveData?.observe(viewLifecycleOwner, { list ->
            adapter.setData(list)

            fabCretaceous.setOnClickListener {
                if (rvCretaceous.isFirstVisible()) {
                    fabCretaceous.setImageResource(R.drawable.ic_arrow_up)
                    rvCretaceous.smoothScrollToPosition(list.lastIndex)
                }
                if (rvCretaceous.isLastVisible()) {
                    fabCretaceous.setImageResource(R.drawable.ic_arrow_down)
                    rvCretaceous.smoothScrollToPosition(list.lastIndex - list.lastIndex)
                }

            }
        })

        viewModel?.fetch()

        setHasOptionsMenu(true)

    }

    override fun provideLayoutId() = R.layout.fragment_cretaceous
    override fun provideViewModelClass() = CretaceousViewModel::class

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    rvCretaceous.scrollToPosition(0)
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