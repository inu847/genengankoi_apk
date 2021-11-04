package com.example.genengankoi.ui.product

import retrofit2.Call
import retrofit2.http.GET

interface Api{
    @GET("product")
    fun getData(): Call<ArrayList<ProductResponse>>

}