package com.erenalparslan.rickandmortyapplication.presentation.detail

import androidx.annotation.StringRes
import com.erenalparslan.rickandmortyapplication.domain.entity.CharacterEntity

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val data: CharacterEntity?) : DetailUiState()
    data class Error(@StringRes val message: Int) : DetailUiState()
}