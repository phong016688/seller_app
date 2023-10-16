package com.otp.sellerapp.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.otp.sellerapp.data.model.Category
import com.otp.sellerapp.databinding.ItemScrollCategoryBinding

class CategoryAdapter: ListAdapter<Category, CategoryAdapter.ViewHolder>(CategoryDiffCallback()) {
    inner class ViewHolder(private val binding:ItemScrollCategoryBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category){
            binding.tvCategoryName.text=category.categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemScrollCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

}
class CategoryDiffCallback:DiffUtil.ItemCallback<Category>(){
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id==newItem.id
    }

}