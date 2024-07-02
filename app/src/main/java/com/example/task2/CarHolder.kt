package com.example.task2

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.task2.databinding.FragmentCarBinding
import com.example.task2.databinding.ItemCarBinding

class CarHolder(
    private val binding: ItemCarBinding,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit,
    private val pref : SharedPreferences
) : ViewHolder(binding.root) {


    private val requestOptions =
        RequestOptions
            .diskCacheStrategyOf(
                DiskCacheStrategy.ALL
            )


    @SuppressLint("CommitPrefEdits")
    fun onBind(car: Car) {
        binding.run {
            name.text = car.name_of_car
            country.text = car.country_of_car

            glide.load(car.url_of_draw).apply(requestOptions).into(image)

            root.setOnClickListener {
                pref.edit().putInt("ARG_INDEX",car.id).apply()
                onClick.invoke(R.id.action_CarFragment_to_infoFragment2)
            }
        }
    }

}