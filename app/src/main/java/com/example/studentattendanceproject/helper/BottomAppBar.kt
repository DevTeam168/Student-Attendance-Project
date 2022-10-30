package com.example.studentattendanceproject.helper

import android.view.View
import androidx.core.content.ContextCompat
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.ActivityMainBinding
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.ATTENDANCE
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.HOME
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.PROFILE
import com.example.studentattendanceproject.helper.Constants.BottomAppBarType.Companion.REPORT

fun View.show(){this.visibility = View.VISIBLE}
fun View.hide(){this.visibility = View.INVISIBLE}
object BottomAppBar{
    fun selectedState(type:String,binding:ActivityMainBinding){
        when(type){
            HOME -> {
                setUpForBottomAppBar(HOME,R.drawable.home_selected,true,R.color.pink,binding)
                setUpForBottomAppBar(ATTENDANCE,R.drawable.tick_circle,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(REPORT,R.drawable.document_text,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(PROFILE,R.drawable.profile_circle,false,R.color.text_color_black,binding)
            }
            ATTENDANCE -> {
                setUpForBottomAppBar(HOME,R.drawable.home,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(ATTENDANCE,R.drawable.tick_circle_selected,true,R.color.pink,binding)
                setUpForBottomAppBar(REPORT,R.drawable.document_text,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(PROFILE,R.drawable.profile_circle,false,R.color.text_color_black,binding)
            }
            REPORT -> {
                setUpForBottomAppBar(HOME,R.drawable.home,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(ATTENDANCE,R.drawable.tick_circle,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(REPORT,R.drawable.document_text_selected,true,R.color.pink,binding)
                setUpForBottomAppBar(PROFILE,R.drawable.profile_circle,false,R.color.text_color_black,binding)
            }
            PROFILE -> {
                setUpForBottomAppBar(HOME,R.drawable.home,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(ATTENDANCE,R.drawable.tick_circle,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(REPORT,R.drawable.document_text,false,R.color.text_color_black,binding)
                setUpForBottomAppBar(PROFILE,R.drawable.profile_circle_selected,true,R.color.pink,binding)
            }
        }
    }

    private fun setUpForBottomAppBar(type:String,image:Int,isShow:Boolean,color:Int,binding: ActivityMainBinding){
        binding.bottomNavBar.apply {
            when(type){
                HOME -> {
                    if (isShow) cdViewSelectedBgHome.show() else cdViewSelectedBgHome.hide()
                    imgHome.setImageResource(image)
                    textViewHome.setTextColor(ContextCompat.getColor(binding.root.context,color))
                }
                ATTENDANCE -> {
                    if (isShow) cdViewSelectedBgAttendance.show() else cdViewSelectedBgAttendance.hide()
                    imgAttendance.setImageResource(image)
                    textViewAttendance.setTextColor(ContextCompat.getColor(binding.root.context,color))
                }
                REPORT -> {
                    if (isShow) cdViewSelectedBgReport.show() else cdViewSelectedBgReport.hide()
                    imgReport.setImageResource(image)
                    textViewReport.setTextColor(ContextCompat.getColor(binding.root.context,color))
                }
                PROFILE -> {
                    if (isShow) cdViewSelectedBgProfile.show() else cdViewSelectedBgProfile.hide()
                    imgProfile.setImageResource(image)
                    textViewProfile.setTextColor(ContextCompat.getColor(binding.root.context,color))
                }
            }
        }

    }
}
