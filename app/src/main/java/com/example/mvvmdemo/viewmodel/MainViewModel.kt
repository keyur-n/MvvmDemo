package com.example.mvvmdemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.network.APIClient.client
import com.example.mvvmdemo.newtwork.ApiState
import com.example.mvvmdemo.interfaces.APIInterface
import com.example.mvvmdemo.model.EntryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class MainViewModel:ViewModel() {
    var listEntry: MutableLiveData<ApiState> = MutableLiveData(ApiState.Empty)

    fun callApiEntry() = viewModelScope.launch(Dispatchers.IO) {
        try {
            updateState(ApiState.Loading)
            val apiInterface = client!!.create(APIInterface::class.java)
            val call: Call<EntryResponse> = apiInterface.callApiEntry()
            val response = call.execute()
            val apiState=if (response.isSuccessful) {
                ApiState.Success(response.body().entries)
            } else {
                ApiState.Failure("Error")
            }
            updateState(apiState)

        } catch (e: Exception) {
            Log.e("HomeViewModelException",e.message?:"No messsage");
        }
    }
    private fun updateState(apiState: ApiState) = viewModelScope.launch(Dispatchers.Main){
        listEntry.value = apiState
    }
}