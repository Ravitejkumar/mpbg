package com.rtk.mpbg.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rtk.mpbg.R
import com.rtk.mpbg.core.extension.failure
import com.rtk.mpbg.core.extension.observe
import com.rtk.mpbg.databinding.FragmentMainBinding
import com.rtk.mpbg.databinding.FragmentMobileListBinding
import com.rtk.mpbg.ui.base.BaseFragment
import com.rtk.mpbg.ui.main.PlaceholderFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MobileListFragment: BaseFragment() {

    @Inject
    lateinit var mobilesAdapter: MobilesAdapter

    private var _binding: FragmentMobileListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(mobiles: List<MobileParcel>): MobileListFragment {
            return MobileListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_SECTION_NUMBER, ArrayList(mobiles))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentMobileListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mobiles =arguments?.getParcelableArrayList<MobileParcel>(MobileListFragment.ARG_SECTION_NUMBER)
        Log.d("Mobile List", "renderMobilesList: $mobiles")
        initializeView(mobiles)
    }

    private fun initializeView(mobiles: ArrayList<MobileParcel>?) {
        binding.mobileList.layoutManager = LinearLayoutManager(requireContext())
        binding.mobileList.adapter = mobilesAdapter
        renderMobilesList(mobiles)
//        moviesAdapter.clickListener = { movie, navigationExtras ->
//            navigator.showMovieDetails(requireActivity(), movie, navigationExtras)
//        }
    }

    private fun renderMobilesList(movies: List<MobileParcel>?) {
        mobilesAdapter.collection = movies.orEmpty()
//        hideProgress()
    }

}