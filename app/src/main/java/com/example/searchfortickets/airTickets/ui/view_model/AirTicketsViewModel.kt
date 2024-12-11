package com.example.searchfortickets.airTickets.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchfortickets.airTickets.domain.interactor.IOfferFeedInteractor
import com.example.searchfortickets.airTickets.domain.models.OfferFeed
import kotlinx.coroutines.launch

class AirTicketsViewModel(private val offerFeedInteractor: IOfferFeedInteractor) : ViewModel() {


    private val _offerFeed = MutableLiveData<Pair<List<OfferFeed>?, String?>>()
    val offerFeed: LiveData<Pair<List<OfferFeed>?, String?>> get() = _offerFeed

    fun getOfferFeed(term: String) {
        // Вызываем интеректор для получения данных
        viewModelScope.launch {
            offerFeedInteractor.searchOfferFeed(term).collect { result ->
                _offerFeed.postValue(result)
            }
        }
    }
}