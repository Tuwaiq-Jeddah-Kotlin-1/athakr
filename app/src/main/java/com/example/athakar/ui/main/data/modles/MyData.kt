package com.example.athakar.ui.main.data.modles

import com.google.gson.annotations.SerializedName

data class MyData(

    @SerializedName("body")
    val AnbaiDoaa: List<Doaa>,
    val quranDoaa: List<Doaa>,
    val wakeupDoaa: List<Doaa>,
    val morningDoaa : List<Doaa>,
    val eveningDoaa: List<Doaa>,
    val sleepDoaa:List<Doaa>,
    val afterSalahDoaa:List<Doaa>,
    val TassbDoaa: List<Doaa>


)