package com.example.searchfortickets.airTickets.data.dto

data class OfferFeedDto(
    val offers: List<OfferDto>
)

data class OfferDto(
    val id: Int,
    val title: String,
    val town: String,
    val price: PriceDto
)
data class PriceDto(
    val value: Int
)