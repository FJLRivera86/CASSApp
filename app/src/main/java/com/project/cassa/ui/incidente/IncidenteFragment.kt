package com.project.cassa.ui.incidente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.cassa.R
import com.project.cassa.databinding.FragmentIncidenteBinding

class IncidenteFragment : Fragment() {

    private var _binding: FragmentIncidenteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val incidenteViewModel =
            ViewModelProvider(this).get(IncidenteViewModel::class.java)

        _binding = FragmentIncidenteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textIncidente
        incidenteViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        var tipos = resources.getStringArray(R.array.tipos)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, tipos)
        binding!!.spIncidente.setAdapter(arrayAdapter)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}