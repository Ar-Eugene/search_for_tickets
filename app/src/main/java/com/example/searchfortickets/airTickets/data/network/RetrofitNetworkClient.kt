package com.example.searchfortickets.airTickets.data.network

import com.example.searchfortickets.airTickets.data.dto.OfferFeedJsonResponse
import com.example.searchfortickets.airTickets.data.dto.OfferFeedSearchRequest
import com.example.searchfortickets.airTickets.data.dto.Response

class RetrofitNetworkClient(private val trackApi: IOfferFeedApi) : INetworkClient {

    override suspend fun doRequest(dto: Any): Response {
        if (dto is OfferFeedSearchRequest) {
            return try {
                val response = trackApi.getOfferFeedJson(dto.term)
                // Успешный ответ
                response.apply {
                    resultCode = 200 // Успешный код
                }
            } catch (e: Exception) {
                // Обработка исключений
                OfferFeedJsonResponse(0, emptyList()).apply {
                    resultCode = -1
                    message = "Ошибка: ${e.message}"
                }
            }
        } else {
            // Обработка неверного запроса
            return OfferFeedJsonResponse(0, emptyList()).apply {
                resultCode = 400
                message = "Неверный запрос: ожидался TracksSearchRequest"
            }
        }
    }
}