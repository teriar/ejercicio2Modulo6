package com.example.cl.ejercicio2modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item: Item)

    @Query("Select * from table_item order by id asc")
    suspend fun getAllItems():LiveData<List<Item>>
}