package com.example.retroapp.repositories

import com.example.retroapp.network.RetrofitClient

class MainActivityRepository(val retrofitClient:RetrofitClient) {

 suspend  fun getCharacter(page:String)=retrofitClient.apiClient.fetchResponse(page)

}