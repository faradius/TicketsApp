package com.developerscracks.ticketsapp.ui.user_client.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.developerscracks.ticketsapp.databinding.TicketItemLayoutBinding

class TicketListAdapter(private val onClick: (Ticket) -> Unit) :
    ListAdapter<Ticket, TicketListAdapter.TicketsViewHolder>(TicketDiffUtil) {

    //private var onItemClickListener: ((Ticket) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsViewHolder {
        return TicketsViewHolder(
            TicketItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TicketsViewHolder, position: Int) {
        val ticket = getItem(position)
        holder.bind(ticket)
    }

    inner class TicketsViewHolder(
        itemBinding: TicketItemLayoutBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        private val numTicket = itemBinding.tvNumTicket
        private val titleTicket = itemBinding.tvTitleTicket
        private val priorityTicket = itemBinding.tvPriorityTicket
        private val severityTicket = itemBinding.tvSeverityIncident

        private var currentTicket: Ticket? = null

        init {
            itemView.setOnClickListener {
                currentTicket?.let {
                    onClick(it)
                }
            }
        }

        fun bind(ticket: Ticket) {
            currentTicket = ticket

            numTicket.text = ticket.numTicket.toString()
            titleTicket.text = ticket.titleTicket
            priorityTicket.text = ticket.incidentType
            severityTicket.text = ticket.severityIncident
        }
    }

}

object TicketDiffUtil : DiffUtil.ItemCallback<Ticket>() {
    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem.idTicket == newItem.idTicket
    }

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem
    }

}