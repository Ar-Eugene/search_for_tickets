package com.example.searchfortickets.di

import com.example.searchfortickets.airTickets.domain.interactor.IOfferFeedInteractor
import com.example.searchfortickets.airTickets.domain.interactor.OfferFeedInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    factory<IOfferFeedInteractor> {
        OfferFeedInteractorImpl(repository = get())
    }

}