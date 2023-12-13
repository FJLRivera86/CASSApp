package com.project.cassa.ui.visita

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VisitaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "¿Quién será tu visita?"
    }
    val text: LiveData<String> = _text
}