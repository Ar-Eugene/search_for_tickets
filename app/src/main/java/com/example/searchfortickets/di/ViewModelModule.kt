package com.example.searchfortickets.di

import com.example.searchfortickets.airTickets.ui.view_model.AirTicketsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        AirTicketsViewModel(offerFeedInteractor = get(),)
    }



}