package com.developerscracks.ticketsapp.data.network.model

import java.util.Date

data class Ticket(
    val id: String,
    val titleTicket: String,
    val dateTicket: Date,
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
