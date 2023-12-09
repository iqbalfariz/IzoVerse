package com.example.izoverse.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListTvSeriesResponse(
    @field:SerializedName("error")
    val page: Int,

    @field:SerializedName("results")
    val results: List<TvSeriesResponse>
)
