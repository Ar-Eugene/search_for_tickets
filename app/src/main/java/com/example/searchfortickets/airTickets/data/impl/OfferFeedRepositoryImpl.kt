package com.example.searchfortickets.airTickets.data.impl

import com.example.searchfortickets.airTickets.data.dto.OfferFeedJsonResponse
import com.example.searchfortickets.airTickets.data.dto.OfferFeedSearchRequest
import com.example.searchfortickets.airTickets.data.network.INetworkClient
import com.example.searchfortickets.airTickets.domain.models.Offer
import com.example.searchfortickets.airTickets.domain.models.OfferFeed
import com.example.searchfortickets.airTickets.domain.models.Price
import com.example.searchfortickets.airTickets.domain.repository.IOfferFeedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OfferFeedRepositoryImpl(private val networkClient: INetworkClient) :IOfferFeedRepository {
    override fun searchOfferFeed(term: String): Flow<List<OfferFeed>> = flow {
        try {
            // Делаем сетевой запрос
            val response = networkClient.doRequest(OfferFeedSearchRequest(term))

            // Проверяем, что ответ - это TracksSearchResponse
            if (response is OfferFeedJsonResponse) {
                when {
                    response.resultCode == -1 -> throw Exception(
                        response.message ?: "Network error"
                    )

                    response.results.isEmpty() -> emit(emptyList())
                    else -> {
                        // Преобразуем данные в список объектов Track
                        val offerFeeds = response.results.mapNotNull { result ->
                            try {
                                OfferFeed(
                                    offers = result.offers.map { offerDto ->
                                        Offer(
                                            id = offerDto.id,
                                            title = offerDto.title,
                                            town = offerDto.town,
                                            price = Price(value = offerDto.price.value)
                                        )
                                    }
                                )
                            } catch (e: Exception) {
                                null // Пропускаем невалидные объекты
                            }
                        }
                        emit(offerFeeds)
                    }
                }
            } else {
                throw Exception("Unexpected response type: ${response::class.java.simpleName}")
            }
        } catch (e: Exception) {
            // Пробрасываем исключение дальше
            throw Exception("Exception occurred: ${e.message}")
        }
    }
}