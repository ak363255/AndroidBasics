package com.example.androidinterview.workmanager

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class SaveWork(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            val data = inputData.getString(OUTPUT)
            return Result.success(workDataOf(OUTPUT to data))
        } catch (e: Exception) {
            Result.failure()
        }
    }

    fun createOutputData(): Data {
        return workDataOf(OUTPUT to "work done")
    }

    companion object {
        const val OUTPUT = "success";
        const val FAIL = "fail"
        const val INPUT = "input"
        const val WORK_TAG = "work_tag"
    }
}