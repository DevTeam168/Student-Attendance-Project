package com.example.studentattendanceproject.fragment.forgotpassword

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentForgotPasswordBinding
import com.example.studentattendanceproject.util.Util

class ForgotPasswordFragment : Fragment() {
    private var mBinding:FragmentForgotPasswordBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_forgot_password,container,false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        initListener()
    }

    private fun initialize() {
        //change shapeType of cardview when focus on it
        mBinding?.etPhoneNumber?.let { mBinding?.cdViewPhoneNumber?.let { it1 ->
            Util.onFocusChange(it,it1)
        } }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListener() {
        mBinding?.cdViewBack?.setOnClickListener {
            findNavController().popBackStack()
        }

        mBinding?.nstScrollForgotPassword?.setOnTouchListener { view, _ ->
            if(mBinding?.etPhoneNumber?.isFocused != true){
                false
            }else{
                Util.hideKeyboard(requireActivity(),view)
                Util.clearEditText(mBinding?.cslContainer)
                true
            }
        }

    }
}