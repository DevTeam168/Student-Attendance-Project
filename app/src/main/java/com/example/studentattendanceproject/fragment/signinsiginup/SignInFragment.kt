package com.example.studentattendanceproject.fragment.signinsiginup

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentSignInBinding
import com.example.studentattendanceproject.helper.ClearFocus
import com.example.studentattendanceproject.util.Util
import soup.neumorphism.NeumorphCardView
import soup.neumorphism.ShapeType

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
        initListener()

    }

    private fun initListener() {
        mBinding?.imageView?.setOnClickListener {
            //hide keyboard layout
            Util.hideKeyboard(requireActivity(),it)
            //clear all focus from editText
            Util.clearEditText(mBinding?.cslContainer)
        }
        mBinding?.cslContainer?.children?.forEach {
            if(it is NeumorphCardView){
                it.children.forEach { it1 ->
                    if(it1 is EditText){
                        if(it1.isFocused){
                            Util.onFocusChange(it1,it)
                        }
                    }
                }
            }
        }
    }

    private fun initialize() {
        setColorToBottomMessage()
        //to make layout is scrollable when showing the keyboard
       // activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    private fun setColorToBottomMessage(){
        val message = getString(R.string.dont_have_an_account).plus(" ").plus(getString(R.string.sign_up))
        val spanMessage = SpannableString(message)

        spanMessage.apply {
            setSpan(clickableSpan,message.length - getString(R.string.sign_in).length ,
                message.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        mBinding?.tvBottomMessage?.movementMethod = LinkMovementMethod.getInstance()
        mBinding?.tvBottomMessage?.highlightColor = ContextCompat.getColor(requireContext(),android.R.color.transparent)
        mBinding?.tvBottomMessage?.text = spanMessage
    }
}