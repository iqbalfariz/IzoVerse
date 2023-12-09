package com.example.izoverse.domain.use_case

import com.example.izoverse.common.Resource
import com.example.izoverse.data.remote.response.ListTvSeriesResponse
import com.example.izoverse.data.repository.TvSeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetPopularSeriesUseCase(
    private val tvSeriesRepository: TvSeriesRepository
) {
    suspend operator fun invoke(language: String, page: Int) = tvSeriesRepository.getTvListTvSeries(language, page)
}