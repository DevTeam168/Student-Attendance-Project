package com.example.studentattendanceproject.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentattendanceproject.R
import com.example.studentattendanceproject.data.ClassSchedule
import com.example.studentattendanceproject.databinding.FragmentHomeBinding
import com.example.studentattendanceproject.fragment.home.adapters.SliderImageViewAdapter
import com.example.studentattendanceproject.fragment.home.adapters.TodayScheduleRecViewAdapter
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class HomeFragment : Fragment() {
    private var mBinding: FragmentHomeBinding? = null
    private var imageList: ArrayList<Int>? = null
    private var classScheduleList: ArrayList<ClassSchedule>? = null

    private fun initialize() {
        imageList = ArrayList()
        imageList?.add(R.drawable.school_1)
        imageList?.add(R.drawable.img2)
        imageList?.add(R.drawable.img3)

        //set some sample data for class schedule
        classScheduleList = ArrayList()
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១០ A", "07:15 AM - 09:00 AM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១១ B", "02:15 AM - 03:45 PM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១០ C", "09:15 AM - 10:45 AM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១២ F", "04:15 AM - 05:45 PM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១០ A", "07:15 AM - 09:00 AM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១១ B", "02:15 AM - 03:45 PM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១០ C", "09:15 AM - 10:45 AM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១២ F", "04:15 AM - 05:45 PM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១០ A", "07:15 AM - 09:00 AM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១១ B", "02:15 AM - 03:45 PM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១០ C", "09:15 AM - 10:45 AM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១២ F", "04:15 AM - 05:45 PM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១០ A", "07:15 AM - 09:00 AM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១១ B", "02:15 AM - 03:45 PM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១០ C", "09:15 AM - 10:45 AM"))
        classScheduleList?.add(ClassSchedule("ថ្នាក់ទី ១២ F", "04:15 AM - 05:45 PM"))

        initImageSlider()
    }

    private fun initImageSlider() {
        val adapter = SliderImageViewAdapter(requireContext())
        imageList?.let { adapter.setImageList(it) }

        mBinding?.apply {
            sliderViewImageSlider.setOffscreenPageLimit(1)
            sliderViewImageSlider.setSliderAdapter(adapter)
            sliderViewImageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
            sliderViewImageSlider.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            sliderViewImageSlider.startAutoCycle()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupForTodayScheduleRecView()
    }

    private fun setupForTodayScheduleRecView() {
        val adt = TodayScheduleRecViewAdapter()
        classScheduleList?.let { adt.setClassScheduleList(it) }

        mBinding?.recViewTodaySchedule?.apply {
            adapter = adt
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}