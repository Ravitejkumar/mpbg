package com.rtk.mpbg.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rtk.mpbg.R
import com.rtk.mpbg.ui.home.FavouriteListFragment
import com.rtk.mpbg.ui.home.MobileListFragment
import com.rtk.mpbg.ui.home.MobileParcel

private val TAB_TITLES = arrayOf(
    "ALL",
    "Favourites"
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, private val mobiles: List<MobileParcel>) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return when(position) {
            0 -> MobileListFragment.newInstance(mobiles)
            1 -> FavouriteListFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}