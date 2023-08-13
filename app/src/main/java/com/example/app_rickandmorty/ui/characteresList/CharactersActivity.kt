package com.example.app_rickandmorty.ui.characteresList

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_rickandmorty.CharactersViewModel
import com.example.app_rickandmorty.CharactersViewState
import com.example.app_rickandmorty.analytics.AnalyticsPageName
import com.example.app_rickandmorty.analytics.TrackedPage
import com.example.app_rickandmorty.ui.characteresList.gender.GenderFilterBottomSheet
import com.example.app_rickandmorty.ui.characteresList.status.StatusFilterBottomSheet
import com.example.app_rickandmorty.characteresList.CharactersAdapter
import com.example.app_rickandmorty.databinding.ActivityCharactersBinding
import kotlinx.coroutines.launch

internal class CharactersActivity : AppCompatActivity(), TrackedPage {

    private lateinit var _binding: ActivityCharactersBinding
    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        turnNavigationBarWhite()
        setupViewBinding()
        setupViewModel()
    }

    private fun turnNavigationBarWhite() {
        val window = this.window
        window.navigationBarColor = Color.WHITE
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
        _binding.apply {
            statusFilter.isVisible = false
            genderFilter.isVisible = false
            charactersList.isVisible = false
            charactersError.root.isVisible = false
            progressBar.isVisible = true
        }
    }

    private fun onLoaded(state: CharactersViewState.Loaded) {
        _binding.apply {
            progressBar.isVisible = false
            statusFilter.isVisible = true
            genderFilter.isVisible = true
            charactersError.root.isVisible = false
            charactersList.isVisible = true
        }

        setupCharactersList(state)

        val listOfStatus = listOf(
            "mortinho da silva",
            "vivaço",
            "ta na melhor"
        )

        val listOfStatusDescription = listOf(
            "mortinho da silva",
            "vivaço",
            "ta na melhor"
        )

        _binding.statusFilter.setOnClickListener {
            val statusBottomSheet =
                StatusFilterBottomSheet.newInstance(
                    listOfStatus,
                    listOfStatusDescription
                )

            statusBottomSheet.show(supportFragmentManager, statusBottomSheet.tag)
        }

        val listOfGender = listOf(
            "Homem",
            "Mulher",
            "Outrossas"
        )

        val listOfGenderDescription = listOf(
            "homenzin",
            "mulhererzaoo",
            "outrxx"
        )

        _binding.genderFilter.setOnClickListener {
            val genderBottomSheet =
                GenderFilterBottomSheet.newInstance(
                    listOfGender,
                    listOfGenderDescription
                )

            genderBottomSheet.show(supportFragmentManager, genderBottomSheet.tag)
        }
    }

    private fun onError() {
        _binding.apply {
            progressBar.isVisible = false
            statusFilter.isVisible = false
            genderFilter.isVisible = false
            charactersList.isVisible = false
            charactersError.root.isVisible = true

            charactersError.btnTryAgain.setOnClickListener {
                viewModel.viewModelScope.launch { viewModel.getCharacters() }
            }
        }
    }

    private fun setupCharactersList(state: CharactersViewState.Loaded) {
        _binding.apply {
            charactersList.layoutManager = LinearLayoutManager(this@CharactersActivity)
            charactersList.adapter = CharactersAdapter(state.characters)
        }
    }

    override fun getPageName(): AnalyticsPageName = AnalyticsPageName.RickAndMortyList

    override fun onNavigateTo(isFirstLoad: Boolean) {
        TODO("Not yet implemented")
    }
}