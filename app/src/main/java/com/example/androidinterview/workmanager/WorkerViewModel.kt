package com.example.androidinterview.workmanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import kotlinx.coroutines.launch

class WorkerViewModel(
    private val workManager: WorkManager
) :ViewModel() {
    val BLUR_UNIQUE_ID = "blur_work_id"
    val outPutWorkInfoItem: LiveData<List<WorkInfo>>

    init {
        outPutWorkInfoItem = workManager.getWorkInfosByTagLiveData(BlurWorker.WORK_TAG)
    }

    fun blur() = viewModelScope.launch {
        val workRequest = OneTimeWorkRequestBuilder<BlurWorker>()
            .setInputData(createInputData())
            .addTag(BlurWorker.WORK_TAG)
            .build()
        val saveImageWork = OneTimeWorkRequest.from(SaveWork::class.java)
        workManager.beginWith(workRequest).then(saveImageWork).enqueue()
        //parallel work
        //workManager.beginWith(listOf(workRequest,saveImageWork)).enqueue()

        //to avoid dublicate work start unique work
        // workManager.beginUniqueWork(BLUR_UNIQUE_ID,ExistingWorkPolicy.KEEP,workRequest)
    }

    fun createInputData():Data{
        return workDataOf(BlurWorker.INPUT to "Blur Image work");
    }

}