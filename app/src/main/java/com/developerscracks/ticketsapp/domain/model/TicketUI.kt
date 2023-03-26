package com.developerscracks.ticketsapp.domain.model

import android.os.Parcelable
import com.developerscracks.ticketsapp.data.network.model.Ticket
import kotlinx.parcelize.Parcelize


data class TicketUI(
    val numTicket: String,
    val titleTicket: String,
    val incidentType: String,
    val severityIncident: String,
)

fun Ticket.toTicketSimpleUI(): TicketUI{
    return TicketUI(
        numTicket = this.numTicket,
        titleTicket = this.titleTicket,
        incidentType = this.incidentType,
        severityIncident = this.severityIncident
    )
}
