package com.project.cassa.ui.reservacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.cassa.R
import com.project.cassa.databinding.FragmentReservacionBinding

class ReservacionFragment : Fragment() {

    private var _binding: FragmentReservacionBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val reservacionViewModel =
            ViewModelProvider(this).get(ReservacionViewModel::class.java)

        _binding = FragmentReservacionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textReservacion
        reservacionViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        var reserva = resources.getStringArray(R.array.reserva)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_reserva, reserva)
        binding!!.spReserva.setAdapter(arrayAdapter)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}