package com.akshay.evaluation_8.network.services

import com.akshay.evaluation_8.model.ProjectModel
import com.akshay.evaluation_8.network.api.ProjectApi
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET(ProjectApi.END_POINT_URL)
    fun getDataFromEndPoint(): Call<List<ProjectModel>>
}