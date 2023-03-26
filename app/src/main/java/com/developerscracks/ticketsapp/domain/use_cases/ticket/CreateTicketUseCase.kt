package com.developerscracks.ticketsapp.domain.use_cases.ticket

import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.developerscracks.ticketsapp.data.repository.ticket.TicketRepository
import javax.inject.Inject

class CreateTicketUseCase @Inject constructor(private val ticketRespository: TicketRepository){
    suspend operator fun invoke(ticket:Ticket) = ticketRespository.createTicket(ticket)
}