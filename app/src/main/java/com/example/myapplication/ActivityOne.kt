package com.example.myapplication

import android.content.Intent.getIntent
import android.widget.TextView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ActivityOne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

//        val txtInfo = findViewById(R.id.txtInfo) as TextView
//        if (intent != null) {
//            val info = intent.getStringExtra("info")
//            txtInfo.text = info
//        }
    }
}

