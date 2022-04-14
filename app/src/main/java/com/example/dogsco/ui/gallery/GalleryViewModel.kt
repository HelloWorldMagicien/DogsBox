package com.example.dogsco.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Viandes :"
    }
    private val _text2 = MutableLiveData<String>().apply {
        value = "Os charnus :"
    }
    private val _text3 = MutableLiveData<String>().apply {
        value = "Abats variés :"
    }
    private val _text4 = MutableLiveData<String>().apply {
        value = "Huiles :"
    }
    private val _text5 = MutableLiveData<String>().apply {
        value = "Mix de légumes réduits en purée :"
    }
    private val _text6 = MutableLiveData<String>().apply {
        value = "Oeufs"
    }
    private val _text_v = MutableLiveData<String>().apply {
        value = "0 g"
    }
    private val _text_v2 = MutableLiveData<String>().apply {
        value = "0 g:"
    }
    private val _text_v3 = MutableLiveData<String>().apply {
        value = "0 g"
    }
    private val _text_v4 = MutableLiveData<String>().apply {
        value = "0 g"
    }
    private val _text_v5 = MutableLiveData<String>().apply {
        value = "0 g"
    }
    private val _text_v6 = MutableLiveData<String>().apply {
        value = "0 g"
    }

    val text: LiveData<String> = _text
    val text2: LiveData<String> = _text2
    val text3: LiveData<String> = _text3
    val text4: LiveData<String> = _text4
    val text5: LiveData<String> = _text5
    val text6: LiveData<String> = _text6
    val text_v: LiveData<String> = _text_v
    val text_v2: LiveData<String> = _text_v2
    val text_v3: LiveData<String> = _text_v3
    val text_v4: LiveData<String> = _text_v4
    val text_v5: LiveData<String> = _text_v5
    val text_v6: LiveData<String> = _text_v6
}