package com.example.app_rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_rickandmorty.characteresList.CharactersAdapter
import com.example.app_rickandmorty.databinding.ActivityCharactersBinding
import kotlinx.coroutines.launch

class CharactersActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityCharactersBinding
    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewBinding()
        setupViewModel()
    }

    private fun setupViewBinding() {
        _binding = ActivityCharactersBinding.inflate(layoutInflater)
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
        _binding.statusFilter.isVisible = false
        _binding.genderFilter.isVisible = false
        _binding.charactersList.isVisible = false
        _binding.charactersError.root.isVisible = false
        _binding.progressBar.isVisible = true
    }

    private fun onLoaded(state: CharactersViewState.Loaded) {
        _binding.progressBar.isVisible = false
        _binding.statusFilter.isVisible = true
        _binding.genderFilter.isVisible = true
        _binding.charactersError.root.isVisible = false
        _binding.charactersList.isVisible = true

        setupCharactersList(state)

        _binding.statusFilter.setOnClickListener {
            val bottomSheet = StatusFilterBottomSheet.newInstance()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        _binding.genderFilter.setOnClickListener {
            val bottomSheet = GenderFilterBottomSheet.newInstance()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

    private fun onError() {
        _binding.progressBar.isVisible = false
        _binding.statusFilter.isVisible = false
        _binding.genderFilter.isVisible = false
        _binding.charactersList.isVisible = false
        _binding.charactersError.root.isVisible = true

        _binding.charactersError.btnTryAgain.setOnClickListener {
            viewModel.viewModelScope.launch { viewModel.getCharacters() }
        }
    }

    private fun setupCharactersList(state: CharactersViewState.Loaded) {
        _binding.charactersList.layoutManager = LinearLayoutManager(this)
        _binding.charactersList.adapter = CharactersAdapter(state.characters)
    }
}