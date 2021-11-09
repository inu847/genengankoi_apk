package com.example.genengankoi.ui.product

import com.example.genengankoi.ui.product.data.ProductResponseNew
import retrofit2.Call
import retrofit2.http.GET

interface Api{
    @GET("product")
    fun getDataApi(): Call<ProductResponseNew>
}