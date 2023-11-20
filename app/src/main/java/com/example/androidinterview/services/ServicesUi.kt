package com.example.androidinterview.services

import android.Manifest
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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androidinterview.notifications.NotificationHelper
import com.example.androidinterview.permissions.PermissionLauncher

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesUi(notificationHelper: NotificationHelper) {
    Column(
        modifier =  Modifier
            .fillMaxSize()
    ) {

        val permissionGranted = remember {
            mutableStateOf(false)
        }
        if(permissionGranted.value){
            val context = LocalContext.current
            val startedServiceUtil by remember {
                mutableStateOf(StartedServiceUtil(context))
            }
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
                        startedServiceUtil.startStartedService()
                    },
                textAlign = TextAlign.Center,
                text = "Start Started Service"
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = Color.Red)
                    .clickable {
                        startedServiceUtil.stopStartedService()

                    },
                textAlign = TextAlign.Center,
                text = "Stop Started Service"
            )
        }else{
                PermissionLauncher(
                    isPermissionGranted = permissionGranted,
                    permissionString = Manifest.permission.POST_NOTIFICATIONS
                )

        }

    }
}