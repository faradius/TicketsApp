package com.developerscracks.ticketsapp.ui.detail_ticket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.developerscracks.ticketsapp.R
import com.developerscracks.ticketsapp.databinding.FragmentDetailTicketBinding


class DetailTicketFragment : Fragment() {

    private var _binding: FragmentDetailTicketBinding? = null
    private val binding get() = _binding!!

    private val args: DetailTicketFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitleTicket.text = args.ticket.titleTicket
        binding.tvNumTicket.text = args.ticket.numTicket.toString()
        binding.tvIdTicket.text = args.ticket.idTicket
        binding.tvDateTicket.text = args.ticket.dateTicket
        binding.tvNamePersonInChargeTicket.text = args.ticket.personInCharge
        binding.tvResponsibleTeam.text = args.ticket.responsibleTeam
        binding.tvincidentTypeTicket.text = args.ticket.incidentType
        binding.tvSeverityIncident.text = args.ticket.severityIncident
        binding.tvVersionSoftware.text = args.ticket.versionSoftware
        binding.tvDescriptionProblem.text = args.ticket.descriptionProblem
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}