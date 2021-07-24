package com.example.dinosaursapp.ui.screen.land

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.screen.land.tab.creta.CretaceousFragment
import com.example.dinosaursapp.ui.screen.land.tab.jura.JurassicFragment
import com.example.dinosaursapp.ui.screen.land.tab.trias.TriassicFragment

class TabAdapter(fm: FragmentManager, var context: Context) : FragmentStatePagerAdapter(fm) {

    private val items = listOf<Fragment>(
        TriassicFragment(),
        JurassicFragment(),
        CretaceousFragment()
    )

    override fun getItem(position: Int) = items[position]

    override fun getCount() = items.size

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> context.getString(R.string.triassic)
        1 -> context.getString(R.string.jurassic)
        2 -> context.getString(R.string.cretaceous)

        else -> throw IllegalStateException("Cannot find title!")
    }
}