package com.amatai.weather.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amatai.weather.databinding.CityitemBinding
import com.amatai.weather.requestmanager.apiresponses.CitySearchResponse

class CityAdapter : ListAdapter<CitySearchResponse, CityAdapter.ViewHolder>(CityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: CityitemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item:CitySearchResponse){
            binding.item = item
            binding.executePendingBindings()

        }


        companion object{

            fun from(parent: ViewGroup):ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CityitemBinding.inflate(layoutInflater,parent,false)

                return ViewHolder(binding)
            }
        }
    }

    class CityDiffCallback : DiffUtil.ItemCallback<CitySearchResponse>(){
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