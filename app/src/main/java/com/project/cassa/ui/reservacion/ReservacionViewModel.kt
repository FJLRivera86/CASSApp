package com.project.cassa.ui.reservacion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReservacionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "¿Qué deseas reservar?"
    }
    val text: LiveData<String> = _text
}