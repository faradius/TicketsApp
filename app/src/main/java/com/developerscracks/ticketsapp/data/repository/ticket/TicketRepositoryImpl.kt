package com.developerscracks.ticketsapp.data.repository.ticket

import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.datasource.ticket.TicketDataSource
import com.developerscracks.ticketsapp.data.network.model.Ticket
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(private val ticketDataSource: TicketDataSource): TicketRepository {
    override suspend fun createTicket(ticket: Ticket): Response<Boolean> {
        return ticketDataSource.createTicket(ticket)
    }

    override suspend fun getTickets(): Response<List<Ticket>> {
        return ticketDataSource.getTickets()
    }
}