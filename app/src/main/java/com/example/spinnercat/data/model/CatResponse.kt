package com.example.spinnercat.data.model

import com.google.gson.annotations.SerializedName

data class CatResponse(
    @SerializedName("url") val image: String? = null,
)
