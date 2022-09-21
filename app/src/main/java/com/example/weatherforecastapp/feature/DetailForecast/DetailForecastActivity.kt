package com.example.weatherforecastapp.feature.DetailForecast

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.rickmorty.app.base.BaseActivity
import com.example.rickmorty.app.base.CustomState
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.databinding.ActivityDetailForecastBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailForecastActivity : BaseActivity(),CustomState {

    @Inject
    lateinit var viewModelFactory: DetailForecastViewModelFactory
    private lateinit var viewModel : DetailForecastViewModel

    private val binding : ActivityDetailForecastBinding by lazy {
        ActivityDetailForecastBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewModel()
        initListener()
        initUI()
    }

    override fun initUI() {
        binding.toolbar.inflateMenu(R.menu.unit_menu)
        binding.toolbar.setNavigationIcon(R.drawable.icon_arrow_left)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
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

    override fun initListener() {

    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this,viewModelFactory).get(DetailForecastViewModel::class.java)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

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