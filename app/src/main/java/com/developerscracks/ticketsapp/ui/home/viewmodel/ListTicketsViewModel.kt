package com.developerscracks.ticketsapp.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.developerscracks.ticketsapp.domain.model.TicketUI
import com.developerscracks.ticketsapp.domain.model.toTicketSimpleUI
import com.developerscracks.ticketsapp.domain.use_cases.ticket.TicketUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListTicketsViewModel @Inject constructor(
    private val ticketUseCases: TicketUseCases
): ViewModel() {

    private val _tickets: MutableLiveData<List<TicketUI>> = MutableLiveData()
    val tickets: LiveData<List<TicketUI>> = _tickets

    fun getTickets(){
        viewModelScope.launch {
            val result = ticketUseCases.getTickets()

            when(result){
                Response.Loading ->{
                    Response.Loading
                }

                is Response.Success ->{
                    _tickets.value = result.data.map {
                        it.toTicketSimpleUI()
                    }
                }

                is Response.Failure -> {
                    Log.d("TAG", "getTickets: ${result.exception?.message}")
                }

            }
        }
    }
}