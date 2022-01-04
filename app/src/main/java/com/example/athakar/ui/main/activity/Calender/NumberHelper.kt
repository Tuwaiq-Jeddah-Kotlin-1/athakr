package com.example.athakar.ui.main.activity.Calender

import java.util.*

class NumberHelper {
    companion object {
        fun getArabicNumber(num: Int): String {
            val locale = Locale("ar")
            return String.format(locale, "%d", num)
        }

        fun getTimeArabicNumber(num: Int): String{
            val locale = Locale("ar")
            return String.format(locale, "%02d", num)
        }
    }
}