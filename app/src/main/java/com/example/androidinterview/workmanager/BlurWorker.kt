package com.example.androidinterview.workmanager

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class BlurWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            val output = (0..1).random()
            if (output == 1) {
                Result.success(createOutputData(inputData))
            } else {
                Result.failure()
            }
        } catch (e: Exception) {
            Result.failure()
        }
    }

    fun createOutputData(inputData: Data): Data {
        return workDataOf(OUTPUT to inputData.getString(INPUT))
    }

    companion object {
        const val OUTPUT = "success";
        const val FAIL = "fail"
        const val INPUT = "input"
        const val WORK_TAG = "work_tag"
    }
}