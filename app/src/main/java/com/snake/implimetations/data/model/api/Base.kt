package com.snake.implimetations.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Base {
    @SerializedName("data")
    @Expose
    val data: List<Data> = ArrayList<Data>()

    @SerializedName("success")
    @Expose
    val success: Boolean = false

    @SerializedName("status")
    @Expose
    val status: Int = 0

}
