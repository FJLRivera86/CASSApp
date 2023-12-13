package com.project.cassa.ui.comunicados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.cassa.databinding.FragmentComunicadosBinding

class ComunicadosFragment : Fragment() {

    private var _binding: FragmentComunicadosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val comunicadosViewModel =
            ViewModelProvider(this).get(ComunicadosViewModel::class.java)

        _binding = FragmentComunicadosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textComunicados
        comunicadosViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}