package com.example.studentattendanceproject.fragment.signinsiginup

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentSignUpBinding
import com.example.studentattendanceproject.helper.ClearFocus
import com.example.studentattendanceproject.util.Util
import kotlinx.coroutines.runBlocking
import soup.neumorphism.NeumorphCardView
import soup.neumorphism.ShapeType

class SignUpFragment : Fragment() {

    private var mBinding: FragmentSignUpBinding? = null
    private var strUserName = ""
    private var strPhoneNumber = ""
    private var strPassword = ""
    private var strConfirmPassword = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding?.apply {
            cdBack.setOnClickListener {
                findNavController().popBackStack()
            }
            activity?.let { it1 ->
                imageView.setOnClickListener {
                    Util.hideKeyboard(it1, view)
                    ClearFocus.clearTextView(cslContainer)

                }
            }

            cslContainer.children.forEach { it1 ->
                if (it1 is NeumorphCardView) {
                    it1.children.forEach {
                        if (it is EditText) {
                            Util.onFocusChange(it, it1)
                        }
                    }
                }
            }
            initialize()
        }
    }

    private fun initialize() {
        mBinding?.apply {

           /* etUserName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    strUserName = p0.toString()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
            etPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    strPassword = p0.toString()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
            etConfirmPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    strConfirmPassword = p0.toString()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
            etPhoneNumber.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    strPhoneNumber = p0.toString()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })*/
        }
    }
}