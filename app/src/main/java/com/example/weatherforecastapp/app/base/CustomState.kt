package com.example.rickmorty.app.base

import dagger.hilt.android.AndroidEntryPoint

interface CustomState {

    fun initUI()
    fun initListener()
    fun initViewModel()
    fun showLoading()
    fun hideLoading()
}