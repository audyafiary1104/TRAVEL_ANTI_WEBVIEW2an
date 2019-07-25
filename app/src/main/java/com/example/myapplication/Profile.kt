package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_team.*

class Profile :AppCompatActivity() {
//    private lateinit var mContext : Context
    private lateinit var sharePref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        sharePref = getSharedPreferences("nik", Context.MODE_PRIVATE)
        email.text = sharePref.getString("email",null)
        agent_code.text = sharePref.getString("agent_code",null)
        nama_profile.text = sharePref.getString("name",null)
        alamat.text = sharePref.getString("alamat",null)
    }
}