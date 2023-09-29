package com.akshay.evaluation_8

import android.app.Application
import com.akshay.evaluation_8.container.AppContainer
import com.akshay.evaluation_8.container.DefaultAppContainer

class MyApplication : Application() {
    val appContainer: AppContainer by lazy {
        DefaultAppContainer(this)
    }

}
