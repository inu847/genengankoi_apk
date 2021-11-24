package com.example.genengankoi.ui.product

import com.example.genengankoi.ui.product.data.DetailProduct
import com.example.genengankoi.ui.product.data.ProductResponseNew
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface Api{
    @GET("product")
    fun getDataApi(): Call<ProductResponseNew>

    @GET("product/{id}")
    fun getDetailProduct(
        @Field("id") id: Int
    ): Call<DetailProduct>
}