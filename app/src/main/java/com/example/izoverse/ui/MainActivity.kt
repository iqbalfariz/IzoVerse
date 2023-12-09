package com.example.izoverse.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.izoverse.R
import com.example.izoverse.common.Constants
import com.example.izoverse.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.resultTvSeries.observe(this) {
            Log.d("result tv list", "${it}")
        }

        mainViewModel.getTvListTvSeries(Constants.REGION_SERIES, 1)
    }
}