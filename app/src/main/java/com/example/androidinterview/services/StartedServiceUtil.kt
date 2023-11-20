package com.example.androidinterview.services

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.androidinterview.services.StartedServiceDemo.Companion.ACTION_START
import com.example.androidinterview.services.StartedServiceDemo.Companion.ACTION_STOP

class StartedServiceUtil(private val context:Context) {
    fun startStartedService(){
        val serviceIntent = Intent(context,StartedServiceDemo::class.java)
        serviceIntent.action = ACTION_START
        context.startService(serviceIntent)
    }
    fun stopStartedService(){
        val serviceIntent = Intent(context,StartedServiceDemo::class.java)
        serviceIntent.action = ACTION_STOP
        context.startForegroundService(serviceIntent)
    }
}