package com.example.izoverse.data.repository

import com.example.izoverse.common.Resource
import com.example.izoverse.data.remote.response.ListTvSeriesResponse
import kotlinx.coroutines.flow.Flow

interface TvSeriesRepository {

    suspend fun getTvListTvSeries(language: String, page: Int): ListTvSeriesResponse

}