package com.example.cl.ejercicio2modulo6.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cl.ejercicio2modulo6.data.local.Item
import com.example.cl.ejercicio2modulo6.databinding.ItemBinding

class Adapter: RecyclerView.Adapter <Adapter.ItemViewHolder>() {
    lateinit var binding: ItemBinding
   private val listItem = mutableListOf<Item>()


    class ItemViewHolder(val v:ItemBinding): RecyclerView.ViewHolder(v.root) {
      fun render(item:Item){
          v.txtNombre.text = item.nombre
          v.txtPrecio.text = item.precio.toString()
          v.txtCantidad.text = item.cantidad.toString()

          v.txtTotal.text = (item.precio * item.cantidad).toString()



      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    fun setData(item:List<Item>){
      this.listItem.clear()
        this.listItem.addAll(item)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
       return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.render(item)
    }


}