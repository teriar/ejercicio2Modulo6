package com.example.cl.ejercicio2modulo6.data

import androidx.lifecycle.LiveData
import com.example.cl.ejercicio2modulo6.data.local.Item
import com.example.cl.ejercicio2modulo6.data.local.ItemDao

class Repository(private val itemDao: ItemDao) {

   suspend fun insertItem(item: Item){
       itemDao.insertItem(item)
    }

     fun getItems():
       LiveData<List<Item>> {
        return itemDao.getAllItems()
    }


}