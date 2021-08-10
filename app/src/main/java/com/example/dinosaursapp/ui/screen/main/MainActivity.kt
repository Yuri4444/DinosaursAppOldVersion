package com.example.dinosaursapp.ui.screen.main

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbsActivity<MainViewModel>() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        provideBottomNavigation()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun provideBottomNavigation() {

        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainLandFragment,
                R.id.aquaFragment,
                R.id.airFragment
            )
        )
        bottomNavigation.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainLandFragment -> setPageColor(R.color.greenDark, R.color.greenLight)
                R.id.aquaFragment -> setPageColor(R.color.blueDark, R.color.blueLight)
                R.id.airFragment -> setPageColor(R.color.redDark, R.color.redLight)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun setPageColor(color: Int, colorBar: Int) {
        val window: Window = this.window
        window.statusBarColor = this.resources.getColor(color, theme)
        window.navigationBarColor = this.resources.getColor(color, theme)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(colorBar, theme)))
        bottomNavigation.setBackgroundColor(resources.getColor(colorBar, theme))
    }

    override fun provideLayoutId() = R.layout.activity_main

    override fun provideViewModelClass() = MainViewModel::class

}