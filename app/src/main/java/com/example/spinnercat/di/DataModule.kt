package com.example.spinnercat.di

import com.example.spinnercat.data.RepositoryImpl
import com.example.spinnercat.domain.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun getRepository(impl: RepositoryImpl): Repository
}