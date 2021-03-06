package com.example.auxyl.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import kotlin.math.log

class SharedPref(activity: Activity) {
    val mypref = "MAIN_PREF"
    val sp:SharedPreferences
    val login = "login"

    init {
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status:Boolean){
        sp.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin():Boolean {
        return sp.getBoolean(login, false)
    }
}