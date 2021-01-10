package com.amatai.weather.ui.adapters


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amatai.weather.R
import com.amatai.weather.databinding.CityitemhomeBinding
import com.amatai.weather.requestmanager.apiresponses.CityDataResponse
import com.amatai.weather.ui.activities.MainActivity

class CityAdapterHome : ListAdapter<CityDataResponse, CityAdapterHome.ViewHolder>(CityHomeDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapterHome.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CityAdapterHome.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(private val binding: CityitemhomeBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item:CityDataResponse){
            binding.item = item
            binding.executePendingBindings()

            if (item.main!!.temp!! <= 17){
                binding.imageViewIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.ic_cold
                    )
                )
            }

            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putParcelable("city", item)
                MainActivity.navController.navigate(
                    R.id.action_homeFragmetnFragment_to_cityDetailsFragment,
                    bundle
                )
            }
        }

        companion object{

            fun from(parent: ViewGroup):ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CityitemhomeBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class CityHomeDiffCallback : DiffUtil.ItemCallback<CityDataResponse>(){
        override fun areItemsTheSame(
            oldItem: CityDataResponse,
            newItem: CityDataResponse
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: CityDataResponse,
            newItem: CityDataResponse
        ): Boolean {
            return oldItem == newItem
        }

    }
}