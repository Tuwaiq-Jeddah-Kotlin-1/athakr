package com.example.athakar.ui.main.activity.Api.network

import com.google.gson.annotations.SerializedName


data class Athaker(

    val athaker :List<Categories>
)


data class Categories(

    val name:String,

    val details:List<responceAkthar>
)


data class responceAkthar(
    val count:String ,
    val description:String,
    val reference:String,
    val content:String,
)
