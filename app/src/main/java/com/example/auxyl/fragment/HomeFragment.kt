package com.example.auxyl.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.auxyl.R
import com.example.auxyl.adapter.AdapterProduk
import com.example.auxyl.model.Produk
import com.inyongtisto.tutorial.adapter.AdapterSlider

class HomeFragment : Fragment() {
    
    lateinit var vpSlider: ViewPager
    lateinit var rvProduk: RecyclerView
    lateinit var rvKaos: RecyclerView
    lateinit var rvTotebag: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)
        rvKaos = view.findViewById(R.id.rv_kaos)
        rvTotebag = view.findViewById(R.id.rv_totebag)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider)
        arrSlider.add(R.drawable.slider)
        arrSlider.add(R.drawable.slider)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

        rvKaos.adapter = AdapterProduk(arrKaos)
        rvKaos.layoutManager = layoutManager2

        rvTotebag.adapter = AdapterProduk(arrTotebag)
        rvTotebag.layoutManager = layoutManager3

        return view
    }

    val arrProduk: ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.namaProduk = "Kaos Masa"
        p1.hargaProduk = "Rp.90.000"
        p1.gambarProduk = R.drawable.p1

        val p2 = Produk()
        p2.namaProduk = "Kaos 2"
        p2.hargaProduk = "Rp.90.000"
        p2.gambarProduk = R.drawable.p2

        val p3 = Produk()
        p3.namaProduk = "Kaos 3"
        p3.hargaProduk = "Rp.90.000"
        p3.gambarProduk = R.drawable.p3

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }

    val arrKaos: ArrayList<Produk>get() {
        val arr2 = ArrayList<Produk>()
        val k1 = Produk()
        k1.namaProduk = "Kaos Masa"
        k1.hargaProduk = "Rp.90.000"
        k1.gambarProduk = R.drawable.p1

        val k2 = Produk()
        k2.namaProduk = "Kaos 2"
        k2.hargaProduk = "Rp.90.000"
        k2.gambarProduk = R.drawable.p2

        val k3 = Produk()
        k3.namaProduk = "Kaos 3"
        k3.hargaProduk = "Rp.90.000"
        k3.gambarProduk = R.drawable.p3

        arr2.add(k1)
        arr2.add(k2)
        arr2.add(k3)

        return arr2
    }

    val arrTotebag: ArrayList<Produk>get() {
        val arr3 = ArrayList<Produk>()
        val t1 = Produk()
        t1.namaProduk = "Kaos Masa"
        t1.hargaProduk = "Rp.90.000"
        t1.gambarProduk = R.drawable.p1

        val t2 = Produk()
        t2.namaProduk = "Kaos 2"
        t2.hargaProduk = "Rp.90.000"
        t2.gambarProduk = R.drawable.p2

        val t3 = Produk()
        t3.namaProduk = "Kaos 3"
        t3.hargaProduk = "Rp.90.000"
        t3.gambarProduk = R.drawable.p3

        arr3.add(t1)
        arr3.add(t2)
        arr3.add(t3)

        return arr3
    }

}