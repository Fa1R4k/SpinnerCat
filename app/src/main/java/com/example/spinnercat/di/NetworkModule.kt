package com.example.spinnercat.di

import com.example.spinnercat.data.BreedsService
import com.example.spinnercat.data.CatService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun getBreedsService(retrofit: Retrofit): BreedsService {
        return retrofit.create(BreedsService::class.java)
    }

    @Provides
    fun getCatService(retrofit: Retrofit): CatService {
        return retrofit.create(CatService::class.java)
    }
}