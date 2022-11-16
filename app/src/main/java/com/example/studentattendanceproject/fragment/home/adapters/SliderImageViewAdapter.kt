package com.example.studentattendanceproject.fragment.home.adapters

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.library.baseAdapters.BR
import com.example.studentattendanceproject.databinding.ImageSliderItemBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderImageViewAdapter(var context: Context): SliderViewAdapter<SliderImageViewAdapter.OnViewHolder>() {

    private lateinit var imgList:ArrayList<Int>

    fun setImageList(imgList:ArrayList<Int>){
        this.imgList = ArrayList()
        this.imgList.addAll(imgList)
        notifyDataSetChanged()
    }

    class OnViewHolder(var binding: ImageSliderItemBinding) : ViewHolder(binding.root) {
        fun bind(img:Int){
            binding.setVariable(BR.image,img)
            binding.executePendingBindings()
        }
    }

    override fun getCount(): Int {
        return imgList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): OnViewHolder {
        val imgSliderBinding = ImageSliderItemBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        return OnViewHolder(imgSliderBinding)
    }

    override fun onBindViewHolder(viewHolder: OnViewHolder?, position: Int) {
        val img = imgList[position]
        viewHolder?.bind(img)
    }
}