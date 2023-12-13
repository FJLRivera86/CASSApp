package com.project.cassa.ui.membresia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MembresiaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Manteniendo tus beneficios"
    }
    val text: LiveData<String> = _text
}