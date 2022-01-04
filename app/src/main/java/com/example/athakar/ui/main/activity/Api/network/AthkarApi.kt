package com.example.athakar.ui.main.activity.Api.network

import com.example.athakar.ui.main.activity.Api.model.Athaker
import retrofit2.http.GET


interface AthkarApi {

    @GET("/json/1")
     suspend fun getAkthar(): Athaker

}