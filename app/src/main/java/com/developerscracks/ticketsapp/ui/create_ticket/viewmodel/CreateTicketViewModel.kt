package com.developerscracks.ticketsapp.ui.create_ticket.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.developerscracks.ticketsapp.domain.use_cases.ticket.TicketUseCases
import com.developerscracks.ticketsapp.domain.use_cases.userAuth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateTicketViewModel @Inject constructor(
    private val ticketUseCases: TicketUseCases
): ViewModel() {

    private var _titleTicket = MutableLiveData<String>()
    private var _personInCharge = MutableLiveData<String>()
    private var _versionSoftware =MutableLiveData<String>()
    private var _descriptionProblem =MutableLiveData<String>()

    private var _createTicketResponse = MutableLiveData<Response<Boolean>?>(null)
    val createTicketResponse:LiveData<Response<Boolean>?> = _createTicketResponse

    fun setTitleTicket(title: String) {
        _titleTicket.value = title
    }

    fun setPersonInCharge(person: String) {
        _personInCharge.value = person
    }

    fun setVersionSoftware(version: String) {
        _versionSoftware.value = version
    }

    fun setDescriptionProblem(description: String) {
        _descriptionProblem.value = description
    }


    fun createTicket(ticket: Ticket) = viewModelScope.launch {
        _createTicketResponse.postValue(Response.Loading)
        val result = ticketUseCases.createTicket(ticket)
        _createTicketResponse.postValue(result)
    }

    fun onNewTicket(){
        val ticket = Ticket(
            titleTicket = _titleTicket.value!!,
            personInCharge = _personInCharge.value!!,
            versionSoftware = _versionSoftware.value!!,
            descriptionProblem = _descriptionProblem.value!!
        )

        createTicket(ticket)
    }
}