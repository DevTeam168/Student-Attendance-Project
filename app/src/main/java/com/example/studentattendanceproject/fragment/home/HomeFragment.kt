package com.example.studentattendanceproject.fragment.home

import android.icu.text.RelativeDateTimeFormatter.Direction
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.databinding.FragmentHomeBinding
import com.example.studentattendanceproject.fragment.home.adapters.SliderImageViewAdapter
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class HomeFragment : Fragment() {
    private var mBinding:FragmentHomeBinding ?= null
    private var imageList:ArrayList<Int> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun initialize() {
        imageList = ArrayList()
        imageList?.add(R.drawable.school_1)
        imageList?.add(R.drawable.img2)
        imageList?.add(R.drawable.img3)
        initImageSlider()
    }

    private fun initImageSlider() {
        val adapter = SliderImageViewAdapter(requireContext())
        imageList?.let { adapter.setImageList(it) }

        mBinding?.apply {
            sliderViewImageSlider.setOffscreenPageLimit(1)
            sliderViewImageSlider.setSliderAdapter(adapter)
            sliderViewImageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
            sliderViewImageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
            sliderViewImageSlider.startAutoCycle()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater,container,false)
        initialize()


        return mBinding?.root
    }
}