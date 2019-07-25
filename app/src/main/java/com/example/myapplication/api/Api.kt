package com.example.myapplication.api

import com.example.myapplication.Models.Models
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("login")
    @FormUrlEncoded
    fun Login(
              @Field("username") username:String,
              @Field("password") password:String):Call<Models>
    @GET("profile/{id}")
    fun getProfile(
        @Path("id") id:String
    ) : Call<Models>

    @GET("balance/{id}")
    fun getBalance(
        @Path("id") id:String
    ) : Call<Models>
    @GET("history/{id}")
    fun getHistory(
        @Path("id") id:String
    ):Call<List<Models>>
}