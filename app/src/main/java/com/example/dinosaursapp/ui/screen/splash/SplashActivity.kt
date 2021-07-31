package com.example.dinosaursapp.ui.screen.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.dinosaursapp.R
import com.example.dinosaursapp.ui.base.AbsActivity
import com.example.dinosaursapp.ui.screen.main.MainActivity

class SplashActivity : AbsActivity<SplashViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed( {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }


    override fun provideLayoutId() = R.layout.activity_splash

    override fun provideViewModelClass() = SplashViewModel::class
}