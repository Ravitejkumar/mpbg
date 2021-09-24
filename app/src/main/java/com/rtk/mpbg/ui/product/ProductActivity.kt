package com.rtk.mpbg.ui.product

import android.content.Context
import android.content.Intent
import com.rtk.mpbg.ui.base.BaseActivity
import com.rtk.mpbg.ui.home.HomeActivity
import com.rtk.mpbg.ui.home.HomeFragment
import com.rtk.mpbg.ui.home.MobileParcel

class ProductActivity: BaseActivity() {

    companion object {
        private const val INTENT_EXTRA_PARAM_MOVIE = "com.rtk.mpbg.INTENT_PARAM_MOBILE"

        fun callingIntent(context: Context, mobileParcel: MobileParcel) =
        Intent(context, ProductActivity::class.java).apply {
            putExtra(INTENT_EXTRA_PARAM_MOVIE, mobileParcel)
        }
    }

    override fun fragment() = ProductFragment.forMobile(intent.getParcelableExtra(INTENT_EXTRA_PARAM_MOVIE))
}