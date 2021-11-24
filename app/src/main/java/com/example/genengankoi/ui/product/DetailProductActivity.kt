package com.example.genengankoi.ui.product

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Base64
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.R
import com.example.genengankoi.ui.RetrofitClient
import com.example.genengankoi.ui.product.data.DataItem
import com.example.genengankoi.ui.product.data.ProductResponseNew
import kotlinx.android.synthetic.main.product_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.NumberFormat


class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val message = intent.getStringArrayExtra(EXTRA_MESSAGE)
        val nameItem = message?.get(0).toString()
        val price = message?.get(1).toString()
        val token = message?.get(2).toString()
        val gender = message?.get(3).toString()
        val qty = message?.get(4).toString()
        val size = message?.get(5).toString()
        val avatar = message?.get(6).toString()
        val status = message?.get(7).toString()

        val avatarTf = findViewById<WebView>(R.id.avatarDetail)
        val embed = "<html><body><iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/$avatar?autoplay=1&mute=1&playlist=$avatar&loop=1\" frameborder=\"0\"></iframe></body></html>"
        Log.d(
            "response",
            "$embed"
        )
        val encodedHtml = Base64.encodeToString(embed.toByteArray(), Base64.NO_PADDING)
        avatarTf.loadData(encodedHtml, "text/html", "base64")
        avatarTf.settings.javaScriptEnabled = true

        findViewById<TextView>(R.id.product_nameDetail).apply {
            text = nameItem
        }

        val numberFormat = NumberFormat.getCurrencyInstance()
        numberFormat.maximumFractionDigits = 0;
        val priceCurrency = numberFormat.format(price?.toInt())

        findViewById<TextView>(R.id.priceDetail).apply {
            text = priceCurrency
        }
        findViewById<TextView>(R.id.tokenDetail).apply {
            text = token
        }
        findViewById<TextView>(R.id.genderDetail).apply {
            text = gender
        }
        findViewById<TextView>(R.id.qtyDetail).apply {
            text = qty
        }
        findViewById<TextView>(R.id.sizeDetail).apply {
            text = size
        }
        findViewById<TextView>(R.id.statusDetail).apply {
            text = status
        }
        findViewById<Button>(R.id.btnBuy).setOnClickListener {
            val url = "https://wa.me/+6283102822666?text=Untuk pemesanan *$token $nameItem* Isi format berikut%0ANama : %0AAlamat Lengkap : %0ANomor Hp: "
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        val rvDetailProduct = findViewById<RecyclerView>(R.id.rvDetailProduct)

        val service = RetrofitClient().getService();
        val call = service.getDataApi();

        call.enqueue(object : Callback<ProductResponseNew> {
            override fun onResponse(
                call: Call<ProductResponseNew>,
                response: Response<ProductResponseNew>
            ) {
                if (response.code() == 200) {
                    val getDataProduct = response.body()
                    val thirty = getDataProduct?.getData()
                    val dataArrayList: List<DataItem>? = thirty
                    dataArrayList!!.size

                    rvDetailProduct.apply {
//                        layoutManager = LinearLayoutManager(
//                            this@DetailProductActivity,
//                            LinearLayoutManager.HORIZONTAL,
//                            false
//                        )
                        layoutManager = LinearLayoutManager(this@DetailProductActivity, LinearLayoutManager.VERTICAL, false)
                        adapter = ProductAdapter(dataArrayList)
                        setHasFixedSize(true)
                    }

                    var no = 0;
                    dataArrayList!!.forEach {
                        Log.d(
                            "Cek Get API Response",
                            "Berhasil Mendapatkan Respon Nama Product  " + dataArrayList!!.get(no)!!.productName
                        );
                        no += 1;
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponseNew>, t: Throwable) {
                Log.d("Cek Get API Response", "Gagal Mendapatkan Data");
            }

        })

    }
}