package com.ntss.popmovie.data.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)