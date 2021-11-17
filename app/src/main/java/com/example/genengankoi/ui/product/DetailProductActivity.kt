package com.example.genengankoi.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Base64
import android.util.Log
import android.webkit.WebView
import android.widget.TextView
import com.example.genengankoi.R

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

        val avatarTf = findViewById<WebView>(R.id.avatarDetail)
        val embed = "<html><body><iframe src=\"https://www.youtube.com/embed/$avatar?autoplay=1&mute=1&playlist=$avatar&loop=1\" frameborder=\"0\"></iframe></body></html>"
        Log.d(
            "response",
            "$embed"
        )
        val encodedHtml = Base64.encodeToString(embed.toByteArray(), Base64.NO_PADDING)
        avatarTf.loadData(encodedHtml, "text/html", "base64")
        avatarTf.settings.javaScriptEnabled = true

        val nameItemTf = findViewById<TextView>(R.id.product_nameDetail).apply {
            text = nameItem
        }
        val priceTf = findViewById<TextView>(R.id.priceDetail).apply {
            text = price
        }
        val tokenTf = findViewById<TextView>(R.id.tokenDetail).apply {
            text = token
        }
        val genderTf = findViewById<TextView>(R.id.genderDetail).apply {
            text = gender
        }
        val qtyTf = findViewById<TextView>(R.id.qtyDetail).apply {
            text = qty
        }
        val sizeTf = findViewById<TextView>(R.id.sizeDetail).apply {
            text = size
        }
    }
}