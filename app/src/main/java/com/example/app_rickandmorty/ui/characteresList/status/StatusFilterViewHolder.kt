package com.example.app_rickandmorty.ui.characteresList.status

import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.databinding.ItemTestBinding

class StatusFilterViewHolder(
    private val binding: ItemTestBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String, secondData: String ) {
        binding.text.text = data
        binding.textTwo.text = secondData

        binding.root.setOnClickListener {

        }
    }
}