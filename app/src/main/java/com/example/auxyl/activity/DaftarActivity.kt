package com.example.auxyl.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.auxyl.R
import com.example.auxyl.app.ApiConfig
import kotlinx.android.synthetic.main.activity_daftar.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        btn_daftar.setOnClickListener{
            register()
        }

        btn_google.setOnClickListener{
            dataDummy()
        }
    }

    fun dataDummy(){
        edit_nama.setText("admin")
        edit_email.setText("admin@gmail.com")
        edit_phone.setText("0987654321")
        edit_pass.setText("admin123")
    }

    fun register(){
        if(edit_nama.text.isEmpty()){
            edit_nama.error = "Nama tidak boleh kosong!"
            edit_nama.requestFocus()
            return
        } else if(edit_email.text.isEmpty()){
            edit_email.error = "Email tidak boleh kosong!"
            edit_email.requestFocus()
            return
        } else if(edit_phone.text.isEmpty()){
            edit_phone.error = "Nomor Telepon tidak boleh kosong!"
            edit_phone.requestFocus()
            return
        } else if(edit_pass.text.isEmpty()) {
            edit_phone.error = "Password tidak boleh kosong!"
            edit_pass.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.daftar(edit_nama.text.toString(),edit_email.text.toString(),edit_pass.text.toString()).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@DaftarActivity,"Error:"+t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Toast.makeText(this@DaftarActivity,"Success!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}