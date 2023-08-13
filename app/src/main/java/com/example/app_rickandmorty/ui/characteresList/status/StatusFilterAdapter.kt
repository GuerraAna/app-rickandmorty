package com.example.app_rickandmorty.ui.characteresList.status

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.databinding.ItemTestBinding

class StatusFilterAdapter(
    private val data: List<String>,
    private val secondData: List<String>
) : RecyclerView.Adapter<StatusFilterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusFilterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTestBinding.inflate(inflater, parent, false)

        return StatusFilterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatusFilterViewHolder, position: Int) {
        holder.bind(data[position], secondData[position])
    }

    override fun getItemCount(): Int = data.size
}