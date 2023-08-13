package com.example.app_rickandmorty.ui.characteresList.gender

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.databinding.ItemTestBinding

class GenderFilterAdapter(
    private val list: List<String>,
    private val secondList: List<String>
) : RecyclerView.Adapter<GenderFilterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenderFilterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTestBinding.inflate(inflater, parent, false)

        return  GenderFilterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenderFilterViewHolder, position: Int) {
        holder.bind(list[position], secondList[position])
    }

    override fun getItemCount(): Int = list.size
}