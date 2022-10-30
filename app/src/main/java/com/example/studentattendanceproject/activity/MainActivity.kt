package com.example.studentattendanceproject.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.ActivityMainBinding
import com.example.studentattendanceproject.helper.BottomAppBar
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.ATTENDANCE
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.HOME
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.PROFILE
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.REPORT

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        initListener()
    }

    private fun initListener() {

        mBinding?.bottomNavBar?.cslHome?.setOnClickListener {
            mBinding?.let { BottomAppBar.selectedState(HOME,it) }
        }

        mBinding?.bottomNavBar?.cslAttendance?.setOnClickListener {
            mBinding?.let { BottomAppBar.selectedState(ATTENDANCE,it) }
        }

        mBinding?.bottomNavBar?.cslReport?.setOnClickListener {
            mBinding?.let { BottomAppBar.selectedState(REPORT,it) }
        }

        mBinding?.bottomNavBar?.cslProfile?.setOnClickListener {
            mBinding?.let { BottomAppBar.selectedState(PROFILE,it) }
        }
    }
}