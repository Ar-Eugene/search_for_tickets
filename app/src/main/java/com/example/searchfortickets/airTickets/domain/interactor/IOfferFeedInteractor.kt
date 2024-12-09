package com.example.searchfortickets.airTickets.domain.interactor

import com.example.searchfortickets.airTickets.domain.models.OfferFeed
import kotlinx.coroutines.flow.Flow

interface IOfferFeedInteractor {
    fun searchOfferFeed(term: String): Flow<Pair<List<OfferFeed>?, String?>>
}