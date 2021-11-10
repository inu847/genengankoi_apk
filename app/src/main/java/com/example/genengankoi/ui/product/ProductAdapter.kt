package com.example.genengankoi.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.R
import com.example.genengankoi.ui.product.data.DataItem
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(private val list: List<DataItem>?):RecyclerView.Adapter<ProductAdapter.NewHolder>() {

//    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        fun bind(ProductResponseNew: ProductResponseNew){
//            with(itemView){
//                val text = "current_page: ${ProductResponseNew.currentPage}"
//                val getId = findViewById<TextView>(R.id.product_text)
//                getId.text = text
////                for (product in products){
////                    val text = "id: ${product.id}\n"+
////                            "title: ${product.product_name}\n"+
////                            "size: ${product.size}\n"+
////                            "gender: ${product.gender}\n"+
////                            "quantity: ${product.qty}\n"+
////                            "price: ${product.price}\n"+
////                            "avatar: ${product.avatar}\n"+
////                            "sizeMin: ${product.size[0]}\n"+
////                            "sizeMax: ${product.size[1]}\n"+
////                            "status1: ${product.status1}\n"+
////                            "status2: ${product.status2}\n"+
////                            "token: ${product.token}\n"+
////                            "admin_id: ${product.admin_id}"
////                    val getId = findViewById<TextView>(R.id.product_text)
////                    getId.text = text
////                }
//            }
//        }
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return NewHolder(view)
    }
    class NewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(get: DataItem?) {
            val nameItem = get?.productName
            val price = get?.price
            val token = get?.token
            val qty = get?.qty
            val gender = get?.gender
            val size = get?.size
            val status2 = get?.status2

            itemView.product_text.text = nameItem
            itemView.price.text = "Rp.$price"
            itemView.token.text = token
            itemView.qty.text = qty
            itemView.gender.text = gender
            itemView.size.text = size
            itemView.status.text = status2
        }
    }

    override fun onBindViewHolder(holder: NewHolder, position: Int) {
//        holder.bind(list[position])
         holder.bind(list?.get(position));

    }

//    override fun getItemCount() = list.size
        override fun getItemCount(): Int = list?.size ?: 0

}