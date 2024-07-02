package com.example.task2

import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.task2.databinding.FragmentBlankBinding

class InfoFragment : Fragment(R.layout.fragment_blank) {
    private var binding: FragmentBlankBinding? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentBlankBinding.bind(view)

        binding?.run {
            infoText.setMovementMethod(ScrollingMovementMethod());

            buttonReturn.setOnClickListener {
                findNavController().navigate(R.id.action_infoFragment2_to_CarFragment)
            }

            val pref = requireActivity().getSharedPreferences("Default", Context.MODE_PRIVATE)

            val index =pref.getInt("ARG_INDEX", -1)

            val car : Car? = CarRepository.list_of_car.find { it.id == index }

            nameText.text = car?.name_of_car.toString()

            countryText.text = car?.country_of_car.toString()

            infoText.text = car?.information.toString()

            Glide.with(this@InfoFragment).load(car?.url_of_draw).into(imageView)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}