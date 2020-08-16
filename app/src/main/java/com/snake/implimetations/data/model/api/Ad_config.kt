package com.snake.implimetations.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ad_config {
    @SerializedName("safeFlags")
    @Expose
    val safeFlags: List<String> = ArrayList<String>()

    @SerializedName("highRiskFlags")
    @Expose
    val highRiskFlags: List<String> = ArrayList<String>()

    @SerializedName("unsafeFlags")
    @Expose
    val unsafeFlags: List<String> = ArrayList<String>()

    @SerializedName("wallUnsafeFlags")
    @Expose
    val wallUnsafeFlags: List<String> = ArrayList<String>()

    @SerializedName("showsAds")
    @Expose
    val showsAds: Boolean = false

}