package com.example.searchfortickets.airTickets.data.dto

data class OfferFeedDto(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price
)
data class Price(
    val value: Int
)