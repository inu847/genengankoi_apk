package com.example.genengankoi.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.genengankoi.ui.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {
    private val list = ArrayList<ProductResponse>()

    private val _text = MutableLiveData<String>().apply {
        value = "This is Product Fragment"
    }

    val text: LiveData<String> = _text
}