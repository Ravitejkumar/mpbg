package com.rtk.mpbg.ui.home

import android.os.Parcel
import com.rtk.mpbg.core.utils.KParcelable
import com.rtk.mpbg.core.utils.parcelableCreator

data class MobileParcel(val id: Int, val brand: String,
                  val name: String, val price: Float,
                  val thumbImageURL: String, val description: String,
                  val rating: Float) : KParcelable {

    companion object {
        @JvmField
        val CREATOR = parcelableCreator(::MobileParcel)
    }

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        with(parcel) {
            parcel.writeInt(id)
            parcel.writeString(brand)
            parcel.writeString(name)
            parcel.writeFloat(price)
            parcel.writeString(thumbImageURL)
            parcel.writeString(description)
            parcel.writeFloat(rating)
        }
    }

}