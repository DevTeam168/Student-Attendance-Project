package com.example.studentattendanceproject.fragment.signinsiginup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private var mBinding: FragmentSignInBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentSignInBinding.inflate(inflater,container,false)


        return mBinding?.root
    }
}