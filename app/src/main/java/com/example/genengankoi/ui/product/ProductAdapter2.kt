package com.example.genengankoi.ui.product

import android.content.Intent
import android.net.Uri
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.R
import com.example.genengankoi.ui.product.data.ProductResponseItem
import kotlinx.android.synthetic.main.product_item.view.*
import java.text.NumberFormat

class ProductAdapter2(private val list: List<ProductResponseItem>?):RecyclerView.Adapter<ProductAdapter2.Holder2>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item2, parent, false)
        return Holder2(view)
    }

    class Holder2(itemView: View): RecyclerView.ViewHolder(itemView.rootView)

    override fun onBindViewHolder(holder: Holder2, position: Int) {
        val data = list?.get(position)
        val item = holder.itemView

        val nameItem = data?.productName
        val price = data?.price
        val token = data?.token
        val qty = data?.qty
        val gender = data?.gender
        val size = data?.size
        var status1 = data?.status1
        if (status1 == null){
            status1 = "ready"
        }else if(status1 == "keep"){
            status1 = "booked"
        }
        val avatar = data?.avatar

//        if (nameItem?.length!! > 40){
//            val str_limit_product = nameItem?.chunked(50)
//            item.product_text.text = str_limit_product?.get(0)+"..."
//        }else{
//            item.product_text.text = nameItem
//        }
        item.product_text.text = nameItem
        item.token.text = ":\t $token"
        item.qty.text = ":\t $qty"
        item.gender.text = ":\t $gender"
        item.size.text = ":\t $size"
        item.status.text = ":\t $status1"
        val numberFormat = NumberFormat.getCurrencyInstance()
        numberFormat.maximumFractionDigits = 0
        val priceCurrency = numberFormat.format(price?.toInt())
        item.price.text = priceCurrency
        item.avatar.apply {
            loadUrl("https://img.youtube.com/vi/$avatar/hqdefault.jpg")
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
        }

//        item.beli.setOnClickListener {
//            val url = "https://wa.me/+6283102822666?text=Untuk pemesanan *$token $nameItem* Isi format berikut%0ANama : %0AAlamat Lengkap : %0ANomor Hp: "
//            item.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
//        }
//        item.product_card.setOnClickListener {
//            val intent = Intent(item.context, DetailProductActivity::class.java).apply {
//                val productDetail = arrayListOf(nameItem, priceCurrency, token, gender, qty, size, avatar, status1)
//                putExtra(AlarmClock.EXTRA_MESSAGE, productDetail)
//            }
//            item.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int = list!!.size
}