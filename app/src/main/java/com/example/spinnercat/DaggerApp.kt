package com.example.spinnercat

import android.app.Application
import com.example.spinnercat.di.ApplicationComponent
import com.example.spinnercat.di.DaggerApplicationComponent

class DaggerApp : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}