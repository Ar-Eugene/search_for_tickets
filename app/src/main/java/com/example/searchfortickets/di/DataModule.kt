package com.example.searchfortickets.di

import android.content.Context
import android.content.SharedPreferences
import com.example.searchfortickets.airTickets.data.network.INetworkClient
import com.example.searchfortickets.airTickets.data.network.IOfferFeedApi
import com.example.searchfortickets.airTickets.data.network.RetrofitNetworkClient
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single { Gson() }

    single {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Ar-Eugene/search_for_tickets/refs/heads/main/jsons/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IOfferFeedApi::class.java)
    }

    single<INetworkClient> {
        RetrofitNetworkClient(offerFeedApi = get())
    }



}