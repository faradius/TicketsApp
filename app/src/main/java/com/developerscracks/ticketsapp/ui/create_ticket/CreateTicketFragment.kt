package com.developerscracks.ticketsapp.ui.create_ticket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.developerscracks.ticketsapp.R
import com.developerscracks.ticketsapp.databinding.FragmentCreateTicketBinding
import com.developerscracks.ticketsapp.databinding.FragmentDetailTicketBinding


class CreateTicketFragment : Fragment() {

    private var _binding: FragmentCreateTicketBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val responsibleTeamAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.responsible_team, android.R.layout.simple_spinner_item)
        responsibleTeamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerResponsibleTeam.adapter = responsibleTeamAdapter

        val incidentTypeAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.incident_type, android.R.layout.simple_spinner_item)
        incidentTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerIncidentType.adapter = incidentTypeAdapter

        val severityIncidentAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.severity_incident, android.R.layout.simple_spinner_item)
        severityIncidentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSeverityIncident.adapter = severityIncidentAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}