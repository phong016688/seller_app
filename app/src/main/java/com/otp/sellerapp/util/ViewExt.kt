package com.otp.sellerapp.util

import android.widget.ImageView
import coil.load
import com.otp.sellerapp.R

fun ImageView.loadImage(url:String) {
    this.load(url){
        placeholder(android.R.color.darker_gray)
        error(R.drawable.slider)
        crossfade(true)
    }
}
fun ImageView.loadImageProduct(url:String) {
    this.load(url){
        placeholder(android.R.color.darker_gray)
        error(R.drawable.image_product)
        crossfade(true)
    }
}