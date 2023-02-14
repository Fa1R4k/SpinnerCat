package com.example.spinnercat.data.model

import com.google.gson.annotations.SerializedName

data class BreedsResponse(
    @SerializedName("name") val breed: String? = null,
    @SerializedName("id") val breedId: String? = null,
)
