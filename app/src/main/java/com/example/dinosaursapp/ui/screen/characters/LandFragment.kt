package com.example.dinosaursapp.ui.screen.characters

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsFragment
import com.example.dinosaursapp.ui.screen.characters.adapter.BaseAdapter
import kotlinx.android.synthetic.main.fragment_common.*
import kotlin.reflect.KClass

class LandFragment : AbsFragment<LandViewModel>() {

    private val adapter by lazy {
        BaseAdapter(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCommon.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, {
            adapter.setData(it)
            Log.e("TAG", it.toString())
        })

        viewModel?.fetch()
    }


    override fun provideLayoutId() = R.layout.fragment_common

    override fun provideViewModelClass(): KClass<LandViewModel> = LandViewModel::class
}