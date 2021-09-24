package com.rtk.mpbg.ui.product

data class ProductDetailEntity(private val id: Int, private val mobile_id: Int, private val url: String) {

    companion object {
        val empty = ProductDetailEntity(
            0, 0, ""
        )
    }
    fun toProductDetail() = ProductDetails(id,mobile_id,url)
}