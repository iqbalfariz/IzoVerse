package com.example.izoverse.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.izoverse.R
import com.example.izoverse.common.Constants
import com.example.izoverse.databinding.FragmentHomeBinding
import com.example.izoverse.ui.TvSeriesAdapter
import com.example.izoverse.ui.detail.DetailActivity
import com.google.android.material.navigation.NavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            viewModel.getTvListTvSeries(Constants.REGION_SERIES, 1)
            val tvSeriesAdapter = TvSeriesAdapter()
            tvSeriesAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
            viewModel.resultTvSeries.observe(viewLifecycleOwner) {response ->
                if (response != null){
                    tvSeriesAdapter.setData(response.results)
                }
            }
            with(binding.rvSeries) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvSeriesAdapter
            }
        }

    }

}