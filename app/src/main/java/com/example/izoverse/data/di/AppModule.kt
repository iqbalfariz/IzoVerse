package com.example.izoverse.data.di

import com.example.izoverse.common.Constants
import com.example.izoverse.common.Resource
import com.example.izoverse.data.remote.api.ApiService
import com.example.izoverse.data.repository.TvSeriesRepository
import com.example.izoverse.data.repository.TvSeriesRepositoryImpl
import com.example.izoverse.domain.use_case.GetPopularSeriesUseCase
import com.example.izoverse.ui.MainViewModel
import com.example.izoverse.ui.detail.DetailViewModel
import com.example.izoverse.ui.favorite.FavoriteViewModel
import com.example.izoverse.ui.home.HomeViewModel
import com.google.gson.GsonBuilder
import com.google.gson.InstanceCreator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single<TvSeriesRepository> { TvSeriesRepositoryImpl(get()) }
}

val viewModelModule = module {
    single { MainViewModel(get()) }
    single { HomeViewModel() }
    single { DetailViewModel() }
    single { FavoriteViewModel() }
}

val useCaseModule = module {
    single { GetPopularSeriesUseCase(get() ) }
}