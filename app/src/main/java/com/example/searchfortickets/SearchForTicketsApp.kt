package com.example.searchfortickets

import android.app.Application
import com.example.searchfortickets.di.dataModule
import com.example.searchfortickets.di.interactorModule
import com.example.searchfortickets.di.repositoryModule
import com.example.searchfortickets.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SearchForTicketsApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SearchForTicketsApp)
            modules(dataModule, interactorModule, repositoryModule, viewModelModule)
        }
    }
}