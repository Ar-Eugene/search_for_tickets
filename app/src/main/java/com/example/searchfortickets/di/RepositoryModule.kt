package com.example.searchfortickets.di

import com.example.searchfortickets.airTickets.data.impl.OfferFeedRepositoryImpl
import com.example.searchfortickets.airTickets.domain.repository.IOfferFeedRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<IOfferFeedRepository> {
        OfferFeedRepositoryImpl(networkClient = get())
    }

}