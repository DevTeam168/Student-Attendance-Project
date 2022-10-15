package com.example.studentattendanceproject.fragment.signinsiginup

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentSignUpBinding
import com.example.studentattendanceproject.util.Util
import soup.neumorphism.NeumorphCardView

class SignUpFragment : Fragment() {

    private var mBinding: FragmentSignUpBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding?.apply {
            cdBack.setOnClickListener {
                findNavController().popBackStack()
            }
            activity?.let { it1->
                imageView.setOnClickListener {
                    Util().hideKeyboard(it1, view)
                    cslContainer.children.forEach { it1 ->
                        if (it1 is NeumorphCardView) {
                            it1.children.forEach {
                                if (it is EditText) {
                                    it.clearFocus()
                                }
                            }

                        }
                    }

                }
            }
        }
    }


}