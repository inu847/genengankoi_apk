package com.example.genengankoi.ui.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.R
import com.example.genengankoi.RetrofitClient
import com.example.genengankoi.ui.product.data.ProductResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        val root = inflater!!.inflate(R.layout.fragment_product, container, false)
        var rvProduct: RecyclerView = root.findViewById(R.id.rvProduct)
//        val textView: TextView = root.findViewById(R.id.text_products)
//        productViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val service = RetrofitClient().getService();
        val call = service.getDataApi();

        call.enqueue(object : Callback<List<ProductResponseItem>> {
            override fun onResponse(
                    call: Call<List<ProductResponseItem>>?,
                    response: Response<List<ProductResponseItem>>?
            ) {
                if (response?.body() != null) {
                    val data = response.body()

                    rvProduct.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = ProductAdapter(data)
                        setHasFixedSize(true)
                    }
                }
            }

            override fun onFailure(call: Call<List<ProductResponseItem>>, t: Throwable) {
                Log.d(
                        "Connection Failed",
                        t.message.toString()
                )
            }
        })
        return root
    }
}



