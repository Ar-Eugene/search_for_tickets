package com.example.searchfortickets.airTickets.data.network

import com.example.searchfortickets.airTickets.data.dto.Response

interface INetworkClient {
    suspend fun doRequest(dto: Any): Response
}