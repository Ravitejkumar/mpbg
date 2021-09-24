package com.rtk.mpbg.ui.home

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rtk.mpbg.R
import com.rtk.mpbg.core.extension.inflate
import javax.inject.Inject
import kotlin.properties.Delegates

class MobilesAdapter
@Inject constructor() : RecyclerView.Adapter<MobilesAdapter.ViewHolder>() {

    internal var collection: List<MobileParcel> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

//    internal var clickListener: (MobileParcel, Navigator.Extras) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.mobile_item))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val name: TextView
            val description: TextView

            init {
                // Define click listener for the ViewHolder's View.
                name = itemView.findViewById(R.id.mobile_name)
                description = itemView.findViewById(R.id.description)
            }

        fun bind(movieView: MobileParcel) {
            name.text = movieView.name
            description.text = movieView.description
//            itemView.setOnClickListener {
//                clickListener(
//                    movieView,
//                    Navigator.Extras(itemView.moviePoster)
//                )
//            }
        }
    }
}