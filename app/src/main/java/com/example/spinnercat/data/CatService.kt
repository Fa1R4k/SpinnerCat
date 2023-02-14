package com.example.spinnercat.data

import com.example.spinnercat.data.model.CatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("images/search")
    fun getCatImage(@Query("breed_ids") id: String) : Call<List<CatResponse>>
}
