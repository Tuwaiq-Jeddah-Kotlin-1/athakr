package com.example.athakar.ui.main.data.network

import com.example.athakar.ui.main.data.modles.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

       @GET("/json/1")
   fun getData(): Call<List<MyData>>



}