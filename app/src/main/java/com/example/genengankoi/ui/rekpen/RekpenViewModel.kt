package com.example.genengankoi.ui.rekpen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RekpenViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Rekpen Fragment"
    }
    val text: LiveData<String> = _text
}