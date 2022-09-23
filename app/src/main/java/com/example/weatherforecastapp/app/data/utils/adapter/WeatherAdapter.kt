package com.example.weatherforecastapp.app.data.utils.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherforecastapp.BuildConfig
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.app.base.BaseKey
import com.example.weatherforecastapp.app.data.model.DetailModel
import com.example.weatherforecastapp.app.data.utils.DateHelper
import com.example.weatherforecastapp.databinding.ItemForecastByThreeHourBinding

class WeatherAdapter(
    private val weatherList : MutableList<DetailModel>,
    private val unit : String
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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

    fun refreshList(newDataList : List<DetailModel>,unit : String){
        weatherList.clear()
        weatherList.addAll(setUnitTemp(newDataList,unit))
        notifyDataSetChanged()
    }

    private fun setUnitTemp(newDataList : List<DetailModel>, unit : String):List<DetailModel>{
        if(unit.isBlank()){
            newDataList.map {
                it.units = BaseKey.KELVIN
            }
            return newDataList
        }else{
            return if(unit == BaseKey.CELSIUS){
                newDataList.map {
                    it.units = BaseKey.CELSIUS
                }
                newDataList
            }else{
                newDataList.map {
                    it.units = BaseKey.FAHRENHEIT
                }
                newDataList
            }
        }
    }

    inner class WeatherViewHolder(private val binding : ItemForecastByThreeHourBinding):RecyclerView.ViewHolder(binding.root){


        @SuppressLint("SetTextI18n")
        fun bindItem(item : DetailModel){
            val context = binding.root.context
            showUnitTemp(item.main?.temp!!,item.units!!,context)
            binding.humidity.text = "${item.main?.humidity.toString()} % ${context.resources.getString(R.string.unit_humidity)}"
            val splitText = item.dt_txt?.split(" ")
            binding.dateText.text = splitText?.get(0) ?: ""
            binding.time.text = splitText?.get(1)?:""

            Glide.with(context)
                .load("${BuildConfig.BASE_URL_IMAGE}${item.weather[0].icon}.png")
                .into(binding.iconWeather)

        }

        @SuppressLint("SetTextI18n")
        fun showUnitTemp(tempValue : Double, unit : String,context : Context){
            if(BaseKey.KELVIN == unit){
                binding.temperature.text = "$tempValue ${context.getString(R.string.abrev_kelvin)}"
            }else{
                if(BaseKey.CELSIUS == unit){
                    binding.temperature.text = "$tempValue ${context.getString(R.string.abrev_celsius)}"
                }else{
                    binding.temperature.text = "$tempValue ${context.getString(R.string.abrev_fahrenheit)}"
                }

            }

        }
    }

}