package com.example.androidinterview.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.androidinterview.MainActivity
import com.example.androidinterview.R

class NotificationHelper (private val context:Context){

    init {
        createNotificationChannel()
    }
    companion object{
        const val CHANNEL_ID_1 = "channel1"
        const val CHANNEL_ID_2 = "channel1"

    }
    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(
                CHANNEL_ID_1,
                "channel1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "this is channel 1"
            val channel2 = NotificationChannel(
                CHANNEL_ID_2,
                "channel2",
                NotificationManager.IMPORTANCE_LOW
            )
            channel2.description = "this is channel 2"

            val manager = context.getSystemService(
                NotificationManager::class.java
            ) as NotificationManager
            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)
        }
    }

    fun getNotificationForChannel1(title:String,desc:String):Notification{
        val notification = NotificationCompat.Builder(
            context,
            CHANNEL_ID_1
        ).setSmallIcon(R.drawable.ic_one)
            .setContentTitle(title)
            .setContentText(desc)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setAutoCancel(false)
            .build()
        return notification
    }

    fun sendNotiOnCh1(title:String,desc:String,notificationManager: NotificationManagerCompat){
        val notification = getNotificationForChannel1(title,desc)
        notificationManager.notify(1,notification)

    }
    fun sendNotiOnCh2(title:String,desc:String,notificationManager: NotificationManagerCompat){
        val intent = Intent(context,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val notification = NotificationCompat.Builder(
            context,
            CHANNEL_ID_2
        ).setSmallIcon(R.drawable.ic_two)
            .setContentTitle(title)
            .setContentText(desc)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.ic_launcher_background,"TOAST",pendingIntent)
            .build()
        notificationManager.notify(2,notification)

    }

}