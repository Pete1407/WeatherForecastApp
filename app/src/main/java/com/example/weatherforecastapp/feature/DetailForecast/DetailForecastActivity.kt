package com.example.weatherforecastapp.feature.DetailForecast

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rickmorty.app.base.BaseActivity
import com.example.rickmorty.app.base.CustomState
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.app.data.model.CityModel
import com.example.weatherforecastapp.app.data.model.WeatherModel
import com.example.weatherforecastapp.app.data.utils.Resource
import com.example.weatherforecastapp.databinding.ActivityDetailForecastBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class DetailForecastActivity : BaseActivity(),CustomState {

    private var cityName : String = ""

    @Inject
    lateinit var viewModelFactory: DetailForecastViewModelFactory
    private lateinit var viewModel : DetailForecastViewModel

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
        viewModel.getPositionOfCity(cityName)
    }

    override fun initUI() {
        binding.cityName.text = cityName
        binding.toolbar.inflateMenu(R.menu.unit_menu)
        binding.toolbar.setNavigationIcon(R.drawable.icon_arrow_left)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun initListener() {
        binding.toolbar.setOnMenuItemClickListener {
            val menuId = it.itemId
            if(menuId == R.id.celsius_unit){
                Toast.makeText(this,"Celsius",Toast.LENGTH_SHORT).show()
                return@setOnMenuItemClickListener true
            }else{
                Toast.makeText(this,"Fahrenheit",Toast.LENGTH_SHORT).show()
                return@setOnMenuItemClickListener it.itemId == R.id.fahrenheit_unit
            }
        }
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(DetailForecastViewModel::class.java)
        viewModel.cityValue.observe(this,cityResult)
        viewModel.weatherValue.observe(this,weatherResult)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    private val cityResult = Observer<Resource<List<CityModel>>>{
        when(it){
            is Resource.Loading -> {}
            is Resource.Success ->{
                Log.d("cityResult", it.data.toString())
                it.data?.get(0)?.let {
                    viewModel.getWeatherToday(it.lat,it.lon)
                }
            }
            else -> {}
        }
    }

    private val weatherResult = Observer<Resource<WeatherModel>> {
        when(it){
            is Resource.Loading -> {}
            is Resource.Success ->{
               Log.d("weather",it.data.toString())
            }
            else -> {}
        }
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