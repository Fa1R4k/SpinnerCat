package com.example.spinnercat.di

import android.content.Context
import com.example.spinnercat.di.ViewModel.ViewModelModule
import com.example.spinnercat.ui.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelModule::class, NetworkModule::class, DataModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}
