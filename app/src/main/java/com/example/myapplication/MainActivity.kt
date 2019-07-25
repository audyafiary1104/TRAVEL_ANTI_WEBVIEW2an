package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.Toast
import com.example.myapplication.Models.Models
import com.example.myapplication.SharedPrefrence.Shared
import com.example.myapplication.api.Api
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    internal lateinit var mainGrid: GridLayout
    private var share : Shared?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainGrid = findViewById(R.id.mainGrid) as GridLayout
        share = Shared(this)
        //Set Event
        setSingleEvent(mainGrid)
        //setToggleEvent(mainGrid);
    }

    private fun setToggleEvent(mainGrid: GridLayout) {
        //Loop all child item of Main Grid
        for (i in 0 until mainGrid.getChildCount()) {
            //You can see , all child item is CardView , so we just cast object to CardView
            val cardView = mainGrid.getChildAt(i) as androidx.cardview.widget.CardView
            cardView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() === -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"))
                        Toast.makeText(this@MainActivity, "State : True", Toast.LENGTH_SHORT).show()

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                        Toast.makeText(this@MainActivity, "State : False", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    private fun setSingleEvent(mainGrid: GridLayout) {
        //Loop all child item of Main Grid
        for (i in 0 until mainGrid.getChildCount()) {

            tf_balance.setOnClickListener(object :View.OnClickListener{
                override fun onClick(v: View?) {
                    tfbalance()
                }

            })
            history.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    getHistory()
                }

            })
            my_balance.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                        getBalance()
                }

            })
            //You can see , all child item is CardView , so we just cast object to CardView
            profile.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    ProfileId()
                }

            })
        }
    }
    private fun getBalance(){
        var a =  share!!.readSetting("id")
        var retrofit = Retrofit.Builder().baseUrl("http://172.16.10.56:8000/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val apake = retrofit.create(Api::class.java)
        apake.getBalance("${a}").enqueue(object : Callback<Models>{
            override fun onFailure(call: Call<Models>?, t: Throwable?) {
                Log.e("TAG", "onFailure: "+t.toString() )

            }

            override fun onResponse(call: Call<Models>?, response: Response<Models>?) {
                share!!.updateSetting("balance",response!!.body().balance)
                startActivity(Intent(this@MainActivity,BalanceActivity::class.java))

            }

        })
    }
    private fun tfbalance(){
        startActivity(Intent(this@MainActivity,TransferBalance::class.java))

    }
    private fun ProfileId(){
       var a =  share!!.readSetting("id")
        var retrofit = Retrofit.Builder().baseUrl("http://172.16.10.56:8000/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            val apake = retrofit.create(Api::class.java)
        apake.getProfile("${a}").enqueue(object :Callback<Models>{
            override fun onFailure(call: Call<Models>?, t: Throwable?) {
                Log.e("TAG", "onFailure: "+t.toString() )
            }

            override fun onResponse(call: Call<Models>?, response: Response<Models>?) {
                Log.e("TAG", "onFailure: "+response!!.body().email )
                share!!.updateSetting("email",response!!.body().email)
                share!!.updateSetting("company",response!!.body().company)
                share!!.updateSetting("name",response!!.body().name)
                share!!.updateSetting("alamat",response!!.body().alamat)
                startActivity(Intent(this@MainActivity,Profile::class.java))
            }

        })
    }
    private fun getHistory(){
        var a =  share!!.readSetting("id")
        var retrofit = Retrofit.Builder().baseUrl("http://172.16.10.56:8000/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        var api = retrofit.create(Api::class.java)
        api.getHistory("${a}").enqueue(object : Callback<List<Models>>{
            override fun onFailure(call: Call<List<Models>>?, t: Throwable?) {
                Log.e("TAG", "onFailure: "+t.toString() )
            }

            override fun onResponse(call: Call<List<Models>>?, response: Response<List<Models>>?) {

                for (data in response!!.body()){
                    share!!.updateSetting("check_in",data!!.check_in)
                share!!.updateSetting("check_out",data!!.check_out)
                share!!.updateSetting("first_name",data!!.first_name)
                share!!.updateSetting("last_name",data.last_name)
                share!!.updateSetting("jumlah_dibayar",data.jumlah_dibayar)
                share!!.updateSetting("nama_hotels",data.nama_hotels)
                share!!.updateSetting("nomor_booking",data.nomor_booking)
                share!!.updateSetting("type_room",data.type_room)
                    startActivity(Intent(this@MainActivity,HistoryActivity::class.java))
                }
            }


        })
    }
}
