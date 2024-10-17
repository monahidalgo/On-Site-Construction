package com.example.constructionsite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConstructionItemViewModel : ViewModel() {
    private val _items = MutableLiveData<List<ConstructionItem>>()
    val items: LiveData<List<ConstructionItem>> = _items

    fun setItems(newItems: List<ConstructionItem>) {
        _items.value = newItems
    }
}
