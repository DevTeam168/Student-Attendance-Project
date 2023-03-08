package com.example.studentattendanceproject.fragment.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.studentattendanceproject.BR
import com.example.studentattendanceproject.data.ClassSchedule
import com.example.studentattendanceproject.databinding.TodayScheduleItemsBinding

class TodayScheduleRecViewAdapter : Adapter<TodayScheduleRecViewAdapter.ViewHolder>() {
    private var classScheduleList: ArrayList<ClassSchedule>? = null

    init {
        classScheduleList = ArrayList()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setClassScheduleList(classScheduleList: ArrayList<ClassSchedule>) {
        this.classScheduleList = classScheduleList
        notifyDataSetChanged()

    }

    class ViewHolder(var mBinding: TodayScheduleItemsBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(classSchedule: ClassSchedule?) {
            mBinding.setVariable(BR.classSchedule, classSchedule)
            mBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            TodayScheduleItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val classSchedule = classScheduleList?.get(position)
        holder.bind(classSchedule)
    }

    override fun getItemCount(): Int {
        return classScheduleList?.size ?: 0
    }
}