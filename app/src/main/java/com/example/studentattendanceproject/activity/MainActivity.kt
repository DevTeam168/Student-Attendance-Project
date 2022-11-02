package com.example.studentattendanceproject.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.ActivityMainBinding
import com.example.studentattendanceproject.fragment.attendance.AttendanceFragment
import com.example.studentattendanceproject.fragment.home.HomeFragment
import com.example.studentattendanceproject.fragment.profile.ProfileFragment
import com.example.studentattendanceproject.fragment.report.ReportFragment
import com.example.studentattendanceproject.helper.BottomAppBar
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.ATTENDANCE
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.HOME
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.PROFILE
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.REPORT

class MainActivity : AppCompatActivity() {
    private var homeFragment: Fragment ?= null
    private var attendanceFragment: Fragment ?= null
    private var reportFragment: Fragment ?= null
    private var profileFragment: Fragment ?= null
    private var mBinding:ActivityMainBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        initialize()
        initListener()
    }

    private fun initialize() {
        //initialize fragment
        homeFragment = HomeFragment()
        attendanceFragment = AttendanceFragment()
        reportFragment = ReportFragment()
        profileFragment = ProfileFragment()
    }

    private fun initListener() {

        mBinding?.apply {
            bottomNavBar.apply {
                cslHome.setOnClickListener {
                    mBinding?.let {
                        BottomAppBar.selectedState(HOME,it)
                        homeFragment?.let { it1 ->
                            supportFragmentManager.beginTransaction().replace(R.id.main_fragment,it1).commit()
                        }
                    }
                }
                //default select on Home Fragment
                cslHome.callOnClick()

                cslAttendance.setOnClickListener {
                    mBinding?.let {
                        BottomAppBar.selectedState(ATTENDANCE,it)
                        attendanceFragment?.let { it1 ->
                            supportFragmentManager.beginTransaction().replace(R.id.main_fragment,it1).commit() }
                    }
                }

                cslReport.setOnClickListener {
                    mBinding?.let {
                        BottomAppBar.selectedState(REPORT,it)
                        reportFragment?.let { it1 ->
                            supportFragmentManager.beginTransaction().replace(R.id.main_fragment,it1).commit()
                        }
                    }
                }

                cslProfile.setOnClickListener {
                    mBinding?.let {
                        BottomAppBar.selectedState(PROFILE,it)
                        profileFragment?.let { it1 ->
                            supportFragmentManager.beginTransaction().replace(R.id.main_fragment,it1).commit()
                        }
                    }
                }
            }

        }


    }
}