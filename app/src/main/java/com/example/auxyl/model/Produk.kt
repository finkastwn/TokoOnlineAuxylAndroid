package com.example.auxyl.model

import java.io.Serializable

class Produk: Serializable{
    lateinit var namaProduk:String
    lateinit var hargaProduk:String
    var gambarProduk:Int = 0
}