package com.example.athakar.ui.main.activity.Api.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroBuilder {

    private const val BASE_URL ="https://oy0ge.mocklab.io/"
    private fun retrofit():Retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val api: AthkarApi =retrofit().create(AthkarApi::class.java)
    }

