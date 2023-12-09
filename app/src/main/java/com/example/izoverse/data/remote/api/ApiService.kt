package com.example.izoverse.data.remote.api

import com.example.izoverse.common.AuthKey
import com.example.izoverse.common.Constants
import com.example.izoverse.common.Resource
import com.example.izoverse.data.remote.response.ListTvSeriesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("tv/popular")
    @Headers(
        Constants.CONTENT_TYPE_JSON,
        AuthKey.AUTHORIZATION
    )
    suspend fun getPopularTvShows(
        @Query("language") language: String,
        @Query("page") page: Int
    ): ListTvSeriesResponse

}