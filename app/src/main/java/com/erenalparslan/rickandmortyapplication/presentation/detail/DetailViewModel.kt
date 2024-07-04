package com.erenalparslan.rickandmortyapplication.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erenalparslan.rickandmortyapplication.R
import com.erenalparslan.rickandmortyapplication.common.onError
import com.erenalparslan.rickandmortyapplication.common.onSuccess
import com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithId.GetCharacterWithIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterWithIdUseCase: GetCharacterWithIdUseCase
): ViewModel() {
    private val _detailUiState=MutableLiveData<DetailUiState>()
    val detailUiState:LiveData<DetailUiState> get() = _detailUiState
    fun getRickAndMortyCharacter(id:String){
        viewModelScope.launch {
            getCharacterWithIdUseCase.invoke(id).onError {
               _detailUiState.postValue(DetailUiState.Error(R.string.error))
            }.onSuccess {
                _detailUiState.postValue(DetailUiState.Success(it))
            }
        }
    }
}