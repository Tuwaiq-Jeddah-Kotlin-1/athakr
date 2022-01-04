package com.example.athakar.ui.main.activity.Api.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.athakar.ui.main.activity.Api.model.Athaker
import com.example.athakar.ui.main.activity.Api.network.athakerRepo
import kotlinx.coroutines.launch

class MainVM : ViewModel() {
    val repo = athakerRepo()

    fun fetchInterestingList(): LiveData<Athaker> {

        val athkarr = MutableLiveData<Athaker>()
        viewModelScope.launch {

            try {
                athkarr.postValue(repo.fetchInterestingList())
            }
            catch (e: Throwable) {
                Log.e("Athkar","Athkar error: ${e.localizedMessage}")
            }

        }
        return athkarr
    }
}









