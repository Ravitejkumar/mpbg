package com.rtk.mpbg.ui.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.rtk.mpbg.core.extension.failure
import com.rtk.mpbg.core.extension.observe
import com.rtk.mpbg.databinding.FragmentHomeBinding
import com.rtk.mpbg.databinding.FragmentProductBinding
import com.rtk.mpbg.ui.base.BaseFragment
import com.rtk.mpbg.ui.home.MobileParcel
import com.rtk.mpbg.ui.main.SectionsPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductFragment: BaseFragment() {

    private val productViewModel: ProductViewModel by viewModels()

    private var _binding: FragmentProductBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var imageAdapter: ProductImageAdapter

    companion object {
        private const val PARAM_MOVIE = "param_mobile"

        fun forMobile(mobile: MobileParcel?) = ProductFragment().apply {
            arguments = bundleOf(PARAM_MOVIE to mobile)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(productViewModel) {
            observe(product, ::handleProductDetails)
//            failure(failure, ::handleFailure)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentProductBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mobile = arguments?.get(PARAM_MOVIE) as MobileParcel
        Log.d("Product Fragment", "onViewCreated: $mobile")
        productViewModel.getProdcutDetails(mobile.id)
        binding.textView.text = (arguments?.get(PARAM_MOVIE) as MobileParcel).name
        binding.description.text = mobile.description
        binding.brand.text = mobile.brand
    }

    private fun handleProductDetails(details: List<ProductDetails>?){
        Log.d("Product Fragment", "handleProductDetails: $details")
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = imageAdapter
        imageAdapter.collection = details.orEmpty()
    }
}