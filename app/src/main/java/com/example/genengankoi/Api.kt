package com.example.genengankoi

import com.example.genengankoi.ui.product.data.ProductResponseItem
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET

interface Api{
    @GET("product")
    fun getDataApi(): Call<List<ProductResponseItem>>
}