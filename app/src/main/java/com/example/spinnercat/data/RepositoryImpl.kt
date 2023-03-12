package com.example.spinnercat.data

import com.example.spinnercat.data.model.CatResponse
import com.example.spinnercat.data.model.BreedsResponse
import com.example.spinnercat.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val breedsService: BreedsService,
    private val catService: CatService,
) : Repository {

    override suspend fun getCatImage(id: String): List<CatResponse> = withContext(Dispatchers.IO) {
        catService.getCatImage(id).execute().body() ?: throw Exception()
    }

    override suspend fun getBreedsList(): List<BreedsResponse> = withContext(Dispatchers.IO) {
        breedsService.getBreeds().execute().body() ?: throw Exception()
    }
}