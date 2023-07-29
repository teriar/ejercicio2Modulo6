package com.example.cl.ejercicio2modulo6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_item")
data class Item(val nombre:String,val precio:Int,val cantidad:Int){
    @PrimaryKey (autoGenerate = true) var id:Long = 0
}
