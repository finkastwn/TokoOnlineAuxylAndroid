package com.example.auxyl.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auxyl.R
import com.example.auxyl.model.Produk

class AdapterProduk(var data:ArrayList<Produk>):RecyclerView.Adapter<AdapterProduk.Holder>() {

    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_namaProduk)
        val tvHarga = view.findViewById<TextView>(R.id.tv_hargaProduk)
        val imgProduk = view.findViewById<ImageView>(R.id.tv_gambarProduk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].namaProduk
        holder.tvHarga.text = data[position].hargaProduk
        holder.imgProduk.setImageResource(data[position].gambarProduk)
    }
}