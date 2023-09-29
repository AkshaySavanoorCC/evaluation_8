package com.akshay.evaluation_8.container

import android.app.Application
import com.akshay.evaluation_8.factory.ProjectViewModelFactory
import com.akshay.evaluation_8.repository.ProjectRepository
import com.akshay.evaluation_8.ui.viewModel.ProjectViewModel

class DefaultAppContainer(private val application: Application) : AppContainer {
    override val projectRepository: ProjectRepository = ProjectRepository(application)
    override val projectViewModelFactory: ProjectViewModelFactory =
        ProjectViewModelFactory(application)

    override fun provideProjectViewModel(): ProjectViewModel {
        return ProjectViewModel(application)
    }
}


