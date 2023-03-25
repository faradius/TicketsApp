package com.developerscracks.ticketsapp.ui.user_client.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.developerscracks.ticketsapp.data.network.model.TicketDemo
import com.developerscracks.ticketsapp.databinding.TicketItemLayoutBinding

class TicketListAdapter(private val onClick: (TicketDemo) -> Unit) : ListAdapter<TicketDemo, TicketListAdapter.TicketsViewHolder>(TicketDiffUtil) {

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
    ): RecyclerView.ViewHolder(itemBinding.root){

        private val numTicket = itemBinding.tvNumTicket
        private val titleTicket = itemBinding.tvTitleTicket
        private val priorityTicket = itemBinding.tvPriorityTicket
        private val severityTicket = itemBinding.tvSeverityIncident

        private var currentTicket: TicketDemo? = null

        fun bind(ticket: TicketDemo){
            currentTicket = ticket

            numTicket.text = ticket.numero.toString()
            titleTicket.text = ticket.titulo
            priorityTicket.text = ticket.tipoIncidencia
            severityTicket.text = ticket.gravedad
        }
    }

}

object TicketDiffUtil : DiffUtil.ItemCallback<TicketDemo>(){
    override fun areItemsTheSame(oldItem: TicketDemo, newItem: TicketDemo): Boolean {
        return oldItem.numero == newItem.numero
    }

    override fun areContentsTheSame(oldItem: TicketDemo, newItem: TicketDemo): Boolean {
        return oldItem == newItem
    }

}