package com.akshay.evaluation_8.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akshay.evaluation_8.databinding.CardItemBinding
import com.akshay.evaluation_8.databinding.HeaderLayoutBinding
import com.akshay.evaluation_8.model.DataItems

const val VIEW_TYPE_ONE = 1
const val VIEW_TYPE_TWO = 2

class ProjectAdapter : ListAdapter<DataItems, RecyclerView.ViewHolder>(DiffCallback) {

    class DataViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(apiData: DataItems.Item) {
            binding.apply {
                nameTextView.text = apiData.apiData.name
                fullNameTextView.text = apiData.apiData.full_name
            }
        }
    }

    class HeaderViewHolder(private val binding: HeaderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(apiHeaderData: DataItems.Header) {
            binding.apply {
                headerTextView.text = apiHeaderData.headerData.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ONE -> {
                val binding: CardItemBinding =
                    CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DataViewHolder(binding)
            }

            VIEW_TYPE_TWO -> {
                val binding: HeaderLayoutBinding =
                    HeaderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                HeaderViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentData = getItem(position)
        when (holder) {
            is DataViewHolder -> {
                holder.bind(currentData as DataItems.Item)
            }
            is HeaderViewHolder -> {
                holder.bind(currentData as DataItems.Header)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItems.Item -> VIEW_TYPE_ONE
            is DataItems.Header -> VIEW_TYPE_TWO
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<DataItems>() {
            override fun areItemsTheSame(oldItem: DataItems, newItem: DataItems): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItems, newItem: DataItems): Boolean {
                return oldItem == newItem
            }
        }
    }
}
