package com.rtk.mpbg.ui.home

import android.content.Context
import android.content.Intent
import com.rtk.mpbg.ui.base.BaseActivity
import com.rtk.mpbg.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

class HomeActivity: BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    override fun fragment() = HomeFragment()
}