package com.example.retroapp.network
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("character")
   suspend fun fetchResponse(@Query("page") page: String): CharactersResponse
}