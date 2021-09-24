package com.rtk.mpbg.ui.product

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.rtk.mpbg.R
import com.rtk.mpbg.core.extension.inflate
import com.rtk.mpbg.core.extension.loadFromUrl
import com.rtk.mpbg.ui.home.MobileParcel
import javax.inject.Inject
import kotlin.properties.Delegates

class ProductImageAdapter @Inject constructor() : RecyclerView.Adapter<ProductImageAdapter.ViewHolder>() {

    internal var collection: List<ProductDetails> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.image_item))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView

        init {

            image = itemView.findViewById(R.id.imageViewMain)
        }

        fun bind(movieView: ProductDetails) {

            image.loadFromUrl(movieView.url)

        }
    }
}