package com.example.myapplication.Models

import com.google.gson.annotations.SerializedName

class Models {
    @SerializedName("username")
    lateinit var username: String

    @SerializedName("status")
    lateinit var status: String

    @SerializedName("id")

    lateinit var id: String

    @SerializedName("agent_code")
    lateinit var agent_code: String

    @SerializedName("alamat")
    lateinit var alamat: String

    @SerializedName("email")
    lateinit var email: String

    @SerializedName("company")
    lateinit var company: String

    @SerializedName("name")
    lateinit var name: String
    @SerializedName("balance")
    lateinit var balance: String

    constructor(){}
    constructor(username: String, status: String,id:String,agent_code:String,alamat:String,email:String,company:String,name:String,balance:String){
        this.username = username
        this.status = status
        this.id = id
        this.agent_code = agent_code
        this.alamat = alamat
        this.email = email
        this.company = company
        this.name = name
        this.balance = name

    }

}