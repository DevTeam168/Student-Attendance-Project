package com.example.studentattendanceproject.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)


    }
}