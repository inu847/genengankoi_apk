package com.example.genengankoi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.genengankoi.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
//        val bgTop: WebView = root.findViewById(R.id.bgTop)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
//        homeViewModel.bg.observe(viewLifecycleOwner, {
//            bgTop.loadUrl(it)
//        })
        return root
    }
}