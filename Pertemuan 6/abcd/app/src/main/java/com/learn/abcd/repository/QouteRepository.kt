package com.learn.abcd.repository

import com.learn.abcd.model.Quote
import com.learn.abcd.services.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.github.cdimascio.dotenv.dotenv

class QouteRepository {

    val dotenv = dotenv{
        directory = "/assets"
        filename = "env"
    }

    val qouteApiUrl: String = dotenv["DUMMY_JSON_URL"]

    private val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(qouteApiUrl)
            .addConverterFactory(
            GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    suspend fun getRandomQuote(): Quote {
        return api.getRandomQuote()
    }
}