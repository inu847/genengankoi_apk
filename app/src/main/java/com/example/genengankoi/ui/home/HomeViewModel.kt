package com.example.genengankoi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Selamat Datang Di Genengan Koi - OFFICIAL STORE KOI BLITAR"
    }

    private val _bg = MutableLiveData<String>().apply {
        value = "http://genegankoi.herokuapp.com/plugins/images/bgcover.png"
    }

    val text: LiveData<String> = _text
    val bg: LiveData<String> = _bg
}