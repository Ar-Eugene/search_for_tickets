package com.example.searchfortickets.airTickets.data.network

import com.example.searchfortickets.airTickets.data.dto.OfferFeedJsonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IOfferFeedApi {
    @GET("main/jsons/main.json")
    suspend fun getOfferFeedJson(@Query("term") text: String): OfferFeedJsonResponse
}