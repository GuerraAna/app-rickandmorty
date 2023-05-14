package com.example.app_rickandmorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

internal class CharactersViewModel(
    private val useCase: CharactersUseCase = CharactersUseCase()
) : ViewModel() {

    private val mutableViewState = MutableLiveData<CharactersViewState>()

    /**
     * Current characters list state.
     */
    val viewState: LiveData<CharactersViewState> = mutableViewState

    init {
        viewModelScope.launch {
            getCharacters()
        }
    }

    private suspend fun getCharacters() {
        mutableViewState.postValue(CharactersViewState.Loading)

        try {
            val characters = useCase.getCharacters()

            if (characters.isNotEmpty()) {
                mutableViewState.postValue(
                    CharactersViewState.Loaded(characters = characters)
                )
            }
        } catch (error: Throwable) {
            mutableViewState.postValue(CharactersViewState.Error)
        }
    }
}