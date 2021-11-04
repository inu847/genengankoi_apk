package com.example.genengankoi.ui.lelang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LelangViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Lelang Fragment"
    }
    val text: LiveData<String> = _text
}