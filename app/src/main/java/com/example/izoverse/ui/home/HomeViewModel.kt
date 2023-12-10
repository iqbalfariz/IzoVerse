package com.example.izoverse.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.izoverse.data.remote.response.ListTvSeriesResponse
import com.example.izoverse.domain.use_case.GetPopularSeriesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularSeriesUseCase: GetPopularSeriesUseCase
): ViewModel() {
    val resultTvSeries = MutableLiveData<ListTvSeriesResponse?>()
    fun getTvListTvSeries(language: String, page: Int) {
        viewModelScope.launch {
            resultTvSeries.value = getPopularSeriesUseCase(language, page)
        }
    }
}