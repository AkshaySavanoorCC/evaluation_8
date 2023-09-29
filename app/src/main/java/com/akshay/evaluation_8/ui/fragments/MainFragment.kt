package com.akshay.evaluation_8.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.evaluation_8.MyApplication
import com.akshay.evaluation_8.databinding.FragmentMainBinding
import com.akshay.evaluation_8.factory.ProjectViewModelFactory
import com.akshay.evaluation_8.model.DataItems
import com.akshay.evaluation_8.repository.ProjectRepository
import com.akshay.evaluation_8.ui.adapters.ProjectAdapter
import com.akshay.evaluation_8.ui.viewModel.ProjectViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var projectViewModel: ProjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContainer = (requireActivity().application as MyApplication).appContainer
        projectViewModel = appContainer.provideProjectViewModel()

        val adapter = ProjectAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        projectViewModel.fetchedDataSet.observe(viewLifecycleOwner) { apiData ->
            val dataset = mutableListOf<DataItems>()
            apiData.map {
                dataset.add(DataItems.Header(it.id))
                dataset.add(DataItems.Item(it))
            }
            adapter.submitList(dataset)
        }
    }
}
