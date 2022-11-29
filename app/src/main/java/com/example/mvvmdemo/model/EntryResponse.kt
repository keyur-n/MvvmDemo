package com.example.mvvmdemo.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class EntryResponse {
    @SerializedName("entries")
    @Expose
    var entries = ArrayList<Entry>()
}