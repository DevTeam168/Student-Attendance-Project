package com.example.studentattendanceproject.fragment.signinsiginup

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.method.MovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentSignInBinding
import soup.neumorphism.ShapeType
import java.util.Calendar.getInstance

class SignInFragment : Fragment() {
    private var mBinding: FragmentSignInBinding? = null
    private val clickableSpan = object : ClickableSpan(){
        override fun onClick(p0: View) {
            findNavController().navigate(R.id.sign_up_fragment)
        }

        override fun updateDrawState(ds: TextPaint) {
            ds.isUnderlineText = false
            ds.isFakeBoldText = true
            ds.color = ds.linkColor
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentSignInBinding.inflate(inflater, container, false)

        return mBinding?.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()

    }

    private fun initialize() {
        setColorToBottomMessage()
    }

    private fun setColorToBottomMessage(){
        var message = getString(R.string.dont_have_an_account).plus(" ").plus(getString(R.string.sign_up))
        var spanMessage = SpannableString(message)

        spanMessage.apply {
            setSpan(clickableSpan,message.length - getString(R.string.sign_in).length ,
                message.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        mBinding?.tvBottomMessage?.movementMethod = LinkMovementMethod.getInstance()
        mBinding?.tvBottomMessage?.highlightColor = ContextCompat.getColor(requireContext(),android.R.color.transparent)
        mBinding?.tvBottomMessage?.text = spanMessage
    }
}