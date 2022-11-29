package com.example.weatherforecastapp.feature.DetailForecast

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.BuildConfig
import com.bumptech.glide.Glide
import com.example.rickmorty.app.base.BaseActivity
import com.example.rickmorty.app.base.CustomState
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.app.base.BaseKey
import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.Coord
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.utils.DateHelper
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.app.data.utils.extension.visible
import com.example.weatherforecastapp.databinding.ActivityDetailForecastBinding
import com.example.weatherforecastapp.feature.WholeDayForecast.WholeDayForecastActivity
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class DetailForecastActivity : BaseActivity(),CustomState {

    private var cityName : String = ""
    private var unit : String? = null
    private var city : CityModel? = null
    private var weather : WeatherModel? = null
    @Inject
    lateinit var viewModelFactory: DetailForecastViewModelFactory
    private val viewModel : DetailForecastViewModel by viewModels()

    private val binding : ActivityDetailForecastBinding by lazy {
        ActivityDetailForecastBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        cityName = intent.getStringExtra(SEARCH_PARAM).toString()
        initViewModel()
        initListener()
        initUI()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun initUI() {
        viewModel.getPositionOfCity(cityName)
        binding.cityName.text = city?.local_names?.th
        binding.toolbar.inflateMenu(R.menu.unit_menu)
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
    }

    override fun initListener() {
        binding.toolbar.setOnMenuItemClickListener {
            val menuId = it.itemId
            if(menuId == R.id.celsius_unit){
                unit = BaseKey.CELSIUS
                binding.unit.setImageResource(R.drawable.icon_celsius_unit)
                viewModel.getWeatherToday(city!!.lat!!,city!!.lon!!,unit)
                return@setOnMenuItemClickListener true
            }else{
                unit = BaseKey.FAHRENHEIT
                binding.unit.setImageResource(R.drawable.icon_fahrenheit_unit)
                viewModel.getWeatherToday(city!!.lat!!,city!!.lon!!,unit)
                return@setOnMenuItemClickListener it.itemId == R.id.fahrenheit_unit
            }
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        binding.button.setOnClickListener {
            WholeDayForecastActivity.start(this,weather!!)
        }
    }

    override fun initViewModel() {
        viewModel.cityValue.observe(this,cityResult)
        viewModel.weatherValue.observe(this,weatherResult)
    }

    override fun showLoading() {
        binding.loading.showLoading()
    }

    override fun hideLoading() {
        binding.loading.hideLoading()
    }

    private val cityResult = Observer<Resource<List<CityModel>>>{ result ->
        when(result){
            is Resource.Loading -> {showLoading()}
            is Resource.Success ->{
                if(result.data?.size != 0){
                    result.data?.get(0)?.let {
                        if(it.country == BaseKey.THAILAND){
                            city = it
                            binding.cityName.text = city?.name
                            viewModel.getWeatherToday(it.lat!!,it.lon!!,unit)
                        }
                        else{
                            Toast.makeText(this,"This city name is unavailiable in Thailand",Toast.LENGTH_SHORT).show()
                            this.finish()
                        }

                    }
                }else{
                    Toast.makeText(this,"This city name is unavailiable in Thailand",Toast.LENGTH_SHORT).show()
                    this.finish()
                }

            }
            else -> {}
        }
    }

    private val weatherResult = Observer<Resource<WeatherModel>> {
        when(it){
            is Resource.Loading -> {}
            is Resource.Success ->{
                hideLoading()
                weather = it.data
                binding.button.visible()
                it.data?.let { result ->
                    setWeatherDataToUI(result)
                }
            }
            else -> {}
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setWeatherDataToUI(weatherResult : WeatherModel){
        binding.unit.visible()
        binding.temperature.text = weatherResult.main?.temp.toString()
        binding.date.text = DateHelper.convertTimeStampToDate(System.currentTimeMillis())
        binding.humidity.visible()
        binding.humidity.text = "${resources.getString(R.string.text_humidity)} :"
        binding.valueHumidity.text = "${weatherResult.main?.humidity.toString()} % ${getString(R.string.unit_humidity)}"
    }

    companion object{
        private const val SEARCH_PARAM = "search-param"
        fun start(context : Context,searchText : String){
            val intent = Intent(context,DetailForecastActivity::class.java).apply {
                putExtra(SEARCH_PARAM,searchText)
            }
            context.startActivity(intent)
        }
    }
}