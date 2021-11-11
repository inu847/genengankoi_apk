package com.example.genengankoi.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genengankoi.ui.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Product List Genengan Koi"
    }

    val text: LiveData<String> = _text
}