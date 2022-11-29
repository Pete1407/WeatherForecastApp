package com.example.weatherforecastapp.feature.WholeDayForecast

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rickmorty.app.base.BaseActivity
import com.example.rickmorty.app.base.CustomState
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.app.base.BaseKey
import com.example.weatherforecastapp.app.data.model.Coord
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.model.WholeDayForecastModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.data.utils.adapter.WeatherAdapter
import com.example.weatherforecastapp.databinding.ActivityWholeDayForecastBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WholeDayForecastActivity : BaseActivity(),CustomState {

    private var weatherData : WeatherModel? = null
    private var adapter : WeatherAdapter? = null
    private var unit : String = ""
    @Inject
    lateinit var viewModelFactory: WholeDayForecastViewModelFactory
    private val viewModel : WholeDayForecastViewModel by viewModels()

    private val binding : ActivityWholeDayForecastBinding by lazy {
        ActivityWholeDayForecastBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        weatherData = intent.getParcelableExtra<WeatherModel>(PARAM_WEATHER)
        initViewModel()
        initListener()
        initUI()
    }

    override fun initUI() {
        binding.cityName.text = weatherData?.name
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.inflateMenu(R.menu.unit_menu)
        setAdapter()
        viewModel.getWholeDayForecast(weatherData?.coord?.lat!!,weatherData?.coord?.lon!!,null)
    }

    override fun initListener() {
        binding.toolbar.setOnMenuItemClickListener {
            val menuId = it.itemId
            if(menuId == R.id.celsius_unit){
                unit = BaseKey.CELSIUS
                viewModel.getWholeDayForecast(weatherData?.coord?.lat!!,weatherData?.coord?.lon!!,unit)
                return@setOnMenuItemClickListener true
            }else{
                unit = BaseKey.FAHRENHEIT
                viewModel.getWholeDayForecast(weatherData?.coord?.lat!!,weatherData?.coord?.lon!!,unit)
                return@setOnMenuItemClickListener it.itemId == R.id.fahrenheit_unit
            }
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun initViewModel() {
        viewModel.wholeDayForecastData.observe(this,state)
    }

    override fun showLoading() {
        binding.loading.showLoading()
    }

    override fun hideLoading() {
        binding.loading.hideLoading()
    }

    private fun setAdapter(){
        if(adapter == null){
            adapter = WeatherAdapter(arrayListOf(),unit)
        }
        binding.recyclerView.adapter = adapter
    }

    private val state = Observer<Resource<WholeDayForecastModel>>{
        when(it){
            is Resource.Loading ->{
                showLoading()
            }
            is Resource.Success ->{
                hideLoading()
                adapter?.refreshList(it.data?.list!!,unit)
            }
            else -> {}
        }
    }

    companion object{

        private const val PARAM_WEATHER = "param-weather"

        fun start(context : Context, weatherData : WeatherModel){
            val intent = Intent(context,WholeDayForecastActivity::class.java).apply {
                putExtra(PARAM_WEATHER,weatherData)
            }
            context.startActivity(intent)
        }
    }
}