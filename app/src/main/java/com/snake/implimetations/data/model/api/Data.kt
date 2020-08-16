package com.snake.implimetations.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {
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

    @SerializedName("cover")
    @Expose
    val cover: String = ""

    @SerializedName("cover_width")
    @Expose
    val cover_width: Int = 0

    @SerializedName("cover_height")
    @Expose
    val cover_height: Int = 0

    @SerializedName("account_url")
    @Expose
    val account_url: String = ""

    @SerializedName("account_id")
    @Expose
    val account_id: Int = 0

    @SerializedName("privacy")
    @Expose
    val privacy: String = ""

    @SerializedName("layout")
    @Expose
    val layout: String = ""

    @SerializedName("views")
    @Expose
    val views: Int = 0

    @SerializedName("link")
    @Expose
    val link: String = ""

    @SerializedName("ups")
    @Expose
    val ups: Int = 0

    @SerializedName("downs")
    @Expose
    val downs: Int = 0

    @SerializedName("points")
    @Expose
    val points: Int = 0

    @SerializedName("score")
    @Expose
    val score: Int = 0

    @SerializedName("is_album")
    @Expose
    val is_album: Boolean = false

    @SerializedName("vote")
    @Expose
    val vote: String = ""

    @SerializedName("favorite")
    @Expose
    val favorite: Boolean = false

    @SerializedName("nsfw")
    @Expose
    val nsfw: Boolean = false

    @SerializedName("section")
    @Expose
    val section: String = ""

    @SerializedName("comment_count")
    @Expose
    val comment_count: Int = 0

    @SerializedName("favorite_count")
    @Expose
    val favorite_count: Int = 0

    @SerializedName("topic")
    @Expose
    val topic: String = ""

    @SerializedName("topic_id")
    @Expose
    val topic_id: Int = 0

    @SerializedName("images_count")
    @Expose
    val images_count: Int = 0

    @SerializedName("in_gallery")
    @Expose
    val in_gallery: Boolean = false

    @SerializedName("is_ad")
    @Expose
    val is_ad: Boolean = false

    @SerializedName("tags")
    @Expose
    val tags: List<Any> = ArrayList()

    @SerializedName("ad_type")
    @Expose
    val ad_type: Int = 0

    @SerializedName("ad_url")
    @Expose
    val ad_url: String = ""

    @SerializedName("in_most_viral")
    @Expose
    val in_most_viral: Boolean = false

    @SerializedName("include_album_ads")
    @Expose
    val include_album_ads: Boolean = false

    @SerializedName("images")
    @Expose
    val images: List<Images> = listOf(Images())

    @SerializedName("ad_config")
    @Expose
    val ad_config: Ad_config = Ad_config()

}