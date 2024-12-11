package com.example.searchfortickets.airTickets.data.network

import com.example.searchfortickets.airTickets.data.dto.OfferFeedJsonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IOfferFeedApi {
    @GET("main.json")
    //@GET("refs/heads/main/jsons/main.json")
    suspend fun getOfferFeedJson(): OfferFeedJsonResponse
}