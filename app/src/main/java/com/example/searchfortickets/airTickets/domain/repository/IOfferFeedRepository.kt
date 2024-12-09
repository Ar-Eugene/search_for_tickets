package com.example.searchfortickets.airTickets.domain.repository

import com.example.searchfortickets.airTickets.domain.models.OfferFeed
import kotlinx.coroutines.flow.Flow

interface IOfferFeedRepository {
    fun searchOfferFeed(term: String): Flow<List<OfferFeed>>
}