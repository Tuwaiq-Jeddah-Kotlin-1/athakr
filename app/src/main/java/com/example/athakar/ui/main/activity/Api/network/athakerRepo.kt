package com.example.athakar.ui.main.activity.Api.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class athakerRepo {

    private val api = RetroBuilder.api

    suspend fun fetchInterestingList(): Athaker = withContext(Dispatchers.IO) {
        api.getAkthar()
    }



}