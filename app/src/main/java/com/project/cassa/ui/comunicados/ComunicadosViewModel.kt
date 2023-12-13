package com.project.cassa.ui.comunicados

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComunicadosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Te tenemos al día"
    }
    val text: LiveData<String> = _text
}