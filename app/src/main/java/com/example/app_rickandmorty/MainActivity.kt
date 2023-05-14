package com.example.app_rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_rickandmorty.characteresList.CharactersAdapter
import com.example.app_rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewBinding()
        setupViewModel()
    }

    private fun setupViewBinding() {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(this) { state: CharactersViewState ->
            when (state) {
                CharactersViewState.Loading -> onLoading()
                is CharactersViewState.Loaded -> onLoaded(state)
                CharactersViewState.Error -> onError()
            }
        }
    }

    private fun onLoading() {
        _binding.progressBar.isVisible = true
    }

    private fun onLoaded(state: CharactersViewState.Loaded) {
        _binding.progressBar.isVisible = false
        _binding.charactersList.isVisible = true
        setupCharactersList(state)
    }

    private fun onError() {
        _binding.progressBar.isVisible = false
        TODO("Not yet implemented")
    }

    private fun setupCharactersList(state: CharactersViewState.Loaded) {
        _binding.charactersList.layoutManager = LinearLayoutManager(this)
        _binding.charactersList.adapter = CharactersAdapter(state.characters)
    }
}