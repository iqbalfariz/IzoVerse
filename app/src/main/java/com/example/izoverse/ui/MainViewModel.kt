package com.example.izoverse.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.izoverse.common.Resource
import com.example.izoverse.data.remote.response.ListTvSeriesResponse
import com.example.izoverse.data.repository.TvSeriesRepository
import com.example.izoverse.domain.use_case.GetPopularSeriesUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel (
    private val getPopularSeriesUseCase: GetPopularSeriesUseCase
): ViewModel() {

    val resultTvSeries = MutableLiveData<ListTvSeriesResponse?>()
    fun getTvListTvSeries(language: String, page: Int) {
        viewModelScope.launch {
            resultTvSeries.value = getPopularSeriesUseCase(language, page)
        }
    }

}