package com.developerscracks.ticketsapp.ui.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.developerscracks.ticketsapp.data.network.model.StatusTicket
import com.developerscracks.ticketsapp.data.network.model.Ticket
import com.developerscracks.ticketsapp.databinding.FragmentListTicketsBinding
import com.developerscracks.ticketsapp.ui.home.adapters.TicketListAdapter
import com.developerscracks.ticketsapp.ui.home.viewmodel.ListTicketsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTicketsFragment : Fragment() {

    private var _binding: FragmentListTicketsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ListTicketsViewModel>()

//    private val rvTicketAdapter = TicketListAdapter(
//        onClick = {
//                val action =
//                    ListTicketsFragmentDirections.actionListTicketsFragmentToCreateTicketFragment(
//                        it
//                    )
//                findNavController().navigate(action)
//        }
//    )

    private val ticketAdapter: TicketListAdapter = TicketListAdapter {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        subscribeTickets()
        _binding = FragmentListTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTickets()

        //Pruebas
        /*val tickets = listOf(
            Ticket(
                "TCK-001",
                "1",
                "Error al iniciar sesión",
                "15/01/2022",
                StatusTicket.NEW,
                "Juan Pérez",
                "Soporte",
                "Bug",
                "High",
                "v1.0",
                "Cuando un usuario intenta iniciar sesión, aparece un mensaje de error indicando que las credenciales son incorrectas.",
                "",
                "",
                ""
            ),
            Ticket(
                "TCK-002",
                "2",
                "Agregar función de búsqueda",
                "15/01/2022",
                StatusTicket.NEW,
                "María González",
                "Desarrollo",
                "Feature",
                "Medium",
                "v2.1",
                "Se requiere agregar una función de búsqueda en la página principal de la aplicación.",
                "",
                "",
                ""
            ),
            Ticket(
                "TCK-003",
                "3",
                "Problemas con la carga de archivos",
                "15/01/2022",
                StatusTicket.NEW,
                "Pedro Rodríguez",
                "Atención a clientes",
                "Bug",
                "Low",
                "v1.2",
                "Algunos usuarios reportan que no pueden cargar archivos en la plataforma.",
                "",
                "",
                ""
            )
        )*/

        binding.rvTickets.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ticketAdapter
        }

        binding.fabNewTicket.setOnClickListener {
            val action = ListTicketsFragmentDirections.actionListTicketsFragmentToCreateTicketFragment()
            findNavController().navigate(action)
        }
    }

    fun subscribeTickets(){
        viewModel.tickets.observe(viewLifecycleOwner){
            ticketAdapter.submit(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}