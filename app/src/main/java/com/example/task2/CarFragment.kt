package com.example.task2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.task2.databinding.FragmentCarBinding

class CarFragment : Fragment(R.layout.fragment_car) {
    private var binding : FragmentCarBinding? = null

    private var adapter : CarAdapter? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCarBinding.bind(view)



        val pref = requireActivity().getSharedPreferences("Default", Context.MODE_PRIVATE)

        binding?.run {
            adapter = CarAdapter(
                list = CarRepository.list_of_car,
                glide = Glide.with(this@CarFragment),
                onClick = {
                    findNavController().navigate(it,
                        null)
                },
                pref = pref
                )
            cars.adapter = adapter

            cars.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}