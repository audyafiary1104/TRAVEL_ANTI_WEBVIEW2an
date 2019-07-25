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
    @SerializedName("jumlah_dibayar")
    lateinit var jumlah_dibayar: String

    @SerializedName("check_in")
    lateinit var check_in: String

    @SerializedName("check_out")
    lateinit var check_out: String

    @SerializedName("first_name")
    lateinit var first_name: String

    @SerializedName("last_name")
    lateinit var last_name: String

    @SerializedName("nama_hotels")
    lateinit var nama_hotels: String

    @SerializedName("type_room")
    lateinit var type_room: String

    @SerializedName("nomor_booking")
    lateinit var nomor_booking: String
    constructor(){}
    constructor(username: String, status: String,id:String,agent_code:String,alamat:String,
                email:String,company:String,name:String,balance:String,
                jumlah_dibayar:String,check_in:String,check_out:String,first_name:String,last_name:String,nama_hotels:String
                ,type_room:String,nomor_booking:String){
        this.username = username
        this.status = status
        this.id = id
        this.agent_code = agent_code
        this.alamat = alamat
        this.email = email
        this.company = company
        this.name = name
        this.balance = balance
        this.jumlah_dibayar = jumlah_dibayar
        this.check_in = check_in
        this.check_out = check_out
        this.first_name = first_name
        this.last_name = last_name
        this.nama_hotels = nama_hotels
        this.type_room = type_room
        this.nomor_booking = nomor_booking
    }

}