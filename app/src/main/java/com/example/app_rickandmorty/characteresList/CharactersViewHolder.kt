package com.example.app_rickandmorty.characteresList

import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.databinding.CharactersItemBinding
import com.example.app_rickandmorty.model.CharactersEntry
import com.squareup.picasso.Picasso

internal class CharactersViewHolder(
    private val binding: CharactersItemBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(entry: CharactersEntry) {
        /**
         * Setup image and title
         */
        //binding.image.drawable = entry.image
        Picasso.get().load(entry.image).into(binding.image)
        binding.number.text = entry.id.toString()
        binding.name.text = entry.name
    }
}