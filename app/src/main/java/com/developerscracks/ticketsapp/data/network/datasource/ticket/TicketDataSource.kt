package com.developerscracks.ticketsapp.data.network.datasource.ticket

import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

interface TicketDataSource {

//    val db: CollectionReference

    suspend fun createTicket(ticket: Ticket): Response<Boolean>
//    suspend fun updateTicket(ticket: Ticket): Response<Boolean>
    suspend fun getTickets():Response<List<Ticket>>

}