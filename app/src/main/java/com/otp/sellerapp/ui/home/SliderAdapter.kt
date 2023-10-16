package com.otp.sellerapp.ui.home


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.otp.sellerapp.R
import com.otp.sellerapp.data.model.Slider
import com.otp.sellerapp.databinding.ItemSliderBinding
import com.otp.sellerapp.util.loadImage
import org.jetbrains.annotations.ApiStatus.Internal

class SliderAdapter: ListAdapter<Slider, SliderAdapter.ViewHolder>(SliderDiffCallback()) {

    inner class ViewHolder(private val binding:ItemSliderBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(slider: Slider){
            binding.ivSlider.loadImage("")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding =ItemSliderBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SliderDiffCallback : DiffUtil.ItemCallback<Slider>() {
    //kiem tra id
    override fun areItemsTheSame(oldItem: Slider, newItem: Slider): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Slider, newItem: Slider): Boolean {
        return  oldItem==newItem
    }

}
