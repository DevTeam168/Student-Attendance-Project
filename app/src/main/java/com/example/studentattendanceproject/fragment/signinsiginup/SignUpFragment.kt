package com.example.studentattendanceproject.fragment.signinsiginup

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var mBinding: FragmentSignUpBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding?.apply {
            cdBack.setOnTouchListener { view, motionEvent ->
                Log.d("click", "click")
                findNavController().popBackStack()
                false

            }
        }
    }


}