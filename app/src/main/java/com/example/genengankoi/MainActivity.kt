package com.example.genengankoi

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.ui.RetrofitClient
import com.example.genengankoi.ui.product.ProductAdapter
import com.example.genengankoi.ui.product.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
//    private val list = ArrayList<ProductResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_product, R.id.navigation_lelang, R.id.navigation_rekpen))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val rvProduct = findViewById<RecyclerView>(R.id.rvProduct)
//        rvProduct.setHasFixedSize(true)
//        rvProduct.layoutManager = LinearLayoutManager(this)
//        RetrofitClient.instance.getData().enqueue(object : Callback<ArrayList<ProductResponse>>{
//            override fun onResponse(
//                call: Call<ArrayList<ProductResponse>>,
//                response: Response<ArrayList<ProductResponse>>
//            ) {
//                val responseCode = response.code().toString()
//                response.body()?.let { list.addAll(it) }
//                val adapter = ProductAdapter(list)
//                rvProduct.adapter = adapter
//            }
//
//            override fun onFailure(call: Call<ArrayList<ProductResponse>>, t: Throwable) {
//
//            }
//
//        })
    }
}