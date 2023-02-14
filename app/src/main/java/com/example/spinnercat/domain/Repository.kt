package com.example.spinnercat.domain

import com.example.spinnercat.data.model.BreedsResponse
import com.example.spinnercat.data.model.CatResponse

interface Repository {

    suspend fun getBreedsList(): List<BreedsResponse>
    suspend fun getCatImage(id: String): List<CatResponse>
}