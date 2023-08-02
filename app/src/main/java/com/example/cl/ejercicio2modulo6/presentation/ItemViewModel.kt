package com.example.cl.ejercicio2modulo6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cl.ejercicio2modulo6.data.Repository
import com.example.cl.ejercicio2modulo6.data.local.Item
import com.example.cl.ejercicio2modulo6.data.local.ItemDataBase
import kotlinx.coroutines.launch

class ItemViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: Repository

        init {
            val dao = ItemDataBase.getDataBase(application).getItemsDao()
            repository = Repository(dao)
        }

          fun getAllItems(): LiveData<List<Item>> = repository.getItems()

        fun insertItem(name: String, price: Int, quantity: Int) = viewModelScope.launch {
            val item = Item(name, price, quantity)
            repository.insertItem(item)
        }
    }
