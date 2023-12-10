package com.example.izoverse.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.izoverse.R
import com.example.izoverse.data.remote.response.TvSeriesResponse
import com.example.izoverse.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }


    private val viewModel: DetailViewModel by viewModel()
    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val detailTvSeries = intent.getParcelableExtra<TvSeriesResponse>(EXTRA_DATA)
        showDetailTvSeries(detailTvSeries)
    }

    private fun showDetailTvSeries(detailTvSeries: TvSeriesResponse?) {
        detailTvSeries?.let {
            supportActionBar?.title = detailTvSeries.name
            binding.content.tvDetailDescription.text = detailTvSeries.overview
            val baseUrl = "https://image.tmdb.org/t/p/w500"
            Glide.with(this)
                .load(baseUrl + detailTvSeries.posterPath)
                .into(binding.ivDetailImage)

//            var statusFavorite = detailTvSeries.isFavorite
//            Log.d("result favorite", "$statusFavorite")
//            setStatusFavorite(statusFavorite)
//            binding.fab.setOnClickListener {
//                statusFavorite = !statusFavorite
//                detailTvSeriesViewModel.setFavoriteTvSeries(detailTvSeries, statusFavorite)
//                setStatusFavorite(statusFavorite)
//            }
        }
    }
}