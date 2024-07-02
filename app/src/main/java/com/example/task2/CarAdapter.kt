package com.example.task2

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.RequestManager
import com.example.task2.databinding.ItemCarBinding

class CarAdapter(
    private var list: List<Car>,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit,
    private val pref : SharedPreferences
) : Adapter<CarHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        return CarHolder(binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context),parent,false
        ), glide = glide, onClick = onClick, pref = pref)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.onBind(list[position])
    }
}