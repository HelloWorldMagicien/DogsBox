package com.example.dogsco.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Poids du chien :"
    }
    private val _text2 = MutableLiveData<String>().apply {
        value = "Age du chien :"
    }
    private val _text3 = MutableLiveData<String>().apply {
        value = "Nombre de rations :"
    }
    private val _text4 = MutableLiveData<String>().apply {
        value = "Soit une quantité totale de :"
    }
    private val _text5 = MutableLiveData<String>().apply {
        value = "XX.XX kg"
    }

    val text: LiveData<String> = _text
    val text2: LiveData<String> = _text2
    val text3: LiveData<String> = _text3
    val text4: LiveData<String> = _text4
    val text5: LiveData<String> = _text5
}