package com.developerscracks.ticketsapp.data.repository.ticket

import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.model.Ticket

interface TicketRepository {
    suspend fun createTicket(ticket: Ticket): Response<Boolean>
}