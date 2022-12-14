package com.example.studentattendanceproject.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var mBinding: FragmentProfileBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)
        return mBinding?.root
    }
}