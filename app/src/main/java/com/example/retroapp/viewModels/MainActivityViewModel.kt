package com.example.retroapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retroapp.network.Characters
import com.example.retroapp.network.RetrofitClient
import com.example.retroapp.repositories.MainActivityRepository
import com.example.retroapp.util.Resource
import kotlinx.coroutines.launch

class MainActivityViewModel(
    val repository: MainActivityRepository = MainActivityRepository(
        RetrofitClient
    )
) : ViewModel() {

    private var _charactersLiveData = MutableLiveData<Resource<List<Characters>?>>()
    val characterLiveDatas: LiveData<Resource<List<Characters>?>> get() = _charactersLiveData

    init {
        fetchCharacters()
    }

    fun fetchCharacters() {
        _charactersLiveData.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
                val client = repository.getCharacter("1")
                _charactersLiveData.postValue(Resource.Success(client.results))
            } catch (e: Exception) {

                _charactersLiveData.postValue(Resource.Error(e.message!!, null))
            }


        }


    }
}

