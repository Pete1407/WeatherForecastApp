package com.example.weatherforecastapp.app.data.utils.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherforecastapp.BuildConfig
import com.example.weatherforecastapp.app.data.model.DetailModel
import com.example.weatherforecastapp.databinding.ItemForecastByThreeHourBinding

class WeatherAdapter(private val weatherList : MutableList<DetailModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewBinding = ItemForecastByThreeHourBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WeatherViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is WeatherViewHolder){
            holder.bindItem(weatherList[position])
        }
    }

    override fun getItemCount(): Int {
       return weatherList.size
    }

    fun refreshList(newDataList : List<DetailModel>){
        weatherList.clear()
        weatherList.addAll(newDataList)
        notifyDataSetChanged()
    }

    inner class WeatherViewHolder(val binding : ItemForecastByThreeHourBinding):RecyclerView.ViewHolder(binding.root){

        @SuppressLint("SetTextI18n")
        fun bindItem(item : DetailModel){
            binding.temperature.text = item.main?.temp.toString()
            binding.humidity.text = "${item.main?.humidity.toString()} %"
            val splitText = item.dt_txt?.split(" ")
            binding.time.text = splitText?.get(1).toString()
            Log.d("link","${BuildConfig.BASE_URL_IMAGE}${item.weather[0].icon}.png")
            Glide.with(binding.root.context)
                .load("${BuildConfig.BASE_URL_IMAGE}${item.weather[0].icon}.png")
                .into(binding.iconWeather)

        }
    }

}