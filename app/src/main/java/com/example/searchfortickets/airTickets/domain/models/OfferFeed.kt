package com.example.searchfortickets.airTickets.domain.models

class OfferFeed (
    val id: Int,
    val title: String,
    val town: String,
    val price: Price
)
data class Price(
    val value: Int
)