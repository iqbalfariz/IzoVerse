package com.example.izoverse.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.izoverse.R
import com.example.izoverse.data.remote.response.TvSeriesResponse
import com.example.izoverse.databinding.ItemListTvSeriesBinding

class TvSeriesAdapter: RecyclerView.Adapter<TvSeriesAdapter.ListViewHolder>() {

    private var listData = ArrayList<TvSeriesResponse>()
    var onItemClick: ((TvSeriesResponse) -> Unit)? = null

    fun setData(newListData: List<TvSeriesResponse>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_tv_series, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTvSeriesBinding.bind(itemView)
        val baseUrl = "https://image.tmdb.org/t/p/w500"
        fun bind(data: TvSeriesResponse) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(baseUrl + data.posterPath)
                    .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.overview
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }
}