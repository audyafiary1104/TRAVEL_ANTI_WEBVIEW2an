package com.example.myapplication.SharedPrefrence

import android.content.Context
import android.content.SharedPreferences

class Shared {
    internal lateinit var mContext : Context
    private lateinit var sharePref: SharedPreferences
    constructor(context: Context){
        mContext = context
        sharePref = mContext.getSharedPreferences("nik", Context.MODE_PRIVATE)
    }
    fun readSetting(key: String):String{
        return sharePref.getString(key, "na")
    }
    fun updateSetting(key: String, value: String){
        val editor = sharePref.edit()
        editor.putString(key, value)
        editor.apply()
    }
        fun deleteAllSetting(){
        sharePref.edit().remove("nik").commit()
    }
}