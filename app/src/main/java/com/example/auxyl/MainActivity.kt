package com.example.auxyl

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.auxyl.activity.LoginActivity
import com.example.auxyl.activity.MasukActivity
import com.example.auxyl.fragment.AkunFragment
import com.example.auxyl.fragment.HomeFragment
import com.example.auxyl.fragment.KeranjangFragment
import com.example.auxyl.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fhome: Fragment = HomeFragment()
    private val fkeranjang: Fragment = KeranjangFragment()
    private val fakun: Fragment = AkunFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fhome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private var statusLogin = false
    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setUpBottomNav()
    }

    fun setUpBottomNav() {
        fm.beginTransaction().add(R.id.container, fhome).show(fhome).commit()
        fm.beginTransaction().add(R.id.container, fkeranjang).hide(fkeranjang).commit()
        fm.beginTransaction().add(R.id.container, fakun).hide(fakun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    callFragment(0,fhome)
                }
                R.id.navigation_keranjang -> {
                    callFragment(1,fkeranjang)
                }
                R.id.navigation_akun -> {
                    if (s.getStatusLogin()) {
                        callFragment(2,fakun)
                    } else {
                        startActivity(Intent(this, MasukActivity::class.java))
                    }
                }
            }
            false
        }
    }

    fun callFragment(int: Int, frag: Fragment) {
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(frag).commit()
        active = frag
    }

}