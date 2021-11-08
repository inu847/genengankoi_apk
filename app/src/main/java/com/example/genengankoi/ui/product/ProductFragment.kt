package com.example.genengankoi.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.R
import com.example.genengankoi.ui.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel
    private val list = ArrayList<ProductResponse>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        val root = inflater.inflate(R.layout.fragment_product, container, false)
        val rvProduct: RecyclerView = root.findViewById(R.id.rvProduct)
        val textView: TextView = root.findViewById(R.id.text_products)
        productViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
            RetrofitClient.instance.getData().enqueue(object : Callback<ArrayList<ProductResponse>> {
                override fun onResponse(
                        call: Call<ArrayList<ProductResponse>>,
                        response: Response<ArrayList<ProductResponse>>
                ) {
                    val responseCode = response.code().toString()
                    response.body()?.let { list.addAll(it) }
                    val adapter = ProductAdapter(list)
                    rvProduct.adapter = adapter
                }

                override fun onFailure(call: Call<ArrayList<ProductResponse>>, t: Throwable) {
                }
            })
        })

        return root
    }
}