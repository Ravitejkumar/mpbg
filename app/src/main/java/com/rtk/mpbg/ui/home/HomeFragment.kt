package com.rtk.mpbg.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.rtk.mpbg.R
import com.rtk.mpbg.ui.base.BaseFragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.rtk.mpbg.core.exception.Failure
import com.rtk.mpbg.core.extension.failure
import com.rtk.mpbg.core.extension.observe
import com.rtk.mpbg.core.navigation.Navigator
import com.rtk.mpbg.databinding.FragmentHomeBinding
import com.rtk.mpbg.ui.main.SectionsPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment: BaseFragment() {

    @Inject
    lateinit var navigator: Navigator

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(homeViewModel) {
            observe(movies, ::renderMoviesList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadMoviesList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadMoviesList() {
//        emptyView.invisible()
//        movieList.visible()
//        showProgress()
        homeViewModel.loadMovies()
    }

    private fun renderMoviesList(movies: List<MobileParcel>?) {
        Log.d("Home Fragment", "renderMoviesList: $movies")
        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), parentFragmentManager, movies!!)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }

    private fun handleFailure(failure: Failure?) {
//        when (failure) {
//            is NetworkConnection -> renderFailure(R.string.failure_network_connection)
//            is ServerError -> renderFailure(R.string.failure_server_error)
//            is ListNotAvailable -> renderFailure(R.string.failure_movies_list_unavailable)
//            else -> renderFailure(R.string.failure_server_error)
//        }
    }

    private fun renderFailure(@StringRes message: Int) {
        Log.d("Home Fragment", "renderFailure: $message")
//        movieList.invisible()
//        emptyView.visible()
//        hideProgress()
//        notifyWithAction(message, R.string.action_refresh, ::loadMoviesList)
    }
}