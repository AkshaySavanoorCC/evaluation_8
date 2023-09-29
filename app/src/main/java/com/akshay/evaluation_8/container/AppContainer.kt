package com.akshay.evaluation_8.container

import com.akshay.evaluation_8.factory.ProjectViewModelFactory
import com.akshay.evaluation_8.repository.ProjectRepository
import com.akshay.evaluation_8.ui.viewModel.ProjectViewModel

interface AppContainer {
    val projectRepository: ProjectRepository
    val projectViewModelFactory: ProjectViewModelFactory
    fun provideProjectViewModel(): ProjectViewModel
}
