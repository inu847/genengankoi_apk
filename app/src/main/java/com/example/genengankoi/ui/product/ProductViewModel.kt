package com.example.genengankoi.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Product List Genengan Koi"
    }

    val text: LiveData<String> = _text
}