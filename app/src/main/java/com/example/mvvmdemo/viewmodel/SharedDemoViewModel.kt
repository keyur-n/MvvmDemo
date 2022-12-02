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

class SharedDemoViewModel:ViewModel() {
    var userName: MutableLiveData<String> = MutableLiveData("")
}