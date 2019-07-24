package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Build
import android.util.Log
import android.view.View
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.myapplication.Models.Models
import com.example.myapplication.SharedPrefrence.Shared
import com.example.myapplication.api.Api
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson




class LoginActivity : AppCompatActivity() {
    private var share: Shared? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //for changing status bar icon colors
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        setContentView(R.layout.activity_login)
        share = Shared(this)
        cirLoginButton.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                kirimdata()
            }

        })
    }
    private fun kirimdata(){

        val username = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()
        val retrofit = Retrofit.Builder().baseUrl("http://172.16.10.16:8000/api/").addConverterFactory(GsonConverterFactory.create()).build()
        val apake = retrofit.create(Api::class.java)
        apake.Login("${username}","${password}")
            .enqueue(object :Callback<Models>{
                override fun onFailure(call: Call<Models>?, t: Throwable?) {
                    Log.e("TAG", "onFailure: "+t.toString() )
                    SweetAlertDialog(this@LoginActivity,SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Something went wrong!")
                        .show()
                }

                override fun onResponse(call: Call<Models>?, response: Response<Models>?) {
                        share!!.updateSetting("nama",response!!.body().id)
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))

                }

            })
    }
}