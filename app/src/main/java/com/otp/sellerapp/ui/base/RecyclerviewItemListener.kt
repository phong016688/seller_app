package com.otp.sellerapp.ui.base

import com.otp.sellerapp.data.model.Product

interface RecyclerviewItemListener {
    fun onItemSelected(product: Product)
}