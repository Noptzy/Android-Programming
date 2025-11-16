package com.learn.abcd.services

import com.learn.abcd.model.Quote
import retrofit2.http.GET

interface ApiService {
    @GET("quotes/random")
    suspend fun getRandomQuote(): Quote
}