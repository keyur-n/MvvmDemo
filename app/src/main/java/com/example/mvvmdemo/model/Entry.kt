package com.example.mvvmdemo.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Entry {
    @SerializedName("API")
    @Expose
    var api: String? = null

    @SerializedName("Description")
    @Expose
    var description: String? = null

    @SerializedName("Auth")
    @Expose
    var auth: String? = null

    @SerializedName("HTTPS")
    @Expose
    var https: Boolean? = null

    @SerializedName("Cors")
    @Expose
    var cors: String? = null

    @SerializedName("Link")
    @Expose
    var link: String? = null

    @SerializedName("Category")
    @Expose
    var category: String? = null
}