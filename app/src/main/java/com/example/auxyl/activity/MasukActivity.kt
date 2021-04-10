package com.example.auxyl.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.auxyl.R
import com.example.auxyl.helper.SharedPref
import kotlinx.android.synthetic.main.activity_masuk.*

class MasukActivity : AppCompatActivity() {

    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        s = SharedPref(this)

        mainButton()
    }

    private fun mainButton(){
        btn_prosesLogin.setOnClickListener{
            s.setStatusLogin(true)
        }

        btn_prosesDaftar.setOnClickListener{
            startActivity(Intent(this, DaftarActivity::class.java))
        }
    }
}