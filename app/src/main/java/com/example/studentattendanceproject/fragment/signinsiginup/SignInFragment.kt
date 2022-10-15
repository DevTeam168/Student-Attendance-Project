package com.example.studentattendanceproject.fragment.signinsiginup

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentSignInBinding
import soup.neumorphism.ShapeType

class SignInFragment : Fragment() {
    private var mBinding: FragmentSignInBinding? = null

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
        mBinding?.apply {
            txtViewEmail.setOnFocusChangeListener { view, b ->
                if (b) {
                    mBinding?.cdViewEmail?.setShapeType(ShapeType.PRESSED)
                }
            }
            tvRememberMe.setOnClickListener {
                findNavController().navigate(R.id.action_singin_fragment_to_sign_up_fragment)
            }
        }
    }
}