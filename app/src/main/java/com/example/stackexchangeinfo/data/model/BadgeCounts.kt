package com.example.stackexchangeinfo.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BadgeCounts(
    @Json(name = "bronze")
    val bronze: Int?,
    @Json(name = "gold")
    val gold: Int?,
    @Json(name = "silver")
    val silver: Int?
)