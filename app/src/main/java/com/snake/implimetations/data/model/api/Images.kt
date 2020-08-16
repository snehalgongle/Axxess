package com.snake.implimetations.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Images {
    @SerializedName("id")
    @Expose
    val id: String = ""
    @SerializedName("title")
    @Expose
    val title: String = ""
    @SerializedName("description")
    @Expose
    val description: String = ""
    @SerializedName("datetime")
    @Expose
    val datetime: Int = 0
    @SerializedName("type")
    @Expose
    val type: String = ""
    @SerializedName("animated")
    @Expose
    val animated: Boolean = false
    @SerializedName("width")
    @Expose
    val width: Int = 0
    @SerializedName("height")
    @Expose
    val height: Int = 0
    @SerializedName("size")
    @Expose
    val size: Int = 0
    @SerializedName("views")
    @Expose
    val views: Int = 0
    @SerializedName("bandwidth")
    @Expose
    val bandwidth: Long = 0
    @SerializedName("vote")
    @Expose
    val vote: String = ""
    @SerializedName("favorite")
    @Expose
    val favorite: Boolean = false
    @SerializedName("nsfw")
    @Expose
    val nsfw: String = ""
    @SerializedName("section")
    @Expose
    val section: String = ""
    @SerializedName("account_url")
    @Expose
    val account_url: String = ""
    @SerializedName("account_id")
    @Expose
    val account_id: String = ""
    @SerializedName("is_ad")
    @Expose
    val is_ad: Boolean = false
    @SerializedName("in_most_viral")
    @Expose
    val in_most_viral: Boolean = false
    @SerializedName("has_sound")
    @Expose
    val has_sound: Boolean = false
    @SerializedName("tags")
    @Expose
    val tags: List<String> = ArrayList<String>()
    @SerializedName("ad_type")
    @Expose
    val ad_type: Int = 0
    @SerializedName("ad_url")
    @Expose
    val ad_url: String = ""
    @SerializedName("edited")
    @Expose
    val edited: Int = 0
    @SerializedName("in_gallery")
    @Expose
    val in_gallery: Boolean = false
    @SerializedName("link")
    @Expose
    val link: String = ""
    @SerializedName("mp4")
    @Expose
    val mp4: String = ""
    @SerializedName("gifv")
    @Expose
    val gifv: String = ""
    @SerializedName("hls")
    @Expose
    val hls: String = ""
    @SerializedName("mp4_size")
    @Expose
    val mp4_size: Int = 0
    @SerializedName("looping")
    @Expose
    val looping: Boolean = false
    @SerializedName("processing")
    @Expose
    val processing: Processing = Processing()
    @SerializedName("comment_count")
    @Expose
    val comment_count: String = ""
    @SerializedName("favorite_count")
    @Expose
    val favorite_count: String = ""
    @SerializedName("ups")
    @Expose
    val ups: String = ""
    @SerializedName("downs")
    @Expose
    val downs: String = ""
    @SerializedName("points")
    @Expose
    val points: String = ""
    @SerializedName("score")
    @Expose
    val score: String = ""

}