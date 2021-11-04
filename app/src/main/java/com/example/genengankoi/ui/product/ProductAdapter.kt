package com.example.genengankoi.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.genengankoi.R

class ProductAdapter(private val list: ArrayList<ProductResponse>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(productResponse: ProductResponse){
            with(itemView){
                val text = "data: ${productResponse.data}"
                val getId = findViewById<TextView>(R.id.product_text)
                getId.text = text
//                for (product in products){
//                    val text = "id: ${product.id}\n"+
//                            "title: ${product.product_name}\n"+
//                            "size: ${product.size}\n"+
//                            "gender: ${product.gender}\n"+
//                            "quantity: ${product.qty}\n"+
//                            "price: ${product.price}\n"+
//                            "avatar: ${product.avatar}\n"+
//                            "sizeMin: ${product.size[0]}\n"+
//                            "sizeMax: ${product.size[1]}\n"+
//                            "status1: ${product.status1}\n"+
//                            "status2: ${product.status2}\n"+
//                            "token: ${product.token}\n"+
//                            "admin_id: ${product.admin_id}"
//                    val getId = findViewById<TextView>(R.id.product_text)
//                    getId.text = text
//                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


}