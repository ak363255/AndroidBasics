package com.example.androidinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.NotificationManagerCompat
import androidx.work.WorkManager
import com.example.androidinterview.notifications.NotificationHelper
import com.example.androidinterview.services.ServicesUi
import com.example.androidinterview.ui.theme.AndroidInterviewTheme
import com.example.androidinterview.workmanager.WorkerViewModel
import com.example.androidinterview.workmanager.WorkerViewModelFactory

class MainActivity : ComponentActivity() {
    val workerViewModel: WorkerViewModel by viewModels {
        WorkerViewModelFactory(WorkManager.getInstance(this))
    }

    val notificatonManager:NotificationManagerCompat by lazy {
        NotificationManagerCompat.from(this)
    }
    val notificationHelper:NotificationHelper by lazy {
        NotificationHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidInterviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ServicesUi(notificationHelper)
                }
            }
        }
        

    }


    companion object{
     //   System.loadLibrary("keys"

    }
}

