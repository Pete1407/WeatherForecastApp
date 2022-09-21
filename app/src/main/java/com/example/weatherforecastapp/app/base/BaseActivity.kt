package com.example.rickmorty.app.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity(),CustomState{
    private  var viewBinding : View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
        viewBinding = view
    }
}