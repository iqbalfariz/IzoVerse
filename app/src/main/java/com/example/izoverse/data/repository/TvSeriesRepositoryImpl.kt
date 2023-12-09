package com.example.izoverse.data.repository

import com.example.izoverse.common.Resource
import com.example.izoverse.data.remote.api.ApiService
import com.example.izoverse.data.remote.response.ListTvSeriesResponse
import kotlinx.coroutines.flow.Flow


class TvSeriesRepositoryImpl (
    private val apiService: ApiService
): TvSeriesRepository {
    override suspend fun getTvListTvSeries(language: String, page: Int): ListTvSeriesResponse {
        return apiService.getPopularTvShows(language, page)
    }
}