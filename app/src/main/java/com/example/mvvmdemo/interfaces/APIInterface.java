package com.example.mvvmdemo.interfaces;

import com.example.mvvmdemo.model.EntryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("entries")
    Call<EntryResponse> callApiEntry();

}