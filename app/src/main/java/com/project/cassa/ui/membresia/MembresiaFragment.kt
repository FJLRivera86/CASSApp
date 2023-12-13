package com.project.cassa.ui.membresia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.cassa.databinding.FragmentInicioBinding
import com.project.cassa.databinding.FragmentMembresiaBinding

class MembresiaFragment : Fragment() {

    private var _binding: FragmentMembresiaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val membresiaViewModel =
            ViewModelProvider(this).get(MembresiaViewModel::class.java)

        _binding = FragmentMembresiaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMembresia
        membresiaViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}