package com.amatai.weather.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amatai.weather.databinding.ForecastitemBinding
import com.amatai.weather.requestmanager.apiresponses.ForecastResponse

class CityForecast : ListAdapter<ForecastResponse, CityForecast.ViewHolder>(CityDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item )
    }

    class ViewHolder private constructor(val binding: ForecastitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ForecastResponse) {
            binding.item = item
            binding.executePendingBindings()
        }


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ForecastitemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    class CityDiffCallback : DiffUtil.ItemCallback<ForecastResponse>(){
        override fun areItemsTheSame(
            oldItem: ForecastResponse,
            newItem: ForecastResponse
        ): Boolean {
            return oldItem.dt_txt == newItem.dt_txt
        }

        override fun areContentsTheSame(
            oldItem: ForecastResponse,
            newItem: ForecastResponse
        ): Boolean {
            return oldItem == newItem
        }

    }


}