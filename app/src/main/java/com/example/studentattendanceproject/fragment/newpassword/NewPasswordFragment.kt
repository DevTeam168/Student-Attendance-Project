package com.example.studentattendanceproject.fragment.newpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentNewPasswordBinding
import com.example.studentattendanceproject.util.Util
import soup.neumorphism.NeumorphCardView

class NewPasswordFragment : Fragment() {
    private var mBinding:FragmentNewPasswordBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_new_password,container,false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        mBinding?.cslContainer?.children?.forEach {
            if(it is NeumorphCardView){
                it.children.forEach { it1 ->
                    if(it1 is EditText){
                        Util.onFocusChange(it1,it)
                    }
                }
            }
        }
    }
}