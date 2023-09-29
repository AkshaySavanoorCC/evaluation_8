package com.akshay.evaluation_8.network

import com.akshay.evaluation_8.network.api.ProjectApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ProjectApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> create(service : Class<T>): T{
        return retrofit.create(service)
    }

}