package com.example.spinnercat.data

import com.example.spinnercat.data.model.BreedsResponse
import retrofit2.Call
import retrofit2.http.GET

interface BreedsService {
    @GET("breeds")
    fun getBreeds() : Call<List<BreedsResponse>>
}