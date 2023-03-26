package com.developerscracks.ticketsapp.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.developerscracks.ticketsapp.databinding.TicketItemLayoutBinding
import com.developerscracks.ticketsapp.domain.model.TicketUI

class TicketListAdapter(private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<TicketListAdapter.TicketsViewHolder>() {

    private var tickets: List<TicketUI> = mutableListOf()

    inner class TicketsViewHolder(
        itemBinding: TicketItemLayoutBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        private val numTicket = itemBinding.tvNumTicket
        private val titleTicket = itemBinding.tvTitleTicket
        private val priorityTicket = itemBinding.tvPriorityTicket
        private val severityTicket = itemBinding.tvSeverityIncident

        fun bind(ticket: TicketUI, onClick: (String) -> Unit) {

            numTicket.text = ticket.numTicket.toString()
            titleTicket.text = ticket.titleTicket
            priorityTicket.text = ticket.incidentType
            severityTicket.text = ticket.severityIncident
        }
    }

    fun submit(ticketsList: List<TicketUI>) {
        tickets = ticketsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsViewHolder {
        return TicketsViewHolder(
            TicketItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return tickets.size
    }

    override fun onBindViewHolder(holder: TicketsViewHolder, position: Int) {
        holder.bind(tickets[position], onClick)
    }
}