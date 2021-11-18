package com.example.genengankoi.ui.product

import android.content.Intent
import android.net.Uri
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.R
import com.example.genengankoi.ui.product.data.DataItem
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(private val list: List<DataItem>?):RecyclerView.Adapter<ProductAdapter.NewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return NewHolder(view)
    }

    fun onCreateViewInDetail(parent: ViewGroup, viewType: Int): HolderDetailProduct {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail_product, parent, false)
        return HolderDetailProduct(view)
    }

    class NewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(get: DataItem?) {
            val nameItem = get?.productName
            val price = get?.price
            val token = get?.token
            val qty = get?.qty
            val gender = get?.gender
            val size = get?.size
            var status1 = get?.status1
            if (status1 == null){
                status1 = "ready"
            }else if(status1 == "keep"){
                status1 = "booked"
            }
            val avatar = get?.avatar

            if (nameItem?.length!! > 40){
                val str_limit_product = nameItem?.chunked(50)
                itemView.product_text.text = str_limit_product?.get(0)+"..."
            }else{
                itemView.product_text.text = nameItem
            }
            itemView.token.text = ":\t $token"
            itemView.qty.text = ":\t $qty"
            itemView.gender.text = ":\t $gender"
            itemView.size.text = ":\t $size"
            itemView.status.text = ":\t $status1"
            itemView.price.text = "Rp.$price"
            itemView.avatar.loadUrl("https://img.youtube.com/vi/$avatar/mqdefault.jpg")
            itemView.beli.setOnClickListener {
                Log.d("Clicked", "$nameItem is selected")
                val url = "https://wa.me/+6283102822666?text=Untuk pemesanan *$token $nameItem* Isi format berikut%0ANama : %0AAlamat Lengkap : %0ANomor Hp: "
                itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            }
            itemView.product_card.setOnClickListener {
                val intent = Intent(itemView.context, DetailProductActivity::class.java).apply {
                    val productDetail = arrayOf(nameItem, price, token, gender, qty, size, avatar)
                    putExtra(EXTRA_MESSAGE, productDetail)
                }
                itemView.context.startActivity(intent)
            }

        }
    }

    class HolderDetailProduct(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(get: DataItem?) {
            val nameItem = get?.productName
            val price = get?.price
            val token = get?.token
            val qty = get?.qty
            val gender = get?.gender
            val size = get?.size
            var status1 = get?.status1
        }
    }

    override fun onBindViewHolder(holder: NewHolder, position: Int) {
//        holder.bind(list[position])
        holder.bind(list?.get(position));
    }

//    override fun getItemCount() = list.size
        override fun getItemCount(): Int = list?.size ?: 0
}