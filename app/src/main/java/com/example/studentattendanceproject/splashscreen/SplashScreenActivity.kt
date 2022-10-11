package com.example.studentattendanceproject.splashscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.SplashScreenActivityBinding

class SplashScreenActivity: AppCompatActivity() {

    private var mBinding: SplashScreenActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.splash_screen_activity)
    }

}