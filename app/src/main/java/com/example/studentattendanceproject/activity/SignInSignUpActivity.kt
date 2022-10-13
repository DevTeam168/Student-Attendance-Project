package com.example.studentattendanceproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.ActivitySignInSignUpBinding

class SignInSignUpActivity : AppCompatActivity() {
    private var mBinding:ActivitySignInSignUpBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in_sign_up)
    }
}