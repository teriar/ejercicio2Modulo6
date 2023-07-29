package com.example.cl.ejercicio2modulo6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(entities = [Item::class], version = 1)
    abstract class ItemDataBase : RoomDatabase() {

        abstract fun getItemsDao(): ItemDao

        companion object {
            @Volatile
            private var INSTANCE: ItemDataBase? = null

            fun getDataBase(context: Context): ItemDataBase {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ItemDataBase::class.java,
                        "item_database"
                    ).build()

                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
