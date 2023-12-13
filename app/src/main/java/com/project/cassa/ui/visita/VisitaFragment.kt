package com.project.cassa.ui.visita

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.cassa.R
import com.project.cassa.databinding.FragmentVisitaBinding

class VisitaFragment : Fragment(R.layout.fragment_visita) {

    private var _binding: FragmentVisitaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val visitaViewModel =
            ViewModelProvider(this).get(VisitaViewModel::class.java)

        _binding = FragmentVisitaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textVisita
        visitaViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}