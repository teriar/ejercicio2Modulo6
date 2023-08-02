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
import com.example.cl.ejercicio2modulo6.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding : FragmentListBinding
     val itemViewModel:ItemViewModel by activityViewModels()
    val adapter =Adapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        initlista()
        return binding.root
    }



         fun initlista() {

             itemViewModel.getAllItems().observe(viewLifecycleOwner){
                 adapter.setData(it)

             }

             binding.RecyclerView.adapter = adapter

             binding.floatingActionButton.setOnClickListener{
                 Navigation.findNavController(requireView())
                     .navigate(R.id.action_listFragment_to_addFragment)
             }

        }
    }

