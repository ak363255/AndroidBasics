package com.example.androidinterview.workmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.WorkManager

class WorkerViewModelFactory(private val workManager: WorkManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WorkerViewModel(workManager) as T
    }
}