package com.rtk.mpbg.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rtk.mpbg.R
import com.rtk.mpbg.ui.base.BaseFragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.rtk.mpbg.databinding.FragmentHomeBinding
import com.rtk.mpbg.ui.main.SectionsPagerAdapter

class HomeFragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_home

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), parentFragmentManager )
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}