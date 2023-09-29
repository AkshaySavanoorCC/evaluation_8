package com.akshay.evaluation_8.model

sealed class DataItems {
    data class Header(val headerData: Int):DataItems()
    data class Item(val apiData: ProjectModel) : DataItems()

}