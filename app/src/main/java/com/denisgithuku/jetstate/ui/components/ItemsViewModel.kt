package com.denisgithuku.jetstate.ui.components

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denisgithuku.jetstate.ui.data.Items

class ItemsViewModel : ViewModel() {

    private val _items = MutableLiveData(listOf<Items>())
    val items: LiveData<List<Items>> = _items


    init {
        _items.value = listOf(
            Items("Testing", "Working"),
            Items("One", "Two"),
            Items("Head", "Tail"),
            Items("First", "Last")
        )
    }

}