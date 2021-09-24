package com.rtk.mpbg.ui.home

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rtk.mpbg.R
import com.rtk.mpbg.core.extension.inflate
import com.rtk.mpbg.core.extension.loadFromUrl
import com.rtk.mpbg.core.navigation.Navigator
import javax.inject.Inject
import kotlin.properties.Delegates

class MobilesAdapter
@Inject constructor() : RecyclerView.Adapter<MobilesAdapter.ViewHolder>() {

    internal var collection: List<MobileParcel> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (MobileParcel) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.mobile_item))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position], clickListener)

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val name: TextView
            val description: TextView
            val image: ImageView
            val price: TextView
            val rating: TextView

            init {
                // Define click listener for the ViewHolder's View.
                name = itemView.findViewById(R.id.mobile_name)
                description = itemView.findViewById(R.id.description)
                image = itemView.findViewById(R.id.imageView)
                price = itemView.findViewById(R.id.price)
                rating = itemView.findViewById(R.id.rating)
            }

        fun bind(movieView: MobileParcel,clickListener: (MobileParcel) -> Unit) {
            name.text = movieView.name
            description.text = movieView.description
            val priceSTr = "Price: " + movieView.price
            val ratingStr = "Rating: " + movieView.rating
            price.text = priceSTr
            rating.text = ratingStr

            image.loadFromUrl(movieView.thumbImageURL)
            itemView.setOnClickListener {
                clickListener(
                    movieView,
                )
            }
        }
    }
}