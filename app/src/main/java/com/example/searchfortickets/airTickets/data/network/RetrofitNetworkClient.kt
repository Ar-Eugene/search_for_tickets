package com.example.searchfortickets.airTickets.data.network

import android.util.Log
import com.example.searchfortickets.airTickets.data.dto.OfferFeedJsonResponse
import com.example.searchfortickets.airTickets.data.dto.OfferFeedSearchRequest
import com.example.searchfortickets.airTickets.data.dto.Response

class RetrofitNetworkClient(private val offerFeedApi: IOfferFeedApi) : INetworkClient {

    override suspend fun doRequest(dto: Any): Response {
        if (dto is OfferFeedSearchRequest) {
            return try {
                val response = offerFeedApi.getOfferFeedJson()
                // Успешный ответ
                response.apply {
                    resultCode = 200 // Успешный код
                }
            } catch (e: Exception) {
                Log.e("NetworkClient", "Request failed", e)
                // Обработка исключений
                OfferFeedJsonResponse(0, emptyList()).apply {
                    resultCode = -1
                    message = "Ошибка: ${e.message}"
                }
            }
        } else {
            Log.e("NetworkClient", "Invalid request type: $dto")
            // Обработка неверного запроса
            return OfferFeedJsonResponse(0, emptyList()).apply {
                resultCode = 400
                message = "Неверный запрос: ожидался OfferFeedSearchRequest"
            }
        }
    }
}