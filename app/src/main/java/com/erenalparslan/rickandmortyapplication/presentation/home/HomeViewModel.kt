package com.erenalparslan.rickandmortyapplication.presentation.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.erenalparslan.rickandmortyapplication.R
import com.erenalparslan.rickandmortyapplication.common.onError
import com.erenalparslan.rickandmortyapplication.common.onSuccess
import com.erenalparslan.rickandmortyapplication.domain.entity.LocationEntity
import com.erenalparslan.rickandmortyapplication.domain.usecase.getCharacterWithLocationIds.GetCharacterLocationWithIdsUseCase
import com.erenalparslan.rickandmortyapplication.domain.usecase.getLocationPaging.GetLocationPagingDataSourceUseCase
import com.erenalparslan.rickandmortyapplication.rickandmorty.ui.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLocationPagingDataSourceUseCase: GetLocationPagingDataSourceUseCase,
    private val getCharacterLocationWithIdsUseCase: GetCharacterLocationWithIdsUseCase,
    private val characterMapper: HomeUiCharacterMapper,
) : ViewModel() {
    private var _homeUiState = MutableLiveData<HomeUiState>()
    val homeUiState: LiveData<HomeUiState> get() = _homeUiState
    lateinit var locationList : Flow<PagingData<LocationEntity>>

    init {
        getLocation()
    }

    private fun getLocation() {
        locationList = getLocationPagingDataSourceUseCase.invoke().cachedIn(viewModelScope)
    }

    fun getCharactersWithLocationIds(urlList: List<String>) {
        viewModelScope.launch {
            _homeUiState.postValue(HomeUiState.Loading)
            getCharacterLocationWithIdsUseCase.invoke(urlList).onError {
                _homeUiState.postValue(HomeUiState.Error(R.string.error))
            }.onSuccess {
                _homeUiState.postValue(HomeUiState.Success(characterMapper.map(it ?: emptyList())))
            }
        }
    }
}