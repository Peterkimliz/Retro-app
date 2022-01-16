package com.example.retroapp.network

data class CharactersResponse(val results: List<Characters>)
data class Characters(val name: String, val image: String)
