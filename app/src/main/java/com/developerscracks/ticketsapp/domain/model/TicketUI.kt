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
        numTicket = this.numTicket.orEmpty(),
        titleTicket = this.titleTicket.orEmpty(),
        incidentType = this.incidentType.orEmpty(),
        severityIncident = this.severityIncident.orEmpty()
    )
}
