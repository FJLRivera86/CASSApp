package com.project.cassa.ui.incidente

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IncidenteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Cuéntanos, ¿qué sucede?"
    }
    val text: LiveData<String> = _text
}