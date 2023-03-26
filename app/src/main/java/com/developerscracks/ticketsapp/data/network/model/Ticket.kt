package com.developerscracks.ticketsapp.data.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Ticket(
    val idTicket: String = "",
    val numTicket: Int = 0,
    val titleTicket: String,
    val dateTicket: String = "",
    val statusTicket: StatusTicket = StatusTicket.NEW,
    val personInCharge: String,
    val responsibleTeam: String = "",
    val incidentType: String = "",
    val severityIncident: String = "",
    val versionSoftware: String,
    val descriptionProblem: String,
    val image1: String? = "",
    val image2: String? = "",
    val image3: String? = ""
):Parcelable

data class TicketDemo(
    val numero: Int,
    val titulo: String,
    val tipoIncidencia: String,
    val gravedad: String
)

enum class IncidentTypePriority{
    BUG, FEATURE
}

enum class SeverityIncidentPriority{
    HIGH, MEDIUM, LOW
}

enum class ResponsibleTeam{
    SUPPORT, DEVELOP, CUSTOMER_SUPPORT
}

enum class StatusTicket{
    NEW, IN_PROGRESS, ATTENDED
}
