package com.developerscracks.ticketsapp.data.network.model

import java.util.Date

data class Ticket(
    val id: String,
    val numTicket: String,
    val titleTicket: String,
    val dateTicket: Date,
    val statusTicket: String,
    val personInCharge: String,
    val responsibleTeam: String,
    val incidentType: String,
    val severityIncident: String,
    val versionSoftware: String,
    val descriptionProblem: String,
    val image1: String,
    val image2: String,
    val image3: String
)

data class TicketDemo(
    val numero: Int,
    val titulo: String,
    val tipoIncidencia: String,
    val gravedad: String
)

enum class incidentTypePriority{
    BUG, FEATURE
}

enum class severityIncidentPriority{
    HIGH, MEDIUM, LOW
}

enum class responsibleTeam{
    SUPPORT, DEVELOP, CUSTOMER_SUPPORT
}

enum class statusTicket{
    NEW, IN_PROGRESS, ATTENDED
}
