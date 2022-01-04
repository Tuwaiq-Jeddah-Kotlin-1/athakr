package com.example.athakar.ui.main.activity.Api.model

import android.os.Parcelable
 import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Athaker(

    val athaker :List<Categories>
): Parcelable

@Parcelize
data class Categories(

    val name:String,


    val details:List<responceAkthar>
): Parcelable

  @Parcelize
data class responceAkthar(
    val count:String ,
    val description:String,
    val reference:String,
    val content:String,
):Parcelable
