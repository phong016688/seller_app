package com.otp.sellerapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.otp.sellerapp.R
import com.otp.sellerapp.databinding.FragmentDetailProductBinding


class DetailProductFragment : Fragment() {

    private lateinit var binding:FragmentDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailProductBinding.inflate(layoutInflater,container,false)
        requireActivity().actionBar!!.hide()
        return binding.root
    }

}