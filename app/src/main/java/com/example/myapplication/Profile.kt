package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_team.*

class Profile :AppCompatActivity() {
//    private lateinit var mContext : Context
    private lateinit var sharePref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
        sharePref = getSharedPreferences("nik", Context.MODE_PRIVATE)
        nama.text = sharePref.getString("email",null)
    }
}