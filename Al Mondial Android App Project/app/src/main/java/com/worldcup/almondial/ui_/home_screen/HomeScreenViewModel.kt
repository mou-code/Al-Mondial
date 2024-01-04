package com.worldcup.almondial.ui_.home_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.worldcup.almondial.Repository
import com.worldcup.almondial.base.BaseViewModel
import com.worldcup.almondial.database.entities.MatchEntity

class HomeScreenViewModel(private val repository: Repository) : BaseViewModel() {

    private var _matchList = MutableLiveData<List<MatchEntity>>().apply { value = emptyList() }
    val matchList: LiveData<List<MatchEntity>> = _matchList
    init {
        loadMatchList()
    }
    fun loadMatchList() {
        _matchList = repository.GetMatches() as MutableLiveData<List<MatchEntity>>
    }
}