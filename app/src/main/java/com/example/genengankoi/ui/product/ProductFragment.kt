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
import com.example.genengankoi.ui.RetrofitClient
import com.example.genengankoi.ui.product.data.DataItem
import com.example.genengankoi.ui.product.data.ProductResponseNew
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel
    private val list = ArrayList<ProductResponseNew>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        val root = inflater.inflate(R.layout.fragment_product, container, false)
        var rvProduct: RecyclerView = root.findViewById(R.id.rvProduct)

//        val textView: TextView = root.findViewById(R.id.text_products)
//        productViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        val service = RetrofitClient().getService();
        val call = service.getDataApi();

        call.enqueue(object : Callback<ProductResponseNew> {
            override fun onResponse(
                call: Call<ProductResponseNew>,
                response: Response<ProductResponseNew>
            ) {
                if (response.code() == 200) {
                    val getdataProd = response.body()!!
                    val twenty = getdataProd.getData()
                    val dataArrayList: List<DataItem>? = twenty
                    dataArrayList!!.size;

                    rvProduct.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = ProductAdapter(dataArrayList)
                        setHasFixedSize(true)
                    }
                    // Test Looping Data
                    var no = 0;
                    dataArrayList!!.forEach {
                        Log.d(
                            "Cek Get API Response",
                            "Berhasil Mendapatkan Respon Nama Product  " + dataArrayList!!.get(no)!!.productName
                        );
                        no += 1;
                    }
                // End Test Looping Data

                }
//                    response.body()?.let { list.addAll(it) }
//                    val adapter = ProductAdapter(list)
//                    rvProduct.adapter = adapter
//                    value = ProductAdapter(list).toString()

            }



            override fun onFailure(call: Call<ProductResponseNew>, t: Throwable) {
                Log.d("Cek Get API Response", "Gagal Mendapatkan Data");
            }


        })
        return root
    }
}



