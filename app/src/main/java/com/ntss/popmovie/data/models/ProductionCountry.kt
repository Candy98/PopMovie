package com.ntss.popmovie.data.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("name")
    val name: String
)