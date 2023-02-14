package com.example.spinnercat.data

import com.example.spinnercat.data.model.CatResponse
import com.example.spinnercat.data.model.BreedsResponse
import com.example.spinnercat.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl : Repository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override suspend fun getCatImage(id : String): List<CatResponse> {

        val service = retrofit.create(CatService::class.java)

        return withContext(Dispatchers.IO) {
            service.getCatImage(id).execute().body() ?: throw Exception()
        }
    }

    override suspend fun getBreedsList(): List<BreedsResponse> {

        val service = retrofit.create(BreedsService::class.java)

        return  withContext(Dispatchers.IO) {
            service.getBreeds().execute().body() ?: throw Exception()
        }
    }
}