package com.amatai.weather.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amatai.weather.R
import com.amatai.weather.databinding.CityitemBinding
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse
import com.amatai.weather.ui.activities.MainActivity
import com.amatai.weather.ui.fragments.HomeFragmetnFragment

class CityAdapter : ListAdapter<CitySearchResponse, CityAdapter.ViewHolder>(CityDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: CityitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CitySearchResponse) {
            binding.item = item
            binding.executePendingBindings()

            itemView.setOnClickListener {


                Toast.makeText(itemView.context, "Added new city", Toast.LENGTH_SHORT).show()
                HomeFragmetnFragment.addCity(item)



            }
        }


        companion object {
            var state = 0
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CityitemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    class CityDiffCallback : DiffUtil.ItemCallback<CitySearchResponse>() {
        override fun areItemsTheSame(
            oldItem: CitySearchResponse,
            newItem: CitySearchResponse
        ): Boolean {
            return oldItem.name == oldItem.name
        }

        override fun areContentsTheSame(
            oldItem: CitySearchResponse,
            newItem: CitySearchResponse
        ): Boolean {
            return oldItem == newItem
        }

    }
}