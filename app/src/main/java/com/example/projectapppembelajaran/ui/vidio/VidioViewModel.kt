package com.example.projectapppembelajaran.ui.vidio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VidioViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is vidio Fragment"
    }
    val text: LiveData<String> = _text
}