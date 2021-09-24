package com.rtk.mpbg.core.navigation

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.FragmentActivity
import com.rtk.mpbg.ui.home.HomeActivity
import com.rtk.mpbg.ui.home.MobileParcel
import com.rtk.mpbg.ui.product.ProductActivity
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator
@Inject constructor() {

    private fun showHome(context: Context) =
        context.startActivity(HomeActivity.callingIntent(context))

    fun showMobileDetails(activity: FragmentActivity, mobile: MobileParcel) {
        val intent = ProductActivity.callingIntent(activity, mobile)
//        val sharedView = navigationExtras.transitionSharedElement as ImageView
//        val activityOptions = ActivityOptionsCompat
//            .makeSceneTransitionAnimation(activity, sharedView, sharedView.transitionName)
        activity.startActivity(intent)
    }

    class Extras(val transitionSharedElement: View)
}


