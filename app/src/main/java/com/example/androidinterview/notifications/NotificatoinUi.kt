package com.example.androidinterview.notifications

import android.app.NotificationManager
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationManagerCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificatonTest(
    notifManager:NotificationManagerCompat,
    notificationHelper: NotificationHelper
){
    Column(
        modifier =  Modifier
            .fillMaxSize()
    ) {
        var title = remember {
            mutableStateOf("")
        }
        var description = remember {
            mutableStateOf("")
        }
        Spacer(modifier = Modifier.height(18.dp))
        TextField(
            value = title.value, onValueChange ={
            title.value = it

        } ,)
        Spacer(modifier = Modifier.height(12.dp))
        TextField(value = description.value, onValueChange ={
            description.value = it

        } )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color.Red)
                .clickable {
                    notificationHelper.sendNotiOnCh1(title.value,description.value,notifManager)
                },
            textAlign = TextAlign.Center,
            text = "Push Notification to Channel 1"
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color.Red)
                .clickable {
                   notificationHelper.sendNotiOnCh2(title.value,description.value,notifManager)
                },
            textAlign = TextAlign.Center,
            text = "Push Notification to Channel 2"
        )

    }
}