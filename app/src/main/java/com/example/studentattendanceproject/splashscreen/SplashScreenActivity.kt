package com.example.studentattendanceproject.splashscreen

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.studentattendanceproject.MainActivity
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.SplashScreenActivityBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity: AppCompatActivity() {

    private var mBinding: SplashScreenActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.splash_screen_activity)
        mBinding?.ivSplashScreen?.let { Glide.with(this).load(R.mipmap.astronaut).centerCrop().into(it) }
        supportActionBar?.hide()
        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            overridePendingTransition(R.anim.slide_down, R.anim.slide_up)
            finishAffinity()

        }

    }

    override fun onBackPressed() {
    }

}