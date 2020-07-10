package com.nike.urbandictionary.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nike.urbandictionary.api.model.Definition
import com.nike.urbandictionary.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(private val urbanDictionaryRepository: Repository) :
    ViewModel() {

    private var _liveSearchResult = MutableLiveData<List<Definition>>()
    val liveSearchResult: LiveData<List<Definition>>? = _liveSearchResult

    private var _searchProgress = MutableLiveData<Boolean>()
    val searchProgress: LiveData<Boolean> = _searchProgress

    fun getAllDefinitions(term: String) {
        try {
            _searchProgress.postValue(true)
            _liveSearchResult.value = runBlocking {
                withContext(Dispatchers.IO) {
                    urbanDictionaryRepository.getResultFromNetwork(
                        term
                    )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    fun definitionListSortedByDescThumbsUp() {
        _liveSearchResult.value = _liveSearchResult.value?.sortedByDescending { it.thumbsUp }


    }

    fun definitionListSortedByDescThumbsDown() {
        _liveSearchResult.value = _liveSearchResult.value?.sortedByDescending { it.thumbsDown }
    }


}