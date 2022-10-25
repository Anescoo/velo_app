package com.example.bikesinnantes.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    private val BaseURL = "https://bikeinnantes.herokuapp.com/"

    fun getInstance():Retrofit {
        return Retrofit.Builder().baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}