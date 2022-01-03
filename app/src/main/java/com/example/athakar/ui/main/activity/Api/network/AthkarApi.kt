package com.example.athakar.ui.main.activity.Api.network

import retrofit2.http.GET


interface AthkarApi {

    @GET("/json/1")
     suspend fun getAkthar():Athaker

}