package com.example.searchfortickets.airTickets.data.dto

class OfferFeedJsonResponse (
    val resultCount: Int,
    val results: List<OfferFeedDto>
) : Response()