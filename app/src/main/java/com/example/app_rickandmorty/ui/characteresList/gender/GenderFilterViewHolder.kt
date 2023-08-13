package com.example.app_rickandmorty.ui.characteresList.gender

import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.databinding.ItemTestBinding

class GenderFilterViewHolder(
    private val binding: ItemTestBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(list: String, secondList: String) {
        binding.text.text = list
        binding.textTwo.text = secondList
    }
}