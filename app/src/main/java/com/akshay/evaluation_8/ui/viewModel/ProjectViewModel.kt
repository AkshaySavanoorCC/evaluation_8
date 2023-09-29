package com.akshay.evaluation_8.ui.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.akshay.evaluation_8.model.ProjectModel
import com.akshay.evaluation_8.repository.ProjectRepository

class ProjectViewModel(application: Application) : ViewModel() {
    private val repository: ProjectRepository = ProjectRepository(application)

    val fetchedDataSet: LiveData<List<ProjectModel>> = repository.fetchedData

    init {
        repository.fetchDataFromApi()
    }
}
