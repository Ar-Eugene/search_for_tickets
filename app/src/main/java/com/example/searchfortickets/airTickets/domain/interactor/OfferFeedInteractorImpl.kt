package com.example.searchfortickets.airTickets.domain.interactor

import com.example.searchfortickets.airTickets.domain.models.OfferFeed
import com.example.searchfortickets.airTickets.domain.repository.IOfferFeedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OfferFeedInteractorImpl(private val repository: IOfferFeedRepository):IOfferFeedInteractor {
    override fun searchOfferFeed(term: String): Flow<Pair<List<OfferFeed>?, String?>> = flow {
        try {
            repository.searchOfferFeed(term)
                .collect { offerFeed ->
                    if (offerFeed.isEmpty()) {
                        emit(null to "No results found") // Пустой список с сообщением об ошибке
                    } else {
                        emit(offerFeed to null) // Успешный результат без сообщения об ошибке
                    }
                }
        } catch (e: Exception) {
            emit(null to "Network error: ${e.message}") // Ошибка сети
        }
    }
}