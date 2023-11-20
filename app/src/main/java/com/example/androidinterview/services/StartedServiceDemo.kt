package com.example.androidinterview.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.androidinterview.notifications.NotificationHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartedServiceDemo : Service() {

    private val TAG = StartedServiceDemo::class.java.simpleName
    private val FOREGOUND_SERVICE_ID = 1
    private var notificationHelper:NotificationHelper? = null
    private var started = false
    companion object{
        val ACTION_START = "start"
        val ACTION_STOP = "stop"
    }



    override fun onCreate() {
        super.onCreate()
        notificationHelper = NotificationHelper(this)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d(TAG,"Thread Name - ${Thread.currentThread().name}")
        val action = intent?.action
        when(action){
            ACTION_START ->{
                //Do background Task
                if(!started){
                    started = true
                    startForeground(FOREGOUND_SERVICE_ID,notificationHelper?.getNotificationForChannel1("Started Service","Service is Running"))
                    CoroutineScope(Dispatchers.Default).launch {
                        doBackgroundTask()
                    }
                }
            }
            ACTION_STOP ->{
                //if(started){
                startForeground(FOREGOUND_SERVICE_ID,notificationHelper?.getNotificationForChannel1("Started Service","Service is Running"))
                stopForeground(STOP_FOREGROUND_REMOVE)
                stopSelf()
               // }
            }
        }

        return START_NOT_STICKY
    }

    private suspend fun doBackgroundTask() {
        var i = 0
        while(true){
            Log.d(TAG,"Working ${i}")
            i++
            delay(1000)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null;
    }

    /*

    output :-->

     */
}