package com.example.retroapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private val BASEURL = "https://rickandmortyapi.com/api/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    val  apiClient:ApiClient by lazy {
        retrofit.create(ApiClient::class.java)
    }

}