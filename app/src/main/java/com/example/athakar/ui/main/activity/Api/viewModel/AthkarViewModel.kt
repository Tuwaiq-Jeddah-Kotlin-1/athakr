package com.example.athakar.ui.main.activity.Api.viewModel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.athakar.ui.main.activity.Api.network.responceAkthar

class AthkarViewModel: BaseObservable() {

    var vmAthkar: responceAkthar? = null

      set(vmAthkar){

    field = vmAthkar
    notifyChange()

      }

    @get:Bindable


    val count:String?
    get() = vmAthkar?.count

    val description:String?
    get() = vmAthkar?.description


    val reference:String?
    get() = vmAthkar?.reference


    val content:String?
    get() = vmAthkar?.content




}