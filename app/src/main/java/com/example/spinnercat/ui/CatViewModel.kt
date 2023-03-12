package com.example.spinnercat.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spinnercat.data.RepositoryImpl
import com.example.spinnercat.data.model.BreedsResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatViewModel @Inject constructor(
    private val repository: RepositoryImpl,
) : ViewModel() {

    private val _catLiveData = MutableLiveData<String>()
    val catLiveData: LiveData<String> get() = _catLiveData

    private val breedIdMap: MutableMap<String, String> = mutableMapOf()

    private val _breedsLiveData = MutableLiveData<List<BreedsResponse>>()
    val breedsLiveData: LiveData<List<BreedsResponse>> get() = _breedsLiveData

    fun getCatImage(breed: String) {
        val id = getIdByBreads(breed)
        viewModelScope.launch {
            _catLiveData.value = repository.getCatImage(id).first().image.toString()
        }
    }

    fun getBreads() {
        viewModelScope.launch {
            _breedsLiveData.value = repository.getBreedsList()
            for (i in repository.getBreedsList()) {
                val breed = i.breed ?: ""
                val breedId = i.breedId ?: ""
                breedIdMap[breed] = breedId
            }
        }
    }

    private fun getIdByBreads(breeds: String): String {
        return breedIdMap[breeds].toString()
    }
}