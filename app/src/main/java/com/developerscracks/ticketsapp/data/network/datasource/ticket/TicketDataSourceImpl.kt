package com.developerscracks.ticketsapp.data.network.datasource.ticket

import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.developerscracks.ticketsapp.utils.Constants.NAME_COLLECTION_TICKET
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class TicketDataSourceImpl @Inject constructor(
    private val ticketRef: CollectionReference
): TicketDataSource {
//    override val db: CollectionReference
//        get() = firebaseFirestore.collection(NAME_COLLECTION_TICKET)

    override suspend fun createTicket(ticket: Ticket): Response<Boolean> {
        return try{
            ticketRef.add(ticket).await()
//            firebaseAuth.currentUser?.let { db.document(it.uid).set(ticket).await() }
            Response.Success(true)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}