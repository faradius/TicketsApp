package com.developerscracks.ticketsapp.domain.use_cases.ticket

data class TicketUseCases(
    val createTicket: CreateTicketUseCase,
    val getTickets: GetListTicketsUseCase
)