package com.example.genengankoi

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient{
    private val BASE_URL = "https://genegankoi.herokuapp.com/api/"
    fun getRetro() : Retrofit {
        Log.d("Cek Get API Response","Cek APa Terbaca");
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getIntercep())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    // cek status Request Api
    fun getIntercep() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return  okHttpClient
    }

    fun getService() = getRetro().create(Api::class.java)
}
