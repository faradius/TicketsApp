package com.developerscracks.ticketsapp.ui.user_client.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.developerscracks.ticketsapp.R
import com.developerscracks.ticketsapp.data.network.model.TicketDemo
import com.developerscracks.ticketsapp.databinding.FragmentListTicketsBinding
import com.developerscracks.ticketsapp.ui.user_client.home.adapters.TicketListAdapter


class ListTicketsFragment : Fragment() {

    private var _binding: FragmentListTicketsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tickets = listOf(
            TicketDemo(1, "Error al iniciar sesión", "bug", "high"),
            TicketDemo(2, "Mejorar la velocidad de carga", "feature", "medium"),
            TicketDemo(3, "Problemas con la visualización en móviles", "bug", "medium"),
            TicketDemo(4, "Agregar opción de cambiar contraseña", "feature", "low")
        )

        val rvTicketAdapter = TicketListAdapter(
            onClick = {

            }
        )

        rvTicketAdapter.submitList(tickets)

        binding.rvTickets.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = rvTicketAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}