package com.akshay.evaluation_8.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akshay.evaluation_8.model.ProjectModel
import com.akshay.evaluation_8.network.RetrofitClient
import com.akshay.evaluation_8.network.services.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectRepository(application: Application) {

    private val apiService = RetrofitClient.create(ApiServices::class.java)
    private val _fetchedData = MutableLiveData<List<ProjectModel>>()
    val fetchedData: LiveData<List<ProjectModel>> = _fetchedData

    fun fetchDataFromApi(){
        apiService.getDataFromEndPoint().enqueue( object : Callback<List<ProjectModel>> {
            override fun onResponse(
                call: Call<List<ProjectModel>>,
                response: Response<List<ProjectModel>>
            ) {
                if (response.isSuccessful) {
                    _fetchedData.value = response.body()
                } else {
                    Log.i("ProjectRepository","API request failed with response code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<ProjectModel>>, t: Throwable) {
                Log.i("ProjectRepository","Network error: ${t.message}")
            }
        })
    }
}