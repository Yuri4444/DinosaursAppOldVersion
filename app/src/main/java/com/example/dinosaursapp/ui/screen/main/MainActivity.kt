package com.example.dinosaursapp.ui.screen.main

import android.os.Bundle
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsActivity
import com.example.dinosaursapp.ui.screen.characters.LandFragment

class MainActivity : AbsActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.flMain, LandFragment())
            .commit()
    }

    override fun provideLayoutId() = R.layout.activity_main

    override fun provideViewModelClass() = MainViewModel::class

}