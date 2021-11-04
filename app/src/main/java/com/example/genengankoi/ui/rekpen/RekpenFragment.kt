package com.example.genengankoi.ui.rekpen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.genengankoi.R

class RekpenFragment : Fragment() {

    private lateinit var viewModel: RekpenViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(RekpenViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_lelang, container, false)
        val textView: TextView = root.findViewById(R.id.text_lelang)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}