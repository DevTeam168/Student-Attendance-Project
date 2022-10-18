package com.example.studentattendanceproject.fragment.otpverification

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentOtpVerificationBinding

class OtpVerificationFragment : Fragment() {
    private var mBinding:FragmentOtpVerificationBinding ?= null

    private var clickSpannable = object : ClickableSpan(){
        override fun onClick(p0: View) {
            //TODO: navigate to another screen
        }

        override fun updateDrawState(ds: TextPaint) {
            ds.color = ds.linkColor
            ds.isFakeBoldText = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_otp_verification,container,false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        setSpanableText()
    }

    private fun setSpanableText() {
        val message = getString(R.string.dont_get_otp_code).plus(" ").plus("Resend")
        val spannableMessage = SpannableString(message)

        spannableMessage.setSpan(clickSpannable,message.length - "Resend".length,message.length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        mBinding?.tvMessageResendCode?.text = spannableMessage
    }
}