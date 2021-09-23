package com.rtk.mpbg.ui.home

data class MobileEntity(private val id: Int,private val brand: String,
                        private val name: String,private val price: Float,
                        private val thumbImageURL: String,private val description: String,
                        private val rating: Float) {
    fun toMobile() = Mobile(id,brand,name,price,thumbImageURL,description,rating)
}
