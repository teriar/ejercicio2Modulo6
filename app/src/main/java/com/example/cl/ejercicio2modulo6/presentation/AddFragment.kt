package com.example.cl.ejercicio2modulo6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.cl.ejercicio2modulo6.R
import com.example.cl.ejercicio2modulo6.databinding.FragmentAddBinding

class AddFragment : Fragment() {

     lateinit var binding : FragmentAddBinding
     private val itemViewModel:ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)

        initListener()

        return binding.root
    }

    private fun initListener() {
        binding.btnGuardar.setOnClickListener{

            val nombre = binding.editTextNombre.text.toString()
            val precio = binding.editTextPrecio.text.toString().toInt()
            val cantidad = binding.editTextCantidad.text.toString().toInt()

            itemViewModel.insertItem(nombre,precio,cantidad)

            binding.btnLista.setOnClickListener{
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_addFragment_to_listFragment)
            }
        }
    }


}