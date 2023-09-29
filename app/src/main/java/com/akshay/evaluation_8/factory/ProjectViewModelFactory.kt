package com.akshay.evaluation_8.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshay.evaluation_8.repository.ProjectRepository
import com.akshay.evaluation_8.ui.viewModel.ProjectViewModel

class ProjectViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProjectViewModel::class.java)){
            return ProjectViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown View model class")
    }
}
