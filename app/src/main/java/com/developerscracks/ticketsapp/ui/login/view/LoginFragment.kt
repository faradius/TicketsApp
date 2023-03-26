package com.developerscracks.ticketsapp.ui.login.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.developerscracks.ticketsapp.R
import com.developerscracks.ticketsapp.core.Response
import com.developerscracks.ticketsapp.databinding.FragmentDetailTicketBinding
import com.developerscracks.ticketsapp.databinding.FragmentLoginBinding
import com.developerscracks.ticketsapp.ui.detail_ticket.DetailTicketFragmentDirections
import com.developerscracks.ticketsapp.ui.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = binding.etEmailInput.text
        val password = binding.etPasswordInput.text


        binding.btnSignIn.setOnClickListener {
            viewModel.login(email.toString(), password.toString())
                .observe(viewLifecycleOwner, Observer { result ->
                    when (result) {
                        Response.Loading -> {

                        }

                        is Response.Success -> {
                            val action = LoginFragmentDirections.actionLoginFragmentToListTicketsFragment()
                            findNavController().navigate(action)
                        }

                        is Response.Failure -> {
                            Toast.makeText(requireContext(), "Error: ${result.exception}", Toast.LENGTH_SHORT).show()
                        }
                        else -> Log.d("TAG", "Error: Error Desconocido")
                    }
                })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}