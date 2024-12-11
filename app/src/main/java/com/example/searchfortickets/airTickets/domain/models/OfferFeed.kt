package com.example.searchfortickets.airTickets.domain.models


data class OfferFeed(
    val offers: List<Offer>
)

data class Offer(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price
)

data class Price(
    val value: Int
)