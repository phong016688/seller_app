package com.otp.sellerapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.otp.sellerapp.R
import com.otp.sellerapp.data.model.Product
import com.otp.sellerapp.databinding.ItemScrollProductBinding
import com.otp.sellerapp.ui.base.RecyclerviewItemListener
import com.otp.sellerapp.util.loadImageProduct

class ProductAdapter : ListAdapter<Product, ProductAdapter.ViewHolder>(ProductDiffCallback()) {
    private val onItemClickListener: RecyclerviewItemListener = object : RecyclerviewItemListener {
        override fun onItemSelected(product: Product) {
            TODO("Not yet implemented")
        }

    }

    inner class ViewHolder(private val binding: ItemScrollProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.apply {
                ivProductImages.loadImageProduct("")
                tvProductName.text = product.productName
                tvProductPrice.text = "€" + product.productPrice

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemScrollProductBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        val bundle = Bundle()
        holder.itemView.findNavController().navigate(R.id.action_homeFragment_to_detailProductFragment, bundle)
    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

}
