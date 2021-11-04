package com.example.genengankoi.ui.product

data class ProductResponse(
    val current_page: Int,
    val `data`: List<Data>,
    val first_page_url: String,
    val from: Int,
    val last_page: Int,
    val last_page_url: String,
    val links: List<Link>,
    val next_page_url: String,
    val path: String,
    val per_page: Int,
    val prev_page_url: Any,
    val to: Int,
    val total: Int
) {
    data class Data(
        val admin_id: Int,
        val avatar: String,
        val created_at: String,
        val gender: String,
        val id: Int,
        val price: String,
        val product_name: String,
        val qty: String,
        val size: String,
        val status1: Any,
        val status2: String,
        val token: String,
        val updated_at: String
    )

    data class Link(
        val active: Boolean,
        val label: String,
        val url: Any
    )
}