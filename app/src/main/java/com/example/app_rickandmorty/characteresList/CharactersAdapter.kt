package com.example.app_rickandmorty.characteresList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.databinding.CharactersItemBinding
import com.example.app_rickandmorty.model.CharactersEntry

internal class CharactersAdapter(
    private val items: List<CharactersEntry>
) : RecyclerView.Adapter<CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharactersItemBinding.inflate(inflater, parent, false)

        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        items[position].let { card ->
            holder.bind(card)
        }
    }

    override fun getItemCount(): Int = items.size
}
