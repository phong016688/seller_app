package com.otp.sellerapp.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.otp.sellerapp.R
import com.otp.sellerapp.data.model.Category
import com.otp.sellerapp.data.model.Product
import com.otp.sellerapp.data.model.Slider
import com.otp.sellerapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel by viewModels<HomeViewModel>()

    private val sliderDataList = mutableListOf<Slider>()
    private val items = listOf(
        Slider(System.currentTimeMillis().toString(), ""),
        Slider(System.currentTimeMillis().toString(), ""),
        Slider(System.currentTimeMillis().toString(), ""),
    )
    private val listCategory = listOf(
        Category(System.currentTimeMillis().toString(), "All"),
        Category(System.currentTimeMillis().toString(), "Winter"),
        Category(System.currentTimeMillis().toString(), "Men"),
        Category(System.currentTimeMillis().toString(), "Women"),
        Category(System.currentTimeMillis().toString(), "Sport")
    )
    private var listProduct = listOf(
        Product(
            System.currentTimeMillis().toString(),
            "Mittens Stylish Jacket",
            "",
            149.99.toFloat()
        ),
        Product(
            System.currentTimeMillis().toString(),
            "Mittens Stylish Jacket",
            "",
            149.99.toFloat()
        ),
        Product(
            System.currentTimeMillis().toString(),
            "Mittens Stylish Jacket",
            "",
            149.99.toFloat()
        ),
        Product(
            System.currentTimeMillis().toString(),
            "Mittens Stylish Jacket",
            "",
            149.99.toFloat()
        ),
        Product(
            System.currentTimeMillis().toString(),
            "Mittens Stylish Jacket",
            "",
            149.99.toFloat()
        )
    )

    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListAdapter()
        scrollSlider()
        setupListCategory()
        setupListProduct()

    }



    private fun setupListProduct() {
        productAdapter = ProductAdapter()
        productAdapter.submitList(listProduct)
        binding.rvProduct.adapter = productAdapter
    }

    private fun setupListCategory() {
        categoryAdapter = CategoryAdapter()
        categoryAdapter.submitList(listCategory)
        binding.rvCategory.adapter = categoryAdapter

    }

    private fun setupListAdapter() {
        sliderAdapter = SliderAdapter()
        sliderAdapter.submitList(items)
        binding.viewPagerSlider.adapter = sliderAdapter

    }

    private fun scrollSlider() {
        lifecycleScope.launch {
            while (true) {
                delay(3000)
                binding.viewPagerSlider.currentItem =
                    (binding.viewPagerSlider.currentItem + 1) % items.size
            }
        }
    }
    private fun navigationToDetailProduct(){
        findNavController().navigate(R.id.action_homeFragment_to_detailProductFragment)
    }


}