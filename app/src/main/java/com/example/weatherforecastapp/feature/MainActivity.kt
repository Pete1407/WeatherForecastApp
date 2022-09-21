package com.example.weatherforecastapp.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.rickmorty.app.base.BaseActivity
import com.example.rickmorty.app.base.CustomState
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.databinding.ActivityMainBinding
import com.example.weatherforecastapp.feature.DetailForecast.DetailForecastActivity
import com.example.weatherforecastapp.feature.DetailForecast.DetailForecastViewModel
import com.example.weatherforecastapp.feature.DetailForecast.DetailForecastViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class MainActivity : BaseActivity(),CustomState {

    private var searchText : String = ""
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewModel()
        initListener()
        initUI()
    }

    override fun initUI() {

    }

    override fun initListener() {

        binding.editText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                searchText = s.toString()
                Log.d("text","$searchText")
            }
        })
        binding.confirmButton.setOnClickListener {
            DetailForecastActivity.start(this,"Nakhon Pathom")
        }
    }

    override fun initViewModel() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

}