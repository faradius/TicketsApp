package com.developerscracks.ticketsapp.domain.use_cases.ticket

import com.developerscracks.ticketsapp.data.repository.ticket.TicketRepository
import javax.inject.Inject

class GetListTicketsUseCase @Inject constructor(private val ticketRepository: TicketRepository){
    suspend operator fun invoke() =  ticketRepository.getTickets()
}