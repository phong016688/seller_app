package com.otp.sellerapp.ui.home

import androidx.lifecycle.ViewModel
import com.otp.sellerapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository: AuthRepository) :ViewModel(){
}